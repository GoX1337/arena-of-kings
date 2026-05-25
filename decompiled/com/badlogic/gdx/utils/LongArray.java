/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.StringBuilder;
import java.util.Arrays;

public class LongArray {
    public long[] items;
    public int size;
    public boolean ordered;

    public LongArray() {
        this(true, 16);
    }

    public LongArray(int n2) {
        this(true, n2);
    }

    public LongArray(boolean bl2, int n2) {
        this.ordered = bl2;
        this.items = new long[n2];
    }

    public LongArray(LongArray longArray) {
        this.ordered = longArray.ordered;
        this.size = longArray.size;
        this.items = new long[this.size];
        System.arraycopy(longArray.items, 0, this.items, 0, this.size);
    }

    public LongArray(long[] lArray) {
        this(true, lArray, 0, lArray.length);
    }

    public LongArray(boolean bl2, long[] lArray, int n2, int n3) {
        this(bl2, n3);
        this.size = n3;
        System.arraycopy(lArray, n2, this.items, 0, n3);
    }

    public void add(long l2) {
        long[] lArray = this.items;
        if (this.size == lArray.length) {
            lArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        lArray[this.size++] = l2;
    }

    public void add(long l2, long l3) {
        long[] lArray = this.items;
        if (this.size + 1 >= lArray.length) {
            lArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        lArray[this.size] = l2;
        lArray[this.size + 1] = l3;
        this.size += 2;
    }

    public void add(long l2, long l3, long l4) {
        long[] lArray = this.items;
        if (this.size + 2 >= lArray.length) {
            lArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        lArray[this.size] = l2;
        lArray[this.size + 1] = l3;
        lArray[this.size + 2] = l4;
        this.size += 3;
    }

    public void add(long l2, long l3, long l4, long l5) {
        long[] lArray = this.items;
        if (this.size + 3 >= lArray.length) {
            lArray = this.resize(Math.max(8, (int)((float)this.size * 1.8f)));
        }
        lArray[this.size] = l2;
        lArray[this.size + 1] = l3;
        lArray[this.size + 2] = l4;
        lArray[this.size + 3] = l5;
        this.size += 4;
    }

    public void addAll(LongArray longArray) {
        this.addAll(longArray.items, 0, longArray.size);
    }

    public void addAll(LongArray longArray, int n2, int n3) {
        if (n2 + n3 > longArray.size) {
            throw new IllegalArgumentException("offset + length must be <= size: " + n2 + " + " + n3 + " <= " + longArray.size);
        }
        this.addAll(longArray.items, n2, n3);
    }

    public void addAll(long ... lArray) {
        this.addAll(lArray, 0, lArray.length);
    }

    public void addAll(long[] lArray, int n2, int n3) {
        int n4 = this.size + n3;
        long[] lArray2 = this.items;
        if (n4 > lArray2.length) {
            lArray2 = this.resize(Math.max(Math.max(8, n4), (int)((float)this.size * 1.75f)));
        }
        System.arraycopy(lArray, n2, lArray2, this.size, n3);
        this.size += n3;
    }

    public long get(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        return this.items[n2];
    }

    public void set(int n2, long l2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        this.items[n2] = l2;
    }

    public void incr(int n2, long l2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int n3 = n2;
        this.items[n3] = this.items[n3] + l2;
    }

    public void incr(long l2) {
        long[] lArray = this.items;
        int n2 = 0;
        int n3 = this.size;
        while (n2 < n3) {
            int n4 = n2++;
            lArray[n4] = lArray[n4] + l2;
        }
    }

    public void mul(int n2, long l2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int n3 = n2;
        this.items[n3] = this.items[n3] * l2;
    }

    public void mul(long l2) {
        long[] lArray = this.items;
        int n2 = 0;
        int n3 = this.size;
        while (n2 < n3) {
            int n4 = n2++;
            lArray[n4] = lArray[n4] * l2;
        }
    }

    public void insert(int n2, long l2) {
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException("index can't be > size: " + n2 + " > " + this.size);
        }
        long[] lArray = this.items;
        if (this.size == lArray.length) {
            lArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        if (this.ordered) {
            System.arraycopy(lArray, n2, lArray, n2 + 1, this.size - n2);
        } else {
            lArray[this.size] = lArray[n2];
        }
        ++this.size;
        lArray[n2] = l2;
    }

    public void insertRange(int n2, int n3) {
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException("index can't be > size: " + n2 + " > " + this.size);
        }
        int n4 = this.size + n3;
        if (n4 > this.items.length) {
            this.items = this.resize(Math.max(Math.max(8, n4), (int)((float)this.size * 1.75f)));
        }
        System.arraycopy(this.items, n2, this.items, n2 + n3, this.size - n2);
        this.size = n4;
    }

    public void swap(int n2, int n3) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("first can't be >= size: " + n2 + " >= " + this.size);
        }
        if (n3 >= this.size) {
            throw new IndexOutOfBoundsException("second can't be >= size: " + n3 + " >= " + this.size);
        }
        long[] lArray = this.items;
        long l2 = lArray[n2];
        lArray[n2] = lArray[n3];
        lArray[n3] = l2;
    }

    public boolean contains(long l2) {
        int n2 = this.size - 1;
        long[] lArray = this.items;
        while (n2 >= 0) {
            if (lArray[n2--] != l2) continue;
            return true;
        }
        return false;
    }

