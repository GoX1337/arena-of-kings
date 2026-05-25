/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLXEXTImportContext {
    public static final int GLX_SHARE_CONTEXT_EXT = 32778;
    public static final int GLX_VISUAL_ID_EXT = 32779;
    public static final int GLX_SCREEN_EXT = 32780;

    protected GLXEXTImportContext() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="Display *")
    public static long glXGetCurrentDisplayEXT() {
        long l2 = GL.getCapabilitiesGLXClient().glXGetCurrentDisplayEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callP(l2);
    }

    public static int nglXQueryContextInfoEXT(long l2, long l3, int n2, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXQueryContextInfoEXT;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPPI(l2, l3, n2, l4, l5);
    }

    public static int glXQueryContextInfoEXT(@NativeType(value="Display *") long l2, @NativeType(value="GLXContext") long l3, int n2, @NativeType(value="int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return GLXEXTImportContext.nglXQueryContextInfoEXT(l2, l3, n2, MemoryUtil.memAddress(intBuffer));
    }

    @NativeType(value="GLXContextID")
    public static long glXGetContextIDEXT(@NativeType(value="GLXContext const") long l2) {
        long l3 = GL.getCapabilitiesGLXClient().glXGetContextIDEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPN(l2, l3);
    }

    @NativeType(value="GLXContext")
    public static long glXImportContextEXT(@NativeType(value="Display *") long l2, @NativeType(value="GLXContextID") long l3) {
        long l4 = GL.getCapabilitiesGLXClient().glXImportContextEXT;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        return JNI.callPNP(l2, l3, l4);
    }

    public static void glXFreeContextEXT(@NativeType(value="Display *") long l2, @NativeType(value="GLXContext") long l3) {
        long l4 = GL.getCapabilitiesGLXClient().glXFreeContextEXT;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPV(l2, l3, l4);
    }

    public static int glXQueryContextInfoEXT(@NativeType(value="Display *") long l2, @NativeType(value="GLXContext") long l3, int n2, @NativeType(value="int *") int[] nArray) {
        long l4 = GL.getCapabilitiesGLXClient().glXQueryContextInfoEXT;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(nArray, 1);
        }
        return JNI.callPPPI(l2, l3, n2, nArray, l4);
    }
}

