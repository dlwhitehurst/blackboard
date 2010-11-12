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
import org.dlw.ai.blackboard.knowledge.KnowledgeSource;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceConstants;

/**
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public class SentenceStructureKnowledgeSource extends SentenceKnowledgeSource {

    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = -3429504143671407871L;

    /*
     * (non-Javadoc)
     * 
     * @see org.dlw.ai.blackboard.knowledge.SentenceKnowledgeSource#evaluate()
     */
    public void evaluate() {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#reset()
     */
    @Override
    public void reset() {
        // TODO Auto-generated method stub
        super.reset();
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#notifyDependents(java.lang.String, org.dlw.ai.blackboard.domain.Assumption)
     */
    @Override
    public void notifyDependents(String direction, Assumption statement) {
        // TODO Auto-generated method stub
        super.notifyDependents(direction, statement);
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#evaluate(org.dlw.ai.blackboard.domain.Sentence)
     */
    @Override
    public void evaluate(Sentence sentence) {
        // TODO Auto-generated method stub
        super.evaluate(sentence);
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#compareTo(org.dlw.ai.blackboard.knowledge.KnowledgeSource)
     */
    @Override
    public int compareTo(KnowledgeSource o) {
        // TODO Auto-generated method stub
        return super.compareTo(o);
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#toString()
     */
    @Override
    public String toString() {
        return KnowledgeSourceConstants.SENTENCE_STRUCTURE_KNOWLEDGE_SOURCE;
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        // TODO Auto-generated method stub
        return super.equals(o);
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#hashCode()
     */
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

}
