/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.StringBuilder;
import java.util.Arrays;

public class IntArray {
    public int[] items;
    public int size;
    public boolean ordered;

    public IntArray() {
        this(true, 16);
    }

    public IntArray(int n2) {
        this(true, n2);
    }

    public IntArray(boolean bl2, int n2) {
        this.ordered = bl2;
        this.items = new int[n2];
    }

    public IntArray(IntArray intArray) {
        this.ordered = intArray.ordered;
        this.size = intArray.size;
        this.items = new int[this.size];
        System.arraycopy(intArray.items, 0, this.items, 0, this.size);
    }

    public IntArray(int[] nArray) {
        this(true, nArray, 0, nArray.length);
    }

    public IntArray(boolean bl2, int[] nArray, int n2, int n3) {
        this(bl2, n3);
        this.size = n3;
        System.arraycopy(nArray, n2, this.items, 0, n3);
    }

    public void add(int n2) {
        int[] nArray = this.items;
        if (this.size == nArray.length) {
            nArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        nArray[this.size++] = n2;
    }

    public void add(int n2, int n3) {
        int[] nArray = this.items;
        if (this.size + 1 >= nArray.length) {
            nArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        nArray[this.size] = n2;
        nArray[this.size + 1] = n3;
        this.size += 2;
    }

    public void add(int n2, int n3, int n4) {
        int[] nArray = this.items;
        if (this.size + 2 >= nArray.length) {
            nArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        nArray[this.size] = n2;
        nArray[this.size + 1] = n3;
        nArray[this.size + 2] = n4;
        this.size += 3;
    }

    public void add(int n2, int n3, int n4, int n5) {
        int[] nArray = this.items;
        if (this.size + 3 >= nArray.length) {
            nArray = this.resize(Math.max(8, (int)((float)this.size * 1.8f)));
        }
        nArray[this.size] = n2;
        nArray[this.size + 1] = n3;
        nArray[this.size + 2] = n4;
        nArray[this.size + 3] = n5;
        this.size += 4;
    }

    public void addAll(IntArray intArray) {
        this.addAll(intArray.items, 0, intArray.size);
    }

    public void addAll(IntArray intArray, int n2, int n3) {
        if (n2 + n3 > intArray.size) {
            throw new IllegalArgumentException("offset + length must be <= size: " + n2 + " + " + n3 + " <= " + intArray.size);
        }
        this.addAll(intArray.items, n2, n3);
    }

    public void addAll(int ... nArray) {
        this.addAll(nArray, 0, nArray.length);
    }

    public void addAll(int[] nArray, int n2, int n3) {
        int n4 = this.size + n3;
        int[] nArray2 = this.items;
        if (n4 > nArray2.length) {
            nArray2 = this.resize(Math.max(Math.max(8, n4), (int)((float)this.size * 1.75f)));
        }
        System.arraycopy(nArray, n2, nArray2, this.size, n3);
        this.size += n3;
    }

    public int get(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        return this.items[n2];
    }

    public void set(int n2, int n3) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        this.items[n2] = n3;
    }

    public void incr(int n2, int n3) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int n4 = n2;
        this.items[n4] = this.items[n4] + n3;
    }

    public void incr(int n2) {
        int[] nArray = this.items;
        int n3 = 0;
        int n4 = this.size;
        while (n3 < n4) {
            int n5 = n3++;
            nArray[n5] = nArray[n5] + n2;
        }
    }

    public void mul(int n2, int n3) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int n4 = n2;
        this.items[n4] = this.items[n4] * n3;
    }

    public void mul(int n2) {
        int[] nArray = this.items;
        int n3 = 0;
        int n4 = this.size;
        while (n3 < n4) {
            int n5 = n3++;
            nArray[n5] = nArray[n5] * n2;
        }
    }

    public void insert(int n2, int n3) {
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException("index can't be > size: " + n2 + " > " + this.size);
        }
        int[] nArray = this.items;
        if (this.size == nArray.length) {
            nArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        if (this.ordered) {
            System.arraycopy(nArray, n2, nArray, n2 + 1, this.size - n2);
        } else {
            nArray[this.size] = nArray[n2];
        }
        ++this.size;
        nArray[n2] = n3;
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
        int[] nArray = this.items;
        int n4 = nArray[n2];
        nArray[n2] = nArray[n3];
        nArray[n3] = n4;
    }

