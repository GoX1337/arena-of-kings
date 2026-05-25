/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.time;

import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.GmtTimeZone;

public class FastTimeZone {
    private static final Pattern GMT_PATTERN = Pattern.compile("^(?:(?i)GMT)?([+-])?(\\d\\d?)?(:?(\\d\\d?))?$");
    private static final TimeZone GREENWICH = new GmtTimeZone(false, 0, 0);

    public static TimeZone getGmtTimeZone() {
        return GREENWICH;
    }

    public static TimeZone getGmtTimeZone(String string) {
        if ("Z".equals(string) || "UTC".equals(string)) {
            return GREENWICH;
        }
        Matcher matcher = GMT_PATTERN.matcher(string);
        if (matcher.matches()) {
            int n2 = FastTimeZone.parseInt(matcher.group(2));
            int n3 = FastTimeZone.parseInt(matcher.group(4));
            if (n2 == 0 && n3 == 0) {
                return GREENWICH;
            }
            return new GmtTimeZone(FastTimeZone.parseSign(matcher.group(1)), n2, n3);
        }
        return null;
    }

    public static TimeZone getTimeZone(String string) {
        TimeZone timeZone = FastTimeZone.getGmtTimeZone(string);
        if (timeZone != null) {
            return timeZone;
        }
        return TimeZone.getTimeZone(string);
    }

    private static int parseInt(String string) {
        return string != null ? Integer.parseInt(string) : 0;
    }

    private static boolean parseSign(String string) {
        return string != null && string.charAt(0) == '-';
    }

    private FastTimeZone() {
    }
}

