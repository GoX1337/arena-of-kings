/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.openbsd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.GraphicsCard;
import oshi.hardware.common.AbstractGraphicsCard;
import oshi.util.ExecutingCommand;

@Immutable
final class OpenBsdGraphicsCard
extends AbstractGraphicsCard {
    private static final String PCI_CLASS_DISPLAY = "Class: 03 Display";
    private static final Pattern PCI_DUMP_HEADER = Pattern.compile(" \\d+:\\d+:\\d+: (.+)");

    OpenBsdGraphicsCard(String string, String string2, String string3, String string4, long l2) {
        super(string, string2, string3, string4, l2);
    }

    public static List<GraphicsCard> getGraphicsCards() {
        ArrayList<GraphicsCard> arrayList = new ArrayList<GraphicsCard>();
        List<String> list = ExecutingCommand.runNative("pcidump -v");
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        String string = "";
        String string2 = "";
        String string3 = "";
        boolean bl2 = false;
        String string4 = "";
        for (String string5 : list) {
            int n2;
            Matcher matcher = PCI_DUMP_HEADER.matcher(string5);
            if (matcher.matches()) {
                if (bl2) {
                    arrayList.add(new OpenBsdGraphicsCard(string.isEmpty() ? "unknown" : string, string3.isEmpty() ? "0x0000" : string3, string2.isEmpty() ? "0x0000" : string2, string4.isEmpty() ? "unknown" : string4, 0L));
                }
                string = matcher.group(1);
                string2 = "";
                string3 = "";
                bl2 = false;
                string4 = "";
                continue;
            }
            if (!bl2) {
                n2 = string5.indexOf("Vendor ID: ");
                if (n2 >= 0 && string5.length() >= n2 + 15) {
                    string2 = "0x" + string5.substring(n2 + 11, n2 + 15);
                }
                if ((n2 = string5.indexOf("Product ID: ")) >= 0 && string5.length() >= n2 + 16) {
                    string3 = "0x" + string5.substring(n2 + 12, n2 + 16);
                }
                if (!string5.contains(PCI_CLASS_DISPLAY)) continue;
                bl2 = true;
                continue;
            }
            if (!string4.isEmpty() || (n2 = string5.indexOf("Revision: ")) < 0) continue;
            string4 = string5.substring(n2);
        }
        if (bl2) {
            arrayList.add(new OpenBsdGraphicsCard(string.isEmpty() ? "unknown" : string, string3.isEmpty() ? "0x0000" : string3, string2.isEmpty() ? "0x0000" : string2, string4.isEmpty() ? "unknown" : string4, 0L));
        }
        return arrayList;
    }
}

