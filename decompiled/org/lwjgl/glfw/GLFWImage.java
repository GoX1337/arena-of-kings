/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

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

@NativeType(value="struct GLFWimage")
public class GLFWImage
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int PIXELS;

    public GLFWImage(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), GLFWImage.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int width() {
        return GLFWImage.nwidth(this.address());
    }

    public int height() {
        return GLFWImage.nheight(this.address());
    }

    @NativeType(value="unsigned char *")
    public ByteBuffer pixels(int n2) {
        return GLFWImage.npixels(this.address(), n2);
    }

    public GLFWImage width(int n2) {
        GLFWImage.nwidth(this.address(), n2);
        return this;
    }

    public GLFWImage height(int n2) {
        GLFWImage.nheight(this.address(), n2);
        return this;
    }

    public GLFWImage pixels(@NativeType(value="unsigned char *") ByteBuffer byteBuffer) {
        GLFWImage.npixels(this.address(), byteBuffer);
        return this;
    }

    public GLFWImage set(int n2, int n3, ByteBuffer byteBuffer) {
        this.width(n2);
        this.height(n3);
        this.pixels(byteBuffer);
        return this;
    }

    public GLFWImage set(GLFWImage gLFWImage) {
        MemoryUtil.memCopy(gLFWImage.address(), this.address(), SIZEOF);
        return this;
    }

    public static GLFWImage malloc() {
        return GLFWImage.wrap(GLFWImage.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static GLFWImage calloc() {
        return GLFWImage.wrap(GLFWImage.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static GLFWImage create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return GLFWImage.wrap(GLFWImage.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static GLFWImage create(long l2) {
        return GLFWImage.wrap(GLFWImage.class, l2);
    }

    @Nullable
    public static GLFWImage createSafe(long l2) {
        return l2 == 0L ? null : GLFWImage.wrap(GLFWImage.class, l2);
    }

    public static Buffer malloc(int n2) {
        return GLFWImage.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(GLFWImage.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return GLFWImage.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = GLFWImage.__create(n2, SIZEOF);
        return GLFWImage.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return GLFWImage.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : GLFWImage.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static GLFWImage mallocStack() {
        return GLFWImage.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static GLFWImage callocStack() {
        return GLFWImage.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static GLFWImage mallocStack(MemoryStack memoryStack) {
        return GLFWImage.malloc(memoryStack);
    }

    @Deprecated
    public static GLFWImage callocStack(MemoryStack memoryStack) {
        return GLFWImage.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return GLFWImage.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return GLFWImage.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return GLFWImage.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return GLFWImage.calloc(n2, memoryStack);
    }

    public static GLFWImage malloc(MemoryStack memoryStack) {
        return GLFWImage.wrap(GLFWImage.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static GLFWImage calloc(MemoryStack memoryStack) {
        return GLFWImage.wrap(GLFWImage.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return GLFWImage.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return GLFWImage.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nwidth(long l2) {
        return UNSAFE.getInt(null, l2 + (long)WIDTH);
    }

    public static int nheight(long l2) {
        return UNSAFE.getInt(null, l2 + (long)HEIGHT);
    }

    public static ByteBuffer npixels(long l2, int n2) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l2 + (long)PIXELS), n2);
    }

    public static void nwidth(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)WIDTH, n2);
    }

    public static void nheight(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)HEIGHT, n2);
    }

    public static void npixels(long l2, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)PIXELS, MemoryUtil.memAddress(byteBuffer));
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)PIXELS));
    }

    static {
        Struct.Layout layout = GLFWImage.__struct(GLFWImage.__member(4), GLFWImage.__member(4), GLFWImage.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        WIDTH = layout.offsetof(0);
        HEIGHT = layout.offsetof(1);
        PIXELS = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<GLFWImage, Buffer>
    implements NativeResource {
        private static final GLFWImage ELEMENT_FACTORY = GLFWImage.create(-1L);

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
        protected GLFWImage getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int width() {
            return GLFWImage.nwidth(this.address());
        }

        public int height() {
            return GLFWImage.nheight(this.address());
        }

        @NativeType(value="unsigned char *")
        public ByteBuffer pixels(int n2) {
            return GLFWImage.npixels(this.address(), n2);
        }

        public Buffer width(int n2) {
            GLFWImage.nwidth(this.address(), n2);
            return this;
        }

        public Buffer height(int n2) {
            GLFWImage.nheight(this.address(), n2);
            return this;
        }

        public Buffer pixels(@NativeType(value="unsigned char *") ByteBuffer byteBuffer) {
            GLFWImage.npixels(this.address(), byteBuffer);
            return this;
        }
    }
}

