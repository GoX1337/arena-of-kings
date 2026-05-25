/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.util.Set;
import java.util.function.IntFunction;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProviderLocal;
import org.lwjgl.system.ThreadLocalUtil;

public final class ALCCapabilities {
    public final long alcOpenDevice;
    public final long alcCloseDevice;
    public final long alcCreateContext;
    public final long alcMakeContextCurrent;
    public final long alcProcessContext;
    public final long alcSuspendContext;
    public final long alcDestroyContext;
    public final long alcGetCurrentContext;
    public final long alcGetContextsDevice;
    public final long alcIsExtensionPresent;
    public final long alcGetProcAddress;
    public final long alcGetEnumValue;
    public final long alcGetError;
    public final long alcGetString;
    public final long alcGetIntegerv;
    public final long alcCaptureOpenDevice;
    public final long alcCaptureCloseDevice;
    public final long alcCaptureStart;
    public final long alcCaptureStop;
    public final long alcCaptureSamples;
    public final long alcSetThreadContext;
    public final long alcGetThreadContext;
    public final long alcGetInteger64vSOFT;
    public final long alcGetStringiSOFT;
    public final long alcResetDeviceSOFT;
    public final long alcLoopbackOpenDeviceSOFT;
    public final long alcIsRenderFormatSupportedSOFT;
    public final long alcRenderSamplesSOFT;
    public final long alcDevicePauseSOFT;
    public final long alcDeviceResumeSOFT;
    public final boolean OpenALC10;
    public final boolean OpenALC11;
    public final boolean ALC_ENUMERATE_ALL_EXT;
    public final boolean ALC_ENUMERATION_EXT;
    public final boolean ALC_EXT_CAPTURE;
    public final boolean ALC_EXT_DEDICATED;
    public final boolean ALC_EXT_DEFAULT_FILTER_ORDER;
    public final boolean ALC_EXT_disconnect;
    public final boolean ALC_EXT_EFX;
    public final boolean ALC_EXT_thread_local_context;
    public final boolean ALC_LOKI_audio_channel;
    public final boolean ALC_SOFT_device_clock;
    public final boolean ALC_SOFT_HRTF;
    public final boolean ALC_SOFT_loopback;
    public final boolean ALC_SOFT_output_limiter;
    public final boolean ALC_SOFT_pause_device;
    final long device;
    final PointerBuffer addresses;

    ALCCapabilities(FunctionProviderLocal functionProviderLocal, long l2, Set<String> set, IntFunction<PointerBuffer> intFunction) {
        this.device = l2;
        PointerBuffer pointerBuffer = intFunction.apply(30);
        this.OpenALC10 = ALCCapabilities.check_ALC10(functionProviderLocal, l2, pointerBuffer, set);
        this.OpenALC11 = ALCCapabilities.check_ALC11(functionProviderLocal, l2, pointerBuffer, set);
        this.ALC_ENUMERATE_ALL_EXT = set.contains("ALC_ENUMERATE_ALL_EXT");
        this.ALC_ENUMERATION_EXT = set.contains("ALC_ENUMERATION_EXT");
        this.ALC_EXT_CAPTURE = ALCCapabilities.check_EXT_CAPTURE(functionProviderLocal, l2, pointerBuffer, set);
        this.ALC_EXT_DEDICATED = set.contains("ALC_EXT_DEDICATED");
        this.ALC_EXT_DEFAULT_FILTER_ORDER = set.contains("ALC_EXT_DEFAULT_FILTER_ORDER");
        this.ALC_EXT_disconnect = set.contains("ALC_EXT_disconnect");
        this.ALC_EXT_EFX = set.contains("ALC_EXT_EFX");
        this.ALC_EXT_thread_local_context = ALCCapabilities.check_EXT_thread_local_context(functionProviderLocal, l2, pointerBuffer, set);
        this.ALC_LOKI_audio_channel = set.contains("ALC_LOKI_audio_channel");
        this.ALC_SOFT_device_clock = ALCCapabilities.check_SOFT_device_clock(functionProviderLocal, l2, pointerBuffer, set);
        this.ALC_SOFT_HRTF = ALCCapabilities.check_SOFT_HRTF(functionProviderLocal, l2, pointerBuffer, set);
        this.ALC_SOFT_loopback = ALCCapabilities.check_SOFT_loopback(functionProviderLocal, l2, pointerBuffer, set);
        this.ALC_SOFT_output_limiter = set.contains("ALC_SOFT_output_limiter");
        this.ALC_SOFT_pause_device = ALCCapabilities.check_SOFT_pause_device(functionProviderLocal, l2, pointerBuffer, set);
        this.alcOpenDevice = pointerBuffer.get(0);
        this.alcCloseDevice = pointerBuffer.get(1);
        this.alcCreateContext = pointerBuffer.get(2);
        this.alcMakeContextCurrent = pointerBuffer.get(3);
        this.alcProcessContext = pointerBuffer.get(4);
        this.alcSuspendContext = pointerBuffer.get(5);
        this.alcDestroyContext = pointerBuffer.get(6);
        this.alcGetCurrentContext = pointerBuffer.get(7);
        this.alcGetContextsDevice = pointerBuffer.get(8);
        this.alcIsExtensionPresent = pointerBuffer.get(9);
        this.alcGetProcAddress = pointerBuffer.get(10);
        this.alcGetEnumValue = pointerBuffer.get(11);
        this.alcGetError = pointerBuffer.get(12);
        this.alcGetString = pointerBuffer.get(13);
        this.alcGetIntegerv = pointerBuffer.get(14);
        this.alcCaptureOpenDevice = pointerBuffer.get(15);
        this.alcCaptureCloseDevice = pointerBuffer.get(16);
        this.alcCaptureStart = pointerBuffer.get(17);
        this.alcCaptureStop = pointerBuffer.get(18);
        this.alcCaptureSamples = pointerBuffer.get(19);
        this.alcSetThreadContext = pointerBuffer.get(20);
        this.alcGetThreadContext = pointerBuffer.get(21);
        this.alcGetInteger64vSOFT = pointerBuffer.get(22);
        this.alcGetStringiSOFT = pointerBuffer.get(23);
        this.alcResetDeviceSOFT = pointerBuffer.get(24);
        this.alcLoopbackOpenDeviceSOFT = pointerBuffer.get(25);
        this.alcIsRenderFormatSupportedSOFT = pointerBuffer.get(26);
        this.alcRenderSamplesSOFT = pointerBuffer.get(27);
        this.alcDevicePauseSOFT = pointerBuffer.get(28);
        this.alcDeviceResumeSOFT = pointerBuffer.get(29);
        this.addresses = ThreadLocalUtil.setupAddressBuffer(pointerBuffer);
    }

