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

@NativeType(value="struct io_uring_probe_op")
public class IOURingProbeOp
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OP;
    public static final int RESV;
    public static final int FLAGS;
    public static final int RESV2;

    public IOURingProbeOp(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingProbeOp.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u8")
    public byte op() {
        return IOURingProbeOp.nop(this.address());
    }

    @NativeType(value="__u8")
    public byte resv() {
        return IOURingProbeOp.nresv(this.address());
    }

    @NativeType(value="__u16")
    public short flags() {
        return IOURingProbeOp.nflags(this.address());
    }

    @NativeType(value="__u32")
    public int resv2() {
        return IOURingProbeOp.nresv2(this.address());
    }

    public IOURingProbeOp op(@NativeType(value="__u8") byte by2) {
        IOURingProbeOp.nop(this.address(), by2);
        return this;
    }

    public IOURingProbeOp resv(@NativeType(value="__u8") byte by2) {
        IOURingProbeOp.nresv(this.address(), by2);
        return this;
    }

    public IOURingProbeOp flags(@NativeType(value="__u16") short s2) {
        IOURingProbeOp.nflags(this.address(), s2);
        return this;
    }

    public IOURingProbeOp resv2(@NativeType(value="__u32") int n2) {
        IOURingProbeOp.nresv2(this.address(), n2);
        return this;
    }

    public IOURingProbeOp set(byte by2, byte by3, short s2, int n2) {
        this.op(by2);
        this.resv(by3);
        this.flags(s2);
        this.resv2(n2);
        return this;
    }

    public IOURingProbeOp set(IOURingProbeOp iOURingProbeOp) {
        MemoryUtil.memCopy(iOURingProbeOp.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingProbeOp malloc() {
        return IOURingProbeOp.wrap(IOURingProbeOp.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURingProbeOp calloc() {
        return IOURingProbeOp.wrap(IOURingProbeOp.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURingProbeOp create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURingProbeOp.wrap(IOURingProbeOp.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingProbeOp create(long l2) {
        return IOURingProbeOp.wrap(IOURingProbeOp.class, l2);
    }

    @Nullable
    public static IOURingProbeOp createSafe(long l2) {
        return l2 == 0L ? null : IOURingProbeOp.wrap(IOURingProbeOp.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURingProbeOp.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURingProbeOp.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURingProbeOp.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURingProbeOp.__create(n2, SIZEOF);
        return IOURingProbeOp.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURingProbeOp.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURingProbeOp.wrap(Buffer.class, l2, n2);
    }

    public static IOURingProbeOp malloc(MemoryStack memoryStack) {
        return IOURingProbeOp.wrap(IOURingProbeOp.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURingProbeOp calloc(MemoryStack memoryStack) {
        return IOURingProbeOp.wrap(IOURingProbeOp.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURingProbeOp.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURingProbeOp.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static byte nop(long l2) {
        return UNSAFE.getByte(null, l2 + (long)OP);
    }

    public static byte nresv(long l2) {
        return UNSAFE.getByte(null, l2 + (long)RESV);
    }

    public static short nflags(long l2) {
        return UNSAFE.getShort(null, l2 + (long)FLAGS);
    }

    public static int nresv2(long l2) {
        return UNSAFE.getInt(null, l2 + (long)RESV2);
    }

    public static void nop(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)OP, by2);
    }

    public static void nresv(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)RESV, by2);
    }

    public static void nflags(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)FLAGS, s2);
    }

    public static void nresv2(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RESV2, n2);
    }

    static {
        Struct.Layout layout = IOURingProbeOp.__struct(IOURingProbeOp.__member(1), IOURingProbeOp.__member(1), IOURingProbeOp.__member(2), IOURingProbeOp.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        OP = layout.offsetof(0);
        RESV = layout.offsetof(1);
        FLAGS = layout.offsetof(2);
        RESV2 = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingProbeOp, Buffer>
    implements NativeResource {
        private static final IOURingProbeOp ELEMENT_FACTORY = IOURingProbeOp.create(-1L);

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
        protected IOURingProbeOp getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u8")
        public byte op() {
            return IOURingProbeOp.nop(this.address());
        }

        @NativeType(value="__u8")
        public byte resv() {
            return IOURingProbeOp.nresv(this.address());
        }

        @NativeType(value="__u16")
        public short flags() {
            return IOURingProbeOp.nflags(this.address());
        }

        @NativeType(value="__u32")
        public int resv2() {
            return IOURingProbeOp.nresv2(this.address());
        }

        public Buffer op(@NativeType(value="__u8") byte by2) {
            IOURingProbeOp.nop(this.address(), by2);
            return this;
        }

        public Buffer resv(@NativeType(value="__u8") byte by2) {
            IOURingProbeOp.nresv(this.address(), by2);
            return this;
        }

        public Buffer flags(@NativeType(value="__u16") short s2) {
            IOURingProbeOp.nflags(this.address(), s2);
            return this;
        }

        public Buffer resv2(@NativeType(value="__u32") int n2) {
            IOURingProbeOp.nresv2(this.address(), n2);
            return this;
        }
    }
}

