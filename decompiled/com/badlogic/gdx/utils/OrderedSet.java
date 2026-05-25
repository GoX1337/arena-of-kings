/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectSet;
import java.util.NoSuchElementException;

public class OrderedSet<T>
extends ObjectSet<T> {
    final Array<T> items;
    transient OrderedSetIterator iterator1;
    transient OrderedSetIterator iterator2;

    public OrderedSet() {
        this.items = new Array();
    }

    public OrderedSet(int n2, float f2) {
        super(n2, f2);
        this.items = new Array(n2);
    }

    public OrderedSet(int n2) {
        super(n2);
        this.items = new Array(n2);
    }

    public OrderedSet(OrderedSet<? extends T> orderedSet) {
        super(orderedSet);
        this.items = new Array<T>(orderedSet.items);
    }

    @Override
    public boolean add(T t2) {
        if (!super.add(t2)) {
            return false;
        }
        this.items.add(t2);
        return true;
    }

    public boolean add(T t2, int n2) {
        if (!super.add(t2)) {
            int n3 = this.items.indexOf(t2, true);
            if (n3 != n2) {
                this.items.insert(n2, this.items.removeIndex(n3));
            }
            return false;
        }
        this.items.insert(n2, t2);
        return true;
    }

    @Override
    public void addAll(OrderedSet<T> orderedSet) {
        this.ensureCapacity(orderedSet.size);
        T[] TArray = orderedSet.items.items;
        int n2 = orderedSet.items.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.add(TArray[i2]);
        }
    }

    @Override
    public boolean remove(T t2) {
        if (!super.remove(t2)) {
            return false;
        }
        this.items.removeValue(t2, false);
        return true;
    }

    public T removeIndex(int n2) {
        T t2 = this.items.removeIndex(n2);
        super.remove(t2);
        return t2;
    }

    public boolean alter(T t2, T t3) {
        if (this.contains(t3)) {
            return false;
        }
        if (!super.remove(t2)) {
            return false;
        }
        super.add(t3);
        this.items.set(this.items.indexOf(t2, false), t3);
        return true;
    }

    public boolean alterIndex(int n2, T t2) {
        if (n2 < 0 || n2 >= this.size || this.contains(t2)) {
            return false;
        }
        super.remove(this.items.get(n2));
        super.add(t2);
        this.items.set(n2, t2);
        return true;
    }

    @Override
    public void clear(int n2) {
        this.items.clear();
        super.clear(n2);
    }

    @Override
    public void clear() {
        this.items.clear();
        super.clear();
    }

    public Array<T> orderedItems() {
        return this.items;
    }

    @Override
    public OrderedSetIterator<T> iterator() {
        if (Collections.allocateIterators) {
            return new OrderedSetIterator(this);
        }
        if (this.iterator1 == null) {
            this.iterator1 = new OrderedSetIterator(this);
            this.iterator2 = new OrderedSetIterator(this);
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

    @Override
    public String toString() {
        if (this.size == 0) {
            return "{}";
        }
        T[] TArray = this.items.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('{');
        stringBuilder.append(TArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(", ");
            stringBuilder.append(TArray[i2]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    public String toString(String string) {
        return this.items.toString(string);
    }

    public static <T> OrderedSet<T> with(T ... TArray) {
        OrderedSet<T> orderedSet = new OrderedSet<T>();
        orderedSet.addAll(TArray);
        return orderedSet;
    }

    public static class OrderedSetIterator<K>
    extends ObjectSet.ObjectSetIterator<K> {
        private Array<K> items;

        public OrderedSetIterator(OrderedSet<K> orderedSet) {
            super(orderedSet);
            this.items = orderedSet.items;
        }

        @Override
        public void reset() {
            this.nextIndex = 0;
            this.hasNext = this.set.size > 0;
        }

        @Override
        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            K k2 = this.items.get(this.nextIndex);
            ++this.nextIndex;
            this.hasNext = this.nextIndex < this.set.size;
            return k2;
        }

        @Override
        public void remove() {
            if (this.nextIndex < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            --this.nextIndex;
            ((OrderedSet)this.set).removeIndex(this.nextIndex);
        }

        @Override
        public Array<K> toArray(Array<K> array) {
            array.addAll(this.items, this.nextIndex, this.items.size - this.nextIndex);
            this.nextIndex = this.items.size;
            this.hasNext = false;
            return array;
        }

        @Override
        public Array<K> toArray() {
            return this.toArray(new Array(true, this.set.size - this.nextIndex));
        }
    }
}

