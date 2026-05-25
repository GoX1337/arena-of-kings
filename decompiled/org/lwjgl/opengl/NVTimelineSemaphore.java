/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVTimelineSemaphore {
    public static final int GL_SEMAPHORE_TYPE_NV = 38323;
    public static final int GL_SEMAPHORE_TYPE_BINARY_NV = 38324;
    public static final int GL_SEMAPHORE_TYPE_TIMELINE_NV = 38325;
    public static final int GL_TIMELINE_SEMAPHORE_VALUE_NV = 38293;
    public static final int GL_MAX_TIMELINE_SEMAPHORE_VALUE_DIFFERENCE_NV = 38326;

    protected NVTimelineSemaphore() {
        throw new UnsupportedOperationException();
    }

    public static native void nglCreateSemaphoresNV(int var0, long var1);

    public static void glCreateSemaphoresNV(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        NVTimelineSemaphore.nglCreateSemaphoresNV(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateSemaphoresNV() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            NVTimelineSemaphore.nglCreateSemaphoresNV(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nglSemaphoreParameterivNV(int var0, int var1, long var2);

    public static void glSemaphoreParameterivNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        NVTimelineSemaphore.nglSemaphoreParameterivNV(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglGetSemaphoreParameterivNV(int var0, int var1, long var2);

    public static void glGetSemaphoreParameterivNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        NVTimelineSemaphore.nglGetSemaphoreParameterivNV(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static void glCreateSemaphoresNV(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glCreateSemaphoresNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glSemaphoreParameterivNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glSemaphoreParameterivNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetSemaphoreParameterivNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetSemaphoreParameterivNV;
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

