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

import org.dlw.ai.blackboard.Blackboard;
import org.dlw.ai.blackboard.util.UniversalContext;

/**
 * @author dlwhitehurst
 *
 */
public class CipherLetter extends BlackboardObject {

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
	
	protected String letter;
	protected Affirmation affirmations = new Affirmation();
	
	/**
	 * Default constructor
	 */
	public CipherLetter() {}

	/**
	 * Loaded constructor
	 * @param letter
	 */
	public CipherLetter(String letter) {
		this.letter = letter;
	}
	
	/**
	 * @return the letter
	 */
	public String getLetter() {
		return letter;
	}
	/**
	 * @param letter the letter to set
	 */
	public void setLetter(String letter) {
		this.letter = letter;
	}

	/**
	 * @return the affirmations
	 */
	public Affirmation getAffirmations() {
		return affirmations;
	}

	/**
	 * @param affirmations the affirmations to set
	 */
	public void setAffirmations(Affirmation affirmations) {
		this.affirmations = affirmations;
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

	public void notifyParticipants() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void register() {
		Blackboard blackboard = (Blackboard) UniversalContext
				.getApplicationContext().getBean("blackboard");
		blackboard.add(this);
	}

	@Override
	public void resign() {
		Blackboard blackboard = (Blackboard) UniversalContext
		.getApplicationContext().getBean("blackboard");
		blackboard.remove(this);
	}


}
