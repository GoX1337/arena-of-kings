/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class WGLEXTSwapControl {
    protected WGLEXTSwapControl() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="BOOL")
    public static boolean wglSwapIntervalEXT(int n2) {
        long l2 = GL.getCapabilitiesWGL().wglSwapIntervalEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callI(n2, l2) != 0;
    }

    public static int wglGetSwapIntervalEXT() {
        long l2 = GL.getCapabilitiesWGL().wglGetSwapIntervalEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callI(l2);
    }
}

