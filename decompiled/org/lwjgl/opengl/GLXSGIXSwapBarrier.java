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

public class GLXSGIXSwapBarrier {
    protected GLXSGIXSwapBarrier() {
        throw new UnsupportedOperationException();
    }

    public static void glXBindSwapBarrierSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, int n2) {
        long l4 = GL.getCapabilitiesGLXClient().glXBindSwapBarrierSGIX;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPV(l2, l3, n2, l4);
    }

    public static int nglXQueryMaxSwapBarriersSGIX(long l2, int n2, long l3) {
        long l4 = GL.getCapabilitiesGLXClient().glXQueryMaxSwapBarriersSGIX;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, l3, l4);
    }

    @NativeType(value="Bool")
    public static boolean glXQueryMaxSwapBarriersSGIX(@NativeType(value="Display *") long l2, int n2, @NativeType(value="int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return GLXSGIXSwapBarrier.nglXQueryMaxSwapBarriersSGIX(l2, n2, MemoryUtil.memAddress(intBuffer)) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXQueryMaxSwapBarriersSGIX(@NativeType(value="Display *") long l2, int n2, @NativeType(value="int *") int[] nArray) {
        long l3 = GL.getCapabilitiesGLXClient().glXQueryMaxSwapBarriersSGIX;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        return JNI.callPPI(l2, n2, nArray, l3) != 0;
    }
}

