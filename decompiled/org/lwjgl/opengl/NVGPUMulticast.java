/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVGPUMulticast {
    public static final int GL_PER_GPU_STORAGE_BIT_NV = 2048;
    public static final int GL_MULTICAST_GPUS_NV = 37562;
    public static final int GL_RENDER_GPU_MASK_NV = 38232;
    public static final int GL_PER_GPU_STORAGE_NV = 38216;
    public static final int GL_MULTICAST_PROGRAMMABLE_SAMPLE_LOCATION_NV = 38217;

    protected NVGPUMulticast() {
        throw new UnsupportedOperationException();
    }

    public static native void glRenderGpuMaskNV(@NativeType(value="GLbitfield") int var0);

    public static native void nglMulticastBufferSubDataNV(int var0, int var1, long var2, long var4, long var6);

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        NVGPUMulticast.nglMulticastBufferSubDataNV(n2, n3, l2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        NVGPUMulticast.nglMulticastBufferSubDataNV(n2, n3, l2, Integer.toUnsignedLong(shortBuffer.remaining()) << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") IntBuffer intBuffer) {
        NVGPUMulticast.nglMulticastBufferSubDataNV(n2, n3, l2, Integer.toUnsignedLong(intBuffer.remaining()) << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        NVGPUMulticast.nglMulticastBufferSubDataNV(n2, n3, l2, Integer.toUnsignedLong(floatBuffer.remaining()) << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        NVGPUMulticast.nglMulticastBufferSubDataNV(n2, n3, l2, Integer.toUnsignedLong(doubleBuffer.remaining()) << 3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glMulticastCopyBufferSubDataNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLbitfield") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLintptr") long var4, @NativeType(value="GLintptr") long var6, @NativeType(value="GLsizeiptr") long var8);

    public static native void glMulticastCopyImageSubDataNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLbitfield") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLint") int var7, @NativeType(value="GLuint") int var8, @NativeType(value="GLenum") int var9, @NativeType(value="GLint") int var10, @NativeType(value="GLint") int var11, @NativeType(value="GLint") int var12, @NativeType(value="GLint") int var13, @NativeType(value="GLsizei") int var14, @NativeType(value="GLsizei") int var15, @NativeType(value="GLsizei") int var16);

    public static native void glMulticastBlitFramebufferNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLint") int var7, @NativeType(value="GLint") int var8, @NativeType(value="GLint") int var9, @NativeType(value="GLbitfield") int var10, @NativeType(value="GLenum") int var11);

    public static native void nglMulticastFramebufferSampleLocationsfvNV(int var0, int var1, int var2, int var3, long var4);

    public static void glMulticastFramebufferSampleLocationsfvNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        NVGPUMulticast.nglMulticastFramebufferSampleLocationsfvNV(n2, n3, n4, floatBuffer.remaining() >> 1, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glMulticastBarrierNV();

    public static native void glMulticastWaitSyncNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLbitfield") int var1);

    public static native void nglMulticastGetQueryObjectivNV(int var0, int var1, int var2, long var3);

    public static void glMulticastGetQueryObjectivNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        NVGPUMulticast.nglMulticastGetQueryObjectivNV(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glMulticastGetQueryObjectiNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            NVGPUMulticast.nglMulticastGetQueryObjectivNV(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglMulticastGetQueryObjectuivNV(int var0, int var1, int var2, long var3);

    public static void glMulticastGetQueryObjectuivNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        NVGPUMulticast.nglMulticastGetQueryObjectuivNV(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glMulticastGetQueryObjectuiNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            NVGPUMulticast.nglMulticastGetQueryObjectuivNV(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglMulticastGetQueryObjecti64vNV(int var0, int var1, int var2, long var3);

    public static void glMulticastGetQueryObjecti64vNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        NVGPUMulticast.nglMulticastGetQueryObjecti64vNV(n2, n3, n4, MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glMulticastGetQueryObjecti64NV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            NVGPUMulticast.nglMulticastGetQueryObjecti64vNV(n2, n3, n4, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglMulticastGetQueryObjectui64vNV(int var0, int var1, int var2, long var3);

    public static void glMulticastGetQueryObjectui64vNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint64 *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        NVGPUMulticast.nglMulticastGetQueryObjectui64vNV(n2, n3, n4, MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glMulticastGetQueryObjectui64NV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            NVGPUMulticast.nglMulticastGetQueryObjectui64vNV(n2, n3, n4, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") short[] sArray) {
        long l3 = GL.getICD().glMulticastBufferSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, n3, l2, Integer.toUnsignedLong(sArray.length) << 1, sArray, l3);
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") int[] nArray) {
        long l3 = GL.getICD().glMulticastBufferSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, n3, l2, Integer.toUnsignedLong(nArray.length) << 2, nArray, l3);
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") float[] fArray) {
        long l3 = GL.getICD().glMulticastBufferSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, n3, l2, Integer.toUnsignedLong(fArray.length) << 2, fArray, l3);
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") double[] dArray) {
        long l3 = GL.getICD().glMulticastBufferSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, n3, l2, Integer.toUnsignedLong(dArray.length) << 3, dArray, l3);
    }

    public static void glMulticastFramebufferSampleLocationsfvNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMulticastFramebufferSampleLocationsfvNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, fArray.length >> 1, fArray, l2);
    }

    public static void glMulticastGetQueryObjectivNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glMulticastGetQueryObjectivNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glMulticastGetQueryObjectuivNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glMulticastGetQueryObjectuivNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glMulticastGetQueryObjecti64vNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glMulticastGetQueryObjecti64vNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, n4, lArray, l2);
    }

    public static void glMulticastGetQueryObjectui64vNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint64 *") long[] lArray) {
        long l2 = GL.getICD().glMulticastGetQueryObjectui64vNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, n4, lArray, l2);
    }

    static {
        GL.initialize();
    }
}

