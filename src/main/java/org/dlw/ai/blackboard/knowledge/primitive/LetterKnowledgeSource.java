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
package org.dlw.ai.blackboard.knowledge.primitive;

import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.knowledge.InferenceEngine;
import org.dlw.ai.blackboard.knowledge.KnowledgeSource;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceConstants;

// TODO - this class may be meaningless

/**
 * @author dlwhitehurst
 * @version 1.0.0-RC
 * 
 */
public class LetterKnowledgeSource extends KnowledgeSource implements InferenceEngine {
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return KnowledgeSourceConstants.LETTER_KNOWLEDGE_SOURCE;
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.KnowledgeSource#reset()
     */
    public void reset() {
        // TODO Auto-generated method stub
        
    }

    public void notifyDependents(String direction, Assumption statement) {
        // TODO Auto-generated method stub
        
    }

    public void evaluate(Sentence sentence) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int compareTo(KnowledgeSource o) {
        int priorityCmp = this.getPriority().compareTo(o.getPriority());
        return (priorityCmp != 0 ? priorityCmp : 0 );
    }

    
}
