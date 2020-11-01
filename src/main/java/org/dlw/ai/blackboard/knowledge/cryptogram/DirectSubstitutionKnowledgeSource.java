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
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.Blackboard;
import org.dlw.ai.blackboard.BlackboardContext;
import org.dlw.ai.blackboard.domain.Assertion;
import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.domain.Alphabet;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.domain.Word;
import org.dlw.ai.blackboard.knowledge.KnowledgeSource;
import org.dlw.ai.blackboard.rule.Rule;
import org.dlw.ai.blackboard.rule.RuleSet;
import org.dlw.ai.blackboard.util.KnowledgeSourceConstants;
import org.dlw.ai.blackboard.util.MessageConstants;
import org.dlw.ai.blackboard.util.SentenceUtil;

/**
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 * 
 */
public class DirectSubstitutionKnowledgeSource extends LetterKnowledgeSource {

    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = 356412919991462052L;

    /**
     * Commons logging class instance
     */
    private final Log log = LogFactory.getLog(DirectSubstitutionKnowledgeSource.class);

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return KnowledgeSourceConstants.DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dlw.ai.blackboard.knowledge.KnowledgeSource#evaluate()
     */
    @Override
    public void evaluate() {

        Blackboard blackboard = BlackboardContext.getInstance().getBlackboard();
        Sentence sentence = blackboard.getSentence();

        RuleSet set = this.getRuleSet();

        List<Rule> rules = set.getRules();

        for (int i = 0; i < rules.size(); i++) {
            Rule rule = rules.get(i);
            processConversionRule(sentence, rule, this);
        }
    }

    private void processConversionRule(Sentence sentence, Rule rule,
            KnowledgeSource ks) {

        List<Word> words = SentenceUtil.getWords(sentence);
        List<Alphabet> letters;

        for (Word word : words) {
            letters = SentenceUtil.getLetters(word);

            String cipher = rule.getBefore();
            String plainText = rule.getAfter();

            for (Alphabet letter : letters) {

                if (letter.getCipherLetter().equals(cipher)) {
                    makeAssertion(ks, cipher, plainText);
                    log.info("processConversionRule->The DirectSubstitutionKnowledgeSource made an assertion to change the letter " + cipher + " to letter " + plainText + ".");
                    return;
                }
            }
        }

    }
    
    private void makeAssertion(KnowledgeSource ks, String cipher,
            String plainText) {

        /**
         * Create and load an Assertion
         */
        Assertion assertion = new Assertion();
        assertion.setCipherLetter(cipher);
        assertion.setPlainLetter(plainText);
        assertion.setReason(MessageConstants.SUBSTITUTION_ASSERT);

        /**
         * Get data-structure to hold new Assertion
         */
        ConcurrentLinkedQueue<Assumption> queue = ks.getPastAssumptions();

        /**
         * Load our Assertion
         */
        queue.add(assertion);

        /**
         * Add Assumption/Assertion queue to this specific knowledge source
         */
        ks.setPastAssumptions(queue);

    }

}
