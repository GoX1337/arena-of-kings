/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.jsonbeans;

public class JsonException
extends RuntimeException {
    private StringBuilder trace;

    public JsonException() {
    }

    public JsonException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public JsonException(String string) {
        super(string);
    }

    public JsonException(Throwable throwable) {
        super("", throwable);
    }

    public boolean causedBy(Class clazz) {
        return this.causedBy(this, clazz);
    }

    private boolean causedBy(Throwable throwable, Class clazz) {
        Throwable throwable2 = throwable.getCause();
        if (throwable2 == null || throwable2 == throwable) {
            return false;
        }
        if (clazz.isAssignableFrom(throwable2.getClass())) {
            return true;
        }
        return this.causedBy(throwable2, clazz);
    }

    @Override
    public String getMessage() {
        if (this.trace == null) {
            return super.getMessage();
        }
        StringBuilder stringBuilder = new StringBuilder(512);
        stringBuilder.append(super.getMessage());
        if (stringBuilder.length() > 0) {
            stringBuilder.append('\n');
        }
        stringBuilder.append("Serialization trace:");
        stringBuilder.append((CharSequence)this.trace);
        return stringBuilder.toString();
    }

    public void addTrace(String string) {
        if (string == null) {
            throw new IllegalArgumentException("info cannot be null.");
        }
        if (this.trace == null) {
            this.trace = new StringBuilder(512);
        }
        this.trace.append('\n');
        this.trace.append(string);
    }
}

