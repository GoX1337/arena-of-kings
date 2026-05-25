/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.SoundCard;
import oshi.hardware.common.AbstractSoundCard;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;

@Immutable
final class MacSoundCard
extends AbstractSoundCard {
    private static final String APPLE = "Apple Inc.";

    MacSoundCard(String string, String string2, String string3) {
        super(string, string2, string3);
    }

    public static List<SoundCard> getSoundCards() {
        ArrayList<SoundCard> arrayList = new ArrayList<SoundCard>();
        String string = APPLE;
        String string2 = "AppleHDAController";
        String string3 = "AppleHDACodec";
        boolean bl2 = false;
        String string4 = "<key>com.apple.driver.AppleHDAController</key>";
        for (String string5 : FileUtil.readFile("/System/Library/Extensions/AppleHDA.kext/Contents/Info.plist")) {
            if (string5.contains(string4)) {
                bl2 = true;
                continue;
            }
            if (!bl2) continue;
            string2 = "AppleHDAController " + ParseUtil.getTextBetweenStrings(string5, "<string>", "</string>");
            bl2 = false;
        }
        arrayList.add(new MacSoundCard(string2, string, string3));
        return arrayList;
    }
}

