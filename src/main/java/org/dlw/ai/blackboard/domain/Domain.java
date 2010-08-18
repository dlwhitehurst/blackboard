/**
 * 
 */
package org.dlw.ai.blackboard.domain;

import java.util.ArrayList;
import java.util.List;

import org.dlw.ai.blackboard.knowledge.KnowledgeSource;

/**
 * <p>This class provides a {@link Domain} parent for all
 * {@link org.dlw.ai.blackboard.BlackBoard} object types. The {@link Dependent}
 * interface also can be used to tie the domain objects together and ping all
 * participating references. This is slightly different than Booch's design
 * however it lends itself better I think for reuse and also extension with
 * other problem-solving models.</p>
 * 
 * <blockquote><i>Domain - "(def.) a sphere of activity over which rule or control
 * is exercised. (blackboard objects maybe?)</i></blockquote>
 * 
 * @author dlwhitehurst
 * 
 */
public abstract class Domain extends Universe {

	/**
	 * Attribute collection of "participating" experts, thinkers, or general consults. 
	 */
	protected List<Participant> participantRefs = new ArrayList<Participant>();

	/**
	 * Public method to add a participant to our counsel.
	 * 
	 * @param ref
	 * @return
	 */
	public boolean addParticipant(Participant ref) {
		if (!participantRefs.add(ref)) {
			return false;
		} else {
			return true;
		}
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
		if (!participantRefs.remove(ref)) {
			return false;
		} else {
			return true;
		}
	}

}
