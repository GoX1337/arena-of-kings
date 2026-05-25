/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.OSDesktopWindow;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.Util;

@ThreadSafe
public final class Xwininfo {
    private static final String[] NET_CLIENT_LIST_STACKING = ParseUtil.whitespaces.split("xprop -root _NET_CLIENT_LIST_STACKING");
    private static final String[] XWININFO_ROOT_TREE = ParseUtil.whitespaces.split("xwininfo -root -tree");
    private static final String[] XPROP_NET_WM_PID_ID = ParseUtil.whitespaces.split("xprop _NET_WM_PID -id");

    private Xwininfo() {
    }

    public static List<OSDesktopWindow> queryXWindows(boolean bl2) {
        String string;
        Object object;
        int n2;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        int n3 = 0;
        List<String> list = ExecutingCommand.runNative(NET_CLIENT_LIST_STACKING, null);
        if (!list.isEmpty() && (n2 = ((String)(object = list.get(0))).indexOf("0x")) >= 0) {
            for (String object2 : ((String)object).substring(n2).split(", ")) {
                hashMap.put(object2, ++n3);
            }
        }
        object = Pattern.compile("(0x\\S+) (?:\"(.+)\")?.*: \\((?:\"(.+)\" \".+\")?\\)  (\\d+)x(\\d+)\\+.+  \\+(-?\\d+)\\+(-?\\d+)");
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        String[] stringArray = new HashMap();
        LinkedHashMap<String, Rectangle> linkedHashMap = new LinkedHashMap<String, Rectangle>();
        for (String string2 : ExecutingCommand.runNative(XWININFO_ROOT_TREE, null)) {
            String string3;
            Matcher matcher = ((Pattern)object).matcher(string2.trim());
            if (!matcher.matches()) continue;
            string = matcher.group(1);
            if (bl2 && !hashMap.containsKey(string)) continue;
            String string4 = matcher.group(2);
            if (!Util.isBlank(string4)) {
                hashMap2.put(string, string4);
            }
            if (!Util.isBlank(string3 = matcher.group(3))) {
                stringArray.put(string, string3);
            }
            linkedHashMap.put(string, new Rectangle(ParseUtil.parseIntOrDefault(matcher.group(6), 0), ParseUtil.parseIntOrDefault(matcher.group(7), 0), ParseUtil.parseIntOrDefault(matcher.group(4), 0), ParseUtil.parseIntOrDefault(matcher.group(5), 0)));
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            string = (String)entry.getKey();
            long l2 = Xwininfo.queryPidFromId(string);
            boolean bl3 = hashMap.containsKey(string);
            arrayList.add(new OSDesktopWindow(ParseUtil.hexStringToLong(string, 0L), hashMap2.getOrDefault(string, ""), stringArray.getOrDefault(string, ""), (Rectangle)entry.getValue(), l2, hashMap.getOrDefault(string, 0), bl3));
        }
        return arrayList;
    }

    private static long queryPidFromId(String string) {
        String[] stringArray = new String[XPROP_NET_WM_PID_ID.length + 1];
        System.arraycopy(XPROP_NET_WM_PID_ID, 0, stringArray, 0, XPROP_NET_WM_PID_ID.length);
        stringArray[Xwininfo.XPROP_NET_WM_PID_ID.length] = string;
        List<String> list = ExecutingCommand.runNative(stringArray, null);
        if (list.isEmpty()) {
            return 0L;
        }
        return ParseUtil.getFirstIntValue(list.get(0));
    }
}

