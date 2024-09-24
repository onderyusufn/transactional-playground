package com.aril.transactionalplayground;

/**
 * Exception that will not trigger rollback
 */
public class NoRollbackException extends Exception {
    public NoRollbackException(String message) {
        super(message);
    }
}
