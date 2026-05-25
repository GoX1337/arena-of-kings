/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.solaris;

import java.util.ArrayList;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.common.AbstractSensors;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
final class SolarisSensors
extends AbstractSensors {
    SolarisSensors() {
    }

    @Override
    public double queryCpuTemperature() {
        double d2 = 0.0;
        for (String string : ExecutingCommand.runNative("/usr/sbin/prtpicl -v -c temperature-sensor")) {
            int n2;
            if (!string.trim().startsWith("Temperature:") || !((double)(n2 = ParseUtil.parseLastInt(string, 0)) > d2)) continue;
            d2 = n2;
        }
        if (d2 > 1000.0) {
            d2 /= 1000.0;
        }
        return d2;
    }

    @Override
    public int[] queryFanSpeeds() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (String string : ExecutingCommand.runNative("/usr/sbin/prtpicl -v -c fan")) {
            if (!string.trim().startsWith("Speed:")) continue;
            arrayList.add(ParseUtil.parseLastInt(string, 0));
        }
        Object object = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            object[i2] = (Integer)arrayList.get(i2);
        }
        return object;
    }

    @Override
    public double queryCpuVoltage() {
        double d2 = 0.0;
        for (String string : ExecutingCommand.runNative("/usr/sbin/prtpicl -v -c voltage-sensor")) {
            if (!string.trim().startsWith("Voltage:")) continue;
            d2 = ParseUtil.parseDoubleOrDefault(string.replace("Voltage:", "").trim(), 0.0);
            break;
        }
        return d2;
    }
}

