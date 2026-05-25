/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.NumberUtils;
import com.badlogic.gdx.utils.ObjectSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntFloatMap
implements Iterable<Entry> {
    public int size;
    int[] keyTable;
    float[] valueTable;
    float zeroValue;
    boolean hasZeroValue;
    private final float loadFactor;
    private int threshold;
    protected int shift;
    protected int mask;
    private transient Entries entries1;
    private transient Entries entries2;
    private transient Values values1;
    private transient Values values2;
    private transient Keys keys1;
    private transient Keys keys2;

    public IntFloatMap() {
        this(51, 0.8f);
    }

    public IntFloatMap(int n2) {
        this(n2, 0.8f);
    }

    public IntFloatMap(int n2, float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
        }
        this.loadFactor = f2;
        int n3 = ObjectSet.tableSize(n2, f2);
        this.threshold = (int)((float)n3 * f2);
        this.mask = n3 - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new int[n3];
        this.valueTable = new float[n3];
    }

    public IntFloatMap(IntFloatMap intFloatMap) {
        this((int)((float)intFloatMap.keyTable.length * intFloatMap.loadFactor), intFloatMap.loadFactor);
        System.arraycopy(intFloatMap.keyTable, 0, this.keyTable, 0, intFloatMap.keyTable.length);
        System.arraycopy(intFloatMap.valueTable, 0, this.valueTable, 0, intFloatMap.valueTable.length);
        this.size = intFloatMap.size;
        this.zeroValue = intFloatMap.zeroValue;
        this.hasZeroValue = intFloatMap.hasZeroValue;
    }

    protected int place(int n2) {
        return (int)((long)n2 * -7046029254386353131L >>> this.shift);
    }

    private int locateKey(int n2) {
        int[] nArray = this.keyTable;
        int n3 = this.place(n2);
        int n4;
        while ((n4 = nArray[n3]) != 0) {
            if (n4 == n2) {
                return n3;
            }
            n3 = n3 + 1 & this.mask;
        }
        return -(n3 + 1);
    }

    public void put(int n2, float f2) {
        if (n2 == 0) {
            this.zeroValue = f2;
            if (!this.hasZeroValue) {
                this.hasZeroValue = true;
                ++this.size;
            }
            return;
        }
        int n3 = this.locateKey(n2);
        if (n3 >= 0) {
            this.valueTable[n3] = f2;
            return;
        }
        n3 = -(n3 + 1);
        this.keyTable[n3] = n2;
        this.valueTable[n3] = f2;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
    }

    public float put(int n2, float f2, float f3) {
        if (n2 == 0) {
            float f4 = this.zeroValue;
            this.zeroValue = f2;
            if (!this.hasZeroValue) {
                this.hasZeroValue = true;
                ++this.size;
                return f3;
            }
            return f4;
        }
        int n3 = this.locateKey(n2);
        if (n3 >= 0) {
            float f5 = this.valueTable[n3];
            this.valueTable[n3] = f2;
            return f5;
        }
        n3 = -(n3 + 1);
        this.keyTable[n3] = n2;
        this.valueTable[n3] = f2;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return f3;
    }

    public void putAll(IntFloatMap intFloatMap) {
        this.ensureCapacity(intFloatMap.size);
        if (intFloatMap.hasZeroValue) {
            this.put(0, intFloatMap.zeroValue);
        }
        int[] nArray = intFloatMap.keyTable;
        float[] fArray = intFloatMap.valueTable;
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = nArray[i2];
            if (n3 == 0) continue;
            this.put(n3, fArray[i2]);
        }
    }

    private void putResize(int n2, float f2) {
        int[] nArray = this.keyTable;
        int n3 = this.place(n2);
        while (true) {
            if (nArray[n3] == 0) {
                nArray[n3] = n2;
                this.valueTable[n3] = f2;
                return;
            }
            n3 = n3 + 1 & this.mask;
        }
    }

    public float get(int n2, float f2) {
        if (n2 == 0) {
            return this.hasZeroValue ? this.zeroValue : f2;
        }
        int n3 = this.locateKey(n2);
        return n3 >= 0 ? this.valueTable[n3] : f2;
    }

    public float getAndIncrement(int n2, float f2, float f3) {
        if (n2 == 0) {
            if (!this.hasZeroValue) {
                this.hasZeroValue = true;
                this.zeroValue = f2 + f3;
                ++this.size;
                return f2;
            }
            float f4 = this.zeroValue;
            this.zeroValue += f3;
            return f4;
        }
        int n3 = this.locateKey(n2);
        if (n3 >= 0) {
            float f5 = this.valueTable[n3];
            int n4 = n3;
            this.valueTable[n4] = this.valueTable[n4] + f3;
            return f5;
        }
        n3 = -(n3 + 1);
        this.keyTable[n3] = n2;
        this.valueTable[n3] = f2 + f3;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return f2;
    }

    public float remove(int n2, float f2) {
        if (n2 == 0) {
            if (!this.hasZeroValue) {
                return f2;
            }
            this.hasZeroValue = false;
            --this.size;
            return this.zeroValue;
        }
        int n3 = this.locateKey(n2);
        if (n3 < 0) {
            return f2;
        }
        int[] nArray = this.keyTable;
        float[] fArray = this.valueTable;
        float f3 = fArray[n3];
        int n4 = this.mask;
        int n5 = n3 + 1 & n4;
        while ((n2 = nArray[n5]) != 0) {
            int n6 = this.place(n2);
            if ((n5 - n6 & n4) > (n3 - n6 & n4)) {
                nArray[n3] = n2;
                fArray[n3] = fArray[n5];
                n3 = n5;
            }
            n5 = n5 + 1 & n4;
        }
        nArray[n3] = 0;
        --this.size;
        return f3;
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void shrink(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("maximumCapacity must be >= 0: " + n2);
        }
        int n3 = ObjectSet.tableSize(n2, this.loadFactor);
        if (this.keyTable.length > n3) {
            this.resize(n3);
        }
    }

    public void clear(int n2) {
        int n3 = ObjectSet.tableSize(n2, this.loadFactor);
        if (this.keyTable.length <= n3) {
            this.clear();
            return;
        }
        this.size = 0;
        this.hasZeroValue = false;
        this.resize(n3);
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        Arrays.fill(this.keyTable, 0);
        this.size = 0;
        this.hasZeroValue = false;
    }

    public boolean containsValue(float f2) {
        if (this.hasZeroValue && this.zeroValue == f2) {
            return true;
        }
        int[] nArray = this.keyTable;
        float[] fArray = this.valueTable;
        for (int i2 = fArray.length - 1; i2 >= 0; --i2) {
            if (nArray[i2] == 0 || fArray[i2] != f2) continue;
            return true;
        }
        return false;
    }

    public boolean containsValue(float f2, float f3) {
        if (this.hasZeroValue && Math.abs(this.zeroValue - f2) <= f3) {
            return true;
        }
        int[] nArray = this.keyTable;
        float[] fArray = this.valueTable;
        for (int i2 = fArray.length - 1; i2 >= 0; --i2) {
            if (nArray[i2] == 0 || !(Math.abs(fArray[i2] - f2) <= f3)) continue;
            return true;
        }
        return false;
    }

    public boolean containsKey(int n2) {
        if (n2 == 0) {
            return this.hasZeroValue;
        }
        return this.locateKey(n2) >= 0;
    }

    public int findKey(float f2, int n2) {
        if (this.hasZeroValue && this.zeroValue == f2) {
            return 0;
        }
        int[] nArray = this.keyTable;
        float[] fArray = this.valueTable;
        for (int i2 = fArray.length - 1; i2 >= 0; --i2) {
            if (nArray[i2] == 0 || fArray[i2] != f2) continue;
            return nArray[i2];
        }
        return n2;
    }

    public int findKey(float f2, float f3, int n2) {
        if (this.hasZeroValue && Math.abs(this.zeroValue - f2) <= f3) {
            return 0;
        }
        int[] nArray = this.keyTable;
        float[] fArray = this.valueTable;
        for (int i2 = fArray.length - 1; i2 >= 0; --i2) {
            if (nArray[i2] == 0 || !(Math.abs(fArray[i2] - f2) <= f3)) continue;
            return nArray[i2];
        }
        return n2;
    }

    public void ensureCapacity(int n2) {
        int n3 = ObjectSet.tableSize(this.size + n2, this.loadFactor);
        if (this.keyTable.length < n3) {
            this.resize(n3);
        }
    }

    private void resize(int n2) {
        int n3 = this.keyTable.length;
        this.threshold = (int)((float)n2 * this.loadFactor);
        this.mask = n2 - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        int[] nArray = this.keyTable;
        float[] fArray = this.valueTable;
        this.keyTable = new int[n2];
        this.valueTable = new float[n2];
        if (this.size > 0) {
            for (int i2 = 0; i2 < n3; ++i2) {
                int n4 = nArray[i2];
                if (n4 == 0) continue;
                this.putResize(n4, fArray[i2]);
            }
        }
    }

    public int hashCode() {
        int n2 = this.size;
        if (this.hasZeroValue) {
            n2 += NumberUtils.floatToRawIntBits(this.zeroValue);
        }
        int[] nArray = this.keyTable;
        float[] fArray = this.valueTable;
        int n3 = nArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = nArray[i2];
            if (n4 == 0) continue;
            n2 += n4 * 31 + NumberUtils.floatToRawIntBits(fArray[i2]);
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IntFloatMap)) {
            return false;
        }
        IntFloatMap intFloatMap = (IntFloatMap)object;
        if (intFloatMap.size != this.size) {
            return false;
        }
        if (intFloatMap.hasZeroValue != this.hasZeroValue) {
            return false;
        }
        if (this.hasZeroValue && intFloatMap.zeroValue != this.zeroValue) {
            return false;
        }
        int[] nArray = this.keyTable;
        float[] fArray = this.valueTable;
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = nArray[i2];
            if (n3 == 0) continue;
            float f2 = intFloatMap.get(n3, 0.0f);
            if (f2 == 0.0f && !intFloatMap.containsKey(n3)) {
                return false;
            }
            if (f2 == fArray[i2]) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        int n2;
        if (this.size == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        int[] nArray = this.keyTable;
        float[] fArray = this.valueTable;
        int n3 = nArray.length;
        if (this.hasZeroValue) {
            stringBuilder.append("0=");
            stringBuilder.append(this.zeroValue);
        } else {
            while (n3-- > 0) {
                n2 = nArray[n3];
                if (n2 == 0) continue;
                stringBuilder.append(n2);
                stringBuilder.append('=');
                stringBuilder.append(fArray[n3]);
                break;
            }
        }
        while (n3-- > 0) {
            n2 = nArray[n3];
            if (n2 == 0) continue;
            stringBuilder.append(", ");
            stringBuilder.append(n2);
            stringBuilder.append('=');
            stringBuilder.append(fArray[n3]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Entry> iterator() {
        return this.entries();
    }

    public Entries entries() {
        if (Collections.allocateIterators) {
            return new Entries(this);
        }
        if (this.entries1 == null) {
            this.entries1 = new Entries(this);
            this.entries2 = new Entries(this);
        }
        if (!this.entries1.valid) {
            this.entries1.reset();
            this.entries1.valid = true;
            this.entries2.valid = false;
            return this.entries1;
        }
        this.entries2.reset();
        this.entries2.valid = true;
        this.entries1.valid = false;
        return this.entries2;
    }

    public Values values() {
        if (Collections.allocateIterators) {
            return new Values(this);
        }
        if (this.values1 == null) {
            this.values1 = new Values(this);
            this.values2 = new Values(this);
        }
        if (!this.values1.valid) {
            this.values1.reset();
            this.values1.valid = true;
            this.values2.valid = false;
            return this.values1;
        }
        this.values2.reset();
        this.values2.valid = true;
        this.values1.valid = false;
        return this.values2;
    }

    public Keys keys() {
        if (Collections.allocateIterators) {
            return new Keys(this);
        }
        if (this.keys1 == null) {
            this.keys1 = new Keys(this);
            this.keys2 = new Keys(this);
        }
        if (!this.keys1.valid) {
            this.keys1.reset();
            this.keys1.valid = true;
            this.keys2.valid = false;
            return this.keys1;
        }
        this.keys2.reset();
        this.keys2.valid = true;
        this.keys1.valid = false;
        return this.keys2;
    }

    public static class Keys
    extends MapIterator {
        public Keys(IntFloatMap intFloatMap) {
            super(intFloatMap);
        }

        public int next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            int n2 = this.nextIndex == -1 ? 0 : this.map.keyTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return n2;
        }

        public IntArray toArray() {
            IntArray intArray = new IntArray(true, this.map.size);
            while (this.hasNext) {
                intArray.add(this.next());
            }
            return intArray;
        }

        public IntArray toArray(IntArray intArray) {
            while (this.hasNext) {
                intArray.add(this.next());
            }
            return intArray;
        }
    }

    public static class Values
    extends MapIterator {
        public Values(IntFloatMap intFloatMap) {
            super(intFloatMap);
        }

        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.hasNext;
        }

        public float next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            float f2 = this.nextIndex == -1 ? this.map.zeroValue : this.map.valueTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return f2;
        }

        public Values iterator() {
            return this;
        }

        public FloatArray toArray() {
            FloatArray floatArray = new FloatArray(true, this.map.size);
            while (this.hasNext) {
                floatArray.add(this.next());
            }
            return floatArray;
        }

        public FloatArray toArray(FloatArray floatArray) {
            while (this.hasNext) {
                floatArray.add(this.next());
            }
            return floatArray;
        }
    }

    public static class Entries
    extends MapIterator
    implements Iterable<Entry>,
    Iterator<Entry> {
        private final Entry entry = new Entry();

        public Entries(IntFloatMap intFloatMap) {
            super(intFloatMap);
        }

        @Override
        public Entry next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            int[] nArray = this.map.keyTable;
            if (this.nextIndex == -1) {
                this.entry.key = 0;
                this.entry.value = this.map.zeroValue;
            } else {
                this.entry.key = nArray[this.nextIndex];
                this.entry.value = this.map.valueTable[this.nextIndex];
            }
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return this.entry;
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.hasNext;
        }

        @Override
        public Iterator<Entry> iterator() {
            return this;
        }

        @Override
        public void remove() {
            super.remove();
        }
    }

    static class MapIterator {
        private static final int INDEX_ILLEGAL = -2;
        static final int INDEX_ZERO = -1;
        public boolean hasNext;
        final IntFloatMap map;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public MapIterator(IntFloatMap intFloatMap) {
            this.map = intFloatMap;
            this.reset();
        }

        public void reset() {
            this.currentIndex = -2;
            this.nextIndex = -1;
            if (this.map.hasZeroValue) {
                this.hasNext = true;
            } else {
                this.findNextIndex();
            }
        }

        void findNextIndex() {
            int[] nArray = this.map.keyTable;
            int n2 = nArray.length;
            while (++this.nextIndex < n2) {
                if (nArray[this.nextIndex] == 0) continue;
                this.hasNext = true;
                return;
            }
            this.hasNext = false;
        }

        public void remove() {
            int n2 = this.currentIndex;
            if (n2 == -1 && this.map.hasZeroValue) {
                this.map.hasZeroValue = false;
            } else {
                int n3;
                if (n2 < 0) {
                    throw new IllegalStateException("next must be called before remove.");
                }
                int[] nArray = this.map.keyTable;
                float[] fArray = this.map.valueTable;
                int n4 = this.map.mask;
                int n5 = n2 + 1 & n4;
                while ((n3 = nArray[n5]) != 0) {
                    int n6 = this.map.place(n3);
                    if ((n5 - n6 & n4) > (n2 - n6 & n4)) {
                        nArray[n2] = n3;
                        fArray[n2] = fArray[n5];
                        n2 = n5;
                    }
                    n5 = n5 + 1 & n4;
                }
                nArray[n2] = 0;
                if (n2 != this.currentIndex) {
                    --this.nextIndex;
                }
            }
            this.currentIndex = -2;
            --this.map.size;
        }
    }

    public static class Entry {
        public int key;
        public float value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}

