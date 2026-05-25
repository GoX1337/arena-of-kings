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
import org.lwjgl.system.linux.liburing.IOCQRingOffsets;
import org.lwjgl.system.linux.liburing.IOSQRingOffsets;

@NativeType(value="struct io_uring_params")
public class IOURingParams
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SQ_ENTRIES;
    public static final int CQ_ENTRIES;
    public static final int FLAGS;
    public static final int SQ_THREAD_CPU;
    public static final int SQ_THREAD_IDLE;
    public static final int FEATURES;
    public static final int WQ_FD;
    public static final int RESV;
    public static final int SQ_OFF;
    public static final int CQ_OFF;

    public IOURingParams(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingParams.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int sq_entries() {
        return IOURingParams.nsq_entries(this.address());
    }

    @NativeType(value="__u32")
    public int cq_entries() {
        return IOURingParams.ncq_entries(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingParams.nflags(this.address());
    }

    @NativeType(value="__u32")
    public int sq_thread_cpu() {
        return IOURingParams.nsq_thread_cpu(this.address());
    }

    @NativeType(value="__u32")
    public int sq_thread_idle() {
        return IOURingParams.nsq_thread_idle(this.address());
    }

    @NativeType(value="__u32")
    public int features() {
        return IOURingParams.nfeatures(this.address());
    }

    @NativeType(value="__u32")
    public int wq_fd() {
        return IOURingParams.nwq_fd(this.address());
    }

    @NativeType(value="__u32[3]")
    public IntBuffer resv() {
        return IOURingParams.nresv(this.address());
    }

    @NativeType(value="__u32")
    public int resv(int n2) {
        return IOURingParams.nresv(this.address(), n2);
    }

    @NativeType(value="struct io_sqring_offsets")
    public IOSQRingOffsets sq_off() {
        return IOURingParams.nsq_off(this.address());
    }

    @NativeType(value="struct io_cqring_offsets")
    public IOCQRingOffsets cq_off() {
        return IOURingParams.ncq_off(this.address());
    }

    public IOURingParams sq_entries(@NativeType(value="__u32") int n2) {
        IOURingParams.nsq_entries(this.address(), n2);
        return this;
    }

    public IOURingParams cq_entries(@NativeType(value="__u32") int n2) {
        IOURingParams.ncq_entries(this.address(), n2);
        return this;
    }

    public IOURingParams flags(@NativeType(value="__u32") int n2) {
        IOURingParams.nflags(this.address(), n2);
        return this;
    }

    public IOURingParams sq_thread_cpu(@NativeType(value="__u32") int n2) {
        IOURingParams.nsq_thread_cpu(this.address(), n2);
        return this;
    }

    public IOURingParams sq_thread_idle(@NativeType(value="__u32") int n2) {
        IOURingParams.nsq_thread_idle(this.address(), n2);
        return this;
    }

    public IOURingParams features(@NativeType(value="__u32") int n2) {
        IOURingParams.nfeatures(this.address(), n2);
        return this;
    }

    public IOURingParams wq_fd(@NativeType(value="__u32") int n2) {
        IOURingParams.nwq_fd(this.address(), n2);
        return this;
    }

    public IOURingParams resv(@NativeType(value="__u32[3]") IntBuffer intBuffer) {
        IOURingParams.nresv(this.address(), intBuffer);
        return this;
    }

    public IOURingParams resv(int n2, @NativeType(value="__u32") int n3) {
        IOURingParams.nresv(this.address(), n2, n3);
        return this;
    }

    public IOURingParams sq_off(@NativeType(value="struct io_sqring_offsets") IOSQRingOffsets iOSQRingOffsets) {
        IOURingParams.nsq_off(this.address(), iOSQRingOffsets);
        return this;
    }

    public IOURingParams sq_off(Consumer<IOSQRingOffsets> consumer) {
        consumer.accept(this.sq_off());
        return this;
    }

    public IOURingParams cq_off(@NativeType(value="struct io_cqring_offsets") IOCQRingOffsets iOCQRingOffsets) {
        IOURingParams.ncq_off(this.address(), iOCQRingOffsets);
        return this;
    }

    public IOURingParams cq_off(Consumer<IOCQRingOffsets> consumer) {
        consumer.accept(this.cq_off());
        return this;
    }

    public IOURingParams set(int n2, int n3, int n4, int n5, int n6, int n7, int n8, IntBuffer intBuffer, IOSQRingOffsets iOSQRingOffsets, IOCQRingOffsets iOCQRingOffsets) {
        this.sq_entries(n2);
        this.cq_entries(n3);
        this.flags(n4);
        this.sq_thread_cpu(n5);
        this.sq_thread_idle(n6);
        this.features(n7);
        this.wq_fd(n8);
        this.resv(intBuffer);
        this.sq_off(iOSQRingOffsets);
        this.cq_off(iOCQRingOffsets);
        return this;
    }

    public IOURingParams set(IOURingParams iOURingParams) {
        MemoryUtil.memCopy(iOURingParams.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingParams malloc() {
        return IOURingParams.wrap(IOURingParams.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURingParams calloc() {
        return IOURingParams.wrap(IOURingParams.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURingParams create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURingParams.wrap(IOURingParams.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingParams create(long l2) {
        return IOURingParams.wrap(IOURingParams.class, l2);
    }

    @Nullable
    public static IOURingParams createSafe(long l2) {
        return l2 == 0L ? null : IOURingParams.wrap(IOURingParams.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURingParams.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURingParams.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURingParams.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURingParams.__create(n2, SIZEOF);
        return IOURingParams.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURingParams.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURingParams.wrap(Buffer.class, l2, n2);
    }

    public static IOURingParams malloc(MemoryStack memoryStack) {
        return IOURingParams.wrap(IOURingParams.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURingParams calloc(MemoryStack memoryStack) {
        return IOURingParams.wrap(IOURingParams.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURingParams.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURingParams.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nsq_entries(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SQ_ENTRIES);
    }

    public static int ncq_entries(long l2) {
        return UNSAFE.getInt(null, l2 + (long)CQ_ENTRIES);
    }

    public static int nflags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FLAGS);
    }

    public static int nsq_thread_cpu(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SQ_THREAD_CPU);
    }

    public static int nsq_thread_idle(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SQ_THREAD_IDLE);
    }

    public static int nfeatures(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FEATURES);
    }

    public static int nwq_fd(long l2) {
        return UNSAFE.getInt(null, l2 + (long)WQ_FD);
    }

    public static IntBuffer nresv(long l2) {
        return MemoryUtil.memIntBuffer(l2 + (long)RESV, 3);
    }

    public static int nresv(long l2, int n2) {
        return UNSAFE.getInt(null, l2 + (long)RESV + Checks.check(n2, 3) * 4L);
    }

    public static IOSQRingOffsets nsq_off(long l2) {
        return IOSQRingOffsets.create(l2 + (long)SQ_OFF);
    }

    public static IOCQRingOffsets ncq_off(long l2) {
        return IOCQRingOffsets.create(l2 + (long)CQ_OFF);
    }

    public static void nsq_entries(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SQ_ENTRIES, n2);
    }

    public static void ncq_entries(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)CQ_ENTRIES, n2);
    }

    public static void nflags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FLAGS, n2);
    }

    public static void nsq_thread_cpu(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SQ_THREAD_CPU, n2);
    }

    public static void nsq_thread_idle(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SQ_THREAD_IDLE, n2);
    }

    public static void nfeatures(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FEATURES, n2);
    }

    public static void nwq_fd(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)WQ_FD, n2);
    }

    public static void nresv(long l2, IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(intBuffer, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), l2 + (long)RESV, intBuffer.remaining() * 4);
    }

    public static void nresv(long l2, int n2, int n3) {
        UNSAFE.putInt(null, l2 + (long)RESV + Checks.check(n2, 3) * 4L, n3);
    }

    public static void nsq_off(long l2, IOSQRingOffsets iOSQRingOffsets) {
        MemoryUtil.memCopy(iOSQRingOffsets.address(), l2 + (long)SQ_OFF, IOSQRingOffsets.SIZEOF);
    }

    public static void ncq_off(long l2, IOCQRingOffsets iOCQRingOffsets) {
        MemoryUtil.memCopy(iOCQRingOffsets.address(), l2 + (long)CQ_OFF, IOCQRingOffsets.SIZEOF);
    }

    static {
        Struct.Layout layout = IOURingParams.__struct(IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__array(4, 3), IOURingParams.__member(IOSQRingOffsets.SIZEOF, IOSQRingOffsets.ALIGNOF), IOURingParams.__member(IOCQRingOffsets.SIZEOF, IOCQRingOffsets.ALIGNOF));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        SQ_ENTRIES = layout.offsetof(0);
        CQ_ENTRIES = layout.offsetof(1);
        FLAGS = layout.offsetof(2);
        SQ_THREAD_CPU = layout.offsetof(3);
        SQ_THREAD_IDLE = layout.offsetof(4);
        FEATURES = layout.offsetof(5);
        WQ_FD = layout.offsetof(6);
        RESV = layout.offsetof(7);
        SQ_OFF = layout.offsetof(8);
        CQ_OFF = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<IOURingParams, Buffer>
    implements NativeResource {
        private static final IOURingParams ELEMENT_FACTORY = IOURingParams.create(-1L);

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
        protected IOURingParams getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int sq_entries() {
            return IOURingParams.nsq_entries(this.address());
        }

        @NativeType(value="__u32")
        public int cq_entries() {
            return IOURingParams.ncq_entries(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingParams.nflags(this.address());
        }

        @NativeType(value="__u32")
        public int sq_thread_cpu() {
            return IOURingParams.nsq_thread_cpu(this.address());
        }

        @NativeType(value="__u32")
        public int sq_thread_idle() {
            return IOURingParams.nsq_thread_idle(this.address());
        }

        @NativeType(value="__u32")
        public int features() {
            return IOURingParams.nfeatures(this.address());
        }

        @NativeType(value="__u32")
        public int wq_fd() {
            return IOURingParams.nwq_fd(this.address());
        }

        @NativeType(value="__u32[3]")
        public IntBuffer resv() {
            return IOURingParams.nresv(this.address());
        }

        @NativeType(value="__u32")
        public int resv(int n2) {
            return IOURingParams.nresv(this.address(), n2);
        }

        @NativeType(value="struct io_sqring_offsets")
        public IOSQRingOffsets sq_off() {
            return IOURingParams.nsq_off(this.address());
        }

        @NativeType(value="struct io_cqring_offsets")
        public IOCQRingOffsets cq_off() {
            return IOURingParams.ncq_off(this.address());
        }

        public Buffer sq_entries(@NativeType(value="__u32") int n2) {
            IOURingParams.nsq_entries(this.address(), n2);
            return this;
        }

        public Buffer cq_entries(@NativeType(value="__u32") int n2) {
            IOURingParams.ncq_entries(this.address(), n2);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int n2) {
            IOURingParams.nflags(this.address(), n2);
            return this;
        }

        public Buffer sq_thread_cpu(@NativeType(value="__u32") int n2) {
            IOURingParams.nsq_thread_cpu(this.address(), n2);
            return this;
        }

        public Buffer sq_thread_idle(@NativeType(value="__u32") int n2) {
            IOURingParams.nsq_thread_idle(this.address(), n2);
            return this;
        }

        public Buffer features(@NativeType(value="__u32") int n2) {
            IOURingParams.nfeatures(this.address(), n2);
            return this;
        }

        public Buffer wq_fd(@NativeType(value="__u32") int n2) {
            IOURingParams.nwq_fd(this.address(), n2);
            return this;
        }

        public Buffer resv(@NativeType(value="__u32[3]") IntBuffer intBuffer) {
            IOURingParams.nresv(this.address(), intBuffer);
            return this;
        }

        public Buffer resv(int n2, @NativeType(value="__u32") int n3) {
            IOURingParams.nresv(this.address(), n2, n3);
            return this;
        }

        public Buffer sq_off(@NativeType(value="struct io_sqring_offsets") IOSQRingOffsets iOSQRingOffsets) {
            IOURingParams.nsq_off(this.address(), iOSQRingOffsets);
            return this;
        }

        public Buffer sq_off(Consumer<IOSQRingOffsets> consumer) {
            consumer.accept(this.sq_off());
            return this;
        }

        public Buffer cq_off(@NativeType(value="struct io_cqring_offsets") IOCQRingOffsets iOCQRingOffsets) {
            IOURingParams.ncq_off(this.address(), iOCQRingOffsets);
            return this;
        }

        public Buffer cq_off(Consumer<IOCQRingOffsets> consumer) {
            consumer.accept(this.cq_off());
            return this;
        }
    }
}

