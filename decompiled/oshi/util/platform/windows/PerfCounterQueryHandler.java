/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.platform.windows;

import com.sun.jna.platform.win32.WinNT;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.NotThreadSafe;
import oshi.util.FormatUtil;
import oshi.util.platform.windows.PerfDataUtil;

@NotThreadSafe
public final class PerfCounterQueryHandler
implements AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(PerfCounterQueryHandler.class);
    private Map<PerfDataUtil.PerfCounter, WinNT.HANDLEByReference> counterHandleMap = new HashMap<PerfDataUtil.PerfCounter, WinNT.HANDLEByReference>();
    private WinNT.HANDLEByReference queryHandle = null;

    public boolean addCounterToQuery(PerfDataUtil.PerfCounter perfCounter) {
        if (this.queryHandle == null) {
            this.queryHandle = new WinNT.HANDLEByReference();
            if (!PerfDataUtil.openQuery(this.queryHandle)) {
                LOG.warn("Failed to open a query for PDH counter: {}", (Object)perfCounter.getCounterPath());
                this.queryHandle = null;
                return false;
            }
        }
        WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
        if (!PerfDataUtil.addCounter(this.queryHandle, perfCounter.getCounterPath(), hANDLEByReference)) {
            LOG.warn("Failed to add counter for PDH counter: {}", (Object)perfCounter.getCounterPath());
            return false;
        }
        this.counterHandleMap.put(perfCounter, hANDLEByReference);
        return true;
    }

    public boolean removeCounterFromQuery(PerfDataUtil.PerfCounter perfCounter) {
        boolean bl2 = false;
        WinNT.HANDLEByReference hANDLEByReference = this.counterHandleMap.remove(perfCounter);
        if (hANDLEByReference != null) {
            bl2 = PerfDataUtil.removeCounter(hANDLEByReference);
        }
        if (this.counterHandleMap.isEmpty()) {
            PerfDataUtil.closeQuery(this.queryHandle);
            this.queryHandle = null;
        }
        return bl2;
    }

    public void removeAllCounters() {
        for (WinNT.HANDLEByReference hANDLEByReference : this.counterHandleMap.values()) {
            PerfDataUtil.removeCounter(hANDLEByReference);
        }
        this.counterHandleMap.clear();
        if (this.queryHandle != null) {
            PerfDataUtil.closeQuery(this.queryHandle);
        }
        this.queryHandle = null;
    }

    public long updateQuery() {
        if (this.queryHandle == null) {
            LOG.warn("Query does not exist to update.");
            return 0L;
        }
        return PerfDataUtil.updateQueryTimestamp(this.queryHandle);
    }

    public long queryCounter(PerfDataUtil.PerfCounter perfCounter) {
        if (!this.counterHandleMap.containsKey(perfCounter)) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("Counter {} does not exist to query.", (Object)perfCounter.getCounterPath());
            }
            return 0L;
        }
        long l2 = PerfDataUtil.queryCounter(this.counterHandleMap.get(perfCounter));
        if (l2 < 0L) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("Error querying counter {}: {}", (Object)perfCounter.getCounterPath(), (Object)String.format(FormatUtil.formatError((int)l2), new Object[0]));
            }
            return 0L;
        }
        return l2;
    }

    @Override
    public void close() {
        this.removeAllCounters();
    }
}

