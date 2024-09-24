package com.aril.transactionalplayground.exception;

/**
 * Exception that will trigger rollback
 */
public class RollbackException extends RuntimeException {
    public RollbackException(String message) {
        super(message);
    }
}
