/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.linux.proc;

import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.CentralProcessor;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.linux.ProcPath;

@ThreadSafe
public final class CpuStat {
    private CpuStat() {
    }

    public static long[] getSystemCpuLoadTicks() {
        long[] lArray = new long[CentralProcessor.TickType.values().length];
        List<String> list = FileUtil.readFile(ProcPath.STAT);
        if (list.isEmpty()) {
            return lArray;
        }
        String string = list.get(0);
        String[] stringArray = ParseUtil.whitespaces.split(string);
        if (stringArray.length <= CentralProcessor.TickType.IDLE.getIndex()) {
            return lArray;
        }
        for (int i2 = 0; i2 < CentralProcessor.TickType.values().length; ++i2) {
            lArray[i2] = ParseUtil.parseLongOrDefault(stringArray[i2 + 1], 0L);
        }
        return lArray;
    }

    public static long[][] getProcessorCpuLoadTicks(int n2) {
        long[][] lArray = new long[n2][CentralProcessor.TickType.values().length];
        int n3 = 0;
        List<String> list = FileUtil.readFile(ProcPath.STAT);
        for (String string : list) {
            if (!string.startsWith("cpu") || string.startsWith("cpu ")) continue;
            String[] stringArray = ParseUtil.whitespaces.split(string);
            if (stringArray.length <= CentralProcessor.TickType.IDLE.getIndex()) {
                return lArray;
            }
            for (int i2 = 0; i2 < CentralProcessor.TickType.values().length; ++i2) {
                lArray[n3][i2] = ParseUtil.parseLongOrDefault(stringArray[i2 + 1], 0L);
            }
            if (++n3 < n2) continue;
            break;
        }
        return lArray;
    }

    public static long getContextSwitches() {
        List<String> list = FileUtil.readFile(ProcPath.STAT);
        for (String string : list) {
            String[] stringArray;
            if (!string.startsWith("ctxt ") || (stringArray = ParseUtil.whitespaces.split(string)).length != 2) continue;
            return ParseUtil.parseLongOrDefault(stringArray[1], 0L);
        }
        return 0L;
    }

    public static long getInterrupts() {
        List<String> list = FileUtil.readFile(ProcPath.STAT);
        for (String string : list) {
            String[] stringArray;
            if (!string.startsWith("intr ") || (stringArray = ParseUtil.whitespaces.split(string)).length <= 2) continue;
            return ParseUtil.parseLongOrDefault(stringArray[1], 0L);
        }
        return 0L;
    }

    public static long getBootTime() {
        List<String> list = FileUtil.readFile(ProcPath.STAT);
        for (String string : list) {
            if (!string.startsWith("btime")) continue;
            String[] stringArray = ParseUtil.whitespaces.split(string);
            return ParseUtil.parseLongOrDefault(stringArray[1], 0L);
        }
        return 0L;
    }
}

