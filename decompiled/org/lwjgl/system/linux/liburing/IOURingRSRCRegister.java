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

@NativeType(value="struct io_uring_rsrc_register")
public class IOURingRSRCRegister
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NR;
    public static final int RESV;
    public static final int RESV2;
    public static final int DATA;
    public static final int TAGS;

    public IOURingRSRCRegister(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingRSRCRegister.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int nr() {
        return IOURingRSRCRegister.nnr(this.address());
    }

    @NativeType(value="__u32")
    public int resv() {
        return IOURingRSRCRegister.nresv(this.address());
    }

    @NativeType(value="__u64")
    public long resv2() {
        return IOURingRSRCRegister.nresv2(this.address());
    }

    @NativeType(value="__u64")
    public long data() {
        return IOURingRSRCRegister.ndata(this.address());
    }

    @NativeType(value="__u64")
    public long tags() {
        return IOURingRSRCRegister.ntags(this.address());
    }

    public IOURingRSRCRegister nr(@NativeType(value="__u32") int n2) {
        IOURingRSRCRegister.nnr(this.address(), n2);
        return this;
    }

    public IOURingRSRCRegister resv(@NativeType(value="__u32") int n2) {
        IOURingRSRCRegister.nresv(this.address(), n2);
        return this;
    }

    public IOURingRSRCRegister resv2(@NativeType(value="__u64") long l2) {
        IOURingRSRCRegister.nresv2(this.address(), l2);
        return this;
    }

    public IOURingRSRCRegister data(@NativeType(value="__u64") long l2) {
        IOURingRSRCRegister.ndata(this.address(), l2);
        return this;
    }

    public IOURingRSRCRegister tags(@NativeType(value="__u64") long l2) {
        IOURingRSRCRegister.ntags(this.address(), l2);
        return this;
    }

    public IOURingRSRCRegister set(int n2, int n3, long l2, long l3, long l4) {
        this.nr(n2);
        this.resv(n3);
        this.resv2(l2);
        this.data(l3);
        this.tags(l4);
        return this;
    }

    public IOURingRSRCRegister set(IOURingRSRCRegister iOURingRSRCRegister) {
        MemoryUtil.memCopy(iOURingRSRCRegister.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRSRCRegister malloc() {
        return IOURingRSRCRegister.wrap(IOURingRSRCRegister.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURingRSRCRegister calloc() {
        return IOURingRSRCRegister.wrap(IOURingRSRCRegister.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURingRSRCRegister create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURingRSRCRegister.wrap(IOURingRSRCRegister.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingRSRCRegister create(long l2) {
        return IOURingRSRCRegister.wrap(IOURingRSRCRegister.class, l2);
    }

    @Nullable
    public static IOURingRSRCRegister createSafe(long l2) {
        return l2 == 0L ? null : IOURingRSRCRegister.wrap(IOURingRSRCRegister.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURingRSRCRegister.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURingRSRCRegister.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURingRSRCRegister.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURingRSRCRegister.__create(n2, SIZEOF);
        return IOURingRSRCRegister.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURingRSRCRegister.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURingRSRCRegister.wrap(Buffer.class, l2, n2);
    }

    public static IOURingRSRCRegister malloc(MemoryStack memoryStack) {
        return IOURingRSRCRegister.wrap(IOURingRSRCRegister.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURingRSRCRegister calloc(MemoryStack memoryStack) {
        return IOURingRSRCRegister.wrap(IOURingRSRCRegister.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURingRSRCRegister.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURingRSRCRegister.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nnr(long l2) {
        return UNSAFE.getInt(null, l2 + (long)NR);
    }

    public static int nresv(long l2) {
        return UNSAFE.getInt(null, l2 + (long)RESV);
    }

    public static long nresv2(long l2) {
        return UNSAFE.getLong(null, l2 + (long)RESV2);
    }

    public static long ndata(long l2) {
        return UNSAFE.getLong(null, l2 + (long)DATA);
    }

    public static long ntags(long l2) {
        return UNSAFE.getLong(null, l2 + (long)TAGS);
    }

    public static void nnr(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)NR, n2);
    }

    public static void nresv(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RESV, n2);
    }

    public static void nresv2(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)RESV2, l3);
    }

    public static void ndata(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)DATA, l3);
    }

    public static void ntags(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)TAGS, l3);
    }

    static {
        Struct.Layout layout = IOURingRSRCRegister.__struct(IOURingRSRCRegister.__member(4), IOURingRSRCRegister.__member(4), IOURingRSRCRegister.__member(8), IOURingRSRCRegister.__member(8), IOURingRSRCRegister.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NR = layout.offsetof(0);
        RESV = layout.offsetof(1);
        RESV2 = layout.offsetof(2);
        DATA = layout.offsetof(3);
        TAGS = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<IOURingRSRCRegister, Buffer>
    implements NativeResource {
        private static final IOURingRSRCRegister ELEMENT_FACTORY = IOURingRSRCRegister.create(-1L);

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
        protected IOURingRSRCRegister getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int nr() {
            return IOURingRSRCRegister.nnr(this.address());
        }

        @NativeType(value="__u32")
        public int resv() {
            return IOURingRSRCRegister.nresv(this.address());
        }

        @NativeType(value="__u64")
        public long resv2() {
            return IOURingRSRCRegister.nresv2(this.address());
        }

        @NativeType(value="__u64")
        public long data() {
            return IOURingRSRCRegister.ndata(this.address());
        }

        @NativeType(value="__u64")
        public long tags() {
            return IOURingRSRCRegister.ntags(this.address());
        }

        public Buffer nr(@NativeType(value="__u32") int n2) {
            IOURingRSRCRegister.nnr(this.address(), n2);
            return this;
        }

        public Buffer resv(@NativeType(value="__u32") int n2) {
            IOURingRSRCRegister.nresv(this.address(), n2);
            return this;
        }

        public Buffer resv2(@NativeType(value="__u64") long l2) {
            IOURingRSRCRegister.nresv2(this.address(), l2);
            return this;
        }

        public Buffer data(@NativeType(value="__u64") long l2) {
            IOURingRSRCRegister.ndata(this.address(), l2);
            return this;
        }

        public Buffer tags(@NativeType(value="__u64") long l2) {
            IOURingRSRCRegister.ntags(this.address(), l2);
            return this;
        }
    }
}

