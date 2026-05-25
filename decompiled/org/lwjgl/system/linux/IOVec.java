/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct iovec")
public class IOVec
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int IOV_BASE;
    public static final int IOV_LEN;

    public IOVec(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOVec.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @Nullable
    @NativeType(value="void *")
    public ByteBuffer iov_base() {
        return IOVec.niov_base(this.address());
    }

    @NativeType(value="size_t")
    public long iov_len() {
        return IOVec.niov_len(this.address());
    }

    public IOVec iov_base(@Nullable @NativeType(value="void *") ByteBuffer byteBuffer) {
        IOVec.niov_base(this.address(), byteBuffer);
        return this;
    }

    public IOVec iov_len(@NativeType(value="size_t") long l2) {
        IOVec.niov_len(this.address(), l2);
        return this;
    }

    public IOVec set(@Nullable ByteBuffer byteBuffer, long l2) {
        this.iov_base(byteBuffer);
        this.iov_len(l2);
        return this;
    }

    public IOVec set(IOVec iOVec) {
        MemoryUtil.memCopy(iOVec.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOVec malloc() {
        return IOVec.wrap(IOVec.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOVec calloc() {
        return IOVec.wrap(IOVec.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOVec create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOVec.wrap(IOVec.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOVec create(long l2) {
        return IOVec.wrap(IOVec.class, l2);
    }

    @Nullable
    public static IOVec createSafe(long l2) {
        return l2 == 0L ? null : IOVec.wrap(IOVec.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOVec.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOVec.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOVec.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOVec.__create(n2, SIZEOF);
        return IOVec.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOVec.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOVec.wrap(Buffer.class, l2, n2);
    }

    public static IOVec malloc(MemoryStack memoryStack) {
        return IOVec.wrap(IOVec.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOVec calloc(MemoryStack memoryStack) {
        return IOVec.wrap(IOVec.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOVec.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOVec.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    @Nullable
    public static ByteBuffer niov_base(long l2) {
        return MemoryUtil.memByteBufferSafe(MemoryUtil.memGetAddress(l2 + (long)IOV_BASE), (int)IOVec.niov_len(l2));
    }

    public static long niov_len(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)IOV_LEN);
    }

    public static void niov_base(long l2, @Nullable ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)IOV_BASE, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void niov_len(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)IOV_LEN, l3);
    }

    static {
        Struct.Layout layout = IOVec.__struct(IOVec.__member(POINTER_SIZE), IOVec.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        IOV_BASE = layout.offsetof(0);
        IOV_LEN = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<IOVec, Buffer>
    implements NativeResource {
        private static final IOVec ELEMENT_FACTORY = IOVec.create(-1L);

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
        protected IOVec getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @Nullable
        @NativeType(value="void *")
        public ByteBuffer iov_base() {
            return IOVec.niov_base(this.address());
        }

        @NativeType(value="size_t")
        public long iov_len() {
            return IOVec.niov_len(this.address());
        }

        public Buffer iov_base(@Nullable @NativeType(value="void *") ByteBuffer byteBuffer) {
            IOVec.niov_base(this.address(), byteBuffer);
            return this;
        }

        public Buffer iov_len(@NativeType(value="size_t") long l2) {
            IOVec.niov_len(this.address(), l2);
            return this;
        }
    }
}

