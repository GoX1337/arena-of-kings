/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet.rmi;

public class TimeoutException
extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TimeoutException() {
    }

    public TimeoutException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public TimeoutException(String string) {
        super(string);
    }

    public TimeoutException(Throwable throwable) {
        super(throwable);
    }
}

