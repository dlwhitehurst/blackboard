package org.dlw.ai.blackboard.util;

import java.io.IOException;

public class Communications {
    
    private static Communications instance;
    
    /**
     * Hidden constructor
     */
    private Communications() { }
    
    public static Communications getInstance() {
        if (instance == null) {
            instance = new Communications();
        }
        return instance;
    }
    /**
     * Public method to provide info communications verbally using a Macbook
     * @param str
     */
    public void sayMac(final String str) {
        try {
            @SuppressWarnings("unused")
            Process p = Runtime.getRuntime().exec("say " + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
