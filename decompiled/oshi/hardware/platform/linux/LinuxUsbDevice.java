/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import com.sun.jna.platform.linux.Udev;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.UsbDevice;
import oshi.hardware.common.AbstractUsbDevice;

@Immutable
public class LinuxUsbDevice
extends AbstractUsbDevice {
    private static final String SUBSYSTEM_USB = "usb";
    private static final String DEVTYPE_USB_DEVICE = "usb_device";
    private static final String ATTR_PRODUCT = "product";
    private static final String ATTR_MANUFACTURER = "manufacturer";
    private static final String ATTR_VENDOR_ID = "idVendor";
    private static final String ATTR_PRODUCT_ID = "idProduct";
    private static final String ATTR_SERIAL = "serial";

    public LinuxUsbDevice(String string, String string2, String string3, String string4, String string5, String string6, List<UsbDevice> list) {
        super(string, string2, string3, string4, string5, string6, list);
    }

    public static List<UsbDevice> getUsbDevices(boolean bl2) {
        List<UsbDevice> list = LinuxUsbDevice.getUsbDevices();
        if (bl2) {
            return list;
        }
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (UsbDevice usbDevice : list) {
            arrayList.add(new LinuxUsbDevice(usbDevice.getName(), usbDevice.getVendor(), usbDevice.getVendorId(), usbDevice.getProductId(), usbDevice.getSerialNumber(), usbDevice.getUniqueDeviceId(), Collections.emptyList()));
            LinuxUsbDevice.addDevicesToList(arrayList, usbDevice.getConnectedDevices());
        }
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static List<UsbDevice> getUsbDevices() {
        Object object;
        ArrayList<String> arrayList = new ArrayList<String>();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        HashMap<String, String> hashMap3 = new HashMap<String, String>();
        HashMap<String, String> hashMap4 = new HashMap<String, String>();
        HashMap<String, String> hashMap5 = new HashMap<String, String>();
        HashMap<String, List<String>> hashMap6 = new HashMap<String, List<String>>();
        Udev.UdevContext udevContext = Udev.INSTANCE.udev_new();
        try {
            object = udevContext.enumerateNew();
            try {
                ((Udev.UdevEnumerate)object).addMatchSubsystem(SUBSYSTEM_USB);
                ((Udev.UdevEnumerate)object).scanDevices();
                for (Object object2 = ((Udev.UdevEnumerate)object).getListEntry(); object2 != null; object2 = ((Udev.UdevListEntry)object2).getNext()) {
                    String string2 = ((Udev.UdevListEntry)object2).getName();
                    Udev.UdevDevice udevDevice = udevContext.deviceNewFromSyspath(string2);
                    if (udevDevice == null) continue;
                    try {
                        Udev.UdevDevice udevDevice2;
                        if (!DEVTYPE_USB_DEVICE.equals(udevDevice.getDevtype())) continue;
                        String string3 = udevDevice.getSysattrValue(ATTR_PRODUCT);
                        if (string3 != null) {
                            hashMap.put(string2, string3);
                        }
                        if ((string3 = udevDevice.getSysattrValue(ATTR_MANUFACTURER)) != null) {
                            hashMap2.put(string2, string3);
                        }
                        if ((string3 = udevDevice.getSysattrValue(ATTR_VENDOR_ID)) != null) {
                            hashMap3.put(string2, string3);
                        }
                        if ((string3 = udevDevice.getSysattrValue(ATTR_PRODUCT_ID)) != null) {
                            hashMap4.put(string2, string3);
                        }
                        if ((string3 = udevDevice.getSysattrValue(ATTR_SERIAL)) != null) {
                            hashMap5.put(string2, string3);
                        }
                        if ((udevDevice2 = udevDevice.getParentWithSubsystemDevtype(SUBSYSTEM_USB, DEVTYPE_USB_DEVICE)) == null) {
                            arrayList.add(string2);
                            continue;
                        }
                        String string4 = udevDevice2.getSyspath();
                        hashMap6.computeIfAbsent(string4, string -> new ArrayList()).add(string2);
                        continue;
                    }
                    finally {
                        udevDevice.unref();
                    }
                }
            }
            finally {
                ((Udev.UdevEnumerate)object).unref();
            }
        }
        finally {
            udevContext.unref();
        }
        object = new ArrayList();
        for (String string2 : arrayList) {
            object.add(LinuxUsbDevice.getDeviceAndChildren(string2, "0000", "0000", hashMap, hashMap2, hashMap3, hashMap4, hashMap5, hashMap6));
        }
        return object;
    }

    private static void addDevicesToList(List<UsbDevice> list, List<UsbDevice> list2) {
        for (UsbDevice usbDevice : list2) {
            list.add(usbDevice);
            LinuxUsbDevice.addDevicesToList(list, usbDevice.getConnectedDevices());
        }
    }

    private static LinuxUsbDevice getDeviceAndChildren(String string, String string2, String string3, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Map<String, String> map5, Map<String, List<String>> map6) {
        String string4 = map3.getOrDefault(string, string2);
        String string5 = map4.getOrDefault(string, string3);
        List list = map6.getOrDefault(string, new ArrayList());
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (String string6 : list) {
            arrayList.add(LinuxUsbDevice.getDeviceAndChildren(string6, string4, string5, map, map2, map3, map4, map5, map6));
        }
        Collections.sort(arrayList);
        return new LinuxUsbDevice(map.getOrDefault(string, string4 + ":" + string5), map2.getOrDefault(string, ""), string4, string5, map5.getOrDefault(string, ""), string, arrayList);
    }
}

