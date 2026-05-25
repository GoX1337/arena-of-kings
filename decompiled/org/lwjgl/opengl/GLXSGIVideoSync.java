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

public class GLXSGIVideoSync {
    protected GLXSGIVideoSync() {
        throw new UnsupportedOperationException();
    }

    public static int nglXGetVideoSyncSGI(long l2) {
        long l3 = GL.getCapabilitiesGLXClient().glXGetVideoSyncSGI;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return JNI.callPI(l2, l3);
    }

    @NativeType(value="GLint")
    public static int glXGetVideoSyncSGI(@NativeType(value="unsigned int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return GLXSGIVideoSync.nglXGetVideoSyncSGI(MemoryUtil.memAddress(intBuffer));
    }

    public static int nglXWaitVideoSyncSGI(int n2, int n3, long l2) {
        long l3 = GL.getCapabilitiesGLXClient().glXWaitVideoSyncSGI;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return JNI.callPI(n2, n3, l2, l3);
    }

    @NativeType(value="GLint")
    public static int glXWaitVideoSyncSGI(int n2, int n3, @NativeType(value="unsigned int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return GLXSGIVideoSync.nglXWaitVideoSyncSGI(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    @NativeType(value="GLint")
    public static int glXGetVideoSyncSGI(@NativeType(value="unsigned int *") int[] nArray) {
        long l2 = GL.getCapabilitiesGLXClient().glXGetVideoSyncSGI;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        return JNI.callPI(nArray, l2);
    }

    @NativeType(value="GLint")
    public static int glXWaitVideoSyncSGI(int n2, int n3, @NativeType(value="unsigned int *") int[] nArray) {
        long l2 = GL.getCapabilitiesGLXClient().glXWaitVideoSyncSGI;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        return JNI.callPI(n2, n3, nArray, l2);
    }
}

