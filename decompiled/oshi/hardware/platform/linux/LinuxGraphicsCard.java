/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.GraphicsCard;
import oshi.hardware.common.AbstractGraphicsCard;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;

@Immutable
final class LinuxGraphicsCard
extends AbstractGraphicsCard {
    LinuxGraphicsCard(String string, String string2, String string3, String string4, long l2) {
        super(string, string2, string3, string4, l2);
    }

    public static List<GraphicsCard> getGraphicsCards() {
        List<GraphicsCard> list = LinuxGraphicsCard.getGraphicsCardsFromLspci();
        if (list.isEmpty()) {
            list = LinuxGraphicsCard.getGraphicsCardsFromLshw();
        }
        return list;
    }

    private static List<GraphicsCard> getGraphicsCardsFromLspci() {
        ArrayList<GraphicsCard> arrayList = new ArrayList<GraphicsCard>();
        List<String> list = ExecutingCommand.runNative("lspci -vnnm");
        String string = "unknown";
        String string2 = "unknown";
        String string3 = "unknown";
        ArrayList<String> arrayList2 = new ArrayList<String>();
        boolean bl2 = false;
        String string4 = null;
        for (String string5 : list) {
            Pair<String, String> pair;
            String[] stringArray = string5.trim().split(":", 2);
            String string6 = stringArray[0];
            if (string6.equals("Class") && string5.contains("VGA")) {
                bl2 = true;
            } else if (string6.equals("Device") && !bl2 && stringArray.length > 1) {
                string4 = stringArray[1].trim();
            }
            if (!bl2) continue;
            if (stringArray.length < 2) {
                arrayList.add(new LinuxGraphicsCard(string, string2, string3, arrayList2.isEmpty() ? "unknown" : String.join((CharSequence)", ", arrayList2), LinuxGraphicsCard.queryLspciMemorySize(string4)));
                arrayList2.clear();
                bl2 = false;
                continue;
            }
            if (string6.equals("Device")) {
                pair = ParseUtil.parseLspciMachineReadable(stringArray[1].trim());
                if (pair == null) continue;
                string = pair.getA();
                string2 = "0x" + pair.getB();
                continue;
            }
            if (string6.equals("Vendor")) {
                pair = ParseUtil.parseLspciMachineReadable(stringArray[1].trim());
                if (pair != null) {
                    string3 = pair.getA() + " (0x" + pair.getB() + ")";
                    continue;
                }
                string3 = stringArray[1].trim();
                continue;
            }
            if (!string6.equals("Rev:")) continue;
            arrayList2.add(string5.trim());
        }
        if (bl2) {
            arrayList.add(new LinuxGraphicsCard(string, string2, string3, arrayList2.isEmpty() ? "unknown" : String.join((CharSequence)", ", arrayList2), LinuxGraphicsCard.queryLspciMemorySize(string4)));
        }
        return arrayList;
    }

    private static long queryLspciMemorySize(String string) {
        long l2 = 0L;
        List<String> list = ExecutingCommand.runNative("lspci -v -s " + string);
        for (String string2 : list) {
            if (!string2.contains(" prefetchable")) continue;
            l2 += ParseUtil.parseLspciMemorySize(string2);
        }
        return l2;
    }

    private static List<GraphicsCard> getGraphicsCardsFromLshw() {
        ArrayList<GraphicsCard> arrayList = new ArrayList<GraphicsCard>();
        List<String> list = ExecutingCommand.runNative("lshw -C display");
        String string = "unknown";
        String string2 = "unknown";
        String string3 = "unknown";
        ArrayList<String> arrayList2 = new ArrayList<String>();
        long l2 = 0L;
        int n2 = 0;
        for (String string4 : list) {
            String[] stringArray = string4.trim().split(":");
            if (stringArray[0].startsWith("*-display")) {
                if (n2++ <= 0) continue;
                arrayList.add(new LinuxGraphicsCard(string, string2, string3, arrayList2.isEmpty() ? "unknown" : String.join((CharSequence)", ", arrayList2), l2));
                arrayList2.clear();
                continue;
            }
            if (stringArray.length != 2) continue;
            String string5 = stringArray[0];
            if (string5.equals("product")) {
                string = stringArray[1].trim();
                continue;
            }
            if (string5.equals("vendor")) {
                string3 = stringArray[1].trim();
                continue;
            }
            if (string5.equals("version")) {
                arrayList2.add(string4.trim());
                continue;
            }
            if (!string5.startsWith("resources")) continue;
            l2 = ParseUtil.parseLshwResourceString(stringArray[1].trim());
        }
        arrayList.add(new LinuxGraphicsCard(string, string2, string3, arrayList2.isEmpty() ? "unknown" : String.join((CharSequence)", ", arrayList2), l2));
        return arrayList;
    }
}

