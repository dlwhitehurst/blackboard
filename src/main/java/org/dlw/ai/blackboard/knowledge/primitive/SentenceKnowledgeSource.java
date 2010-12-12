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

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.Blackboard;
import org.dlw.ai.blackboard.domain.Antecedent;
import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.domain.Consequent;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.knowledge.KnowledgeSource;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceUtil;
import org.dlw.ai.blackboard.rule.Rule;
import org.dlw.ai.blackboard.rule.RuleSet;
import org.dlw.ai.blackboard.rule.RuleType;
import org.dlw.ai.blackboard.util.KnowledgeSourceConstants;
import org.dlw.ai.blackboard.util.Logger;
import org.dlw.ai.blackboard.util.ReflectionUtil;
import org.dlw.ai.blackboard.util.UniversalContext;


/**
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public class SentenceKnowledgeSource extends KnowledgeSource {

    /**
     * Commons logging class instance
     */
    private final Log log = LogFactory.getLog(SentenceKnowledgeSource.class);

    /**
     * Attribute class logger
     */
    private Logger logger;
    
    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = -8260075649431321553L;
    
    public void notifyDependents(String direction, Assumption statement) {
        // TODO Auto-generated method stub
    }

    @Override
    public String toString() {
        return KnowledgeSourceConstants.SENTENCE_KNOWLEDGE_SOURCE;
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.KnowledgeSource#evaluate()
     */
    @Override
    public void evaluate() {

        /**
         * Initialize logger
         */
        logger = Logger.getInstance();
        logger.wrap(log);

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
     *   the {@link org.dlw.ai.blackboard.domain.Antecedent} reference
     * @param consequent
     *   the {@link org.dlw.ai.blackboard.domain.Consequent} reference
     */
    private void processMethodRule(Antecedent antecedent,
            Consequent consequent) {
        if (ReflectionUtil.isAntecedent(antecedent.getFullyQualifiedClass(),
                antecedent.getMethodName())) {

            ReflectionUtil.execConsequent(consequent.getFullyQualifiedClass(),
                    consequent.getMethodName());
        } else {
            logger.info("Controller::processNextHint->The SolvedKnowledgeSource has NO hint at this time.");
        }
    }

}
