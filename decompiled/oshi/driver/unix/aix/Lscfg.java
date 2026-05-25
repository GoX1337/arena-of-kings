/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix;

import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

@ThreadSafe
public final class Lscfg {
    private Lscfg() {
    }

    public static List<String> queryAllDevices() {
        return ExecutingCommand.runNative("lscfg -vp");
    }

    public static Triplet<String, String, String> queryBackplaneModelSerialVersion(List<String> list) {
        String string = "WAY BACKPLANE";
        String string2 = "Part Number";
        String string3 = "Serial Number";
        String string4 = "Version";
        String string5 = "Physical Location";
        String string6 = null;
        String string7 = null;
        String string8 = null;
        boolean bl2 = false;
        for (String string9 : list) {
            if (!bl2 && string9.contains("WAY BACKPLANE")) {
                bl2 = true;
                continue;
            }
            if (!bl2) continue;
            if (string9.contains("Part Number")) {
                string6 = ParseUtil.removeLeadingDots(string9.split("Part Number")[1].trim());
                continue;
            }
            if (string9.contains("Serial Number")) {
                string7 = ParseUtil.removeLeadingDots(string9.split("Serial Number")[1].trim());
                continue;
            }
            if (string9.contains("Version")) {
                string8 = ParseUtil.removeLeadingDots(string9.split("Version")[1].trim());
                continue;
            }
            if (!string9.contains("Physical Location")) continue;
            break;
        }
        return new Triplet<Object, Object, Object>(string6, string7, string8);
    }

    public static Pair<String, String> queryModelSerial(String string) {
        String string2 = "Machine Type and Model";
        String string3 = "Serial Number";
        String string4 = null;
        String string5 = null;
        for (String string6 : ExecutingCommand.runNative("lscfg -vl " + string)) {
            if (string6.contains(string2)) {
                string4 = ParseUtil.removeLeadingDots(string6.split(string2)[1].trim());
                continue;
            }
            if (!string6.contains(string3)) continue;
            string5 = ParseUtil.removeLeadingDots(string6.split(string3)[1].trim());
        }
        return new Pair<Object, Object>(string4, string5);
    }
}

