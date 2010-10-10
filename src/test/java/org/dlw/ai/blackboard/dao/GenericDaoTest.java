package org.dlw.ai.blackboard.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.dao.hibernate.GenericDaoHibernate;
import org.dlw.ai.blackboard.rule.RuleSet;
import org.hibernate.SessionFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDaoTest extends BaseDaoTestCase {
    Log log = LogFactory.getLog(GenericDaoTest.class);
    GenericDao<RuleSet, Long> genericDao;
    @Autowired
    SessionFactory sessionFactory;

    @Before
    public void setUp() {
        genericDao = new GenericDaoHibernate<RuleSet, Long>(RuleSet.class, sessionFactory);
    }

    @Test
    public void getRuleSet() {
        RuleSet ruleSet = genericDao.get(-1L);
        assertNotNull(ruleSet);
        assertEquals("PatternMatching",ruleSet.getName());
    }
}
