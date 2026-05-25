/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.util.Set;
import java.util.function.IntFunction;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.ThreadLocalUtil;

public final class ALCapabilities {
    public final long alGetError;
    public final long alEnable;
    public final long alDisable;
    public final long alIsEnabled;
    public final long alGetBoolean;
    public final long alGetInteger;
    public final long alGetFloat;
    public final long alGetDouble;
    public final long alGetBooleanv;
    public final long alGetIntegerv;
    public final long alGetFloatv;
    public final long alGetDoublev;
    public final long alGetString;
    public final long alDistanceModel;
    public final long alDopplerFactor;
    public final long alDopplerVelocity;
    public final long alListenerf;
    public final long alListeneri;
    public final long alListener3f;
    public final long alListenerfv;
    public final long alGetListenerf;
    public final long alGetListeneri;
    public final long alGetListener3f;
    public final long alGetListenerfv;
    public final long alGenSources;
    public final long alDeleteSources;
    public final long alIsSource;
    public final long alSourcef;
    public final long alSource3f;
    public final long alSourcefv;
    public final long alSourcei;
    public final long alGetSourcef;
    public final long alGetSource3f;
    public final long alGetSourcefv;
    public final long alGetSourcei;
    public final long alGetSourceiv;
    public final long alSourceQueueBuffers;
    public final long alSourceUnqueueBuffers;
    public final long alSourcePlay;
    public final long alSourcePause;
    public final long alSourceStop;
    public final long alSourceRewind;
    public final long alSourcePlayv;
    public final long alSourcePausev;
    public final long alSourceStopv;
    public final long alSourceRewindv;
    public final long alGenBuffers;
    public final long alDeleteBuffers;
    public final long alIsBuffer;
    public final long alGetBufferf;
    public final long alGetBufferi;
    public final long alBufferData;
    public final long alGetEnumValue;
    public final long alGetProcAddress;
    public final long alIsExtensionPresent;
    public final long alListener3i;
    public final long alGetListeneriv;
    public final long alSource3i;
    public final long alListeneriv;
    public final long alSourceiv;
    public final long alBufferf;
    public final long alBuffer3f;
    public final long alBufferfv;
    public final long alBufferi;
    public final long alBuffer3i;
    public final long alBufferiv;
    public final long alGetBufferiv;
    public final long alGetBufferfv;
    public final long alSpeedOfSound;
    public final long alGenEffects;
    public final long alDeleteEffects;
    public final long alIsEffect;
    public final long alEffecti;
    public final long alEffectiv;
    public final long alEffectf;
    public final long alEffectfv;
    public final long alGetEffecti;
    public final long alGetEffectiv;
    public final long alGetEffectf;
    public final long alGetEffectfv;
    public final long alGenFilters;
    public final long alDeleteFilters;
    public final long alIsFilter;
    public final long alFilteri;
    public final long alFilteriv;
    public final long alFilterf;
    public final long alFilterfv;
    public final long alGetFilteri;
    public final long alGetFilteriv;
    public final long alGetFilterf;
    public final long alGetFilterfv;
    public final long alGenAuxiliaryEffectSlots;
    public final long alDeleteAuxiliaryEffectSlots;
    public final long alIsAuxiliaryEffectSlot;
    public final long alAuxiliaryEffectSloti;
    public final long alAuxiliaryEffectSlotiv;
    public final long alAuxiliaryEffectSlotf;
    public final long alAuxiliaryEffectSlotfv;
    public final long alGetAuxiliaryEffectSloti;
    public final long alGetAuxiliaryEffectSlotiv;
    public final long alGetAuxiliaryEffectSlotf;
    public final long alGetAuxiliaryEffectSlotfv;
    public final long alBufferDataStatic;
    public final long alBufferSamplesSOFT;
    public final long alBufferSubSamplesSOFT;
    public final long alGetBufferSamplesSOFT;
    public final long alIsBufferFormatSupportedSOFT;
    public final long alBufferSubDataSOFT;
    public final long alDeferUpdatesSOFT;
    public final long alProcessUpdatesSOFT;
    public final long alSourcedSOFT;
    public final long alSource3dSOFT;
    public final long alSourcedvSOFT;
    public final long alGetSourcedSOFT;
    public final long alGetSource3dSOFT;
    public final long alGetSourcedvSOFT;
    public final long alSourcei64SOFT;
    public final long alSource3i64SOFT;
    public final long alSourcei64vSOFT;
    public final long alGetSourcei64SOFT;
    public final long alGetSource3i64SOFT;
    public final long alGetSourcei64vSOFT;
    public final long alGetStringiSOFT;
    public final boolean OpenAL10;
    public final boolean OpenAL11;
    public final boolean OpenAL_SOFT_bformat_ex;
    public final boolean AL_EXT_ALAW;
    public final boolean AL_EXT_BFORMAT;
    public final boolean AL_EXT_DOUBLE;
    public final boolean ALC_EXT_EFX;
    public final boolean AL_EXT_EXPONENT_DISTANCE;
    public final boolean AL_EXT_FLOAT32;
    public final boolean AL_EXT_IMA4;
    public final boolean AL_EXT_LINEAR_DISTANCE;
    public final boolean AL_EXT_MCFORMATS;
    public final boolean AL_EXT_MULAW;
    public final boolean AL_EXT_MULAW_BFORMAT;
    public final boolean AL_EXT_MULAW_MCFORMATS;
    public final boolean AL_EXT_OFFSET;
    public final boolean AL_EXT_source_distance_model;
    public final boolean AL_EXT_SOURCE_RADIUS;
    public final boolean AL_EXT_static_buffer;
    public final boolean AL_EXT_STEREO_ANGLES;
    public final boolean AL_EXT_vorbis;
    public final boolean AL_LOKI_IMA_ADPCM;
    public final boolean AL_LOKI_quadriphonic;
    public final boolean AL_LOKI_WAVE_format;
    public final boolean AL_SOFT_block_alignment;
    public final boolean AL_SOFT_buffer_samples;
    public final boolean AL_SOFT_buffer_sub_data;
    public final boolean AL_SOFT_deferred_updates;
    public final boolean AL_SOFT_direct_channels;
    public final boolean AL_SOFT_direct_channels_remix;
    public final boolean AL_SOFT_gain_clamp_ex;
    public final boolean AL_SOFT_loop_points;
    public final boolean AL_SOFT_MSADPCM;
    public final boolean AL_SOFT_source_latency;
    public final boolean AL_SOFT_source_length;
    public final boolean AL_SOFT_source_resampler;
    public final boolean AL_SOFT_source_spatialize;
    final PointerBuffer addresses;

