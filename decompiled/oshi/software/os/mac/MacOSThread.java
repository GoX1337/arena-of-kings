/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.mac;

import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractOSThread;
import oshi.software.os.OSProcess;

@ThreadSafe
public class MacOSThread
extends AbstractOSThread {
    private final int threadId;
    private final OSProcess.State state;
    private final long kernelTime;
    private final long userTime;
    private final long startTime;
    private final long upTime;
    private final int priority;

    public MacOSThread(int n2, int n3, OSProcess.State state, long l2, long l3, long l4, long l5, int n4) {
        super(n2);
        this.threadId = n3;
        this.state = state;
        this.kernelTime = l2;
        this.userTime = l3;
        this.startTime = l4;
        this.upTime = l5;
        this.priority = n4;
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
}

