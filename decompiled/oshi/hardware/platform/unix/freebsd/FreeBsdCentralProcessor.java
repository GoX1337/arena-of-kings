/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.platform.unix.LibCAPI$size_t$ByReference
 */
package oshi.hardware.platform.unix.freebsd;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.unix.LibCAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.CentralProcessor;
import oshi.hardware.common.AbstractCentralProcessor;
import oshi.jna.platform.unix.FreeBsdLibc;
import oshi.util.ExecutingCommand;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.freebsd.BsdSysctlUtil;

@ThreadSafe
final class FreeBsdCentralProcessor
extends AbstractCentralProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(FreeBsdCentralProcessor.class);
    private static final Pattern CPUMASK = Pattern.compile(".*<cpu\\s.*mask=\"(?:0x)?(\\p{XDigit}+)\".*>.*</cpu>.*");

    FreeBsdCentralProcessor() {
    }

    @Override
    public CentralProcessor.ProcessorIdentifier queryProcessorId() {
        Pattern pattern = Pattern.compile("Origin=\"([^\"]*)\".*Id=(\\S+).*Family=(\\S+).*Model=(\\S+).*Stepping=(\\S+).*");
        Pattern pattern2 = Pattern.compile("Features=(\\S+)<.*");
        String string = "";
        String string2 = BsdSysctlUtil.sysctl("hw.model", "");
        String string3 = "";
        String string4 = "";
        String string5 = "";
        long l2 = BsdSysctlUtil.sysctl("hw.clockrate", 0L) * 1000000L;
        long l3 = 0L;
        List<String> list = FileUtil.readFile("/var/run/dmesg.boot");
        for (String string6 : list) {
            Matcher matcher;
            if ((string6 = string6.trim()).startsWith("CPU:") && string2.isEmpty()) {
                string2 = string6.replace("CPU:", "").trim();
                continue;
            }
            if (string6.startsWith("Origin=")) {
                matcher = pattern.matcher(string6);
                if (!matcher.matches()) continue;
                string = matcher.group(1);
                l3 |= Long.decode(matcher.group(2)).longValue();
                string3 = Integer.decode(matcher.group(3)).toString();
                string4 = Integer.decode(matcher.group(4)).toString();
                string5 = Integer.decode(matcher.group(5)).toString();
                continue;
            }
            if (!string6.startsWith("Features=")) continue;
            matcher = pattern2.matcher(string6);
            if (!matcher.matches()) break;
            l3 |= Long.decode(matcher.group(1)) << 32;
            break;
        }
        boolean bl2 = ExecutingCommand.getFirstAnswer("uname -m").trim().contains("64");
        String string7 = FreeBsdCentralProcessor.getProcessorIDfromDmiDecode(l3);
        return new CentralProcessor.ProcessorIdentifier(string, string2, string3, string4, string5, string7, bl2, l2);
    }

    @Override
    public List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
        List<CentralProcessor.LogicalProcessor> list = FreeBsdCentralProcessor.parseTopology();
        if (list.isEmpty()) {
            list.add(new CentralProcessor.LogicalProcessor(0, 0, 0));
        }
        return list;
    }

    private static List<CentralProcessor.LogicalProcessor> parseTopology() {
        String[] stringArray = BsdSysctlUtil.sysctl("kern.sched.topology_spec", "").split("\\n|\\r");
        long l2 = 1L;
        ArrayList<Long> arrayList = new ArrayList<Long>();
        ArrayList<Long> arrayList2 = new ArrayList<Long>();
        int n2 = 0;
        block5: for (String string : stringArray) {
            Matcher matcher;
            if (string.contains("<group level=")) {
                ++n2;
                continue;
            }
            if (string.contains("</group>")) {
                --n2;
                continue;
            }
            if (!string.contains("<cpu") || !(matcher = CPUMASK.matcher(string)).matches()) continue;
            switch (n2) {
                case 1: {
                    l2 = Long.parseLong(matcher.group(1), 16);
                    continue block5;
                }
                case 2: {
                    arrayList.add(Long.parseLong(matcher.group(1), 16));
                    continue block5;
                }
                case 3: {
                    arrayList2.add(Long.parseLong(matcher.group(1), 16));
                    continue block5;
                }
            }
        }
        return FreeBsdCentralProcessor.matchBitmasks(l2, arrayList, arrayList2);
    }

    private static List<CentralProcessor.LogicalProcessor> matchBitmasks(long l2, List<Long> list, List<Long> list2) {
        ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList<CentralProcessor.LogicalProcessor>();
        int n2 = Long.numberOfTrailingZeros(l2);
        int n3 = 63 - Long.numberOfLeadingZeros(l2);
        for (int i2 = n2; i2 <= n3; ++i2) {
            if ((l2 & 1L << i2) <= 0L) continue;
            int n4 = 0;
            CentralProcessor.LogicalProcessor logicalProcessor = new CentralProcessor.LogicalProcessor(i2, FreeBsdCentralProcessor.getMatchingBitmask(list2, i2), FreeBsdCentralProcessor.getMatchingBitmask(list, i2), n4);
            arrayList.add(logicalProcessor);
        }
        return arrayList;
    }

    private static int getMatchingBitmask(List<Long> list, int n2) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if ((list.get(i2) & 1L << n2) == 0L) continue;
            return i2;
        }
        return 0;
    }

    @Override
    public long[] querySystemCpuLoadTicks() {
        long[] lArray = new long[CentralProcessor.TickType.values().length];
        FreeBsdLibc.CpTime cpTime = new FreeBsdLibc.CpTime();
        BsdSysctlUtil.sysctl("kern.cp_time", cpTime);
        lArray[CentralProcessor.TickType.USER.getIndex()] = cpTime.cpu_ticks[0];
        lArray[CentralProcessor.TickType.NICE.getIndex()] = cpTime.cpu_ticks[1];
        lArray[CentralProcessor.TickType.SYSTEM.getIndex()] = cpTime.cpu_ticks[2];
        lArray[CentralProcessor.TickType.IRQ.getIndex()] = cpTime.cpu_ticks[3];
        lArray[CentralProcessor.TickType.IDLE.getIndex()] = cpTime.cpu_ticks[4];
        return lArray;
    }

    @Override
    public long[] queryCurrentFreq() {
        long[] lArray = new long[]{BsdSysctlUtil.sysctl("dev.cpu.0.freq", -1L)};
        lArray[0] = lArray[0] > 0L ? lArray[0] * 1000000L : BsdSysctlUtil.sysctl("machdep.tsc_freq", -1L);
        return lArray;
    }

    @Override
    public long queryMaxFreq() {
        long l2 = -1L;
        String string = BsdSysctlUtil.sysctl("dev.cpu.0.freq_levels", "");
        for (String string2 : ParseUtil.whitespaces.split(string)) {
            long l3 = ParseUtil.parseLongOrDefault(string2.split("/")[0], -1L);
            if (l2 >= l3) continue;
            l2 = l3;
        }
        l2 = l2 > 0L ? (l2 *= 1000000L) : BsdSysctlUtil.sysctl("machdep.tsc_freq", -1L);
        return l2;
    }

    @Override
    public double[] getSystemLoadAverage(int n2) {
        if (n2 < 1 || n2 > 3) {
            throw new IllegalArgumentException("Must include from one to three elements.");
        }
        double[] dArray = new double[n2];
        int n3 = FreeBsdLibc.INSTANCE.getloadavg(dArray, n2);
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
        String string = "kern.cp_times";
        long l2 = new FreeBsdLibc.CpTime().size();
        long l3 = l2 * (long)this.getLogicalProcessorCount();
        Memory memory = new Memory(l3);
        if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(string, memory, new LibCAPI.size_t.ByReference(new LibCAPI.size_t(l3)), null, LibCAPI.size_t.ZERO)) {
            LOG.error("Failed sysctl call: {}, Error code: {}", (Object)string, (Object)Native.getLastError());
            return lArray;
        }
        for (int i2 = 0; i2 < this.getLogicalProcessorCount(); ++i2) {
            lArray[i2][CentralProcessor.TickType.USER.getIndex()] = ((Pointer)memory).getLong(l2 * (long)i2 + (long)(0 * FreeBsdLibc.UINT64_SIZE));
            lArray[i2][CentralProcessor.TickType.NICE.getIndex()] = ((Pointer)memory).getLong(l2 * (long)i2 + (long)(1 * FreeBsdLibc.UINT64_SIZE));
            lArray[i2][CentralProcessor.TickType.SYSTEM.getIndex()] = ((Pointer)memory).getLong(l2 * (long)i2 + (long)(2 * FreeBsdLibc.UINT64_SIZE));
            lArray[i2][CentralProcessor.TickType.IRQ.getIndex()] = ((Pointer)memory).getLong(l2 * (long)i2 + (long)(3 * FreeBsdLibc.UINT64_SIZE));
            lArray[i2][CentralProcessor.TickType.IDLE.getIndex()] = ((Pointer)memory).getLong(l2 * (long)i2 + (long)(4 * FreeBsdLibc.UINT64_SIZE));
        }
        return lArray;
    }

    private static String getProcessorIDfromDmiDecode(long l2) {
        boolean bl2 = false;
        String string = "Processor Information";
        for (String string2 : ExecutingCommand.runNative("dmidecode -t system")) {
            if (!bl2 && string2.contains(string)) {
                string = "ID:";
                bl2 = true;
                continue;
            }
            if (!bl2 || !string2.contains(string)) continue;
            return string2.split(string)[1].trim();
        }
        return String.format("%016X", l2);
    }

    @Override
    public long queryContextSwitches() {
        String string = "vm.stats.sys.v_swtch";
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t((long)FreeBsdLibc.INT_SIZE));
        Memory memory = new Memory(byReference.longValue());
        if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(string, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            return 0L;
        }
        return ParseUtil.unsignedIntToLong(((Pointer)memory).getInt(0L));
    }

    @Override
    public long queryInterrupts() {
        String string = "vm.stats.sys.v_intr";
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t((long)FreeBsdLibc.INT_SIZE));
        Memory memory = new Memory(byReference.longValue());
        if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(string, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            return 0L;
        }
        return ParseUtil.unsignedIntToLong(((Pointer)memory).getInt(0L));
    }
}

