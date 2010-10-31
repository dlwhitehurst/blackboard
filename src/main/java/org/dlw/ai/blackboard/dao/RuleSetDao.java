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
package org.dlw.ai.blackboard.dao;

import org.dlw.ai.blackboard.exception.RuleSetNameNotFoundException;
import org.dlw.ai.blackboard.rule.RuleSet;
import java.util.List;

/**
 * RuleSet Data Access Object (GenericDao) interface.
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 */
public interface RuleSetDao extends GenericDao<RuleSet, Long> {

    /**
     * This method signature requires one argument, the name and it will return a RuleSet object.
     * 
     * @param name
     *   the name of the {@link org.dlw.ai.blackboard.rule.RuleSet}
     * @return {@link org.dlw.ai.blackboard.rule.RuleSet}
     * @throws RuleSetNameNotFoundException
     */
    RuleSet getRuleSetByName(String name) throws RuleSetNameNotFoundException;

    /**
     * This method signature requires no arguments. It returns a list of RuleSets.
     * 
     * @return a {@link java.util.List} of {@link org.dlw.ai.blackboard.rule.RuleSet} objects
     */
    List<RuleSet> getRuleSets();

    /**
     * This method signature requires a single argument, or {@link org.dlw.ai.blackboard.rule.RuleSet}.
     * The method saves the RuleSet and returns the object to the caller.
     * 
     * @param ruleSet
     *   the RuleSet to persist
     * @return {@link org.dlw.ai.blackboard.rule.RuleSet}
     */
    RuleSet saveRuleSet(RuleSet ruleSet);

}
