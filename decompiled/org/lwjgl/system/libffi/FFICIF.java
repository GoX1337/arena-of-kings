/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.libffi;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.libffi.FFIType;

@NativeType(value="struct ffi_cif")
public class FFICIF
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ABI;
    public static final int NARGS;
    public static final int ARG_TYPES;
    public static final int RTYPE;
    public static final int BYTES;
    public static final int FLAGS;

    private static native int offsets(long var0);

    public FFICIF(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), FFICIF.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="ffi_abi")
    public int abi() {
        return FFICIF.nabi(this.address());
    }

    @NativeType(value="unsigned")
    public int nargs() {
        return FFICIF.nnargs(this.address());
    }

    @NativeType(value="ffi_type **")
    public PointerBuffer arg_types(int n2) {
        return FFICIF.narg_types(this.address(), n2);
    }

    @NativeType(value="ffi_type *")
    public FFIType rtype() {
        return FFICIF.nrtype(this.address());
    }

    @NativeType(value="unsigned")
    public int bytes() {
        return FFICIF.nbytes(this.address());
    }

    @NativeType(value="unsigned")
    public int flags() {
        return FFICIF.nflags(this.address());
    }

    public static FFICIF malloc() {
        return FFICIF.wrap(FFICIF.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static FFICIF calloc() {
        return FFICIF.wrap(FFICIF.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static FFICIF create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return FFICIF.wrap(FFICIF.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static FFICIF create(long l2) {
        return FFICIF.wrap(FFICIF.class, l2);
    }

    @Nullable
    public static FFICIF createSafe(long l2) {
        return l2 == 0L ? null : FFICIF.wrap(FFICIF.class, l2);
    }

    public static Buffer malloc(int n2) {
        return FFICIF.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(FFICIF.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return FFICIF.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = FFICIF.__create(n2, SIZEOF);
        return FFICIF.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return FFICIF.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : FFICIF.wrap(Buffer.class, l2, n2);
    }

    public static FFICIF malloc(MemoryStack memoryStack) {
        return FFICIF.wrap(FFICIF.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static FFICIF calloc(MemoryStack memoryStack) {
        return FFICIF.wrap(FFICIF.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return FFICIF.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return FFICIF.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nabi(long l2) {
        return UNSAFE.getInt(null, l2 + (long)ABI);
    }

    public static int nnargs(long l2) {
        return UNSAFE.getInt(null, l2 + (long)NARGS);
    }

    public static PointerBuffer narg_types(long l2, int n2) {
        return MemoryUtil.memPointerBuffer(MemoryUtil.memGetAddress(l2 + (long)ARG_TYPES), n2);
    }

    public static FFIType nrtype(long l2) {
        return FFIType.create(MemoryUtil.memGetAddress(l2 + (long)RTYPE));
    }

    public static int nbytes(long l2) {
        return UNSAFE.getInt(null, l2 + (long)BYTES);
    }

    public static int nflags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FLAGS);
    }

    static {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(7);
            SIZEOF = FFICIF.offsets(MemoryUtil.memAddress(intBuffer));
            ABI = intBuffer.get(0);
            NARGS = intBuffer.get(1);
            ARG_TYPES = intBuffer.get(2);
            RTYPE = intBuffer.get(3);
            BYTES = intBuffer.get(4);
            FLAGS = intBuffer.get(5);
            ALIGNOF = intBuffer.get(6);
        }
    }

    public static class Buffer
    extends StructBuffer<FFICIF, Buffer>
    implements NativeResource {
        private static final FFICIF ELEMENT_FACTORY = FFICIF.create(-1L);

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
        protected FFICIF getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="ffi_abi")
        public int abi() {
            return FFICIF.nabi(this.address());
        }

        @NativeType(value="unsigned")
        public int nargs() {
            return FFICIF.nnargs(this.address());
        }

        @NativeType(value="ffi_type **")
        public PointerBuffer arg_types(int n2) {
            return FFICIF.narg_types(this.address(), n2);
        }

        @NativeType(value="ffi_type *")
        public FFIType rtype() {
            return FFICIF.nrtype(this.address());
        }

        @NativeType(value="unsigned")
        public int bytes() {
            return FFICIF.nbytes(this.address());
        }

        @NativeType(value="unsigned")
        public int flags() {
            return FFICIF.nflags(this.address());
        }
    }
}

