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

/**
 * @author dlwhitehurst
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
     * @return
     */
    public String value() {
        return sentence;
    }

    /**
     * Public method to determine if the sentence has been solved
     * 
     * @return
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
     * @param sentence
     *            the sentence to set
     */
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dlw.ai.blackboard.domain.Universe#getDef()
     */
    @Override
    public String getDef() {
        return this.def;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dlw.ai.blackboard.domain.Universe#setDef(java.lang.String)
     */
    @Override
    public void setDef(String def) {
        this.def = def;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dlw.ai.blackboard.domain.Dependent#notifyParticipants()
     */
    public void notifyParticipants() {
        // TODO Auto-generated method stub

    }

}
