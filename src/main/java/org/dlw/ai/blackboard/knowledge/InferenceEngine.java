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

import org.dlw.ai.blackboard.rule.Rule;

/**
 * This interface provides service hooks for loading rules and
 * then providing evaluation of problems using these rules for
 * objects similar and including the {@link KnowledgeSource}
 * 
 * @author dlwhitehurst
 *
 */
public interface InferenceEngine {

    /**
     * Public method to evaluate the blackboard model domain problem and offer
     * assumptions or assertions
     */
    void evaluate();

    /**
     * Public method to implement where a list of rules to be used for
     * evaluation
     * 
     * @param rules
     *            the {@link java.util.ArrayList} containing rules
     */
    void loadRules(ArrayList<Rule> rules);

}
