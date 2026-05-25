/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.aix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.UsbDevice;
import oshi.hardware.common.AbstractUsbDevice;
import oshi.util.ParseUtil;

@Immutable
public class AixUsbDevice
extends AbstractUsbDevice {
    public AixUsbDevice(String string, String string2, String string3, String string4, String string5, String string6, List<UsbDevice> list) {
        super(string, string2, string3, string4, string5, string6, list);
    }

    public static List<UsbDevice> getUsbDevices(boolean bl2, Supplier<List<String>> supplier) {
        ArrayList<UsbDevice> arrayList = new ArrayList<UsbDevice>();
        for (String string : supplier.get()) {
            String[] stringArray;
            String string2 = string.trim();
            if (!string2.startsWith("usb") || (stringArray = ParseUtil.whitespaces.split(string2, 3)).length != 3) continue;
            arrayList.add(new AixUsbDevice(stringArray[2], "unknown", "unknown", "unknown", "unknown", stringArray[0], Collections.emptyList()));
        }
        if (bl2) {
            return Arrays.asList(new AixUsbDevice("USB Controller", "", "0000", "0000", "", "", arrayList));
        }
        return arrayList;
    }
}

