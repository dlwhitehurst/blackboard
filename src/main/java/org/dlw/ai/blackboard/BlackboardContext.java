package org.dlw.ai.blackboard;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.dlw.ai.blackboard.domain.Assumption;

public final class BlackboardContext {

	/**
	 * TODO - comment
	 */
	protected Blackboard blackboard;
	
	/**
	 * @return the blackboard
	 */
	public Blackboard getBlackboard() {
		return blackboard;
	}

	/**
	 * @param blackboard the blackboard to set
	 */
	public void setBlackboard(Blackboard blackboard) {
		this.blackboard = blackboard;
	}

	/**
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}

	/**
	 * @param controller the controller to set
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * @return the pastAssumptions
	 */
	public ConcurrentLinkedQueue<Assumption> getPastAssumptions() {
		return pastAssumptions;
	}

	/**
	 * @param pastAssumptions the pastAssumptions to set
	 */
	public void setPastAssumptions(ConcurrentLinkedQueue<Assumption> pastAssumptions) {
		this.pastAssumptions = pastAssumptions;
	}

	/**
	 * TODO - comment
	 */
	protected Controller controller;
	
	/**
	 * TODO - comment
	 */
	protected ConcurrentLinkedQueue<Assumption> pastAssumptions;

}
