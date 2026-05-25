/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public abstract class FlushablePool<T>
extends Pool<T> {
    protected Array<T> obtained = new Array();

    public FlushablePool() {
    }

    public FlushablePool(int n2) {
        super(n2);
    }

    public FlushablePool(int n2, int n3) {
        super(n2, n3);
    }

    @Override
    public T obtain() {
        Object t2 = super.obtain();
        this.obtained.add(t2);
        return t2;
    }

    public void flush() {
        super.freeAll(this.obtained);
        this.obtained.clear();
    }

    @Override
    public void free(T t2) {
        this.obtained.removeValue(t2, true);
        super.free(t2);
    }

    @Override
    public void freeAll(Array<T> array) {
        this.obtained.removeAll(array, true);
        super.freeAll(array);
    }
}

