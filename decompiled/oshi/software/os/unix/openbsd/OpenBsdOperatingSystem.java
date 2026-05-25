/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.openbsd;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.unix.OpenBsdLibc;
import oshi.software.common.AbstractOperatingSystem;
import oshi.software.os.FileSystem;
import oshi.software.os.InternetProtocolStats;
import oshi.software.os.NetworkParams;
import oshi.software.os.OSProcess;
import oshi.software.os.OSService;
import oshi.software.os.OperatingSystem;
import oshi.software.os.unix.openbsd.OpenBsdFileSystem;
import oshi.software.os.unix.openbsd.OpenBsdInternetProtocolStats;
import oshi.software.os.unix.openbsd.OpenBsdNetworkParams;
import oshi.software.os.unix.openbsd.OpenBsdOSProcess;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.openbsd.OpenBsdSysctlUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public class OpenBsdOperatingSystem
extends AbstractOperatingSystem {
    private static final Logger LOG = LoggerFactory.getLogger(OpenBsdOperatingSystem.class);
    private static final long BOOTTIME = OpenBsdOperatingSystem.querySystemBootTime();
    static final String PS_COMMAND_ARGS = Arrays.stream(PsKeywords.values()).map(Enum::name).map(String::toLowerCase).collect(Collectors.joining(","));

    @Override
    public String queryManufacturer() {
        return "Unix/BSD";
    }

    @Override
    public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
        int[] nArray = new int[]{1, 1};
        String string = OpenBsdSysctlUtil.sysctl(nArray, "OpenBSD");
        nArray[1] = 2;
        String string2 = OpenBsdSysctlUtil.sysctl(nArray, "");
        nArray[1] = 4;
        String string3 = OpenBsdSysctlUtil.sysctl(nArray, "");
        String string4 = string3.split(":")[0].replace(string, "").replace(string2, "").trim();
        return new Pair<String, OperatingSystem.OSVersionInfo>(string, new OperatingSystem.OSVersionInfo(string2, null, string4));
    }

    @Override
    public int queryBitness(int n2) {
        if (n2 < 64 && ExecutingCommand.getFirstAnswer("uname -m").indexOf("64") == -1) {
            return n2;
        }
        return 64;
    }

    @Override
    public FileSystem getFileSystem() {
        return new OpenBsdFileSystem();
    }

    @Override
    public InternetProtocolStats getInternetProtocolStats() {
        return new OpenBsdInternetProtocolStats();
    }

    @Override
    public List<OSProcess> queryAllProcesses() {
        return OpenBsdOperatingSystem.getProcessListFromPS(-1);
    }

    @Override
    public List<OSProcess> queryChildProcesses(int n2) {
        List<OSProcess> list = this.queryAllProcesses();
        Set<Integer> set = OpenBsdOperatingSystem.getChildrenOrDescendants(list, n2, false);
        return list.stream().filter(oSProcess -> set.contains(oSProcess.getProcessID())).collect(Collectors.toList());
    }

    @Override
    public List<OSProcess> queryDescendantProcesses(int n2) {
        List<OSProcess> list = this.queryAllProcesses();
        Set<Integer> set = OpenBsdOperatingSystem.getChildrenOrDescendants(list, n2, true);
        return list.stream().filter(oSProcess -> set.contains(oSProcess.getProcessID())).collect(Collectors.toList());
    }

    @Override
    public OSProcess getProcess(int n2) {
        List<OSProcess> list = OpenBsdOperatingSystem.getProcessListFromPS(n2);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static List<OSProcess> getProcessListFromPS(int n2) {
        List<String> list;
        ArrayList<OSProcess> arrayList = new ArrayList<OSProcess>();
        String string = "ps -awwxo " + PS_COMMAND_ARGS;
        if (n2 >= 0) {
            string = string + " -p " + n2;
        }
        if ((list = ExecutingCommand.runNative(string)).isEmpty() || list.size() < 2) {
            return arrayList;
        }
        list.remove(0);
        for (String string2 : list) {
            Map<PsKeywords, String> map = ParseUtil.stringToEnumMap(PsKeywords.class, string2.trim(), ' ');
            if (!map.containsKey((Object)PsKeywords.ARGS)) continue;
            arrayList.add(new OpenBsdOSProcess(n2 < 0 ? ParseUtil.parseIntOrDefault(map.get((Object)PsKeywords.PID), 0) : n2, map));
        }
        return arrayList;
    }

    @Override
    public int getProcessId() {
        return OpenBsdLibc.INSTANCE.getpid();
    }

    @Override
    public int getProcessCount() {
        List<String> list = ExecutingCommand.runNative("ps -axo pid");
        if (!list.isEmpty()) {
            return list.size() - 1;
        }
        return 0;
    }

    @Override
    public int getThreadCount() {
        List<String> list = ExecutingCommand.runNative("ps -axHo tid");
        if (!list.isEmpty()) {
            return list.size() - 1;
        }
        return 0;
    }

    @Override
    public long getSystemUptime() {
        return System.currentTimeMillis() / 1000L - BOOTTIME;
    }

    @Override
    public long getSystemBootTime() {
        return BOOTTIME;
    }

    private static long querySystemBootTime() {
        return ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("sysctl -n kern.boottime").split(",")[0].replaceAll("\\D", ""), System.currentTimeMillis() / 1000L);
    }

    @Override
    public NetworkParams getNetworkParams() {
        return new OpenBsdNetworkParams();
    }

    @Override
    public List<OSService> getServices() {
        File[] fileArray;
        ArrayList<OSService> arrayList = new ArrayList<OSService>();
        HashSet<String> hashSet = new HashSet<String>();
        for (OSProcess fileArray2 : this.getChildProcesses(1, OperatingSystem.ProcessFiltering.ALL_PROCESSES, OperatingSystem.ProcessSorting.PID_ASC, 0)) {
            File[] fileArray3 = new OSService(fileArray2.getName(), fileArray2.getProcessID(), OSService.State.RUNNING);
            arrayList.add((OSService)fileArray3);
            hashSet.add(fileArray2.getName());
        }
        File file = new File("/etc/rc.d");
        if (file.exists() && file.isDirectory() && (fileArray = file.listFiles()) != null) {
            for (File file2 : fileArray) {
                String string = file2.getName();
                if (hashSet.contains(string)) continue;
                OSService oSService = new OSService(string, 0, OSService.State.STOPPED);
                arrayList.add(oSService);
            }
        } else {
            LOG.error("Directory: /etc/rc.d does not exist");
        }
        return arrayList;
    }

    static enum PsKeywords {
        STATE,
        PID,
        PPID,
        USER,
        UID,
        GROUP,
        GID,
        PRI,
        VSZ,
        RSS,
        ETIME,
        CPUTIME,
        COMM,
        MAJFLT,
        MINFLT,
        NVCSW,
        NIVCSW,
        ARGS;

    }
}

