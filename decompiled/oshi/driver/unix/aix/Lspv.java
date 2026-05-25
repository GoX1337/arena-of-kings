/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.HWPartition;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class Lspv {
    private Lspv() {
    }

    public static List<HWPartition> queryLogicalVolumes(String string, Map<String, Pair<Integer, Integer>> map) {
        String string2;
        String string22 = "PV STATE:";
        String string3 = "PP SIZE:";
        long l2 = 0L;
        for (String object22 : ExecutingCommand.runNative("lspv -L " + string)) {
            if (object22.startsWith(string22)) {
                if (object22.contains("active")) continue;
                return Collections.emptyList();
            }
            if (!object22.contains(string3)) continue;
            l2 = ParseUtil.getFirstIntValue(object22);
        }
        if (l2 == 0L) {
            return Collections.emptyList();
        }
        l2 <<= 20;
        HashMap hashMap = new HashMap();
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        HashMap<String, Integer> hashMap3 = new HashMap<String, Integer>();
        for (String string4 : ExecutingCommand.runNative("lspv -p " + string)) {
            String[] stringArray = ParseUtil.whitespaces.split(string4.trim());
            if (stringArray.length < 6 || !"used".equals(stringArray[1])) continue;
            string2 = stringArray[stringArray.length - 3];
            hashMap.put(string2, stringArray[stringArray.length - 1]);
            hashMap2.put(string2, stringArray[stringArray.length - 2]);
            int n2 = 1 + ParseUtil.getNthIntValue(stringArray[0], 2) - ParseUtil.getNthIntValue(stringArray[0], 1);
            hashMap3.put(string2, n2 + hashMap3.getOrDefault(string2, 0));
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            string2 = "N/A".equals(entry.getValue()) ? "" : (String)entry.getValue();
            String string5 = (String)entry.getKey();
            String string6 = (String)hashMap2.get(string5);
            long l3 = l2 * (long)((Integer)hashMap3.get(string5)).intValue();
            Pair<Integer, Integer> pair = map.get(string5);
            int n3 = pair == null ? ParseUtil.getFirstIntValue(string5) : pair.getA();
            int n4 = pair == null ? ParseUtil.getFirstIntValue(string5) : pair.getB();
            arrayList.add(new HWPartition(string5, string5, string6, "", l3, n3, n4, string2));
        }
        return arrayList;
    }
}

