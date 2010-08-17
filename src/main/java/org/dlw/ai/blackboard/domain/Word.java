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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author dlwhitehurst
 * 
 */
public class Word extends BlackboardObject {

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
	
	/**
	 * List of cipher letters that make up this ciphered word
	 */
	private List<CipherLetter> letters = new ArrayList<CipherLetter>();

	/**
	 * The string word
	 */
	private String word;

	/**
	 * Default constructor
	 */
	@SuppressWarnings("unused")
	private Word() {
	}

	/**
	 * Loaded constructor
	 * 
	 * @param word
	 */
	public Word(String word) {
		this.word = word;
	}

	/**
	 * Public method to return the value or the string word
	 * 
	 * @return
	 */
	public String value() {
		return word;
	}

	/**
	 * Public method to determine if the word has been solved
	 * 
	 * @return
	 */
	public boolean isSolved() {

		/**
		 * Always use a local result
		 */
		boolean result = false;

		/**
		 * No. of true occurrences
		 */
		int countTrue = 0;

		/**
		 * Iterate over all letters, be sure there is an assertion for each
		 */
		List<CipherLetter> list = this.getLetters();
		int count = list.size();

		for (CipherLetter letter : list) {
			Stack<Assumption> stack = letter.getAffirmations().getStatements();
			for (int i = 0; i < stack.size(); i++) {
				Assumption assumption = stack.pop();
				if (!assumption.isRetractable()) {
					countTrue++;
				}
			}
		}

		/**
		 * If the no. of true occurrences equals the no. of letters it's solved
		 */
		if (count == countTrue) {
			result = true;
		}

		return result;
	}

	/**
	 * Public setter for list of cipher letters
	 * 
	 * @param letters
	 */
	public void setLetters(List<CipherLetter> letters) {
		this.letters = letters;
	}

	/**
	 * Public getter for list of cipher letters
	 * 
	 * @return
	 */
	public List<CipherLetter> getLetters() {
		return letters;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
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

}
