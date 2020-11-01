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
package org.dlw.ai.blackboard.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.Blackboard;
import org.dlw.ai.blackboard.domain.Alphabet;
import org.dlw.ai.blackboard.domain.Assertion;
import org.dlw.ai.blackboard.domain.BlackboardObject;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.domain.Word;

/**
 * This class is used to provide utility functions for the blackboard object.
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 */
public final class BlackboardUtil {

    /**
     * Commons logging class instance
     */
    private static final Log log = LogFactory.getLog(BlackboardUtil.class);

    /**
     * Public method to output all flat-hierarchy blackboard objects
     * 
     * @param blackboard
     */
    public static void outputSnapshot(Blackboard blackboard) {

        log.debug("-----------------------------------------------------------------------------");
        log.debug("-- BLACKBOARD SNAPSHOT " + TimeRecordUtil.getTimeStamp());
        log.debug("-----------------------------------------------------------------------------");
        
        for (BlackboardObject obj : blackboard) {

            if (obj.getClass().equals(
                    org.dlw.ai.blackboard.domain.Sentence.class)) {
                Sentence sentence = (Sentence) obj;
                log.debug("SENTENCE: " + sentence.value());
            }
            
            if (obj.getClass().equals(
                    org.dlw.ai.blackboard.domain.Word.class)) {
                Word word = (Word) obj;
                log.debug("WORD: " + word.value());
            }
            
            if (obj.getClass().equals(
                    org.dlw.ai.blackboard.domain.Alphabet.class)) {
                Alphabet cipherLetter = (Alphabet) obj;
                log.debug("CIPHER: " + cipherLetter.getCipherLetter());
            }
            
            if (obj.getClass().equals(
                    org.dlw.ai.blackboard.domain.Alphabet.class)) {
                Alphabet alphabet = (Alphabet) obj;
                log.debug("ALPHABET: " + alphabet.getCipherLetter() + "=" + alphabet.getPlainLetter());
            }

            if (obj.getClass().equals(
                    org.dlw.ai.blackboard.domain.Assertion.class)) {
                Assertion assertion = (Assertion) obj;
                log.debug("ASSUMPTION: (retractable=" + assertion.isRetractable() + ") " + assertion.getReason());
            }
        
        }
        
        log.debug("-----------------------------------------------------------------------------");
        
    }

    /**
     * Public method to output the sentence and underline any corrected cipher
     * letters. Also any letters that are underlined are plaintext letters
     * (Alphabets) and also Affirmations exist in blackboard problem domain.
     */
    public static void outputProgress(Blackboard blackboard) {

        /**
         * Timestamp
         */
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
        
        Sentence sentence = null;
        
        for (BlackboardObject obj : blackboard) {
            if (obj.getClass().equals(
                    org.dlw.ai.blackboard.domain.Sentence.class)) {
                sentence = (Sentence) obj;
            }
        }

        log.debug("-----------------------------------------------------------------------------");
        log.debug("-- THE BLACKBOARD " + currentTimestamp);
        log.debug("-----------------------------------------------------------------------------");
        
        log.debug("ORIGINAL: " + sentence.value());

        String markers = getAffirmationMarkings(sentence);

        /**
         * Use this to show that no markers exist
         */
        if (markers.equals("")) {
            markers = "___________________________";
        }

        log.debug("PROGRESS: " + markers);
        log.debug("-----------------------------------------------------------------------------");

    }
    

    /**
     * Private method to get affirmation markings for console output line below
     * working sentence
     * 
     * @param sentence
     * @return a special string of underscores
     */
    private static String getAffirmationMarkings(Sentence sentence) {

        String markerLine = "";
        int wordcount = 0;
        int loopcount = 0;

        List<Word> words = sentence.getWords();
        wordcount = words.size();

        for (Word word : words) {

            List<Alphabet> list = word.getLetters();

            for (Alphabet letter : list) {
                if (letter.getAffirmations().getSolvedLetter() != null) {
                        // affirmation and we have an assertion
                        markerLine = markerLine.concat(letter.getAffirmations().getSolvedLetter().getPlainLetter()); // was underscore
                    } else {
                        markerLine = markerLine.concat(letter.getPlainLetter()); // was space
                    }
            }
            if (loopcount < wordcount) {
                markerLine = markerLine.concat(" ");
            }
            loopcount++;

        }
        return markerLine;
    }

    /**
     * Public method to get assertion statements
     * 
     * @param blackboard {@link org.dlw.ai.blackboard.Blackboard} reference
     * @return a list of {@link org.dlw.ai.blackboard.domain.Assertion}(s)
     */
    public static List<Assertion> getAssertionStatements(Blackboard blackboard) {
        ArrayList<Assertion> assertions = new ArrayList<Assertion>();
        for (BlackboardObject obj : blackboard) {
            if (obj.getClass().equals(
                    org.dlw.ai.blackboard.domain.Assertion.class)) {
                Assertion assertion = (Assertion) obj;
                if (!assertion.isRetractable()) {
                    assertions.add(assertion);
                }
            }
        }
        
        return assertions;
    }
    
}
