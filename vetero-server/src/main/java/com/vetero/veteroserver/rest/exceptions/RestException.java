package com.vetero.veteroserver.rest.exceptions;

public abstract class RestException extends Exception {

    private static final long serialVersionUID = 628659355495199628L;

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
