/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.aix;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.GraphicsCard;
import oshi.hardware.common.AbstractGraphicsCard;
import oshi.util.ParseUtil;
import oshi.util.Util;

@Immutable
final class AixGraphicsCard
extends AbstractGraphicsCard {
    AixGraphicsCard(String string, String string2, String string3, String string4, long l2) {
        super(string, string2, string3, string4, l2);
    }

    public static List<GraphicsCard> getGraphicsCards(Supplier<List<String>> supplier) {
        ArrayList<GraphicsCard> arrayList = new ArrayList<GraphicsCard>();
        boolean bl2 = false;
        String string = null;
        String string2 = null;
        ArrayList<String> arrayList2 = new ArrayList<String>();
        for (String string3 : supplier.get()) {
            String string4 = string3.trim();
            if (string4.startsWith("Name:") && string4.contains("display")) {
                bl2 = true;
                continue;
            }
            if (bl2 && string4.toLowerCase().contains("graphics")) {
                string = string4;
                continue;
            }
            if (!bl2 || string == null) continue;
            if (string4.startsWith("Manufacture ID")) {
                string2 = ParseUtil.removeLeadingDots(string4.substring(14));
                continue;
            }
            if (string4.contains("Level")) {
                arrayList2.add(string4.replaceAll("\\.\\.+", "="));
                continue;
            }
            if (!string4.startsWith("Hardware Location Code")) continue;
            arrayList.add(new AixGraphicsCard(string, "unknown", Util.isBlank(string2) ? "unknown" : string2, arrayList2.isEmpty() ? "unknown" : String.join((CharSequence)",", arrayList2), 0L));
            bl2 = false;
        }
        return arrayList;
    }
}

