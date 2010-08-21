package org.dlw.ai.blackboard;


import static org.junit.Assert.*;

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
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {

		blackboard = (Blackboard) UniversalContext
		.getApplicationContext().getBean("blackboard");
		blackboardContext = new BlackboardContext();

		controller = (Controller) UniversalContext
		.getApplicationContext().getBean("controller");
		blackboardContext = new BlackboardContext();
		
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
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

}
