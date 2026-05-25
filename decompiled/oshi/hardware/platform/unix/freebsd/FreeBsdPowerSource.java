/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.freebsd;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.PowerSource;
import oshi.hardware.common.AbstractPowerSource;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.freebsd.BsdSysctlUtil;

@ThreadSafe
public final class FreeBsdPowerSource
extends AbstractPowerSource {
    public FreeBsdPowerSource(String string, String string2, double d2, double d3, double d4, double d5, double d6, double d7, boolean bl2, boolean bl3, boolean bl4, PowerSource.CapacityUnits capacityUnits, int n2, int n3, int n4, int n5, String string3, LocalDate localDate, String string4, String string5, double d8) {
        super(string, string2, d2, d3, d4, d5, d6, d7, bl2, bl3, bl4, capacityUnits, n2, n3, n4, n5, string3, localDate, string4, string5, d8);
    }

    public static List<PowerSource> getPowerSources() {
        return Arrays.asList(FreeBsdPowerSource.getPowerSource("BAT0"));
    }

    private static FreeBsdPowerSource getPowerSource(String string) {
        String string2;
        Object object;
        String string3;
        Object object2;
        String string42;
        int n2;
        String string5 = string;
        double d2 = 1.0;
        double d3 = -1.0;
        double d4 = 0.0;
        int n3 = -1;
        double d5 = 0.0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        PowerSource.CapacityUnits capacityUnits = PowerSource.CapacityUnits.RELATIVE;
        int n4 = 0;
        int n5 = 1;
        int n6 = 1;
        int n7 = -1;
        LocalDate localDate = null;
        double d6 = 0.0;
        int n8 = BsdSysctlUtil.sysctl("hw.acpi.battery.state", 0);
        if (n8 == 2) {
            bl3 = true;
        } else {
            n2 = BsdSysctlUtil.sysctl("hw.acpi.battery.time", -1);
            double d7 = d3 = n2 < 0 ? -1.0 : 60.0 * (double)n2;
            if (n8 == 1) {
                bl4 = true;
            }
        }
        n2 = BsdSysctlUtil.sysctl("hw.acpi.battery.life", -1);
        if (n2 > 0) {
            d2 = (double)n2 / 100.0;
        }
        List<String> list = ExecutingCommand.runNative("acpiconf -i 0");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (String string42 : list) {
            object2 = string42.split(":", 2);
            if (((String[])object2).length <= 1 || (string3 = object2[1].trim()).isEmpty()) continue;
            hashMap.put(object2[0], string3);
        }
        String string6 = hashMap.getOrDefault("Model number", "unknown");
        string42 = hashMap.getOrDefault("Serial number", "unknown");
        object2 = hashMap.getOrDefault("Type", "unknown");
        string3 = hashMap.getOrDefault("OEM info", "unknown");
        String string7 = (String)hashMap.get("Design capacity");
        if (string7 != null) {
            n6 = ParseUtil.getFirstIntValue(string7);
            if (string7.toLowerCase().contains("mah")) {
                capacityUnits = PowerSource.CapacityUnits.MAH;
            } else if (string7.toLowerCase().contains("mwh")) {
                capacityUnits = PowerSource.CapacityUnits.MWH;
            }
        }
        n5 = (string7 = (String)hashMap.get("Last full capacity")) != null ? ParseUtil.getFirstIntValue(string7) : n6;
        double d8 = d3;
        String string8 = (String)hashMap.get("Remaining time");
        if (string8 != null && ((String[])(object = string8.split(":"))).length == 2) {
            d8 = 3600.0 * (double)ParseUtil.parseIntOrDefault(object[0], 0) + 60.0 * (double)ParseUtil.parseIntOrDefault(object[1], 0);
        }
        if ((object = (String)hashMap.get("Present rate")) != null) {
            d4 = ParseUtil.getFirstIntValue((String)object);
        }
        if ((string2 = (String)hashMap.get("Present voltage")) != null && (n3 = ParseUtil.getFirstIntValue(string2)) != 0) {
            d5 = d4 / (double)n3;
        }
        return new FreeBsdPowerSource(string5, string6, d2, d3, d8, d4, n3, d5, bl2, bl3, bl4, capacityUnits, n4, n5, n6, n7, (String)object2, localDate, string3, string42, d6);
    }
}

