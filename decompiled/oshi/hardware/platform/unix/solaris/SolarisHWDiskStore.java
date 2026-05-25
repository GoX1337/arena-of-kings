/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.solaris;

import com.sun.jna.platform.unix.solaris.LibKstat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.solaris.disk.Iostat;
import oshi.driver.unix.solaris.disk.Lshal;
import oshi.driver.unix.solaris.disk.Prtvtoc;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.common.AbstractHWDiskStore;
import oshi.util.platform.unix.solaris.KstatUtil;
import oshi.util.tuples.Quintet;

@ThreadSafe
public final class SolarisHWDiskStore
extends AbstractHWDiskStore {
    private long reads = 0L;
    private long readBytes = 0L;
    private long writes = 0L;
    private long writeBytes = 0L;
    private long currentQueueLength = 0L;
    private long transferTime = 0L;
    private long timeStamp = 0L;
    private List<HWPartition> partitionList;

    private SolarisHWDiskStore(String string, String string2, String string3, long l2) {
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
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup(null, 0, this.getName());
            if (kstat != null && KstatUtil.KstatChain.read(kstat)) {
                LibKstat.KstatIO kstatIO = new LibKstat.KstatIO(kstat.ks_data);
                this.reads = kstatIO.reads;
                this.writes = kstatIO.writes;
                this.readBytes = kstatIO.nread;
                this.writeBytes = kstatIO.nwritten;
                this.currentQueueLength = (long)kstatIO.wcnt + (long)kstatIO.rcnt;
                this.transferTime = kstatIO.rtime / 1000000L;
                this.timeStamp = kstat.ks_snaptime / 1000000L;
                boolean bl2 = true;
                return bl2;
            }
        }
        return false;
    }

    public static List<HWDiskStore> getDisks() {
        Map<String, String> map = Iostat.queryPartitionToMountMap();
        Map<String, Integer> map2 = Lshal.queryDiskToMajorMap();
        Map<String, Quintet<String, String, String, String, Long>> map3 = Iostat.queryDeviceStrings(map.keySet());
        ArrayList<HWDiskStore> arrayList = new ArrayList<HWDiskStore>();
        for (Map.Entry<String, Quintet<String, String, String, String, Long>> entry : map3.entrySet()) {
            String string = entry.getKey();
            Quintet<String, String, String, String, Long> quintet = entry.getValue();
            arrayList.add(SolarisHWDiskStore.createStore(string, quintet.getA(), quintet.getB(), quintet.getC(), quintet.getD(), quintet.getE(), map.getOrDefault(string, ""), map2.getOrDefault(string, 0)));
        }
        return arrayList;
    }

    private static SolarisHWDiskStore createStore(String string, String string2, String string3, String string4, String string5, long l2, String string6, int n2) {
        SolarisHWDiskStore solarisHWDiskStore = new SolarisHWDiskStore(string, string2.isEmpty() ? (string3 + " " + string4).trim() : string2, string5, l2);
        solarisHWDiskStore.partitionList = Collections.unmodifiableList(Prtvtoc.queryPartitions(string6, n2).stream().sorted(Comparator.comparing(HWPartition::getName)).collect(Collectors.toList()));
        solarisHWDiskStore.updateAttributes();
        return solarisHWDiskStore;
    }
}

