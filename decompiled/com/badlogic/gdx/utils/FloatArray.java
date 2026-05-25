/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.NumberUtils;
import com.badlogic.gdx.utils.StringBuilder;
import java.util.Arrays;

public class FloatArray {
    public float[] items;
    public int size;
    public boolean ordered;

    public FloatArray() {
        this(true, 16);
    }

    public FloatArray(int n2) {
        this(true, n2);
    }

    public FloatArray(boolean bl2, int n2) {
        this.ordered = bl2;
        this.items = new float[n2];
    }

    public FloatArray(FloatArray floatArray) {
        this.ordered = floatArray.ordered;
        this.size = floatArray.size;
        this.items = new float[this.size];
        System.arraycopy(floatArray.items, 0, this.items, 0, this.size);
    }

    public FloatArray(float[] fArray) {
        this(true, fArray, 0, fArray.length);
    }

    public FloatArray(boolean bl2, float[] fArray, int n2, int n3) {
        this(bl2, n3);
        this.size = n3;
        System.arraycopy(fArray, n2, this.items, 0, n3);
    }

    public void add(float f2) {
        float[] fArray = this.items;
        if (this.size == fArray.length) {
            fArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        fArray[this.size++] = f2;
    }

    public void add(float f2, float f3) {
        float[] fArray = this.items;
        if (this.size + 1 >= fArray.length) {
            fArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        fArray[this.size] = f2;
        fArray[this.size + 1] = f3;
        this.size += 2;
    }

    public void add(float f2, float f3, float f4) {
        float[] fArray = this.items;
        if (this.size + 2 >= fArray.length) {
            fArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        fArray[this.size] = f2;
        fArray[this.size + 1] = f3;
        fArray[this.size + 2] = f4;
        this.size += 3;
    }

    public void add(float f2, float f3, float f4, float f5) {
        float[] fArray = this.items;
        if (this.size + 3 >= fArray.length) {
            fArray = this.resize(Math.max(8, (int)((float)this.size * 1.8f)));
        }
        fArray[this.size] = f2;
        fArray[this.size + 1] = f3;
        fArray[this.size + 2] = f4;
        fArray[this.size + 3] = f5;
        this.size += 4;
    }

    public void addAll(FloatArray floatArray) {
        this.addAll(floatArray.items, 0, floatArray.size);
    }

    public void addAll(FloatArray floatArray, int n2, int n3) {
        if (n2 + n3 > floatArray.size) {
            throw new IllegalArgumentException("offset + length must be <= size: " + n2 + " + " + n3 + " <= " + floatArray.size);
        }
        this.addAll(floatArray.items, n2, n3);
    }

    public void addAll(float ... fArray) {
        this.addAll(fArray, 0, fArray.length);
    }

    public void addAll(float[] fArray, int n2, int n3) {
        int n4 = this.size + n3;
        float[] fArray2 = this.items;
        if (n4 > fArray2.length) {
            fArray2 = this.resize(Math.max(Math.max(8, n4), (int)((float)this.size * 1.75f)));
        }
        System.arraycopy(fArray, n2, fArray2, this.size, n3);
        this.size += n3;
    }

    public float get(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        return this.items[n2];
    }

    public void set(int n2, float f2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        this.items[n2] = f2;
    }

    public void incr(int n2, float f2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int n3 = n2;
        this.items[n3] = this.items[n3] + f2;
    }

    public void incr(float f2) {
        float[] fArray = this.items;
        int n2 = 0;
        int n3 = this.size;
        while (n2 < n3) {
            int n4 = n2++;
            fArray[n4] = fArray[n4] + f2;
        }
    }

    public void mul(int n2, float f2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int n3 = n2;
        this.items[n3] = this.items[n3] * f2;
    }

    public void mul(float f2) {
        float[] fArray = this.items;
        int n2 = 0;
        int n3 = this.size;
        while (n2 < n3) {
            int n4 = n2++;
            fArray[n4] = fArray[n4] * f2;
        }
    }

    public void insert(int n2, float f2) {
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException("index can't be > size: " + n2 + " > " + this.size);
        }
        float[] fArray = this.items;
        if (this.size == fArray.length) {
            fArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        if (this.ordered) {
            System.arraycopy(fArray, n2, fArray, n2 + 1, this.size - n2);
        } else {
            fArray[this.size] = fArray[n2];
        }
        ++this.size;
        fArray[n2] = f2;
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
        float[] fArray = this.items;
        float f2 = fArray[n2];
        fArray[n2] = fArray[n3];
        fArray[n3] = f2;
    }

    public boolean contains(float f2) {
        int n2 = this.size - 1;
        float[] fArray = this.items;
        while (n2 >= 0) {
            if (fArray[n2--] != f2) continue;
            return true;
        }
        return false;
    }

    public int indexOf(float f2) {
        float[] fArray = this.items;
        int n2 = this.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (fArray[i2] != f2) continue;
            return i2;
        }
        return -1;
    }

    public int lastIndexOf(float f2) {
        float[] fArray = this.items;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            if (fArray[i2] != f2) continue;
            return i2;
        }
        return -1;
    }

    public boolean removeValue(float f2) {
        float[] fArray = this.items;
        int n2 = this.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (fArray[i2] != f2) continue;
            this.removeIndex(i2);
            return true;
        }
        return false;
    }

