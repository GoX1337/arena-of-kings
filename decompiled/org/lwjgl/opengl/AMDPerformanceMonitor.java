/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class AMDPerformanceMonitor {
    public static final int GL_COUNTER_TYPE_AMD = 35776;
    public static final int GL_COUNTER_RANGE_AMD = 35777;
    public static final int GL_UNSIGNED_INT64_AMD = 35778;
    public static final int GL_PERCENTAGE_AMD = 35779;
    public static final int GL_PERFMON_RESULT_AVAILABLE_AMD = 35780;
    public static final int GL_PERFMON_RESULT_SIZE_AMD = 35781;
    public static final int GL_PERFMON_RESULT_AMD = 35782;

    protected AMDPerformanceMonitor() {
        throw new UnsupportedOperationException();
    }

    public static native void nglGetPerfMonitorGroupsAMD(long var0, int var2, long var3);

    public static void glGetPerfMonitorGroupsAMD(@Nullable @NativeType(value="GLint *") IntBuffer intBuffer, @Nullable @NativeType(value="GLuint *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorGroupsAMD(MemoryUtil.memAddressSafe(intBuffer), Checks.remainingSafe(intBuffer2), MemoryUtil.memAddressSafe(intBuffer2));
    }

    public static native void nglGetPerfMonitorCountersAMD(int var0, long var1, long var3, int var5, long var6);

    public static void glGetPerfMonitorCountersAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLint *") IntBuffer intBuffer2, @NativeType(value="GLuint *") IntBuffer intBuffer3) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCountersAMD(n2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2), intBuffer3.remaining(), MemoryUtil.memAddress(intBuffer3));
    }

    public static native void nglGetPerfMonitorGroupStringAMD(int var0, int var1, long var2, long var4);

    public static void glGetPerfMonitorGroupStringAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorGroupStringAMD(n2, byteBuffer.remaining(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetPerfMonitorCounterStringAMD(int var0, int var1, int var2, long var3, long var5);

    public static void glGetPerfMonitorCounterStringAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @Nullable @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCounterStringAMD(n2, n3, Checks.remainingSafe(byteBuffer), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static native void nglGetPerfMonitorCounterInfoAMD(int var0, int var1, int var2, long var3);

    public static void glGetPerfMonitorCounterInfoAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, 4);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCounterInfoAMD(n2, n3, n4, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetPerfMonitorCounterInfoAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCounterInfoAMD(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetPerfMonitorCounterInfoAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCounterInfoAMD(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGenPerfMonitorsAMD(int var0, long var1);

    public static void glGenPerfMonitorsAMD(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        AMDPerformanceMonitor.nglGenPerfMonitorsAMD(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenPerfMonitorsAMD() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            AMDPerformanceMonitor.nglGenPerfMonitorsAMD(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nglDeletePerfMonitorsAMD(int var0, long var1);

    public static void glDeletePerfMonitorsAMD(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        AMDPerformanceMonitor.nglDeletePerfMonitorsAMD(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeletePerfMonitorsAMD(@NativeType(value="GLuint *") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n2);
            AMDPerformanceMonitor.nglDeletePerfMonitorsAMD(1, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nglSelectPerfMonitorCountersAMD(int var0, boolean var1, int var2, int var3, long var4);

    public static void glSelectPerfMonitorCountersAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        AMDPerformanceMonitor.nglSelectPerfMonitorCountersAMD(n2, bl2, n3, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static native void glBeginPerfMonitorAMD(@NativeType(value="GLuint") int var0);

    public static native void glEndPerfMonitorAMD(@NativeType(value="GLuint") int var0);

    public static native void nglGetPerfMonitorCounterDataAMD(int var0, int var1, int var2, long var3, long var5);

    public static void glGetPerfMonitorCounterDataAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") IntBuffer intBuffer, @Nullable @NativeType(value="GLint *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer2, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCounterDataAMD(n2, n3, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddressSafe(intBuffer2));
    }

    public static void glGetPerfMonitorGroupsAMD(@Nullable @NativeType(value="GLint *") int[] nArray, @Nullable @NativeType(value="GLuint *") int[] nArray2) {
        long l2 = GL.getICD().glGetPerfMonitorGroupsAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
        }
        JNI.callPPV(nArray, Checks.lengthSafe(nArray2), nArray2, l2);
    }

    public static void glGetPerfMonitorCountersAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLint *") int[] nArray, @NativeType(value="GLint *") int[] nArray2, @NativeType(value="GLuint *") int[] nArray3) {
        long l2 = GL.getICD().glGetPerfMonitorCountersAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
        }
        JNI.callPPPV(n2, nArray, nArray2, nArray3.length, nArray3, l2);
    }

    public static void glGetPerfMonitorGroupStringAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetPerfMonitorGroupStringAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPPV(n2, byteBuffer.remaining(), nArray, MemoryUtil.memAddress(byteBuffer), l2);
    }

    public static void glGetPerfMonitorCounterStringAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") int[] nArray, @Nullable @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetPerfMonitorCounterStringAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
        }
        JNI.callPPV(n2, n3, Checks.remainingSafe(byteBuffer), nArray, MemoryUtil.memAddressSafe(byteBuffer), l2);
    }

    public static void glGetPerfMonitorCounterInfoAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getICD().glGetPerfMonitorCounterInfoAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetPerfMonitorCounterInfoAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getICD().glGetPerfMonitorCounterInfoAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glGenPerfMonitorsAMD(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGenPerfMonitorsAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glDeletePerfMonitorsAMD(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glDeletePerfMonitorsAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glSelectPerfMonitorCountersAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glSelectPerfMonitorCountersAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, bl2, n3, nArray.length, nArray, l2);
    }

    public static void glGetPerfMonitorCounterDataAMD(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") int[] nArray, @Nullable @NativeType(value="GLint *") int[] nArray2) {
        long l2 = GL.getICD().glGetPerfMonitorCounterDataAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray2, 1);
        }
        JNI.callPPV(n2, n3, nArray.length, nArray, nArray2, l2);
    }

    static {
        GL.initialize();
    }
}

