/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.solaris.kstat;

import com.sun.jna.platform.unix.solaris.LibKstat;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.unix.solaris.KstatUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class SystemPages {
    private SystemPages() {
    }

    public static Pair<Long, Long> queryAvailableTotal() {
        long l2 = 0L;
        long l3 = 0L;
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup(null, -1, "system_pages");
            if (kstat != null && KstatUtil.KstatChain.read(kstat)) {
                l2 = KstatUtil.dataLookupLong(kstat, "availrmem");
                l3 = KstatUtil.dataLookupLong(kstat, "physmem");
            }
        }
        return new Pair<Long, Long>(l2, l3);
    }
}

