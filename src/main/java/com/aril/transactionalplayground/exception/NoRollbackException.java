package com.aril.transactionalplayground.exception;

/**
 * Exception that will not trigger rollback
 */
public class NoRollbackException extends Exception {
    public NoRollbackException(String message) {
        super(message);
    }
}
