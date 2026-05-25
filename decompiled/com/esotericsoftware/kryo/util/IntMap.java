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
import java.util.NoSuchElementException;

public class IntMap<V>
implements Iterable<Entry<V>> {
    public int size;
    int[] keyTable;
    V[] valueTable;
    V zeroValue;
    boolean hasZeroValue;
    private final float loadFactor;
    private int threshold;
    protected int shift;
    protected int mask;

    public IntMap() {
        this(51, 0.8f);
    }

    public IntMap(int n2) {
        this(n2, 0.8f);
    }

    public IntMap(int n2, float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
        }
        this.loadFactor = f2;
        int n3 = ObjectMap.tableSize(n2, f2);
        this.threshold = (int)((float)n3 * f2);
        this.mask = n3 - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new int[n3];
        this.valueTable = new Object[n3];
    }

    public IntMap(IntMap<? extends V> intMap) {
        this((int)((float)intMap.keyTable.length * intMap.loadFactor), intMap.loadFactor);
        System.arraycopy(intMap.keyTable, 0, this.keyTable, 0, intMap.keyTable.length);
        System.arraycopy(intMap.valueTable, 0, this.valueTable, 0, intMap.valueTable.length);
        this.size = intMap.size;
        this.zeroValue = intMap.zeroValue;
        this.hasZeroValue = intMap.hasZeroValue;
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

    @Null
    public V put(int n2, @Null V v2) {
        if (n2 == 0) {
            V v3 = this.zeroValue;
            this.zeroValue = v2;
            if (!this.hasZeroValue) {
                this.hasZeroValue = true;
                ++this.size;
            }
            return v3;
        }
        int n3 = this.locateKey(n2);
        if (n3 >= 0) {
            V v4 = this.valueTable[n3];
            this.valueTable[n3] = v2;
            return v4;
        }
        n3 = -(n3 + 1);
        this.keyTable[n3] = n2;
        this.valueTable[n3] = v2;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return null;
    }

    public void putAll(IntMap<? extends V> intMap) {
        this.ensureCapacity(intMap.size);
        if (intMap.hasZeroValue) {
            this.put(0, intMap.zeroValue);
        }
        int[] nArray = intMap.keyTable;
        V[] VArray = intMap.valueTable;
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = nArray[i2];
            if (n3 == 0) continue;
            this.put(n3, VArray[i2]);
        }
    }

    private void putResize(int n2, @Null V v2) {
        int[] nArray = this.keyTable;
        int n3 = this.place(n2);
        while (true) {
            if (nArray[n3] == 0) {
                nArray[n3] = n2;
                this.valueTable[n3] = v2;
                return;
            }
            n3 = n3 + 1 & this.mask;
        }
    }

    public V get(int n2) {
        if (n2 == 0) {
            return this.hasZeroValue ? (V)this.zeroValue : null;
        }
        int n3 = this.locateKey(n2);
        return n3 >= 0 ? (V)this.valueTable[n3] : null;
    }

    public V get(int n2, @Null V v2) {
        if (n2 == 0) {
            return this.hasZeroValue ? this.zeroValue : v2;
        }
        int n3 = this.locateKey(n2);
        return n3 >= 0 ? this.valueTable[n3] : v2;
    }

    @Null
    public V remove(int n2) {
        if (n2 == 0) {
            if (!this.hasZeroValue) {
                return null;
            }
            this.hasZeroValue = false;
            V v2 = this.zeroValue;
            this.zeroValue = null;
            --this.size;
            return v2;
        }
        int n3 = this.locateKey(n2);
        if (n3 < 0) {
            return null;
        }
        int[] nArray = this.keyTable;
        V[] VArray = this.valueTable;
        V v3 = VArray[n3];
        int n4 = this.mask;
        int n5 = n3 + 1 & n4;
        while ((n2 = nArray[n5]) != 0) {
            int n6 = this.place(n2);
            if ((n5 - n6 & n4) > (n3 - n6 & n4)) {
                nArray[n3] = n2;
                VArray[n3] = VArray[n5];
                n3 = n5;
            }
            n5 = n5 + 1 & n4;
        }
        nArray[n3] = 0;
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
        this.hasZeroValue = false;
        this.zeroValue = null;
        this.resize(n3);
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        Arrays.fill(this.keyTable, 0);
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
            int[] nArray = this.keyTable;
            for (int i2 = VArray.length - 1; i2 >= 0; --i2) {
                if (nArray[i2] == 0 || VArray[i2] != null) continue;
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

    public boolean containsKey(int n2) {
        if (n2 == 0) {
            return this.hasZeroValue;
        }
        return this.locateKey(n2) >= 0;
    }

    public int findKey(@Null Object object, boolean bl2, int n2) {
        V[] VArray = this.valueTable;
        if (object == null) {
            if (this.hasZeroValue && this.zeroValue == null) {
                return 0;
            }
            int[] nArray = this.keyTable;
            for (int i2 = VArray.length - 1; i2 >= 0; --i2) {
                if (nArray[i2] == 0 || VArray[i2] != null) continue;
                return nArray[i2];
            }
        } else if (bl2) {
            if (object == this.zeroValue) {
                return 0;
            }
            for (int i3 = VArray.length - 1; i3 >= 0; --i3) {
                if (VArray[i3] != object) continue;
                return this.keyTable[i3];
            }
        } else {
            if (this.hasZeroValue && object.equals(this.zeroValue)) {
                return 0;
            }
            for (int i4 = VArray.length - 1; i4 >= 0; --i4) {
                if (!object.equals(VArray[i4])) continue;
                return this.keyTable[i4];
            }
        }
        return n2;
    }

    public void ensureCapacity(int n2) {
        int n3 = ObjectMap.tableSize(this.size + n2, this.loadFactor);
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
        V[] VArray = this.valueTable;
        this.keyTable = new int[n2];
        this.valueTable = new Object[n2];
        if (this.size > 0) {
            for (int i2 = 0; i2 < n3; ++i2) {
                int n4 = nArray[i2];
                if (n4 == 0) continue;
                this.putResize(n4, VArray[i2]);
            }
        }
    }

    public int hashCode() {
        int n2 = this.size;
        if (this.hasZeroValue && this.zeroValue != null) {
            n2 += this.zeroValue.hashCode();
        }
        int[] nArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n3 = nArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = nArray[i2];
            if (n4 == 0) continue;
            n2 += n4 * 31;
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
        if (!(object instanceof IntMap)) {
            return false;
        }
        IntMap intMap = (IntMap)object;
        if (intMap.size != this.size) {
            return false;
        }
        if (intMap.hasZeroValue != this.hasZeroValue) {
            return false;
        }
        if (this.hasZeroValue && (intMap.zeroValue == null ? this.zeroValue != null : !intMap.zeroValue.equals(this.zeroValue))) {
            return false;
        }
        int[] nArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            V v2;
            int n3 = nArray[i2];
            if (n3 == 0 || !((v2 = VArray[i2]) == null ? intMap.get(n3, ObjectMap.dummy) != null : !v2.equals(intMap.get(n3)))) continue;
            return false;
        }
        return true;
    }

    public boolean equalsIdentity(@Null Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IntMap)) {
            return false;
        }
        IntMap intMap = (IntMap)object;
        if (intMap.size != this.size) {
            return false;
        }
        if (intMap.hasZeroValue != this.hasZeroValue) {
            return false;
        }
        if (this.hasZeroValue && this.zeroValue != intMap.zeroValue) {
            return false;
        }
        int[] nArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = nArray[i2];
            if (n3 == 0 || VArray[i2] == intMap.get(n3, ObjectMap.dummy)) continue;
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
        V[] VArray = this.valueTable;
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
                stringBuilder.append(VArray[n3]);
                break;
            }
        }
        while (n3-- > 0) {
            n2 = nArray[n3];
            if (n2 == 0) continue;
            stringBuilder.append(", ");
            stringBuilder.append(n2);
            stringBuilder.append('=');
            stringBuilder.append(VArray[n3]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Entry<V>> iterator() {
        return this.entries();
    }

    public Entries<V> entries() {
        return new Entries(this);
    }

    public Values<V> values() {
        return new Values(this);
    }

    public Keys keys() {
        return new Keys(this);
    }

    public static class Keys
    extends MapIterator {
        public Keys(IntMap intMap) {
            super(intMap);
        }

        public int next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
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

    public static class Values<V>
    extends MapIterator<V>
    implements Iterable<V>,
    Iterator<V> {
        public Values(IntMap<V> intMap) {
            super(intMap);
        }

        @Override
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override
        @Null
        public V next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
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

        public ArrayList<V> toList() {
            ArrayList<V> arrayList = new ArrayList<V>(this.map.size);
            while (this.hasNext) {
                arrayList.add(this.next());
            }
            return arrayList;
        }
    }

    public static class Entries<V>
    extends MapIterator<V>
    implements Iterable<Entry<V>>,
    Iterator<Entry<V>> {
        private final Entry<V> entry = new Entry();

        public Entries(IntMap intMap) {
            super(intMap);
        }

        @Override
        public Entry<V> next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new KryoException("#iterator() cannot be used nested.");
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
                throw new KryoException("#iterator() cannot be used nested.");
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
        final IntMap<V> map;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public MapIterator(IntMap<V> intMap) {
            this.map = intMap;
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
                V[] VArray = this.map.valueTable;
                int n4 = this.map.mask;
                int n5 = n2 + 1 & n4;
                while ((n3 = nArray[n5]) != 0) {
                    int n6 = this.map.place(n3);
                    if ((n5 - n6 & n4) > (n2 - n6 & n4)) {
                        nArray[n2] = n3;
                        VArray[n2] = VArray[n5];
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

    public static class Entry<V> {
        public int key;
        @Null
        public V value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}

