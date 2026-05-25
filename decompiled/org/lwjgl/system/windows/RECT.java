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

public class RECT
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int LEFT;
    public static final int TOP;
    public static final int RIGHT;
    public static final int BOTTOM;

    public RECT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), RECT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int left() {
        return RECT.nleft(this.address());
    }

    @NativeType(value="LONG")
    public int top() {
        return RECT.ntop(this.address());
    }

    @NativeType(value="LONG")
    public int right() {
        return RECT.nright(this.address());
    }

    @NativeType(value="LONG")
    public int bottom() {
        return RECT.nbottom(this.address());
    }

    public RECT left(@NativeType(value="LONG") int n2) {
        RECT.nleft(this.address(), n2);
        return this;
    }

    public RECT top(@NativeType(value="LONG") int n2) {
        RECT.ntop(this.address(), n2);
        return this;
    }

    public RECT right(@NativeType(value="LONG") int n2) {
        RECT.nright(this.address(), n2);
        return this;
    }

    public RECT bottom(@NativeType(value="LONG") int n2) {
        RECT.nbottom(this.address(), n2);
        return this;
    }

    public RECT set(int n2, int n3, int n4, int n5) {
        this.left(n2);
        this.top(n3);
        this.right(n4);
        this.bottom(n5);
        return this;
    }

    public RECT set(RECT rECT) {
        MemoryUtil.memCopy(rECT.address(), this.address(), SIZEOF);
        return this;
    }

    public static RECT malloc() {
        return RECT.wrap(RECT.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static RECT calloc() {
        return RECT.wrap(RECT.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static RECT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return RECT.wrap(RECT.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static RECT create(long l2) {
        return RECT.wrap(RECT.class, l2);
    }

    @Nullable
    public static RECT createSafe(long l2) {
        return l2 == 0L ? null : RECT.wrap(RECT.class, l2);
    }

    public static Buffer malloc(int n2) {
        return RECT.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(RECT.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return RECT.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = RECT.__create(n2, SIZEOF);
        return RECT.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return RECT.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : RECT.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static RECT mallocStack() {
        return RECT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static RECT callocStack() {
        return RECT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static RECT mallocStack(MemoryStack memoryStack) {
        return RECT.malloc(memoryStack);
    }

    @Deprecated
    public static RECT callocStack(MemoryStack memoryStack) {
        return RECT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return RECT.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return RECT.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return RECT.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return RECT.calloc(n2, memoryStack);
    }

    public static RECT malloc(MemoryStack memoryStack) {
        return RECT.wrap(RECT.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static RECT calloc(MemoryStack memoryStack) {
        return RECT.wrap(RECT.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return RECT.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return RECT.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nleft(long l2) {
        return UNSAFE.getInt(null, l2 + (long)LEFT);
    }

    public static int ntop(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TOP);
    }

    public static int nright(long l2) {
        return UNSAFE.getInt(null, l2 + (long)RIGHT);
    }

    public static int nbottom(long l2) {
        return UNSAFE.getInt(null, l2 + (long)BOTTOM);
    }

    public static void nleft(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)LEFT, n2);
    }

    public static void ntop(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)TOP, n2);
    }

    public static void nright(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RIGHT, n2);
    }

    public static void nbottom(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)BOTTOM, n2);
    }

    static {
        Struct.Layout layout = RECT.__struct(RECT.__member(4), RECT.__member(4), RECT.__member(4), RECT.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        LEFT = layout.offsetof(0);
        TOP = layout.offsetof(1);
        RIGHT = layout.offsetof(2);
        BOTTOM = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<RECT, Buffer>
    implements NativeResource {
        private static final RECT ELEMENT_FACTORY = RECT.create(-1L);

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
        protected RECT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int left() {
            return RECT.nleft(this.address());
        }

        @NativeType(value="LONG")
        public int top() {
            return RECT.ntop(this.address());
        }

        @NativeType(value="LONG")
        public int right() {
            return RECT.nright(this.address());
        }

        @NativeType(value="LONG")
        public int bottom() {
            return RECT.nbottom(this.address());
        }

        public Buffer left(@NativeType(value="LONG") int n2) {
            RECT.nleft(this.address(), n2);
            return this;
        }

        public Buffer top(@NativeType(value="LONG") int n2) {
            RECT.ntop(this.address(), n2);
            return this;
        }

        public Buffer right(@NativeType(value="LONG") int n2) {
            RECT.nright(this.address(), n2);
            return this;
        }

        public Buffer bottom(@NativeType(value="LONG") int n2) {
            RECT.nbottom(this.address(), n2);
            return this;
        }
    }
}

