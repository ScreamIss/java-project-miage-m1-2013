package com.plugin.exception;

/**
 *
 * TechnicalException is wrapper for Exception class
 */
public class TechnicalException extends Exception {

    /**  */
    private static final long serialVersionUID = 1437111538277770215L;

    /**
     * Constructor
     */
    public TechnicalException() {
        super();
    }

    /**
     * Constructs a new exception {@link #Exception}.
     *
     * @param   message   the detail message.
     */
    public TechnicalException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception {@link #Exception}.
     *
     * @param   message   the detail message.
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).
     */
    public TechnicalException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception {@link #Exception}.
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).
     */
    public TechnicalException(final Throwable cause) {
        super(cause);
    }
}
