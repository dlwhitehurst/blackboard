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

import java.util.ArrayList;

import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.knowledge.KnowledgeSource;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceConstants;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceUtil;
import org.dlw.ai.blackboard.rule.Rule;
import org.dlw.ai.blackboard.util.MessageConstants;

/**
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public class SolvedKnowledgeSource extends SentenceKnowledgeSource {

    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = -7129896322940388384L;
    
    private ArrayList<Rule> rules = new ArrayList<Rule>();

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#reset()
     */
    @Override
    public void reset() {
        // TODO Auto-generated method stub
        super.reset();
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#evaluate(org.dlw.ai.blackboard.domain.Sentence)
     */
    @Override
    public void evaluate(Sentence sentence) {
        KnowledgeSourceUtil.considerRules(this, sentence, MessageConstants.SENTENCE_SOLVED, "");
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#evaluate()
     */
    @Override
    public void evaluate() {
        // TODO Auto-generated method stub
        super.evaluate();
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
        return KnowledgeSourceConstants.SOLVED_KNOWLEDGE_SOURCE;
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
