/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.openbsd;

import com.sun.jna.Memory;
import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.VirtualMemory;
import oshi.hardware.common.AbstractGlobalMemory;
import oshi.hardware.platform.unix.openbsd.OpenBsdVirtualMemory;
import oshi.jna.platform.unix.OpenBsdLibc;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.platform.unix.openbsd.OpenBsdSysctlUtil;

@ThreadSafe
final class OpenBsdGlobalMemory
extends AbstractGlobalMemory {
    private final Supplier<Long> available = Memoizer.memoize(OpenBsdGlobalMemory::queryAvailable, Memoizer.defaultExpiration());
    private final Supplier<Long> total = Memoizer.memoize(OpenBsdGlobalMemory::queryPhysMem);
    private final Supplier<Long> pageSize = Memoizer.memoize(OpenBsdGlobalMemory::queryPageSize);
    private final Supplier<VirtualMemory> vm = Memoizer.memoize(this::createVirtualMemory);

    OpenBsdGlobalMemory() {
    }

    @Override
    public long getAvailable() {
        return this.available.get() * this.getPageSize();
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

    private static long queryAvailable() {
        long l2 = 0L;
        long l3 = 0L;
        for (String object2 : ExecutingCommand.runNative("vmstat -s")) {
            if (object2.endsWith("pages free")) {
                l2 = ParseUtil.getFirstIntValue(object2);
                continue;
            }
            if (!object2.endsWith("pages inactive")) continue;
            l3 = ParseUtil.getFirstIntValue(object2);
        }
        Object object3 = new int[3];
        object3[0] = 10;
        object3[1] = false;
        object3[2] = 3;
        Memory memory = OpenBsdSysctlUtil.sysctl((int[])object3);
        OpenBsdLibc.Bcachestats bcachestats = new OpenBsdLibc.Bcachestats(memory);
        return bcachestats.numbufpages + l2 + l3;
    }

    private static long queryPhysMem() {
        return OpenBsdSysctlUtil.sysctl("hw.physmem", 0L);
    }

    private static long queryPageSize() {
        return OpenBsdSysctlUtil.sysctl("hw.pagesize", 4096L);
    }

    private VirtualMemory createVirtualMemory() {
        return new OpenBsdVirtualMemory(this);
    }
}

