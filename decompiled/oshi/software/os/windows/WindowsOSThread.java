/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.windows;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.windows.registry.ThreadPerformanceData;
import oshi.software.common.AbstractOSThread;
import oshi.software.os.OSProcess;

@ThreadSafe
public class WindowsOSThread
extends AbstractOSThread {
    private final int threadId;
    private String name;
    private OSProcess.State state;
    private long startMemoryAddress;
    private long contextSwitches;
    private long kernelTime;
    private long userTime;
    private long startTime;
    private long upTime;
    private int priority;

    public WindowsOSThread(int n2, int n3, String string, ThreadPerformanceData.PerfCounterBlock perfCounterBlock) {
        super(n2);
        this.threadId = n3;
        this.updateAttributes(string, perfCounterBlock);
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
    public long getKernelTime() {
        return this.kernelTime;
    }

    @Override
    public long getUserTime() {
        return this.userTime;
    }

    @Override
    public long getStartTime() {
        return this.startTime;
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
        Set<Integer> set = Collections.singleton(this.getOwningProcessId());
        Map<Integer, ThreadPerformanceData.PerfCounterBlock> map = ThreadPerformanceData.buildThreadMapFromRegistry(set);
        if (map == null) {
            map = ThreadPerformanceData.buildThreadMapFromPerfCounters(set);
        }
        return this.updateAttributes(this.name.split("/")[0], map.get(this.getThreadId()));
    }

    private boolean updateAttributes(String string, ThreadPerformanceData.PerfCounterBlock perfCounterBlock) {
        if (perfCounterBlock == null) {
            this.state = OSProcess.State.INVALID;
            return false;
        }
        this.name = perfCounterBlock.getName().contains("/") || string.isEmpty() ? perfCounterBlock.getName() : string + "/" + perfCounterBlock.getName();
        if (perfCounterBlock.getThreadWaitReason() == 5) {
            this.state = OSProcess.State.SUSPENDED;
        } else {
            switch (perfCounterBlock.getThreadState()) {
                case 0: {
                    this.state = OSProcess.State.NEW;
                    break;
                }
                case 2: 
                case 3: {
                    this.state = OSProcess.State.RUNNING;
                    break;
                }
                case 4: {
                    this.state = OSProcess.State.STOPPED;
                    break;
                }
                case 5: {
                    this.state = OSProcess.State.SLEEPING;
                    break;
                }
                case 1: 
                case 6: {
                    this.state = OSProcess.State.WAITING;
                    break;
                }
                default: {
                    this.state = OSProcess.State.OTHER;
                }
            }
        }
        this.startMemoryAddress = perfCounterBlock.getStartAddress();
        this.contextSwitches = perfCounterBlock.getContextSwitches();
        this.kernelTime = perfCounterBlock.getKernelTime();
        this.userTime = perfCounterBlock.getUserTime();
        this.startTime = perfCounterBlock.getStartTime();
        this.upTime = System.currentTimeMillis() - perfCounterBlock.getStartTime();
        this.priority = perfCounterBlock.getPriority();
        return true;
    }
}

