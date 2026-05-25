/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class WGLARBMakeCurrentRead {
    public static final int ERROR_INVALID_PIXEL_TYPE_ARB = 8259;
    public static final int ERROR_INCOMPATIBLE_DEVICE_CONTEXTS_ARB = 8276;

    protected WGLARBMakeCurrentRead() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="BOOL")
    public static boolean wglMakeContextCurrentARB(@NativeType(value="HDC") long l2, @NativeType(value="HDC") long l3, @NativeType(value="HGLRC") long l4) {
        long l5 = GL.getCapabilitiesWGL().wglMakeContextCurrentARB;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(l4);
        }
        return JNI.callPPPI(l2, l3, l4, l5) != 0;
    }

    @NativeType(value="HDC")
    public static long wglGetCurrentReadDCARB() {
        long l2 = GL.getCapabilitiesWGL().wglGetCurrentReadDCARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callP(l2);
    }
}

