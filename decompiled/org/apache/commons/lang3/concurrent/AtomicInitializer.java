/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.concurrent.ConcurrentInitializer;

public abstract class AtomicInitializer<T>
implements ConcurrentInitializer<T> {
    private final AtomicReference<T> reference = new AtomicReference();

    @Override
    public T get() {
        T t2 = this.reference.get();
        if (t2 == null && !this.reference.compareAndSet(null, t2 = this.initialize())) {
            t2 = this.reference.get();
        }
        return t2;
    }

    protected abstract T initialize();
}