    ALCapabilities(FunctionProvider functionProvider, Set<String> set, IntFunction<PointerBuffer> intFunction) {
        PointerBuffer pointerBuffer = intFunction.apply(123);
        this.OpenAL10 = ALCapabilities.check_AL10(functionProvider, pointerBuffer, set);
        this.OpenAL11 = ALCapabilities.check_AL11(functionProvider, pointerBuffer, set);
        this.OpenAL_SOFT_bformat_ex = set.contains("OpenAL_SOFT_bformat_ex");
        this.AL_EXT_ALAW = set.contains("AL_EXT_ALAW");
        this.AL_EXT_BFORMAT = set.contains("AL_EXT_BFORMAT");
        this.AL_EXT_DOUBLE = set.contains("AL_EXT_DOUBLE");
        this.ALC_EXT_EFX = ALCapabilities.check_EXT_EFX(functionProvider, pointerBuffer, set);
        this.AL_EXT_EXPONENT_DISTANCE = set.contains("AL_EXT_EXPONENT_DISTANCE");
        this.AL_EXT_FLOAT32 = set.contains("AL_EXT_FLOAT32");
        this.AL_EXT_IMA4 = set.contains("AL_EXT_IMA4");
        this.AL_EXT_LINEAR_DISTANCE = set.contains("AL_EXT_LINEAR_DISTANCE");
        this.AL_EXT_MCFORMATS = set.contains("AL_EXT_MCFORMATS");
        this.AL_EXT_MULAW = set.contains("AL_EXT_MULAW");
        this.AL_EXT_MULAW_BFORMAT = set.contains("AL_EXT_MULAW_BFORMAT");
        this.AL_EXT_MULAW_MCFORMATS = set.contains("AL_EXT_MULAW_MCFORMATS");
        this.AL_EXT_OFFSET = set.contains("AL_EXT_OFFSET");
        this.AL_EXT_source_distance_model = set.contains("AL_EXT_source_distance_model");
        this.AL_EXT_SOURCE_RADIUS = set.contains("AL_EXT_SOURCE_RADIUS");
        this.AL_EXT_static_buffer = ALCapabilities.check_EXT_static_buffer(functionProvider, pointerBuffer, set);
        this.AL_EXT_STEREO_ANGLES = set.contains("AL_EXT_STEREO_ANGLES");
        this.AL_EXT_vorbis = set.contains("AL_EXT_vorbis");
        this.AL_LOKI_IMA_ADPCM = set.contains("AL_LOKI_IMA_ADPCM");
        this.AL_LOKI_quadriphonic = set.contains("AL_LOKI_quadriphonic");
        this.AL_LOKI_WAVE_format = set.contains("AL_LOKI_WAVE_format");
        this.AL_SOFT_block_alignment = set.contains("AL_SOFT_block_alignment");
        this.AL_SOFT_buffer_samples = ALCapabilities.check_SOFT_buffer_samples(functionProvider, pointerBuffer, set);
        this.AL_SOFT_buffer_sub_data = ALCapabilities.check_SOFT_buffer_sub_data(functionProvider, pointerBuffer, set);
        this.AL_SOFT_deferred_updates = ALCapabilities.check_SOFT_deferred_updates(functionProvider, pointerBuffer, set);
        this.AL_SOFT_direct_channels = set.contains("AL_SOFT_direct_channels");
        this.AL_SOFT_direct_channels_remix = set.contains("AL_SOFT_direct_channels_remix");
        this.AL_SOFT_gain_clamp_ex = set.contains("AL_SOFT_gain_clamp_ex");
        this.AL_SOFT_loop_points = set.contains("AL_SOFT_loop_points");
        this.AL_SOFT_MSADPCM = set.contains("AL_SOFT_MSADPCM");
        this.AL_SOFT_source_latency = ALCapabilities.check_SOFT_source_latency(functionProvider, pointerBuffer, set);
        this.AL_SOFT_source_length = set.contains("AL_SOFT_source_length");
        this.AL_SOFT_source_resampler = ALCapabilities.check_SOFT_source_resampler(functionProvider, pointerBuffer, set);
        this.AL_SOFT_source_spatialize = set.contains("AL_SOFT_source_spatialize");
        this.alGetError = pointerBuffer.get(0);
        this.alEnable = pointerBuffer.get(1);
        this.alDisable = pointerBuffer.get(2);
        this.alIsEnabled = pointerBuffer.get(3);
        this.alGetBoolean = pointerBuffer.get(4);
        this.alGetInteger = pointerBuffer.get(5);
        this.alGetFloat = pointerBuffer.get(6);
        this.alGetDouble = pointerBuffer.get(7);
        this.alGetBooleanv = pointerBuffer.get(8);
        this.alGetIntegerv = pointerBuffer.get(9);
        this.alGetFloatv = pointerBuffer.get(10);
        this.alGetDoublev = pointerBuffer.get(11);
        this.alGetString = pointerBuffer.get(12);
        this.alDistanceModel = pointerBuffer.get(13);
        this.alDopplerFactor = pointerBuffer.get(14);
        this.alDopplerVelocity = pointerBuffer.get(15);
        this.alListenerf = pointerBuffer.get(16);
        this.alListeneri = pointerBuffer.get(17);
        this.alListener3f = pointerBuffer.get(18);
        this.alListenerfv = pointerBuffer.get(19);
        this.alGetListenerf = pointerBuffer.get(20);
        this.alGetListeneri = pointerBuffer.get(21);
        this.alGetListener3f = pointerBuffer.get(22);
        this.alGetListenerfv = pointerBuffer.get(23);
        this.alGenSources = pointerBuffer.get(24);
        this.alDeleteSources = pointerBuffer.get(25);
        this.alIsSource = pointerBuffer.get(26);
        this.alSourcef = pointerBuffer.get(27);
        this.alSource3f = pointerBuffer.get(28);
        this.alSourcefv = pointerBuffer.get(29);
        this.alSourcei = pointerBuffer.get(30);
        this.alGetSourcef = pointerBuffer.get(31);
        this.alGetSource3f = pointerBuffer.get(32);
        this.alGetSourcefv = pointerBuffer.get(33);
        this.alGetSourcei = pointerBuffer.get(34);
        this.alGetSourceiv = pointerBuffer.get(35);
        this.alSourceQueueBuffers = pointerBuffer.get(36);
        this.alSourceUnqueueBuffers = pointerBuffer.get(37);
        this.alSourcePlay = pointerBuffer.get(38);
        this.alSourcePause = pointerBuffer.get(39);
        this.alSourceStop = pointerBuffer.get(40);
        this.alSourceRewind = pointerBuffer.get(41);
        this.alSourcePlayv = pointerBuffer.get(42);
        this.alSourcePausev = pointerBuffer.get(43);
        this.alSourceStopv = pointerBuffer.get(44);
        this.alSourceRewindv = pointerBuffer.get(45);
        this.alGenBuffers = pointerBuffer.get(46);
        this.alDeleteBuffers = pointerBuffer.get(47);
        this.alIsBuffer = pointerBuffer.get(48);
        this.alGetBufferf = pointerBuffer.get(49);
        this.alGetBufferi = pointerBuffer.get(50);
        this.alBufferData = pointerBuffer.get(51);
        this.alGetEnumValue = pointerBuffer.get(52);
        this.alGetProcAddress = pointerBuffer.get(53);
        this.alIsExtensionPresent = pointerBuffer.get(54);
        this.alListener3i = pointerBuffer.get(55);
        this.alGetListeneriv = pointerBuffer.get(56);
        this.alSource3i = pointerBuffer.get(57);
        this.alListeneriv = pointerBuffer.get(58);
        this.alSourceiv = pointerBuffer.get(59);
        this.alBufferf = pointerBuffer.get(60);
        this.alBuffer3f = pointerBuffer.get(61);
        this.alBufferfv = pointerBuffer.get(62);
        this.alBufferi = pointerBuffer.get(63);
        this.alBuffer3i = pointerBuffer.get(64);
        this.alBufferiv = pointerBuffer.get(65);
        this.alGetBufferiv = pointerBuffer.get(66);
        this.alGetBufferfv = pointerBuffer.get(67);
        this.alSpeedOfSound = pointerBuffer.get(68);
        this.alGenEffects = pointerBuffer.get(69);
        this.alDeleteEffects = pointerBuffer.get(70);
        this.alIsEffect = pointerBuffer.get(71);
        this.alEffecti = pointerBuffer.get(72);
        this.alEffectiv = pointerBuffer.get(73);
        this.alEffectf = pointerBuffer.get(74);
        this.alEffectfv = pointerBuffer.get(75);
        this.alGetEffecti = pointerBuffer.get(76);
        this.alGetEffectiv = pointerBuffer.get(77);
        this.alGetEffectf = pointerBuffer.get(78);
        this.alGetEffectfv = pointerBuffer.get(79);
        this.alGenFilters = pointerBuffer.get(80);
        this.alDeleteFilters = pointerBuffer.get(81);
        this.alIsFilter = pointerBuffer.get(82);
        this.alFilteri = pointerBuffer.get(83);
        this.alFilteriv = pointerBuffer.get(84);
        this.alFilterf = pointerBuffer.get(85);
        this.alFilterfv = pointerBuffer.get(86);
        this.alGetFilteri = pointerBuffer.get(87);
        this.alGetFilteriv = pointerBuffer.get(88);
        this.alGetFilterf = pointerBuffer.get(89);
        this.alGetFilterfv = pointerBuffer.get(90);
        this.alGenAuxiliaryEffectSlots = pointerBuffer.get(91);
        this.alDeleteAuxiliaryEffectSlots = pointerBuffer.get(92);
        this.alIsAuxiliaryEffectSlot = pointerBuffer.get(93);
        this.alAuxiliaryEffectSloti = pointerBuffer.get(94);
        this.alAuxiliaryEffectSlotiv = pointerBuffer.get(95);
        this.alAuxiliaryEffectSlotf = pointerBuffer.get(96);
        this.alAuxiliaryEffectSlotfv = pointerBuffer.get(97);
        this.alGetAuxiliaryEffectSloti = pointerBuffer.get(98);
        this.alGetAuxiliaryEffectSlotiv = pointerBuffer.get(99);
        this.alGetAuxiliaryEffectSlotf = pointerBuffer.get(100);
        this.alGetAuxiliaryEffectSlotfv = pointerBuffer.get(101);
        this.alBufferDataStatic = pointerBuffer.get(102);
        this.alBufferSamplesSOFT = pointerBuffer.get(103);
        this.alBufferSubSamplesSOFT = pointerBuffer.get(104);
        this.alGetBufferSamplesSOFT = pointerBuffer.get(105);
        this.alIsBufferFormatSupportedSOFT = pointerBuffer.get(106);
        this.alBufferSubDataSOFT = pointerBuffer.get(107);
        this.alDeferUpdatesSOFT = pointerBuffer.get(108);
        this.alProcessUpdatesSOFT = pointerBuffer.get(109);
        this.alSourcedSOFT = pointerBuffer.get(110);
        this.alSource3dSOFT = pointerBuffer.get(111);
        this.alSourcedvSOFT = pointerBuffer.get(112);
        this.alGetSourcedSOFT = pointerBuffer.get(113);
        this.alGetSource3dSOFT = pointerBuffer.get(114);
        this.alGetSourcedvSOFT = pointerBuffer.get(115);
        this.alSourcei64SOFT = pointerBuffer.get(116);
        this.alSource3i64SOFT = pointerBuffer.get(117);
        this.alSourcei64vSOFT = pointerBuffer.get(118);
        this.alGetSourcei64SOFT = pointerBuffer.get(119);
        this.alGetSource3i64SOFT = pointerBuffer.get(120);
        this.alGetSourcei64vSOFT = pointerBuffer.get(121);
        this.alGetStringiSOFT = pointerBuffer.get(122);
        this.addresses = ThreadLocalUtil.setupAddressBuffer(pointerBuffer);
    }

