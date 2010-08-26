package org.dlw.ai.blackboard.rule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceConstants;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceType;

/**
 * 
 * @author dlwhitehurst
 * @version 1.0.0-RC
 *
 */
public class RuleFactory {

    /**
     * Commons logging class instance
     */
    private final static Log log = LogFactory.getLog(RuleFactory.class);

    private RuleFactory() { }
    
    public static Rule createRule(KnowledgeSourceType type) {
        
        Rule rule = new Rule();
        
        switch (type) {
        
            case COMMON_PREFIX_KNOWLEDGE_SOURCE: 
                log.info("Creating " + KnowledgeSourceConstants.COMMON_PREFIX_KNOWLEDGE_SOURCE + " rule.");
                
            case COMMON_SUFFIX_KNOWLEDGE_SOURCE: 
                log.info("Creating " + KnowledgeSourceConstants.COMMON_SUFFIX_KNOWLEDGE_SOURCE + " rule.");
            
            default: log.info("Default nothing doh!");
                
        }
        return rule; 
    }

}
