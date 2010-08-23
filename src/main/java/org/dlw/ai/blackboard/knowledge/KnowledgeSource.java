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

import org.dlw.ai.blackboard.domain.Participant;

/**
 * This interface defines the knowledge source object. Its one and only method
 * is is used to implement what each knowledge source does and how it
 * communicates with the {@link org.dlw.ai.blackboard.Blackboard} object.
 * 
 * @author dlwhitehurst
 * 
 */
public interface KnowledgeSource extends Participant {

    /**
     * Public method to evaluate the blackboard model domain problem and offer
     * assumptions or assertions
     */
    void evaluate();

}
