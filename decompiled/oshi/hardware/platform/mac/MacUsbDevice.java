/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import com.sun.jna.platform.mac.CoreFoundation;
import com.sun.jna.platform.mac.IOKit;
import com.sun.jna.platform.mac.IOKitUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.UsbDevice;
import oshi.hardware.common.AbstractUsbDevice;

@Immutable
public class MacUsbDevice
extends AbstractUsbDevice {
    private static final CoreFoundation CF = CoreFoundation.INSTANCE;
    private static final String IOUSB = "IOUSB";
    private static final String IOSERVICE = "IOService";

    public MacUsbDevice(String string, String string2, String string3, String string4, String string5, String string6, List<UsbDevice> list) {
        super(string, string2, string3, string4, string5, string6, list);
    }

    public static List<UsbDevice> getUsbDevices(boolean bl2) {
        List<UsbDevice> list = MacUsbDevice.getUsbDevices();
        if (bl2) {
            return list;
        }
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (UsbDevice usbDevice : list) {
            MacUsbDevice.addDevicesToList(arrayList, usbDevice.getConnectedDevices());
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    private static List<UsbDevice> getUsbDevices() {
        Object object;
        HashMap<Long, String> hashMap = new HashMap<Long, String>();
        HashMap<Long, String> hashMap2 = new HashMap<Long, String>();
        HashMap<Long, String> hashMap3 = new HashMap<Long, String>();
        HashMap<Long, String> hashMap4 = new HashMap<Long, String>();
        HashMap<Long, String> hashMap5 = new HashMap<Long, String>();
        HashMap<Long, List<Long>> hashMap6 = new HashMap<Long, List<Long>>();
        ArrayList<Long> arrayList = new ArrayList<Long>();
        IOKit.IORegistryEntry iORegistryEntry = IOKitUtil.getRoot();
        IOKit.IOIterator iOIterator = iORegistryEntry.getChildIterator(IOUSB);
        if (iOIterator != null) {
            void var11_12;
            object = CoreFoundation.CFStringRef.createCFString("locationID");
            CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString("IOPropertyMatch");
            IOKit.IORegistryEntry object2 = iOIterator.next();
            while (var11_12 != null) {
                long l2 = 0L;
                IOKit.IORegistryEntry iORegistryEntry2 = var11_12.getParentEntry(IOSERVICE);
                if (iORegistryEntry2 != null) {
                    l2 = iORegistryEntry2.getRegistryEntryID();
                    hashMap.put(l2, iORegistryEntry2.getName());
                    CoreFoundation.CFTypeRef cFTypeRef = iORegistryEntry2.createCFProperty((CoreFoundation.CFStringRef)object);
                    if (cFTypeRef != null) {
                        MacUsbDevice.getControllerIdByLocation(l2, cFTypeRef, (CoreFoundation.CFStringRef)object, cFStringRef, hashMap3, hashMap4);
                        cFTypeRef.release();
                    }
                    iORegistryEntry2.release();
                }
                arrayList.add(l2);
                MacUsbDevice.addDeviceAndChildrenToMaps((IOKit.IORegistryEntry)var11_12, l2, hashMap, hashMap2, hashMap3, hashMap4, hashMap5, hashMap6);
                var11_12.release();
                IOKit.IORegistryEntry iORegistryEntry3 = iOIterator.next();
            }
            ((CoreFoundation.CFTypeRef)object).release();
            cFStringRef.release();
            iOIterator.release();
        }
        iORegistryEntry.release();
        object = new ArrayList();
        for (Long l3 : arrayList) {
            object.add(MacUsbDevice.getDeviceAndChildren(l3, "0000", "0000", hashMap, hashMap2, hashMap3, hashMap4, hashMap5, hashMap6));
        }
        return object;
    }

    private static void addDeviceAndChildrenToMaps(IOKit.IORegistryEntry iORegistryEntry, long l3, Map<Long, String> map, Map<Long, String> map2, Map<Long, String> map3, Map<Long, String> map4, Map<Long, String> map5, Map<Long, List<Long>> map6) {
        String string;
        Long l4;
        Long l5;
        long l6 = iORegistryEntry.getRegistryEntryID();
        map6.computeIfAbsent(l3, l2 -> new ArrayList()).add(l6);
        map.put(l6, iORegistryEntry.getName().trim());
        String string2 = iORegistryEntry.getStringProperty("USB Vendor Name");
        if (string2 != null) {
            map2.put(l6, string2.trim());
        }
        if ((l5 = iORegistryEntry.getLongProperty("idVendor")) != null) {
            map3.put(l6, String.format("%04x", 0xFFFFL & l5));
        }
        if ((l4 = iORegistryEntry.getLongProperty("idProduct")) != null) {
            map4.put(l6, String.format("%04x", 0xFFFFL & l4));
        }
        if ((string = iORegistryEntry.getStringProperty("USB Serial Number")) != null) {
            map5.put(l6, string.trim());
        }
        IOKit.IOIterator iOIterator = iORegistryEntry.getChildIterator(IOUSB);
        IOKit.IORegistryEntry iORegistryEntry2 = iOIterator.next();
        while (iORegistryEntry2 != null) {
            MacUsbDevice.addDeviceAndChildrenToMaps(iORegistryEntry2, l6, map, map2, map3, map4, map5, map6);
            iORegistryEntry2.release();
            iORegistryEntry2 = iOIterator.next();
        }
        iOIterator.release();
    }

    private static void addDevicesToList(List<UsbDevice> list, List<UsbDevice> list2) {
        for (UsbDevice usbDevice : list2) {
            list.add(new MacUsbDevice(usbDevice.getName(), usbDevice.getVendor(), usbDevice.getVendorId(), usbDevice.getProductId(), usbDevice.getSerialNumber(), usbDevice.getUniqueDeviceId(), Collections.emptyList()));
            MacUsbDevice.addDevicesToList(list, usbDevice.getConnectedDevices());
        }
    }

    private static void getControllerIdByLocation(long l2, CoreFoundation.CFTypeRef cFTypeRef, CoreFoundation.CFStringRef cFStringRef, CoreFoundation.CFStringRef cFStringRef2, Map<Long, String> map, Map<Long, String> map2) {
        CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef = CF.CFDictionaryCreateMutable(CF.CFAllocatorGetDefault(), new CoreFoundation.CFIndex(0L), null, null);
        cFMutableDictionaryRef.setValue(cFStringRef, cFTypeRef);
        CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef2 = CF.CFDictionaryCreateMutable(CF.CFAllocatorGetDefault(), new CoreFoundation.CFIndex(0L), null, null);
        cFMutableDictionaryRef2.setValue(cFStringRef2, cFMutableDictionaryRef);
        IOKit.IOIterator iOIterator = IOKitUtil.getMatchingServices(cFMutableDictionaryRef2);
        cFMutableDictionaryRef.release();
        boolean bl2 = false;
        if (iOIterator != null) {
            IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
            while (iORegistryEntry != null && !bl2) {
                IOKit.IORegistryEntry iORegistryEntry2 = iORegistryEntry.getParentEntry(IOSERVICE);
                if (iORegistryEntry2 != null) {
                    byte[] byArray;
                    byte[] byArray2 = iORegistryEntry2.getByteArrayProperty("vendor-id");
                    if (byArray2 != null && byArray2.length >= 2) {
                        map.put(l2, String.format("%02x%02x", byArray2[1], byArray2[0]));
                        bl2 = true;
                    }
                    if ((byArray = iORegistryEntry2.getByteArrayProperty("device-id")) != null && byArray.length >= 2) {
                        map2.put(l2, String.format("%02x%02x", byArray[1], byArray[0]));
                        bl2 = true;
                    }
                    iORegistryEntry2.release();
                }
                iORegistryEntry.release();
                iORegistryEntry = iOIterator.next();
            }
            iOIterator.release();
        }
    }

    private static MacUsbDevice getDeviceAndChildren(Long l2, String string, String string2, Map<Long, String> map, Map<Long, String> map2, Map<Long, String> map3, Map<Long, String> map4, Map<Long, String> map5, Map<Long, List<Long>> map6) {
        String string3 = map3.getOrDefault(l2, string);
        String string4 = map4.getOrDefault(l2, string2);
        List list = map6.getOrDefault(l2, new ArrayList());
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (Long l3 : list) {
            arrayList.add(MacUsbDevice.getDeviceAndChildren(l3, string3, string4, map, map2, map3, map4, map5, map6));
        }
        Collections.sort(arrayList);
        return new MacUsbDevice(map.getOrDefault(l2, string3 + ":" + string4), map2.getOrDefault(l2, ""), string3, string4, map5.getOrDefault(l2, ""), "0x" + Long.toHexString(l2), arrayList);
    }
}

