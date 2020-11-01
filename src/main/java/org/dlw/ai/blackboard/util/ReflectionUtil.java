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


package org.dlw.ai.blackboard.util;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 */
public final class ReflectionUtil {
    
    public static boolean isAntecedent(String fqObj, String method) {
        Boolean output = null;
        try {
            Class<?> cl=Class.forName(fqObj);
            Method mthd=cl.getMethod(method);
            output=(Boolean) mthd.invoke(cl.newInstance());
          } catch (Exception e) {
            e.printStackTrace();
          }
        return output.booleanValue();     
    }
    
    public static void execConsequent(String fqObj, String method) {
        try {
            Class<?> cl=Class.forName(fqObj);
            Method mthd=cl.getMethod(method);
            mthd.invoke(cl.newInstance());
          } catch (Exception e) {
            e.printStackTrace();
          }
    }
    
    public static void addPath(String s) throws Exception {
    	File f = new File(s);
    	@SuppressWarnings("deprecation")
		URL u = f.toURL();
    	
    	URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
    	Class urlClass = URLClassLoader.class;
    	Method method = urlClass.getDeclaredMethod("addURL", new Class[]{URL.class});
    	method.setAccessible(true);
    	method.invoke(urlClassLoader, new Object[]{u});
    		
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
          System.out.println(isAntecedent("org.dlw.blackboard.Blackboard", "isSolved"));
    }

}
