/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.exceptions;

public class InvalidDataException
extends Exception {
    private static final long serialVersionUID = 3731842424390998726L;
    private final int closecode;

    public InvalidDataException(int n2) {
        this.closecode = n2;
    }

    public InvalidDataException(int n2, String string) {
        super(string);
        this.closecode = n2;
    }

    public InvalidDataException(int n2, Throwable throwable) {
        super(throwable);
        this.closecode = n2;
    }

    public InvalidDataException(int n2, String string, Throwable throwable) {
        super(string, throwable);
        this.closecode = n2;
    }

    public int getCloseCode() {
        return this.closecode;
    }
}

