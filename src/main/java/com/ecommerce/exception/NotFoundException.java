package com.ecommerce.exception;

/**
 * The type Resource not found exception.
 */
public class NotFoundException extends RuntimeException {


    /**
     * Instantiates a new Resource not found exception.
     */
    public NotFoundException() {
        super();
    }

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param message the message
     */
    public NotFoundException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param cause the cause
     */
    public NotFoundException(final Throwable cause) {
        super(cause);
    }
}
