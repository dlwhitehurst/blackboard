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
package org.dlw.ai.blackboard.util;

/**
 * This class is used to provide static constants for naming persisted rule sets
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public final class RuleSetConstants {

    /**
     * Hidden constructor
     */
    private RuleSetConstants() { 
    }
    
    public static final String COMMON_PREFIX = "CommonPrefix";
    
    public static final String COMMON_SUFFIX = "CommonSuffix";
    
    public static final String CONSONANT = "Consonant";
    
    public static final String DIRECT_SUBSTITUTION = "DirectSubstitution";
    
    public static final String DOUBLE_LETTER = "DoubleLetter";
    
    public static final String LEGAL_STRING = "LegalString";
    
    public static final String LETTER_FREQUENCY = "LetterFrequency";
    
    public static final String PATTERN_MATCHING = "PatternMatching";
    
    public static final String SENTENCE_STRUCTURE = "SentenceStructure";
    
    public static final String SMALL_WORD = "SmallWord";
    
    public static final String SOLVED = "Solved";
    
    public static final String VOWEL = "Vowel";
    
    public static final String WORD_STRUCTURE = "WordStructure";

}
