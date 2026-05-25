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
import org.lwjgl.system.linux.liburing.IOURingCQ;
import org.lwjgl.system.linux.liburing.IOURingSQ;

@NativeType(value="struct io_uring")
public class IOURing
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SQ;
    public static final int CQ;
    public static final int FLAGS;
    public static final int RING_FD;
    public static final int FEATURES;
    public static final int PAD;

    public IOURing(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURing.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="struct io_uring_sq")
    public IOURingSQ sq() {
        return IOURing.nsq(this.address());
    }

    @NativeType(value="struct io_uring_cq")
    public IOURingCQ cq() {
        return IOURing.ncq(this.address());
    }

    @NativeType(value="unsigned int")
    public int flags() {
        return IOURing.nflags(this.address());
    }

    public int ring_fd() {
        return IOURing.nring_fd(this.address());
    }

    @NativeType(value="unsigned int")
    public int features() {
        return IOURing.nfeatures(this.address());
    }

    public IOURing sq(@NativeType(value="struct io_uring_sq") IOURingSQ iOURingSQ) {
        IOURing.nsq(this.address(), iOURingSQ);
        return this;
    }

    public IOURing sq(Consumer<IOURingSQ> consumer) {
        consumer.accept(this.sq());
        return this;
    }

    public IOURing cq(@NativeType(value="struct io_uring_cq") IOURingCQ iOURingCQ) {
        IOURing.ncq(this.address(), iOURingCQ);
        return this;
    }

    public IOURing cq(Consumer<IOURingCQ> consumer) {
        consumer.accept(this.cq());
        return this;
    }

    public IOURing flags(@NativeType(value="unsigned int") int n2) {
        IOURing.nflags(this.address(), n2);
        return this;
    }

    public IOURing ring_fd(int n2) {
        IOURing.nring_fd(this.address(), n2);
        return this;
    }

    public IOURing features(@NativeType(value="unsigned int") int n2) {
        IOURing.nfeatures(this.address(), n2);
        return this;
    }

    public IOURing set(IOURingSQ iOURingSQ, IOURingCQ iOURingCQ, int n2, int n3, int n4) {
        this.sq(iOURingSQ);
        this.cq(iOURingCQ);
        this.flags(n2);
        this.ring_fd(n3);
        this.features(n4);
        return this;
    }

    public IOURing set(IOURing iOURing) {
        MemoryUtil.memCopy(iOURing.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURing malloc() {
        return IOURing.wrap(IOURing.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURing calloc() {
        return IOURing.wrap(IOURing.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURing create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURing.wrap(IOURing.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURing create(long l2) {
        return IOURing.wrap(IOURing.class, l2);
    }

    @Nullable
    public static IOURing createSafe(long l2) {
        return l2 == 0L ? null : IOURing.wrap(IOURing.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURing.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURing.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURing.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURing.__create(n2, SIZEOF);
        return IOURing.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURing.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURing.wrap(Buffer.class, l2, n2);
    }

    public static IOURing malloc(MemoryStack memoryStack) {
        return IOURing.wrap(IOURing.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURing calloc(MemoryStack memoryStack) {
        return IOURing.wrap(IOURing.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURing.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURing.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static IOURingSQ nsq(long l2) {
        return IOURingSQ.create(l2 + (long)SQ);
    }

    public static IOURingCQ ncq(long l2) {
        return IOURingCQ.create(l2 + (long)CQ);
    }

    public static int nflags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FLAGS);
    }

    public static int nring_fd(long l2) {
        return UNSAFE.getInt(null, l2 + (long)RING_FD);
    }

    public static int nfeatures(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FEATURES);
    }

    public static IntBuffer npad(long l2) {
        return MemoryUtil.memIntBuffer(l2 + (long)PAD, 3);
    }

    public static int npad(long l2, int n2) {
        return UNSAFE.getInt(null, l2 + (long)PAD + Checks.check(n2, 3) * 4L);
    }

    public static void nsq(long l2, IOURingSQ iOURingSQ) {
        MemoryUtil.memCopy(iOURingSQ.address(), l2 + (long)SQ, IOURingSQ.SIZEOF);
    }

    public static void ncq(long l2, IOURingCQ iOURingCQ) {
        MemoryUtil.memCopy(iOURingCQ.address(), l2 + (long)CQ, IOURingCQ.SIZEOF);
    }

    public static void nflags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FLAGS, n2);
    }

    public static void nring_fd(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RING_FD, n2);
    }

    public static void nfeatures(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FEATURES, n2);
    }

    public static void npad(long l2, IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(intBuffer, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), l2 + (long)PAD, intBuffer.remaining() * 4);
    }

    public static void npad(long l2, int n2, int n3) {
        UNSAFE.putInt(null, l2 + (long)PAD + Checks.check(n2, 3) * 4L, n3);
    }

    public static void validate(long l2) {
        IOURingSQ.validate(l2 + (long)SQ);
        IOURingCQ.validate(l2 + (long)CQ);
    }

    static {
        Struct.Layout layout = IOURing.__struct(IOURing.__member(IOURingSQ.SIZEOF, IOURingSQ.ALIGNOF), IOURing.__member(IOURingCQ.SIZEOF, IOURingCQ.ALIGNOF), IOURing.__member(4), IOURing.__member(4), IOURing.__member(4), IOURing.__array(4, 3));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        SQ = layout.offsetof(0);
        CQ = layout.offsetof(1);
        FLAGS = layout.offsetof(2);
        RING_FD = layout.offsetof(3);
        FEATURES = layout.offsetof(4);
        PAD = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<IOURing, Buffer>
    implements NativeResource {
        private static final IOURing ELEMENT_FACTORY = IOURing.create(-1L);

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
        protected IOURing getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="struct io_uring_sq")
        public IOURingSQ sq() {
            return IOURing.nsq(this.address());
        }

        @NativeType(value="struct io_uring_cq")
        public IOURingCQ cq() {
            return IOURing.ncq(this.address());
        }

        @NativeType(value="unsigned int")
        public int flags() {
            return IOURing.nflags(this.address());
        }

        public int ring_fd() {
            return IOURing.nring_fd(this.address());
        }

        @NativeType(value="unsigned int")
        public int features() {
            return IOURing.nfeatures(this.address());
        }

        public Buffer sq(@NativeType(value="struct io_uring_sq") IOURingSQ iOURingSQ) {
            IOURing.nsq(this.address(), iOURingSQ);
            return this;
        }

        public Buffer sq(Consumer<IOURingSQ> consumer) {
            consumer.accept(this.sq());
            return this;
        }

        public Buffer cq(@NativeType(value="struct io_uring_cq") IOURingCQ iOURingCQ) {
            IOURing.ncq(this.address(), iOURingCQ);
            return this;
        }

        public Buffer cq(Consumer<IOURingCQ> consumer) {
            consumer.accept(this.cq());
            return this;
        }

        public Buffer flags(@NativeType(value="unsigned int") int n2) {
            IOURing.nflags(this.address(), n2);
            return this;
        }

        public Buffer ring_fd(int n2) {
            IOURing.nring_fd(this.address(), n2);
            return this;
        }

        public Buffer features(@NativeType(value="unsigned int") int n2) {
            IOURing.nfeatures(this.address(), n2);
            return this;
        }
    }
}

