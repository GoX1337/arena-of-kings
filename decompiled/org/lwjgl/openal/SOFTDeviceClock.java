/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.LongBuffer;
import org.lwjgl.openal.ALC;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTDeviceClock {
    public static final int ALC_DEVICE_CLOCK_SOFT = 5632;
    public static final int ALC_DEVICE_LATENCY_SOFT = 5633;
    public static final int ALC_DEVICE_CLOCK_LATENCY_SOFT = 5634;
    public static final int AL_SAMPLE_OFFSET_CLOCK_SOFT = 4610;
    public static final int AL_SEC_OFFSET_CLOCK_SOFT = 4611;

    protected SOFTDeviceClock() {
        throw new UnsupportedOperationException();
    }

    public static void nalcGetInteger64vSOFT(long l2, int n2, int n3, long l3) {
        long l4 = ALC.getICD().alcGetInteger64vSOFT;
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        JNI.invokePPV(l2, n2, n3, l3, l4);
    }

    @NativeType(value="ALCvoid")
    public static void alcGetInteger64vSOFT(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCenum") int n2, @NativeType(value="ALCint64SOFT *") LongBuffer longBuffer) {
        SOFTDeviceClock.nalcGetInteger64vSOFT(l2, n2, longBuffer.remaining(), MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCvoid")
    public static long alcGetInteger64vSOFT(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCenum") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            SOFTDeviceClock.nalcGetInteger64vSOFT(l2, n2, 1, MemoryUtil.memAddress(longBuffer));
            long l3 = longBuffer.get(0);
            return l3;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    @NativeType(value="ALCvoid")
    public static void alcGetInteger64vSOFT(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCenum") int n2, @NativeType(value="ALCint64SOFT *") long[] lArray) {
        long l3 = ALC.getICD().alcGetInteger64vSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePPV(l2, n2, lArray.length, lArray, l3);
    }
}

