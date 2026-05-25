/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix.perfstat;

import com.sun.jna.platform.unix.aix.Perfstat;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class PerfstatNetInterface {
    private static final Perfstat PERF = Perfstat.INSTANCE;

    private PerfstatNetInterface() {
    }

    public static Perfstat.perfstat_netinterface_t[] queryNetInterfaces() {
        Perfstat.perfstat_netinterface_t[] perfstat_netinterface_tArray;
        Perfstat.perfstat_id_t perfstat_id_t2;
        int n2;
        Perfstat.perfstat_netinterface_t perfstat_netinterface_t2 = new Perfstat.perfstat_netinterface_t();
        int n3 = PERF.perfstat_netinterface(null, null, perfstat_netinterface_t2.size(), 0);
        if (n3 > 0 && (n2 = PERF.perfstat_netinterface(perfstat_id_t2 = new Perfstat.perfstat_id_t(), perfstat_netinterface_tArray = (Perfstat.perfstat_netinterface_t[])perfstat_netinterface_t2.com_sun_jna_Structure_arr_toArray(n3), perfstat_netinterface_t2.size(), n3)) > 0) {
            return perfstat_netinterface_tArray;
        }
        return new Perfstat.perfstat_netinterface_t[0];
    }
}

