/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class VertexAttributes
implements Comparable<VertexAttributes>,
Iterable<VertexAttribute> {
    private final VertexAttribute[] attributes;
    public final int vertexSize;
    private long mask = -1L;
    private ReadonlyIterable<VertexAttribute> iterable;

    public VertexAttributes(VertexAttribute ... vertexAttributeArray) {
        if (vertexAttributeArray.length == 0) {
            throw new IllegalArgumentException("attributes must be >= 1");
        }
        VertexAttribute[] vertexAttributeArray2 = new VertexAttribute[vertexAttributeArray.length];
        for (int i2 = 0; i2 < vertexAttributeArray.length; ++i2) {
            vertexAttributeArray2[i2] = vertexAttributeArray[i2];
        }
        this.attributes = vertexAttributeArray2;
        this.vertexSize = this.calculateOffsets();
    }

    public int getOffset(int n2, int n3) {
        VertexAttribute vertexAttribute = this.findByUsage(n2);
        if (vertexAttribute == null) {
            return n3;
        }
        return vertexAttribute.offset / 4;
    }

    public int getOffset(int n2) {
        return this.getOffset(n2, 0);
    }

    public VertexAttribute findByUsage(int n2) {
        int n3 = this.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            if (this.get((int)i2).usage != n2) continue;
            return this.get(i2);
        }
        return null;
    }

    private int calculateOffsets() {
        int n2 = 0;
        for (int i2 = 0; i2 < this.attributes.length; ++i2) {
            VertexAttribute vertexAttribute = this.attributes[i2];
            vertexAttribute.offset = n2;
            n2 += vertexAttribute.getSizeInBytes();
        }
        return n2;
    }

    public int size() {
        return this.attributes.length;
    }

    public VertexAttribute get(int n2) {
        return this.attributes[n2];
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i2 = 0; i2 < this.attributes.length; ++i2) {
            stringBuilder.append("(");
            stringBuilder.append(this.attributes[i2].alias);
            stringBuilder.append(", ");
            stringBuilder.append(this.attributes[i2].usage);
            stringBuilder.append(", ");
            stringBuilder.append(this.attributes[i2].numComponents);
            stringBuilder.append(", ");
            stringBuilder.append(this.attributes[i2].offset);
            stringBuilder.append(")");
            stringBuilder.append("\n");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof VertexAttributes)) {
            return false;
        }
        VertexAttributes vertexAttributes = (VertexAttributes)object;
        if (this.attributes.length != vertexAttributes.attributes.length) {
            return false;
        }
        for (int i2 = 0; i2 < this.attributes.length; ++i2) {
            if (this.attributes[i2].equals(vertexAttributes.attributes[i2])) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        long l2 = 61 * this.attributes.length;
        for (int i2 = 0; i2 < this.attributes.length; ++i2) {
            l2 = l2 * 61L + (long)this.attributes[i2].hashCode();
        }
        return (int)(l2 ^ l2 >> 32);
    }

    public long getMask() {
        if (this.mask == -1L) {
            long l2 = 0L;
            for (int i2 = 0; i2 < this.attributes.length; ++i2) {
                l2 |= (long)this.attributes[i2].usage;
            }
            this.mask = l2;
        }
        return this.mask;
    }

    public long getMaskWithSizePacked() {
        return this.getMask() | (long)this.attributes.length << 32;
    }

    @Override
    public int compareTo(VertexAttributes vertexAttributes) {
        long l2;
        if (this.attributes.length != vertexAttributes.attributes.length) {
            return this.attributes.length - vertexAttributes.attributes.length;
        }
        long l3 = this.getMask();
        if (l3 != (l2 = vertexAttributes.getMask())) {
            return l3 < l2 ? -1 : 1;
        }
        for (int i2 = this.attributes.length - 1; i2 >= 0; --i2) {
            VertexAttribute vertexAttribute = this.attributes[i2];
            VertexAttribute vertexAttribute2 = vertexAttributes.attributes[i2];
            if (vertexAttribute.usage != vertexAttribute2.usage) {
                return vertexAttribute.usage - vertexAttribute2.usage;
            }
            if (vertexAttribute.unit != vertexAttribute2.unit) {
                return vertexAttribute.unit - vertexAttribute2.unit;
            }
            if (vertexAttribute.numComponents != vertexAttribute2.numComponents) {
                return vertexAttribute.numComponents - vertexAttribute2.numComponents;
            }
            if (vertexAttribute.normalized != vertexAttribute2.normalized) {
                return vertexAttribute.normalized ? 1 : -1;
            }
            if (vertexAttribute.type == vertexAttribute2.type) continue;
            return vertexAttribute.type - vertexAttribute2.type;
        }
        return 0;
    }

    @Override
    public Iterator<VertexAttribute> iterator() {
        if (this.iterable == null) {
            this.iterable = new ReadonlyIterable<VertexAttribute>(this.attributes);
        }
        return this.iterable.iterator();
    }

    static class ReadonlyIterable<T>
    implements Iterable<T> {
        private final T[] array;
        private ReadonlyIterator iterator1;
        private ReadonlyIterator iterator2;

        public ReadonlyIterable(T[] TArray) {
            this.array = TArray;
        }

        @Override
        public Iterator<T> iterator() {
            if (Collections.allocateIterators) {
                return new ReadonlyIterator<T>(this.array);
            }
            if (this.iterator1 == null) {
                this.iterator1 = new ReadonlyIterator<T>(this.array);
                this.iterator2 = new ReadonlyIterator<T>(this.array);
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

    static class ReadonlyIterator<T>
    implements Iterable<T>,
    Iterator<T> {
        private final T[] array;
        int index;
        boolean valid = true;

        public ReadonlyIterator(T[] TArray) {
            this.array = TArray;
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.index < this.array.length;
        }

        @Override
        public T next() {
            if (this.index >= this.array.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.array[this.index++];
        }

        @Override
        public void remove() {
            throw new GdxRuntimeException("Remove not allowed.");
        }

        public void reset() {
            this.index = 0;
        }

        @Override
        public Iterator<T> iterator() {
            return this;
        }
    }

    public static final class Usage {
        public static final int Position = 1;
        public static final int ColorUnpacked = 2;
        public static final int ColorPacked = 4;
        public static final int Normal = 8;
        public static final int TextureCoordinates = 16;
        public static final int Generic = 32;
        public static final int BoneWeight = 64;
        public static final int Tangent = 128;
        public static final int BiNormal = 256;
    }
}

