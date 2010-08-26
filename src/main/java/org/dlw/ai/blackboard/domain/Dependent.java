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
package org.dlw.ai.blackboard.domain;

import java.util.ArrayList;
import java.util.List;

import org.dlw.ai.blackboard.knowledge.KnowledgeSource;

/**
 * <p>
 * This abstract class Dependent is used to model a host of knowledge sources
 * that pertain or apply to any Blackboard object. This class is used with the
 * default implementation of the blackboard system here and could be used in
 * other design scenarios.
 * </p>
 * 
 * <blockquote><i>Dependent - "(def.) relying on or contingent upon existential
 * support or other context to define its meaning, structure, behavior, or
 * definition"</i></blockquote>
 * 
 * @author dlwhitehurst
 * @version 1.0.0-RC
 * 
 */
public abstract class Dependent {

    /**
     * Attribute collection of participating experts, thinkers, or general
     * consults.
     */
    protected List<KnowledgeSource> references = new ArrayList<KnowledgeSource>();

    /**
     * Public method to add a new knowledge source reference
     * 
     * @param ref
     * @return
     */
    public boolean addReference(KnowledgeSource ref) {
        return references.add(ref);
    }

    /**
     * Public method to return the number of knowledge source references
     * 
     * @return
     */
    public int numberOfReferences() {
        return references.size();
    }

    /**
     * Public method to remove a knowledge source reference
     * 
     * @param ref
     * @return
     */
    public boolean removeReference(KnowledgeSource ref) {
        return references.remove(ref);
    }

    public abstract void notifyDependents();

}
