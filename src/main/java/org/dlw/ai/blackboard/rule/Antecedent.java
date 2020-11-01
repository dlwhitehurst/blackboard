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
package org.dlw.ai.blackboard.rule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.dlw.ai.blackboard.domain.BaseObject;
import org.hibernate.annotations.*;

/**
 * This class provides the "if" part of a conditional that is used to define a
 * {@link org.dlw.ai.blackboard.rule.Rule} object.  The rule is not complete 
 * without the {@link org.dlw.ai.blackboard.rule.Consequent} object.
 * 
 * <blockquote><i>Antecedent - "(def.) a thing or event that existed before or 
 * logically precedes another.</i></blockquote> 
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 */
@Entity
@Table(name="antecedent")
public class Antecedent extends BaseObject {
    
    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = 2299632874123077597L;
    
    /**
     * Primary key object
     */
    private Long id;
    
    /**
     * Attribute parent
     */
    private Rule rule;
    
    /**
     * Attribute class name
     */
    private String fullyQualifiedClass;
    
    /**
     * Attribute method name
     */
    private String methodName;
    
    /**
     * Attribute pure String antecedent
     */
    private String basic;
    
    /**
     * @return the String class name (fully qualified)
     */
    @Column(name="class_name",nullable=false,length=40)    
    public String getFullyQualifiedClass() {
        return fullyQualifiedClass;
    }

    /**
     * @param fullyQualifiedClass 
     *   the fullyQualifiedClass String to set
     */
    public void setFullyQualifiedClass(String fullyQualifiedClass) {
        this.fullyQualifiedClass = fullyQualifiedClass;
    }

    /**
     * @return the String methodName
     */
    @Column(name="method_name",nullable=false,length=40)    
    public String getMethodName() {
        return methodName;
    }

    /**
     * @param methodName 
     *   the methodName to set
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * @return the String antecedent
     */
    @Column(name="basic_stmt",nullable=false,length=40)    
    public String getBasic() {
        return basic;
    }

    /**
     * @param basic 
     *   the String antecedent to set
     */
    public void setBasic(String basic) {
        this.basic = basic;
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
     * @return the {@link java.lang.Long } id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the {@link org.dlw.ai.blackboard.rule.Rule} object
     */
    @OneToOne
    @Cascade({CascadeType.ALL})
    @JoinColumn(name="rule_fk")    
    public Rule getRule() {
        return rule;
    }

    /**
     * @param rule the {@link org.dlw.ai.blackboard.rule.Rule} to set
     */
    public void setRule(Rule rule) {
        this.rule = rule;
    }

}
