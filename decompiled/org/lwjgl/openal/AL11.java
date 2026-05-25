/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class AL11
extends AL10 {
    public static final int AL_SEC_OFFSET = 4132;
    public static final int AL_SAMPLE_OFFSET = 4133;
    public static final int AL_BYTE_OFFSET = 4134;
    public static final int AL_STATIC = 4136;
    public static final int AL_STREAMING = 4137;
    public static final int AL_UNDETERMINED = 4144;
    public static final int AL_ILLEGAL_COMMAND = 40964;
    public static final int AL_SPEED_OF_SOUND = 49155;
    public static final int AL_LINEAR_DISTANCE = 53251;
    public static final int AL_LINEAR_DISTANCE_CLAMPED = 53252;
    public static final int AL_EXPONENT_DISTANCE = 53253;
    public static final int AL_EXPONENT_DISTANCE_CLAMPED = 53254;

    protected AL11() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="ALvoid")
    public static void alListener3i(@NativeType(value="ALenum") int n2, @NativeType(value="ALint") int n3, @NativeType(value="ALint") int n4, @NativeType(value="ALint") int n5) {
        long l2 = AL.getICD().alListener3i;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokeV(n2, n3, n4, n5, l2);
    }

    public static void nalGetListeneriv(int n2, long l2) {
        long l3 = AL.getICD().alGetListeneriv;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetListeneriv(@NativeType(value="ALenum") int n2, @NativeType(value="ALint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        AL11.nalGetListeneriv(n2, MemoryUtil.memAddress(intBuffer));
    }

    @NativeType(value="ALvoid")
    public static void alSource3i(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint") int n4, @NativeType(value="ALint") int n5, @NativeType(value="ALint") int n6) {
        long l2 = AL.getICD().alSource3i;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokeV(n2, n3, n4, n5, n6, l2);
    }

    public static void nalListeneriv(int n2, long l2) {
        long l3 = AL.getICD().alListeneriv;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alListeneriv(@NativeType(value="ALenum") int n2, @NativeType(value="ALint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        AL11.nalListeneriv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static void nalSourceiv(int n2, int n3, long l2) {
        long l3 = AL.getICD().alSourceiv;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alSourceiv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        AL11.nalSourceiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    @NativeType(value="ALvoid")
    public static void alBufferf(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat") float f2) {
        long l2 = AL.getICD().alBufferf;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokeV(n2, n3, f2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alBuffer3f(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat") float f2, @NativeType(value="ALfloat") float f3, @NativeType(value="ALfloat") float f4) {
        long l2 = AL.getICD().alBuffer3f;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokeV(n2, n3, f2, f3, f4, l2);
    }

    public static void nalBufferfv(int n2, int n3, long l2) {
        long l3 = AL.getICD().alBufferfv;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alBufferfv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        AL11.nalBufferfv(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    @NativeType(value="ALvoid")
    public static void alBufferi(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint") int n4) {
        long l2 = AL.getICD().alBufferi;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokeV(n2, n3, n4, l2);
    }

    @NativeType(value="ALvoid")
    public static void alBuffer3i(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint") int n4, @NativeType(value="ALint") int n5, @NativeType(value="ALint") int n6) {
        long l2 = AL.getICD().alBuffer3i;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokeV(n2, n3, n4, n5, n6, l2);
    }

    public static void nalBufferiv(int n2, int n3, long l2) {
        long l3 = AL.getICD().alBufferiv;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alBufferiv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        AL11.nalBufferiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static void nalGetBufferiv(int n2, int n3, long l2) {
        long l3 = AL.getICD().alGetBufferiv;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferiv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        AL11.nalGetBufferiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static void nalGetBufferfv(int n2, int n3, long l2) {
        long l3 = AL.getICD().alGetBufferfv;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferfv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        AL11.nalGetBufferfv(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    @NativeType(value="ALvoid")
    public static void alSpeedOfSound(@NativeType(value="ALfloat") float f2) {
        long l2 = AL.getICD().alSpeedOfSound;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokeV(f2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetListeneriv(@NativeType(value="ALenum") int n2, @NativeType(value="ALint *") int[] nArray) {
        long l2 = AL.getICD().alGetListeneriv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.invokePV(n2, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alListeneriv(@NativeType(value="ALenum") int n2, @NativeType(value="ALint const *") int[] nArray) {
        long l2 = AL.getICD().alListeneriv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.invokePV(n2, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourceiv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint const *") int[] nArray) {
        long l2 = AL.getICD().alSourceiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.invokePV(n2, n3, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alBufferfv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat const *") float[] fArray) {
        long l2 = AL.getICD().alBufferfv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.invokePV(n2, n3, fArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alBufferiv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint const *") int[] nArray) {
        long l2 = AL.getICD().alBufferiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.invokePV(n2, n3, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferiv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint *") int[] nArray) {
        long l2 = AL.getICD().alGetBufferiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.invokePV(n2, n3, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferfv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat *") float[] fArray) {
        long l2 = AL.getICD().alGetBufferfv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.invokePV(n2, n3, fArray, l2);
    }
}

