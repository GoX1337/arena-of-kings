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

@NativeType(value="struct io_cqring_offsets")
public class IOCQRingOffsets
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int HEAD;
    public static final int TAIL;
    public static final int RING_MASK;
    public static final int RING_ENTRIES;
    public static final int OVERFLOW;
    public static final int CQES;
    public static final int FLAGS;
    public static final int RESV1;
    public static final int RESV2;

    public IOCQRingOffsets(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOCQRingOffsets.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int head() {
        return IOCQRingOffsets.nhead(this.address());
    }

    @NativeType(value="__u32")
    public int tail() {
        return IOCQRingOffsets.ntail(this.address());
    }

    @NativeType(value="__u32")
    public int ring_mask() {
        return IOCQRingOffsets.nring_mask(this.address());
    }

    @NativeType(value="__u32")
    public int ring_entries() {
        return IOCQRingOffsets.nring_entries(this.address());
    }

    @NativeType(value="__u32")
    public int overflow() {
        return IOCQRingOffsets.noverflow(this.address());
    }

    @NativeType(value="__u32")
    public int cqes() {
        return IOCQRingOffsets.ncqes(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOCQRingOffsets.nflags(this.address());
    }

    public IOCQRingOffsets head(@NativeType(value="__u32") int n2) {
        IOCQRingOffsets.nhead(this.address(), n2);
        return this;
    }

    public IOCQRingOffsets tail(@NativeType(value="__u32") int n2) {
        IOCQRingOffsets.ntail(this.address(), n2);
        return this;
    }

    public IOCQRingOffsets ring_mask(@NativeType(value="__u32") int n2) {
        IOCQRingOffsets.nring_mask(this.address(), n2);
        return this;
    }

    public IOCQRingOffsets ring_entries(@NativeType(value="__u32") int n2) {
        IOCQRingOffsets.nring_entries(this.address(), n2);
        return this;
    }

    public IOCQRingOffsets overflow(@NativeType(value="__u32") int n2) {
        IOCQRingOffsets.noverflow(this.address(), n2);
        return this;
    }

    public IOCQRingOffsets cqes(@NativeType(value="__u32") int n2) {
        IOCQRingOffsets.ncqes(this.address(), n2);
        return this;
    }

    public IOCQRingOffsets flags(@NativeType(value="__u32") int n2) {
        IOCQRingOffsets.nflags(this.address(), n2);
        return this;
    }

    public IOCQRingOffsets set(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.head(n2);
        this.tail(n3);
        this.ring_mask(n4);
        this.ring_entries(n5);
        this.overflow(n6);
        this.cqes(n7);
        this.flags(n8);
        return this;
    }

    public IOCQRingOffsets set(IOCQRingOffsets iOCQRingOffsets) {
        MemoryUtil.memCopy(iOCQRingOffsets.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOCQRingOffsets malloc() {
        return IOCQRingOffsets.wrap(IOCQRingOffsets.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOCQRingOffsets calloc() {
        return IOCQRingOffsets.wrap(IOCQRingOffsets.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOCQRingOffsets create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOCQRingOffsets.wrap(IOCQRingOffsets.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOCQRingOffsets create(long l2) {
        return IOCQRingOffsets.wrap(IOCQRingOffsets.class, l2);
    }

    @Nullable
    public static IOCQRingOffsets createSafe(long l2) {
        return l2 == 0L ? null : IOCQRingOffsets.wrap(IOCQRingOffsets.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOCQRingOffsets.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOCQRingOffsets.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOCQRingOffsets.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOCQRingOffsets.__create(n2, SIZEOF);
        return IOCQRingOffsets.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOCQRingOffsets.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOCQRingOffsets.wrap(Buffer.class, l2, n2);
    }

    public static IOCQRingOffsets malloc(MemoryStack memoryStack) {
        return IOCQRingOffsets.wrap(IOCQRingOffsets.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOCQRingOffsets calloc(MemoryStack memoryStack) {
        return IOCQRingOffsets.wrap(IOCQRingOffsets.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOCQRingOffsets.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOCQRingOffsets.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nhead(long l2) {
        return UNSAFE.getInt(null, l2 + (long)HEAD);
    }

    public static int ntail(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TAIL);
    }

    public static int nring_mask(long l2) {
        return UNSAFE.getInt(null, l2 + (long)RING_MASK);
    }

    public static int nring_entries(long l2) {
        return UNSAFE.getInt(null, l2 + (long)RING_ENTRIES);
    }

    public static int noverflow(long l2) {
        return UNSAFE.getInt(null, l2 + (long)OVERFLOW);
    }

    public static int ncqes(long l2) {
        return UNSAFE.getInt(null, l2 + (long)CQES);
    }

    public static int nflags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FLAGS);
    }

    public static int nresv1(long l2) {
        return UNSAFE.getInt(null, l2 + (long)RESV1);
    }

    public static long nresv2(long l2) {
        return UNSAFE.getLong(null, l2 + (long)RESV2);
    }

    public static void nhead(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)HEAD, n2);
    }

    public static void ntail(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)TAIL, n2);
    }

    public static void nring_mask(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RING_MASK, n2);
    }

    public static void nring_entries(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RING_ENTRIES, n2);
    }

    public static void noverflow(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)OVERFLOW, n2);
    }

    public static void ncqes(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)CQES, n2);
    }

    public static void nflags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FLAGS, n2);
    }

    public static void nresv1(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RESV1, n2);
    }

    public static void nresv2(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)RESV2, l3);
    }

    static {
        Struct.Layout layout = IOCQRingOffsets.__struct(IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        HEAD = layout.offsetof(0);
        TAIL = layout.offsetof(1);
        RING_MASK = layout.offsetof(2);
        RING_ENTRIES = layout.offsetof(3);
        OVERFLOW = layout.offsetof(4);
        CQES = layout.offsetof(5);
        FLAGS = layout.offsetof(6);
        RESV1 = layout.offsetof(7);
        RESV2 = layout.offsetof(8);
    }

    public static class Buffer
    extends StructBuffer<IOCQRingOffsets, Buffer>
    implements NativeResource {
        private static final IOCQRingOffsets ELEMENT_FACTORY = IOCQRingOffsets.create(-1L);

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
        protected IOCQRingOffsets getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int head() {
            return IOCQRingOffsets.nhead(this.address());
        }

        @NativeType(value="__u32")
        public int tail() {
            return IOCQRingOffsets.ntail(this.address());
        }

        @NativeType(value="__u32")
        public int ring_mask() {
            return IOCQRingOffsets.nring_mask(this.address());
        }

        @NativeType(value="__u32")
        public int ring_entries() {
            return IOCQRingOffsets.nring_entries(this.address());
        }

        @NativeType(value="__u32")
        public int overflow() {
            return IOCQRingOffsets.noverflow(this.address());
        }

        @NativeType(value="__u32")
        public int cqes() {
            return IOCQRingOffsets.ncqes(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOCQRingOffsets.nflags(this.address());
        }

        public Buffer head(@NativeType(value="__u32") int n2) {
            IOCQRingOffsets.nhead(this.address(), n2);
            return this;
        }

        public Buffer tail(@NativeType(value="__u32") int n2) {
            IOCQRingOffsets.ntail(this.address(), n2);
            return this;
        }

        public Buffer ring_mask(@NativeType(value="__u32") int n2) {
            IOCQRingOffsets.nring_mask(this.address(), n2);
            return this;
        }

        public Buffer ring_entries(@NativeType(value="__u32") int n2) {
            IOCQRingOffsets.nring_entries(this.address(), n2);
            return this;
        }

        public Buffer overflow(@NativeType(value="__u32") int n2) {
            IOCQRingOffsets.noverflow(this.address(), n2);
            return this;
        }

        public Buffer cqes(@NativeType(value="__u32") int n2) {
            IOCQRingOffsets.ncqes(this.address(), n2);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int n2) {
            IOCQRingOffsets.nflags(this.address(), n2);
            return this;
        }
    }
}

