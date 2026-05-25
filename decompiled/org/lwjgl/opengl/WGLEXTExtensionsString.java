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

public class WGLEXTExtensionsString {
    protected WGLEXTExtensionsString() {
        throw new UnsupportedOperationException();
    }

    public static long nwglGetExtensionsStringEXT() {
        long l2 = GL.getCapabilitiesWGL().wglGetExtensionsStringEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callP(l2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String wglGetExtensionsStringEXT() {
        long l2 = WGLEXTExtensionsString.nwglGetExtensionsStringEXT();
        return MemoryUtil.memASCIISafe(l2);
    }
}

