/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.freebsd;

import java.io.File;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractFileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.linux.LinuxOSFileStore;
import oshi.util.ExecutingCommand;
import oshi.util.FileSystemUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.freebsd.BsdSysctlUtil;

@ThreadSafe
public final class FreeBsdFileSystem
extends AbstractFileSystem {
    public static final String OSHI_FREEBSD_FS_PATH_EXCLUDES = "oshi.os.freebsd.filesystem.path.excludes";
    public static final String OSHI_FREEBSD_FS_PATH_INCLUDES = "oshi.os.freebsd.filesystem.path.includes";
    public static final String OSHI_FREEBSD_FS_VOLUME_EXCLUDES = "oshi.os.freebsd.filesystem.volume.excludes";
    public static final String OSHI_FREEBSD_FS_VOLUME_INCLUDES = "oshi.os.freebsd.filesystem.volume.includes";
    private static final List<PathMatcher> FS_PATH_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.freebsd.filesystem.path.excludes");
    private static final List<PathMatcher> FS_PATH_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.freebsd.filesystem.path.includes");
    private static final List<PathMatcher> FS_VOLUME_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.freebsd.filesystem.volume.excludes");
    private static final List<PathMatcher> FS_VOLUME_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.freebsd.filesystem.volume.includes");

    @Override
    public List<OSFileStore> getFileStores(boolean bl2) {
        String[] stringArray;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string = "";
        for (String string2 : ExecutingCommand.runNative("geom part list")) {
            String string3;
            if (string2.contains("Name: ")) {
                string = string2.substring(string2.lastIndexOf(32) + 1);
            }
            if (string.isEmpty() || !(string3 = string2.trim()).startsWith("rawuuid:")) continue;
            hashMap.put(string, string3.substring(string3.lastIndexOf(32) + 1));
            string = "";
        }
        ArrayList arrayList = new ArrayList();
        HashMap<String, Long> hashMap2 = new HashMap<String, Long>();
        HashMap<String, Long> hashMap3 = new HashMap<String, Long>();
        for (String string4 : ExecutingCommand.runNative("df -i")) {
            if (!string4.startsWith("/") || (stringArray = ParseUtil.whitespaces.split(string4)).length <= 7) continue;
            hashMap2.put(stringArray[0], ParseUtil.parseLongOrDefault(stringArray[6], 0L));
            hashMap3.put(stringArray[0], (Long)hashMap2.get(stringArray[0]) + ParseUtil.parseLongOrDefault(stringArray[5], 0L));
        }
        for (String string4 : ExecutingCommand.runNative("mount -p")) {
            stringArray = ParseUtil.whitespaces.split(string4);
            if (stringArray.length < 5) continue;
            String string5 = stringArray[0];
            String string6 = stringArray[1];
            String string7 = stringArray[2];
            String string8 = stringArray[3];
            if (bl2 && NETWORK_FS_TYPES.contains(string7) || !string6.equals("/") && (PSEUDO_FS_TYPES.contains(string7) || FileSystemUtil.isFileStoreExcluded(string6, string5, FS_PATH_INCLUDES, FS_PATH_EXCLUDES, FS_VOLUME_INCLUDES, FS_VOLUME_EXCLUDES))) continue;
            String string9 = string6.substring(string6.lastIndexOf(47) + 1);
            if (string9.isEmpty()) {
                string9 = string5.substring(string5.lastIndexOf(47) + 1);
            }
            File file = new File(string6);
            long l2 = file.getTotalSpace();
            long l3 = file.getUsableSpace();
            long l4 = file.getFreeSpace();
            String string10 = string5.startsWith("/dev") || string6.equals("/") ? "Local Disk" : (string5.equals("tmpfs") ? "Ram Disk" : (NETWORK_FS_TYPES.contains(string7) ? "Network Disk" : "Mount Point"));
            String string11 = hashMap.getOrDefault(string9, "");
            arrayList.add(new LinuxOSFileStore(string9, string5, string9, string6, string8, string11, "", string10, string7, l4, l3, l2, hashMap2.containsKey(string6) ? (Long)hashMap2.get(string6) : 0L, hashMap3.containsKey(string6) ? (Long)hashMap3.get(string6) : 0L));
        }
        return arrayList;
    }

    @Override
    public long getOpenFileDescriptors() {
        return BsdSysctlUtil.sysctl("kern.openfiles", 0);
    }

    @Override
    public long getMaxFileDescriptors() {
        return BsdSysctlUtil.sysctl("kern.maxfiles", 0);
    }
}

