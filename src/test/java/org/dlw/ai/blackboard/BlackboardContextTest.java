package org.dlw.ai.blackboard;

import static org.junit.Assert.*;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.dlw.ai.blackboard.domain.Assumption;
import org.dlw.ai.blackboard.util.UniversalContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.dlw.ai.blackboard.BlackboardContext;
import org.dlw.ai.blackboard.Blackboard;

/**
 * @author dlwhitehurst
 * 
 */
public class BlackboardContextTest {

    private Blackboard blackboard;
    private Controller controller;
    private BlackboardContext blackboardContext;
    private ConcurrentLinkedQueue<Assumption> pastAssumptions;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

        blackboard = (Blackboard) UniversalContext.getApplicationContext()
                .getBean("blackboard");
        blackboardContext = new BlackboardContext();

        controller = (Controller) UniversalContext.getApplicationContext()
                .getBean("controller");
        blackboardContext = new BlackboardContext();

        pastAssumptions = new ConcurrentLinkedQueue<Assumption>();

    }

    @Test
    public void testSetBlackboard() {
        blackboardContext.setBlackboard(blackboard);
        // should continue
    }

    @Test
    public void testGetBlackboard() throws AssertionError {
        blackboardContext.setBlackboard(blackboard);
        blackboard = blackboardContext.getBlackboard();
        assertNotNull(blackboard);
    }

    @Test
    public void testSetController() {
        blackboardContext.setController(controller);
        // should continue
    }

    @Test
    public void testGetController() throws AssertionError {
        blackboardContext.setController(controller);
        controller = blackboardContext.getController();
        assertNotNull(controller);
    }

    @Test
    public void testSetPastAssumptions() {
        blackboardContext.setPastAssumptions(pastAssumptions);
        // should continue
    }

    @Test
    public void testGetPastAssumtions() throws AssertionError {
        blackboardContext.setPastAssumptions(pastAssumptions);
        pastAssumptions = blackboardContext.getPastAssumptions();
        assertNotNull(pastAssumptions);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

}
