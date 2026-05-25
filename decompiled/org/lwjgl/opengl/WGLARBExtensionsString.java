/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLARBExtensionsString {
    protected WGLARBExtensionsString() {
        throw new UnsupportedOperationException();
    }

    public static long nwglGetExtensionsStringARB(long l2) {
        long l3 = GL.getCapabilitiesWGL().wglGetExtensionsStringARB;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPP(l2, l3);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String wglGetExtensionsStringARB(@NativeType(value="HDC") long l2) {
        long l3 = WGLARBExtensionsString.nwglGetExtensionsStringARB(l2);
        return MemoryUtil.memASCIISafe(l3);
    }
}

