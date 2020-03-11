package com.vetero.veteroserver.exceptions;

public class WrongJsonException extends RuntimeException {
    private static final long serialVersionUID = -7270347449304826463L;

    public WrongJsonException(String msg) {
        super(msg);
    }
}
