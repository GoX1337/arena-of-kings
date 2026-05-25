/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.aix;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.PowerSource;
import oshi.hardware.common.AbstractPowerSource;

@ThreadSafe
public final class AixPowerSource
extends AbstractPowerSource {
    public AixPowerSource(String string, String string2, double d2, double d3, double d4, double d5, double d6, double d7, boolean bl2, boolean bl3, boolean bl4, PowerSource.CapacityUnits capacityUnits, int n2, int n3, int n4, int n5, String string3, LocalDate localDate, String string4, String string5, double d8) {
        super(string, string2, d2, d3, d4, d5, d6, d7, bl2, bl3, bl4, capacityUnits, n2, n3, n4, n5, string3, localDate, string4, string5, d8);
    }

    public static List<PowerSource> getPowerSources() {
        return Collections.emptyList();
    }
}

