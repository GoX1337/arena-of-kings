/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;

public class TimedSemaphore {
    public static final int NO_LIMIT = 0;
    private static final int THREAD_POOL_SIZE = 1;
    private final ScheduledExecutorService executorService;
    private final long period;
    private final TimeUnit unit;
    private final boolean ownExecutor;
    private ScheduledFuture<?> task;
    private long totalAcquireCount;
    private long periodCount;
    private int limit;
    private int acquireCount;
    private int lastCallsPerPeriod;
    private boolean shutdown;

    public TimedSemaphore(long l2, TimeUnit timeUnit, int n2) {
        this(null, l2, timeUnit, n2);
    }

    public TimedSemaphore(ScheduledExecutorService scheduledExecutorService, long l2, TimeUnit timeUnit, int n2) {
        Validate.inclusiveBetween(1L, Long.MAX_VALUE, l2, "Time period must be greater than 0!");
        this.period = l2;
        this.unit = timeUnit;
        if (scheduledExecutorService != null) {
            this.executorService = scheduledExecutorService;
            this.ownExecutor = false;
        } else {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.executorService = scheduledThreadPoolExecutor;
            this.ownExecutor = true;
        }
        this.setLimit(n2);
    }

    public final synchronized int getLimit() {
        return this.limit;
    }

    public final synchronized void setLimit(int n2) {
        this.limit = n2;
    }

    public synchronized void shutdown() {
        if (!this.shutdown) {
            if (this.ownExecutor) {
                this.getExecutorService().shutdownNow();
            }
            if (this.task != null) {
                this.task.cancel(false);
            }
            this.shutdown = true;
        }
    }

    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    public synchronized void acquire() {
        boolean bl2;
        this.prepareAcquire();
        do {
            if (bl2 = this.acquirePermit()) continue;
            this.wait();
        } while (!bl2);
    }

    public synchronized boolean tryAcquire() {
        this.prepareAcquire();
        return this.acquirePermit();
    }

    public synchronized int getLastAcquiresPerPeriod() {
        return this.lastCallsPerPeriod;
    }

    public synchronized int getAcquireCount() {
        return this.acquireCount;
    }

    public synchronized int getAvailablePermits() {
        return this.getLimit() - this.getAcquireCount();
    }

    public synchronized double getAverageCallsPerPeriod() {
        return this.periodCount == 0L ? 0.0 : (double)this.totalAcquireCount / (double)this.periodCount;
    }

    public long getPeriod() {
        return this.period;
    }

    public TimeUnit getUnit() {
        return this.unit;
    }

    protected ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    protected ScheduledFuture<?> startTimer() {
        return this.getExecutorService().scheduleAtFixedRate(this::endOfPeriod, this.getPeriod(), this.getPeriod(), this.getUnit());
    }

    synchronized void endOfPeriod() {
        this.lastCallsPerPeriod = this.acquireCount;
        this.totalAcquireCount += (long)this.acquireCount;
        ++this.periodCount;
        this.acquireCount = 0;
        this.notifyAll();
    }

    private void prepareAcquire() {
        if (this.isShutdown()) {
            throw new IllegalStateException("TimedSemaphore is shut down!");
        }
        if (this.task == null) {
            this.task = this.startTimer();
        }
    }

    private boolean acquirePermit() {
        if (this.getLimit() <= 0 || this.acquireCount < this.getLimit()) {
            ++this.acquireCount;
            return true;
        }
        return false;
    }
}