    public PointerBuffer getAddressBuffer() {
        return this.addresses;
    }

    private static boolean check_ALC10(FunctionProviderLocal functionProviderLocal, long l2, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenALC10")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l2, pointerBuffer, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, "alcOpenDevice", "alcCloseDevice", "alcCreateContext", "alcMakeContextCurrent", "alcProcessContext", "alcSuspendContext", "alcDestroyContext", "alcGetCurrentContext", "alcGetContextsDevice", "alcIsExtensionPresent", "alcGetProcAddress", "alcGetEnumValue", "alcGetError", "alcGetString", "alcGetIntegerv") || Checks.reportMissing("ALC", "OpenALC10");
    }

    private static boolean check_ALC11(FunctionProviderLocal functionProviderLocal, long l2, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenALC11")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l2, pointerBuffer, new int[]{15, 16, 17, 18, 19}, "alcCaptureOpenDevice", "alcCaptureCloseDevice", "alcCaptureStart", "alcCaptureStop", "alcCaptureSamples") || Checks.reportMissing("ALC", "OpenALC11");
    }

    private static boolean check_EXT_CAPTURE(FunctionProviderLocal functionProviderLocal, long l2, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_EXT_CAPTURE")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l2, pointerBuffer, new int[]{15, 16, 17, 18, 19}, "alcCaptureOpenDevice", "alcCaptureCloseDevice", "alcCaptureStart", "alcCaptureStop", "alcCaptureSamples") || Checks.reportMissing("ALC", "ALC_EXT_CAPTURE");
    }

    private static boolean check_EXT_thread_local_context(FunctionProviderLocal functionProviderLocal, long l2, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_EXT_thread_local_context")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l2, pointerBuffer, new int[]{20, 21}, "alcSetThreadContext", "alcGetThreadContext") || Checks.reportMissing("ALC", "ALC_EXT_thread_local_context");
    }

    private static boolean check_SOFT_device_clock(FunctionProviderLocal functionProviderLocal, long l2, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_SOFT_device_clock")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l2, pointerBuffer, new int[]{22}, "alcGetInteger64vSOFT") || Checks.reportMissing("ALC", "ALC_SOFT_device_clock");
    }

    private static boolean check_SOFT_HRTF(FunctionProviderLocal functionProviderLocal, long l2, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_SOFT_HRTF")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l2, pointerBuffer, new int[]{23, 24}, "alcGetStringiSOFT", "alcResetDeviceSOFT") || Checks.reportMissing("ALC", "ALC_SOFT_HRTF");
    }

    private static boolean check_SOFT_loopback(FunctionProviderLocal functionProviderLocal, long l2, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_SOFT_loopback")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l2, pointerBuffer, new int[]{25, 26, 27}, "alcLoopbackOpenDeviceSOFT", "alcIsRenderFormatSupportedSOFT", "alcRenderSamplesSOFT") || Checks.reportMissing("ALC", "ALC_SOFT_loopback");
    }

    private static boolean check_SOFT_pause_device(FunctionProviderLocal functionProviderLocal, long l2, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_SOFT_pause_device")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l2, pointerBuffer, new int[]{28, 29}, "alcDevicePauseSOFT", "alcDeviceResumeSOFT") || Checks.reportMissing("ALC", "ALC_SOFT_pause_device");
    }
}

