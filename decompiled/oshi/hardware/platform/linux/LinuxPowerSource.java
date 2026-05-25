/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.PowerSource;
import oshi.hardware.common.AbstractPowerSource;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;

@ThreadSafe
public final class LinuxPowerSource
extends AbstractPowerSource {
    private static final String PS_PATH = "/sys/class/power_supply/";

    public LinuxPowerSource(String string, String string2, double d2, double d3, double d4, double d5, double d6, double d7, boolean bl2, boolean bl3, boolean bl4, PowerSource.CapacityUnits capacityUnits, int n2, int n3, int n4, int n5, String string3, LocalDate localDate, String string4, String string5, double d8) {
        super(string, string2, d2, d3, d4, d5, d6, d7, bl2, bl3, bl4, capacityUnits, n2, n3, n4, n5, string3, localDate, string4, string5, d8);
    }

    public static List<PowerSource> getPowerSources() {
        double d2 = -1.0;
        double d3 = -1.0;
        double d4 = -1.0;
        double d5 = 0.0;
        double d6 = -1.0;
        double d7 = 0.0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        PowerSource.CapacityUnits capacityUnits = PowerSource.CapacityUnits.RELATIVE;
        int n2 = -1;
        int n3 = -1;
        int n4 = -1;
        int n5 = -1;
        LocalDate localDate = null;
        double d8 = 0.0;
        File file = new File(PS_PATH);
        String[] stringArray = file.list();
        ArrayList<PowerSource> arrayList = new ArrayList<PowerSource>();
        if (stringArray != null) {
            for (String string : stringArray) {
                List<String> list;
                if (string.startsWith("ADP") || string.startsWith("AC") || (list = FileUtil.readFile(PS_PATH + string + "/uevent", false)).isEmpty()) continue;
                HashMap<String, String> hashMap = new HashMap<String, String>();
                for (String string2 : list) {
                    String[] stringArray2 = string2.split("=");
                    if (stringArray2.length <= 1 || stringArray2[1].isEmpty()) continue;
                    hashMap.put(stringArray2[0], stringArray2[1]);
                }
                String string3 = hashMap.getOrDefault("POWER_SUPPLY_NAME", string);
                String string4 = (String)hashMap.get("POWER_SUPPLY_STATUS");
                bl3 = "Charging".equals(string4);
                bl4 = "Discharging".equals(string4);
                if (hashMap.containsKey("POWER_SUPPLY_CAPACITY")) {
                    d2 = (double)ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_CAPACITY"), -100) / 100.0;
                }
                if (hashMap.containsKey("POWER_SUPPLY_ENERGY_NOW")) {
                    n2 = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_ENERGY_NOW"), -1);
                } else if (hashMap.containsKey("POWER_SUPPLY_CHARGE_NOW")) {
                    n2 = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_CHARGE_NOW"), -1);
                }
                if (hashMap.containsKey("POWER_SUPPLY_ENERGY_FULL")) {
                    n2 = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_ENERGY_FULL"), 1);
                } else if (hashMap.containsKey("POWER_SUPPLY_CHARGE_FULL")) {
                    n2 = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_CHARGE_FULL"), 1);
                }
                if (hashMap.containsKey("POWER_SUPPLY_ENERGY_FULL_DESIGN")) {
                    n3 = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_ENERGY_FULL_DESIGN"), 1);
                } else if (hashMap.containsKey("POWER_SUPPLY_CHARGE_FULL_DESIGN")) {
                    n3 = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_CHARGE_FULL_DESIGN"), 1);
                }
                if (hashMap.containsKey("POWER_SUPPLY_VOLTAGE_NOW")) {
                    d6 = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_VOLTAGE_NOW"), -1);
                }
                if (hashMap.containsKey("POWER_SUPPLY_POWER_NOW")) {
                    d5 = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_POWER_NOW"), -1);
                }
                if (d6 > 0.0) {
                    d7 = d5 / d6;
                }
                if (hashMap.containsKey("POWER_SUPPLY_CYCLE_COUNT")) {
                    n5 = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_CYCLE_COUNT"), -1);
                }
                String string5 = hashMap.getOrDefault("POWER_SUPPLY_TECHNOLOGY", "unknown");
                String string6 = hashMap.getOrDefault("POWER_SUPPLY_MODEL_NAME", "unknown");
                String string7 = hashMap.getOrDefault("POWER_SUPPLY_MANUFACTURER", "unknown");
                String string8 = hashMap.getOrDefault("POWER_SUPPLY_SERIAL_NUMBER", "unknown");
                if (ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_PRESENT"), 1) <= 0) continue;
                arrayList.add(new LinuxPowerSource(string3, string6, d2, d3, d4, d5, d6, d7, bl2, bl3, bl4, capacityUnits, n2, n3, n4, n5, string5, localDate, string7, string8, d8));
            }
        }
        return arrayList;
    }
}

