/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.openbsd.disk;

import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.HWPartition;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Quartet;

@ThreadSafe
public final class Disklabel {
    private Disklabel() {
    }

    public static Quartet<String, String, Long, List<HWPartition>> getDiskParams(String string) {
        ArrayList<HWPartition> arrayList = new ArrayList<HWPartition>();
        String string2 = "total sectors:";
        long l2 = 1L;
        String string3 = "bytes/sector:";
        int n2 = 1;
        String string4 = "label:";
        String string5 = "";
        String string6 = "duid:";
        String string7 = "";
        for (String string8 : ExecutingCommand.runNative("disklabel -n " + string)) {
            if (string8.contains(string2)) {
                l2 = ParseUtil.getFirstIntValue(string8);
            } else if (string8.contains(string3)) {
                n2 = ParseUtil.getFirstIntValue(string8);
            } else if (string8.contains(string4)) {
                string5 = string8.split(string4)[1].trim();
            } else if (string8.contains(string6)) {
                string7 = string8.split(string6)[1].trim();
            }
            if (string8.trim().indexOf(58) != 1) continue;
            String[] stringArray = ParseUtil.whitespaces.split(string8.trim(), 9);
            String string9 = stringArray[0].substring(0, 1);
            Pair<Integer, Integer> pair = Disklabel.getMajorMinor(string, string9);
            if (stringArray.length <= 4) continue;
            arrayList.add(new HWPartition(string + string9, string9, stringArray[3], string7 + "." + string9, ParseUtil.parseLongOrDefault(stringArray[1], 0L) * (long)n2, pair.getA(), pair.getB(), stringArray.length > 5 ? stringArray[stringArray.length - 1] : ""));
        }
        if (arrayList.isEmpty()) {
            return Disklabel.getDiskParamsNoRoot(string);
        }
        return new Quartet<String, String, Long, List<HWPartition>>(string5, string7, l2 * (long)n2, arrayList);
    }

    private static Quartet<String, String, Long, List<HWPartition>> getDiskParamsNoRoot(String string) {
        ArrayList<HWPartition> arrayList = new ArrayList<HWPartition>();
        for (String string2 : ExecutingCommand.runNative("df")) {
            if (!string2.startsWith("/dev/" + string)) continue;
            String[] stringArray = ParseUtil.whitespaces.split(string2);
            String string3 = stringArray[0].substring(5 + string.length());
            Pair<Integer, Integer> pair = Disklabel.getMajorMinor(string, string3);
            if (stringArray.length <= 5) continue;
            long l2 = ParseUtil.parseLongOrDefault(stringArray[1], 1L) * 512L;
            arrayList.add(new HWPartition(stringArray[0], stringArray[0].substring(5), "unknown", "unknown", l2, pair.getA(), pair.getB(), stringArray[5]));
        }
        return new Quartet<String, String, Long, List<HWPartition>>("unknown", "unknown", 0L, arrayList);
    }

    private static Pair<Integer, Integer> getMajorMinor(String string, String string2) {
        int n2 = 0;
        int n3 = 0;
        String string3 = ExecutingCommand.getFirstAnswer("stat -f %Hr,%Lr /dev/" + string + string2);
        int n4 = string3.indexOf(44);
        if (n4 > 0 && n4 < string3.length()) {
            n2 = ParseUtil.parseIntOrDefault(string3.substring(0, n4), 0);
            n3 = ParseUtil.parseIntOrDefault(string3.substring(n4 + 1), 0);
        }
        return new Pair<Integer, Integer>(n2, n3);
    }
}

