/**
 * 
 */
package org.dlw.ai.blackboard;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.dlw.ai.blackboard.domain.BlackboardObject;
import org.dlw.ai.blackboard.domain.CipherLetter;
import org.dlw.ai.blackboard.domain.Sentence;
import org.dlw.ai.blackboard.domain.Word;
import org.dlw.ai.blackboard.util.UniversalContext;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dlwhitehurst
 *
 */
public class BlackboardTest {

    private Blackboard blackboard;
    private int count = 0;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        blackboard = (Blackboard) UniversalContext.getApplicationContext()
        .getBean("blackboard");
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
                    org.dlw.ai.blackboard.domain.CipherLetter.class)) {
                CipherLetter letter = (CipherLetter) obj;
                System.out.println("LETTER: " + letter.value());
            }
        }
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

}
