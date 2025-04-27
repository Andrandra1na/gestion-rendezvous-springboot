package com.example.exception;

public class CreneauIndisponibleException extends RuntimeException {

    public CreneauIndisponibleException() {
        super();
    }

    public CreneauIndisponibleException(String message) {
        super(message);
    }

    public CreneauIndisponibleException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreneauIndisponibleException(Throwable cause) {
        super(cause);
    }
}
