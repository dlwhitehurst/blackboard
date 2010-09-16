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
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.dlw.ai.blackboard.domain.Antecedent;
import org.dlw.ai.blackboard.domain.Assertion;
import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.domain.CipherLetter;
import org.dlw.ai.blackboard.domain.Consequent;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.domain.Word;
import org.dlw.ai.blackboard.knowledge.InferenceEngine;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceConstants;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceUtil;
import org.dlw.ai.blackboard.rule.Rule;
import org.dlw.ai.blackboard.rule.RuleType;
import org.dlw.ai.blackboard.util.MessageConstants;
import org.dlw.ai.blackboard.util.ReflectionUtil;
import org.dlw.ai.blackboard.util.SentenceUtil;

/**
 * @author dlwhitehurst
 * @version 1.0.0-RC
 * 
 */
public class SolvedKnowledgeSource extends SentenceKnowledgeSource implements
        InferenceEngine {

    private ArrayList<Rule> rules = new ArrayList<Rule>();
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((rules == null) ? 0 : rules.hashCode());
        return result;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        SolvedKnowledgeSource other = (SolvedKnowledgeSource) obj;
        if (rules == null) {
            if (other.rules != null)
                return false;
        } else if (!rules.equals(other.rules))
            return false;
        return true;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.dlw.ai.blackboard.knowledge.SentenceKnowledgeSource#toString()
     */
    @Override
    public String toString() {
        return KnowledgeSourceConstants.SOLVED_KNOWLEDGE_SOURCE;
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#reset()
     */
    @Override
    public void reset() {
        // TODO Auto-generated method stub
        super.reset();
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.SentenceKnowledgeSource#evaluate(org.dlw.ai.blackboard.domain.Sentence)
     */
    @Override
    public void evaluate(Sentence sentence) {
        List<Rule> rules = this.getRules();

        for (Rule rule : rules) {
            Antecedent antecedent = rule.getAntecedent();
            Consequent consequent = rule.getConsequent();
            RuleType ruleType = rule.getRuleType();

            switch (ruleType) {

            case METHOD:
                if (ReflectionUtil.isAntecedent(antecedent
                        .getFullyQualifiedClass(), antecedent.getMethodName())) {

                    KnowledgeSourceUtil.evaluationResponse(this,
                            MessageConstants.SENTENCE_SOLVED);
                    
                    ReflectionUtil.execConsequent(consequent
                            .getFullyQualifiedClass(), consequent
                            .getMethodName());
                }
                break;

            case CONVERSION:
                List<Word> words = SentenceUtil.getWords(sentence);
                List<CipherLetter> letters;

                for (Word word : words) {
                    letters = SentenceUtil.getLetters(word);

                    for (CipherLetter letter : letters) {
                        for (Rule convRule : rules) {

                            String cipher = convRule.getBefore();
                            String plainText = convRule.getAfter();

                            if (letter.value().equals(cipher)) {
                                makeAssertion(cipher, plainText);
                                Assertion assertion = new Assertion();
                                assertion.setCipherLetter(cipher);
                                assertion.setPlainLetter(plainText);
                                assertion
                                        .setReason(MessageConstants.SUBSTITUTION_ASSERT);

                                Stack<Assumption> stack = letter
                                        .getAffirmation().getStatements();
                                stack.add(assertion);
                                KnowledgeSourceUtil.evaluationResponse(this,
                                        MessageConstants.SUBSTITUTION_ASSERT
                                                + antecedent + " = "
                                                + consequent + ".");
                            }
                        }

                    }
                }

                break;

            }

        }
    }

    /**
     * Private method to store an assertion
     * 
     * @param antecedent
     * @param consequent
     */
    private void makeAssertion(String cipher, String plainText) {

        /**
         * Create and load an Assertion
         */
        Assertion assertion = new Assertion();
        assertion.setCipherLetter(cipher);
        assertion.setPlainLetter(plainText);
        assertion.setReason("An assertion was given to describe a direct substitution.");

        /**
         * Create a data-structure to hold Assumptions
         */
        ConcurrentLinkedQueue<Assumption> queue = new ConcurrentLinkedQueue<Assumption>();

        /**
         * Load our Assertion
         */
        queue.add(assertion);

        /**
         * Add Assumption/Assertion queue to this specific knowledge source
         */
        this.setPastAssumptions(queue);

    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dlw.ai.blackboard.knowledge.primitive.LetterKnowledgeSource#loadRules
     * (java.util.ArrayList)
     */
    @Override
    public void loadRules(ArrayList<Rule> rules) {
        this.setRules(rules);
    }

    /**
     * @return the rules
     */
    public ArrayList<Rule> getRules() {
        return rules;
    }

    /**
     * @param rules the rules to set
     */
    public void setRules(ArrayList<Rule> rules) {
        this.rules = rules;
    }

}
