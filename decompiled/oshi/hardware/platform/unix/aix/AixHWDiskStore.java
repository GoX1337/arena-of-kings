/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.aix;

import com.sun.jna.Native;
import com.sun.jna.platform.unix.aix.Perfstat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.aix.Ls;
import oshi.driver.unix.aix.Lscfg;
import oshi.driver.unix.aix.Lspv;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.common.AbstractHWDiskStore;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class AixHWDiskStore
extends AbstractHWDiskStore {
    private final Supplier<Perfstat.perfstat_disk_t[]> diskStats;
    private long reads = 0L;
    private long readBytes = 0L;
    private long writes = 0L;
    private long writeBytes = 0L;
    private long currentQueueLength = 0L;
    private long transferTime = 0L;
    private long timeStamp = 0L;
    private List<HWPartition> partitionList;

    private AixHWDiskStore(String string, String string2, String string3, long l2, Supplier<Perfstat.perfstat_disk_t[]> supplier) {
        super(string, string2, string3, l2);
        this.diskStats = supplier;
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
        for (Perfstat.perfstat_disk_t perfstat_disk_t2 : this.diskStats.get()) {
            String string = Native.toString(perfstat_disk_t2.name);
            if (!string.equals(this.getName())) continue;
            long l2 = perfstat_disk_t2.rblks + perfstat_disk_t2.wblks;
            this.reads = perfstat_disk_t2.xfers;
            if (l2 > 0L) {
                this.writes = perfstat_disk_t2.xfers * perfstat_disk_t2.wblks / l2;
                this.reads -= this.writes;
            }
            this.readBytes = perfstat_disk_t2.rblks * perfstat_disk_t2.bsize;
            this.writeBytes = perfstat_disk_t2.wblks * perfstat_disk_t2.bsize;
            this.currentQueueLength = perfstat_disk_t2.qdepth;
            this.transferTime = perfstat_disk_t2.time;
            return true;
        }
        return false;
    }

    public static List<HWDiskStore> getDisks(Supplier<Perfstat.perfstat_disk_t[]> supplier) {
        Map<String, Pair<Integer, Integer>> map = Ls.queryDeviceMajorMinor();
        ArrayList<AixHWDiskStore> arrayList = new ArrayList<AixHWDiskStore>();
        for (Perfstat.perfstat_disk_t perfstat_disk_t2 : supplier.get()) {
            String string = Native.toString(perfstat_disk_t2.name);
            Pair<String, String> pair = Lscfg.queryModelSerial(string);
            String string2 = pair.getA() == null ? Native.toString(perfstat_disk_t2.description) : pair.getA();
            String string3 = pair.getB() == null ? "unknown" : pair.getB();
            arrayList.add(AixHWDiskStore.createStore(string, string2, string3, perfstat_disk_t2.size << 20, supplier, map));
        }
        return arrayList.stream().sorted(Comparator.comparingInt(aixHWDiskStore -> aixHWDiskStore.getPartitions().isEmpty() ? Integer.MAX_VALUE : aixHWDiskStore.getPartitions().get(0).getMajor())).collect(Collectors.toList());
    }

    private static AixHWDiskStore createStore(String string, String string2, String string3, long l2, Supplier<Perfstat.perfstat_disk_t[]> supplier, Map<String, Pair<Integer, Integer>> map) {
        AixHWDiskStore aixHWDiskStore = new AixHWDiskStore(string, string2.isEmpty() ? "unknown" : string2, string3, l2, supplier);
        aixHWDiskStore.partitionList = Collections.unmodifiableList(Lspv.queryLogicalVolumes(string, map).stream().sorted(Comparator.comparing(HWPartition::getMinor).thenComparing(HWPartition::getName)).collect(Collectors.toList()));
        aixHWDiskStore.updateAttributes();
        return aixHWDiskStore;
    }
}

