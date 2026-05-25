/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct GLFWgamepadstate")
public class GLFWGamepadState
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int BUTTONS;
    public static final int AXES;

    public GLFWGamepadState(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), GLFWGamepadState.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned char[15]")
    public ByteBuffer buttons() {
        return GLFWGamepadState.nbuttons(this.address());
    }

    @NativeType(value="unsigned char")
    public byte buttons(int n2) {
        return GLFWGamepadState.nbuttons(this.address(), n2);
    }

    @NativeType(value="float[6]")
    public FloatBuffer axes() {
        return GLFWGamepadState.naxes(this.address());
    }

    public float axes(int n2) {
        return GLFWGamepadState.naxes(this.address(), n2);
    }

    public GLFWGamepadState buttons(@NativeType(value="unsigned char[15]") ByteBuffer byteBuffer) {
        GLFWGamepadState.nbuttons(this.address(), byteBuffer);
        return this;
    }

    public GLFWGamepadState buttons(int n2, @NativeType(value="unsigned char") byte by2) {
        GLFWGamepadState.nbuttons(this.address(), n2, by2);
        return this;
    }

    public GLFWGamepadState axes(@NativeType(value="float[6]") FloatBuffer floatBuffer) {
        GLFWGamepadState.naxes(this.address(), floatBuffer);
        return this;
    }

    public GLFWGamepadState axes(int n2, float f2) {
        GLFWGamepadState.naxes(this.address(), n2, f2);
        return this;
    }

    public GLFWGamepadState set(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        this.buttons(byteBuffer);
        this.axes(floatBuffer);
        return this;
    }

    public GLFWGamepadState set(GLFWGamepadState gLFWGamepadState) {
        MemoryUtil.memCopy(gLFWGamepadState.address(), this.address(), SIZEOF);
        return this;
    }

    public static GLFWGamepadState malloc() {
        return GLFWGamepadState.wrap(GLFWGamepadState.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static GLFWGamepadState calloc() {
        return GLFWGamepadState.wrap(GLFWGamepadState.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static GLFWGamepadState create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return GLFWGamepadState.wrap(GLFWGamepadState.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static GLFWGamepadState create(long l2) {
        return GLFWGamepadState.wrap(GLFWGamepadState.class, l2);
    }

    @Nullable
    public static GLFWGamepadState createSafe(long l2) {
        return l2 == 0L ? null : GLFWGamepadState.wrap(GLFWGamepadState.class, l2);
    }

    public static Buffer malloc(int n2) {
        return GLFWGamepadState.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(GLFWGamepadState.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return GLFWGamepadState.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = GLFWGamepadState.__create(n2, SIZEOF);
        return GLFWGamepadState.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return GLFWGamepadState.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : GLFWGamepadState.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static GLFWGamepadState mallocStack() {
        return GLFWGamepadState.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static GLFWGamepadState callocStack() {
        return GLFWGamepadState.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static GLFWGamepadState mallocStack(MemoryStack memoryStack) {
        return GLFWGamepadState.malloc(memoryStack);
    }

    @Deprecated
    public static GLFWGamepadState callocStack(MemoryStack memoryStack) {
        return GLFWGamepadState.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return GLFWGamepadState.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return GLFWGamepadState.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return GLFWGamepadState.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return GLFWGamepadState.calloc(n2, memoryStack);
    }

    public static GLFWGamepadState malloc(MemoryStack memoryStack) {
        return GLFWGamepadState.wrap(GLFWGamepadState.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static GLFWGamepadState calloc(MemoryStack memoryStack) {
        return GLFWGamepadState.wrap(GLFWGamepadState.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return GLFWGamepadState.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return GLFWGamepadState.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static ByteBuffer nbuttons(long l2) {
        return MemoryUtil.memByteBuffer(l2 + (long)BUTTONS, 15);
    }

    public static byte nbuttons(long l2, int n2) {
        return UNSAFE.getByte(null, l2 + (long)BUTTONS + Checks.check(n2, 15) * 1L);
    }

    public static FloatBuffer naxes(long l2) {
        return MemoryUtil.memFloatBuffer(l2 + (long)AXES, 6);
    }

    public static float naxes(long l2, int n2) {
        return UNSAFE.getFloat(null, l2 + (long)AXES + Checks.check(n2, 6) * 4L);
    }

    public static void nbuttons(long l2, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(byteBuffer, 15);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(byteBuffer), l2 + (long)BUTTONS, byteBuffer.remaining() * 1);
    }

    public static void nbuttons(long l2, int n2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)BUTTONS + Checks.check(n2, 15) * 1L, by2);
    }

    public static void naxes(long l2, FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(floatBuffer, 6);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(floatBuffer), l2 + (long)AXES, floatBuffer.remaining() * 4);
    }

    public static void naxes(long l2, int n2, float f2) {
        UNSAFE.putFloat(null, l2 + (long)AXES + Checks.check(n2, 6) * 4L, f2);
    }

    static {
        Struct.Layout layout = GLFWGamepadState.__struct(GLFWGamepadState.__array(1, 15), GLFWGamepadState.__array(4, 6));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        BUTTONS = layout.offsetof(0);
        AXES = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<GLFWGamepadState, Buffer>
    implements NativeResource {
        private static final GLFWGamepadState ELEMENT_FACTORY = GLFWGamepadState.create(-1L);

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
        protected GLFWGamepadState getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned char[15]")
        public ByteBuffer buttons() {
            return GLFWGamepadState.nbuttons(this.address());
        }

        @NativeType(value="unsigned char")
        public byte buttons(int n2) {
            return GLFWGamepadState.nbuttons(this.address(), n2);
        }

        @NativeType(value="float[6]")
        public FloatBuffer axes() {
            return GLFWGamepadState.naxes(this.address());
        }

        public float axes(int n2) {
            return GLFWGamepadState.naxes(this.address(), n2);
        }

        public Buffer buttons(@NativeType(value="unsigned char[15]") ByteBuffer byteBuffer) {
            GLFWGamepadState.nbuttons(this.address(), byteBuffer);
            return this;
        }

        public Buffer buttons(int n2, @NativeType(value="unsigned char") byte by2) {
            GLFWGamepadState.nbuttons(this.address(), n2, by2);
            return this;
        }

        public Buffer axes(@NativeType(value="float[6]") FloatBuffer floatBuffer) {
            GLFWGamepadState.naxes(this.address(), floatBuffer);
            return this;
        }

        public Buffer axes(int n2, float f2) {
            GLFWGamepadState.naxes(this.address(), n2, f2);
            return this;
        }
    }
}

