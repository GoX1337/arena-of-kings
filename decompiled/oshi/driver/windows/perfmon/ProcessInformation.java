/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.perfmon;

import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.PerfCounterWildcardQuery;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class ProcessInformation {
    private static final String WIN32_PERFPROC_PROCESS = "Win32_PerfRawData_PerfProc_Process";
    private static final String PROCESS = "Process";
    private static final String WIN32_PERFPROC_PROCESS_WHERE_NOT_NAME_LIKE_TOTAL = "Win32_PerfRawData_PerfProc_Process WHERE NOT Name LIKE \"%_Total\"";

    private ProcessInformation() {
    }

    public static Pair<List<String>, Map<ProcessPerformanceProperty, List<Long>>> queryProcessCounters() {
        return PerfCounterWildcardQuery.queryInstancesAndValues(ProcessPerformanceProperty.class, PROCESS, WIN32_PERFPROC_PROCESS_WHERE_NOT_NAME_LIKE_TOTAL);
    }

    public static Pair<List<String>, Map<HandleCountProperty, List<Long>>> queryHandles() {
        return PerfCounterWildcardQuery.queryInstancesAndValues(HandleCountProperty.class, PROCESS, WIN32_PERFPROC_PROCESS);
    }

    public static enum ProcessPerformanceProperty implements PerfCounterWildcardQuery.PdhCounterWildcardProperty
    {
        NAME("^*_Total"),
        PRIORITYBASE("Priority Base"),
        ELAPSEDTIME("Elapsed Time"),
        IDPROCESS("ID Process"),
        CREATINGPROCESSID("Creating Process ID"),
        IOREADBYTESPERSEC("IO Read Bytes/sec"),
        IOWRITEBYTESPERSEC("IO Write Bytes/sec"),
        PRIVATEBYTES("Working Set - Private"),
        PAGEFAULTSPERSEC("Page Faults/sec");

        private final String counter;

        private ProcessPerformanceProperty(String string2) {
            this.counter = string2;
        }

        @Override
        public String getCounter() {
            return this.counter;
        }
    }

    public static enum HandleCountProperty implements PerfCounterWildcardQuery.PdhCounterWildcardProperty
    {
        NAME("_Total"),
        HANDLECOUNT("Handle Count");

        private final String counter;

        private HandleCountProperty(String string2) {
            this.counter = string2;
        }

        @Override
        public String getCounter() {
            return this.counter;
        }
    }
}

