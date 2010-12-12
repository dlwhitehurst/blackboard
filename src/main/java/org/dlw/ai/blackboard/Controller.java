/**
 * Copyright 2010 David L. Whitehurst
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
import org.dlw.ai.blackboard.knowledge.KnowledgeSource;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourcesImpl;
import org.dlw.ai.blackboard.util.SystemConstants;
import org.dlw.ai.blackboard.util.UniversalContext;

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
     * Attribute class logger
     */
    private static final Log log = LogFactory.getLog(Controller.class);

    /**
     * Attribute enum state of the controller
     */
    private ControllerState state;

    /**
     * Attribute brain or source of intelligence
     */
    private Brain brain;

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

        System.exit(0); // Temporary for testing

        state = ControllerState.SOLVED;
    }

    /**
     * Public method to determine if the controller is really finished
     * 
     * @return boolean primitive
     */
    public final boolean isSolved() {

        boolean result = false;

        if (state == ControllerState.SOLVED) {
            result = true;
        }

        return result;
    }

    /**
     * Public method to determine if the controller is stuck and cannot proceed
     * 
     * @return boolean primitive
     */
    public final boolean unableToProceed() {
        // TODO - implement
        return false;
    }

    /**
     * Public method to cycle each KnowledgeSource and evaluate the current
     * blackboard problem string (repeatable method)
     */
    public final void processNextHint() {

        KnowledgeSourcesImpl knowledgeSources = (KnowledgeSourcesImpl) brain
                .getKnowledgeSources();

        Collections.sort(knowledgeSources);

        /**
         * go thru ks experts and choose the best one to go to the blackboard
         */
        for (KnowledgeSource ks : knowledgeSources) {

            ks.evaluate();

            ConcurrentLinkedQueue<Assumption> queue = ks.getPastAssumptions();

            if (queue.size() > 0) {
                activeKnowledgeSource = ks;
                break;
            }

        }

        log.info("processNextHint->The "
                + activeKnowledgeSource.toString() + " is now active.");

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
     * Public reset method to null the brain and knowledge sources and create a
     * new brain. Knowledge sources are not created until the engage() method on
     * brain is called.
     */
    public final void reset() {

        activeKnowledgeSource = null;

        /**
         * kill any existing Brain
         */
        brain = null;

        /**
         * Get an instance of Brain
         */
        brain = (Brain) UniversalContext.getApplicationContext().getBean(
                "brain");

        /**
         * Reset state
         */
        state = ControllerState.INITIALIZING;
    }

    /**
     * Private method for KnowledgeSource expert to have a turn at the
     * blackboard problem
     * 
     * @param hint
     *            the KnowledgeSource (or Expert) to provide input for solution
     */
    private void visitBlackboard(KnowledgeSource hint) {

        blackboard = (Blackboard) UniversalContext.getApplicationContext()
                .getBean("blackboard");

        log.info("visitBlackboard-> Controller is now connecting "
                + hint.toString() + " to the blackboard.");

        blackboard.connect(hint);

    }

    /**
     * Private method to leave or disengage from the blackboard.
     * 
     * @param hint
     *            the KnowledgeSource (or Expert)
     */
    private void leaveBlackboard(KnowledgeSource hint) {

        blackboard.disconnect(hint);
        log.info("leaveBlackboard-> Controller has disconnected the "
                + hint.toString() + " from the blackboard.");
    }

    /**
     * Connect and manage the Brain
     */
    public final void connect() {

        brain.engage();
        if (log.isInfoEnabled()) {
            log.info("Controller::connect-> Controller and Brain are now connected.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_FATAL);
            System.exit(0); // die
        }
    }

}
