/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.solaris;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.SoundCard;
import oshi.hardware.common.AbstractSoundCard;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@Immutable
final class SolarisSoundCard
extends AbstractSoundCard {
    private static final String LSHAL = "lshal";
    private static final String DEFAULT_AUDIO_DRIVER = "audio810";

    SolarisSoundCard(String string, String string2, String string3) {
        super(string, string2, string3);
    }

    public static List<SoundCard> getSoundCards() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        ArrayList<String> arrayList = new ArrayList<String>();
        String string = "";
        for (String string2 : ExecutingCommand.runNative(LSHAL)) {
            String object = string2.trim();
            if (object.startsWith("udi =")) {
                string = ParseUtil.getSingleQuoteStringValue(object);
                continue;
            }
            if (string.isEmpty() || object.isEmpty()) continue;
            if (object.contains("info.solaris.driver =") && DEFAULT_AUDIO_DRIVER.equals(ParseUtil.getSingleQuoteStringValue(object))) {
                arrayList.add(string);
                continue;
            }
            if (object.contains("info.product")) {
                hashMap2.put(string, ParseUtil.getStringBetween(object, '\''));
                continue;
            }
            if (!object.contains("info.vendor")) continue;
            hashMap.put(string, ParseUtil.getStringBetween(object, '\''));
        }
        ArrayList arrayList2 = new ArrayList();
        for (String string3 : arrayList) {
            arrayList2.add(new SolarisSoundCard((String)hashMap2.get(string3) + " " + DEFAULT_AUDIO_DRIVER, (String)hashMap.get(string3) + " " + (String)hashMap2.get(string3), (String)hashMap2.get(string3)));
        }
        return arrayList2;
    }
}

