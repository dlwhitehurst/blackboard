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
package org.dlw.ai.blackboard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.domain.BlackboardObject;
import org.dlw.ai.blackboard.domain.Alphabet;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.domain.Word;
import org.dlw.ai.blackboard.knowledge.KnowledgeSource;
import org.dlw.ai.blackboard.util.BlackboardUtil;
import org.dlw.ai.blackboard.util.MessageConstants;
import org.dlw.ai.blackboard.util.SentenceUtil;
import org.dlw.ai.blackboard.util.StringTrimmer;
import org.dlw.ai.blackboard.util.SystemConstants;

/**
 * This class is where the problem is addressed and solved. The blackboard is
 * the sandbox of the problem domain. This class was derived from the book,
 * Object Oriented Analysis and Design by Grady Booch, however the blackboard
 * model itself was first introduced by ... (add background)
 * 
 * <p>
 * This class is not extendable and therefore not part of the API. Its use is
 * specific to the problem domain being solved by
 * {@link org.dlw.ai.blackboard.Main}.
 * </p>
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 * 
 */
@SuppressWarnings("serial")
public class Blackboard extends ArrayList<BlackboardObject> {

    /**
     * Commons logging class instance
     */
    private final Log log = LogFactory.getLog(Blackboard.class);

    /**
     * Default constructor
     */
    public Blackboard() {
    }

    /**
     * Return decoded sentence
     * 
     * @return {@link org.dlw.ai.blackboard.domain.Sentence} object for the
     *         solution
     * 
     */
    public final Sentence retrieveSolution() {

        /**
         * Protects premature use of method
         */
        if (!isSolved()) {
            return new Sentence(SystemConstants.EARLY_RETRIEVAL_ERROR);
        }

        return getSentence();
    }

    /**
     * Reset the blackboard
     */
    public final void reset() {

        this.clear();

        if (log.isDebugEnabled()) {
            log.debug(MessageConstants.BLACKBOARD_RESET);
        }
    }

    /**
     * Public method used to determine if the blackboard problem is solved
     * 
     * @return boolean primitive
     */
    public final boolean isSolved() {

        boolean result = false;

        Sentence sentence = null;

        /**
         * Search the ArrayList for our sentence
         */
        sentence = getSentence();

        /**
         * If we have a sentence and the sentence is solved, then the blackboard
         * problem is solved.
         */
        if (sentence != null) {
            result = sentence.isSolved();
        }

        return result;

    }

    /**
     * Public boolean method to assert our problem with the blackboard
     * 
     * @param code
     *            the String code or initial cryptogram
     * @return boolean primitive
     */
    public final boolean assertProblem(String code) {

        boolean result = true;

        code = StringTrimmer.trim(code);

        if (code.equals("")) {
            result = false;
        }

        Sentence sentence = new Sentence(code);

        /**
         * Establish initial sentence, word, and letter hierarchy. WARNING: This
         * method should be called after any modification to the blackboard
         * sentence.
         */
        buildSentenceGraph(sentence);

        /**
         * Register the sentence, the words, and each cipher letter with the
         * blackboard. This method adds each domain object to the blackboard
         * object collection or ArrayList<BlackboardObject>
         */
        registerBlackboardObjects(sentence);

        /**
         * Return a true result
         */
        return result;
    }

    private void buildSentenceGraph(Sentence sentence) {

        List<Word> words = SentenceUtil.getWords(sentence);
        sentence.setWords(words);

        for (Word word : words) {
            List<Alphabet> letters = SentenceUtil.getLetters(word);
            word.setLetters(letters);
        }
    }

    /**
     * 
     * @param sentence
     */
    private void registerBlackboardObjects(Sentence sentence) {

        sentence.register();

        List<Word> words = SentenceUtil.getWords(sentence);

        for (Word word : words) {

            word.register();

            List<Alphabet> letters = SentenceUtil.getLetters(word);

            for (Alphabet letter : letters) {
                letter.register();
            }
        }
    }

