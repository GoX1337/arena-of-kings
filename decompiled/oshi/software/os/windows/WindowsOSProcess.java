/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.windows;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.COM.WbemcliUtil;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.Shell32Util;
import com.sun.jna.platform.win32.VersionHelpers;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.windows.registry.ProcessPerformanceData;
import oshi.driver.windows.registry.ProcessWtsData;
import oshi.driver.windows.registry.ThreadPerformanceData;
import oshi.driver.windows.wmi.Win32Process;
import oshi.driver.windows.wmi.Win32ProcessCached;
import oshi.jna.platform.windows.NtDll;
import oshi.software.common.AbstractOSProcess;
import oshi.software.os.OSProcess;
import oshi.software.os.OSThread;
import oshi.software.os.windows.WindowsOSThread;
import oshi.software.os.windows.WindowsOperatingSystem;
import oshi.util.GlobalConfig;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.platform.windows.WmiUtil;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

@ThreadSafe
public class WindowsOSProcess
extends AbstractOSProcess {
    private static final Logger LOG = LoggerFactory.getLogger(WindowsOSProcess.class);
    public static final String OSHI_OS_WINDOWS_COMMANDLINE_BATCH = "oshi.os.windows.commandline.batch";
    private static final boolean USE_BATCH_COMMANDLINE = GlobalConfig.get("oshi.os.windows.commandline.batch", false);
    private static final boolean USE_PROCSTATE_SUSPENDED = GlobalConfig.get("oshi.os.windows.procstate.suspended", false);
    private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
    private static final boolean IS_WINDOWS7_OR_GREATER = VersionHelpers.IsWindows7OrGreater();
    private final WindowsOperatingSystem os;
    private Supplier<Pair<String, String>> userInfo = Memoizer.memoize(this::queryUserInfo);
    private Supplier<Pair<String, String>> groupInfo = Memoizer.memoize(this::queryGroupInfo);
    private Supplier<String> currentWorkingDirectory = Memoizer.memoize(this::queryCwd);
    private Supplier<String> commandLine = Memoizer.memoize(this::queryCommandLine);
    private Supplier<List<String>> args = Memoizer.memoize(this::queryArguments);
    private Supplier<Triplet<String, String, Map<String, String>>> cwdCmdEnv = Memoizer.memoize(this::queryCwdCommandlineEnvironment);
    private String name;
    private String path;
    private OSProcess.State state = OSProcess.State.INVALID;
    private int parentProcessID;
    private int threadCount;
    private int priority;
    private long virtualSize;
    private long residentSetSize;
    private long kernelTime;
    private long userTime;
    private long startTime;
    private long upTime;
    private long bytesRead;
    private long bytesWritten;
    private long openFiles;
    private int bitness;
    private long pageFaults;

    public WindowsOSProcess(int n2, WindowsOperatingSystem windowsOperatingSystem, Map<Integer, ProcessPerformanceData.PerfCounterBlock> map, Map<Integer, ProcessWtsData.WtsInfo> map2, Map<Integer, ThreadPerformanceData.PerfCounterBlock> map3) {
        super(n2);
        this.os = windowsOperatingSystem;
        this.bitness = windowsOperatingSystem.getBitness();
        this.updateAttributes(map.get(n2), map2.get(n2), map3);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public String getCommandLine() {
        return this.commandLine.get();
    }

    @Override
    public List<String> getArguments() {
        return this.args.get();
    }

    @Override
    public Map<String, String> getEnvironmentVariables() {
        return this.cwdCmdEnv.get().getC();
    }

    @Override
    public String getCurrentWorkingDirectory() {
        return this.currentWorkingDirectory.get();
    }

    @Override
    public String getUser() {
        return this.userInfo.get().getA();
    }

    @Override
    public String getUserID() {
        return this.userInfo.get().getB();
    }

    @Override
    public String getGroup() {
        return this.groupInfo.get().getA();
    }

    @Override
    public String getGroupID() {
        return this.groupInfo.get().getB();
    }

    @Override
    public OSProcess.State getState() {
        return this.state;
    }

    @Override
    public int getParentProcessID() {
        return this.parentProcessID;
    }

    @Override
    public int getThreadCount() {
        return this.threadCount;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public long getVirtualSize() {
        return this.virtualSize;
    }

    @Override
    public long getResidentSetSize() {
        return this.residentSetSize;
    }

    @Override
    public long getKernelTime() {
        return this.kernelTime;
    }

    @Override
    public long getUserTime() {
        return this.userTime;
    }

    @Override
    public long getUpTime() {
        return this.upTime;
    }

    @Override
    public long getStartTime() {
        return this.startTime;
    }

    @Override
    public long getBytesRead() {
        return this.bytesRead;
    }

    @Override
    public long getBytesWritten() {
        return this.bytesWritten;
    }

    @Override
    public long getOpenFiles() {
        return this.openFiles;
    }

    @Override
    public int getBitness() {
        return this.bitness;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long getAffinityMask() {
        WinNT.HANDLE hANDLE = Kernel32.INSTANCE.OpenProcess(1024, false, this.getProcessID());
        if (hANDLE != null) {
            try {
                BaseTSD.ULONG_PTRByReference uLONG_PTRByReference = new BaseTSD.ULONG_PTRByReference();
                BaseTSD.ULONG_PTRByReference uLONG_PTRByReference2 = new BaseTSD.ULONG_PTRByReference();
                if (Kernel32.INSTANCE.GetProcessAffinityMask(hANDLE, uLONG_PTRByReference, uLONG_PTRByReference2)) {
                    long l2 = Pointer.nativeValue(uLONG_PTRByReference.getValue().toPointer());
                    return l2;
                }
            }
            finally {
                Kernel32.INSTANCE.CloseHandle(hANDLE);
            }
            Kernel32.INSTANCE.CloseHandle(hANDLE);
        }
        return 0L;
    }

    @Override
    public long getMinorFaults() {
        return this.pageFaults;
    }

    @Override
    public List<OSThread> getThreadDetails() {
        Map<Integer, ThreadPerformanceData.PerfCounterBlock> map = ThreadPerformanceData.buildThreadMapFromRegistry(Collections.singleton(this.getProcessID()));
        if (map != null) {
            map = ThreadPerformanceData.buildThreadMapFromPerfCounters(Collections.singleton(this.getProcessID()));
        }
        if (map == null) {
            return Collections.emptyList();
        }
        return map.entrySet().stream().map(entry -> new WindowsOSThread(this.getProcessID(), (Integer)entry.getKey(), this.name, (ThreadPerformanceData.PerfCounterBlock)entry.getValue())).collect(Collectors.toList());
    }

    @Override
    public boolean updateAttributes() {
        Set<Integer> set = Collections.singleton(this.getProcessID());
        Map<Integer, ProcessPerformanceData.PerfCounterBlock> map = ProcessPerformanceData.buildProcessMapFromRegistry(null);
        if (map == null) {
            map = ProcessPerformanceData.buildProcessMapFromPerfCounters(set);
        }
        Map<Integer, ThreadPerformanceData.PerfCounterBlock> map2 = null;
        if (USE_PROCSTATE_SUSPENDED && (map2 = ThreadPerformanceData.buildThreadMapFromRegistry(null)) == null) {
            map2 = ThreadPerformanceData.buildThreadMapFromPerfCounters(null);
        }
        Map<Integer, ProcessWtsData.WtsInfo> map3 = ProcessWtsData.queryProcessWtsMap(set);
        return this.updateAttributes(map.get(this.getProcessID()), map3.get(this.getProcessID()), map2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean updateAttributes(ProcessPerformanceData.PerfCounterBlock perfCounterBlock, ProcessWtsData.WtsInfo wtsInfo, Map<Integer, ThreadPerformanceData.PerfCounterBlock> map) {
        WinNT.HANDLE hANDLE;
        Object object;
        this.name = perfCounterBlock.getName();
        this.path = wtsInfo.getPath();
        this.parentProcessID = perfCounterBlock.getParentProcessID();
        this.threadCount = wtsInfo.getThreadCount();
        this.priority = perfCounterBlock.getPriority();
        this.virtualSize = wtsInfo.getVirtualSize();
        this.residentSetSize = perfCounterBlock.getResidentSetSize();
        this.kernelTime = wtsInfo.getKernelTime();
        this.userTime = wtsInfo.getUserTime();
        this.startTime = perfCounterBlock.getStartTime();
        this.upTime = perfCounterBlock.getUpTime();
        this.bytesRead = perfCounterBlock.getBytesRead();
        this.bytesWritten = perfCounterBlock.getBytesWritten();
        this.openFiles = wtsInfo.getOpenFiles();
        this.pageFaults = perfCounterBlock.getPageFaults();
        this.state = OSProcess.State.RUNNING;
        if (map != null) {
            int n2 = this.getProcessID();
            object = map.values().iterator();
            while (object.hasNext()) {
                ThreadPerformanceData.PerfCounterBlock perfCounterBlock2 = object.next();
                if (perfCounterBlock2.getOwningProcessID() != n2) continue;
                if (perfCounterBlock2.getThreadWaitReason() == 5) {
                    this.state = OSProcess.State.SUSPENDED;
                    continue;
                }
                this.state = OSProcess.State.RUNNING;
                break;
            }
        }
        if ((hANDLE = Kernel32.INSTANCE.OpenProcess(1024, false, this.getProcessID())) != null) {
            try {
                if (IS_VISTA_OR_GREATER && this.bitness == 64 && Kernel32.INSTANCE.IsWow64Process(hANDLE, (IntByReference)(object = new IntByReference(0))) && ((IntByReference)object).getValue() > 0) {
                    this.bitness = 32;
                }
                object = new WinNT.HANDLEByReference();
                try {
                    if (IS_WINDOWS7_OR_GREATER) {
                        this.path = Kernel32Util.QueryFullProcessImageName(hANDLE, 0);
                    }
                }
                catch (Win32Exception win32Exception) {
                    this.state = OSProcess.State.INVALID;
                }
                finally {
                    WinNT.HANDLE hANDLE2 = ((WinNT.HANDLEByReference)object).getValue();
                    if (hANDLE2 != null) {
                        Kernel32.INSTANCE.CloseHandle(hANDLE2);
                    }
                }
            }
            finally {
                Kernel32.INSTANCE.CloseHandle(hANDLE);
            }
        }
        return !this.state.equals((Object)OSProcess.State.INVALID);
    }

    private String queryCommandLine() {
        if (!this.cwdCmdEnv.get().getB().isEmpty()) {
            return this.cwdCmdEnv.get().getB();
        }
        if (USE_BATCH_COMMANDLINE) {
            return Win32ProcessCached.getInstance().getCommandLine(this.getProcessID(), this.getStartTime());
        }
        WbemcliUtil.WmiResult<Win32Process.CommandLineProperty> wmiResult = Win32Process.queryCommandLines(Collections.singleton(this.getProcessID()));
        if (wmiResult.getResultCount() > 0) {
            return WmiUtil.getString(wmiResult, Win32Process.CommandLineProperty.COMMANDLINE, 0);
        }
        return "";
    }

    private List<String> queryArguments() {
        String string = this.getCommandLine();
        if (!string.isEmpty()) {
            return Arrays.asList(Shell32Util.CommandLineToArgv((String)string));
        }
        return Collections.emptyList();
    }

    private String queryCwd() {
        String string;
        if (!this.cwdCmdEnv.get().getA().isEmpty()) {
            return this.cwdCmdEnv.get().getA();
        }
        if (this.getProcessID() == this.os.getProcessId() && !(string = new File(".").getAbsolutePath()).isEmpty()) {
            return string.substring(0, string.length() - 1);
        }
        return "";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Pair<String, String> queryUserInfo() {
        Pair<String, String> pair = null;
        WinNT.HANDLE hANDLE = Kernel32.INSTANCE.OpenProcess(1024, false, this.getProcessID());
        if (hANDLE != null) {
            WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
            try {
                if (Advapi32.INSTANCE.OpenProcessToken(hANDLE, 10, hANDLEByReference)) {
                    Advapi32Util.Account account = Advapi32Util.getTokenAccount(hANDLEByReference.getValue());
                    pair = new Pair<String, String>(account.name, account.sidString);
                } else {
                    int n2 = Kernel32.INSTANCE.GetLastError();
                    if (n2 != 5) {
                        LOG.error("Failed to get process token for process {}: {}", (Object)this.getProcessID(), (Object)Kernel32.INSTANCE.GetLastError());
                    }
                }
            }
            catch (Win32Exception win32Exception) {
                LOG.warn("Failed to query user info for process {} ({}): {}", this.getProcessID(), this.getName(), win32Exception.getMessage());
            }
            finally {
                WinNT.HANDLE hANDLE2 = hANDLEByReference.getValue();
                if (hANDLE2 != null) {
                    Kernel32.INSTANCE.CloseHandle(hANDLE2);
                }
                Kernel32.INSTANCE.CloseHandle(hANDLE);
            }
        }
        if (pair == null) {
            return new Pair<String, String>("unknown", "unknown");
        }
        return pair;
    }

    private Pair<String, String> queryGroupInfo() {
        Pair<String, String> pair = null;
        WinNT.HANDLE hANDLE = Kernel32.INSTANCE.OpenProcess(1024, false, this.getProcessID());
        if (hANDLE != null) {
            Object object;
            WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
            if (Advapi32.INSTANCE.OpenProcessToken(hANDLE, 10, hANDLEByReference)) {
                object = Advapi32Util.getTokenPrimaryGroup(hANDLEByReference.getValue());
                pair = new Pair<String, String>(((Advapi32Util.Account)object).name, ((Advapi32Util.Account)object).sidString);
            } else {
                int n2 = Kernel32.INSTANCE.GetLastError();
                if (n2 != 5) {
                    LOG.error("Failed to get process token for process {}: {}", (Object)this.getProcessID(), (Object)Kernel32.INSTANCE.GetLastError());
                }
            }
            object = hANDLEByReference.getValue();
            if (object != null) {
                Kernel32.INSTANCE.CloseHandle((WinNT.HANDLE)object);
            }
            Kernel32.INSTANCE.CloseHandle(hANDLE);
        }
        if (pair == null) {
            return new Pair<String, String>("unknown", "unknown");
        }
        return pair;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Triplet<String, String, Map<String, String>> queryCwdCommandlineEnvironment() {
        WinNT.HANDLE hANDLE = Kernel32.INSTANCE.OpenProcess(1040, false, this.getProcessID());
        if (hANDLE != null) {
            try {
                if (WindowsOperatingSystem.isX86() == WindowsOperatingSystem.isWow(hANDLE)) {
                    Object object;
                    IntByReference intByReference = new IntByReference();
                    NtDll.PROCESS_BASIC_INFORMATION pROCESS_BASIC_INFORMATION = new NtDll.PROCESS_BASIC_INFORMATION();
                    int n2 = NtDll.INSTANCE.NtQueryInformationProcess(hANDLE, 0, pROCESS_BASIC_INFORMATION.getPointer(), pROCESS_BASIC_INFORMATION.size(), intByReference);
                    if (n2 != 0) {
                        Triplet<String, String, Map<String, String>> triplet = WindowsOSProcess.defaultCwdCommandlineEnvironment();
                        return triplet;
                    }
                    pROCESS_BASIC_INFORMATION.read();
                    NtDll.PEB pEB = new NtDll.PEB();
                    Kernel32.INSTANCE.ReadProcessMemory(hANDLE, pROCESS_BASIC_INFORMATION.PebBaseAddress, pEB.getPointer(), pEB.size(), intByReference);
                    if (intByReference.getValue() == 0) {
                        Triplet<String, String, Map<String, String>> triplet = WindowsOSProcess.defaultCwdCommandlineEnvironment();
                        return triplet;
                    }
                    pEB.read();
                    NtDll.RTL_USER_PROCESS_PARAMETERS rTL_USER_PROCESS_PARAMETERS = new NtDll.RTL_USER_PROCESS_PARAMETERS();
                    Kernel32.INSTANCE.ReadProcessMemory(hANDLE, pEB.ProcessParameters, rTL_USER_PROCESS_PARAMETERS.getPointer(), rTL_USER_PROCESS_PARAMETERS.size(), intByReference);
                    if (intByReference.getValue() == 0) {
                        Triplet<String, String, Map<String, String>> triplet = WindowsOSProcess.defaultCwdCommandlineEnvironment();
                        return triplet;
                    }
                    rTL_USER_PROCESS_PARAMETERS.read();
                    String string = WindowsOSProcess.readUnicodeString(hANDLE, rTL_USER_PROCESS_PARAMETERS.CurrentDirectory.DosPath);
                    String string2 = WindowsOSProcess.readUnicodeString(hANDLE, rTL_USER_PROCESS_PARAMETERS.CommandLine);
                    int n3 = rTL_USER_PROCESS_PARAMETERS.EnvironmentSize.intValue();
                    if (n3 > 0) {
                        object = new Memory(n3);
                        Kernel32.INSTANCE.ReadProcessMemory(hANDLE, rTL_USER_PROCESS_PARAMETERS.Environment, (Pointer)object, n3, intByReference);
                        if (intByReference.getValue() > 0) {
                            char[] cArray = ((Pointer)object).getCharArray(0L, n3 / 2);
                            Map<String, String> map = ParseUtil.parseCharArrayToStringMap(cArray);
                            map.remove("");
                            Triplet<String, String, Map<String, String>> triplet = new Triplet<String, String, Map<String, String>>(string, string2, Collections.unmodifiableMap(map));
                            return triplet;
                        }
                    }
                    object = new Triplet(string, string2, Collections.emptyMap());
                    return object;
                }
            }
            finally {
                Kernel32.INSTANCE.CloseHandle(hANDLE);
            }
        }
        return WindowsOSProcess.defaultCwdCommandlineEnvironment();
    }

    private static Triplet<String, String, Map<String, String>> defaultCwdCommandlineEnvironment() {
        return new Triplet<String, String, Map<String, String>>("", "", Collections.emptyMap());
    }

    private static String readUnicodeString(WinNT.HANDLE hANDLE, NtDll.UNICODE_STRING uNICODE_STRING) {
        IntByReference intByReference = new IntByReference();
        if (uNICODE_STRING.Length > 0) {
            Memory memory = new Memory((long)uNICODE_STRING.Length + 2L);
            memory.clear();
            Kernel32.INSTANCE.ReadProcessMemory(hANDLE, uNICODE_STRING.Buffer, memory, uNICODE_STRING.Length, intByReference);
            if (intByReference.getValue() > 0) {
                return memory.getWideString(0L);
            }
        }
        return "";
    }
}

