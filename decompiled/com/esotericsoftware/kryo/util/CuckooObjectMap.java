/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class CuckooObjectMap<K, V> {
    private static final int PRIME2 = -1105259343;
    private static final int PRIME3 = -1262997959;
    private static final int PRIME4 = -825114047;
    static Random random = new Random();
    public int size;
    K[] keyTable;
    V[] valueTable;
    int capacity;
    int stashSize;
    private float loadFactor;
    private int hashShift;
    private int mask;
    private int threshold;
    private int stashCapacity;
    private int pushIterations;
    private boolean isBigTable;

    public CuckooObjectMap() {
        this(32, 0.8f);
    }

    public CuckooObjectMap(int n2) {
        this(n2, 0.8f);
    }

    public CuckooObjectMap(int n2, float f2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("initialCapacity must be >= 0: " + n2);
        }
        if (n2 > 0x40000000) {
            throw new IllegalArgumentException("initialCapacity is too large: " + n2);
        }
        this.capacity = CuckooObjectMap.nextPowerOfTwo(n2);
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0: " + f2);
        }
        this.loadFactor = f2;
        this.isBigTable = this.capacity >>> 16 != 0;
        this.threshold = (int)((float)this.capacity * f2);
        this.mask = this.capacity - 1;
        this.hashShift = 31 - Integer.numberOfTrailingZeros(this.capacity);
        this.stashCapacity = Math.max(3, (int)Math.ceil(Math.log(this.capacity)) * 2);
        this.pushIterations = Math.max(Math.min(this.capacity, 8), (int)Math.sqrt(this.capacity) / 8);
        this.keyTable = new Object[this.capacity + this.stashCapacity];
        this.valueTable = new Object[this.keyTable.length];
    }

    public CuckooObjectMap(CuckooObjectMap<? extends K, ? extends V> cuckooObjectMap) {
        this(cuckooObjectMap.capacity, cuckooObjectMap.loadFactor);
        this.stashSize = cuckooObjectMap.stashSize;
        System.arraycopy(cuckooObjectMap.keyTable, 0, this.keyTable, 0, cuckooObjectMap.keyTable.length);
        System.arraycopy(cuckooObjectMap.valueTable, 0, this.valueTable, 0, cuckooObjectMap.valueTable.length);
        this.size = cuckooObjectMap.size;
    }

    public V put(K k2, V v2) {
        if (k2 == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        return this.put_internal(k2, v2);
    }

    private V put_internal(K object, V v2) {
        int n2;
        K[] KArray = this.keyTable;
        int n3 = this.mask;
        boolean bl2 = this.isBigTable;
        int n4 = object.hashCode();
        int n5 = n4 & n3;
        K k2 = KArray[n5];
        if (object.equals(k2)) {
            V v3 = this.valueTable[n5];
            this.valueTable[n5] = v2;
            return v3;
        }
        int n6 = this.hash2(n4);
        K k3 = KArray[n6];
        if (object.equals(k3)) {
            V v4 = this.valueTable[n6];
            this.valueTable[n6] = v2;
            return v4;
        }
        int n7 = this.hash3(n4);
        K k4 = KArray[n7];
        if (object.equals(k4)) {
            V v5 = this.valueTable[n7];
            this.valueTable[n7] = v2;
            return v5;
        }
        int n8 = -1;
        K k5 = null;
        if (bl2 && object.equals(k5 = (K)KArray[n8 = this.hash4(n4)])) {
            V v6 = this.valueTable[n8];
            this.valueTable[n8] = v2;
            return v6;
        }
        int n9 = n2 + this.stashSize;
        for (n2 = this.capacity; n2 < n9; ++n2) {
            if (!object.equals(KArray[n2])) continue;
            V v7 = this.valueTable[n2];
            this.valueTable[n2] = v2;
            return v7;
        }
        if (k2 == null) {
            KArray[n5] = object;
            this.valueTable[n5] = v2;
            if (this.size++ >= this.threshold) {
                this.resize(this.capacity << 1);
            }
            return null;
        }
        if (k3 == null) {
            KArray[n6] = object;
            this.valueTable[n6] = v2;
            if (this.size++ >= this.threshold) {
                this.resize(this.capacity << 1);
            }
            return null;
        }
        if (k4 == null) {
            KArray[n7] = object;
            this.valueTable[n7] = v2;
            if (this.size++ >= this.threshold) {
                this.resize(this.capacity << 1);
            }
            return null;
        }
        if (bl2 && k5 == null) {
            KArray[n8] = object;
            this.valueTable[n8] = v2;
            if (this.size++ >= this.threshold) {
                this.resize(this.capacity << 1);
            }
            return null;
        }
        this.push(object, v2, n5, k2, n6, k3, n7, k4, n8, k5);
        return null;
    }

    public void putAll(CuckooObjectMap<K, V> cuckooObjectMap) {
        this.ensureCapacity(cuckooObjectMap.size);
        for (Entry<K, V> entry : cuckooObjectMap.entries()) {
            this.put(entry.key, entry.value);
        }
    }

    private void putResize(K k2, V v2) {
        int n2 = k2.hashCode();
        int n3 = n2 & this.mask;
        K k3 = this.keyTable[n3];
        if (k3 == null) {
            this.keyTable[n3] = k2;
            this.valueTable[n3] = v2;
            if (this.size++ >= this.threshold) {
                this.resize(this.capacity << 1);
            }
            return;
        }
        int n4 = this.hash2(n2);
        K k4 = this.keyTable[n4];
        if (k4 == null) {
            this.keyTable[n4] = k2;
            this.valueTable[n4] = v2;
            if (this.size++ >= this.threshold) {
                this.resize(this.capacity << 1);
            }
            return;
        }
        int n5 = this.hash3(n2);
        K k5 = this.keyTable[n5];
        if (k5 == null) {
            this.keyTable[n5] = k2;
            this.valueTable[n5] = v2;
            if (this.size++ >= this.threshold) {
                this.resize(this.capacity << 1);
            }
            return;
        }
        int n6 = -1;
        K k6 = null;
        if (this.isBigTable && (k6 = (K)this.keyTable[n6 = this.hash4(n2)]) == null) {
            this.keyTable[n6] = k2;
            this.valueTable[n6] = v2;
            if (this.size++ >= this.threshold) {
                this.resize(this.capacity << 1);
            }
            return;
        }
        this.push(k2, v2, n3, k3, n4, k4, n5, k5, n6, k6);
    }

    private void push(K k2, V v2, int n2, K k3, int n3, K k4, int n4, K k5, int n5, K k6) {
        V v3;
        K k7;
        K[] KArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n6 = this.mask;
        boolean bl2 = this.isBigTable;
        int n7 = 0;
        int n8 = this.pushIterations;
        int n9 = bl2 ? 4 : 3;
        while (true) {
            switch (random.nextInt(n9)) {
                case 0: {
                    k7 = k3;
                    v3 = VArray[n2];
                    KArray[n2] = k2;
                    VArray[n2] = v2;
                    break;
                }
                case 1: {
                    k7 = k4;
                    v3 = VArray[n3];
                    KArray[n3] = k2;
                    VArray[n3] = v2;
                    break;
                }
                case 2: {
                    k7 = k5;
                    v3 = VArray[n4];
                    KArray[n4] = k2;
                    VArray[n4] = v2;
                    break;
                }
                default: {
                    k7 = k6;
                    v3 = VArray[n5];
                    KArray[n5] = k2;
                    VArray[n5] = v2;
                }
            }
            int n10 = k7.hashCode();
            n2 = n10 & n6;
            k3 = KArray[n2];
            if (k3 == null) {
                KArray[n2] = k7;
                VArray[n2] = v3;
                if (this.size++ >= this.threshold) {
                    this.resize(this.capacity << 1);
                }
                return;
            }
            n3 = this.hash2(n10);
            k4 = KArray[n3];
            if (k4 == null) {
                KArray[n3] = k7;
                VArray[n3] = v3;
                if (this.size++ >= this.threshold) {
                    this.resize(this.capacity << 1);
                }
                return;
            }
            n4 = this.hash3(n10);
            k5 = KArray[n4];
            if (k5 == null) {
                KArray[n4] = k7;
                VArray[n4] = v3;
                if (this.size++ >= this.threshold) {
                    this.resize(this.capacity << 1);
                }
                return;
            }
            if (bl2 && (k6 = KArray[n5 = this.hash4(n10)]) == null) {
                KArray[n5] = k7;
                VArray[n5] = v3;
                if (this.size++ >= this.threshold) {
                    this.resize(this.capacity << 1);
                }
                return;
            }
            if (++n7 == n8) break;
            k2 = k7;
            v2 = v3;
        }
        this.putStash(k7, v3);
    }

    private void putStash(K k2, V v2) {
        if (this.stashSize == this.stashCapacity) {
            this.resize(this.capacity << 1);
            this.put_internal(k2, v2);
            return;
        }
        int n2 = this.capacity + this.stashSize;
        this.keyTable[n2] = k2;
        this.valueTable[n2] = v2;
        ++this.stashSize;
        ++this.size;
    }

    public V get(K k2) {
        int n2 = k2.hashCode();
        int n3 = n2 & this.mask;
        if (!(k2.equals(this.keyTable[n3]) || k2.equals(this.keyTable[n3 = this.hash2(n2)]) || k2.equals(this.keyTable[n3 = this.hash3(n2)]))) {
            if (this.isBigTable) {
                n3 = this.hash4(n2);
                if (!k2.equals(this.keyTable[n3])) {
                    return this.getStash(k2);
                }
            } else {
                return this.getStash(k2);
            }
        }
        return this.valueTable[n3];
    }

    private V getStash(K k2) {
        int n2;
        K[] KArray = this.keyTable;
        int n3 = n2 + this.stashSize;
        for (n2 = this.capacity; n2 < n3; ++n2) {
            if (!k2.equals(KArray[n2])) continue;
            return this.valueTable[n2];
        }
        return null;
    }

    public V get(K k2, V v2) {
        int n2 = k2.hashCode();
        int n3 = n2 & this.mask;
        if (!(k2.equals(this.keyTable[n3]) || k2.equals(this.keyTable[n3 = this.hash2(n2)]) || k2.equals(this.keyTable[n3 = this.hash3(n2)]))) {
            if (this.isBigTable) {
                n3 = this.hash4(n2);
                if (!k2.equals(this.keyTable[n3])) {
                    return this.getStash(k2, v2);
                }
            } else {
                return this.getStash(k2, v2);
            }
        }
        return this.valueTable[n3];
    }

    private V getStash(K k2, V v2) {
        int n2;
        K[] KArray = this.keyTable;
        int n3 = n2 + this.stashSize;
        for (n2 = this.capacity; n2 < n3; ++n2) {
            if (!k2.equals(KArray[n2])) continue;
            return this.valueTable[n2];
        }
        return v2;
    }

    public V remove(K k2) {
        int n2 = k2.hashCode();
        int n3 = n2 & this.mask;
        if (k2.equals(this.keyTable[n3])) {
            this.keyTable[n3] = null;
            V v2 = this.valueTable[n3];
            this.valueTable[n3] = null;
            --this.size;
            return v2;
        }
        n3 = this.hash2(n2);
        if (k2.equals(this.keyTable[n3])) {
            this.keyTable[n3] = null;
            V v3 = this.valueTable[n3];
            this.valueTable[n3] = null;
            --this.size;
            return v3;
        }
        n3 = this.hash3(n2);
        if (k2.equals(this.keyTable[n3])) {
            this.keyTable[n3] = null;
            V v4 = this.valueTable[n3];
            this.valueTable[n3] = null;
            --this.size;
            return v4;
        }
        if (this.isBigTable && k2.equals(this.keyTable[n3 = this.hash4(n2)])) {
            this.keyTable[n3] = null;
            V v5 = this.valueTable[n3];
            this.valueTable[n3] = null;
            --this.size;
            return v5;
        }
        return this.removeStash(k2);
    }

    V removeStash(K k2) {
        int n2;
        K[] KArray = this.keyTable;
        int n3 = n2 + this.stashSize;
        for (n2 = this.capacity; n2 < n3; ++n2) {
            if (!k2.equals(KArray[n2])) continue;
            V v2 = this.valueTable[n2];
            this.removeStashIndex(n2);
            --this.size;
            return v2;
        }
        return null;
    }

    void removeStashIndex(int n2) {
        --this.stashSize;
        int n3 = this.capacity + this.stashSize;
        if (n2 < n3) {
            this.keyTable[n2] = this.keyTable[n3];
            this.valueTable[n2] = this.valueTable[n3];
            this.valueTable[n3] = null;
        } else {
            this.valueTable[n2] = null;
        }
    }

    public void shrink(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("maximumCapacity must be >= 0: " + n2);
        }
        if (this.size > n2) {
            n2 = this.size;
        }
        if (this.capacity <= n2) {
            return;
        }
        n2 = CuckooObjectMap.nextPowerOfTwo(n2);
        this.resize(n2);
    }

    public void clear(int n2) {
        if (this.capacity <= n2) {
            this.clear();
            return;
        }
        this.size = 0;
        this.resize(n2);
    }

    public void clear() {
        K[] KArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n2 = this.capacity + this.stashSize;
        while (n2-- > 0) {
            KArray[n2] = null;
            VArray[n2] = null;
        }
        this.size = 0;
        this.stashSize = 0;
    }

    public boolean containsValue(Object object, boolean bl2) {
        V[] VArray = this.valueTable;
        if (object == null) {
            K[] KArray = this.keyTable;
            int n2 = this.capacity + this.stashSize;
            while (n2-- > 0) {
                if (KArray[n2] == null || VArray[n2] != null) continue;
                return true;
            }
        } else if (bl2) {
            int n3 = this.capacity + this.stashSize;
            while (n3-- > 0) {
                if (VArray[n3] != object) continue;
                return true;
            }
        } else {
            int n4 = this.capacity + this.stashSize;
            while (n4-- > 0) {
                if (!object.equals(VArray[n4])) continue;
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(K k2) {
        int n2 = k2.hashCode();
        int n3 = n2 & this.mask;
        if (!(k2.equals(this.keyTable[n3]) || k2.equals(this.keyTable[n3 = this.hash2(n2)]) || k2.equals(this.keyTable[n3 = this.hash3(n2)]))) {
            if (this.isBigTable) {
                n3 = this.hash4(n2);
                if (!k2.equals(this.keyTable[n3])) {
                    return this.containsKeyStash(k2);
                }
            } else {
                return this.containsKeyStash(k2);
            }
        }
        return true;
    }

    private boolean containsKeyStash(K k2) {
        int n2;
        K[] KArray = this.keyTable;
        int n3 = n2 + this.stashSize;
        for (n2 = this.capacity; n2 < n3; ++n2) {
            if (!k2.equals(KArray[n2])) continue;
            return true;
        }
        return false;
    }

    public K findKey(Object object, boolean bl2) {
        V[] VArray = this.valueTable;
        if (object == null) {
            K[] KArray = this.keyTable;
            int n2 = this.capacity + this.stashSize;
            while (n2-- > 0) {
                if (KArray[n2] == null || VArray[n2] != null) continue;
                return KArray[n2];
            }
        } else if (bl2) {
            int n3 = this.capacity + this.stashSize;
            while (n3-- > 0) {
                if (VArray[n3] != object) continue;
                return this.keyTable[n3];
            }
        } else {
            int n4 = this.capacity + this.stashSize;
            while (n4-- > 0) {
                if (!object.equals(VArray[n4])) continue;
                return this.keyTable[n4];
            }
        }
        return null;
    }

    public void ensureCapacity(int n2) {
        int n3 = this.size + n2;
        if (n3 >= this.threshold) {
            this.resize(CuckooObjectMap.nextPowerOfTwo((int)((float)n3 / this.loadFactor)));
        }
    }

    private void resize(int n2) {
        int n3 = this.capacity + this.stashSize;
        this.capacity = n2;
        this.threshold = (int)((float)n2 * this.loadFactor);
        this.mask = n2 - 1;
        this.hashShift = 31 - Integer.numberOfTrailingZeros(n2);
        this.stashCapacity = Math.max(3, (int)Math.ceil(Math.log(n2)) * 2);
        this.pushIterations = Math.max(Math.min(n2, 8), (int)Math.sqrt(n2) / 8);
        this.isBigTable = this.capacity >>> 16 != 0;
        K[] KArray = this.keyTable;
        V[] VArray = this.valueTable;
        this.keyTable = new Object[n2 + this.stashCapacity];
        this.valueTable = new Object[n2 + this.stashCapacity];
        int n4 = this.size;
        this.size = 0;
        this.stashSize = 0;
        if (n4 > 0) {
            for (int i2 = 0; i2 < n3; ++i2) {
                K k2 = KArray[i2];
                if (k2 == null) continue;
                this.putResize(k2, VArray[i2]);
            }
        }
    }

    private int hash2(int n2) {
        return ((n2 *= -1105259343) ^ n2 >>> this.hashShift) & this.mask;
    }

    private int hash3(int n2) {
        return ((n2 *= -1262997959) ^ n2 >>> this.hashShift) & this.mask;
    }

    private int hash4(int n2) {
        return ((n2 *= -825114047) ^ n2 >>> this.hashShift) & this.mask;
    }

    public String toString() {
        K k2;
        if (this.size == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('{');
        K[] KArray = this.keyTable;
        V[] VArray = this.valueTable;
        int n2 = KArray.length;
        while (n2-- > 0) {
            k2 = KArray[n2];
            if (k2 == null) continue;
            stringBuilder.append(k2);
            stringBuilder.append('=');
            stringBuilder.append(VArray[n2]);
            break;
        }
        while (n2-- > 0) {
            k2 = KArray[n2];
            if (k2 == null) continue;
            stringBuilder.append(", ");
            stringBuilder.append(k2);
            stringBuilder.append('=');
            stringBuilder.append(VArray[n2]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Entries<K, V> entries() {
        return new Entries(this);
    }

    public Values<V> values() {
        return new Values(this);
    }

    public Keys<K> keys() {
        return new Keys(this);
    }

    public static int nextPowerOfTwo(int n2) {
        if (n2 == 0) {
            return 1;
        }
        --n2;
        n2 |= n2 >> 1;
        n2 |= n2 >> 2;
        n2 |= n2 >> 4;
        n2 |= n2 >> 8;
        n2 |= n2 >> 16;
        return n2 + 1;
    }

    public static class Keys<K>
    extends MapIterator<K, Object>
    implements Iterable<K>,
    Iterator<K> {
        public Keys(CuckooObjectMap<K, ?> cuckooObjectMap) {
            super(cuckooObjectMap);
        }

        @Override
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override
        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            Object k2 = this.map.keyTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.advance();
            return k2;
        }

        @Override
        public Iterator<K> iterator() {
            return this;
        }

        public ArrayList<K> toArray() {
            ArrayList<K> arrayList = new ArrayList<K>(this.map.size);
            while (this.hasNext) {
                arrayList.add(this.next());
            }
            return arrayList;
        }
    }

    public static class Values<V>
    extends MapIterator<Object, V>
    implements Iterable<V>,
    Iterator<V> {
        public Values(CuckooObjectMap<?, V> cuckooObjectMap) {
            super(cuckooObjectMap);
        }

        @Override
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override
        public V next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            Object v2 = this.map.valueTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.advance();
            return v2;
        }

        @Override
        public Iterator<V> iterator() {
            return this;
        }

        public ArrayList<V> toArray() {
            ArrayList<V> arrayList = new ArrayList<V>(this.map.size);
            while (this.hasNext) {
                arrayList.add(this.next());
            }
            return arrayList;
        }

        public void toArray(ArrayList<V> arrayList) {
            while (this.hasNext) {
                arrayList.add(this.next());
            }
        }
    }

    public static class Entries<K, V>
    extends MapIterator<K, V>
    implements Iterable<Entry<K, V>>,
    Iterator<Entry<K, V>> {
        Entry<K, V> entry = new Entry();

        public Entries(CuckooObjectMap<K, V> cuckooObjectMap) {
            super(cuckooObjectMap);
        }

        @Override
        public Entry<K, V> next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            K[] KArray = this.map.keyTable;
            this.entry.key = KArray[this.nextIndex];
            this.entry.value = this.map.valueTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.advance();
            return this.entry;
        }

        @Override
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return this;
        }
    }

    static class MapIterator<K, V> {
        public boolean hasNext;
        final CuckooObjectMap<K, V> map;
        int nextIndex;
        int currentIndex;

        public MapIterator(CuckooObjectMap<K, V> cuckooObjectMap) {
            this.map = cuckooObjectMap;
            this.reset();
        }

        public void reset() {
            this.currentIndex = -1;
            this.nextIndex = -1;
            this.advance();
        }

        void advance() {
            this.hasNext = false;
            K[] KArray = this.map.keyTable;
            int n2 = this.map.capacity + this.map.stashSize;
            while (++this.nextIndex < n2) {
                if (KArray[this.nextIndex] == null) continue;
                this.hasNext = true;
                break;
            }
        }

        public void remove() {
            if (this.currentIndex < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            if (this.currentIndex >= this.map.capacity) {
                this.map.removeStashIndex(this.currentIndex);
                this.nextIndex = this.currentIndex - 1;
                this.advance();
            } else {
                this.map.keyTable[this.currentIndex] = null;
                this.map.valueTable[this.currentIndex] = null;
            }
            this.currentIndex = -1;
            --this.map.size;
        }
    }

    public static class Entry<K, V> {
        public K key;
        public V value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}

