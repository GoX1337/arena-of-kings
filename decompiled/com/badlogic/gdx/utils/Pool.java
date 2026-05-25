/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;

public abstract class Pool<T> {
    public final int max;
    public int peak;
    private final Array<T> freeObjects;

    public Pool() {
        this(16, Integer.MAX_VALUE);
    }

    public Pool(int n2) {
        this(n2, Integer.MAX_VALUE);
    }

    public Pool(int n2, int n3) {
        this.freeObjects = new Array(false, n2);
        this.max = n3;
    }

    protected abstract T newObject();

    public T obtain() {
        return this.freeObjects.size == 0 ? this.newObject() : this.freeObjects.pop();
    }

    public void free(T t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        if (this.freeObjects.size < this.max) {
            this.freeObjects.add(t2);
            this.peak = Math.max(this.peak, this.freeObjects.size);
            this.reset(t2);
        } else {
            this.discard(t2);
        }
    }

    public void fill(int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.freeObjects.size >= this.max) continue;
            this.freeObjects.add(this.newObject());
        }
        this.peak = Math.max(this.peak, this.freeObjects.size);
    }

    protected void reset(T t2) {
        if (t2 instanceof Poolable) {
            ((Poolable)t2).reset();
        }
    }

    protected void discard(T t2) {
        this.reset(t2);
    }

    public void freeAll(Array<T> array) {
        if (array == null) {
            throw new IllegalArgumentException("objects cannot be null.");
        }
        Array<T> array2 = this.freeObjects;
        int n2 = this.max;
        int n3 = array.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            T t2 = array.get(i2);
            if (t2 == null) continue;
            if (array2.size < n2) {
                array2.add(t2);
                this.reset(t2);
                continue;
            }
            this.discard(t2);
        }
        this.peak = Math.max(this.peak, array2.size);
    }

    public void clear() {
        Array<T> array = this.freeObjects;
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.discard(array.get(i2));
        }
        array.clear();
    }

    public int getFree() {
        return this.freeObjects.size;
    }

    public static interface Poolable {
        public void reset();
    }
}

