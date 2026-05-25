/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.linux;

import com.sun.jna.Native;
import com.sun.jna.platform.linux.LibC;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractFileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.linux.LinuxOSFileStore;
import oshi.util.ExecutingCommand;
import oshi.util.FileSystemUtil;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.linux.ProcPath;

@ThreadSafe
public class LinuxFileSystem
extends AbstractFileSystem {
    private static final Logger LOG = LoggerFactory.getLogger(LinuxFileSystem.class);
    public static final String OSHI_LINUX_FS_PATH_EXCLUDES = "oshi.os.linux.filesystem.path.excludes";
    public static final String OSHI_LINUX_FS_PATH_INCLUDES = "oshi.os.linux.filesystem.path.includes";
    public static final String OSHI_LINUX_FS_VOLUME_EXCLUDES = "oshi.os.linux.filesystem.volume.excludes";
    public static final String OSHI_LINUX_FS_VOLUME_INCLUDES = "oshi.os.linux.filesystem.volume.includes";
    private static final List<PathMatcher> FS_PATH_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.linux.filesystem.path.excludes");
    private static final List<PathMatcher> FS_PATH_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.linux.filesystem.path.includes");
    private static final List<PathMatcher> FS_VOLUME_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.linux.filesystem.volume.excludes");
    private static final List<PathMatcher> FS_VOLUME_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.linux.filesystem.volume.includes");
    private static final String UNICODE_SPACE = "\\040";

    @Override
    public List<OSFileStore> getFileStores(boolean bl2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        File file = new File("/dev/mapper");
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            for (File fileArray2 : fileArray) {
                try {
                    hashMap.put(fileArray2.getCanonicalPath(), fileArray2.getAbsolutePath());
                }
                catch (IOException iOException) {
                    LOG.error("Couldn't get canonical path for {}. {}", (Object)fileArray2.getName(), (Object)iOException.getMessage());
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        File file2 = new File("/dev/disk/by-uuid");
        File[] fileArray3 = file2.listFiles();
        if (fileArray3 != null) {
            for (File file3 : fileArray3) {
                try {
                    String iOException = file3.getCanonicalPath();
                    hashMap2.put(iOException, file3.getName().toLowerCase());
                    if (!hashMap.containsKey(iOException)) continue;
                    hashMap2.put((String)hashMap.get(iOException), file3.getName().toLowerCase());
                }
                catch (IOException iOException) {
                    LOG.error("Couldn't get canonical path for {}. {}", (Object)file3.getName(), (Object)iOException.getMessage());
                }
            }
        }
        return LinuxFileSystem.getFileStoreMatching(null, hashMap2, bl2);
    }

    static List<OSFileStore> getFileStoreMatching(String string, Map<String, String> map) {
        return LinuxFileSystem.getFileStoreMatching(string, map, false);
    }

    private static List<OSFileStore> getFileStoreMatching(String string, Map<String, String> map, boolean bl2) {
        ArrayList<OSFileStore> arrayList = new ArrayList<OSFileStore>();
        Map<String, String> map2 = LinuxFileSystem.queryLabelMap();
        List<String> list = FileUtil.readFile(ProcPath.MOUNTS);
        for (String string2 : list) {
            Object object;
            String string3;
            String string4;
            String[] stringArray = string2.split(" ");
            if (stringArray.length < 6) continue;
            String string5 = string4 = stringArray[0].replace(UNICODE_SPACE, " ");
            String string6 = stringArray[1].replace(UNICODE_SPACE, " ");
            if (string6.equals("/")) {
                string5 = "/";
            }
            String string7 = stringArray[2];
            if (bl2 && NETWORK_FS_TYPES.contains(string7) || !string6.equals("/") && (PSEUDO_FS_TYPES.contains(string7) || FileSystemUtil.isFileStoreExcluded(string6, string4, FS_PATH_INCLUDES, FS_PATH_EXCLUDES, FS_VOLUME_INCLUDES, FS_VOLUME_EXCLUDES))) continue;
            String string8 = stringArray[3];
            if (string != null && !string.equals(string5)) continue;
            String string9 = string3 = map != null ? map.getOrDefault(stringArray[0], "") : "";
            String string10 = string4.startsWith("/dev") ? "Local Disk" : (string4.equals("tmpfs") ? "Ram Disk" : (NETWORK_FS_TYPES.contains(string7) ? "Network Disk" : "Mount Point"));
            String string11 = "";
            String string12 = "/dev/mapper/";
            Path path = Paths.get(string4, new String[0]);
            if (path.toFile().exists() && Files.isSymbolicLink(path)) {
                try {
                    Path path2 = Files.readSymbolicLink(path);
                    Path path3 = Paths.get(string12 + path2.toString(), new String[0]);
                    if (path3.toFile().exists()) {
                        string11 = path3.normalize().toString();
                    }
                }
                catch (IOException iOException) {
                    LOG.warn("Couldn't access symbolic path  {}. {}", (Object)path, (Object)iOException.getMessage());
                }
            }
            long l2 = 0L;
            long l3 = 0L;
            long l4 = 0L;
            long l5 = 0L;
            long l6 = 0L;
            try {
                object = new LibC.Statvfs();
                if (0 == LibC.INSTANCE.statvfs(string6, (LibC.Statvfs)object)) {
                    l2 = ((LibC.Statvfs)object).f_files.longValue();
                    l3 = ((LibC.Statvfs)object).f_ffree.longValue();
                    l4 = ((LibC.Statvfs)object).f_blocks.longValue() * ((LibC.Statvfs)object).f_frsize.longValue();
                    l5 = ((LibC.Statvfs)object).f_bavail.longValue() * ((LibC.Statvfs)object).f_frsize.longValue();
                    l6 = ((LibC.Statvfs)object).f_bfree.longValue() * ((LibC.Statvfs)object).f_frsize.longValue();
                } else {
                    LOG.warn("Failed to get information to use statvfs. path: {}, Error code: {}", (Object)string6, (Object)Native.getLastError());
                }
            }
            catch (NoClassDefFoundError | UnsatisfiedLinkError linkageError) {
                LOG.error("Failed to get file counts from statvfs. {}", (Object)linkageError.getMessage());
            }
            if (l4 == 0L) {
                object = new File(string6);
                l4 = ((File)object).getTotalSpace();
                l5 = ((File)object).getUsableSpace();
                l6 = ((File)object).getFreeSpace();
            }
            arrayList.add(new LinuxOSFileStore(string5, string4, map2.getOrDefault(string6, string5), string6, string8, string3, string11, string10, string7, l6, l5, l4, l3, l2));
        }
        return arrayList;
    }

    private static Map<String, String> queryLabelMap() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (String string : ExecutingCommand.runNative("lsblk -o mountpoint,label")) {
            String[] stringArray = ParseUtil.whitespaces.split(string, 2);
            if (stringArray.length != 2) continue;
            hashMap.put(stringArray[0], stringArray[1]);
        }
        return hashMap;
    }

    @Override
    public long getOpenFileDescriptors() {
        return LinuxFileSystem.getFileDescriptors(0);
    }

    @Override
    public long getMaxFileDescriptors() {
        return LinuxFileSystem.getFileDescriptors(2);
    }

    private static long getFileDescriptors(int n2) {
        String string = ProcPath.SYS_FS_FILE_NR;
        if (n2 < 0 || n2 > 2) {
            throw new IllegalArgumentException("Index must be between 0 and 2.");
        }
        List<String> list = FileUtil.readFile(string);
        if (!list.isEmpty()) {
            String[] stringArray = list.get(0).split("\\D+");
            return ParseUtil.parseLongOrDefault(stringArray[n2], 0L);
        }
        return 0L;
    }
}

