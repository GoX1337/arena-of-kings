/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.linux.proc;

import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.linux.ProcPath;
import oshi.util.tuples.Quartet;

@ThreadSafe
public final class CpuInfo {
    private CpuInfo() {
    }

    public static String queryCpuManufacturer() {
        List<String> list = FileUtil.readFile(ProcPath.CPUINFO);
        for (String string : list) {
            if (!string.startsWith("CPU implementer")) continue;
            int n2 = ParseUtil.parseLastInt(string, 0);
            switch (n2) {
                case 65: {
                    return "ARM";
                }
                case 66: {
                    return "Broadcom";
                }
                case 67: {
                    return "Cavium";
                }
                case 68: {
                    return "DEC";
                }
                case 78: {
                    return "Nvidia";
                }
                case 80: {
                    return "APM";
                }
                case 81: {
                    return "Qualcomm";
                }
                case 83: {
                    return "Samsung";
                }
                case 86: {
                    return "Marvell";
                }
                case 102: {
                    return "Faraday";
                }
                case 105: {
                    return "Intel";
                }
            }
            return null;
        }
        return null;
    }

    public static Quartet<String, String, String, String> queryBoardInfo() {
        String string = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        List<String> list = FileUtil.readFile(ProcPath.CPUINFO);
        for (String string5 : list) {
            String[] stringArray = ParseUtil.whitespacesColonWhitespace.split(string5);
            if (stringArray.length < 2) continue;
            switch (stringArray[0]) {
                case "Hardware": {
                    string2 = stringArray[1];
                    break;
                }
                case "Revision": {
                    string3 = stringArray[1];
                    if (string3.length() <= 1) break;
                    string = CpuInfo.queryBoardManufacturer(string3.charAt(1));
                    break;
                }
                case "Serial": {
                    string4 = stringArray[1];
                    break;
                }
            }
        }
        return new Quartet<Object, Object, Object, Object>(string, string2, string3, string4);
    }

    private static String queryBoardManufacturer(char c2) {
        switch (c2) {
            case '0': {
                return "Sony UK";
            }
            case '1': {
                return "Egoman";
            }
            case '2': {
                return "Embest";
            }
            case '3': {
                return "Sony Japan";
            }
            case '4': {
                return "Embest";
            }
            case '5': {
                return "Stadium";
            }
        }
        return "unknown";
    }
}

