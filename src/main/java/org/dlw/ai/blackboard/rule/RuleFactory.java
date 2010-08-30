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
package org.dlw.ai.blackboard.rule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceConstants;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceType;

/**
 * <p>
 * This static factory class provides for the creation of the {@link Rule}
 * object. The objects are returned from a static method based on the input of a
 * {@link org.dlw.ai.blackboard.knowledge.KnowledgeSourceType}
 * </p>
 * 
 * @author dlwhitehurst
 * @version 1.0.0-RC
 * 
 */
public final class RuleFactory {

    /**
     * Attribute commons-logging class instance
     */
    private static final Log log = LogFactory.getLog(RuleFactory.class);

    private RuleFactory() {
    }

    public static Rule createRule(KnowledgeSourceType type) {

        Rule rule = new Rule();

        switch (type) {

        case COMMON_PREFIX_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.COMMON_PREFIX_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        case COMMON_SUFFIX_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.COMMON_SUFFIX_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        case CONSONANT_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.CONSONANT_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        case DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        case DOUBLE_LETTER_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.DOUBLE_LETTER_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        case LEGAL_STRING_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.LEGAL_STRING_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        case LETTER_FREQUENCY_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.LETTER_FREQUENCY_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        case PATTERN_MATCHING_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.PATTERN_MATCHING_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        case SENTENCE_STRUCTURE_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.SENTENCE_STRUCTURE_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        case SMALL_WORD_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.SMALL_WORD_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        case SOLVED_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.SOLVED_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        case VOWEL_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.VOWEL_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        case WORD_STRUCTURE_KNOWLEDGE_SOURCE:
            log.info("Creating "
                    + KnowledgeSourceConstants.WORD_STRUCTURE_KNOWLEDGE_SOURCE
                    + " rule.");
            break;

        default:
            log.info("Default error!");

        }
        
        return rule;
    }

}
