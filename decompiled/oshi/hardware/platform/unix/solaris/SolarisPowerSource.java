/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.solaris;

import com.sun.jna.platform.unix.solaris.LibKstat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.PowerSource;
import oshi.hardware.common.AbstractPowerSource;
import oshi.util.platform.unix.solaris.KstatUtil;

@ThreadSafe
public final class SolarisPowerSource
extends AbstractPowerSource {
    private static final String[] KSTAT_BATT_MOD = new String[]{null, "battery", "acpi_drv"};
    private static final int KSTAT_BATT_IDX;

    public SolarisPowerSource(String string, String string2, double d2, double d3, double d4, double d5, double d6, double d7, boolean bl2, boolean bl3, boolean bl4, PowerSource.CapacityUnits capacityUnits, int n2, int n3, int n4, int n5, String string3, LocalDate localDate, String string4, String string5, double d8) {
        super(string, string2, d2, d3, d4, d5, d6, d7, bl2, bl3, bl4, capacityUnits, n2, n3, n4, n5, string3, localDate, string4, string5, d8);
    }

    public static List<PowerSource> getPowerSources() {
        return Arrays.asList(SolarisPowerSource.getPowerSource("BAT0"));
    }

    private static SolarisPowerSource getPowerSource(String string) {
        String string2 = string;
        String string3 = "unknown";
        double d2 = 1.0;
        double d3 = -1.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = -1.0;
        double d7 = 0.0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        PowerSource.CapacityUnits capacityUnits = PowerSource.CapacityUnits.RELATIVE;
        int n2 = 0;
        int n3 = 1;
        int n4 = 1;
        int n5 = -1;
        String string4 = "unknown";
        LocalDate localDate = null;
        String string5 = "unknown";
        String string6 = "unknown";
        double d8 = 0.0;
        if (KSTAT_BATT_IDX > 0) {
            try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
                long l2;
                long l3;
                LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup(KSTAT_BATT_MOD[KSTAT_BATT_IDX], 0, "battery BIF0");
                if (kstat != null) {
                    l3 = KstatUtil.dataLookupLong(kstat, "bif_last_cap");
                    if (l3 == -1L || l3 <= 0L) {
                        l3 = KstatUtil.dataLookupLong(kstat, "bif_design_cap");
                    }
                    if (l3 != -1L && l3 > 0L) {
                        n3 = (int)l3;
                    }
                    if ((l2 = KstatUtil.dataLookupLong(kstat, "bif_unit")) == 0L) {
                        capacityUnits = PowerSource.CapacityUnits.MWH;
                    } else if (l2 == 1L) {
                        capacityUnits = PowerSource.CapacityUnits.MAH;
                    }
                    string3 = KstatUtil.dataLookupString(kstat, "bif_model");
                    string6 = KstatUtil.dataLookupString(kstat, "bif_serial");
                    string4 = KstatUtil.dataLookupString(kstat, "bif_type");
                    string5 = KstatUtil.dataLookupString(kstat, "bif_oem_info");
                }
                if ((kstat = KstatUtil.KstatChain.lookup(KSTAT_BATT_MOD[KSTAT_BATT_IDX], 0, "battery BST0")) != null) {
                    long l4;
                    boolean bl5;
                    l3 = KstatUtil.dataLookupLong(kstat, "bst_rem_cap");
                    if (l3 >= 0L) {
                        n2 = (int)l3;
                    }
                    if ((l2 = KstatUtil.dataLookupLong(kstat, "bst_rate")) == -1L) {
                        l2 = 0L;
                    }
                    boolean bl6 = bl5 = (KstatUtil.dataLookupLong(kstat, "bst_state") & 0x10L) > 0L;
                    if (!bl5) {
                        double d9 = d3 = l2 > 0L ? 3600.0 * (double)l3 / (double)l2 : -1.0;
                    }
                    if ((l4 = KstatUtil.dataLookupLong(kstat, "bst_voltage")) > 0L) {
                        d6 = (double)l4 / 1000.0;
                        d7 = d5 * 1000.0 / (double)l4;
                    }
                }
            }
        }
        return new SolarisPowerSource(string2, string3, d2, d3, d4, d5, d6, d7, bl2, bl3, bl4, capacityUnits, n2, n3, n4, n5, string4, localDate, string5, string6, d8);
    }

    static {
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            KSTAT_BATT_IDX = KstatUtil.KstatChain.lookup(KSTAT_BATT_MOD[1], 0, null) != null ? 1 : (KstatUtil.KstatChain.lookup(KSTAT_BATT_MOD[2], 0, null) != null ? 2 : 0);
        }
    }
}

