/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class Uptime {
    private static final long MINUTE_MS = 60000L;
    private static final long HOUR_MS = 3600000L;
    private static final long DAY_MS = 86400000L;
    private static final Pattern UPTIME_FORMAT_AIX = Pattern.compile(".*\\sup\\s+((\\d+)\\s+days?,?\\s+)?\\b((\\d+):)?(\\d+)(\\s+min(utes?)?)?,\\s+\\d+\\s+user.+");

    private Uptime() {
    }

    public static long queryUpTime() {
        long l2 = 0L;
        String string = ExecutingCommand.getFirstAnswer("/usr/bin/uptime");
        Matcher matcher = UPTIME_FORMAT_AIX.matcher(string);
        if (matcher.matches()) {
            if (matcher.group(2) != null) {
                l2 += ParseUtil.parseLongOrDefault(matcher.group(2), 0L) * 86400000L;
            }
            if (matcher.group(4) != null) {
                l2 += ParseUtil.parseLongOrDefault(matcher.group(4), 0L) * 3600000L;
            }
            l2 += ParseUtil.parseLongOrDefault(matcher.group(5), 0L) * 60000L;
        }
        return l2;
    }
}

