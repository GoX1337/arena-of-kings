/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.concurrent.ConcurrentInitializer;

public abstract class AtomicSafeInitializer<T>
implements ConcurrentInitializer<T> {
    private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference();
    private final AtomicReference<T> reference = new AtomicReference();

    @Override
    public final T get() {
        T t2;
        while ((t2 = this.reference.get()) == null) {
            if (!this.factory.compareAndSet(null, this)) continue;
            this.reference.set(this.initialize());
        }
        return t2;
    }

    protected abstract T initialize();
}

