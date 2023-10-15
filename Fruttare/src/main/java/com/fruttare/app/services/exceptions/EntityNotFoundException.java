package com.fruttare.app.services.exceptions;

public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionID = 1;

    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
