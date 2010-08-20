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

import org.dlw.ai.blackboard.knowledge.KnowledgeSourceConstants;


/**
 * @author dlwhitehurst
 *
 */
public class VowelKnowledgeSource extends LetterKnowledgeSource {

	/* (non-Javadoc)
	 * @see org.dlw.ai.blackboard.knowledge.LetterKnowledgeSource#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	/* (non-Javadoc)
	 * @see org.dlw.ai.blackboard.knowledge.LetterKnowledgeSource#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	/* (non-Javadoc)
	 * @see org.dlw.ai.blackboard.knowledge.LetterKnowledgeSource#toString()
	 */
	@Override
	public String toString() {
		return KnowledgeSourceConstants.VOWEL_KNOWLEDGE_SOURCE;
	}

	/* (non-Javadoc)
	 * @see org.dlw.ai.blackboard.knowledge.KnowledgeSource#evaluate()
	 */
	@Override
	public void evaluate() {
		// TODO Auto-generated method stub
	}

}
