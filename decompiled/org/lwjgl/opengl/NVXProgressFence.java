/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVXProgressFence {
    protected NVXProgressFence() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="GLuint")
    public static native int glCreateProgressFenceNVX();

    public static native void nglSignalSemaphoreui64NVX(int var0, int var1, long var2, long var4);

    public static void glSignalSemaphoreui64NVX(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLuint64 const *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, intBuffer.remaining());
        }
        NVXProgressFence.nglSignalSemaphoreui64NVX(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(longBuffer));
    }

    public static native void nglWaitSemaphoreui64NVX(int var0, int var1, long var2, long var4);

    public static void glWaitSemaphoreui64NVX(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLuint64 const *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, intBuffer.remaining());
        }
        NVXProgressFence.nglWaitSemaphoreui64NVX(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(longBuffer));
    }

    public static native void nglClientWaitSemaphoreui64NVX(int var0, long var1, long var3);

    public static void glClientWaitSemaphoreui64NVX(@NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLuint64 const *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, intBuffer.remaining());
        }
        NVXProgressFence.nglClientWaitSemaphoreui64NVX(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(longBuffer));
    }

    public static void glSignalSemaphoreui64NVX(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLuint64 const *") long[] lArray) {
        long l2 = GL.getICD().glSignalSemaphoreui64NVX;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, nArray.length);
        }
        JNI.callPPV(n2, nArray.length, nArray, lArray, l2);
    }

    public static void glWaitSemaphoreui64NVX(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLuint64 const *") long[] lArray) {
        long l2 = GL.getICD().glWaitSemaphoreui64NVX;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, nArray.length);
        }
        JNI.callPPV(n2, nArray.length, nArray, lArray, l2);
    }

    public static void glClientWaitSemaphoreui64NVX(@NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLuint64 const *") long[] lArray) {
        long l2 = GL.getICD().glClientWaitSemaphoreui64NVX;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, nArray.length);
        }
        JNI.callPPV(nArray.length, nArray, lArray, l2);
    }

    static {
        GL.initialize();
    }
}

