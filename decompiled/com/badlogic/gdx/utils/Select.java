/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.QuickSelect;
import java.util.Comparator;

public class Select {
    private static Select instance;
    private QuickSelect quickSelect;

    public static Select instance() {
        if (instance == null) {
            instance = new Select();
        }
        return instance;
    }

    public <T> T select(T[] TArray, Comparator<T> comparator, int n2, int n3) {
        int n4 = this.selectIndex(TArray, comparator, n2, n3);
        return TArray[n4];
    }

    public <T> int selectIndex(T[] TArray, Comparator<T> comparator, int n2, int n3) {
        int n4;
        if (n3 < 1) {
            throw new GdxRuntimeException("cannot select from empty array (size < 1)");
        }
        if (n2 > n3) {
            throw new GdxRuntimeException("Kth rank is larger than size. k: " + n2 + ", size: " + n3);
        }
        if (n2 == 1) {
            n4 = this.fastMin(TArray, comparator, n3);
        } else if (n2 == n3) {
            n4 = this.fastMax(TArray, comparator, n3);
        } else {
            if (this.quickSelect == null) {
                this.quickSelect = new QuickSelect();
            }
            n4 = this.quickSelect.select(TArray, comparator, n2, n3);
        }
        return n4;
    }

    private <T> int fastMin(T[] TArray, Comparator<T> comparator, int n2) {
        int n3 = 0;
        for (int i2 = 1; i2 < n2; ++i2) {
            int n4 = comparator.compare(TArray[i2], TArray[n3]);
            if (n4 >= 0) continue;
            n3 = i2;
        }
        return n3;
    }

    private <T> int fastMax(T[] TArray, Comparator<T> comparator, int n2) {
        int n3 = 0;
        for (int i2 = 1; i2 < n2; ++i2) {
            int n4 = comparator.compare(TArray[i2], TArray[n3]);
            if (n4 <= 0) continue;
            n3 = i2;
        }
        return n3;
    }
}

