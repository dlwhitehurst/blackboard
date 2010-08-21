/**
 * 
 */
package org.dlw.ai.blackboard.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dlwhitehurst
 * 
 */
public final class UniversalContext {

    private final static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "/application-context.xml");

    private UniversalContext() {
    }

    /**
     * @return the applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
