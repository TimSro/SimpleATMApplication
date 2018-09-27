package de.tz.helloweb.web.exception;

public class MyEntityIdMismatchException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MyEntityIdMismatchException() {
        super();
    }

    public MyEntityIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyEntityIdMismatchException(final String message) {
        super(message);
    }

    public MyEntityIdMismatchException(final Throwable cause) {
        super(cause);
    }
}