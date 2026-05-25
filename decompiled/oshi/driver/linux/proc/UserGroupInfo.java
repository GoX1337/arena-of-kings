/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.linux.proc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;

@ThreadSafe
public final class UserGroupInfo {
    private static final Supplier<Map<String, String>> USERS_ID_MAP = Memoizer.memoize(UserGroupInfo::getUserMap, TimeUnit.MINUTES.toNanos(1L));
    private static final Supplier<Map<String, String>> GROUPS_ID_MAP = Memoizer.memoize(UserGroupInfo::getGroupMap, TimeUnit.MINUTES.toNanos(1L));

    private UserGroupInfo() {
    }

    public static String getUser(String string) {
        return USERS_ID_MAP.get().getOrDefault(string, "unknown");
    }

    public static String getGroupName(String string) {
        return GROUPS_ID_MAP.get().getOrDefault(string, "unknown");
    }

    private static Map<String, String> getUserMap() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        List<String> list = ExecutingCommand.runNative("getent passwd");
        for (String string : list) {
            String[] stringArray = string.split(":");
            if (stringArray.length <= 2) continue;
            String string2 = stringArray[0];
            String string3 = stringArray[2];
            hashMap.putIfAbsent(string3, string2);
        }
        return hashMap;
    }

    private static Map<String, String> getGroupMap() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        List<String> list = ExecutingCommand.runNative("getent group");
        for (String string : list) {
            String[] stringArray = string.split(":");
            if (stringArray.length <= 2) continue;
            String string2 = stringArray[0];
            String string3 = stringArray[2];
            hashMap.putIfAbsent(string3, string2);
        }
        return hashMap;
    }
}

