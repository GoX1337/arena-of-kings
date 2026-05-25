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

@NativeType(value="struct io_uring_rsrc_update")
public class IOURingRSRCUpdate
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OFFSET;
    public static final int RESV;
    public static final int DATA;

    public IOURingRSRCUpdate(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingRSRCUpdate.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int offset() {
        return IOURingRSRCUpdate.noffset(this.address());
    }

    @NativeType(value="__u32")
    public int resv() {
        return IOURingRSRCUpdate.nresv(this.address());
    }

    @NativeType(value="__u64")
    public long data() {
        return IOURingRSRCUpdate.ndata(this.address());
    }

    public IOURingRSRCUpdate offset(@NativeType(value="__u32") int n2) {
        IOURingRSRCUpdate.noffset(this.address(), n2);
        return this;
    }

    public IOURingRSRCUpdate resv(@NativeType(value="__u32") int n2) {
        IOURingRSRCUpdate.nresv(this.address(), n2);
        return this;
    }

    public IOURingRSRCUpdate data(@NativeType(value="__u64") long l2) {
        IOURingRSRCUpdate.ndata(this.address(), l2);
        return this;
    }

    public IOURingRSRCUpdate set(int n2, int n3, long l2) {
        this.offset(n2);
        this.resv(n3);
        this.data(l2);
        return this;
    }

    public IOURingRSRCUpdate set(IOURingRSRCUpdate iOURingRSRCUpdate) {
        MemoryUtil.memCopy(iOURingRSRCUpdate.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRSRCUpdate malloc() {
        return IOURingRSRCUpdate.wrap(IOURingRSRCUpdate.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURingRSRCUpdate calloc() {
        return IOURingRSRCUpdate.wrap(IOURingRSRCUpdate.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURingRSRCUpdate create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURingRSRCUpdate.wrap(IOURingRSRCUpdate.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingRSRCUpdate create(long l2) {
        return IOURingRSRCUpdate.wrap(IOURingRSRCUpdate.class, l2);
    }

    @Nullable
    public static IOURingRSRCUpdate createSafe(long l2) {
        return l2 == 0L ? null : IOURingRSRCUpdate.wrap(IOURingRSRCUpdate.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURingRSRCUpdate.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURingRSRCUpdate.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURingRSRCUpdate.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURingRSRCUpdate.__create(n2, SIZEOF);
        return IOURingRSRCUpdate.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURingRSRCUpdate.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURingRSRCUpdate.wrap(Buffer.class, l2, n2);
    }

    public static IOURingRSRCUpdate malloc(MemoryStack memoryStack) {
        return IOURingRSRCUpdate.wrap(IOURingRSRCUpdate.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURingRSRCUpdate calloc(MemoryStack memoryStack) {
        return IOURingRSRCUpdate.wrap(IOURingRSRCUpdate.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURingRSRCUpdate.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURingRSRCUpdate.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static void noffset(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)OFFSET, n2);
    }

    public static void nresv(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RESV, n2);
    }

    public static void ndata(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)DATA, l3);
    }

    static {
        Struct.Layout layout = IOURingRSRCUpdate.__struct(IOURingRSRCUpdate.__member(4), IOURingRSRCUpdate.__member(4), IOURingRSRCUpdate.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        OFFSET = layout.offsetof(0);
        RESV = layout.offsetof(1);
        DATA = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<IOURingRSRCUpdate, Buffer>
    implements NativeResource {
        private static final IOURingRSRCUpdate ELEMENT_FACTORY = IOURingRSRCUpdate.create(-1L);

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
        protected IOURingRSRCUpdate getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int offset() {
            return IOURingRSRCUpdate.noffset(this.address());
        }

        @NativeType(value="__u32")
        public int resv() {
            return IOURingRSRCUpdate.nresv(this.address());
        }

        @NativeType(value="__u64")
        public long data() {
            return IOURingRSRCUpdate.ndata(this.address());
        }

        public Buffer offset(@NativeType(value="__u32") int n2) {
            IOURingRSRCUpdate.noffset(this.address(), n2);
            return this;
        }

        public Buffer resv(@NativeType(value="__u32") int n2) {
            IOURingRSRCUpdate.nresv(this.address(), n2);
            return this;
        }

        public Buffer data(@NativeType(value="__u64") long l2) {
            IOURingRSRCUpdate.ndata(this.address(), l2);
            return this;
        }
    }
}

