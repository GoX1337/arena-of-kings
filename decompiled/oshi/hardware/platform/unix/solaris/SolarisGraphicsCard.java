/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.solaris;

import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.GraphicsCard;
import oshi.hardware.common.AbstractGraphicsCard;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@Immutable
final class SolarisGraphicsCard
extends AbstractGraphicsCard {
    private static final String PCI_CLASS_DISPLAY = "0003";

    SolarisGraphicsCard(String string, String string2, String string3, String string4, long l2) {
        super(string, string2, string3, string4, l2);
    }

    public static List<GraphicsCard> getGraphicsCards() {
        ArrayList<GraphicsCard> arrayList = new ArrayList<GraphicsCard>();
        List<String> list = ExecutingCommand.runNative("prtconf -pv");
        if (list.isEmpty()) {
            return arrayList;
        }
        String string = "";
        String string2 = "";
        String string3 = "";
        String string4 = "";
        ArrayList<String> arrayList2 = new ArrayList<String>();
        for (String string5 : list) {
            if (string5.contains("Node 0x")) {
                if (PCI_CLASS_DISPLAY.equals(string4)) {
                    arrayList.add(new SolarisGraphicsCard(string.isEmpty() ? "unknown" : string, string3.isEmpty() ? "unknown" : string3, string2.isEmpty() ? "unknown" : string2, arrayList2.isEmpty() ? "unknown" : String.join((CharSequence)", ", arrayList2), 0L));
                }
                string = "";
                string2 = "unknown";
                string3 = "unknown";
                string4 = "";
                arrayList2.clear();
                continue;
            }
            String[] stringArray = string5.trim().split(":", 2);
            if (stringArray.length != 2) continue;
            if (stringArray[0].equals("model")) {
                string = ParseUtil.getSingleQuoteStringValue(string5);
                continue;
            }
            if (stringArray[0].equals("name")) {
                if (!string.isEmpty()) continue;
                string = ParseUtil.getSingleQuoteStringValue(string5);
                continue;
            }
            if (stringArray[0].equals("vendor-id")) {
                string2 = "0x" + string5.substring(string5.length() - 4);
                continue;
            }
            if (stringArray[0].equals("device-id")) {
                string3 = "0x" + string5.substring(string5.length() - 4);
                continue;
            }
            if (stringArray[0].equals("revision-id")) {
                arrayList2.add(string5.trim());
                continue;
            }
            if (!stringArray[0].equals("class-code")) continue;
            string4 = string5.substring(string5.length() - 8, string5.length() - 4);
        }
        if (PCI_CLASS_DISPLAY.equals(string4)) {
            arrayList.add(new SolarisGraphicsCard(string.isEmpty() ? "unknown" : string, string3.isEmpty() ? "unknown" : string3, string2.isEmpty() ? "unknown" : string2, arrayList2.isEmpty() ? "unknown" : String.join((CharSequence)", ", arrayList2), 0L));
        }
        return arrayList;
    }
}

