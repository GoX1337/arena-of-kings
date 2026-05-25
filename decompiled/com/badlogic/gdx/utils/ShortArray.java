/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.StringBuilder;
import java.util.Arrays;

public class ShortArray {
    public short[] items;
    public int size;
    public boolean ordered;

    public ShortArray() {
        this(true, 16);
    }

    public ShortArray(int n2) {
        this(true, n2);
    }

    public ShortArray(boolean bl2, int n2) {
        this.ordered = bl2;
        this.items = new short[n2];
    }

    public ShortArray(ShortArray shortArray) {
        this.ordered = shortArray.ordered;
        this.size = shortArray.size;
        this.items = new short[this.size];
        System.arraycopy(shortArray.items, 0, this.items, 0, this.size);
    }

    public ShortArray(short[] sArray) {
        this(true, sArray, 0, sArray.length);
    }

    public ShortArray(boolean bl2, short[] sArray, int n2, int n3) {
        this(bl2, n3);
        this.size = n3;
        System.arraycopy(sArray, n2, this.items, 0, n3);
    }

    public void add(int n2) {
        short[] sArray = this.items;
        if (this.size == sArray.length) {
            sArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        sArray[this.size++] = (short)n2;
    }

    public void add(short s2) {
        short[] sArray = this.items;
        if (this.size == sArray.length) {
            sArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        sArray[this.size++] = s2;
    }

    public void add(short s2, short s3) {
        short[] sArray = this.items;
        if (this.size + 1 >= sArray.length) {
            sArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        sArray[this.size] = s2;
        sArray[this.size + 1] = s3;
        this.size += 2;
    }

    public void add(short s2, short s3, short s4) {
        short[] sArray = this.items;
        if (this.size + 2 >= sArray.length) {
            sArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        sArray[this.size] = s2;
        sArray[this.size + 1] = s3;
        sArray[this.size + 2] = s4;
        this.size += 3;
    }

    public void add(short s2, short s3, short s4, short s5) {
        short[] sArray = this.items;
        if (this.size + 3 >= sArray.length) {
            sArray = this.resize(Math.max(8, (int)((float)this.size * 1.8f)));
        }
        sArray[this.size] = s2;
        sArray[this.size + 1] = s3;
        sArray[this.size + 2] = s4;
        sArray[this.size + 3] = s5;
        this.size += 4;
    }

    public void addAll(ShortArray shortArray) {
        this.addAll(shortArray.items, 0, shortArray.size);
    }

    public void addAll(ShortArray shortArray, int n2, int n3) {
        if (n2 + n3 > shortArray.size) {
            throw new IllegalArgumentException("offset + length must be <= size: " + n2 + " + " + n3 + " <= " + shortArray.size);
        }
        this.addAll(shortArray.items, n2, n3);
    }

    public void addAll(short ... sArray) {
        this.addAll(sArray, 0, sArray.length);
    }

    public void addAll(short[] sArray, int n2, int n3) {
        int n4 = this.size + n3;
        short[] sArray2 = this.items;
        if (n4 > sArray2.length) {
            sArray2 = this.resize(Math.max(Math.max(8, n4), (int)((float)this.size * 1.75f)));
        }
        System.arraycopy(sArray, n2, sArray2, this.size, n3);
        this.size += n3;
    }

    public short get(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        return this.items[n2];
    }

    public void set(int n2, short s2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        this.items[n2] = s2;
    }

    public void incr(int n2, short s2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int n3 = n2;
        this.items[n3] = (short)(this.items[n3] + s2);
    }

    public void incr(short s2) {
        short[] sArray = this.items;
        int n2 = 0;
        int n3 = this.size;
        while (n2 < n3) {
            int n4 = n2++;
            sArray[n4] = (short)(sArray[n4] + s2);
        }
    }

    public void mul(int n2, short s2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int n3 = n2;
        this.items[n3] = (short)(this.items[n3] * s2);
    }

    public void mul(short s2) {
        short[] sArray = this.items;
        int n2 = 0;
        int n3 = this.size;
        while (n2 < n3) {
            int n4 = n2++;
            sArray[n4] = (short)(sArray[n4] * s2);
        }
    }

    public void insert(int n2, short s2) {
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException("index can't be > size: " + n2 + " > " + this.size);
        }
        short[] sArray = this.items;
        if (this.size == sArray.length) {
            sArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        if (this.ordered) {
            System.arraycopy(sArray, n2, sArray, n2 + 1, this.size - n2);
        } else {
            sArray[this.size] = sArray[n2];
        }
        ++this.size;
        sArray[n2] = s2;
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
        short[] sArray = this.items;
        short s2 = sArray[n2];
        sArray[n2] = sArray[n3];
        sArray[n3] = s2;
    }

    public boolean contains(short s2) {
        int n2 = this.size - 1;
        short[] sArray = this.items;
        while (n2 >= 0) {
            if (sArray[n2--] != s2) continue;
            return true;
        }
        return false;
    }

    public int indexOf(short s2) {
        short[] sArray = this.items;
        int n2 = this.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (sArray[i2] != s2) continue;
            return i2;
        }
        return -1;
    }

    public int lastIndexOf(char c2) {
        short[] sArray = this.items;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            if (sArray[i2] != c2) continue;
            return i2;
        }
        return -1;
    }

    public boolean removeValue(short s2) {
        short[] sArray = this.items;
        int n2 = this.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (sArray[i2] != s2) continue;
            this.removeIndex(i2);
            return true;
        }
        return false;
    }

    public short removeIndex(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        short[] sArray = this.items;
        short s2 = sArray[n2];
        --this.size;
        if (this.ordered) {
            System.arraycopy(sArray, n2 + 1, sArray, n2, this.size - n2);
        } else {
            sArray[n2] = sArray[this.size];
        }
        return s2;
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

    public boolean removeAll(ShortArray shortArray) {
        int n2;
        int n3 = n2 = this.size;
        short[] sArray = this.items;
        int n4 = shortArray.size;
        block0: for (int i2 = 0; i2 < n4; ++i2) {
            short s2 = shortArray.get(i2);
            for (int i3 = 0; i3 < n2; ++i3) {
                if (s2 != sArray[i3]) continue;
                this.removeIndex(i3);
                --n2;
                continue block0;
            }
        }
        return n2 != n3;
    }

    public short pop() {
        return this.items[--this.size];
    }

    public short peek() {
        return this.items[this.size - 1];
    }

    public short first() {
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

    public short[] shrink() {
        if (this.items.length != this.size) {
            this.resize(this.size);
        }
        return this.items;
    }

    public short[] ensureCapacity(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + n2);
        }
        int n3 = this.size + n2;
        if (n3 > this.items.length) {
            this.resize(Math.max(Math.max(8, n3), (int)((float)this.size * 1.75f)));
        }
        return this.items;
    }

    public short[] setSize(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("newSize must be >= 0: " + n2);
        }
        if (n2 > this.items.length) {
            this.resize(Math.max(8, n2));
        }
        this.size = n2;
        return this.items;
    }

