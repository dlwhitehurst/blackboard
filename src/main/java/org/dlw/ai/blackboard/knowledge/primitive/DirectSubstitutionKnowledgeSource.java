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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.Blackboard;
import org.dlw.ai.blackboard.domain.Affirmation;
import org.dlw.ai.blackboard.domain.Alphabet;
import org.dlw.ai.blackboard.domain.Assertion;
import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.domain.CipherLetter;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.domain.Word;
import org.dlw.ai.blackboard.knowledge.InferenceEngine;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceConstants;
import org.dlw.ai.blackboard.rule.Rule;
import org.dlw.ai.blackboard.util.Logger;
import org.dlw.ai.blackboard.util.SentenceUtil;


/**
 * @author dlwhitehurst
 * @version 1.0.0-RC
 * 
 */
public class DirectSubstitutionKnowledgeSource extends LetterKnowledgeSource implements InferenceEngine {

    private ArrayList<Rule> rules = new ArrayList<Rule>();

    /**
     * Commons logging class instance
     */
    private final Log log = LogFactory.getLog(Blackboard.class);

    /**
     * Attribute class logger
     */
    private Logger logger;
    
    public DirectSubstitutionKnowledgeSource() {

        /**
         * Initialize logger
         */
        logger = Logger.getInstance();
        logger.wrap(log);
        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return KnowledgeSourceConstants.DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE;
    }

    /**
     * Public implementation for this object's evaluation of the sentence on the blackboard
     */
    public void evaluate(Sentence sentence) {

        List<Word> words = SentenceUtil.getWords(sentence);
        List<Rule> rules = this.getRules();
        List<CipherLetter> letters;
        
        for (Word word: words) {
            letters = SentenceUtil.getLetters(word);
            
            for (CipherLetter letter : letters) {
                for (Rule rule : rules) {
                    String antecedent = rule.getAntecedent(); // if letter = W e.g. really just "V"
                    ArrayList<String> consequents = rule.getConsequents();
                    for (String consequent : consequents) {
                        logger.info(letter.value() + " " + antecedent + " " + consequent);
                        if (letter.value().equals(antecedent)) {
                            logger.info("BINGO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            // put letter and consequent in assumptions stack
                            makeAssumption(antecedent, consequent);
                            Assertion assertion = new Assertion();
                            assertion.setCipherLetter(antecedent);
                            assertion.setPlainLetter(consequent);
                            assertion.setReason("This assertion was given as an initial hint.");

                            Stack<Assumption> stack = letter.getAffirmation()
                            .getStatements();
                            stack.add(assertion);
                            
                        }
                    }
                }
                
            }
        }
        
    }

    /**
     * Private method where antecedent and consequent matched
     * 
     * @param antecedent
     * @param consequent
     */
    private void makeAssumption(String antecedent, String consequent) {

        /**
         * Create and load an Assertion
         */
        Assertion assertion = new Assertion();
        assertion.setCipherLetter(antecedent);
        assertion.setPlainLetter(consequent);
        assertion.setReason("This assertion was given as an initial hint.");

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

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.LetterKnowledgeSource#reset()
     */
    @Override
    public void reset() {
        // TODO Auto-generated method stub
        super.reset();
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.LetterKnowledgeSource#loadRules(java.util.ArrayList)
     */
    @Override
    public void loadRules(ArrayList<Rule> rules) {
        this.setRules(rules);
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.knowledge.primitive.LetterKnowledgeSource#notifyDependents(java.lang.String, org.dlw.ai.blackboard.domain.Assumption)
     */
    @Override
    public void notifyDependents(String direction, Assumption statement) {
        // TODO Auto-generated method stub
        super.notifyDependents(direction, statement);
    }

    /**
     * @param rules the rules to set
     */
    public void setRules(ArrayList<Rule> rules) {
        this.rules = rules;
    }

    /**
     * @return the rules
     */
    public ArrayList<Rule> getRules() {
        return rules;
    }

}
