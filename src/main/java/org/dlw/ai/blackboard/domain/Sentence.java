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
package org.dlw.ai.blackboard.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is used to define a sentence object. This sentence can be cipher
 * (code) or understandable. The object represents the data structure for a
 * sentence object simply. This class can be extended and may be used outside of
 * the default blackboard implementation in other design scenarios.
 * </p>
 * 
 * <blockquote><i>Sentence - "(def.) a set of words that is complete in itself,
 * typically containing a subject and predicate, conveying a statement,
 * question, exclamation, or command, and consisting of a main clause and
 * sometimes one or more subordinate clauses."</i></blockquote>
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 * 
 */
public class Sentence extends BlackboardObject {

    /**
     * Collection of words that make up the sentence
     */
    protected List<Word> words = new ArrayList<Word>(); // collection of words

    /**
     * Attribute sentence
     */
    protected String sentence;

    /**
     * Default constructor
     */
    public Sentence() {
    }

    /**
     * Loaded constructor
     * 
     * @param sentence
     *            the sentence string
     */
    public Sentence(final String sentence) {
        this.sentence = sentence;
    }

    /**
     * Return the current value of of the sentence
     * 
     * @return the string value for the sentence
     */
    public String value() {
        return sentence;
    }

    /**
     * Public method to determine if the sentence has been solved
     * 
     * @return boolean true if solved
     */
    public boolean isSolved() {

        boolean result = false;
        int countTrue = 0;

        // if each word has been solved, naturally the sentence has been solved
        List<Word> list = this.getWords();
        int count = list.size();

        for (Word word : list) {
            if (word.isSolved()) {
                countTrue++;
            }
        }

        if (count == countTrue) {
            result = true;
        }

        return result;
    }

    /**
     * @param words
     *            the words to set
     */
    public void setWords(List<Word> words) {
        this.words = words;
    }

    /**
     * @return the words
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     * @return the sentence
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * @param sentence the sentence to set
     */
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

}
