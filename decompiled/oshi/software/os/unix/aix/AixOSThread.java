/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.aix;

import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractOSThread;
import oshi.software.os.OSProcess;
import oshi.software.os.unix.aix.AixOSProcess;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public class AixOSThread
extends AbstractOSThread {
    private int threadId;
    private OSProcess.State state = OSProcess.State.INVALID;
    private long contextSwitches;
    private long kernelTime;
    private long userTime;
    private long startTime;
    private long upTime;
    private int priority;

    public AixOSThread(int n2, Map<AixOSProcess.PsThreadColumns, String> map) {
        super(n2);
        this.updateAttributes(map);
    }

    @Override
    public int getThreadId() {
        return this.threadId;
    }

    @Override
    public OSProcess.State getState() {
        return this.state;
    }

    @Override
    public long getContextSwitches() {
        return this.contextSwitches;
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
        List<String> list = ExecutingCommand.runNative("ps -m -o THREAD -p " + this.getOwningProcessId());
        if (list.size() > 2) {
            list.remove(0);
            list.remove(0);
            String string = Integer.toString(this.getThreadId());
            for (String string2 : list) {
                Map<AixOSProcess.PsThreadColumns, String> map = ParseUtil.stringToEnumMap(AixOSProcess.PsThreadColumns.class, string2.trim(), ' ');
                if (!map.containsKey((Object)AixOSProcess.PsThreadColumns.COMMAND) || !string.equals(map.get((Object)AixOSProcess.PsThreadColumns.TID))) continue;
                return this.updateAttributes(map);
            }
        }
        this.state = OSProcess.State.INVALID;
        return false;
    }

    private boolean updateAttributes(Map<AixOSProcess.PsThreadColumns, String> map) {
        this.threadId = ParseUtil.parseIntOrDefault(map.get((Object)AixOSProcess.PsThreadColumns.TID), 0);
        this.state = AixOSProcess.getStateFromOutput(map.get((Object)AixOSProcess.PsThreadColumns.ST).charAt(0));
        this.priority = ParseUtil.parseIntOrDefault(map.get((Object)AixOSProcess.PsThreadColumns.PRI), 0);
        return true;
    }
}

