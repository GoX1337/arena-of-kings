/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.platform.windows;

import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.Pdh;
import com.sun.jna.platform.win32.VersionHelpers;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.Immutable;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.FormatUtil;
import oshi.util.ParseUtil;
import oshi.util.Util;

@ThreadSafe
public final class PerfDataUtil {
    private static final Logger LOG = LoggerFactory.getLogger(PerfDataUtil.class);
    private static final BaseTSD.DWORD_PTR PZERO = new BaseTSD.DWORD_PTR(0L);
    private static final WinDef.DWORDByReference PDH_FMT_RAW = new WinDef.DWORDByReference(new WinDef.DWORD(16L));
    private static final Pdh PDH = Pdh.INSTANCE;
    private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();

    private PerfDataUtil() {
    }

    public static PerfCounter createCounter(String string, String string2, String string3) {
        return new PerfCounter(string, string2, string3);
    }

    public static long updateQueryTimestamp(WinNT.HANDLEByReference hANDLEByReference) {
        WinDef.LONGLONGByReference lONGLONGByReference = new WinDef.LONGLONGByReference();
        int n2 = IS_VISTA_OR_GREATER ? PDH.PdhCollectQueryDataWithTime(hANDLEByReference.getValue(), lONGLONGByReference) : PDH.PdhCollectQueryData(hANDLEByReference.getValue());
        int n3 = 0;
        while (n2 == -2147481643 && n3++ < 3) {
            Util.sleep(1 << n3);
            n2 = IS_VISTA_OR_GREATER ? PDH.PdhCollectQueryDataWithTime(hANDLEByReference.getValue(), lONGLONGByReference) : PDH.PdhCollectQueryData(hANDLEByReference.getValue());
        }
        if (n2 != 0) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("Failed to update counter. Error code: {}", (Object)String.format(FormatUtil.formatError(n2), new Object[0]));
            }
            return 0L;
        }
        return IS_VISTA_OR_GREATER ? ParseUtil.filetimeToUtcMs(lONGLONGByReference.getValue().longValue(), true) : System.currentTimeMillis();
    }

    public static boolean openQuery(WinNT.HANDLEByReference hANDLEByReference) {
        int n2 = PDH.PdhOpenQuery(null, PZERO, hANDLEByReference);
        if (n2 != 0) {
            if (LOG.isErrorEnabled()) {
                LOG.error("Failed to open PDH Query. Error code: {}", (Object)String.format(FormatUtil.formatError(n2), new Object[0]));
            }
            return false;
        }
        return true;
    }

    public static boolean closeQuery(WinNT.HANDLEByReference hANDLEByReference) {
        return 0 == PDH.PdhCloseQuery(hANDLEByReference.getValue());
    }

    public static long queryCounter(WinNT.HANDLEByReference hANDLEByReference) {
        Pdh.PDH_RAW_COUNTER pDH_RAW_COUNTER = new Pdh.PDH_RAW_COUNTER();
        int n2 = PDH.PdhGetRawCounterValue(hANDLEByReference.getValue(), PDH_FMT_RAW, pDH_RAW_COUNTER);
        if (n2 != 0) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("Failed to get counter. Error code: {}", (Object)String.format(FormatUtil.formatError(n2), new Object[0]));
            }
            return n2;
        }
        return pDH_RAW_COUNTER.FirstValue;
    }

    public static boolean addCounter(WinNT.HANDLEByReference hANDLEByReference, String string, WinNT.HANDLEByReference hANDLEByReference2) {
        int n2;
        int n3 = n2 = IS_VISTA_OR_GREATER ? PDH.PdhAddEnglishCounter(hANDLEByReference.getValue(), string, PZERO, hANDLEByReference2) : PDH.PdhAddCounter(hANDLEByReference.getValue(), string, PZERO, hANDLEByReference2);
        if (n2 != 0) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("Failed to add PDH Counter: {}, Error code: {}", (Object)string, (Object)String.format(FormatUtil.formatError(n2), new Object[0]));
            }
            return false;
        }
        return true;
    }

    public static boolean removeCounter(WinNT.HANDLEByReference hANDLEByReference) {
        return 0 == PDH.PdhRemoveCounter(hANDLEByReference.getValue());
    }

    @Immutable
    public static class PerfCounter {
        private String object;
        private String instance;
        private String counter;

        public PerfCounter(String string, String string2, String string3) {
            this.object = string;
            this.instance = string2;
            this.counter = string3;
        }

        public String getObject() {
            return this.object;
        }

        public String getInstance() {
            return this.instance;
        }

        public String getCounter() {
            return this.counter;
        }

        public String getCounterPath() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\\').append(this.object);
            if (this.instance != null) {
                stringBuilder.append('(').append(this.instance).append(')');
            }
            stringBuilder.append('\\').append(this.counter);
            return stringBuilder.toString();
        }
    }
}

