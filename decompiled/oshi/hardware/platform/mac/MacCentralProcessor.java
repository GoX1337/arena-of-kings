/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import com.sun.jna.Native;
import com.sun.jna.platform.mac.IOKit;
import com.sun.jna.platform.mac.IOKitUtil;
import com.sun.jna.platform.mac.SystemB;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.CentralProcessor;
import oshi.hardware.common.AbstractCentralProcessor;
import oshi.util.FormatUtil;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.Util;
import oshi.util.platform.mac.SysctlUtil;
import oshi.util.tuples.Triplet;

@ThreadSafe
final class MacCentralProcessor
extends AbstractCentralProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(MacCentralProcessor.class);
    private final Supplier<String> vendor = Memoizer.memoize(MacCentralProcessor::platformExpert);
    private final Supplier<Triplet<Integer, Integer, Long>> typeFamilyFreq = Memoizer.memoize(MacCentralProcessor::queryArmCpu);
    private static final int ROSETTA_CPUTYPE = 7;
    private static final int ROSETTA_CPUFAMILY = 1463508716;
    private static final int M1_CPUTYPE = 0x100000C;
    private static final int M1_CPUFAMILY = 458787763;

    MacCentralProcessor() {
    }

    @Override
    public CentralProcessor.ProcessorIdentifier queryProcessorId() {
        String string;
        String string2;
        int n2;
        String string3;
        String string4;
        String string5;
        String string6 = SysctlUtil.sysctl("machdep.cpu.brand_string", "");
        long l2 = 0L;
        if (string6.startsWith("Apple")) {
            string5 = this.vendor.get();
            string4 = "0";
            string3 = "0";
            n2 = SysctlUtil.sysctl("hw.cputype", 0);
            int n3 = SysctlUtil.sysctl("hw.cpufamily", 0);
            if (n3 == 1463508716) {
                n2 = this.typeFamilyFreq.get().getA();
                n3 = this.typeFamilyFreq.get().getB();
            }
            l2 = this.typeFamilyFreq.get().getC();
            string2 = String.format("0x%08x", n3);
            string = String.format("%08x%08x", n2, n3);
        } else {
            string5 = SysctlUtil.sysctl("machdep.cpu.vendor", "");
            n2 = SysctlUtil.sysctl("machdep.cpu.stepping", -1);
            string4 = n2 < 0 ? "" : Integer.toString(n2);
            n2 = SysctlUtil.sysctl("machdep.cpu.model", -1);
            string3 = n2 < 0 ? "" : Integer.toString(n2);
            n2 = SysctlUtil.sysctl("machdep.cpu.family", -1);
            string2 = n2 < 0 ? "" : Integer.toString(n2);
            long l3 = 0L;
            l3 |= (long)SysctlUtil.sysctl("machdep.cpu.signature", 0);
            string = String.format("%016x", l3 |= (SysctlUtil.sysctl("machdep.cpu.feature_bits", 0L) & 0xFFFFFFFFFFFFFFFFL) << 32);
        }
        if (l2 == 0L) {
            l2 = SysctlUtil.sysctl("hw.cpufrequency", 0L);
        }
        n2 = SysctlUtil.sysctl("hw.cpu64bit_capable", 0) != 0 ? 1 : 0;
        return new CentralProcessor.ProcessorIdentifier(string5, string6, string2, string3, string4, string, n2 != 0, l2);
    }

    @Override
    public List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
        int n2 = SysctlUtil.sysctl("hw.logicalcpu", 1);
        int n3 = SysctlUtil.sysctl("hw.physicalcpu", 1);
        int n4 = SysctlUtil.sysctl("hw.packages", 1);
        ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList<CentralProcessor.LogicalProcessor>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(new CentralProcessor.LogicalProcessor(i2, i2 * n3 / n2, i2 * n4 / n2));
        }
        return arrayList;
    }

    @Override
    public long[] querySystemCpuLoadTicks() {
        SystemB.HostCpuLoadInfo hostCpuLoadInfo;
        long[] lArray = new long[CentralProcessor.TickType.values().length];
        int n2 = SystemB.INSTANCE.mach_host_self();
        if (0 != SystemB.INSTANCE.host_statistics(n2, 3, hostCpuLoadInfo = new SystemB.HostCpuLoadInfo(), new IntByReference(hostCpuLoadInfo.size()))) {
            LOG.error("Failed to get System CPU ticks. Error code: {} ", (Object)Native.getLastError());
            return lArray;
        }
        lArray[CentralProcessor.TickType.USER.getIndex()] = hostCpuLoadInfo.cpu_ticks[0];
        lArray[CentralProcessor.TickType.NICE.getIndex()] = hostCpuLoadInfo.cpu_ticks[3];
        lArray[CentralProcessor.TickType.SYSTEM.getIndex()] = hostCpuLoadInfo.cpu_ticks[1];
        lArray[CentralProcessor.TickType.IDLE.getIndex()] = hostCpuLoadInfo.cpu_ticks[2];
        return lArray;
    }

    @Override
    public long[] queryCurrentFreq() {
        long[] lArray = new long[]{SysctlUtil.sysctl("hw.cpufrequency", this.getProcessorIdentifier().getVendorFreq())};
        return lArray;
    }

    @Override
    public long queryMaxFreq() {
        return SysctlUtil.sysctl("hw.cpufrequency_max", this.getProcessorIdentifier().getVendorFreq());
    }

    @Override
    public double[] getSystemLoadAverage(int n2) {
        if (n2 < 1 || n2 > 3) {
            throw new IllegalArgumentException("Must include from one to three elements.");
        }
        double[] dArray = new double[n2];
        int n3 = SystemB.INSTANCE.getloadavg(dArray, n2);
        if (n3 < n2) {
            Arrays.fill(dArray, -1.0);
        }
        return dArray;
    }

    @Override
    public long[][] queryProcessorCpuLoadTicks() {
        IntByReference intByReference;
        PointerByReference pointerByReference;
        IntByReference intByReference2;
        long[][] lArray = new long[this.getLogicalProcessorCount()][CentralProcessor.TickType.values().length];
        int n2 = SystemB.INSTANCE.mach_host_self();
        if (0 != SystemB.INSTANCE.host_processor_info(n2, 2, intByReference2 = new IntByReference(), pointerByReference = new PointerByReference(), intByReference = new IntByReference())) {
            LOG.error("Failed to update CPU Load. Error code: {}", (Object)Native.getLastError());
            return lArray;
        }
        int[] nArray = pointerByReference.getValue().getIntArray(0L, intByReference.getValue());
        for (int i2 = 0; i2 < intByReference2.getValue(); ++i2) {
            int n3 = i2 * 4;
            lArray[i2][CentralProcessor.TickType.USER.getIndex()] = FormatUtil.getUnsignedInt(nArray[n3 + 0]);
            lArray[i2][CentralProcessor.TickType.NICE.getIndex()] = FormatUtil.getUnsignedInt(nArray[n3 + 3]);
            lArray[i2][CentralProcessor.TickType.SYSTEM.getIndex()] = FormatUtil.getUnsignedInt(nArray[n3 + 1]);
            lArray[i2][CentralProcessor.TickType.IDLE.getIndex()] = FormatUtil.getUnsignedInt(nArray[n3 + 2]);
        }
        return lArray;
    }

    @Override
    public long queryContextSwitches() {
        return 0L;
    }

    @Override
    public long queryInterrupts() {
        return 0L;
    }

    private static String platformExpert() {
        String string = null;
        IOKit.IOService iOService = IOKitUtil.getMatchingService("IOPlatformExpertDevice");
        if (iOService != null) {
            byte[] byArray = iOService.getByteArrayProperty("manufacturer");
            if (byArray != null) {
                string = Native.toString(byArray, StandardCharsets.UTF_8);
            }
            iOService.release();
        }
        return Util.isBlank(string) ? "Apple Inc." : string;
    }

    private static Triplet<Integer, Integer, Long> queryArmCpu() {
        int n2 = 7;
        int n3 = 1463508716;
        long l2 = 0L;
        IOKit.IOIterator iOIterator = IOKitUtil.getMatchingServices("IOPlatformDevice");
        if (iOIterator != null) {
            Object object;
            HashSet<String> hashSet = new HashSet<String>();
            IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
            while (iORegistryEntry != null) {
                if (iORegistryEntry.getName().startsWith("cpu")) {
                    long l3;
                    object = iORegistryEntry.getByteArrayProperty("clock-frequency");
                    if (object != null && (l3 = ParseUtil.byteArrayToLong(object, ((byte[])object).length, false) * 1000L) > l2) {
                        l2 = l3;
                    }
                    if ((object = iORegistryEntry.getByteArrayProperty("compatible")) != null) {
                        for (String string : new String((byte[])object, StandardCharsets.UTF_8).split("\u0000")) {
                            if (string.isEmpty()) continue;
                            hashSet.add(string);
                        }
                    }
                }
                iORegistryEntry.release();
                iORegistryEntry = iOIterator.next();
            }
            iOIterator.release();
            object = Arrays.asList("ARM,v8", "apple,firestorm", "apple,icestorm");
            hashSet.retainAll((Collection<?>)object);
            if (hashSet.size() == object.size()) {
                n2 = 0x100000C;
                n3 = 458787763;
            }
        }
        return new Triplet<Integer, Integer, Long>(n2, n3, l2);
    }
}

