package org.dlw.ai.blackboard.rule;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import org.dlw.ai.blackboard.domain.BaseObject;

/**
 * This class represents the collection of similar Rule objects.
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 * 
 */
@Entity
@Table(name = "ruleset")
public class RuleSet extends BaseObject {

    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = 3094361637466019949L;

    /**
     * Attribute id or primary key
     */
    private Long id;

    /**
     * Attribute name of KnowledgeSource (type extension)
     */
    private String name;

    /**
     * Attribute to hold rules for KnowledgeSource
     */
    private List<Rule> rules = new ArrayList<Rule>();

    /**
     * @param rules
     *  the rules to set
     */
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    /**
     * @return the rules
     */
    @OneToMany(mappedBy = "rset",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    public List<Rule> getRules() {
        return rules;
    }

    /**
     * @return a Long integer primary key id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *  the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return a String name for this RuleSet
     */
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    /**
     * @param name
     *  the String name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {

        boolean result = false;

        if (o.getClass().getCanonicalName()
                .equals(this.getClass().getCanonicalName())) {
            RuleSet ruleSet = (RuleSet) o;
            if (ruleSet.getRules().equals(this.getRules())) {
                result = true;
            }
        }

        return result;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return 0;
    }

}
