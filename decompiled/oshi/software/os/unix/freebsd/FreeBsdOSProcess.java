/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.platform.unix.LibCAPI$size_t$ByReference
 */
package oshi.software.os.unix.freebsd;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.platform.unix.LibCAPI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.unix.FreeBsdLibc;
import oshi.software.common.AbstractOSProcess;
import oshi.software.os.OSProcess;
import oshi.software.os.OSThread;
import oshi.software.os.unix.freebsd.FreeBsdOSThread;
import oshi.software.os.unix.freebsd.FreeBsdOperatingSystem;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.freebsd.BsdSysctlUtil;
import oshi.util.platform.unix.freebsd.ProcstatUtil;

@ThreadSafe
public class FreeBsdOSProcess
extends AbstractOSProcess {
    private static final Logger LOG = LoggerFactory.getLogger(FreeBsdOSProcess.class);
    private static final int ARGMAX = BsdSysctlUtil.sysctl("kern.argmax", 0);
    static final String PS_THREAD_COLUMNS = Arrays.stream(PsThreadColumns.values()).map(Enum::name).map(String::toLowerCase).collect(Collectors.joining(","));
    private Supplier<Integer> bitness = Memoizer.memoize(this::queryBitness);
    private Supplier<String> commandLine = Memoizer.memoize(this::queryCommandLine);
    private Supplier<List<String>> arguments = Memoizer.memoize(this::queryArguments);
    private Supplier<Map<String, String>> environmentVariables = Memoizer.memoize(this::queryEnvironmentVariables);
    private String name;
    private String path = "";
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
    private long minorFaults;
    private long majorFaults;
    private long contextSwitches;
    private String commandLineBackup;

    public FreeBsdOSProcess(int n2, Map<FreeBsdOperatingSystem.PsKeywords, String> map) {
        super(n2);
        this.updateAttributes(map);
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
        return this.arguments.get();
    }

    private List<String> queryArguments() {
        if (ARGMAX > 0) {
            int[] nArray = new int[]{1, 14, 7, this.getProcessID()};
            Memory memory = new Memory(ARGMAX);
            LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t((long)ARGMAX));
            if (FreeBsdLibc.INSTANCE.sysctl(nArray, nArray.length, memory, byReference, null, LibCAPI.size_t.ZERO) == 0) {
                return Collections.unmodifiableList(ParseUtil.parseByteArrayToStrings(memory.getByteArray(0L, byReference.getValue().intValue())));
            }
            LOG.warn("Failed sysctl call for process arguments (kern.proc.args), process {} may not exist. Error code: {}", (Object)this.getProcessID(), (Object)Native.getLastError());
        }
        return Collections.emptyList();
    }

    @Override
    public Map<String, String> getEnvironmentVariables() {
        return this.environmentVariables.get();
    }

    private Map<String, String> queryEnvironmentVariables() {
        if (ARGMAX > 0) {
            int[] nArray = new int[]{1, 14, 35, this.getProcessID()};
            Memory memory = new Memory(ARGMAX);
            LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t((long)ARGMAX));
            if (FreeBsdLibc.INSTANCE.sysctl(nArray, nArray.length, memory, byReference, null, LibCAPI.size_t.ZERO) == 0) {
                return Collections.unmodifiableMap(ParseUtil.parseByteArrayToStringMap(memory.getByteArray(0L, byReference.getValue().intValue())));
            }
            LOG.warn("Failed sysctl call for process environment variables (kern.proc.env), process {} may not exist. Error code: {}", (Object)this.getProcessID(), (Object)Native.getLastError());
        }
        return Collections.emptyMap();
    }

    @Override
    public String getCurrentWorkingDirectory() {
        return ProcstatUtil.getCwd(this.getProcessID());
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
        return ProcstatUtil.getOpenFiles(this.getProcessID());
    }

    @Override
    public int getBitness() {
        return this.bitness.get();
    }

    @Override
    public long getAffinityMask() {
        long l2 = 0L;
        String string = ExecutingCommand.getFirstAnswer("cpuset -gp " + this.getProcessID());
        String[] stringArray = string.split(":");
        if (stringArray.length > 1) {
            String[] stringArray2;
            for (String string2 : stringArray2 = stringArray[1].split(",")) {
                int n2 = ParseUtil.parseIntOrDefault(string2.trim(), -1);
                if (n2 < 0) continue;
                l2 |= 1L << n2;
            }
        }
        return l2;
    }

    private int queryBitness() {
        int[] nArray = new int[]{1, 14, 9, this.getProcessID()};
        Memory memory = new Memory(32L);
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t(32L));
        if (0 == FreeBsdLibc.INSTANCE.sysctl(nArray, nArray.length, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            String string = memory.getString(0L);
            if (string.contains("ELF32")) {
                return 32;
            }
            if (string.contains("ELF64")) {
                return 64;
            }
        }
        return 0;
    }

    @Override
    public List<OSThread> getThreadDetails() {
        List<String> list;
        ArrayList<OSThread> arrayList = new ArrayList<OSThread>();
        String string = "ps -awwxo " + PS_THREAD_COLUMNS + " -H";
        if (this.getProcessID() >= 0) {
            string = string + " -p " + this.getProcessID();
        }
        if ((list = ExecutingCommand.runNative(string)).size() > 1) {
            list.remove(0);
            for (String string2 : list) {
                Map<PsThreadColumns, String> map = ParseUtil.stringToEnumMap(PsThreadColumns.class, string2.trim(), ' ');
                if (!map.containsKey((Object)PsThreadColumns.PRI)) continue;
                arrayList.add(new FreeBsdOSThread(this.getProcessID(), map));
            }
        }
        return arrayList;
    }

    @Override
    public long getMinorFaults() {
        return this.minorFaults;
    }

    @Override
    public long getMajorFaults() {
        return this.majorFaults;
    }

    @Override
    public long getContextSwitches() {
        return this.contextSwitches;
    }

    @Override
    public boolean updateAttributes() {
        Map<FreeBsdOperatingSystem.PsKeywords, String> map;
        String string = "ps -awwxo " + FreeBsdOperatingSystem.PS_COMMAND_ARGS + " -p " + this.getProcessID();
        List<String> list = ExecutingCommand.runNative(string);
        if (list.size() > 1 && (map = ParseUtil.stringToEnumMap(FreeBsdOperatingSystem.PsKeywords.class, list.get(1).trim(), ' ')).containsKey((Object)FreeBsdOperatingSystem.PsKeywords.ARGS)) {
            return this.updateAttributes(map);
        }
        this.state = OSProcess.State.INVALID;
        return false;
    }

    private boolean updateAttributes(Map<FreeBsdOperatingSystem.PsKeywords, String> map) {
        long l2 = System.currentTimeMillis();
        switch (map.get((Object)FreeBsdOperatingSystem.PsKeywords.STATE).charAt(0)) {
            case 'R': {
                this.state = OSProcess.State.RUNNING;
                break;
            }
            case 'I': 
            case 'S': {
                this.state = OSProcess.State.SLEEPING;
                break;
            }
            case 'D': 
            case 'L': 
            case 'U': {
                this.state = OSProcess.State.WAITING;
                break;
            }
            case 'Z': {
                this.state = OSProcess.State.ZOMBIE;
                break;
            }
            case 'T': {
                this.state = OSProcess.State.STOPPED;
                break;
            }
            default: {
                this.state = OSProcess.State.OTHER;
            }
        }
        this.parentProcessID = ParseUtil.parseIntOrDefault(map.get((Object)FreeBsdOperatingSystem.PsKeywords.PPID), 0);
        this.user = map.get((Object)FreeBsdOperatingSystem.PsKeywords.USER);
        this.userID = map.get((Object)FreeBsdOperatingSystem.PsKeywords.UID);
        this.group = map.get((Object)FreeBsdOperatingSystem.PsKeywords.GROUP);
        this.groupID = map.get((Object)FreeBsdOperatingSystem.PsKeywords.GID);
        this.threadCount = ParseUtil.parseIntOrDefault(map.get((Object)FreeBsdOperatingSystem.PsKeywords.NLWP), 0);
        this.priority = ParseUtil.parseIntOrDefault(map.get((Object)FreeBsdOperatingSystem.PsKeywords.PRI), 0);
        this.virtualSize = ParseUtil.parseLongOrDefault(map.get((Object)FreeBsdOperatingSystem.PsKeywords.VSZ), 0L) * 1024L;
        this.residentSetSize = ParseUtil.parseLongOrDefault(map.get((Object)FreeBsdOperatingSystem.PsKeywords.RSS), 0L) * 1024L;
        long l3 = ParseUtil.parseDHMSOrDefault(map.get((Object)FreeBsdOperatingSystem.PsKeywords.ETIMES), 0L);
        this.upTime = l3 < 1L ? 1L : l3;
        this.startTime = l2 - this.upTime;
        this.kernelTime = ParseUtil.parseDHMSOrDefault(map.get((Object)FreeBsdOperatingSystem.PsKeywords.SYSTIME), 0L);
        this.userTime = ParseUtil.parseDHMSOrDefault(map.get((Object)FreeBsdOperatingSystem.PsKeywords.TIME), 0L) - this.kernelTime;
        this.path = map.get((Object)FreeBsdOperatingSystem.PsKeywords.COMM);
        this.name = this.path.substring(this.path.lastIndexOf(47) + 1);
        this.minorFaults = ParseUtil.parseLongOrDefault(map.get((Object)FreeBsdOperatingSystem.PsKeywords.MAJFLT), 0L);
        this.majorFaults = ParseUtil.parseLongOrDefault(map.get((Object)FreeBsdOperatingSystem.PsKeywords.MINFLT), 0L);
        long l4 = ParseUtil.parseLongOrDefault(map.get((Object)FreeBsdOperatingSystem.PsKeywords.NVCSW), 0L);
        long l5 = ParseUtil.parseLongOrDefault(map.get((Object)FreeBsdOperatingSystem.PsKeywords.NIVCSW), 0L);
        this.contextSwitches = l5 + l4;
        this.commandLineBackup = map.get((Object)FreeBsdOperatingSystem.PsKeywords.ARGS);
        return true;
    }

    static enum PsThreadColumns {
        TDNAME,
        LWP,
        STATE,
        ETIMES,
        SYSTIME,
        TIME,
        TDADDR,
        NIVCSW,
        NVCSW,
        MAJFLT,
        MINFLT,
        PRI;

    }
}

