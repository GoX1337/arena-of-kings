/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.perfmon;

import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.PerfCounterWildcardQuery;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class PhysicalDisk {
    private static final String PHYSICAL_DISK = "PhysicalDisk";
    private static final String WIN32_PERF_RAW_DATA_PERF_DISK_PHYSICAL_DISK_WHERE_NAME_NOT_TOTAL = "Win32_PerfRawData_PerfDisk_PhysicalDisk WHERE Name!=\"_Total\"";

    private PhysicalDisk() {
    }

    public static Pair<List<String>, Map<PhysicalDiskProperty, List<Long>>> queryDiskCounters() {
        return PerfCounterWildcardQuery.queryInstancesAndValues(PhysicalDiskProperty.class, PHYSICAL_DISK, WIN32_PERF_RAW_DATA_PERF_DISK_PHYSICAL_DISK_WHERE_NAME_NOT_TOTAL);
    }

    public static enum PhysicalDiskProperty implements PerfCounterWildcardQuery.PdhCounterWildcardProperty
    {
        NAME("^_Total"),
        DISKREADSPERSEC("Disk Reads/sec"),
        DISKREADBYTESPERSEC("Disk Read Bytes/sec"),
        DISKWRITESPERSEC("Disk Writes/sec"),
        DISKWRITEBYTESPERSEC("Disk Write Bytes/sec"),
        CURRENTDISKQUEUELENGTH("Current Disk Queue Length"),
        PERCENTDISKTIME("% Disk Time");

        private final String counter;

        private PhysicalDiskProperty(String string2) {
            this.counter = string2;
        }

        @Override
        public String getCounter() {
            return this.counter;
        }
    }
}

