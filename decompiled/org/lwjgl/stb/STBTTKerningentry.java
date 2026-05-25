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
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct stbtt_kerningentry")
public class STBTTKerningentry
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int GLYPH1;
    public static final int GLYPH2;
    public static final int ADVANCE;

    public STBTTKerningentry(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBTTKerningentry.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int glyph1() {
        return STBTTKerningentry.nglyph1(this.address());
    }

    public int glyph2() {
        return STBTTKerningentry.nglyph2(this.address());
    }

    public int advance() {
        return STBTTKerningentry.nadvance(this.address());
    }

    public static STBTTKerningentry malloc() {
        return STBTTKerningentry.wrap(STBTTKerningentry.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBTTKerningentry calloc() {
        return STBTTKerningentry.wrap(STBTTKerningentry.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBTTKerningentry create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBTTKerningentry.wrap(STBTTKerningentry.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBTTKerningentry create(long l2) {
        return STBTTKerningentry.wrap(STBTTKerningentry.class, l2);
    }

    @Nullable
    public static STBTTKerningentry createSafe(long l2) {
        return l2 == 0L ? null : STBTTKerningentry.wrap(STBTTKerningentry.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBTTKerningentry.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBTTKerningentry.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBTTKerningentry.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBTTKerningentry.__create(n2, SIZEOF);
        return STBTTKerningentry.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBTTKerningentry.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBTTKerningentry.wrap(Buffer.class, l2, n2);
    }

    public static STBTTKerningentry malloc(MemoryStack memoryStack) {
        return STBTTKerningentry.wrap(STBTTKerningentry.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBTTKerningentry calloc(MemoryStack memoryStack) {
        return STBTTKerningentry.wrap(STBTTKerningentry.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBTTKerningentry.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBTTKerningentry.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nglyph1(long l2) {
        return UNSAFE.getInt(null, l2 + (long)GLYPH1);
    }

    public static int nglyph2(long l2) {
        return UNSAFE.getInt(null, l2 + (long)GLYPH2);
    }

    public static int nadvance(long l2) {
        return UNSAFE.getInt(null, l2 + (long)ADVANCE);
    }

    static {
        Struct.Layout layout = STBTTKerningentry.__struct(STBTTKerningentry.__member(4), STBTTKerningentry.__member(4), STBTTKerningentry.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        GLYPH1 = layout.offsetof(0);
        GLYPH2 = layout.offsetof(1);
        ADVANCE = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<STBTTKerningentry, Buffer>
    implements NativeResource {
        private static final STBTTKerningentry ELEMENT_FACTORY = STBTTKerningentry.create(-1L);

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
        protected STBTTKerningentry getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int glyph1() {
            return STBTTKerningentry.nglyph1(this.address());
        }

        public int glyph2() {
            return STBTTKerningentry.nglyph2(this.address());
        }

        public int advance() {
            return STBTTKerningentry.nadvance(this.address());
        }
    }
}

