/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners.statements;

import org.junit.runners.model.Statement;

public class Fail
extends Statement {
    private final Throwable fError;

    public Fail(Throwable throwable) {
        this.fError = throwable;
    }

    public void evaluate() {
        throw this.fError;
    }
}

