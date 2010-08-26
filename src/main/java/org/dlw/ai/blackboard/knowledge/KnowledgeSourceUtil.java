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

import org.dlw.ai.blackboard.Blackboard;
import org.dlw.ai.blackboard.Controller;
import org.dlw.ai.blackboard.knowledge.primitive.CommonPrefixKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.CommonSuffixKnowledgeSource;
import org.dlw.ai.blackboard.rule.Rule;
import org.dlw.ai.blackboard.rule.RuleFactory;

/**
 * The KnowledgeSourceUtil class is used to provide static methods to stage-load
 * data into all KnowledgeSources
 * 
 * @author dlwhitehurst
 * @version 1.0.0-RC
 * 
 */
public class KnowledgeSourceUtil {

    /**
     * Hidden constructor
     */
    private KnowledgeSourceUtil() {
    }

    /**
     * Public method to load any {@link KnowledgeSource} with blackboard context
     * 
     * @param ks
     *            the {@link KnowledgeSource} being loaded
     * @param type
     *            the {@link KnowledgeSourceType} enum
     * @param controller
     *            the {@link org.dlw.ai.blackboard.Controller} of the problem
     *            domain
     * @param blackboard
     *            the {@link org.dlw.ai.blackboard.Blackboard} data structure
     * @return
     */
    public static KnowledgeSource loadContext(KnowledgeSource ks,
            KnowledgeSourceType type, Controller controller,
            Blackboard blackboard) {

        switch (type) {

        case COMMON_PREFIX_KNOWLEDGE_SOURCE:
            CommonPrefixKnowledgeSource commonPrefixKnowledgeSource = (CommonPrefixKnowledgeSource) ks;
            commonPrefixKnowledgeSource.setBlackboard(blackboard);
            commonPrefixKnowledgeSource.setController(controller);

        case COMMON_SUFFIX_KNOWLEDGE_SOURCE:
            CommonSuffixKnowledgeSource commonSuffixKnowledgeSource = (CommonSuffixKnowledgeSource) ks;
            commonSuffixKnowledgeSource.setBlackboard(blackboard);
            commonSuffixKnowledgeSource.setController(controller);

        default:

        }

        return ks;
    }

    /**
     * Public method to load {@link Rule} objects for any
     * {@link KnowledgeSource}
     * 
     * @param ks
     * @param type
     * @return
     */
    public static KnowledgeSource loadRules(KnowledgeSource ks,
            KnowledgeSourceType type) {

        ArrayList<Rule> rules = new ArrayList<Rule>();
        Rule rule;
        KnowledgeSource tmp;

        switch (type) {

        case COMMON_PREFIX_KNOWLEDGE_SOURCE:
            tmp = (CommonPrefixKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.COMMON_PREFIX_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;

        case COMMON_SUFFIX_KNOWLEDGE_SOURCE:
            tmp = (CommonSuffixKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.COMMON_SUFFIX_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;

        default:

        }

        return ks;
    }

}
