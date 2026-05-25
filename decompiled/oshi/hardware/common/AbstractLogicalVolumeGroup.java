/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.common;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import oshi.hardware.LogicalVolumeGroup;

public class AbstractLogicalVolumeGroup
implements LogicalVolumeGroup {
    private final String name;
    private final Map<String, Set<String>> lvMap;
    private final Set<String> pvSet;

    public AbstractLogicalVolumeGroup(String string, Map<String, Set<String>> map, Set<String> set) {
        this.name = string;
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            map.put(entry.getKey(), Collections.unmodifiableSet(entry.getValue()));
        }
        this.lvMap = Collections.unmodifiableMap(map);
        this.pvSet = Collections.unmodifiableSet(set);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Map<String, Set<String>> getLogicalVolumes() {
        return this.lvMap;
    }

    @Override
    public Set<String> getPhysicalVolumes() {
        return this.pvSet;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Logical Volume Group: ");
        stringBuilder.append(this.name).append("\n |-- PVs: ");
        stringBuilder.append(this.pvSet.toString());
        for (Map.Entry<String, Set<String>> entry : this.lvMap.entrySet()) {
            stringBuilder.append("\n |-- LV: ").append(entry.getKey());
            Set<String> set = entry.getValue();
            if (set.isEmpty()) continue;
            stringBuilder.append(" --> ").append(set);
        }
        return stringBuilder.toString();
    }
}

