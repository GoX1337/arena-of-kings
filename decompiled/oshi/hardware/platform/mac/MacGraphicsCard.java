/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.GraphicsCard;
import oshi.hardware.common.AbstractGraphicsCard;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@Immutable
final class MacGraphicsCard
extends AbstractGraphicsCard {
    MacGraphicsCard(String string, String string2, String string3, String string4, long l2) {
        super(string, string2, string3, string4, l2);
    }

    public static List<GraphicsCard> getGraphicsCards() {
        ArrayList<GraphicsCard> arrayList = new ArrayList<GraphicsCard>();
        List<String> list = ExecutingCommand.runNative("system_profiler SPDisplaysDataType");
        String string = "unknown";
        String string2 = "unknown";
        String string3 = "unknown";
        ArrayList<String> arrayList2 = new ArrayList<String>();
        long l2 = 0L;
        int n2 = 0;
        for (String string4 : list) {
            String[] stringArray = string4.trim().split(":", 2);
            if (stringArray.length != 2) continue;
            String string5 = stringArray[0].toLowerCase();
            if (string5.equals("chipset model")) {
                if (n2++ > 0) {
                    arrayList.add(new MacGraphicsCard(string, string2, string3, arrayList2.isEmpty() ? "unknown" : String.join((CharSequence)", ", arrayList2), l2));
                    arrayList2.clear();
                }
                string = stringArray[1].trim();
                continue;
            }
            if (string5.equals("device id")) {
                string2 = stringArray[1].trim();
                continue;
            }
            if (string5.equals("vendor")) {
                string3 = stringArray[1].trim();
                continue;
            }
            if (string5.contains("version") || string5.contains("revision")) {
                arrayList2.add(string4.trim());
                continue;
            }
            if (!string5.startsWith("vram")) continue;
            l2 = ParseUtil.parseDecimalMemorySizeToBinary(stringArray[1].trim());
        }
        arrayList.add(new MacGraphicsCard(string, string2, string3, arrayList2.isEmpty() ? "unknown" : String.join((CharSequence)", ", arrayList2), l2));
        return arrayList;
    }
}