    public PointerBuffer getAddressBuffer() {
        return this.addresses;
    }

    private static boolean check_AL10(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenAL10")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54}, "alGetError", "alEnable", "alDisable", "alIsEnabled", "alGetBoolean", "alGetInteger", "alGetFloat", "alGetDouble", "alGetBooleanv", "alGetIntegerv", "alGetFloatv", "alGetDoublev", "alGetString", "alDistanceModel", "alDopplerFactor", "alDopplerVelocity", "alListenerf", "alListeneri", "alListener3f", "alListenerfv", "alGetListenerf", "alGetListeneri", "alGetListener3f", "alGetListenerfv", "alGenSources", "alDeleteSources", "alIsSource", "alSourcef", "alSource3f", "alSourcefv", "alSourcei", "alGetSourcef", "alGetSource3f", "alGetSourcefv", "alGetSourcei", "alGetSourceiv", "alSourceQueueBuffers", "alSourceUnqueueBuffers", "alSourcePlay", "alSourcePause", "alSourceStop", "alSourceRewind", "alSourcePlayv", "alSourcePausev", "alSourceStopv", "alSourceRewindv", "alGenBuffers", "alDeleteBuffers", "alIsBuffer", "alGetBufferf", "alGetBufferi", "alBufferData", "alGetEnumValue", "alGetProcAddress", "alIsExtensionPresent") || Checks.reportMissing("AL", "OpenAL10");
    }

