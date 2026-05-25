/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.solaris;

import com.sun.jna.platform.unix.solaris.LibKstat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.CentralProcessor;
import oshi.hardware.common.AbstractCentralProcessor;
import oshi.jna.platform.unix.SolarisLibc;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.solaris.KstatUtil;

@ThreadSafe
final class SolarisCentralProcessor
extends AbstractCentralProcessor {
    private static final String CPU_INFO = "cpu_info";

    SolarisCentralProcessor() {
    }

    @Override
    public CentralProcessor.ProcessorIdentifier queryProcessorId() {
        Object object;
        String string = "";
        String string2 = "";
        String string3 = "";
        String string4 = "";
        String string5 = "";
        long l2 = 0L;
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            object = KstatUtil.KstatChain.lookup(CPU_INFO, -1, null);
            if (object != null && KstatUtil.KstatChain.read((LibKstat.Kstat)object)) {
                string = KstatUtil.dataLookupString((LibKstat.Kstat)object, "vendor_id");
                string2 = KstatUtil.dataLookupString((LibKstat.Kstat)object, "brand");
                string3 = KstatUtil.dataLookupString((LibKstat.Kstat)object, "family");
                string4 = KstatUtil.dataLookupString((LibKstat.Kstat)object, "model");
                string5 = KstatUtil.dataLookupString((LibKstat.Kstat)object, "stepping");
                l2 = KstatUtil.dataLookupLong((LibKstat.Kstat)object, "clock_MHz") * 1000000L;
            }
        }
        boolean bl2 = "64".equals(ExecutingCommand.getFirstAnswer("isainfo -b").trim());
        object = SolarisCentralProcessor.getProcessorID(string5, string4, string3);
        return new CentralProcessor.ProcessorIdentifier(string, string2, string3, string4, string5, (String)object, bl2, l2);
    }

    @Override
    public List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
        Map<Integer, Integer> map = SolarisCentralProcessor.mapNumaNodes();
        ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList<CentralProcessor.LogicalProcessor>();
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            List<LibKstat.Kstat> list = KstatUtil.KstatChain.lookupAll(CPU_INFO, -1, null);
            for (LibKstat.Kstat kstat : list) {
                if (kstat == null || !KstatUtil.KstatChain.read(kstat)) continue;
                int n2 = arrayList.size();
                String string = KstatUtil.dataLookupString(kstat, "chip_id");
                String string2 = KstatUtil.dataLookupString(kstat, "core_id");
                CentralProcessor.LogicalProcessor logicalProcessor = new CentralProcessor.LogicalProcessor(n2, ParseUtil.parseIntOrDefault(string2, 0), ParseUtil.parseIntOrDefault(string, 0), map.getOrDefault(n2, 0));
                arrayList.add(logicalProcessor);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new CentralProcessor.LogicalProcessor(0, 0, 0));
        }
        return arrayList;
    }

    private static Map<Integer, Integer> mapNumaNodes() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int n2 = 0;
        for (String string : ExecutingCommand.runNative("lgrpinfo -c leaves")) {
            if (string.startsWith("lgroup")) {
                n2 = ParseUtil.getFirstIntValue(string);
                continue;
            }
            if (!string.contains("CPUs:") && !string.contains("CPU:")) continue;
            for (Integer n3 : ParseUtil.parseHyphenatedIntList(string.split(":")[1])) {
                hashMap.put(n3, n2);
            }
        }
        return hashMap;
    }

    @Override
    public long[] querySystemCpuLoadTicks() {
        long[] lArray = new long[CentralProcessor.TickType.values().length];
        long[][] lArray2 = this.getProcessorCpuLoadTicks();
        int n2 = 0;
        while (n2 < lArray.length) {
            for (long[] lArray3 : lArray2) {
                int n3 = n2;
                lArray[n3] = lArray[n3] + lArray3[n2];
            }
            int n4 = n2++;
            lArray[n4] = lArray[n4] / (long)lArray2.length;
        }
        return lArray;
    }

    @Override
    public long[] queryCurrentFreq() {
        long[] lArray = new long[this.getLogicalProcessorCount()];
        Arrays.fill(lArray, -1L);
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            for (int i2 = 0; i2 < lArray.length; ++i2) {
                for (LibKstat.Kstat kstat : KstatUtil.KstatChain.lookupAll(CPU_INFO, i2, null)) {
                    if (!KstatUtil.KstatChain.read(kstat)) continue;
                    lArray[i2] = KstatUtil.dataLookupLong(kstat, "current_clock_Hz");
                }
            }
        }
        return lArray;
    }

    @Override
    public long queryMaxFreq() {
        long l2 = -1L;
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            for (LibKstat.Kstat kstat : KstatUtil.KstatChain.lookupAll(CPU_INFO, 0, null)) {
                String string;
                if (!KstatUtil.KstatChain.read(kstat) || (string = KstatUtil.dataLookupString(kstat, "supported_frequencies_Hz")).isEmpty()) continue;
                for (String string2 : string.split(":")) {
                    long l3 = ParseUtil.parseLongOrDefault(string2, -1L);
                    if (l2 >= l3) continue;
                    l2 = l3;
                }
            }
        }
        return l2;
    }

    @Override
    public double[] getSystemLoadAverage(int n2) {
        if (n2 < 1 || n2 > 3) {
            throw new IllegalArgumentException("Must include from one to three elements.");
        }
        double[] dArray = new double[n2];
        int n3 = SolarisLibc.INSTANCE.getloadavg(dArray, n2);
        if (n3 < n2) {
            for (int i2 = Math.max(n3, 0); i2 < dArray.length; ++i2) {
                dArray[i2] = -1.0;
            }
        }
        return dArray;
    }

    @Override
    public long[][] queryProcessorCpuLoadTicks() {
        long[][] lArray = new long[this.getLogicalProcessorCount()][CentralProcessor.TickType.values().length];
        int n2 = -1;
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            for (LibKstat.Kstat kstat : KstatUtil.KstatChain.lookupAll("cpu", -1, "sys")) {
                if (++n2 >= lArray.length) {
                    break;
                }
                if (!KstatUtil.KstatChain.read(kstat)) continue;
                lArray[n2][CentralProcessor.TickType.IDLE.getIndex()] = KstatUtil.dataLookupLong(kstat, "cpu_ticks_idle");
                lArray[n2][CentralProcessor.TickType.SYSTEM.getIndex()] = KstatUtil.dataLookupLong(kstat, "cpu_ticks_kernel");
                lArray[n2][CentralProcessor.TickType.USER.getIndex()] = KstatUtil.dataLookupLong(kstat, "cpu_ticks_user");
            }
        }
        return lArray;
    }

    private static String getProcessorID(String string, String string2, String string3) {
        List<String> list = ExecutingCommand.runNative("isainfo -v");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string4 : list) {
            if (string4.startsWith("32-bit")) break;
            if (string4.startsWith("64-bit")) continue;
            stringBuilder.append(' ').append(string4.trim());
        }
        return SolarisCentralProcessor.createProcessorID(string, string2, string3, ParseUtil.whitespaces.split(stringBuilder.toString().toLowerCase()));
    }

    @Override
    public long queryContextSwitches() {
        long l2 = 0L;
        List<String> list = ExecutingCommand.runNative("kstat -p cpu_stat:::/pswitch\\\\|inv_swtch/");
        for (String string : list) {
            l2 += ParseUtil.parseLastLong(string, 0L);
        }
        return l2;
    }

    @Override
    public long queryInterrupts() {
        long l2 = 0L;
        List<String> list = ExecutingCommand.runNative("kstat -p cpu_stat:::/intr/");
        for (String string : list) {
            l2 += ParseUtil.parseLastLong(string, 0L);
        }
        return l2;
    }
}

