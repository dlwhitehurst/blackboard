/**
 * Copyright 2010 David L. Whitehurst
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
package org.dlw.ai.blackboard.knowledge;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * @author @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 *
 */
public class KnowledgeSourcesTest {

    private KnowledgeSourcesImpl knowledgeSources;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        knowledgeSources = new KnowledgeSourcesImpl();
    }
    
    @Test
    public void testKnowledgeSourcesCreation() throws AssertionError {
        assertNotNull(knowledgeSources);
    }

}
