/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis;

public class ObjenesisException
extends RuntimeException {
    private static final long serialVersionUID = -2677230016262426968L;

    public ObjenesisException(String string) {
        super(string);
    }

    public ObjenesisException(Throwable throwable) {
        super(throwable);
    }

    public ObjenesisException(String string, Throwable throwable) {
        super(string, throwable);
    }
}

