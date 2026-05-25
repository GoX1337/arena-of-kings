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
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLARBPbuffer {
    public static final int WGL_DRAW_TO_PBUFFER_ARB = 8237;
    public static final int WGL_MAX_PBUFFER_PIXELS_ARB = 8238;
    public static final int WGL_MAX_PBUFFER_WIDTH_ARB = 8239;
    public static final int WGL_MAX_PBUFFER_HEIGHT_ARB = 8240;
    public static final int WGL_PBUFFER_LARGEST_ARB = 8243;
    public static final int WGL_PBUFFER_WIDTH_ARB = 8244;
    public static final int WGL_PBUFFER_HEIGHT_ARB = 8245;
    public static final int WGL_PBUFFER_LOST_ARB = 8246;

    protected WGLARBPbuffer() {
        throw new UnsupportedOperationException();
    }

    public static long nwglCreatePbufferARB(long l2, int n2, int n3, int n4, long l3) {
        long l4 = GL.getCapabilitiesWGL().wglCreatePbufferARB;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        return JNI.callPPP(l2, n2, n3, n4, l3, l4);
    }

    @NativeType(value="HPBUFFERARB")
    public static long wglCreatePbufferARB(@NativeType(value="HDC") long l2, int n2, int n3, int n4, @Nullable @NativeType(value="int const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(intBuffer);
        }
        return WGLARBPbuffer.nwglCreatePbufferARB(l2, n2, n3, n4, MemoryUtil.memAddressSafe(intBuffer));
    }

    @NativeType(value="HDC")
    public static long wglGetPbufferDCARB(@NativeType(value="HPBUFFERARB") long l2) {
        long l3 = GL.getCapabilitiesWGL().wglGetPbufferDCARB;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPP(l2, l3);
    }

    public static int wglReleasePbufferDCARB(@NativeType(value="HPBUFFERARB") long l2, @NativeType(value="HDC") long l3) {
        long l4 = GL.getCapabilitiesWGL().wglReleasePbufferDCARB;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPI(l2, l3, l4);
    }

    @NativeType(value="BOOL")
    public static boolean wglDestroyPbufferARB(@NativeType(value="HPBUFFERARB") long l2) {
        long l3 = GL.getCapabilitiesWGL().wglDestroyPbufferARB;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3) != 0;
    }

    public static int nwglQueryPbufferARB(long l2, int n2, long l3) {
        long l4 = GL.getCapabilitiesWGL().wglQueryPbufferARB;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, l3, l4);
    }

    @NativeType(value="BOOL")
    public static boolean wglQueryPbufferARB(@NativeType(value="HPBUFFERARB") long l2, int n2, @NativeType(value="int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return WGLARBPbuffer.nwglQueryPbufferARB(l2, n2, MemoryUtil.memAddress(intBuffer)) != 0;
    }

    @NativeType(value="HPBUFFERARB")
    public static long wglCreatePbufferARB(@NativeType(value="HDC") long l2, int n2, int n3, int n4, @Nullable @NativeType(value="int const *") int[] nArray) {
        long l3 = GL.getCapabilitiesWGL().wglCreatePbufferARB;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.checkNTSafe(nArray);
        }
        return JNI.callPPP(l2, n2, n3, n4, nArray, l3);
    }

    @NativeType(value="BOOL")
    public static boolean wglQueryPbufferARB(@NativeType(value="HPBUFFERARB") long l2, int n2, @NativeType(value="int *") int[] nArray) {
        long l3 = GL.getCapabilitiesWGL().wglQueryPbufferARB;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        return JNI.callPPI(l2, n2, nArray, l3) != 0;
    }
}

