/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.openbsd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.UsbDevice;
import oshi.hardware.common.AbstractUsbDevice;
import oshi.util.ExecutingCommand;

@Immutable
public class OpenBsdUsbDevice
extends AbstractUsbDevice {
    public OpenBsdUsbDevice(String string, String string2, String string3, String string4, String string5, String string6, List<UsbDevice> list) {
        super(string, string2, string3, string4, string5, string6, list);
    }

    public static List<UsbDevice> getUsbDevices(boolean bl2) {
        List<UsbDevice> list = OpenBsdUsbDevice.getUsbDevices();
        if (bl2) {
            return list;
        }
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (UsbDevice usbDevice : list) {
            arrayList.add(new OpenBsdUsbDevice(usbDevice.getName(), usbDevice.getVendor(), usbDevice.getVendorId(), usbDevice.getProductId(), usbDevice.getSerialNumber(), usbDevice.getUniqueDeviceId(), Collections.emptyList()));
            OpenBsdUsbDevice.addDevicesToList(arrayList, usbDevice.getConnectedDevices());
        }
        return arrayList;
    }

    private static List<UsbDevice> getUsbDevices() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        HashMap<String, String> hashMap3 = new HashMap<String, String>();
        HashMap<String, String> hashMap4 = new HashMap<String, String>();
        HashMap<String, String> hashMap5 = new HashMap<String, String>();
        HashMap<String, List<String>> hashMap6 = new HashMap<String, List<String>>();
        ArrayList<String> arrayList = new ArrayList<String>();
        String string2 = "";
        String string3 = "";
        for (String object : ExecutingCommand.runNative("usbdevs -v")) {
            if (object.startsWith("Controller ")) {
                string3 = object.substring(11);
                continue;
            }
            if (object.startsWith("addr ")) {
                if (object.indexOf(58) != 7 || object.indexOf(44) < 18) continue;
                string2 = string3 + object.substring(0, 7);
                String[] n4 = object.substring(8).trim().split(",");
                if (n4.length <= 1) continue;
                String string4 = n4[0].trim();
                int n2 = string4.indexOf(58);
                int n3 = string4.indexOf(32);
                if (n2 >= 0 && n3 >= 0) {
                    hashMap3.put(string2, string4.substring(0, n2));
                    hashMap4.put(string2, string4.substring(n2 + 1, n3));
                    hashMap2.put(string2, string4.substring(n3 + 1));
                }
                hashMap.put(string2, n4[1].trim());
                hashMap6.computeIfAbsent(string3, string -> new ArrayList()).add(string2);
                if (string3.contains("addr")) continue;
                string3 = string2;
                arrayList.add(string3);
                continue;
            }
            if (string2.isEmpty()) continue;
            int n4 = object.indexOf("iSerial ");
            if (n4 >= 0) {
                hashMap5.put(string2, object.substring(n4 + 8).trim());
            }
            string2 = "";
        }
        ArrayList arrayList2 = new ArrayList();
        for (String string5 : arrayList) {
            arrayList2.add(OpenBsdUsbDevice.getDeviceAndChildren(string5, "0000", "0000", hashMap, hashMap2, hashMap3, hashMap4, hashMap5, hashMap6));
        }
        return arrayList2;
    }

    private static void addDevicesToList(List<UsbDevice> list, List<UsbDevice> list2) {
        for (UsbDevice usbDevice : list2) {
            list.add(usbDevice);
            OpenBsdUsbDevice.addDevicesToList(list, usbDevice.getConnectedDevices());
        }
    }

    private static OpenBsdUsbDevice getDeviceAndChildren(String string, String string2, String string3, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Map<String, String> map5, Map<String, List<String>> map6) {
        String string4 = map3.getOrDefault(string, string2);
        String string5 = map4.getOrDefault(string, string3);
        List list = map6.getOrDefault(string, new ArrayList());
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (String string6 : list) {
            arrayList.add(OpenBsdUsbDevice.getDeviceAndChildren(string6, string4, string5, map, map2, map3, map4, map5, map6));
        }
        Collections.sort(arrayList);
        return new OpenBsdUsbDevice(map.getOrDefault(string, string4 + ":" + string5), map2.getOrDefault(string, ""), string4, string5, map5.getOrDefault(string, ""), string, arrayList);
    }
}

