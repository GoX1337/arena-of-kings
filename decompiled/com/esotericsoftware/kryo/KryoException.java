/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo;

public class KryoException
extends RuntimeException {
    private StringBuffer trace;

    public KryoException() {
    }

    public KryoException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public KryoException(String string) {
        super(string);
    }

    public KryoException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String getMessage() {
        if (this.trace == null) {
            return super.getMessage();
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        stringBuffer.append(super.getMessage());
        if (stringBuffer.length() > 0) {
            stringBuffer.append('\n');
        }
        stringBuffer.append("Serialization trace:");
        stringBuffer.append(this.trace);
        return stringBuffer.toString();
    }

    public void addTrace(String string) {
        if (string == null) {
            throw new IllegalArgumentException("info cannot be null.");
        }
        if (this.trace == null) {
            this.trace = new StringBuffer(512);
        }
        this.trace.append('\n');
        this.trace.append(string);
    }
}

