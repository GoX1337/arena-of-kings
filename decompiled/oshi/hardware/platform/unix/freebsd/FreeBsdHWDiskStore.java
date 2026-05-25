/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.freebsd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.freebsd.disk.GeomDiskList;
import oshi.driver.unix.freebsd.disk.GeomPartList;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.common.AbstractHWDiskStore;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.freebsd.BsdSysctlUtil;
import oshi.util.tuples.Triplet;

@ThreadSafe
public final class FreeBsdHWDiskStore
extends AbstractHWDiskStore {
    private long reads = 0L;
    private long readBytes = 0L;
    private long writes = 0L;
    private long writeBytes = 0L;
    private long currentQueueLength = 0L;
    private long transferTime = 0L;
    private long timeStamp = 0L;
    private List<HWPartition> partitionList;

    private FreeBsdHWDiskStore(String string, String string2, String string3, long l2) {
        super(string, string2, string3, l2);
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
        List<String> list = ExecutingCommand.runNative("iostat -Ix " + this.getName());
        long l2 = System.currentTimeMillis();
        boolean bl2 = false;
        for (String string : list) {
            String[] stringArray = ParseUtil.whitespaces.split(string);
            if (stringArray.length < 7 || !stringArray[0].equals(this.getName())) continue;
            bl2 = true;
            this.reads = (long)ParseUtil.parseDoubleOrDefault(stringArray[1], 0.0);
            this.writes = (long)ParseUtil.parseDoubleOrDefault(stringArray[2], 0.0);
            this.readBytes = (long)(ParseUtil.parseDoubleOrDefault(stringArray[3], 0.0) * 1024.0);
            this.writeBytes = (long)(ParseUtil.parseDoubleOrDefault(stringArray[4], 0.0) * 1024.0);
            this.currentQueueLength = ParseUtil.parseLongOrDefault(stringArray[5], 0L);
            this.transferTime = (long)(ParseUtil.parseDoubleOrDefault(stringArray[6], 0.0) * 1000.0);
            this.timeStamp = l2;
        }
        return bl2;
    }

    public static List<HWDiskStore> getDisks() {
        ArrayList<HWDiskStore> arrayList = new ArrayList<HWDiskStore>();
        Map<String, List<HWPartition>> map = GeomPartList.queryPartitions();
        Map<String, Triplet<String, String, Long>> map2 = GeomDiskList.queryDisks();
        List<String> list = Arrays.asList(ParseUtil.whitespaces.split(BsdSysctlUtil.sysctl("kern.disks", "")));
        List<String> list2 = ExecutingCommand.runNative("iostat -Ix");
        long l2 = System.currentTimeMillis();
        for (String string : list2) {
            String[] stringArray = ParseUtil.whitespaces.split(string);
            if (stringArray.length <= 6 || !list.contains(stringArray[0])) continue;
            Triplet<String, String, Long> triplet = map2.get(stringArray[0]);
            FreeBsdHWDiskStore freeBsdHWDiskStore = triplet == null ? new FreeBsdHWDiskStore(stringArray[0], "unknown", "unknown", 0L) : new FreeBsdHWDiskStore(stringArray[0], triplet.getA(), triplet.getB(), triplet.getC());
            freeBsdHWDiskStore.reads = (long)ParseUtil.parseDoubleOrDefault(stringArray[1], 0.0);
            freeBsdHWDiskStore.writes = (long)ParseUtil.parseDoubleOrDefault(stringArray[2], 0.0);
            freeBsdHWDiskStore.readBytes = (long)(ParseUtil.parseDoubleOrDefault(stringArray[3], 0.0) * 1024.0);
            freeBsdHWDiskStore.writeBytes = (long)(ParseUtil.parseDoubleOrDefault(stringArray[4], 0.0) * 1024.0);
            freeBsdHWDiskStore.currentQueueLength = ParseUtil.parseLongOrDefault(stringArray[5], 0L);
            freeBsdHWDiskStore.transferTime = (long)(ParseUtil.parseDoubleOrDefault(stringArray[6], 0.0) * 1000.0);
            freeBsdHWDiskStore.partitionList = Collections.unmodifiableList(map.getOrDefault(stringArray[0], Collections.emptyList()).stream().sorted(Comparator.comparing(HWPartition::getName)).collect(Collectors.toList()));
            freeBsdHWDiskStore.timeStamp = l2;
            arrayList.add(freeBsdHWDiskStore);
        }
        return arrayList;
    }
}

