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

import org.dlw.ai.blackboard.domain.Antecedent;
import org.dlw.ai.blackboard.domain.Consequent;

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
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public class Rule {

    protected Antecedent antecedent;

    protected Consequent consequent;
    
    protected RuleType ruleType;
    
    protected String before;
    
    protected String after;
    

    /**
     * Default constructor
     */
    public Rule() {
    }

    /**
     * Loaded constructor
     * 
     * @param antecedent
     *            the Antecedent defining this rule.
     * @param consequent
     *            the Consequent following this rule and
     *            antecedent
     */
    public Rule(final Antecedent antecedent, final Consequent consequent) {

        /**
         * set antecedent
         */

        this.antecedent = antecedent;

        /**
         * set final ArrayList of consequents
         */

        this.consequent = consequent;
    }

    /**
     * @return Antecedent
     */
    public Antecedent getAntecedent() {
        return antecedent;
    }

    /**
     * @param antecedent
     *            the String to set
     */
    public void setAntecedent(Antecedent antecedent) {
        this.antecedent = antecedent;
    }

    /**
     * @return Consequent
     */
    public Consequent getConsequent() {
        return consequent;
    }

    /**
     * @param consequent
     *            the Consequent to set
     */
    public void setConsequent(Consequent consequent) {
        this.consequent = consequent;
    }


    /**
     * @return the before
     */
    public String getBefore() {
        return before;
    }

    /**
     * @param before the before to set
     */
    public void setBefore(String before) {
        this.before = before;
    }

    /**
     * @return the after
     */
    public String getAfter() {
        return after;
    }

    /**
     * @param after the after to set
     */
    public void setAfter(String after) {
        this.after = after;
    }

    /**
     * @return the ruleType
     */
    public RuleType getRuleType() {
        return ruleType;
    }

    /**
     * @param ruleType the ruleType to set
     */
    public void setRuleType(RuleType ruleType) {
        this.ruleType = ruleType;
    }

}
