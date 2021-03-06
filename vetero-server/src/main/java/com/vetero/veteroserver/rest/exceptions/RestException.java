package com.vetero.veteroserver.rest.exceptions;

public abstract class RestException extends Exception {

    private static final long serialVersionUID = 8924312320020687939L;

    public RestException() {
        super();
    }

    public RestException(String msg) {
        super(msg);
    }

    public RestException(Throwable throwable) {
        super(throwable);
    }

    public RestException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public abstract int getStatusCode();
}