    public float removeIndex(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        float[] fArray = this.items;
        float f2 = fArray[n2];
        --this.size;
        if (this.ordered) {
            System.arraycopy(fArray, n2 + 1, fArray, n2, this.size - n2);
        } else {
            fArray[n2] = fArray[this.size];
        }
        return f2;
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

    public boolean removeAll(FloatArray floatArray) {
        int n2;
        int n3 = n2 = this.size;
        float[] fArray = this.items;
        int n4 = floatArray.size;
        block0: for (int i2 = 0; i2 < n4; ++i2) {
            float f2 = floatArray.get(i2);
            for (int i3 = 0; i3 < n2; ++i3) {
                if (f2 != fArray[i3]) continue;
                this.removeIndex(i3);
                --n2;
                continue block0;
            }
        }
        return n2 != n3;
    }

    public float pop() {
        return this.items[--this.size];
    }

    public float peek() {
        return this.items[this.size - 1];
    }

    public float first() {
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

    public float[] shrink() {
        if (this.items.length != this.size) {
            this.resize(this.size);
        }
        return this.items;
    }

    public float[] ensureCapacity(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + n2);
        }
        int n3 = this.size + n2;
        if (n3 > this.items.length) {
            this.resize(Math.max(Math.max(8, n3), (int)((float)this.size * 1.75f)));
        }
        return this.items;
    }

    public float[] setSize(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("newSize must be >= 0: " + n2);
        }
        if (n2 > this.items.length) {
            this.resize(Math.max(8, n2));
        }
        this.size = n2;
        return this.items;
    }

    protected float[] resize(int n2) {
        float[] fArray = new float[n2];
        float[] fArray2 = this.items;
        System.arraycopy(fArray2, 0, fArray, 0, Math.min(this.size, fArray.length));
        this.items = fArray;
        return fArray;
    }

    public void sort() {
        Arrays.sort(this.items, 0, this.size);
    }

    public void reverse() {
        float[] fArray = this.items;
        int n2 = this.size - 1;
        int n3 = this.size / 2;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = n2 - i2;
            float f2 = fArray[i2];
            fArray[i2] = fArray[n4];
            fArray[n4] = f2;
        }
    }

    public void shuffle() {
        float[] fArray = this.items;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            int n2 = MathUtils.random(i2);
            float f2 = fArray[i2];
            fArray[i2] = fArray[n2];
            fArray[n2] = f2;
        }
    }

    public void truncate(int n2) {
        if (this.size > n2) {
            this.size = n2;
        }
    }

    public float random() {
        if (this.size == 0) {
            return 0.0f;
        }
        return this.items[MathUtils.random(0, this.size - 1)];
    }

    public float[] toArray() {
        float[] fArray = new float[this.size];
        System.arraycopy(this.items, 0, fArray, 0, this.size);
        return fArray;
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        float[] fArray = this.items;
        int n2 = 1;
        int n3 = this.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 = n2 * 31 + NumberUtils.floatToRawIntBits(fArray[i2]);
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
        if (!(object instanceof FloatArray)) {
            return false;
        }
        FloatArray floatArray = (FloatArray)object;
        if (!floatArray.ordered) {
            return false;
        }
        int n2 = this.size;
        if (n2 != floatArray.size) {
            return false;
        }
        float[] fArray = this.items;
        float[] fArray2 = floatArray.items;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (fArray[i2] == fArray2[i2]) continue;
            return false;
        }
        return true;
    }

    public boolean equals(Object object, float f2) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof FloatArray)) {
            return false;
        }
        FloatArray floatArray = (FloatArray)object;
        int n2 = this.size;
        if (n2 != floatArray.size) {
            return false;
        }
        if (!this.ordered) {
            return false;
        }
        if (!floatArray.ordered) {
            return false;
        }
        float[] fArray = this.items;
        float[] fArray2 = floatArray.items;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!(Math.abs(fArray[i2] - fArray2[i2]) > f2)) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        float[] fArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(fArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(", ");
            stringBuilder.append(fArray[i2]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String toString(String string) {
        if (this.size == 0) {
            return "";
        }
        float[] fArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(fArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(string);
            stringBuilder.append(fArray[i2]);
        }
        return stringBuilder.toString();
    }

    public static FloatArray with(float ... fArray) {
        return new FloatArray(fArray);
    }
}

