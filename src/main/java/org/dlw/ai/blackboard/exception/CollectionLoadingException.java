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
 * This class provides an Exception that can be thrown when the loading
 * of objects into a collection fails.
 * 
 * @author dlwhitehurst
 *
 */
public final class CollectionLoadingException extends Exception {

    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = 5789122665313290342L;
    
    /**
     * Constructor
     * @param err
     *   the String error message
     */
    public CollectionLoadingException(String err) {
        super(err);
    }

}
