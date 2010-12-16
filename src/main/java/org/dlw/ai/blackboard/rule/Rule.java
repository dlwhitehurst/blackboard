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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.dlw.ai.blackboard.domain.BaseObject;

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
 * @version 1.0.0
 * 
 */
@Entity
@Table(name="rule")
public class Rule extends BaseObject {
    
    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = 1752654049647426358L;

    /**
     * Primary key object
     */
    private Long id;
    
    /**
     * Attribute antecedent (if-part)
     */
    private Antecedent antecedent;

    /**
     * Attribute consequent (then-part)
     */
    private Consequent consequent;
    
    /**
     * Attribute rule type string
     */
    private String ruleType;
    
    /**
     * Attribute initial letter
     */
    private String before;
    
    /**
     * Attribute deciphered letter
     */
    private String after;
  
    /**
     * Attribute parent rset
     */
    private RuleSet rset;

    /**
     * Default constructor
     */
    public Rule() {
    }

    /**
     * @return the before
     */
    @Column(name="before_str",nullable=false,length=10)    
    public String getBefore() {
        return before;
    }

    /**
     * @return the after
     */
    @Column(name="after_str",nullable=false,length=10)    
    public String getAfter() {
        return after;
    }

    /**
     * @return Antecedent
     */
    @OneToOne(mappedBy = "rule")
    public Antecedent getAntecedent() {
        return antecedent;
    }


    /**
     * @return Consequent
     */
    @OneToOne(mappedBy = "rule")
    public Consequent getConsequent() {
        return consequent;
    }

    /**
     * @param antecedent
     *            the String to set
     */
    public void setAntecedent(Antecedent antecedent) {
        this.antecedent = antecedent;
    }

    /**
     * @param consequent
     *            the Consequent to set
     */
    public void setConsequent(Consequent consequent) {
        this.consequent = consequent;
    }



    /**
     * @param before t
     *   the before String to set
     */
    public void setBefore(String before) {
        this.before = before;
    }


    /**
     * @param after
     *   the after String to set
     */
    public void setAfter(String after) {
        this.after = after;
    }

    /**
     * @return the {@link org.dlw.ai.blackboard.rule.RuleSet} object
     */
    @ManyToOne
    public RuleSet getRset() {
        return rset;
    }

    /**
     * @param rset 
     *   the {@link org.dlw.ai.blackboard.rule.RuleSet} to set
     */
    public void setRset(RuleSet rset) {
        this.rset = rset;
    }

    /**
     * @return the Long id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    
    public Long getId() {
        return id;
    }

    /**
     * @param id 
     *   the id Long to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean equals(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * @return the rule type String
     */
    @Column(name="rule_type")
    public String getRuleType() {
        return ruleType;
    }

    /**
     * @param ruleType 
     *   the ruleType String to set
     */
    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }


}
