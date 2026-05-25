/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_restriction")
public class IOURingRestriction
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OPCODE;
    public static final int REGISTER_OP;
    public static final int SQE_OP;
    public static final int SQE_FLAGS;
    public static final int RESV;
    public static final int RESV2;

    public IOURingRestriction(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingRestriction.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u16")
    public short opcode() {
        return IOURingRestriction.nopcode(this.address());
    }

    @NativeType(value="__u8")
    public byte register_op() {
        return IOURingRestriction.nregister_op(this.address());
    }

    @NativeType(value="__u8")
    public byte sqe_op() {
        return IOURingRestriction.nsqe_op(this.address());
    }

    @NativeType(value="__u8")
    public byte sqe_flags() {
        return IOURingRestriction.nsqe_flags(this.address());
    }

    public IOURingRestriction opcode(@NativeType(value="__u16") short s2) {
        IOURingRestriction.nopcode(this.address(), s2);
        return this;
    }

    public IOURingRestriction register_op(@NativeType(value="__u8") byte by2) {
        IOURingRestriction.nregister_op(this.address(), by2);
        return this;
    }

    public IOURingRestriction sqe_op(@NativeType(value="__u8") byte by2) {
        IOURingRestriction.nsqe_op(this.address(), by2);
        return this;
    }

    public IOURingRestriction sqe_flags(@NativeType(value="__u8") byte by2) {
        IOURingRestriction.nsqe_flags(this.address(), by2);
        return this;
    }

    public IOURingRestriction set(IOURingRestriction iOURingRestriction) {
        MemoryUtil.memCopy(iOURingRestriction.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRestriction malloc() {
        return IOURingRestriction.wrap(IOURingRestriction.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURingRestriction calloc() {
        return IOURingRestriction.wrap(IOURingRestriction.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURingRestriction create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURingRestriction.wrap(IOURingRestriction.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingRestriction create(long l2) {
        return IOURingRestriction.wrap(IOURingRestriction.class, l2);
    }

    @Nullable
    public static IOURingRestriction createSafe(long l2) {
        return l2 == 0L ? null : IOURingRestriction.wrap(IOURingRestriction.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURingRestriction.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURingRestriction.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURingRestriction.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURingRestriction.__create(n2, SIZEOF);
        return IOURingRestriction.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURingRestriction.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURingRestriction.wrap(Buffer.class, l2, n2);
    }

    public static IOURingRestriction malloc(MemoryStack memoryStack) {
        return IOURingRestriction.wrap(IOURingRestriction.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURingRestriction calloc(MemoryStack memoryStack) {
        return IOURingRestriction.wrap(IOURingRestriction.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURingRestriction.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURingRestriction.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static short nopcode(long l2) {
        return UNSAFE.getShort(null, l2 + (long)OPCODE);
    }

    public static byte nregister_op(long l2) {
        return UNSAFE.getByte(null, l2 + (long)REGISTER_OP);
    }

    public static byte nsqe_op(long l2) {
        return UNSAFE.getByte(null, l2 + (long)SQE_OP);
    }

    public static byte nsqe_flags(long l2) {
        return UNSAFE.getByte(null, l2 + (long)SQE_FLAGS);
    }

    public static byte nresv(long l2) {
        return UNSAFE.getByte(null, l2 + (long)RESV);
    }

    public static IntBuffer nresv2(long l2) {
        return MemoryUtil.memIntBuffer(l2 + (long)RESV2, 3);
    }

    public static int nresv2(long l2, int n2) {
        return UNSAFE.getInt(null, l2 + (long)RESV2 + Checks.check(n2, 3) * 4L);
    }

    public static void nopcode(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)OPCODE, s2);
    }

    public static void nregister_op(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)REGISTER_OP, by2);
    }

    public static void nsqe_op(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)SQE_OP, by2);
    }

    public static void nsqe_flags(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)SQE_FLAGS, by2);
    }

    public static void nresv(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)RESV, by2);
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

    static {
        Struct.Layout layout = IOURingRestriction.__struct(IOURingRestriction.__member(2), IOURingRestriction.__union(IOURingRestriction.__member(1), IOURingRestriction.__member(1), IOURingRestriction.__member(1)), IOURingRestriction.__member(1), IOURingRestriction.__array(4, 3));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        OPCODE = layout.offsetof(0);
        REGISTER_OP = layout.offsetof(2);
        SQE_OP = layout.offsetof(3);
        SQE_FLAGS = layout.offsetof(4);
        RESV = layout.offsetof(5);
        RESV2 = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<IOURingRestriction, Buffer>
    implements NativeResource {
        private static final IOURingRestriction ELEMENT_FACTORY = IOURingRestriction.create(-1L);

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
        protected IOURingRestriction getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u16")
        public short opcode() {
            return IOURingRestriction.nopcode(this.address());
        }

        @NativeType(value="__u8")
        public byte register_op() {
            return IOURingRestriction.nregister_op(this.address());
        }

        @NativeType(value="__u8")
        public byte sqe_op() {
            return IOURingRestriction.nsqe_op(this.address());
        }

        @NativeType(value="__u8")
        public byte sqe_flags() {
            return IOURingRestriction.nsqe_flags(this.address());
        }

        public Buffer opcode(@NativeType(value="__u16") short s2) {
            IOURingRestriction.nopcode(this.address(), s2);
            return this;
        }

        public Buffer register_op(@NativeType(value="__u8") byte by2) {
            IOURingRestriction.nregister_op(this.address(), by2);
            return this;
        }

        public Buffer sqe_op(@NativeType(value="__u8") byte by2) {
            IOURingRestriction.nsqe_op(this.address(), by2);
            return this;
        }

        public Buffer sqe_flags(@NativeType(value="__u8") byte by2) {
            IOURingRestriction.nsqe_flags(this.address(), by2);
            return this;
        }
    }
}

