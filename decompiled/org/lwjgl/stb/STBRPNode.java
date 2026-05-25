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

@NativeType(value="struct stbrp_node")
public class STBRPNode
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;
    public static final int NEXT;

    public STBRPNode(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBRPNode.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="stbrp_coord")
    public int x() {
        return STBRPNode.nx(this.address());
    }

    @NativeType(value="stbrp_coord")
    public int y() {
        return STBRPNode.ny(this.address());
    }

    @Nullable
    @NativeType(value="stbrp_node *")
    public STBRPNode next() {
        return STBRPNode.nnext(this.address());
    }

    public static STBRPNode malloc() {
        return STBRPNode.wrap(STBRPNode.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBRPNode calloc() {
        return STBRPNode.wrap(STBRPNode.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBRPNode create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBRPNode.wrap(STBRPNode.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBRPNode create(long l2) {
        return STBRPNode.wrap(STBRPNode.class, l2);
    }

    @Nullable
    public static STBRPNode createSafe(long l2) {
        return l2 == 0L ? null : STBRPNode.wrap(STBRPNode.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBRPNode.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBRPNode.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBRPNode.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBRPNode.__create(n2, SIZEOF);
        return STBRPNode.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBRPNode.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBRPNode.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static STBRPNode mallocStack() {
        return STBRPNode.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBRPNode callocStack() {
        return STBRPNode.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBRPNode mallocStack(MemoryStack memoryStack) {
        return STBRPNode.malloc(memoryStack);
    }

    @Deprecated
    public static STBRPNode callocStack(MemoryStack memoryStack) {
        return STBRPNode.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return STBRPNode.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return STBRPNode.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return STBRPNode.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return STBRPNode.calloc(n2, memoryStack);
    }

    public static STBRPNode malloc(MemoryStack memoryStack) {
        return STBRPNode.wrap(STBRPNode.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBRPNode calloc(MemoryStack memoryStack) {
        return STBRPNode.wrap(STBRPNode.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBRPNode.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBRPNode.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nx(long l2) {
        return UNSAFE.getInt(null, l2 + (long)X);
    }

    public static int ny(long l2) {
        return UNSAFE.getInt(null, l2 + (long)Y);
    }

    @Nullable
    public static STBRPNode nnext(long l2) {
        return STBRPNode.createSafe(MemoryUtil.memGetAddress(l2 + (long)NEXT));
    }

    static {
        Struct.Layout layout = STBRPNode.__struct(STBRPNode.__member(4), STBRPNode.__member(4), STBRPNode.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        X = layout.offsetof(0);
        Y = layout.offsetof(1);
        NEXT = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<STBRPNode, Buffer>
    implements NativeResource {
        private static final STBRPNode ELEMENT_FACTORY = STBRPNode.create(-1L);

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
        protected STBRPNode getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="stbrp_coord")
        public int x() {
            return STBRPNode.nx(this.address());
        }

        @NativeType(value="stbrp_coord")
        public int y() {
            return STBRPNode.ny(this.address());
        }

        @Nullable
        @NativeType(value="stbrp_node *")
        public STBRPNode next() {
            return STBRPNode.nnext(this.address());
        }
    }
}

