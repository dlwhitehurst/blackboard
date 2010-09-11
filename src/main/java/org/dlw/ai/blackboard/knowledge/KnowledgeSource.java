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

import java.util.ArrayList;

import org.dlw.ai.blackboard.BlackboardContext;
import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.rule.Rule;

/**
 * This interface defines the signature knowledge source object. Any default
 * implementation e.g.
 * {@link org.dlw.ai.blackboard.knowledge.primitive.CommonPrefixKnowledgeSource}
 * extends {@link InferenceEngine} ultimately through the implementation of this
 * interface and the extension {@link org.dlw.ai.blackboard.BlackboardContext}
 * directly within the implementation.
 * 
 * @author dlwhitehurst
 * @version 1.0.0-RC
 * 
 */
public abstract class KnowledgeSource extends BlackboardContext implements InferenceEngine, Comparable<KnowledgeSource>{

    private Integer priority;
    
    /**
     * Reset knowledge source
     */
    public void reset() {
        // TODO - implement
    }

    /**
     * Find dependent knowledge sources and tell them to add, retract, etc. a
     * statement
     * 
     * @param direction
     * @param statement
     */
    public void notifyDependents(String direction, Assumption statement) {
        // TODO - implement
    }

    public void evaluate() {
        // TODO Auto-generated method stub
        
    }

    public void loadRules(ArrayList<Rule> rules) {

    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public abstract int compareTo(KnowledgeSource o);

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.InferenceEngine#evaluate(org.dlw.ai.blackboard.domain.Sentence)
     */
    public void evaluate(Sentence sentence) {
        // TODO Auto-generated method stub
        
    }

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

}
