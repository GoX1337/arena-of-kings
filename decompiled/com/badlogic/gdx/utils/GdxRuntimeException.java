/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

public class GdxRuntimeException
extends RuntimeException {
    private static final long serialVersionUID = 6735854402467673117L;

    public GdxRuntimeException(String string) {
        super(string);
    }

    public GdxRuntimeException(Throwable throwable) {
        super(throwable);
    }

    public GdxRuntimeException(String string, Throwable throwable) {
        super(string, throwable);
    }
}

