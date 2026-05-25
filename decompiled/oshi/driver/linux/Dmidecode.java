/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.linux;

import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class Dmidecode {
    private Dmidecode() {
    }

    public static String querySerialNumber() {
        String string = "Serial Number:";
        for (String string2 : ExecutingCommand.runNative("dmidecode -t system")) {
            if (!string2.contains(string)) continue;
            return string2.split(string)[1].trim();
        }
        return null;
    }

    public static String queryUUID() {
        String string = "UUID:";
        for (String string2 : ExecutingCommand.runNative("dmidecode -t system")) {
            if (!string2.contains(string)) continue;
            return string2.split(string)[1].trim();
        }
        return null;
    }

    public static Pair<String, String> queryBiosNameRev() {
        String string = null;
        String string2 = null;
        String string3 = "SMBIOS";
        String string4 = "Bios Revision:";
        for (String string5 : ExecutingCommand.runNative("dmidecode -t bios")) {
            String[] stringArray;
            if (string5.contains("SMBIOS") && (stringArray = ParseUtil.whitespaces.split(string5)).length >= 2) {
                string = stringArray[0] + " " + stringArray[1];
            }
            if (!string5.contains("Bios Revision:")) continue;
            string2 = string5.split("Bios Revision:")[1].trim();
            break;
        }
        return new Pair<Object, Object>(string, string2);
    }
}

