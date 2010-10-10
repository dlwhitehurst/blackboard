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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.knowledge.AbstractKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourcesImpl;
import org.dlw.ai.blackboard.util.Logger;
import org.dlw.ai.blackboard.util.SystemConstants;
import org.dlw.ai.blackboard.util.UniversalContext;

/**
 * The Controller class is used to orchestrate (state machine controller) the
 * problem solving that occurs at the blackboard. Knowledge sources are called
 * to evaluate the current blackboard state and accept hints and try them in
 * turn until the problem is solved.
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public class Controller {

    /**
     * Attribute active or current knowledge source
     */
    private AbstractKnowledgeSource activeKnowledgeSource;

    /**
     * Attribute class logger
     */
    private static final Log log = LogFactory.getLog(Controller.class);

    private Logger logger;
    
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
        
        logger = Logger.getInstance();
        logger.wrap(log);
        
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

        state = ControllerState.SELECTING;

        KnowledgeSourcesImpl knowledgeSources = (KnowledgeSourcesImpl) brain
        .getKnowledgeSources();
        
        Collections.sort(knowledgeSources);
        
        for (AbstractKnowledgeSource ks : knowledgeSources) {

            activeKnowledgeSource = ks;
            addHint(ks);
        
        }
        
        /**
         * Expert stands down
         */
        removeHint(activeKnowledgeSource);

    }

    /**
     * Public reset method to null the brain and knowledge sources and create a
     * new brain. Knowledge sources are not created until the engage() method on
     * brain is called.
     */
    public final void reset() {

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
     * Private method to add a hint to the blackboard problem
     * 
     * @param hint
     *            the KnowledgeSource (or Expert) to provide hint for solution
     */
    private void addHint(AbstractKnowledgeSource hint) {

        blackboard = (Blackboard) UniversalContext.getApplicationContext()
                .getBean("blackboard");

        blackboard.connect(hint);

        if (log.isInfoEnabled()) {
            log.info("Controller-addHint(): Controller has connected knowledge source to blackboard: "
                            + hint.toString());
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_FATAL);
            System.exit(0); // die
        }

    }

    /**
     * Private method to remove a hint from the blackboard problem
     * 
     * @param hint
     *            the KnowledgeSource (or Expert)
     */
    private void removeHint(AbstractKnowledgeSource hint) {

        blackboard.disconnect(hint);

        if (log.isInfoEnabled()) {
            log
                    .info("Controller-removeHint(): Controller has disconnected knowledge source from blackboard: "
                            + hint.toString());
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_FATAL);
            System.exit(0); // die
        }

    }

    /**
     * Connect and manage the Brain
     */
    public final void connect() {

        brain.engage();

        if (log.isInfoEnabled()) {
            log
                    .info("Controller-connect(): Controller and Brain are now connected.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_FATAL);
            System.exit(0); // die
        }
    }

}
