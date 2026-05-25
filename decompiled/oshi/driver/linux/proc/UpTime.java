/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.linux.proc;

import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.FileUtil;
import oshi.util.platform.linux.ProcPath;

@ThreadSafe
public final class UpTime {
    private UpTime() {
    }

    public static double getSystemUptimeSeconds() {
        String string = FileUtil.getStringFromFile(ProcPath.UPTIME);
        int n2 = string.indexOf(32);
        try {
            if (n2 < 0) {
                return 0.0;
            }
            return Double.parseDouble(string.substring(0, n2));
        }
        catch (NumberFormatException numberFormatException) {
            return 0.0;
        }
    }
}

