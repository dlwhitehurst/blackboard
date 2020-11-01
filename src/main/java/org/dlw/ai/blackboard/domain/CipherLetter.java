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

/**
 * @author <a href="mailto:dlwhitehurst@me.com">David L. Whitehurst</a>
 *
 */
public class CipherLetter extends BlackboardObject {

	private boolean _solved;

	private String cipherLetter;
	
    /**
     * Affirmation (statements) made against this cipher
     */
    protected Affirmation affirmations = new Affirmation();
	
    public String value() {
        return cipherLetter;
    } 

    /**
     * @return the solved
     */
    public boolean isSolved() {
        return _solved;
    }

    /**
     * @param solved the solved to set
     */
    public void setSolved(boolean solved) {
        this._solved = solved;
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
