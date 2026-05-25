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
import org.lwjgl.system.linux.liburing.IOURingCQE;

@NativeType(value="struct io_uring_cq")
public class IOURingCQ
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int KHEAD;
    public static final int KTAIL;
    public static final int KRING_MASK;
    public static final int KRING_ENTRIES;
    public static final int KFLAGS;
    public static final int KOVERFLOW;
    public static final int CQES;
    public static final int RING_SZ;
    public static final int RING_PTR;
    public static final int PAD;

    public IOURingCQ(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingCQ.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned *")
    public IntBuffer khead(int n2) {
        return IOURingCQ.nkhead(this.address(), n2);
    }

    @NativeType(value="unsigned *")
    public IntBuffer ktail(int n2) {
        return IOURingCQ.nktail(this.address(), n2);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kring_mask(int n2) {
        return IOURingCQ.nkring_mask(this.address(), n2);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kring_entries(int n2) {
        return IOURingCQ.nkring_entries(this.address(), n2);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kflags(int n2) {
        return IOURingCQ.nkflags(this.address(), n2);
    }

    @NativeType(value="unsigned *")
    public IntBuffer koverflow(int n2) {
        return IOURingCQ.nkoverflow(this.address(), n2);
    }

    @NativeType(value="struct io_uring_cqe *")
    public IOURingCQE cqes() {
        return IOURingCQ.ncqes(this.address());
    }

    @NativeType(value="size_t")
    public long ring_sz() {
        return IOURingCQ.nring_sz(this.address());
    }

    @NativeType(value="void *")
    public ByteBuffer ring_ptr() {
        return IOURingCQ.nring_ptr(this.address());
    }

    public IOURingCQ khead(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingCQ.nkhead(this.address(), intBuffer);
        return this;
    }

    public IOURingCQ ktail(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingCQ.nktail(this.address(), intBuffer);
        return this;
    }

    public IOURingCQ kring_mask(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingCQ.nkring_mask(this.address(), intBuffer);
        return this;
    }

    public IOURingCQ kring_entries(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingCQ.nkring_entries(this.address(), intBuffer);
        return this;
    }

    public IOURingCQ kflags(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingCQ.nkflags(this.address(), intBuffer);
        return this;
    }

    public IOURingCQ koverflow(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingCQ.nkoverflow(this.address(), intBuffer);
        return this;
    }

    public IOURingCQ cqes(@NativeType(value="struct io_uring_cqe *") IOURingCQE iOURingCQE) {
        IOURingCQ.ncqes(this.address(), iOURingCQE);
        return this;
    }

    public IOURingCQ ring_ptr(@NativeType(value="void *") ByteBuffer byteBuffer) {
        IOURingCQ.nring_ptr(this.address(), byteBuffer);
        return this;
    }

    public IOURingCQ set(IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, IntBuffer intBuffer4, IntBuffer intBuffer5, IntBuffer intBuffer6, IOURingCQE iOURingCQE, ByteBuffer byteBuffer) {
        this.khead(intBuffer);
        this.ktail(intBuffer2);
        this.kring_mask(intBuffer3);
        this.kring_entries(intBuffer4);
        this.kflags(intBuffer5);
        this.koverflow(intBuffer6);
        this.cqes(iOURingCQE);
        this.ring_ptr(byteBuffer);
        return this;
    }

    public IOURingCQ set(IOURingCQ iOURingCQ) {
        MemoryUtil.memCopy(iOURingCQ.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingCQ malloc() {
        return IOURingCQ.wrap(IOURingCQ.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURingCQ calloc() {
        return IOURingCQ.wrap(IOURingCQ.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURingCQ create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURingCQ.wrap(IOURingCQ.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingCQ create(long l2) {
        return IOURingCQ.wrap(IOURingCQ.class, l2);
    }

    @Nullable
    public static IOURingCQ createSafe(long l2) {
        return l2 == 0L ? null : IOURingCQ.wrap(IOURingCQ.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURingCQ.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURingCQ.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURingCQ.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURingCQ.__create(n2, SIZEOF);
        return IOURingCQ.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURingCQ.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURingCQ.wrap(Buffer.class, l2, n2);
    }

    public static IOURingCQ malloc(MemoryStack memoryStack) {
        return IOURingCQ.wrap(IOURingCQ.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURingCQ calloc(MemoryStack memoryStack) {
        return IOURingCQ.wrap(IOURingCQ.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURingCQ.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURingCQ.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static IntBuffer nkoverflow(long l2, int n2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l2 + (long)KOVERFLOW), n2);
    }

    public static IOURingCQE ncqes(long l2) {
        return IOURingCQE.create(MemoryUtil.memGetAddress(l2 + (long)CQES));
    }

    public static long nring_sz(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)RING_SZ);
    }

    public static ByteBuffer nring_ptr(long l2) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l2 + (long)RING_PTR), (int)IOURingCQ.nring_sz(l2));
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

    public static void nkoverflow(long l2, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)KOVERFLOW, MemoryUtil.memAddress(intBuffer));
    }

    public static void ncqes(long l2, IOURingCQE iOURingCQE) {
        MemoryUtil.memPutAddress(l2 + (long)CQES, iOURingCQE.address());
    }

    public static void nring_sz(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)RING_SZ, l3);
    }

    public static void nring_ptr(long l2, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)RING_PTR, MemoryUtil.memAddress(byteBuffer));
        IOURingCQ.nring_sz(l2, byteBuffer.remaining());
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
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)KOVERFLOW));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)CQES));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)RING_PTR));
    }

    static {
        Struct.Layout layout = IOURingCQ.__struct(IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__array(4, 4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        KHEAD = layout.offsetof(0);
        KTAIL = layout.offsetof(1);
        KRING_MASK = layout.offsetof(2);
        KRING_ENTRIES = layout.offsetof(3);
        KFLAGS = layout.offsetof(4);
        KOVERFLOW = layout.offsetof(5);
        CQES = layout.offsetof(6);
        RING_SZ = layout.offsetof(7);
        RING_PTR = layout.offsetof(8);
        PAD = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<IOURingCQ, Buffer>
    implements NativeResource {
        private static final IOURingCQ ELEMENT_FACTORY = IOURingCQ.create(-1L);

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
        protected IOURingCQ getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned *")
        public IntBuffer khead(int n2) {
            return IOURingCQ.nkhead(this.address(), n2);
        }

        @NativeType(value="unsigned *")
        public IntBuffer ktail(int n2) {
            return IOURingCQ.nktail(this.address(), n2);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kring_mask(int n2) {
            return IOURingCQ.nkring_mask(this.address(), n2);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kring_entries(int n2) {
            return IOURingCQ.nkring_entries(this.address(), n2);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kflags(int n2) {
            return IOURingCQ.nkflags(this.address(), n2);
        }

        @NativeType(value="unsigned *")
        public IntBuffer koverflow(int n2) {
            return IOURingCQ.nkoverflow(this.address(), n2);
        }

        @NativeType(value="struct io_uring_cqe *")
        public IOURingCQE cqes() {
            return IOURingCQ.ncqes(this.address());
        }

        @NativeType(value="size_t")
        public long ring_sz() {
            return IOURingCQ.nring_sz(this.address());
        }

        @NativeType(value="void *")
        public ByteBuffer ring_ptr() {
            return IOURingCQ.nring_ptr(this.address());
        }

        public Buffer khead(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingCQ.nkhead(this.address(), intBuffer);
            return this;
        }

        public Buffer ktail(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingCQ.nktail(this.address(), intBuffer);
            return this;
        }

        public Buffer kring_mask(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingCQ.nkring_mask(this.address(), intBuffer);
            return this;
        }

        public Buffer kring_entries(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingCQ.nkring_entries(this.address(), intBuffer);
            return this;
        }

        public Buffer kflags(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingCQ.nkflags(this.address(), intBuffer);
            return this;
        }

        public Buffer koverflow(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingCQ.nkoverflow(this.address(), intBuffer);
            return this;
        }

        public Buffer cqes(@NativeType(value="struct io_uring_cqe *") IOURingCQE iOURingCQE) {
            IOURingCQ.ncqes(this.address(), iOURingCQE);
            return this;
        }

        public Buffer ring_ptr(@NativeType(value="void *") ByteBuffer byteBuffer) {
            IOURingCQ.nring_ptr(this.address(), byteBuffer);
            return this;
        }
    }
}

