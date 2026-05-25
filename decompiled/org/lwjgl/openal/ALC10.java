/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.openal.ALC;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ALC10 {
    public static final int ALC_INVALID = -1;
    public static final int ALC_FALSE = 0;
    public static final int ALC_TRUE = 1;
    public static final int ALC_FREQUENCY = 4103;
    public static final int ALC_REFRESH = 4104;
    public static final int ALC_SYNC = 4105;
    public static final int ALC_NO_ERROR = 0;
    public static final int ALC_INVALID_DEVICE = 40961;
    public static final int ALC_INVALID_CONTEXT = 40962;
    public static final int ALC_INVALID_ENUM = 40963;
    public static final int ALC_INVALID_VALUE = 40964;
    public static final int ALC_OUT_OF_MEMORY = 40965;
    public static final int ALC_DEFAULT_DEVICE_SPECIFIER = 4100;
    public static final int ALC_DEVICE_SPECIFIER = 4101;
    public static final int ALC_EXTENSIONS = 4102;
    public static final int ALC_MAJOR_VERSION = 4096;
    public static final int ALC_MINOR_VERSION = 4097;
    public static final int ALC_ATTRIBUTES_SIZE = 4098;
    public static final int ALC_ALL_ATTRIBUTES = 4099;

    protected ALC10() {
        throw new UnsupportedOperationException();
    }

    public static long nalcOpenDevice(long l2) {
        long l3 = ALC.getICD().alcOpenDevice;
        return JNI.invokePP(l2, l3);
    }

    @NativeType(value="ALCdevice *")
    public static long alcOpenDevice(@Nullable @NativeType(value="ALCchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(byteBuffer);
        }
        return ALC10.nalcOpenDevice(MemoryUtil.memAddressSafe(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCdevice *")
    public static long alcOpenDevice(@Nullable @NativeType(value="ALCchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8Safe(charSequence, true);
            long l2 = charSequence == null ? 0L : memoryStack.getPointerAddress();
            long l3 = ALC10.nalcOpenDevice(l2);
            return l3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    @NativeType(value="ALCboolean")
    public static boolean alcCloseDevice(@NativeType(value="ALCdevice const *") long l2) {
        long l3 = ALC.getICD().alcCloseDevice;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePZ(l2, l3);
    }

    public static long nalcCreateContext(long l2, long l3) {
        long l4 = ALC.getICD().alcCreateContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePPP(l2, l3, l4);
    }

    @NativeType(value="ALCcontext *")
    public static long alcCreateContext(@NativeType(value="ALCdevice const *") long l2, @Nullable @NativeType(value="ALCint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(intBuffer);
        }
        return ALC10.nalcCreateContext(l2, MemoryUtil.memAddressSafe(intBuffer));
    }

    @NativeType(value="ALCboolean")
    public static boolean alcMakeContextCurrent(@NativeType(value="ALCcontext *") long l2) {
        long l3 = ALC.getICD().alcMakeContextCurrent;
        return JNI.invokePZ(l2, l3);
    }

    @NativeType(value="ALCvoid")
    public static void alcProcessContext(@NativeType(value="ALCcontext *") long l2) {
        long l3 = ALC.getICD().alcProcessContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(l2, l3);
    }

    @NativeType(value="ALCvoid")
    public static void alcSuspendContext(@NativeType(value="ALCcontext *") long l2) {
        long l3 = ALC.getICD().alcSuspendContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(l2, l3);
    }

    @NativeType(value="ALCvoid")
    public static void alcDestroyContext(@NativeType(value="ALCcontext *") long l2) {
        long l3 = ALC.getICD().alcDestroyContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(l2, l3);
    }

    @NativeType(value="ALCcontext *")
    public static long alcGetCurrentContext() {
        long l2 = ALC.getICD().alcGetCurrentContext;
        return JNI.invokeP(l2);
    }

    @NativeType(value="ALCdevice *")
    public static long alcGetContextsDevice(@NativeType(value="ALCcontext *") long l2) {
        long l3 = ALC.getICD().alcGetContextsDevice;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l2, l3);
    }

    public static boolean nalcIsExtensionPresent(long l2, long l3) {
        long l4 = ALC.getICD().alcIsExtensionPresent;
        return JNI.invokePPZ(l2, l3, l4);
    }

    @NativeType(value="ALCboolean")
    public static boolean alcIsExtensionPresent(@NativeType(value="ALCdevice const *") long l2, @NativeType(value="ALCchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return ALC10.nalcIsExtensionPresent(l2, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCboolean")
    public static boolean alcIsExtensionPresent(@NativeType(value="ALCdevice const *") long l2, @NativeType(value="ALCchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l3 = memoryStack.getPointerAddress();
            boolean bl2 = ALC10.nalcIsExtensionPresent(l2, l3);
            return bl2;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static long nalcGetProcAddress(long l2, long l3) {
        long l4 = ALC.getICD().alcGetProcAddress;
        return JNI.invokePPP(l2, l3, l4);
    }

    @NativeType(value="void *")
    public static long alcGetProcAddress(@NativeType(value="ALCdevice const *") long l2, @NativeType(value="ALchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return ALC10.nalcGetProcAddress(l2, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long alcGetProcAddress(@NativeType(value="ALCdevice const *") long l2, @NativeType(value="ALchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l3 = memoryStack.getPointerAddress();
            long l4 = ALC10.nalcGetProcAddress(l2, l3);
            return l4;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static int nalcGetEnumValue(long l2, long l3) {
        long l4 = ALC.getICD().alcGetEnumValue;
        return JNI.invokePPI(l2, l3, l4);
    }

    @NativeType(value="ALCenum")
    public static int alcGetEnumValue(@NativeType(value="ALCdevice const *") long l2, @NativeType(value="ALCchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return ALC10.nalcGetEnumValue(l2, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCenum")
    public static int alcGetEnumValue(@NativeType(value="ALCdevice const *") long l2, @NativeType(value="ALCchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l3 = memoryStack.getPointerAddress();
            int n3 = ALC10.nalcGetEnumValue(l2, l3);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    @NativeType(value="ALCenum")
    public static int alcGetError(@NativeType(value="ALCdevice *") long l2) {
        long l3 = ALC.getICD().alcGetError;
        return JNI.invokePI(l2, l3);
    }

    public static long nalcGetString(long l2, int n2) {
        long l3 = ALC.getICD().alcGetString;
        return JNI.invokePP(l2, n2, l3);
    }

    @Nullable
    @NativeType(value="ALCchar const *")
    public static String alcGetString(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCenum") int n2) {
        long l3 = ALC10.nalcGetString(l2, n2);
        return MemoryUtil.memUTF8Safe(l3);
    }

    public static void nalcGetIntegerv(long l2, int n2, int n3, long l3) {
        long l4 = ALC.getICD().alcGetIntegerv;
        JNI.invokePPV(l2, n2, n3, l3, l4);
    }

    @NativeType(value="ALCvoid")
    public static void alcGetIntegerv(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCenum") int n2, @NativeType(value="ALCint *") IntBuffer intBuffer) {
        ALC10.nalcGetIntegerv(l2, n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCvoid")
    public static int alcGetInteger(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCenum") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ALC10.nalcGetIntegerv(l2, n2, 1, MemoryUtil.memAddress(intBuffer));
            int n4 = intBuffer.get(0);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    @NativeType(value="ALCcontext *")
    public static long alcCreateContext(@NativeType(value="ALCdevice const *") long l2, @Nullable @NativeType(value="ALCint const *") int[] nArray) {
        long l3 = ALC.getICD().alcCreateContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkNTSafe(nArray);
        }
        return JNI.invokePPP(l2, nArray, l3);
    }

    @NativeType(value="ALCvoid")
    public static void alcGetIntegerv(@NativeType(value="ALCdevice *") long l2, @NativeType(value="ALCenum") int n2, @NativeType(value="ALCint *") int[] nArray) {
        long l3 = ALC.getICD().alcGetIntegerv;
        JNI.invokePPV(l2, n2, nArray.length, nArray, l3);
    }
}

