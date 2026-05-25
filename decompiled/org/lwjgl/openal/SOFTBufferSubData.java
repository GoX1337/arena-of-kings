/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.openal.AL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTBufferSubData {
    public static final int AL_BYTE_RW_OFFSETS_SOFT = 4145;
    public static final int AL_SAMPLE_RW_OFFSETS_SOFT = 4146;

    protected SOFTBufferSubData() {
        throw new UnsupportedOperationException();
    }

    public static void nalBufferSubDataSOFT(int n2, int n3, long l2, int n4, int n5) {
        long l3 = AL.getICD().alBufferSubDataSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, n4, n5, l3);
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") ByteBuffer byteBuffer, @NativeType(value="ALsizei") int n4) {
        SOFTBufferSubData.nalBufferSubDataSOFT(n2, n3, MemoryUtil.memAddress(byteBuffer), n4, byteBuffer.remaining());
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") ShortBuffer shortBuffer, @NativeType(value="ALsizei") int n4) {
        SOFTBufferSubData.nalBufferSubDataSOFT(n2, n3, MemoryUtil.memAddress(shortBuffer), n4, shortBuffer.remaining() << 1);
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") IntBuffer intBuffer, @NativeType(value="ALsizei") int n4) {
        SOFTBufferSubData.nalBufferSubDataSOFT(n2, n3, MemoryUtil.memAddress(intBuffer), n4, intBuffer.remaining() << 2);
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") FloatBuffer floatBuffer, @NativeType(value="ALsizei") int n4) {
        SOFTBufferSubData.nalBufferSubDataSOFT(n2, n3, MemoryUtil.memAddress(floatBuffer), n4, floatBuffer.remaining() << 2);
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") short[] sArray, @NativeType(value="ALsizei") int n4) {
        long l2 = AL.getICD().alBufferSubDataSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n2, n3, sArray, n4, sArray.length << 1, l2);
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") int[] nArray, @NativeType(value="ALsizei") int n4) {
        long l2 = AL.getICD().alBufferSubDataSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n2, n3, nArray, n4, nArray.length << 2, l2);
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") float[] fArray, @NativeType(value="ALsizei") int n4) {
        long l2 = AL.getICD().alBufferSubDataSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n2, n3, fArray, n4, fArray.length << 2, l2);
    }
}

