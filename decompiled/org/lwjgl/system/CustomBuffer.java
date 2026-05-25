/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;

public abstract class CustomBuffer<SELF extends CustomBuffer<SELF>>
extends Pointer.Default {
    @Nullable
    protected ByteBuffer container;
    protected int mark;
    protected int position;
    protected int limit;
    protected int capacity;

    public CustomBuffer(long l2, @Nullable ByteBuffer byteBuffer, int n2, int n3, int n4, int n5) {
        super(l2);
        this.container = byteBuffer;
        this.mark = n2;
        this.position = n3;
        this.limit = n4;
        this.capacity = n5;
    }

    public abstract int sizeof();

    public long address0() {
        return this.address;
    }

    @Override
    public long address() {
        return this.address + Integer.toUnsignedLong(this.position) * (long)this.sizeof();
    }

    public long address(int n2) {
        return this.address + Integer.toUnsignedLong(n2) * (long)this.sizeof();
    }

    public void free() {
        MemoryUtil.nmemFree(this.address);
    }

    public int capacity() {
        return this.capacity;
    }

    public int position() {
        return this.position;
    }

    public SELF position(int n2) {
        if (n2 < 0 || this.limit < n2) {
            throw new IllegalArgumentException();
        }
        this.position = n2;
        if (n2 < this.mark) {
            this.mark = -1;
        }
        return this.self();
    }

    public int limit() {
        return this.limit;
    }

    public SELF limit(int n2) {
        if (n2 < 0 || this.capacity < n2) {
            throw new IllegalArgumentException();
        }
        this.limit = n2;
        if (n2 < this.position) {
            this.position = n2;
        }
        if (n2 < this.mark) {
            this.mark = -1;
        }
        return this.self();
    }

    public SELF mark() {
        this.mark = this.position;
        return this.self();
    }

    public SELF reset() {
        int n2 = this.mark;
        if (n2 < 0) {
            throw new InvalidMarkException();
        }
        this.position = n2;
        return this.self();
    }

    public SELF clear() {
        this.position = 0;
        this.limit = this.capacity;
        this.mark = -1;
        return this.self();
    }

    public SELF flip() {
        this.limit = this.position;
        this.position = 0;
        this.mark = -1;
        return this.self();
    }

    public SELF rewind() {
        this.position = 0;
        this.mark = -1;
        return this.self();
    }

    public int remaining() {
        return this.limit - this.position;
    }

    public boolean hasRemaining() {
        return this.position < this.limit;
    }

    public SELF slice() {
        CustomBuffer customBuffer;
        try {
            customBuffer = (CustomBuffer)UNSAFE.allocateInstance(this.getClass());
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(customBuffer, ADDRESS, this.address + Integer.toUnsignedLong(this.position) * (long)this.sizeof());
        UNSAFE.putInt(customBuffer, BUFFER_MARK, -1);
        UNSAFE.putInt(customBuffer, BUFFER_LIMIT, this.remaining());
        UNSAFE.putInt(customBuffer, BUFFER_CAPACITY, this.remaining());
        UNSAFE.putObject(customBuffer, BUFFER_CONTAINER, this.container);
        return (SELF)customBuffer;
    }

    public SELF slice(int n2, int n3) {
        CustomBuffer customBuffer;
        int n4 = this.position + n2;
        if (n2 < 0 || this.limit < n2) {
            throw new IllegalArgumentException();
        }
        if (n3 < 0 || this.capacity - n4 < n3) {
            throw new IllegalArgumentException();
        }
        try {
            customBuffer = (CustomBuffer)UNSAFE.allocateInstance(this.getClass());
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(customBuffer, ADDRESS, this.address + Integer.toUnsignedLong(n4) * (long)this.sizeof());
        UNSAFE.putInt(customBuffer, BUFFER_MARK, -1);
        UNSAFE.putInt(customBuffer, BUFFER_LIMIT, n3);
        UNSAFE.putInt(customBuffer, BUFFER_CAPACITY, n3);
        UNSAFE.putObject(customBuffer, BUFFER_CONTAINER, this.container);
        return (SELF)customBuffer;
    }

    public SELF duplicate() {
        CustomBuffer customBuffer;
        try {
            customBuffer = (CustomBuffer)UNSAFE.allocateInstance(this.getClass());
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(customBuffer, ADDRESS, this.address);
        UNSAFE.putInt(customBuffer, BUFFER_MARK, this.mark);
        UNSAFE.putInt(customBuffer, BUFFER_POSITION, this.position);
        UNSAFE.putInt(customBuffer, BUFFER_LIMIT, this.limit);
        UNSAFE.putInt(customBuffer, BUFFER_CAPACITY, this.capacity);
        UNSAFE.putObject(customBuffer, BUFFER_CONTAINER, this.container);
        return (SELF)customBuffer;
    }

    public SELF put(SELF SELF) {
        if (SELF == this) {
            throw new IllegalArgumentException();
        }
        int n2 = ((CustomBuffer)SELF).remaining();
        if (this.remaining() < n2) {
            throw new BufferOverflowException();
        }
        MemoryUtil.memCopy(((CustomBuffer)SELF).address(), this.address(), Integer.toUnsignedLong(n2) * (long)this.sizeof());
        this.position += n2;
        return this.self();
    }

    public SELF compact() {
        MemoryUtil.memCopy(this.address(), this.address, Integer.toUnsignedLong(this.remaining()) * (long)this.sizeof());
        this.position(this.remaining());
        this.limit(this.capacity());
        this.mark = -1;
        return this.self();
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[pos=" + this.position() + " lim=" + this.limit() + " cap=" + this.capacity() + "]";
    }

    protected abstract SELF self();

    protected final int nextGetIndex() {
        if (this.position < this.limit) {
            return this.position++;
        }
        throw new BufferUnderflowException();
    }

    protected final int nextPutIndex() {
        if (this.position < this.limit) {
            return this.position++;
        }
        throw new BufferOverflowException();
    }
}

