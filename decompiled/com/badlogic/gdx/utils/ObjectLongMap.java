/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.LongArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectLongMap<K>
implements Iterable<Entry<K>> {
    public int size;
    K[] keyTable;
    long[] valueTable;
    float loadFactor;
    int threshold;
    protected int shift;
    protected int mask;
    transient Entries entries1;
    transient Entries entries2;
    transient Values values1;
    transient Values values2;
    transient Keys keys1;
    transient Keys keys2;

    public ObjectLongMap() {
        this(51, 0.8f);
    }

    public ObjectLongMap(int n2) {
        this(n2, 0.8f);
    }

    public ObjectLongMap(int n2, float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
        }
        this.loadFactor = f2;
        int n3 = ObjectSet.tableSize(n2, f2);
        this.threshold = (int)((float)n3 * f2);
        this.mask = n3 - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new Object[n3];
        this.valueTable = new long[n3];
    }

    public ObjectLongMap(ObjectLongMap<? extends K> objectLongMap) {
        this((int)((float)objectLongMap.keyTable.length * objectLongMap.loadFactor), objectLongMap.loadFactor);
        System.arraycopy(objectLongMap.keyTable, 0, this.keyTable, 0, objectLongMap.keyTable.length);
        System.arraycopy(objectLongMap.valueTable, 0, this.valueTable, 0, objectLongMap.valueTable.length);
        this.size = objectLongMap.size;
    }

    protected int place(K k2) {
        return (int)((long)k2.hashCode() * -7046029254386353131L >>> this.shift);
    }

    int locateKey(K k2) {
        if (k2 == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        K[] KArray = this.keyTable;
        int n2 = this.place(k2);
        K k3;
        while ((k3 = KArray[n2]) != null) {
            if (k3.equals(k2)) {
                return n2;
            }
            n2 = n2 + 1 & this.mask;
        }
        return -(n2 + 1);
    }

    public void put(K k2, long l2) {
        int n2 = this.locateKey(k2);
        if (n2 >= 0) {
            this.valueTable[n2] = l2;
            return;
        }
        n2 = -(n2 + 1);
        this.keyTable[n2] = k2;
        this.valueTable[n2] = l2;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
    }

    public long put(K k2, long l2, long l3) {
        int n2 = this.locateKey(k2);
        if (n2 >= 0) {
            long l4 = this.valueTable[n2];
            this.valueTable[n2] = l2;
            return l4;
        }
        n2 = -(n2 + 1);
        this.keyTable[n2] = k2;
        this.valueTable[n2] = l2;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return l3;
    }

    public void putAll(ObjectLongMap<? extends K> objectLongMap) {
        this.ensureCapacity(objectLongMap.size);
        K[] KArray = objectLongMap.keyTable;
        long[] lArray = objectLongMap.valueTable;
        int n2 = KArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            K k2 = KArray[i2];
            if (k2 == null) continue;
            this.put(k2, lArray[i2]);
        }
    }

    private void putResize(K k2, long l2) {
        K[] KArray = this.keyTable;
        int n2 = this.place(k2);
        while (true) {
            if (KArray[n2] == null) {
                KArray[n2] = k2;
                this.valueTable[n2] = l2;
                return;
            }
            n2 = n2 + 1 & this.mask;
        }
    }

    public long get(K k2, long l2) {
        int n2 = this.locateKey(k2);
        return n2 < 0 ? l2 : this.valueTable[n2];
    }

    public long getAndIncrement(K k2, long l2, long l3) {
        int n2 = this.locateKey(k2);
        if (n2 >= 0) {
            long l4 = this.valueTable[n2];
            int n3 = n2;
            this.valueTable[n3] = this.valueTable[n3] + l3;
            return l4;
        }
        n2 = -(n2 + 1);
        this.keyTable[n2] = k2;
        this.valueTable[n2] = l2 + l3;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return l2;
    }

    public long remove(K k2, long l2) {
        int n2 = this.locateKey(k2);
        if (n2 < 0) {
            return l2;
        }
        K[] KArray = this.keyTable;
        long[] lArray = this.valueTable;
        long l3 = lArray[n2];
        int n3 = this.mask;
        int n4 = n2 + 1 & n3;
        while ((k2 = KArray[n4]) != null) {
            int n5 = this.place(k2);
            if ((n4 - n5 & n3) > (n2 - n5 & n3)) {
                KArray[n2] = k2;
                lArray[n2] = lArray[n4];
                n2 = n4;
            }
            n4 = n4 + 1 & n3;
        }
        KArray[n2] = null;
        --this.size;
        return l3;
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

    public boolean containsValue(long l2) {
        K[] KArray = this.keyTable;
        long[] lArray = this.valueTable;
        for (int i2 = lArray.length - 1; i2 >= 0; --i2) {
            if (KArray[i2] == null || lArray[i2] != l2) continue;
            return true;
        }
        return false;
    }

    public boolean containsKey(K k2) {
        return this.locateKey(k2) >= 0;
    }

    @Null
    public K findKey(long l2) {
        K[] KArray = this.keyTable;
        long[] lArray = this.valueTable;
        for (int i2 = lArray.length - 1; i2 >= 0; --i2) {
            K k2 = KArray[i2];
            if (k2 == null || lArray[i2] != l2) continue;
            return k2;
        }
        return null;
    }

    public void ensureCapacity(int n2) {
        int n3 = ObjectSet.tableSize(this.size + n2, this.loadFactor);
        if (this.keyTable.length < n3) {
            this.resize(n3);
        }
    }

    final void resize(int n2) {
        int n3 = this.keyTable.length;
        this.threshold = (int)((float)n2 * this.loadFactor);
        this.mask = n2 - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        K[] KArray = this.keyTable;
        long[] lArray = this.valueTable;
        this.keyTable = new Object[n2];
        this.valueTable = new long[n2];
        if (this.size > 0) {
            for (int i2 = 0; i2 < n3; ++i2) {
                K k2 = KArray[i2];
                if (k2 == null) continue;
                this.putResize(k2, lArray[i2]);
            }
        }
    }

    public int hashCode() {
        int n2 = this.size;
        K[] KArray = this.keyTable;
        long[] lArray = this.valueTable;
        int n3 = KArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            K k2 = KArray[i2];
            if (k2 == null) continue;
            n2 = (int)((long)n2 + ((long)k2.hashCode() + lArray[i2]));
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ObjectLongMap)) {
            return false;
        }
        ObjectLongMap objectLongMap = (ObjectLongMap)object;
        if (objectLongMap.size != this.size) {
            return false;
        }
        K[] KArray = this.keyTable;
        long[] lArray = this.valueTable;
        int n2 = KArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            K k2 = KArray[i2];
            if (k2 == null) continue;
            long l2 = objectLongMap.get(k2, 0L);
            if (l2 == 0L && !objectLongMap.containsKey(k2)) {
                return false;
            }
            if (l2 == lArray[i2]) continue;
            return false;
        }
        return true;
    }

    public String toString(String string) {
        return this.toString(string, false);
    }

    public String toString() {
        return this.toString(", ", true);
    }

    private String toString(String string, boolean bl2) {
        K k2;
        if (this.size == 0) {
            return bl2 ? "{}" : "";
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        if (bl2) {
            stringBuilder.append('{');
        }
        K[] KArray = this.keyTable;
        long[] lArray = this.valueTable;
        int n2 = KArray.length;
        while (n2-- > 0) {
            k2 = KArray[n2];
            if (k2 == null) continue;
            stringBuilder.append(k2);
            stringBuilder.append('=');
            stringBuilder.append(lArray[n2]);
            break;
        }
        while (n2-- > 0) {
            k2 = KArray[n2];
            if (k2 == null) continue;
            stringBuilder.append(string);
            stringBuilder.append(k2);
            stringBuilder.append('=');
            stringBuilder.append(lArray[n2]);
        }
        if (bl2) {
            stringBuilder.append('}');
        }
        return stringBuilder.toString();
    }

    @Override
    public Entries<K> iterator() {
        return this.entries();
    }

    public Entries<K> entries() {
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
            return new Values((ObjectLongMap<?>)this);
        }
        if (this.values1 == null) {
            this.values1 = new Values((ObjectLongMap<?>)this);
            this.values2 = new Values((ObjectLongMap<?>)this);
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

    public Keys<K> keys() {
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

    public static class Keys<K>
    extends MapIterator<K>
    implements Iterable<K>,
    Iterator<K> {
        public Keys(ObjectLongMap<K> objectLongMap) {
            super(objectLongMap);
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
            Object k2 = this.map.keyTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return k2;
        }

        @Override
        public Keys<K> iterator() {
            return this;
        }

        public Array<K> toArray() {
            return this.toArray(new Array(true, this.map.size));
        }

        public Array<K> toArray(Array<K> array) {
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }
    }

    public static class Values
    extends MapIterator<Object> {
        public Values(ObjectLongMap<?> objectLongMap) {
            super(objectLongMap);
        }

        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.hasNext;
        }

        public long next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            long l2 = this.map.valueTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return l2;
        }

        public Values iterator() {
            return this;
        }

        public LongArray toArray() {
            LongArray longArray = new LongArray(true, this.map.size);
            while (this.hasNext) {
                longArray.add(this.next());
            }
            return longArray;
        }

        public LongArray toArray(LongArray longArray) {
            while (this.hasNext) {
                longArray.add(this.next());
            }
            return longArray;
        }
    }

    public static class Entries<K>
    extends MapIterator<K>
    implements Iterable<Entry<K>>,
    Iterator<Entry<K>> {
        Entry<K> entry = new Entry();

        public Entries(ObjectLongMap<K> objectLongMap) {
            super(objectLongMap);
        }

        @Override
        public Entry<K> next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            K[] KArray = this.map.keyTable;
            this.entry.key = KArray[this.nextIndex];
            this.entry.value = this.map.valueTable[this.nextIndex];
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
        public Entries<K> iterator() {
            return this;
        }
    }

    static class MapIterator<K> {
        public boolean hasNext;
        final ObjectLongMap<K> map;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public MapIterator(ObjectLongMap<K> objectLongMap) {
            this.map = objectLongMap;
            this.reset();
        }

        public void reset() {
            this.currentIndex = -1;
            this.nextIndex = -1;
            this.findNextIndex();
        }

        void findNextIndex() {
            K[] KArray = this.map.keyTable;
            int n2 = KArray.length;
            while (++this.nextIndex < n2) {
                if (KArray[this.nextIndex] == null) continue;
                this.hasNext = true;
                return;
            }
            this.hasNext = false;
        }

        public void remove() {
            Object k2;
            int n2 = this.currentIndex;
            if (n2 < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            K[] KArray = this.map.keyTable;
            long[] lArray = this.map.valueTable;
            int n3 = this.map.mask;
            int n4 = n2 + 1 & n3;
            while ((k2 = KArray[n4]) != null) {
                int n5 = this.map.place(k2);
                if ((n4 - n5 & n3) > (n2 - n5 & n3)) {
                    KArray[n2] = k2;
                    lArray[n2] = lArray[n4];
                    n2 = n4;
                }
                n4 = n4 + 1 & n3;
            }
            KArray[n2] = null;
            --this.map.size;
            if (n2 != this.currentIndex) {
                --this.nextIndex;
            }
            this.currentIndex = -1;
        }
    }

    public static class Entry<K> {
        public K key;
        public long value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}

