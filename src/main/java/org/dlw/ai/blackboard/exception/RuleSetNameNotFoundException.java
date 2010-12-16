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
package org.dlw.ai.blackboard.exception;

/**
 * This class is used to represent an exception where the {@link org.dlw.ai.blackboard.rule.RuleSet}
 * being searched does not exist.
 * 
 * @author @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
 */
public class RuleSetNameNotFoundException extends Exception {

    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = -8771263652269086292L;

    /**
     * Constructor
     * @param err
     *   the string error to be propagated.
     */
    public RuleSetNameNotFoundException(String err) {
        super(err);
    }

}
