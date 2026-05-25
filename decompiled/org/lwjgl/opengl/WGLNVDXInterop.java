/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLNVDXInterop {
    public static final int WGL_ACCESS_READ_ONLY_NV = 0;
    public static final int WGL_ACCESS_READ_WRITE_NV = 1;
    public static final int WGL_ACCESS_WRITE_DISCARD_NV = 2;

    protected WGLNVDXInterop() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="BOOL")
    public static boolean wglDXSetResourceShareHandleNV(@NativeType(value="void *") long l2, @NativeType(value="HANDLE") long l3) {
        long l4 = GL.getCapabilitiesWGL().wglDXSetResourceShareHandleNV;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPI(l2, l3, l4) != 0;
    }

    @NativeType(value="HANDLE")
    public static long wglDXOpenDeviceNV(@NativeType(value="void *") long l2) {
        long l3 = GL.getCapabilitiesWGL().wglDXOpenDeviceNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPP(l2, l3);
    }

    @NativeType(value="BOOL")
    public static boolean wglDXCloseDeviceNV(@NativeType(value="HANDLE") long l2) {
        long l3 = GL.getCapabilitiesWGL().wglDXCloseDeviceNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3) != 0;
    }

    @NativeType(value="HANDLE")
    public static long wglDXRegisterObjectNV(@NativeType(value="HANDLE") long l2, @NativeType(value="void *") long l3, @NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        long l4 = GL.getCapabilitiesWGL().wglDXRegisterObjectNV;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPP(l2, l3, n2, n3, n4, l4);
    }

    @NativeType(value="BOOL")
    public static boolean wglDXUnregisterObjectNV(@NativeType(value="HANDLE") long l2, @NativeType(value="HANDLE") long l3) {
        long l4 = GL.getCapabilitiesWGL().wglDXUnregisterObjectNV;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPI(l2, l3, l4) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglDXObjectAccessNV(@NativeType(value="HANDLE") long l2, @NativeType(value="GLenum") int n2) {
        long l3 = GL.getCapabilitiesWGL().wglDXObjectAccessNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, n2, l3) != 0;
    }

    public static int nwglDXLockObjectsNV(long l2, int n2, long l3) {
        long l4 = GL.getCapabilitiesWGL().wglDXLockObjectsNV;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, l3, l4);
    }

    @NativeType(value="BOOL")
    public static boolean wglDXLockObjectsNV(@NativeType(value="HANDLE") long l2, @NativeType(value="HANDLE *") PointerBuffer pointerBuffer) {
        return WGLNVDXInterop.nwglDXLockObjectsNV(l2, pointerBuffer.remaining(), MemoryUtil.memAddress(pointerBuffer)) != 0;
    }

    public static int nwglDXUnlockObjectsNV(long l2, int n2, long l3) {
        long l4 = GL.getCapabilitiesWGL().wglDXUnlockObjectsNV;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, l3, l4);
    }

    @NativeType(value="BOOL")
    public static boolean wglDXUnlockObjectsNV(@NativeType(value="HANDLE") long l2, @NativeType(value="HANDLE *") PointerBuffer pointerBuffer) {
        return WGLNVDXInterop.nwglDXUnlockObjectsNV(l2, pointerBuffer.remaining(), MemoryUtil.memAddress(pointerBuffer)) != 0;
    }
}

