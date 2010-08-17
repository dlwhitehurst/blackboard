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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.knowledge.KnowledgeSource;
import org.dlw.ai.blackboard.util.SystemConstants;
import org.dlw.ai.blackboard.util.UniversalContext;

/**
 * The Controller class is used to orchestrate the problem solving that occurs
 * at the blackboard. Knowledge sources are called to evaluate the current
 * blackboard state and accept hints and try them in turn until the problem is
 * solved.
 * 
 * @author dlwhitehurst
 * 
 */
public class Controller {

	private boolean done = false;
	
	/**
	 * Attribute active or current knowledge source
	 */
	private KnowledgeSource activeKnowledgeSource;
	
	/**
	 * Attribute class logger
	 */
	private final static Log log = LogFactory.getLog(Controller.class);

	/**
	 * Attribute knowledge source collection index
	 */
	private static int index = 0;

	/**
	 * Attribute brain or source of intelligence
	 */
	private Brain brain;

	/**
	 * Public constructor
	 */
	public Controller() {
	}

	/**
	 * Public method to tell the controller that his work is done
	 * 
	 */
	public void done() {
		done = true;
	}
	
	/**
	 * Public method to determine if the controller is finished
	 * 
	 * @return
	 */
	public boolean isSolved() {

		boolean result = false;
		
		if (this.done) {
			result = true;
		}
		
		return result; 
	}

	public boolean unableToProceed() {
		return false;
	}

	/**
	 * Public method to cycle each KnowledgeSource and evaluate the current
	 * blackboard problem string
	 */
	public void processNextHint() {

		/**
		 * Set the active knowledge source to evaluate
		 */

		setActiveKnowledgeSource(brain.getKnowledgeSources().get(index));

		/**
		 * Evaluate the current knowledge source
		 */
		getActiveKnowledgeSource().evaluate();

		/**
		 * Increment the index used to obtain the knowledge source next time
		 * this method is called
		 */
		incrementIndex();
		
	}

	/**
	 * Public reset method to null the brain and knowledge sources and create a
	 * new brain and ultimately new knowledge sources.
	 */
	public void reset() {

		/**
		 * kill any existing Brain
		 */

		brain = null;

		/**
		 * Get an instance of a fresh Brain
		 */

		brain = (Brain) UniversalContext.getApplicationContext().getBean("brain");

	}

	/**
	 * Public method to add a hint to the blackboard problem
	 * 
	 * @param hint
	 */
	public void addHint(KnowledgeSource hint) {
		// TODO - implement
	}

	/**
	 * Private method to increment the index of the knowledge source collection
	 * and reset to zero at the last index
	 */
	private void incrementIndex() {
		int size = brain.getKnowledgeSources().size();

		if (log.isInfoEnabled()) {
			log.info("No. of KnowledgeSources: " + size);
		} else {
			System.err.println(SystemConstants.INFO_LEVEL_FATAL);
			System.exit(0); // die
		}
		
		if (index == size-1) {
			index = 0;
		} else {
			index++;
		}
	}

	/**
	 * Public method to remove a hint from the blackboard problem
	 * 
	 * @param hint
	 */
	public void removeHint(KnowledgeSource hint) {
		// TODO - implement
	}

	/**
	 * Connect and manage the Brain
	 */
	public void connect() {
		brain.engage();

		if (log.isInfoEnabled()) {
			log.info("Controller and Brain now connected.");
		} else {
			System.err.println(SystemConstants.INFO_LEVEL_FATAL);
			System.exit(0); // die
		}
	}

	/**
	 * @param activeKnowledgeSource
	 *            the activeKnowledgeSource to set
	 */
	public void setActiveKnowledgeSource(KnowledgeSource activeKnowledgeSource) {
		this.activeKnowledgeSource = activeKnowledgeSource;
	}

	/**
	 * @return the activeKnowledgeSource
	 */
	public KnowledgeSource getActiveKnowledgeSource() {
		return activeKnowledgeSource;
	}

}
