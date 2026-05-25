/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import javax.annotation.Nullable;
import org.lwjgl.openal.AL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTSourceResampler {
    public static final int AL_NUM_RESAMPLERS_SOFT = 4624;
    public static final int AL_DEFAULT_RESAMPLER_SOFT = 4625;
    public static final int AL_SOURCE_RESAMPLER_SOFT = 4626;
    public static final int AL_RESAMPLER_NAME_SOFT = 4627;

    protected SOFTSourceResampler() {
        throw new UnsupportedOperationException();
    }

    public static long nalGetStringiSOFT(int n2, int n3) {
        long l2 = AL.getICD().alGetStringiSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokeP(n2, n3, l2);
    }

    @Nullable
    @NativeType(value="ALchar const *")
    public static String alGetStringiSOFT(@NativeType(value="ALenum") int n2, @NativeType(value="ALsizei") int n3) {
        long l2 = SOFTSourceResampler.nalGetStringiSOFT(n2, n3);
        return MemoryUtil.memUTF8Safe(l2);
    }
}

