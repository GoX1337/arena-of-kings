/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_cqe")
public class IOURingCQE
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int USER_DATA;
    public static final int RES;
    public static final int FLAGS;

    public IOURingCQE(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingCQE.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long user_data() {
        return IOURingCQE.nuser_data(this.address());
    }

    @NativeType(value="__s32")
    public int res() {
        return IOURingCQE.nres(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingCQE.nflags(this.address());
    }

    public IOURingCQE user_data(@NativeType(value="__u64") long l2) {
        IOURingCQE.nuser_data(this.address(), l2);
        return this;
    }

    public IOURingCQE res(@NativeType(value="__s32") int n2) {
        IOURingCQE.nres(this.address(), n2);
        return this;
    }

    public IOURingCQE flags(@NativeType(value="__u32") int n2) {
        IOURingCQE.nflags(this.address(), n2);
        return this;
    }

    public IOURingCQE set(long l2, int n2, int n3) {
        this.user_data(l2);
        this.res(n2);
        this.flags(n3);
        return this;
    }

    public IOURingCQE set(IOURingCQE iOURingCQE) {
        MemoryUtil.memCopy(iOURingCQE.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingCQE malloc() {
        return IOURingCQE.wrap(IOURingCQE.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURingCQE calloc() {
        return IOURingCQE.wrap(IOURingCQE.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURingCQE create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURingCQE.wrap(IOURingCQE.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingCQE create(long l2) {
        return IOURingCQE.wrap(IOURingCQE.class, l2);
    }

    @Nullable
    public static IOURingCQE createSafe(long l2) {
        return l2 == 0L ? null : IOURingCQE.wrap(IOURingCQE.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURingCQE.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURingCQE.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURingCQE.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURingCQE.__create(n2, SIZEOF);
        return IOURingCQE.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURingCQE.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURingCQE.wrap(Buffer.class, l2, n2);
    }

    public static IOURingCQE malloc(MemoryStack memoryStack) {
        return IOURingCQE.wrap(IOURingCQE.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURingCQE calloc(MemoryStack memoryStack) {
        return IOURingCQE.wrap(IOURingCQE.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURingCQE.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURingCQE.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static long nuser_data(long l2) {
        return UNSAFE.getLong(null, l2 + (long)USER_DATA);
    }

    public static int nres(long l2) {
        return UNSAFE.getInt(null, l2 + (long)RES);
    }

    public static int nflags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FLAGS);
    }

    public static void nuser_data(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)USER_DATA, l3);
    }

    public static void nres(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RES, n2);
    }

    public static void nflags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FLAGS, n2);
    }

    static {
        Struct.Layout layout = IOURingCQE.__struct(IOURingCQE.__member(8), IOURingCQE.__member(4), IOURingCQE.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        USER_DATA = layout.offsetof(0);
        RES = layout.offsetof(1);
        FLAGS = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<IOURingCQE, Buffer>
    implements NativeResource {
        private static final IOURingCQE ELEMENT_FACTORY = IOURingCQE.create(-1L);

        public Buffer(ByteBuffer byteBuffer) {
            super(byteBuffer, byteBuffer.remaining() / SIZEOF);
        }

        public Buffer(long l2, int n2) {
            super(l2, null, -1, 0, n2, n2);
        }

        Buffer(long l2, @Nullable ByteBuffer byteBuffer, int n2, int n3, int n4, int n5) {
            super(l2, byteBuffer, n2, n3, n4, n5);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected IOURingCQE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long user_data() {
            return IOURingCQE.nuser_data(this.address());
        }

        @NativeType(value="__s32")
        public int res() {
            return IOURingCQE.nres(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingCQE.nflags(this.address());
        }

        public Buffer user_data(@NativeType(value="__u64") long l2) {
            IOURingCQE.nuser_data(this.address(), l2);
            return this;
        }

        public Buffer res(@NativeType(value="__s32") int n2) {
            IOURingCQE.nres(this.address(), n2);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int n2) {
            IOURingCQE.nflags(this.address(), n2);
            return this;
        }
    }
}

