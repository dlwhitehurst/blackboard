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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.Blackboard;
import org.dlw.ai.blackboard.Controller;
import org.dlw.ai.blackboard.knowledge.primitive.CommonPrefixKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.CommonSuffixKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.ConsonantKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.DirectSubstitutionKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.DoubleLetterKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.LegalStringKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.LetterFrequencyKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.PatternMatchingKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.SentenceStructureKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.SmallWordKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.SolvedKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.VowelKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.primitive.WordStructureKnowledgeSource;
import org.dlw.ai.blackboard.rule.Rule;
import org.dlw.ai.blackboard.rule.RuleFactory;
import org.dlw.ai.blackboard.util.Logger;

/**
 * The KnowledgeSourceUtil class is used to provide static methods to stage-load
 * data into all KnowledgeSources
 * 
 * @author dlwhitehurst
 * @version 1.0.0-RC
 * 
 */
public final class KnowledgeSourceUtil {

    /**
     * Attribute commons-logging class instance
     */
    private static final Log log = LogFactory.getLog(KnowledgeSourceUtil.class);

    /**
     * Attribute class logger
     */
    private static Logger logger;

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
            Controller controller, Blackboard blackboard) {

        ks.setBlackboard(blackboard);
        ks.setController(controller);

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
            break;

        case COMMON_SUFFIX_KNOWLEDGE_SOURCE:
            tmp = (CommonSuffixKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.COMMON_SUFFIX_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;
            break;

        case CONSONANT_KNOWLEDGE_SOURCE: // 3
            tmp = (ConsonantKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.CONSONANT_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;
            break;

        case DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE: // 4
            tmp = (DirectSubstitutionKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;
            break;

        case DOUBLE_LETTER_KNOWLEDGE_SOURCE: // 5
            tmp = (DoubleLetterKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.DOUBLE_LETTER_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;
            break;

        case LEGAL_STRING_KNOWLEDGE_SOURCE: // 6
            tmp = (LegalStringKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.LEGAL_STRING_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;
            break;

        case LETTER_FREQUENCY_KNOWLEDGE_SOURCE: // 7
            tmp = (LetterFrequencyKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.LETTER_FREQUENCY_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;
            break;

        case PATTERN_MATCHING_KNOWLEDGE_SOURCE: // 8
            tmp = (PatternMatchingKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.PATTERN_MATCHING_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;
            break;

        case SENTENCE_STRUCTURE_KNOWLEDGE_SOURCE: // 9
            tmp = (SentenceStructureKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.SENTENCE_STRUCTURE_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;
            break;

        case SMALL_WORD_KNOWLEDGE_SOURCE: // 10
            tmp = (SmallWordKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.SMALL_WORD_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;
            break;

        case SOLVED_KNOWLEDGE_SOURCE: // 11
            tmp = (SolvedKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.SOLVED_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;
            break;

        case VOWEL_KNOWLEDGE_SOURCE: // 12
            tmp = (VowelKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.VOWEL_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;
            break;

        case WORD_STRUCTURE_KNOWLEDGE_SOURCE: // 13
            tmp = (WordStructureKnowledgeSource) ks;
            rule = RuleFactory
                    .createRule(KnowledgeSourceType.WORD_STRUCTURE_KNOWLEDGE_SOURCE);
            rules.add(rule);
            tmp.loadRules(rules);
            ks = tmp;
            break;

        default:
            // TODO - do something for sure
        }

        return ks;
    }
    
    public static void evaluationResponse(KnowledgeSource knowledgeSource, String response) {

        /**
         * Timestamp
         */
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
        
        /**
         * Initialize logger
         */
        logger = Logger.getInstance();
        logger.wrap(log);

        logger.info("##############################################################################");
        logger.info("## " +  knowledgeSource.toString() + ":EVALUATION " + currentTimestamp);
        logger.info("##############################################################################");
        
        logger.info(response);
        logger.info("##############################################################################");
        
    }
}
