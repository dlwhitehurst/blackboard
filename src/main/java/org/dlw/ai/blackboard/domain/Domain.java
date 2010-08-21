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

/**
 * <p>
 * This class provides a {@link Domain} parent for all
 * {@link org.dlw.ai.blackboard.BlackBoard} object types. The {@link Dependent}
 * interface also can be used to tie the domain objects together and ping all
 * participating references. This is slightly different than Booch's design
 * however it lends itself better I think for reuse and also extension with
 * other problem-solving models.
 * </p>
 * 
 * <blockquote><i>Domain - "(def.) a sphere of activity over which rule or
 * control is exercised. (blackboard objects maybe?)</i></blockquote>
 * 
 * @author dlwhitehurst
 * 
 */
public abstract class Domain extends Universe {

    /**
     * Attribute collection of "participating" experts, thinkers, or general
     * consults.
     */
    protected List<Participant> participantRefs = new ArrayList<Participant>();

    /**
     * Public method to add a participant to our counsel.
     * 
     * @param ref
     * @return
     */
    public boolean addParticipant(Participant ref) {
        return participantRefs.add(ref);
    }

    /**
     * Public method to return the number of participating counselors.
     * 
     * @return
     */
    public int numberParticipating() {
        return participantRefs.size();
    }

    /**
     * Public method to remove a participating counselor.
     * 
     * @param ref
     * @return
     */
    public boolean removeParticipant(Participant ref) {
        return participantRefs.remove(ref);
    }

}
