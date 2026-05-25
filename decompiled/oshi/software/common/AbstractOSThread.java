/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.common;

import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.OSThread;
import oshi.util.Memoizer;

@ThreadSafe
public abstract class AbstractOSThread
implements OSThread {
    private final Supplier<Double> cumulativeCpuLoad = Memoizer.memoize(this::queryCumulativeCpuLoad, Memoizer.defaultExpiration());
    private final int owningProcessId;

    public AbstractOSThread(int n2) {
        this.owningProcessId = n2;
    }

    @Override
    public int getOwningProcessId() {
        return this.owningProcessId;
    }

    @Override
    public double getThreadCpuLoadCumulative() {
        return this.cumulativeCpuLoad.get();
    }

    private double queryCumulativeCpuLoad() {
        return (double)this.getUpTime() > 0.0 ? (double)(this.getKernelTime() + this.getUserTime()) / (double)this.getUpTime() : 0.0;
    }

    @Override
    public double getThreadCpuLoadBetweenTicks(OSThread oSThread) {
        if (oSThread != null && this.owningProcessId == oSThread.getOwningProcessId() && this.getThreadId() == oSThread.getThreadId() && this.getUpTime() > oSThread.getUpTime()) {
            return (double)(this.getUserTime() - oSThread.getUserTime() + this.getKernelTime() - oSThread.getKernelTime()) / (double)(this.getUpTime() - oSThread.getUpTime());
        }
        return this.getThreadCpuLoadCumulative();
    }

    public String toString() {
        return "OSThread [threadId=" + this.getThreadId() + ", owningProcessId=" + this.getOwningProcessId() + ", name=" + this.getName() + ", state=" + (Object)((Object)this.getState()) + ", kernelTime=" + this.getKernelTime() + ", userTime=" + this.getUserTime() + ", upTime=" + this.getUpTime() + ", startTime=" + this.getStartTime() + ", startMemoryAddress=0x" + String.format("%x", this.getStartMemoryAddress()) + ", contextSwitches=" + this.getContextSwitches() + ", minorFaults=" + this.getMinorFaults() + ", majorFaults=" + this.getMajorFaults() + "]";
    }
}

