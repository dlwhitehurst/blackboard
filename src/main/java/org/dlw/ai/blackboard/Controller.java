/*
 * Copyright 2020 David L. Whitehurst
 *
 * Licensed under the Apache License, Version 2.0
 * (the "License"); You may not use this file except
 * in compliance with the License. You may obtain a
 * copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the
 * License.
 *
 */

package org.dlw.ai.blackboard;

import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.exception.CollectionLoadingException;
import org.dlw.ai.blackboard.exception.InitializationException;
import org.dlw.ai.blackboard.knowledge.KnowledgeSource;
import org.dlw.ai.blackboard.knowledge.KnowledgeSources;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourcesImpl;
import org.dlw.ai.blackboard.util.SystemConstants;

/**
 * The Controller class is used to orchestrate (state machine controller) the
 * problem solving that occurs at the blackboard. Knowledge sources are called
 * to evaluate the current blackboard state and accept hints and try them in
 * turn until the problem is solved.
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 * 
 */
public class Controller {

    /**
     * Attribute active or current knowledge source
     */
    private KnowledgeSource activeKnowledgeSource;

    /**
     * Attribute collection and entire problem domain of knowledge sources
     */
    private final KnowledgeSourcesImpl knowledgeSources = new KnowledgeSourcesImpl();
    
    /**
     * Attribute class logger
     */
    private static final Log log = LogFactory.getLog(Controller.class);

    /**
     * Attribute enum state of the controller
     */
    private ControllerState state;

    /**
     * Attribute blackboard or problem solving sandbox
     */
    private Blackboard blackboard;

    /**
     * Public constructor
     */
    public Controller() {
        /**
         * State - initializing
         */
        this.state = ControllerState.INITIALIZING;
    }

    /**
     * Public method to signal halt of the controller
     * 
     */
    public final void done() {
        log.info("done->The Controller has determined that our problem is solved! It is done.");
//        System.exit(0); // Temporary for testing
        state = ControllerState.SOLVED;
    }

    /**
     * Public method to determine if the controller is stuck and cannot proceed
     * 
     * @return boolean primitive
     */
    public final boolean unableToProceed() {
        boolean result = false;

        if (state == ControllerState.STUCK) {
            result = true;
        }

        return result;
    }

    /**
     * Public method to determine if the controller is done (solved)
     * 
     * @return boolean primitive
     */
    public boolean isSolved() {

        boolean result = false;

        if (state == ControllerState.SOLVED) {
            result = true;
        }

        return result;
    }

    /**
     * Public method to cycle each KnowledgeSource and evaluate the current
     * blackboard problem string (repeatable method)
     */
    public final void processNextHint() {

        KnowledgeSourcesImpl knowledgeSources = (KnowledgeSourcesImpl) getKnowledgeSources();

        Collections.sort(knowledgeSources);

        /**
         * go thru ks experts and choose the best one to go to the blackboard
         */
        for (KnowledgeSource ks : knowledgeSources) {

            ks.evaluate();
            state = ControllerState.EVALUATING;

            ConcurrentLinkedQueue<Assumption> queue = ks.getPastAssumptions();

            if (queue.size() > 0) {
                activeKnowledgeSource = ks;
                break;
            }

        }

        log.info("processNextHint->The " + activeKnowledgeSource.toString()
                + " is now active.");

        if (activeKnowledgeSource != null) {

            /**
             * Take a turn at the board
             */
            visitBlackboard(activeKnowledgeSource);

            /**
             * Step down and give the next expert a chance
             */
            leaveBlackboard(activeKnowledgeSource);

            /**
             * Null activeKnowledgeSource
             */
            activeKnowledgeSource = null;
        }

    }

    /**
     * Public reset method to flush the expertise/knowledge sources and create a
     * new collection of knowledge sources.
     */
    public final void reset() {

        /**
         * Dismiss any current expert on the floor
         */
        activeKnowledgeSource = null;

        try {
            /**
             * Reset/Initialize/Refresh collection of knowledge sources
             */
            knowledgeSources.reset();
        } catch (InitializationException e) {
            log.error("Could not reset and initialize knowledge sources.");
        } catch (CollectionLoadingException e) {
            log.error("Some failure occurred loading knowledge source collection.");
        }
        
        /**
         * Initial controller state
         */
        state = ControllerState.INITIALIZING;

    }

    /**
     * Private method for KnowledgeSource expert to have a turn at the
     * blackboard problem
     * 
     * @param ks
     *    the KnowledgeSource (or Expert)
     */
    private void visitBlackboard(KnowledgeSource ks) {

        blackboard = BlackboardContext.getInstance().getBlackboard();

        log.info("visitBlackboard-> Controller is now connecting "
                + ks.toString() + " to the blackboard.");

        blackboard.connect(ks);

    }

    /**
     * Private method to leave or disengage from the blackboard.
     * 
     * @param hint
     *            the KnowledgeSource (or Expert)
     */
    private void leaveBlackboard(KnowledgeSource ks) {

        blackboard.disconnect(ks);
        
        log.info("leaveBlackboard-> Controller has disconnected the "
                + ks.toString() + " from the blackboard.");
    }

    /**
     * @return the knowledgeSources
     */
    public KnowledgeSources getKnowledgeSources() {
        return knowledgeSources;
    }

}
