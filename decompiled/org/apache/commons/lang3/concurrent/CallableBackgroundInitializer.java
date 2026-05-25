/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.concurrent.BackgroundInitializer;

public class CallableBackgroundInitializer<T>
extends BackgroundInitializer<T> {
    private final Callable<T> callable;

    public CallableBackgroundInitializer(Callable<T> callable) {
        this.checkCallable(callable);
        this.callable = callable;
    }

    public CallableBackgroundInitializer(Callable<T> callable, ExecutorService executorService) {
        super(executorService);
        this.checkCallable(callable);
        this.callable = callable;
    }

    @Override
    protected T initialize() {
        return this.callable.call();
    }

    private void checkCallable(Callable<T> callable) {
        Validate.notNull(callable, "callable", new Object[0]);
    }
}

