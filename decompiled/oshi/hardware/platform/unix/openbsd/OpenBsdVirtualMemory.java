/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.openbsd;

import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.common.AbstractVirtualMemory;
import oshi.hardware.platform.unix.openbsd.OpenBsdGlobalMemory;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.tuples.Triplet;

@ThreadSafe
final class OpenBsdVirtualMemory
extends AbstractVirtualMemory {
    private final OpenBsdGlobalMemory global;
    private final Supplier<Triplet<Integer, Integer, Integer>> usedTotalPgin = Memoizer.memoize(OpenBsdVirtualMemory::queryVmstat, Memoizer.defaultExpiration());
    private final Supplier<Integer> pgout = Memoizer.memoize(OpenBsdVirtualMemory::queryUvm, Memoizer.defaultExpiration());

    OpenBsdVirtualMemory(OpenBsdGlobalMemory openBsdGlobalMemory) {
        this.global = openBsdGlobalMemory;
    }

    @Override
    public long getSwapUsed() {
        return (long)this.usedTotalPgin.get().getA().intValue() * this.global.getPageSize();
    }

    @Override
    public long getSwapTotal() {
        return (long)this.usedTotalPgin.get().getB().intValue() * this.global.getPageSize();
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
        return (long)this.usedTotalPgin.get().getC().intValue() * this.global.getPageSize();
    }

    @Override
    public long getSwapPagesOut() {
        return (long)this.pgout.get().intValue() * this.global.getPageSize();
    }

    private static Triplet<Integer, Integer, Integer> queryVmstat() {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (String string : ExecutingCommand.runNative("vmstat -s")) {
            if (string.contains("swap pages in use")) {
                n2 = ParseUtil.getFirstIntValue(string);
                continue;
            }
            if (string.contains("swap pages")) {
                n3 = ParseUtil.getFirstIntValue(string);
                continue;
            }
            if (!string.contains("pagein operations")) continue;
            n4 = ParseUtil.getFirstIntValue(string);
        }
        return new Triplet<Integer, Integer, Integer>(n2, n3, n4);
    }

    private static int queryUvm() {
        for (String string : ExecutingCommand.runNative("systat -ab uvm")) {
            if (!string.contains("pdpageouts")) continue;
            return ParseUtil.getFirstIntValue(string);
        }
        return 0;
    }
}

