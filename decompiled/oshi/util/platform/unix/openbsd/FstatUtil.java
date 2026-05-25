/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.platform.unix.openbsd;

import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class FstatUtil {
    private FstatUtil() {
    }

    public static String getCwd(int n2) {
        List<String> list = ExecutingCommand.runNative("ps -axwwo cwd -p " + n2);
        if (!list.isEmpty()) {
            return list.get(1);
        }
        return "";
    }

    public static long getOpenFiles(int n2) {
        long l2 = 0L;
        List<String> list = ExecutingCommand.runNative("fstat -sp " + n2);
        for (String string : list) {
            String[] stringArray = ParseUtil.whitespaces.split(string.trim(), 11);
            if (stringArray.length != 11 || "pipe".contains(stringArray[4]) || "unix".contains(stringArray[4])) continue;
            ++l2;
        }
        return l2 - 1L;
    }
}

