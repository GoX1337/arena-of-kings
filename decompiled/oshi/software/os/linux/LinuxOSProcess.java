/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.linux;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.linux.proc.ProcessStat;
import oshi.driver.linux.proc.UserGroupInfo;
import oshi.hardware.platform.linux.LinuxGlobalMemory;
import oshi.software.common.AbstractOSProcess;
import oshi.software.os.OSProcess;
import oshi.software.os.OSThread;
import oshi.software.os.linux.LinuxOSThread;
import oshi.software.os.linux.LinuxOperatingSystem;
import oshi.util.ExecutingCommand;
import oshi.util.FileUtil;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.Util;
import oshi.util.platform.linux.ProcPath;

@ThreadSafe
public class LinuxOSProcess
extends AbstractOSProcess {
    private static final Logger LOG = LoggerFactory.getLogger(LinuxOSProcess.class);
    private static final int[] PROC_PID_STAT_ORDERS = new int[ProcPidStat.values().length];
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

    public LinuxOSProcess(int n2) {
        super(n2);
        this.updateAttributes();
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
        return Arrays.stream(FileUtil.getStringFromFile(String.format(ProcPath.PID_CMDLINE, this.getProcessID())).split("\u0000")).collect(Collectors.joining(" "));
    }

    @Override
    public List<String> getArguments() {
        return this.arguments.get();
    }

    private List<String> queryArguments() {
        return Collections.unmodifiableList(ParseUtil.parseByteArrayToStrings(FileUtil.readAllBytes(String.format(ProcPath.PID_CMDLINE, this.getProcessID()))));
    }

    @Override
    public Map<String, String> getEnvironmentVariables() {
        return this.environmentVariables.get();
    }

    private Map<String, String> queryEnvironmentVariables() {
        return Collections.unmodifiableMap(ParseUtil.parseByteArrayToStringMap(FileUtil.readAllBytes(String.format(ProcPath.PID_ENVIRON, this.getProcessID()))));
    }

    @Override
    public String getCurrentWorkingDirectory() {
        try {
            String string = String.format(ProcPath.PID_CWD, this.getProcessID());
            String string2 = new File(string).getCanonicalPath();
            if (!string2.equals(string)) {
                return string2;
            }
        }
        catch (IOException iOException) {
            LOG.trace("Couldn't find cwd for pid {}: {}", (Object)this.getProcessID(), (Object)iOException.getMessage());
        }
        return "";
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
    public List<OSThread> getThreadDetails() {
        return ProcessStat.getThreadIds(this.getProcessID()).stream().map(n2 -> new LinuxOSThread(this.getProcessID(), (int)n2)).collect(Collectors.toList());
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
    public long getOpenFiles() {
        return ProcessStat.getFileDescriptorFiles(this.getProcessID()).length;
    }

    @Override
    public int getBitness() {
        return this.bitness.get();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int queryBitness() {
        byte[] byArray = new byte[5];
        if (this.path.isEmpty()) return 0;
        try (FileInputStream fileInputStream = new FileInputStream(this.path);){
            if (((InputStream)fileInputStream).read(byArray) != byArray.length) return 0;
            int n2 = byArray[4] == 1 ? 32 : 64;
            return n2;
        }
        catch (IOException iOException) {
            LOG.warn("Failed to read process file: {}", (Object)this.path);
        }
        return 0;
    }

    @Override
    public long getAffinityMask() {
        String string = ExecutingCommand.getFirstAnswer("taskset -p " + this.getProcessID());
        String[] stringArray = ParseUtil.whitespaces.split(string);
        try {
            return new BigInteger(stringArray[stringArray.length - 1], 16).longValue();
        }
        catch (NumberFormatException numberFormatException) {
            return 0L;
        }
    }

    @Override
    public boolean updateAttributes() {
        Object object;
        String string = String.format(ProcPath.PID_EXE, this.getProcessID());
        try {
            object = Paths.get(string, new String[0]);
            this.path = Files.readSymbolicLink((Path)object).toString();
            int n2 = this.path.indexOf(" (deleted)");
            if (n2 != -1) {
                this.path = this.path.substring(0, n2);
            }
        }
        catch (IOException | SecurityException | UnsupportedOperationException | InvalidPathException exception) {
            LOG.debug("Unable to open symbolic link {}", (Object)string);
        }
        object = FileUtil.getKeyValueMapFromFile(String.format(ProcPath.PID_IO, this.getProcessID()), ":");
        Map<String, String> map = FileUtil.getKeyValueMapFromFile(String.format(ProcPath.PID_STATUS, this.getProcessID()), ":");
        String string2 = FileUtil.getStringFromFile(String.format(ProcPath.PID_STAT, this.getProcessID()));
        if (string2.isEmpty()) {
            this.state = OSProcess.State.INVALID;
            return false;
        }
        LinuxOSProcess.getMissingDetails(map, string2);
        long l2 = System.currentTimeMillis();
        long[] lArray = ParseUtil.parseStringToLongArray(string2, PROC_PID_STAT_ORDERS, ProcessStat.PROC_PID_STAT_LENGTH, ' ');
        this.startTime = (LinuxOperatingSystem.BOOTTIME * LinuxOperatingSystem.getHz() + lArray[ProcPidStat.START_TIME.ordinal()]) * 1000L / LinuxOperatingSystem.getHz();
        if (this.startTime >= l2) {
            this.startTime = l2 - 1L;
        }
        this.parentProcessID = (int)lArray[ProcPidStat.PPID.ordinal()];
        this.threadCount = (int)lArray[ProcPidStat.THREAD_COUNT.ordinal()];
        this.priority = (int)lArray[ProcPidStat.PRIORITY.ordinal()];
        this.virtualSize = lArray[ProcPidStat.VSZ.ordinal()];
        this.residentSetSize = lArray[ProcPidStat.RSS.ordinal()] * LinuxGlobalMemory.PAGE_SIZE;
        this.kernelTime = lArray[ProcPidStat.KERNEL_TIME.ordinal()] * 1000L / LinuxOperatingSystem.getHz();
        this.userTime = lArray[ProcPidStat.USER_TIME.ordinal()] * 1000L / LinuxOperatingSystem.getHz();
        this.minorFaults = lArray[ProcPidStat.MINOR_FAULTS.ordinal()];
        this.majorFaults = lArray[ProcPidStat.MAJOR_FAULTS.ordinal()];
        long l3 = ParseUtil.parseLongOrDefault(map.get("nonvoluntary_ctxt_switches"), 0L);
        long l4 = ParseUtil.parseLongOrDefault(map.get("voluntary_ctxt_switches"), 0L);
        this.contextSwitches = l4 + l3;
        this.upTime = l2 - this.startTime;
        this.bytesRead = ParseUtil.parseLongOrDefault(object.getOrDefault("read_bytes", ""), 0L);
        this.bytesWritten = ParseUtil.parseLongOrDefault(object.getOrDefault("write_bytes", ""), 0L);
        this.userID = ParseUtil.whitespaces.split(map.getOrDefault("Uid", ""))[0];
        this.user = UserGroupInfo.getUser(this.userID);
        this.groupID = ParseUtil.whitespaces.split(map.getOrDefault("Gid", ""))[0];
        this.group = UserGroupInfo.getGroupName(this.groupID);
        this.name = map.getOrDefault("Name", "");
        this.state = ProcessStat.getState(map.getOrDefault("State", "U").charAt(0));
        return true;
    }

    private static void getMissingDetails(Map<String, String> map, String string) {
        String string2;
        if (map == null || string == null) {
            return;
        }
        int n2 = string.indexOf(40);
        int n3 = string.indexOf(41);
        if (Util.isBlank(map.get("Name")) && n2 > 0 && n2 < n3) {
            string2 = string.substring(n2 + 1, n3);
            map.put("Name", string2);
        }
        if (Util.isBlank(map.get("State")) && n3 > 0 && string.length() > n3 + 2) {
            string2 = String.valueOf(string.charAt(n3 + 2));
            map.put("State", string2);
        }
    }

    static {
        for (ProcPidStat procPidStat : ProcPidStat.values()) {
            LinuxOSProcess.PROC_PID_STAT_ORDERS[procPidStat.ordinal()] = procPidStat.getOrder() - 1;
        }
    }

    static enum ProcPidStat {
        PPID(4),
        MINOR_FAULTS(10),
        MAJOR_FAULTS(12),
        USER_TIME(14),
        KERNEL_TIME(15),
        PRIORITY(18),
        THREAD_COUNT(20),
        START_TIME(22),
        VSZ(23),
        RSS(24);

        private final int order;

        public int getOrder() {
            return this.order;
        }

        private ProcPidStat(int n3) {
            this.order = n3;
        }
    }
}