    private static boolean check_AL11(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenAL11")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68}, "alListener3i", "alGetListeneriv", "alSource3i", "alListeneriv", "alSourceiv", "alBufferf", "alBuffer3f", "alBufferfv", "alBufferi", "alBuffer3i", "alBufferiv", "alGetBufferiv", "alGetBufferfv", "alSpeedOfSound") || Checks.reportMissing("AL", "OpenAL11");
    }

    private static boolean check_EXT_EFX(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_EXT_EFX")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101}, "alGenEffects", "alDeleteEffects", "alIsEffect", "alEffecti", "alEffectiv", "alEffectf", "alEffectfv", "alGetEffecti", "alGetEffectiv", "alGetEffectf", "alGetEffectfv", "alGenFilters", "alDeleteFilters", "alIsFilter", "alFilteri", "alFilteriv", "alFilterf", "alFilterfv", "alGetFilteri", "alGetFilteriv", "alGetFilterf", "alGetFilterfv", "alGenAuxiliaryEffectSlots", "alDeleteAuxiliaryEffectSlots", "alIsAuxiliaryEffectSlot", "alAuxiliaryEffectSloti", "alAuxiliaryEffectSlotiv", "alAuxiliaryEffectSlotf", "alAuxiliaryEffectSlotfv", "alGetAuxiliaryEffectSloti", "alGetAuxiliaryEffectSlotiv", "alGetAuxiliaryEffectSlotf", "alGetAuxiliaryEffectSlotfv") || Checks.reportMissing("AL", "ALC_EXT_EFX");
    }

