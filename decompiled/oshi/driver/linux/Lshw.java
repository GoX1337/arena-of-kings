/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.linux;

import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class Lshw {
    private Lshw() {
    }

    public static String queryModel() {
        String string = "product:";
        for (String string2 : ExecutingCommand.runNative("lshw -C system")) {
            if (!string2.contains(string)) continue;
            return string2.split(string)[1].trim();
        }
        return null;
    }

    public static String querySerialNumber() {
        String string = "serial:";
        for (String string2 : ExecutingCommand.runNative("lshw -C system")) {
            if (!string2.contains(string)) continue;
            return string2.split(string)[1].trim();
        }
        return null;
    }

    public static String queryUUID() {
        String string = "uuid:";
        for (String string2 : ExecutingCommand.runNative("lshw -C system")) {
            if (!string2.contains(string)) continue;
            return string2.split(string)[1].trim();
        }
        return null;
    }

    public static long queryCpuCapacity() {
        String string = "capacity:";
        for (String string2 : ExecutingCommand.runNative("lshw -class processor")) {
            if (!string2.contains(string)) continue;
            return ParseUtil.parseHertz(string2.split(string)[1].trim());
        }
        return -1L;
    }
}

