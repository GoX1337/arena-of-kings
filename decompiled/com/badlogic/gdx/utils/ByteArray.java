/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.StringBuilder;
import java.util.Arrays;

public class ByteArray {
    public byte[] items;
    public int size;
    public boolean ordered;

    public ByteArray() {
        this(true, 16);
    }

    public ByteArray(int n2) {
        this(true, n2);
    }

    public ByteArray(boolean bl2, int n2) {
        this.ordered = bl2;
        this.items = new byte[n2];
    }

    public ByteArray(ByteArray byteArray) {
        this.ordered = byteArray.ordered;
        this.size = byteArray.size;
        this.items = new byte[this.size];
        System.arraycopy(byteArray.items, 0, this.items, 0, this.size);
    }

    public ByteArray(byte[] byArray) {
        this(true, byArray, 0, byArray.length);
    }

    public ByteArray(boolean bl2, byte[] byArray, int n2, int n3) {
        this(bl2, n3);
        this.size = n3;
        System.arraycopy(byArray, n2, this.items, 0, n3);
    }

    public void add(byte by2) {
        byte[] byArray = this.items;
        if (this.size == byArray.length) {
            byArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        byArray[this.size++] = by2;
    }

    public void add(byte by2, byte by3) {
        byte[] byArray = this.items;
        if (this.size + 1 >= byArray.length) {
            byArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        byArray[this.size] = by2;
        byArray[this.size + 1] = by3;
        this.size += 2;
    }

    public void add(byte by2, byte by3, byte by4) {
        byte[] byArray = this.items;
        if (this.size + 2 >= byArray.length) {
            byArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        byArray[this.size] = by2;
        byArray[this.size + 1] = by3;
        byArray[this.size + 2] = by4;
        this.size += 3;
    }

    public void add(byte by2, byte by3, byte by4, byte by5) {
        byte[] byArray = this.items;
        if (this.size + 3 >= byArray.length) {
            byArray = this.resize(Math.max(8, (int)((float)this.size * 1.8f)));
        }
        byArray[this.size] = by2;
        byArray[this.size + 1] = by3;
        byArray[this.size + 2] = by4;
        byArray[this.size + 3] = by5;
        this.size += 4;
    }

    public void addAll(ByteArray byteArray) {
        this.addAll(byteArray.items, 0, byteArray.size);
    }

    public void addAll(ByteArray byteArray, int n2, int n3) {
        if (n2 + n3 > byteArray.size) {
            throw new IllegalArgumentException("offset + length must be <= size: " + n2 + " + " + n3 + " <= " + byteArray.size);
        }
        this.addAll(byteArray.items, n2, n3);
    }

    public void addAll(byte ... byArray) {
        this.addAll(byArray, 0, byArray.length);
    }

    public void addAll(byte[] byArray, int n2, int n3) {
        int n4 = this.size + n3;
        byte[] byArray2 = this.items;
        if (n4 > byArray2.length) {
            byArray2 = this.resize(Math.max(Math.max(8, n4), (int)((float)this.size * 1.75f)));
        }
        System.arraycopy(byArray, n2, byArray2, this.size, n3);
        this.size += n3;
    }

    public byte get(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        return this.items[n2];
    }

    public void set(int n2, byte by2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        this.items[n2] = by2;
    }

    public void incr(int n2, byte by2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int n3 = n2;
        this.items[n3] = (byte)(this.items[n3] + by2);
    }

    public void incr(byte by2) {
        byte[] byArray = this.items;
        int n2 = 0;
        int n3 = this.size;
        while (n2 < n3) {
            int n4 = n2++;
            byArray[n4] = (byte)(byArray[n4] + by2);
        }
    }

    public void mul(int n2, byte by2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int n3 = n2;
        this.items[n3] = (byte)(this.items[n3] * by2);
    }

    public void mul(byte by2) {
        byte[] byArray = this.items;
        int n2 = 0;
        int n3 = this.size;
        while (n2 < n3) {
            int n4 = n2++;
            byArray[n4] = (byte)(byArray[n4] * by2);
        }
    }

    public void insert(int n2, byte by2) {
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException("index can't be > size: " + n2 + " > " + this.size);
        }
        byte[] byArray = this.items;
        if (this.size == byArray.length) {
            byArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        if (this.ordered) {
            System.arraycopy(byArray, n2, byArray, n2 + 1, this.size - n2);
        } else {
            byArray[this.size] = byArray[n2];
        }
        ++this.size;
        byArray[n2] = by2;
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
        byte[] byArray = this.items;
        byte by2 = byArray[n2];
        byArray[n2] = byArray[n3];
        byArray[n3] = by2;
    }

    public boolean contains(byte by2) {
        int n2 = this.size - 1;
        byte[] byArray = this.items;
        while (n2 >= 0) {
            if (byArray[n2--] != by2) continue;
            return true;
        }
        return false;
    }

    public int indexOf(byte by2) {
        byte[] byArray = this.items;
        int n2 = this.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (byArray[i2] != by2) continue;
            return i2;
        }
        return -1;
    }

    public int lastIndexOf(byte by2) {
        byte[] byArray = this.items;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            if (byArray[i2] != by2) continue;
            return i2;
        }
        return -1;
    }

    public boolean removeValue(byte by2) {
        byte[] byArray = this.items;
        int n2 = this.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (byArray[i2] != by2) continue;
            this.removeIndex(i2);
            return true;
        }
        return false;
    }

