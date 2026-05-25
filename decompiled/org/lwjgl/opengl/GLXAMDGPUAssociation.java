/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLXAMDGPUAssociation {
    public static final int GLX_GPU_VENDOR_AMD = 7936;
    public static final int GLX_GPU_RENDERER_STRING_AMD = 7937;
    public static final int GLX_GPU_OPENGL_VERSION_STRING_AMD = 7938;
    public static final int GLX_GPU_FASTEST_TARGET_GPUS_AMD = 8610;
    public static final int GLX_GPU_RAM_AMD = 8611;
    public static final int GLX_GPU_CLOCK_AMD = 8612;
    public static final int GLX_GPU_NUM_PIPES_AMD = 8613;
    public static final int GLX_GPU_NUM_SIMD_AMD = 8614;
    public static final int GLX_GPU_NUM_RB_AMD = 8615;
    public static final int GLX_GPU_NUM_SPI_AMD = 8616;

    protected GLXAMDGPUAssociation() {
        throw new UnsupportedOperationException();
    }

    public static void glXBlitContextFramebufferAMD(@NativeType(value="GLXContext") long l2, @NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLbitfield") int n10, @NativeType(value="GLenum") int n11) {
        long l3 = GL.getCapabilitiesGLXClient().glXBlitContextFramebufferAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.callPV(l2, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, l3);
    }

    @NativeType(value="GLXContext")
    public static long glXCreateAssociatedContextAMD(@NativeType(value="unsigned int") int n2, @NativeType(value="GLXContext") long l2) {
        long l3 = GL.getCapabilitiesGLXClient().glXCreateAssociatedContextAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPP(n2, l2, l3);
    }

    public static long nglXCreateAssociatedContextAttribsAMD(int n2, long l2, long l3) {
        long l4 = GL.getCapabilitiesGLXClient().glXCreateAssociatedContextAttribsAMD;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        return JNI.callPPP(n2, l2, l3, l4);
    }

    @NativeType(value="GLXContext")
    public static long glXCreateAssociatedContextAttribsAMD(@NativeType(value="unsigned int") int n2, @NativeType(value="GLXContext") long l2, @NativeType(value="int const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT(intBuffer);
        }
        return GLXAMDGPUAssociation.nglXCreateAssociatedContextAttribsAMD(n2, l2, MemoryUtil.memAddress(intBuffer));
    }

    @NativeType(value="Bool")
    public static boolean glXDeleteAssociatedContextAMD(@NativeType(value="GLXContext") long l2) {
        long l3 = GL.getCapabilitiesGLXClient().glXDeleteAssociatedContextAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3) != 0;
    }

    @NativeType(value="unsigned int")
    public static int glXGetContextGPUIDAMD(@NativeType(value="GLXContext") long l2) {
        long l3 = GL.getCapabilitiesGLXClient().glXGetContextGPUIDAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    @NativeType(value="GLXContext")
    public static long glXGetCurrentAssociatedContextAMD() {
        long l2 = GL.getCapabilitiesGLXClient().glXGetCurrentAssociatedContextAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callP(l2);
    }

    @NativeType(value="unsigned int")
    public static int glXGetGPUIDsAMD(@NativeType(value="unsigned int") int n2, @NativeType(value="unsigned int") int n3) {
        long l2 = GL.getCapabilitiesGLXClient().glXGetGPUIDsAMD;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callI(n2, n3, l2);
    }

    public static int nglXGetGPUInfoAMD(int n2, int n3, int n4, int n5, long l2) {
        long l3 = GL.getCapabilitiesGLXClient().glXGetGPUInfoAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return JNI.callPI(n2, n3, n4, n5, l2, l3);
    }

    public static int glXGetGPUInfoAMD(@NativeType(value="unsigned int") int n2, int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        return GLXAMDGPUAssociation.nglXGetGPUInfoAMD(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    @NativeType(value="Bool")
    public static boolean glXMakeAssociatedContextCurrentAMD(@NativeType(value="GLXContext") long l2) {
        long l3 = GL.getCapabilitiesGLXClient().glXMakeAssociatedContextCurrentAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3) != 0;
    }

    @NativeType(value="GLXContext")
    public static long glXCreateAssociatedContextAttribsAMD(@NativeType(value="unsigned int") int n2, @NativeType(value="GLXContext") long l2, @NativeType(value="int const *") int[] nArray) {
        long l3 = GL.getCapabilitiesGLXClient().glXCreateAssociatedContextAttribsAMD;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.checkNT(nArray);
        }
        return JNI.callPPP(n2, l2, nArray, l3);
    }
}

