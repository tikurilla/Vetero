package com.vetero.veteroserver.rest.exceptions;

public class ConflictException extends RestException {

    private static final long serialVersionUID = 6749480795011502596L;

    public ConflictException(String msg) {
        super(msg);
    }

    public ConflictException(String msg, Exception e) {
        super(msg, e);
    }

    @Override
    public int getStatusCode() {
        return 409;
    }
}
