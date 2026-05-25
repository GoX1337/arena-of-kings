/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.CLongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLXSGIXPbuffer {
    public static final int GLX_MAX_PBUFFER_WIDTH_SGIX = 32790;
    public static final int GLX_MAX_PBUFFER_HEIGHT_SGIX = 32791;
    public static final int GLX_MAX_PBUFFER_PIXELS_SGIX = 32792;
    public static final int GLX_OPTIMAL_PBUFFER_WIDTH_SGIX = 32793;
    public static final int GLX_OPTIMAL_PBUFFER_HEIGHT_SGIX = 32794;
    public static final int GLX_PBUFFER_BIT_SGIX = 4;
    public static final int GLX_PRESERVED_CONTENTS_SGIX = 32795;
    public static final int GLX_LARGEST_PBUFFER_SGIX = 32796;
    public static final int GLX_WIDTH_SGIX = 32797;
    public static final int GLX_HEIGHT_SGIX = 32798;
    public static final int GLX_EVENT_MASK_SGIX = 32799;
    public static final int GLX_BUFFER_CLOBBER_MASK_SGIX = 0x8000000;
    public static final int GLX_DAMAGED_SGIX = 32800;
    public static final int GLX_SAVED_SGIX = 32801;
    public static final int GLX_WINDOW_SGIX = 32802;
    public static final int GLX_PBUFFER_SGIX = 32803;
    public static final int GLX_FRONT_LEFT_BUFFER_BIT_SGIX = 1;
    public static final int GLX_FRONT_RIGHT_BUFFER_BIT_SGIX = 2;
    public static final int GLX_BACK_LEFT_BUFFER_BIT_SGIX = 4;
    public static final int GLX_BACK_RIGHT_BUFFER_BIT_SGIX = 8;
    public static final int GLX_AUX_BUFFERS_BIT_SGIX = 16;
    public static final int GLX_DEPTH_BUFFER_BIT_SGIX = 32;
    public static final int GLX_STENCIL_BUFFER_BIT_SGIX = 64;
    public static final int GLX_ACCUM_BUFFER_BIT_SGIX = 128;
    public static final int GLX_SAMPLE_BUFFERS_BIT_SGIX = 256;

    protected GLXSGIXPbuffer() {
        throw new UnsupportedOperationException();
    }

    public static long nglXCreateGLXPbufferSGIX(long l2, long l3, int n2, int n3, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXCreateGLXPbufferSGIX;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPPP(l2, l3, n2, n3, l4, l5);
    }

    @NativeType(value="GLXPbuffer")
    public static long glXCreateGLXPbufferSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, @NativeType(value="unsigned int") int n2, @NativeType(value="unsigned int") int n3, @Nullable @NativeType(value="int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(intBuffer);
        }
        return GLXSGIXPbuffer.nglXCreateGLXPbufferSGIX(l2, l3, n2, n3, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glXDestroyGLXPbufferSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXPbuffer") long l3) {
        long l4 = GL.getCapabilitiesGLXClient().glXDestroyGLXPbufferSGIX;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPV(l2, l3, l4);
    }

    public static void nglXQueryGLXPbufferSGIX(long l2, long l3, int n2, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXQueryGLXPbufferSGIX;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPPV(l2, l3, n2, l4, l5);
    }

    public static void glXQueryGLXPbufferSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXPbuffer") long l3, int n2, @NativeType(value="unsigned int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GLXSGIXPbuffer.nglXQueryGLXPbufferSGIX(l2, l3, n2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glXSelectEventSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, @NativeType(value="unsigned long") long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXSelectEventSGIX;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPNV(l2, l3, l4, l5);
    }

    public static void nglXGetSelectedEventSGIX(long l2, long l3, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXGetSelectedEventSGIX;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPPV(l2, l3, l4, l5);
    }

    public static void glXGetSelectedEventSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, @NativeType(value="unsigned long *") CLongBuffer cLongBuffer) {
        if (Checks.CHECKS) {
            Checks.check(cLongBuffer, 1);
        }
        GLXSGIXPbuffer.nglXGetSelectedEventSGIX(l2, l3, MemoryUtil.memAddress(cLongBuffer));
    }

    @NativeType(value="GLXPbuffer")
    public static long glXCreateGLXPbufferSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, @NativeType(value="unsigned int") int n2, @NativeType(value="unsigned int") int n3, @Nullable @NativeType(value="int *") int[] nArray) {
        long l4 = GL.getCapabilitiesGLXClient().glXCreateGLXPbufferSGIX;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
            Checks.checkNTSafe(nArray);
        }
        return JNI.callPPPP(l2, l3, n2, n3, nArray, l4);
    }

    public static void glXQueryGLXPbufferSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXPbuffer") long l3, int n2, @NativeType(value="unsigned int *") int[] nArray) {
        long l4 = GL.getCapabilitiesGLXClient().glXQueryGLXPbufferSGIX;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(nArray, 1);
        }
        JNI.callPPPV(l2, l3, n2, nArray, l4);
    }
}

