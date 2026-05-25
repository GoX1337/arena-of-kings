/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.liburing.IOURingProbeOp;

@NativeType(value="struct io_uring_probe")
public class IOURingProbe
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int LAST_OP;
    public static final int OPS_LEN;
    public static final int RESV;
    public static final int RESV2;
    public static final int OPS;

    public IOURingProbe(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingProbe.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u8")
    public byte last_op() {
        return IOURingProbe.nlast_op(this.address());
    }

    @NativeType(value="__u8")
    public byte ops_len() {
        return IOURingProbe.nops_len(this.address());
    }

    @NativeType(value="__u16")
    public short resv() {
        return IOURingProbe.nresv(this.address());
    }

    @NativeType(value="struct io_uring_probe_op[0]")
    public IOURingProbeOp.Buffer ops() {
        return IOURingProbe.nops(this.address());
    }

    @NativeType(value="struct io_uring_probe_op")
    public IOURingProbeOp ops(int n2) {
        return IOURingProbe.nops(this.address(), n2);
    }

    public IOURingProbe last_op(@NativeType(value="__u8") byte by2) {
        IOURingProbe.nlast_op(this.address(), by2);
        return this;
    }

    public IOURingProbe ops_len(@NativeType(value="__u8") byte by2) {
        IOURingProbe.nops_len(this.address(), by2);
        return this;
    }

    public IOURingProbe resv(@NativeType(value="__u16") short s2) {
        IOURingProbe.nresv(this.address(), s2);
        return this;
    }

    public IOURingProbe ops(@NativeType(value="struct io_uring_probe_op[0]") IOURingProbeOp.Buffer buffer) {
        IOURingProbe.nops(this.address(), buffer);
        return this;
    }

    public IOURingProbe ops(int n2, @NativeType(value="struct io_uring_probe_op") IOURingProbeOp iOURingProbeOp) {
        IOURingProbe.nops(this.address(), n2, iOURingProbeOp);
        return this;
    }

    public IOURingProbe ops(Consumer<IOURingProbeOp.Buffer> consumer) {
        consumer.accept(this.ops());
        return this;
    }

    public IOURingProbe ops(int n2, Consumer<IOURingProbeOp> consumer) {
        consumer.accept(this.ops(n2));
        return this;
    }

    public IOURingProbe set(byte by2, byte by3, short s2, IOURingProbeOp.Buffer buffer) {
        this.last_op(by2);
        this.ops_len(by3);
        this.resv(s2);
        this.ops(buffer);
        return this;
    }

    public IOURingProbe set(IOURingProbe iOURingProbe) {
        MemoryUtil.memCopy(iOURingProbe.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingProbe malloc() {
        return IOURingProbe.wrap(IOURingProbe.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURingProbe calloc() {
        return IOURingProbe.wrap(IOURingProbe.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURingProbe create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURingProbe.wrap(IOURingProbe.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingProbe create(long l2) {
        return IOURingProbe.wrap(IOURingProbe.class, l2);
    }

    @Nullable
    public static IOURingProbe createSafe(long l2) {
        return l2 == 0L ? null : IOURingProbe.wrap(IOURingProbe.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURingProbe.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURingProbe.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURingProbe.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURingProbe.__create(n2, SIZEOF);
        return IOURingProbe.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURingProbe.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURingProbe.wrap(Buffer.class, l2, n2);
    }

    public static IOURingProbe malloc(MemoryStack memoryStack) {
        return IOURingProbe.wrap(IOURingProbe.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURingProbe calloc(MemoryStack memoryStack) {
        return IOURingProbe.wrap(IOURingProbe.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURingProbe.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURingProbe.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static byte nlast_op(long l2) {
        return UNSAFE.getByte(null, l2 + (long)LAST_OP);
    }

    public static byte nops_len(long l2) {
        return UNSAFE.getByte(null, l2 + (long)OPS_LEN);
    }

    public static short nresv(long l2) {
        return UNSAFE.getShort(null, l2 + (long)RESV);
    }

    public static IntBuffer nresv2(long l2) {
        return MemoryUtil.memIntBuffer(l2 + (long)RESV2, 3);
    }

    public static int nresv2(long l2, int n2) {
        return UNSAFE.getInt(null, l2 + (long)RESV2 + Checks.check(n2, 3) * 4L);
    }

    public static IOURingProbeOp.Buffer nops(long l2) {
        return IOURingProbeOp.create(l2 + (long)OPS, 0);
    }

    public static IOURingProbeOp nops(long l2, int n2) {
        return IOURingProbeOp.create(l2 + (long)OPS + Checks.check(n2, 0) * (long)IOURingProbeOp.SIZEOF);
    }

    public static void nlast_op(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)LAST_OP, by2);
    }

    public static void nops_len(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)OPS_LEN, by2);
    }

    public static void nresv(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)RESV, s2);
    }

    public static void nresv2(long l2, IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(intBuffer, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), l2 + (long)RESV2, intBuffer.remaining() * 4);
    }

    public static void nresv2(long l2, int n2, int n3) {
        UNSAFE.putInt(null, l2 + (long)RESV2 + Checks.check(n2, 3) * 4L, n3);
    }

    public static void nops(long l2, IOURingProbeOp.Buffer buffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(buffer, 0);
        }
        MemoryUtil.memCopy(buffer.address(), l2 + (long)OPS, buffer.remaining() * IOURingProbeOp.SIZEOF);
    }

    public static void nops(long l2, int n2, IOURingProbeOp iOURingProbeOp) {
        MemoryUtil.memCopy(iOURingProbeOp.address(), l2 + (long)OPS + Checks.check(n2, 0) * (long)IOURingProbeOp.SIZEOF, IOURingProbeOp.SIZEOF);
    }

    static {
        Struct.Layout layout = IOURingProbe.__struct(IOURingProbe.__member(1), IOURingProbe.__member(1), IOURingProbe.__member(2), IOURingProbe.__array(4, 3), IOURingProbe.__array(IOURingProbeOp.SIZEOF, IOURingProbeOp.ALIGNOF, 0));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        LAST_OP = layout.offsetof(0);
        OPS_LEN = layout.offsetof(1);
        RESV = layout.offsetof(2);
        RESV2 = layout.offsetof(3);
        OPS = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<IOURingProbe, Buffer>
    implements NativeResource {
        private static final IOURingProbe ELEMENT_FACTORY = IOURingProbe.create(-1L);

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
        protected IOURingProbe getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u8")
        public byte last_op() {
            return IOURingProbe.nlast_op(this.address());
        }

        @NativeType(value="__u8")
        public byte ops_len() {
            return IOURingProbe.nops_len(this.address());
        }

        @NativeType(value="__u16")
        public short resv() {
            return IOURingProbe.nresv(this.address());
        }

        @NativeType(value="struct io_uring_probe_op[0]")
        public IOURingProbeOp.Buffer ops() {
            return IOURingProbe.nops(this.address());
        }

        @NativeType(value="struct io_uring_probe_op")
        public IOURingProbeOp ops(int n2) {
            return IOURingProbe.nops(this.address(), n2);
        }

        public Buffer last_op(@NativeType(value="__u8") byte by2) {
            IOURingProbe.nlast_op(this.address(), by2);
            return this;
        }

        public Buffer ops_len(@NativeType(value="__u8") byte by2) {
            IOURingProbe.nops_len(this.address(), by2);
            return this;
        }

        public Buffer resv(@NativeType(value="__u16") short s2) {
            IOURingProbe.nresv(this.address(), s2);
            return this;
        }

        public Buffer ops(@NativeType(value="struct io_uring_probe_op[0]") IOURingProbeOp.Buffer buffer) {
            IOURingProbe.nops(this.address(), buffer);
            return this;
        }

        public Buffer ops(int n2, @NativeType(value="struct io_uring_probe_op") IOURingProbeOp iOURingProbeOp) {
            IOURingProbe.nops(this.address(), n2, iOURingProbeOp);
            return this;
        }

        public Buffer ops(Consumer<IOURingProbeOp.Buffer> consumer) {
            consumer.accept(this.ops());
            return this;
        }

        public Buffer ops(int n2, Consumer<IOURingProbeOp> consumer) {
            consumer.accept(this.ops(n2));
            return this;
        }
    }
}

