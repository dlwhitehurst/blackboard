/**
 * 
 */
package org.dlw.ai.blackboard;

import org.dlw.ai.blackboard.util.UniversalContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author dlwhitehurst
 * 
 */
public class CryptographerTest {

    private Cryptographer cryptographer;
    private Controller controller;
    private Blackboard blackboard;
    private Brain brain;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        cryptographer = (Cryptographer) UniversalContext
                .getApplicationContext().getBean("cryptographer");
    }

    @Test
    public void getBlackboard() throws AssertionError {
        blackboard = cryptographer.getBlackboard();
        assertNotNull(blackboard);
        assertTrue(blackboard instanceof org.dlw.ai.blackboard.Blackboard);
    }

    @Test
    public void getController() throws AssertionError {
        controller = cryptographer.getController();
        assertNotNull(controller);
        assertTrue(controller instanceof org.dlw.ai.blackboard.Controller);
    }

    @Test
    public void getBrain() throws AssertionError {
        brain = cryptographer.getBrain();
        assertNotNull(brain);
        assertTrue(brain instanceof org.dlw.ai.blackboard.Brain);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

}
