package org.dlw.ai.blackboard.exception;

public class KnowledgeSourceConnectionException extends Exception {

    /**
     * unique serial identifier
     */
    private static final long serialVersionUID = 1513284861906194992L;

    /**
     * Constructor
     * @param err
     */
    public KnowledgeSourceConnectionException(String err) {
        super(err);
    }
}
