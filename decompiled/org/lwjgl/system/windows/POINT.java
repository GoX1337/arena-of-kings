/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class POINT
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;

    public POINT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), POINT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int x() {
        return POINT.nx(this.address());
    }

    @NativeType(value="LONG")
    public int y() {
        return POINT.ny(this.address());
    }

    public POINT x(@NativeType(value="LONG") int n2) {
        POINT.nx(this.address(), n2);
        return this;
    }

    public POINT y(@NativeType(value="LONG") int n2) {
        POINT.ny(this.address(), n2);
        return this;
    }

    public POINT set(int n2, int n3) {
        this.x(n2);
        this.y(n3);
        return this;
    }

    public POINT set(POINT pOINT) {
        MemoryUtil.memCopy(pOINT.address(), this.address(), SIZEOF);
        return this;
    }

    public static POINT malloc() {
        return POINT.wrap(POINT.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static POINT calloc() {
        return POINT.wrap(POINT.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static POINT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return POINT.wrap(POINT.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static POINT create(long l2) {
        return POINT.wrap(POINT.class, l2);
    }

    @Nullable
    public static POINT createSafe(long l2) {
        return l2 == 0L ? null : POINT.wrap(POINT.class, l2);
    }

    public static Buffer malloc(int n2) {
        return POINT.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(POINT.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return POINT.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = POINT.__create(n2, SIZEOF);
        return POINT.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return POINT.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : POINT.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static POINT mallocStack() {
        return POINT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static POINT callocStack() {
        return POINT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static POINT mallocStack(MemoryStack memoryStack) {
        return POINT.malloc(memoryStack);
    }

    @Deprecated
    public static POINT callocStack(MemoryStack memoryStack) {
        return POINT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return POINT.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return POINT.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return POINT.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return POINT.calloc(n2, memoryStack);
    }

    public static POINT malloc(MemoryStack memoryStack) {
        return POINT.wrap(POINT.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static POINT calloc(MemoryStack memoryStack) {
        return POINT.wrap(POINT.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return POINT.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return POINT.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nx(long l2) {
        return UNSAFE.getInt(null, l2 + (long)X);
    }

    public static int ny(long l2) {
        return UNSAFE.getInt(null, l2 + (long)Y);
    }

    public static void nx(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)X, n2);
    }

    public static void ny(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)Y, n2);
    }

    static {
        Struct.Layout layout = POINT.__struct(POINT.__member(4), POINT.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        X = layout.offsetof(0);
        Y = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<POINT, Buffer>
    implements NativeResource {
        private static final POINT ELEMENT_FACTORY = POINT.create(-1L);

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
        protected POINT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int x() {
            return POINT.nx(this.address());
        }

        @NativeType(value="LONG")
        public int y() {
            return POINT.ny(this.address());
        }

        public Buffer x(@NativeType(value="LONG") int n2) {
            POINT.nx(this.address(), n2);
            return this;
        }

        public Buffer y(@NativeType(value="LONG") int n2) {
            POINT.ny(this.address(), n2);
            return this;
        }
    }
}

