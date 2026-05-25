/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.aix;

import com.sun.jna.platform.unix.aix.Perfstat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.aix.perfstat.PerfstatMemory;
import oshi.hardware.PhysicalMemory;
import oshi.hardware.VirtualMemory;
import oshi.hardware.common.AbstractGlobalMemory;
import oshi.hardware.platform.unix.aix.AixVirtualMemory;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;

@ThreadSafe
final class AixGlobalMemory
extends AbstractGlobalMemory {
    private final Supplier<Perfstat.perfstat_memory_total_t> perfstatMem = Memoizer.memoize(AixGlobalMemory::queryPerfstat, Memoizer.defaultExpiration());
    private final Supplier<List<String>> lscfg;
    private static final long PAGESIZE = 4096L;
    private final Supplier<VirtualMemory> vm = Memoizer.memoize(this::createVirtualMemory);

    AixGlobalMemory(Supplier<List<String>> supplier) {
        this.lscfg = supplier;
    }

    @Override
    public long getAvailable() {
        return this.perfstatMem.get().real_avail * 4096L;
    }

    @Override
    public long getTotal() {
        return this.perfstatMem.get().real_total * 4096L;
    }

    @Override
    public long getPageSize() {
        return 4096L;
    }

    @Override
    public VirtualMemory getVirtualMemory() {
        return this.vm.get();
    }

    @Override
    public List<PhysicalMemory> getPhysicalMemory() {
        ArrayList<PhysicalMemory> arrayList = new ArrayList<PhysicalMemory>();
        boolean bl2 = false;
        String string = "unknown";
        String string2 = "";
        long l2 = 0L;
        for (String string3 : this.lscfg.get()) {
            String string4 = string3.trim();
            if (string4.endsWith("memory-module")) {
                bl2 = true;
                continue;
            }
            if (!bl2) continue;
            if (string4.startsWith("Node:")) {
                string = string4.substring(5).trim();
                if (!string.startsWith("IBM,")) continue;
                string = string.substring(4);
                continue;
            }
            if (string4.startsWith("Physical Location:")) {
                string2 = "/" + string4.substring(18).trim();
                continue;
            }
            if (string4.startsWith("Size")) {
                l2 = ParseUtil.parseLongOrDefault(ParseUtil.removeLeadingDots(string4.substring(4).trim()), 0L) << 20;
                continue;
            }
            if (!string4.startsWith("Hardware Location Code")) continue;
            if (l2 > 0L) {
                arrayList.add(new PhysicalMemory(string + string2, l2, 0L, "IBM", "unknown"));
            }
            string = "unknown";
            string2 = "";
            l2 = 0L;
            bl2 = false;
        }
        return arrayList;
    }

    private static Perfstat.perfstat_memory_total_t queryPerfstat() {
        return PerfstatMemory.queryMemoryTotal();
    }

    private VirtualMemory createVirtualMemory() {
        return new AixVirtualMemory(this.perfstatMem);
    }
}

