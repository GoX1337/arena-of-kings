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
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.libffi.FFICIF;

@NativeType(value="struct ffi_closure")
public class FFIClosure
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CIF;
    public static final int FUN;
    public static final int USER_DATA;

    private static native int offsets(long var0);

    public FFIClosure(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), FFIClosure.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="ffi_cif *")
    public FFICIF cif() {
        return FFIClosure.ncif(this.address());
    }

    @NativeType(value="void (*)(ffi_cif*,void*,void**,void*)")
    public long fun() {
        return FFIClosure.nfun(this.address());
    }

    @NativeType(value="void *")
    public long user_data() {
        return FFIClosure.nuser_data(this.address());
    }

    public static FFIClosure malloc() {
        return FFIClosure.wrap(FFIClosure.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static FFIClosure calloc() {
        return FFIClosure.wrap(FFIClosure.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static FFIClosure create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return FFIClosure.wrap(FFIClosure.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static FFIClosure create(long l2) {
        return FFIClosure.wrap(FFIClosure.class, l2);
    }

    @Nullable
    public static FFIClosure createSafe(long l2) {
        return l2 == 0L ? null : FFIClosure.wrap(FFIClosure.class, l2);
    }

    public static Buffer malloc(int n2) {
        return FFIClosure.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(FFIClosure.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return FFIClosure.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = FFIClosure.__create(n2, SIZEOF);
        return FFIClosure.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return FFIClosure.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : FFIClosure.wrap(Buffer.class, l2, n2);
    }

    public static FFIClosure malloc(MemoryStack memoryStack) {
        return FFIClosure.wrap(FFIClosure.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static FFIClosure calloc(MemoryStack memoryStack) {
        return FFIClosure.wrap(FFIClosure.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return FFIClosure.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return FFIClosure.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static FFICIF ncif(long l2) {
        return FFICIF.create(MemoryUtil.memGetAddress(l2 + (long)CIF));
    }

    public static long nfun(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)FUN);
    }

    public static long nuser_data(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)USER_DATA);
    }

    static {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(4);
            SIZEOF = FFIClosure.offsets(MemoryUtil.memAddress(intBuffer));
            CIF = intBuffer.get(0);
            FUN = intBuffer.get(1);
            USER_DATA = intBuffer.get(2);
            ALIGNOF = intBuffer.get(3);
        }
    }

    public static class Buffer
    extends StructBuffer<FFIClosure, Buffer>
    implements NativeResource {
        private static final FFIClosure ELEMENT_FACTORY = FFIClosure.create(-1L);

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
        protected FFIClosure getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="ffi_cif *")
        public FFICIF cif() {
            return FFIClosure.ncif(this.address());
        }

        @NativeType(value="void (*)(ffi_cif*,void*,void**,void*)")
        public long fun() {
            return FFIClosure.nfun(this.address());
        }

        @NativeType(value="void *")
        public long user_data() {
            return FFIClosure.nuser_data(this.address());
        }
    }
}

