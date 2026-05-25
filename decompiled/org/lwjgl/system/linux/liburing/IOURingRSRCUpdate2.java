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

@NativeType(value="struct io_uring_rsrc_update2")
public class IOURingRSRCUpdate2
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OFFSET;
    public static final int RESV;
    public static final int DATA;
    public static final int TAGS;
    public static final int NR;
    public static final int RESV2;

    public IOURingRSRCUpdate2(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingRSRCUpdate2.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int offset() {
        return IOURingRSRCUpdate2.noffset(this.address());
    }

    @NativeType(value="__u32")
    public int resv() {
        return IOURingRSRCUpdate2.nresv(this.address());
    }

    @NativeType(value="__u64")
    public long data() {
        return IOURingRSRCUpdate2.ndata(this.address());
    }

    @NativeType(value="__u64")
    public long tags() {
        return IOURingRSRCUpdate2.ntags(this.address());
    }

    @NativeType(value="__u32")
    public int nr() {
        return IOURingRSRCUpdate2.nnr(this.address());
    }

    @NativeType(value="__u32")
    public int resv2() {
        return IOURingRSRCUpdate2.nresv2(this.address());
    }

    public IOURingRSRCUpdate2 offset(@NativeType(value="__u32") int n2) {
        IOURingRSRCUpdate2.noffset(this.address(), n2);
        return this;
    }

    public IOURingRSRCUpdate2 resv(@NativeType(value="__u32") int n2) {
        IOURingRSRCUpdate2.nresv(this.address(), n2);
        return this;
    }

    public IOURingRSRCUpdate2 data(@NativeType(value="__u64") long l2) {
        IOURingRSRCUpdate2.ndata(this.address(), l2);
        return this;
    }

    public IOURingRSRCUpdate2 tags(@NativeType(value="__u64") long l2) {
        IOURingRSRCUpdate2.ntags(this.address(), l2);
        return this;
    }

    public IOURingRSRCUpdate2 nr(@NativeType(value="__u32") int n2) {
        IOURingRSRCUpdate2.nnr(this.address(), n2);
        return this;
    }

    public IOURingRSRCUpdate2 resv2(@NativeType(value="__u32") int n2) {
        IOURingRSRCUpdate2.nresv2(this.address(), n2);
        return this;
    }

    public IOURingRSRCUpdate2 set(int n2, int n3, long l2, long l3, int n4, int n5) {
        this.offset(n2);
        this.resv(n3);
        this.data(l2);
        this.tags(l3);
        this.nr(n4);
        this.resv2(n5);
        return this;
    }

    public IOURingRSRCUpdate2 set(IOURingRSRCUpdate2 iOURingRSRCUpdate2) {
        MemoryUtil.memCopy(iOURingRSRCUpdate2.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRSRCUpdate2 malloc() {
        return IOURingRSRCUpdate2.wrap(IOURingRSRCUpdate2.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURingRSRCUpdate2 calloc() {
        return IOURingRSRCUpdate2.wrap(IOURingRSRCUpdate2.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURingRSRCUpdate2 create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURingRSRCUpdate2.wrap(IOURingRSRCUpdate2.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingRSRCUpdate2 create(long l2) {
        return IOURingRSRCUpdate2.wrap(IOURingRSRCUpdate2.class, l2);
    }

    @Nullable
    public static IOURingRSRCUpdate2 createSafe(long l2) {
        return l2 == 0L ? null : IOURingRSRCUpdate2.wrap(IOURingRSRCUpdate2.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURingRSRCUpdate2.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURingRSRCUpdate2.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURingRSRCUpdate2.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURingRSRCUpdate2.__create(n2, SIZEOF);
        return IOURingRSRCUpdate2.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURingRSRCUpdate2.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURingRSRCUpdate2.wrap(Buffer.class, l2, n2);
    }

    public static IOURingRSRCUpdate2 malloc(MemoryStack memoryStack) {
        return IOURingRSRCUpdate2.wrap(IOURingRSRCUpdate2.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURingRSRCUpdate2 calloc(MemoryStack memoryStack) {
        return IOURingRSRCUpdate2.wrap(IOURingRSRCUpdate2.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURingRSRCUpdate2.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURingRSRCUpdate2.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int noffset(long l2) {
        return UNSAFE.getInt(null, l2 + (long)OFFSET);
    }

    public static int nresv(long l2) {
        return UNSAFE.getInt(null, l2 + (long)RESV);
    }

    public static long ndata(long l2) {
        return UNSAFE.getLong(null, l2 + (long)DATA);
    }

    public static long ntags(long l2) {
        return UNSAFE.getLong(null, l2 + (long)TAGS);
    }

    public static int nnr(long l2) {
        return UNSAFE.getInt(null, l2 + (long)NR);
    }

    public static int nresv2(long l2) {
        return UNSAFE.getInt(null, l2 + (long)RESV2);
    }

    public static void noffset(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)OFFSET, n2);
    }

    public static void nresv(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RESV, n2);
    }

    public static void ndata(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)DATA, l3);
    }

    public static void ntags(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)TAGS, l3);
    }

    public static void nnr(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)NR, n2);
    }

    public static void nresv2(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RESV2, n2);
    }

    static {
        Struct.Layout layout = IOURingRSRCUpdate2.__struct(IOURingRSRCUpdate2.__member(4), IOURingRSRCUpdate2.__member(4), IOURingRSRCUpdate2.__member(8), IOURingRSRCUpdate2.__member(8), IOURingRSRCUpdate2.__member(4), IOURingRSRCUpdate2.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        OFFSET = layout.offsetof(0);
        RESV = layout.offsetof(1);
        DATA = layout.offsetof(2);
        TAGS = layout.offsetof(3);
        NR = layout.offsetof(4);
        RESV2 = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<IOURingRSRCUpdate2, Buffer>
    implements NativeResource {
        private static final IOURingRSRCUpdate2 ELEMENT_FACTORY = IOURingRSRCUpdate2.create(-1L);

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
        protected IOURingRSRCUpdate2 getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int offset() {
            return IOURingRSRCUpdate2.noffset(this.address());
        }

        @NativeType(value="__u32")
        public int resv() {
            return IOURingRSRCUpdate2.nresv(this.address());
        }

        @NativeType(value="__u64")
        public long data() {
            return IOURingRSRCUpdate2.ndata(this.address());
        }

        @NativeType(value="__u64")
        public long tags() {
            return IOURingRSRCUpdate2.ntags(this.address());
        }

        @NativeType(value="__u32")
        public int nr() {
            return IOURingRSRCUpdate2.nnr(this.address());
        }

        @NativeType(value="__u32")
        public int resv2() {
            return IOURingRSRCUpdate2.nresv2(this.address());
        }

        public Buffer offset(@NativeType(value="__u32") int n2) {
            IOURingRSRCUpdate2.noffset(this.address(), n2);
            return this;
        }

        public Buffer resv(@NativeType(value="__u32") int n2) {
            IOURingRSRCUpdate2.nresv(this.address(), n2);
            return this;
        }

        public Buffer data(@NativeType(value="__u64") long l2) {
            IOURingRSRCUpdate2.ndata(this.address(), l2);
            return this;
        }

        public Buffer tags(@NativeType(value="__u64") long l2) {
            IOURingRSRCUpdate2.ntags(this.address(), l2);
            return this;
        }

        public Buffer nr(@NativeType(value="__u32") int n2) {
            IOURingRSRCUpdate2.nnr(this.address(), n2);
            return this;
        }

        public Buffer resv2(@NativeType(value="__u32") int n2) {
            IOURingRSRCUpdate2.nresv2(this.address(), n2);
            return this;
        }
    }
}

