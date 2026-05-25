/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.linux.Lshw;
import oshi.driver.linux.proc.CpuStat;
import oshi.hardware.CentralProcessor;
import oshi.hardware.common.AbstractCentralProcessor;
import oshi.jna.platform.linux.LinuxLibc;
import oshi.software.os.linux.LinuxOperatingSystem;
import oshi.util.ExecutingCommand;
import oshi.util.FileUtil;
import oshi.util.GlobalConfig;
import oshi.util.ParseUtil;
import oshi.util.platform.linux.ProcPath;

@ThreadSafe
final class LinuxCentralProcessor
extends AbstractCentralProcessor {
    private static final String CPUFREQ_PATH = "oshi.cpu.freq.path";

    LinuxCentralProcessor() {
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
        boolean bl2 = false;
        StringBuilder stringBuilder = new StringBuilder();
        String[] stringArray = new String[]{};
        List<String> list = FileUtil.readFile(ProcPath.CPUINFO);
        block25: for (String object2 : list) {
            object = ParseUtil.whitespacesColonWhitespace.split(object2);
            if (((String[])object).length < 2) {
                if (!object2.startsWith("CPU architecture: ")) continue;
                string3 = object2.replace("CPU architecture: ", "").trim();
                continue;
            }
            block14 : switch (object[0]) {
                case "vendor_id": 
                case "CPU implementer": {
                    string = object[1];
                    break;
                }
                case "model name": 
                case "Processor": {
                    string2 = object[1];
                    break;
                }
                case "flags": {
                    for (String string6 : stringArray = object[1].toLowerCase().split(" ")) {
                        if (!"lm".equals(string6)) continue;
                        bl2 = true;
                        break block14;
                    }
                    continue block25;
                }
                case "stepping": {
                    string5 = object[1];
                    break;
                }
                case "CPU variant": {
                    if (stringBuilder.toString().startsWith("r")) break;
                    stringBuilder.insert(0, "r" + (String)object[1]);
                    break;
                }
                case "CPU revision": {
                    if (stringBuilder.toString().contains("p")) break;
                    stringBuilder.append('p').append(object[1]);
                    break;
                }
                case "model": 
                case "CPU part": {
                    string4 = object[1];
                    break;
                }
                case "cpu family": {
                    string3 = object[1];
                    break;
                }
                case "cpu MHz": {
                    l2 = ParseUtil.parseHertz(object[1]);
                    break;
                }
            }
        }
        if (string2.contains("Hz")) {
            l2 = -1L;
        } else {
            long l3 = Lshw.queryCpuCapacity();
            if (l3 > l2) {
                l2 = l3;
            }
        }
        if (string5.isEmpty()) {
            string5 = stringBuilder.toString();
        }
        String string7 = LinuxCentralProcessor.getProcessorID(string, string5, string4, string3, stringArray);
        if (string.startsWith("0x")) {
            List<String> list2 = ExecutingCommand.runNative("lscpu");
            Iterator iterator = list2.iterator();
            while (iterator.hasNext()) {
                object = (String)iterator.next();
                if (!((String)object).startsWith("Architecture:")) continue;
                string = ((String)object).replace("Architecture:", "").trim();
            }
        }
        return new CentralProcessor.ProcessorIdentifier(string, string2, string3, string4, string5, string7, bl2, l2);
    }

    @Override
    public List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
        Map<Integer, Integer> map = LinuxCentralProcessor.mapNumaNodes();
        List<String> list = FileUtil.readFile(ProcPath.CPUINFO);
        ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList<CentralProcessor.LogicalProcessor>();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        boolean bl2 = true;
        for (String string : list) {
            if (string.startsWith("processor")) {
                if (!bl2) {
                    arrayList.add(new CentralProcessor.LogicalProcessor(n2, n3, n4, map.getOrDefault(n2, 0)));
                } else {
                    bl2 = false;
                }
                n2 = ParseUtil.parseLastInt(string, 0);
                continue;
            }
            if (string.startsWith("core id") || string.startsWith("cpu number")) {
                n3 = ParseUtil.parseLastInt(string, 0);
                continue;
            }
            if (!string.startsWith("physical id")) continue;
            n4 = ParseUtil.parseLastInt(string, 0);
        }
        arrayList.add(new CentralProcessor.LogicalProcessor(n2, n3, n4, map.getOrDefault(n2, 0)));
        return arrayList;
    }

    private static Map<Integer, Integer> mapNumaNodes() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        List<String> list = ExecutingCommand.runNative("lscpu -p=cpu,node");
        for (String string : list) {
            String[] stringArray;
            if (string.startsWith("#") || (stringArray = string.split(",")).length != 2) continue;
            hashMap.put(ParseUtil.parseIntOrDefault(stringArray[0], 0), ParseUtil.parseIntOrDefault(stringArray[1], 0));
        }
        return hashMap;
    }

    @Override
    public long[] querySystemCpuLoadTicks() {
        long[] lArray = CpuStat.getSystemCpuLoadTicks();
        if (LongStream.of(lArray).sum() == 0L) {
            lArray = CpuStat.getSystemCpuLoadTicks();
        }
        long l2 = LinuxOperatingSystem.getHz();
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            lArray[i2] = lArray[i2] * 1000L / l2;
        }
        return lArray;
    }

    @Override
    public long[] queryCurrentFreq() {
        int n2;
        String string = GlobalConfig.get(CPUFREQ_PATH, "");
        long[] lArray = new long[this.getLogicalProcessorCount()];
        long l2 = 0L;
        for (n2 = 0; n2 < lArray.length; ++n2) {
            lArray[n2] = FileUtil.getLongFromFile(string + "/cpu" + n2 + "/cpufreq/scaling_cur_freq");
            if (lArray[n2] == 0L) {
                lArray[n2] = FileUtil.getLongFromFile(string + "/cpu" + n2 + "/cpufreq/cpuinfo_cur_freq");
            }
            if (l2 >= lArray[n2]) continue;
            l2 = lArray[n2];
        }
        if (l2 > 0L) {
            n2 = 0;
            while (n2 < lArray.length) {
                int n3 = n2++;
                lArray[n3] = lArray[n3] * 1000L;
            }
            return lArray;
        }
        Arrays.fill(lArray, -1L);
        List<String> list = FileUtil.readFile(ProcPath.CPUINFO);
        int n4 = 0;
        for (String string2 : list) {
            if (!string2.toLowerCase().contains("cpu mhz")) continue;
            lArray[n4] = Math.round(ParseUtil.parseLastDouble(string2, 0.0) * 1000000.0);
            if (++n4 < lArray.length) continue;
            break;
        }
        return lArray;
    }

    @Override
    public long queryMaxFreq() {
        File file;
        File[] fileArray;
        String string = GlobalConfig.get(CPUFREQ_PATH, "");
        long l2 = Arrays.stream(this.getCurrentFreq()).max().orElse(-1L);
        if (l2 > 0L) {
            l2 /= 1000L;
        }
        if ((fileArray = (file = new File(string + "/cpufreq")).listFiles()) != null) {
            for (int i2 = 0; i2 < fileArray.length; ++i2) {
                File file2 = fileArray[i2];
                if (!file2.getName().startsWith("policy")) continue;
                long l3 = FileUtil.getLongFromFile(string + "/cpufreq/" + file2.getName() + "/scaling_max_freq");
                if (l3 == 0L) {
                    l3 = FileUtil.getLongFromFile(string + "/cpufreq/" + file2.getName() + "/cpuinfo_max_freq");
                }
                if (l2 >= l3) continue;
                l2 = l3;
            }
        }
        if (l2 > 0L) {
            long l4 = Lshw.queryCpuCapacity();
            return l4 > (l2 *= 1000L) ? l4 : l2;
        }
        return -1L;
    }

    @Override
    public double[] getSystemLoadAverage(int n2) {
        if (n2 < 1 || n2 > 3) {
            throw new IllegalArgumentException("Must include from one to three elements.");
        }
        double[] dArray = new double[n2];
        int n3 = LinuxLibc.INSTANCE.getloadavg(dArray, n2);
        if (n3 < n2) {
            for (int i2 = Math.max(n3, 0); i2 < dArray.length; ++i2) {
                dArray[i2] = -1.0;
            }
        }
        return dArray;
    }

    @Override
    public long[][] queryProcessorCpuLoadTicks() {
        long[][] lArray = CpuStat.getProcessorCpuLoadTicks(this.getLogicalProcessorCount());
        if (LongStream.of(lArray[0]).sum() == 0L) {
            lArray = CpuStat.getProcessorCpuLoadTicks(this.getLogicalProcessorCount());
        }
        long l2 = LinuxOperatingSystem.getHz();
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            for (int i3 = 0; i3 < lArray[i2].length; ++i3) {
                lArray[i2][i3] = lArray[i2][i3] * 1000L / l2;
            }
        }
        return lArray;
    }

    private static String getProcessorID(String string, String string2, String string3, String string4, String[] stringArray) {
        boolean bl2 = false;
        String string5 = "Processor Information";
        for (String string6 : ExecutingCommand.runNative("dmidecode -t 4")) {
            if (!bl2 && string6.contains(string5)) {
                string5 = "ID:";
                bl2 = true;
                continue;
            }
            if (!bl2 || !string6.contains(string5)) continue;
            return string6.split(string5)[1].trim();
        }
        string5 = "eax=";
        for (String string6 : ExecutingCommand.runNative("cpuid -1r")) {
            if (!string6.contains(string5) || !string6.trim().startsWith("0x00000001")) continue;
            String string7 = "";
            String string8 = "";
            for (String string9 : ParseUtil.whitespaces.split(string6)) {
                if (string9.startsWith("eax=")) {
                    string7 = ParseUtil.removeMatchingString(string9, "eax=0x");
                    continue;
                }
                if (!string9.startsWith("edx=")) continue;
                string8 = ParseUtil.removeMatchingString(string9, "edx=0x");
            }
            return string8 + string7;
        }
        if (string.startsWith("0x")) {
            return LinuxCentralProcessor.createMIDR(string, string2, string3, string4) + "00000000";
        }
        return LinuxCentralProcessor.createProcessorID(string2, string3, string4, stringArray);
    }

    private static String createMIDR(String string, String string2, String string3, String string4) {
        int n2 = 0;
        if (string2.startsWith("r") && string2.contains("p")) {
            String[] stringArray = string2.substring(1).split("p");
            n2 |= ParseUtil.parseLastInt(stringArray[1], 0);
            n2 |= ParseUtil.parseLastInt(stringArray[0], 0) << 20;
        }
        n2 |= ParseUtil.parseLastInt(string3, 0) << 4;
        n2 |= ParseUtil.parseLastInt(string4, 0) << 16;
        return String.format("%08X", n2 |= ParseUtil.parseLastInt(string, 0) << 24);
    }

    @Override
    public long queryContextSwitches() {
        return CpuStat.getContextSwitches();
    }

    @Override
    public long queryInterrupts() {
        return CpuStat.getInterrupts();
    }
}

