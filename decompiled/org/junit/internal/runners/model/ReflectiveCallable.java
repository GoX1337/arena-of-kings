/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners.model;

import java.lang.reflect.InvocationTargetException;

public abstract class ReflectiveCallable {
    public Object run() {
        try {
            return this.runReflectiveCall();
        }
        catch (InvocationTargetException invocationTargetException) {
            throw invocationTargetException.getTargetException();
        }
    }

    protected abstract Object runReflectiveCall();
}

