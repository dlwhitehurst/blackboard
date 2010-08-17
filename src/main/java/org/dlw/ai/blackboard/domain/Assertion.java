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
package org.dlw.ai.blackboard.domain;

/**
 * <p>The {@link Assertion} class is a special kind of {@link Assumption} that is not
 * retractable. Once the {@link Assertion} has been made, the
 * {@link org.dlw.ai.blackboard.Cryptographer} has accepted the
 * {@link Assumption} to be true and will no longer allow the
 * {@link org.dlw.ai.blackboard.knowledge.KnowledgeSource} to interject its
 * thoughts or facts surrounding the assertion's domain.</p>
 * 
 * <blockquote><i>Assertion -
 * "(def.) a confident or forceful statement of fact or belief ... Oxford 
 * American Dictionary"</i></blockquote>
 * 
 * @author dlwhitehurst
 * 
 */
public class Assertion extends Assumption {

	/**
	 * Domain object definition, <i>never</i> set as constant. This object attribute
	 * is very important to our understanding, knowledge, intelligence, etc. because it
	 * answers the question "what is it?". And, how do our senses perceive this 
	 * impression (image, sound, thought, experience, smell, touch, etc.)? Therefore,
	 * this impression(s) is different for each individual.  Webster, Oxford, and or any
	 * other dictionary provides a definition for us that provides a baseline 
	 * impression for our <i>knowledge</i>if we seek this impression and <i>definition</i>
	 * for our own understanding.
	 */
	protected String def;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dlw.ai.cryptogram.domain.Assumption#isRetractable()
	 */
	/**
	 * return false (always)
	 */
	@Override
	public boolean isRetractable() {
		return false;
	}

	/**
	 * @return the def
	 */
	public String getDef() {
		return def;
	}

	/**
	 * @param def the def to set
	 */
	public void setDef(String def) {
		this.def = def;
	}

}
