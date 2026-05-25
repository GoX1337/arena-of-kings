/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLXSGIMakeCurrentRead {
    protected GLXSGIMakeCurrentRead() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="Bool")
    public static boolean glXMakeCurrentReadSGI(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, @NativeType(value="GLXDrawable") long l4, @NativeType(value="GLXContext") long l5) {
        long l6 = GL.getCapabilitiesGLXClient().glXMakeCurrentReadSGI;
        if (Checks.CHECKS) {
            Checks.check(l6);
            Checks.check(l2);
        }
        return JNI.callPPPPI(l2, l3, l4, l5, l6) != 0;
    }

    @NativeType(value="GLXDrawable")
    public static long glXGetCurrentReadDrawableSGI() {
        long l2 = GL.getCapabilitiesGLXClient().glXGetCurrentReadDrawableSGI;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callP(l2);
    }
}

