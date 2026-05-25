/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix;

import java.util.HashMap;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class Ls {
    private Ls() {
    }

    public static Map<String, Pair<Integer, Integer>> queryDeviceMajorMinor() {
        HashMap<String, Pair<Integer, Integer>> hashMap = new HashMap<String, Pair<Integer, Integer>>();
        for (String string : ExecutingCommand.runNative("ls -l /dev")) {
            int n2;
            if (string.isEmpty() || string.charAt(0) != 'b' || (n2 = string.lastIndexOf(32)) <= 0 || n2 >= string.length()) continue;
            String string2 = string.substring(n2 + 1);
            int n3 = ParseUtil.getNthIntValue(string, 2);
            int n4 = ParseUtil.getNthIntValue(string, 3);
            hashMap.put(string2, new Pair<Integer, Integer>(n3, n4));
        }
        return hashMap;
    }
}

