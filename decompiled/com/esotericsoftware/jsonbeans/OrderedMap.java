/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.jsonbeans;

import com.esotericsoftware.jsonbeans.ObjectMap;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderedMap<K, V>
extends ObjectMap<K, V> {
    final ArrayList<K> keys;

    public OrderedMap() {
        this.keys = new ArrayList();
    }

    public OrderedMap(int n2) {
        super(n2);
        this.keys = new ArrayList(n2);
    }

    public OrderedMap(int n2, float f2) {
        super(n2, f2);
        this.keys = new ArrayList(n2);
    }

    public OrderedMap(OrderedMap<? extends K, ? extends V> orderedMap) {
        super(orderedMap);
        this.keys = new ArrayList<K>(orderedMap.keys);
    }

    @Override
    public V put(K k2, V v2) {
        int n2 = this.locateKey(k2);
        if (n2 >= 0) {
            Object object = this.valueTable[n2];
            this.valueTable[n2] = v2;
            return (V)object;
        }
        n2 = -(n2 + 1);
        this.keyTable[n2] = k2;
        this.valueTable[n2] = v2;
        this.keys.add(k2);
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return null;
    }

    @Override
    public <T extends K> void putAll(OrderedMap<T, ? extends V> orderedMap) {
        this.ensureCapacity(orderedMap.size);
        ArrayList<K> arrayList = orderedMap.keys;
        int n2 = orderedMap.keys.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            K k2 = arrayList.get(i2);
            this.put(k2, orderedMap.get(k2));
        }
    }

    @Override
    public V remove(K k2) {
        this.keys.remove(k2);
        return super.remove(k2);
    }

    public V removeIndex(int n2) {
        return super.remove(this.keys.remove(n2));
    }

    public boolean alter(K k2, K k3) {
        if (this.containsKey(k3)) {
            return false;
        }
        int n2 = this.keys.indexOf(k2);
        if (n2 == -1) {
            return false;
        }
        super.put(k3, super.remove(k2));
        this.keys.set(n2, k3);
        return true;
    }

    public boolean alterIndex(int n2, K k2) {
        if (n2 < 0 || n2 >= this.size || this.containsKey(k2)) {
            return false;
        }
        super.put(k2, super.remove(this.keys.get(n2)));
        this.keys.set(n2, k2);
        return true;
    }

    @Override
    public void clear(int n2) {
        this.keys.clear();
        super.clear(n2);
    }

    @Override
    public void clear() {
        this.keys.clear();
        super.clear();
    }

    public ArrayList<K> orderedKeys() {
        return this.keys;
    }

    @Override
    public ObjectMap.Entries<K, V> iterator() {
        return this.entries();
    }

    @Override
    public ObjectMap.Entries<K, V> entries() {
        return new OrderedMapEntries(this);
    }

    @Override
    public ObjectMap.Values<V> values() {
        return new OrderedMapValues(this);
    }

    @Override
    public ObjectMap.Keys<K> keys() {
        return new OrderedMapKeys(this);
    }

    @Override
    public String toString() {
        if (this.size == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('{');
        ArrayList<K> arrayList = this.keys;
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            K k2 = arrayList.get(i2);
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(k2);
            stringBuilder.append('=');
            stringBuilder.append(this.get(k2));
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static class OrderedMapValues<V>
    extends ObjectMap.Values<V> {
        private ArrayList keys;

        public OrderedMapValues(OrderedMap<?, V> orderedMap) {
            super(orderedMap);
            this.keys = orderedMap.keys;
        }

        @Override
        public void reset() {
            this.currentIndex = -1;
            this.nextIndex = 0;
            this.hasNext = this.map.size > 0;
        }

        @Override
        public V next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            Object v2 = this.map.get(this.keys.get(this.nextIndex));
            this.currentIndex = this.nextIndex++;
            this.hasNext = this.nextIndex < this.map.size;
            return v2;
        }

        @Override
        public void remove() {
            if (this.currentIndex < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            ((OrderedMap)this.map).removeIndex(this.currentIndex);
            this.nextIndex = this.currentIndex;
            this.currentIndex = -1;
        }

        @Override
        public <T extends List<V>> T toList(T t2) {
            int n2 = this.keys.size();
            for (int i2 = this.nextIndex; i2 < n2; ++i2) {
                t2.add(this.map.get(this.keys.get(i2)));
            }
            this.currentIndex = n2 - 1;
            this.nextIndex = n2;
            this.hasNext = false;
            return t2;
        }

        @Override
        public ArrayList<V> toList() {
            return this.toList(new ArrayList(this.keys.size() - this.nextIndex));
        }
    }

    public static class OrderedMapKeys<K>
    extends ObjectMap.Keys<K> {
        private ArrayList<K> keys;

        public OrderedMapKeys(OrderedMap<K, ?> orderedMap) {
            super(orderedMap);
            this.keys = orderedMap.keys;
        }

        @Override
        public void reset() {
            this.currentIndex = -1;
            this.nextIndex = 0;
            this.hasNext = this.map.size > 0;
        }

        @Override
        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            K k2 = this.keys.get(this.nextIndex);
            this.currentIndex = this.nextIndex++;
            this.hasNext = this.nextIndex < this.map.size;
            return k2;
        }

        @Override
        public void remove() {
            if (this.currentIndex < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            ((OrderedMap)this.map).removeIndex(this.currentIndex);
            this.nextIndex = this.currentIndex;
            this.currentIndex = -1;
        }
    }

    public static class OrderedMapEntries<K, V>
    extends ObjectMap.Entries<K, V> {
        private ArrayList<K> keys;

        public OrderedMapEntries(OrderedMap<K, V> orderedMap) {
            super(orderedMap);
            this.keys = orderedMap.keys;
        }

        @Override
        public void reset() {
            this.currentIndex = -1;
            this.nextIndex = 0;
            this.hasNext = this.map.size > 0;
        }

        @Override
        public ObjectMap.Entry next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.currentIndex = this.nextIndex;
            this.entry.key = this.keys.get(this.nextIndex);
            this.entry.value = this.map.get(this.entry.key);
            ++this.nextIndex;
            this.hasNext = this.nextIndex < this.map.size;
            return this.entry;
        }

        @Override
        public void remove() {
            if (this.currentIndex < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            this.map.remove(this.entry.key);
            --this.nextIndex;
            this.currentIndex = -1;
        }
    }
}

