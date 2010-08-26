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
package org.dlw.ai.blackboard.rule;

import java.util.ArrayList;

/**
 * <p>
 * This class defines a rule for the blackboard framework. Rules are kept in a
 * collection within the knowledge source for the default implementation and
 * apply specifically to statements given by the subject
 * {@link org.dlw.ai.blackboard.knowledge.KnowledgeSource}.
 * </p>
 * 
 * <blockquote><i>Rule - "(def.) a law or principle that operates within a
 * particular sphere of knowledge, describing or prescribing what is possible or
 * allowable : the rules of grammar."</i></blockquote>
 * 
 * @author dlwhitehurst
 * @version 1.0.0-RC
 * 
 */
public class Rule {

    /**
     * String that exists before or wildcard pattern
     */
    protected String antecedent;

    /**
     * Actual pattern choices in a collection
     */
    protected ArrayList<String> consequents;

    /**
     * Default constructor
     */
    public Rule() {
    }

    /**
     * Loaded constructor
     * 
     * @param antecedent
     *            the String antecedent defining this rule.
     * @param consequents
     *            the ArrayList of consequents following this rule and
     *            antecedent
     */
    public Rule(final String antecedent, final ArrayList<String> consequents) {

        /**
         * set antecedent
         */

        this.antecedent = antecedent;

        /**
         * set final ArrayList of consequents
         */

        this.consequents = consequents;
    }

    /**
     * 
     * 
     * @param antecedent
     *            the String antecedent to remove
     * @return boolean primitive
     */
    public boolean removeAntecedent(final String antecedent) {
        return false;
    }

    /**
     * 
     * 
     * @param consequent
     *            the String consequent to remove
     * @return boolean primitive
     */
    public boolean removeConsequent(final String consequent) {
        return false;
    }

    /**
     * Accept antecedent and consequent pair, only single antecedent exists
     * 
     * @param antecedent
     *            the String antecedent to bind
     * @param consequent
     *            the String consequent to bing
     * @return boolean primitive
     */
    public boolean bind(final String antecedent, final String consequent) {

        boolean result = false;

        if (antecedent == null) {
            this.antecedent = new String(antecedent);

            if (consequents == null) {
                consequents = new ArrayList<String>();
                consequents.add(consequent);
            } else {
                consequents.add(consequent);
            }

            result = true;
        }

        if (antecedent != null && antecedent.equals(this.antecedent)) {
            if (consequents == null) {
                consequents = new ArrayList<String>();
                consequents.add(consequent);
            } else {
                consequents.add(consequent);
            }

            result = true;
        }

        if (antecedent != null && !antecedent.equals(this.antecedent)) {
            result = false;
        }

        return result;
    }

    /**
     * Antecedent exists, possible consequent matching
     * 
     * @param antecedent
     *            the String antecedent matching
     * @return boolean primitive
     */
    public boolean isPossible(final String antecedent) {
        return false;
    }

    /**
     * @return String
     */
    public String getAntecedent() {
        return antecedent;
    }

    /**
     * @param antecedent
     *            the String to set
     */
    public void setAntecedent(String antecedent) {
        this.antecedent = antecedent;
    }

    /**
     * @return ArrayList
     */
    public ArrayList<String> getConsequents() {
        return consequents;
    }

    /**
     * @param consequents
     *            the ArrayList to set
     */
    public void setConsequents(ArrayList<String> consequents) {
        this.consequents = consequents;
    }

}