    public boolean contains(int n2) {
        int n3 = this.size - 1;
        int[] nArray = this.items;
        while (n3 >= 0) {
            if (nArray[n3--] != n2) continue;
            return true;
        }
        return false;
    }

    public int indexOf(int n2) {
        int[] nArray = this.items;
        int n3 = this.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (nArray[i2] != n2) continue;
            return i2;
        }
        return -1;
    }

    public int lastIndexOf(int n2) {
        int[] nArray = this.items;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            if (nArray[i2] != n2) continue;
            return i2;
        }
        return -1;
    }

    public boolean removeValue(int n2) {
        int[] nArray = this.items;
        int n3 = this.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (nArray[i2] != n2) continue;
            this.removeIndex(i2);
            return true;
        }
        return false;
    }

    public int removeIndex(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int[] nArray = this.items;
        int n3 = nArray[n2];
        --this.size;
        if (this.ordered) {
            System.arraycopy(nArray, n2 + 1, nArray, n2, this.size - n2);
        } else {
            nArray[n2] = nArray[this.size];
        }
        return n3;
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

    public boolean removeAll(IntArray intArray) {
        int n2;
        int n3 = n2 = this.size;
        int[] nArray = this.items;
        int n4 = intArray.size;
        block0: for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = intArray.get(i2);
            for (int i3 = 0; i3 < n2; ++i3) {
                if (n5 != nArray[i3]) continue;
                this.removeIndex(i3);
                --n2;
                continue block0;
            }
        }
        return n2 != n3;
    }

    public int pop() {
        return this.items[--this.size];
    }

    public int peek() {
        return this.items[this.size - 1];
    }

    public int first() {
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

    public int[] shrink() {
        if (this.items.length != this.size) {
            this.resize(this.size);
        }
        return this.items;
    }

    public int[] ensureCapacity(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + n2);
        }
        int n3 = this.size + n2;
        if (n3 > this.items.length) {
            this.resize(Math.max(Math.max(8, n3), (int)((float)this.size * 1.75f)));
        }
        return this.items;
    }

    public int[] setSize(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("newSize must be >= 0: " + n2);
        }
        if (n2 > this.items.length) {
            this.resize(Math.max(8, n2));
        }
        this.size = n2;
        return this.items;
    }

    protected int[] resize(int n2) {
        int[] nArray = new int[n2];
        int[] nArray2 = this.items;
        System.arraycopy(nArray2, 0, nArray, 0, Math.min(this.size, nArray.length));
        this.items = nArray;
        return nArray;
    }

    public void sort() {
        Arrays.sort(this.items, 0, this.size);
    }

    public void reverse() {
        int[] nArray = this.items;
        int n2 = this.size - 1;
        int n3 = this.size / 2;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = n2 - i2;
            int n5 = nArray[i2];
            nArray[i2] = nArray[n4];
            nArray[n4] = n5;
        }
    }

    public void shuffle() {
        int[] nArray = this.items;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            int n2 = MathUtils.random(i2);
            int n3 = nArray[i2];
            nArray[i2] = nArray[n2];
            nArray[n2] = n3;
        }
    }

    public void truncate(int n2) {
        if (this.size > n2) {
            this.size = n2;
        }
    }

    public int random() {
        if (this.size == 0) {
            return 0;
        }
        return this.items[MathUtils.random(0, this.size - 1)];
    }

    public int[] toArray() {
        int[] nArray = new int[this.size];
        System.arraycopy(this.items, 0, nArray, 0, this.size);
        return nArray;
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        int[] nArray = this.items;
        int n2 = 1;
        int n3 = this.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 = n2 * 31 + nArray[i2];
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
        if (!(object instanceof IntArray)) {
            return false;
        }
        IntArray intArray = (IntArray)object;
        if (!intArray.ordered) {
            return false;
        }
        int n2 = this.size;
        if (n2 != intArray.size) {
            return false;
        }
        int[] nArray = this.items;
        int[] nArray2 = intArray.items;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (nArray[i2] == nArray2[i2]) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        int[] nArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(nArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(", ");
            stringBuilder.append(nArray[i2]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String toString(String string) {
        if (this.size == 0) {
            return "";
        }
        int[] nArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(nArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(string);
            stringBuilder.append(nArray[i2]);
        }
        return stringBuilder.toString();
    }

    public static IntArray with(int ... nArray) {
        return new IntArray(nArray);
    }
}

