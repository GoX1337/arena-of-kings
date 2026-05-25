/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Predicate;
import com.badlogic.gdx.utils.Select;
import com.badlogic.gdx.utils.Sort;
import com.badlogic.gdx.utils.StringBuilder;
import com.badlogic.gdx.utils.reflect.ArrayReflection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array<T>
implements Iterable<T> {
    public T[] items;
    public int size;
    public boolean ordered;
    private ArrayIterable iterable;
    private Predicate.PredicateIterable<T> predicateIterable;

    public Array() {
        this(true, 16);
    }

    public Array(int n2) {
        this(true, n2);
    }

    public Array(boolean bl2, int n2) {
        this.ordered = bl2;
        this.items = new Object[n2];
    }

    public Array(boolean bl2, int n2, Class clazz) {
        this.ordered = bl2;
        this.items = (Object[])ArrayReflection.newInstance(clazz, n2);
    }

    public Array(Class clazz) {
        this(true, 16, clazz);
    }

    public Array(Array<? extends T> array) {
        this(array.ordered, array.size, array.items.getClass().getComponentType());
        this.size = array.size;
        System.arraycopy(array.items, 0, this.items, 0, this.size);
    }

    public Array(T[] TArray) {
        this(true, TArray, 0, TArray.length);
    }

    public Array(boolean bl2, T[] TArray, int n2, int n3) {
        this(bl2, n3, TArray.getClass().getComponentType());
        this.size = n3;
        System.arraycopy(TArray, n2, this.items, 0, this.size);
    }

    public void add(T t2) {
        T[] TArray = this.items;
        if (this.size == TArray.length) {
            TArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        TArray[this.size++] = t2;
    }

    public void add(T t2, T t3) {
        T[] TArray = this.items;
        if (this.size + 1 >= TArray.length) {
            TArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        TArray[this.size] = t2;
        TArray[this.size + 1] = t3;
        this.size += 2;
    }

    public void add(T t2, T t3, T t4) {
        T[] TArray = this.items;
        if (this.size + 2 >= TArray.length) {
            TArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        TArray[this.size] = t2;
        TArray[this.size + 1] = t3;
        TArray[this.size + 2] = t4;
        this.size += 3;
    }

    public void add(T t2, T t3, T t4, T t5) {
        T[] TArray = this.items;
        if (this.size + 3 >= TArray.length) {
            TArray = this.resize(Math.max(8, (int)((float)this.size * 1.8f)));
        }
        TArray[this.size] = t2;
        TArray[this.size + 1] = t3;
        TArray[this.size + 2] = t4;
        TArray[this.size + 3] = t5;
        this.size += 4;
    }

    public void addAll(Array<? extends T> array) {
        this.addAll(array.items, 0, array.size);
    }

    public void addAll(Array<? extends T> array, int n2, int n3) {
        if (n2 + n3 > array.size) {
            throw new IllegalArgumentException("start + count must be <= size: " + n2 + " + " + n3 + " <= " + array.size);
        }
        this.addAll(array.items, n2, n3);
    }

    public void addAll(T ... TArray) {
        this.addAll(TArray, 0, TArray.length);
    }

    public void addAll(T[] TArray, int n2, int n3) {
        int n4 = this.size + n3;
        T[] TArray2 = this.items;
        if (n4 > TArray2.length) {
            TArray2 = this.resize(Math.max(Math.max(8, n4), (int)((float)this.size * 1.75f)));
        }
        System.arraycopy(TArray, n2, TArray2, this.size, n3);
        this.size = n4;
    }

    public T get(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        return this.items[n2];
    }

    public void set(int n2, T t2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        this.items[n2] = t2;
    }

    public void insert(int n2, T t2) {
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException("index can't be > size: " + n2 + " > " + this.size);
        }
        T[] TArray = this.items;
        if (this.size == TArray.length) {
            TArray = this.resize(Math.max(8, (int)((float)this.size * 1.75f)));
        }
        if (this.ordered) {
            System.arraycopy(TArray, n2, TArray, n2 + 1, this.size - n2);
        } else {
            TArray[this.size] = TArray[n2];
        }
        ++this.size;
        TArray[n2] = t2;
    }

    public void insertRange(int n2, int n3) {
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException("index can't be > size: " + n2 + " > " + this.size);
        }
        int n4 = this.size + n3;
        if (n4 > this.items.length) {
            this.items = this.resize(Math.max(Math.max(8, n4), (int)((float)this.size * 1.75f)));
        }
        System.arraycopy(this.items, n2, this.items, n2 + n3, this.size - n2);
        this.size = n4;
    }

    public void swap(int n2, int n3) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("first can't be >= size: " + n2 + " >= " + this.size);
        }
        if (n3 >= this.size) {
            throw new IndexOutOfBoundsException("second can't be >= size: " + n3 + " >= " + this.size);
        }
        T[] TArray = this.items;
        T t2 = TArray[n2];
        TArray[n2] = TArray[n3];
        TArray[n3] = t2;
    }

    public boolean contains(@Null T t2, boolean bl2) {
        T[] TArray = this.items;
        int n2 = this.size - 1;
        if (bl2 || t2 == null) {
            while (n2 >= 0) {
                if (TArray[n2--] != t2) continue;
                return true;
            }
        } else {
            while (n2 >= 0) {
                if (!t2.equals(TArray[n2--])) continue;
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Array<? extends T> array, boolean bl2) {
        T[] TArray = array.items;
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.contains(TArray[i2], bl2)) continue;
            return false;
        }
        return true;
    }

    public boolean containsAny(Array<? extends T> array, boolean bl2) {
        T[] TArray = array.items;
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.contains(TArray[i2], bl2)) continue;
            return true;
        }
        return false;
    }

    public int indexOf(@Null T t2, boolean bl2) {
        T[] TArray = this.items;
        if (bl2 || t2 == null) {
            int n2 = this.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (TArray[i2] != t2) continue;
                return i2;
            }
        } else {
            int n3 = this.size;
            for (int i3 = 0; i3 < n3; ++i3) {
                if (!t2.equals(TArray[i3])) continue;
                return i3;
            }
        }
        return -1;
    }

    public int lastIndexOf(@Null T t2, boolean bl2) {
        T[] TArray = this.items;
        if (bl2 || t2 == null) {
            for (int i2 = this.size - 1; i2 >= 0; --i2) {
                if (TArray[i2] != t2) continue;
                return i2;
            }
        } else {
            for (int i3 = this.size - 1; i3 >= 0; --i3) {
                if (!t2.equals(TArray[i3])) continue;
                return i3;
            }
        }
        return -1;
    }

    public boolean removeValue(@Null T t2, boolean bl2) {
        T[] TArray = this.items;
        if (bl2 || t2 == null) {
            int n2 = this.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (TArray[i2] != t2) continue;
                this.removeIndex(i2);
                return true;
            }
        } else {
            int n3 = this.size;
            for (int i3 = 0; i3 < n3; ++i3) {
                if (!t2.equals(TArray[i3])) continue;
                this.removeIndex(i3);
                return true;
            }
        }
        return false;
    }

    public T removeIndex(int n2) {
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        T[] TArray = this.items;
        T t2 = TArray[n2];
        --this.size;
        if (this.ordered) {
            System.arraycopy(TArray, n2 + 1, TArray, n2, this.size - n2);
        } else {
            TArray[n2] = TArray[this.size];
        }
        TArray[this.size] = null;
        return t2;
    }

    public void removeRange(int n2, int n3) {
        int n4;
        int n5 = this.size;
        if (n3 >= n5) {
            throw new IndexOutOfBoundsException("end can't be >= size: " + n3 + " >= " + this.size);
        }
        if (n2 > n3) {
            throw new IndexOutOfBoundsException("start can't be > end: " + n2 + " > " + n3);
        }
        T[] TArray = this.items;
        int n6 = n3 - n2 + 1;
        int n7 = n5 - n6;
        if (this.ordered) {
            System.arraycopy(TArray, n2 + n6, TArray, n2, n5 - (n2 + n6));
        } else {
            n4 = Math.max(n7, n3 + 1);
            System.arraycopy(TArray, n4, TArray, n2, n5 - n4);
        }
        for (n4 = n7; n4 < n5; ++n4) {
            TArray[n4] = null;
        }
        this.size = n5 - n6;
    }

    public boolean removeAll(Array<? extends T> array, boolean bl2) {
        int n2;
        int n3 = n2 = this.size;
        T[] TArray = this.items;
        if (bl2) {
            int n4 = array.size;
            block0: for (int i2 = 0; i2 < n4; ++i2) {
                T t2 = array.get(i2);
                for (int i3 = 0; i3 < n2; ++i3) {
                    if (t2 != TArray[i3]) continue;
                    this.removeIndex(i3);
                    --n2;
                    continue block0;
                }
            }
        } else {
            int n5 = array.size;
            block2: for (int i4 = 0; i4 < n5; ++i4) {
                T t3 = array.get(i4);
                for (int i5 = 0; i5 < n2; ++i5) {
                    if (!t3.equals(TArray[i5])) continue;
                    this.removeIndex(i5);
                    --n2;
                    continue block2;
                }
            }
        }
        return n2 != n3;
    }

    public T pop() {
        if (this.size == 0) {
            throw new IllegalStateException("Array is empty.");
        }
        --this.size;
        T t2 = this.items[this.size];
        this.items[this.size] = null;
        return t2;
    }

    public T peek() {
        if (this.size == 0) {
            throw new IllegalStateException("Array is empty.");
        }
        return this.items[this.size - 1];
    }

    public T first() {
        if (this.size == 0) {
            throw new IllegalStateException("Array is empty.");
        }
        return this.items[0];
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        Arrays.fill(this.items, 0, this.size, null);
        this.size = 0;
    }

    public T[] shrink() {
        if (this.items.length != this.size) {
            this.resize(this.size);
        }
        return this.items;
    }

    public T[] ensureCapacity(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + n2);
        }
        int n3 = this.size + n2;
        if (n3 > this.items.length) {
            this.resize(Math.max(Math.max(8, n3), (int)((float)this.size * 1.75f)));
        }
        return this.items;
    }

    public T[] setSize(int n2) {
        this.truncate(n2);
        if (n2 > this.items.length) {
            this.resize(Math.max(8, n2));
        }
        this.size = n2;
        return this.items;
    }

    protected T[] resize(int n2) {
        T[] TArray = this.items;
        Object[] objectArray = (Object[])ArrayReflection.newInstance(TArray.getClass().getComponentType(), n2);
        System.arraycopy(TArray, 0, objectArray, 0, Math.min(this.size, objectArray.length));
        this.items = objectArray;
        return objectArray;
    }

    public void sort() {
        Sort.instance().sort(this.items, 0, this.size);
    }

    public void sort(Comparator<? super T> comparator) {
        Sort.instance().sort(this.items, comparator, 0, this.size);
    }

    public T selectRanked(Comparator<T> comparator, int n2) {
        if (n2 < 1) {
            throw new GdxRuntimeException("nth_lowest must be greater than 0, 1 = first, 2 = second...");
        }
        return Select.instance().select(this.items, comparator, n2, this.size);
    }

    public int selectRankedIndex(Comparator<T> comparator, int n2) {
        if (n2 < 1) {
            throw new GdxRuntimeException("nth_lowest must be greater than 0, 1 = first, 2 = second...");
        }
        return Select.instance().selectIndex(this.items, comparator, n2, this.size);
    }

    public void reverse() {
        T[] TArray = this.items;
        int n2 = this.size - 1;
        int n3 = this.size / 2;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = n2 - i2;
            T t2 = TArray[i2];
            TArray[i2] = TArray[n4];
            TArray[n4] = t2;
        }
    }

    public void shuffle() {
        T[] TArray = this.items;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            int n2 = MathUtils.random(i2);
            T t2 = TArray[i2];
            TArray[i2] = TArray[n2];
            TArray[n2] = t2;
        }
    }

    @Override
    public ArrayIterator<T> iterator() {
        if (Collections.allocateIterators) {
            return new ArrayIterator(this, true);
        }
        if (this.iterable == null) {
            this.iterable = new ArrayIterable(this);
        }
        return this.iterable.iterator();
    }

    public Iterable<T> select(Predicate<T> predicate) {
        if (Collections.allocateIterators) {
            return new Predicate.PredicateIterable<T>(this, predicate);
        }
        if (this.predicateIterable == null) {
            this.predicateIterable = new Predicate.PredicateIterable<T>(this, predicate);
        } else {
            this.predicateIterable.set(this, predicate);
        }
        return this.predicateIterable;
    }

    public void truncate(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("newSize must be >= 0: " + n2);
        }
        if (this.size <= n2) {
            return;
        }
        for (int i2 = n2; i2 < this.size; ++i2) {
            this.items[i2] = null;
        }
        this.size = n2;
    }

    @Null
    public T random() {
        if (this.size == 0) {
            return null;
        }
        return this.items[MathUtils.random(0, this.size - 1)];
    }

    public T[] toArray() {
        return this.toArray(this.items.getClass().getComponentType());
    }

    public <V> V[] toArray(Class<V> clazz) {
        Object[] objectArray = (Object[])ArrayReflection.newInstance(clazz, this.size);
        System.arraycopy(this.items, 0, objectArray, 0, this.size);
        return objectArray;
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        T[] TArray = this.items;
        int n2 = 1;
        int n3 = this.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 *= 31;
            T t2 = TArray[i2];
            if (t2 == null) continue;
            n2 += t2.hashCode();
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!this.ordered) {
            return false;
        }
        if (!(object instanceof Array)) {
            return false;
        }
        Array array = (Array)object;
        if (!array.ordered) {
            return false;
        }
        int n2 = this.size;
        if (n2 != array.size) {
            return false;
        }
        T[] TArray = this.items;
        T[] TArray2 = array.items;
        for (int i2 = 0; i2 < n2; ++i2) {
            T t2 = TArray[i2];
            T t3 = TArray2[i2];
            if (t2 != null ? t2.equals(t3) : t3 == null) continue;
            return false;
        }
        return true;
    }

    public boolean equalsIdentity(Object object) {
        if (object == this) {
            return true;
        }
        if (!this.ordered) {
            return false;
        }
        if (!(object instanceof Array)) {
            return false;
        }
        Array array = (Array)object;
        if (!array.ordered) {
            return false;
        }
        int n2 = this.size;
        if (n2 != array.size) {
            return false;
        }
        T[] TArray = this.items;
        T[] TArray2 = array.items;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (TArray[i2] == TArray2[i2]) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        T[] TArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(TArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(", ");
            stringBuilder.append(TArray[i2]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String toString(String string) {
        if (this.size == 0) {
            return "";
        }
        T[] TArray = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(TArray[0]);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(string);
            stringBuilder.append(TArray[i2]);
        }
        return stringBuilder.toString();
    }

    public static <T> Array<T> of(Class<T> clazz) {
        return new Array<T>(clazz);
    }

    public static <T> Array<T> of(boolean bl2, int n2, Class<T> clazz) {
        return new Array<T>(bl2, n2, clazz);
    }

    public static <T> Array<T> with(T ... TArray) {
        return new Array<T>(TArray);
    }

    public static class ArrayIterable<T>
    implements Iterable<T> {
        private final Array<T> array;
        private final boolean allowRemove;
        private ArrayIterator iterator1;
        private ArrayIterator iterator2;

        public ArrayIterable(Array<T> array) {
            this(array, true);
        }

        public ArrayIterable(Array<T> array, boolean bl2) {
            this.array = array;
            this.allowRemove = bl2;
        }

        @Override
        public ArrayIterator<T> iterator() {
            if (Collections.allocateIterators) {
                return new ArrayIterator<T>(this.array, this.allowRemove);
            }
            if (this.iterator1 == null) {
                this.iterator1 = new ArrayIterator<T>(this.array, this.allowRemove);
                this.iterator2 = new ArrayIterator<T>(this.array, this.allowRemove);
            }
            if (!this.iterator1.valid) {
                this.iterator1.index = 0;
                this.iterator1.valid = true;
                this.iterator2.valid = false;
                return this.iterator1;
            }
            this.iterator2.index = 0;
            this.iterator2.valid = true;
            this.iterator1.valid = false;
            return this.iterator2;
        }
    }

    public static class ArrayIterator<T>
    implements Iterable<T>,
    Iterator<T> {
        private final Array<T> array;
        private final boolean allowRemove;
        int index;
        boolean valid = true;

        public ArrayIterator(Array<T> array) {
            this(array, true);
        }

        public ArrayIterator(Array<T> array, boolean bl2) {
            this.array = array;
            this.allowRemove = bl2;
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.index < this.array.size;
        }

        @Override
        public T next() {
            if (this.index >= this.array.size) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.array.items[this.index++];
        }

        @Override
        public void remove() {
            if (!this.allowRemove) {
                throw new GdxRuntimeException("Remove not allowed.");
            }
            --this.index;
            this.array.removeIndex(this.index);
        }

        public void reset() {
            this.index = 0;
        }

        @Override
        public ArrayIterator<T> iterator() {
            return this;
        }
    }
}

