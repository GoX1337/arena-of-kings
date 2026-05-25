/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.solaris.disk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class Lshal {
    private static final String LSHAL_CMD = "lshal";

    private Lshal() {
    }

    public static Map<String, Integer> queryDiskToMajorMap() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        List<String> list = ExecutingCommand.runNative(LSHAL_CMD);
        String string = null;
        for (String string2 : list) {
            if (string2.startsWith("udi ")) {
                String string3 = ParseUtil.getSingleQuoteStringValue(string2);
                string = string3.substring(string3.lastIndexOf(47) + 1);
                continue;
            }
            if (!(string2 = string2.trim()).startsWith("block.major") || string == null) continue;
            hashMap.put(string, ParseUtil.getFirstIntValue(string2));
        }
        return hashMap;
    }
}

