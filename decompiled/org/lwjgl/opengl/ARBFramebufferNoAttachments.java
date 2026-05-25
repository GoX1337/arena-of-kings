/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBFramebufferNoAttachments {
    public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648;
    public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649;
    public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
    public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651;
    public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652;
    public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653;
    public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654;
    public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
    public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656;

    protected ARBFramebufferNoAttachments() {
        throw new UnsupportedOperationException();
    }

    public static void glFramebufferParameteri(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4) {
        GL43C.glFramebufferParameteri(n2, n3, n4);
    }

    public static void nglGetFramebufferParameteriv(int n2, int n3, long l2) {
        GL43C.nglGetFramebufferParameteriv(n2, n3, l2);
    }

    public static void glGetFramebufferParameteriv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL43C.glGetFramebufferParameteriv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetFramebufferParameteri(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        return GL43C.glGetFramebufferParameteri(n2, n3);
    }

    public static native void glNamedFramebufferParameteriEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void nglGetNamedFramebufferParameterivEXT(int var0, int var1, long var2);

    public static void glGetNamedFramebufferParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        ARBFramebufferNoAttachments.nglGetNamedFramebufferParameterivEXT(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedFramebufferParameteriEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBFramebufferNoAttachments.nglGetNamedFramebufferParameterivEXT(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void glGetFramebufferParameteriv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL43C.glGetFramebufferParameteriv(n2, n3, nArray);
    }

    public static void glGetNamedFramebufferParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedFramebufferParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    static {
        GL.initialize();
    }
}

