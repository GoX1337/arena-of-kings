/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import oshi.hardware.LogicalVolumeGroup;
import oshi.hardware.common.AbstractLogicalVolumeGroup;
import oshi.util.ExecutingCommand;

final class MacLogicalVolumeGroup
extends AbstractLogicalVolumeGroup {
    private static final String DISKUTIL_CS_LIST = "diskutil cs list";
    private static final String LOGICAL_VOLUME_GROUP = "Logical Volume Group";
    private static final String PHYSICAL_VOLUME = "Physical Volume";
    private static final String LOGICAL_VOLUME = "Logical Volume";

    MacLogicalVolumeGroup(String string, Map<String, Set<String>> map, Set<String> set) {
        super(string, map, set);
    }

    static List<LogicalVolumeGroup> getLogicalVolumeGroups() {
        HashMap<String, Map> hashMap = new HashMap<String, Map>();
        HashMap<String, Set> hashMap2 = new HashMap<String, Set>();
        String string2 = null;
        boolean bl2 = false;
        boolean bl3 = false;
        for (String string3 : ExecutingCommand.runNative(DISKUTIL_CS_LIST)) {
            int n2;
            if (string3.contains(LOGICAL_VOLUME_GROUP)) {
                bl2 = true;
                continue;
            }
            if (bl2) {
                n2 = string3.indexOf("Name:");
                if (n2 < 0) continue;
                string2 = string3.substring(n2 + 5).trim();
                bl2 = false;
                continue;
            }
            if (string3.contains(PHYSICAL_VOLUME)) {
                bl3 = true;
                continue;
            }
            if (string3.contains(LOGICAL_VOLUME)) {
                bl3 = false;
                continue;
            }
            n2 = string3.indexOf("Disk:");
            if (n2 < 0) continue;
            if (bl3) {
                hashMap2.computeIfAbsent(string2, string -> new HashSet()).add(string3.substring(n2 + 5).trim());
                continue;
            }
            hashMap.computeIfAbsent(string2, string -> new HashMap()).put(string3.substring(n2 + 5).trim(), Collections.emptySet());
        }
        return hashMap.entrySet().stream().map(entry -> new MacLogicalVolumeGroup((String)entry.getKey(), (Map)entry.getValue(), (Set)hashMap2.get(entry.getKey()))).collect(Collectors.toList());
    }
}

