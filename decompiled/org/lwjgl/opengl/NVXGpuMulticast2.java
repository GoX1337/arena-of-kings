/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVXGpuMulticast2 {
    protected NVXGpuMulticast2() {
        throw new UnsupportedOperationException();
    }

    public static native int nglAsyncCopyImageSubDataNVX(int var0, long var1, long var3, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20, int var21, int var22, long var23, long var25);

    @NativeType(value="GLuint")
    public static int glAsyncCopyImageSubDataNVX(@NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLuint64 const *") LongBuffer longBuffer, @NativeType(value="GLuint") int n2, @NativeType(value="GLbitfield") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLuint") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLint") int n12, @NativeType(value="GLint") int n13, @NativeType(value="GLint") int n14, @NativeType(value="GLint") int n15, @NativeType(value="GLsizei") int n16, @NativeType(value="GLsizei") int n17, @NativeType(value="GLsizei") int n18, @NativeType(value="GLuint const *") IntBuffer intBuffer2, @NativeType(value="GLuint64 const *") LongBuffer longBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, intBuffer.remaining());
            Checks.check((Buffer)longBuffer2, intBuffer2.remaining());
        }
        return NVXGpuMulticast2.nglAsyncCopyImageSubDataNVX(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(longBuffer), n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, intBuffer2.remaining(), MemoryUtil.memAddress(intBuffer2), MemoryUtil.memAddress(longBuffer2));
    }

    public static native long nglAsyncCopyBufferSubDataNVX(int var0, long var1, long var3, int var5, int var6, int var7, int var8, long var9, long var11, long var13, int var15, long var16, long var18);

    @NativeType(value="GLsync")
    public static long glAsyncCopyBufferSubDataNVX(@NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLuint64 const *") LongBuffer longBuffer, @NativeType(value="GLuint") int n2, @NativeType(value="GLbitfield") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLintptr") long l2, @NativeType(value="GLintptr") long l3, @NativeType(value="GLsizeiptr") long l4, @NativeType(value="GLuint const *") IntBuffer intBuffer2, @NativeType(value="GLuint64 const *") LongBuffer longBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, intBuffer.remaining());
            Checks.check((Buffer)longBuffer2, intBuffer2.remaining());
        }
        return NVXGpuMulticast2.nglAsyncCopyBufferSubDataNVX(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(longBuffer), n2, n3, n4, n5, l2, l3, l4, intBuffer2.remaining(), MemoryUtil.memAddress(intBuffer2), MemoryUtil.memAddress(longBuffer2));
    }

    public static native void glUploadGpuMaskNVX(@NativeType(value="GLbitfield") int var0);

    public static native void nglMulticastViewportArrayvNVX(int var0, int var1, int var2, long var3);

    public static void glMulticastViewportArrayvNVX(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        NVXGpuMulticast2.nglMulticastViewportArrayvNVX(n2, n3, floatBuffer.remaining() >> 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglMulticastScissorArrayvNVX(int var0, int var1, int var2, long var3);

    public static void glMulticastScissorArrayvNVX(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        NVXGpuMulticast2.nglMulticastScissorArrayvNVX(n2, n3, intBuffer.remaining() >> 2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glMulticastViewportPositionWScaleNVX(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    @NativeType(value="GLuint")
    public static int glAsyncCopyImageSubDataNVX(@NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLuint64 const *") long[] lArray, @NativeType(value="GLuint") int n2, @NativeType(value="GLbitfield") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLuint") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLint") int n12, @NativeType(value="GLint") int n13, @NativeType(value="GLint") int n14, @NativeType(value="GLint") int n15, @NativeType(value="GLsizei") int n16, @NativeType(value="GLsizei") int n17, @NativeType(value="GLsizei") int n18, @NativeType(value="GLuint const *") int[] nArray2, @NativeType(value="GLuint64 const *") long[] lArray2) {
        long l2 = GL.getICD().glAsyncCopyImageSubDataNVX;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, nArray.length);
            Checks.check(lArray2, nArray2.length);
        }
        return JNI.callPPPPI(nArray.length, nArray, lArray, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, nArray2.length, nArray2, lArray2, l2);
    }

    @NativeType(value="GLsync")
    public static long glAsyncCopyBufferSubDataNVX(@NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLuint64 const *") long[] lArray, @NativeType(value="GLuint") int n2, @NativeType(value="GLbitfield") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLintptr") long l2, @NativeType(value="GLintptr") long l3, @NativeType(value="GLsizeiptr") long l4, @NativeType(value="GLuint const *") int[] nArray2, @NativeType(value="GLuint64 const *") long[] lArray2) {
        long l5 = GL.getICD().glAsyncCopyBufferSubDataNVX;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(lArray, nArray.length);
            Checks.check(lArray2, nArray2.length);
        }
        return JNI.callPPPPPPPP(nArray.length, nArray, lArray, n2, n3, n4, n5, l2, l3, l4, nArray2.length, nArray2, lArray2, l5);
    }

    public static void glMulticastViewportArrayvNVX(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMulticastViewportArrayvNVX;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 2, fArray, l2);
    }

    public static void glMulticastScissorArrayvNVX(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glMulticastScissorArrayvNVX;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length >> 2, nArray, l2);
    }

    static {
        GL.initialize();
    }
}

