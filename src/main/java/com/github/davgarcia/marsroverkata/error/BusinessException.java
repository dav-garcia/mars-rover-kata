package com.github.davgarcia.marsroverkata.error;

public class BusinessException extends RuntimeException {

    public BusinessException(final String message) {
        super(message);
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
