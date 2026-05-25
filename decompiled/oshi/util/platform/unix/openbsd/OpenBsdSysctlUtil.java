/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.platform.unix.LibCAPI$size_t$ByReference
 */
package oshi.util.platform.unix.openbsd;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.unix.LibCAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.unix.OpenBsdLibc;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class OpenBsdSysctlUtil {
    private static final String SYSCTL_N = "sysctl -n ";
    private static final Logger LOG = LoggerFactory.getLogger(OpenBsdSysctlUtil.class);
    private static final String SYSCTL_FAIL = "Failed sysctl call: {}, Error code: {}";

    private OpenBsdSysctlUtil() {
    }

    public static int sysctl(int[] nArray, int n2) {
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t((long)OpenBsdLibc.INT_SIZE));
        Memory memory = new Memory(byReference.longValue());
        if (0 != OpenBsdLibc.INSTANCE.sysctl(nArray, nArray.length, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.warn(SYSCTL_FAIL, (Object)nArray, (Object)Native.getLastError());
            return n2;
        }
        return ((Pointer)memory).getInt(0L);
    }

    public static long sysctl(int[] nArray, long l2) {
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t((long)OpenBsdLibc.UINT64_SIZE));
        Memory memory = new Memory(byReference.longValue());
        if (0 != OpenBsdLibc.INSTANCE.sysctl(nArray, nArray.length, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.warn(SYSCTL_FAIL, (Object)nArray, (Object)Native.getLastError());
            return l2;
        }
        return ((Pointer)memory).getLong(0L);
    }

    public static String sysctl(int[] nArray, String string) {
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference();
        if (0 != OpenBsdLibc.INSTANCE.sysctl(nArray, nArray.length, null, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.warn(SYSCTL_FAIL, (Object)nArray, (Object)Native.getLastError());
            return string;
        }
        Memory memory = new Memory(byReference.longValue() + 1L);
        if (0 != OpenBsdLibc.INSTANCE.sysctl(nArray, nArray.length, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.warn(SYSCTL_FAIL, (Object)nArray, (Object)Native.getLastError());
            return string;
        }
        return memory.getString(0L);
    }

    public static boolean sysctl(int[] nArray, Structure structure) {
        if (0 != OpenBsdLibc.INSTANCE.sysctl(nArray, nArray.length, structure.getPointer(), new LibCAPI.size_t.ByReference(new LibCAPI.size_t((long)structure.size())), null, LibCAPI.size_t.ZERO)) {
            LOG.error(SYSCTL_FAIL, (Object)nArray, (Object)Native.getLastError());
            return false;
        }
        structure.read();
        return true;
    }

    public static Memory sysctl(int[] nArray) {
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference();
        if (0 != OpenBsdLibc.INSTANCE.sysctl(nArray, nArray.length, null, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.error(SYSCTL_FAIL, (Object)nArray, (Object)Native.getLastError());
            return null;
        }
        Memory memory = new Memory(byReference.longValue());
        if (0 != OpenBsdLibc.INSTANCE.sysctl(nArray, nArray.length, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.error(SYSCTL_FAIL, (Object)nArray, (Object)Native.getLastError());
            return null;
        }
        return memory;
    }

    public static int sysctl(String string, int n2) {
        return ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer(SYSCTL_N + string), n2);
    }

    public static long sysctl(String string, long l2) {
        return ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer(SYSCTL_N + string), l2);
    }

    public static String sysctl(String string, String string2) {
        String string3 = ExecutingCommand.getFirstAnswer(SYSCTL_N + string);
        if (null == string3 || string3.isEmpty()) {
            return string2;
        }
        return string3;
    }
}

