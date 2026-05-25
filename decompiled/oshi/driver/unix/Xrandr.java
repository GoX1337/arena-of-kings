/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class Xrandr {
    private static final String[] XRANDR_VERBOSE = new String[]{"xrandr", "--verbose"};

    private Xrandr() {
    }

    public static List<byte[]> getEdidArrays() {
        List<String> list = ExecutingCommand.runNative(XRANDR_VERBOSE, null);
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        StringBuilder stringBuilder = null;
        for (String string : list) {
            if (string.contains("EDID")) {
                stringBuilder = new StringBuilder();
                continue;
            }
            if (stringBuilder == null) continue;
            stringBuilder.append(string.trim());
            if (stringBuilder.length() < 256) continue;
            String string2 = stringBuilder.toString();
            byte[] byArray = ParseUtil.hexStringToByteArray(string2);
            if (byArray.length >= 128) {
                arrayList.add(byArray);
            }
            stringBuilder = null;
        }
        return arrayList;
    }
}

