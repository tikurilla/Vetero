package com.vetero.veteroserver.rest.exceptions;

public class IncorrectParameterException extends RestException {

    public IncorrectParameterException(String msg) {
        super(msg);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
