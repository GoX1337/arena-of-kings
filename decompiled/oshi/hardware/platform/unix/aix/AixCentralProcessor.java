/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.aix;

import com.sun.jna.Native;
import com.sun.jna.platform.unix.aix.Perfstat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.aix.Lssrad;
import oshi.driver.unix.aix.perfstat.PerfstatConfig;
import oshi.driver.unix.aix.perfstat.PerfstatCpu;
import oshi.hardware.CentralProcessor;
import oshi.hardware.common.AbstractCentralProcessor;
import oshi.util.ExecutingCommand;
import oshi.util.FileUtil;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
final class AixCentralProcessor
extends AbstractCentralProcessor {
    private final Supplier<Perfstat.perfstat_cpu_total_t> cpuTotal = Memoizer.memoize(PerfstatCpu::queryCpuTotal, Memoizer.defaultExpiration());
    private final Supplier<Perfstat.perfstat_cpu_t[]> cpuProc = Memoizer.memoize(PerfstatCpu::queryCpu, Memoizer.defaultExpiration());
    private static final int SBITS = AixCentralProcessor.querySbits();
    private Perfstat.perfstat_partition_config_t config;
    private static final long USER_HZ = ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("getconf CLK_TCK"), 100L);

    AixCentralProcessor() {
    }

    @Override
    public CentralProcessor.ProcessorIdentifier queryProcessorId() {
        String string8;
        String string2 = "unknown";
        String string3 = "";
        String string4 = "";
        boolean bl2 = false;
        String string5 = "Processor Type:";
        String string6 = "Processor Version:";
        String string7 = "CPU Type:";
        for (String string8 : ExecutingCommand.runNative("prtconf")) {
            if (string8.startsWith("Processor Type:")) {
                string3 = string8.split("Processor Type:")[1].trim();
                if (string3.startsWith("P")) {
                    string2 = "IBM";
                    continue;
                }
                if (!string3.startsWith("I")) continue;
                string2 = "Intel";
                continue;
            }
            if (string8.startsWith("Processor Version:")) {
                string4 = string8.split("Processor Version:")[1].trim();
                continue;
            }
            if (!string8.startsWith("CPU Type:")) continue;
            bl2 = string8.split("CPU Type:")[1].contains("64");
        }
        Object object = "";
        string8 = "";
        String string9 = Native.toString(this.config.machineID);
        if (string9.isEmpty()) {
            string9 = ExecutingCommand.getFirstAnswer("uname -m");
        }
        if (string9.length() > 10) {
            int n2 = string9.length() - 4;
            int n3 = string9.length() - 2;
            object = string9.substring(n2, n3);
            string8 = string9.substring(n3);
        }
        return new CentralProcessor.ProcessorIdentifier(string2, string3, string4, (String)object, string8, string9, bl2, (long)(this.config.processorMHz * 1000000.0));
    }

    @Override
    public List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
        int n2;
        this.config = PerfstatConfig.queryConfig();
        int n3 = (int)this.config.numProcessors.max;
        if (n3 < 1) {
            n3 = 1;
        }
        if ((n2 = this.config.lcpus) < 1) {
            n2 = 1;
        }
        Map<Integer, Pair<Integer, Integer>> map = Lssrad.queryNodesPackages();
        ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList<CentralProcessor.LogicalProcessor>();
        for (int i2 = 0; i2 < n2; ++i2) {
            Pair<Integer, Integer> pair = map.get(i2);
            arrayList.add(new CentralProcessor.LogicalProcessor(i2, i2 / n3, pair == null ? 0 : pair.getB(), pair == null ? 0 : pair.getA()));
        }
        return arrayList;
    }

    @Override
    public long[] querySystemCpuLoadTicks() {
        Perfstat.perfstat_cpu_total_t perfstat_cpu_total_t2 = this.cpuTotal.get();
        long[] lArray = new long[CentralProcessor.TickType.values().length];
        lArray[CentralProcessor.TickType.USER.ordinal()] = perfstat_cpu_total_t2.user * 1000L / USER_HZ;
        lArray[CentralProcessor.TickType.SYSTEM.ordinal()] = perfstat_cpu_total_t2.sys * 1000L / USER_HZ;
        lArray[CentralProcessor.TickType.IDLE.ordinal()] = perfstat_cpu_total_t2.idle * 1000L / USER_HZ;
        lArray[CentralProcessor.TickType.IOWAIT.ordinal()] = perfstat_cpu_total_t2.wait * 1000L / USER_HZ;
        lArray[CentralProcessor.TickType.IRQ.ordinal()] = perfstat_cpu_total_t2.devintrs * 1000L / USER_HZ;
        lArray[CentralProcessor.TickType.SOFTIRQ.ordinal()] = perfstat_cpu_total_t2.softintrs * 1000L / USER_HZ;
        lArray[CentralProcessor.TickType.STEAL.ordinal()] = (perfstat_cpu_total_t2.idle_stolen_purr + perfstat_cpu_total_t2.busy_stolen_purr) * 1000L / USER_HZ;
        return lArray;
    }

    @Override
    public long[] queryCurrentFreq() {
        long[] lArray = new long[this.getLogicalProcessorCount()];
        Arrays.fill(lArray, -1L);
        String string = "runs at";
        int n2 = 0;
        for (String string2 : ExecutingCommand.runNative("pmcycles -m")) {
            if (!string2.contains(string)) continue;
            lArray[n2++] = ParseUtil.parseHertz(string2.split(string)[1].trim());
            if (n2 < lArray.length) continue;
            break;
        }
        return lArray;
    }

    @Override
    public long queryMaxFreq() {
        Perfstat.perfstat_cpu_total_t perfstat_cpu_total_t2 = this.cpuTotal.get();
        return perfstat_cpu_total_t2.processorHZ;
    }

    @Override
    public double[] getSystemLoadAverage(int n2) {
        if (n2 < 1 || n2 > 3) {
            throw new IllegalArgumentException("Must include from one to three elements.");
        }
        double[] dArray = new double[n2];
        long[] lArray = this.cpuTotal.get().loadavg;
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = (double)lArray[i2] / (double)(1L << SBITS);
        }
        return dArray;
    }

    @Override
    public long[][] queryProcessorCpuLoadTicks() {
        Perfstat.perfstat_cpu_t[] perfstat_cpu_tArray = this.cpuProc.get();
        long[][] lArray = new long[perfstat_cpu_tArray.length][CentralProcessor.TickType.values().length];
        for (int i2 = 0; i2 < perfstat_cpu_tArray.length; ++i2) {
            lArray[i2] = new long[CentralProcessor.TickType.values().length];
            lArray[i2][CentralProcessor.TickType.USER.ordinal()] = perfstat_cpu_tArray[i2].user * 1000L / USER_HZ;
            lArray[i2][CentralProcessor.TickType.SYSTEM.ordinal()] = perfstat_cpu_tArray[i2].sys * 1000L / USER_HZ;
            lArray[i2][CentralProcessor.TickType.IDLE.ordinal()] = perfstat_cpu_tArray[i2].idle * 1000L / USER_HZ;
            lArray[i2][CentralProcessor.TickType.IOWAIT.ordinal()] = perfstat_cpu_tArray[i2].wait * 1000L / USER_HZ;
            lArray[i2][CentralProcessor.TickType.IRQ.ordinal()] = perfstat_cpu_tArray[i2].devintrs * 1000L / USER_HZ;
            lArray[i2][CentralProcessor.TickType.SOFTIRQ.ordinal()] = perfstat_cpu_tArray[i2].softintrs * 1000L / USER_HZ;
            lArray[i2][CentralProcessor.TickType.STEAL.ordinal()] = (perfstat_cpu_tArray[i2].idle_stolen_purr + perfstat_cpu_tArray[i2].busy_stolen_purr) * 1000L / USER_HZ;
        }
        return lArray;
    }

    @Override
    public long queryContextSwitches() {
        return this.cpuTotal.get().pswitch;
    }

    @Override
    public long queryInterrupts() {
        Perfstat.perfstat_cpu_total_t perfstat_cpu_total_t2 = this.cpuTotal.get();
        return perfstat_cpu_total_t2.devintrs + perfstat_cpu_total_t2.softintrs;
    }

    private static int querySbits() {
        for (String string : FileUtil.readFile("/usr/include/sys/proc.h")) {
            if (!string.contains("SBITS") || !string.contains("#define")) continue;
            return ParseUtil.parseLastInt(string, 16);
        }
        return 16;
    }
}

