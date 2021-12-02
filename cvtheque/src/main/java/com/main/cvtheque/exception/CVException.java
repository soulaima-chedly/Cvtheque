package com.main.cvtheque.exception;

public class CVException extends RuntimeException {

    public CVException(String message) {
        super(message);
    }

    public CVException(String message, Throwable cause) {
        super(message, cause);
    }
}
