package com.ecommerce.exception;

/**
 * The type Resource not found exception.
 */
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5861310537366287163L;

    /**
     * Instantiates a new Resource not found exception.
     */
    public ResourceNotFoundException() {
        super();
    }

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param message the message
     */
    public ResourceNotFoundException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param cause the cause
     */
    public ResourceNotFoundException(final Throwable cause) {
        super(cause);
    }
}
