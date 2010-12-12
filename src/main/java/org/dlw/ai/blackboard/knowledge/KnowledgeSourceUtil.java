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
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.Blackboard;
import org.dlw.ai.blackboard.dao.RuleSetDao;
import org.dlw.ai.blackboard.dao.hibernate.RuleSetDaoHibernate;
import org.dlw.ai.blackboard.domain.Antecedent;
import org.dlw.ai.blackboard.domain.Assertion;
import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.domain.Consequent;
import org.dlw.ai.blackboard.domain.Letter;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.domain.Word;
import org.dlw.ai.blackboard.exception.RuleSetNameNotFoundException;
import org.dlw.ai.blackboard.rule.Rule;
import org.dlw.ai.blackboard.rule.RuleSet;
import org.dlw.ai.blackboard.rule.RuleType;
import org.dlw.ai.blackboard.util.Logger;
import org.dlw.ai.blackboard.util.MessageConstants;
import org.dlw.ai.blackboard.util.ReflectionUtil;
import org.dlw.ai.blackboard.util.SentenceUtil;
import org.dlw.ai.blackboard.util.UniversalContext;

/**
 * The KnowledgeSourceUtil class is used to provide static methods to stage-load
 * data into all KnowledgeSources. This class is not part of the API because it
 * is only used to assist in the implementation of the example cryptogram
 * problem.
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public final class KnowledgeSourceUtil {

    private RuleSetDao dao;

    /**
     * Attribute commons-logging class instance
     */
    private static final Log log = LogFactory.getLog(KnowledgeSourceUtil.class);

    /**
     * Attribute class logger
     */
    private static Logger logger;

    /**
     * Default constructor
     */
    public KnowledgeSourceUtil() {
        dao = (RuleSetDaoHibernate) UniversalContext.getApplicationContext()
                .getBean("ruleSetDao");

    }

    /**
     * @param ks
     *            the {@link org.dlw.ai.blackboard.knowledge.KnowledgeSource}
     * @param name
     *            the String name
     */
    public void loadRuleSet(KnowledgeSource ks, String name) {

        /**
         * Initialize logger
         */
        logger = Logger.getInstance();
        logger.wrap(log);

        /**
         * Create a RuleSet
         */
        RuleSet ruleSet = null;
        try {
            ruleSet = dao.getRuleSetByName(name);
        } catch (RuleSetNameNotFoundException e) {
            logger.info("System error: RuleSet name provided does not exist");
            e.printStackTrace();
        }

        /**
         * Set RuleSet on KnowledgeSource
         */
        ks.setRuleSet(ruleSet);
    }

    /**
     * Public method to consider rules based on
     * {@link org.dlw.ai.blackboard.rule.RuleType}
     * 
     * @param ks
     *            the {@link KnowledgeSource}
     * @param sentence
     *            the {@link org.dlw.ai.blackboard.domain.Sentence} object
     */
    public static List<String> considerRules(KnowledgeSource ks) {
        
        ArrayList<String> msgs = new ArrayList<String>();
        
        RuleSet set = ks.getRuleSet();
        
        List<Rule> rules = set.getRules();

        for (int i = 0; i < rules.size(); i++) {
            Rule rule = rules.get(i);

            Antecedent antecedent = rule.getAntecedent();
            Consequent consequent = rule.getConsequent();

            String ruleType = rule.getRuleType();

            if (ruleType.equals(RuleType.METHOD)) {
                processMethodRule(antecedent, consequent);
            }

            if (ruleType.equals(RuleType.CONVERSION)) {
                Blackboard blackboard = (Blackboard) UniversalContext.getApplicationContext()
                .getBean("blackboard");
                Sentence sentence = blackboard.getSentence();
               
                processConversionRule(sentence, rule, ks);
            }
        }
        
        return msgs;
    }

    /**
     * Private method to process a method rule
     * 
     * @param antecedent
     *   the {@link org.dlw.ai.blackboard.domain.Antecedent} reference
     * @param consequent
     *   the {@link org.dlw.ai.blackboard.domain.Consequent} reference
     */
    private static void processMethodRule(Antecedent antecedent,
            Consequent consequent) {
        if (ReflectionUtil.isAntecedent(antecedent.getFullyQualifiedClass(),
                antecedent.getMethodName())) {

            ReflectionUtil.execConsequent(consequent.getFullyQualifiedClass(),
                    consequent.getMethodName());
        }
    }

    /**
     * Private method to process a direct cipher letter conversion rule
     * 
     * @param sentence
     *   the {@link org.dlw.ai.blackboard.domain.Sentence} reference
     * @param rule
     *   the {@link org.dlw.ai.blackboard.rule.Rule} reference
     * @param ks
     *   the {@link org.dlw.ai.blackboard.knowledge.KnowledgeSource} reference
     */
    private static void processConversionRule(Sentence sentence, Rule rule,
            KnowledgeSource ks) {
        List<Word> words = SentenceUtil.getWords(sentence);
        List<Letter> letters;

        for (Word word : words) {
            letters = SentenceUtil.getLetters(word);

            String cipher = rule.getBefore();
            String plainText = rule.getAfter();

            for (Letter letter : letters) {

                if (letter.value().equals(cipher)) {
                    makeAssertion(ks, cipher, plainText);
                }
            }
        }

    }

    /**
     * Private method to store an assertion
     * 
     * @param ks
     *            the {@link KnowledgeSource} object
     * @param cipher
     *            the String cipher letter
     * @param plainText
     *            the String plain text letter
     */
    private static void makeAssertion(KnowledgeSource ks, String cipher,
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