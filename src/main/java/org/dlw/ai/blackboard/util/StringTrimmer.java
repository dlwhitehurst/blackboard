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
 * @author dlwhitehurst
 *
 */
public final class StringTrimmer {

	private StringTrimmer() { 
		// non-accessible default constructor
	} 
	
	/* remove leading whitespace */
	/**
	 * TODO - comment
	 */
    public static String ltrim(String source) {
        return source.replaceAll("^\\s+", "");
    }

    /* remove trailing whitespace */
    /**
     * TODO - comment
     */
    public static String rtrim(String source) {
        return source.replaceAll("\\s+$", "");
    }

    /* replace multiple whitespaces between words with single blank */
    /**
     * TODO - comment
     */
    public static String itrim(String source) {
        return source.replaceAll("\\b\\s{2,}\\b", " ");
    }

    /* remove all superfluous whitespaces in source string */
    /**
     * TODO - comment
     */
    public static String trim(String source) {
        return itrim(ltrim(rtrim(source)));
    }

    /**
     * TODO- comment
     * @param source
     * @return
     */
    public static String lrtrim(String source){
        return ltrim(rtrim(source));
    }

}
