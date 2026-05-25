/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.aix;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.SoundCard;
import oshi.hardware.common.AbstractSoundCard;
import oshi.util.ParseUtil;

@Immutable
final class AixSoundCard
extends AbstractSoundCard {
    AixSoundCard(String string, String string2, String string3) {
        super(string, string2, string3);
    }

    public static List<SoundCard> getSoundCards(Supplier<List<String>> supplier) {
        ArrayList<SoundCard> arrayList = new ArrayList<SoundCard>();
        for (String string : supplier.get()) {
            String[] stringArray;
            String string2 = string.trim();
            if (!string2.startsWith("paud") || (stringArray = ParseUtil.whitespaces.split(string2, 3)).length != 3) continue;
            arrayList.add(new AixSoundCard("unknown", stringArray[2], "unknown"));
        }
        return arrayList;
    }
}

