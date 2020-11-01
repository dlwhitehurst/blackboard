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
package org.dlw.ai.blackboard.knowledge;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.exception.CollectionLoadingException;
import org.dlw.ai.blackboard.exception.InitializationException;
import org.dlw.ai.blackboard.exception.UnknownKnowledgeSourceException;
import org.dlw.ai.blackboard.knowledge.cryptogram.CommonPrefixKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.cryptogram.CommonSuffixKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.cryptogram.ConsonantKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.cryptogram.DirectSubstitutionKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.cryptogram.DoubleLetterKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.cryptogram.LegalStringKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.cryptogram.LetterFrequencyKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.cryptogram.PatternMatchingKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.cryptogram.SentenceStructureKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.cryptogram.SmallWordKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.cryptogram.SolvedKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.cryptogram.VowelKnowledgeSource;
import org.dlw.ai.blackboard.knowledge.cryptogram.WordStructureKnowledgeSource;
import org.dlw.ai.blackboard.util.KnowledgeSourceConstants;
import org.dlw.ai.blackboard.util.RuleSetConstants;
import org.dlw.ai.blackboard.util.UniversalContext;

/**
 * This class provides a data structure for the collection of
 * {@link KnowledgeSources} implemented. It implements 13 knowledge sources at
 * present to solve a cryptogram problem using a blackboard artificial
 * intelligence model.
 * 
 * <p>
 * This class is not extendable and therefore not part of the API. Its use is
 * specific to the problem domain being solved by
 * {@link org.dlw.ai.blackboard.Main}.
 * </p>
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 * @since 1.0
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
     * Public method to initialize all knowledge sources
     * 
     * @throws CollectionLoadingException
     */
    public void init() throws InitializationException,
            CollectionLoadingException {

        /**
         * Load all Knowledge Sources
         */

        try {
            loadKnowledgeSources();
        } catch (CollectionLoadingException e) {
            e.printStackTrace();
            throw new CollectionLoadingException(
                    "Initialization failed due to error loading collection or arraylist.");
        }

        /**
         * Load all with BlackboardContext and Rules
         */

        try {
            initializeKnowledgeSources();
        } catch (InitializationException iex) {
            iex.printStackTrace();
            throw new InitializationException(
                    "Initialization failed due to error initializing knowledge source object");
        }

    }

    /**
     * Public method to clear and initialize all knowledge sources
     * 
     * @throws CollectionLoadingException
     */
    public void reset() throws InitializationException,
            CollectionLoadingException {

        /**
         * Clear array
         */

        this.clear();

        /**
         * Load all Knowledge Sources
         */

        try {
            loadKnowledgeSources();
        } catch (CollectionLoadingException e) {
            e.printStackTrace();
            throw new CollectionLoadingException(
                    "Reset failed due to error loading the collection or arraylist.");
        }

        /**
         * Load all with rules and priorities
         */
        try {
            initializeKnowledgeSources();
        } catch (InitializationException iex) {
            iex.printStackTrace();
            throw new InitializationException(
                    "Reset failed due to error initializing knowledge source object.");
        }

    }

    /**
     * Private method to load this data structure with (13) unique knowledge
     * sources
     */
    public void loadKnowledgeSources() throws CollectionLoadingException {

        /**
         * Load SolvedKnowledgeSource
         */

        SolvedKnowledgeSource solvedKnowledgeSource = (SolvedKnowledgeSource) UniversalContext
                .getApplicationContext().getBean(
                        KnowledgeSourceConstants.SOLVED_KNOWLEDGE_SOURCE);

        addKS(solvedKnowledgeSource);

        /**
         * Load SentenceStructureKnowledgeSource
         */

        SentenceStructureKnowledgeSource sentenceStructureKnowledgeSource = (SentenceStructureKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.SENTENCE_STRUCTURE_KNOWLEDGE_SOURCE);

        addKS(sentenceStructureKnowledgeSource);

        /**
         * Load PatternMatchingKnowledgeSource
         */

        PatternMatchingKnowledgeSource patternMatchingKnowledgeSource = (PatternMatchingKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.PATTERN_MATCHING_KNOWLEDGE_SOURCE);

        addKS(patternMatchingKnowledgeSource);

        /**
         * Load SmallWordKnowledgeSource
         */

        SmallWordKnowledgeSource smallWordKnowledgeSource = (SmallWordKnowledgeSource) UniversalContext
                .getApplicationContext().getBean(
                        KnowledgeSourceConstants.SMALL_WORD_KNOWLEDGE_SOURCE);

        addKS(smallWordKnowledgeSource);

        /**
         * Load WordStructureKnowledgeSource
         */

        WordStructureKnowledgeSource wordStructureKnowledgeSource = (WordStructureKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.WORD_STRUCTURE_KNOWLEDGE_SOURCE);

        addKS(wordStructureKnowledgeSource);

        /**
         * Load LegalStringKnowledgeSource
         */

        LegalStringKnowledgeSource legalStringKnowledgeSource = (LegalStringKnowledgeSource) UniversalContext
                .getApplicationContext().getBean(
                        KnowledgeSourceConstants.LEGAL_STRING_KNOWLEDGE_SOURCE);

        addKS(legalStringKnowledgeSource);

        /**
         * Load DoubleLetterKnowledgeSource
         */

        DoubleLetterKnowledgeSource doubleLetterKnowledgeSource = (DoubleLetterKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.DOUBLE_LETTER_KNOWLEDGE_SOURCE);

        addKS(doubleLetterKnowledgeSource);

        /**
         * Load CommonSuffixKnowledgeSource
         */

        CommonSuffixKnowledgeSource commonSuffixKnowledgeSource = (CommonSuffixKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.COMMON_SUFFIX_KNOWLEDGE_SOURCE);

        addKS(commonSuffixKnowledgeSource);

        /**
         * Load CommonPrefixKnowledgeSource
         */

        CommonPrefixKnowledgeSource commonPrefixKnowledgeSource = (CommonPrefixKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.COMMON_PREFIX_KNOWLEDGE_SOURCE);

        addKS(commonPrefixKnowledgeSource);

        /**
         * Load LetterFrequencyKnowledgeSource
         */

        LetterFrequencyKnowledgeSource letterFrequencyKnowledgeSource = (LetterFrequencyKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.LETTER_FREQUENCY_KNOWLEDGE_SOURCE);

        addKS(letterFrequencyKnowledgeSource);

        /**
         * Load ConsonantKnowledgeSource
         */

        ConsonantKnowledgeSource consonantKnowledgeSource = (ConsonantKnowledgeSource) UniversalContext
                .getApplicationContext().getBean(
                        KnowledgeSourceConstants.CONSONANT_KNOWLEDGE_SOURCE);

        addKS(consonantKnowledgeSource);

        /**
         * Load VowelKnowledgeSource
         */

        VowelKnowledgeSource vowelKnowledgeSource = (VowelKnowledgeSource) UniversalContext
                .getApplicationContext().getBean(
                        KnowledgeSourceConstants.VOWEL_KNOWLEDGE_SOURCE);

        addKS(vowelKnowledgeSource);

        /**
         * Load DirectSubstitutionKnowledgeSource
         */

        DirectSubstitutionKnowledgeSource directSubstitutionKnowledgeSource = (DirectSubstitutionKnowledgeSource) UniversalContext
                .getApplicationContext()
                .getBean(
                        KnowledgeSourceConstants.DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE);

        addKS(directSubstitutionKnowledgeSource);
    }

    /**
     * Public method to iterate over all KnowledgeSources, load rules and
     * context
     */
    public void initializeKnowledgeSources() throws InitializationException {
        for (KnowledgeSource knowledgeSource : this) {

            /**
             * Initialize
             */
            try {
                loadRulesAndContext(knowledgeSource);
            } catch (UnknownKnowledgeSourceException e) {
                e.printStackTrace();
                throw new InitializationException(
                        "Initialization failed due to error loading rules and context for some knowledge source.");
            }

        }
    }

    /**
     * Private method to specifically load rules and context based on knowledge
     * source type
     * 
     * @param ks
     *            the {@link org.dlw.ai.blackboard.knowledge.KnowledgeSource}
     *            needing rules and context
     */
    private void loadRulesAndContext(KnowledgeSource ks)
            throws UnknownKnowledgeSourceException {

        KnowledgeSourceUtil ksUtil = new KnowledgeSourceUtil();

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.CommonPrefixKnowledgeSource) {
            ks.setPriority(new Integer(4));
            ksUtil.loadRuleSet(ks, RuleSetConstants.COMMON_PREFIX);
            return;
        }

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.CommonSuffixKnowledgeSource) {
            ks.setPriority(new Integer(5));
            ksUtil.loadRuleSet(ks, RuleSetConstants.COMMON_SUFFIX);
            return;
        }

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.ConsonantKnowledgeSource) {
            ks.setPriority(new Integer(5));
            ksUtil.loadRuleSet(ks, RuleSetConstants.CONSONANT);
            return;
        }

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.DirectSubstitutionKnowledgeSource) {
            ks.setPriority(new Integer(2));
            ksUtil.loadRuleSet(ks, RuleSetConstants.DIRECT_SUBSTITUTION);
            return;
        }

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.DoubleLetterKnowledgeSource) {
            ks.setPriority(new Integer(5));
            ksUtil.loadRuleSet(ks, RuleSetConstants.DOUBLE_LETTER);
            return;
        }

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.LegalStringKnowledgeSource) {
            ks.setPriority(new Integer(5));
            ksUtil.loadRuleSet(ks, RuleSetConstants.LEGAL_STRING);
            return;
        }

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.LetterFrequencyKnowledgeSource) {
            ks.setPriority(new Integer(5));
            ksUtil.loadRuleSet(ks, RuleSetConstants.LETTER_FREQUENCY);
            return;
        }

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.PatternMatchingKnowledgeSource) {
            ks.setPriority(new Integer(4));
            ksUtil.loadRuleSet(ks, RuleSetConstants.PATTERN_MATCHING);
            return;
        }

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.SentenceStructureKnowledgeSource) {
            ks.setPriority(new Integer(5));
            ksUtil.loadRuleSet(ks, RuleSetConstants.SENTENCE_STRUCTURE);
            return;
        }

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.SmallWordKnowledgeSource) {
            ks.setPriority(new Integer(3));
            ksUtil.loadRuleSet(ks, RuleSetConstants.SMALL_WORD);
            return;
        }

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.SolvedKnowledgeSource) {
            ks.setPriority(new Integer(1)); // top priority
            ksUtil.loadRuleSet(ks, RuleSetConstants.SOLVED);
            return;
        }

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.VowelKnowledgeSource) {
            ks.setPriority(new Integer(5));
            ksUtil.loadRuleSet(ks, RuleSetConstants.VOWEL);
            return;
        }

        if (ks instanceof org.dlw.ai.blackboard.knowledge.cryptogram.WordStructureKnowledgeSource) {
            ks.setPriority(new Integer(5));
            ksUtil.loadRuleSet(ks, RuleSetConstants.WORD_STRUCTURE);
            return;
        }

        else {
            log.error("This knowledge source instance could not be identified.");
            throw new UnknownKnowledgeSourceException(
                    "This knowledge source instance could not be identified.");
        }

    }

    /**
     * Private method to add KnowledgeSources to itself
     * 
     * @param ks
     *            the {@link org.dlw.ai.blackboard.knowledge.KnowledgeSource}
     *            reference
     * @throws CollectionLoadingException
     */
    private void addKS(KnowledgeSource ks) throws CollectionLoadingException {


        if (this.add(ks)) {
            log.info(ks.toString() + " added.");
        } else {
            throw new CollectionLoadingException(
                    "Could not load collection due to object or collection constraint.");
        }

    }

}
