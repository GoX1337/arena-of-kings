/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.CheckIntrinsics;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;

public class CLongBuffer
extends CustomBuffer<CLongBuffer>
implements Comparable<CLongBuffer> {
    protected CLongBuffer(long l2, @Nullable ByteBuffer byteBuffer, int n2, int n3, int n4, int n5) {
        super(l2, byteBuffer, n2, n3, n4, n5);
    }

    public static CLongBuffer allocateDirect(int n2) {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(n2, CLONG_SHIFT));
        return CLongBuffer.wrap(CLongBuffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static CLongBuffer create(long l2, int n2) {
        return CLongBuffer.wrap(CLongBuffer.class, l2, n2);
    }

    public static CLongBuffer create(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.remaining() >> CLONG_SHIFT;
        return CLongBuffer.wrap(CLongBuffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    @Override
    protected CLongBuffer self() {
        return this;
    }

    @Override
    public int sizeof() {
        return CLONG_SIZE;
    }

    public long get() {
        return MemoryUtil.memGetCLong(this.address + Integer.toUnsignedLong(this.nextGetIndex()) * (long)CLONG_SIZE);
    }

    public static long get(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < CLONG_SIZE) {
            throw new BufferUnderflowException();
        }
        try {
            long l2 = MemoryUtil.memGetCLong(MemoryUtil.memAddress(byteBuffer));
            return l2;
        }
        finally {
            byteBuffer.position(byteBuffer.position() + CLONG_SIZE);
        }
    }

    @Override
    public CLongBuffer put(long l2) {
        MemoryUtil.memPutCLong(this.address + Integer.toUnsignedLong(this.nextPutIndex()) * (long)CLONG_SIZE, l2);
        return this;
    }

    public static void put(ByteBuffer byteBuffer, long l2) {
        if (byteBuffer.remaining() < CLONG_SIZE) {
            throw new BufferOverflowException();
        }
        try {
            MemoryUtil.memPutCLong(MemoryUtil.memAddress(byteBuffer), l2);
        }
        finally {
            byteBuffer.position(byteBuffer.position() + CLONG_SIZE);
        }
    }

    public long get(int n2) {
        return MemoryUtil.memGetCLong(this.address + Checks.check(n2, this.limit) * (long)CLONG_SIZE);
    }

    public static long get(ByteBuffer byteBuffer, int n2) {
        CheckIntrinsics.checkFromIndexSize(n2, CLONG_SIZE, byteBuffer.limit());
        return MemoryUtil.memGetCLong(MemoryUtil.memAddress0(byteBuffer) + (long)n2);
    }

    public CLongBuffer put(int n2, long l2) {
        MemoryUtil.memPutCLong(this.address + Checks.check(n2, this.limit) * (long)CLONG_SIZE, l2);
        return this;
    }

    public static void put(ByteBuffer byteBuffer, int n2, long l2) {
        CheckIntrinsics.checkFromIndexSize(n2, CLONG_SIZE, byteBuffer.limit());
        MemoryUtil.memPutCLong(MemoryUtil.memAddress0(byteBuffer) + (long)n2, l2);
    }

    public CLongBuffer get(long[] lArray) {
        return this.get(lArray, 0, lArray.length);
    }

    public CLongBuffer get(long[] lArray, int n2, int n3) {
        if (CLONG_SIZE == 8) {
            MemoryUtil.memLongBuffer(this.address(), this.remaining()).get(lArray, n2, n3);
            this.position(this.position() + n3);
        } else {
            this.get32(lArray, n2, n3);
        }
        return this;
    }

    private void get32(long[] lArray, int n2, int n3) {
        CheckIntrinsics.checkFromIndexSize(n2, n3, lArray.length);
        if (this.remaining() < n3) {
            throw new BufferUnderflowException();
        }
        int n4 = n2 + n3;
        for (int i2 = n2; i2 < n4; ++i2) {
            lArray[i2] = this.get();
        }
    }

    @Override
    public CLongBuffer put(long[] lArray) {
        return this.put(lArray, 0, lArray.length);
    }

    public CLongBuffer put(long[] lArray, int n2, int n3) {
        if (CLONG_SIZE == 8) {
            MemoryUtil.memLongBuffer(this.address(), this.remaining()).put(lArray, n2, n3);
            this.position(this.position() + n3);
        } else {
            this.put32(lArray, n2, n3);
        }
        return this;
    }

    private void put32(long[] lArray, int n2, int n3) {
        CheckIntrinsics.checkFromIndexSize(n2, n3, lArray.length);
        if (this.remaining() < n3) {
            throw new BufferOverflowException();
        }
        int n4 = n2 + n3;
        for (int i2 = n2; i2 < n4; ++i2) {
            this.put(lArray[i2]);
        }
    }

    @Override
    public int hashCode() {
        int n2 = 1;
        int n3 = this.position();
        for (int i2 = this.limit() - 1; i2 >= n3; --i2) {
            n2 = 31 * n2 + (int)this.get(i2);
        }
        return n2;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CLongBuffer)) {
            return false;
        }
        CLongBuffer cLongBuffer = (CLongBuffer)object;
        if (this.remaining() != cLongBuffer.remaining()) {
            return false;
        }
        int n2 = this.position();
        int n3 = this.limit() - 1;
        int n4 = cLongBuffer.limit() - 1;
        while (n3 >= n2) {
            long l2;
            long l3 = this.get(n3);
            if (l3 != (l2 = cLongBuffer.get(n4))) {
                return false;
            }
            --n3;
            --n4;
        }
        return true;
    }

    @Override
    public int compareTo(CLongBuffer cLongBuffer) {
        int n2 = this.position() + Math.min(this.remaining(), cLongBuffer.remaining());
        int n3 = this.position();
        int n4 = cLongBuffer.position();
        while (n3 < n2) {
            long l2;
            long l3 = this.get(n3);
            if (l3 != (l2 = cLongBuffer.get(n4))) {
                if (l3 < l2) {
                    return -1;
                }
                return 1;
            }
            ++n3;
            ++n4;
        }
        return this.remaining() - cLongBuffer.remaining();
    }
}

