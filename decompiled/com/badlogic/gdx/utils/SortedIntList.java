/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;

public class SortedIntList<E>
implements Iterable<Node<E>> {
    private NodePool<E> nodePool = new NodePool();
    private transient Iterator iterator;
    int size = 0;
    Node<E> first;

    @Null
    public E insert(int n2, E e2) {
        if (this.first != null) {
            Node<E> node = this.first;
            while (node.n != null && node.n.index <= n2) {
                node = node.n;
            }
            if (n2 > node.index) {
                node.n = this.nodePool.obtain(node, node.n, e2, n2);
                if (node.n.n != null) {
                    node.n.n.p = node.n;
                }
                ++this.size;
            } else if (n2 < node.index) {
                Node<E> node2 = this.nodePool.obtain(null, this.first, e2, n2);
                this.first.p = node2;
                this.first = node2;
                ++this.size;
            } else {
                node.value = e2;
            }
        } else {
            this.first = this.nodePool.obtain(null, null, e2, n2);
            ++this.size;
        }
        return null;
    }

    public E get(int n2) {
        E e2 = null;
        if (this.first != null) {
            Node<E> node = this.first;
            while (node.n != null && node.index < n2) {
                node = node.n;
            }
            if (node.index == n2) {
                e2 = node.value;
            }
        }
        return e2;
    }

    public void clear() {
        while (this.first != null) {
            this.nodePool.free(this.first);
            this.first = this.first.n;
        }
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public java.util.Iterator<Node<E>> iterator() {
        if (Collections.allocateIterators) {
            return new Iterator();
        }
        if (this.iterator == null) {
            this.iterator = new Iterator();
        }
        return this.iterator.reset();
    }

    static class NodePool<E>
    extends Pool<Node<E>> {
        NodePool() {
        }

        @Override
        protected Node<E> newObject() {
            return new Node();
        }

        public Node<E> obtain(Node<E> node, Node<E> node2, E e2, int n2) {
            Node node3 = (Node)super.obtain();
            node3.p = node;
            node3.n = node2;
            node3.value = e2;
            node3.index = n2;
            return node3;
        }
    }

    public static class Node<E> {
        protected Node<E> p;
        protected Node<E> n;
        public E value;
        public int index;
    }

    public class Iterator
    implements java.util.Iterator<Node<E>> {
        private Node<E> position;
        private Node<E> previousPosition;

        @Override
        public boolean hasNext() {
            return this.position != null;
        }

        @Override
        public Node<E> next() {
            this.previousPosition = this.position;
            this.position = this.position.n;
            return this.previousPosition;
        }

        @Override
        public void remove() {
            if (this.previousPosition != null) {
                if (this.previousPosition == SortedIntList.this.first) {
                    SortedIntList.this.first = this.position;
                } else {
                    this.previousPosition.p.n = this.position;
                    if (this.position != null) {
                        this.position.p = this.previousPosition.p;
                    }
                }
                --SortedIntList.this.size;
            }
        }

        public Iterator reset() {
            this.position = SortedIntList.this.first;
            this.previousPosition = null;
            return this;
        }
    }
}

