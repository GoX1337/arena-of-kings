/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.aix;

import com.sun.jna.Native;
import com.sun.jna.platform.unix.aix.Perfstat;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.aix.Uptime;
import oshi.driver.unix.aix.Who;
import oshi.driver.unix.aix.perfstat.PerfstatConfig;
import oshi.driver.unix.aix.perfstat.PerfstatProcess;
import oshi.jna.platform.unix.AixLibc;
import oshi.software.common.AbstractOperatingSystem;
import oshi.software.os.FileSystem;
import oshi.software.os.InternetProtocolStats;
import oshi.software.os.NetworkParams;
import oshi.software.os.OSProcess;
import oshi.software.os.OSService;
import oshi.software.os.OperatingSystem;
import oshi.software.os.unix.aix.AixFileSystem;
import oshi.software.os.unix.aix.AixInternetProtocolStats;
import oshi.software.os.unix.aix.AixNetworkParams;
import oshi.software.os.unix.aix.AixOSProcess;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.Util;
import oshi.util.tuples.Pair;

@ThreadSafe
public class AixOperatingSystem
extends AbstractOperatingSystem {
    private final Supplier<Perfstat.perfstat_partition_config_t> config = Memoizer.memoize(PerfstatConfig::queryConfig);
    private final Supplier<Perfstat.perfstat_process_t[]> procCpu = Memoizer.memoize(PerfstatProcess::queryProcesses, Memoizer.defaultExpiration());
    private static final long BOOTTIME = AixOperatingSystem.querySystemBootTimeMillis() / 1000L;
    static final String PS_COMMAND_ARGS = Arrays.stream(PsKeywords.values()).map(Enum::name).map(String::toLowerCase).collect(Collectors.joining(","));

    @Override
    public String queryManufacturer() {
        return "IBM";
    }

    @Override
    public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
        String string;
        Perfstat.perfstat_partition_config_t perfstat_partition_config_t2 = this.config.get();
        String string2 = System.getProperty("os.name");
        String string3 = System.getProperty("os.arch");
        String string4 = System.getProperty("os.version");
        if (Util.isBlank(string4)) {
            string4 = ExecutingCommand.getFirstAnswer("oslevel");
        }
        if (Util.isBlank(string = Native.toString(perfstat_partition_config_t2.OSBuild))) {
            string = ExecutingCommand.getFirstAnswer("oslevel -s");
        } else {
            int n2 = string.lastIndexOf(32);
            if (n2 > 0 && n2 < string.length()) {
                string = string.substring(n2 + 1);
            }
        }
        return new Pair<String, OperatingSystem.OSVersionInfo>(string2, new OperatingSystem.OSVersionInfo(string4, string3, string));
    }

    @Override
    public int queryBitness(int n2) {
        if (n2 == 64) {
            return 64;
        }
        return (this.config.get().conf & 0x800000) > 0 ? 64 : 32;
    }

    @Override
    public FileSystem getFileSystem() {
        return new AixFileSystem();
    }

    @Override
    public InternetProtocolStats getInternetProtocolStats() {
        return new AixInternetProtocolStats();
    }

    @Override
    public List<OSProcess> queryAllProcesses() {
        return this.getProcessListFromPS("ps -A -o " + PS_COMMAND_ARGS, -1);
    }

    @Override
    public List<OSProcess> queryChildProcesses(int n2) {
        List<OSProcess> list = this.queryAllProcesses();
        Set<Integer> set = AixOperatingSystem.getChildrenOrDescendants(list, n2, false);
        return list.stream().filter(oSProcess -> set.contains(oSProcess.getProcessID())).collect(Collectors.toList());
    }

    @Override
    public List<OSProcess> queryDescendantProcesses(int n2) {
        List<OSProcess> list = this.queryAllProcesses();
        Set<Integer> set = AixOperatingSystem.getChildrenOrDescendants(list, n2, true);
        return list.stream().filter(oSProcess -> set.contains(oSProcess.getProcessID())).collect(Collectors.toList());
    }

    @Override
    public OSProcess getProcess(int n2) {
        List<OSProcess> list = this.getProcessListFromPS("ps -o " + PS_COMMAND_ARGS + " -p ", n2);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private List<OSProcess> getProcessListFromPS(String string, int n2) {
        Perfstat.perfstat_process_t[] perfstat_process_tArray = this.procCpu.get();
        List<String> list = ExecutingCommand.runNative(string + (n2 < 0 ? "" : Integer.valueOf(n2)));
        if (list.isEmpty() || list.size() < 2) {
            return Collections.emptyList();
        }
        HashMap<Integer, Pair<Long, Long>> hashMap = new HashMap<Integer, Pair<Long, Long>>();
        for (Perfstat.perfstat_process_t map : perfstat_process_tArray) {
            hashMap.put((int)map.pid, new Pair<Long, Long>((long)map.ucpu_time, (long)map.scpu_time));
        }
        list.remove(0);
        ArrayList arrayList = new ArrayList();
        for (String string2 : list) {
            Map<PsKeywords, String> map = ParseUtil.stringToEnumMap(PsKeywords.class, string2.trim(), ' ');
            if (!map.containsKey((Object)PsKeywords.ARGS)) continue;
            arrayList.add(new AixOSProcess(n2 < 0 ? ParseUtil.parseIntOrDefault(map.get((Object)PsKeywords.PID), 0) : n2, map, hashMap, this.procCpu));
        }
        return arrayList;
    }

    @Override
    public int getProcessId() {
        return AixLibc.INSTANCE.getpid();
    }

    @Override
    public int getProcessCount() {
        return this.procCpu.get().length;
    }

    @Override
    public int getThreadCount() {
        long l2 = 0L;
        for (Perfstat.perfstat_process_t perfstat_process_t2 : this.procCpu.get()) {
            l2 += perfstat_process_t2.num_threads;
        }
        return (int)l2;
    }

    @Override
    public long getSystemUptime() {
        return System.currentTimeMillis() / 1000L - BOOTTIME;
    }

    @Override
    public long getSystemBootTime() {
        return BOOTTIME;
    }

    private static long querySystemBootTimeMillis() {
        long l2 = Who.queryBootTime();
        if (l2 >= 1000L) {
            return l2;
        }
        return System.currentTimeMillis() - Uptime.queryUpTime();
    }

    @Override
    public NetworkParams getNetworkParams() {
        return new AixNetworkParams();
    }

    @Override
    public List<OSService> getServices() {
        File[] fileArray;
        Object object;
        ArrayList<OSService> arrayList = new ArrayList<OSService>();
        List<String> list = ExecutingCommand.runNative("lssrc -a");
        if (list.size() > 1) {
            list.remove(0);
            object = list.iterator();
            while (object.hasNext()) {
                fileArray = (File[])object.next();
                Object[] objectArray = ParseUtil.whitespaces.split(fileArray.trim());
                if (fileArray.contains("active")) {
                    if (objectArray.length == 4) {
                        arrayList.add(new OSService((String)objectArray[0], ParseUtil.parseIntOrDefault((String)objectArray[2], 0), OSService.State.RUNNING));
                        continue;
                    }
                    if (objectArray.length != 3) continue;
                    arrayList.add(new OSService((String)objectArray[0], ParseUtil.parseIntOrDefault((String)objectArray[1], 0), OSService.State.RUNNING));
                    continue;
                }
                if (!fileArray.contains("inoperative")) continue;
                arrayList.add(new OSService((String)objectArray[0], 0, OSService.State.STOPPED));
            }
        }
        if (((File)(object = new File("/etc/rc.d/init.d"))).exists() && ((File)object).isDirectory() && (fileArray = ((File)object).listFiles()) != null) {
            for (File file : fileArray) {
                String string = ExecutingCommand.getFirstAnswer(file.getAbsolutePath() + " status");
                if (string.contains("running")) {
                    arrayList.add(new OSService(file.getName(), ParseUtil.parseLastInt(string, 0), OSService.State.RUNNING));
                    continue;
                }
                arrayList.add(new OSService(file.getName(), 0, OSService.State.STOPPED));
            }
        }
        return arrayList;
    }

    static enum PsKeywords {
        ST,
        PID,
        PPID,
        USER,
        UID,
        GROUP,
        GID,
        THCOUNT,
        PRI,
        VSIZE,
        RSSIZE,
        ETIME,
        TIME,
        COMM,
        PAGEIN,
        ARGS;

    }
}

