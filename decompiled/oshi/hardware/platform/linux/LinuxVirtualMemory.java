/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import java.util.List;
import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.common.AbstractVirtualMemory;
import oshi.hardware.platform.linux.LinuxGlobalMemory;
import oshi.util.FileUtil;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.platform.linux.ProcPath;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

@ThreadSafe
final class LinuxVirtualMemory
extends AbstractVirtualMemory {
    private final LinuxGlobalMemory global;
    private final Supplier<Triplet<Long, Long, Long>> usedTotalCommitLim = Memoizer.memoize(LinuxVirtualMemory::queryMemInfo, Memoizer.defaultExpiration());
    private final Supplier<Pair<Long, Long>> inOut = Memoizer.memoize(LinuxVirtualMemory::queryVmStat, Memoizer.defaultExpiration());

    LinuxVirtualMemory(LinuxGlobalMemory linuxGlobalMemory) {
        this.global = linuxGlobalMemory;
    }

    @Override
    public long getSwapUsed() {
        return this.usedTotalCommitLim.get().getA();
    }

    @Override
    public long getSwapTotal() {
        return this.usedTotalCommitLim.get().getB();
    }

    @Override
    public long getVirtualMax() {
        return this.usedTotalCommitLim.get().getC();
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

    private static Triplet<Long, Long, Long> queryMemInfo() {
        long l2 = 0L;
        long l3 = 0L;
        long l4 = 0L;
        List<String> list = FileUtil.readFile(ProcPath.MEMINFO);
        for (String string : list) {
            String[] stringArray = ParseUtil.whitespaces.split(string);
            if (stringArray.length <= 1) continue;
            switch (stringArray[0]) {
                case "SwapTotal:": {
                    l3 = LinuxVirtualMemory.parseMeminfo(stringArray);
                    break;
                }
                case "SwapFree:": {
                    l2 = LinuxVirtualMemory.parseMeminfo(stringArray);
                    break;
                }
                case "CommitLimit:": {
                    l4 = LinuxVirtualMemory.parseMeminfo(stringArray);
                    break;
                }
            }
        }
        return new Triplet<Long, Long, Long>(l3 - l2, l3, l4);
    }

    private static Pair<Long, Long> queryVmStat() {
        long l2 = 0L;
        long l3 = 0L;
        List<String> list = FileUtil.readFile(ProcPath.VMSTAT);
        for (String string : list) {
            String[] stringArray = ParseUtil.whitespaces.split(string);
            if (stringArray.length <= 1) continue;
            switch (stringArray[0]) {
                case "pswpin": {
                    l2 = ParseUtil.parseLongOrDefault(stringArray[1], 0L);
                    break;
                }
                case "pswpout": {
                    l3 = ParseUtil.parseLongOrDefault(stringArray[1], 0L);
                    break;
                }
            }
        }
        return new Pair<Long, Long>(l2, l3);
    }

    private static long parseMeminfo(String[] stringArray) {
        if (stringArray.length < 2) {
            return 0L;
        }
        long l2 = ParseUtil.parseLongOrDefault(stringArray[1], 0L);
        if (stringArray.length > 2 && "kB".equals(stringArray[2])) {
            l2 *= 1024L;
        }
        return l2;
    }
}

