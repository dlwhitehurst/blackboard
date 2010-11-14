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
package org.dlw.ai.blackboard.rule;

/**
 * This class defines static string names for different types of Rules.  These
 * types are each evaluated differently based on the type of information the 
 * Rule object holds.
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 *
 */
public final class RuleType {

    /**
     * Hidden constructor
     */
    private RuleType() {
    }
    
    /**
     * A method rule
     */
    public static final String METHOD = "method";
    
    /**
     * A conversion rule
     */
    public static final String CONVERSION = "conversion";
    
    /**
     * A regular expression rule
     */
    public static final String REGEX = "regex";
    
}
