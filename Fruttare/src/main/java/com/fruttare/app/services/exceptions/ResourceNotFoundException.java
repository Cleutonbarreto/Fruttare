package com.fruttare.app.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionID = 1;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
