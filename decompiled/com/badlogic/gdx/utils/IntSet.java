/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ObjectSet;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntSet {
    public int size;
    int[] keyTable;
    boolean hasZeroValue;
    private final float loadFactor;
    private int threshold;
    protected int shift;
    protected int mask;
    private transient IntSetIterator iterator1;
    private transient IntSetIterator iterator2;

    public IntSet() {
        this(51, 0.8f);
    }

    public IntSet(int n2) {
        this(n2, 0.8f);
    }

    public IntSet(int n2, float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
        }
        this.loadFactor = f2;
        int n3 = ObjectSet.tableSize(n2, f2);
        this.threshold = (int)((float)n3 * f2);
        this.mask = n3 - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new int[n3];
    }

    public IntSet(IntSet intSet) {
        this((int)((float)intSet.keyTable.length * intSet.loadFactor), intSet.loadFactor);
        System.arraycopy(intSet.keyTable, 0, this.keyTable, 0, intSet.keyTable.length);
        this.size = intSet.size;
        this.hasZeroValue = intSet.hasZeroValue;
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

    public boolean add(int n2) {
        if (n2 == 0) {
            if (this.hasZeroValue) {
                return false;
            }
            this.hasZeroValue = true;
            ++this.size;
            return true;
        }
        int n3 = this.locateKey(n2);
        if (n3 >= 0) {
            return false;
        }
        n3 = -(n3 + 1);
        this.keyTable[n3] = n2;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return true;
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
        int n4;
        this.ensureCapacity(n3);
        int n5 = n4 + n3;
        for (n4 = n2; n4 < n5; ++n4) {
            this.add(nArray[n4]);
        }
    }

    public void addAll(IntSet intSet) {
        this.ensureCapacity(intSet.size);
        if (intSet.hasZeroValue) {
            this.add(0);
        }
        for (int n2 : intSet.keyTable) {
            if (n2 == 0) continue;
            this.add(n2);
        }
    }

    private void addResize(int n2) {
        int[] nArray = this.keyTable;
        int n3 = this.place(n2);
        while (true) {
            if (nArray[n3] == 0) {
                nArray[n3] = n2;
                return;
            }
            n3 = n3 + 1 & this.mask;
        }
    }

    public boolean remove(int n2) {
        if (n2 == 0) {
            if (!this.hasZeroValue) {
                return false;
            }
            this.hasZeroValue = false;
            --this.size;
            return true;
        }
        int n3 = this.locateKey(n2);
        if (n3 < 0) {
            return false;
        }
        int[] nArray = this.keyTable;
        int n4 = this.mask;
        int n5 = n3 + 1 & n4;
        while ((n2 = nArray[n5]) != 0) {
            int n6 = this.place(n2);
            if ((n5 - n6 & n4) > (n3 - n6 & n4)) {
                nArray[n3] = n2;
                n3 = n5;
            }
            n5 = n5 + 1 & n4;
        }
        nArray[n3] = 0;
        --this.size;
        return true;
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
        this.size = 0;
        Arrays.fill(this.keyTable, 0);
        this.hasZeroValue = false;
    }

    public boolean contains(int n2) {
        if (n2 == 0) {
            return this.hasZeroValue;
        }
        return this.locateKey(n2) >= 0;
    }

    public int first() {
        if (this.hasZeroValue) {
            return 0;
        }
        int[] nArray = this.keyTable;
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (nArray[i2] == 0) continue;
            return nArray[i2];
        }
        throw new IllegalStateException("IntSet is empty.");
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
        this.keyTable = new int[n2];
        if (this.size > 0) {
            for (int i2 = 0; i2 < n3; ++i2) {
                int n4 = nArray[i2];
                if (n4 == 0) continue;
                this.addResize(n4);
            }
        }
    }

    public int hashCode() {
        int n2 = this.size;
        for (int n3 : this.keyTable) {
            if (n3 == 0) continue;
            n2 += n3;
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (!(object instanceof IntSet)) {
            return false;
        }
        IntSet intSet = (IntSet)object;
        if (intSet.size != this.size) {
            return false;
        }
        if (intSet.hasZeroValue != this.hasZeroValue) {
            return false;
        }
        int[] nArray = this.keyTable;
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (nArray[i2] == 0 || intSet.contains(nArray[i2])) continue;
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
        int n3 = nArray.length;
        if (this.hasZeroValue) {
            stringBuilder.append("0");
        } else {
            while (n3-- > 0) {
                n2 = nArray[n3];
                if (n2 == 0) continue;
                stringBuilder.append(n2);
                break;
            }
        }
        while (n3-- > 0) {
            n2 = nArray[n3];
            if (n2 == 0) continue;
            stringBuilder.append(", ");
            stringBuilder.append(n2);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public IntSetIterator iterator() {
        if (Collections.allocateIterators) {
            return new IntSetIterator(this);
        }
        if (this.iterator1 == null) {
            this.iterator1 = new IntSetIterator(this);
            this.iterator2 = new IntSetIterator(this);
        }
        if (!this.iterator1.valid) {
            this.iterator1.reset();
            this.iterator1.valid = true;
            this.iterator2.valid = false;
            return this.iterator1;
        }
        this.iterator2.reset();
        this.iterator2.valid = true;
        this.iterator1.valid = false;
        return this.iterator2;
    }

    public static IntSet with(int ... nArray) {
        IntSet intSet = new IntSet();
        intSet.addAll(nArray);
        return intSet;
    }

    public static class IntSetIterator {
        private static final int INDEX_ILLEGAL = -2;
        private static final int INDEX_ZERO = -1;
        public boolean hasNext;
        final IntSet set;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public IntSetIterator(IntSet intSet) {
            this.set = intSet;
            this.reset();
        }

        public void reset() {
            this.currentIndex = -2;
            this.nextIndex = -1;
            if (this.set.hasZeroValue) {
                this.hasNext = true;
            } else {
                this.findNextIndex();
            }
        }

        void findNextIndex() {
            int[] nArray = this.set.keyTable;
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
            if (n2 == -1 && this.set.hasZeroValue) {
                this.set.hasZeroValue = false;
            } else {
                int n3;
                if (n2 < 0) {
                    throw new IllegalStateException("next must be called before remove.");
                }
                int[] nArray = this.set.keyTable;
                int n4 = this.set.mask;
                int n5 = n2 + 1 & n4;
                while ((n3 = nArray[n5]) != 0) {
                    int n6 = this.set.place(n3);
                    if ((n5 - n6 & n4) > (n2 - n6 & n4)) {
                        nArray[n2] = n3;
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
            --this.set.size;
        }

        public int next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            int n2 = this.nextIndex == -1 ? 0 : this.set.keyTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return n2;
        }

        public IntArray toArray() {
            IntArray intArray = new IntArray(true, this.set.size);
            while (this.hasNext) {
                intArray.add(this.next());
            }
            return intArray;
        }
    }
}

