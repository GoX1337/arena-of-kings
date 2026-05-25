/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.platform.unix.LibCAPI$size_t$ByReference
 */
package oshi.util.platform.unix.freebsd;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.unix.LibCAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.unix.FreeBsdLibc;

@ThreadSafe
public final class BsdSysctlUtil {
    private static final Logger LOG = LoggerFactory.getLogger(BsdSysctlUtil.class);
    private static final String SYSCTL_FAIL = "Failed sysctl call: {}, Error code: {}";

    private BsdSysctlUtil() {
    }

    public static int sysctl(String string, int n2) {
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t((long)FreeBsdLibc.INT_SIZE));
        Memory memory = new Memory(byReference.longValue());
        if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(string, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.warn(SYSCTL_FAIL, (Object)string, (Object)Native.getLastError());
            return n2;
        }
        return ((Pointer)memory).getInt(0L);
    }

    public static long sysctl(String string, long l2) {
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t((long)FreeBsdLibc.UINT64_SIZE));
        Memory memory = new Memory(byReference.longValue());
        if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(string, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.warn(SYSCTL_FAIL, (Object)string, (Object)Native.getLastError());
            return l2;
        }
        return ((Pointer)memory).getLong(0L);
    }

    public static String sysctl(String string, String string2) {
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference();
        if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(string, null, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.warn(SYSCTL_FAIL, (Object)string, (Object)Native.getLastError());
            return string2;
        }
        Memory memory = new Memory(byReference.longValue() + 1L);
        if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(string, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.warn(SYSCTL_FAIL, (Object)string, (Object)Native.getLastError());
            return string2;
        }
        return memory.getString(0L);
    }

    public static boolean sysctl(String string, Structure structure) {
        if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(string, structure.getPointer(), new LibCAPI.size_t.ByReference(new LibCAPI.size_t((long)structure.size())), null, LibCAPI.size_t.ZERO)) {
            LOG.error(SYSCTL_FAIL, (Object)string, (Object)Native.getLastError());
            return false;
        }
        structure.read();
        return true;
    }

    public static Memory sysctl(String string) {
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference();
        if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(string, null, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.error(SYSCTL_FAIL, (Object)string, (Object)Native.getLastError());
            return null;
        }
        Memory memory = new Memory(byReference.longValue());
        if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(string, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.error(SYSCTL_FAIL, (Object)string, (Object)Native.getLastError());
            return null;
        }
        return memory;
    }
}

