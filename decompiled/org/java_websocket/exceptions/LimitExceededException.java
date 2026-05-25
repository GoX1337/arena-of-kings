/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.exceptions;

import org.java_websocket.exceptions.InvalidDataException;

public class LimitExceededException
extends InvalidDataException {
    private static final long serialVersionUID = 6908339749836826785L;
    private final int limit;

    public LimitExceededException() {
        this(Integer.MAX_VALUE);
    }

    public LimitExceededException(int n2) {
        super(1009);
        this.limit = n2;
    }

    public LimitExceededException(String string, int n2) {
        super(1009, string);
        this.limit = n2;
    }

    public LimitExceededException(String string) {
        this(string, Integer.MAX_VALUE);
    }

    public int getLimit() {
        return this.limit;
    }
}

