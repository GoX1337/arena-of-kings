/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import com.sun.jna.platform.mac.IOKit;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.common.AbstractSensors;
import oshi.util.platform.mac.SmcUtil;

@ThreadSafe
final class MacSensors
extends AbstractSensors {
    private int numFans = 0;

    MacSensors() {
    }

    @Override
    public double queryCpuTemperature() {
        IOKit.IOConnect iOConnect = SmcUtil.smcOpen();
        double d2 = SmcUtil.smcGetFloat(iOConnect, "TC0P");
        SmcUtil.smcClose(iOConnect);
        if (d2 > 0.0) {
            return d2;
        }
        return 0.0;
    }

    @Override
    public int[] queryFanSpeeds() {
        IOKit.IOConnect iOConnect = SmcUtil.smcOpen();
        if (this.numFans == 0) {
            this.numFans = (int)SmcUtil.smcGetLong(iOConnect, "FNum");
        }
        int[] nArray = new int[this.numFans];
        for (int i2 = 0; i2 < this.numFans; ++i2) {
            nArray[i2] = (int)SmcUtil.smcGetFloat(iOConnect, String.format("F%dAc", i2));
        }
        SmcUtil.smcClose(iOConnect);
        return nArray;
    }

    @Override
    public double queryCpuVoltage() {
        IOKit.IOConnect iOConnect = SmcUtil.smcOpen();
        double d2 = SmcUtil.smcGetFloat(iOConnect, "VC0C") / 1000.0;
        SmcUtil.smcClose(iOConnect);
        return d2;
    }
}

