/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.CentralProcessor;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;

@ThreadSafe
public abstract class AbstractCentralProcessor
implements CentralProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractCentralProcessor.class);
    private final Supplier<CentralProcessor.ProcessorIdentifier> cpuid = Memoizer.memoize(this::queryProcessorId);
    private final Supplier<Long> maxFreq = Memoizer.memoize(this::queryMaxFreq, Memoizer.defaultExpiration());
    private final Supplier<long[]> currentFreq = Memoizer.memoize(this::queryCurrentFreq, Memoizer.defaultExpiration());
    private final Supplier<Long> contextSwitches = Memoizer.memoize(this::queryContextSwitches, Memoizer.defaultExpiration());
    private final Supplier<Long> interrupts = Memoizer.memoize(this::queryInterrupts, Memoizer.defaultExpiration());
    private final Supplier<long[]> systemCpuLoadTicks = Memoizer.memoize(this::querySystemCpuLoadTicks, Memoizer.defaultExpiration());
    private final Supplier<long[][]> processorCpuLoadTicks = Memoizer.memoize(this::queryProcessorCpuLoadTicks, Memoizer.defaultExpiration());
    private final int physicalPackageCount;
    private final int physicalProcessorCount;
    private final int logicalProcessorCount;
    private final List<CentralProcessor.LogicalProcessor> logicalProcessors = Collections.unmodifiableList(this.initProcessorCounts());

    public AbstractCentralProcessor() {
        HashSet<String> hashSet = new HashSet<String>();
        HashSet<Integer> hashSet2 = new HashSet<Integer>();
        for (CentralProcessor.LogicalProcessor logicalProcessor : this.logicalProcessors) {
            int n2 = logicalProcessor.getPhysicalPackageNumber();
            hashSet.add(logicalProcessor.getPhysicalProcessorNumber() + ":" + n2);
            hashSet2.add(n2);
        }
        this.logicalProcessorCount = this.logicalProcessors.size();
        this.physicalProcessorCount = hashSet.size();
        this.physicalPackageCount = hashSet2.size();
    }

    protected abstract List<CentralProcessor.LogicalProcessor> initProcessorCounts();

    protected abstract CentralProcessor.ProcessorIdentifier queryProcessorId();

    @Override
    public CentralProcessor.ProcessorIdentifier getProcessorIdentifier() {
        return this.cpuid.get();
    }

    @Override
    public long getMaxFreq() {
        return this.maxFreq.get();
    }

    protected abstract long queryMaxFreq();

    @Override
    public long[] getCurrentFreq() {
        long[] lArray = this.currentFreq.get();
        if (lArray.length == this.getLogicalProcessorCount()) {
            return lArray;
        }
        long[] lArray2 = new long[this.getLogicalProcessorCount()];
        Arrays.fill(lArray2, lArray[0]);
        return lArray2;
    }

    protected abstract long[] queryCurrentFreq();

    @Override
    public long getContextSwitches() {
        return this.contextSwitches.get();
    }

    protected abstract long queryContextSwitches();

    @Override
    public long getInterrupts() {
        return this.interrupts.get();
    }

    protected abstract long queryInterrupts();

    @Override
    public List<CentralProcessor.LogicalProcessor> getLogicalProcessors() {
        return this.logicalProcessors;
    }

    @Override
    public long[] getSystemCpuLoadTicks() {
        return this.systemCpuLoadTicks.get();
    }

    protected abstract long[] querySystemCpuLoadTicks();

    @Override
    public long[][] getProcessorCpuLoadTicks() {
        return this.processorCpuLoadTicks.get();
    }

    protected abstract long[][] queryProcessorCpuLoadTicks();

    @Override
    public double getSystemCpuLoadBetweenTicks(long[] lArray) {
        if (lArray.length != CentralProcessor.TickType.values().length) {
            throw new IllegalArgumentException("Tick array " + lArray.length + " should have " + CentralProcessor.TickType.values().length + " elements");
        }
        long[] lArray2 = this.getSystemCpuLoadTicks();
        long l2 = 0L;
        for (int i2 = 0; i2 < lArray2.length; ++i2) {
            l2 += lArray2[i2] - lArray[i2];
        }
        long l3 = lArray2[CentralProcessor.TickType.IDLE.getIndex()] + lArray2[CentralProcessor.TickType.IOWAIT.getIndex()] - lArray[CentralProcessor.TickType.IDLE.getIndex()] - lArray[CentralProcessor.TickType.IOWAIT.getIndex()];
        LOG.trace("Total ticks: {}  Idle ticks: {}", (Object)l2, (Object)l3);
        return l2 > 0L && l3 >= 0L ? (double)(l2 - l3) / (double)l2 : 0.0;
    }

    @Override
    public double[] getProcessorCpuLoadBetweenTicks(long[][] lArray) {
        if (lArray.length != this.logicalProcessorCount || lArray[0].length != CentralProcessor.TickType.values().length) {
            throw new IllegalArgumentException("Tick array " + lArray.length + " should have " + this.logicalProcessorCount + " arrays, each of which has " + CentralProcessor.TickType.values().length + " elements");
        }
        long[][] lArray2 = this.getProcessorCpuLoadTicks();
        double[] dArray = new double[this.logicalProcessorCount];
        for (int i2 = 0; i2 < this.logicalProcessorCount; ++i2) {
            long l2 = 0L;
            for (int i3 = 0; i3 < lArray2[i2].length; ++i3) {
                l2 += lArray2[i2][i3] - lArray[i2][i3];
            }
            long l3 = lArray2[i2][CentralProcessor.TickType.IDLE.getIndex()] + lArray2[i2][CentralProcessor.TickType.IOWAIT.getIndex()] - lArray[i2][CentralProcessor.TickType.IDLE.getIndex()] - lArray[i2][CentralProcessor.TickType.IOWAIT.getIndex()];
            LOG.trace("CPU: {}  Total ticks: {}  Idle ticks: {}", i2, l2, l3);
            dArray[i2] = l2 > 0L && l3 >= 0L ? (double)(l2 - l3) / (double)l2 : 0.0;
        }
        return dArray;
    }

    @Override
    public int getLogicalProcessorCount() {
        return this.logicalProcessorCount;
    }

    @Override
    public int getPhysicalProcessorCount() {
        return this.physicalProcessorCount;
    }

    @Override
    public int getPhysicalPackageCount() {
        return this.physicalPackageCount;
    }

    public static String createProcessorID(String string, String string2, String string3, String[] stringArray) {
        long l2 = 0L;
        long l3 = ParseUtil.parseLongOrDefault(string, 0L);
        long l4 = ParseUtil.parseLongOrDefault(string2, 0L);
        long l5 = ParseUtil.parseLongOrDefault(string3, 0L);
        l2 |= l3 & 0xFL;
        l2 |= (l4 & 0xFL) << 4;
        l2 |= (l4 & 0xF0L) << 16;
        l2 |= (l5 & 0xFL) << 8;
        l2 |= (l5 & 0xF0L) << 20;
        String[] stringArray2 = stringArray;
        int n2 = stringArray2.length;
        block64: for (int i2 = 0; i2 < n2; ++i2) {
            String string4;
            switch (string4 = stringArray2[i2]) {
                case "fpu": {
                    l2 |= 0x100000000L;
                    continue block64;
                }
                case "vme": {
                    l2 |= 0x200000000L;
                    continue block64;
                }
                case "de": {
                    l2 |= 0x400000000L;
                    continue block64;
                }
                case "pse": {
                    l2 |= 0x800000000L;
                    continue block64;
                }
                case "tsc": {
                    l2 |= 0x1000000000L;
                    continue block64;
                }
                case "msr": {
                    l2 |= 0x2000000000L;
                    continue block64;
                }
                case "pae": {
                    l2 |= 0x4000000000L;
                    continue block64;
                }
                case "mce": {
                    l2 |= 0x8000000000L;
                    continue block64;
                }
                case "cx8": {
                    l2 |= 0x10000000000L;
                    continue block64;
                }
                case "apic": {
                    l2 |= 0x20000000000L;
                    continue block64;
                }
                case "sep": {
                    l2 |= 0x80000000000L;
                    continue block64;
                }
                case "mtrr": {
                    l2 |= 0x100000000000L;
                    continue block64;
                }
                case "pge": {
                    l2 |= 0x200000000000L;
                    continue block64;
                }
                case "mca": {
                    l2 |= 0x400000000000L;
                    continue block64;
                }
                case "cmov": {
                    l2 |= 0x800000000000L;
                    continue block64;
                }
                case "pat": {
                    l2 |= 0x1000000000000L;
                    continue block64;
                }
                case "pse-36": {
                    l2 |= 0x2000000000000L;
                    continue block64;
                }
                case "psn": {
                    l2 |= 0x4000000000000L;
                    continue block64;
                }
                case "clfsh": {
                    l2 |= 0x8000000000000L;
                    continue block64;
                }
                case "ds": {
                    l2 |= 0x20000000000000L;
                    continue block64;
                }
                case "acpi": {
                    l2 |= 0x40000000000000L;
                    continue block64;
                }
                case "mmx": {
                    l2 |= 0x80000000000000L;
                    continue block64;
                }
                case "fxsr": {
                    l2 |= 0x100000000000000L;
                    continue block64;
                }
                case "sse": {
                    l2 |= 0x200000000000000L;
                    continue block64;
                }
                case "sse2": {
                    l2 |= 0x400000000000000L;
                    continue block64;
                }
                case "ss": {
                    l2 |= 0x800000000000000L;
                    continue block64;
                }
                case "htt": {
                    l2 |= 0x1000000000000000L;
                    continue block64;
                }
                case "tm": {
                    l2 |= 0x2000000000000000L;
                    continue block64;
                }
                case "ia64": {
                    l2 |= 0x4000000000000000L;
                    continue block64;
                }
                case "pbe": {
                    l2 |= Long.MIN_VALUE;
                    continue block64;
                }
            }
        }
        return String.format("%016X", l2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getProcessorIdentifier().getName());
        stringBuilder.append("\n ").append(this.getPhysicalPackageCount()).append(" physical CPU package(s)");
        stringBuilder.append("\n ").append(this.getPhysicalProcessorCount()).append(" physical CPU core(s)");
        stringBuilder.append("\n ").append(this.getLogicalProcessorCount()).append(" logical CPU(s)");
        stringBuilder.append('\n').append("Identifier: ").append(this.getProcessorIdentifier().getIdentifier());
        stringBuilder.append('\n').append("ProcessorID: ").append(this.getProcessorIdentifier().getProcessorID());
        stringBuilder.append('\n').append("Microarchitecture: ").append(this.getProcessorIdentifier().getMicroarchitecture());
        return stringBuilder.toString();
    }
}

