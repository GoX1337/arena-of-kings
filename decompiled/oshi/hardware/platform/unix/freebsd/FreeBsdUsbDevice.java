/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.freebsd;

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
public class FreeBsdUsbDevice
extends AbstractUsbDevice {
    public FreeBsdUsbDevice(String string, String string2, String string3, String string4, String string5, String string6, List<UsbDevice> list) {
        super(string, string2, string3, string4, string5, string6, list);
    }

    public static List<UsbDevice> getUsbDevices(boolean bl2) {
        List<UsbDevice> list = FreeBsdUsbDevice.getUsbDevices();
        if (bl2) {
            return list;
        }
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (UsbDevice usbDevice : list) {
            arrayList.add(new FreeBsdUsbDevice(usbDevice.getName(), usbDevice.getVendor(), usbDevice.getVendorId(), usbDevice.getProductId(), usbDevice.getSerialNumber(), usbDevice.getUniqueDeviceId(), Collections.emptyList()));
            FreeBsdUsbDevice.addDevicesToList(arrayList, usbDevice.getConnectedDevices());
        }
        return arrayList;
    }

    private static List<UsbDevice> getUsbDevices() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        HashMap<String, String> hashMap3 = new HashMap<String, String>();
        HashMap<String, String> hashMap4 = new HashMap<String, String>();
        HashMap<String, String> hashMap5 = new HashMap<String, String>();
        HashMap<String, String> hashMap6 = new HashMap<String, String>();
        HashMap<String, List<String>> hashMap7 = new HashMap<String, List<String>>();
        List<String> list = ExecutingCommand.runNative("lshal");
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        String string2 = "";
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string3 : list) {
            String string4;
            String string5;
            if (string3.startsWith("udi =")) {
                string2 = ParseUtil.getSingleQuoteStringValue(string3);
                continue;
            }
            if (string2.isEmpty() || (string5 = string3.trim()).isEmpty()) continue;
            if (string5.startsWith("freebsd.driver =") && "usbus".equals(ParseUtil.getSingleQuoteStringValue(string5))) {
                arrayList.add(string2);
                continue;
            }
            if (string5.contains(".parent =")) {
                string4 = ParseUtil.getSingleQuoteStringValue(string5);
                if (string2.replace(string4, "").startsWith("_if")) continue;
                hashMap6.put(string2, string4);
                hashMap7.computeIfAbsent(string4, string -> new ArrayList()).add(string2);
                continue;
            }
            if (string5.contains(".product =")) {
                hashMap.put(string2, ParseUtil.getSingleQuoteStringValue(string5));
                continue;
            }
            if (string5.contains(".vendor =")) {
                hashMap2.put(string2, ParseUtil.getSingleQuoteStringValue(string5));
                continue;
            }
            if (string5.contains(".serial =")) {
                string4 = ParseUtil.getSingleQuoteStringValue(string5);
                hashMap5.put(string2, string4.startsWith("0x") ? ParseUtil.hexStringToString(string4.replace("0x", "")) : string4);
                continue;
            }
            if (string5.contains(".vendor_id =")) {
                hashMap3.put(string2, String.format("%04x", ParseUtil.getFirstIntValue(string5)));
                continue;
            }
            if (!string5.contains(".product_id =")) continue;
            hashMap4.put(string2, String.format("%04x", ParseUtil.getFirstIntValue(string5)));
        }
        ArrayList arrayList2 = new ArrayList();
        for (String string4 : arrayList) {
            String string6 = (String)hashMap6.get(string4);
            hashMap7.put(string6, (List)hashMap7.get(string4));
            arrayList2.add(FreeBsdUsbDevice.getDeviceAndChildren(string6, "0000", "0000", hashMap, hashMap2, hashMap3, hashMap4, hashMap5, hashMap7));
        }
        return arrayList2;
    }

    private static void addDevicesToList(List<UsbDevice> list, List<UsbDevice> list2) {
        for (UsbDevice usbDevice : list2) {
            list.add(usbDevice);
            FreeBsdUsbDevice.addDevicesToList(list, usbDevice.getConnectedDevices());
        }
    }

    private static FreeBsdUsbDevice getDeviceAndChildren(String string, String string2, String string3, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Map<String, String> map5, Map<String, List<String>> map6) {
        String string4 = map3.getOrDefault(string, string2);
        String string5 = map4.getOrDefault(string, string3);
        List list = map6.getOrDefault(string, new ArrayList());
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (String string6 : list) {
            arrayList.add(FreeBsdUsbDevice.getDeviceAndChildren(string6, string4, string5, map, map2, map3, map4, map5, map6));
        }
        Collections.sort(arrayList);
        return new FreeBsdUsbDevice(map.getOrDefault(string, string4 + ":" + string5), map2.getOrDefault(string, ""), string4, string5, map5.getOrDefault(string, ""), string, arrayList);
    }
}