    private static boolean check_EXT_static_buffer(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_EXT_static_buffer")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{102}, "alBufferDataStatic") || Checks.reportMissing("AL", "AL_EXT_static_buffer");
    }

    private static boolean check_SOFT_buffer_samples(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_buffer_samples")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{103, 104, 105, 106}, "alBufferSamplesSOFT", "alBufferSubSamplesSOFT", "alGetBufferSamplesSOFT", "alIsBufferFormatSupportedSOFT") || Checks.reportMissing("AL", "AL_SOFT_buffer_samples");
    }

    private static boolean check_SOFT_buffer_sub_data(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_buffer_sub_data")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{107}, "alBufferSubDataSOFT") || Checks.reportMissing("AL", "AL_SOFT_buffer_sub_data");
    }

    private static boolean check_SOFT_deferred_updates(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_deferred_updates")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{108, 109}, "alDeferUpdatesSOFT", "alProcessUpdatesSOFT") || Checks.reportMissing("AL", "AL_SOFT_deferred_updates");
    }

    private static boolean check_SOFT_source_latency(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_source_latency")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121}, "alSourcedSOFT", "alSource3dSOFT", "alSourcedvSOFT", "alGetSourcedSOFT", "alGetSource3dSOFT", "alGetSourcedvSOFT", "alSourcei64SOFT", "alSource3i64SOFT", "alSourcei64vSOFT", "alGetSourcei64SOFT", "alGetSource3i64SOFT", "alGetSourcei64vSOFT") || Checks.reportMissing("AL", "AL_SOFT_source_latency");
    }

    private static boolean check_SOFT_source_resampler(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_source_resampler")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{122}, "alGetStringiSOFT") || Checks.reportMissing("AL", "AL_SOFT_source_resampler");
    }
}

