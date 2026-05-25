/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.linux.proc;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.linux.ProcPath;

@ThreadSafe
public final class DiskStats {
    private DiskStats() {
    }

    public static Map<String, Map<IoStat, Long>> getDiskStats() {
        HashMap<String, Map<IoStat, Long>> hashMap = new HashMap<String, Map<IoStat, Long>>();
        IoStat[] ioStatArray = (IoStat[])IoStat.class.getEnumConstants();
        List<String> list = FileUtil.readFile(ProcPath.DISKSTATS);
        for (String string : list) {
            String[] stringArray = ParseUtil.whitespaces.split(string.trim());
            EnumMap<IoStat, Long> enumMap = new EnumMap<IoStat, Long>(IoStat.class);
            String string2 = null;
            for (int i2 = 0; i2 < ioStatArray.length && i2 < stringArray.length; ++i2) {
                if (ioStatArray[i2] == IoStat.NAME) {
                    string2 = stringArray[i2];
                    continue;
                }
                enumMap.put(ioStatArray[i2], ParseUtil.parseLongOrDefault(stringArray[i2], 0L));
            }
            if (string2 == null) continue;
            hashMap.put(string2, enumMap);
        }
        return hashMap;
    }

    public static enum IoStat {
        MAJOR,
        MINOR,
        NAME,
        READS,
        READS_MERGED,
        READS_SECTOR,
        READS_MS,
        WRITES,
        WRITES_MERGED,
        WRITES_SECTOR,
        WRITES_MS,
        IO_QUEUE_LENGTH,
        IO_MS,
        IO_MS_WEIGHTED,
        DISCARDS,
        DISCARDS_MERGED,
        DISCARDS_SECTOR,
        DISCARDS_MS,
        FLUSHES,
        FLUSHES_MS;

    }
}

