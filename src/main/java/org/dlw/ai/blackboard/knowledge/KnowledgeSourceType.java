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

/**
 * This enum provides enumerated types for specifically implemented knowledge
 * sources to support the default blackboard model implementation. Please note
 * that this is an implementation enumerated type and should not be considered
 * API. These enumerations are specific to the default implementation.
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public enum KnowledgeSourceType {

    /**
     * Public static final enumeration describing pattern matching understanding
     */
    PATTERN_MATCHING_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing the knowledge of the completed
     * problem
     */
    SOLVED_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing the knowledge of how sentences
     * are structured
     */
    SENTENCE_STRUCTURE_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing the understanding of small
     * words
     */
    SMALL_WORD_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing knowledge of how words are
     * structured
     */
    WORD_STRUCTURE_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing what strings are legal for
     * cryptogram puzzles
     */
    LEGAL_STRING_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing words that use double vowels
     * or double consonants
     */
    DOUBLE_LETTER_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing common suffixes frequently
     * used
     */
    COMMON_SUFFIX_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing common prefixes frequently
     * used
     */
    COMMON_PREFIX_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing letters that occur and with
     * what frequency
     */
    LETTER_FREQUENCY_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing consonant definitions,
     * understanding, etc.
     */
    CONSONANT_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing vowel definitions,
     * understanding, etc.
     */
    VOWEL_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing direct substitution e.g. hints
     * (a D is really a Z)
     */
    DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing the parent knowledge of letters in general
     */
    LETTER_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing the parent knowledge of words in general
     */
    WORD_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing the parent knowledge of sentences in general
     */
    SENTENCE_KNOWLEDGE_SOURCE,

    /**
     * Public static final enumeration describing the parent knowledge of strings in general
     */
    STRING_KNOWLEDGE_SOURCE

}
