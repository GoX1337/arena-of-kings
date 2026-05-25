/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLAMDGPUAssociation {
    public static final int WGL_GPU_VENDOR_AMD = 7936;
    public static final int WGL_GPU_RENDERER_STRING_AMD = 7937;
    public static final int WGL_GPU_OPENGL_VERSION_STRING_AMD = 7938;
    public static final int WGL_GPU_FASTEST_TARGET_GPUS_AMD = 8610;
    public static final int WGL_GPU_RAM_AMD = 8611;
    public static final int WGL_GPU_CLOCK_AMD = 8612;
    public static final int WGL_GPU_NUM_PIPES_AMD = 8613;
    public static final int WGL_GPU_NUM_SIMD_AMD = 8614;
    public static final int WGL_GPU_NUM_RB_AMD = 8615;
    public static final int WGL_GPU_NUM_SPI_AMD = 8616;

    protected WGLAMDGPUAssociation() {
        throw new UnsupportedOperationException();
    }

    public static int nwglGetGPUIDsAMD(int n2, long l2) {
        long l3 = GL.getCapabilitiesWGL().wglGetGPUIDsAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return JNI.callPI(n2, l2, l3);
    }

    @NativeType(value="UINT")
    public static int wglGetGPUIDsAMD(@Nullable @NativeType(value="UINT *") IntBuffer intBuffer) {
        return WGLAMDGPUAssociation.nwglGetGPUIDsAMD(Checks.remainingSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer));
    }

    public static int nwglGetGPUInfoAMD(int n2, int n3, int n4, int n5, long l2) {
        long l3 = GL.getCapabilitiesWGL().wglGetGPUInfoAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return JNI.callPI(n2, n3, n4, n5, l2, l3);
    }

    public static int wglGetGPUInfoAMD(@NativeType(value="UINT") int n2, int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        return WGLAMDGPUAssociation.nwglGetGPUInfoAMD(n2, n3, n4, byteBuffer.remaining() >> GLChecks.typeToByteShift(n4), MemoryUtil.memAddress(byteBuffer));
    }

    public static int wglGetGPUInfoAMD(@NativeType(value="UINT") int n2, int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") IntBuffer intBuffer) {
        return WGLAMDGPUAssociation.nwglGetGPUInfoAMD(n2, n3, n4, (int)((long)intBuffer.remaining() << 2 >> GLChecks.typeToByteShift(n4)), MemoryUtil.memAddress(intBuffer));
    }

    public static int wglGetGPUInfoAMD(@NativeType(value="UINT") int n2, int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") FloatBuffer floatBuffer) {
        return WGLAMDGPUAssociation.nwglGetGPUInfoAMD(n2, n3, n4, (int)((long)floatBuffer.remaining() << 2 >> GLChecks.typeToByteShift(n4)), MemoryUtil.memAddress(floatBuffer));
    }

    @NativeType(value="UINT")
    public static int wglGetContextGPUIDAMD(@NativeType(value="HGLRC") long l2) {
        long l3 = GL.getCapabilitiesWGL().wglGetContextGPUIDAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    @NativeType(value="HGLRC")
    public static long wglCreateAssociatedContextAMD(@NativeType(value="UINT") int n2) {
        long l2 = GL.getCapabilitiesWGL().wglCreateAssociatedContextAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callP(n2, l2);
    }

    public static long nwglCreateAssociatedContextAttribsAMD(int n2, long l2, long l3) {
        long l4 = GL.getCapabilitiesWGL().wglCreateAssociatedContextAttribsAMD;
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        return JNI.callPPP(n2, l2, l3, l4);
    }

    @NativeType(value="HGLRC")
    public static long wglCreateAssociatedContextAttribsAMD(@NativeType(value="UINT") int n2, @NativeType(value="HGLRC") long l2, @Nullable @NativeType(value="int const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(intBuffer);
        }
        return WGLAMDGPUAssociation.nwglCreateAssociatedContextAttribsAMD(n2, l2, MemoryUtil.memAddressSafe(intBuffer));
    }

    @NativeType(value="BOOL")
    public static boolean wglDeleteAssociatedContextAMD(@NativeType(value="HGLRC") long l2) {
        long l3 = GL.getCapabilitiesWGL().wglDeleteAssociatedContextAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglMakeAssociatedContextCurrentAMD(@NativeType(value="HGLRC") long l2) {
        long l3 = GL.getCapabilitiesWGL().wglMakeAssociatedContextCurrentAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3) != 0;
    }

    @NativeType(value="HGLRC")
    public static long wglGetCurrentAssociatedContextAMD() {
        long l2 = GL.getCapabilitiesWGL().wglGetCurrentAssociatedContextAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callP(l2);
    }

    @NativeType(value="VOID")
    public static void wglBlitContextFramebufferAMD(@NativeType(value="HGLRC") long l2, @NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLbitfield") int n10, @NativeType(value="GLenum") int n11) {
        long l3 = GL.getCapabilitiesWGL().wglBlitContextFramebufferAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.callPV(l2, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, l3);
    }

    @NativeType(value="UINT")
    public static int wglGetGPUIDsAMD(@Nullable @NativeType(value="UINT *") int[] nArray) {
        long l2 = GL.getCapabilitiesWGL().wglGetGPUIDsAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(Checks.lengthSafe(nArray), nArray, l2);
    }

    public static int wglGetGPUInfoAMD(@NativeType(value="UINT") int n2, int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getCapabilitiesWGL().wglGetGPUInfoAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(n2, n3, n4, nArray.length, nArray, l2);
    }

    public static int wglGetGPUInfoAMD(@NativeType(value="UINT") int n2, int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getCapabilitiesWGL().wglGetGPUInfoAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(n2, n3, n4, fArray.length, fArray, l2);
    }

    @NativeType(value="HGLRC")
    public static long wglCreateAssociatedContextAttribsAMD(@NativeType(value="UINT") int n2, @NativeType(value="HGLRC") long l2, @Nullable @NativeType(value="int const *") int[] nArray) {
        long l3 = GL.getCapabilitiesWGL().wglCreateAssociatedContextAttribsAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.checkNTSafe(nArray);
        }
        return JNI.callPPP(n2, l2, nArray, l3);
    }
}

