/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.Null;
import com.esotericsoftware.kryo.util.ObjectMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ObjectIntMap<K>
implements Iterable<Entry<K>> {
    public int size;
    K[] keyTable;
    int[] valueTable;
    float loadFactor;
    int threshold;
    protected int shift;
    protected int mask;

    public ObjectIntMap() {
        this(51, 0.8f);
    }

    public ObjectIntMap(int n2) {
        this(n2, 0.8f);
    }

    public ObjectIntMap(int n2, float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
        }
        this.loadFactor = f2;
        int n3 = ObjectMap.tableSize(n2, f2);
        this.threshold = (int)((float)n3 * f2);
        this.mask = n3 - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new Object[n3];
        this.valueTable = new int[n3];
    }

    public ObjectIntMap(ObjectIntMap<? extends K> objectIntMap) {
        this((int)((float)objectIntMap.keyTable.length * objectIntMap.loadFactor), objectIntMap.loadFactor);
        System.arraycopy(objectIntMap.keyTable, 0, this.keyTable, 0, objectIntMap.keyTable.length);
        System.arraycopy(objectIntMap.valueTable, 0, this.valueTable, 0, objectIntMap.valueTable.length);
        this.size = objectIntMap.size;
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

    public void put(K k2, int n2) {
        int n3 = this.locateKey(k2);
        if (n3 >= 0) {
            this.valueTable[n3] = n2;
            return;
        }
        n3 = -(n3 + 1);
        this.keyTable[n3] = k2;
        this.valueTable[n3] = n2;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
    }

    public void putAll(ObjectIntMap<? extends K> objectIntMap) {
        this.ensureCapacity(objectIntMap.size);
        K[] KArray = objectIntMap.keyTable;
        int[] nArray = objectIntMap.valueTable;
        int n2 = KArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            K k2 = KArray[i2];
            if (k2 == null) continue;
            this.put(k2, nArray[i2]);
        }
    }

    private void putResize(K k2, int n2) {
        K[] KArray = this.keyTable;
        int n3 = this.place(k2);
        while (true) {
            if (KArray[n3] == null) {
                KArray[n3] = k2;
                this.valueTable[n3] = n2;
                return;
            }
            n3 = n3 + 1 & this.mask;
        }
    }

    public int get(K k2, int n2) {
        int n3 = this.locateKey(k2);
        return n3 < 0 ? n2 : this.valueTable[n3];
    }

    public int getAndIncrement(K k2, int n2, int n3) {
        int n4 = this.locateKey(k2);
        if (n4 >= 0) {
            int n5 = this.valueTable[n4];
            int n6 = n4;
            this.valueTable[n6] = this.valueTable[n6] + n3;
            return n5;
        }
        n4 = -(n4 + 1);
        this.keyTable[n4] = k2;
        this.valueTable[n4] = n2 + n3;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return n2;
    }

    public int remove(K k2, int n2) {
        int n3 = this.locateKey(k2);
        if (n3 < 0) {
            return n2;
        }
        K[] KArray = this.keyTable;
        int[] nArray = this.valueTable;
        int n4 = nArray[n3];
        int n5 = this.mask;
        int n6 = n3 + 1 & n5;
        while ((k2 = KArray[n6]) != null) {
            int n7 = this.place(k2);
            if ((n6 - n7 & n5) > (n3 - n7 & n5)) {
                KArray[n3] = k2;
                nArray[n3] = nArray[n6];
                n3 = n6;
            }
            n6 = n6 + 1 & n5;
        }
        KArray[n3] = null;
        --this.size;
        return n4;
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
        int n3 = ObjectMap.tableSize(n2, this.loadFactor);
        if (this.keyTable.length > n3) {
            this.resize(n3);
        }
    }

    public void clear(int n2) {
        int n3 = ObjectMap.tableSize(n2, this.loadFactor);
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

    public boolean containsValue(int n2) {
        K[] KArray = this.keyTable;
        int[] nArray = this.valueTable;
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            if (KArray[i2] == null || nArray[i2] != n2) continue;
            return true;
        }
        return false;
    }

    public boolean containsKey(K k2) {
        return this.locateKey(k2) >= 0;
    }

    @Null
    public K findKey(int n2) {
        K[] KArray = this.keyTable;
        int[] nArray = this.valueTable;
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            K k2 = KArray[i2];
            if (k2 == null || nArray[i2] != n2) continue;
            return k2;
        }
        return null;
    }

    public void ensureCapacity(int n2) {
        int n3 = ObjectMap.tableSize(this.size + n2, this.loadFactor);
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
        int[] nArray = this.valueTable;
        this.keyTable = new Object[n2];
        this.valueTable = new int[n2];
        if (this.size > 0) {
            for (int i2 = 0; i2 < n3; ++i2) {
                K k2 = KArray[i2];
                if (k2 == null) continue;
                this.putResize(k2, nArray[i2]);
            }
        }
    }

    public int hashCode() {
        int n2 = this.size;
        K[] KArray = this.keyTable;
        int[] nArray = this.valueTable;
        int n3 = KArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            K k2 = KArray[i2];
            if (k2 == null) continue;
            n2 += k2.hashCode() + nArray[i2];
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ObjectIntMap)) {
            return false;
        }
        ObjectIntMap objectIntMap = (ObjectIntMap)object;
        if (objectIntMap.size != this.size) {
            return false;
        }
        K[] KArray = this.keyTable;
        int[] nArray = this.valueTable;
        int n2 = KArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            K k2 = KArray[i2];
            if (k2 == null) continue;
            int n3 = objectIntMap.get(k2, 0);
            if (n3 == 0 && !objectIntMap.containsKey(k2)) {
                return false;
            }
            if (n3 == nArray[i2]) continue;
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
        int[] nArray = this.valueTable;
        int n2 = KArray.length;
        while (n2-- > 0) {
            k2 = KArray[n2];
            if (k2 == null) continue;
            stringBuilder.append(k2);
            stringBuilder.append('=');
            stringBuilder.append(nArray[n2]);
            break;
        }
        while (n2-- > 0) {
            k2 = KArray[n2];
            if (k2 == null) continue;
            stringBuilder.append(string);
            stringBuilder.append(k2);
            stringBuilder.append('=');
            stringBuilder.append(nArray[n2]);
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
        return new Entries(this);
    }

    public Values values() {
        return new Values((ObjectIntMap<?>)this);
    }

    public Keys<K> keys() {
        return new Keys(this);
    }

    public static class Keys<K>
    extends MapIterator<K>
    implements Iterable<K>,
    Iterator<K> {
        public Keys(ObjectIntMap<K> objectIntMap) {
            super(objectIntMap);
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new KryoException("#iterator() cannot be used nested.");
            }
            return this.hasNext;
        }

        @Override
        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new KryoException("#iterator() cannot be used nested.");
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

        public ArrayList<K> toList() {
            return this.toList(new ArrayList(this.map.size));
        }

        public <T extends List<K>> T toList(T t2) {
            while (this.hasNext) {
                t2.add(this.next());
            }
            return t2;
        }
    }

    public static class Values
    extends MapIterator<Object> {
        public Values(ObjectIntMap<?> objectIntMap) {
            super(objectIntMap);
        }

        public boolean hasNext() {
            if (!this.valid) {
                throw new KryoException("#iterator() cannot be used nested.");
            }
            return this.hasNext;
        }

        public int next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new KryoException("#iterator() cannot be used nested.");
            }
            int n2 = this.map.valueTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return n2;
        }

        public Values iterator() {
            return this;
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

    public static class Entries<K>
    extends MapIterator<K>
    implements Iterable<Entry<K>>,
    Iterator<Entry<K>> {
        Entry<K> entry = new Entry();

        public Entries(ObjectIntMap<K> objectIntMap) {
            super(objectIntMap);
        }

        @Override
        public Entry<K> next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new KryoException("#iterator() cannot be used nested.");
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
                throw new KryoException("#iterator() cannot be used nested.");
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
        final ObjectIntMap<K> map;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public MapIterator(ObjectIntMap<K> objectIntMap) {
            this.map = objectIntMap;
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
            int[] nArray = this.map.valueTable;
            int n3 = this.map.mask;
            int n4 = n2 + 1 & n3;
            while ((k2 = KArray[n4]) != null) {
                int n5 = this.map.place(k2);
                if ((n4 - n5 & n3) > (n2 - n5 & n3)) {
                    KArray[n2] = k2;
                    nArray[n2] = nArray[n4];
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
        public int value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}

