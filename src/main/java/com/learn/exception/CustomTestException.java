/*
 *-----------------------------------------------------------------------------
 * Copyright 2017 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.learn.exception;

/**
 * Custom defined exception to test
 *
 * @author km185223
 */
public class CustomTestException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     * later retrieval by the {@link #getMessage()} method.
     */
    public CustomTestException(String message) {
        super(message);
    }
}
