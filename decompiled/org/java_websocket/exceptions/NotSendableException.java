/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.exceptions;

public class NotSendableException
extends RuntimeException {
    private static final long serialVersionUID = -6468967874576651628L;

    public NotSendableException(String string) {
        super(string);
    }

    public NotSendableException(Throwable throwable) {
        super(throwable);
    }

    public NotSendableException(String string, Throwable throwable) {
        super(string, throwable);
    }
}

