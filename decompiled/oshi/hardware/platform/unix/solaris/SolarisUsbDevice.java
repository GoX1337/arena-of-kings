/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.solaris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.UsbDevice;
import oshi.hardware.common.AbstractUsbDevice;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@Immutable
public class SolarisUsbDevice
extends AbstractUsbDevice {
    private static final String PCI_TYPE_USB = "000c";

    public SolarisUsbDevice(String string, String string2, String string3, String string4, String string5, String string6, List<UsbDevice> list) {
        super(string, string2, string3, string4, string5, string6, list);
    }

    public static List<UsbDevice> getUsbDevices(boolean bl2) {
        List<UsbDevice> list = SolarisUsbDevice.getUsbDevices();
        if (bl2) {
            return list;
        }
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (UsbDevice usbDevice : list) {
            arrayList.add(new SolarisUsbDevice(usbDevice.getName(), usbDevice.getVendor(), usbDevice.getVendorId(), usbDevice.getProductId(), usbDevice.getSerialNumber(), usbDevice.getUniqueDeviceId(), Collections.emptyList()));
            SolarisUsbDevice.addDevicesToList(arrayList, usbDevice.getConnectedDevices());
        }
        return arrayList;
    }

    private static List<UsbDevice> getUsbDevices() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        HashMap<String, String> hashMap3 = new HashMap<String, String>();
        HashMap<String, List<String>> hashMap4 = new HashMap<String, List<String>>();
        HashMap<String, String> hashMap5 = new HashMap<String, String>();
        List<String> list = ExecutingCommand.runNative("prtconf -pv");
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        HashMap<Integer, String> hashMap6 = new HashMap<Integer, String>();
        String string2 = "";
        int n2 = 0;
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string3 : list) {
            if (string3.contains("Node 0x")) {
                string2 = string3.replaceFirst("^\\s*", "");
                int n3 = string3.length() - string2.length();
                if (n2 == 0) {
                    n2 = n3;
                }
                hashMap6.put(n3, string2);
                if (n3 > n2) {
                    hashMap4.computeIfAbsent((String)hashMap6.get(n3 - n2), string -> new ArrayList()).add(string2);
                    continue;
                }
                arrayList.add(string2);
                continue;
            }
            if (string2.isEmpty()) continue;
            String string4 = string3.trim();
            if (string4.startsWith("model:")) {
                hashMap.put(string2, ParseUtil.getSingleQuoteStringValue(string4));
                continue;
            }
            if (string4.startsWith("name:")) {
                hashMap.putIfAbsent(string2, ParseUtil.getSingleQuoteStringValue(string4));
                continue;
            }
            if (string4.startsWith("vendor-id:")) {
                hashMap2.put(string2, string4.substring(string4.length() - 4));
                continue;
            }
            if (string4.startsWith("device-id:")) {
                hashMap3.put(string2, string4.substring(string4.length() - 4));
                continue;
            }
            if (string4.startsWith("class-code:")) {
                hashMap5.putIfAbsent(string2, string4.substring(string4.length() - 8, string4.length() - 4));
                continue;
            }
            if (!string4.startsWith("device_type:")) continue;
            hashMap5.putIfAbsent(string2, ParseUtil.getSingleQuoteStringValue(string4));
        }
        ArrayList arrayList2 = new ArrayList();
        for (String string5 : arrayList) {
            if (!PCI_TYPE_USB.equals(hashMap5.getOrDefault(string5, "")) && !"usb".equals(hashMap5.getOrDefault(string5, ""))) continue;
            arrayList2.add(SolarisUsbDevice.getDeviceAndChildren(string5, "0000", "0000", hashMap, hashMap2, hashMap3, hashMap4));
        }
        return arrayList2;
    }

    private static void addDevicesToList(List<UsbDevice> list, List<UsbDevice> list2) {
        for (UsbDevice usbDevice : list2) {
            list.add(usbDevice);
            SolarisUsbDevice.addDevicesToList(list, usbDevice.getConnectedDevices());
        }
    }

    private static SolarisUsbDevice getDeviceAndChildren(String string, String string2, String string3, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, List<String>> map4) {
        String string4 = map2.getOrDefault(string, string2);
        String string5 = map3.getOrDefault(string, string3);
        List list = map4.getOrDefault(string, new ArrayList());
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (String string6 : list) {
            arrayList.add(SolarisUsbDevice.getDeviceAndChildren(string6, string4, string5, map, map2, map3, map4));
        }
        Collections.sort(arrayList);
        return new SolarisUsbDevice(map.getOrDefault(string, string4 + ":" + string5), "", string4, string5, "", string, arrayList);
    }
}

