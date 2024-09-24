package com.aril.transactionalplayground;

/**
 * Exception that will trigger rollback
 */
public class RollbackException extends RuntimeException {
    public RollbackException(String message) {
        super(message);
    }
}
