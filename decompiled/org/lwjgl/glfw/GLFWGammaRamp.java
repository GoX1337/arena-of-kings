/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct GLFWgammaramp")
public class GLFWGammaRamp
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int RED;
    public static final int GREEN;
    public static final int BLUE;
    public static final int SIZE;

    public GLFWGammaRamp(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), GLFWGammaRamp.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned short *")
    public ShortBuffer red() {
        return GLFWGammaRamp.nred(this.address());
    }

    @NativeType(value="unsigned short *")
    public ShortBuffer green() {
        return GLFWGammaRamp.ngreen(this.address());
    }

    @NativeType(value="unsigned short *")
    public ShortBuffer blue() {
        return GLFWGammaRamp.nblue(this.address());
    }

    @NativeType(value="unsigned int")
    public int size() {
        return GLFWGammaRamp.nsize(this.address());
    }

    public GLFWGammaRamp red(@NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
        GLFWGammaRamp.nred(this.address(), shortBuffer);
        return this;
    }

    public GLFWGammaRamp green(@NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
        GLFWGammaRamp.ngreen(this.address(), shortBuffer);
        return this;
    }

    public GLFWGammaRamp blue(@NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
        GLFWGammaRamp.nblue(this.address(), shortBuffer);
        return this;
    }

    public GLFWGammaRamp size(@NativeType(value="unsigned int") int n2) {
        GLFWGammaRamp.nsize(this.address(), n2);
        return this;
    }

    public GLFWGammaRamp set(ShortBuffer shortBuffer, ShortBuffer shortBuffer2, ShortBuffer shortBuffer3, int n2) {
        this.red(shortBuffer);
        this.green(shortBuffer2);
        this.blue(shortBuffer3);
        this.size(n2);
        return this;
    }

    public GLFWGammaRamp set(GLFWGammaRamp gLFWGammaRamp) {
        MemoryUtil.memCopy(gLFWGammaRamp.address(), this.address(), SIZEOF);
        return this;
    }

    public static GLFWGammaRamp malloc() {
        return GLFWGammaRamp.wrap(GLFWGammaRamp.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static GLFWGammaRamp calloc() {
        return GLFWGammaRamp.wrap(GLFWGammaRamp.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static GLFWGammaRamp create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return GLFWGammaRamp.wrap(GLFWGammaRamp.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static GLFWGammaRamp create(long l2) {
        return GLFWGammaRamp.wrap(GLFWGammaRamp.class, l2);
    }

    @Nullable
    public static GLFWGammaRamp createSafe(long l2) {
        return l2 == 0L ? null : GLFWGammaRamp.wrap(GLFWGammaRamp.class, l2);
    }

    public static Buffer malloc(int n2) {
        return GLFWGammaRamp.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(GLFWGammaRamp.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return GLFWGammaRamp.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = GLFWGammaRamp.__create(n2, SIZEOF);
        return GLFWGammaRamp.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return GLFWGammaRamp.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : GLFWGammaRamp.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static GLFWGammaRamp mallocStack() {
        return GLFWGammaRamp.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static GLFWGammaRamp callocStack() {
        return GLFWGammaRamp.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static GLFWGammaRamp mallocStack(MemoryStack memoryStack) {
        return GLFWGammaRamp.malloc(memoryStack);
    }

    @Deprecated
    public static GLFWGammaRamp callocStack(MemoryStack memoryStack) {
        return GLFWGammaRamp.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return GLFWGammaRamp.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return GLFWGammaRamp.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return GLFWGammaRamp.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return GLFWGammaRamp.calloc(n2, memoryStack);
    }

    public static GLFWGammaRamp malloc(MemoryStack memoryStack) {
        return GLFWGammaRamp.wrap(GLFWGammaRamp.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static GLFWGammaRamp calloc(MemoryStack memoryStack) {
        return GLFWGammaRamp.wrap(GLFWGammaRamp.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return GLFWGammaRamp.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return GLFWGammaRamp.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static ShortBuffer nred(long l2) {
        return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(l2 + (long)RED), GLFWGammaRamp.nsize(l2));
    }

    public static ShortBuffer ngreen(long l2) {
        return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(l2 + (long)GREEN), GLFWGammaRamp.nsize(l2));
    }

    public static ShortBuffer nblue(long l2) {
        return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(l2 + (long)BLUE), GLFWGammaRamp.nsize(l2));
    }

    public static int nsize(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SIZE);
    }

    public static void nred(long l2, ShortBuffer shortBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)RED, MemoryUtil.memAddress(shortBuffer));
    }

    public static void ngreen(long l2, ShortBuffer shortBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)GREEN, MemoryUtil.memAddress(shortBuffer));
    }

    public static void nblue(long l2, ShortBuffer shortBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)BLUE, MemoryUtil.memAddress(shortBuffer));
    }

    public static void nsize(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SIZE, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)RED));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)GREEN));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)BLUE));
    }

    static {
        Struct.Layout layout = GLFWGammaRamp.__struct(GLFWGammaRamp.__member(POINTER_SIZE), GLFWGammaRamp.__member(POINTER_SIZE), GLFWGammaRamp.__member(POINTER_SIZE), GLFWGammaRamp.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        RED = layout.offsetof(0);
        GREEN = layout.offsetof(1);
        BLUE = layout.offsetof(2);
        SIZE = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<GLFWGammaRamp, Buffer>
    implements NativeResource {
        private static final GLFWGammaRamp ELEMENT_FACTORY = GLFWGammaRamp.create(-1L);

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
        protected GLFWGammaRamp getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned short *")
        public ShortBuffer red() {
            return GLFWGammaRamp.nred(this.address());
        }

        @NativeType(value="unsigned short *")
        public ShortBuffer green() {
            return GLFWGammaRamp.ngreen(this.address());
        }

        @NativeType(value="unsigned short *")
        public ShortBuffer blue() {
            return GLFWGammaRamp.nblue(this.address());
        }

        @NativeType(value="unsigned int")
        public int size() {
            return GLFWGammaRamp.nsize(this.address());
        }

        public Buffer red(@NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
            GLFWGammaRamp.nred(this.address(), shortBuffer);
            return this;
        }

        public Buffer green(@NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
            GLFWGammaRamp.ngreen(this.address(), shortBuffer);
            return this;
        }

        public Buffer blue(@NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
            GLFWGammaRamp.nblue(this.address(), shortBuffer);
            return this;
        }

        public Buffer size(@NativeType(value="unsigned int") int n2) {
            GLFWGammaRamp.nsize(this.address(), n2);
            return this;
        }
    }
}

