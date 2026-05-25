/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.linux;

import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class Lshal {
    private Lshal() {
    }

    public static String querySerialNumber() {
        String string = "system.hardware.serial =";
        for (String string2 : ExecutingCommand.runNative("lshal")) {
            if (!string2.contains(string)) continue;
            return ParseUtil.getSingleQuoteStringValue(string2);
        }
        return null;
    }

    public static String queryUUID() {
        String string = "system.hardware.uuid =";
        for (String string2 : ExecutingCommand.runNative("lshal")) {
            if (!string2.contains(string)) continue;
            return ParseUtil.getSingleQuoteStringValue(string2);
        }
        return null;
    }
}

