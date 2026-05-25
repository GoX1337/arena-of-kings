/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet;

public class KryoNetException
extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public KryoNetException() {
    }

    public KryoNetException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public KryoNetException(String string) {
        super(string);
    }

    public KryoNetException(Throwable throwable) {
        super(throwable);
    }
}

