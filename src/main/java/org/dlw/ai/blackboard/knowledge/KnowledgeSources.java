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

import org.dlw.ai.blackboard.exception.CollectionLoadingException;
import org.dlw.ai.blackboard.exception.InitializationException;

/**
 * The KnowledgeSources interface represents some form of collections object
 * that is used to hold individual or unique {@link KnowledgeSource} objects. A reset
 * and load method signature are provided so that the developer can choose a
 * collection type based on her requirements and handle these operations through
 * implementation.
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public interface KnowledgeSources {

    /**
     * Load and initialize knowledge sources
     * 
     * @throws InitializationException
     * @throws CollectionLoadingException
     */
    void init() throws InitializationException, CollectionLoadingException;

    /**
     * Clear, reset, load and initialize the knowledge
     * sources collection
     */
    void reset() throws InitializationException, CollectionLoadingException;

    /**
     * This method is called by init() and reset() to load unique knowledge
     * sources
     */
    void loadKnowledgeSources() throws CollectionLoadingException;

    /**
     * This method is called by init() and reset() to load knowledge sources
     * with attribute data
     * 
     * @throws InitializationException
     */
    void initializeKnowledgeSources() throws InitializationException;

    /**
     * 
     * @param knowledgeSource
     *   the {@link KnowledgeSource} to activate
     */
    void startKnowledgeSource(KnowledgeSource knowledgeSource);
    
    /**
     * This method is called once when controller begins
     */
    void startAllKnowledgeSources();
    

}
