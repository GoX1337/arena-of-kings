/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.windows;

import com.sun.jna.platform.win32.COM.COMException;
import com.sun.jna.platform.win32.COM.WbemcliUtil;
import com.sun.jna.platform.win32.Kernel32;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.windows.perfmon.PhysicalDisk;
import oshi.driver.windows.wmi.Win32DiskDrive;
import oshi.driver.windows.wmi.Win32DiskDriveToDiskPartition;
import oshi.driver.windows.wmi.Win32DiskPartition;
import oshi.driver.windows.wmi.Win32LogicalDiskToPartition;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.common.AbstractHWDiskStore;
import oshi.util.ParseUtil;
import oshi.util.platform.windows.WmiQueryHandler;
import oshi.util.platform.windows.WmiUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class WindowsHWDiskStore
extends AbstractHWDiskStore {
    private static final Logger LOG = LoggerFactory.getLogger(WindowsHWDiskStore.class);
    private static final String PHYSICALDRIVE_PREFIX = "\\\\.\\PHYSICALDRIVE";
    private static final Pattern DEVICE_ID = Pattern.compile(".*\\.DeviceID=\"(.*)\"");
    private static final int GUID_BUFSIZE = 100;
    private long reads = 0L;
    private long readBytes = 0L;
    private long writes = 0L;
    private long writeBytes = 0L;
    private long currentQueueLength = 0L;
    private long transferTime = 0L;
    private long timeStamp = 0L;
    private List<HWPartition> partitionList;

    private WindowsHWDiskStore(String string, String string2, String string3, long l2) {
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
        String string = null;
        List<HWPartition> list = this.getPartitions();
        if (!list.isEmpty()) {
            string = Integer.toString(list.get(0).getMajor());
        } else if (this.getName().startsWith(PHYSICALDRIVE_PREFIX)) {
            string = this.getName().substring(PHYSICALDRIVE_PREFIX.length(), this.getName().length());
        } else {
            LOG.warn("Couldn't match index for {}", (Object)this.getName());
            return false;
        }
        DiskStats diskStats = WindowsHWDiskStore.queryReadWriteStats(string);
        if (diskStats.readMap.containsKey(string)) {
            this.reads = diskStats.readMap.getOrDefault(string, 0L);
            this.readBytes = diskStats.readByteMap.getOrDefault(string, 0L);
            this.writes = diskStats.writeMap.getOrDefault(string, 0L);
            this.writeBytes = diskStats.writeByteMap.getOrDefault(string, 0L);
            this.currentQueueLength = diskStats.queueLengthMap.getOrDefault(string, 0L);
            this.transferTime = diskStats.diskTimeMap.getOrDefault(string, 0L);
            this.timeStamp = diskStats.timeStamp;
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static List<HWDiskStore> getDisks() {
        WmiQueryHandler wmiQueryHandler = Objects.requireNonNull(WmiQueryHandler.createInstance());
        boolean bl2 = false;
        try {
            bl2 = wmiQueryHandler.initCOM();
            ArrayList<HWDiskStore> arrayList = new ArrayList<HWDiskStore>();
            DiskStats diskStats = WindowsHWDiskStore.queryReadWriteStats(null);
            PartitionMaps partitionMaps = WindowsHWDiskStore.queryPartitionMaps(wmiQueryHandler);
            WbemcliUtil.WmiResult<Win32DiskDrive.DiskDriveProperty> wmiResult = Win32DiskDrive.queryDiskDrive(wmiQueryHandler);
            for (int i2 = 0; i2 < wmiResult.getResultCount(); ++i2) {
                WindowsHWDiskStore windowsHWDiskStore = new WindowsHWDiskStore(WmiUtil.getString(wmiResult, Win32DiskDrive.DiskDriveProperty.NAME, i2), String.format("%s %s", WmiUtil.getString(wmiResult, Win32DiskDrive.DiskDriveProperty.MODEL, i2), WmiUtil.getString(wmiResult, Win32DiskDrive.DiskDriveProperty.MANUFACTURER, i2)).trim(), ParseUtil.hexStringToString(WmiUtil.getString(wmiResult, Win32DiskDrive.DiskDriveProperty.SERIALNUMBER, i2)), WmiUtil.getUint64(wmiResult, Win32DiskDrive.DiskDriveProperty.SIZE, i2));
                String string = Integer.toString(WmiUtil.getUint32(wmiResult, Win32DiskDrive.DiskDriveProperty.INDEX, i2));
                windowsHWDiskStore.reads = diskStats.readMap.getOrDefault(string, 0L);
                windowsHWDiskStore.readBytes = diskStats.readByteMap.getOrDefault(string, 0L);
                windowsHWDiskStore.writes = diskStats.writeMap.getOrDefault(string, 0L);
                windowsHWDiskStore.writeBytes = diskStats.writeByteMap.getOrDefault(string, 0L);
                windowsHWDiskStore.currentQueueLength = diskStats.queueLengthMap.getOrDefault(string, 0L);
                windowsHWDiskStore.transferTime = diskStats.diskTimeMap.getOrDefault(string, 0L);
                windowsHWDiskStore.timeStamp = diskStats.timeStamp;
                ArrayList arrayList2 = new ArrayList();
                List list = (List)partitionMaps.driveToPartitionMap.get(windowsHWDiskStore.getName());
                if (list != null && !list.isEmpty()) {
                    for (String string2 : list) {
                        if (!partitionMaps.partitionMap.containsKey(string2)) continue;
                        arrayList2.addAll((Collection)partitionMaps.partitionMap.get(string2));
                    }
                }
                windowsHWDiskStore.partitionList = Collections.unmodifiableList(arrayList2.stream().sorted(Comparator.comparing(HWPartition::getName)).collect(Collectors.toList()));
                arrayList.add(windowsHWDiskStore);
            }
            ArrayList<HWDiskStore> arrayList3 = arrayList;
            return arrayList3;
        }
        catch (COMException cOMException) {
            LOG.warn("COM exception: {}", (Object)cOMException.getMessage());
            List<HWDiskStore> list = Collections.emptyList();
            return list;
        }
        finally {
            if (bl2) {
                wmiQueryHandler.unInitCOM();
            }
        }
    }

    private static DiskStats queryReadWriteStats(String string) {
        DiskStats diskStats = new DiskStats();
        Pair<List<String>, Map<PhysicalDisk.PhysicalDiskProperty, List<Long>>> pair = PhysicalDisk.queryDiskCounters();
        List<String> list = pair.getA();
        Map<PhysicalDisk.PhysicalDiskProperty, List<Long>> map = pair.getB();
        diskStats.timeStamp = System.currentTimeMillis();
        List<Long> list2 = map.get(PhysicalDisk.PhysicalDiskProperty.DISKREADSPERSEC);
        List<Long> list3 = map.get(PhysicalDisk.PhysicalDiskProperty.DISKREADBYTESPERSEC);
        List<Long> list4 = map.get(PhysicalDisk.PhysicalDiskProperty.DISKWRITESPERSEC);
        List<Long> list5 = map.get(PhysicalDisk.PhysicalDiskProperty.DISKWRITEBYTESPERSEC);
        List<Long> list6 = map.get(PhysicalDisk.PhysicalDiskProperty.CURRENTDISKQUEUELENGTH);
        List<Long> list7 = map.get(PhysicalDisk.PhysicalDiskProperty.PERCENTDISKTIME);
        if (list.isEmpty() || list2 == null || list3 == null || list4 == null || list5 == null || list6 == null || list7 == null) {
            return diskStats;
        }
        for (int i2 = 0; i2 < list.size(); ++i2) {
            String string2 = WindowsHWDiskStore.getIndexFromName(list.get(i2));
            if (string != null && !string.equals(string2)) continue;
            diskStats.readMap.put(string2, list2.get(i2));
            diskStats.readByteMap.put(string2, list3.get(i2));
            diskStats.writeMap.put(string2, list4.get(i2));
            diskStats.writeByteMap.put(string2, list5.get(i2));
            diskStats.queueLengthMap.put(string2, list6.get(i2));
            diskStats.diskTimeMap.put(string2, list7.get(i2) / 10000L);
        }
        return diskStats;
    }

    private static PartitionMaps queryPartitionMaps(WmiQueryHandler wmiQueryHandler) {
        ArrayList<Pair<String, Long>> arrayList;
        Matcher matcher;
        Matcher matcher2;
        PartitionMaps partitionMaps = new PartitionMaps();
        WbemcliUtil.WmiResult<Win32DiskDriveToDiskPartition.DriveToPartitionProperty> wmiResult = Win32DiskDriveToDiskPartition.queryDriveToPartition(wmiQueryHandler);
        for (int i2 = 0; i2 < wmiResult.getResultCount(); ++i2) {
            matcher2 = DEVICE_ID.matcher(WmiUtil.getRefString(wmiResult, Win32DiskDriveToDiskPartition.DriveToPartitionProperty.ANTECEDENT, i2));
            matcher = DEVICE_ID.matcher(WmiUtil.getRefString(wmiResult, Win32DiskDriveToDiskPartition.DriveToPartitionProperty.DEPENDENT, i2));
            if (!matcher2.matches() || !matcher.matches()) continue;
            partitionMaps.driveToPartitionMap.computeIfAbsent(matcher2.group(1).replace("\\\\", "\\"), string -> new ArrayList()).add(matcher.group(1));
        }
        WbemcliUtil.WmiResult<Win32LogicalDiskToPartition.DiskToPartitionProperty> wmiResult2 = Win32LogicalDiskToPartition.queryDiskToPartition(wmiQueryHandler);
        for (int i3 = 0; i3 < wmiResult2.getResultCount(); ++i3) {
            matcher2 = DEVICE_ID.matcher(WmiUtil.getRefString(wmiResult2, Win32LogicalDiskToPartition.DiskToPartitionProperty.ANTECEDENT, i3));
            matcher = DEVICE_ID.matcher(WmiUtil.getRefString(wmiResult2, Win32LogicalDiskToPartition.DiskToPartitionProperty.DEPENDENT, i3));
            long l2 = WmiUtil.getUint64(wmiResult2, Win32LogicalDiskToPartition.DiskToPartitionProperty.ENDINGADDRESS, i3) - WmiUtil.getUint64(wmiResult2, Win32LogicalDiskToPartition.DiskToPartitionProperty.STARTINGADDRESS, i3) + 1L;
            if (!matcher2.matches() || !matcher.matches()) continue;
            if (partitionMaps.partitionToLogicalDriveMap.containsKey(matcher2.group(1))) {
                ((List)partitionMaps.partitionToLogicalDriveMap.get(matcher2.group(1))).add(new Pair<String, Long>(matcher.group(1) + "\\", l2));
                continue;
            }
            arrayList = new ArrayList<Pair<String, Long>>();
            arrayList.add(new Pair<String, Long>(matcher.group(1) + "\\", l2));
            partitionMaps.partitionToLogicalDriveMap.put(matcher2.group(1), arrayList);
        }
        WbemcliUtil.WmiResult<Win32DiskPartition.DiskPartitionProperty> wmiResult3 = Win32DiskPartition.queryPartition(wmiQueryHandler);
        for (int i4 = 0; i4 < wmiResult3.getResultCount(); ++i4) {
            String string2 = WmiUtil.getString(wmiResult3, Win32DiskPartition.DiskPartitionProperty.DEVICEID, i4);
            arrayList = (ArrayList<Pair<String, Long>>)partitionMaps.partitionToLogicalDriveMap.get(string2);
            if (arrayList == null) continue;
            for (int i5 = 0; i5 < arrayList.size(); ++i5) {
                Pair pair = (Pair)arrayList.get(i5);
                if (pair == null || ((String)pair.getA()).isEmpty()) continue;
                char[] cArray = new char[100];
                Kernel32.INSTANCE.GetVolumeNameForVolumeMountPoint((String)pair.getA(), cArray, 100);
                String string3 = ParseUtil.parseUuidOrDefault(new String(cArray).trim(), "");
                HWPartition hWPartition = new HWPartition(WmiUtil.getString(wmiResult3, Win32DiskPartition.DiskPartitionProperty.NAME, i4), WmiUtil.getString(wmiResult3, Win32DiskPartition.DiskPartitionProperty.TYPE, i4), WmiUtil.getString(wmiResult3, Win32DiskPartition.DiskPartitionProperty.DESCRIPTION, i4), string3, (Long)pair.getB(), WmiUtil.getUint32(wmiResult3, Win32DiskPartition.DiskPartitionProperty.DISKINDEX, i4), WmiUtil.getUint32(wmiResult3, Win32DiskPartition.DiskPartitionProperty.INDEX, i4), (String)pair.getA());
                if (partitionMaps.partitionMap.containsKey(string2)) {
                    ((List)partitionMaps.partitionMap.get(string2)).add(hWPartition);
                    continue;
                }
                ArrayList<HWPartition> arrayList2 = new ArrayList<HWPartition>();
                arrayList2.add(hWPartition);
                partitionMaps.partitionMap.put(string2, arrayList2);
            }
        }
        return partitionMaps;
    }

    private static String getIndexFromName(String string) {
        if (string.isEmpty()) {
            return string;
        }
        return string.split("\\s")[0];
    }

    static final class DiskStats {
        private final Map<String, Long> readMap = new HashMap<String, Long>();
        private final Map<String, Long> readByteMap = new HashMap<String, Long>();
        private final Map<String, Long> writeMap = new HashMap<String, Long>();
        private final Map<String, Long> writeByteMap = new HashMap<String, Long>();
        private final Map<String, Long> queueLengthMap = new HashMap<String, Long>();
        private final Map<String, Long> diskTimeMap = new HashMap<String, Long>();
        private long timeStamp;

        private DiskStats() {
        }
    }

    static final class PartitionMaps {
        private final Map<String, List<String>> driveToPartitionMap = new HashMap<String, List<String>>();
        private final Map<String, List<Pair<String, Long>>> partitionToLogicalDriveMap = new HashMap<String, List<Pair<String, Long>>>();
        private final Map<String, List<HWPartition>> partitionMap = new HashMap<String, List<HWPartition>>();

        private PartitionMaps() {
        }
    }
}

