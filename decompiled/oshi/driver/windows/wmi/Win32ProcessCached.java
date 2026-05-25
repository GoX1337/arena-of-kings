/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.wmi;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;
import oshi.annotation.concurrent.GuardedBy;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.windows.wmi.Win32Process;
import oshi.util.Memoizer;
import oshi.util.platform.windows.WmiUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class Win32ProcessCached {
    private static final Supplier<Win32ProcessCached> INSTANCE = Memoizer.memoize(Win32ProcessCached::createInstance);
    @GuardedBy(value="commandLineCacheLock")
    private final Map<Integer, Pair<Long, String>> commandLineCache = new HashMap<Integer, Pair<Long, String>>();
    private final ReentrantLock commandLineCacheLock = new ReentrantLock();

    private Win32ProcessCached() {
    }

    public static Win32ProcessCached getInstance() {
        return INSTANCE.get();
    }

    private static Win32ProcessCached createInstance() {
        return new Win32ProcessCached();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getCommandLine(int n2, long l2) {
        this.commandLineCacheLock.lock();
        try {
            Pair<Long, String> pair = this.commandLineCache.get(n2);
            if (pair != null && l2 < pair.getA()) {
                String string = pair.getB();
                return string;
            }
            long l3 = System.currentTimeMillis();
            WbemcliUtil.WmiResult<Win32Process.CommandLineProperty> wmiResult = Win32Process.queryCommandLines(null);
            if (this.commandLineCache.size() > wmiResult.getResultCount() * 2) {
                this.commandLineCache.clear();
            }
            String string = "";
            for (int i2 = 0; i2 < wmiResult.getResultCount(); ++i2) {
                int n3 = WmiUtil.getUint32(wmiResult, Win32Process.CommandLineProperty.PROCESSID, i2);
                String string2 = WmiUtil.getString(wmiResult, Win32Process.CommandLineProperty.COMMANDLINE, i2);
                this.commandLineCache.put(n3, new Pair<Long, String>(l3, string2));
                if (n3 != n2) continue;
                string = string2;
            }
            String string3 = string;
            return string3;
        }
        finally {
            this.commandLineCacheLock.unlock();
        }
    }
}

