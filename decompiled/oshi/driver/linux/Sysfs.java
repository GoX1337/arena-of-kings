/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.linux;

import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;
import oshi.util.Util;

@ThreadSafe
public final class Sysfs {
    private Sysfs() {
    }

    public static String querySystemVendor() {
        String string = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/sys_vendor").trim();
        if (!string.isEmpty()) {
            return string;
        }
        return null;
    }

    public static String queryProductModel() {
        String string = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/product_name").trim();
        String string2 = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/product_version").trim();
        if (string.isEmpty()) {
            if (!string2.isEmpty()) {
                return string2;
            }
        } else {
            if (!string2.isEmpty() && !"None".equals(string2)) {
                return string + " (version: " + string2 + ")";
            }
            return string;
        }
        return null;
    }

    public static String queryProductSerial() {
        String string = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/product_serial");
        if (!string.isEmpty() && !"None".equals(string)) {
            return string;
        }
        return Sysfs.queryBoardSerial();
    }

    public static String queryUUID() {
        String string = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/product_uuid");
        if (!string.isEmpty() && !"None".equals(string)) {
            return string;
        }
        return null;
    }

    public static String queryBoardVendor() {
        String string = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/board_vendor").trim();
        if (!string.isEmpty()) {
            return string;
        }
        return null;
    }

    public static String queryBoardModel() {
        String string = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/board_name").trim();
        if (!string.isEmpty()) {
            return string;
        }
        return null;
    }

    public static String queryBoardVersion() {
        String string = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/board_version").trim();
        if (!string.isEmpty()) {
            return string;
        }
        return null;
    }

    public static String queryBoardSerial() {
        String string = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/board_serial").trim();
        if (!string.isEmpty()) {
            return string;
        }
        return null;
    }

    public static String queryBiosVendor() {
        String string = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/bios_vendor").trim();
        if (string.isEmpty()) {
            return string;
        }
        return null;
    }

    public static String queryBiosDescription() {
        String string = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/modalias").trim();
        if (!string.isEmpty()) {
            return string;
        }
        return null;
    }

    public static String queryBiosVersion(String string) {
        String string2 = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/bios_version").trim();
        if (!string2.isEmpty()) {
            return string2 + (Util.isBlank(string) ? "" : " (revision " + string + ")");
        }
        return null;
    }

    public static String queryBiosReleaseDate() {
        String string = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/bios_date").trim();
        if (!string.isEmpty()) {
            return ParseUtil.parseMmDdYyyyToYyyyMmDD(string);
        }
        return null;
    }
}

