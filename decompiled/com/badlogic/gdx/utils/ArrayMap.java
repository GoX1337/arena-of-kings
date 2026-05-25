/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.StringBuilder;
import com.badlogic.gdx.utils.reflect.ArrayReflection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayMap<K, V>
implements Iterable<ObjectMap.Entry<K, V>> {
    public K[] keys;
    public V[] values;
    public int size;
    public boolean ordered;
    private transient Entries entries1;
    private transient Entries entries2;
    private transient Values values1;
    private transient Values values2;
    private transient Keys keys1;
    private transient Keys keys2;

    public ArrayMap() {
        this(true, 16);
    }

    public ArrayMap(int n2) {
        this(true, n2);
    }

    public ArrayMap(boolean bl2, int n2) {
        this.ordered = bl2;
        this.keys = new Object[n2];
        this.values = new Object[n2];
    }

    public ArrayMap(boolean bl2, int n2, Class clazz, Class clazz2) {
        this.ordered = bl2;
        this.keys = (Object[])ArrayReflection.newInstance(clazz, n2);
        this.values = (Object[])ArrayReflection.newInstance(clazz2, n2);
    }

    public ArrayMap(Class clazz, Class clazz2) {
        this(false, 16, clazz, clazz2);
    }

    public ArrayMap(ArrayMap arrayMap) {
        this(arrayMap.ordered, arrayMap.size, arrayMap.keys.getClass().getComponentType(), arrayMap.values.getClass().getComponentType());
        this.size = arrayMap.size;
        System.arraycopy(arrayMap.keys, 0, this.keys, 0, this.size);
        System.arraycopy(arrayMap.values, 0, this.values, 0, this.size);
    }

    public int put(K k2, V v2) {
        int n2 = this.indexOfKey(k2);
        if (n2 == -1) {
            if (this.size == this.keys.length) {
                this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
            }
            n2 = this.size++;
        }
        this.keys[n2] = k2;
        this.values[n2] = v2;
        return n2;
    }

    public int put(K k2, V v2, int n2) {
        int n3 = this.indexOfKey(k2);
        if (n3 != -1) {
            this.removeIndex(n3);
        } else if (this.size == this.keys.length) {
            this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        System.arraycopy(this.keys, n2, this.keys, n2 + 1, this.size - n2);
        System.arraycopy(this.values, n2, this.values, n2 + 1, this.size - n2);
        this.keys[n2] = k2;
        this.values[n2] = v2;
        ++this.size;
        return n2;
    }

    public void putAll(ArrayMap<? extends K, ? extends V> arrayMap) {
        this.putAll(arrayMap, 0, arrayMap.size);
    }

    public void putAll(ArrayMap<? extends K, ? extends V> arrayMap, int n2, int n3) {
        if (n2 + n3 > arrayMap.size) {
            throw new IllegalArgumentException("offset + length must be <= size: " + n2 + " + " + n3 + " <= " + arrayMap.size);
        }
        int n4 = this.size + n3 - n2;
        if (n4 >= this.keys.length) {
            this.resize(Math.max(8, (int)((float)n4 * 1.75f)));
        }
        System.arraycopy(arrayMap.keys, n2, this.keys, this.size, n3);
        System.arraycopy(arrayMap.values, n2, this.values, this.size, n3);
        this.size += n3;
    }

    @Null
    public V get(K k2) {
        return this.get(k2, null);
    }

    @Null
    public V get(K k2, @Null V v2) {
        int n2;
        K[] KArray = this.keys;
        if (k2 == null) {
            for (n2 = this.size - 1; n2 >= 0; --n2) {
                if (KArray[n2] != k2) continue;
                return this.values[n2];
            }
        } else {
            while (n2 >= 0) {
                if (k2.equals(KArray[n2])) {
                    return this.values[n2];
                }
                --n2;
            }
        }
        return v2;
    }

    @Null
    public K getKey(V v2, boolean bl2) {
        int n2;
        V[] VArray = this.values;
        if (bl2 || v2 == null) {
            for (n2 = this.size - 1; n2 >= 0; --n2) {
                if (VArray[n2] != v2) continue;
                return this.keys[n2];
            }
        } else {
            while (n2 >= 0) {
                if (v2.equals(VArray[n2])) {
                    return this.keys[n2];
                }
                --n2;
            }
        }
        return null;
    }

    public K getKeyAt(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(n2));
        }
        return this.keys[n2];
    }

    public V getValueAt(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(n2));
        }
        return this.values[n2];
    }

    public K firstKey() {
        if (this.size == 0) {
            throw new IllegalStateException("Map is empty.");
        }
        return this.keys[0];
    }

    public V firstValue() {
        if (this.size == 0) {
            throw new IllegalStateException("Map is empty.");
        }
        return this.values[0];
    }

    public void setKey(int n2, K k2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(n2));
        }
        this.keys[n2] = k2;
    }

    public void setValue(int n2, V v2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(n2));
        }
        this.values[n2] = v2;
    }

    public void insert(int n2, K k2, V v2) {
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(n2));
        }
        if (this.size == this.keys.length) {
            this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        if (this.ordered) {
            System.arraycopy(this.keys, n2, this.keys, n2 + 1, this.size - n2);
            System.arraycopy(this.values, n2, this.values, n2 + 1, this.size - n2);
        } else {
            this.keys[this.size] = this.keys[n2];
            this.values[this.size] = this.values[n2];
        }
        ++this.size;
        this.keys[n2] = k2;
        this.values[n2] = v2;
    }

    public boolean containsKey(K k2) {
        K[] KArray = this.keys;
        int n2 = this.size - 1;
        if (k2 == null) {
            while (n2 >= 0) {
                if (KArray[n2--] != k2) continue;
                return true;
            }
        } else {
            while (n2 >= 0) {
                if (!k2.equals(KArray[n2--])) continue;
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V v2, boolean bl2) {
        V[] VArray = this.values;
        int n2 = this.size - 1;
        if (bl2 || v2 == null) {
            while (n2 >= 0) {
                if (VArray[n2--] != v2) continue;
                return true;
            }
        } else {
            while (n2 >= 0) {
                if (!v2.equals(VArray[n2--])) continue;
                return true;
            }
        }
        return false;
    }

    public int indexOfKey(K k2) {
        K[] KArray = this.keys;
        if (k2 == null) {
            int n2 = this.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (KArray[i2] != k2) continue;
                return i2;
            }
        } else {
            int n3 = this.size;
            for (int i3 = 0; i3 < n3; ++i3) {
                if (!k2.equals(KArray[i3])) continue;
                return i3;
            }
        }
        return -1;
    }

    public int indexOfValue(V v2, boolean bl2) {
        V[] VArray = this.values;
        if (bl2 || v2 == null) {
            int n2 = this.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (VArray[i2] != v2) continue;
                return i2;
            }
        } else {
            int n3 = this.size;
            for (int i3 = 0; i3 < n3; ++i3) {
                if (!v2.equals(VArray[i3])) continue;
                return i3;
            }
        }
        return -1;
    }

    @Null
    public V removeKey(K k2) {
        K[] KArray = this.keys;
        if (k2 == null) {
            int n2 = this.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (KArray[i2] != k2) continue;
                V v2 = this.values[i2];
                this.removeIndex(i2);
                return v2;
            }
        } else {
            int n3 = this.size;
            for (int i3 = 0; i3 < n3; ++i3) {
                if (!k2.equals(KArray[i3])) continue;
                V v3 = this.values[i3];
                this.removeIndex(i3);
                return v3;
            }
        }
        return null;
    }

    public boolean removeValue(V v2, boolean bl2) {
        V[] VArray = this.values;
        if (bl2 || v2 == null) {
            int n2 = this.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (VArray[i2] != v2) continue;
                this.removeIndex(i2);
                return true;
            }
        } else {
            int n3 = this.size;
            for (int i3 = 0; i3 < n3; ++i3) {
                if (!v2.equals(VArray[i3])) continue;
                this.removeIndex(i3);
                return true;
            }
        }
        return false;
    }

    public void removeIndex(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(n2));
        }
        K[] KArray = this.keys;
        --this.size;
        if (this.ordered) {
            System.arraycopy(KArray, n2 + 1, KArray, n2, this.size - n2);
            System.arraycopy(this.values, n2 + 1, this.values, n2, this.size - n2);
        } else {
            KArray[n2] = KArray[this.size];
            this.values[n2] = this.values[this.size];
        }
        KArray[this.size] = null;
        this.values[this.size] = null;
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public K peekKey() {
        return this.keys[this.size - 1];
    }

    public V peekValue() {
        return this.values[this.size - 1];
    }

    public void clear(int n2) {
        if (this.keys.length <= n2) {
            this.clear();
            return;
        }
        this.size = 0;
        this.resize(n2);
    }

    public void clear() {
        Arrays.fill(this.keys, 0, this.size, null);
        Arrays.fill(this.values, 0, this.size, null);
        this.size = 0;
    }

    public void shrink() {
        if (this.keys.length == this.size) {
            return;
        }
        this.resize(this.size);
    }

    public void ensureCapacity(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + n2);
        }
        int n3 = this.size + n2;
        if (n3 > this.keys.length) {
            this.resize(Math.max(Math.max(8, n3), (int)((float)this.size * 1.75f)));
        }
    }

    protected void resize(int n2) {
        Object[] objectArray = (Object[])ArrayReflection.newInstance(this.keys.getClass().getComponentType(), n2);
        System.arraycopy(this.keys, 0, objectArray, 0, Math.min(this.size, objectArray.length));
        this.keys = objectArray;
        Object[] objectArray2 = (Object[])ArrayReflection.newInstance(this.values.getClass().getComponentType(), n2);
        System.arraycopy(this.values, 0, objectArray2, 0, Math.min(this.size, objectArray2.length));
        this.values = objectArray2;
    }

    public void reverse() {
        int n2 = this.size - 1;
        int n3 = this.size / 2;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = n2 - i2;
            K k2 = this.keys[i2];
            this.keys[i2] = this.keys[n4];
            this.keys[n4] = k2;
            V v2 = this.values[i2];
            this.values[i2] = this.values[n4];
            this.values[n4] = v2;
        }
    }

    public void shuffle() {
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            int n2 = MathUtils.random(i2);
            K k2 = this.keys[i2];
            this.keys[i2] = this.keys[n2];
            this.keys[n2] = k2;
            V v2 = this.values[i2];
            this.values[i2] = this.values[n2];
            this.values[n2] = v2;
        }
    }

    public void truncate(int n2) {
        if (this.size <= n2) {
            return;
        }
        for (int i2 = n2; i2 < this.size; ++i2) {
            this.keys[i2] = null;
            this.values[i2] = null;
        }
        this.size = n2;
    }

    public int hashCode() {
        K[] KArray = this.keys;
        V[] VArray = this.values;
        int n2 = 0;
        int n3 = this.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            K k2 = KArray[i2];
            V v2 = VArray[i2];
            if (k2 != null) {
                n2 += k2.hashCode() * 31;
            }
            if (v2 == null) continue;
            n2 += v2.hashCode();
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ArrayMap)) {
            return false;
        }
        ArrayMap arrayMap = (ArrayMap)object;
        if (arrayMap.size != this.size) {
            return false;
        }
        K[] KArray = this.keys;
        V[] VArray = this.values;
        int n2 = this.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            K k2 = KArray[i2];
            V v2 = VArray[i2];
            if (!(v2 == null ? arrayMap.get(k2, ObjectMap.dummy) != null : !v2.equals(arrayMap.get(k2)))) continue;
            return false;
        }
        return true;
    }

    public boolean equalsIdentity(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ArrayMap)) {
            return false;
        }
        ArrayMap arrayMap = (ArrayMap)object;
        if (arrayMap.size != this.size) {
            return false;
        }
        K[] KArray = this.keys;
        V[] VArray = this.values;
        int n2 = this.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (VArray[i2] == arrayMap.get(KArray[i2], ObjectMap.dummy)) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        if (this.size == 0) {
            return "{}";
        }
        K[] KArray = this.keys;
        V[] VArray = this.values;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('{');
        stringBuilder.append(KArray[0]);
        stringBuilder.append('=');
        stringBuilder.append(VArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(", ");
            stringBuilder.append(KArray[i2]);
            stringBuilder.append('=');
            stringBuilder.append(VArray[i2]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    public Iterator<ObjectMap.Entry<K, V>> iterator() {
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
            this.entries1.index = 0;
            this.entries1.valid = true;
            this.entries2.valid = false;
            return this.entries1;
        }
        this.entries2.index = 0;
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
            this.values1.index = 0;
            this.values1.valid = true;
            this.values2.valid = false;
            return this.values1;
        }
        this.values2.index = 0;
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
            this.keys1.index = 0;
            this.keys1.valid = true;
            this.keys2.valid = false;
            return this.keys1;
        }
        this.keys2.index = 0;
        this.keys2.valid = true;
        this.keys1.valid = false;
        return this.keys2;
    }

    public static class Keys<K>
    implements Iterable<K>,
    Iterator<K> {
        private final ArrayMap<K, Object> map;
        int index;
        boolean valid = true;

        public Keys(ArrayMap<K, Object> arrayMap) {
            this.map = arrayMap;
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.index < this.map.size;
        }

        @Override
        public Iterator<K> iterator() {
            return this;
        }

        @Override
        public K next() {
            if (this.index >= this.map.size) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.map.keys[this.index++];
        }

        @Override
        public void remove() {
            --this.index;
            this.map.removeIndex(this.index);
        }

        public void reset() {
            this.index = 0;
        }

        public Array<K> toArray() {
            return new Array(true, this.map.keys, this.index, this.map.size - this.index);
        }

        public Array<K> toArray(Array array) {
            array.addAll(this.map.keys, this.index, this.map.size - this.index);
            return array;
        }
    }

    public static class Values<V>
    implements Iterable<V>,
    Iterator<V> {
        private final ArrayMap<Object, V> map;
        int index;
        boolean valid = true;

        public Values(ArrayMap<Object, V> arrayMap) {
            this.map = arrayMap;
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.index < this.map.size;
        }

        @Override
        public Iterator<V> iterator() {
            return this;
        }

        @Override
        public V next() {
            if (this.index >= this.map.size) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.map.values[this.index++];
        }

        @Override
        public void remove() {
            --this.index;
            this.map.removeIndex(this.index);
        }

        public void reset() {
            this.index = 0;
        }

        public Array<V> toArray() {
            return new Array(true, this.map.values, this.index, this.map.size - this.index);
        }

        public Array<V> toArray(Array array) {
            array.addAll(this.map.values, this.index, this.map.size - this.index);
            return array;
        }
    }

    public static class Entries<K, V>
    implements Iterable<ObjectMap.Entry<K, V>>,
    Iterator<ObjectMap.Entry<K, V>> {
        private final ArrayMap<K, V> map;
        ObjectMap.Entry<K, V> entry = new ObjectMap.Entry();
        int index;
        boolean valid = true;

        public Entries(ArrayMap<K, V> arrayMap) {
            this.map = arrayMap;
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.index < this.map.size;
        }

        @Override
        public Iterator<ObjectMap.Entry<K, V>> iterator() {
            return this;
        }

        @Override
        public ObjectMap.Entry<K, V> next() {
            if (this.index >= this.map.size) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            this.entry.key = this.map.keys[this.index];
            this.entry.value = this.map.values[this.index++];
            return this.entry;
        }

        @Override
        public void remove() {
            --this.index;
            this.map.removeIndex(this.index);
        }

        public void reset() {
            this.index = 0;
        }
    }
}

