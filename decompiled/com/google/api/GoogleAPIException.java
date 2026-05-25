/*
 * Decompiled with CFR 0.152.
 */
package com.google.api;

public class GoogleAPIException
extends Exception {
    private static final long serialVersionUID = 1904924954995479356L;

    public GoogleAPIException(String string) {
        super(string);
    }

    public GoogleAPIException(Exception exception) {
        super(exception);
    }
}

