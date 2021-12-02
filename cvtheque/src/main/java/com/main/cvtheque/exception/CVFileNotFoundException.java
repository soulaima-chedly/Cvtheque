package com.main.cvtheque.exception;

public class CVFileNotFoundException extends CVException {

    public CVFileNotFoundException(String message) {
        super(message);
    }

    public CVFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}