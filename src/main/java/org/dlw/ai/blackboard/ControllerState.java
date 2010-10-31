/**
 * 
 */
package org.dlw.ai.blackboard;

/**
 * This class is used to provide named enumerations for controller states.  The controller
 * is driven by KnowledgeSource(s) and the controller state machine has named states as
 * defined here.
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public enum ControllerState {

    INITIALIZING,
    SELECTING,
    EVALUATING,
    STUCK,
    SOLVED

}
