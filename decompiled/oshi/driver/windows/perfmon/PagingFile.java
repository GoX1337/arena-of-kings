/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.perfmon;

import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.PerfCounterQuery;

@ThreadSafe
public final class PagingFile {
    private static final String PAGING_FILE = "Paging File";
    private static final String WIN32_PERF_RAW_DATA_PERF_OS_PAGING_FILE = "Win32_PerfRawData_PerfOS_PagingFile";

    private PagingFile() {
    }

    public static Map<PagingPercentProperty, Long> querySwapUsed() {
        return PerfCounterQuery.queryValues(PagingPercentProperty.class, PAGING_FILE, WIN32_PERF_RAW_DATA_PERF_OS_PAGING_FILE);
    }

    public static enum PagingPercentProperty implements PerfCounterQuery.PdhCounterProperty
    {
        PERCENTUSAGE("_Total", "% Usage");

        private final String instance;
        private final String counter;

        private PagingPercentProperty(String string2, String string3) {
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

