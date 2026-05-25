/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.windows;

import com.sun.jna.Memory;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.COM.WbemcliUtil;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.VersionHelpers;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinReg;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.windows.LogicalProcessorInformation;
import oshi.driver.windows.perfmon.ProcessorInformation;
import oshi.driver.windows.perfmon.SystemInformation;
import oshi.driver.windows.wmi.Win32Processor;
import oshi.hardware.CentralProcessor;
import oshi.hardware.common.AbstractCentralProcessor;
import oshi.jna.platform.windows.PowrProf;
import oshi.util.ParseUtil;
import oshi.util.platform.windows.WmiUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
final class WindowsCentralProcessor
extends AbstractCentralProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(WindowsCentralProcessor.class);
    private Map<String, Integer> numaNodeProcToLogicalProcMap;

    WindowsCentralProcessor() {
    }

    @Override
    public CentralProcessor.ProcessorIdentifier queryProcessorId() {
        String string;
        WbemcliUtil.WmiResult<Win32Processor.ProcessorIdProperty> wmiResult;
        Object object;
        String string2 = "";
        String string3 = "";
        String string4 = "";
        String string5 = "";
        String string6 = "";
        String string7 = "";
        long l2 = 0L;
        boolean bl2 = false;
        String string8 = "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\";
        String[] stringArray = Advapi32Util.registryGetKeys(WinReg.HKEY_LOCAL_MACHINE, "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\");
        if (stringArray.length > 0) {
            object = "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\" + stringArray[0];
            string2 = Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, (String)object, "VendorIdentifier");
            string3 = Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, (String)object, "ProcessorNameString");
            string4 = Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, (String)object, "Identifier");
            try {
                l2 = (long)Advapi32Util.registryGetIntValue(WinReg.HKEY_LOCAL_MACHINE, (String)object, "~MHz") * 1000000L;
            }
            catch (Win32Exception win32Exception) {
                // empty catch block
            }
        }
        if (!string4.isEmpty()) {
            string5 = WindowsCentralProcessor.parseIdentifier(string4, "Family");
            string6 = WindowsCentralProcessor.parseIdentifier(string4, "Model");
            string7 = WindowsCentralProcessor.parseIdentifier(string4, "Stepping");
        }
        object = new WinBase.SYSTEM_INFO();
        Kernel32.INSTANCE.GetNativeSystemInfo((WinBase.SYSTEM_INFO)object);
        int n2 = ((WinBase.SYSTEM_INFO)object).processorArchitecture.pi.wProcessorArchitecture.intValue();
        if (n2 == 9 || n2 == 12 || n2 == 6) {
            bl2 = true;
        }
        if ((wmiResult = Win32Processor.queryProcessorId()).getResultCount() > 0) {
            string = WmiUtil.getString(wmiResult, Win32Processor.ProcessorIdProperty.PROCESSORID, 0);
        } else {
            String[] stringArray2;
            if (bl2) {
                String[] stringArray3 = new String[1];
                stringArray2 = stringArray3;
                stringArray3[0] = "ia64";
            } else {
                stringArray2 = new String[]{};
            }
            string = WindowsCentralProcessor.createProcessorID(string7, string6, string5, stringArray2);
        }
        return new CentralProcessor.ProcessorIdentifier(string2, string3, string5, string6, string7, string, bl2, l2);
    }

    private static String parseIdentifier(String string, String string2) {
        String[] stringArray = ParseUtil.whitespaces.split(string);
        boolean bl2 = false;
        for (String string3 : stringArray) {
            if (bl2) {
                return string3;
            }
            bl2 = string3.equals(string2);
        }
        return "";
    }

    @Override
    public List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
        if (VersionHelpers.IsWindows7OrGreater()) {
            List<CentralProcessor.LogicalProcessor> list = LogicalProcessorInformation.getLogicalProcessorInformationEx();
            int n2 = -1;
            int n3 = 0;
            int n4 = 0;
            this.numaNodeProcToLogicalProcMap = new HashMap<String, Integer>();
            for (CentralProcessor.LogicalProcessor logicalProcessor : list) {
                int n5 = logicalProcessor.getNumaNode();
                if (n5 != n2) {
                    n2 = n5;
                    n3 = 0;
                }
                this.numaNodeProcToLogicalProcMap.put(String.format("%d,%d", logicalProcessor.getNumaNode(), n3++), n4++);
            }
            return list;
        }
        return LogicalProcessorInformation.getLogicalProcessorInformation();
    }

    @Override
    public long[] querySystemCpuLoadTicks() {
        long[] lArray = new long[CentralProcessor.TickType.values().length];
        long[][] lArray2 = this.getProcessorCpuLoadTicks();
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            for (long[] lArray3 : lArray2) {
                int n2 = i2;
                lArray[n2] = lArray[n2] + lArray3[i2];
            }
        }
        return lArray;
    }

    @Override
    public long[] queryCurrentFreq() {
        if (VersionHelpers.IsWindows7OrGreater()) {
            Pair<List<String>, Map<ProcessorInformation.ProcessorFrequencyProperty, List<Long>>> pair = ProcessorInformation.queryFrequencyCounters();
            List<String> list = pair.getA();
            Map<ProcessorInformation.ProcessorFrequencyProperty, List<Long>> map = pair.getB();
            List<Long> list2 = map.get(ProcessorInformation.ProcessorFrequencyProperty.PERCENTOFMAXIMUMFREQUENCY);
            if (!list.isEmpty()) {
                long l2 = this.getMaxFreq();
                long[] lArray = new long[this.getLogicalProcessorCount()];
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    int n2;
                    int n3 = n2 = list.get(i2).contains(",") ? this.numaNodeProcToLogicalProcMap.getOrDefault(list.get(i2), 0) : ParseUtil.parseIntOrDefault(list.get(i2), 0);
                    if (n2 >= this.getLogicalProcessorCount()) continue;
                    lArray[n2] = list2.get(n2) * l2 / 100L;
                }
                return lArray;
            }
        }
        return this.queryNTPower(2);
    }

    @Override
    public long queryMaxFreq() {
        long[] lArray = this.queryNTPower(1);
        return Arrays.stream(lArray).max().orElse(-1L);
    }

    private long[] queryNTPower(int n2) {
        PowrProf.ProcessorPowerInformation processorPowerInformation = new PowrProf.ProcessorPowerInformation();
        long[] lArray = new long[this.getLogicalProcessorCount()];
        int n3 = processorPowerInformation.size() * lArray.length;
        Memory memory = new Memory(n3);
        if (0 != PowrProf.INSTANCE.CallNtPowerInformation(11, null, 0, memory, n3)) {
            LOG.error("Unable to get Processor Information");
            Arrays.fill(lArray, -1L);
            return lArray;
        }
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            processorPowerInformation = new PowrProf.ProcessorPowerInformation(memory.share((long)i2 * (long)processorPowerInformation.size()));
            lArray[i2] = n2 == 1 ? (long)processorPowerInformation.maxMhz * 1000000L : (n2 == 2 ? (long)processorPowerInformation.currentMhz * 1000000L : -1L);
        }
        return lArray;
    }

    @Override
    public double[] getSystemLoadAverage(int n2) {
        if (n2 < 1 || n2 > 3) {
            throw new IllegalArgumentException("Must include from one to three elements.");
        }
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray[i2] = -1.0;
        }
        return dArray;
    }

    @Override
    public long[][] queryProcessorCpuLoadTicks() {
        Pair<List<String>, Map<ProcessorInformation.ProcessorTickCountProperty, List<Long>>> pair = ProcessorInformation.queryProcessorCounters();
        List<String> list = pair.getA();
        Map<ProcessorInformation.ProcessorTickCountProperty, List<Long>> map = pair.getB();
        List<Long> list2 = map.get(ProcessorInformation.ProcessorTickCountProperty.PERCENTPRIVILEGEDTIME);
        List<Long> list3 = map.get(ProcessorInformation.ProcessorTickCountProperty.PERCENTUSERTIME);
        List<Long> list4 = map.get(ProcessorInformation.ProcessorTickCountProperty.PERCENTINTERRUPTTIME);
        List<Long> list5 = map.get(ProcessorInformation.ProcessorTickCountProperty.PERCENTDPCTIME);
        List<Long> list6 = map.get(ProcessorInformation.ProcessorTickCountProperty.PERCENTPROCESSORTIME);
        long[][] lArray = new long[this.getLogicalProcessorCount()][CentralProcessor.TickType.values().length];
        if (list.isEmpty() || list2 == null || list3 == null || list4 == null || list5 == null || list6 == null) {
            return lArray;
        }
        for (int i2 = 0; i2 < list.size(); ++i2) {
            int n2;
            int n3 = n2 = list.get(i2).contains(",") ? this.numaNodeProcToLogicalProcMap.getOrDefault(list.get(i2), 0) : ParseUtil.parseIntOrDefault(list.get(i2), 0);
            if (n2 >= this.getLogicalProcessorCount()) continue;
            lArray[n2][CentralProcessor.TickType.SYSTEM.getIndex()] = list2.get(n2);
            lArray[n2][CentralProcessor.TickType.USER.getIndex()] = list3.get(n2);
            lArray[n2][CentralProcessor.TickType.IRQ.getIndex()] = list4.get(n2);
            lArray[n2][CentralProcessor.TickType.SOFTIRQ.getIndex()] = list5.get(n2);
            lArray[n2][CentralProcessor.TickType.IDLE.getIndex()] = list6.get(n2);
            long[] lArray2 = lArray[n2];
            int n4 = CentralProcessor.TickType.SYSTEM.getIndex();
            lArray2[n4] = lArray2[n4] - (lArray[n2][CentralProcessor.TickType.IRQ.getIndex()] + lArray[n2][CentralProcessor.TickType.SOFTIRQ.getIndex()]);
            long[] lArray3 = lArray[n2];
            int n5 = CentralProcessor.TickType.SYSTEM.getIndex();
            lArray3[n5] = lArray3[n5] / 10000L;
            long[] lArray4 = lArray[n2];
            int n6 = CentralProcessor.TickType.USER.getIndex();
            lArray4[n6] = lArray4[n6] / 10000L;
            long[] lArray5 = lArray[n2];
            int n7 = CentralProcessor.TickType.IRQ.getIndex();
            lArray5[n7] = lArray5[n7] / 10000L;
            long[] lArray6 = lArray[n2];
            int n8 = CentralProcessor.TickType.SOFTIRQ.getIndex();
            lArray6[n8] = lArray6[n8] / 10000L;
            long[] lArray7 = lArray[n2];
            int n9 = CentralProcessor.TickType.IDLE.getIndex();
            lArray7[n9] = lArray7[n9] / 10000L;
        }
        return lArray;
    }

    @Override
    public long queryContextSwitches() {
        return SystemInformation.queryContextSwitchCounters().getOrDefault(SystemInformation.ContextSwitchProperty.CONTEXTSWITCHESPERSEC, 0L);
    }

    @Override
    public long queryInterrupts() {
        return ProcessorInformation.queryInterruptCounters().getOrDefault(ProcessorInformation.InterruptsProperty.INTERRUPTSPERSEC, 0L);
    }
}

