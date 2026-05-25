/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;

public class PooledLinkedList<T> {
    private Item<T> head;
    private Item<T> tail;
    private Item<T> iter;
    private Item<T> curr;
    private int size = 0;
    private final Pool<Item<T>> pool;

    public PooledLinkedList(int n2) {
        this.pool = new Pool<Item<T>>(16, n2){

            @Override
            protected Item<T> newObject() {
                return new Item();
            }
        };
    }

    public void add(T t2) {
        Item<T> item = this.pool.obtain();
        item.payload = t2;
        item.next = null;
        item.prev = null;
        if (this.head == null) {
            this.head = item;
            this.tail = item;
            ++this.size;
            return;
        }
        item.prev = this.tail;
        this.tail.next = item;
        this.tail = item;
        ++this.size;
    }

    public void addFirst(T t2) {
        Item<T> item = this.pool.obtain();
        item.payload = t2;
        item.next = this.head;
        item.prev = null;
        if (this.head != null) {
            this.head.prev = item;
        } else {
            this.tail = item;
        }
        this.head = item;
        ++this.size;
    }

    public int size() {
        return this.size;
    }

    public void iter() {
        this.iter = this.head;
    }

    public void iterReverse() {
        this.iter = this.tail;
    }

    @Null
    public T next() {
        if (this.iter == null) {
            return null;
        }
        Object t2 = this.iter.payload;
        this.curr = this.iter;
        this.iter = this.iter.next;
        return t2;
    }

    @Null
    public T previous() {
        if (this.iter == null) {
            return null;
        }
        Object t2 = this.iter.payload;
        this.curr = this.iter;
        this.iter = this.iter.prev;
        return t2;
    }

    public void remove() {
        if (this.curr == null) {
            return;
        }
        --this.size;
        Item<T> item = this.curr;
        Item item2 = this.curr.next;
        Item item3 = this.curr.prev;
        this.pool.free(this.curr);
        this.curr = null;
        if (this.size == 0) {
            this.head = null;
            this.tail = null;
            return;
        }
        if (item == this.head) {
            item2.prev = null;
            this.head = item2;
            return;
        }
        if (item == this.tail) {
            item3.next = null;
            this.tail = item3;
            return;
        }
        item3.next = item2;
        item2.prev = item3;
    }

    @Null
    public T removeLast() {
        if (this.tail == null) {
            return null;
        }
        Object t2 = this.tail.payload;
        --this.size;
        Item item = this.tail.prev;
        this.pool.free(this.tail);
        if (this.size == 0) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = item;
            this.tail.next = null;
        }
        return t2;
    }

    public void clear() {
        this.iter();
        Object var1_1 = null;
        while (true) {
            T t2 = this.next();
            var1_1 = t2;
            if (t2 == null) break;
            this.remove();
        }
    }

    static final class Item<T> {
        public T payload;
        public Item<T> next;
        public Item<T> prev;

        Item() {
        }
    }
}