    public int removeIndex(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        byte[] byArray = this.items;
        byte by2 = byArray[n2];
        --this.size;
        if (this.ordered) {
            System.arraycopy(byArray, n2 + 1, byArray, n2, this.size - n2);
        } else {
            byArray[n2] = byArray[this.size];
        }
        return by2;
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

    public boolean removeAll(ByteArray byteArray) {
        int n2;
        int n3 = n2 = this.size;
        byte[] byArray = this.items;
        int n4 = byteArray.size;
        block0: for (int i2 = 0; i2 < n4; ++i2) {
            byte by2 = byteArray.get(i2);
            for (int i3 = 0; i3 < n2; ++i3) {
                if (by2 != byArray[i3]) continue;
                this.removeIndex(i3);
                --n2;
                continue block0;
            }
        }
        return n2 != n3;
    }

    public byte pop() {
        return this.items[--this.size];
    }

    public byte peek() {
        return this.items[this.size - 1];
    }

    public byte first() {
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

    public byte[] shrink() {
        if (this.items.length != this.size) {
            this.resize(this.size);
        }
        return this.items;
    }

    public byte[] ensureCapacity(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + n2);
        }
        int n3 = this.size + n2;
        if (n3 > this.items.length) {
            this.resize(Math.max(Math.max(8, n3), (int)((float)this.size * 1.75f)));
        }
        return this.items;
    }

    public byte[] setSize(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("newSize must be >= 0: " + n2);
        }
        if (n2 > this.items.length) {
            this.resize(Math.max(8, n2));
        }
        this.size = n2;
        return this.items;
    }

    protected byte[] resize(int n2) {
        byte[] byArray = new byte[n2];
        byte[] byArray2 = this.items;
        System.arraycopy(byArray2, 0, byArray, 0, Math.min(this.size, byArray.length));
        this.items = byArray;
        return byArray;
    }

    public void sort() {
        Arrays.sort(this.items, 0, this.size);
    }

    public void reverse() {
        byte[] byArray = this.items;
        int n2 = this.size - 1;
        int n3 = this.size / 2;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = n2 - i2;
            byte by2 = byArray[i2];
            byArray[i2] = byArray[n4];
            byArray[n4] = by2;
        }
    }

    public void shuffle() {
        byte[] byArray = this.items;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            int n2 = MathUtils.random(i2);
            byte by2 = byArray[i2];
            byArray[i2] = byArray[n2];
            byArray[n2] = by2;
        }
    }

    public void truncate(int n2) {
        if (this.size > n2) {
            this.size = n2;
        }
    }

    public byte random() {
        if (this.size == 0) {
            return 0;
        }
        return this.items[MathUtils.random(0, this.size - 1)];
    }

    public byte[] toArray() {
        byte[] byArray = new byte[this.size];
        System.arraycopy(this.items, 0, byArray, 0, this.size);
        return byArray;
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        byte[] byArray = this.items;
        int n2 = 1;
        int n3 = this.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 = n2 * 31 + byArray[i2];
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
        if (!(object instanceof ByteArray)) {
            return false;
        }
        ByteArray byteArray = (ByteArray)object;
        if (!byteArray.ordered) {
            return false;
        }
        int n2 = this.size;
        if (n2 != byteArray.size) {
            return false;
        }
        byte[] byArray = this.items;
        byte[] byArray2 = byteArray.items;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (byArray[i2] == byArray2[i2]) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        byte[] byArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(byArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(", ");
            stringBuilder.append(byArray[i2]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String toString(String string) {
        if (this.size == 0) {
            return "";
        }
        byte[] byArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(byArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(string);
            stringBuilder.append(byArray[i2]);
        }
        return stringBuilder.toString();
    }

    public static ByteArray with(byte ... byArray) {
        return new ByteArray(byArray);
    }
}

