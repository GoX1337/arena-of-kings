/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.registry;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.COM.WbemcliUtil;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.VersionHelpers;
import com.sun.jna.platform.win32.Wtsapi32;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.Immutable;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.windows.wmi.Win32Process;
import oshi.util.platform.windows.WmiUtil;

@ThreadSafe
public final class ProcessWtsData {
    private static final Logger LOG = LoggerFactory.getLogger(ProcessWtsData.class);
    private static final boolean IS_WINDOWS7_OR_GREATER = VersionHelpers.IsWindows7OrGreater();

    private ProcessWtsData() {
    }

    public static Map<Integer, WtsInfo> queryProcessWtsMap(Collection<Integer> collection) {
        if (IS_WINDOWS7_OR_GREATER) {
            return ProcessWtsData.queryProcessWtsMapFromWTS(collection);
        }
        return ProcessWtsData.queryProcessWtsMapFromPerfMon(collection);
    }

    private static Map<Integer, WtsInfo> queryProcessWtsMapFromWTS(Collection<Integer> collection) {
        HashMap<Integer, WtsInfo> hashMap = new HashMap<Integer, WtsInfo>();
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference(0);
        if (!Wtsapi32.INSTANCE.WTSEnumerateProcessesEx(Wtsapi32.WTS_CURRENT_SERVER_HANDLE, new IntByReference(1), -2, pointerByReference, intByReference)) {
            LOG.error("Failed to enumerate Processes. Error code: {}", (Object)Kernel32.INSTANCE.GetLastError());
            return hashMap;
        }
        Pointer pointer = pointerByReference.getValue();
        Wtsapi32.WTS_PROCESS_INFO_EX wTS_PROCESS_INFO_EX = new Wtsapi32.WTS_PROCESS_INFO_EX(pointer);
        Wtsapi32.WTS_PROCESS_INFO_EX[] wTS_PROCESS_INFO_EXArray = (Wtsapi32.WTS_PROCESS_INFO_EX[])wTS_PROCESS_INFO_EX.com_sun_jna_Structure_arr_toArray(intByReference.getValue());
        for (int i2 = 0; i2 < wTS_PROCESS_INFO_EXArray.length; ++i2) {
            if (collection != null && !collection.contains(wTS_PROCESS_INFO_EXArray[i2].ProcessId)) continue;
            hashMap.put(wTS_PROCESS_INFO_EXArray[i2].ProcessId, new WtsInfo(wTS_PROCESS_INFO_EXArray[i2].pProcessName, "", wTS_PROCESS_INFO_EXArray[i2].NumberOfThreads, (long)wTS_PROCESS_INFO_EXArray[i2].PagefileUsage & 0xFFFFFFFFL, wTS_PROCESS_INFO_EXArray[i2].KernelTime.getValue() / 10000L, wTS_PROCESS_INFO_EXArray[i2].UserTime.getValue() / 10000L, wTS_PROCESS_INFO_EXArray[i2].HandleCount));
        }
        if (!Wtsapi32.INSTANCE.WTSFreeMemoryEx(1, pointer, intByReference.getValue())) {
            LOG.warn("Failed to Free Memory for Processes. Error code: {}", (Object)Kernel32.INSTANCE.GetLastError());
        }
        return hashMap;
    }

    private static Map<Integer, WtsInfo> queryProcessWtsMapFromPerfMon(Collection<Integer> collection) {
        HashMap<Integer, WtsInfo> hashMap = new HashMap<Integer, WtsInfo>();
        WbemcliUtil.WmiResult<Win32Process.ProcessXPProperty> wmiResult = Win32Process.queryProcesses(collection);
        for (int i2 = 0; i2 < wmiResult.getResultCount(); ++i2) {
            hashMap.put(WmiUtil.getUint32(wmiResult, Win32Process.ProcessXPProperty.PROCESSID, i2), new WtsInfo(WmiUtil.getString(wmiResult, Win32Process.ProcessXPProperty.NAME, i2), WmiUtil.getString(wmiResult, Win32Process.ProcessXPProperty.EXECUTABLEPATH, i2), WmiUtil.getUint32(wmiResult, Win32Process.ProcessXPProperty.THREADCOUNT, i2), 1024L * ((long)WmiUtil.getUint32(wmiResult, Win32Process.ProcessXPProperty.PAGEFILEUSAGE, i2) & 0xFFFFFFFFL), WmiUtil.getUint64(wmiResult, Win32Process.ProcessXPProperty.KERNELMODETIME, i2) / 10000L, WmiUtil.getUint64(wmiResult, Win32Process.ProcessXPProperty.USERMODETIME, i2) / 10000L, WmiUtil.getUint32(wmiResult, Win32Process.ProcessXPProperty.HANDLECOUNT, i2)));
        }
        return hashMap;
    }

    @Immutable
    public static class WtsInfo {
        private final String name;
        private final String path;
        private final int threadCount;
        private final long virtualSize;
        private final long kernelTime;
        private final long userTime;
        private final long openFiles;

        public WtsInfo(String string, String string2, int n2, long l2, long l3, long l4, long l5) {
            this.name = string;
            this.path = string2;
            this.threadCount = n2;
            this.virtualSize = l2;
            this.kernelTime = l3;
            this.userTime = l4;
            this.openFiles = l5;
        }

        public String getName() {
            return this.name;
        }

        public String getPath() {
            return this.path;
        }

        public int getThreadCount() {
            return this.threadCount;
        }

        public long getVirtualSize() {
            return this.virtualSize;
        }

        public long getKernelTime() {
            return this.kernelTime;
        }

        public long getUserTime() {
            return this.userTime;
        }

        public long getOpenFiles() {
            return this.openFiles;
        }
    }
}

