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

import java.util.List;
import java.util.Map;

import org.dlw.ai.blackboard.dao.RuleSetDao;
import org.dlw.ai.blackboard.exception.RuleSetNameNotFoundException;
import org.dlw.ai.blackboard.rule.RuleSet;

/**
 * @author @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 *
 */
public class RuleSetDaoHibernate extends GenericDaoHibernate<RuleSet, Long> implements RuleSetDao {

    /**
     * Constructor, sets class object (dao subject) to RuleSet
     */
    public RuleSetDaoHibernate() {
        super(RuleSet.class);
    }
    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.dao.RuleSetDao#getRuleSets()
     */
    @SuppressWarnings("unchecked")
    public List<RuleSet> getRuleSets() {
        return getHibernateTemplate().find("from RuleSet r order by upper(r.name)");
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.dao.RuleSetDao#loadRuleSetByName(java.lang.String)
     */
    public RuleSet loadRuleSetByName(String name)
            throws RuleSetNameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.dao.RuleSetDao#saveRuleSet(org.dlw.ai.blackboard.rule.RuleSet)
     */
    public RuleSet saveRuleSet(RuleSet ruleSet) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.dao.GenericDao#exists(java.io.Serializable)
     */
    public boolean exists(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.dao.GenericDao#findByNamedQuery(java.lang.String, java.util.Map)
     */
    public List<RuleSet> findByNamedQuery(String queryName,
            Map<String, Object> queryParams) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.dao.GenericDao#get(java.io.Serializable)
     */
    public RuleSet get(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.dao.GenericDao#getAll()
     */
    public List<RuleSet> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.dao.GenericDao#getAllDistinct()
     */
    public List<RuleSet> getAllDistinct() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.dao.GenericDao#remove(java.io.Serializable)
     */
    public void remove(Long id) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.dao.GenericDao#save(java.lang.Object)
     */
    public RuleSet save(RuleSet object) {
        // TODO Auto-generated method stub
        return null;
    }

}
