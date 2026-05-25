/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.freebsd.disk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.tuples.Triplet;

@ThreadSafe
public final class GeomDiskList {
    private static final String GEOM_DISK_LIST = "geom disk list";

    private GeomDiskList() {
    }

    public static Map<String, Triplet<String, String, Long>> queryDisks() {
        HashMap<String, Triplet<String, String, Long>> hashMap = new HashMap<String, Triplet<String, String, Long>>();
        String string = null;
        String string2 = "unknown";
        String string3 = "unknown";
        long l2 = 0L;
        List<String> list = ExecutingCommand.runNative(GEOM_DISK_LIST);
        for (String string4 : list) {
            String[] stringArray;
            if ((string4 = string4.trim()).startsWith("Geom name:")) {
                if (string != null) {
                    hashMap.put(string, new Triplet<String, String, Long>(string2, string3, l2));
                    string2 = "unknown";
                    string3 = "unknown";
                    l2 = 0L;
                }
                string = string4.substring(string4.lastIndexOf(32) + 1);
            }
            if (string == null) continue;
            if ((string4 = string4.trim()).startsWith("Mediasize:") && (stringArray = ParseUtil.whitespaces.split(string4)).length > 1) {
                l2 = ParseUtil.parseLongOrDefault(stringArray[1], 0L);
            }
            if (string4.startsWith("descr:")) {
                string2 = string4.replace("descr:", "").trim();
            }
            if (!string4.startsWith("ident:")) continue;
            string3 = string4.replace("ident:", "").replace("(null)", "").trim();
        }
        if (string != null) {
            hashMap.put(string, new Triplet<String, String, Long>(string2, string3, l2));
        }
        return hashMap;
    }
}

