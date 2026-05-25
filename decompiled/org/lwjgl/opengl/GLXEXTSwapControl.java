/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLXEXTSwapControl {
    public static final int GLX_SWAP_INTERVAL_EXT = 8433;
    public static final int GLX_MAX_SWAP_INTERVAL_EXT = 8434;

    protected GLXEXTSwapControl() {
        throw new UnsupportedOperationException();
    }

    public static void glXSwapIntervalEXT(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, int n2) {
        long l4 = GL.getCapabilitiesGLXClient().glXSwapIntervalEXT;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPV(l2, l3, n2, l4);
    }
}

