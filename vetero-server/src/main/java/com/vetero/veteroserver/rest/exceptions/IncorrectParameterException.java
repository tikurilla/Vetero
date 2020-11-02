package com.vetero.veteroserver.rest.exceptions;

public class IncorrectParameterException extends RestException {

    private static final long serialVersionUID = 4828938277361835038L;

    public IncorrectParameterException(String msg) {
        super(msg);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
