package com.github.davgarcia.marsroverkata.error;

public class InvalidCommandFormatException extends BusinessException {

    public InvalidCommandFormatException(final String message) {
        super(message);
    }

    public InvalidCommandFormatException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
