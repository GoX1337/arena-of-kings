/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix.perfstat;

import com.sun.jna.platform.unix.aix.Perfstat;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class PerfstatMemory {
    private static final Perfstat PERF = Perfstat.INSTANCE;

    private PerfstatMemory() {
    }

    public static Perfstat.perfstat_memory_total_t queryMemoryTotal() {
        Perfstat.perfstat_memory_total_t perfstat_memory_total_t2 = new Perfstat.perfstat_memory_total_t();
        int n2 = PERF.perfstat_memory_total(null, perfstat_memory_total_t2, perfstat_memory_total_t2.size(), 1);
        if (n2 > 0) {
            return perfstat_memory_total_t2;
        }
        return new Perfstat.perfstat_memory_total_t();
    }
}