    public int indexOf(long l2) {
        long[] lArray = this.items;
        int n2 = this.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (lArray[i2] != l2) continue;
            return i2;
        }
        return -1;
    }

    public int lastIndexOf(char c2) {
        long[] lArray = this.items;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            if (lArray[i2] != (long)c2) continue;
            return i2;
        }
        return -1;
    }

    public boolean removeValue(long l2) {
        long[] lArray = this.items;
        int n2 = this.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (lArray[i2] != l2) continue;
            this.removeIndex(i2);
            return true;
        }
        return false;
    }

    public long removeIndex(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        long[] lArray = this.items;
        long l2 = lArray[n2];
        --this.size;
        if (this.ordered) {
            System.arraycopy(lArray, n2 + 1, lArray, n2, this.size - n2);
        } else {
            lArray[n2] = lArray[this.size];
        }
        return l2;
    }

    public void removeRange(int n2, int n3) {
        int n4 = this.size;
        if (n3 >= n4) {
            throw new IndexOutOfBoundsException("end can't be >= size: " + n3 + " >= " + this.size);
        }
        if (n2 > n3) {
            throw new IndexOutOfBoundsException("start can't be > end: " + n2 + " > " + n3);
        }
        int n5 = n3 - n2 + 1;
        int n6 = n4 - n5;
        if (this.ordered) {
            System.arraycopy(this.items, n2 + n5, this.items, n2, n4 - (n2 + n5));
        } else {
            int n7 = Math.max(n6, n3 + 1);
            System.arraycopy(this.items, n7, this.items, n2, n4 - n7);
        }
        this.size = n4 - n5;
    }

    public boolean removeAll(LongArray longArray) {
        int n2;
        int n3 = n2 = this.size;
        long[] lArray = this.items;
        int n4 = longArray.size;
        block0: for (int i2 = 0; i2 < n4; ++i2) {
            long l2 = longArray.get(i2);
            for (int i3 = 0; i3 < n2; ++i3) {
                if (l2 != lArray[i3]) continue;
                this.removeIndex(i3);
                --n2;
                continue block0;
            }
        }
        return n2 != n3;
    }

    public long pop() {
        return this.items[--this.size];
    }

    public long peek() {
        return this.items[this.size - 1];
    }

    public long first() {
        if (this.size == 0) {
            throw new IllegalStateException("Array is empty.");
        }
        return this.items[0];
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.size = 0;
    }

    public long[] shrink() {
        if (this.items.length != this.size) {
            this.resize(this.size);
        }
        return this.items;
    }

    public long[] ensureCapacity(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + n2);
        }
        int n3 = this.size + n2;
        if (n3 > this.items.length) {
            this.resize(Math.max(Math.max(8, n3), (int)((float)this.size * 1.75f)));
        }
        return this.items;
    }

    public long[] setSize(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("newSize must be >= 0: " + n2);
        }
        if (n2 > this.items.length) {
            this.resize(Math.max(8, n2));
        }
        this.size = n2;
        return this.items;
    }

    protected long[] resize(int n2) {
        long[] lArray = new long[n2];
        long[] lArray2 = this.items;
        System.arraycopy(lArray2, 0, lArray, 0, Math.min(this.size, lArray.length));
        this.items = lArray;
        return lArray;
    }

    public void sort() {
        Arrays.sort(this.items, 0, this.size);
    }

    public void reverse() {
        long[] lArray = this.items;
        int n2 = this.size - 1;
        int n3 = this.size / 2;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = n2 - i2;
            long l2 = lArray[i2];
            lArray[i2] = lArray[n4];
            lArray[n4] = l2;
        }
    }

    public void shuffle() {
        long[] lArray = this.items;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            int n2 = MathUtils.random(i2);
            long l2 = lArray[i2];
            lArray[i2] = lArray[n2];
            lArray[n2] = l2;
        }
    }

    public void truncate(int n2) {
        if (this.size > n2) {
            this.size = n2;
        }
    }

    public long random() {
        if (this.size == 0) {
            return 0L;
        }
        return this.items[MathUtils.random(0, this.size - 1)];
    }

    public long[] toArray() {
        long[] lArray = new long[this.size];
        System.arraycopy(this.items, 0, lArray, 0, this.size);
        return lArray;
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        long[] lArray = this.items;
        int n2 = 1;
        int n3 = this.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            long l2 = lArray[i2];
            n2 = n2 * 31 + (int)(l2 ^ l2 >>> 32);
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!this.ordered) {
            return false;
        }
        if (!(object instanceof LongArray)) {
            return false;
        }
        LongArray longArray = (LongArray)object;
        if (!longArray.ordered) {
            return false;
        }
        int n2 = this.size;
        if (n2 != longArray.size) {
            return false;
        }
        long[] lArray = this.items;
        long[] lArray2 = longArray.items;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (lArray[i2] == lArray2[i2]) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        long[] lArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(lArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(", ");
            stringBuilder.append(lArray[i2]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String toString(String string) {
        if (this.size == 0) {
            return "";
        }
        long[] lArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(lArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(string);
            stringBuilder.append(lArray[i2]);
        }
        return stringBuilder.toString();
    }

    public static LongArray with(long ... lArray) {
        return new LongArray(lArray);
    }
}

