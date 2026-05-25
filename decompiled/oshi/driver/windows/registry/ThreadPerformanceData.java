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
import oshi.driver.windows.perfmon.ThreadInformation;
import oshi.driver.windows.registry.HkeyPerformanceDataUtil;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

@ThreadSafe
public final class ThreadPerformanceData {
    private static final String THREAD = "Thread";

    private ThreadPerformanceData() {
    }

    public static Map<Integer, PerfCounterBlock> buildThreadMapFromRegistry(Collection<Integer> collection) {
        Triplet<List<Map<ThreadInformation.ThreadPerformanceProperty, Object>>, Long, Long> triplet = HkeyPerformanceDataUtil.readPerfDataFromRegistry(THREAD, ThreadInformation.ThreadPerformanceProperty.class);
        if (triplet == null) {
            return null;
        }
        List<Map<ThreadInformation.ThreadPerformanceProperty, Object>> list = triplet.getA();
        long l2 = triplet.getB();
        long l3 = triplet.getC();
        HashMap<Integer, PerfCounterBlock> hashMap = new HashMap<Integer, PerfCounterBlock>();
        for (Map<ThreadInformation.ThreadPerformanceProperty, Object> map : list) {
            int n2 = (Integer)map.get(ThreadInformation.ThreadPerformanceProperty.IDPROCESS);
            if (collection != null && !collection.contains(n2) || n2 <= 0) continue;
            int n3 = (Integer)map.get(ThreadInformation.ThreadPerformanceProperty.IDTHREAD);
            String string = (String)map.get(ThreadInformation.ThreadPerformanceProperty.NAME);
            long l4 = (l2 - (Long)map.get(ThreadInformation.ThreadPerformanceProperty.ELAPSEDTIME)) / 10000L;
            if (l4 < 1L) {
                l4 = 1L;
            }
            long l5 = (Long)map.get(ThreadInformation.ThreadPerformanceProperty.PERCENTUSERTIME) / 10000L;
            long l6 = (Long)map.get(ThreadInformation.ThreadPerformanceProperty.PERCENTPRIVILEGEDTIME) / 10000L;
            int n4 = (Integer)map.get(ThreadInformation.ThreadPerformanceProperty.PRIORITYCURRENT);
            int n5 = (Integer)map.get(ThreadInformation.ThreadPerformanceProperty.THREADSTATE);
            int n6 = (Integer)map.get(ThreadInformation.ThreadPerformanceProperty.THREADWAITREASON);
            Object object = map.get(ThreadInformation.ThreadPerformanceProperty.STARTADDRESS);
            long l7 = object.getClass().equals(Long.class) ? (Long)object : Integer.toUnsignedLong((Integer)object);
            int n7 = (Integer)map.get(ThreadInformation.ThreadPerformanceProperty.CONTEXTSWITCHESPERSEC);
            hashMap.put(n3, new PerfCounterBlock(string, n3, n2, l3 - l4, l5, l6, n4, n5, n6, l7, n7));
        }
        return hashMap;
    }

    public static Map<Integer, PerfCounterBlock> buildThreadMapFromPerfCounters(Collection<Integer> collection) {
        HashMap<Integer, PerfCounterBlock> hashMap = new HashMap<Integer, PerfCounterBlock>();
        Pair<List<String>, Map<ThreadInformation.ThreadPerformanceProperty, List<Long>>> pair = ThreadInformation.queryThreadCounters();
        long l2 = System.currentTimeMillis();
        List<String> list = pair.getA();
        Map<ThreadInformation.ThreadPerformanceProperty, List<Long>> map = pair.getB();
        List<Long> list2 = map.get(ThreadInformation.ThreadPerformanceProperty.IDTHREAD);
        List<Long> list3 = map.get(ThreadInformation.ThreadPerformanceProperty.IDPROCESS);
        List<Long> list4 = map.get(ThreadInformation.ThreadPerformanceProperty.PERCENTUSERTIME);
        List<Long> list5 = map.get(ThreadInformation.ThreadPerformanceProperty.PERCENTPRIVILEGEDTIME);
        List<Long> list6 = map.get(ThreadInformation.ThreadPerformanceProperty.ELAPSEDTIME);
        List<Long> list7 = map.get(ThreadInformation.ThreadPerformanceProperty.PRIORITYCURRENT);
        List<Long> list8 = map.get(ThreadInformation.ThreadPerformanceProperty.THREADSTATE);
        List<Long> list9 = map.get(ThreadInformation.ThreadPerformanceProperty.THREADWAITREASON);
        List<Long> list10 = map.get(ThreadInformation.ThreadPerformanceProperty.STARTADDRESS);
        List<Long> list11 = map.get(ThreadInformation.ThreadPerformanceProperty.CONTEXTSWITCHESPERSEC);
        int n2 = 0;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            int n3 = list3.get(i2).intValue();
            if (collection != null && !collection.contains(n3)) continue;
            int n4 = list2.get(i2).intValue();
            String string = Integer.toString(n2++);
            long l3 = list6.get(i2);
            if ((l3 = WinBase.FILETIME.filetimeToDate((int)(l3 >> 32), (int)(l3 & 0xFFFFFFFFL)).getTime()) > l2) {
                l3 = l2 - 1L;
            }
            long l4 = list4.get(i2) / 10000L;
            long l5 = list5.get(i2) / 10000L;
            int n5 = list7.get(i2).intValue();
            int n6 = list8.get(i2).intValue();
            int n7 = list9.get(i2).intValue();
            long l6 = list10.get(i2);
            int n8 = list11.get(i2).intValue();
            hashMap.put(n4, new PerfCounterBlock(string, n4, n3, l3, l4, l5, n5, n6, n7, l6, n8));
        }
        return hashMap;
    }

    @Immutable
    public static class PerfCounterBlock {
        private final String name;
        private final int threadID;
        private final int owningProcessID;
        private final long startTime;
        private final long userTime;
        private final long kernelTime;
        private final int priority;
        private final int threadState;
        private final int threadWaitReason;
        private final long startAddress;
        private final int contextSwitches;

        public PerfCounterBlock(String string, int n2, int n3, long l2, long l3, long l4, int n4, int n5, int n6, long l5, int n7) {
            this.name = string;
            this.threadID = n2;
            this.owningProcessID = n3;
            this.startTime = l2;
            this.userTime = l3;
            this.kernelTime = l4;
            this.priority = n4;
            this.threadState = n5;
            this.threadWaitReason = n6;
            this.startAddress = l5;
            this.contextSwitches = n7;
        }

        public String getName() {
            return this.name;
        }

        public int getThreadID() {
            return this.threadID;
        }

        public int getOwningProcessID() {
            return this.owningProcessID;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public long getUserTime() {
            return this.userTime;
        }

        public long getKernelTime() {
            return this.kernelTime;
        }

        public int getPriority() {
            return this.priority;
        }

        public int getThreadState() {
            return this.threadState;
        }

        public int getThreadWaitReason() {
            return this.threadWaitReason;
        }

        public long getStartAddress() {
            return this.startAddress;
        }

        public int getContextSwitches() {
            return this.contextSwitches;
        }
    }
}

