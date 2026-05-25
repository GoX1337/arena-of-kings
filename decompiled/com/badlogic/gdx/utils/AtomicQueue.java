/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Null;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicQueue<T> {
    private final AtomicInteger writeIndex = new AtomicInteger();
    private final AtomicInteger readIndex = new AtomicInteger();
    private final AtomicReferenceArray<T> queue;

    public AtomicQueue(int n2) {
        this.queue = new AtomicReferenceArray(n2);
    }

    private int next(int n2) {
        return (n2 + 1) % this.queue.length();
    }

    public boolean put(@Null T t2) {
        int n2 = this.writeIndex.get();
        int n3 = this.readIndex.get();
        int n4 = this.next(n2);
        if (n4 == n3) {
            return false;
        }
        this.queue.set(n2, t2);
        this.writeIndex.set(n4);
        return true;
    }

    @Null
    public T poll() {
        int n2;
        int n3 = this.readIndex.get();
        if (n3 == (n2 = this.writeIndex.get())) {
            return null;
        }
        T t2 = this.queue.get(n3);
        this.readIndex.set(this.next(n3));
        return t2;
    }
}

