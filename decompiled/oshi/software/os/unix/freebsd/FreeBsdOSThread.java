/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.freebsd;

import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractOSThread;
import oshi.software.os.OSProcess;
import oshi.software.os.unix.freebsd.FreeBsdOSProcess;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public class FreeBsdOSThread
extends AbstractOSThread {
    private int threadId;
    private String name = "";
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

    public FreeBsdOSThread(int n2, Map<FreeBsdOSProcess.PsThreadColumns, String> map) {
        super(n2);
        this.updateAttributes(map);
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
    public long getStartTime() {
        return this.startTime;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public boolean updateAttributes() {
        List<String> list = ExecutingCommand.runNative("ps -awwxo " + FreeBsdOSProcess.PS_THREAD_COLUMNS + " -H -p " + this.getOwningProcessId());
        String string = Integer.toString(this.threadId);
        for (String string2 : list) {
            Map<FreeBsdOSProcess.PsThreadColumns, String> map = ParseUtil.stringToEnumMap(FreeBsdOSProcess.PsThreadColumns.class, string2.trim(), ' ');
            if (!map.containsKey((Object)FreeBsdOSProcess.PsThreadColumns.PRI) || !string.equals(map.get((Object)FreeBsdOSProcess.PsThreadColumns.LWP))) continue;
            return this.updateAttributes(map);
        }
        this.state = OSProcess.State.INVALID;
        return false;
    }

    private boolean updateAttributes(Map<FreeBsdOSProcess.PsThreadColumns, String> map) {
        this.name = map.get((Object)FreeBsdOSProcess.PsThreadColumns.TDNAME);
        this.threadId = ParseUtil.parseIntOrDefault(map.get((Object)FreeBsdOSProcess.PsThreadColumns.LWP), 0);
        switch (map.get((Object)FreeBsdOSProcess.PsThreadColumns.STATE).charAt(0)) {
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
        long l2 = ParseUtil.parseDHMSOrDefault(map.get((Object)FreeBsdOSProcess.PsThreadColumns.ETIMES), 0L);
        this.upTime = l2 < 1L ? 1L : l2;
        long l3 = System.currentTimeMillis();
        this.startTime = l3 - this.upTime;
        this.kernelTime = ParseUtil.parseDHMSOrDefault(map.get((Object)FreeBsdOSProcess.PsThreadColumns.SYSTIME), 0L);
        this.userTime = ParseUtil.parseDHMSOrDefault(map.get((Object)FreeBsdOSProcess.PsThreadColumns.TIME), 0L) - this.kernelTime;
        this.startMemoryAddress = ParseUtil.hexStringToLong(map.get((Object)FreeBsdOSProcess.PsThreadColumns.TDADDR), 0L);
        long l4 = ParseUtil.parseLongOrDefault(map.get((Object)FreeBsdOSProcess.PsThreadColumns.NIVCSW), 0L);
        long l5 = ParseUtil.parseLongOrDefault(map.get((Object)FreeBsdOSProcess.PsThreadColumns.NVCSW), 0L);
        this.contextSwitches = l5 + l4;
        this.majorFaults = ParseUtil.parseLongOrDefault(map.get((Object)FreeBsdOSProcess.PsThreadColumns.MAJFLT), 0L);
        this.minorFaults = ParseUtil.parseLongOrDefault(map.get((Object)FreeBsdOSProcess.PsThreadColumns.MINFLT), 0L);
        this.priority = ParseUtil.parseIntOrDefault(map.get((Object)FreeBsdOSProcess.PsThreadColumns.PRI), 0);
        return true;
    }
}

