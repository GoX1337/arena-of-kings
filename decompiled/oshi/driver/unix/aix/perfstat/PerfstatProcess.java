/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix.perfstat;

import com.sun.jna.platform.unix.aix.Perfstat;
import java.util.Arrays;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class PerfstatProcess {
    private static final Perfstat PERF = Perfstat.INSTANCE;

    private PerfstatProcess() {
    }

    public static Perfstat.perfstat_process_t[] queryProcesses() {
        Perfstat.perfstat_process_t[] perfstat_process_tArray;
        Perfstat.perfstat_id_t perfstat_id_t2;
        int n2;
        Perfstat.perfstat_process_t perfstat_process_t2 = new Perfstat.perfstat_process_t();
        int n3 = PERF.perfstat_process(null, null, perfstat_process_t2.size(), 0);
        if (n3 > 0 && (n2 = PERF.perfstat_process(perfstat_id_t2 = new Perfstat.perfstat_id_t(), perfstat_process_tArray = (Perfstat.perfstat_process_t[])perfstat_process_t2.com_sun_jna_Structure_arr_toArray(n3), perfstat_process_t2.size(), n3)) > 0) {
            return Arrays.copyOf(perfstat_process_tArray, n2);
        }
        return new Perfstat.perfstat_process_t[0];
    }
}

