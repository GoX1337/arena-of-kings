/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.common;

import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.GlobalMemory;
import oshi.hardware.PhysicalMemory;
import oshi.util.ExecutingCommand;
import oshi.util.FormatUtil;
import oshi.util.ParseUtil;

@ThreadSafe
public abstract class AbstractGlobalMemory
implements GlobalMemory {
    @Override
    public List<PhysicalMemory> getPhysicalMemory() {
        ArrayList<PhysicalMemory> arrayList = new ArrayList<PhysicalMemory>();
        List<String> list = ExecutingCommand.runNative("dmidecode --type 17");
        int n2 = 0;
        String string = "unknown";
        String string2 = "";
        long l2 = 0L;
        long l3 = 0L;
        String string3 = "unknown";
        String string4 = "unknown";
        for (String string5 : list) {
            String[] stringArray;
            if (string5.trim().contains("DMI type 17")) {
                if (n2++ <= 0) continue;
                if (l2 > 0L) {
                    arrayList.add(new PhysicalMemory(string + string2, l2, l3, string3, string4));
                }
                string = "unknown";
                string2 = "";
                l2 = 0L;
                l3 = 0L;
                continue;
            }
            if (n2 <= 0 || (stringArray = string5.trim().split(":")).length != 2) continue;
            switch (stringArray[0]) {
                case "Bank Locator": {
                    string = stringArray[1].trim();
                    break;
                }
                case "Locator": {
                    string2 = "/" + stringArray[1].trim();
                    break;
                }
                case "Size": {
                    l2 = ParseUtil.parseDecimalMemorySizeToBinary(stringArray[1].trim());
                    break;
                }
                case "Type": {
                    string4 = stringArray[1].trim();
                    break;
                }
                case "Speed": {
                    l3 = ParseUtil.parseHertz(stringArray[1]);
                    break;
                }
                case "Manufacturer": {
                    string3 = stringArray[1].trim();
                    break;
                }
            }
        }
        if (l2 > 0L) {
            arrayList.add(new PhysicalMemory(string + string2, l2, l3, string3, string4));
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Available: ");
        stringBuilder.append(FormatUtil.formatBytes(this.getAvailable()));
        stringBuilder.append("/");
        stringBuilder.append(FormatUtil.formatBytes(this.getTotal()));
        return stringBuilder.toString();
    }
}

