/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.libffi;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct ffi_type")
public class FFIType
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SIZE;
    public static final int ALIGNMENT;
    public static final int TYPE;
    public static final int ELEMENTS;

    public FFIType(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), FFIType.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="size_t")
    public long size() {
        return FFIType.nsize(this.address());
    }

    @NativeType(value="unsigned short")
    public short alignment() {
        return FFIType.nalignment(this.address());
    }

    @NativeType(value="unsigned short")
    public short type() {
        return FFIType.ntype(this.address());
    }

    @Nullable
    @NativeType(value="ffi_type *")
    public PointerBuffer elements(int n2) {
        return FFIType.nelements(this.address(), n2);
    }

    public FFIType size(@NativeType(value="size_t") long l2) {
        FFIType.nsize(this.address(), l2);
        return this;
    }

    public FFIType alignment(@NativeType(value="unsigned short") short s2) {
        FFIType.nalignment(this.address(), s2);
        return this;
    }

    public FFIType type(@NativeType(value="unsigned short") short s2) {
        FFIType.ntype(this.address(), s2);
        return this;
    }

    public FFIType elements(@Nullable @NativeType(value="ffi_type *") PointerBuffer pointerBuffer) {
        FFIType.nelements(this.address(), pointerBuffer);
        return this;
    }

    public FFIType set(long l2, short s2, short s3, @Nullable PointerBuffer pointerBuffer) {
        this.size(l2);
        this.alignment(s2);
        this.type(s3);
        this.elements(pointerBuffer);
        return this;
    }

    public FFIType set(FFIType fFIType) {
        MemoryUtil.memCopy(fFIType.address(), this.address(), SIZEOF);
        return this;
    }

    public static FFIType malloc() {
        return FFIType.wrap(FFIType.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static FFIType calloc() {
        return FFIType.wrap(FFIType.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static FFIType create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return FFIType.wrap(FFIType.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static FFIType create(long l2) {
        return FFIType.wrap(FFIType.class, l2);
    }

    @Nullable
    public static FFIType createSafe(long l2) {
        return l2 == 0L ? null : FFIType.wrap(FFIType.class, l2);
    }

    public static Buffer malloc(int n2) {
        return FFIType.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(FFIType.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return FFIType.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = FFIType.__create(n2, SIZEOF);
        return FFIType.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return FFIType.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : FFIType.wrap(Buffer.class, l2, n2);
    }

    public static FFIType malloc(MemoryStack memoryStack) {
        return FFIType.wrap(FFIType.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static FFIType calloc(MemoryStack memoryStack) {
        return FFIType.wrap(FFIType.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return FFIType.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return FFIType.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static long nsize(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)SIZE);
    }

    public static short nalignment(long l2) {
        return UNSAFE.getShort(null, l2 + (long)ALIGNMENT);
    }

    public static short ntype(long l2) {
        return UNSAFE.getShort(null, l2 + (long)TYPE);
    }

    @Nullable
    public static PointerBuffer nelements(long l2, int n2) {
        return MemoryUtil.memPointerBufferSafe(MemoryUtil.memGetAddress(l2 + (long)ELEMENTS), n2);
    }

    public static void nsize(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)SIZE, l3);
    }

    public static void nalignment(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)ALIGNMENT, s2);
    }

    public static void ntype(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)TYPE, s2);
    }

    public static void nelements(long l2, @Nullable PointerBuffer pointerBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)ELEMENTS, MemoryUtil.memAddressSafe(pointerBuffer));
    }

    static {
        Struct.Layout layout = FFIType.__struct(FFIType.__member(POINTER_SIZE), FFIType.__member(2), FFIType.__member(2), FFIType.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        SIZE = layout.offsetof(0);
        ALIGNMENT = layout.offsetof(1);
        TYPE = layout.offsetof(2);
        ELEMENTS = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<FFIType, Buffer>
    implements NativeResource {
        private static final FFIType ELEMENT_FACTORY = FFIType.create(-1L);

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
        protected FFIType getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="size_t")
        public long size() {
            return FFIType.nsize(this.address());
        }

        @NativeType(value="unsigned short")
        public short alignment() {
            return FFIType.nalignment(this.address());
        }

        @NativeType(value="unsigned short")
        public short type() {
            return FFIType.ntype(this.address());
        }

        @Nullable
        @NativeType(value="ffi_type *")
        public PointerBuffer elements(int n2) {
            return FFIType.nelements(this.address(), n2);
        }

        public Buffer size(@NativeType(value="size_t") long l2) {
            FFIType.nsize(this.address(), l2);
            return this;
        }

        public Buffer alignment(@NativeType(value="unsigned short") short s2) {
            FFIType.nalignment(this.address(), s2);
            return this;
        }

        public Buffer type(@NativeType(value="unsigned short") short s2) {
            FFIType.ntype(this.address(), s2);
            return this;
        }

        public Buffer elements(@Nullable @NativeType(value="ffi_type *") PointerBuffer pointerBuffer) {
            FFIType.nelements(this.address(), pointerBuffer);
            return this;
        }
    }
}

