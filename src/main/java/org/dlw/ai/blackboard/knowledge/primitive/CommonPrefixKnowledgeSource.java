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

/**
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public class CommonPrefixKnowledgeSource extends StringKnowledgeSource implements
        InferenceEngine {

    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = 2808716412471354046L;

    /*
     * (non-Javadoc)
     * 
     * @see org.dlw.ai.blackboard.knowledge.KnowledgeSource#evaluate()
     */
    public void evaluate() {
        // TODO - implement
        // BlackboardContext parent has what we need for this method
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.StringKnowledgeSource#reset()
     */
    @Override
    public void reset() {
        // TODO Auto-generated method stub
        super.reset();
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.KnowledgeSource#notifyDependents(java.lang.String, org.dlw.ai.blackboard.domain.Assumption)
     */
    public void notifyDependents(String direction, Assumption statement) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.KnowledgeSource#compareTo(org.dlw.ai.blackboard.knowledge.KnowledgeSource)
     */
    @Override
    public int compareTo(KnowledgeSource o) {
        int priorityCmp = this.getPriority().compareTo(o.getPriority());
        return (priorityCmp != 0 ? priorityCmp : 0 );
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.StringKnowledgeSource#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.StringKnowledgeSource#evaluate(org.dlw.ai.blackboard.domain.Sentence)
     */
    @Override
    public void evaluate(Sentence sentence) {
        // TODO Auto-generated method stub
        super.evaluate(sentence);
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.StringKnowledgeSource#hashCode()
     */
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

}
