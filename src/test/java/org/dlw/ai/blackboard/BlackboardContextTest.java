package org.dlw.ai.blackboard;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dlwhitehurst
 * 
 */
public class BlackboardContextTest {

    private Blackboard blackboard;
    private Controller controller;
    private Brain brain;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

        blackboard = BlackboardContext.getInstance().getBlackboard();
        controller = BlackboardContext.getInstance().getController();
        brain = BlackboardContext.getInstance().getBrain();
    }

    @Test
    public void testGetBlackboard() throws AssertionError {
        assertNotNull(blackboard);
    }


    @Test
    public void testGetController() throws AssertionError {
        assertNotNull(controller);
    }

    @Test
    public void testGetBrain() throws AssertionError {
        assertNotNull(brain);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

}
