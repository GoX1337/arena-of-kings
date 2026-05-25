/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVQueryResourceTag {
    protected NVQueryResourceTag() {
        throw new UnsupportedOperationException();
    }

    public static native void nglGenQueryResourceTagNV(int var0, long var1);

    public static void glGenQueryResourceTagNV(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        NVQueryResourceTag.nglGenQueryResourceTagNV(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenQueryResourceTagNV() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            NVQueryResourceTag.nglGenQueryResourceTagNV(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nglDeleteQueryResourceTagNV(int var0, long var1);

    public static void glDeleteQueryResourceTagNV(@NativeType(value="GLuint const *") IntBuffer intBuffer) {
        NVQueryResourceTag.nglDeleteQueryResourceTagNV(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteQueryResourceTagNV(@NativeType(value="GLuint const *") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n2);
            NVQueryResourceTag.nglDeleteQueryResourceTagNV(1, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nglQueryResourceTagNV(int var0, long var1);

    public static void glQueryResourceTagNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        NVQueryResourceTag.nglQueryResourceTagNV(n2, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glQueryResourceTagNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            NVQueryResourceTag.nglQueryResourceTagNV(n2, l2);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static void glGenQueryResourceTagNV(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGenQueryResourceTagNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glDeleteQueryResourceTagNV(@NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glDeleteQueryResourceTagNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    static {
        GL.initialize();
    }
}

