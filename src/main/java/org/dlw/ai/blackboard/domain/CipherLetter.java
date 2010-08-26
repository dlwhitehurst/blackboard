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
 * <p>This class is used to represent the cryptic letter or alphabet used by
 * the initial cryptogram. These letter objects will ultimately be decoded
 * into understandable {@link Alphabet}. No conversion is kept here, however
 * the {@link Alphabet} class will keep a mapping as the cipher letters are
 * decoded.</p>
 * 
 * <blockquote><i>Cipher - "(def.) a secret or disguised way of writing: a code."</i></blockquote>
 * 
 * @author dlwhitehurst
 * @version 1.0.0-RC
 * 
 */
public class CipherLetter extends BlackboardObject {

    /**
     * Attribute String cipher code or letter
     */
    protected String cipherLetter;

    /**
     * Attribute Affirmation object or data structure Stack of statements
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
     * @param cipherLetter
     *      the String cipherLetter
     */
    public CipherLetter(String cipherLetter) {
        this.cipherLetter = cipherLetter;
    }

    /**
     * @return the String cipherLetter
     */
    public String getCipherLetter() {
        return cipherLetter;
    }

    /**
     * @param cipherLetter
     *            the String cipherLetter
     */
    public void setCipherLetter(String cipherLetter) {
        this.cipherLetter = cipherLetter;
    }

    /**
     * @return the Affirmation object affirmations
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

    @Override
    public void notifyDependents() {
        // TODO Auto-generated method stub
        
    }


}
