package com.vetero.veteroserver.rest.exceptions;

public abstract class RestException extends Exception {

    private static final long serialVersionUID = 8924312320020687939L;

    public RestException() {
        super();
    }

    public RestException(String msg) {
        super(msg);
    }

    public RestException(Throwable trowable) {
        super(trowable);
    }

    public RestException(String msg, Throwable trowable) {
        super(msg, trowable);
    }

    public abstract int getStatusCode();
}
