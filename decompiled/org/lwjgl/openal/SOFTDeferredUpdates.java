/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.lwjgl.openal.AL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class SOFTDeferredUpdates {
    public static final int AL_DEFERRED_UPDATES_SOFT = 49154;

    protected SOFTDeferredUpdates() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="ALvoid")
    public static void alDeferUpdatesSOFT() {
        long l2 = AL.getICD().alDeferUpdatesSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokeV(l2);
    }

    @NativeType(value="ALvoid")
    public static void alProcessUpdatesSOFT() {
        long l2 = AL.getICD().alProcessUpdatesSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokeV(l2);
    }
}

