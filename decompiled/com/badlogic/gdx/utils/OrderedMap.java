/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import java.util.NoSuchElementException;

public class OrderedMap<K, V>
extends ObjectMap<K, V> {
    final Array<K> keys;

    public OrderedMap() {
        this.keys = new Array();
    }

    public OrderedMap(int n2) {
        super(n2);
        this.keys = new Array(n2);
    }

    public OrderedMap(int n2, float f2) {
        super(n2, f2);
        this.keys = new Array(n2);
    }

    public OrderedMap(OrderedMap<? extends K, ? extends V> orderedMap) {
        super(orderedMap);
        this.keys = new Array<K>(orderedMap.keys);
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
        T[] TArray = orderedMap.keys.items;
        int n2 = orderedMap.keys.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object t2 = TArray[i2];
            this.put(t2, orderedMap.get(t2));
        }
    }

    @Override
    public V remove(K k2) {
        this.keys.removeValue(k2, false);
        return super.remove(k2);
    }

    public V removeIndex(int n2) {
        return super.remove(this.keys.removeIndex(n2));
    }

    public boolean alter(K k2, K k3) {
        if (this.containsKey(k3)) {
            return false;
        }
        int n2 = this.keys.indexOf(k2, false);
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

    public Array<K> orderedKeys() {
        return this.keys;
    }

    @Override
    public ObjectMap.Entries<K, V> iterator() {
        return this.entries();
    }

    @Override
    public ObjectMap.Entries<K, V> entries() {
        if (Collections.allocateIterators) {
            return new OrderedMapEntries(this);
        }
        if (this.entries1 == null) {
            this.entries1 = new OrderedMapEntries(this);
            this.entries2 = new OrderedMapEntries(this);
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

    @Override
    public ObjectMap.Values<V> values() {
        if (Collections.allocateIterators) {
            return new OrderedMapValues(this);
        }
        if (this.values1 == null) {
            this.values1 = new OrderedMapValues(this);
            this.values2 = new OrderedMapValues(this);
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

    @Override
    public ObjectMap.Keys<K> keys() {
        if (Collections.allocateIterators) {
            return new OrderedMapKeys(this);
        }
        if (this.keys1 == null) {
            this.keys1 = new OrderedMapKeys(this);
            this.keys2 = new OrderedMapKeys(this);
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

    @Override
    protected String toString(String string, boolean bl2) {
        if (this.size == 0) {
            return bl2 ? "{}" : "";
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        if (bl2) {
            stringBuilder.append('{');
        }
        Array<K> array = this.keys;
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            K k2 = array.get(i2);
            if (i2 > 0) {
                stringBuilder.append(string);
            }
            stringBuilder.append((Object)(k2 == this ? "(this)" : k2));
            stringBuilder.append('=');
            Object v2 = this.get(k2);
            stringBuilder.append((Object)(v2 == this ? "(this)" : v2));
        }
        if (bl2) {
            stringBuilder.append('}');
        }
        return stringBuilder.toString();
    }

    public static class OrderedMapValues<V>
    extends ObjectMap.Values<V> {
        private Array keys;

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
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
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
        public Array<V> toArray(Array<V> array) {
            int n2 = this.keys.size;
            array.ensureCapacity(n2 - this.nextIndex);
            T[] TArray = this.keys.items;
            for (int i2 = this.nextIndex; i2 < n2; ++i2) {
                array.add(this.map.get(TArray[i2]));
            }
            this.currentIndex = n2 - 1;
            this.nextIndex = n2;
            this.hasNext = false;
            return array;
        }

        @Override
        public Array<V> toArray() {
            return this.toArray(new Array(true, this.keys.size - this.nextIndex));
        }
    }

    public static class OrderedMapKeys<K>
    extends ObjectMap.Keys<K> {
        private Array<K> keys;

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
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
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

        @Override
        public Array<K> toArray(Array<K> array) {
            array.addAll(this.keys, this.nextIndex, this.keys.size - this.nextIndex);
            this.nextIndex = this.keys.size;
            this.hasNext = false;
            return array;
        }

        @Override
        public Array<K> toArray() {
            return this.toArray(new Array(true, this.keys.size - this.nextIndex));
        }
    }

    public static class OrderedMapEntries<K, V>
    extends ObjectMap.Entries<K, V> {
        private Array<K> keys;

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
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
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

