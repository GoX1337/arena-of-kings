/*
 * Decompiled with CFR 0.152.
 */
package oshi.util;

import java.util.Map;
import java.util.Properties;
import oshi.annotation.concurrent.NotThreadSafe;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;

@NotThreadSafe
public final class GlobalConfig {
    private static final String OSHI_PROPERTIES = "oshi.properties";
    private static final Properties CONFIG = FileUtil.readPropertiesFromFilename("oshi.properties");

    private GlobalConfig() {
    }

    public static String get(String string, String string2) {
        return CONFIG.getProperty(string, string2);
    }

    public static int get(String string, int n2) {
        String string2 = CONFIG.getProperty(string);
        return string2 == null ? n2 : ParseUtil.parseIntOrDefault(string2, n2);
    }

    public static double get(String string, double d2) {
        String string2 = CONFIG.getProperty(string);
        return string2 == null ? d2 : ParseUtil.parseDoubleOrDefault(string2, d2);
    }

    public static boolean get(String string, boolean bl2) {
        String string2 = CONFIG.getProperty(string);
        return string2 == null ? bl2 : Boolean.parseBoolean(string2);
    }

    public static void set(String string, Object object) {
        if (object == null) {
            CONFIG.remove(string);
        } else {
            CONFIG.setProperty(string, object.toString());
        }
    }

    public static void remove(String string) {
        CONFIG.remove(string);
    }

    public static void clear() {
        CONFIG.clear();
    }

    public static void load(Properties properties) {
        CONFIG.putAll((Map<?, ?>)properties);
    }

    public static class PropertyException
    extends RuntimeException {
        private static final long serialVersionUID = -7482581936621748005L;

        public PropertyException(String string) {
            super("Invalid property: \"" + string + "\" = " + GlobalConfig.get(string, null));
        }

        public PropertyException(String string, String string2) {
            super("Invalid property \"" + string + "\": " + string2);
        }
    }
}

