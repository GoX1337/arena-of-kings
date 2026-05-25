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

@NativeType(value="struct __kernel_timespec")
public class KernelTimespec
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TV_SEC;
    public static final int TV_NSEC;

    public KernelTimespec(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), KernelTimespec.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="int64_t")
    public long tv_sec() {
        return KernelTimespec.ntv_sec(this.address());
    }

    @NativeType(value="long long")
    public long tv_nsec() {
        return KernelTimespec.ntv_nsec(this.address());
    }

    public KernelTimespec tv_sec(@NativeType(value="int64_t") long l2) {
        KernelTimespec.ntv_sec(this.address(), l2);
        return this;
    }

    public KernelTimespec tv_nsec(@NativeType(value="long long") long l2) {
        KernelTimespec.ntv_nsec(this.address(), l2);
        return this;
    }

    public KernelTimespec set(long l2, long l3) {
        this.tv_sec(l2);
        this.tv_nsec(l3);
        return this;
    }

    public KernelTimespec set(KernelTimespec kernelTimespec) {
        MemoryUtil.memCopy(kernelTimespec.address(), this.address(), SIZEOF);
        return this;
    }

    public static KernelTimespec malloc() {
        return KernelTimespec.wrap(KernelTimespec.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static KernelTimespec calloc() {
        return KernelTimespec.wrap(KernelTimespec.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static KernelTimespec create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return KernelTimespec.wrap(KernelTimespec.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static KernelTimespec create(long l2) {
        return KernelTimespec.wrap(KernelTimespec.class, l2);
    }

    @Nullable
    public static KernelTimespec createSafe(long l2) {
        return l2 == 0L ? null : KernelTimespec.wrap(KernelTimespec.class, l2);
    }

    public static Buffer malloc(int n2) {
        return KernelTimespec.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(KernelTimespec.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return KernelTimespec.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = KernelTimespec.__create(n2, SIZEOF);
        return KernelTimespec.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return KernelTimespec.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : KernelTimespec.wrap(Buffer.class, l2, n2);
    }

    public static KernelTimespec malloc(MemoryStack memoryStack) {
        return KernelTimespec.wrap(KernelTimespec.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static KernelTimespec calloc(MemoryStack memoryStack) {
        return KernelTimespec.wrap(KernelTimespec.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return KernelTimespec.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return KernelTimespec.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static long ntv_sec(long l2) {
        return UNSAFE.getLong(null, l2 + (long)TV_SEC);
    }

    public static long ntv_nsec(long l2) {
        return UNSAFE.getLong(null, l2 + (long)TV_NSEC);
    }

    public static void ntv_sec(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)TV_SEC, l3);
    }

    public static void ntv_nsec(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)TV_NSEC, l3);
    }

    static {
        Struct.Layout layout = KernelTimespec.__struct(KernelTimespec.__member(8), KernelTimespec.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TV_SEC = layout.offsetof(0);
        TV_NSEC = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<KernelTimespec, Buffer>
    implements NativeResource {
        private static final KernelTimespec ELEMENT_FACTORY = KernelTimespec.create(-1L);

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
        protected KernelTimespec getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="int64_t")
        public long tv_sec() {
            return KernelTimespec.ntv_sec(this.address());
        }

        @NativeType(value="long long")
        public long tv_nsec() {
            return KernelTimespec.ntv_nsec(this.address());
        }

        public Buffer tv_sec(@NativeType(value="int64_t") long l2) {
            KernelTimespec.ntv_sec(this.address(), l2);
            return this;
        }

        public Buffer tv_nsec(@NativeType(value="long long") long l2) {
            KernelTimespec.ntv_nsec(this.address(), l2);
            return this;
        }
    }
}

