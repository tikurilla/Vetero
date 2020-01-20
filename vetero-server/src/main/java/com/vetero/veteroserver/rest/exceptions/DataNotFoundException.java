package com.vetero.veteroserver.rest.exceptions;

public class DataNotFoundException extends RestException {

    private static final long serialVersionUID = 4858954278263435013L;

    public DataNotFoundException(String msg) {
        super(msg);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
