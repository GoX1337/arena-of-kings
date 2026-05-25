/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import com.sun.jna.platform.linux.Udev;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.common.AbstractHWDiskStore;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.linux.ProcPath;

@ThreadSafe
public final class LinuxHWDiskStore
extends AbstractHWDiskStore {
    private static final String BLOCK = "block";
    private static final String DISK = "disk";
    private static final String PARTITION = "partition";
    private static final String STAT = "stat";
    private static final String SIZE = "size";
    private static final String MINOR = "MINOR";
    private static final String MAJOR = "MAJOR";
    private static final String ID_FS_TYPE = "ID_FS_TYPE";
    private static final String ID_FS_UUID = "ID_FS_UUID";
    private static final String ID_MODEL = "ID_MODEL";
    private static final String ID_SERIAL_SHORT = "ID_SERIAL_SHORT";
    private static final String DM_UUID = "DM_UUID";
    private static final String DM_VG_NAME = "DM_VG_NAME";
    private static final String DM_LV_NAME = "DM_LV_NAME";
    private static final String LOGICAL_VOLUME_GROUP = "Logical Volume Group";
    private static final String DEV_LOCATION = "/dev/";
    private static final String DEV_MAPPER = "/dev/mapper/";
    private static final int SECTORSIZE = 512;
    private static final int[] UDEV_STAT_ORDERS = new int[UdevStat.values().length];
    private static final int UDEV_STAT_LENGTH;
    private long reads = 0L;
    private long readBytes = 0L;
    private long writes = 0L;
    private long writeBytes = 0L;
    private long currentQueueLength = 0L;
    private long transferTime = 0L;
    private long timeStamp = 0L;
    private List<HWPartition> partitionList = new ArrayList<HWPartition>();

    private LinuxHWDiskStore(String string, String string2, String string3, long l2) {
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

    public static List<HWDiskStore> getDisks() {
        return LinuxHWDiskStore.getDisks(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private static List<HWDiskStore> getDisks(LinuxHWDiskStore linuxHWDiskStore) {
        AbstractHWDiskStore abstractHWDiskStore = null;
        ArrayList<HWDiskStore> arrayList = new ArrayList<HWDiskStore>();
        Map<String, String> map = LinuxHWDiskStore.readMountsMap();
        Udev.UdevContext udevContext = Udev.INSTANCE.udev_new();
        try {
            Udev.UdevEnumerate udevEnumerate = udevContext.enumerateNew();
            try {
                void var6_7;
                udevEnumerate.addMatchSubsystem(BLOCK);
                udevEnumerate.scanDevices();
                Udev.UdevListEntry object = udevEnumerate.getListEntry();
                while (var6_7 != null) {
                    block18: {
                        String string = var6_7.getName();
                        Udev.UdevDevice udevDevice = udevContext.deviceNewFromSyspath(string);
                        if (udevDevice != null) {
                            try {
                                String string2;
                                Object object2;
                                String string3 = udevDevice.getDevnode();
                                if (string3 == null || string3.startsWith("/dev/loop") || string3.startsWith("/dev/ram")) break block18;
                                if (DISK.equals(udevDevice.getDevtype())) {
                                    object2 = udevDevice.getPropertyValue(ID_MODEL);
                                    string2 = udevDevice.getPropertyValue(ID_SERIAL_SHORT);
                                    long l2 = ParseUtil.parseLongOrDefault(udevDevice.getSysattrValue(SIZE), 0L) * 512L;
                                    if (string3.startsWith("/dev/dm")) {
                                        object2 = LOGICAL_VOLUME_GROUP;
                                        string2 = udevDevice.getPropertyValue(DM_UUID);
                                        abstractHWDiskStore = new LinuxHWDiskStore(string3, (String)object2, string2 == null ? "unknown" : string2, l2);
                                        String string4 = udevDevice.getPropertyValue(DM_VG_NAME);
                                        String string5 = udevDevice.getPropertyValue(DM_LV_NAME);
                                        ((LinuxHWDiskStore)abstractHWDiskStore).partitionList.add(new HWPartition(LinuxHWDiskStore.getPartitionNameForDmDevice(string4, string5), udevDevice.getSysname(), udevDevice.getPropertyValue(ID_FS_TYPE) == null ? PARTITION : udevDevice.getPropertyValue(ID_FS_TYPE), udevDevice.getPropertyValue(ID_FS_UUID) == null ? "" : udevDevice.getPropertyValue(ID_FS_UUID), ParseUtil.parseLongOrDefault(udevDevice.getSysattrValue(SIZE), 0L) * 512L, ParseUtil.parseIntOrDefault(udevDevice.getPropertyValue(MAJOR), 0), ParseUtil.parseIntOrDefault(udevDevice.getPropertyValue(MINOR), 0), LinuxHWDiskStore.getMountPointOfDmDevice(string4, string5)));
                                    } else {
                                        abstractHWDiskStore = new LinuxHWDiskStore(string3, (String)(object2 == null ? "unknown" : object2), string2 == null ? "unknown" : string2, l2);
                                    }
                                    if (linuxHWDiskStore == null) {
                                        LinuxHWDiskStore.computeDiskStats((LinuxHWDiskStore)abstractHWDiskStore, udevDevice.getSysattrValue(STAT));
                                        arrayList.add(abstractHWDiskStore);
                                        break block18;
                                    }
                                    if (!abstractHWDiskStore.getName().equals(linuxHWDiskStore.getName()) || !abstractHWDiskStore.getModel().equals(linuxHWDiskStore.getModel()) || !abstractHWDiskStore.getSerial().equals(linuxHWDiskStore.getSerial()) || abstractHWDiskStore.getSize() != linuxHWDiskStore.getSize()) break block18;
                                    LinuxHWDiskStore.computeDiskStats(linuxHWDiskStore, udevDevice.getSysattrValue(STAT));
                                    arrayList.add(linuxHWDiskStore);
                                    break;
                                }
                                if (linuxHWDiskStore == null && abstractHWDiskStore != null && PARTITION.equals(udevDevice.getDevtype()) && (object2 = udevDevice.getParentWithSubsystemDevtype(BLOCK, DISK)) != null && abstractHWDiskStore.getName().equals(((Udev.UdevDevice)object2).getDevnode())) {
                                    string2 = udevDevice.getDevnode();
                                    ((LinuxHWDiskStore)abstractHWDiskStore).partitionList.add(new HWPartition(string2, udevDevice.getSysname(), udevDevice.getPropertyValue(ID_FS_TYPE) == null ? PARTITION : udevDevice.getPropertyValue(ID_FS_TYPE), udevDevice.getPropertyValue(ID_FS_UUID) == null ? "" : udevDevice.getPropertyValue(ID_FS_UUID), ParseUtil.parseLongOrDefault(udevDevice.getSysattrValue(SIZE), 0L) * 512L, ParseUtil.parseIntOrDefault(udevDevice.getPropertyValue(MAJOR), 0), ParseUtil.parseIntOrDefault(udevDevice.getPropertyValue(MINOR), 0), map.getOrDefault(string2, LinuxHWDiskStore.getDependentNamesFromHoldersDirectory(udevDevice.getSysname()))));
                                }
                            }
                            finally {
                                udevDevice.unref();
                            }
                        }
                    }
                    Udev.UdevListEntry udevListEntry = var6_7.getNext();
                }
            }
            finally {
                udevEnumerate.unref();
            }
        }
        finally {
            udevContext.unref();
        }
        for (HWDiskStore hWDiskStore : arrayList) {
            ((LinuxHWDiskStore)hWDiskStore).partitionList = Collections.unmodifiableList(hWDiskStore.getPartitions().stream().sorted(Comparator.comparing(HWPartition::getName)).collect(Collectors.toList()));
        }
        return arrayList;
    }

    @Override
    public boolean updateAttributes() {
        return !LinuxHWDiskStore.getDisks(this).isEmpty();
    }

    private static Map<String, String> readMountsMap() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        List<String> list = FileUtil.readFile(ProcPath.MOUNTS);
        for (String string : list) {
            String[] stringArray = ParseUtil.whitespaces.split(string);
            if (stringArray.length < 2 || !stringArray[0].startsWith(DEV_LOCATION)) continue;
            hashMap.put(stringArray[0], stringArray[1]);
        }
        return hashMap;
    }

    private static void computeDiskStats(LinuxHWDiskStore linuxHWDiskStore, String string) {
        long[] lArray = ParseUtil.parseStringToLongArray(string, UDEV_STAT_ORDERS, UDEV_STAT_LENGTH, ' ');
        linuxHWDiskStore.timeStamp = System.currentTimeMillis();
        linuxHWDiskStore.reads = lArray[UdevStat.READS.ordinal()];
        linuxHWDiskStore.readBytes = lArray[UdevStat.READ_BYTES.ordinal()] * 512L;
        linuxHWDiskStore.writes = lArray[UdevStat.WRITES.ordinal()];
        linuxHWDiskStore.writeBytes = lArray[UdevStat.WRITE_BYTES.ordinal()] * 512L;
        linuxHWDiskStore.currentQueueLength = lArray[UdevStat.QUEUE_LENGTH.ordinal()];
        linuxHWDiskStore.transferTime = lArray[UdevStat.ACTIVE_MS.ordinal()];
    }

    private static String getPartitionNameForDmDevice(String string, String string2) {
        return DEV_LOCATION + string + '/' + string2;
    }

    private static String getMountPointOfDmDevice(String string, String string2) {
        return DEV_MAPPER + string + '-' + string2;
    }

    private static String getDependentNamesFromHoldersDirectory(String string) {
        File file = new File(string + "/holders");
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            return Arrays.stream(fileArray).map(File::getName).collect(Collectors.joining(" "));
        }
        return "";
    }

    static {
        for (UdevStat udevStat : UdevStat.values()) {
            LinuxHWDiskStore.UDEV_STAT_ORDERS[udevStat.ordinal()] = udevStat.getOrder();
        }
        String string = FileUtil.getStringFromFile(ProcPath.DISKSTATS);
        int n2 = 11;
        if (!string.isEmpty()) {
            n2 = ParseUtil.countStringToLongArray(string, ' ');
        }
        UDEV_STAT_LENGTH = n2;
    }

    static enum UdevStat {
        READS(0),
        READ_BYTES(2),
        WRITES(4),
        WRITE_BYTES(6),
        QUEUE_LENGTH(8),
        ACTIVE_MS(9);

        private int order;

        public int getOrder() {
            return this.order;
        }

        private UdevStat(int n3) {
            this.order = n3;
        }
    }
}

