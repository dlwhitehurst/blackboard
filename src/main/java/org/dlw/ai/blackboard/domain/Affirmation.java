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

import java.util.Stack;

/**
 *<p>
 * This class is a literal stack of assumptions about a
 * particular blackboard object. Some assumptions are more opportunistic, such
 * as assertions.
 *</p>
 * 
 * <p>
 * The public method {@link Affirmation#cipherText} will return the cipherText
 * letter at any time and can be used to set the "affirmed" character if assumed
 * to have a plain-text solution back to the cipher character if needed. The
 * {@link Affirmation#plainText} method, however will only return the plain-text
 * character if an {@link Letter} object has been created and placed on the
 * {@link org.dlw.ai.blackboard.Blackboard}.
 * </p>
 * 
 * <p>
 * The {@link Affirmation} is a collection of statements {@link Assumption}
 * and/or {@link Assertion} about a particular domain object. A number of
 * assumptions could define an {@link Assertion} but the {@link Affirmation} is
 * the public offering that this {@link CipherLetter} is ready to be
 * considered.
 * </p>
 * 
 * <blockquote><i>Affirmation - "(def.) statement of facts; asserted strongly
 * and publicly (at the blackboard perchance?)</i></blockquote>
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public class Affirmation {

    /**
     * The cipher letter relating to this affirmation
     */
    private CipherLetter cipherLetter;

    /**
     * The plaintext equivalent relating to this affirmation. We think this is
     * the logical letter replacement or solution for the ciphertext letter
     */
    private Letter solvedLetter;

    /**
     * Our stack of assumptions. Remember that assertions extend assumption
     */
    private Stack<Assumption> statements = new Stack<Assumption>();

    /**
     * Default constructor
     */
    public Affirmation() {
    }

    public void push(Assumption assumption) {
        statements.push(assumption);
    }

    /**
     * Retract a statement
     * 
     */
    public Assumption pop() {
        return statements.pop();
    }

    public Assumption statementAt(int i) {
        return statements.get(i);
    }
    /**
     * Public method to get ciphertext (rarely, may not be finished)
     * 
     * @return String
     */
    public String cipherText() {
        return cipherLetter.value();
    }

    /**
     * Public method to get solved letter (for display of our work)
     * 
     * @return String
     */
    public String plainText() {
        return solvedLetter.getPlainLetter();
    }

    /**
     * Public method to determine if plain letter has been asserted
     * 
     * @return boolean
     */
    public boolean isPlainLetterAsserted() {
        boolean result = false;

        Stack<Assumption> stack = this.solvedLetter.getAffirmation()
                .getStatements();
        for (int i = 0; i < stack.size(); i++) {
            Assumption assumption = stack.pop();
            if (!assumption.isRetractable()) {
                result = true;
            }
        }

        return result;
    }

    /**
     * Public method to determine if cipher letter has been asserted
     * 
     * @return boolean
     */
    public boolean isCipherLetterAsserted() {

        boolean result = false;

        Stack<Assumption> stack = this.cipherLetter.getAffirmation()
                .getStatements();
        for (int i = 0; i < stack.size(); i++) {
            Assumption assumption = stack.pop();
            if (!assumption.isRetractable()) {
                result = true;
            }
        }

        return result;
    }

    /**
     * Public method to determine if an assumption is made against the plain
     * letter
     * 
     * @return boolean
     */
    public boolean plainLetterHasAssumption() {
        boolean result = false;

        Stack<Assumption> stack = this.solvedLetter.getAffirmation()
                .getStatements();
        if (stack.size() > 0) {
            result = true;
        }

        return result;
    }

    /**
     * Public method to determine if an assumption is made against the cipher
     * letter
     * 
     * @return boolean
     */
    public boolean cipherLetterHasAssumption() {
        boolean result = false;

        Stack<Assumption> stack = this.cipherLetter.getAffirmation()
                .getStatements();
        if (stack.size() > 0) {
            result = true;
        }

        return result;
    }

    /**
     * @return {@link CipherLetter}
     */
    public CipherLetter getCipherLetter() {
        return cipherLetter;
    }

    /**
     * @param cipherLetter
     *   the {@link CipherLetter} to set
     */
    public void setCipherLetter(CipherLetter cipherLetter) {
        this.cipherLetter = cipherLetter;
    }

    /**
     * @return {@link Letter}
     */
    public Letter getSolvedLetter() {
        return solvedLetter;
    }

    /**
     * @param solvedLetter
     *            the solvedLetter to set
     */
    public void setSolvedLetter(Letter solvedLetter) {
        this.solvedLetter = solvedLetter;
    }

    /**
     * @return Stack<Assumption>
     */
    public Stack<Assumption> getStatements() {
        return statements;
    }

    /**
     * @param statements
     *            the statements to set
     */
    public void setStatements(Stack<Assumption> statements) {
        this.statements = statements;
    }

}
