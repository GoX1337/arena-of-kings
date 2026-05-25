/*
 * Decompiled with CFR 0.152.
 */
package oshi.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class LsofUtil {
    private LsofUtil() {
    }

    public static Map<Integer, String> getCwdMap(int n2) {
        List<String> list = ExecutingCommand.runNative("lsof -F n -d cwd" + (n2 < 0 ? "" : " -p " + n2));
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        Integer n3 = -1;
        for (String string : list) {
            if (string.isEmpty()) continue;
            switch (string.charAt(0)) {
                case 'p': {
                    n3 = ParseUtil.parseIntOrDefault(string.substring(1), -1);
                    break;
                }
                case 'n': {
                    hashMap.put(n3, string.substring(1));
                    break;
                }
            }
        }
        return hashMap;
    }

    public static String getCwd(int n2) {
        List<String> list = ExecutingCommand.runNative("lsof -F n -d cwd -p " + n2);
        for (String string : list) {
            if (string.isEmpty() || string.charAt(0) != 'n') continue;
            return string.substring(1).trim();
        }
        return "";
    }

    public static long getOpenFiles(int n2) {
        int n3 = ExecutingCommand.runNative("lsof -p " + n2).size();
        return n3 > 0 ? (long)n3 - 1L : 0L;
    }
}

