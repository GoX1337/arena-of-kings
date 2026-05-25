/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import java.util.List;
import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.VirtualMemory;
import oshi.hardware.common.AbstractGlobalMemory;
import oshi.hardware.platform.linux.LinuxVirtualMemory;
import oshi.util.ExecutingCommand;
import oshi.util.FileUtil;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.platform.linux.ProcPath;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class LinuxGlobalMemory
extends AbstractGlobalMemory {
    public static final long PAGE_SIZE = ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("getconf PAGE_SIZE"), 4096L);
    private final Supplier<Pair<Long, Long>> availTotal = Memoizer.memoize(LinuxGlobalMemory::readMemInfo, Memoizer.defaultExpiration());
    private final Supplier<VirtualMemory> vm = Memoizer.memoize(this::createVirtualMemory);

    @Override
    public long getAvailable() {
        return this.availTotal.get().getA();
    }

    @Override
    public long getTotal() {
        return this.availTotal.get().getB();
    }

    @Override
    public long getPageSize() {
        return PAGE_SIZE;
    }

    @Override
    public VirtualMemory getVirtualMemory() {
        return this.vm.get();
    }

    private static Pair<Long, Long> readMemInfo() {
        long l2 = 0L;
        long l3 = 0L;
        long l4 = 0L;
        long l5 = 0L;
        long l6 = 0L;
        List<String> list = FileUtil.readFile(ProcPath.MEMINFO);
        for (String string : list) {
            String[] stringArray = ParseUtil.whitespaces.split(string, 2);
            if (stringArray.length <= 1) continue;
            switch (stringArray[0]) {
                case "MemTotal:": {
                    l6 = ParseUtil.parseDecimalMemorySizeToBinary(stringArray[1]);
                    break;
                }
                case "MemAvailable:": {
                    long l7 = ParseUtil.parseDecimalMemorySizeToBinary(stringArray[1]);
                    return new Pair<Long, Long>(l7, l6);
                }
                case "MemFree:": {
                    l2 = ParseUtil.parseDecimalMemorySizeToBinary(stringArray[1]);
                    break;
                }
                case "Active(file):": {
                    l3 = ParseUtil.parseDecimalMemorySizeToBinary(stringArray[1]);
                    break;
                }
                case "Inactive(file):": {
                    l4 = ParseUtil.parseDecimalMemorySizeToBinary(stringArray[1]);
                    break;
                }
                case "SReclaimable:": {
                    l5 = ParseUtil.parseDecimalMemorySizeToBinary(stringArray[1]);
                    break;
                }
            }
        }
        return new Pair<Long, Long>(l2 + l3 + l4 + l5, l6);
    }

    private VirtualMemory createVirtualMemory() {
        return new LinuxVirtualMemory(this);
    }
}

