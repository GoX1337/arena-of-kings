/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.StringBuilder;

public class BooleanArray {
    public boolean[] items;
    public int size;
    public boolean ordered;

    public BooleanArray() {
        this(true, 16);
    }

    public BooleanArray(int n2) {
        this(true, n2);
    }

    public BooleanArray(boolean bl2, int n2) {
        this.ordered = bl2;
        this.items = new boolean[n2];
    }

    public BooleanArray(BooleanArray booleanArray) {
        this.ordered = booleanArray.ordered;
        this.size = booleanArray.size;
        this.items = new boolean[this.size];
        System.arraycopy(booleanArray.items, 0, this.items, 0, this.size);
    }

    public BooleanArray(boolean[] blArray) {
        this(true, blArray, 0, blArray.length);
    }

    public BooleanArray(boolean bl2, boolean[] blArray, int n2, int n3) {
        this(bl2, n3);
        this.size = n3;
        System.arraycopy(blArray, n2, this.items, 0, n3);
    }

    public void add(boolean bl2) {
        boolean[] blArray = this.items;
        if (this.size == blArray.length) {
            blArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        blArray[this.size++] = bl2;
    }

    public void add(boolean bl2, boolean bl3) {
        boolean[] blArray = this.items;
        if (this.size + 1 >= blArray.length) {
            blArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        blArray[this.size] = bl2;
        blArray[this.size + 1] = bl3;
        this.size += 2;
    }

    public void add(boolean bl2, boolean bl3, boolean bl4) {
        boolean[] blArray = this.items;
        if (this.size + 2 >= blArray.length) {
            blArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        blArray[this.size] = bl2;
        blArray[this.size + 1] = bl3;
        blArray[this.size + 2] = bl4;
        this.size += 3;
    }

    public void add(boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        boolean[] blArray = this.items;
        if (this.size + 3 >= blArray.length) {
            blArray = this.resize(Math.max(8, (int)((float)this.size * 1.8f)));
        }
        blArray[this.size] = bl2;
        blArray[this.size + 1] = bl3;
        blArray[this.size + 2] = bl4;
        blArray[this.size + 3] = bl5;
        this.size += 4;
    }

    public void addAll(BooleanArray booleanArray) {
        this.addAll(booleanArray.items, 0, booleanArray.size);
    }

    public void addAll(BooleanArray booleanArray, int n2, int n3) {
        if (n2 + n3 > booleanArray.size) {
            throw new IllegalArgumentException("offset + length must be <= size: " + n2 + " + " + n3 + " <= " + booleanArray.size);
        }
        this.addAll(booleanArray.items, n2, n3);
    }

    public void addAll(boolean ... blArray) {
        this.addAll(blArray, 0, blArray.length);
    }

    public void addAll(boolean[] blArray, int n2, int n3) {
        int n4 = this.size + n3;
        boolean[] blArray2 = this.items;
        if (n4 > blArray2.length) {
            blArray2 = this.resize(Math.max(Math.max(8, n4), (int)((float)this.size * 1.75f)));
        }
        System.arraycopy(blArray, n2, blArray2, this.size, n3);
        this.size += n3;
    }

    public boolean get(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        return this.items[n2];
    }

    public void set(int n2, boolean bl2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        this.items[n2] = bl2;
    }

    public void insert(int n2, boolean bl2) {
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException("index can't be > size: " + n2 + " > " + this.size);
        }
        boolean[] blArray = this.items;
        if (this.size == blArray.length) {
            blArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        if (this.ordered) {
            System.arraycopy(blArray, n2, blArray, n2 + 1, this.size - n2);
        } else {
            blArray[this.size] = blArray[n2];
        }
        ++this.size;
        blArray[n2] = bl2;
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
        boolean[] blArray = this.items;
        boolean bl2 = blArray[n2];
        blArray[n2] = blArray[n3];
        blArray[n3] = bl2;
    }

    public boolean removeIndex(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        boolean[] blArray = this.items;
        boolean bl2 = blArray[n2];
        --this.size;
        if (this.ordered) {
            System.arraycopy(blArray, n2 + 1, blArray, n2, this.size - n2);
        } else {
            blArray[n2] = blArray[this.size];
        }
        return bl2;
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

    public boolean removeAll(BooleanArray booleanArray) {
        int n2;
        int n3 = n2 = this.size;
        boolean[] blArray = this.items;
        int n4 = booleanArray.size;
        block0: for (int i2 = 0; i2 < n4; ++i2) {
            boolean bl2 = booleanArray.get(i2);
            for (int i3 = 0; i3 < n2; ++i3) {
                if (bl2 != blArray[i3]) continue;
                this.removeIndex(i3);
                --n2;
                continue block0;
            }
        }
        return n2 != n3;
    }

    public boolean pop() {
        return this.items[--this.size];
    }

    public boolean peek() {
        return this.items[this.size - 1];
    }

    public boolean first() {
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

    public boolean[] shrink() {
        if (this.items.length != this.size) {
            this.resize(this.size);
        }
        return this.items;
    }

    public boolean[] ensureCapacity(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + n2);
        }
        int n3 = this.size + n2;
        if (n3 > this.items.length) {
            this.resize(Math.max(Math.max(8, n3), (int)((float)this.size * 1.75f)));
        }
        return this.items;
    }

    public boolean[] setSize(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("newSize must be >= 0: " + n2);
        }
        if (n2 > this.items.length) {
            this.resize(Math.max(8, n2));
        }
        this.size = n2;
        return this.items;
    }

    protected boolean[] resize(int n2) {
        boolean[] blArray = new boolean[n2];
        boolean[] blArray2 = this.items;
        System.arraycopy(blArray2, 0, blArray, 0, Math.min(this.size, blArray.length));
        this.items = blArray;
        return blArray;
    }

    public void reverse() {
        boolean[] blArray = this.items;
        int n2 = this.size - 1;
        int n3 = this.size / 2;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = n2 - i2;
            boolean bl2 = blArray[i2];
            blArray[i2] = blArray[n4];
            blArray[n4] = bl2;
        }
    }

    public void shuffle() {
        boolean[] blArray = this.items;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            int n2 = MathUtils.random(i2);
            boolean bl2 = blArray[i2];
            blArray[i2] = blArray[n2];
            blArray[n2] = bl2;
        }
    }

