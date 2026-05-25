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
import org.lwjgl.openal.ALC10;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ALC11
extends ALC10 {
    public static final int ALC_MONO_SOURCES = 4112;
    public static final int ALC_STEREO_SOURCES = 4113;
    public static final int ALC_DEFAULT_ALL_DEVICES_SPECIFIER = 4114;
    public static final int ALC_ALL_DEVICES_SPECIFIER = 4115;
    public static final int ALC_CAPTURE_DEVICE_SPECIFIER = 784;
    public static final int ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER = 785;
    public static final int ALC_CAPTURE_SAMPLES = 786;

    protected ALC11() {
        throw new UnsupportedOperationException();
    }

    public static long nalcCaptureOpenDevice(long l2, int n2, int n3, int n4) {
        long l3 = ALC.getICD().alcCaptureOpenDevice;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return JNI.invokePP(l2, n2, n3, n4, l3);
    }

    @NativeType(value="ALCdevice *")
    public static long alcCaptureOpenDevice(@Nullable @NativeType(value="ALCchar const *") ByteBuffer byteBuffer, @NativeType(value="ALCuint") int n2, @NativeType(value="ALCenum") int n3, @NativeType(value="ALCsizei") int n4) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(byteBuffer);
        }
        return ALC11.nalcCaptureOpenDevice(MemoryUtil.memAddressSafe(byteBuffer), n2, n3, n4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCdevice *")
    public static long alcCaptureOpenDevice(@Nullable @NativeType(value="ALCchar const *") CharSequence charSequence, @NativeType(value="ALCuint") int n2, @NativeType(value="ALCenum") int n3, @NativeType(value="ALCsizei") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8Safe(charSequence, true);
            long l2 = charSequence == null ? 0L : memoryStack.getPointerAddress();
            long l3 = ALC11.nalcCaptureOpenDevice(l2, n2, n3, n4);
            return l3;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    @NativeType(value="ALCboolean")
    public static boolean alcCaptureCloseDevice(@NativeType(value="ALCdevice *") long l2) {
        long l3 = ALC.getICD().alcCaptureCloseDevice;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        return JNI.invokePZ(l2, l3);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureStart(@NativeType(value="ALCdevice *") long l2) {
        long l3 = ALC.getICD().alcCaptureStart;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.invokePV(l2, l3);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureStop(@NativeType(value="ALCdevice *") long l2) {
        long l3 = ALC.getICD().alcCaptureStop;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.invokePV(l2, l3);
    }

    public static void nalcCaptureSamples(long l2, long l3, int n2) {
        long l4 = ALC.getICD().alcCaptureSamples;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        JNI.invokePPV(l2, l3, n2, l4);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") ByteBuffer byteBuffer, @NativeType(value="ALCsizei") int n2) {
        ALC11.nalcCaptureSamples(l2, MemoryUtil.memAddress(byteBuffer), n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") ShortBuffer shortBuffer, @NativeType(value="ALCsizei") int n2) {
        ALC11.nalcCaptureSamples(l2, MemoryUtil.memAddress(shortBuffer), n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") IntBuffer intBuffer, @NativeType(value="ALCsizei") int n2) {
        ALC11.nalcCaptureSamples(l2, MemoryUtil.memAddress(intBuffer), n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") FloatBuffer floatBuffer, @NativeType(value="ALCsizei") int n2) {
        ALC11.nalcCaptureSamples(l2, MemoryUtil.memAddress(floatBuffer), n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") short[] sArray, @NativeType(value="ALCsizei") int n2) {
        long l3 = ALC.getICD().alcCaptureSamples;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.invokePPV(l2, sArray, n2, l3);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") int[] nArray, @NativeType(value="ALCsizei") int n2) {
        long l3 = ALC.getICD().alcCaptureSamples;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.invokePPV(l2, nArray, n2, l3);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") float[] fArray, @NativeType(value="ALCsizei") int n2) {
        long l3 = ALC.getICD().alcCaptureSamples;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.invokePPV(l2, fArray, n2, l3);
    }
}

