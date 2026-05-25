/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLXNVDelayBeforeSwap {
    protected GLXNVDelayBeforeSwap() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="Bool")
    public static boolean glXDelayBeforeSwapNV(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, @NativeType(value="GLfloat") float f2) {
        long l4 = GL.getCapabilitiesGLXClient().glXDelayBeforeSwapNV;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPI(l2, l3, f2, l4) != 0;
    }
}

