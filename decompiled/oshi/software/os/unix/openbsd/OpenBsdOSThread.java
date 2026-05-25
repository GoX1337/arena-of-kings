/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.openbsd;

import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractOSThread;
import oshi.software.os.OSProcess;
import oshi.software.os.unix.openbsd.OpenBsdOSProcess;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public class OpenBsdOSThread
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

    public OpenBsdOSThread(int n2, Map<OpenBsdOSProcess.PsThreadColumns, String> map) {
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
        String string = "ps -aHwwxo " + OpenBsdOSProcess.PS_THREAD_COLUMNS + " -p " + this.getOwningProcessId();
        List<String> list = ExecutingCommand.runNative(string);
        String string2 = Integer.toString(this.threadId);
        for (String string3 : list) {
            Map<OpenBsdOSProcess.PsThreadColumns, String> map = ParseUtil.stringToEnumMap(OpenBsdOSProcess.PsThreadColumns.class, string3.trim(), ' ');
            if (!map.containsKey((Object)OpenBsdOSProcess.PsThreadColumns.ARGS) || !string2.equals(map.get((Object)OpenBsdOSProcess.PsThreadColumns.TID))) continue;
            return this.updateAttributes(map);
        }
        this.state = OSProcess.State.INVALID;
        return false;
    }

    private boolean updateAttributes(Map<OpenBsdOSProcess.PsThreadColumns, String> map) {
        this.threadId = ParseUtil.parseIntOrDefault(map.get((Object)OpenBsdOSProcess.PsThreadColumns.TID), 0);
        switch (map.get((Object)OpenBsdOSProcess.PsThreadColumns.STATE).charAt(0)) {
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
        long l2 = ParseUtil.parseDHMSOrDefault(map.get((Object)OpenBsdOSProcess.PsThreadColumns.ETIME), 0L);
        this.upTime = l2 < 1L ? 1L : l2;
        long l3 = System.currentTimeMillis();
        this.startTime = l3 - this.upTime;
        this.kernelTime = 0L;
        this.userTime = ParseUtil.parseDHMSOrDefault(map.get((Object)OpenBsdOSProcess.PsThreadColumns.CPUTIME), 0L);
        this.startMemoryAddress = 0L;
        long l4 = ParseUtil.parseLongOrDefault(map.get((Object)OpenBsdOSProcess.PsThreadColumns.NIVCSW), 0L);
        long l5 = ParseUtil.parseLongOrDefault(map.get((Object)OpenBsdOSProcess.PsThreadColumns.NVCSW), 0L);
        this.contextSwitches = l5 + l4;
        this.majorFaults = ParseUtil.parseLongOrDefault(map.get((Object)OpenBsdOSProcess.PsThreadColumns.MAJFLT), 0L);
        this.minorFaults = ParseUtil.parseLongOrDefault(map.get((Object)OpenBsdOSProcess.PsThreadColumns.MINFLT), 0L);
        this.priority = ParseUtil.parseIntOrDefault(map.get((Object)OpenBsdOSProcess.PsThreadColumns.PRI), 0);
        this.name = map.get((Object)OpenBsdOSProcess.PsThreadColumns.ARGS);
        return true;
    }
}

