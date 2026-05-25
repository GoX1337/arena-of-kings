/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.mac;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.mac.CoreFoundation;
import com.sun.jna.platform.mac.DiskArbitration;
import com.sun.jna.platform.mac.IOKit;
import com.sun.jna.platform.mac.IOKitUtil;
import com.sun.jna.platform.mac.SystemB;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractFileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.mac.MacOSFileStore;
import oshi.util.FileSystemUtil;
import oshi.util.platform.mac.CFUtil;
import oshi.util.platform.mac.SysctlUtil;

@ThreadSafe
public class MacFileSystem
extends AbstractFileSystem {
    private static final Logger LOG = LoggerFactory.getLogger(MacFileSystem.class);
    public static final String OSHI_MAC_FS_PATH_EXCLUDES = "oshi.os.mac.filesystem.path.excludes";
    public static final String OSHI_MAC_FS_PATH_INCLUDES = "oshi.os.mac.filesystem.path.includes";
    public static final String OSHI_MAC_FS_VOLUME_EXCLUDES = "oshi.os.mac.filesystem.volume.excludes";
    public static final String OSHI_MAC_FS_VOLUME_INCLUDES = "oshi.os.mac.filesystem.volume.includes";
    private static final List<PathMatcher> FS_PATH_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.mac.filesystem.path.excludes");
    private static final List<PathMatcher> FS_PATH_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.mac.filesystem.path.includes");
    private static final List<PathMatcher> FS_VOLUME_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.mac.filesystem.volume.excludes");
    private static final List<PathMatcher> FS_VOLUME_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.mac.filesystem.volume.includes");
    private static final Pattern LOCAL_DISK = Pattern.compile("/dev/disk\\d");
    private static final int MNT_RDONLY = 1;
    private static final int MNT_SYNCHRONOUS = 2;
    private static final int MNT_NOEXEC = 4;
    private static final int MNT_NOSUID = 8;
    private static final int MNT_NODEV = 16;
    private static final int MNT_UNION = 32;
    private static final int MNT_ASYNC = 64;
    private static final int MNT_CPROTECT = 128;
    private static final int MNT_EXPORTED = 256;
    private static final int MNT_QUARANTINE = 1024;
    private static final int MNT_LOCAL = 4096;
    private static final int MNT_QUOTA = 8192;
    private static final int MNT_ROOTFS = 16384;
    private static final int MNT_DOVOLFS = 32768;
    private static final int MNT_DONTBROWSE = 0x100000;
    private static final int MNT_IGNORE_OWNERSHIP = 0x200000;
    private static final int MNT_AUTOMOUNTED = 0x400000;
    private static final int MNT_JOURNALED = 0x800000;
    private static final int MNT_NOUSERXATTR = 0x1000000;
    private static final int MNT_DEFWRITE = 0x2000000;
    private static final int MNT_MULTILABEL = 0x4000000;
    private static final int MNT_NOATIME = 0x10000000;
    private static final Map<Integer, String> OPTIONS_MAP = new HashMap<Integer, String>();

    @Override
    public List<OSFileStore> getFileStores(boolean bl2) {
        return MacFileSystem.getFileStoreMatching(null, bl2);
    }

    static List<OSFileStore> getFileStoreMatching(String string) {
        return MacFileSystem.getFileStoreMatching(string, false);
    }

    private static List<OSFileStore> getFileStoreMatching(String string, boolean bl2) {
        ArrayList<OSFileStore> arrayList = new ArrayList<OSFileStore>();
        int n2 = SystemB.INSTANCE.getfsstat64(null, 0, 0);
        if (n2 > 0) {
            DiskArbitration.DASessionRef dASessionRef = DiskArbitration.INSTANCE.DASessionCreate(CoreFoundation.INSTANCE.CFAllocatorGetDefault());
            if (dASessionRef == null) {
                LOG.error("Unable to open session to DiskArbitration framework.");
            } else {
                CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString("DAVolumeName");
                SystemB.Statfs[] statfsArray = new SystemB.Statfs[n2];
                n2 = SystemB.INSTANCE.getfsstat64(statfsArray, n2 * new SystemB.Statfs().size(), 16);
                for (int i2 = 0; i2 < n2; ++i2) {
                    String string2 = Native.toString(statfsArray[i2].f_mntfromname, StandardCharsets.UTF_8);
                    String string3 = Native.toString(statfsArray[i2].f_mntonname, StandardCharsets.UTF_8);
                    String string4 = Native.toString(statfsArray[i2].f_fstypename, StandardCharsets.UTF_8);
                    int n3 = statfsArray[i2].f_flags;
                    if (bl2 && (n3 & 0x1000) == 0 || !string3.equals("/") && (PSEUDO_FS_TYPES.contains(string4) || FileSystemUtil.isFileStoreExcluded(string3, string2, FS_PATH_INCLUDES, FS_PATH_EXCLUDES, FS_VOLUME_INCLUDES, FS_VOLUME_EXCLUDES))) continue;
                    String string5 = "Volume";
                    if (LOCAL_DISK.matcher(string2).matches()) {
                        string5 = "Local Disk";
                    } else if (string2.startsWith("localhost:") || string2.startsWith("//") || string2.startsWith("smb://") || NETWORK_FS_TYPES.contains(string4)) {
                        string5 = "Network Drive";
                    }
                    File file = new File(string3);
                    String string6 = file.getName();
                    if (string6.isEmpty()) {
                        string6 = file.getPath();
                    }
                    if (string != null && !string.equals(string6)) continue;
                    StringBuilder stringBuilder = new StringBuilder((1 & n3) == 0 ? "rw" : "ro");
                    String string7 = OPTIONS_MAP.entrySet().stream().filter(entry -> ((Integer)entry.getKey() & n3) > 0).map(Map.Entry::getValue).collect(Collectors.joining(","));
                    if (!string7.isEmpty()) {
                        stringBuilder.append(',').append(string7);
                    }
                    String string8 = "";
                    String string9 = string2.replace("/dev/disk", "disk");
                    if (string9.startsWith("disk")) {
                        Object object;
                        CoreFoundation.CFDictionaryRef cFDictionaryRef;
                        DiskArbitration.DADiskRef dADiskRef = DiskArbitration.INSTANCE.DADiskCreateFromBSDName(CoreFoundation.INSTANCE.CFAllocatorGetDefault(), dASessionRef, string2);
                        if (dADiskRef != null) {
                            cFDictionaryRef = DiskArbitration.INSTANCE.DADiskCopyDescription(dADiskRef);
                            if (cFDictionaryRef != null) {
                                object = cFDictionaryRef.getValue(cFStringRef);
                                string6 = CFUtil.cfPointerToString((Pointer)object);
                                cFDictionaryRef.release();
                            }
                            dADiskRef.release();
                        }
                        if ((cFDictionaryRef = IOKitUtil.getBSDNameMatchingDict(string9)) != null && (object = IOKitUtil.getMatchingServices(cFDictionaryRef)) != null) {
                            IOKit.IORegistryEntry iORegistryEntry = ((IOKit.IOIterator)object).next();
                            if (iORegistryEntry != null && iORegistryEntry.conformsTo("IOMedia")) {
                                string8 = iORegistryEntry.getStringProperty("UUID");
                                if (string8 != null) {
                                    string8 = string8.toLowerCase();
                                }
                                iORegistryEntry.release();
                            }
                            ((IOKit.IOObject)object).release();
                        }
                    }
                    arrayList.add(new MacOSFileStore(string6, string2, string6, string3, stringBuilder.toString(), string8 == null ? "" : string8, "", string5, string4, file.getFreeSpace(), file.getUsableSpace(), file.getTotalSpace(), statfsArray[i2].f_ffree, statfsArray[i2].f_files));
                }
                cFStringRef.release();
                dASessionRef.release();
            }
        }
        return arrayList;
    }

    @Override
    public long getOpenFileDescriptors() {
        return SysctlUtil.sysctl("kern.num_files", 0);
    }

    @Override
    public long getMaxFileDescriptors() {
        return SysctlUtil.sysctl("kern.maxfiles", 0);
    }

    static {
        OPTIONS_MAP.put(2, "synchronous");
        OPTIONS_MAP.put(4, "noexec");
        OPTIONS_MAP.put(8, "nosuid");
        OPTIONS_MAP.put(16, "nodev");
        OPTIONS_MAP.put(32, "union");
        OPTIONS_MAP.put(64, "asynchronous");
        OPTIONS_MAP.put(128, "content-protection");
        OPTIONS_MAP.put(256, "exported");
        OPTIONS_MAP.put(1024, "quarantined");
        OPTIONS_MAP.put(4096, "local");
        OPTIONS_MAP.put(8192, "quotas");
        OPTIONS_MAP.put(16384, "rootfs");
        OPTIONS_MAP.put(32768, "volfs");
        OPTIONS_MAP.put(0x100000, "nobrowse");
        OPTIONS_MAP.put(0x200000, "noowners");
        OPTIONS_MAP.put(0x400000, "automounted");
        OPTIONS_MAP.put(0x800000, "journaled");
        OPTIONS_MAP.put(0x1000000, "nouserxattr");
        OPTIONS_MAP.put(0x2000000, "defwrite");
        OPTIONS_MAP.put(0x4000000, "multilabel");
        OPTIONS_MAP.put(0x10000000, "noatime");
    }
}

