package com.github.davgarcia.marsroverkata.error;

public class InvalidPositionFormatException extends BusinessException {

    public InvalidPositionFormatException(final String message) {
        super(message);
    }

    public InvalidPositionFormatException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
