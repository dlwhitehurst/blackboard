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

import org.dlw.ai.blackboard.dao.RuleSetDao;
import org.dlw.ai.blackboard.exception.RuleSetNameNotFoundException;
import org.dlw.ai.blackboard.rule.RuleSet;

/**
 * @author @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
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
    @SuppressWarnings("unchecked")
    public RuleSet getRuleSetByName(String name)
            throws RuleSetNameNotFoundException {
        List<RuleSet> ruleSet = getHibernateTemplate().find("from RuleSet where name=?", name);
        if (ruleSet == null || ruleSet.isEmpty()) {
            throw new RuleSetNameNotFoundException("name '" + name + "' not found...");
        } else {
            return (RuleSet) ruleSet.get(0);
        }
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.dao.RuleSetDao#saveRuleSet(org.dlw.ai.blackboard.rule.RuleSet)
     */
    public RuleSet saveRuleSet(RuleSet ruleSet) {
        getHibernateTemplate().saveOrUpdate(ruleSet);
        getHibernateTemplate().flush();
        return ruleSet;
    }

    /* (non-Javadoc)
     * @see org.dlw.ai.blackboard.dao.GenericDao#save(java.lang.Object)
     */
    public RuleSet save(RuleSet ruleSet) {
        return this.saveRuleSet(ruleSet);
    }

}
