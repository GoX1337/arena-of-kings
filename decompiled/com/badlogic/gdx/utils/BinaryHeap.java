/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.StringBuilder;
import java.util.Arrays;

public class BinaryHeap<T extends Node> {
    public int size;
    private Node[] nodes;
    private final boolean isMaxHeap;

    public BinaryHeap() {
        this(16, false);
    }

    public BinaryHeap(int n2, boolean bl2) {
        this.isMaxHeap = bl2;
        this.nodes = new Node[n2];
    }

    public T add(T t2) {
        if (this.size == this.nodes.length) {
            Node[] nodeArray = new Node[this.size << 1];
            System.arraycopy(this.nodes, 0, nodeArray, 0, this.size);
            this.nodes = nodeArray;
        }
        ((Node)t2).index = this.size;
        this.nodes[this.size] = t2;
        this.up(this.size++);
        return t2;
    }

    public T add(T t2, float f2) {
        ((Node)t2).value = f2;
        return this.add(t2);
    }

    public boolean contains(T t2, boolean bl2) {
        if (t2 == null) {
            throw new IllegalArgumentException("node cannot be null.");
        }
        if (bl2) {
            for (Node node : this.nodes) {
                if (node != t2) continue;
                return true;
            }
        } else {
            for (Node node : this.nodes) {
                if (!node.equals(t2)) continue;
                return true;
            }
        }
        return false;
    }

    public T peek() {
        if (this.size == 0) {
            throw new IllegalStateException("The heap is empty.");
        }
        return (T)this.nodes[0];
    }

    public T pop() {
        Node node = this.nodes[0];
        if (--this.size > 0) {
            this.nodes[0] = this.nodes[this.size];
            this.nodes[this.size] = null;
            this.down(0);
        } else {
            this.nodes[0] = null;
        }
        return (T)node;
    }

    public T remove(T t2) {
        if (--this.size > 0) {
            Node node = this.nodes[this.size];
            this.nodes[this.size] = null;
            this.nodes[((Node)t2).index] = node;
            if (node.value < ((Node)t2).value ^ this.isMaxHeap) {
                this.up(((Node)t2).index);
            } else {
                this.down(((Node)t2).index);
            }
        } else {
            this.nodes[0] = null;
        }
        return t2;
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        Arrays.fill(this.nodes, 0, this.size, null);
        this.size = 0;
    }

    public void setValue(T t2, float f2) {
        float f3 = ((Node)t2).value;
        ((Node)t2).value = f2;
        if (f2 < f3 ^ this.isMaxHeap) {
            this.up(((Node)t2).index);
        } else {
            this.down(((Node)t2).index);
        }
    }

    private void up(int n2) {
        Node[] nodeArray = this.nodes;
        Node node = nodeArray[n2];
        float f2 = node.value;
        while (n2 > 0) {
            int n3 = n2 - 1 >> 1;
            Node node2 = nodeArray[n3];
            if (!(f2 < node2.value ^ this.isMaxHeap)) break;
            nodeArray[n2] = node2;
            node2.index = n2;
            n2 = n3;
        }
        nodeArray[n2] = node;
        node.index = n2;
    }

    private void down(int n2) {
        int n3;
        Node[] nodeArray = this.nodes;
        int n4 = this.size;
        Node node = nodeArray[n2];
        float f2 = node.value;
        while ((n3 = 1 + (n2 << 1)) < n4) {
            float f3;
            Node node2;
            int n5 = n3 + 1;
            Node node3 = nodeArray[n3];
            float f4 = node3.value;
            if (n5 >= n4) {
                node2 = null;
                f3 = this.isMaxHeap ? -3.4028235E38f : Float.MAX_VALUE;
            } else {
                node2 = nodeArray[n5];
                f3 = node2.value;
            }
            if (f4 < f3 ^ this.isMaxHeap) {
                if (f4 == f2 || f4 > f2 ^ this.isMaxHeap) break;
                nodeArray[n2] = node3;
                node3.index = n2;
                n2 = n3;
                continue;
            }
            if (f3 == f2 || f3 > f2 ^ this.isMaxHeap) break;
            nodeArray[n2] = node2;
            if (node2 != null) {
                node2.index = n2;
            }
            n2 = n5;
        }
        nodeArray[n2] = node;
        node.index = n2;
    }

    public boolean equals(Object object) {
        if (!(object instanceof BinaryHeap)) {
            return false;
        }
        BinaryHeap binaryHeap = (BinaryHeap)object;
        if (binaryHeap.size != this.size) {
            return false;
        }
        Node[] nodeArray = this.nodes;
        Node[] nodeArray2 = binaryHeap.nodes;
        int n2 = this.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (nodeArray[i2].value == nodeArray2[i2].value) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        int n2 = 1;
        Node[] nodeArray = this.nodes;
        int n3 = this.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 = n2 * 31 + Float.floatToIntBits(nodeArray[i2].value);
        }
        return n2;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        Node[] nodeArray = this.nodes;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(nodeArray[0].value);
        for (int i2 = 1; i2 < this.size; ++i2) {
            stringBuilder.append(", ");
            stringBuilder.append(nodeArray[i2].value);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static class Node {
        float value;
        int index;

        public Node(float f2) {
            this.value = f2;
        }

        public float getValue() {
            return this.value;
        }

        public String toString() {
            return Float.toString(this.value);
        }
    }
}