    public void truncate(int n2) {
        if (this.size > n2) {
            this.size = n2;
        }
    }

    public boolean random() {
        if (this.size == 0) {
            return false;
        }
        return this.items[MathUtils.random(0, this.size - 1)];
    }

    public boolean[] toArray() {
        boolean[] blArray = new boolean[this.size];
        System.arraycopy(this.items, 0, blArray, 0, this.size);
        return blArray;
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        boolean[] blArray = this.items;
        int n2 = 1;
        int n3 = this.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 = n2 * 31 + (blArray[i2] ? 1231 : 1237);
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
        if (!(object instanceof BooleanArray)) {
            return false;
        }
        BooleanArray booleanArray = (BooleanArray)object;
        if (!booleanArray.ordered) {
            return false;
        }
        int n2 = this.size;
        if (n2 != booleanArray.size) {
            return false;
        }
        boolean[] blArray = this.items;
        boolean[] blArray2 = booleanArray.items;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (blArray[i2] == blArray2[i2]) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        boolean[] blArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(blArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(", ");
            stringBuilder.append(blArray[i2]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String toString(String string) {
        if (this.size == 0) {
            return "";
        }
        boolean[] blArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(blArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(string);
            stringBuilder.append(blArray[i2]);
        }
        return stringBuilder.toString();
    }

    public static BooleanArray with(boolean ... blArray) {
        return new BooleanArray(blArray);
    }
}

