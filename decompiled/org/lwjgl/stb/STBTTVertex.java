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

@NativeType(value="struct stbtt_vertex")
public class STBTTVertex
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;
    public static final int CX;
    public static final int CY;
    public static final int CX1;
    public static final int CY1;
    public static final int TYPE;

    public STBTTVertex(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBTTVertex.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="stbtt_vertex_type")
    public short x() {
        return STBTTVertex.nx(this.address());
    }

    @NativeType(value="stbtt_vertex_type")
    public short y() {
        return STBTTVertex.ny(this.address());
    }

    @NativeType(value="stbtt_vertex_type")
    public short cx() {
        return STBTTVertex.ncx(this.address());
    }

    @NativeType(value="stbtt_vertex_type")
    public short cy() {
        return STBTTVertex.ncy(this.address());
    }

    @NativeType(value="stbtt_vertex_type")
    public short cx1() {
        return STBTTVertex.ncx1(this.address());
    }

    @NativeType(value="stbtt_vertex_type")
    public short cy1() {
        return STBTTVertex.ncy1(this.address());
    }

    @NativeType(value="unsigned char")
    public byte type() {
        return STBTTVertex.ntype(this.address());
    }

    public static STBTTVertex malloc() {
        return STBTTVertex.wrap(STBTTVertex.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBTTVertex calloc() {
        return STBTTVertex.wrap(STBTTVertex.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBTTVertex create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBTTVertex.wrap(STBTTVertex.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBTTVertex create(long l2) {
        return STBTTVertex.wrap(STBTTVertex.class, l2);
    }

    @Nullable
    public static STBTTVertex createSafe(long l2) {
        return l2 == 0L ? null : STBTTVertex.wrap(STBTTVertex.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBTTVertex.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBTTVertex.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBTTVertex.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBTTVertex.__create(n2, SIZEOF);
        return STBTTVertex.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBTTVertex.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBTTVertex.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static STBTTVertex mallocStack() {
        return STBTTVertex.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBTTVertex callocStack() {
        return STBTTVertex.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBTTVertex mallocStack(MemoryStack memoryStack) {
        return STBTTVertex.malloc(memoryStack);
    }

    @Deprecated
    public static STBTTVertex callocStack(MemoryStack memoryStack) {
        return STBTTVertex.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return STBTTVertex.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return STBTTVertex.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return STBTTVertex.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return STBTTVertex.calloc(n2, memoryStack);
    }

    public static STBTTVertex malloc(MemoryStack memoryStack) {
        return STBTTVertex.wrap(STBTTVertex.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBTTVertex calloc(MemoryStack memoryStack) {
        return STBTTVertex.wrap(STBTTVertex.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBTTVertex.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBTTVertex.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static short nx(long l2) {
        return UNSAFE.getShort(null, l2 + (long)X);
    }

    public static short ny(long l2) {
        return UNSAFE.getShort(null, l2 + (long)Y);
    }

    public static short ncx(long l2) {
        return UNSAFE.getShort(null, l2 + (long)CX);
    }

    public static short ncy(long l2) {
        return UNSAFE.getShort(null, l2 + (long)CY);
    }

    public static short ncx1(long l2) {
        return UNSAFE.getShort(null, l2 + (long)CX1);
    }

    public static short ncy1(long l2) {
        return UNSAFE.getShort(null, l2 + (long)CY1);
    }

    public static byte ntype(long l2) {
        return UNSAFE.getByte(null, l2 + (long)TYPE);
    }

    static {
        Struct.Layout layout = STBTTVertex.__struct(STBTTVertex.__member(2), STBTTVertex.__member(2), STBTTVertex.__member(2), STBTTVertex.__member(2), STBTTVertex.__member(2), STBTTVertex.__member(2), STBTTVertex.__member(1));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        X = layout.offsetof(0);
        Y = layout.offsetof(1);
        CX = layout.offsetof(2);
        CY = layout.offsetof(3);
        CX1 = layout.offsetof(4);
        CY1 = layout.offsetof(5);
        TYPE = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<STBTTVertex, Buffer>
    implements NativeResource {
        private static final STBTTVertex ELEMENT_FACTORY = STBTTVertex.create(-1L);

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
        protected STBTTVertex getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="stbtt_vertex_type")
        public short x() {
            return STBTTVertex.nx(this.address());
        }

        @NativeType(value="stbtt_vertex_type")
        public short y() {
            return STBTTVertex.ny(this.address());
        }

        @NativeType(value="stbtt_vertex_type")
        public short cx() {
            return STBTTVertex.ncx(this.address());
        }

        @NativeType(value="stbtt_vertex_type")
        public short cy() {
            return STBTTVertex.ncy(this.address());
        }

        @NativeType(value="stbtt_vertex_type")
        public short cx1() {
            return STBTTVertex.ncx1(this.address());
        }

        @NativeType(value="stbtt_vertex_type")
        public short cy1() {
            return STBTTVertex.ncy1(this.address());
        }

        @NativeType(value="unsigned char")
        public byte type() {
            return STBTTVertex.ntype(this.address());
        }
    }
}

