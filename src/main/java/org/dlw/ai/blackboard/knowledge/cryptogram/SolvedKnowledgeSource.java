/*
 * Copyright 2020 David L. Whitehurst
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

package org.dlw.ai.blackboard.knowledge.cryptogram;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.rule.Antecedent;
import org.dlw.ai.blackboard.rule.Consequent;
import org.dlw.ai.blackboard.rule.Rule;
import org.dlw.ai.blackboard.rule.RuleSet;
import org.dlw.ai.blackboard.util.KnowledgeSourceConstants;
import org.dlw.ai.blackboard.util.ReflectionUtil;


/**
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 * 
 */
public class SolvedKnowledgeSource extends SentenceKnowledgeSource {

    /**
     * unique serial identifier
     */

    private static final long serialVersionUID = -7129896322940388384L;
    /**
     * Commons logging class instance
     */
    private final Log log = LogFactory.getLog(SolvedKnowledgeSource.class);

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#toString()
     */
    @Override
    public String toString() {
        return KnowledgeSourceConstants.SOLVED_KNOWLEDGE_SOURCE;
    }
    
    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.KnowledgeSource#evaluate()
     */
    @Override
    public void evaluate() {


        RuleSet set = this.getRuleSet();
        
        List<Rule> rules = set.getRules();

        for (int i = 0; i < rules.size(); i++) {
            Rule rule = rules.get(i);

            Antecedent antecedent = rule.getAntecedent();
            Consequent consequent = rule.getConsequent();

                processMethodRule(antecedent, consequent);
        }

    }

    /**
     * Private method to process a method rule
     * 
     * @param antecedent
     *   the {@link org.dlw.ai.blackboard.rule.Antecedent} reference
     * @param consequent
     *   the {@link org.dlw.ai.blackboard.rule.Consequent} reference
     */
    private void processMethodRule(Antecedent antecedent,
            Consequent consequent) {

        if (ReflectionUtil.isAntecedent(antecedent.getFullyQualifiedClass(),
                antecedent.getMethodName())) {

            log.info("processMethodRule->The SolvedKnowledgeSource is informing the controller that a solution has been found.");
            ReflectionUtil.execConsequent(consequent.getFullyQualifiedClass(),
                    consequent.getMethodName());

        } else log.info("processMethodRule->The SolvedKnowledgeSource makes no assumption at this time.");
    }

}    
