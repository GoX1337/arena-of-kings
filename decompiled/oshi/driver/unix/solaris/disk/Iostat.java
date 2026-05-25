/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.solaris.disk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.tuples.Quintet;

@ThreadSafe
public final class Iostat {
    private static final String IOSTAT_ER_DETAIL = "iostat -Er";
    private static final String IOSTAT_ER = "iostat -er";
    private static final String IOSTAT_ERN = "iostat -ern";
    private static final String DEVICE_HEADER = "device";

    private Iostat() {
    }

    public static Map<String, String> queryPartitionToMountMap() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        List<String> list = ExecutingCommand.runNative(IOSTAT_ER);
        List<String> list2 = ExecutingCommand.runNative(IOSTAT_ERN);
        for (int i2 = 0; i2 < list.size() && i2 < list2.size(); ++i2) {
            String string;
            String[] stringArray;
            String string2 = list.get(i2);
            String[] stringArray2 = string2.split(",");
            if (stringArray2.length < 5 || DEVICE_HEADER.equals(stringArray2[0]) || (stringArray = (string = list2.get(i2)).split(",")).length < 5 || DEVICE_HEADER.equals(stringArray[4])) continue;
            hashMap.put(stringArray2[0], stringArray[4]);
        }
        return hashMap;
    }

    public static Map<String, Quintet<String, String, String, String, Long>> queryDeviceStrings(Set<String> set) {
        HashMap<String, Quintet<String, String, String, String, Long>> hashMap = new HashMap<String, Quintet<String, String, String, String, Long>>();
        List<String> list = ExecutingCommand.runNative(IOSTAT_ER_DETAIL);
        String string = null;
        String string2 = "";
        String string3 = "";
        String string4 = "";
        String string5 = "";
        long l2 = 0L;
        for (String string6 : list) {
            String[] stringArray;
            for (String string7 : stringArray = string6.split(",")) {
                String[] stringArray2;
                if (set.contains(string7 = string7.trim())) {
                    if (string != null) {
                        hashMap.put(string, new Quintet<String, String, String, String, Long>(string2, string3, string4, string5, l2));
                    }
                    string = string7;
                    string2 = "";
                    string3 = "";
                    string4 = "";
                    string5 = "";
                    l2 = 0L;
                    continue;
                }
                if (string7.startsWith("Model:")) {
                    string2 = string7.replace("Model:", "").trim();
                    continue;
                }
                if (string7.startsWith("Serial No:")) {
                    string5 = string7.replace("Serial No:", "").trim();
                    continue;
                }
                if (string7.startsWith("Vendor:")) {
                    string3 = string7.replace("Vendor:", "").trim();
                    continue;
                }
                if (string7.startsWith("Product:")) {
                    string4 = string7.replace("Product:", "").trim();
                    continue;
                }
                if (!string7.startsWith("Size:") || (stringArray2 = string7.split("<")).length <= 1) continue;
                stringArray2 = ParseUtil.whitespaces.split(stringArray2[1]);
                l2 = ParseUtil.parseLongOrDefault(stringArray2[0], 0L);
            }
            if (string == null) continue;
            hashMap.put(string, new Quintet<String, String, String, String, Long>(string2, string3, string4, string5, l2));
        }
        return hashMap;
    }
}

