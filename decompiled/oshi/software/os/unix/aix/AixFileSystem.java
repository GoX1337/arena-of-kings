/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.aix;

import java.io.File;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractFileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.unix.aix.AixOSFileStore;
import oshi.util.ExecutingCommand;
import oshi.util.FileSystemUtil;
import oshi.util.ParseUtil;

@ThreadSafe
public class AixFileSystem
extends AbstractFileSystem {
    public static final String OSHI_AIX_FS_PATH_EXCLUDES = "oshi.os.aix.filesystem.path.excludes";
    public static final String OSHI_AIX_FS_PATH_INCLUDES = "oshi.os.aix.filesystem.path.includes";
    public static final String OSHI_AIX_FS_VOLUME_EXCLUDES = "oshi.os.aix.filesystem.volume.excludes";
    public static final String OSHI_AIX_FS_VOLUME_INCLUDES = "oshi.os.aix.filesystem.volume.includes";
    private static final List<PathMatcher> FS_PATH_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.aix.filesystem.path.excludes");
    private static final List<PathMatcher> FS_PATH_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.aix.filesystem.path.includes");
    private static final List<PathMatcher> FS_VOLUME_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.aix.filesystem.volume.excludes");
    private static final List<PathMatcher> FS_VOLUME_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.aix.filesystem.volume.includes");

    @Override
    public List<OSFileStore> getFileStores(boolean bl2) {
        return AixFileSystem.getFileStoreMatching(null, bl2);
    }

    static List<OSFileStore> getFileStoreMatching(String string) {
        return AixFileSystem.getFileStoreMatching(string, false);
    }

    private static List<OSFileStore> getFileStoreMatching(String string, boolean bl2) {
        String[] stringArray;
        ArrayList<OSFileStore> arrayList = new ArrayList<OSFileStore>();
        HashMap<String, Long> hashMap = new HashMap<String, Long>();
        HashMap<String, Long> hashMap2 = new HashMap<String, Long>();
        String string2 = "df -i" + (bl2 ? " -l" : "");
        for (String string3 : ExecutingCommand.runNative(string2)) {
            if (!string3.startsWith("/") || (stringArray = ParseUtil.whitespaces.split(string3)).length <= 5) continue;
            hashMap2.put(stringArray[0], ParseUtil.parseLongOrDefault(stringArray[1], 0L));
            hashMap.put(stringArray[0], ParseUtil.parseLongOrDefault(stringArray[3], 0L));
        }
        for (String string3 : ExecutingCommand.runNative("mount")) {
            stringArray = ParseUtil.whitespaces.split("x" + string3);
            if (stringArray.length <= 7) continue;
            String string4 = stringArray[1];
            String string5 = stringArray[2];
            String string6 = stringArray[3];
            String string7 = stringArray[4];
            if (bl2 && NETWORK_FS_TYPES.contains(string6) || !string5.equals("/") && (PSEUDO_FS_TYPES.contains(string6) || FileSystemUtil.isFileStoreExcluded(string5, string4, FS_PATH_INCLUDES, FS_PATH_EXCLUDES, FS_VOLUME_INCLUDES, FS_VOLUME_EXCLUDES))) continue;
            String string8 = string5.substring(string5.lastIndexOf(47) + 1);
            if (string8.isEmpty()) {
                string8 = string4.substring(string4.lastIndexOf(47) + 1);
            }
            if (string != null && !string.equals(string8)) continue;
            File file = new File(string5);
            long l2 = file.getTotalSpace();
            long l3 = file.getUsableSpace();
            long l4 = file.getFreeSpace();
            String string9 = string4.startsWith("/dev") || string5.equals("/") ? "Local Disk" : (string4.equals("tmpfs") ? "Ram Disk" : (NETWORK_FS_TYPES.contains(string6) ? "Network Disk" : "Mount Point"));
            arrayList.add(new AixOSFileStore(string8, string4, string8, string5, string7, "", "", string9, string6, l4, l3, l2, hashMap.getOrDefault(string4, 0L), hashMap2.getOrDefault(string4, 0L)));
        }
        return arrayList;
    }

    @Override
    public long getOpenFileDescriptors() {
        boolean bl2 = false;
        long l2 = 0L;
        for (String string : ExecutingCommand.runNative("lsof -nl")) {
            if (!bl2) {
                bl2 = string.startsWith("COMMAND");
                continue;
            }
            ++l2;
        }
        return l2;
    }

    @Override
    public long getMaxFileDescriptors() {
        return ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("ulimit -n"), 0L);
    }
}

