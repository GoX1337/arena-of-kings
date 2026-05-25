/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix.perfstat;

import com.sun.jna.platform.unix.aix.Perfstat;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class PerfstatCpu {
    private static final Perfstat PERF = Perfstat.INSTANCE;

    private PerfstatCpu() {
    }

    public static Perfstat.perfstat_cpu_total_t queryCpuTotal() {
        Perfstat.perfstat_cpu_total_t perfstat_cpu_total_t2 = new Perfstat.perfstat_cpu_total_t();
        int n2 = PERF.perfstat_cpu_total(null, perfstat_cpu_total_t2, perfstat_cpu_total_t2.size(), 1);
        if (n2 > 0) {
            return perfstat_cpu_total_t2;
        }
        return new Perfstat.perfstat_cpu_total_t();
    }

    public static Perfstat.perfstat_cpu_t[] queryCpu() {
        Perfstat.perfstat_cpu_t[] perfstat_cpu_tArray;
        Perfstat.perfstat_id_t perfstat_id_t2;
        int n2;
        Perfstat.perfstat_cpu_t perfstat_cpu_t2 = new Perfstat.perfstat_cpu_t();
        int n3 = PERF.perfstat_cpu(null, null, perfstat_cpu_t2.size(), 0);
        if (n3 > 0 && (n2 = PERF.perfstat_cpu(perfstat_id_t2 = new Perfstat.perfstat_id_t(), perfstat_cpu_tArray = (Perfstat.perfstat_cpu_t[])perfstat_cpu_t2.com_sun_jna_Structure_arr_toArray(n3), perfstat_cpu_t2.size(), n3)) > 0) {
            return perfstat_cpu_tArray;
        }
        return new Perfstat.perfstat_cpu_t[0];
    }

    public static long queryCpuAffinityMask() {
        int n2 = PerfstatCpu.queryCpuTotal().ncpus;
        if (n2 < 63) {
            return (1L << n2) - 1L;
        }
        return n2 == 63 ? Long.MAX_VALUE : -1L;
    }
}

