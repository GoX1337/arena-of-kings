/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.stb;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.stb.LibSTB;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct stbtt_fontinfo")
public class STBTTFontinfo
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;

    private static native int offsets(long var0);

    public STBTTFontinfo(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBTTFontinfo.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public static STBTTFontinfo malloc() {
        return STBTTFontinfo.wrap(STBTTFontinfo.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBTTFontinfo calloc() {
        return STBTTFontinfo.wrap(STBTTFontinfo.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBTTFontinfo create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBTTFontinfo.wrap(STBTTFontinfo.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBTTFontinfo create(long l2) {
        return STBTTFontinfo.wrap(STBTTFontinfo.class, l2);
    }

    @Nullable
    public static STBTTFontinfo createSafe(long l2) {
        return l2 == 0L ? null : STBTTFontinfo.wrap(STBTTFontinfo.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBTTFontinfo.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBTTFontinfo.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBTTFontinfo.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBTTFontinfo.__create(n2, SIZEOF);
        return STBTTFontinfo.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBTTFontinfo.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBTTFontinfo.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static STBTTFontinfo mallocStack() {
        return STBTTFontinfo.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBTTFontinfo callocStack() {
        return STBTTFontinfo.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBTTFontinfo mallocStack(MemoryStack memoryStack) {
        return STBTTFontinfo.malloc(memoryStack);
    }

    @Deprecated
    public static STBTTFontinfo callocStack(MemoryStack memoryStack) {
        return STBTTFontinfo.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return STBTTFontinfo.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return STBTTFontinfo.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return STBTTFontinfo.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return STBTTFontinfo.calloc(n2, memoryStack);
    }

    public static STBTTFontinfo malloc(MemoryStack memoryStack) {
        return STBTTFontinfo.wrap(STBTTFontinfo.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBTTFontinfo calloc(MemoryStack memoryStack) {
        return STBTTFontinfo.wrap(STBTTFontinfo.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBTTFontinfo.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBTTFontinfo.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    static {
        LibSTB.initialize();
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(1);
            SIZEOF = STBTTFontinfo.offsets(MemoryUtil.memAddress(intBuffer));
            ALIGNOF = intBuffer.get(0);
        }
    }

    public static class Buffer
    extends StructBuffer<STBTTFontinfo, Buffer>
    implements NativeResource {
        private static final STBTTFontinfo ELEMENT_FACTORY = STBTTFontinfo.create(-1L);

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
        protected STBTTFontinfo getElementFactory() {
            return ELEMENT_FACTORY;
        }
    }
}

