/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.windows;

import com.sun.jna.platform.win32.Guid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.Immutable;
import oshi.driver.windows.DeviceTree;
import oshi.hardware.UsbDevice;
import oshi.hardware.common.AbstractUsbDevice;
import oshi.util.ParseUtil;
import oshi.util.tuples.Quintet;
import oshi.util.tuples.Triplet;

@Immutable
public class WindowsUsbDevice
extends AbstractUsbDevice {
    private static final Guid.GUID GUID_DEVINTERFACE_USB_HOST_CONTROLLER = new Guid.GUID("{3ABF6F2D-71C4-462A-8A92-1E6861E6AF27}");

    public WindowsUsbDevice(String string, String string2, String string3, String string4, String string5, String string6, List<UsbDevice> list) {
        super(string, string2, string3, string4, string5, string6, list);
    }

    public static List<UsbDevice> getUsbDevices(boolean bl2) {
        List<UsbDevice> list = WindowsUsbDevice.queryUsbDevices();
        if (bl2) {
            return list;
        }
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (UsbDevice usbDevice : list) {
            WindowsUsbDevice.addDevicesToList(arrayList, usbDevice.getConnectedDevices());
        }
        return arrayList;
    }

    private static void addDevicesToList(List<UsbDevice> list, List<UsbDevice> list2) {
        for (UsbDevice usbDevice : list2) {
            list.add(new WindowsUsbDevice(usbDevice.getName(), usbDevice.getVendor(), usbDevice.getVendorId(), usbDevice.getProductId(), usbDevice.getSerialNumber(), usbDevice.getUniqueDeviceId(), Collections.emptyList()));
            WindowsUsbDevice.addDevicesToList(list, usbDevice.getConnectedDevices());
        }
    }

    private static List<UsbDevice> queryUsbDevices() {
        Quintet<Set<Integer>, Map<Integer, Integer>, Map<Integer, String>, Map<Integer, String>, Map<Integer, String>> quintet = DeviceTree.queryDeviceTree(GUID_DEVINTERFACE_USB_HOST_CONTROLLER);
        Map<Integer, Integer> map = quintet.getB();
        Map<Integer, String> map2 = quintet.getC();
        Map<Integer, String> map3 = quintet.getD();
        Map<Integer, String> map4 = quintet.getE();
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (Integer n2 : quintet.getA()) {
            WindowsUsbDevice windowsUsbDevice = WindowsUsbDevice.queryDeviceAndChildren(n2, map, map2, map3, map4, "0000", "0000", "");
            if (windowsUsbDevice == null) continue;
            arrayList.add(windowsUsbDevice);
        }
        return arrayList;
    }

    private static WindowsUsbDevice queryDeviceAndChildren(Integer n2, Map<Integer, Integer> map, Map<Integer, String> map2, Map<Integer, String> map3, Map<Integer, String> map4, String string, String string2, String string3) {
        Object object;
        String string4 = string;
        String string5 = string2;
        String string6 = string3;
        Triplet<String, String, String> triplet = ParseUtil.parseDeviceIdToVendorProductSerial(map3.get(n2));
        if (triplet != null) {
            string4 = triplet.getA();
            string5 = triplet.getB();
            string6 = triplet.getC();
            if (string6.isEmpty() && string4.equals(string) && string5.equals(string2)) {
                string6 = string3;
            }
        }
        Set set = map.entrySet().stream().filter(entry -> ((Integer)entry.getValue()).equals(n2)).map(Map.Entry::getKey).collect(Collectors.toSet());
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (Object object2 : set) {
            object = WindowsUsbDevice.queryDeviceAndChildren((Integer)object2, map, map2, map3, map4, string4, string5, string6);
            if (object == null) continue;
            arrayList.add((UsbDevice)object);
        }
        Collections.sort(arrayList);
        if (map2.containsKey(n2)) {
            Object object2;
            Object object3 = map2.get(n2);
            if (((String)object3).isEmpty()) {
                object3 = string4 + ":" + string5;
            }
            object2 = map3.get(n2);
            object = map4.get(n2);
            return new WindowsUsbDevice((String)object3, (String)object, string4, string5, string6, (String)object2, arrayList);
        }
        return null;
    }
}

