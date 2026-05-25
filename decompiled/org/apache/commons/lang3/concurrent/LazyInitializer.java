/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.concurrent;

import org.apache.commons.lang3.concurrent.ConcurrentInitializer;

public abstract class LazyInitializer<T>
implements ConcurrentInitializer<T> {
    private static final Object NO_INIT = new Object();
    private volatile T object = NO_INIT;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public T get() {
        T t2 = this.object;
        if (t2 == NO_INIT) {
            LazyInitializer lazyInitializer = this;
            synchronized (lazyInitializer) {
                t2 = this.object;
                if (t2 == NO_INIT) {
                    this.object = t2 = this.initialize();
                }
            }
        }
        return t2;
    }

    protected abstract T initialize();
}

