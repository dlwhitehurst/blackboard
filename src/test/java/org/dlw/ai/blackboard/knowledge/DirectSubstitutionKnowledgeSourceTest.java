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
package org.dlw.ai.blackboard.knowledge;

import org.dlw.ai.blackboard.exception.CollectionLoadingException;
import org.dlw.ai.blackboard.exception.InitializationException;
import org.dlw.ai.blackboard.rule.RuleSet;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 */
public class DirectSubstitutionKnowledgeSourceTest {

    private KnowledgeSource knowledgeSource;

    @Before
    public void setUp() throws Exception {
        KnowledgeSourcesImpl knowledgeSources = new KnowledgeSourcesImpl();

        try {
            knowledgeSources.loadKnowledgeSources();
        } catch (CollectionLoadingException e) {
            e.printStackTrace();
        }

        try {
            // loads rule sets and priorities
            knowledgeSources.initializeKnowledgeSources();
        } catch (InitializationException e) {
            e.printStackTrace();
        }

        Collections.sort(knowledgeSources);
        knowledgeSource = (KnowledgeSource) knowledgeSources.get(1);

        RuleSet ruleset = knowledgeSource.getRuleSet(); // DirectSubstitution

    }

    @Test
    public void testEvaluate() throws AssertionError {

        // This knowledge source will make an assertion statement, non-retractable during evaluation.
        knowledgeSource.evaluate();

        assertNotNull(knowledgeSource.getPastAssumptions());
        assertEquals(1, knowledgeSource.getPastAssumptions().size());
        assertFalse(knowledgeSource.getPastAssumptions().remove().isRetractable());

    }
}
