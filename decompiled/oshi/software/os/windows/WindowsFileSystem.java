/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.windows;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.COM.WbemcliUtil;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.windows.perfmon.ProcessInformation;
import oshi.driver.windows.wmi.Win32LogicalDisk;
import oshi.software.common.AbstractFileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.windows.WindowsOSFileStore;
import oshi.util.ParseUtil;
import oshi.util.platform.windows.WmiUtil;

@ThreadSafe
public class WindowsFileSystem
extends AbstractFileSystem {
    private static final int BUFSIZE = 255;
    private static final int SEM_FAILCRITICALERRORS = 1;
    private static final int FILE_CASE_SENSITIVE_SEARCH = 1;
    private static final int FILE_CASE_PRESERVED_NAMES = 2;
    private static final int FILE_FILE_COMPRESSION = 16;
    private static final int FILE_DAX_VOLUME = 0x20000000;
    private static final int FILE_NAMED_STREAMS = 262144;
    private static final int FILE_PERSISTENT_ACLS = 8;
    private static final int FILE_READ_ONLY_VOLUME = 524288;
    private static final int FILE_SEQUENTIAL_WRITE_ONCE = 0x100000;
    private static final int FILE_SUPPORTS_ENCRYPTION = 131072;
    private static final int FILE_SUPPORTS_OBJECT_IDS = 65536;
    private static final int FILE_SUPPORTS_REPARSE_POINTS = 128;
    private static final int FILE_SUPPORTS_SPARSE_FILES = 64;
    private static final int FILE_SUPPORTS_TRANSACTIONS = 0x200000;
    private static final int FILE_SUPPORTS_USN_JOURNAL = 0x2000000;
    private static final int FILE_UNICODE_ON_DISK = 4;
    private static final int FILE_VOLUME_IS_COMPRESSED = 32768;
    private static final int FILE_VOLUME_QUOTAS = 32;
    private static final Map<Integer, String> OPTIONS_MAP = new HashMap<Integer, String>();
    private static final long MAX_WINDOWS_HANDLES;

    public WindowsFileSystem() {
        Kernel32.INSTANCE.SetErrorMode(1);
    }

    @Override
    public List<OSFileStore> getFileStores(boolean bl2) {
        ArrayList<OSFileStore> arrayList = WindowsFileSystem.getLocalVolumes(null);
        HashMap<String, OSFileStore> hashMap = new HashMap<String, OSFileStore>();
        for (OSFileStore oSFileStore : arrayList) {
            hashMap.put(oSFileStore.getMount(), oSFileStore);
        }
        for (OSFileStore oSFileStore : WindowsFileSystem.getWmiVolumes(null, bl2)) {
            if (hashMap.containsKey(oSFileStore.getMount())) {
                OSFileStore oSFileStore2 = (OSFileStore)hashMap.get(oSFileStore.getMount());
                arrayList.remove(oSFileStore2);
                arrayList.add(new WindowsOSFileStore(oSFileStore.getName(), oSFileStore2.getVolume(), oSFileStore2.getLabel().isEmpty() ? oSFileStore.getLabel() : oSFileStore2.getLabel(), oSFileStore2.getMount(), oSFileStore2.getOptions(), oSFileStore2.getUUID(), "", oSFileStore2.getDescription(), oSFileStore2.getType(), oSFileStore2.getFreeSpace(), oSFileStore2.getUsableSpace(), oSFileStore2.getTotalSpace(), 0L, 0L));
                continue;
            }
            if (bl2) continue;
            arrayList.add(oSFileStore);
        }
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static ArrayList<OSFileStore> getLocalVolumes(String string) {
        ArrayList<OSFileStore> arrayList = new ArrayList<OSFileStore>();
        char[] cArray = new char[255];
        WinNT.HANDLE hANDLE = Kernel32.INSTANCE.FindFirstVolume(cArray, 255);
        if (WinBase.INVALID_HANDLE_VALUE.equals(hANDLE)) {
            return arrayList;
        }
        try {
            do {
                char[] cArray2 = new char[16];
                char[] cArray3 = new char[255];
                char[] cArray4 = new char[255];
                IntByReference intByReference = new IntByReference();
                WinNT.LARGE_INTEGER lARGE_INTEGER = new WinNT.LARGE_INTEGER(0L);
                WinNT.LARGE_INTEGER lARGE_INTEGER2 = new WinNT.LARGE_INTEGER(0L);
                WinNT.LARGE_INTEGER lARGE_INTEGER3 = new WinNT.LARGE_INTEGER(0L);
                String string2 = Native.toString(cArray);
                Kernel32.INSTANCE.GetVolumeInformation(string2, cArray3, 255, null, null, intByReference, cArray2, 16);
                int n2 = intByReference.getValue();
                Kernel32.INSTANCE.GetVolumePathNamesForVolumeName(string2, cArray4, 255, null);
                String string3 = Native.toString(cArray4);
                if (string3.isEmpty() || string != null && !string.equals(string2)) continue;
                String string4 = Native.toString(cArray3);
                String string5 = Native.toString(cArray2);
                StringBuilder stringBuilder = new StringBuilder((0x80000 & n2) == 0 ? "rw" : "ro");
                String string6 = OPTIONS_MAP.entrySet().stream().filter(entry -> ((Integer)entry.getKey() & n2) > 0).map(Map.Entry::getValue).collect(Collectors.joining(","));
                if (!string6.isEmpty()) {
                    stringBuilder.append(',').append(string6);
                }
                Kernel32.INSTANCE.GetDiskFreeSpaceEx(string2, lARGE_INTEGER, lARGE_INTEGER2, lARGE_INTEGER3);
                String string7 = ParseUtil.parseUuidOrDefault(string2, "");
                arrayList.add(new WindowsOSFileStore(String.format("%s (%s)", string4, string3), string2, string4, string3, stringBuilder.toString(), string7, "", WindowsFileSystem.getDriveType(string3), string5, lARGE_INTEGER3.getValue(), lARGE_INTEGER.getValue(), lARGE_INTEGER2.getValue(), 0L, 0L));
            } while (Kernel32.INSTANCE.FindNextVolume(hANDLE, cArray, 255));
            ArrayList<OSFileStore> arrayList2 = arrayList;
            return arrayList2;
        }
        finally {
            Kernel32.INSTANCE.FindVolumeClose(hANDLE);
        }
    }

    static List<OSFileStore> getWmiVolumes(String string, boolean bl2) {
        ArrayList<OSFileStore> arrayList = new ArrayList<OSFileStore>();
        WbemcliUtil.WmiResult<Win32LogicalDisk.LogicalDiskProperty> wmiResult = Win32LogicalDisk.queryLogicalDisk(string, bl2);
        for (int i2 = 0; i2 < wmiResult.getResultCount(); ++i2) {
            String string2;
            Object[] objectArray;
            long l2 = WmiUtil.getUint64(wmiResult, Win32LogicalDisk.LogicalDiskProperty.FREESPACE, i2);
            long l3 = WmiUtil.getUint64(wmiResult, Win32LogicalDisk.LogicalDiskProperty.SIZE, i2);
            Object object = WmiUtil.getString(wmiResult, Win32LogicalDisk.LogicalDiskProperty.DESCRIPTION, i2);
            String string3 = WmiUtil.getString(wmiResult, Win32LogicalDisk.LogicalDiskProperty.NAME, i2);
            String string4 = WmiUtil.getString(wmiResult, Win32LogicalDisk.LogicalDiskProperty.VOLUMENAME, i2);
            String string5 = WmiUtil.getUint16(wmiResult, Win32LogicalDisk.LogicalDiskProperty.ACCESS, i2) == 1 ? "ro" : "rw";
            int n2 = WmiUtil.getUint32(wmiResult, Win32LogicalDisk.LogicalDiskProperty.DRIVETYPE, i2);
            if (n2 != 4) {
                objectArray = new char[255];
                Kernel32.INSTANCE.GetVolumeNameForVolumeMountPoint(string3 + "\\", (char[])objectArray, 255);
                string2 = Native.toString(objectArray);
            } else {
                string2 = WmiUtil.getString(wmiResult, Win32LogicalDisk.LogicalDiskProperty.PROVIDERNAME, i2);
                objectArray = string2.split("\\\\");
                if (objectArray.length > 1 && objectArray[objectArray.length - 1].length() > 0) {
                    object = objectArray[objectArray.length - 1];
                }
            }
            arrayList.add(new WindowsOSFileStore(String.format("%s (%s)", object, string3), string2, string4, string3 + "\\", string5, "", "", WindowsFileSystem.getDriveType(string3), WmiUtil.getString(wmiResult, Win32LogicalDisk.LogicalDiskProperty.FILESYSTEM, i2), l2, l2, l3, 0L, 0L));
        }
        return arrayList;
    }

    private static String getDriveType(String string) {
        switch (Kernel32.INSTANCE.GetDriveType(string)) {
            case 2: {
                return "Removable drive";
            }
            case 3: {
                return "Fixed drive";
            }
            case 4: {
                return "Network drive";
            }
            case 5: {
                return "CD-ROM";
            }
            case 6: {
                return "RAM drive";
            }
        }
        return "Unknown drive type";
    }

    @Override
    public long getOpenFileDescriptors() {
        Map<ProcessInformation.HandleCountProperty, List<Long>> map = ProcessInformation.queryHandles().getB();
        List<Long> list = map.get(ProcessInformation.HandleCountProperty.HANDLECOUNT);
        long l2 = 0L;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                l2 += list.get(i2).longValue();
            }
        }
        return l2;
    }

    @Override
    public long getMaxFileDescriptors() {
        return MAX_WINDOWS_HANDLES;
    }

    static {
        OPTIONS_MAP.put(2, "casepn");
        OPTIONS_MAP.put(1, "casess");
        OPTIONS_MAP.put(16, "fcomp");
        OPTIONS_MAP.put(0x20000000, "dax");
        OPTIONS_MAP.put(262144, "streams");
        OPTIONS_MAP.put(8, "acls");
        OPTIONS_MAP.put(0x100000, "wronce");
        OPTIONS_MAP.put(131072, "efs");
        OPTIONS_MAP.put(65536, "oids");
        OPTIONS_MAP.put(128, "reparse");
        OPTIONS_MAP.put(64, "sparse");
        OPTIONS_MAP.put(0x200000, "trans");
        OPTIONS_MAP.put(0x2000000, "journaled");
        OPTIONS_MAP.put(4, "unicode");
        OPTIONS_MAP.put(32768, "vcomp");
        OPTIONS_MAP.put(32, "quota");
        MAX_WINDOWS_HANDLES = System.getenv("ProgramFiles(x86)") == null ? 0xFF8000L : 0xFF0000L;
    }
}