    /**
     * Public method allowing expert (knowledge source) a chance at the
     * blackboard model to evaluate the problem domain
     * 
     * @param ks
     *            the {@link org.dlw.ai.blackboard.knowledge.KnowledgeSource} at
     *            the board (presently)
     */
    public final void connect(KnowledgeSource ks) {

        ConcurrentLinkedQueue<Assumption> queue = ks.getPastAssumptions();

        if (queue.size() > 0) {

            Assumption assumption = queue.peek();

                /**
                 * Search the ArrayList for our one and only sentence
                 */
                Sentence sentence = getSentence();

                /**
                 * make affirmation statement on letter-stack (push assumptions)
                 */
                updateAffirmations(sentence, assumption);
        }

        //BlackboardUtil.outputSnapshot(this);
        BlackboardUtil.outputProgress(this);

    }

    /**
     * Private method to update blackboard with a new Alphabet when an assertion
     * is given for a particular cipher letter. Also register the assertion
     * (assumption) with the blackboard as well.
     * 
     * @param sentence
     * @param assumption
     */
    private void updateAffirmations(Sentence sentence, Assumption assumption) {

        assumption.register();

        for (Word word : sentence.getWords()) {
            for (Alphabet cipherLetter : word.getLetters()) {
                if (cipherLetter.value().equals(assumption.getCipherLetter())) {
                    cipherLetter.setPlainLetter(assumption.getPlainLetter());
//                    cipherLetter.
//                    Letter alphabet = new Letter(
//                            assumption.getCipherLetter(),
//                            assumption.getPlainLetter());
//                    alphabet.register();

//                    log.info("updateAffirmations-> "
//                            + alphabet.getCipherLetter() + "->"
//                            + alphabet.getPlainLetter() + ": "
//                            + assumption.getReason());

//                    alphabet.getAffirmation().getStatements().push(assumption);
//                    cipherLetter.getAffirmation().setCipherLetter(cipherLetter);
//                    cipherLetter.getAffirmation().setSolvedLetter(alphabet);
                }
            }
        }
    }

    /**
     * Public method to removing expert (knowledge source) from the blackboard
     * model
     * 
     * @param ks
     *            the {@link org.dlw.ai.blackboard.knowledge.KnowledgeSource}
     *            steps back from the board
     */
    public final void disconnect(KnowledgeSource ks) {
        // TODO - pending removal
    }

    /**
     * Public method to get the problem domain sentence
     * 
     * @return String sentence
     */
    public Sentence getSentence() {

        Sentence sentence = null;

        /**
         * Search the ArrayList for our one and only sentence
         */
        for (BlackboardObject obj : this) {
            if (obj.getClass().equals(
                    org.dlw.ai.blackboard.domain.Sentence.class)) {
                sentence = (Sentence) obj;
            }
        }

        return sentence;
    }

    public Sentence getAssumedSentence() {
        Sentence sentence = null;
        sentence = SentenceUtil.getDirtySentence();
        return sentence;
    }
    
    /**
     * This method returns true if a cipher letter exists on the blackboard.
     * 
     * @param letter
     *            the String letter
     * @return a boolean if exists
     */
    public boolean cipherLetterExists(String letter) {

        boolean result = false;

//        for (BlackboardObject obj : this) {
//            if (obj.getClass().equals(
//                    org.dlw.ai.blackboard.domain.CipherLetter.class)) {
//                CipherLetter cipherLetter = (CipherLetter) obj;
//                if (cipherLetter.value().equals(letter)) {
//                    result = true;
//                }
//            }
//        }
        return result;

    }

    /**
     * This method creates a new plain text alphabet to replace the cipher
     * letter and registers itself with the blackboard.
     * 
     * @param cipher
     *            the String cipher letter
     * @param plainText
     *            the String plain text letter
     */
//    public void createAlphabet(String cipher, String plainText) {
//        Letter alphabet = new Letter(cipher, plainText);
//        alphabet.register();
//    }
}
