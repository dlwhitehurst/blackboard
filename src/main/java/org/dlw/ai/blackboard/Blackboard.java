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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.domain.BlackboardObject;
import org.dlw.ai.blackboard.domain.CipherLetter;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.domain.Word;
import org.dlw.ai.blackboard.util.StringTrimmer;
import org.dlw.ai.blackboard.util.SystemConstants;

/**
 * This class is where the problem is addressed and solved. The blackboard is
 * the sandbox of the problem domain. This class was derived from the book,
 * Object Oriented Analysis and Design by Grady Booch, however the blackboard
 * model itself was first introduced by ... (add background)
 *
 * @author dlwhitehurst
 *
 */
@SuppressWarnings("serial")
public class Blackboard extends ArrayList < BlackboardObject > {

	/**
	 * Commons logging class instance
	 */
	private final Log log = LogFactory.getLog(Blackboard.class);

	/**
	 * Default constructor
	 */
	public Blackboard() {
	}

	/**
	 * Return decoded sentence
	 * 
	 * @return
	 */
	public final Sentence retrieveSolution() {

		if (!isSolved()) {
			return new Sentence(SystemConstants.EARLY_RETRIEVAL_ERROR);
		}

		// TODO - this is probably incorrect, should only return Sentence if
		// isSolved()
		Sentence sentence = null;

		for (BlackboardObject obj : this) {
			if (obj.getClass().equals(
					org.dlw.ai.blackboard.domain.Sentence.class)) {
				sentence = (Sentence) obj;
			}
		}
		return sentence;
	}

	/**
	 * Reset the blackboard
	 */
	public final void reset() {

		/**
		 * Clear the blackboard array
		 */
		this.clear();

		/**
		 * Notify
		 */
		log.info("Blackboard has been cleaned and ready for problem solving.");
		// TODO - wrap
	}

	/**
	 * Public method used to determine if the blackboard problem is solved
	 * 
	 * @return
	 */
	public final boolean isSolved() {

		boolean result = false;

		Sentence sentence = null;

		/**
		 * Search the ArrayList for a sentence
		 */
		for (BlackboardObject obj : this) {
			if (obj.getClass().equals(
					org.dlw.ai.blackboard.domain.Sentence.class)) {
				sentence = (Sentence) obj;
			}
		}

		/**
		 * If we have a sentence and the sentence is solved, then the blackboard
		 * problem is solved.
		 */
		if (sentence != null) {
			result = sentence.isSolved();
		}

		/**
		 * need method to show blackboard solution anytime this method is
		 * called. Also, the entire sentence should be underline with
		 * affirmations.
		 */

		outputProgress();

		return result;

	}

	/**
	 * Private method to output the sentence and underline any corrected cipher
	 * letters. Also any letters that are underlined are plaintext letters
	 * (Alphabets) and also Affirmations exist in blackboard problem domain.
	 */
	private void outputProgress() {
		
		Sentence sentence = null;

		/**
		 * Get the sentence object
		 */
		for (BlackboardObject obj : this) {
			if (obj.getClass().equals(
					org.dlw.ai.blackboard.domain.Sentence.class)) {
				sentence = (Sentence) obj;
			}
		}
		// TODO - wrap
		log.info("PROGRESS: " + sentence.value());
		
		String markers = getAffirmations(sentence);
		
		/**
		 * Use this to show that no markers exist
		 */
		if (markers.equals("")) {
			markers = "___________________________";
		}
		
		if (log.isInfoEnabled()) {
			log.info("########: " + markers);
		} else {
			System.err.println(SystemConstants.INFO_LEVEL_FATAL);
			System.exit(0); // die
		}
	}

	/**
	 * Public boolean method to assert our problem with the blackboard
	 * 
	 * @param code
	 * @return
	 */
	public final boolean assertProblem(String code) {
		// TODO - Test for code being null as a method argument here
		boolean result = true;

		code = StringTrimmer.trim(code);

		if (code.equals("")) {
			result = false;
		}

		Sentence sentence = new Sentence(code);
		List<Word> words = getWords(sentence);
		sentence.setWords(words);
		this.add(sentence);

		return result;
	}

	/**
	 * Private method to return a List of Word objects based on the Sentence
	 * object provided
	 * 
	 * @param sentence
	 * @return
	 */
	private List<Word> getWords(Sentence sentence) {

		StringTokenizer toker = new StringTokenizer(sentence.value());
		List<Word> listOfWords = sentence.getWords();

		while (toker.hasMoreTokens()) {

			String tmpWord = toker.nextToken();
			// TODO - wrap
			if (log.isInfoEnabled()) {
				log.info("Word: " + tmpWord);
			}

			Word word = new Word(tmpWord);
			List<CipherLetter> letters = getLetters(word);
			word.setLetters(letters);
			listOfWords.add(word);

			this.add(word);

		}

		return listOfWords;
	}

	/**
	 * Private method to return a List of CipherLetter objects based on Word
	 * provided
	 * 
	 * @param word
	 * @return
	 */
	private List<CipherLetter> getLetters(Word word) {

		List<CipherLetter> listOfLetters = word.getLetters();

		// char[] chars = word.value().toCharArray();
		int i = 0;

		for (i = 0; i < word.value().length(); i++) {
			CipherLetter letter = new CipherLetter(word.value().substring(i,
					i + 1));
			listOfLetters.add(letter);
			this.add(letter);
		}

		return listOfLetters;
	}
	
	private String getAffirmations(Sentence sentence) {

		String markerLine = new String("");
		int wordcount = 0;
		int loopcount = 0;
		
		List<Word> words = sentence.getWords();
		wordcount = words.size();
		
		for (Word word: words) {
			loopcount++;
			List<CipherLetter> list = word.getLetters();

			for (CipherLetter letter : list) {
				Stack<Assumption> stack = letter.getAffirmations().getStatements();
				for (int i = 0; i < stack.size(); i++) {
					Assumption assumption = stack.pop();
					if (!assumption.isRetractable()) {
						// affirmation and we have an assertion
						markerLine.concat("#");
					} else {
						markerLine.concat(" ");
					}
				}
			}
			if (loopcount < wordcount) {
				markerLine.concat(" ");
			}
		}
		return markerLine;
	}
}
