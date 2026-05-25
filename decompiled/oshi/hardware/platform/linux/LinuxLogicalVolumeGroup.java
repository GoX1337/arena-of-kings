/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import com.sun.jna.platform.linux.Udev;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import oshi.hardware.LogicalVolumeGroup;
import oshi.hardware.common.AbstractLogicalVolumeGroup;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.Util;

final class LinuxLogicalVolumeGroup
extends AbstractLogicalVolumeGroup {
    private static final String BLOCK = "block";
    private static final String DM_UUID = "DM_UUID";
    private static final String DM_VG_NAME = "DM_VG_NAME";
    private static final String DM_LV_NAME = "DM_LV_NAME";
    private static final String DEV_LOCATION = "/dev/";

    LinuxLogicalVolumeGroup(String string, Map<String, Set<String>> map, Set<String> set) {
        super(string, map, set);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static List<LogicalVolumeGroup> getLogicalVolumeGroups() {
        Object object;
        HashMap<String, Map> hashMap = new HashMap<String, Map>();
        HashMap<String, Set> hashMap2 = new HashMap<String, Set>();
        for (String object2 : ExecutingCommand.runNative("pvs -o vg_name,pv_name")) {
            object = ParseUtil.whitespaces.split(object2.trim());
            if (((String[])object).length != 2 || !object[1].startsWith(DEV_LOCATION)) continue;
            hashMap2.computeIfAbsent((String)object[0], string -> new HashSet()).add(object[1]);
        }
        Udev.UdevContext udevContext = Udev.INSTANCE.udev_new();
        try {
            Udev.UdevEnumerate udevEnumerate = udevContext.enumerateNew();
            try {
                udevEnumerate.addMatchSubsystem(BLOCK);
                udevEnumerate.scanDevices();
                for (object = udevEnumerate.getListEntry(); object != null; object = ((Udev.UdevListEntry)object).getNext()) {
                    String string2 = ((Udev.UdevListEntry)object).getName();
                    Udev.UdevDevice udevDevice = udevContext.deviceNewFromSyspath(string2);
                    if (udevDevice == null) continue;
                    try {
                        String string3;
                        String string4 = udevDevice.getDevnode();
                        if (string4 == null || !string4.startsWith("/dev/dm") || (string3 = udevDevice.getPropertyValue(DM_UUID)) == null || !string3.startsWith("LVM-")) continue;
                        String string5 = udevDevice.getPropertyValue(DM_VG_NAME);
                        String string6 = udevDevice.getPropertyValue(DM_LV_NAME);
                        if (Util.isBlank(string5) || Util.isBlank(string6)) continue;
                        hashMap.computeIfAbsent(string5, string -> new HashMap());
                        Map map = (Map)hashMap.get(string5);
                        hashMap2.computeIfAbsent(string5, string -> new HashSet());
                        Set set = (Set)hashMap2.get(string5);
                        File file = new File(string2 + "/slaves");
                        File[] fileArray = file.listFiles();
                        if (fileArray == null) continue;
                        for (File file2 : fileArray) {
                            String string7 = file2.getName();
                            map.computeIfAbsent(string6, string -> new HashSet()).add(DEV_LOCATION + string7);
                            set.add(DEV_LOCATION + string7);
                        }
                        continue;
                    }
                    finally {
                        udevDevice.unref();
                    }
                }
            }
            finally {
                udevEnumerate.unref();
            }
        }
        finally {
            udevContext.unref();
        }
        return hashMap.entrySet().stream().map(entry -> new LinuxLogicalVolumeGroup((String)entry.getKey(), (Map)entry.getValue(), (Set)hashMap2.get(entry.getKey()))).collect(Collectors.toList());
    }
}

