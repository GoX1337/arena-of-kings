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

public class WGLNVSwapGroup {
    protected WGLNVSwapGroup() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="BOOL")
    public static boolean wglJoinSwapGroupNV(@NativeType(value="HDC") long l2, @NativeType(value="GLuint") int n2) {
        long l3 = GL.getCapabilitiesWGL().wglJoinSwapGroupNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, n2, l3) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglBindSwapBarrierNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        long l2 = GL.getCapabilitiesWGL().wglBindSwapBarrierNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callI(n2, n3, l2) != 0;
    }

    public static int nwglQuerySwapGroupNV(long l2, long l3, long l4) {
        long l5 = GL.getCapabilitiesWGL().wglQuerySwapGroupNV;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
        }
        return JNI.callPPPI(l2, l3, l4, l5);
    }

    @NativeType(value="BOOL")
    public static boolean wglQuerySwapGroupNV(@NativeType(value="HDC") long l2, @NativeType(value="GLuint *") IntBuffer intBuffer, @NativeType(value="GLuint *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        return WGLNVSwapGroup.nwglQuerySwapGroupNV(l2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2)) != 0;
    }

    public static int nwglQueryMaxSwapGroupsNV(long l2, long l3, long l4) {
        long l5 = GL.getCapabilitiesWGL().wglQueryMaxSwapGroupsNV;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
        }
        return JNI.callPPPI(l2, l3, l4, l5);
    }

    @NativeType(value="BOOL")
    public static boolean wglQueryMaxSwapGroupsNV(@NativeType(value="HDC") long l2, @NativeType(value="GLuint *") IntBuffer intBuffer, @NativeType(value="GLuint *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        return WGLNVSwapGroup.nwglQueryMaxSwapGroupsNV(l2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2)) != 0;
    }

    public static int nwglQueryFrameCountNV(long l2, long l3) {
        long l4 = GL.getCapabilitiesWGL().wglQueryFrameCountNV;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        return JNI.callPPI(l2, l3, l4);
    }

    @NativeType(value="BOOL")
    public static boolean wglQueryFrameCountNV(@NativeType(value="HDC") long l2, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return WGLNVSwapGroup.nwglQueryFrameCountNV(l2, MemoryUtil.memAddress(intBuffer)) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglResetFrameCountNV(@NativeType(value="HDC") long l2) {
        long l3 = GL.getCapabilitiesWGL().wglResetFrameCountNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglQuerySwapGroupNV(@NativeType(value="HDC") long l2, @NativeType(value="GLuint *") int[] nArray, @NativeType(value="GLuint *") int[] nArray2) {
        long l3 = GL.getCapabilitiesWGL().wglQuerySwapGroupNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
        }
        return JNI.callPPPI(l2, nArray, nArray2, l3) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglQueryMaxSwapGroupsNV(@NativeType(value="HDC") long l2, @NativeType(value="GLuint *") int[] nArray, @NativeType(value="GLuint *") int[] nArray2) {
        long l3 = GL.getCapabilitiesWGL().wglQueryMaxSwapGroupsNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
        }
        return JNI.callPPPI(l2, nArray, nArray2, l3) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglQueryFrameCountNV(@NativeType(value="HDC") long l2, @NativeType(value="GLuint *") int[] nArray) {
        long l3 = GL.getCapabilitiesWGL().wglQueryFrameCountNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        return JNI.callPPI(l2, nArray, l3) != 0;
    }
}

