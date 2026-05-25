/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.openal.ALC;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTLoopback {
    public static final int ALC_BYTE_SOFT = 5120;
    public static final int ALC_UNSIGNED_BYTE_SOFT = 5121;
    public static final int ALC_SHORT_SOFT = 5122;
    public static final int ALC_UNSIGNED_SHORT_SOFT = 5123;
    public static final int ALC_INT_SOFT = 5124;
    public static final int ALC_UNSIGNED_INT_SOFT = 5125;
    public static final int ALC_FLOAT_SOFT = 5126;
    public static final int ALC_MONO_SOFT = 5376;
    public static final int ALC_STEREO_SOFT = 5377;
    public static final int ALC_QUAD_SOFT = 5379;
    public static final int ALC_5POINT1_SOFT = 5380;
    public static final int ALC_6POINT1_SOFT = 5381;
    public static final int ALC_7POINT1_SOFT = 5382;
    public static final int ALC_FORMAT_CHANNELS_SOFT = 6544;
    public static final int ALC_FORMAT_TYPE_SOFT = 6545;

    protected SOFTLoopback() {
        throw new UnsupportedOperationException();
    }

    public static long nalcLoopbackOpenDeviceSOFT(long l2) {
        long l3 = ALC.getICD().alcLoopbackOpenDeviceSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return JNI.invokePP(l2, l3);
    }

    @NativeType(value="ALCdevice *")
    public static long alcLoopbackOpenDeviceSOFT(@Nullable @NativeType(value="ALCchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(byteBuffer);
        }
        return SOFTLoopback.nalcLoopbackOpenDeviceSOFT(MemoryUtil.memAddressSafe(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCdevice *")
    public static long alcLoopbackOpenDeviceSOFT(@Nullable @NativeType(value="ALCchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8Safe(charSequence, true);
            long l2 = charSequence == null ? 0L : memoryStack.getPointerAddress();
            long l3 = SOFTLoopback.nalcLoopbackOpenDeviceSOFT(l2);
            return l3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    @NativeType(value="ALCboolean")
    public static boolean alcIsRenderFormatSupportedSOFT(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCsizei") int n2, @NativeType(value="ALCenum") int n3, @NativeType(value="ALCenum") int n4) {
        long l3 = ALC.getICD().alcIsRenderFormatSupportedSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.invokePZ(l2, n2, n3, n4, l3);
    }

    public static void nalcRenderSamplesSOFT(long l2, long l3, int n2) {
        long l4 = ALC.getICD().alcRenderSamplesSOFT;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        JNI.invokePPV(l2, l3, n2, l4);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") ByteBuffer byteBuffer, @NativeType(value="ALCsizei") int n2) {
        SOFTLoopback.nalcRenderSamplesSOFT(l2, MemoryUtil.memAddress(byteBuffer), n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") ShortBuffer shortBuffer, @NativeType(value="ALCsizei") int n2) {
        SOFTLoopback.nalcRenderSamplesSOFT(l2, MemoryUtil.memAddress(shortBuffer), n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") IntBuffer intBuffer, @NativeType(value="ALCsizei") int n2) {
        SOFTLoopback.nalcRenderSamplesSOFT(l2, MemoryUtil.memAddress(intBuffer), n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") FloatBuffer floatBuffer, @NativeType(value="ALCsizei") int n2) {
        SOFTLoopback.nalcRenderSamplesSOFT(l2, MemoryUtil.memAddress(floatBuffer), n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") short[] sArray, @NativeType(value="ALCsizei") int n2) {
        long l3 = ALC.getICD().alcRenderSamplesSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.invokePPV(l2, sArray, n2, l3);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") int[] nArray, @NativeType(value="ALCsizei") int n2) {
        long l3 = ALC.getICD().alcRenderSamplesSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.invokePPV(l2, nArray, n2, l3);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") float[] fArray, @NativeType(value="ALCsizei") int n2) {
        long l3 = ALC.getICD().alcRenderSamplesSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.invokePPV(l2, fArray, n2, l3);
    }
}

