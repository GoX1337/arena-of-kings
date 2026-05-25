/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.openbsd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.SoundCard;
import oshi.hardware.common.AbstractSoundCard;
import oshi.util.ExecutingCommand;

@Immutable
final class OpenBsdSoundCard
extends AbstractSoundCard {
    private static final Pattern AUDIO_AT = Pattern.compile("audio\\d+ at (.+)");
    private static final Pattern PCI_AT = Pattern.compile("(.+) at pci\\d+ dev \\d+ function \\d+ \"(.*)\" (rev .+):.*");

    OpenBsdSoundCard(String string, String string2, String string3) {
        super(string, string2, string3);
    }

    public static List<SoundCard> getSoundCards() {
        Object object;
        List<String> list = ExecutingCommand.runNative("dmesg");
        HashSet<String> hashSet = new HashSet<String>();
        for (String object22 : list) {
            object = AUDIO_AT.matcher(object22);
            if (!((Matcher)object).matches()) continue;
            hashSet.add(((Matcher)object).group(1));
        }
        HashMap hashMap = new HashMap();
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        object = new HashMap();
        String string = "";
        for (String string2 : list) {
            Matcher matcher = PCI_AT.matcher(string2);
            if (matcher.matches() && hashSet.contains(matcher.group(1))) {
                string = matcher.group(1);
                hashMap.put(string, matcher.group(2));
                object.put(string, matcher.group(3));
                continue;
            }
            if (string.isEmpty()) continue;
            int n2 = string2.indexOf("codec");
            if (n2 >= 0) {
                n2 = string2.indexOf(58);
                hashMap2.put(string, string2.substring(n2 + 1).trim());
            }
            string = "";
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            arrayList.add(new OpenBsdSoundCard((String)object.get(entry.getKey()), (String)entry.getValue(), (String)hashMap2.get(entry.getKey())));
        }
        return arrayList;
    }
}

