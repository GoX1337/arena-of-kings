/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.linux;

import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.linux.proc.ProcessStat;
import oshi.software.common.AbstractOSThread;
import oshi.software.os.OSProcess;
import oshi.software.os.linux.LinuxOperatingSystem;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.linux.ProcPath;

@ThreadSafe
public class LinuxOSThread
extends AbstractOSThread {
    private static final int[] PROC_TASK_STAT_ORDERS = new int[ThreadPidStat.values().length];
    private final int threadId;
    private String name;
    private OSProcess.State state = OSProcess.State.INVALID;
    private long minorFaults;
    private long majorFaults;
    private long startMemoryAddress;
    private long contextSwitches;
    private long kernelTime;
    private long userTime;
    private long startTime;
    private long upTime;
    private int priority;

    public LinuxOSThread(int n2, int n3) {
        super(n2);
        this.threadId = n3;
        this.updateAttributes();
    }

    @Override
    public int getThreadId() {
        return this.threadId;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public OSProcess.State getState() {
        return this.state;
    }

    @Override
    public long getStartTime() {
        return this.startTime;
    }

    @Override
    public long getStartMemoryAddress() {
        return this.startMemoryAddress;
    }

    @Override
    public long getContextSwitches() {
        return this.contextSwitches;
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
    public int getPriority() {
        return this.priority;
    }

    @Override
    public boolean updateAttributes() {
        this.name = FileUtil.getStringFromFile(String.format(ProcPath.TASK_COMM, this.getOwningProcessId(), this.threadId));
        Map<String, String> map = FileUtil.getKeyValueMapFromFile(String.format(ProcPath.TASK_STATUS, this.getOwningProcessId(), this.threadId), ":");
        String string = FileUtil.getStringFromFile(String.format(ProcPath.TASK_STAT, this.getOwningProcessId(), this.threadId));
        if (string.isEmpty()) {
            this.state = OSProcess.State.INVALID;
            return false;
        }
        long l2 = System.currentTimeMillis();
        long[] lArray = ParseUtil.parseStringToLongArray(string, PROC_TASK_STAT_ORDERS, ProcessStat.PROC_PID_STAT_LENGTH, ' ');
        this.startTime = (LinuxOperatingSystem.BOOTTIME * LinuxOperatingSystem.getHz() + lArray[ThreadPidStat.START_TIME.ordinal()]) * 1000L / LinuxOperatingSystem.getHz();
        if (this.startTime >= l2) {
            this.startTime = l2 - 1L;
        }
        this.minorFaults = lArray[ThreadPidStat.MINOR_FAULTS.ordinal()];
        this.majorFaults = lArray[ThreadPidStat.MAJOR_FAULT.ordinal()];
        this.startMemoryAddress = lArray[ThreadPidStat.START_CODE.ordinal()];
        long l3 = ParseUtil.parseLongOrDefault(map.get("voluntary_ctxt_switches"), 0L);
        long l4 = ParseUtil.parseLongOrDefault(map.get("nonvoluntary_ctxt_switches"), 0L);
        this.contextSwitches = l3 + l4;
        this.state = ProcessStat.getState(map.getOrDefault("State", "U").charAt(0));
        this.kernelTime = lArray[ThreadPidStat.KERNEL_TIME.ordinal()] * 1000L / LinuxOperatingSystem.getHz();
        this.userTime = lArray[ThreadPidStat.USER_TIME.ordinal()] * 1000L / LinuxOperatingSystem.getHz();
        this.upTime = l2 - this.startTime;
        this.priority = (int)lArray[ThreadPidStat.PRIORITY.ordinal()];
        return true;
    }

    static {
        for (ThreadPidStat threadPidStat : ThreadPidStat.values()) {
            LinuxOSThread.PROC_TASK_STAT_ORDERS[threadPidStat.ordinal()] = threadPidStat.getOrder() - 1;
        }
    }

    static enum ThreadPidStat {
        PPID(4),
        MINOR_FAULTS(10),
        MAJOR_FAULT(12),
        USER_TIME(14),
        KERNEL_TIME(15),
        PRIORITY(18),
        THREAD_COUNT(20),
        START_TIME(22),
        VSZ(23),
        RSS(24),
        START_CODE(26);

        private final int order;

        private ThreadPidStat(int n3) {
            this.order = n3;
        }

        public int getOrder() {
            return this.order;
        }
    }
}

