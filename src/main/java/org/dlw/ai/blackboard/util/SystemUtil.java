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
package org.dlw.ai.blackboard.util;

/**
 * This utility class provides runtime thread processes for audible system output in
 * addition to console or file level logging. 
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public final class SystemUtil {

    /**
     * Public method to provide vocal responses during system interactions
     * 
     * @param message
     * @param who
     */
    public static void say(String message, String who) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("say -v " + who + " " + message);

            pause(20000);
            
            int exitVal = proc.exitValue();
            System.out.println("Process exitValue: " + exitVal);

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    /**
     * Public method to provide delay between threads
     * 
     * @param time
     */
    public static void pause(long time) {
        try {
            Thread.sleep(time);

        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
    }
    
 }
