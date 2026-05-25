/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class WGLARBBufferRegion {
    public static final int WGL_FRONT_COLOR_BUFFER_BIT_ARB = 1;
    public static final int WGL_BACK_COLOR_BUFFER_BIT_ARB = 2;
    public static final int WGL_DEPTH_BUFFER_BIT_ARB = 4;
    public static final int WGL_STENCIL_BUFFER_BIT_ARB = 8;

    protected WGLARBBufferRegion() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="HANDLE")
    public static long wglCreateBufferRegionARB(@NativeType(value="HDC") long l2, int n2, @NativeType(value="UINT") int n3) {
        long l3 = GL.getCapabilitiesWGL().wglCreateBufferRegionARB;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPP(l2, n2, n3, l3);
    }

    @NativeType(value="VOID")
    public static void wglDeleteBufferRegionARB(@NativeType(value="HANDLE") long l2) {
        long l3 = GL.getCapabilitiesWGL().wglDeleteBufferRegionARB;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.callPV(l2, l3);
    }

    @NativeType(value="BOOL")
    public static boolean wglSaveBufferRegionARB(@NativeType(value="HANDLE") long l2, int n2, int n3, int n4, int n5) {
        long l3 = GL.getCapabilitiesWGL().wglSaveBufferRegionARB;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, n2, n3, n4, n5, l3) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglRestoreBufferRegionARB(@NativeType(value="HANDLE") long l2, int n2, int n3, int n4, int n5, int n6, int n7) {
        long l3 = GL.getCapabilitiesWGL().wglRestoreBufferRegionARB;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, n2, n3, n4, n5, n6, n7, l3) != 0;
    }
}

