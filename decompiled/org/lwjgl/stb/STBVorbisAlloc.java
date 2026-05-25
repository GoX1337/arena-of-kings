/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.stb;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct stb_vorbis_alloc")
public class STBVorbisAlloc
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ALLOC_BUFFER;
    public static final int ALLOC_BUFFER_LENGTH_IN_BYTES;

    public STBVorbisAlloc(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBVorbisAlloc.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char *")
    public ByteBuffer alloc_buffer() {
        return STBVorbisAlloc.nalloc_buffer(this.address());
    }

    public int alloc_buffer_length_in_bytes() {
        return STBVorbisAlloc.nalloc_buffer_length_in_bytes(this.address());
    }

    public STBVorbisAlloc alloc_buffer(@NativeType(value="char *") ByteBuffer byteBuffer) {
        STBVorbisAlloc.nalloc_buffer(this.address(), byteBuffer);
        return this;
    }

    public STBVorbisAlloc set(STBVorbisAlloc sTBVorbisAlloc) {
        MemoryUtil.memCopy(sTBVorbisAlloc.address(), this.address(), SIZEOF);
        return this;
    }

    public static STBVorbisAlloc malloc() {
        return STBVorbisAlloc.wrap(STBVorbisAlloc.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBVorbisAlloc calloc() {
        return STBVorbisAlloc.wrap(STBVorbisAlloc.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBVorbisAlloc create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBVorbisAlloc.wrap(STBVorbisAlloc.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBVorbisAlloc create(long l2) {
        return STBVorbisAlloc.wrap(STBVorbisAlloc.class, l2);
    }

    @Nullable
    public static STBVorbisAlloc createSafe(long l2) {
        return l2 == 0L ? null : STBVorbisAlloc.wrap(STBVorbisAlloc.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBVorbisAlloc.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBVorbisAlloc.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBVorbisAlloc.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBVorbisAlloc.__create(n2, SIZEOF);
        return STBVorbisAlloc.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBVorbisAlloc.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBVorbisAlloc.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static STBVorbisAlloc mallocStack() {
        return STBVorbisAlloc.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBVorbisAlloc callocStack() {
        return STBVorbisAlloc.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBVorbisAlloc mallocStack(MemoryStack memoryStack) {
        return STBVorbisAlloc.malloc(memoryStack);
    }

    @Deprecated
    public static STBVorbisAlloc callocStack(MemoryStack memoryStack) {
        return STBVorbisAlloc.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return STBVorbisAlloc.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return STBVorbisAlloc.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return STBVorbisAlloc.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return STBVorbisAlloc.calloc(n2, memoryStack);
    }

    public static STBVorbisAlloc malloc(MemoryStack memoryStack) {
        return STBVorbisAlloc.wrap(STBVorbisAlloc.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBVorbisAlloc calloc(MemoryStack memoryStack) {
        return STBVorbisAlloc.wrap(STBVorbisAlloc.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBVorbisAlloc.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBVorbisAlloc.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static ByteBuffer nalloc_buffer(long l2) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l2 + (long)ALLOC_BUFFER), STBVorbisAlloc.nalloc_buffer_length_in_bytes(l2));
    }

    public static int nalloc_buffer_length_in_bytes(long l2) {
        return UNSAFE.getInt(null, l2 + (long)ALLOC_BUFFER_LENGTH_IN_BYTES);
    }

    public static void nalloc_buffer(long l2, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)ALLOC_BUFFER, MemoryUtil.memAddress(byteBuffer));
        STBVorbisAlloc.nalloc_buffer_length_in_bytes(l2, byteBuffer.remaining());
    }

    public static void nalloc_buffer_length_in_bytes(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)ALLOC_BUFFER_LENGTH_IN_BYTES, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)ALLOC_BUFFER));
    }

    static {
        Struct.Layout layout = STBVorbisAlloc.__struct(STBVorbisAlloc.__member(POINTER_SIZE), STBVorbisAlloc.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        ALLOC_BUFFER = layout.offsetof(0);
        ALLOC_BUFFER_LENGTH_IN_BYTES = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<STBVorbisAlloc, Buffer>
    implements NativeResource {
        private static final STBVorbisAlloc ELEMENT_FACTORY = STBVorbisAlloc.create(-1L);

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
        protected STBVorbisAlloc getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char *")
        public ByteBuffer alloc_buffer() {
            return STBVorbisAlloc.nalloc_buffer(this.address());
        }

        public int alloc_buffer_length_in_bytes() {
            return STBVorbisAlloc.nalloc_buffer_length_in_bytes(this.address());
        }

        public Buffer alloc_buffer(@NativeType(value="char *") ByteBuffer byteBuffer) {
            STBVorbisAlloc.nalloc_buffer(this.address(), byteBuffer);
            return this;
        }
    }
}

