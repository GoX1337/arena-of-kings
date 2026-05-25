/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectSet<T>
implements Iterable<T> {
    public int size;
    T[] keyTable;
    float loadFactor;
    int threshold;
    protected int shift;
    protected int mask;
    private transient ObjectSetIterator iterator1;
    private transient ObjectSetIterator iterator2;

    public ObjectSet() {
        this(51, 0.8f);
    }

    public ObjectSet(int n2) {
        this(n2, 0.8f);
    }

    public ObjectSet(int n2, float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
        }
        this.loadFactor = f2;
        int n3 = ObjectSet.tableSize(n2, f2);
        this.threshold = (int)((float)n3 * f2);
        this.mask = n3 - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new Object[n3];
    }

    public ObjectSet(ObjectSet<? extends T> objectSet) {
        this((int)((float)objectSet.keyTable.length * objectSet.loadFactor), objectSet.loadFactor);
        System.arraycopy(objectSet.keyTable, 0, this.keyTable, 0, objectSet.keyTable.length);
        this.size = objectSet.size;
    }

    protected int place(T t2) {
        return (int)((long)t2.hashCode() * -7046029254386353131L >>> this.shift);
    }

    int locateKey(T t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        T[] TArray = this.keyTable;
        int n2 = this.place(t2);
        T t3;
        while ((t3 = TArray[n2]) != null) {
            if (t3.equals(t2)) {
                return n2;
            }
            n2 = n2 + 1 & this.mask;
        }
        return -(n2 + 1);
    }

    public boolean add(T t2) {
        int n2 = this.locateKey(t2);
        if (n2 >= 0) {
            return false;
        }
        n2 = -(n2 + 1);
        this.keyTable[n2] = t2;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return true;
    }

    public void addAll(Array<? extends T> array) {
        this.addAll(array.items, 0, array.size);
    }

    public void addAll(Array<? extends T> array, int n2, int n3) {
        if (n2 + n3 > array.size) {
            throw new IllegalArgumentException("offset + length must be <= size: " + n2 + " + " + n3 + " <= " + array.size);
        }
        this.addAll(array.items, n2, n3);
    }

    public boolean addAll(T ... TArray) {
        return this.addAll(TArray, 0, TArray.length);
    }

    public boolean addAll(T[] TArray, int n2, int n3) {
        int n4;
        this.ensureCapacity(n3);
        int n5 = this.size;
        int n6 = n4 + n3;
        for (n4 = n2; n4 < n6; ++n4) {
            this.add(TArray[n4]);
        }
        return n5 != this.size;
    }

    public void addAll(ObjectSet<T> objectSet) {
        this.ensureCapacity(objectSet.size);
        for (T t2 : objectSet.keyTable) {
            if (t2 == null) continue;
            this.add(t2);
        }
    }

    private void addResize(T t2) {
        T[] TArray = this.keyTable;
        int n2 = this.place(t2);
        while (true) {
            if (TArray[n2] == null) {
                TArray[n2] = t2;
                return;
            }
            n2 = n2 + 1 & this.mask;
        }
    }

    public boolean remove(T t2) {
        int n2 = this.locateKey(t2);
        if (n2 < 0) {
            return false;
        }
        T[] TArray = this.keyTable;
        int n3 = this.mask;
        int n4 = n2 + 1 & n3;
        while ((t2 = TArray[n4]) != null) {
            int n5 = this.place(t2);
            if ((n4 - n5 & n3) > (n2 - n5 & n3)) {
                TArray[n2] = t2;
                n2 = n4;
            }
            n4 = n4 + 1 & n3;
        }
        TArray[n2] = null;
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
        this.resize(n3);
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        Arrays.fill(this.keyTable, null);
    }

    public boolean contains(T t2) {
        return this.locateKey(t2) >= 0;
    }

    @Null
    public T get(T t2) {
        int n2 = this.locateKey(t2);
        return n2 < 0 ? null : (T)this.keyTable[n2];
    }

    public T first() {
        T[] TArray = this.keyTable;
        int n2 = TArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (TArray[i2] == null) continue;
            return TArray[i2];
        }
        throw new IllegalStateException("ObjectSet is empty.");
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
        T[] TArray = this.keyTable;
        this.keyTable = new Object[n2];
        if (this.size > 0) {
            for (int i2 = 0; i2 < n3; ++i2) {
                T t2 = TArray[i2];
                if (t2 == null) continue;
                this.addResize(t2);
            }
        }
    }

    public int hashCode() {
        int n2 = this.size;
        for (T t2 : this.keyTable) {
            if (t2 == null) continue;
            n2 += t2.hashCode();
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (!(object instanceof ObjectSet)) {
            return false;
        }
        ObjectSet objectSet = (ObjectSet)object;
        if (objectSet.size != this.size) {
            return false;
        }
        T[] TArray = this.keyTable;
        int n2 = TArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (TArray[i2] == null || objectSet.contains(TArray[i2])) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        return '{' + this.toString(", ") + '}';
    }

    public String toString(String string) {
        T t2;
        if (this.size == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        T[] TArray = this.keyTable;
        int n2 = TArray.length;
        while (n2-- > 0) {
            t2 = TArray[n2];
            if (t2 == null) continue;
            stringBuilder.append((Object)(t2 == this ? "(this)" : t2));
            break;
        }
        while (n2-- > 0) {
            t2 = TArray[n2];
            if (t2 == null) continue;
            stringBuilder.append(string);
            stringBuilder.append((Object)(t2 == this ? "(this)" : t2));
        }
        return stringBuilder.toString();
    }

    @Override
    public ObjectSetIterator<T> iterator() {
        if (Collections.allocateIterators) {
            return new ObjectSetIterator(this);
        }
        if (this.iterator1 == null) {
            this.iterator1 = new ObjectSetIterator(this);
            this.iterator2 = new ObjectSetIterator(this);
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

    public static <T> ObjectSet<T> with(T ... TArray) {
        ObjectSet<T> objectSet = new ObjectSet<T>();
        objectSet.addAll(TArray);
        return objectSet;
    }

    static int tableSize(int n2, float f2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("capacity must be >= 0: " + n2);
        }
        int n3 = MathUtils.nextPowerOfTwo(Math.max(2, (int)Math.ceil((float)n2 / f2)));
        if (n3 > 0x40000000) {
            throw new IllegalArgumentException("The required capacity is too large: " + n2);
        }
        return n3;
    }

    public static class ObjectSetIterator<K>
    implements Iterable<K>,
    Iterator<K> {
        public boolean hasNext;
        final ObjectSet<K> set;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public ObjectSetIterator(ObjectSet<K> objectSet) {
            this.set = objectSet;
            this.reset();
        }

        public void reset() {
            this.currentIndex = -1;
            this.nextIndex = -1;
            this.findNextIndex();
        }

        private void findNextIndex() {
            T[] TArray = this.set.keyTable;
            int n2 = this.set.keyTable.length;
            while (++this.nextIndex < n2) {
                if (TArray[this.nextIndex] == null) continue;
                this.hasNext = true;
                return;
            }
            this.hasNext = false;
        }

        @Override
        public void remove() {
            Object t2;
            int n2 = this.currentIndex;
            if (n2 < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            T[] TArray = this.set.keyTable;
            int n3 = this.set.mask;
            int n4 = n2 + 1 & n3;
            while ((t2 = TArray[n4]) != null) {
                int n5 = this.set.place(t2);
                if ((n4 - n5 & n3) > (n2 - n5 & n3)) {
                    TArray[n2] = t2;
                    n2 = n4;
                }
                n4 = n4 + 1 & n3;
            }
            TArray[n2] = null;
            --this.set.size;
            if (n2 != this.currentIndex) {
                --this.nextIndex;
            }
            this.currentIndex = -1;
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.hasNext;
        }

        @Override
        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            Object t2 = this.set.keyTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return (K)t2;
        }

        @Override
        public ObjectSetIterator<K> iterator() {
            return this;
        }

        public Array<K> toArray(Array<K> array) {
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }

        public Array<K> toArray() {
            return this.toArray(new Array(true, this.set.size));
        }
    }
}

