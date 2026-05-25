/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectMap<K, V>
implements Iterable<Entry<K, V>> {
    static final Object dummy = new Object();
    public int size;
    K[] keyTable;
    V[] valueTable;
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

    public ObjectMap() {
        this(51, 0.8f);
    }

    public ObjectMap(int n2) {
        this(n2, 0.8f);
    }

    public ObjectMap(int n2, float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
        }
        this.loadFactor = f2;
        int n3 = ObjectSet.tableSize(n2, f2);
        this.threshold = (int)((float)n3 * f2);
        this.mask = n3 - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new Object[n3];
        this.valueTable = new Object[n3];
    }

    public ObjectMap(ObjectMap<? extends K, ? extends V> objectMap) {
        this((int)((float)objectMap.keyTable.length * objectMap.loadFactor), objectMap.loadFactor);
        System.arraycopy(objectMap.keyTable, 0, this.keyTable, 0, objectMap.keyTable.length);
        System.arraycopy(objectMap.valueTable, 0, this.valueTable, 0, objectMap.valueTable.length);
        this.size = objectMap.size;
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

    @Null
    public V put(K k2, @Null V v2) {
        int n2 = this.locateKey(k2);
        if (n2 >= 0) {
            V v3 = this.valueTable[n2];
            this.valueTable[n2] = v2;
            return v3;
        }
        n2 = -(n2 + 1);
        this.keyTable[n2] = k2;
        this.valueTable[n2] = v2;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return null;
    }

    public void putAll(ObjectMap<? extends K, ? extends V> objectMap) {
        this.ensureCapacity(objectMap.size);
        K[] KArray = objectMap.keyTable;
        V[] VArray = objectMap.valueTable;
        int n2 = KArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            K k2 = KArray[i2];
            if (k2 == null) continue;
            this.put(k2, VArray[i2]);
        }
    }

    private void putResize(K k2, @Null V v2) {
        K[] KArray = this.keyTable;
        int n2 = this.place(k2);
        while (true) {
            if (KArray[n2] == null) {
                KArray[n2] = k2;
                this.valueTable[n2] = v2;
                return;
            }
            n2 = n2 + 1 & this.mask;
        }
    }

    @Null
    public <T extends K> V get(T t2) {
        int n2 = this.locateKey(t2);
        return n2 < 0 ? null : (V)this.valueTable[n2];
    }

    public V get(K k2, @Null V v2) {
        int n2 = this.locateKey(k2);
        return n2 < 0 ? v2 : this.valueTable[n2];
    }

    @Null
    public V remove(K k2) {
        int n2 = this.locateKey(k2);
        if (n2 < 0) {
            return null;
        }
        K[] KArray = this.keyTable;
        V[] VArray = this.valueTable;
        V v2 = VArray[n2];
        int n3 = this.mask;
        int n4 = n2 + 1 & n3;
        while ((k2 = KArray[n4]) != null) {
            int n5 = this.place(k2);
            if ((n4 - n5 & n3) > (n2 - n5 & n3)) {
                KArray[n2] = k2;
                VArray[n2] = VArray[n4];
                n2 = n4;
            }
            n4 = n4 + 1 & n3;
        }
        KArray[n2] = null;
        VArray[n2] = null;
        --this.size;
        return v2;
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
        Arrays.fill(this.valueTable, null);
    }

    public boolean containsValue(@Null Object object, boolean bl2) {
        V[] VArray = this.valueTable;
        if (object == null) {
            K[] KArray = this.keyTable;
            for (int i2 = VArray.length - 1; i2 >= 0; --i2) {
                if (KArray[i2] == null || VArray[i2] != null) continue;
                return true;
            }
        } else if (bl2) {
            for (int i3 = VArray.length - 1; i3 >= 0; --i3) {
                if (VArray[i3] != object) continue;
                return true;
            }
        } else {
            for (int i4 = VArray.length - 1; i4 >= 0; --i4) {
                if (!object.equals(VArray[i4])) continue;
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(K k2) {
        return this.locateKey(k2) >= 0;
    }

    @Null
    public K findKey(@Null Object object, boolean bl2) {
        V[] VArray = this.valueTable;
        if (object == null) {
            K[] KArray = this.keyTable;
            for (int i2 = VArray.length - 1; i2 >= 0; --i2) {
                if (KArray[i2] == null || VArray[i2] != null) continue;
                return KArray[i2];
            }
        } else if (bl2) {
            for (int i3 = VArray.length - 1; i3 >= 0; --i3) {
                if (VArray[i3] != object) continue;
                return this.keyTable[i3];
            }
        } else {
            for (int i4 = VArray.length - 1; i4 >= 0; --i4) {
                if (!object.equals(VArray[i4])) continue;
                return this.keyTable[i4];
            }
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
        V[] VArray = this.valueTable;
        this.keyTable = new Object[n2];
        this.valueTable = new Object[n2];
        if (this.size > 0) {
            for (int i2 = 0; i2 < n3; ++i2) {
                K k2 = KArray[i2];
                if (k2 == null) continue;
                this.putResize(k2, VArray[i2]);
            }
        }
    }

    public int hashCode() {
        int n2 = this.size;
        K[] KArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n3 = KArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            K k2 = KArray[i2];
            if (k2 == null) continue;
            n2 += k2.hashCode();
            V v2 = VArray[i2];
            if (v2 == null) continue;
            n2 += v2.hashCode();
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ObjectMap)) {
            return false;
        }
        ObjectMap objectMap = (ObjectMap)object;
        if (objectMap.size != this.size) {
            return false;
        }
        K[] KArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n2 = KArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            V v2;
            K k2 = KArray[i2];
            if (k2 == null || !((v2 = VArray[i2]) == null ? objectMap.get(k2, dummy) != null : !v2.equals(objectMap.get(k2)))) continue;
            return false;
        }
        return true;
    }

    public boolean equalsIdentity(@Null Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ObjectMap)) {
            return false;
        }
        ObjectMap objectMap = (ObjectMap)object;
        if (objectMap.size != this.size) {
            return false;
        }
        K[] KArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n2 = KArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            K k2 = KArray[i2];
            if (k2 == null || VArray[i2] == objectMap.get(k2, dummy)) continue;
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

    protected String toString(String string, boolean bl2) {
        V v2;
        K k2;
        if (this.size == 0) {
            return bl2 ? "{}" : "";
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        if (bl2) {
            stringBuilder.append('{');
        }
        K[] KArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n2 = KArray.length;
        while (n2-- > 0) {
            k2 = KArray[n2];
            if (k2 == null) continue;
            stringBuilder.append((Object)(k2 == this ? "(this)" : k2));
            stringBuilder.append('=');
            v2 = VArray[n2];
            stringBuilder.append((Object)(v2 == this ? "(this)" : v2));
            break;
        }
        while (n2-- > 0) {
            k2 = KArray[n2];
            if (k2 == null) continue;
            stringBuilder.append(string);
            stringBuilder.append((Object)(k2 == this ? "(this)" : k2));
            stringBuilder.append('=');
            v2 = VArray[n2];
            stringBuilder.append((Object)(v2 == this ? "(this)" : v2));
        }
        if (bl2) {
            stringBuilder.append('}');
        }
        return stringBuilder.toString();
    }

    public Entries<K, V> iterator() {
        return this.entries();
    }

    public Entries<K, V> entries() {
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

    public Values<V> values() {
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
    extends MapIterator<K, Object, K> {
        public Keys(ObjectMap<K, ?> objectMap) {
            super(objectMap);
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

    public static class Values<V>
    extends MapIterator<Object, V, V> {
        public Values(ObjectMap<?, V> objectMap) {
            super(objectMap);
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.hasNext;
        }

        @Override
        @Null
        public V next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            Object v2 = this.map.valueTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return v2;
        }

        @Override
        public Values<V> iterator() {
            return this;
        }

        public Array<V> toArray() {
            return this.toArray(new Array(true, this.map.size));
        }

        public Array<V> toArray(Array<V> array) {
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }
    }

    public static class Entries<K, V>
    extends MapIterator<K, V, Entry<K, V>> {
        Entry<K, V> entry = new Entry();

        public Entries(ObjectMap<K, V> objectMap) {
            super(objectMap);
        }

        @Override
        public Entry<K, V> next() {
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

        public Entries<K, V> iterator() {
            return this;
        }
    }

    static abstract class MapIterator<K, V, I>
    implements Iterable<I>,
    Iterator<I> {
        public boolean hasNext;
        final ObjectMap<K, V> map;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public MapIterator(ObjectMap<K, V> objectMap) {
            this.map = objectMap;
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

        @Override
        public void remove() {
            Object k2;
            int n2 = this.currentIndex;
            if (n2 < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            K[] KArray = this.map.keyTable;
            V[] VArray = this.map.valueTable;
            int n3 = this.map.mask;
            int n4 = n2 + 1 & n3;
            while ((k2 = KArray[n4]) != null) {
                int n5 = this.map.place(k2);
                if ((n4 - n5 & n3) > (n2 - n5 & n3)) {
                    KArray[n2] = k2;
                    VArray[n2] = VArray[n4];
                    n2 = n4;
                }
                n4 = n4 + 1 & n3;
            }
            KArray[n2] = null;
            VArray[n2] = null;
            --this.map.size;
            if (n2 != this.currentIndex) {
                --this.nextIndex;
            }
            this.currentIndex = -1;
        }
    }

    public static class Entry<K, V> {
        public K key;
        @Null
        public V value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}

