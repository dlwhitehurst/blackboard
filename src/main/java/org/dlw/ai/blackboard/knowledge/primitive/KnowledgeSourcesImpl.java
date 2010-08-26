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

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.util.SystemConstants;
import org.dlw.ai.blackboard.util.UniversalContext;

import org.dlw.ai.blackboard.knowledge.KnowledgeSource;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceConstants;
import org.dlw.ai.blackboard.knowledge.KnowledgeSources;

/**
 * This class provides a data structure for the collection of {@link KnowledgeSources}
 * implemented.  It implements 13 knowledge sources at present to solve a cryptogram
 * problem using a blackboard artificial intelligence model.
 * 
 * <p>
 * This class is not extendable and therefore not part of the API. Its use is
 * specific to the problem domain being solved by
 * {@link org.dlw.ai.blackboard.Main}.
 * </p>
 * 
 * @author dlwhitehurst
 * @version 1.0.0-RC
 *
 */
public final class KnowledgeSourcesImpl extends ArrayList<KnowledgeSource>
        implements KnowledgeSources {

    /**
	 * unique serial identifier
	 */
    private static final long serialVersionUID = -7058137814441379445L;

    /**
     * Commons logging class instance
     */
    private final Log log = LogFactory.getLog(KnowledgeSources.class);

    /**
     * Default constructor
     */
    public KnowledgeSourcesImpl() {
    }

    /**
     * Public method to clear and create all fresh knowledge sources
     */
    public void reset() {

        /**
         * Clear array
         */

        this.clear();

        /**
         * Load all Knowledge Sources
         */

        loadKnowledgeSources();

    }

    /**
	 * Public method to load this data structure with (13) unique knowledge sources
	 */
    public void loadKnowledgeSources() {

        /**
         * Load SolvedKnowledgeSource
         */

        SolvedKnowledgeSource solvedKnowledgeSource = (SolvedKnowledgeSource) UniversalContext
                .getApplicationContext().getBean(
                        KnowledgeSourceConstants.SOLVED_KNOWLEDGE_SOURCE);

        if (this.add((SolvedKnowledgeSource) solvedKnowledgeSource)
                && log.isInfoEnabled()) {
            log.info("1-SolvedKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

        /**
         * Load SentenceStructureKnowledgeSource
         */

        SentenceStructureKnowledgeSource sentenceStructureKnowledgeSource = (SentenceStructureKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.SENTENCE_STRUCTURE_KNOWLEDGE_SOURCE);

        if (this.add(sentenceStructureKnowledgeSource) && log.isInfoEnabled()) {
            log.info("2-SentenceStructureKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

        /**
         * Load PatternMatchingKnowledgeSource
         */

        PatternMatchingKnowledgeSource patternMatchingKnowledgeSource = (PatternMatchingKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.PATTERN_MATCHING_KNOWLEDGE_SOURCE);

        if (this.add(patternMatchingKnowledgeSource) && log.isInfoEnabled()) {
            log.info("3-PatternMatchingKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

        /**
         * Load SmallWordKnowledgeSource
         */

        SmallWordKnowledgeSource smallWordKnowledgeSource = (SmallWordKnowledgeSource) UniversalContext
                .getApplicationContext().getBean(
                        KnowledgeSourceConstants.SMALL_WORD_KNOWLEDGE_SOURCE);

        if (this.add(smallWordKnowledgeSource) && log.isInfoEnabled()) {
            log.info("4-SmallWordKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

        /**
         * Load WordStructureKnowledgeSource
         */

        WordStructureKnowledgeSource wordStructureKnowledgeSource = (WordStructureKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.WORD_STRUCTURE_KNOWLEDGE_SOURCE);

        if (this.add(wordStructureKnowledgeSource) && log.isInfoEnabled()) {
            log.info("5-WordStructureKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

        /**
         * Load LegalStringKnowledgeSource
         */

        LegalStringKnowledgeSource legalStringKnowledgeSource = (LegalStringKnowledgeSource) UniversalContext
                .getApplicationContext().getBean(
                        KnowledgeSourceConstants.LEGAL_STRING_KNOWLEDGE_SOURCE);

        if (this.add(legalStringKnowledgeSource) && log.isInfoEnabled()) {
            log.info("6-LegalStringKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

        /**
         * Load DoubleLetterKnowledgeSource
         */

        DoubleLetterKnowledgeSource doubleLetterKnowledgeSource = (DoubleLetterKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.DOUBLE_LETTER_KNOWLEDGE_SOURCE);

        if (this.add(doubleLetterKnowledgeSource) && log.isInfoEnabled()) {
            log.info("7-DoubleLetterKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

        /**
         * Load CommonSuffixKnowledgeSource
         */

        CommonSuffixKnowledgeSource commonSuffixKnowledgeSource = (CommonSuffixKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.COMMON_SUFFIX_KNOWLEDGE_SOURCE);

        if (this.add(commonSuffixKnowledgeSource) && log.isInfoEnabled()) {
            log.info("8-CommonSuffixKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

        /**
         * Load CommonPrefixKnowledgeSource
         */

        CommonPrefixKnowledgeSource commonPrefixKnowledgeSource = (CommonPrefixKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.COMMON_PREFIX_KNOWLEDGE_SOURCE);

        if (this.add(commonPrefixKnowledgeSource) && log.isInfoEnabled()) {
            log.info("9-CommonPrefixKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

        /**
         * Load LetterFrequencyKnowledgeSource
         */

        LetterFrequencyKnowledgeSource letterFrequencyKnowledgeSource = (LetterFrequencyKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.LETTER_FREQUENCY_KNOWLEDGE_SOURCE);

        if (this.add(letterFrequencyKnowledgeSource) && log.isInfoEnabled()) {
            log.info("10-LetterFrequencyKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

        /**
         * Load ConsonantKnowledgeSource
         */

        ConsonantKnowledgeSource consonantKnowledgeSource = (ConsonantKnowledgeSource) UniversalContext
                .getApplicationContext().getBean(
                        KnowledgeSourceConstants.CONSONANT_KNOWLEDGE_SOURCE);

        if (this.add(consonantKnowledgeSource) && log.isInfoEnabled()) {
            log.info("11-ConsonantKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

        /**
         * Load VowelKnowledgeSource
         */

        VowelKnowledgeSource vowelKnowledgeSource = (VowelKnowledgeSource) UniversalContext
                .getApplicationContext().getBean(
                        KnowledgeSourceConstants.VOWEL_KNOWLEDGE_SOURCE);

        if (this.add(vowelKnowledgeSource) && log.isInfoEnabled()) {
            log.info("12-VowelKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

        /**
         * Load DirectSubstitutionKnowledgeSource
         */

        DirectSubstitutionKnowledgeSource directSubstitutionKnowledgeSource = (DirectSubstitutionKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE);

        if (this.add(directSubstitutionKnowledgeSource) && log.isInfoEnabled()) {
            log.info("13-DirectSubstitutionKnowledgeSource added.");
        } else {
            System.err.println(SystemConstants.INFO_LEVEL_KS_FAIL);
            System.exit(0); // die
        }

    }

}
