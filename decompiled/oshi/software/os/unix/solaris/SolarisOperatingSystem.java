/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.solaris;

import com.sun.jna.platform.unix.solaris.LibKstat;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.linux.proc.ProcessStat;
import oshi.driver.unix.solaris.Who;
import oshi.jna.platform.unix.SolarisLibc;
import oshi.software.common.AbstractOperatingSystem;
import oshi.software.os.FileSystem;
import oshi.software.os.InternetProtocolStats;
import oshi.software.os.NetworkParams;
import oshi.software.os.OSProcess;
import oshi.software.os.OSService;
import oshi.software.os.OSSession;
import oshi.software.os.OperatingSystem;
import oshi.software.os.unix.solaris.SolarisFileSystem;
import oshi.software.os.unix.solaris.SolarisInternetProtocolStats;
import oshi.software.os.unix.solaris.SolarisNetworkParams;
import oshi.software.os.unix.solaris.SolarisOSProcess;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.solaris.KstatUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public class SolarisOperatingSystem
extends AbstractOperatingSystem {
    static final String PS_COMMAND_ARGS = Arrays.stream(PsKeywords.values()).map(Enum::name).map(String::toLowerCase).collect(Collectors.joining(","));
    private static final long BOOTTIME = SolarisOperatingSystem.querySystemBootTime();

    @Override
    public String queryManufacturer() {
        return "Oracle";
    }

    @Override
    public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
        String[] stringArray = ParseUtil.whitespaces.split(ExecutingCommand.getFirstAnswer("uname -rv"));
        String string = stringArray[0];
        String string2 = null;
        if (stringArray.length > 1) {
            string2 = stringArray[1];
        }
        return new Pair<String, OperatingSystem.OSVersionInfo>("SunOS", new OperatingSystem.OSVersionInfo(string, "Solaris", string2));
    }

    @Override
    public int queryBitness(int n2) {
        if (n2 == 64) {
            return 64;
        }
        return ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("isainfo -b"), 32);
    }

    @Override
    public FileSystem getFileSystem() {
        return new SolarisFileSystem();
    }

    @Override
    public InternetProtocolStats getInternetProtocolStats() {
        return new SolarisInternetProtocolStats();
    }

    @Override
    public List<OSSession> getSessions() {
        return USE_WHO_COMMAND ? super.getSessions() : Who.queryUtxent();
    }

    @Override
    public OSProcess getProcess(int n2) {
        List<OSProcess> list = SolarisOperatingSystem.getProcessListFromPS("ps -o " + PS_COMMAND_ARGS + " -p " + n2, n2);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<OSProcess> queryAllProcesses() {
        return SolarisOperatingSystem.queryAllProcessesFromPS();
    }

    @Override
    public List<OSProcess> queryChildProcesses(int n2) {
        List<OSProcess> list = SolarisOperatingSystem.queryAllProcessesFromPS();
        Set<Integer> set = SolarisOperatingSystem.getChildrenOrDescendants(list, n2, false);
        return list.stream().filter(oSProcess -> set.contains(oSProcess.getProcessID())).collect(Collectors.toList());
    }

    @Override
    public List<OSProcess> queryDescendantProcesses(int n2) {
        List<OSProcess> list = SolarisOperatingSystem.queryAllProcessesFromPS();
        Set<Integer> set = SolarisOperatingSystem.getChildrenOrDescendants(list, n2, true);
        return list.stream().filter(oSProcess -> set.contains(oSProcess.getProcessID())).collect(Collectors.toList());
    }

    private static List<OSProcess> queryAllProcessesFromPS() {
        return SolarisOperatingSystem.getProcessListFromPS("ps -eo " + PS_COMMAND_ARGS, -1);
    }

    private static List<OSProcess> getProcessListFromPS(String string, int n2) {
        ArrayList<OSProcess> arrayList = new ArrayList<OSProcess>();
        List<String> list = ExecutingCommand.runNative(string);
        if (list.size() > 1) {
            Map<PsKeywords, String> map;
            List<String> list2 = n2 < 0 ? ExecutingCommand.runNative("prstat -v 1 1") : ExecutingCommand.runNative("prstat -v -p " + n2 + " 1 1");
            HashMap<String, String> hashMap = new HashMap<String, String>();
            for (String string2 : list2) {
                map = string2.trim();
                int n3 = ((String)((Object)map)).indexOf(32);
                if (n3 <= 0) continue;
                hashMap.put(((String)((Object)map)).substring(0, n3), (String)((Object)map));
            }
            list.remove(0);
            for (String string2 : list) {
                map = ParseUtil.stringToEnumMap(PsKeywords.class, string2.trim(), ' ');
                if (!map.containsKey((Object)PsKeywords.ARGS)) continue;
                String string3 = (String)map.get((Object)PsKeywords.PID);
                Map<PrstatKeywords, String> map2 = ParseUtil.stringToEnumMap(PrstatKeywords.class, hashMap.getOrDefault(string3, ""), ' ');
                arrayList.add(new SolarisOSProcess(n2 < 0 ? ParseUtil.parseIntOrDefault(string3, 0) : n2, map, map2));
            }
        }
        return arrayList;
    }

    @Override
    public int getProcessId() {
        return SolarisLibc.INSTANCE.getpid();
    }

    @Override
    public int getProcessCount() {
        return ProcessStat.getPidFiles().length;
    }

    @Override
    public int getThreadCount() {
        List<String> list = ExecutingCommand.runNative("ps -eLo pid");
        if (!list.isEmpty()) {
            return list.size() - 1;
        }
        return this.getProcessCount();
    }

    @Override
    public long getSystemUptime() {
        return SolarisOperatingSystem.querySystemUptime();
    }

    private static long querySystemUptime() {
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup("unix", 0, "system_misc");
            if (kstat != null) {
                long l2 = kstat.ks_snaptime / 1000000000L;
                return l2;
            }
        }
        return 0L;
    }

    @Override
    public long getSystemBootTime() {
        return BOOTTIME;
    }

    private static long querySystemBootTime() {
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup("unix", 0, "system_misc");
            if (kstat != null && KstatUtil.KstatChain.read(kstat)) {
                long l2 = KstatUtil.dataLookupLong(kstat, "boot_time");
                return l2;
            }
        }
        return System.currentTimeMillis() / 1000L - SolarisOperatingSystem.querySystemUptime();
    }

    @Override
    public NetworkParams getNetworkParams() {
        return new SolarisNetworkParams();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public List<OSService> getServices() {
        File[] fileArray2;
        File[] fileArray;
        ArrayList<OSService> arrayList = new ArrayList<OSService>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        File file = new File("/etc/init.d");
        if (file.exists() && file.isDirectory() && (fileArray = file.listFiles()) != null) {
            void string;
            fileArray2 = fileArray;
            int n2 = fileArray2.length;
            boolean bl2 = false;
            while (string < n2) {
                File n22 = fileArray2[string];
                arrayList2.add(n22.getName());
                ++string;
            }
        }
        fileArray2 = ExecutingCommand.runNative("svcs -p");
        block1: for (String string : fileArray2) {
            if (string.startsWith("online")) {
                int stringArray = string.lastIndexOf(":/");
                if (stringArray <= 0) continue;
                String string2 = string.substring(stringArray + 1);
                if (string2.endsWith(":default")) {
                    string2 = string2.substring(0, string2.length() - 8);
                }
                arrayList.add(new OSService(string2, 0, OSService.State.STOPPED));
                continue;
            }
            if (string.startsWith(" ")) {
                String[] stringArray = ParseUtil.whitespaces.split(string.trim());
                if (stringArray.length != 3) continue;
                arrayList.add(new OSService(stringArray[2], ParseUtil.parseIntOrDefault(stringArray[1], 0), OSService.State.RUNNING));
                continue;
            }
            if (!string.startsWith("legacy_run")) continue;
            for (String string2 : arrayList2) {
                if (!string.endsWith(string2)) continue;
                arrayList.add(new OSService(string2, 0, OSService.State.STOPPED));
                continue block1;
            }
        }
        return arrayList;
    }

    static enum PsKeywords {
        S,
        PID,
        PPID,
        USER,
        UID,
        GROUP,
        GID,
        NLWP,
        PRI,
        VSZ,
        RSS,
        ETIME,
        TIME,
        COMM,
        ARGS;

    }

    static enum PrstatKeywords {
        PID,
        USERNAME,
        USR,
        SYS,
        TRP,
        TFL,
        DFL,
        LCK,
        SLP,
        LAT,
        VCX,
        ICX,
        SCL,
        SIG,
        PROCESS_NLWP;

    }
}

