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

import java.util.Stack;

/**
 * <p>
 * This class represents the knowledge that the {@link CipherLetter} has
 * <i>plaintext</i> meaning. The instance of this class has no default
 * constructor and can only be created if the strings for the <i>cipher</i>
 * letter and the <i>plaintext</i> letters are understood or assumed.
 * </p>
 * 
 * <p>
 * The {@link Alphabet} tells us that we have knowledge of its meaning in two
 * languages, the problem language (cipher) and the general dialect (english) in
 * our case.
 * </p>
 * 
 * <blockquote><i>Alphabet - "(def.) a set of letters or symbols in a fixed
 * order, used to represent the basic sounds of a language; in particular, the
 * set of letters from A to Z"</i></blockquote>
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 * 
 */
public class Alphabet extends BlackboardObject {

    /**
     * Affirmation (statements) made against this alphabet
     */
    protected Affirmation affirmations = new Affirmation();
	
	/**
     * Attribute cipher letter knowledge
     */
    private String cipherLetter;

    /**
     * Attribute plaintext letter knowledge
     */
    private String plainLetter;
    
    private boolean vowel = false;
    
    private boolean consonant = false;
    

    /**
     * No default constructor allowed
     */
    @SuppressWarnings("unused")
    private Alphabet() {
    }

    /**
     * Constructor
     * 
     * @param cipherLetter
     */
    public Alphabet(final String cipherLetter) {
        this.cipherLetter = cipherLetter;
    }

    public boolean isAsserted() {
        boolean result = false;
        Stack<Assumption> stack = getAffirmations().getStatements();
        for (int i = 0; i < stack.size(); i++) {
            Assumption assumption = stack.pop();
            if (!assumption.isRetractable()) {
                result = true;
                
            }
        }
        return result;
    }

	/**
	 * @return the vowel
	 */
	public boolean isVowel() {
		return vowel;
	}

	/**
	 * @param vowel the vowel to set
	 */
	public void setVowel(boolean vowel) {
		this.vowel = vowel;
	}

	/**
	 * @return the consonant
	 */
	public boolean isConsonant() {
		return consonant;
	}

	/**
	 * @param consonant the consonant to set
	 */
	public void setConsonant(boolean consonant) {
		this.consonant = consonant;
	}
    /**
     * @return the cipherLetter
     */
    public String getCipherLetter() {
        return cipherLetter;
    }

    /**
     * @param cipherLetter
     *            the cipherLetter to set
     */
    public void setCipherLetter(String cipherLetter) {
        this.cipherLetter = cipherLetter;
    }

    /**
     * @return the plainLetter
     */
    public String getPlainLetter() {
        return plainLetter;
    }

    /**
     * @param plainLetter
     *            the plainLetter to set
     */
    public void setPlainLetter(String plainLetter) {
        this.plainLetter = plainLetter;
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
    public void setAffirmation(Affirmation affirmation) {
        this.affirmations = affirmation;
    }
	
}
