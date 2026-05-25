/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.openbsd;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.openbsd.disk.Disklabel;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.common.AbstractHWDiskStore;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.openbsd.OpenBsdSysctlUtil;
import oshi.util.tuples.Quartet;

@ThreadSafe
public final class OpenBsdHWDiskStore
extends AbstractHWDiskStore {
    private final Supplier<List<String>> iostat = Memoizer.memoize(OpenBsdHWDiskStore::querySystatIostat, Memoizer.defaultExpiration());
    private long reads = 0L;
    private long readBytes = 0L;
    private long writes = 0L;
    private long writeBytes = 0L;
    private long currentQueueLength = 0L;
    private long transferTime = 0L;
    private long timeStamp = 0L;
    private List<HWPartition> partitionList;

    private OpenBsdHWDiskStore(String string, String string2, String string3, long l2) {
        super(string, string2, string3, l2);
    }

    public static List<HWDiskStore> getDisks() {
        String[] stringArray;
        ArrayList<HWDiskStore> arrayList = new ArrayList<HWDiskStore>();
        List<String> list = null;
        for (String string : stringArray = OpenBsdSysctlUtil.sysctl("hw.disknames", "").split(",")) {
            String string2 = string.split(":")[0];
            Quartet<String, String, Long, List<HWPartition>> quartet = Disklabel.getDiskParams(string2);
            String string3 = quartet.getA();
            long l2 = quartet.getC();
            if (l2 <= 1L) {
                if (list == null) {
                    list = ExecutingCommand.runNative("dmesg");
                }
                Pattern pattern = Pattern.compile(string2 + " at .*<(.+)>.*");
                Pattern pattern2 = Pattern.compile(string2 + ":.* (\\d+)MB, (?:(\\d+) bytes\\/sector, )?(?:(\\d+) sectors).*");
                for (String string4 : list) {
                    Matcher matcher = pattern.matcher(string4);
                    if (matcher.matches()) {
                        string3 = matcher.group(1);
                    }
                    if (!(matcher = pattern2.matcher(string4)).matches()) continue;
                    long l3 = ParseUtil.parseLongOrDefault(matcher.group(3), 0L);
                    long l4 = ParseUtil.parseLongOrDefault(matcher.group(2), 0L);
                    if (l4 == 0L && l3 > 0L) {
                        l2 = ParseUtil.parseLongOrDefault(matcher.group(1), 0L) << 20;
                        l4 = l2 / l3;
                        l4 = Long.highestOneBit(l4 + l4 >> 1);
                    }
                    l2 = l4 * l3;
                    break;
                }
            }
            OpenBsdHWDiskStore openBsdHWDiskStore = new OpenBsdHWDiskStore(string2, string3, quartet.getB(), l2);
            openBsdHWDiskStore.partitionList = quartet.getD();
            openBsdHWDiskStore.updateAttributes();
            arrayList.add(openBsdHWDiskStore);
        }
        return arrayList;
    }

    @Override
    public long getReads() {
        return this.reads;
    }

    @Override
    public long getReadBytes() {
        return this.readBytes;
    }

    @Override
    public long getWrites() {
        return this.writes;
    }

    @Override
    public long getWriteBytes() {
        return this.writeBytes;
    }

    @Override
    public long getCurrentQueueLength() {
        return this.currentQueueLength;
    }

    @Override
    public long getTransferTime() {
        return this.transferTime;
    }

    @Override
    public long getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public List<HWPartition> getPartitions() {
        return this.partitionList;
    }

    @Override
    public boolean updateAttributes() {
        long l2 = System.currentTimeMillis();
        boolean bl2 = false;
        for (String string : this.iostat.get()) {
            String[] stringArray = ParseUtil.whitespaces.split(string);
            if (stringArray.length >= 7 || !stringArray[0].equals(this.getName())) continue;
            bl2 = true;
            this.readBytes = ParseUtil.parseMultipliedToLongs(stringArray[1]);
            this.writeBytes = ParseUtil.parseMultipliedToLongs(stringArray[2]);
            this.reads = (long)ParseUtil.parseDoubleOrDefault(stringArray[3], 0.0);
            this.writes = (long)ParseUtil.parseDoubleOrDefault(stringArray[4], 0.0);
            this.transferTime = (long)(ParseUtil.parseDoubleOrDefault(stringArray[5], 0.0) * 1000.0);
            this.timeStamp = l2;
        }
        return bl2;
    }

    private static List<String> querySystatIostat() {
        return ExecutingCommand.runNative("systat -ab iostat");
    }
}

