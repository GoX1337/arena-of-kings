/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.solaris.disk;

import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.HWPartition;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class Prtvtoc {
    private static final String PRTVTOC_DEV_DSK = "prtvtoc /dev/dsk/";

    private Prtvtoc() {
    }

    public static List<HWPartition> queryPartitions(String string, int n2) {
        ArrayList<HWPartition> arrayList = new ArrayList<HWPartition>();
        List<String> list = ExecutingCommand.runNative(PRTVTOC_DEV_DSK + string);
        if (list.size() > 1) {
            int n3 = 0;
            for (String string2 : list) {
                String string3;
                String string4;
                String[] stringArray;
                if (string2.startsWith("*")) {
                    if (!string2.endsWith("bytes/sector") || (stringArray = ParseUtil.whitespaces.split(string2)).length <= 0) continue;
                    n3 = ParseUtil.parseIntOrDefault(stringArray[1], 0);
                    continue;
                }
                if (n3 <= 0 || (stringArray = ParseUtil.whitespaces.split(string2.trim())).length < 6 || "2".equals(stringArray[0])) continue;
                String string5 = string + "s" + stringArray[0];
                int n4 = ParseUtil.parseIntOrDefault(stringArray[0], 0);
                switch (ParseUtil.parseIntOrDefault(stringArray[1], 0)) {
                    case 1: 
                    case 24: {
                        string4 = "boot";
                        break;
                    }
                    case 2: {
                        string4 = "root";
                        break;
                    }
                    case 3: {
                        string4 = "swap";
                        break;
                    }
                    case 4: {
                        string4 = "usr";
                        break;
                    }
                    case 5: {
                        string4 = "backup";
                        break;
                    }
                    case 6: {
                        string4 = "stand";
                        break;
                    }
                    case 7: {
                        string4 = "var";
                        break;
                    }
                    case 8: {
                        string4 = "home";
                        break;
                    }
                    case 9: {
                        string4 = "altsctr";
                        break;
                    }
                    case 10: {
                        string4 = "cache";
                        break;
                    }
                    case 11: {
                        string4 = "reserved";
                        break;
                    }
                    case 12: {
                        string4 = "system";
                        break;
                    }
                    case 14: {
                        string4 = "public region";
                        break;
                    }
                    case 15: {
                        string4 = "private region";
                        break;
                    }
                    default: {
                        string4 = "unknown";
                    }
                }
                switch (stringArray[2]) {
                    case "00": {
                        string3 = "wm";
                        break;
                    }
                    case "10": {
                        string3 = "rm";
                        break;
                    }
                    case "01": {
                        string3 = "wu";
                        break;
                    }
                    default: {
                        string3 = "ru";
                    }
                }
                long l2 = (long)n3 * ParseUtil.parseLongOrDefault(stringArray[4], 0L);
                String string6 = "";
                if (stringArray.length > 6) {
                    string6 = stringArray[6];
                }
                arrayList.add(new HWPartition(string5, string4, string3, "", l2, n2, n4, string6));
            }
        }
        return arrayList;
    }
}

