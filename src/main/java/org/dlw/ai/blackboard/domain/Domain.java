/**
 * 
 */
package org.dlw.ai.blackboard.domain;

import java.util.ArrayList;
import java.util.List;

import org.dlw.ai.blackboard.knowledge.KnowledgeSource;

/**
 * @author dlwhitehurst
 *
 */
public abstract class Domain extends Universe {

	/**
	 * 
	 */
	protected List<KnowledgeSource> knowledgeSourceRefs = new ArrayList<KnowledgeSource>();
	
	/**
	 * 
	 * @param ref
	 * @return
	 */
	public boolean addParticipant(KnowledgeSource ref) {
		if (!knowledgeSourceRefs.add(ref)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @return
	 */
	public int numberParticipating() {
		return knowledgeSourceRefs.size();
	}

	/**
	 * 
	 * @param ref
	 * @return
	 */
	public boolean removeParticipant(KnowledgeSource ref) {
		if (!knowledgeSourceRefs.remove(ref)) {
			return false;
		} else {
			return true;
		}
	}

}
