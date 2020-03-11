package com.vetero.veteroserver.logger;

public class Logger {
    private org.slf4j.Logger log;

    public Logger(org.slf4j.Logger logger) {
        this.log = logger;
    }

    public void debug(final String msg) {
        log.debug(msg);
    }

    public void debug(final String msg, final Throwable t) {
        log.debug(msg, t);
    }

    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    public void info(final String msg) {
        log.info(msg);
    }

    public void info(final String msg, final Throwable t) {
        log.info(msg, t);
    }

    public void warn(final String msg) {
        log.warn(msg);
    }

    public void warn(final String msg, final Throwable t) {
        log.warn(msg, t);
    }

    public void error(final String msg) {
        log.error(msg);
    }

    public void error(final String msg, final Throwable t) {
        log.error(msg, t);
    }
}
