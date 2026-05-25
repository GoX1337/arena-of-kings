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
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct stb_vorbis_comment")
public class STBVorbisComment
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int VENDOR;
    public static final int COMMENT_LIST_LENGTH;
    public static final int COMMENT_LIST;

    public STBVorbisComment(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBVorbisComment.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char *")
    public ByteBuffer vendor() {
        return STBVorbisComment.nvendor(this.address());
    }

    @NativeType(value="char *")
    public String vendorString() {
        return STBVorbisComment.nvendorString(this.address());
    }

    public int comment_list_length() {
        return STBVorbisComment.ncomment_list_length(this.address());
    }

    @NativeType(value="char **")
    public PointerBuffer comment_list() {
        return STBVorbisComment.ncomment_list(this.address());
    }

    public static STBVorbisComment malloc() {
        return STBVorbisComment.wrap(STBVorbisComment.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBVorbisComment calloc() {
        return STBVorbisComment.wrap(STBVorbisComment.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBVorbisComment create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBVorbisComment.wrap(STBVorbisComment.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBVorbisComment create(long l2) {
        return STBVorbisComment.wrap(STBVorbisComment.class, l2);
    }

    @Nullable
    public static STBVorbisComment createSafe(long l2) {
        return l2 == 0L ? null : STBVorbisComment.wrap(STBVorbisComment.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBVorbisComment.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBVorbisComment.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBVorbisComment.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBVorbisComment.__create(n2, SIZEOF);
        return STBVorbisComment.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBVorbisComment.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBVorbisComment.wrap(Buffer.class, l2, n2);
    }

    public static STBVorbisComment malloc(MemoryStack memoryStack) {
        return STBVorbisComment.wrap(STBVorbisComment.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBVorbisComment calloc(MemoryStack memoryStack) {
        return STBVorbisComment.wrap(STBVorbisComment.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBVorbisComment.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBVorbisComment.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static ByteBuffer nvendor(long l2) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(l2 + (long)VENDOR));
    }

    public static String nvendorString(long l2) {
        return MemoryUtil.memASCII(MemoryUtil.memGetAddress(l2 + (long)VENDOR));
    }

    public static int ncomment_list_length(long l2) {
        return UNSAFE.getInt(null, l2 + (long)COMMENT_LIST_LENGTH);
    }

    public static PointerBuffer ncomment_list(long l2) {
        return MemoryUtil.memPointerBuffer(MemoryUtil.memGetAddress(l2 + (long)COMMENT_LIST), STBVorbisComment.ncomment_list_length(l2));
    }

    static {
        Struct.Layout layout = STBVorbisComment.__struct(STBVorbisComment.__member(POINTER_SIZE), STBVorbisComment.__member(4), STBVorbisComment.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        VENDOR = layout.offsetof(0);
        COMMENT_LIST_LENGTH = layout.offsetof(1);
        COMMENT_LIST = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<STBVorbisComment, Buffer>
    implements NativeResource {
        private static final STBVorbisComment ELEMENT_FACTORY = STBVorbisComment.create(-1L);

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
        protected STBVorbisComment getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char *")
        public ByteBuffer vendor() {
            return STBVorbisComment.nvendor(this.address());
        }

        @NativeType(value="char *")
        public String vendorString() {
            return STBVorbisComment.nvendorString(this.address());
        }

        public int comment_list_length() {
            return STBVorbisComment.ncomment_list_length(this.address());
        }

        @NativeType(value="char **")
        public PointerBuffer comment_list() {
            return STBVorbisComment.ncomment_list(this.address());
        }
    }
}

