/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.exceptions;

import org.java_websocket.exceptions.InvalidDataException;

public class InvalidFrameException
extends InvalidDataException {
    private static final long serialVersionUID = -9016496369828887591L;

    public InvalidFrameException() {
        super(1002);
    }

    public InvalidFrameException(String string) {
        super(1002, string);
    }

    public InvalidFrameException(Throwable throwable) {
        super(1002, throwable);
    }

    public InvalidFrameException(String string, Throwable throwable) {
        super(1002, string, throwable);
    }
}

