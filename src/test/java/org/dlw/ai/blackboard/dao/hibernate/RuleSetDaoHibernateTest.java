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
package org.dlw.ai.blackboard.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.dlw.ai.blackboard.dao.BaseDaoTestCase;
import org.dlw.ai.blackboard.dao.RuleSetDao;
import org.dlw.ai.blackboard.rule.Antecedent;
import org.dlw.ai.blackboard.rule.Consequent;
import org.dlw.ai.blackboard.rule.Rule;
import org.dlw.ai.blackboard.rule.RuleSet;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 */
public class RuleSetDaoHibernateTest extends BaseDaoTestCase {

    @Autowired
    private RuleSetDao dao;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetRuleSets() throws Exception {
        List<RuleSet> ruleSets = dao.getRuleSets();
        assertNotNull(ruleSets);
        assertEquals(13, ruleSets.size());
        RuleSet ruleSet = ruleSets.get(0);
        assertTrue(ruleSet.getName().equals("CommonPrefix"));
    
    }

    @Test
    public void testGetRuleSetByName() throws Exception {
        RuleSet ruleSet = dao.getRuleSetByName("LegalString");
        assertNotNull(ruleSet);
        assertTrue(ruleSet.getName().equals("LegalString"));
        
    }

    @Test
    public void testGetAntecendentAndConsequent() throws Exception {
        RuleSet ruleSet = dao.getRuleSetByName("Solved");
        assertNotNull(ruleSet);
        
        List<Rule> rules = ruleSet.getRules();
        Rule rule = rules.get(0);
        
        Antecedent antecedent = rule.getAntecedent();
        Consequent consequent = rule.getConsequent();
        
        assertTrue(antecedent.getFullyQualifiedClass().equals("org.dlw.ai.blackboard.Blackboard"));
        assertTrue(antecedent.getMethodName().equals("isSolved"));

        assertTrue(consequent.getFullyQualifiedClass().equals("org.dlw.ai.blackboard.Controller"));
        assertTrue(consequent.getMethodName().equals("done"));
        
    }
    
}
