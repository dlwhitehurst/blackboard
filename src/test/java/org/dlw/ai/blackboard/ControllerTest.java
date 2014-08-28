package org.dlw.ai.blackboard;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.dlw.ai.blackboard.knowledge.KnowledgeSourcesImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 */
public class ControllerTest {

    private Controller controller;

    @Before
    public void setUp() throws Exception {
        controller = BlackboardContext.getInstance().getController();

    }

    @Test
    public void engageTest() throws AssertionError {
        controller.engage(); // load KnowledgeSources
        assertNotNull(controller.getKnowledgeSources());

        KnowledgeSourcesImpl kss = (KnowledgeSourcesImpl) controller
                .getKnowledgeSources();
        int count = kss.size();

        assertTrue(count == 13);
    }
}
