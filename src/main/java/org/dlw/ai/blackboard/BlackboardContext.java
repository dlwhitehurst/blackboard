package org.dlw.ai.blackboard;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.dlw.ai.blackboard.domain.Assumption;

public class BlackboardContext {

	/**
	 * TODO - comment
	 */
	protected Blackboard blackboard;
	
	/**
	 * TODO - comment
	 */
	protected Controller controller;
	
	/**
	 * TODO - comment
	 */
	protected ConcurrentLinkedQueue<Assumption> pastAssumptions;

}
