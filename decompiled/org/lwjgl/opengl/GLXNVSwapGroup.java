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

public class GLXNVSwapGroup {
    protected GLXNVSwapGroup() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="Bool")
    public static boolean glXJoinSwapGroupNV(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, @NativeType(value="GLuint") int n2) {
        long l4 = GL.getCapabilitiesGLXClient().glXJoinSwapGroupNV;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPI(l2, l3, n2, l4) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXBindSwapBarrierNV(@NativeType(value="Display *") long l2, @NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        long l3 = GL.getCapabilitiesGLXClient().glXBindSwapBarrierNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, n2, n3, l3) != 0;
    }

    public static int nglXQuerySwapGroupNV(long l2, long l3, long l4, long l5) {
        long l6 = GL.getCapabilitiesGLXClient().glXQuerySwapGroupNV;
        if (Checks.CHECKS) {
            Checks.check(l6);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPPPI(l2, l3, l4, l5, l6);
    }

    @NativeType(value="Bool")
    public static boolean glXQuerySwapGroupNV(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, @NativeType(value="GLuint *") IntBuffer intBuffer, @NativeType(value="GLuint *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        return GLXNVSwapGroup.nglXQuerySwapGroupNV(l2, l3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2)) != 0;
    }

    public static int nglXQueryMaxSwapGroupsNV(long l2, int n2, long l3, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXQueryMaxSwapGroupsNV;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
        }
        return JNI.callPPPI(l2, n2, l3, l4, l5);
    }

    @NativeType(value="Bool")
    public static boolean glXQueryMaxSwapGroupsNV(@NativeType(value="Display *") long l2, int n2, @NativeType(value="GLuint *") IntBuffer intBuffer, @NativeType(value="GLuint *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        return GLXNVSwapGroup.nglXQueryMaxSwapGroupsNV(l2, n2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2)) != 0;
    }

    public static int nglXQueryFrameCountNV(long l2, int n2, long l3) {
        long l4 = GL.getCapabilitiesGLXClient().glXQueryFrameCountNV;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, l3, l4);
    }

    @NativeType(value="Bool")
    public static boolean glXQueryFrameCountNV(@NativeType(value="Display *") long l2, int n2, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return GLXNVSwapGroup.nglXQueryFrameCountNV(l2, n2, MemoryUtil.memAddress(intBuffer)) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXResetFrameCountNV(@NativeType(value="Display *") long l2, int n2) {
        long l3 = GL.getCapabilitiesGLXClient().glXResetFrameCountNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, n2, l3) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXQuerySwapGroupNV(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, @NativeType(value="GLuint *") int[] nArray, @NativeType(value="GLuint *") int[] nArray2) {
        long l4 = GL.getCapabilitiesGLXClient().glXQuerySwapGroupNV;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
        }
        return JNI.callPPPPI(l2, l3, nArray, nArray2, l4) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXQueryMaxSwapGroupsNV(@NativeType(value="Display *") long l2, int n2, @NativeType(value="GLuint *") int[] nArray, @NativeType(value="GLuint *") int[] nArray2) {
        long l3 = GL.getCapabilitiesGLXClient().glXQueryMaxSwapGroupsNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
        }
        return JNI.callPPPI(l2, n2, nArray, nArray2, l3) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXQueryFrameCountNV(@NativeType(value="Display *") long l2, int n2, @NativeType(value="GLuint *") int[] nArray) {
        long l3 = GL.getCapabilitiesGLXClient().glXQueryFrameCountNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        return JNI.callPPI(l2, n2, nArray, l3) != 0;
    }
}

