/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.openbsd;

import java.io.File;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractFileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.unix.openbsd.OpenBsdOSFileStore;
import oshi.util.ExecutingCommand;
import oshi.util.FileSystemUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.openbsd.OpenBsdSysctlUtil;

@ThreadSafe
public class OpenBsdFileSystem
extends AbstractFileSystem {
    public static final String OSHI_OPENBSD_FS_PATH_EXCLUDES = "oshi.os.openbsd.filesystem.path.excludes";
    public static final String OSHI_OPENBSD_FS_PATH_INCLUDES = "oshi.os.openbsd.filesystem.path.includes";
    public static final String OSHI_OPENBSD_FS_VOLUME_EXCLUDES = "oshi.os.openbsd.filesystem.volume.excludes";
    public static final String OSHI_OPENBSD_FS_VOLUME_INCLUDES = "oshi.os.openbsd.filesystem.volume.includes";
    private static final List<PathMatcher> FS_PATH_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.openbsd.filesystem.path.excludes");
    private static final List<PathMatcher> FS_PATH_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.openbsd.filesystem.path.includes");
    private static final List<PathMatcher> FS_VOLUME_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.openbsd.filesystem.volume.excludes");
    private static final List<PathMatcher> FS_VOLUME_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.openbsd.filesystem.volume.includes");

    @Override
    public List<OSFileStore> getFileStores(boolean bl2) {
        return OpenBsdFileSystem.getFileStoreMatching(null, bl2);
    }

    static List<OSFileStore> getFileStoreMatching(String string) {
        return OpenBsdFileSystem.getFileStoreMatching(string, false);
    }

    private static List<OSFileStore> getFileStoreMatching(String string, boolean bl2) {
        String[] stringArray;
        ArrayList<OSFileStore> arrayList = new ArrayList<OSFileStore>();
        HashMap<String, Long> hashMap = new HashMap<String, Long>();
        HashMap<String, Long> hashMap2 = new HashMap<String, Long>();
        String string2 = "df -i" + (bl2 ? " -l" : "");
        for (String string3 : ExecutingCommand.runNative(string2)) {
            if (!string3.startsWith("/") || (stringArray = ParseUtil.whitespaces.split(string3)).length <= 6) continue;
            hashMap2.put(stringArray[0], ParseUtil.parseLongOrDefault(stringArray[5], 0L));
            hashMap.put(stringArray[0], ParseUtil.parseLongOrDefault(stringArray[6], 0L));
        }
        for (String string3 : ExecutingCommand.runNative("mount -v")) {
            stringArray = ParseUtil.whitespaces.split(string3, 7);
            if (stringArray.length != 7) continue;
            String string4 = stringArray[0];
            String string5 = stringArray[1];
            String string6 = stringArray[3];
            String string7 = stringArray[5];
            String string8 = stringArray[6];
            if (bl2 && NETWORK_FS_TYPES.contains(string7) || !string6.equals("/") && (PSEUDO_FS_TYPES.contains(string7) || FileSystemUtil.isFileStoreExcluded(string6, string4, FS_PATH_INCLUDES, FS_PATH_EXCLUDES, FS_VOLUME_INCLUDES, FS_VOLUME_EXCLUDES))) continue;
            String string9 = string6.substring(string6.lastIndexOf(47) + 1);
            if (string9.isEmpty()) {
                string9 = string4.substring(string4.lastIndexOf(47) + 1);
            }
            if (string != null && !string.equals(string9)) continue;
            File file = new File(string6);
            long l2 = file.getTotalSpace();
            long l3 = file.getUsableSpace();
            long l4 = file.getFreeSpace();
            String string10 = string4.startsWith("/dev") || string6.equals("/") ? "Local Disk" : (string4.equals("tmpfs") ? "Ram Disk (dynamic)" : (string4.equals("mfs") ? "Ram Disk (fixed)" : (NETWORK_FS_TYPES.contains(string7) ? "Network Disk" : "Mount Point")));
            arrayList.add(new OpenBsdOSFileStore(string9, string4, string9, string6, string8, string5, "", string10, string7, l4, l3, l2, hashMap.getOrDefault(string4, 0L), hashMap2.getOrDefault(string4, 0L) + hashMap.getOrDefault(string4, 0L)));
        }
        return arrayList;
    }

    @Override
    public long getOpenFileDescriptors() {
        return OpenBsdSysctlUtil.sysctl("kern.nfiles", 0);
    }

    @Override
    public long getMaxFileDescriptors() {
        return OpenBsdSysctlUtil.sysctl("kern.maxfiles", 0);
    }
}

