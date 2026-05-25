/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.aix;

import java.util.List;
import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.common.AbstractSensors;

@ThreadSafe
final class AixSensors
extends AbstractSensors {
    private final Supplier<List<String>> lscfg;

    AixSensors(Supplier<List<String>> supplier) {
        this.lscfg = supplier;
    }

    @Override
    public double queryCpuTemperature() {
        return 0.0;
    }

    @Override
    public int[] queryFanSpeeds() {
        int n2 = 0;
        for (String string : this.lscfg.get()) {
            if (!string.contains("Air Mover")) continue;
            ++n2;
        }
        return new int[n2];
    }

    @Override
    public double queryCpuVoltage() {
        return 0.0;
    }
}

