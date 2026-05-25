/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.freebsd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.GraphicsCard;
import oshi.hardware.common.AbstractGraphicsCard;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@Immutable
final class FreeBsdGraphicsCard
extends AbstractGraphicsCard {
    private static final String PCI_CLASS_DISPLAY = "0x03";

    FreeBsdGraphicsCard(String string, String string2, String string3, String string4, long l2) {
        super(string, string2, string3, string4, l2);
    }

    public static List<GraphicsCard> getGraphicsCards() {
        ArrayList<GraphicsCard> arrayList = new ArrayList<GraphicsCard>();
        List<String> list = ExecutingCommand.runNative("pciconf -lv");
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        String string = "unknown";
        String string2 = "unknown";
        String string3 = "unknown";
        String string4 = "";
        Object object = "unknown";
        for (String string5 : list) {
            String[] stringArray;
            if (string5.contains("class=0x")) {
                if (PCI_CLASS_DISPLAY.equals(string4)) {
                    arrayList.add(new FreeBsdGraphicsCard(string.isEmpty() ? "unknown" : string, string3.isEmpty() ? "unknown" : string3, string2.isEmpty() ? "unknown" : string2, (String)(((String)object).isEmpty() ? "unknown" : object), 0L));
                }
                stringArray = ParseUtil.whitespaces.split(string5);
                for (String string6 : stringArray) {
                    String[] stringArray2 = string6.split("=");
                    if (stringArray2.length <= 1) continue;
                    if (stringArray2[0].equals("class") && stringArray2[1].length() >= 4) {
                        string4 = stringArray2[1].substring(0, 4);
                        continue;
                    }
                    if (stringArray2[0].equals("chip") && stringArray2[1].length() >= 10) {
                        string3 = stringArray2[1].substring(0, 6);
                        string2 = "0x" + stringArray2[1].substring(6, 10);
                        continue;
                    }
                    if (!stringArray2[0].contains("rev")) continue;
                    object = string6;
                }
                string = "unknown";
                continue;
            }
            stringArray = string5.trim().split("=", 2);
            if (stringArray.length != 2) continue;
            String string7 = stringArray[0].trim();
            if (string7.equals("vendor")) {
                string2 = ParseUtil.getSingleQuoteStringValue(string5) + (string2.equals("unknown") ? "" : " (" + string2 + ")");
                continue;
            }
            if (!string7.equals("device")) continue;
            string = ParseUtil.getSingleQuoteStringValue(string5);
        }
        if (PCI_CLASS_DISPLAY.equals(string4)) {
            arrayList.add(new FreeBsdGraphicsCard(string.isEmpty() ? "unknown" : string, string3.isEmpty() ? "unknown" : string3, string2.isEmpty() ? "unknown" : string2, (String)(((String)object).isEmpty() ? "unknown" : object), 0L));
        }
        return arrayList;
    }
}

