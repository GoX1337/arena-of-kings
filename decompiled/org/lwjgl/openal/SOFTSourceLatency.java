/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.nio.LongBuffer;
import org.lwjgl.openal.AL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTSourceLatency {
    public static final int AL_SAMPLE_OFFSET_LATENCY_SOFT = 4608;
    public static final int AL_SEC_OFFSET_LATENCY_SOFT = 4609;

    protected SOFTSourceLatency() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="ALvoid")
    public static void alSourcedSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALdouble") double d2) {
        long l2 = AL.getICD().alSourcedSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokeV(n2, n3, d2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSource3dSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALdouble") double d2, @NativeType(value="ALdouble") double d3, @NativeType(value="ALdouble") double d4) {
        long l2 = AL.getICD().alSource3dSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokeV(n2, n3, d2, d3, d4, l2);
    }

    public static void nalSourcedvSOFT(int n2, int n3, long l2) {
        long l3 = AL.getICD().alSourcedvSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alSourcedvSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALdouble const *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 1);
        }
        SOFTSourceLatency.nalSourcedvSOFT(n2, n3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static void nalGetSourcedSOFT(int n2, int n3, long l2) {
        long l3 = AL.getICD().alGetSourcedSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcedSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALdouble *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 1);
        }
        SOFTSourceLatency.nalGetSourcedSOFT(n2, n3, MemoryUtil.memAddress(doubleBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static double alGetSourcedSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
            SOFTSourceLatency.nalGetSourcedSOFT(n2, n3, MemoryUtil.memAddress(doubleBuffer));
            double d2 = doubleBuffer.get(0);
            return d2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void nalGetSource3dSOFT(int n2, int n3, long l2, long l3, long l4) {
        long l5 = AL.getICD().alGetSource3dSOFT;
        if (Checks.CHECKS) {
            Checks.check(l5);
        }
        JNI.invokePPPV(n2, n3, l2, l3, l4, l5);
    }

    @NativeType(value="ALvoid")
    public static void alGetSource3dSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALdouble *") DoubleBuffer doubleBuffer, @NativeType(value="ALdouble *") DoubleBuffer doubleBuffer2, @NativeType(value="ALdouble *") DoubleBuffer doubleBuffer3) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 1);
            Checks.check((Buffer)doubleBuffer2, 1);
            Checks.check((Buffer)doubleBuffer3, 1);
        }
        SOFTSourceLatency.nalGetSource3dSOFT(n2, n3, MemoryUtil.memAddress(doubleBuffer), MemoryUtil.memAddress(doubleBuffer2), MemoryUtil.memAddress(doubleBuffer3));
    }

    public static void nalGetSourcedvSOFT(int n2, int n3, long l2) {
        long l3 = AL.getICD().alGetSourcedvSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcedvSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALdouble *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 1);
        }
        SOFTSourceLatency.nalGetSourcedvSOFT(n2, n3, MemoryUtil.memAddress(doubleBuffer));
    }

    @NativeType(value="ALvoid")
    public static void alSourcei64SOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint64SOFT") long l2) {
        long l3 = AL.getICD().alSourcei64SOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokeJV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alSource3i64SOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint64SOFT") long l2, @NativeType(value="ALint64SOFT") long l3, @NativeType(value="ALint64SOFT") long l4) {
        long l5 = AL.getICD().alSource3i64SOFT;
        if (Checks.CHECKS) {
            Checks.check(l5);
        }
        JNI.invokeJJJV(n2, n3, l2, l3, l4, l5);
    }

    public static void nalSourcei64vSOFT(int n2, int n3, long l2) {
        long l3 = AL.getICD().alSourcei64vSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alSourcei64vSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint64SOFT const *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        SOFTSourceLatency.nalSourcei64vSOFT(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    public static void nalGetSourcei64SOFT(int n2, int n3, long l2) {
        long l3 = AL.getICD().alGetSourcei64SOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcei64SOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint64SOFT *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        SOFTSourceLatency.nalGetSourcei64SOFT(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static long alGetSourcei64SOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            SOFTSourceLatency.nalGetSourcei64SOFT(n2, n3, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void nalGetSource3i64SOFT(int n2, int n3, long l2, long l3, long l4) {
        long l5 = AL.getICD().alGetSource3i64SOFT;
        if (Checks.CHECKS) {
            Checks.check(l5);
        }
        JNI.invokePPPV(n2, n3, l2, l3, l4, l5);
    }

    @NativeType(value="ALvoid")
    public static void alGetSource3i64SOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint64SOFT *") LongBuffer longBuffer, @NativeType(value="ALint64SOFT *") LongBuffer longBuffer2, @NativeType(value="ALint64SOFT *") LongBuffer longBuffer3) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
            Checks.check((Buffer)longBuffer2, 1);
            Checks.check((Buffer)longBuffer3, 1);
        }
        SOFTSourceLatency.nalGetSource3i64SOFT(n2, n3, MemoryUtil.memAddress(longBuffer), MemoryUtil.memAddress(longBuffer2), MemoryUtil.memAddress(longBuffer3));
    }

    public static void nalGetSourcei64vSOFT(int n2, int n3, long l2) {
        long l3 = AL.getICD().alGetSourcei64vSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcei64vSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint64SOFT *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        SOFTSourceLatency.nalGetSourcei64vSOFT(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    @NativeType(value="ALvoid")
    public static void alSourcedvSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALdouble const *") double[] dArray) {
        long l2 = AL.getICD().alSourcedvSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 1);
        }
        JNI.invokePV(n2, n3, dArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcedSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALdouble *") double[] dArray) {
        long l2 = AL.getICD().alGetSourcedSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 1);
        }
        JNI.invokePV(n2, n3, dArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetSource3dSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALdouble *") double[] dArray, @NativeType(value="ALdouble *") double[] dArray2, @NativeType(value="ALdouble *") double[] dArray3) {
        long l2 = AL.getICD().alGetSource3dSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 1);
            Checks.check(dArray2, 1);
            Checks.check(dArray3, 1);
        }
        JNI.invokePPPV(n2, n3, dArray, dArray2, dArray3, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcedvSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALdouble *") double[] dArray) {
        long l2 = AL.getICD().alGetSourcedvSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 1);
        }
        JNI.invokePV(n2, n3, dArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourcei64vSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint64SOFT const *") long[] lArray) {
        long l2 = AL.getICD().alSourcei64vSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.invokePV(n2, n3, lArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcei64SOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint64SOFT *") long[] lArray) {
        long l2 = AL.getICD().alGetSourcei64SOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.invokePV(n2, n3, lArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetSource3i64SOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint64SOFT *") long[] lArray, @NativeType(value="ALint64SOFT *") long[] lArray2, @NativeType(value="ALint64SOFT *") long[] lArray3) {
        long l2 = AL.getICD().alGetSource3i64SOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
            Checks.check(lArray2, 1);
            Checks.check(lArray3, 1);
        }
        JNI.invokePPPV(n2, n3, lArray, lArray2, lArray3, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcei64vSOFT(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint64SOFT *") long[] lArray) {
        long l2 = AL.getICD().alGetSourcei64vSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.invokePV(n2, n3, lArray, l2);
    }
}

