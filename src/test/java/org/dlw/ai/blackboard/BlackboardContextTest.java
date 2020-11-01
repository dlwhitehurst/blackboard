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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dlwhitehurst
 * @version 1.0.0
 */
public class BlackboardContextTest {

    private Blackboard blackboard;
    private Controller controller;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

        blackboard = BlackboardContext.getInstance().getBlackboard();
        controller = BlackboardContext.getInstance().getController();
    }

    @Test
    public void testGetBlackboard() throws AssertionError {
        assertNotNull(blackboard);
    }


    @Test
    public void testGetController() throws AssertionError {
        assertNotNull(controller);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

}
