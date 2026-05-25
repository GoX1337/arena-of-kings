/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.openbsd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.PowerSource;
import oshi.hardware.common.AbstractPowerSource;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class OpenBsdPowerSource
extends AbstractPowerSource {
    public OpenBsdPowerSource(String string, String string2, double d2, double d3, double d4, double d5, double d6, double d7, boolean bl2, boolean bl3, boolean bl4, PowerSource.CapacityUnits capacityUnits, int n2, int n3, int n4, int n5, String string3, LocalDate localDate, String string4, String string5, double d8) {
        super(string, string2, d2, d3, d4, d5, d6, d7, bl2, bl3, bl4, capacityUnits, n2, n3, n4, n5, string3, localDate, string4, string5, d8);
    }

    public static List<PowerSource> getPowerSources() {
        HashSet<String> hashSet = new HashSet<String>();
        for (String object : ExecutingCommand.runNative("systat -ab sensors")) {
            if (!object.contains(".amphour") && !object.contains(".watthour")) continue;
            int string = object.indexOf(46);
            hashSet.add(object.substring(0, string));
        }
        ArrayList arrayList = new ArrayList();
        for (String string : hashSet) {
            arrayList.add(OpenBsdPowerSource.getPowerSource(string));
        }
        return arrayList;
    }

    private static OpenBsdPowerSource getPowerSource(String string) {
        int n2;
        Object object;
        String string2 = string.startsWith("acpi") ? string.substring(4) : string;
        double d2 = 1.0;
        double d3 = -1.0;
        double d4 = 0.0;
        double d5 = -1.0;
        double d6 = 0.0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        PowerSource.CapacityUnits capacityUnits = PowerSource.CapacityUnits.RELATIVE;
        int n3 = 0;
        int n4 = 1;
        int n5 = 1;
        int n6 = -1;
        LocalDate localDate = null;
        double d7 = 0.0;
        for (String string3 : ExecutingCommand.runNative("systat -ab sensors")) {
            object = ParseUtil.whitespaces.split(string3);
            if (((String[])object).length <= 1 || !object[0].startsWith(string)) continue;
            if (object[0].contains("volt0") || object[0].contains("volt") && string3.contains("current")) {
                d5 = ParseUtil.parseDoubleOrDefault(object[1], -1.0);
                continue;
            }
            if (object[0].contains("current0")) {
                d6 = ParseUtil.parseDoubleOrDefault(object[1], 0.0);
                continue;
            }
            if (object[0].contains("temp0")) {
                d7 = ParseUtil.parseDoubleOrDefault(object[1], 0.0);
                continue;
            }
            if (!object[0].contains("watthour") && !object[0].contains("amphour")) continue;
            PowerSource.CapacityUnits capacityUnits2 = capacityUnits = object[0].contains("watthour") ? PowerSource.CapacityUnits.MWH : PowerSource.CapacityUnits.MAH;
            if (string3.contains("remaining")) {
                n3 = (int)(1000.0 * ParseUtil.parseDoubleOrDefault(object[1], 0.0));
                continue;
            }
            if (string3.contains("full")) {
                n4 = (int)(1000.0 * ParseUtil.parseDoubleOrDefault(object[1], 0.0));
                continue;
            }
            if (!string3.contains("new") && !string3.contains("design")) continue;
            n5 = (int)(1000.0 * ParseUtil.parseDoubleOrDefault(object[1], 0.0));
        }
        int n7 = ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("apm -b"), 255);
        if (n7 < 4) {
            bl2 = true;
            if (n7 == 3) {
                bl3 = true;
            } else {
                int n8 = ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("apm -m"), -1);
                d3 = n8 < 0 ? -1.0 : 60.0 * (double)n8;
                bl4 = true;
            }
        }
        if ((n2 = ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("apm -l"), -1)) > 0) {
            d2 = (double)n2 / 100.0;
        }
        if (n4 < n5 && n4 < n3) {
            n4 = n5;
        } else if (n5 < n4 && n5 < n3) {
            n5 = n4;
        }
        object = "unknown";
        String string4 = "unknown";
        String string5 = "unknown";
        String string6 = "unknown";
        double d8 = d3;
        if (d5 > 0.0) {
            if (d6 > 0.0 && d4 == 0.0) {
                d4 = d6 * d5;
            } else if (d6 == 0.0 && d4 > 0.0) {
                d6 = d4 / d5;
            }
        }
        return new OpenBsdPowerSource(string2, (String)object, d2, d3, d8, d4, d5, d6, bl2, bl3, bl4, capacityUnits, n3, n4, n5, n6, string5, localDate, string6, string4, d7);
    }
}

