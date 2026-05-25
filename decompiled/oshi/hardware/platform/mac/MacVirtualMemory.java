/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import com.sun.jna.Native;
import com.sun.jna.platform.mac.SystemB;
import com.sun.jna.ptr.IntByReference;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.common.AbstractVirtualMemory;
import oshi.hardware.platform.mac.MacGlobalMemory;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.platform.mac.SysctlUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
final class MacVirtualMemory
extends AbstractVirtualMemory {
    private static final Logger LOG = LoggerFactory.getLogger(MacVirtualMemory.class);
    private final MacGlobalMemory global;
    private final Supplier<Pair<Long, Long>> usedTotal = Memoizer.memoize(MacVirtualMemory::querySwapUsage, Memoizer.defaultExpiration());
    private final Supplier<Pair<Long, Long>> inOut = Memoizer.memoize(MacVirtualMemory::queryVmStat, Memoizer.defaultExpiration());

    MacVirtualMemory(MacGlobalMemory macGlobalMemory) {
        this.global = macGlobalMemory;
    }

    @Override
    public long getSwapUsed() {
        return this.usedTotal.get().getA();
    }

    @Override
    public long getSwapTotal() {
        return this.usedTotal.get().getB();
    }

    @Override
    public long getVirtualMax() {
        return this.global.getTotal() + this.getSwapTotal();
    }

    @Override
    public long getVirtualInUse() {
        return this.global.getTotal() - this.global.getAvailable() + this.getSwapUsed();
    }

    @Override
    public long getSwapPagesIn() {
        return this.inOut.get().getA();
    }

    @Override
    public long getSwapPagesOut() {
        return this.inOut.get().getB();
    }

    private static Pair<Long, Long> querySwapUsage() {
        long l2 = 0L;
        long l3 = 0L;
        SystemB.XswUsage xswUsage = new SystemB.XswUsage();
        if (SysctlUtil.sysctl("vm.swapusage", xswUsage)) {
            l2 = xswUsage.xsu_used;
            l3 = xswUsage.xsu_total;
        }
        return new Pair<Long, Long>(l2, l3);
    }

    private static Pair<Long, Long> queryVmStat() {
        long l2 = 0L;
        long l3 = 0L;
        SystemB.VMStatistics vMStatistics = new SystemB.VMStatistics();
        if (0 == SystemB.INSTANCE.host_statistics(SystemB.INSTANCE.mach_host_self(), 2, vMStatistics, new IntByReference(vMStatistics.size() / SystemB.INT_SIZE))) {
            l2 = ParseUtil.unsignedIntToLong(vMStatistics.pageins);
            l3 = ParseUtil.unsignedIntToLong(vMStatistics.pageouts);
        } else {
            LOG.error("Failed to get host VM info. Error code: {}", (Object)Native.getLastError());
        }
        return new Pair<Long, Long>(l2, l3);
    }
}

