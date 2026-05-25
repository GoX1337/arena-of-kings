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

@NativeType(value="struct stbtt__bitmap")
public class STBTTBitmap
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int W;
    public static final int H;
    public static final int STRIDE;
    public static final int PIXELS;

    public STBTTBitmap(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBTTBitmap.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int w() {
        return STBTTBitmap.nw(this.address());
    }

    public int h() {
        return STBTTBitmap.nh(this.address());
    }

    public int stride() {
        return STBTTBitmap.nstride(this.address());
    }

    @NativeType(value="unsigned char *")
    public ByteBuffer pixels(int n2) {
        return STBTTBitmap.npixels(this.address(), n2);
    }

    public STBTTBitmap w(int n2) {
        STBTTBitmap.nw(this.address(), n2);
        return this;
    }

    public STBTTBitmap h(int n2) {
        STBTTBitmap.nh(this.address(), n2);
        return this;
    }

    public STBTTBitmap stride(int n2) {
        STBTTBitmap.nstride(this.address(), n2);
        return this;
    }

    public STBTTBitmap pixels(@NativeType(value="unsigned char *") ByteBuffer byteBuffer) {
        STBTTBitmap.npixels(this.address(), byteBuffer);
        return this;
    }

    public STBTTBitmap set(int n2, int n3, int n4, ByteBuffer byteBuffer) {
        this.w(n2);
        this.h(n3);
        this.stride(n4);
        this.pixels(byteBuffer);
        return this;
    }

    public STBTTBitmap set(STBTTBitmap sTBTTBitmap) {
        MemoryUtil.memCopy(sTBTTBitmap.address(), this.address(), SIZEOF);
        return this;
    }

    public static STBTTBitmap malloc() {
        return STBTTBitmap.wrap(STBTTBitmap.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBTTBitmap calloc() {
        return STBTTBitmap.wrap(STBTTBitmap.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBTTBitmap create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBTTBitmap.wrap(STBTTBitmap.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBTTBitmap create(long l2) {
        return STBTTBitmap.wrap(STBTTBitmap.class, l2);
    }

    @Nullable
    public static STBTTBitmap createSafe(long l2) {
        return l2 == 0L ? null : STBTTBitmap.wrap(STBTTBitmap.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBTTBitmap.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBTTBitmap.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBTTBitmap.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBTTBitmap.__create(n2, SIZEOF);
        return STBTTBitmap.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBTTBitmap.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBTTBitmap.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static STBTTBitmap mallocStack() {
        return STBTTBitmap.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBTTBitmap callocStack() {
        return STBTTBitmap.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBTTBitmap mallocStack(MemoryStack memoryStack) {
        return STBTTBitmap.malloc(memoryStack);
    }

    @Deprecated
    public static STBTTBitmap callocStack(MemoryStack memoryStack) {
        return STBTTBitmap.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return STBTTBitmap.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return STBTTBitmap.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return STBTTBitmap.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return STBTTBitmap.calloc(n2, memoryStack);
    }

    public static STBTTBitmap malloc(MemoryStack memoryStack) {
        return STBTTBitmap.wrap(STBTTBitmap.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBTTBitmap calloc(MemoryStack memoryStack) {
        return STBTTBitmap.wrap(STBTTBitmap.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBTTBitmap.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBTTBitmap.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nw(long l2) {
        return UNSAFE.getInt(null, l2 + (long)W);
    }

    public static int nh(long l2) {
        return UNSAFE.getInt(null, l2 + (long)H);
    }

    public static int nstride(long l2) {
        return UNSAFE.getInt(null, l2 + (long)STRIDE);
    }

    public static ByteBuffer npixels(long l2, int n2) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l2 + (long)PIXELS), n2);
    }

    public static void nw(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)W, n2);
    }

    public static void nh(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)H, n2);
    }

    public static void nstride(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)STRIDE, n2);
    }

    public static void npixels(long l2, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)PIXELS, MemoryUtil.memAddress(byteBuffer));
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)PIXELS));
    }

    static {
        Struct.Layout layout = STBTTBitmap.__struct(STBTTBitmap.__member(4), STBTTBitmap.__member(4), STBTTBitmap.__member(4), STBTTBitmap.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        W = layout.offsetof(0);
        H = layout.offsetof(1);
        STRIDE = layout.offsetof(2);
        PIXELS = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<STBTTBitmap, Buffer>
    implements NativeResource {
        private static final STBTTBitmap ELEMENT_FACTORY = STBTTBitmap.create(-1L);

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
        protected STBTTBitmap getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int w() {
            return STBTTBitmap.nw(this.address());
        }

        public int h() {
            return STBTTBitmap.nh(this.address());
        }

        public int stride() {
            return STBTTBitmap.nstride(this.address());
        }

        @NativeType(value="unsigned char *")
        public ByteBuffer pixels(int n2) {
            return STBTTBitmap.npixels(this.address(), n2);
        }

        public Buffer w(int n2) {
            STBTTBitmap.nw(this.address(), n2);
            return this;
        }

        public Buffer h(int n2) {
            STBTTBitmap.nh(this.address(), n2);
            return this;
        }

        public Buffer stride(int n2) {
            STBTTBitmap.nstride(this.address(), n2);
            return this;
        }

        public Buffer pixels(@NativeType(value="unsigned char *") ByteBuffer byteBuffer) {
            STBTTBitmap.npixels(this.address(), byteBuffer);
            return this;
        }
    }
}

