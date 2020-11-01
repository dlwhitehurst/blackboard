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
package org.dlw.ai.blackboard.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.dlw.ai.blackboard.knowledge.KnowledgeSource;
import org.dlw.ai.blackboard.util.DirectionConstants;

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
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0
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
     *    the {@link org.dlw.ai.blackboard.knowledge.KnowledgeSource} reference
     * @return true if success
     */
    public boolean addReference(KnowledgeSource ref) {
        return references.add(ref);
    }

    /**
     * Public method to return the number of knowledge source references
     * 
     * @return integer number of references
     */
    public int numberOfReferences() {
        return references.size();
    }

    /**
     * Public method to remove a knowledge source reference
     * 
     * @param ref
     *   the {@link org.dlw.ai.blackboard.knowledge.KnowledgeSource} reference
     * @return true if success
     */
    public boolean removeReference(KnowledgeSource ref) {
        return references.remove(ref);
    }

    public void notify(String direction, Assumption statement) {
        
        /**
         * Forward chaining Knowledge Sources
         */
        if (direction.equals(DirectionConstants.FORWARD)) {
            for (KnowledgeSource knowledgeSource : references) {
                knowledgeSource.getPastAssumptions().add(statement);
            }
        }
        
        /**
         * Reverse chaining Knowledge Sources
         */
        if (direction.equals(DirectionConstants.REVERSE)) {
            for (KnowledgeSource knowledgeSource : references) {
                ConcurrentLinkedQueue<Assumption> queue = knowledgeSource.getPastAssumptions();
                Iterator<Assumption> iter = queue.iterator();
                while (iter.hasNext()) {
                    Assumption stmt = (Assumption) iter.next();
                    if (stmt.equals(statement)) {
                        iter.remove();
                    }
                }
            }
        } 
    }

}
