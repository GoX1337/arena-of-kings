/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix.perfstat;

import com.sun.jna.platform.unix.aix.Perfstat;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class PerfstatConfig {
    private static final Perfstat PERF = Perfstat.INSTANCE;

    private PerfstatConfig() {
    }

    public static Perfstat.perfstat_partition_config_t queryConfig() {
        Perfstat.perfstat_partition_config_t perfstat_partition_config_t2 = new Perfstat.perfstat_partition_config_t();
        int n2 = PERF.perfstat_partition_config(null, perfstat_partition_config_t2, perfstat_partition_config_t2.size(), 1);
        if (n2 > 0) {
            return perfstat_partition_config_t2;
        }
        return new Perfstat.perfstat_partition_config_t();
    }
}

