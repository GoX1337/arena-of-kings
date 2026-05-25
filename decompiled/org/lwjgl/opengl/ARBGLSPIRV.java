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

public class ARBGLSPIRV {
    public static final int GL_SHADER_BINARY_FORMAT_SPIR_V_ARB = 38225;
    public static final int GL_SPIR_V_BINARY_ARB = 38226;

    protected ARBGLSPIRV() {
        throw new UnsupportedOperationException();
    }

    public static native void nglSpecializeShaderARB(int var0, long var1, int var3, long var4, long var6);

    public static void glSpecializeShaderARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer, @NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLuint const *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.check((Buffer)intBuffer2, intBuffer.remaining());
        }
        ARBGLSPIRV.nglSpecializeShaderARB(n2, MemoryUtil.memAddress(byteBuffer), intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glSpecializeShaderARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence, @NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLuint const *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer2, intBuffer.remaining());
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            ARBGLSPIRV.nglSpecializeShaderARB(n2, l2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2));
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static void glSpecializeShaderARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer, @NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLuint const *") int[] nArray2) {
        long l2 = GL.getICD().glSpecializeShaderARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkNT1(byteBuffer);
            Checks.check(nArray2, nArray.length);
        }
        JNI.callPPPV(n2, MemoryUtil.memAddress(byteBuffer), nArray.length, nArray, nArray2, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glSpecializeShaderARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence, @NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLuint const *") int[] nArray2) {
        long l2 = GL.getICD().glSpecializeShaderARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray2, nArray.length);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l3 = memoryStack.getPointerAddress();
            JNI.callPPPV(n2, l3, nArray.length, nArray, nArray2, l2);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    static {
        GL.initialize();
    }
}

