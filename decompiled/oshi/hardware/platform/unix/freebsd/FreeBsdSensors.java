/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.platform.unix.LibCAPI$size_t$ByReference
 */
package oshi.hardware.platform.unix.freebsd;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.unix.LibCAPI;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.common.AbstractSensors;
import oshi.jna.platform.unix.FreeBsdLibc;

@ThreadSafe
final class FreeBsdSensors
extends AbstractSensors {
    FreeBsdSensors() {
    }

    @Override
    public double queryCpuTemperature() {
        return FreeBsdSensors.queryKldloadCoretemp();
    }

    private static double queryKldloadCoretemp() {
        String string = "dev.cpu.%d.temperature";
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t((long)FreeBsdLibc.INT_SIZE));
        Memory memory = new Memory(byReference.longValue());
        int n2 = 0;
        double d2 = 0.0;
        while (0 == FreeBsdLibc.INSTANCE.sysctlbyname(String.format(string, n2), memory, byReference, null, LibCAPI.size_t.ZERO)) {
            d2 += (double)((Pointer)memory).getInt(0L) / 10.0 - 273.15;
            ++n2;
        }
        return n2 > 0 ? d2 / (double)n2 : Double.NaN;
    }

    @Override
    public int[] queryFanSpeeds() {
        return new int[0];
    }

    @Override
    public double queryCpuVoltage() {
        return 0.0;
    }
}

