package com.fruttare.app.services.exceptions;

public class DatabaseException extends RuntimeException {
    private static final long serialVersionID = 1;

    public DatabaseException(String msg) {
        super(msg);
    }
}
