/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.registry;

import com.sun.jna.platform.win32.WinBase;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.Immutable;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.windows.perfmon.ProcessInformation;
import oshi.driver.windows.registry.HkeyPerformanceDataUtil;
import oshi.util.GlobalConfig;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

@ThreadSafe
public final class ProcessPerformanceData {
    private static final String PROCESS = "Process";
    public static final String WIN_HKEY_PERFDATA = "oshi.os.windows.hkeyperfdata";
    private static final boolean PERFDATA = GlobalConfig.get("oshi.os.windows.hkeyperfdata", true);

    private ProcessPerformanceData() {
    }

    public static Map<Integer, PerfCounterBlock> buildProcessMapFromRegistry(Collection<Integer> collection) {
        Triplet<List<Map<ProcessInformation.ProcessPerformanceProperty, Object>>, Long, Long> triplet = null;
        if (PERFDATA) {
            triplet = HkeyPerformanceDataUtil.readPerfDataFromRegistry(PROCESS, ProcessInformation.ProcessPerformanceProperty.class);
        }
        if (triplet == null) {
            return null;
        }
        List<Map<ProcessInformation.ProcessPerformanceProperty, Object>> list = triplet.getA();
        long l2 = triplet.getC();
        HashMap<Integer, PerfCounterBlock> hashMap = new HashMap<Integer, PerfCounterBlock>();
        for (Map<ProcessInformation.ProcessPerformanceProperty, Object> map : list) {
            long l3;
            int n2 = (Integer)map.get(ProcessInformation.ProcessPerformanceProperty.IDPROCESS);
            String string = (String)map.get(ProcessInformation.ProcessPerformanceProperty.NAME);
            if (collection != null && !collection.contains(n2) || "_Total".equals(string)) continue;
            long l4 = (Long)map.get(ProcessInformation.ProcessPerformanceProperty.ELAPSEDTIME);
            if (l4 > l2) {
                l4 = WinBase.FILETIME.filetimeToDate((int)(l4 >> 32), (int)(l4 & 0xFFFFFFFFL)).getTime();
            }
            if ((l3 = l2 - l4) < 1L) {
                l3 = 1L;
            }
            hashMap.put(n2, new PerfCounterBlock(string, (Integer)map.get(ProcessInformation.ProcessPerformanceProperty.CREATINGPROCESSID), (Integer)map.get(ProcessInformation.ProcessPerformanceProperty.PRIORITYBASE), (Long)map.get(ProcessInformation.ProcessPerformanceProperty.PRIVATEBYTES), l4, l3, (Long)map.get(ProcessInformation.ProcessPerformanceProperty.IOREADBYTESPERSEC), (Long)map.get(ProcessInformation.ProcessPerformanceProperty.IOWRITEBYTESPERSEC), (Integer)map.get(ProcessInformation.ProcessPerformanceProperty.PAGEFAULTSPERSEC)));
        }
        return hashMap;
    }

    public static Map<Integer, PerfCounterBlock> buildProcessMapFromPerfCounters(Collection<Integer> collection) {
        HashMap<Integer, PerfCounterBlock> hashMap = new HashMap<Integer, PerfCounterBlock>();
        Pair<List<String>, Map<ProcessInformation.ProcessPerformanceProperty, List<Long>>> pair = ProcessInformation.queryProcessCounters();
        long l2 = System.currentTimeMillis();
        List<String> list = pair.getA();
        Map<ProcessInformation.ProcessPerformanceProperty, List<Long>> map = pair.getB();
        List<Long> list2 = map.get(ProcessInformation.ProcessPerformanceProperty.IDPROCESS);
        List<Long> list3 = map.get(ProcessInformation.ProcessPerformanceProperty.CREATINGPROCESSID);
        List<Long> list4 = map.get(ProcessInformation.ProcessPerformanceProperty.PRIORITYBASE);
        List<Long> list5 = map.get(ProcessInformation.ProcessPerformanceProperty.IOREADBYTESPERSEC);
        List<Long> list6 = map.get(ProcessInformation.ProcessPerformanceProperty.IOWRITEBYTESPERSEC);
        List<Long> list7 = map.get(ProcessInformation.ProcessPerformanceProperty.PRIVATEBYTES);
        List<Long> list8 = map.get(ProcessInformation.ProcessPerformanceProperty.ELAPSEDTIME);
        List<Long> list9 = map.get(ProcessInformation.ProcessPerformanceProperty.PAGEFAULTSPERSEC);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            long l3;
            int n2 = list2.get(i2).intValue();
            if (collection != null && !collection.contains(n2)) continue;
            long l4 = list8.get(i2);
            if (l4 > l2) {
                l4 = WinBase.FILETIME.filetimeToDate((int)(l4 >> 32), (int)(l4 & 0xFFFFFFFFL)).getTime();
            }
            if ((l3 = l2 - l4) < 1L) {
                l3 = 1L;
            }
            hashMap.put(n2, new PerfCounterBlock(list.get(i2), list3.get(i2).intValue(), list4.get(i2).intValue(), list7.get(i2), l4, l3, list5.get(i2), list6.get(i2), list9.get(i2).intValue()));
        }
        return hashMap;
    }

    @Immutable
    public static class PerfCounterBlock {
        private final String name;
        private final int parentProcessID;
        private final int priority;
        private final long residentSetSize;
        private final long startTime;
        private final long upTime;
        private final long bytesRead;
        private final long bytesWritten;
        private final int pageFaults;

        public PerfCounterBlock(String string, int n2, int n3, long l2, long l3, long l4, long l5, long l6, int n4) {
            this.name = string;
            this.parentProcessID = n2;
            this.priority = n3;
            this.residentSetSize = l2;
            this.startTime = l3;
            this.upTime = l4;
            this.bytesRead = l5;
            this.bytesWritten = l6;
            this.pageFaults = n4;
        }

        public String getName() {
            return this.name;
        }

        public int getParentProcessID() {
            return this.parentProcessID;
        }

        public int getPriority() {
            return this.priority;
        }

        public long getResidentSetSize() {
            return this.residentSetSize;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public long getUpTime() {
            return this.upTime;
        }

        public long getBytesRead() {
            return this.bytesRead;
        }

        public long getBytesWritten() {
            return this.bytesWritten;
        }

        public long getPageFaults() {
            return this.pageFaults;
        }
    }
}

