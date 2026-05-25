/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.openbsd;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.CentralProcessor;
import oshi.hardware.common.AbstractCentralProcessor;
import oshi.jna.platform.unix.OpenBsdLibc;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.openbsd.OpenBsdSysctlUtil;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

@ThreadSafe
public class OpenBsdCentralProcessor
extends AbstractCentralProcessor {
    private final Supplier<Pair<Long, Long>> vmStats = Memoizer.memoize(OpenBsdCentralProcessor::queryVmStats, Memoizer.defaultExpiration());
    private static final Pattern DMESG_CPU = Pattern.compile("cpu(\\d+): smt (\\d+), core (\\d+), package (\\d+)");

    @Override
    public CentralProcessor.ProcessorIdentifier queryProcessorId() {
        String string = OpenBsdSysctlUtil.sysctl("machdep.cpuvendor", "");
        int[] nArray = new int[]{6, 2};
        String string2 = OpenBsdSysctlUtil.sysctl(nArray, "");
        int n2 = ParseUtil.hexStringToInt(OpenBsdSysctlUtil.sysctl("machdep.cpuid", ""), 0);
        int n3 = ParseUtil.hexStringToInt(OpenBsdSysctlUtil.sysctl("machdep.cpufeature", ""), 0);
        Triplet<Integer, Integer, Integer> triplet = OpenBsdCentralProcessor.cpuidToFamilyModelStepping(n2);
        String string3 = triplet.getA().toString();
        String string4 = triplet.getB().toString();
        String string5 = triplet.getC().toString();
        long l2 = ParseUtil.parseHertz(string2);
        if (l2 < 0L) {
            l2 = this.queryMaxFreq();
        }
        nArray[1] = 1;
        String string6 = OpenBsdSysctlUtil.sysctl(nArray, "");
        boolean bl2 = string6 != null && string6.contains("64") || ExecutingCommand.getFirstAnswer("uname -m").trim().contains("64");
        String string7 = String.format("%08x%08x", n3, n2);
        return new CentralProcessor.ProcessorIdentifier(string, string2, string3, string4, string5, string7, bl2, l2);
    }

    private static Triplet<Integer, Integer, Integer> cpuidToFamilyModelStepping(int n2) {
        int n3 = n2 >> 16 & 0xFF0 | n2 >> 8 & 0xF;
        int n4 = n2 >> 12 & 0xF0 | n2 >> 4 & 0xF;
        int n5 = n2 & 0xF;
        return new Triplet<Integer, Integer, Integer>(n3, n4, n5);
    }

    @Override
    public long queryMaxFreq() {
        return this.queryCurrentFreq()[0];
    }

    @Override
    public long[] queryCurrentFreq() {
        long[] lArray = new long[1];
        int[] nArray = new int[]{6, 12};
        lArray[0] = OpenBsdSysctlUtil.sysctl(nArray, 0L) * 1000000L;
        return lArray;
    }

    @Override
    public List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<Integer, Integer>();
        for (String object2 : ExecutingCommand.runNative("dmesg")) {
            Matcher i2 = DMESG_CPU.matcher(object2);
            if (!i2.matches()) continue;
            int n2 = ParseUtil.parseIntOrDefault(i2.group(1), 0);
            hashMap.put(n2, ParseUtil.parseIntOrDefault(i2.group(3), 0));
            hashMap2.put(n2, ParseUtil.parseIntOrDefault(i2.group(4), 0));
        }
        int n3 = OpenBsdSysctlUtil.sysctl("hw.ncpuonline", 1);
        if (n3 < hashMap.keySet().size()) {
            n3 = hashMap.keySet().size();
        }
        ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList<CentralProcessor.LogicalProcessor>(n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            arrayList.add(new CentralProcessor.LogicalProcessor(i2, hashMap.getOrDefault(i2, 0), hashMap2.getOrDefault(i2, 0)));
        }
        return arrayList;
    }

    @Override
    public long queryContextSwitches() {
        return this.vmStats.get().getA();
    }

    @Override
    public long queryInterrupts() {
        return this.vmStats.get().getB();
    }

    private static Pair<Long, Long> queryVmStats() {
        long l2 = 0L;
        long l3 = 0L;
        List<String> list = ExecutingCommand.runNative("vmstat -s");
        for (String string : list) {
            if (string.endsWith("cpu context switches")) {
                l2 = ParseUtil.getFirstIntValue(string);
                continue;
            }
            if (!string.endsWith("interrupts")) continue;
            l3 = ParseUtil.getFirstIntValue(string);
        }
        return new Pair<Long, Long>(l2, l3);
    }

    @Override
    public long[] querySystemCpuLoadTicks() {
        long[] lArray = new long[CentralProcessor.TickType.values().length];
        int[] nArray = new int[]{1, 40};
        Memory memory = OpenBsdSysctlUtil.sysctl(nArray);
        long[] lArray2 = OpenBsdCentralProcessor.cpTimeToTicks(memory, false);
        if (lArray2.length >= 5) {
            lArray[CentralProcessor.TickType.USER.getIndex()] = lArray2[0];
            lArray[CentralProcessor.TickType.NICE.getIndex()] = lArray2[1];
            lArray[CentralProcessor.TickType.SYSTEM.getIndex()] = lArray2[2];
            int n2 = lArray2.length > 5 ? 1 : 0;
            lArray[CentralProcessor.TickType.IRQ.getIndex()] = lArray2[3 + n2];
            lArray[CentralProcessor.TickType.IDLE.getIndex()] = lArray2[4 + n2];
        }
        return lArray;
    }

    @Override
    public long[][] queryProcessorCpuLoadTicks() {
        long[][] lArray = new long[this.getLogicalProcessorCount()][CentralProcessor.TickType.values().length];
        int[] nArray = new int[3];
        nArray[0] = 1;
        nArray[1] = 71;
        for (int i2 = 0; i2 < this.getLogicalProcessorCount(); ++i2) {
            nArray[2] = i2;
            Memory memory = OpenBsdSysctlUtil.sysctl(nArray);
            long[] lArray2 = OpenBsdCentralProcessor.cpTimeToTicks(memory, true);
            if (lArray2.length < 5) continue;
            lArray[i2][CentralProcessor.TickType.USER.getIndex()] = lArray2[0];
            lArray[i2][CentralProcessor.TickType.NICE.getIndex()] = lArray2[1];
            lArray[i2][CentralProcessor.TickType.SYSTEM.getIndex()] = lArray2[2];
            int n2 = lArray2.length > 5 ? 1 : 0;
            lArray[i2][CentralProcessor.TickType.IRQ.getIndex()] = lArray2[3 + n2];
            lArray[i2][CentralProcessor.TickType.IDLE.getIndex()] = lArray2[4 + n2];
        }
        return lArray;
    }

    private static long[] cpTimeToTicks(Memory memory, boolean bl2) {
        int n2;
        long l2 = bl2 ? 8L : (long)Native.LONG_SIZE;
        int n3 = n2 = memory == null ? 0 : (int)(memory.size() / l2);
        if (bl2 && memory != null) {
            return memory.getLongArray(0L, n2);
        }
        long[] lArray = new long[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            lArray[i2] = memory.getNativeLong((long)i2 * l2).longValue();
        }
        return lArray;
    }

    @Override
    public double[] getSystemLoadAverage(int n2) {
        if (n2 < 1 || n2 > 3) {
            throw new IllegalArgumentException("Must include from one to three elements.");
        }
        double[] dArray = new double[n2];
        int n3 = OpenBsdLibc.INSTANCE.getloadavg(dArray, n2);
        if (n3 < n2) {
            Arrays.fill(dArray, -1.0);
        }
        return dArray;
    }
}

