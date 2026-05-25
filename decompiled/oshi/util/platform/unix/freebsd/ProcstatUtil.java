/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.platform.unix.freebsd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class ProcstatUtil {
    private ProcstatUtil() {
    }

    public static Map<Integer, String> getCwdMap(int n2) {
        List<String> list = ExecutingCommand.runNative("procstat -f " + (n2 < 0 ? "-a" : Integer.valueOf(n2)));
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        for (String string : list) {
            String[] stringArray = ParseUtil.whitespaces.split(string.trim(), 10);
            if (stringArray.length != 10 || !stringArray[2].equals("cwd")) continue;
            hashMap.put(ParseUtil.parseIntOrDefault(stringArray[0], -1), stringArray[9]);
        }
        return hashMap;
    }

    public static String getCwd(int n2) {
        List<String> list = ExecutingCommand.runNative("procstat -f " + n2);
        for (String string : list) {
            String[] stringArray = ParseUtil.whitespaces.split(string.trim(), 10);
            if (stringArray.length != 10 || !stringArray[2].equals("cwd")) continue;
            return stringArray[9];
        }
        return "";
    }

    public static long getOpenFiles(int n2) {
        long l2 = 0L;
        List<String> list = ExecutingCommand.runNative("procstat -f " + n2);
        for (String string : list) {
            String[] stringArray = ParseUtil.whitespaces.split(string.trim(), 10);
            if (stringArray.length != 10 || "Vd-".contains(stringArray[4])) continue;
            ++l2;
        }
        return l2;
    }
}

