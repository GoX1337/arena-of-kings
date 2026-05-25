/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import com.sun.jna.Native;
import com.sun.jna.platform.mac.SystemB;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.PhysicalMemory;
import oshi.hardware.VirtualMemory;
import oshi.hardware.common.AbstractGlobalMemory;
import oshi.hardware.platform.mac.MacVirtualMemory;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.platform.mac.SysctlUtil;

@ThreadSafe
final class MacGlobalMemory
extends AbstractGlobalMemory {
    private static final Logger LOG = LoggerFactory.getLogger(MacGlobalMemory.class);
    private final Supplier<Long> available = Memoizer.memoize(this::queryVmStats, Memoizer.defaultExpiration());
    private final Supplier<Long> total = Memoizer.memoize(MacGlobalMemory::queryPhysMem);
    private final Supplier<Long> pageSize = Memoizer.memoize(MacGlobalMemory::queryPageSize);
    private final Supplier<VirtualMemory> vm = Memoizer.memoize(this::createVirtualMemory);

    MacGlobalMemory() {
    }

    @Override
    public long getAvailable() {
        return this.available.get();
    }

    @Override
    public long getTotal() {
        return this.total.get();
    }

    @Override
    public long getPageSize() {
        return this.pageSize.get();
    }

    @Override
    public VirtualMemory getVirtualMemory() {
        return this.vm.get();
    }

    @Override
    public List<PhysicalMemory> getPhysicalMemory() {
        ArrayList<PhysicalMemory> arrayList = new ArrayList<PhysicalMemory>();
        List<String> list = ExecutingCommand.runNative("system_profiler SPMemoryDataType");
        int n2 = 0;
        String string = "unknown";
        long l2 = 0L;
        long l3 = 0L;
        String string2 = "unknown";
        String string3 = "unknown";
        for (String string4 : list) {
            String[] stringArray;
            if (string4.trim().startsWith("BANK")) {
                int n3;
                if (n2++ > 0) {
                    arrayList.add(new PhysicalMemory(string, l2, l3, string2, string3));
                }
                if ((n3 = (string = string4.trim()).lastIndexOf(58)) <= 0) continue;
                string = string.substring(0, n3 - 1);
                continue;
            }
            if (n2 <= 0 || (stringArray = string4.trim().split(":")).length != 2) continue;
            switch (stringArray[0]) {
                case "Size": {
                    l2 = ParseUtil.parseDecimalMemorySizeToBinary(stringArray[1].trim());
                    break;
                }
                case "Type": {
                    string3 = stringArray[1].trim();
                    break;
                }
                case "Speed": {
                    l3 = ParseUtil.parseHertz(stringArray[1]);
                    break;
                }
                case "Manufacturer": {
                    string2 = stringArray[1].trim();
                    break;
                }
            }
        }
        arrayList.add(new PhysicalMemory(string, l2, l3, string2, string3));
        return arrayList;
    }

    private long queryVmStats() {
        SystemB.VMStatistics vMStatistics = new SystemB.VMStatistics();
        if (0 != SystemB.INSTANCE.host_statistics(SystemB.INSTANCE.mach_host_self(), 2, vMStatistics, new IntByReference(vMStatistics.size() / SystemB.INT_SIZE))) {
            LOG.error("Failed to get host VM info. Error code: {}", (Object)Native.getLastError());
            return 0L;
        }
        return (long)(vMStatistics.free_count + vMStatistics.inactive_count) * this.getPageSize();
    }

    private static long queryPhysMem() {
        return SysctlUtil.sysctl("hw.memsize", 0L);
    }

    private static long queryPageSize() {
        LongByReference longByReference = new LongByReference();
        if (0 == SystemB.INSTANCE.host_page_size(SystemB.INSTANCE.mach_host_self(), longByReference)) {
            return longByReference.getValue();
        }
        LOG.error("Failed to get host page size. Error code: {}", (Object)Native.getLastError());
        return 4098L;
    }

    private VirtualMemory createVirtualMemory() {
        return new MacVirtualMemory(this);
    }
}

