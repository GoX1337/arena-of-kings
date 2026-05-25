/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.solaris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.solaris.PsInfo;
import oshi.software.common.AbstractOSProcess;
import oshi.software.os.OSProcess;
import oshi.software.os.OSThread;
import oshi.software.os.unix.solaris.SolarisOSThread;
import oshi.software.os.unix.solaris.SolarisOperatingSystem;
import oshi.util.ExecutingCommand;
import oshi.util.LsofUtil;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public class SolarisOSProcess
extends AbstractOSProcess {
    static final String PS_THREAD_COLUMNS = Arrays.stream(PsThreadColumns.values()).map(Enum::name).map(String::toLowerCase).collect(Collectors.joining(","));
    private Supplier<Integer> bitness = Memoizer.memoize(this::queryBitness);
    private Supplier<String> commandLine = Memoizer.memoize(this::queryCommandLine);
    private Supplier<Pair<List<String>, Map<String, String>>> cmdEnv = Memoizer.memoize(this::queryCommandlineEnvironment);
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
    private long contextSwitches = 0L;

    public SolarisOSProcess(int n2, Map<SolarisOperatingSystem.PsKeywords, String> map, Map<SolarisOperatingSystem.PrstatKeywords, String> map2) {
        super(n2);
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
    public long getContextSwitches() {
        return this.contextSwitches;
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
        String string = ExecutingCommand.getFirstAnswer("pbind -q " + this.getProcessID());
        if (string.isEmpty()) {
            List<String> list = ExecutingCommand.runNative("psrinfo");
            for (String string2 : list) {
                String[] stringArray = ParseUtil.whitespaces.split(string2);
                int n2 = ParseUtil.parseIntOrDefault(stringArray[0], -1);
                if (n2 < 0) continue;
                l2 |= 1L << n2;
            }
            return l2;
        }
        if (string.endsWith(".") && string.contains("strongly bound to processor(s)")) {
            int n3;
            String string3 = string.substring(0, string.length() - 1);
            String[] stringArray = ParseUtil.whitespaces.split(string3);
            for (int i2 = stringArray.length - 1; i2 >= 0 && (n3 = ParseUtil.parseIntOrDefault(stringArray[i2], -1)) >= 0; --i2) {
                l2 |= 1L << n3;
            }
        }
        return l2;
    }

    @Override
    public List<OSThread> getThreadDetails() {
        ArrayList<OSThread> arrayList = new ArrayList<OSThread>();
        List<String> list = ExecutingCommand.runNative("ps -o " + PS_THREAD_COLUMNS + " -p " + this.getProcessID());
        if (list.size() > 1) {
            Map<PsThreadColumns, String> map;
            List<String> list2 = ExecutingCommand.runNative("prstat -L -v -p " + this.getProcessID() + " 1 1");
            HashMap<String, String> hashMap = new HashMap<String, String>();
            for (String string : list2) {
                map = string.trim();
                int n2 = ((String)((Object)map)).lastIndexOf(47);
                if (n2 <= 0) continue;
                hashMap.put(((String)((Object)map)).substring(n2 + 1), (String)((Object)map));
            }
            list.remove(0);
            for (String string : list) {
                map = ParseUtil.stringToEnumMap(PsThreadColumns.class, string.trim(), ' ');
                if (!map.containsKey((Object)PsThreadColumns.PRI)) continue;
                String string2 = (String)map.get((Object)PsThreadColumns.LWP);
                Map<SolarisOperatingSystem.PrstatKeywords, String> map2 = ParseUtil.stringToEnumMap(SolarisOperatingSystem.PrstatKeywords.class, hashMap.getOrDefault(string2, ""), ' ');
                arrayList.add(new SolarisOSThread(this.getProcessID(), map, map2));
            }
        }
        return arrayList;
    }

    @Override
    public boolean updateAttributes() {
        Map<SolarisOperatingSystem.PsKeywords, String> map;
        int n2 = this.getProcessID();
        List<String> list = ExecutingCommand.runNative("ps -o " + SolarisOperatingSystem.PS_COMMAND_ARGS + " -p " + n2);
        if (list.size() > 1 && (map = ParseUtil.stringToEnumMap(SolarisOperatingSystem.PsKeywords.class, list.get(1).trim(), ' ')).containsKey((Object)SolarisOperatingSystem.PsKeywords.ARGS)) {
            String string = map.get((Object)SolarisOperatingSystem.PsKeywords.PID);
            List<String> list2 = ExecutingCommand.runNative("prstat -v -p " + string + " 1 1");
            String string2 = "";
            for (String string3 : list2) {
                String string4 = string3.trim();
                if (!string4.startsWith(string + " ")) continue;
                string2 = string4;
                break;
            }
            Map<SolarisOperatingSystem.PrstatKeywords, String> map2 = ParseUtil.stringToEnumMap(SolarisOperatingSystem.PrstatKeywords.class, string2, ' ');
            return this.updateAttributes(map, map2);
        }
        this.state = OSProcess.State.INVALID;
        return false;
    }

    private boolean updateAttributes(Map<SolarisOperatingSystem.PsKeywords, String> map, Map<SolarisOperatingSystem.PrstatKeywords, String> map2) {
        long l2 = System.currentTimeMillis();
        this.state = SolarisOSProcess.getStateFromOutput(map.get((Object)SolarisOperatingSystem.PsKeywords.S).charAt(0));
        this.parentProcessID = ParseUtil.parseIntOrDefault(map.get((Object)SolarisOperatingSystem.PsKeywords.PPID), 0);
        this.user = map.get((Object)SolarisOperatingSystem.PsKeywords.USER);
        this.userID = map.get((Object)SolarisOperatingSystem.PsKeywords.UID);
        this.group = map.get((Object)SolarisOperatingSystem.PsKeywords.GROUP);
        this.groupID = map.get((Object)SolarisOperatingSystem.PsKeywords.GID);
        this.threadCount = ParseUtil.parseIntOrDefault(map.get((Object)SolarisOperatingSystem.PsKeywords.NLWP), 0);
        this.priority = ParseUtil.parseIntOrDefault(map.get((Object)SolarisOperatingSystem.PsKeywords.PRI), 0);
        this.virtualSize = ParseUtil.parseLongOrDefault(map.get((Object)SolarisOperatingSystem.PsKeywords.VSZ), 0L) * 1024L;
        this.residentSetSize = ParseUtil.parseLongOrDefault(map.get((Object)SolarisOperatingSystem.PsKeywords.RSS), 0L) * 1024L;
        long l3 = ParseUtil.parseDHMSOrDefault(map.get((Object)SolarisOperatingSystem.PsKeywords.ETIME), 0L);
        this.upTime = l3 < 1L ? 1L : l3;
        this.startTime = l2 - this.upTime;
        this.kernelTime = 0L;
        this.userTime = ParseUtil.parseDHMSOrDefault(map.get((Object)SolarisOperatingSystem.PsKeywords.TIME), 0L);
        this.path = map.get((Object)SolarisOperatingSystem.PsKeywords.COMM);
        this.name = this.path.substring(this.path.lastIndexOf(47) + 1);
        this.commandLineBackup = map.get((Object)SolarisOperatingSystem.PsKeywords.ARGS);
        if (map2.containsKey((Object)SolarisOperatingSystem.PrstatKeywords.ICX)) {
            long l4 = ParseUtil.parseLongOrDefault(map2.get((Object)SolarisOperatingSystem.PrstatKeywords.ICX), 0L);
            long l5 = ParseUtil.parseLongOrDefault(map2.get((Object)SolarisOperatingSystem.PrstatKeywords.VCX), 0L);
            this.contextSwitches = l5 + l4;
        }
        return true;
    }

    static OSProcess.State getStateFromOutput(char c2) {
        OSProcess.State state;
        switch (c2) {
            case 'O': {
                state = OSProcess.State.RUNNING;
                break;
            }
            case 'S': {
                state = OSProcess.State.SLEEPING;
                break;
            }
            case 'R': 
            case 'W': {
                state = OSProcess.State.WAITING;
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
        LWP,
        S,
        ETIME,
        TIME,
        ADDR,
        PRI;

    }
}

