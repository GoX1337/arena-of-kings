/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.freebsd.disk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.freebsd.disk.Mount;
import oshi.hardware.HWPartition;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class GeomPartList {
    private static final String GEOM_PART_LIST = "geom part list";
    private static final String STAT_FILESIZE = "stat -f %i /dev/";

    private GeomPartList() {
    }

    public static Map<String, List<HWPartition>> queryPartitions() {
        Map<String, String> map = Mount.queryPartitionToMountMap();
        HashMap<String, List<HWPartition>> hashMap = new HashMap<String, List<HWPartition>>();
        String string = null;
        List<Object> list = new ArrayList();
        Object object = null;
        Object object2 = "unknown";
        Object object3 = "unknown";
        Object object4 = "unknown";
        long l2 = 0L;
        String string2 = "";
        List<String> list2 = ExecutingCommand.runNative(GEOM_PART_LIST);
        for (String string3 : list2) {
            Object object5;
            if ((string3 = string3.trim()).startsWith("Geom name:")) {
                if (string != null && !list.isEmpty()) {
                    hashMap.put(string, list);
                    list = new ArrayList();
                }
                string = string3.substring(string3.lastIndexOf(32) + 1);
            }
            if (string == null) continue;
            if (string3.contains("Name:")) {
                if (object != null) {
                    int n2 = ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer(STAT_FILESIZE + object), 0);
                    list.add(new HWPartition((String)object2, (String)object, (String)object3, (String)object4, l2, 0, n2, string2));
                    object = null;
                    object2 = "unknown";
                    object3 = "unknown";
                    object4 = "unknown";
                    l2 = 0L;
                }
                if (((String)(object5 = string3.substring(string3.lastIndexOf(32) + 1))).startsWith(string)) {
                    object = object5;
                    object2 = object5;
                    string2 = map.getOrDefault(object5, "");
                }
            }
            if (object == null || ((String[])(object5 = ParseUtil.whitespaces.split(string3))).length < 2) continue;
            if (string3.startsWith("Mediasize:")) {
                l2 = ParseUtil.parseLongOrDefault((String)object5[1], 0L);
                continue;
            }
            if (string3.startsWith("rawuuid:")) {
                object4 = object5[1];
                continue;
            }
            if (!string3.startsWith("type:")) continue;
            object3 = object5[1];
        }
        if (string != null) {
            if (object != null) {
                int n3 = ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer(STAT_FILESIZE + object), 0);
                list.add(new HWPartition((String)object2, (String)object, (String)object3, (String)object4, l2, 0, n3, string2));
            }
            if (!list.isEmpty()) {
                list = list.stream().sorted(Comparator.comparing(HWPartition::getName)).collect(Collectors.toList());
                hashMap.put(string, list);
            }
        }
        return hashMap;
    }
}

