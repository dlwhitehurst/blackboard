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
import org.dlw.ai.blackboard.type.KnowledgeSources;
import org.dlw.ai.blackboard.util.SystemConstants;

public class Brain {

	/**
	 * Attribute collection and entire problem domain of knowledge sources
	 */
	private KnowledgeSources knowledgeSources;

	/**
	 * Attribute class logger
	 */
	private final Log log = LogFactory.getLog(Brain.class);

	/**
	 * Engage the brain by obtaining a set of knowledge sources (intelligence)
	 * 
	 */
	public void engage() {

		/**
		 * Create collection container
		 */
		knowledgeSources = new KnowledgeSources();
		
		/**
		 * Clear and load domain knowledge
		 */
		knowledgeSources.reset();

		/**
		 * Notify
		 */
		if (log.isInfoEnabled()) {
			log.info("New knowledge sources instanced and reset.");
		} else {
			System.err.println(SystemConstants.INFO_LEVEL_FATAL);
			System.exit(0); // die
		}
		
	}
	
	/**
	 * Reset existing domain knowledge or intelligence
	 */
	public void reset() {
		knowledgeSources.reset();
		log.info("Existing knowledge sources reset.");
	}

	/**
	 * @param knowledgeSources the knowledgeSources to set
	 */
	public void setKnowledgeSources(KnowledgeSources knowledgeSources) {
		this.knowledgeSources = knowledgeSources;
	}

	/**
	 * @return the knowledgeSources
	 */
	public KnowledgeSources getKnowledgeSources() {
		return knowledgeSources;
	}

}
