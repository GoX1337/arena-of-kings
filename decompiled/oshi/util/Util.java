/*
 * Decompiled with CFR 0.152.
 */
package oshi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class Util {
    private static final Logger LOG = LoggerFactory.getLogger(Util.class);

    private Util() {
    }

    public static void sleep(long l2) {
        try {
            LOG.trace("Sleeping for {} ms", (Object)l2);
            Thread.sleep(l2);
        }
        catch (InterruptedException interruptedException) {
            LOG.warn("Interrupted while sleeping for {} ms: {}", (Object)l2, (Object)interruptedException.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public static boolean wildcardMatch(String string, String string2) {
        if (string2.length() > 0 && string2.charAt(0) == '^') {
            return !Util.wildcardMatch(string, string2.substring(1));
        }
        return string.matches(string2.replace("?", ".?").replace("*", ".*?"));
    }

    public static boolean isBlank(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isBlankOrUnknown(String string) {
        return Util.isBlank(string) || "unknown".equals(string);
    }
}

