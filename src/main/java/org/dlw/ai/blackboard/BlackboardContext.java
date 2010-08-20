package org.dlw.ai.blackboard;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.dlw.ai.blackboard.domain.Assumption;

public class BlackboardContext {
	/**
	 * TODO - comment
	 */
	private Controller controller;
	
	/**
	 * TODO - comment
	 */
	private ConcurrentLinkedQueue<Assumption> pastAssumptions;

	/**
	 * TODO - comment
	 */
	private Blackboard blackboard;
	
	/**
	 * @return the blackboard
	 */
	public final Blackboard getBlackboard() {
		return blackboard;
	}

	/**
	 * @param blackboard the blackboard to set
	 */
	public final void setBlackboard(Blackboard blackboard) {
		this.blackboard = blackboard;
	}

	/**
	 * @return the controller
	 */
	public final Controller getController() {
		return controller;
	}

	/**
	 * @param controller the controller to set
	 */
	public final void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * @return the pastAssumptions
	 */
	public final ConcurrentLinkedQueue<Assumption> getPastAssumptions() {
		return pastAssumptions;
	}

	/**
	 * @param pastAssumptions the pastAssumptions to set
	 */
	public final void setPastAssumptions(ConcurrentLinkedQueue<Assumption> pastAssumptions) {
		this.pastAssumptions = pastAssumptions;
	}


}
