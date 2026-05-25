/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.solaris;

import com.sun.jna.platform.unix.solaris.LibKstat;
import java.io.File;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractFileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.unix.solaris.SolarisOSFileStore;
import oshi.util.ExecutingCommand;
import oshi.util.FileSystemUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.solaris.KstatUtil;

@ThreadSafe
public class SolarisFileSystem
extends AbstractFileSystem {
    public static final String OSHI_SOLARIS_FS_PATH_EXCLUDES = "oshi.os.solaris.filesystem.path.excludes";
    public static final String OSHI_SOLARIS_FS_PATH_INCLUDES = "oshi.os.solaris.filesystem.path.includes";
    public static final String OSHI_SOLARIS_FS_VOLUME_EXCLUDES = "oshi.os.solaris.filesystem.volume.excludes";
    public static final String OSHI_SOLARIS_FS_VOLUME_INCLUDES = "oshi.os.solaris.filesystem.volume.includes";
    private static final List<PathMatcher> FS_PATH_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.solaris.filesystem.path.excludes");
    private static final List<PathMatcher> FS_PATH_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.solaris.filesystem.path.includes");
    private static final List<PathMatcher> FS_VOLUME_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.solaris.filesystem.volume.excludes");
    private static final List<PathMatcher> FS_VOLUME_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.solaris.filesystem.volume.includes");

    @Override
    public List<OSFileStore> getFileStores(boolean bl2) {
        return SolarisFileSystem.getFileStoreMatching(null, bl2);
    }

    static List<OSFileStore> getFileStoreMatching(String string) {
        return SolarisFileSystem.getFileStoreMatching(string, false);
    }

    private static List<OSFileStore> getFileStoreMatching(String string, boolean bl2) {
        ArrayList<OSFileStore> arrayList = new ArrayList<OSFileStore>();
        HashMap<String, Long> hashMap = new HashMap<String, Long>();
        HashMap<String, Long> hashMap2 = new HashMap<String, Long>();
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = "df -g" + (bl2 ? " -l" : "");
        for (String string6 : ExecutingCommand.runNative(string5)) {
            if (string6.startsWith("/")) {
                string2 = ParseUtil.whitespaces.split(string6)[0];
                string3 = null;
                continue;
            }
            if (string6.contains("available") && string6.contains("total files")) {
                string3 = ParseUtil.getTextBetweenStrings(string6, "available", "total files").trim();
                continue;
            }
            if (!string6.contains("free files")) continue;
            string4 = ParseUtil.getTextBetweenStrings(string6, "", "free files").trim();
            if (string2 == null || string3 == null) continue;
            hashMap.put(string2, ParseUtil.parseLongOrDefault(string4, 0L));
            hashMap2.put(string2, ParseUtil.parseLongOrDefault(string3, 0L));
            string2 = null;
        }
        for (String string6 : ExecutingCommand.runNative("cat /etc/mnttab")) {
            String[] stringArray = ParseUtil.whitespaces.split(string6);
            if (stringArray.length < 5) continue;
            String string7 = stringArray[0];
            String string8 = stringArray[1];
            String string9 = stringArray[2];
            String string10 = stringArray[3];
            if (bl2 && NETWORK_FS_TYPES.contains(string9) || !string8.equals("/") && (PSEUDO_FS_TYPES.contains(string9) || FileSystemUtil.isFileStoreExcluded(string8, string7, FS_PATH_INCLUDES, FS_PATH_EXCLUDES, FS_VOLUME_INCLUDES, FS_VOLUME_EXCLUDES))) continue;
            String string11 = string8.substring(string8.lastIndexOf(47) + 1);
            if (string11.isEmpty()) {
                string11 = string7.substring(string7.lastIndexOf(47) + 1);
            }
            if (string != null && !string.equals(string11)) continue;
            File file = new File(string8);
            long l2 = file.getTotalSpace();
            long l3 = file.getUsableSpace();
            long l4 = file.getFreeSpace();
            String string12 = string7.startsWith("/dev") || string8.equals("/") ? "Local Disk" : (string7.equals("tmpfs") ? "Ram Disk" : (NETWORK_FS_TYPES.contains(string9) ? "Network Disk" : "Mount Point"));
            arrayList.add(new SolarisOSFileStore(string11, string7, string11, string8, string10, "", "", string12, string9, l4, l3, l2, hashMap.containsKey(string8) ? (Long)hashMap.get(string8) : 0L, hashMap2.containsKey(string8) ? (Long)hashMap2.get(string8) : 0L));
        }
        return arrayList;
    }

    @Override
    public long getOpenFileDescriptors() {
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup(null, -1, "file_cache");
            if (kstat != null && KstatUtil.KstatChain.read(kstat)) {
                long l2 = KstatUtil.dataLookupLong(kstat, "buf_inuse");
                return l2;
            }
        }
        return 0L;
    }

    @Override
    public long getMaxFileDescriptors() {
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup(null, -1, "file_cache");
            if (kstat != null && KstatUtil.KstatChain.read(kstat)) {
                long l2 = KstatUtil.dataLookupLong(kstat, "buf_max");
                return l2;
            }
        }
        return 0L;
    }
}

