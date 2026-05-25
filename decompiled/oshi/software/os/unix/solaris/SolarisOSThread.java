/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.solaris;

import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractOSThread;
import oshi.software.os.OSProcess;
import oshi.software.os.unix.solaris.SolarisOSProcess;
import oshi.software.os.unix.solaris.SolarisOperatingSystem;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public class SolarisOSThread
extends AbstractOSThread {
    private int threadId;
    private OSProcess.State state = OSProcess.State.INVALID;
    private long startMemoryAddress;
    private long contextSwitches;
    private long kernelTime;
    private long userTime;
    private long startTime;
    private long upTime;
    private int priority;

    public SolarisOSThread(int n2, Map<SolarisOSProcess.PsThreadColumns, String> map, Map<SolarisOperatingSystem.PrstatKeywords, String> map2) {
        super(n2);
        this.updateAttributes(map, map2);
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
    public long getStartMemoryAddress() {
        return this.startMemoryAddress;
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
        int n2 = this.getOwningProcessId();
        List<String> list = ExecutingCommand.runNative("ps -o " + SolarisOSProcess.PS_THREAD_COLUMNS + " -p " + n2);
        if (list.size() > 1) {
            String string = Integer.toString(this.threadId);
            for (String string2 : list) {
                Map<SolarisOSProcess.PsThreadColumns, String> map = ParseUtil.stringToEnumMap(SolarisOSProcess.PsThreadColumns.class, string2.trim(), ' ');
                if (!map.containsKey((Object)SolarisOSProcess.PsThreadColumns.PRI) || !string.equals(map.get((Object)SolarisOSProcess.PsThreadColumns.LWP))) continue;
                List<String> list2 = ExecutingCommand.runNative("prstat -L -v -p " + n2 + " 1 1");
                String string3 = "";
                for (String string4 : list2) {
                    String string5 = string4.trim();
                    if (!string5.endsWith("/" + string)) continue;
                    string3 = string5;
                    break;
                }
                Map<SolarisOperatingSystem.PrstatKeywords, String> map2 = ParseUtil.stringToEnumMap(SolarisOperatingSystem.PrstatKeywords.class, string3, ' ');
                return this.updateAttributes(map, map2);
            }
        }
        this.state = OSProcess.State.INVALID;
        return false;
    }

    private boolean updateAttributes(Map<SolarisOSProcess.PsThreadColumns, String> map, Map<SolarisOperatingSystem.PrstatKeywords, String> map2) {
        this.threadId = ParseUtil.parseIntOrDefault(map.get((Object)SolarisOSProcess.PsThreadColumns.LWP), 0);
        this.state = SolarisOSProcess.getStateFromOutput(map.get((Object)SolarisOSProcess.PsThreadColumns.S).charAt(0));
        long l2 = ParseUtil.parseDHMSOrDefault(map.get((Object)SolarisOSProcess.PsThreadColumns.ETIME), 0L);
        this.upTime = l2 < 1L ? 1L : l2;
        long l3 = System.currentTimeMillis();
        this.startTime = l3 - this.upTime;
        this.kernelTime = 0L;
        this.userTime = ParseUtil.parseDHMSOrDefault(map.get((Object)SolarisOSProcess.PsThreadColumns.TIME), 0L);
        this.startMemoryAddress = ParseUtil.hexStringToLong(map.get((Object)SolarisOSProcess.PsThreadColumns.ADDR), 0L);
        this.priority = ParseUtil.parseIntOrDefault(map.get((Object)SolarisOSProcess.PsThreadColumns.PRI), 0);
        long l4 = ParseUtil.parseLongOrDefault(map2.get((Object)SolarisOperatingSystem.PrstatKeywords.ICX), 0L);
        long l5 = ParseUtil.parseLongOrDefault(map2.get((Object)SolarisOperatingSystem.PrstatKeywords.VCX), 0L);
        this.contextSwitches = l5 + l4;
        return true;
    }
}

