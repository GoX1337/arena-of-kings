/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class Lssrad {
    private Lssrad() {
    }

    public static Map<Integer, Pair<Integer, Integer>> queryNodesPackages() {
        int n2 = 0;
        int n3 = 0;
        HashMap<Integer, Pair<Integer, Integer>> hashMap = new HashMap<Integer, Pair<Integer, Integer>>();
        List<String> list = ExecutingCommand.runNative("lssrad -av");
        if (!list.isEmpty()) {
            list.remove(0);
        }
        for (String string : list) {
            String string2 = string.trim();
            if (string2.isEmpty()) continue;
            if (Character.isDigit(string.charAt(0))) {
                n2 = ParseUtil.parseIntOrDefault(string2, 0);
                continue;
            }
            if (string2.contains(".")) {
                String[] stringArray = ParseUtil.whitespaces.split(string2, 3);
                n3 = ParseUtil.parseIntOrDefault(stringArray[0], 0);
                string2 = stringArray.length > 2 ? stringArray[2] : "";
            }
            for (Integer n4 : ParseUtil.parseHyphenatedIntList(string2)) {
                hashMap.put(n4, new Pair<Integer, Integer>(n2, n3));
            }
        }
        return hashMap;
    }
}

