package org.dlw.ai.blackboard;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.dlw.ai.blackboard.knowledge.primitive.KnowledgeSourcesImpl;
import org.dlw.ai.blackboard.util.UniversalContext;
import org.junit.Before;
import org.junit.Test;

public class BrainTest {

    private Brain brain;

    @Before
    public void setUp() throws Exception {
        brain = (Brain) UniversalContext.getApplicationContext().getBean(
                "brain");

    }

    @Test
    public void engageTest() throws AssertionError {
        brain.engage(); // load KnowledgeSources
        assertNotNull(brain.getKnowledgeSources());

        KnowledgeSourcesImpl kss = (KnowledgeSourcesImpl) brain
                .getKnowledgeSources();
        int count = kss.size();

        assertTrue(count == 13);
    }
}
