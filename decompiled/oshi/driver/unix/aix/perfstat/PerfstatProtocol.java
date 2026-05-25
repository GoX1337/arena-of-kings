/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix.perfstat;

import com.sun.jna.platform.unix.aix.Perfstat;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class PerfstatProtocol {
    private static final Perfstat PERF = Perfstat.INSTANCE;

    private PerfstatProtocol() {
    }

    public static Perfstat.perfstat_protocol_t[] queryProtocols() {
        Perfstat.perfstat_protocol_t[] perfstat_protocol_tArray;
        Perfstat.perfstat_id_t perfstat_id_t2;
        int n2;
        Perfstat.perfstat_protocol_t perfstat_protocol_t2 = new Perfstat.perfstat_protocol_t();
        int n3 = PERF.perfstat_protocol(null, null, perfstat_protocol_t2.size(), 0);
        if (n3 > 0 && (n2 = PERF.perfstat_protocol(perfstat_id_t2 = new Perfstat.perfstat_id_t(), perfstat_protocol_tArray = (Perfstat.perfstat_protocol_t[])perfstat_protocol_t2.com_sun_jna_Structure_arr_toArray(n3), perfstat_protocol_t2.size(), n3)) > 0) {
            return perfstat_protocol_tArray;
        }
        return new Perfstat.perfstat_protocol_t[0];
    }
}

