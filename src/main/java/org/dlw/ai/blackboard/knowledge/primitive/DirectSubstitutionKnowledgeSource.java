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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.Blackboard;
import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.knowledge.InferenceEngine;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceConstants;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceUtil;
import org.dlw.ai.blackboard.util.Logger;
import org.dlw.ai.blackboard.util.MessageConstants;

/**
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public class DirectSubstitutionKnowledgeSource extends LetterKnowledgeSource
        implements InferenceEngine {

    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = 356412919991462052L;

    /**
     * Commons logging class instance
     */
    private final Log log = LogFactory.getLog(Blackboard.class);

    /**
     * Attribute class logger
     */
    private Logger logger;

    /**
     * Default constructor
     */
    public DirectSubstitutionKnowledgeSource() {

        /**
         * Initialize logger
         */
        logger = Logger.getInstance();
        logger.wrap(log);

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
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
        return KnowledgeSourceConstants.DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dlw.ai.blackboard.knowledge.primitive.LetterKnowledgeSource#reset()
     */
    @Override
    public void reset() {
        // TODO Auto-generated method stub
        super.reset();
    }
    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.InferenceEngine#evaluate(org.dlw.ai.blackboard.domain.Sentence)
     */
    public void evaluate(Sentence sentence) {
        KnowledgeSourceUtil.considerRules(this, sentence, "", MessageConstants.SUBSTITUTION_ASSERT);
    }

    /*
     * (non-Javadoc)
     * 
     * @seeorg.dlw.ai.blackboard.knowledge.primitive.LetterKnowledgeSource#
     * notifyDependents(java.lang.String,
     * org.dlw.ai.blackboard.domain.Assumption)
     */
    @Override
    public void notifyDependents(String direction, Assumption statement) {
        // TODO Auto-generated method stub
        super.notifyDependents(direction, statement);
    }

}
