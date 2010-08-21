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
 * @author dlwhitehurst
 * 
 */
public class CipherLetter extends BlackboardObject {

    /**
     * TODO - comment
     */
    protected String letter;

    /**
     * TODO - comment
     */
    protected Affirmation affirmations = new Affirmation();

    /**
     * Default constructor
     */
    public CipherLetter() {
    }

    /**
     * Loaded constructor
     * 
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
     * @param letter
     *            the letter to set
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
     * @param affirmations
     *            the affirmations to set
     */
    public void setAffirmations(Affirmation affirmations) {
        this.affirmations = affirmations;
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

    public void notifyParticipants() {
        // TODO Auto-generated method stub

    }

}
