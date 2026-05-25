/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.async;

import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncResult<T> {
    private final Future<T> future;

    AsyncResult(Future<T> future) {
        this.future = future;
    }

    public boolean isDone() {
        return this.future.isDone();
    }

    public T get() {
        try {
            return this.future.get();
        }
        catch (InterruptedException interruptedException) {
            return null;
        }
        catch (ExecutionException executionException) {
            throw new GdxRuntimeException(executionException.getCause());
        }
    }
}

