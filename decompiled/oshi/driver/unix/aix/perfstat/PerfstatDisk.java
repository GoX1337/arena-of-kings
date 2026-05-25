/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix.perfstat;

import com.sun.jna.platform.unix.aix.Perfstat;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class PerfstatDisk {
    private static final Perfstat PERF = Perfstat.INSTANCE;

    private PerfstatDisk() {
    }

    public static Perfstat.perfstat_disk_t[] queryDiskStats() {
        Perfstat.perfstat_disk_t[] perfstat_disk_tArray;
        Perfstat.perfstat_id_t perfstat_id_t2;
        int n2;
        Perfstat.perfstat_disk_t perfstat_disk_t2 = new Perfstat.perfstat_disk_t();
        int n3 = PERF.perfstat_disk(null, null, perfstat_disk_t2.size(), 0);
        if (n3 > 0 && (n2 = PERF.perfstat_disk(perfstat_id_t2 = new Perfstat.perfstat_id_t(), perfstat_disk_tArray = (Perfstat.perfstat_disk_t[])perfstat_disk_t2.com_sun_jna_Structure_arr_toArray(n3), perfstat_disk_t2.size(), n3)) > 0) {
            return perfstat_disk_tArray;
        }
        return new Perfstat.perfstat_disk_t[0];
    }
}

