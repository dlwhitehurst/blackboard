package org.dlw.ai.blackboard.rule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RuleFactory {

    /**
     * Commons logging class instance
     */
    private final static Log log = LogFactory.getLog(RuleFactory.class);

    private RuleFactory() { }
    
    public static void createRule(RuleType type) {
       
        switch (type) {
            case SINGLE_LETTER: log.info("SINGLE_LETTER passed");
                
            case DOUBLE_LETTER: log.info("DOUBLE_LETTER passed");
            
            default:
                
        }
    }

}
