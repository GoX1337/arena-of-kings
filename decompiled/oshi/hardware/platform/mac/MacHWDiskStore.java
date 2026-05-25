/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.platform.mac.CoreFoundation;
import com.sun.jna.platform.mac.DiskArbitration;
import com.sun.jna.platform.mac.IOKit;
import com.sun.jna.platform.mac.IOKitUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.mac.disk.Fsstat;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.common.AbstractHWDiskStore;
import oshi.util.platform.mac.CFUtil;

@ThreadSafe
public final class MacHWDiskStore
extends AbstractHWDiskStore {
    private static final CoreFoundation CF = CoreFoundation.INSTANCE;
    private static final DiskArbitration DA = DiskArbitration.INSTANCE;
    private static final Logger LOG = LoggerFactory.getLogger(MacHWDiskStore.class);
    private long reads = 0L;
    private long readBytes = 0L;
    private long writes = 0L;
    private long writeBytes = 0L;
    private long currentQueueLength = 0L;
    private long transferTime = 0L;
    private long timeStamp = 0L;
    private List<HWPartition> partitionList;

    private MacHWDiskStore(String string, String string2, String string3, long l2, DiskArbitration.DASessionRef dASessionRef, Map<String, String> map, Map<CFKey, CoreFoundation.CFStringRef> map2) {
        super(string, string2, string3, l2);
        this.updateDiskStats(dASessionRef, map, map2);
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
        DiskArbitration.DASessionRef dASessionRef = DA.DASessionCreate(CF.CFAllocatorGetDefault());
        if (dASessionRef == null) {
            LOG.error("Unable to open session to DiskArbitration framework.");
            return false;
        }
        Map<CFKey, CoreFoundation.CFStringRef> map = MacHWDiskStore.mapCFKeys();
        boolean bl2 = this.updateDiskStats(dASessionRef, Fsstat.queryPartitionToMountMap(), map);
        dASessionRef.release();
        for (CoreFoundation.CFTypeRef cFTypeRef : map.values()) {
            cFTypeRef.release();
        }
        return bl2;
    }

    private boolean updateDiskStats(DiskArbitration.DASessionRef dASessionRef, Map<String, String> map, Map<CFKey, CoreFoundation.CFStringRef> map2) {
        IOKit.IOIterator iOIterator;
        String string = this.getName();
        CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef = IOKitUtil.getBSDNameMatchingDict(string);
        if (cFMutableDictionaryRef != null && (iOIterator = IOKitUtil.getMatchingServices(cFMutableDictionaryRef)) != null) {
            IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
            if (iORegistryEntry != null) {
                if (iORegistryEntry.conformsTo("IOMedia")) {
                    Object object;
                    Object object2;
                    CoreFoundation.CFNumberRef cFNumberRef;
                    Object object3;
                    Object object4;
                    Object object5;
                    IOKit.IORegistryEntry iORegistryEntry2 = iORegistryEntry.getParentEntry("IOService");
                    if (iORegistryEntry2 != null && (iORegistryEntry2.conformsTo("IOBlockStorageDriver") || iORegistryEntry2.conformsTo("AppleAPFSContainerScheme"))) {
                        object5 = iORegistryEntry2.createCFProperties();
                        object4 = ((CoreFoundation.CFDictionaryRef)object5).getValue(map2.get((Object)CFKey.STATISTICS));
                        object3 = new CoreFoundation.CFDictionaryRef((Pointer)object4);
                        this.timeStamp = System.currentTimeMillis();
                        object4 = ((CoreFoundation.CFDictionaryRef)object3).getValue(map2.get((Object)CFKey.READ_OPS));
                        cFNumberRef = new CoreFoundation.CFNumberRef((Pointer)object4);
                        this.reads = cFNumberRef.longValue();
                        object4 = ((CoreFoundation.CFDictionaryRef)object3).getValue(map2.get((Object)CFKey.READ_BYTES));
                        cFNumberRef.setPointer((Pointer)object4);
                        this.readBytes = cFNumberRef.longValue();
                        object4 = ((CoreFoundation.CFDictionaryRef)object3).getValue(map2.get((Object)CFKey.WRITE_OPS));
                        cFNumberRef.setPointer((Pointer)object4);
                        this.writes = cFNumberRef.longValue();
                        object4 = ((CoreFoundation.CFDictionaryRef)object3).getValue(map2.get((Object)CFKey.WRITE_BYTES));
                        cFNumberRef.setPointer((Pointer)object4);
                        this.writeBytes = cFNumberRef.longValue();
                        object2 = ((CoreFoundation.CFDictionaryRef)object3).getValue(map2.get((Object)CFKey.READ_TIME));
                        object = ((CoreFoundation.CFDictionaryRef)object3).getValue(map2.get((Object)CFKey.WRITE_TIME));
                        if (object2 != null && object != null) {
                            cFNumberRef.setPointer((Pointer)object2);
                            long l2 = cFNumberRef.longValue();
                            cFNumberRef.setPointer((Pointer)object);
                            this.transferTime = (l2 += cFNumberRef.longValue()) / 1000000L;
                        }
                        ((CoreFoundation.CFTypeRef)object5).release();
                    } else {
                        LOG.debug("Unable to find block storage driver properties for {}", (Object)string);
                    }
                    object5 = new ArrayList();
                    object4 = iORegistryEntry.createCFProperties();
                    object3 = ((CoreFoundation.CFDictionaryRef)object4).getValue(map2.get((Object)CFKey.BSD_UNIT));
                    cFNumberRef = new CoreFoundation.CFNumberRef((Pointer)object3);
                    object3 = ((CoreFoundation.CFDictionaryRef)object4).getValue(map2.get((Object)CFKey.LEAF));
                    object2 = new CoreFoundation.CFBooleanRef((Pointer)object3);
                    object = CF.CFDictionaryCreateMutable(CF.CFAllocatorGetDefault(), new CoreFoundation.CFIndex(0L), null, null);
                    ((CoreFoundation.CFMutableDictionaryRef)object).setValue(map2.get((Object)CFKey.BSD_UNIT), cFNumberRef);
                    ((CoreFoundation.CFMutableDictionaryRef)object).setValue(map2.get((Object)CFKey.WHOLE), (PointerType)object2);
                    cFMutableDictionaryRef = CF.CFDictionaryCreateMutable(CF.CFAllocatorGetDefault(), new CoreFoundation.CFIndex(0L), null, null);
                    cFMutableDictionaryRef.setValue(map2.get((Object)CFKey.IO_PROPERTY_MATCH), (PointerType)object);
                    IOKit.IOIterator iOIterator2 = IOKitUtil.getMatchingServices(cFMutableDictionaryRef);
                    ((CoreFoundation.CFTypeRef)object4).release();
                    ((CoreFoundation.CFTypeRef)object).release();
                    if (iOIterator2 != null) {
                        IOKit.IORegistryEntry iORegistryEntry3 = IOKit.INSTANCE.IOIteratorNext(iOIterator2);
                        while (iORegistryEntry3 != null) {
                            Object object6;
                            String string2;
                            String string3 = string2 = iORegistryEntry3.getStringProperty("BSD Name");
                            String string4 = "";
                            DiskArbitration.DADiskRef dADiskRef = DA.DADiskCreateFromBSDName(CF.CFAllocatorGetDefault(), dASessionRef, string2);
                            if (dADiskRef != null) {
                                object6 = DA.DADiskCopyDescription(dADiskRef);
                                if (object6 != null) {
                                    object3 = ((CoreFoundation.CFDictionaryRef)object6).getValue(map2.get((Object)CFKey.DA_MEDIA_NAME));
                                    string4 = CFUtil.cfPointerToString((Pointer)object3);
                                    object3 = ((CoreFoundation.CFDictionaryRef)object6).getValue(map2.get((Object)CFKey.DA_VOLUME_NAME));
                                    string3 = object3 == null ? string4 : CFUtil.cfPointerToString((Pointer)object3);
                                    ((CoreFoundation.CFTypeRef)object6).release();
                                }
                                dADiskRef.release();
                            }
                            object6 = map.getOrDefault(string2, "");
                            Long l3 = iORegistryEntry3.getLongProperty("Size");
                            Integer n2 = iORegistryEntry3.getIntegerProperty("BSD Major");
                            Integer n3 = iORegistryEntry3.getIntegerProperty("BSD Minor");
                            String string5 = iORegistryEntry3.getStringProperty("UUID");
                            object5.add(new HWPartition(string2, string3, string4, string5 == null ? "unknown" : string5, l3 == null ? 0L : l3, n2 == null ? 0 : n2, n3 == null ? 0 : n3, (String)object6));
                            iORegistryEntry3.release();
                            iORegistryEntry3 = IOKit.INSTANCE.IOIteratorNext(iOIterator2);
                        }
                        iOIterator2.release();
                    }
                    this.partitionList = Collections.unmodifiableList(object5.stream().sorted(Comparator.comparing(HWPartition::getName)).collect(Collectors.toList()));
                    if (iORegistryEntry2 != null) {
                        iORegistryEntry2.release();
                    }
                } else {
                    LOG.error("Unable to find IOMedia device or parent for {}", (Object)string);
                }
                iORegistryEntry.release();
            }
            iOIterator.release();
            return true;
        }
        return false;
    }

    public static List<HWDiskStore> getDisks() {
        Object object;
        Map<String, String> map = Fsstat.queryPartitionToMountMap();
        Map<CFKey, CoreFoundation.CFStringRef> map2 = MacHWDiskStore.mapCFKeys();
        ArrayList<HWDiskStore> arrayList = new ArrayList<HWDiskStore>();
        DiskArbitration.DASessionRef dASessionRef = DA.DASessionCreate(CF.CFAllocatorGetDefault());
        if (dASessionRef == null) {
            LOG.error("Unable to open session to DiskArbitration framework.");
            return Collections.emptyList();
        }
        ArrayList<String> arrayList2 = new ArrayList<String>();
        IOKit.IOIterator iOIterator = IOKitUtil.getMatchingServices("IOMedia");
        if (iOIterator != null) {
            Object object2 = iOIterator.next();
            while (object2 != null) {
                Boolean object3 = ((IOKit.IORegistryEntry)object2).getBooleanProperty("Whole");
                if (object3 != null && object3.booleanValue()) {
                    object = DA.DADiskCreateFromIOMedia(CF.CFAllocatorGetDefault(), dASessionRef, (IOKit.IOObject)object2);
                    arrayList2.add(DA.DADiskGetBSDName((DiskArbitration.DADiskRef)object));
                    ((CoreFoundation.CFTypeRef)object).release();
                }
                ((IOKit.IOObject)object2).release();
                object2 = iOIterator.next();
            }
            iOIterator.release();
        }
        for (String string : arrayList2) {
            Object object2;
            object = "";
            String string2 = "";
            long l2 = 0L;
            String string3 = "/dev/" + string;
            DiskArbitration.DADiskRef dADiskRef = DA.DADiskCreateFromBSDName(CF.CFAllocatorGetDefault(), dASessionRef, string3);
            if (dADiskRef == null) continue;
            CoreFoundation.CFDictionaryRef cFDictionaryRef = DA.DADiskCopyDescription(dADiskRef);
            if (cFDictionaryRef != null) {
                object2 = cFDictionaryRef.getValue(map2.get((Object)CFKey.DA_DEVICE_MODEL));
                object = CFUtil.cfPointerToString((Pointer)object2);
                object2 = cFDictionaryRef.getValue(map2.get((Object)CFKey.DA_MEDIA_SIZE));
                CoreFoundation.CFNumberRef cFNumberRef = new CoreFoundation.CFNumberRef((Pointer)object2);
                l2 = cFNumberRef.longValue();
                cFDictionaryRef.release();
                if (!"Disk Image".equals(object)) {
                    CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString((String)object);
                    CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef = CF.CFDictionaryCreateMutable(CF.CFAllocatorGetDefault(), new CoreFoundation.CFIndex(0L), null, null);
                    cFMutableDictionaryRef.setValue(map2.get((Object)CFKey.MODEL), cFStringRef);
                    CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef2 = CF.CFDictionaryCreateMutable(CF.CFAllocatorGetDefault(), new CoreFoundation.CFIndex(0L), null, null);
                    cFMutableDictionaryRef2.setValue(map2.get((Object)CFKey.IO_PROPERTY_MATCH), cFMutableDictionaryRef);
                    IOKit.IOIterator iOIterator2 = IOKitUtil.getMatchingServices(cFMutableDictionaryRef2);
                    cFStringRef.release();
                    cFMutableDictionaryRef.release();
                    if (iOIterator2 != null) {
                        IOKit.IORegistryEntry iORegistryEntry = iOIterator2.next();
                        while (iORegistryEntry != null) {
                            string2 = iORegistryEntry.getStringProperty("Serial Number");
                            iORegistryEntry.release();
                            if (string2 != null) break;
                            iORegistryEntry.release();
                            iORegistryEntry = iOIterator2.next();
                        }
                        iOIterator2.release();
                    }
                    if (string2 == null) {
                        string2 = "";
                    }
                }
            }
            dADiskRef.release();
            if (l2 <= 0L) continue;
            object2 = new MacHWDiskStore(string, ((String)object).trim(), string2.trim(), l2, dASessionRef, map, map2);
            arrayList.add((HWDiskStore)object2);
        }
        dASessionRef.release();
        for (CoreFoundation.CFTypeRef cFTypeRef : map2.values()) {
            cFTypeRef.release();
        }
        return arrayList;
    }

    private static Map<CFKey, CoreFoundation.CFStringRef> mapCFKeys() {
        EnumMap<CFKey, CoreFoundation.CFStringRef> enumMap = new EnumMap<CFKey, CoreFoundation.CFStringRef>(CFKey.class);
        for (CFKey cFKey : CFKey.values()) {
            enumMap.put(cFKey, CoreFoundation.CFStringRef.createCFString(cFKey.getKey()));
        }
        return enumMap;
    }

    static enum CFKey {
        IO_PROPERTY_MATCH("IOPropertyMatch"),
        STATISTICS("Statistics"),
        READ_OPS("Operations (Read)"),
        READ_BYTES("Bytes (Read)"),
        READ_TIME("Total Time (Read)"),
        WRITE_OPS("Operations (Write)"),
        WRITE_BYTES("Bytes (Write)"),
        WRITE_TIME("Total Time (Write)"),
        BSD_UNIT("BSD Unit"),
        LEAF("Leaf"),
        WHOLE("Whole"),
        DA_MEDIA_NAME("DAMediaName"),
        DA_VOLUME_NAME("DAVolumeName"),
        DA_MEDIA_SIZE("DAMediaSize"),
        DA_DEVICE_MODEL("DADeviceModel"),
        MODEL("Model");

        private final String key;

        private CFKey(String string2) {
            this.key = string2;
        }

        public String getKey() {
            return this.key;
        }
    }
}

