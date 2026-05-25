/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLXSGIXSwapGroup {
    protected GLXSGIXSwapGroup() {
        throw new UnsupportedOperationException();
    }

    public static void glXJoinSwapGroupSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, @NativeType(value="GLXDrawable") long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXJoinSwapGroupSGIX;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPPV(l2, l3, l4, l5);
    }
}

