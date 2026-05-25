/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLX;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLX11
extends GLX {
    public static final int GLX_VENDOR = 1;
    public static final int GLX_VERSION = 2;
    public static final int GLX_EXTENSIONS = 3;

    protected GLX11() {
        throw new UnsupportedOperationException();
    }

    public static long nglXQueryExtensionsString(long l2, int n2) {
        long l3 = GL.getCapabilitiesGLXClient().glXQueryExtensionsString;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPP(l2, n2, l3);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glXQueryExtensionsString(@NativeType(value="Display *") long l2, int n2) {
        long l3 = GLX11.nglXQueryExtensionsString(l2, n2);
        return MemoryUtil.memASCIISafe(l3);
    }

    public static long nglXGetClientString(long l2, int n2) {
        long l3 = GL.getCapabilitiesGLXClient().glXGetClientString;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPP(l2, n2, l3);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glXGetClientString(@NativeType(value="Display *") long l2, int n2) {
        long l3 = GLX11.nglXGetClientString(l2, n2);
        return MemoryUtil.memASCIISafe(l3);
    }

    public static long nglXQueryServerString(long l2, int n2, int n3) {
        long l3 = GL.getCapabilitiesGLXClient().glXQueryServerString;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPP(l2, n2, n3, l3);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glXQueryServerString(@NativeType(value="Display *") long l2, int n2, int n3) {
        long l3 = GLX11.nglXQueryServerString(l2, n2, n3);
        return MemoryUtil.memASCIISafe(l3);
    }
}

