/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.Struct;

public abstract class StructBuffer<T extends Struct, SELF extends StructBuffer<T, SELF>>
extends CustomBuffer<SELF>
implements Iterable<T> {
    public StructBuffer(ByteBuffer byteBuffer, int n2) {
        super(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n2, n2);
    }

    public StructBuffer(long l2, @Nullable ByteBuffer byteBuffer, int n2, int n3, int n4, int n5) {
        super(l2, byteBuffer, n2, n3, n4, n5);
    }

    @Override
    public int sizeof() {
        return ((Struct)this.getElementFactory()).sizeof();
    }

    public T get() {
        return ((Struct)this.getElementFactory()).wrap(this.address, this.nextGetIndex(), this.container);
    }

    public SELF get(T t2) {
        int n2 = ((Struct)this.getElementFactory()).sizeof();
        MemoryUtil.memCopy(this.address + Integer.toUnsignedLong(this.nextGetIndex()) * (long)n2, ((Pointer.Default)t2).address(), n2);
        return (SELF)((StructBuffer)this.self());
    }

    @Override
    public SELF put(T t2) {
        int n2 = ((Struct)this.getElementFactory()).sizeof();
        MemoryUtil.memCopy(((Pointer.Default)t2).address(), this.address + Integer.toUnsignedLong(this.nextPutIndex()) * (long)n2, n2);
        return (SELF)((StructBuffer)this.self());
    }

    public T get(int n2) {
        return ((Struct)this.getElementFactory()).wrap(this.address, StructBuffer.check(n2, this.limit), this.container);
    }

    public SELF get(int n2, T t2) {
        int n3 = ((Struct)this.getElementFactory()).sizeof();
        MemoryUtil.memCopy(this.address + Checks.check(n2, this.limit) * (long)n3, ((Pointer.Default)t2).address(), n3);
        return (SELF)((StructBuffer)this.self());
    }

    public SELF put(int n2, T t2) {
        int n3 = ((Struct)this.getElementFactory()).sizeof();
        MemoryUtil.memCopy(((Pointer.Default)t2).address(), this.address + Checks.check(n2, this.limit) * (long)n3, n3);
        return (SELF)((StructBuffer)this.self());
    }

    public SELF apply(Consumer<T> consumer) {
        consumer.accept(this.get());
        return (SELF)((StructBuffer)this.self());
    }

    public SELF apply(int n2, Consumer<T> consumer) {
        consumer.accept(this.get(n2));
        return (SELF)((StructBuffer)this.self());
    }

    @Override
    public Iterator<T> iterator() {
        return new StructIterator(this.address, this.container, this.getElementFactory(), this.position, this.limit);
    }

    @Override
    public void forEach(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer);
        T t2 = this.getElementFactory();
        int n2 = this.limit;
        for (int i2 = this.position; i2 < n2; ++i2) {
            consumer.accept(((Struct)t2).wrap(this.address, i2, this.container));
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return new StructSpliterator(this.address, this.container, this.getElementFactory(), this.position, this.limit);
    }

    public Stream<T> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    public Stream<T> parallelStream() {
        return StreamSupport.stream(this.spliterator(), true);
    }

    protected abstract T getElementFactory();

    private static int check(int n2, int n3) {
        if (Checks.CHECKS && (n2 < 0 || n3 <= n2)) {
            throw new IndexOutOfBoundsException();
        }
        return n2;
    }

    static class StructSpliterator<T extends Struct, SELF extends StructBuffer<T, SELF>>
    implements Spliterator<T> {
        private long address;
        @Nullable
        private ByteBuffer container;
        private T factory;
        private int index;
        private int fence;

        StructSpliterator(long l2, @Nullable ByteBuffer byteBuffer, T t2, int n2, int n3) {
            this.address = l2;
            this.container = byteBuffer;
            this.factory = t2;
            this.index = n2;
            this.fence = n3;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> consumer) {
            Objects.requireNonNull(consumer);
            if (this.index < this.fence) {
                consumer.accept(((Struct)this.factory).wrap(this.address, this.index++, this.container));
                return true;
            }
            return false;
        }

        @Override
        @Nullable
        public Spliterator<T> trySplit() {
            StructSpliterator<T, SELF> structSpliterator;
            int n2 = this.index;
            int n3 = n2 + this.fence >>> 1;
            if (n2 < n3) {
                this.index = n3;
                StructSpliterator<T, SELF> structSpliterator2 = new StructSpliterator<T, SELF>(this.address, this.container, this.factory, n2, this.index);
                structSpliterator = structSpliterator2;
            } else {
                structSpliterator = null;
            }
            return structSpliterator;
        }

        @Override
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override
        public int characteristics() {
            return 17744;
        }

        @Override
        public void forEachRemaining(Consumer<? super T> consumer) {
            int n2;
            Objects.requireNonNull(consumer);
            try {
                for (n2 = this.index; n2 < this.fence; ++n2) {
                    consumer.accept(((Struct)this.factory).wrap(this.address, n2, this.container));
                }
            }
            finally {
                this.index = n2;
            }
        }

        @Override
        public Comparator<? super T> getComparator() {
            throw new IllegalStateException();
        }
    }

    static class StructIterator<T extends Struct, SELF extends StructBuffer<T, SELF>>
    implements Iterator<T> {
        private long address;
        @Nullable
        private ByteBuffer container;
        private T factory;
        private int index;
        private int fence;

        StructIterator(long l2, @Nullable ByteBuffer byteBuffer, T t2, int n2, int n3) {
            this.address = l2;
            this.container = byteBuffer;
            this.factory = t2;
            this.index = n2;
            this.fence = n3;
        }

        @Override
        public boolean hasNext() {
            return this.index < this.fence;
        }

        @Override
        public T next() {
            if (Checks.CHECKS && this.fence <= this.index) {
                throw new NoSuchElementException();
            }
            return ((Struct)this.factory).wrap(this.address, this.index++, this.container);
        }

        @Override
        public void forEachRemaining(Consumer<? super T> consumer) {
            int n2;
            Objects.requireNonNull(consumer);
            try {
                for (n2 = this.index; n2 < this.fence; ++n2) {
                    consumer.accept(((Struct)this.factory).wrap(this.address, n2, this.container));
                }
            }
            finally {
                this.index = n2;
            }
        }
    }
}

