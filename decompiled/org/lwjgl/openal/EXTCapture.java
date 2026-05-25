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
import org.lwjgl.openal.ALC11;
import org.lwjgl.system.NativeType;

public class EXTCapture {
    public static final int ALC_CAPTURE_DEVICE_SPECIFIER = 784;
    public static final int ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER = 785;
    public static final int ALC_CAPTURE_SAMPLES = 786;

    protected EXTCapture() {
        throw new UnsupportedOperationException();
    }

    public static long nalcCaptureOpenDevice(long l2, int n2, int n3, int n4) {
        return ALC11.nalcCaptureOpenDevice(l2, n2, n3, n4);
    }

    @NativeType(value="ALCdevice *")
    public static long alcCaptureOpenDevice(@Nullable @NativeType(value="ALCchar const *") ByteBuffer byteBuffer, @NativeType(value="ALCuint") int n2, @NativeType(value="ALCenum") int n3, @NativeType(value="ALCsizei") int n4) {
        return ALC11.alcCaptureOpenDevice(byteBuffer, n2, n3, n4);
    }

    @NativeType(value="ALCdevice *")
    public static long alcCaptureOpenDevice(@Nullable @NativeType(value="ALCchar const *") CharSequence charSequence, @NativeType(value="ALCuint") int n2, @NativeType(value="ALCenum") int n3, @NativeType(value="ALCsizei") int n4) {
        return ALC11.alcCaptureOpenDevice(charSequence, n2, n3, n4);
    }

    @NativeType(value="ALCboolean")
    public static boolean alcCaptureCloseDevice(@NativeType(value="ALCdevice *") long l2) {
        return ALC11.alcCaptureCloseDevice(l2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureStart(@NativeType(value="ALCdevice *") long l2) {
        ALC11.alcCaptureStart(l2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureStop(@NativeType(value="ALCdevice *") long l2) {
        ALC11.alcCaptureStop(l2);
    }

    public static void nalcCaptureSamples(long l2, long l3, int n2) {
        ALC11.nalcCaptureSamples(l2, l3, n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") ByteBuffer byteBuffer, @NativeType(value="ALCsizei") int n2) {
        ALC11.alcCaptureSamples(l2, byteBuffer, n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") ShortBuffer shortBuffer, @NativeType(value="ALCsizei") int n2) {
        ALC11.alcCaptureSamples(l2, shortBuffer, n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") IntBuffer intBuffer, @NativeType(value="ALCsizei") int n2) {
        ALC11.alcCaptureSamples(l2, intBuffer, n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") FloatBuffer floatBuffer, @NativeType(value="ALCsizei") int n2) {
        ALC11.alcCaptureSamples(l2, floatBuffer, n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") short[] sArray, @NativeType(value="ALCsizei") int n2) {
        ALC11.alcCaptureSamples(l2, sArray, n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") int[] nArray, @NativeType(value="ALCsizei") int n2) {
        ALC11.alcCaptureSamples(l2, nArray, n2);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCvoid *") float[] fArray, @NativeType(value="ALCsizei") int n2) {
        ALC11.alcCaptureSamples(l2, fArray, n2);
    }
}

