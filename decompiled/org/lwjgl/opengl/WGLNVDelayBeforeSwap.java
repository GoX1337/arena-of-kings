/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class WGLNVDelayBeforeSwap {
    protected WGLNVDelayBeforeSwap() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="BOOL")
    public static boolean wglDelayBeforeSwapNV(@NativeType(value="HDC") long l2, @NativeType(value="GLfloat") float f2) {
        long l3 = GL.getCapabilitiesWGL().wglDelayBeforeSwapNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, f2, l3) != 0;
    }
}

