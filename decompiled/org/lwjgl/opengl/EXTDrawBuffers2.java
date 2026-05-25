/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTDrawBuffers2 {
    protected EXTDrawBuffers2() {
        throw new UnsupportedOperationException();
    }

    public static native void glColorMaskIndexedEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLboolean") boolean var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLboolean") boolean var3, @NativeType(value="GLboolean") boolean var4);

    public static native void nglGetBooleanIndexedvEXT(int var0, int var1, long var2);

    public static void glGetBooleanIndexedvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLboolean *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, 1);
        }
        EXTDrawBuffers2.nglGetBooleanIndexedvEXT(n2, n3, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static boolean glGetBooleanIndexedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            ByteBuffer byteBuffer = memoryStack.calloc(1);
            EXTDrawBuffers2.nglGetBooleanIndexedvEXT(n2, n3, MemoryUtil.memAddress(byteBuffer));
            boolean bl2 = byteBuffer.get(0) != 0;
            return bl2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetIntegerIndexedvEXT(int var0, int var1, long var2);

    public static void glGetIntegerIndexedvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDrawBuffers2.nglGetIntegerIndexedvEXT(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetIntegerIndexedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDrawBuffers2.nglGetIntegerIndexedvEXT(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void glEnableIndexedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glDisableIndexedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    @NativeType(value="GLboolean")
    public static native boolean glIsEnabledIndexedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static void glGetIntegerIndexedvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetIntegerIndexedvEXT;
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

