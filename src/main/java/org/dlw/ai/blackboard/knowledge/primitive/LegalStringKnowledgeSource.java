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

import org.dlw.ai.blackboard.knowledge.InferenceEngine;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceConstants;

/**
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public class LegalStringKnowledgeSource extends StringKnowledgeSource implements
        InferenceEngine {

    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = 4579670117184769983L;

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
        return KnowledgeSourceConstants.LEGAL_STRING_KNOWLEDGE_SOURCE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dlw.ai.blackboard.knowledge.KnowledgeSource#evaluate()
     */
    public void evaluate() {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.StringKnowledgeSource#reset()
     */
    @Override
    public void reset() {
        // TODO Auto-generated method stub
        super.reset();
    }

}
