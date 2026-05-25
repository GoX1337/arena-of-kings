/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.LongArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LongMap<V>
implements Iterable<Entry<V>> {
    public int size;
    long[] keyTable;
    V[] valueTable;
    V zeroValue;
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

    public LongMap() {
        this(51, 0.8f);
    }

    public LongMap(int n2) {
        this(n2, 0.8f);
    }

    public LongMap(int n2, float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
        }
        this.loadFactor = f2;
        int n3 = ObjectSet.tableSize(n2, f2);
        this.threshold = (int)((float)n3 * f2);
        this.mask = n3 - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new long[n3];
        this.valueTable = new Object[n3];
    }

    public LongMap(LongMap<? extends V> longMap) {
        this((int)((float)longMap.keyTable.length * longMap.loadFactor), longMap.loadFactor);
        System.arraycopy(longMap.keyTable, 0, this.keyTable, 0, longMap.keyTable.length);
        System.arraycopy(longMap.valueTable, 0, this.valueTable, 0, longMap.valueTable.length);
        this.size = longMap.size;
        this.zeroValue = longMap.zeroValue;
        this.hasZeroValue = longMap.hasZeroValue;
    }

    protected int place(long l2) {
        return (int)((l2 ^ l2 >>> 32) * -7046029254386353131L >>> this.shift);
    }

    private int locateKey(long l2) {
        long[] lArray = this.keyTable;
        int n2 = this.place(l2);
        long l3;
        while ((l3 = lArray[n2]) != 0L) {
            if (l3 == l2) {
                return n2;
            }
            n2 = n2 + 1 & this.mask;
        }
        return -(n2 + 1);
    }

    @Null
    public V put(long l2, @Null V v2) {
        if (l2 == 0L) {
            V v3 = this.zeroValue;
            this.zeroValue = v2;
            if (!this.hasZeroValue) {
                this.hasZeroValue = true;
                ++this.size;
            }
            return v3;
        }
        int n2 = this.locateKey(l2);
        if (n2 >= 0) {
            V v4 = this.valueTable[n2];
            this.valueTable[n2] = v2;
            return v4;
        }
        n2 = -(n2 + 1);
        this.keyTable[n2] = l2;
        this.valueTable[n2] = v2;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return null;
    }

    public void putAll(LongMap<? extends V> longMap) {
        this.ensureCapacity(longMap.size);
        if (longMap.hasZeroValue) {
            this.put(0L, longMap.zeroValue);
        }
        long[] lArray = longMap.keyTable;
        V[] VArray = longMap.valueTable;
        int n2 = lArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l2 = lArray[i2];
            if (l2 == 0L) continue;
            this.put(l2, VArray[i2]);
        }
    }

    private void putResize(long l2, @Null V v2) {
        long[] lArray = this.keyTable;
        int n2 = this.place(l2);
        while (true) {
            if (lArray[n2] == 0L) {
                lArray[n2] = l2;
                this.valueTable[n2] = v2;
                return;
            }
            n2 = n2 + 1 & this.mask;
        }
    }

    @Null
    public V get(long l2) {
        if (l2 == 0L) {
            return this.hasZeroValue ? (V)this.zeroValue : null;
        }
        int n2 = this.locateKey(l2);
        return n2 >= 0 ? (V)this.valueTable[n2] : null;
    }

    public V get(long l2, @Null V v2) {
        if (l2 == 0L) {
            return this.hasZeroValue ? this.zeroValue : v2;
        }
        int n2 = this.locateKey(l2);
        return n2 >= 0 ? this.valueTable[n2] : v2;
    }

    @Null
    public V remove(long l2) {
        if (l2 == 0L) {
            if (!this.hasZeroValue) {
                return null;
            }
            this.hasZeroValue = false;
            V v2 = this.zeroValue;
            this.zeroValue = null;
            --this.size;
            return v2;
        }
        int n2 = this.locateKey(l2);
        if (n2 < 0) {
            return null;
        }
        long[] lArray = this.keyTable;
        V[] VArray = this.valueTable;
        V v3 = VArray[n2];
        int n3 = this.mask;
        int n4 = n2 + 1 & n3;
        while ((l2 = lArray[n4]) != 0L) {
            int n5 = this.place(l2);
            if ((n4 - n5 & n3) > (n2 - n5 & n3)) {
                lArray[n2] = l2;
                VArray[n2] = VArray[n4];
                n2 = n4;
            }
            n4 = n4 + 1 & n3;
        }
        lArray[n2] = 0L;
        VArray[n2] = null;
        --this.size;
        return v3;
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
        this.zeroValue = null;
        this.resize(n3);
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        Arrays.fill(this.keyTable, 0L);
        Arrays.fill(this.valueTable, null);
        this.zeroValue = null;
        this.hasZeroValue = false;
    }

    public boolean containsValue(@Null Object object, boolean bl2) {
        V[] VArray = this.valueTable;
        if (object == null) {
            if (this.hasZeroValue && this.zeroValue == null) {
                return true;
            }
            long[] lArray = this.keyTable;
            for (int i2 = VArray.length - 1; i2 >= 0; --i2) {
                if (lArray[i2] == 0L || VArray[i2] != null) continue;
                return true;
            }
        } else if (bl2) {
            if (object == this.zeroValue) {
                return true;
            }
            for (int i3 = VArray.length - 1; i3 >= 0; --i3) {
                if (VArray[i3] != object) continue;
                return true;
            }
        } else {
            if (this.hasZeroValue && object.equals(this.zeroValue)) {
                return true;
            }
            for (int i4 = VArray.length - 1; i4 >= 0; --i4) {
                if (!object.equals(VArray[i4])) continue;
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(long l2) {
        if (l2 == 0L) {
            return this.hasZeroValue;
        }
        return this.locateKey(l2) >= 0;
    }

    public long findKey(@Null Object object, boolean bl2, long l2) {
        V[] VArray = this.valueTable;
        if (object == null) {
            if (this.hasZeroValue && this.zeroValue == null) {
                return 0L;
            }
            long[] lArray = this.keyTable;
            for (int i2 = VArray.length - 1; i2 >= 0; --i2) {
                if (lArray[i2] == 0L || VArray[i2] != null) continue;
                return lArray[i2];
            }
        } else if (bl2) {
            if (object == this.zeroValue) {
                return 0L;
            }
            for (int i3 = VArray.length - 1; i3 >= 0; --i3) {
                if (VArray[i3] != object) continue;
                return this.keyTable[i3];
            }
        } else {
            if (this.hasZeroValue && object.equals(this.zeroValue)) {
                return 0L;
            }
            for (int i4 = VArray.length - 1; i4 >= 0; --i4) {
                if (!object.equals(VArray[i4])) continue;
                return this.keyTable[i4];
            }
        }
        return l2;
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
        long[] lArray = this.keyTable;
        V[] VArray = this.valueTable;
        this.keyTable = new long[n2];
        this.valueTable = new Object[n2];
        if (this.size > 0) {
            for (int i2 = 0; i2 < n3; ++i2) {
                long l2 = lArray[i2];
                if (l2 == 0L) continue;
                this.putResize(l2, VArray[i2]);
            }
        }
    }

    public int hashCode() {
        int n2 = this.size;
        if (this.hasZeroValue && this.zeroValue != null) {
            n2 += this.zeroValue.hashCode();
        }
        long[] lArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n3 = lArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            long l2 = lArray[i2];
            if (l2 == 0L) continue;
            n2 = (int)((long)n2 + l2 * 31L);
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
        if (!(object instanceof LongMap)) {
            return false;
        }
        LongMap longMap = (LongMap)object;
        if (longMap.size != this.size) {
            return false;
        }
        if (longMap.hasZeroValue != this.hasZeroValue) {
            return false;
        }
        if (this.hasZeroValue && (longMap.zeroValue == null ? this.zeroValue != null : !longMap.zeroValue.equals(this.zeroValue))) {
            return false;
        }
        long[] lArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n2 = lArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            V v2;
            long l2 = lArray[i2];
            if (l2 == 0L || !((v2 = VArray[i2]) == null ? longMap.get(l2, ObjectMap.dummy) != null : !v2.equals(longMap.get(l2)))) continue;
            return false;
        }
        return true;
    }

    public boolean equalsIdentity(@Null Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LongMap)) {
            return false;
        }
        LongMap longMap = (LongMap)object;
        if (longMap.size != this.size) {
            return false;
        }
        if (longMap.hasZeroValue != this.hasZeroValue) {
            return false;
        }
        if (this.hasZeroValue && this.zeroValue != longMap.zeroValue) {
            return false;
        }
        long[] lArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n2 = lArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l2 = lArray[i2];
            if (l2 == 0L || VArray[i2] == longMap.get(l2, ObjectMap.dummy)) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        long l2;
        if (this.size == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        long[] lArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n2 = lArray.length;
        if (this.hasZeroValue) {
            stringBuilder.append("0=");
            stringBuilder.append(this.zeroValue);
        } else {
            while (n2-- > 0) {
                l2 = lArray[n2];
                if (l2 == 0L) continue;
                stringBuilder.append(l2);
                stringBuilder.append('=');
                stringBuilder.append(VArray[n2]);
                break;
            }
        }
        while (n2-- > 0) {
            l2 = lArray[n2];
            if (l2 == 0L) continue;
            stringBuilder.append(", ");
            stringBuilder.append(l2);
            stringBuilder.append('=');
            stringBuilder.append(VArray[n2]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Entry<V>> iterator() {
        return this.entries();
    }

    public Entries<V> entries() {
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
        public Keys(LongMap longMap) {
            super(longMap);
        }

        public long next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            long l2 = this.nextIndex == -1 ? 0L : this.map.keyTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return l2;
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

    public static class Values<V>
    extends MapIterator<V>
    implements Iterable<V>,
    Iterator<V> {
        public Values(LongMap<V> longMap) {
            super(longMap);
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
            Object v2 = this.nextIndex == -1 ? this.map.zeroValue : this.map.valueTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return v2;
        }

        @Override
        public Iterator<V> iterator() {
            return this;
        }

        public Array<V> toArray() {
            Array<V> array = new Array<V>(true, this.map.size);
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }
    }

    public static class Entries<V>
    extends MapIterator<V>
    implements Iterable<Entry<V>>,
    Iterator<Entry<V>> {
        private final Entry<V> entry = new Entry();

        public Entries(LongMap longMap) {
            super(longMap);
        }

        @Override
        public Entry<V> next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            long[] lArray = this.map.keyTable;
            if (this.nextIndex == -1) {
                this.entry.key = 0L;
                this.entry.value = this.map.zeroValue;
            } else {
                this.entry.key = lArray[this.nextIndex];
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
        public Iterator<Entry<V>> iterator() {
            return this;
        }
    }

    static class MapIterator<V> {
        private static final int INDEX_ILLEGAL = -2;
        static final int INDEX_ZERO = -1;
        public boolean hasNext;
        final LongMap<V> map;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public MapIterator(LongMap<V> longMap) {
            this.map = longMap;
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
            long[] lArray = this.map.keyTable;
            int n2 = lArray.length;
            while (++this.nextIndex < n2) {
                if (lArray[this.nextIndex] == 0L) continue;
                this.hasNext = true;
                return;
            }
            this.hasNext = false;
        }

        public void remove() {
            int n2 = this.currentIndex;
            if (n2 == -1 && this.map.hasZeroValue) {
                this.map.hasZeroValue = false;
                this.map.zeroValue = null;
            } else {
                long l2;
                if (n2 < 0) {
                    throw new IllegalStateException("next must be called before remove.");
                }
                long[] lArray = this.map.keyTable;
                V[] VArray = this.map.valueTable;
                int n3 = this.map.mask;
                int n4 = n2 + 1 & n3;
                while ((l2 = lArray[n4]) != 0L) {
                    int n5 = this.map.place(l2);
                    if ((n4 - n5 & n3) > (n2 - n5 & n3)) {
                        lArray[n2] = l2;
                        VArray[n2] = VArray[n4];
                        n2 = n4;
                    }
                    n4 = n4 + 1 & n3;
                }
                lArray[n2] = 0L;
                VArray[n2] = null;
                if (n2 != this.currentIndex) {
                    --this.nextIndex;
                }
            }
            this.currentIndex = -2;
            --this.map.size;
        }
    }

    public static class Entry<V> {
        public long key;
        @Null
        public V value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}

