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

@NativeType(value="struct io_sqring_offsets")
public class IOSQRingOffsets
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int HEAD;
    public static final int TAIL;
    public static final int RING_MASK;
    public static final int RING_ENTRIES;
    public static final int FLAGS;
    public static final int DROPPED;
    public static final int ARRAY;
    public static final int RESV1;
    public static final int RESV2;

    public IOSQRingOffsets(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOSQRingOffsets.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int head() {
        return IOSQRingOffsets.nhead(this.address());
    }

    @NativeType(value="__u32")
    public int tail() {
        return IOSQRingOffsets.ntail(this.address());
    }

    @NativeType(value="__u32")
    public int ring_mask() {
        return IOSQRingOffsets.nring_mask(this.address());
    }

    @NativeType(value="__u32")
    public int ring_entries() {
        return IOSQRingOffsets.nring_entries(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOSQRingOffsets.nflags(this.address());
    }

    @NativeType(value="__u32")
    public int dropped() {
        return IOSQRingOffsets.ndropped(this.address());
    }

    @NativeType(value="__u32")
    public int array() {
        return IOSQRingOffsets.narray(this.address());
    }

    public IOSQRingOffsets head(@NativeType(value="__u32") int n2) {
        IOSQRingOffsets.nhead(this.address(), n2);
        return this;
    }

    public IOSQRingOffsets tail(@NativeType(value="__u32") int n2) {
        IOSQRingOffsets.ntail(this.address(), n2);
        return this;
    }

    public IOSQRingOffsets ring_mask(@NativeType(value="__u32") int n2) {
        IOSQRingOffsets.nring_mask(this.address(), n2);
        return this;
    }

    public IOSQRingOffsets ring_entries(@NativeType(value="__u32") int n2) {
        IOSQRingOffsets.nring_entries(this.address(), n2);
        return this;
    }

    public IOSQRingOffsets flags(@NativeType(value="__u32") int n2) {
        IOSQRingOffsets.nflags(this.address(), n2);
        return this;
    }

    public IOSQRingOffsets dropped(@NativeType(value="__u32") int n2) {
        IOSQRingOffsets.ndropped(this.address(), n2);
        return this;
    }

    public IOSQRingOffsets array(@NativeType(value="__u32") int n2) {
        IOSQRingOffsets.narray(this.address(), n2);
        return this;
    }

    public IOSQRingOffsets set(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.head(n2);
        this.tail(n3);
        this.ring_mask(n4);
        this.ring_entries(n5);
        this.flags(n6);
        this.dropped(n7);
        this.array(n8);
        return this;
    }

    public IOSQRingOffsets set(IOSQRingOffsets iOSQRingOffsets) {
        MemoryUtil.memCopy(iOSQRingOffsets.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOSQRingOffsets malloc() {
        return IOSQRingOffsets.wrap(IOSQRingOffsets.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOSQRingOffsets calloc() {
        return IOSQRingOffsets.wrap(IOSQRingOffsets.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOSQRingOffsets create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOSQRingOffsets.wrap(IOSQRingOffsets.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOSQRingOffsets create(long l2) {
        return IOSQRingOffsets.wrap(IOSQRingOffsets.class, l2);
    }

    @Nullable
    public static IOSQRingOffsets createSafe(long l2) {
        return l2 == 0L ? null : IOSQRingOffsets.wrap(IOSQRingOffsets.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOSQRingOffsets.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOSQRingOffsets.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOSQRingOffsets.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOSQRingOffsets.__create(n2, SIZEOF);
        return IOSQRingOffsets.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOSQRingOffsets.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOSQRingOffsets.wrap(Buffer.class, l2, n2);
    }

    public static IOSQRingOffsets malloc(MemoryStack memoryStack) {
        return IOSQRingOffsets.wrap(IOSQRingOffsets.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOSQRingOffsets calloc(MemoryStack memoryStack) {
        return IOSQRingOffsets.wrap(IOSQRingOffsets.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOSQRingOffsets.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOSQRingOffsets.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static int nflags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FLAGS);
    }

    public static int ndropped(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DROPPED);
    }

    public static int narray(long l2) {
        return UNSAFE.getInt(null, l2 + (long)ARRAY);
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

    public static void nflags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FLAGS, n2);
    }

    public static void ndropped(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)DROPPED, n2);
    }

    public static void narray(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)ARRAY, n2);
    }

    public static void nresv1(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RESV1, n2);
    }

    public static void nresv2(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)RESV2, l3);
    }

    static {
        Struct.Layout layout = IOSQRingOffsets.__struct(IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        HEAD = layout.offsetof(0);
        TAIL = layout.offsetof(1);
        RING_MASK = layout.offsetof(2);
        RING_ENTRIES = layout.offsetof(3);
        FLAGS = layout.offsetof(4);
        DROPPED = layout.offsetof(5);
        ARRAY = layout.offsetof(6);
        RESV1 = layout.offsetof(7);
        RESV2 = layout.offsetof(8);
    }

    public static class Buffer
    extends StructBuffer<IOSQRingOffsets, Buffer>
    implements NativeResource {
        private static final IOSQRingOffsets ELEMENT_FACTORY = IOSQRingOffsets.create(-1L);

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
        protected IOSQRingOffsets getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int head() {
            return IOSQRingOffsets.nhead(this.address());
        }

        @NativeType(value="__u32")
        public int tail() {
            return IOSQRingOffsets.ntail(this.address());
        }

        @NativeType(value="__u32")
        public int ring_mask() {
            return IOSQRingOffsets.nring_mask(this.address());
        }

        @NativeType(value="__u32")
        public int ring_entries() {
            return IOSQRingOffsets.nring_entries(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOSQRingOffsets.nflags(this.address());
        }

        @NativeType(value="__u32")
        public int dropped() {
            return IOSQRingOffsets.ndropped(this.address());
        }

        @NativeType(value="__u32")
        public int array() {
            return IOSQRingOffsets.narray(this.address());
        }

        public Buffer head(@NativeType(value="__u32") int n2) {
            IOSQRingOffsets.nhead(this.address(), n2);
            return this;
        }

        public Buffer tail(@NativeType(value="__u32") int n2) {
            IOSQRingOffsets.ntail(this.address(), n2);
            return this;
        }

        public Buffer ring_mask(@NativeType(value="__u32") int n2) {
            IOSQRingOffsets.nring_mask(this.address(), n2);
            return this;
        }

        public Buffer ring_entries(@NativeType(value="__u32") int n2) {
            IOSQRingOffsets.nring_entries(this.address(), n2);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int n2) {
            IOSQRingOffsets.nflags(this.address(), n2);
            return this;
        }

        public Buffer dropped(@NativeType(value="__u32") int n2) {
            IOSQRingOffsets.ndropped(this.address(), n2);
            return this;
        }

        public Buffer array(@NativeType(value="__u32") int n2) {
            IOSQRingOffsets.narray(this.address(), n2);
            return this;
        }
    }
}

