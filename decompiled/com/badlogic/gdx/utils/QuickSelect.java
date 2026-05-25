/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import java.util.Comparator;

public class QuickSelect<T> {
    private T[] array;
    private Comparator<? super T> comp;

    public int select(T[] TArray, Comparator<T> comparator, int n2, int n3) {
        this.array = TArray;
        this.comp = comparator;
        return this.recursiveSelect(0, n3 - 1, n2);
    }

    private int partition(int n2, int n3, int n4) {
        T t2 = this.array[n4];
        this.swap(n3, n4);
        int n5 = n2;
        for (int i2 = n2; i2 < n3; ++i2) {
            if (this.comp.compare(this.array[i2], t2) >= 0) continue;
            this.swap(n5, i2);
            ++n5;
        }
        this.swap(n3, n5);
        return n5;
    }

    private int recursiveSelect(int n2, int n3, int n4) {
        if (n2 == n3) {
            return n2;
        }
        int n5 = this.medianOfThreePivot(n2, n3);
        int n6 = this.partition(n2, n3, n5);
        int n7 = n6 - n2 + 1;
        int n8 = n7 == n4 ? n6 : (n4 < n7 ? this.recursiveSelect(n2, n6 - 1, n4) : this.recursiveSelect(n6 + 1, n3, n4 - n7));
        return n8;
    }

    private int medianOfThreePivot(int n2, int n3) {
        T t2 = this.array[n2];
        int n4 = (n2 + n3) / 2;
        T t3 = this.array[n4];
        T t4 = this.array[n3];
        if (this.comp.compare(t2, t3) > 0) {
            if (this.comp.compare(t3, t4) > 0) {
                return n4;
            }
            if (this.comp.compare(t2, t4) > 0) {
                return n3;
            }
            return n2;
        }
        if (this.comp.compare(t2, t4) > 0) {
            return n2;
        }
        if (this.comp.compare(t3, t4) > 0) {
            return n3;
        }
        return n4;
    }

    private void swap(int n2, int n3) {
        T t2 = this.array[n2];
        this.array[n2] = this.array[n3];
        this.array[n3] = t2;
    }
}

