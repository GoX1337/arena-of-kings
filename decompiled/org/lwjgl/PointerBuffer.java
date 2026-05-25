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
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.CheckIntrinsics;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;

public class PointerBuffer
extends CustomBuffer<PointerBuffer>
implements Comparable<PointerBuffer> {
    protected PointerBuffer(long l2, @Nullable ByteBuffer byteBuffer, int n2, int n3, int n4, int n5) {
        super(l2, byteBuffer, n2, n3, n4, n5);
    }

    public static PointerBuffer allocateDirect(int n2) {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(n2, POINTER_SHIFT));
        return PointerBuffer.wrap(PointerBuffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static PointerBuffer create(long l2, int n2) {
        return PointerBuffer.wrap(PointerBuffer.class, l2, n2);
    }

    public static PointerBuffer create(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.remaining() >> POINTER_SHIFT;
        return PointerBuffer.wrap(PointerBuffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    @Override
    protected PointerBuffer self() {
        return this;
    }

    @Override
    public int sizeof() {
        return POINTER_SIZE;
    }

    public long get() {
        return MemoryUtil.memGetAddress(this.address + Integer.toUnsignedLong(this.nextGetIndex()) * (long)POINTER_SIZE);
    }

    public static long get(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < POINTER_SIZE) {
            throw new BufferUnderflowException();
        }
        try {
            long l2 = MemoryUtil.memGetAddress(MemoryUtil.memAddress(byteBuffer));
            return l2;
        }
        finally {
            byteBuffer.position(byteBuffer.position() + POINTER_SIZE);
        }
    }

    @Override
    public PointerBuffer put(long l2) {
        MemoryUtil.memPutAddress(this.address + Integer.toUnsignedLong(this.nextPutIndex()) * (long)POINTER_SIZE, l2);
        return this;
    }

    public static void put(ByteBuffer byteBuffer, long l2) {
        if (byteBuffer.remaining() < POINTER_SIZE) {
            throw new BufferOverflowException();
        }
        try {
            MemoryUtil.memPutAddress(MemoryUtil.memAddress(byteBuffer), l2);
        }
        finally {
            byteBuffer.position(byteBuffer.position() + POINTER_SIZE);
        }
    }

    public long get(int n2) {
        return MemoryUtil.memGetAddress(this.address + Checks.check(n2, this.limit) * (long)POINTER_SIZE);
    }

    public static long get(ByteBuffer byteBuffer, int n2) {
        CheckIntrinsics.checkFromIndexSize(n2, POINTER_SIZE, byteBuffer.limit());
        return MemoryUtil.memGetAddress(MemoryUtil.memAddress0(byteBuffer) + (long)n2);
    }

    public PointerBuffer put(int n2, long l2) {
        MemoryUtil.memPutAddress(this.address + Checks.check(n2, this.limit) * (long)POINTER_SIZE, l2);
        return this;
    }

    public static void put(ByteBuffer byteBuffer, int n2, long l2) {
        CheckIntrinsics.checkFromIndexSize(n2, POINTER_SIZE, byteBuffer.limit());
        MemoryUtil.memPutAddress(MemoryUtil.memAddress0(byteBuffer) + (long)n2, l2);
    }

    @Override
    public PointerBuffer put(Pointer pointer) {
        this.put(pointer.address());
        return this;
    }

    public PointerBuffer put(int n2, Pointer pointer) {
        this.put(n2, pointer.address());
        return this;
    }

    @Override
    public PointerBuffer put(ByteBuffer byteBuffer) {
        this.put(MemoryUtil.memAddress(byteBuffer));
        return this;
    }

    @Override
    public PointerBuffer put(ShortBuffer shortBuffer) {
        this.put(MemoryUtil.memAddress(shortBuffer));
        return this;
    }

    @Override
    public PointerBuffer put(IntBuffer intBuffer) {
        this.put(MemoryUtil.memAddress(intBuffer));
        return this;
    }

    @Override
    public PointerBuffer put(LongBuffer longBuffer) {
        this.put(MemoryUtil.memAddress(longBuffer));
        return this;
    }

    @Override
    public PointerBuffer put(FloatBuffer floatBuffer) {
        this.put(MemoryUtil.memAddress(floatBuffer));
        return this;
    }

    @Override
    public PointerBuffer put(DoubleBuffer doubleBuffer) {
        this.put(MemoryUtil.memAddress(doubleBuffer));
        return this;
    }

    public PointerBuffer putAddressOf(CustomBuffer<?> customBuffer) {
        this.put(MemoryUtil.memAddress(customBuffer));
        return this;
    }

    public PointerBuffer put(int n2, ByteBuffer byteBuffer) {
        this.put(n2, MemoryUtil.memAddress(byteBuffer));
        return this;
    }

    public PointerBuffer put(int n2, ShortBuffer shortBuffer) {
        this.put(n2, MemoryUtil.memAddress(shortBuffer));
        return this;
    }

    public PointerBuffer put(int n2, IntBuffer intBuffer) {
        this.put(n2, MemoryUtil.memAddress(intBuffer));
        return this;
    }

    public PointerBuffer put(int n2, LongBuffer longBuffer) {
        this.put(n2, MemoryUtil.memAddress(longBuffer));
        return this;
    }

    public PointerBuffer put(int n2, FloatBuffer floatBuffer) {
        this.put(n2, MemoryUtil.memAddress(floatBuffer));
        return this;
    }

    public PointerBuffer put(int n2, DoubleBuffer doubleBuffer) {
        this.put(n2, MemoryUtil.memAddress(doubleBuffer));
        return this;
    }

    public PointerBuffer putAddressOf(int n2, CustomBuffer<?> customBuffer) {
        this.put(n2, MemoryUtil.memAddress(customBuffer));
        return this;
    }

    public ByteBuffer getByteBuffer(int n2) {
        return MemoryUtil.memByteBuffer(this.get(), n2);
    }

    public ShortBuffer getShortBuffer(int n2) {
        return MemoryUtil.memShortBuffer(this.get(), n2);
    }

    public IntBuffer getIntBuffer(int n2) {
        return MemoryUtil.memIntBuffer(this.get(), n2);
    }

    public LongBuffer getLongBuffer(int n2) {
        return MemoryUtil.memLongBuffer(this.get(), n2);
    }

    public FloatBuffer getFloatBuffer(int n2) {
        return MemoryUtil.memFloatBuffer(this.get(), n2);
    }

    public DoubleBuffer getDoubleBuffer(int n2) {
        return MemoryUtil.memDoubleBuffer(this.get(), n2);
    }

    public PointerBuffer getPointerBuffer(int n2) {
        return MemoryUtil.memPointerBuffer(this.get(), n2);
    }

    public String getStringASCII() {
        return MemoryUtil.memASCII(this.get());
    }

    public String getStringUTF8() {
        return MemoryUtil.memUTF8(this.get());
    }

    public String getStringUTF16() {
        return MemoryUtil.memUTF16(this.get());
    }

    public ByteBuffer getByteBuffer(int n2, int n3) {
        return MemoryUtil.memByteBuffer(this.get(n2), n3);
    }

    public ShortBuffer getShortBuffer(int n2, int n3) {
        return MemoryUtil.memShortBuffer(this.get(n2), n3);
    }

    public IntBuffer getIntBuffer(int n2, int n3) {
        return MemoryUtil.memIntBuffer(this.get(n2), n3);
    }

    public LongBuffer getLongBuffer(int n2, int n3) {
        return MemoryUtil.memLongBuffer(this.get(n2), n3);
    }

    public FloatBuffer getFloatBuffer(int n2, int n3) {
        return MemoryUtil.memFloatBuffer(this.get(n2), n3);
    }

    public DoubleBuffer getDoubleBuffer(int n2, int n3) {
        return MemoryUtil.memDoubleBuffer(this.get(n2), n3);
    }

    public PointerBuffer getPointerBuffer(int n2, int n3) {
        return MemoryUtil.memPointerBuffer(this.get(n2), n3);
    }

    public String getStringASCII(int n2) {
        return MemoryUtil.memASCII(this.get(n2));
    }

    public String getStringUTF8(int n2) {
        return MemoryUtil.memUTF8(this.get(n2));
    }

    public String getStringUTF16(int n2) {
        return MemoryUtil.memUTF16(this.get(n2));
    }

    public PointerBuffer get(long[] lArray) {
        return this.get(lArray, 0, lArray.length);
    }

    public PointerBuffer get(long[] lArray, int n2, int n3) {
        if (BITS64) {
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
    public PointerBuffer put(long[] lArray) {
        return this.put(lArray, 0, lArray.length);
    }

    public PointerBuffer put(long[] lArray, int n2, int n3) {
        if (BITS64) {
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
        if (!(object instanceof PointerBuffer)) {
            return false;
        }
        PointerBuffer pointerBuffer = (PointerBuffer)object;
        if (this.remaining() != pointerBuffer.remaining()) {
            return false;
        }
        int n2 = this.position();
        int n3 = this.limit() - 1;
        int n4 = pointerBuffer.limit() - 1;
        while (n3 >= n2) {
            long l2;
            long l3 = this.get(n3);
            if (l3 != (l2 = pointerBuffer.get(n4))) {
                return false;
            }
            --n3;
            --n4;
        }
        return true;
    }

    @Override
    public int compareTo(PointerBuffer pointerBuffer) {
        int n2 = this.position() + Math.min(this.remaining(), pointerBuffer.remaining());
        int n3 = this.position();
        int n4 = pointerBuffer.position();
        while (n3 < n2) {
            long l2;
            long l3 = this.get(n3);
            if (l3 != (l2 = pointerBuffer.get(n4))) {
                if (l3 < l2) {
                    return -1;
                }
                return 1;
            }
            ++n3;
            ++n4;
        }
        return this.remaining() - pointerBuffer.remaining();
    }
}

