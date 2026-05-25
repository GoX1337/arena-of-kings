/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.aix;

import com.sun.jna.platform.unix.aix.Perfstat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.aix.PsInfo;
import oshi.driver.unix.aix.perfstat.PerfstatCpu;
import oshi.software.common.AbstractOSProcess;
import oshi.software.os.OSProcess;
import oshi.software.os.OSThread;
import oshi.software.os.unix.aix.AixOSThread;
import oshi.software.os.unix.aix.AixOperatingSystem;
import oshi.util.ExecutingCommand;
import oshi.util.LsofUtil;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public class AixOSProcess
extends AbstractOSProcess {
    private Supplier<Integer> bitness = Memoizer.memoize(this::queryBitness);
    private Supplier<String> commandLine = Memoizer.memoize(this::queryCommandLine);
    private Supplier<Pair<List<String>, Map<String, String>>> cmdEnv = Memoizer.memoize(this::queryCommandlineEnvironment);
    private final Supplier<Long> affinityMask = Memoizer.memoize(PerfstatCpu::queryCpuAffinityMask, Memoizer.defaultExpiration());
    private String name;
    private String path = "";
    private String commandLineBackup;
    private String user;
    private String userID;
    private String group;
    private String groupID;
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
    private long majorFaults;
    private Supplier<Perfstat.perfstat_process_t[]> procCpu;

    public AixOSProcess(int n2, Map<AixOperatingSystem.PsKeywords, String> map, Map<Integer, Pair<Long, Long>> map2, Supplier<Perfstat.perfstat_process_t[]> supplier) {
        super(n2);
        this.procCpu = supplier;
        this.updateAttributes(map, map2);
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

    private String queryCommandLine() {
        String string = String.join((CharSequence)" ", this.getArguments());
        return string.isEmpty() ? this.commandLineBackup : string;
    }

    @Override
    public List<String> getArguments() {
        return this.cmdEnv.get().getA();
    }

    @Override
    public Map<String, String> getEnvironmentVariables() {
        return this.cmdEnv.get().getB();
    }

    private Pair<List<String>, Map<String, String>> queryCommandlineEnvironment() {
        return PsInfo.queryArgsEnv(this.getProcessID());
    }

    @Override
    public String getCurrentWorkingDirectory() {
        return LsofUtil.getCwd(this.getProcessID());
    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getUserID() {
        return this.userID;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public String getGroupID() {
        return this.groupID;
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
        return LsofUtil.getOpenFiles(this.getProcessID());
    }

    @Override
    public int getBitness() {
        return this.bitness.get();
    }

    private int queryBitness() {
        List<String> list = ExecutingCommand.runNative("pflags " + this.getProcessID());
        for (String string : list) {
            if (!string.contains("data model")) continue;
            if (string.contains("LP32")) {
                return 32;
            }
            if (!string.contains("LP64")) continue;
            return 64;
        }
        return 0;
    }

    @Override
    public long getAffinityMask() {
        long l2 = 0L;
        List<String> list = ExecutingCommand.runNative("ps -m -o THREAD -p " + this.getProcessID());
        if (list.size() > 2) {
            list.remove(0);
            list.remove(0);
            for (String string : list) {
                Map<PsThreadColumns, String> map = ParseUtil.stringToEnumMap(PsThreadColumns.class, string.trim(), ' ');
                if (!map.containsKey((Object)PsThreadColumns.COMMAND) || map.get((Object)PsThreadColumns.ST).charAt(0) == 'Z') continue;
                String string2 = map.get((Object)PsThreadColumns.BND);
                if (string2.charAt(0) == '-') {
                    return this.affinityMask.get();
                }
                int n2 = ParseUtil.parseIntOrDefault(string2, 0);
                l2 |= 1L << n2;
            }
        }
        return l2;
    }

    @Override
    public List<OSThread> getThreadDetails() {
        List<String> list = ExecutingCommand.runNative("ps -m -o THREAD -p " + this.getProcessID());
        if (list.size() > 2) {
            ArrayList<OSThread> arrayList = new ArrayList<OSThread>();
            list.remove(0);
            list.remove(0);
            for (String string : list) {
                Map<PsThreadColumns, String> map = ParseUtil.stringToEnumMap(PsThreadColumns.class, string.trim(), ' ');
                if (!map.containsKey((Object)PsThreadColumns.COMMAND)) continue;
                arrayList.add(new AixOSThread(this.getProcessID(), map));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    @Override
    public long getMajorFaults() {
        return this.majorFaults;
    }

    @Override
    public boolean updateAttributes() {
        Perfstat.perfstat_process_t[] perfstat_process_tArray = this.procCpu.get();
        List<String> list = ExecutingCommand.runNative("ps -o " + AixOperatingSystem.PS_COMMAND_ARGS + " -p " + this.getProcessID());
        HashMap<Integer, Pair<Long, Long>> hashMap = new HashMap<Integer, Pair<Long, Long>>();
        Object object = perfstat_process_tArray;
        int n2 = ((Perfstat.perfstat_process_t[])object).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Perfstat.perfstat_process_t perfstat_process_t2 = object[i2];
            hashMap.put((int)perfstat_process_t2.pid, new Pair<Long, Long>((long)perfstat_process_t2.ucpu_time, (long)perfstat_process_t2.scpu_time));
        }
        if (list.size() > 1 && (object = ParseUtil.stringToEnumMap(AixOperatingSystem.PsKeywords.class, list.get(1).trim(), ' ')).containsKey((Object)AixOperatingSystem.PsKeywords.ARGS)) {
            return this.updateAttributes((Map<AixOperatingSystem.PsKeywords, String>)object, hashMap);
        }
        this.state = OSProcess.State.INVALID;
        return false;
    }

    private boolean updateAttributes(Map<AixOperatingSystem.PsKeywords, String> map, Map<Integer, Pair<Long, Long>> map2) {
        long l2 = System.currentTimeMillis();
        this.state = AixOSProcess.getStateFromOutput(map.get((Object)AixOperatingSystem.PsKeywords.ST).charAt(0));
        this.parentProcessID = ParseUtil.parseIntOrDefault(map.get((Object)AixOperatingSystem.PsKeywords.PPID), 0);
        this.user = map.get((Object)AixOperatingSystem.PsKeywords.USER);
        this.userID = map.get((Object)AixOperatingSystem.PsKeywords.UID);
        this.group = map.get((Object)AixOperatingSystem.PsKeywords.GROUP);
        this.groupID = map.get((Object)AixOperatingSystem.PsKeywords.GID);
        this.threadCount = ParseUtil.parseIntOrDefault(map.get((Object)AixOperatingSystem.PsKeywords.THCOUNT), 0);
        this.priority = ParseUtil.parseIntOrDefault(map.get((Object)AixOperatingSystem.PsKeywords.PRI), 0);
        this.virtualSize = ParseUtil.parseLongOrDefault(map.get((Object)AixOperatingSystem.PsKeywords.VSIZE), 0L) << 10;
        this.residentSetSize = ParseUtil.parseLongOrDefault(map.get((Object)AixOperatingSystem.PsKeywords.RSSIZE), 0L) << 10;
        long l3 = ParseUtil.parseDHMSOrDefault(map.get((Object)AixOperatingSystem.PsKeywords.ETIME), 0L);
        if (map2.containsKey(this.getProcessID())) {
            Pair<Long, Long> pair = map2.get(this.getProcessID());
            this.userTime = pair.getA();
            this.kernelTime = pair.getB();
        } else {
            this.userTime = ParseUtil.parseDHMSOrDefault(map.get((Object)AixOperatingSystem.PsKeywords.TIME), 0L);
            this.kernelTime = 0L;
        }
        long l4 = this.upTime = l3 < 1L ? 1L : l3;
        while (this.upTime < this.userTime + this.kernelTime) {
            this.upTime += 500L;
        }
        this.startTime = l2 - this.upTime;
        this.name = map.get((Object)AixOperatingSystem.PsKeywords.COMM);
        this.majorFaults = ParseUtil.parseLongOrDefault(map.get((Object)AixOperatingSystem.PsKeywords.PAGEIN), 0L);
        this.commandLineBackup = map.get((Object)AixOperatingSystem.PsKeywords.ARGS);
        this.path = ParseUtil.whitespaces.split(this.commandLineBackup)[0];
        return true;
    }

    static OSProcess.State getStateFromOutput(char c2) {
        OSProcess.State state;
        switch (c2) {
            case 'O': {
                state = OSProcess.State.INVALID;
                break;
            }
            case 'A': 
            case 'R': {
                state = OSProcess.State.RUNNING;
                break;
            }
            case 'I': {
                state = OSProcess.State.WAITING;
                break;
            }
            case 'S': 
            case 'W': {
                state = OSProcess.State.SLEEPING;
                break;
            }
            case 'Z': {
                state = OSProcess.State.ZOMBIE;
                break;
            }
            case 'T': {
                state = OSProcess.State.STOPPED;
                break;
            }
            default: {
                state = OSProcess.State.OTHER;
            }
        }
        return state;
    }

    static enum PsThreadColumns {
        USER,
        PID,
        PPID,
        TID,
        ST,
        CP,
        PRI,
        SC,
        WCHAN,
        F,
        TT,
        BND,
        COMMAND;

    }
}

