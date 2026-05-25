/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.mac;

import com.sun.jna.platform.mac.SystemB;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.mac.Who;
import oshi.driver.mac.WindowInfo;
import oshi.software.common.AbstractOperatingSystem;
import oshi.software.os.FileSystem;
import oshi.software.os.InternetProtocolStats;
import oshi.software.os.NetworkParams;
import oshi.software.os.OSDesktopWindow;
import oshi.software.os.OSProcess;
import oshi.software.os.OSService;
import oshi.software.os.OSSession;
import oshi.software.os.OperatingSystem;
import oshi.software.os.mac.MacFileSystem;
import oshi.software.os.mac.MacInternetProtocolStats;
import oshi.software.os.mac.MacNetworkParams;
import oshi.software.os.mac.MacOSProcess;
import oshi.util.ExecutingCommand;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;
import oshi.util.Util;
import oshi.util.platform.mac.SysctlUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public class MacOperatingSystem
extends AbstractOperatingSystem {
    private static final Logger LOG = LoggerFactory.getLogger(MacOperatingSystem.class);
    public static final String MACOS_VERSIONS_PROPERTIES = "oshi.macos.versions.properties";
    private static final String SYSTEM_LIBRARY_LAUNCH_AGENTS = "/System/Library/LaunchAgents";
    private static final String SYSTEM_LIBRARY_LAUNCH_DAEMONS = "/System/Library/LaunchDaemons";
    private int maxProc = 1024;
    private final String osXVersion;
    private final int major;
    private final int minor;
    private static final long BOOTTIME;

    public MacOperatingSystem() {
        String string = System.getProperty("os.version");
        int n2 = ParseUtil.getFirstIntValue(string);
        int n3 = ParseUtil.getNthIntValue(string, 2);
        if (n2 == 10 && n3 > 15) {
            String string2 = ExecutingCommand.getFirstAnswer("sw_vers -productVersion");
            if (!string2.isEmpty()) {
                string = string2;
            }
            n2 = ParseUtil.getFirstIntValue(string);
            n3 = ParseUtil.getNthIntValue(string, 2);
        }
        this.osXVersion = string;
        this.major = n2;
        this.minor = n3;
        this.maxProc = SysctlUtil.sysctl("kern.maxproc", 4096);
    }

    @Override
    public String queryManufacturer() {
        return "Apple";
    }

    @Override
    public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
        String string = this.major > 10 || this.major == 10 && this.minor >= 12 ? "macOS" : System.getProperty("os.name");
        String string2 = this.parseCodeName();
        String string3 = SysctlUtil.sysctl("kern.osversion", "");
        return new Pair<String, OperatingSystem.OSVersionInfo>(string, new OperatingSystem.OSVersionInfo(this.osXVersion, string2, string3));
    }

    private String parseCodeName() {
        Properties properties = FileUtil.readPropertiesFromFilename(MACOS_VERSIONS_PROPERTIES);
        String string = null;
        if (this.major > 10) {
            string = properties.getProperty(Integer.toString(this.major));
        } else if (this.major == 10) {
            string = properties.getProperty(this.major + "." + this.minor);
        }
        if (Util.isBlank(string)) {
            LOG.warn("Unable to parse version {}.{} to a codename.", (Object)this.major, (Object)this.minor);
        }
        return string;
    }

    @Override
    public int queryBitness(int n2) {
        if (n2 == 64 || this.major == 10 && this.minor > 6) {
            return 64;
        }
        return ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("getconf LONG_BIT"), 32);
    }

    @Override
    public FileSystem getFileSystem() {
        return new MacFileSystem();
    }

    @Override
    public InternetProtocolStats getInternetProtocolStats() {
        return new MacInternetProtocolStats(this.isElevated());
    }

    @Override
    public List<OSSession> getSessions() {
        return USE_WHO_COMMAND ? super.getSessions() : Who.queryUtxent();
    }

    @Override
    public List<OSProcess> queryAllProcesses() {
        ArrayList<OSProcess> arrayList = new ArrayList<OSProcess>();
        int[] nArray = new int[this.maxProc];
        int n2 = SystemB.INSTANCE.proc_listpids(1, 0, nArray, nArray.length * SystemB.INT_SIZE) / SystemB.INT_SIZE;
        for (int i2 = 0; i2 < n2; ++i2) {
            OSProcess oSProcess;
            if (nArray[i2] == 0 || (oSProcess = this.getProcess(nArray[i2])) == null) continue;
            arrayList.add(oSProcess);
        }
        return arrayList;
    }

    @Override
    public OSProcess getProcess(int n2) {
        MacOSProcess macOSProcess = new MacOSProcess(n2, this.minor);
        return macOSProcess.getState().equals((Object)OSProcess.State.INVALID) ? null : macOSProcess;
    }

    @Override
    public List<OSProcess> queryChildProcesses(int n2) {
        List<OSProcess> list = this.queryAllProcesses();
        Set<Integer> set = MacOperatingSystem.getChildrenOrDescendants(list, n2, false);
        return list.stream().filter(oSProcess -> set.contains(oSProcess.getProcessID())).collect(Collectors.toList());
    }

    @Override
    public List<OSProcess> queryDescendantProcesses(int n2) {
        List<OSProcess> list = this.queryAllProcesses();
        Set<Integer> set = MacOperatingSystem.getChildrenOrDescendants(list, n2, true);
        return list.stream().filter(oSProcess -> set.contains(oSProcess.getProcessID())).collect(Collectors.toList());
    }

    @Override
    public int getProcessId() {
        return SystemB.INSTANCE.getpid();
    }

    @Override
    public int getProcessCount() {
        return SystemB.INSTANCE.proc_listpids(1, 0, null, 0) / SystemB.INT_SIZE;
    }

    @Override
    public int getThreadCount() {
        int[] nArray = new int[this.getProcessCount() + 10];
        int n2 = SystemB.INSTANCE.proc_listpids(1, 0, nArray, nArray.length) / SystemB.INT_SIZE;
        int n3 = 0;
        SystemB.ProcTaskInfo procTaskInfo = new SystemB.ProcTaskInfo();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = SystemB.INSTANCE.proc_pidinfo(nArray[i2], 4, 0L, procTaskInfo, procTaskInfo.size());
            if (n4 == -1) continue;
            n3 += procTaskInfo.pti_threadnum;
        }
        return n3;
    }

    @Override
    public long getSystemUptime() {
        return System.currentTimeMillis() / 1000L - BOOTTIME;
    }

    @Override
    public long getSystemBootTime() {
        return BOOTTIME;
    }

    @Override
    public NetworkParams getNetworkParams() {
        return new MacNetworkParams();
    }

    @Override
    public List<OSService> getServices() {
        Object object;
        ArrayList<OSService> arrayList = new ArrayList<OSService>();
        HashSet<String> hashSet = new HashSet<String>();
        for (OSProcess object22 : this.getChildProcesses(1, OperatingSystem.ProcessFiltering.ALL_PROCESSES, OperatingSystem.ProcessSorting.PID_ASC, 0)) {
            object = new OSService(object22.getName(), object22.getProcessID(), OSService.State.RUNNING);
            arrayList.add((OSService)object);
            hashSet.add(object22.getName());
        }
        ArrayList arrayList2 = new ArrayList();
        File file2 = new File(SYSTEM_LIBRARY_LAUNCH_AGENTS);
        if (file2.exists() && file2.isDirectory()) {
            arrayList2.addAll(Arrays.asList(file2.listFiles((file, string) -> string.toLowerCase().endsWith(".plist"))));
        } else {
            LOG.error("Directory: /System/Library/LaunchAgents does not exist");
        }
        File file3 = new File(SYSTEM_LIBRARY_LAUNCH_DAEMONS);
        if (file3.exists() && file3.isDirectory()) {
            arrayList2.addAll(Arrays.asList(file3.listFiles((file, string) -> string.toLowerCase().endsWith(".plist"))));
        } else {
            LOG.error("Directory: /System/Library/LaunchDaemons does not exist");
        }
        object = arrayList2.iterator();
        while (object.hasNext()) {
            String string2;
            File file4 = (File)object.next();
            String string3 = file4.getName().substring(0, file4.getName().length() - 6);
            int n2 = string3.lastIndexOf(46);
            String string4 = string2 = n2 < 0 || n2 > string3.length() - 2 ? string3 : string3.substring(n2 + 1);
            if (hashSet.contains(string3) || hashSet.contains(string2)) continue;
            OSService oSService = new OSService(string3, 0, OSService.State.STOPPED);
            arrayList.add(oSService);
        }
        return arrayList;
    }

    @Override
    public List<OSDesktopWindow> getDesktopWindows(boolean bl2) {
        return WindowInfo.queryDesktopWindows(bl2);
    }

    static {
        SystemB.Timeval timeval = new SystemB.Timeval();
        BOOTTIME = !SysctlUtil.sysctl("kern.boottime", timeval) || timeval.tv_sec.longValue() == 0L ? ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("sysctl -n kern.boottime").split(",")[0].replaceAll("\\D", ""), System.currentTimeMillis() / 1000L) : timeval.tv_sec.longValue();
    }
}

