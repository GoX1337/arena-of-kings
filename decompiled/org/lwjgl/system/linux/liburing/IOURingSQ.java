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
import org.lwjgl.system.linux.liburing.IOURingSQE;

@NativeType(value="struct io_uring_sq")
public class IOURingSQ
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int KHEAD;
    public static final int KTAIL;
    public static final int KRING_MASK;
    public static final int KRING_ENTRIES;
    public static final int KFLAGS;
    public static final int KDROPPED;
    public static final int ARRAY;
    public static final int SQES;
    public static final int SQE_HEAD;
    public static final int SQE_TAIL;
    public static final int RING_SZ;
    public static final int RING_PTR;
    public static final int PAD;

    public IOURingSQ(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingSQ.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned *")
    public IntBuffer khead(int n2) {
        return IOURingSQ.nkhead(this.address(), n2);
    }

    @NativeType(value="unsigned *")
    public IntBuffer ktail(int n2) {
        return IOURingSQ.nktail(this.address(), n2);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kring_mask(int n2) {
        return IOURingSQ.nkring_mask(this.address(), n2);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kring_entries(int n2) {
        return IOURingSQ.nkring_entries(this.address(), n2);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kflags(int n2) {
        return IOURingSQ.nkflags(this.address(), n2);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kdropped(int n2) {
        return IOURingSQ.nkdropped(this.address(), n2);
    }

    @NativeType(value="unsigned *")
    public IntBuffer array(int n2) {
        return IOURingSQ.narray(this.address(), n2);
    }

    @NativeType(value="struct io_uring_sqe *")
    public IOURingSQE sqes() {
        return IOURingSQ.nsqes(this.address());
    }

    @NativeType(value="unsigned")
    public int sqe_head() {
        return IOURingSQ.nsqe_head(this.address());
    }

    @NativeType(value="unsigned")
    public int sqe_tail() {
        return IOURingSQ.nsqe_tail(this.address());
    }

    @NativeType(value="size_t")
    public long ring_sz() {
        return IOURingSQ.nring_sz(this.address());
    }

    @NativeType(value="void *")
    public ByteBuffer ring_ptr() {
        return IOURingSQ.nring_ptr(this.address());
    }

    public IOURingSQ khead(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.nkhead(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ ktail(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.nktail(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ kring_mask(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.nkring_mask(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ kring_entries(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.nkring_entries(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ kflags(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.nkflags(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ kdropped(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.nkdropped(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ array(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.narray(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ sqes(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE) {
        IOURingSQ.nsqes(this.address(), iOURingSQE);
        return this;
    }

    public IOURingSQ sqe_head(@NativeType(value="unsigned") int n2) {
        IOURingSQ.nsqe_head(this.address(), n2);
        return this;
    }

    public IOURingSQ sqe_tail(@NativeType(value="unsigned") int n2) {
        IOURingSQ.nsqe_tail(this.address(), n2);
        return this;
    }

    public IOURingSQ ring_ptr(@NativeType(value="void *") ByteBuffer byteBuffer) {
        IOURingSQ.nring_ptr(this.address(), byteBuffer);
        return this;
    }

    public IOURingSQ set(IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, IntBuffer intBuffer4, IntBuffer intBuffer5, IntBuffer intBuffer6, IntBuffer intBuffer7, IOURingSQE iOURingSQE, int n2, int n3, ByteBuffer byteBuffer) {
        this.khead(intBuffer);
        this.ktail(intBuffer2);
        this.kring_mask(intBuffer3);
        this.kring_entries(intBuffer4);
        this.kflags(intBuffer5);
        this.kdropped(intBuffer6);
        this.array(intBuffer7);
        this.sqes(iOURingSQE);
        this.sqe_head(n2);
        this.sqe_tail(n3);
        this.ring_ptr(byteBuffer);
        return this;
    }

    public IOURingSQ set(IOURingSQ iOURingSQ) {
        MemoryUtil.memCopy(iOURingSQ.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingSQ malloc() {
        return IOURingSQ.wrap(IOURingSQ.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURingSQ calloc() {
        return IOURingSQ.wrap(IOURingSQ.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURingSQ create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURingSQ.wrap(IOURingSQ.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingSQ create(long l2) {
        return IOURingSQ.wrap(IOURingSQ.class, l2);
    }

    @Nullable
    public static IOURingSQ createSafe(long l2) {
        return l2 == 0L ? null : IOURingSQ.wrap(IOURingSQ.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURingSQ.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURingSQ.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURingSQ.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURingSQ.__create(n2, SIZEOF);
        return IOURingSQ.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURingSQ.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURingSQ.wrap(Buffer.class, l2, n2);
    }

    public static IOURingSQ malloc(MemoryStack memoryStack) {
        return IOURingSQ.wrap(IOURingSQ.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURingSQ calloc(MemoryStack memoryStack) {
        return IOURingSQ.wrap(IOURingSQ.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURingSQ.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURingSQ.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static IntBuffer nkhead(long l2, int n2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l2 + (long)KHEAD), n2);
    }

    public static IntBuffer nktail(long l2, int n2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l2 + (long)KTAIL), n2);
    }

    public static IntBuffer nkring_mask(long l2, int n2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l2 + (long)KRING_MASK), n2);
    }

    public static IntBuffer nkring_entries(long l2, int n2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l2 + (long)KRING_ENTRIES), n2);
    }

    public static IntBuffer nkflags(long l2, int n2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l2 + (long)KFLAGS), n2);
    }

    public static IntBuffer nkdropped(long l2, int n2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l2 + (long)KDROPPED), n2);
    }

    public static IntBuffer narray(long l2, int n2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l2 + (long)ARRAY), n2);
    }

    public static IOURingSQE nsqes(long l2) {
        return IOURingSQE.create(MemoryUtil.memGetAddress(l2 + (long)SQES));
    }

    public static int nsqe_head(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SQE_HEAD);
    }

    public static int nsqe_tail(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SQE_TAIL);
    }

    public static long nring_sz(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)RING_SZ);
    }

    public static ByteBuffer nring_ptr(long l2) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l2 + (long)RING_PTR), (int)IOURingSQ.nring_sz(l2));
    }

    public static IntBuffer npad(long l2) {
        return MemoryUtil.memIntBuffer(l2 + (long)PAD, 4);
    }

    public static int npad(long l2, int n2) {
        return UNSAFE.getInt(null, l2 + (long)PAD + Checks.check(n2, 4) * 4L);
    }

    public static void nkhead(long l2, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)KHEAD, MemoryUtil.memAddress(intBuffer));
    }

    public static void nktail(long l2, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)KTAIL, MemoryUtil.memAddress(intBuffer));
    }

    public static void nkring_mask(long l2, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)KRING_MASK, MemoryUtil.memAddress(intBuffer));
    }

    public static void nkring_entries(long l2, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)KRING_ENTRIES, MemoryUtil.memAddress(intBuffer));
    }

    public static void nkflags(long l2, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)KFLAGS, MemoryUtil.memAddress(intBuffer));
    }

    public static void nkdropped(long l2, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)KDROPPED, MemoryUtil.memAddress(intBuffer));
    }

    public static void narray(long l2, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)ARRAY, MemoryUtil.memAddress(intBuffer));
    }

    public static void nsqes(long l2, IOURingSQE iOURingSQE) {
        MemoryUtil.memPutAddress(l2 + (long)SQES, iOURingSQE.address());
    }

    public static void nsqe_head(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SQE_HEAD, n2);
    }

    public static void nsqe_tail(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SQE_TAIL, n2);
    }

    public static void nring_sz(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)RING_SZ, l3);
    }

    public static void nring_ptr(long l2, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)RING_PTR, MemoryUtil.memAddress(byteBuffer));
        IOURingSQ.nring_sz(l2, byteBuffer.remaining());
    }

    public static void npad(long l2, IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(intBuffer, 4);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), l2 + (long)PAD, intBuffer.remaining() * 4);
    }

    public static void npad(long l2, int n2, int n3) {
        UNSAFE.putInt(null, l2 + (long)PAD + Checks.check(n2, 4) * 4L, n3);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)KHEAD));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)KTAIL));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)KRING_MASK));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)KRING_ENTRIES));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)KFLAGS));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)KDROPPED));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)ARRAY));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)SQES));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)RING_PTR));
    }

    static {
        Struct.Layout layout = IOURingSQ.__struct(IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(4), IOURingSQ.__member(4), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__array(4, 4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        KHEAD = layout.offsetof(0);
        KTAIL = layout.offsetof(1);
        KRING_MASK = layout.offsetof(2);
        KRING_ENTRIES = layout.offsetof(3);
        KFLAGS = layout.offsetof(4);
        KDROPPED = layout.offsetof(5);
        ARRAY = layout.offsetof(6);
        SQES = layout.offsetof(7);
        SQE_HEAD = layout.offsetof(8);
        SQE_TAIL = layout.offsetof(9);
        RING_SZ = layout.offsetof(10);
        RING_PTR = layout.offsetof(11);
        PAD = layout.offsetof(12);
    }

    public static class Buffer
    extends StructBuffer<IOURingSQ, Buffer>
    implements NativeResource {
        private static final IOURingSQ ELEMENT_FACTORY = IOURingSQ.create(-1L);

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
        protected IOURingSQ getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned *")
        public IntBuffer khead(int n2) {
            return IOURingSQ.nkhead(this.address(), n2);
        }

        @NativeType(value="unsigned *")
        public IntBuffer ktail(int n2) {
            return IOURingSQ.nktail(this.address(), n2);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kring_mask(int n2) {
            return IOURingSQ.nkring_mask(this.address(), n2);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kring_entries(int n2) {
            return IOURingSQ.nkring_entries(this.address(), n2);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kflags(int n2) {
            return IOURingSQ.nkflags(this.address(), n2);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kdropped(int n2) {
            return IOURingSQ.nkdropped(this.address(), n2);
        }

        @NativeType(value="unsigned *")
        public IntBuffer array(int n2) {
            return IOURingSQ.narray(this.address(), n2);
        }

        @NativeType(value="struct io_uring_sqe *")
        public IOURingSQE sqes() {
            return IOURingSQ.nsqes(this.address());
        }

        @NativeType(value="unsigned")
        public int sqe_head() {
            return IOURingSQ.nsqe_head(this.address());
        }

        @NativeType(value="unsigned")
        public int sqe_tail() {
            return IOURingSQ.nsqe_tail(this.address());
        }

        @NativeType(value="size_t")
        public long ring_sz() {
            return IOURingSQ.nring_sz(this.address());
        }

        @NativeType(value="void *")
        public ByteBuffer ring_ptr() {
            return IOURingSQ.nring_ptr(this.address());
        }

        public Buffer khead(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.nkhead(this.address(), intBuffer);
            return this;
        }

        public Buffer ktail(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.nktail(this.address(), intBuffer);
            return this;
        }

        public Buffer kring_mask(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.nkring_mask(this.address(), intBuffer);
            return this;
        }

        public Buffer kring_entries(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.nkring_entries(this.address(), intBuffer);
            return this;
        }

        public Buffer kflags(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.nkflags(this.address(), intBuffer);
            return this;
        }

        public Buffer kdropped(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.nkdropped(this.address(), intBuffer);
            return this;
        }

        public Buffer array(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.narray(this.address(), intBuffer);
            return this;
        }

        public Buffer sqes(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE) {
            IOURingSQ.nsqes(this.address(), iOURingSQE);
            return this;
        }

        public Buffer sqe_head(@NativeType(value="unsigned") int n2) {
            IOURingSQ.nsqe_head(this.address(), n2);
            return this;
        }

        public Buffer sqe_tail(@NativeType(value="unsigned") int n2) {
            IOURingSQ.nsqe_tail(this.address(), n2);
            return this;
        }

        public Buffer ring_ptr(@NativeType(value="void *") ByteBuffer byteBuffer) {
            IOURingSQ.nring_ptr(this.address(), byteBuffer);
            return this;
        }
    }
}

