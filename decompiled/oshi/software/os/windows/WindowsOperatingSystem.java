/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.windows;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.COM.WbemcliUtil;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Psapi;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.VersionHelpers;
import com.sun.jna.platform.win32.W32ServiceManager;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.Winsvc;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.windows.EnumWindows;
import oshi.driver.windows.registry.HkeyUserData;
import oshi.driver.windows.registry.NetSessionData;
import oshi.driver.windows.registry.ProcessPerformanceData;
import oshi.driver.windows.registry.ProcessWtsData;
import oshi.driver.windows.registry.SessionWtsData;
import oshi.driver.windows.registry.ThreadPerformanceData;
import oshi.driver.windows.wmi.Win32OperatingSystem;
import oshi.driver.windows.wmi.Win32Processor;
import oshi.jna.platform.windows.WinNT;
import oshi.software.common.AbstractOperatingSystem;
import oshi.software.os.FileSystem;
import oshi.software.os.InternetProtocolStats;
import oshi.software.os.NetworkParams;
import oshi.software.os.OSDesktopWindow;
import oshi.software.os.OSProcess;
import oshi.software.os.OSService;
import oshi.software.os.OSSession;
import oshi.software.os.OperatingSystem;
import oshi.software.os.windows.WindowsFileSystem;
import oshi.software.os.windows.WindowsInternetProtocolStats;
import oshi.software.os.windows.WindowsNetworkParams;
import oshi.software.os.windows.WindowsOSProcess;
import oshi.util.GlobalConfig;
import oshi.util.Memoizer;
import oshi.util.platform.windows.WmiUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public class WindowsOperatingSystem
extends AbstractOperatingSystem {
    private static final Logger LOG = LoggerFactory.getLogger(WindowsOperatingSystem.class);
    public static final String OSHI_OS_WINDOWS_PROCSTATE_SUSPENDED = "oshi.os.windows.procstate.suspended";
    private static final boolean USE_PROCSTATE_SUSPENDED = GlobalConfig.get("oshi.os.windows.procstate.suspended", false);
    private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
    private static final int TOKENELEVATION = 20;
    private static Supplier<String> systemLog = Memoizer.memoize(WindowsOperatingSystem::querySystemLog, TimeUnit.HOURS.toNanos(1L));
    private static final long BOOTTIME = WindowsOperatingSystem.querySystemBootTime();
    private static final boolean X86;
    private static final boolean WOW;
    private Supplier<Map<Integer, ProcessPerformanceData.PerfCounterBlock>> processMapFromRegistry = Memoizer.memoize(WindowsOperatingSystem::queryProcessMapFromRegistry, Memoizer.defaultExpiration());
    private Supplier<Map<Integer, ProcessPerformanceData.PerfCounterBlock>> processMapFromPerfCounters = Memoizer.memoize(WindowsOperatingSystem::queryProcessMapFromPerfCounters, Memoizer.defaultExpiration());
    private Supplier<Map<Integer, ThreadPerformanceData.PerfCounterBlock>> threadMapFromRegistry = Memoizer.memoize(WindowsOperatingSystem::queryThreadMapFromRegistry, Memoizer.defaultExpiration());
    private Supplier<Map<Integer, ThreadPerformanceData.PerfCounterBlock>> threadMapFromPerfCounters = Memoizer.memoize(WindowsOperatingSystem::queryThreadMapFromPerfCounters, Memoizer.defaultExpiration());

    @Override
    public String queryManufacturer() {
        return "Microsoft";
    }

    @Override
    public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
        String string = System.getProperty("os.name");
        if (string.startsWith("Windows ")) {
            string = string.substring(8);
        }
        String string2 = null;
        int n2 = 0;
        String string3 = null;
        WbemcliUtil.WmiResult<Win32OperatingSystem.OSVersionProperty> wmiResult = Win32OperatingSystem.queryOsVersion();
        if (wmiResult.getResultCount() > 0) {
            string2 = WmiUtil.getString(wmiResult, Win32OperatingSystem.OSVersionProperty.CSDVERSION, 0);
            if (!string2.isEmpty() && !"unknown".equals(string2)) {
                string = string + " " + string2.replace("Service Pack ", "SP");
            }
            n2 = WmiUtil.getUint32(wmiResult, Win32OperatingSystem.OSVersionProperty.SUITEMASK, 0);
            string3 = WmiUtil.getString(wmiResult, Win32OperatingSystem.OSVersionProperty.BUILDNUMBER, 0);
        }
        String string4 = WindowsOperatingSystem.parseCodeName(n2);
        return new Pair<String, OperatingSystem.OSVersionInfo>("Windows", new OperatingSystem.OSVersionInfo(string, string4, string3));
    }

    private static String parseCodeName(int n2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if ((n2 & 2) != 0) {
            arrayList.add("Enterprise");
        }
        if ((n2 & 4) != 0) {
            arrayList.add("BackOffice");
        }
        if ((n2 & 8) != 0) {
            arrayList.add("Communications Server");
        }
        if ((n2 & 0x80) != 0) {
            arrayList.add("Datacenter");
        }
        if ((n2 & 0x200) != 0) {
            arrayList.add("Home");
        }
        if ((n2 & 0x400) != 0) {
            arrayList.add("Web Server");
        }
        if ((n2 & 0x2000) != 0) {
            arrayList.add("Storage Server");
        }
        if ((n2 & 0x4000) != 0) {
            arrayList.add("Compute Cluster");
        }
        if ((n2 & 0x8000) != 0) {
            arrayList.add("Home Server");
        }
        return String.join((CharSequence)",", arrayList);
    }

    @Override
    public int queryBitness(int n2) {
        WbemcliUtil.WmiResult<Win32Processor.BitnessProperty> wmiResult;
        if (n2 < 64 && System.getenv("ProgramFiles(x86)") != null && IS_VISTA_OR_GREATER && (wmiResult = Win32Processor.queryBitness()).getResultCount() > 0) {
            return WmiUtil.getUint16(wmiResult, Win32Processor.BitnessProperty.ADDRESSWIDTH, 0);
        }
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isElevated() {
        WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
        boolean bl2 = Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(), 8, hANDLEByReference);
        if (!bl2) {
            LOG.error("OpenProcessToken failed. Error: {}", (Object)Native.getLastError());
            return false;
        }
        try {
            WinNT.TOKEN_ELEVATION tOKEN_ELEVATION = new WinNT.TOKEN_ELEVATION();
            if (Advapi32.INSTANCE.GetTokenInformation(hANDLEByReference.getValue(), 20, tOKEN_ELEVATION, tOKEN_ELEVATION.size(), new IntByReference())) {
                boolean bl3 = tOKEN_ELEVATION.TokenIsElevated > 0;
                return bl3;
            }
        }
        finally {
            Kernel32.INSTANCE.CloseHandle(hANDLEByReference.getValue());
        }
        return false;
    }

    @Override
    public FileSystem getFileSystem() {
        return new WindowsFileSystem();
    }

    @Override
    public InternetProtocolStats getInternetProtocolStats() {
        return new WindowsInternetProtocolStats();
    }

    @Override
    public List<OSSession> getSessions() {
        List<OSSession> list = HkeyUserData.queryUserSessions();
        list.addAll(SessionWtsData.queryUserSessions());
        list.addAll(NetSessionData.queryUserSessions());
        return list;
    }

    @Override
    public List<OSProcess> getProcesses(Collection<Integer> collection) {
        return this.processMapToList(collection);
    }

    @Override
    public List<OSProcess> queryAllProcesses() {
        return this.processMapToList(null);
    }

    @Override
    public List<OSProcess> queryChildProcesses(int n2) {
        Set<Integer> set = WindowsOperatingSystem.getChildrenOrDescendants(WindowsOperatingSystem.getParentPidsFromSnapshot(), n2, false);
        return this.processMapToList(set);
    }

    @Override
    public List<OSProcess> queryDescendantProcesses(int n2) {
        Set<Integer> set = WindowsOperatingSystem.getChildrenOrDescendants(WindowsOperatingSystem.getParentPidsFromSnapshot(), n2, true);
        return this.processMapToList(set);
    }

    private static Map<Integer, Integer> getParentPidsFromSnapshot() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Tlhelp32.PROCESSENTRY32.ByReference byReference = new Tlhelp32.PROCESSENTRY32.ByReference();
        WinNT.HANDLE hANDLE = Kernel32.INSTANCE.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0L));
        try {
            while (Kernel32.INSTANCE.Process32Next(hANDLE, byReference)) {
                hashMap.put(byReference.th32ProcessID.intValue(), byReference.th32ParentProcessID.intValue());
            }
        }
        finally {
            Kernel32.INSTANCE.CloseHandle(hANDLE);
        }
        return hashMap;
    }

    @Override
    public OSProcess getProcess(int n2) {
        List<OSProcess> list = this.processMapToList(Arrays.asList(n2));
        return list.isEmpty() ? null : list.get(0);
    }

    private List<OSProcess> processMapToList(Collection<Integer> collection) {
        Map<Integer, ProcessPerformanceData.PerfCounterBlock> map = this.processMapFromRegistry.get();
        if (map == null || map.isEmpty()) {
            map = collection == null ? this.processMapFromPerfCounters.get() : ProcessPerformanceData.buildProcessMapFromPerfCounters(collection);
        }
        Map<Integer, ThreadPerformanceData.PerfCounterBlock> map2 = null;
        if (USE_PROCSTATE_SUSPENDED && ((map2 = this.threadMapFromRegistry.get()) == null || map2.isEmpty())) {
            map2 = collection == null ? this.threadMapFromPerfCounters.get() : ThreadPerformanceData.buildThreadMapFromPerfCounters(collection);
        }
        Map<Integer, ProcessWtsData.WtsInfo> map3 = ProcessWtsData.queryProcessWtsMap(collection);
        HashSet<Integer> hashSet = new HashSet<Integer>(map3.keySet());
        hashSet.retainAll(map.keySet());
        ArrayList<OSProcess> arrayList = new ArrayList<OSProcess>();
        for (Integer n2 : hashSet) {
            arrayList.add(new WindowsOSProcess(n2, this, map, map3, map2));
        }
        return arrayList;
    }

    private static Map<Integer, ProcessPerformanceData.PerfCounterBlock> queryProcessMapFromRegistry() {
        return ProcessPerformanceData.buildProcessMapFromRegistry(null);
    }

    private static Map<Integer, ProcessPerformanceData.PerfCounterBlock> queryProcessMapFromPerfCounters() {
        return ProcessPerformanceData.buildProcessMapFromPerfCounters(null);
    }

    private static Map<Integer, ThreadPerformanceData.PerfCounterBlock> queryThreadMapFromRegistry() {
        return ThreadPerformanceData.buildThreadMapFromRegistry(null);
    }

    private static Map<Integer, ThreadPerformanceData.PerfCounterBlock> queryThreadMapFromPerfCounters() {
        return ThreadPerformanceData.buildThreadMapFromPerfCounters(null);
    }

    @Override
    public int getProcessId() {
        return Kernel32.INSTANCE.GetCurrentProcessId();
    }

    @Override
    public int getProcessCount() {
        Psapi.PERFORMANCE_INFORMATION pERFORMANCE_INFORMATION = new Psapi.PERFORMANCE_INFORMATION();
        if (!Psapi.INSTANCE.GetPerformanceInfo(pERFORMANCE_INFORMATION, pERFORMANCE_INFORMATION.size())) {
            LOG.error("Failed to get Performance Info. Error code: {}", (Object)Kernel32.INSTANCE.GetLastError());
            return 0;
        }
        return pERFORMANCE_INFORMATION.ProcessCount.intValue();
    }

    @Override
    public int getThreadCount() {
        Psapi.PERFORMANCE_INFORMATION pERFORMANCE_INFORMATION = new Psapi.PERFORMANCE_INFORMATION();
        if (!Psapi.INSTANCE.GetPerformanceInfo(pERFORMANCE_INFORMATION, pERFORMANCE_INFORMATION.size())) {
            LOG.error("Failed to get Performance Info. Error code: {}", (Object)Kernel32.INSTANCE.GetLastError());
            return 0;
        }
        return pERFORMANCE_INFORMATION.ThreadCount.intValue();
    }

    @Override
    public long getSystemUptime() {
        return WindowsOperatingSystem.querySystemUptime();
    }

    private static long querySystemUptime() {
        if (IS_VISTA_OR_GREATER) {
            return Kernel32.INSTANCE.GetTickCount64() / 1000L;
        }
        return (long)Kernel32.INSTANCE.GetTickCount() / 1000L;
    }

    @Override
    public long getSystemBootTime() {
        return BOOTTIME;
    }

    private static long querySystemBootTime() {
        String string = systemLog.get();
        if (string != null) {
            try {
                Advapi32Util.EventLogIterator eventLogIterator = new Advapi32Util.EventLogIterator(null, string, 8);
                long l2 = 0L;
                while (eventLogIterator.hasNext()) {
                    Advapi32Util.EventLogRecord eventLogRecord = eventLogIterator.next();
                    if (eventLogRecord.getStatusCode() == 12) {
                        return eventLogRecord.getRecord().TimeGenerated.longValue();
                    }
                    if (eventLogRecord.getStatusCode() != 6005) continue;
                    if (l2 > 0L) {
                        return l2;
                    }
                    l2 = eventLogRecord.getRecord().TimeGenerated.longValue();
                }
                if (l2 > 0L) {
                    return l2;
                }
            }
            catch (Win32Exception win32Exception) {
                LOG.warn("Can't open event log \"{}\".", (Object)string);
            }
        }
        return System.currentTimeMillis() / 1000L - WindowsOperatingSystem.querySystemUptime();
    }

    @Override
    public NetworkParams getNetworkParams() {
        return new WindowsNetworkParams();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean enableDebugPrivilege() {
        WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
        boolean bl2 = Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(), 40, hANDLEByReference);
        if (!bl2) {
            LOG.error("OpenProcessToken failed. Error: {}", (Object)Native.getLastError());
            return false;
        }
        try {
            WinNT.LUID lUID = new WinNT.LUID();
            bl2 = Advapi32.INSTANCE.LookupPrivilegeValue(null, "SeDebugPrivilege", lUID);
            if (!bl2) {
                LOG.error("LookupPrivilegeValue failed. Error: {}", (Object)Native.getLastError());
                boolean bl3 = false;
                return bl3;
            }
            WinNT.TOKEN_PRIVILEGES tOKEN_PRIVILEGES = new WinNT.TOKEN_PRIVILEGES(1);
            tOKEN_PRIVILEGES.Privileges[0] = new WinNT.LUID_AND_ATTRIBUTES(lUID, new WinDef.DWORD(2L));
            bl2 = Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, tOKEN_PRIVILEGES, 0, null, null);
            int n2 = Native.getLastError();
            if (!bl2) {
                LOG.error("AdjustTokenPrivileges failed. Error: {}", (Object)n2);
                boolean bl4 = false;
                return bl4;
            }
            if (n2 == 1300) {
                LOG.debug("Debug privileges not enabled.");
                boolean bl5 = false;
                return bl5;
            }
        }
        finally {
            Kernel32.INSTANCE.CloseHandle(hANDLEByReference.getValue());
        }
        return true;
    }

    @Override
    public List<OSService> getServices() {
        W32ServiceManager w32ServiceManager = new W32ServiceManager();
        try {
            w32ServiceManager.open(4);
            Winsvc.ENUM_SERVICE_STATUS_PROCESS[] eNUM_SERVICE_STATUS_PROCESSArray = w32ServiceManager.enumServicesStatusExProcess(48, 3, null);
            ArrayList<OSService> arrayList = new ArrayList<OSService>();
            for (Winsvc.ENUM_SERVICE_STATUS_PROCESS eNUM_SERVICE_STATUS_PROCESS : eNUM_SERVICE_STATUS_PROCESSArray) {
                OSService.State state;
                switch (eNUM_SERVICE_STATUS_PROCESS.ServiceStatusProcess.dwCurrentState) {
                    case 1: {
                        state = OSService.State.STOPPED;
                        break;
                    }
                    case 4: {
                        state = OSService.State.RUNNING;
                        break;
                    }
                    default: {
                        state = OSService.State.OTHER;
                    }
                }
                arrayList.add(new OSService(eNUM_SERVICE_STATUS_PROCESS.lpDisplayName, eNUM_SERVICE_STATUS_PROCESS.ServiceStatusProcess.dwProcessId, state));
            }
            ArrayList<OSService> arrayList2 = arrayList;
            w32ServiceManager.close();
            return arrayList2;
        }
        catch (Throwable throwable) {
            try {
                try {
                    w32ServiceManager.close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (Win32Exception win32Exception) {
                LOG.error("Win32Exception: {}", (Object)win32Exception.getMessage());
                return Collections.emptyList();
            }
        }
    }

    private static String querySystemLog() {
        String string = GlobalConfig.get("oshi.os.windows.eventlog", "System");
        if (string.isEmpty()) {
            return null;
        }
        WinNT.HANDLE hANDLE = Advapi32.INSTANCE.OpenEventLog(null, string);
        if (hANDLE == null) {
            LOG.warn("Unable to open configured system Event log \"{}\". Calculating boot time from uptime.", (Object)string);
            return null;
        }
        return string;
    }

    @Override
    public List<OSDesktopWindow> getDesktopWindows(boolean bl2) {
        return EnumWindows.queryDesktopWindows(bl2);
    }

    static boolean isX86() {
        return X86;
    }

    private static boolean isCurrentX86() {
        WinBase.SYSTEM_INFO sYSTEM_INFO = new WinBase.SYSTEM_INFO();
        Kernel32.INSTANCE.GetNativeSystemInfo(sYSTEM_INFO);
        return 0 == sYSTEM_INFO.processorArchitecture.pi.wProcessorArchitecture.intValue();
    }

    static boolean isWow() {
        return WOW;
    }

    static boolean isWow(WinNT.HANDLE hANDLE) {
        if (X86) {
            return true;
        }
        IntByReference intByReference = new IntByReference();
        Kernel32.INSTANCE.IsWow64Process(hANDLE, intByReference);
        return intByReference.getValue() != 0;
    }

    private static boolean isCurrentWow() {
        if (X86) {
            return true;
        }
        WinNT.HANDLE hANDLE = Kernel32.INSTANCE.GetCurrentProcess();
        if (hANDLE != null) {
            try {
                boolean bl2 = WindowsOperatingSystem.isWow(hANDLE);
                return bl2;
            }
            finally {
                Kernel32.INSTANCE.CloseHandle(hANDLE);
            }
        }
        return false;
    }

    static {
        WindowsOperatingSystem.enableDebugPrivilege();
        X86 = WindowsOperatingSystem.isCurrentX86();
        WOW = WindowsOperatingSystem.isCurrentWow();
    }
}

