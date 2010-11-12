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
package org.dlw.ai.blackboard.knowledge;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.domain.BaseObject;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.rule.RuleSet;

/**
 * This interface defines the signature knowledge source object. Any default
 * implementation e.g.
 * {@link org.dlw.ai.blackboard.knowledge.primitive.CommonPrefixKnowledgeSource}
 * extends {@link InferenceEngine} ultimately through the implementation of this
 * interface and the extension {@link org.dlw.ai.blackboard.BlackboardContext}
 * directly within the implementation.
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC (hibernate-mysql branch)
 * 
 */
public abstract class KnowledgeSource extends BaseObject implements Comparable<KnowledgeSource>{

    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = 3094361637466019949L;
    
    /**
     * Attribute priority
     */
    protected Integer priority;

    /**
     * Attribute to hold rules for KnowledgeSource
     */
    protected RuleSet ruleSet = null;

    /**
     * Attribute queue of assumptions made by KnowledgeSource
     */
    protected ConcurrentLinkedQueue<Assumption> pastAssumptions = new ConcurrentLinkedQueue<Assumption>();
    
    /**
     * Reset knowledge source
     */
    public abstract void reset();
    
    /**
     * Evaluate sentence and provide expertise
     * @param sentence
     */
    public abstract void evaluate(Sentence sentence);
    

    /**
     * Find dependent knowledge sources and tell them to add, retract, etc. a
     * statement
     * 
     * @param direction
     * @param statement
     */
    public abstract void notifyDependents(String direction, Assumption statement);

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public abstract int compareTo(KnowledgeSource o);

    /**
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
        
    }

    /**
     * @return the priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * @return the ruleSet
     */
    public RuleSet getRuleSet() {
        return ruleSet;
    }

    /**
     * @param ruleSet the ruleSet to set
     */
    public void setRuleSet(RuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }

    /**
     * @param pastAssumptions the pastAssumptions to set
     */
    public void setPastAssumptions(ConcurrentLinkedQueue<Assumption> pastAssumptions) {
        this.pastAssumptions = pastAssumptions;
    }

    /**
     * @return the pastAssumptions
     */
    public ConcurrentLinkedQueue<Assumption> getPastAssumptions() {
        return pastAssumptions;
    }
    
}
