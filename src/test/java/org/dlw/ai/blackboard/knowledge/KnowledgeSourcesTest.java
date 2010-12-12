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
import static org.junit.Assert.assertTrue;

import org.dlw.ai.blackboard.exception.CollectionLoadingException;
import org.dlw.ai.blackboard.exception.InitializationException;
import org.dlw.ai.blackboard.rule.RuleSet;
import org.dlw.ai.blackboard.util.RuleSetConstants;
import org.junit.Before;
import org.junit.Test;

/**
 * @author @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 *
 */
public class KnowledgeSourcesTest {

    private KnowledgeSourcesImpl knowledgeSources;
    
    @Before
    public void setUp() throws Exception {
        knowledgeSources = new KnowledgeSourcesImpl();
    }

    @Test
    public void testKnowledgeSourcesCreation() throws AssertionError {
        assertNotNull(knowledgeSources);
    }

    @Test
    public void testKnowledgeSourcesInitialization() throws AssertionError {

        try {
            knowledgeSources.loadKnowledgeSources();
        } catch (CollectionLoadingException e) {
            e.printStackTrace();
        }
        
        // not empty
        assertTrue(knowledgeSources.isEmpty() == false);
        
        // contains 13 knowledge sources
        assertTrue(knowledgeSources.size() == 13);
    }
    
    @Test
    public void testKnowledgeSourcesRuleSetLoading() throws AssertionError {

        try {
            knowledgeSources.loadKnowledgeSources();
        } catch (CollectionLoadingException e) {
            e.printStackTrace();
        }
        
        assertNotNull(knowledgeSources);
        
        try {
            // loads rule sets and priorities
            knowledgeSources.initializeKnowledgeSources();
        } catch (InitializationException e) {
            e.printStackTrace();
        }
       
        KnowledgeSource ks = (KnowledgeSource) knowledgeSources.get(0);
        assertNotNull(ks);
        
        RuleSet rules = ks.getRuleSet();
        assertNotNull(rules);
        
        String name = rules.getName();
        
        assertTrue(name.equals(RuleSetConstants.SOLVED));
        
        assertTrue(ks.getPriority() == 1);
    }

}
