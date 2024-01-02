package com.fruttare.app.services.exceptions;

public class RequiredFieldsException extends RuntimeException {
    private static final long serialVersionID =1;

    public RequiredFieldsException (String msg) {
        super(msg);
    }
}
