/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class CGPoint
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;

    public CGPoint(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), CGPoint.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="CGFloat")
    public double x() {
        return CGPoint.nx(this.address());
    }

    @NativeType(value="CGFloat")
    public double y() {
        return CGPoint.ny(this.address());
    }

    public CGPoint x(@NativeType(value="CGFloat") double d2) {
        CGPoint.nx(this.address(), d2);
        return this;
    }

    public CGPoint y(@NativeType(value="CGFloat") double d2) {
        CGPoint.ny(this.address(), d2);
        return this;
    }

    public CGPoint set(double d2, double d3) {
        this.x(d2);
        this.y(d3);
        return this;
    }

    public CGPoint set(CGPoint cGPoint) {
        MemoryUtil.memCopy(cGPoint.address(), this.address(), SIZEOF);
        return this;
    }

    public static CGPoint malloc() {
        return CGPoint.wrap(CGPoint.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static CGPoint calloc() {
        return CGPoint.wrap(CGPoint.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static CGPoint create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return CGPoint.wrap(CGPoint.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static CGPoint create(long l2) {
        return CGPoint.wrap(CGPoint.class, l2);
    }

    @Nullable
    public static CGPoint createSafe(long l2) {
        return l2 == 0L ? null : CGPoint.wrap(CGPoint.class, l2);
    }

    public static Buffer malloc(int n2) {
        return CGPoint.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(CGPoint.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return CGPoint.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = CGPoint.__create(n2, SIZEOF);
        return CGPoint.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return CGPoint.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : CGPoint.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static CGPoint mallocStack() {
        return CGPoint.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static CGPoint callocStack() {
        return CGPoint.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static CGPoint mallocStack(MemoryStack memoryStack) {
        return CGPoint.malloc(memoryStack);
    }

    @Deprecated
    public static CGPoint callocStack(MemoryStack memoryStack) {
        return CGPoint.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return CGPoint.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return CGPoint.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return CGPoint.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return CGPoint.calloc(n2, memoryStack);
    }

    public static CGPoint malloc(MemoryStack memoryStack) {
        return CGPoint.wrap(CGPoint.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static CGPoint calloc(MemoryStack memoryStack) {
        return CGPoint.wrap(CGPoint.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return CGPoint.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return CGPoint.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static double nx(long l2) {
        return UNSAFE.getDouble(null, l2 + (long)X);
    }

    public static double ny(long l2) {
        return UNSAFE.getDouble(null, l2 + (long)Y);
    }

    public static void nx(long l2, double d2) {
        UNSAFE.putDouble(null, l2 + (long)X, d2);
    }

    public static void ny(long l2, double d2) {
        UNSAFE.putDouble(null, l2 + (long)Y, d2);
    }

    static {
        Struct.Layout layout = CGPoint.__struct(CGPoint.__member(8), CGPoint.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        X = layout.offsetof(0);
        Y = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<CGPoint, Buffer>
    implements NativeResource {
        private static final CGPoint ELEMENT_FACTORY = CGPoint.create(-1L);

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
        protected CGPoint getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="CGFloat")
        public double x() {
            return CGPoint.nx(this.address());
        }

        @NativeType(value="CGFloat")
        public double y() {
            return CGPoint.ny(this.address());
        }

        public Buffer x(@NativeType(value="CGFloat") double d2) {
            CGPoint.nx(this.address(), d2);
            return this;
        }

        public Buffer y(@NativeType(value="CGFloat") double d2) {
            CGPoint.ny(this.address(), d2);
            return this;
        }
    }
}

