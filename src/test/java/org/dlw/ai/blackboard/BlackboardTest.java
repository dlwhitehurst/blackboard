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

/**
 * 
 */
package org.dlw.ai.blackboard;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.dlw.ai.blackboard.domain.BlackboardObject;
import org.dlw.ai.blackboard.domain.Alphabet;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.domain.Word;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dlwhitehurst
 * @version 1.0.0
 */
public class BlackboardTest {

    private Blackboard blackboard;
    private int count = 0;
    private int i = 0;
    private int j = 0;
    
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        blackboard = BlackboardContext.getInstance().getBlackboard();
    }
    
    @Test
    public void testAssertProblem() throws AssertionError {
        assertNotNull(blackboard);
        
        blackboard.assertProblem("I HAVE SEEN THE SMALL SHELL");
        for (BlackboardObject obj: blackboard) {
            if (obj.getClass().equals(
                    org.dlw.ai.blackboard.domain.Sentence.class)) {
                Sentence sentence = (Sentence) obj;
                System.out.println("SENTENCE: " + sentence.value());
            }
            if (obj.getClass().equals(
                    org.dlw.ai.blackboard.domain.Word.class)) {
                Word word = (Word) obj;
                System.out.println("WORD: " + word.value());
            }
            if (obj.getClass().equals(
                    org.dlw.ai.blackboard.domain.Alphabet.class)) {
                Alphabet letter = (Alphabet) obj;
                System.out.println("LETTER: " + letter.getCipherLetter());
            }
        }
        
        Sentence sentence = blackboard.getSentence();
        assertTrue(sentence.value() == "I HAVE SEEN THE SMALL SHELL");
        System.out.println(sentence.value());
    }
    
    @Test
    public void testWordCount() throws AssertionError {
        for (BlackboardObject obj: blackboard) {
            if (obj.getClass().equals(
                    org.dlw.ai.blackboard.domain.Word.class)) {
                Word word = (Word) obj;
                System.out.println("WORD: " + word.value());
                count++;
            }
        }
        System.out.println(count);

        assertTrue(count == 6);
    }
    
    @Test
    public void testHierarchy() throws AssertionError {
        Sentence sentence = blackboard.getSentence();
        
        List<Word> words = sentence.getWords();
        for (Word word: words) {
            System.out.println(i + ":" + word.value());
            i++;
            List<Alphabet> letters = word.getLetters();
            for (Alphabet letter: letters) {
                System.out.println(j + ":" + letter.getCipherLetter());
                j++;
            }
        }
        assertTrue(i == 6);

    }
}
