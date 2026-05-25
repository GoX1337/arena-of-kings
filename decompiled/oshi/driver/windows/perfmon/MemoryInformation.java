/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.perfmon;

import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.PerfCounterQuery;

@ThreadSafe
public final class MemoryInformation {
    private static final String MEMORY = "Memory";
    private static final String WIN32_PERF_RAW_DATA_PERF_OS_MEMORY = "Win32_PerfRawData_PerfOS_Memory";

    private MemoryInformation() {
    }

    public static Map<PageSwapProperty, Long> queryPageSwaps() {
        return PerfCounterQuery.queryValues(PageSwapProperty.class, MEMORY, WIN32_PERF_RAW_DATA_PERF_OS_MEMORY);
    }

    public static enum PageSwapProperty implements PerfCounterQuery.PdhCounterProperty
    {
        PAGESINPUTPERSEC(null, "Pages Input/sec"),
        PAGESOUTPUTPERSEC(null, "Pages Output/sec");

        private final String instance;
        private final String counter;

        private PageSwapProperty(String string2, String string3) {
            this.instance = string2;
            this.counter = string3;
        }

        @Override
        public String getInstance() {
            return this.instance;
        }

        @Override
        public String getCounter() {
            return this.counter;
        }
    }
}

