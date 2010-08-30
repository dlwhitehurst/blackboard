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

        case COMMON_PREFIX_KNOWLEDGE_SOURCE: // 1
            CommonPrefixKnowledgeSource commonPrefixKnowledgeSource = (CommonPrefixKnowledgeSource) ks;
            commonPrefixKnowledgeSource.setBlackboard(blackboard);
            commonPrefixKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.COMMON_PREFIX_KNOWLEDGE_SOURCE
                    + " object.");
            break;

        case COMMON_SUFFIX_KNOWLEDGE_SOURCE: // 2
            CommonSuffixKnowledgeSource commonSuffixKnowledgeSource = (CommonSuffixKnowledgeSource) ks;
            commonSuffixKnowledgeSource.setBlackboard(blackboard);
            commonSuffixKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.COMMON_SUFFIX_KNOWLEDGE_SOURCE
                    + " object.");
            break;

        case CONSONANT_KNOWLEDGE_SOURCE: // 3
            ConsonantKnowledgeSource consonantKnowledgeSource = (ConsonantKnowledgeSource) ks;
            consonantKnowledgeSource.setBlackboard(blackboard);
            consonantKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.CONSONANT_KNOWLEDGE_SOURCE
                    + " object.");
            break;
            
        case DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE: // 4
            DirectSubstitutionKnowledgeSource directSubstitutionKnowledgeSource = (DirectSubstitutionKnowledgeSource) ks;
            directSubstitutionKnowledgeSource.setBlackboard(blackboard);
            directSubstitutionKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE
                    + " object.");
            break;
            
        case DOUBLE_LETTER_KNOWLEDGE_SOURCE: // 5
            DoubleLetterKnowledgeSource doubleLetterKnowledgeSource = (DoubleLetterKnowledgeSource) ks;
            doubleLetterKnowledgeSource.setBlackboard(blackboard);
            doubleLetterKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.DOUBLE_LETTER_KNOWLEDGE_SOURCE
                    + " object.");
            break;
        
        case LEGAL_STRING_KNOWLEDGE_SOURCE: // 6
            LegalStringKnowledgeSource legalStringKnowledgeSource = (LegalStringKnowledgeSource) ks;
            legalStringKnowledgeSource.setBlackboard(blackboard);
            legalStringKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.LEGAL_STRING_KNOWLEDGE_SOURCE
                    + " object.");
            break;
            
        case LETTER_FREQUENCY_KNOWLEDGE_SOURCE: // 7
            LetterFrequencyKnowledgeSource letterFrequencyKnowledgeSource = (LetterFrequencyKnowledgeSource) ks;
            letterFrequencyKnowledgeSource.setBlackboard(blackboard);
            letterFrequencyKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.LETTER_FREQUENCY_KNOWLEDGE_SOURCE
                    + " object.");
            break;
            
        case PATTERN_MATCHING_KNOWLEDGE_SOURCE: // 8
            PatternMatchingKnowledgeSource patternMatchingKnowledgeSource = (PatternMatchingKnowledgeSource) ks;
            patternMatchingKnowledgeSource.setBlackboard(blackboard);
            patternMatchingKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.PATTERN_MATCHING_KNOWLEDGE_SOURCE
                    + " object.");
            break;
            
        case SENTENCE_STRUCTURE_KNOWLEDGE_SOURCE: // 9
            SentenceStructureKnowledgeSource sentenceStructureKnowledgeSource = (SentenceStructureKnowledgeSource) ks;
            sentenceStructureKnowledgeSource.setBlackboard(blackboard);
            sentenceStructureKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.SENTENCE_STRUCTURE_KNOWLEDGE_SOURCE
                    + " object.");
            break;
            
        case SMALL_WORD_KNOWLEDGE_SOURCE: // 10
            SmallWordKnowledgeSource smallWordKnowledgeSource = (SmallWordKnowledgeSource) ks;
            smallWordKnowledgeSource.setBlackboard(blackboard);
            smallWordKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.SMALL_WORD_KNOWLEDGE_SOURCE
                    + " object.");
            break;
            
        case SOLVED_KNOWLEDGE_SOURCE: // 11
            SolvedKnowledgeSource solvedKnowledgeSource = (SolvedKnowledgeSource) ks;
            solvedKnowledgeSource.setBlackboard(blackboard);
            solvedKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.SOLVED_KNOWLEDGE_SOURCE
                    + " object.");
            break;
            
        case VOWEL_KNOWLEDGE_SOURCE: // 12
            VowelKnowledgeSource vowelKnowledgeSource = (VowelKnowledgeSource) ks;
            vowelKnowledgeSource.setBlackboard(blackboard);
            vowelKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.VOWEL_KNOWLEDGE_SOURCE
                    + " object.");
            break;
            
        case WORD_STRUCTURE_KNOWLEDGE_SOURCE: // 13
            WordStructureKnowledgeSource wordStructureKnowledgeSource = (WordStructureKnowledgeSource) ks;
            wordStructureKnowledgeSource.setBlackboard(blackboard);
            wordStructureKnowledgeSource.setController(controller);
            log.info("Creating context for "
                    + KnowledgeSourceConstants.WORD_STRUCTURE_KNOWLEDGE_SOURCE
                    + " object.");
            break;
        default:
            // TODO - do something for sure
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

}
