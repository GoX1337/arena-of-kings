/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.common;

import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.OSProcess;
import oshi.util.Memoizer;

@ThreadSafe
public abstract class AbstractOSProcess
implements OSProcess {
    private final Supplier<Double> cumulativeCpuLoad = Memoizer.memoize(this::queryCumulativeCpuLoad, Memoizer.defaultExpiration());
    private int processID;

    public AbstractOSProcess(int n2) {
        this.processID = n2;
    }

    @Override
    public int getProcessID() {
        return this.processID;
    }

    @Override
    public double getProcessCpuLoadCumulative() {
        return this.cumulativeCpuLoad.get();
    }

    private double queryCumulativeCpuLoad() {
        return (double)this.getUpTime() > 0.0 ? (double)(this.getKernelTime() + this.getUserTime()) / (double)this.getUpTime() : 0.0;
    }

    @Override
    public double getProcessCpuLoadBetweenTicks(OSProcess oSProcess) {
        if (oSProcess != null && this.processID == oSProcess.getProcessID() && this.getUpTime() > oSProcess.getUpTime()) {
            return (double)(this.getUserTime() - oSProcess.getUserTime() + this.getKernelTime() - oSProcess.getKernelTime()) / (double)(this.getUpTime() - oSProcess.getUpTime());
        }
        return this.getProcessCpuLoadCumulative();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("OSProcess@");
        stringBuilder.append(Integer.toHexString(this.hashCode()));
        stringBuilder.append("[processID=").append(this.processID);
        stringBuilder.append(", name=").append(this.getName()).append(']');
        return stringBuilder.toString();
    }
}

