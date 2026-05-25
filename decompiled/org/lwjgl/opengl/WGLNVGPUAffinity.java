/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GPU_DEVICE;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLNVGPUAffinity {
    public static final int ERROR_INCOMPATIBLE_AFFINITY_MASKS_NV = 8400;
    public static final int ERROR_MISSING_AFFINITY_MASK_NV = 8401;

    protected WGLNVGPUAffinity() {
        throw new UnsupportedOperationException();
    }

    public static int nwglEnumGpusNV(int n2, long l2) {
        long l3 = GL.getCapabilitiesWGL().wglEnumGpusNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return JNI.callPI(n2, l2, l3);
    }

    @NativeType(value="BOOL")
    public static boolean wglEnumGpusNV(@NativeType(value="UINT") int n2, @NativeType(value="HGPUNV *") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        return WGLNVGPUAffinity.nwglEnumGpusNV(n2, MemoryUtil.memAddress(pointerBuffer)) != 0;
    }

    public static int nwglEnumGpuDevicesNV(long l2, int n2, long l3) {
        long l4 = GL.getCapabilitiesWGL().wglEnumGpuDevicesNV;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, l3, l4);
    }

    @NativeType(value="BOOL")
    public static boolean wglEnumGpuDevicesNV(@NativeType(value="HGPUNV") long l2, @NativeType(value="UINT") int n2, @NativeType(value="PGPU_DEVICE") GPU_DEVICE gPU_DEVICE) {
        return WGLNVGPUAffinity.nwglEnumGpuDevicesNV(l2, n2, gPU_DEVICE.address()) != 0;
    }

    public static long nwglCreateAffinityDCNV(long l2) {
        long l3 = GL.getCapabilitiesWGL().wglCreateAffinityDCNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return JNI.callPP(l2, l3);
    }

    @NativeType(value="HDC")
    public static long wglCreateAffinityDCNV(@NativeType(value="HGPUNV const *") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT(pointerBuffer);
        }
        return WGLNVGPUAffinity.nwglCreateAffinityDCNV(MemoryUtil.memAddress(pointerBuffer));
    }

    public static int nwglEnumGpusFromAffinityDCNV(long l2, int n2, long l3) {
        long l4 = GL.getCapabilitiesWGL().wglEnumGpusFromAffinityDCNV;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, l3, l4);
    }

    @NativeType(value="BOOL")
    public static boolean wglEnumGpusFromAffinityDCNV(@NativeType(value="HDC") long l2, @NativeType(value="UINT") int n2, @NativeType(value="HGPUNV *") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        return WGLNVGPUAffinity.nwglEnumGpusFromAffinityDCNV(l2, n2, MemoryUtil.memAddress(pointerBuffer)) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglDeleteDCNV(@NativeType(value="HDC") long l2) {
        long l3 = GL.getCapabilitiesWGL().wglDeleteDCNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3) != 0;
    }
}