    protected short[] resize(int n2) {
        short[] sArray = new short[n2];
        short[] sArray2 = this.items;
        System.arraycopy(sArray2, 0, sArray, 0, Math.min(this.size, sArray.length));
        this.items = sArray;
        return sArray;
    }

    public void sort() {
        Arrays.sort(this.items, 0, this.size);
    }

    public void reverse() {
        short[] sArray = this.items;
        int n2 = this.size - 1;
        int n3 = this.size / 2;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = n2 - i2;
            short s2 = sArray[i2];
            sArray[i2] = sArray[n4];
            sArray[n4] = s2;
        }
    }

    public void shuffle() {
        short[] sArray = this.items;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            int n2 = MathUtils.random(i2);
            short s2 = sArray[i2];
            sArray[i2] = sArray[n2];
            sArray[n2] = s2;
        }
    }

    public void truncate(int n2) {
        if (this.size > n2) {
            this.size = n2;
        }
    }

    public short random() {
        if (this.size == 0) {
            return 0;
        }
        return this.items[MathUtils.random(0, this.size - 1)];
    }

    public short[] toArray() {
        short[] sArray = new short[this.size];
        System.arraycopy(this.items, 0, sArray, 0, this.size);
        return sArray;
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        short[] sArray = this.items;
        int n2 = 1;
        int n3 = this.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 = n2 * 31 + sArray[i2];
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
        if (!(object instanceof ShortArray)) {
            return false;
        }
        ShortArray shortArray = (ShortArray)object;
        if (!shortArray.ordered) {
            return false;
        }
        int n2 = this.size;
        if (n2 != shortArray.size) {
            return false;
        }
        short[] sArray = this.items;
        short[] sArray2 = shortArray.items;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (sArray[i2] == sArray2[i2]) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        short[] sArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(sArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(", ");
            stringBuilder.append(sArray[i2]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String toString(String string) {
        if (this.size == 0) {
            return "";
        }
        short[] sArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(sArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(string);
            stringBuilder.append(sArray[i2]);
        }
        return stringBuilder.toString();
    }

    public static ShortArray with(short ... sArray) {
        return new ShortArray(sArray);
    }
}

