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
package org.dlw.ai.blackboard.knowledge;

/**
 * The KnowledgeSources interface represents some form of collections object that is
 * used to hold individual or unique {@link KnowSource} objects.  A reset and load method
 * signature are provided so that the developer can choose a collection type based on
 * her requirements and handle these operations through implementation.
 * 
 * @author dlwhitehurst
 * @version 1.0.0-RC
 * 
 */
public interface KnowledgeSources {

    /**
     * This method is used to flush, clear, reset, or null the knowledge sources
     * collection
     */
    void reset();

    /**
     * This method is used to fill the knowledge sources collection with
     * knowledge sources.
     */
    void loadKnowledgeSources();

}
