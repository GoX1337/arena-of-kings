/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import java.util.Comparator;

public class SnapshotArray<T>
extends Array<T> {
    private T[] snapshot;
    private T[] recycled;
    private int snapshots;

    public SnapshotArray() {
    }

    public SnapshotArray(Array array) {
        super(array);
    }

    public SnapshotArray(boolean bl2, int n2, Class clazz) {
        super(bl2, n2, clazz);
    }

    public SnapshotArray(boolean bl2, int n2) {
        super(bl2, n2);
    }

    public SnapshotArray(boolean bl2, T[] TArray, int n2, int n3) {
        super(bl2, TArray, n2, n3);
    }

    public SnapshotArray(Class clazz) {
        super(clazz);
    }

    public SnapshotArray(int n2) {
        super(n2);
    }

    public SnapshotArray(T[] TArray) {
        super(TArray);
    }

    public T[] begin() {
        this.modified();
        this.snapshot = this.items;
        ++this.snapshots;
        return this.items;
    }

    public void end() {
        this.snapshots = Math.max(0, this.snapshots - 1);
        if (this.snapshot == null) {
            return;
        }
        if (this.snapshot != this.items && this.snapshots == 0) {
            this.recycled = this.snapshot;
            int n2 = this.recycled.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                this.recycled[i2] = null;
            }
        }
        this.snapshot = null;
    }

    private void modified() {
        if (this.snapshot == null || this.snapshot != this.items) {
            return;
        }
        if (this.recycled != null && this.recycled.length >= this.size) {
            System.arraycopy(this.items, 0, this.recycled, 0, this.size);
            this.items = this.recycled;
            this.recycled = null;
        } else {
            this.resize(this.items.length);
        }
    }

    @Override
    public void set(int n2, T t2) {
        this.modified();
        super.set(n2, t2);
    }

    @Override
    public void insert(int n2, T t2) {
        this.modified();
        super.insert(n2, t2);
    }

    @Override
    public void insertRange(int n2, int n3) {
        this.modified();
        super.insertRange(n2, n3);
    }

    @Override
    public void swap(int n2, int n3) {
        this.modified();
        super.swap(n2, n3);
    }

    @Override
    public boolean removeValue(T t2, boolean bl2) {
        this.modified();
        return super.removeValue(t2, bl2);
    }

    @Override
    public T removeIndex(int n2) {
        this.modified();
        return super.removeIndex(n2);
    }

    @Override
    public void removeRange(int n2, int n3) {
        this.modified();
        super.removeRange(n2, n3);
    }

    @Override
    public boolean removeAll(Array<? extends T> array, boolean bl2) {
        this.modified();
        return super.removeAll(array, bl2);
    }

    @Override
    public T pop() {
        this.modified();
        return super.pop();
    }

    @Override
    public void clear() {
        this.modified();
        super.clear();
    }

    @Override
    public void sort() {
        this.modified();
        super.sort();
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        this.modified();
        super.sort(comparator);
    }

    @Override
    public void reverse() {
        this.modified();
        super.reverse();
    }

    @Override
    public void shuffle() {
        this.modified();
        super.shuffle();
    }

    @Override
    public void truncate(int n2) {
        this.modified();
        super.truncate(n2);
    }

    @Override
    public T[] setSize(int n2) {
        this.modified();
        return super.setSize(n2);
    }

    public static <T> SnapshotArray<T> with(T ... TArray) {
        return new SnapshotArray<T>(TArray);
    }
}

