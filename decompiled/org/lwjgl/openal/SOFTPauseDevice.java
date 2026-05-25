/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.lwjgl.openal.ALC;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class SOFTPauseDevice {
    protected SOFTPauseDevice() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="ALCvoid")
    public static void alcDevicePauseSOFT(@NativeType(value="ALCdevice *") long l2) {
        long l3 = ALC.getICD().alcDevicePauseSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.invokePV(l2, l3);
    }

    @NativeType(value="ALCvoid")
    public static void alcDeviceResumeSOFT(@NativeType(value="ALCdevice *") long l2) {
        long l3 = ALC.getICD().alcDeviceResumeSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.invokePV(l2, l3);
    }
}

