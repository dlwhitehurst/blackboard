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
