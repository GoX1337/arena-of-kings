/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.platform.unix.solaris;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.unix.solaris.LibKstat;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.FormatUtil;
import oshi.util.Util;

@ThreadSafe
public final class KstatUtil {
    private static final Logger LOG = LoggerFactory.getLogger(KstatUtil.class);
    private static final LibKstat KS = LibKstat.INSTANCE;
    private static final LibKstat.KstatCtl KC = KS.kstat_open();
    private static final ReentrantLock CHAIN = new ReentrantLock();

    private KstatUtil() {
    }

    public static KstatChain openChain() {
        return new KstatChain();
    }

    public static String dataLookupString(LibKstat.Kstat kstat, String string) {
        if (kstat.ks_type != 1 && kstat.ks_type != 4) {
            throw new IllegalArgumentException("Not a kstat_named or kstat_timer kstat.");
        }
        Pointer pointer = KS.kstat_data_lookup(kstat, string);
        if (pointer == null) {
            LOG.debug("Failed to lookup kstat value for key {}", (Object)string);
            return "";
        }
        LibKstat.KstatNamed kstatNamed = new LibKstat.KstatNamed(pointer);
        switch (kstatNamed.data_type) {
            case 0: {
                return Native.toString(kstatNamed.value.charc, StandardCharsets.UTF_8);
            }
            case 1: {
                return Integer.toString(kstatNamed.value.i32);
            }
            case 2: {
                return FormatUtil.toUnsignedString(kstatNamed.value.ui32);
            }
            case 3: {
                return Long.toString(kstatNamed.value.i64);
            }
            case 4: {
                return FormatUtil.toUnsignedString(kstatNamed.value.ui64);
            }
            case 9: {
                return kstatNamed.value.str.addr.getString(0L);
            }
        }
        LOG.error("Unimplemented kstat data type {}", (Object)kstatNamed.data_type);
        return "";
    }

    public static long dataLookupLong(LibKstat.Kstat kstat, String string) {
        if (kstat.ks_type != 1 && kstat.ks_type != 4) {
            throw new IllegalArgumentException("Not a kstat_named or kstat_timer kstat.");
        }
        Pointer pointer = KS.kstat_data_lookup(kstat, string);
        if (pointer == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Failed lo lookup kstat value on {}:{}:{} for key {}", Native.toString(kstat.ks_module, StandardCharsets.US_ASCII), kstat.ks_instance, Native.toString(kstat.ks_name, StandardCharsets.US_ASCII), string);
            }
            return 0L;
        }
        LibKstat.KstatNamed kstatNamed = new LibKstat.KstatNamed(pointer);
        switch (kstatNamed.data_type) {
            case 1: {
                return kstatNamed.value.i32;
            }
            case 2: {
                return FormatUtil.getUnsignedInt(kstatNamed.value.ui32);
            }
            case 3: {
                return kstatNamed.value.i64;
            }
            case 4: {
                return kstatNamed.value.ui64;
            }
        }
        LOG.error("Unimplemented or non-numeric kstat data type {}", (Object)kstatNamed.data_type);
        return 0L;
    }

    public static final class KstatChain
    implements AutoCloseable {
        private KstatChain() {
            CHAIN.lock();
            KstatChain.update();
        }

        public static boolean read(LibKstat.Kstat kstat) {
            int n2 = 0;
            while (0 > KS.kstat_read(KC, kstat, null)) {
                if (11 != Native.getLastError() || 5 <= ++n2) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Failed to read kstat {}:{}:{}", Native.toString(kstat.ks_module, StandardCharsets.US_ASCII), kstat.ks_instance, Native.toString(kstat.ks_name, StandardCharsets.US_ASCII));
                    }
                    return false;
                }
                Util.sleep(8 << n2);
            }
            return true;
        }

        public static LibKstat.Kstat lookup(String string, int n2, String string2) {
            return KS.kstat_lookup(KC, string, n2, string2);
        }

        public static List<LibKstat.Kstat> lookupAll(String string, int n2, String string2) {
            ArrayList<LibKstat.Kstat> arrayList = new ArrayList<LibKstat.Kstat>();
            for (LibKstat.Kstat kstat = KS.kstat_lookup(KC, string, n2, string2); kstat != null; kstat = kstat.next()) {
                if (string != null && !string.equals(Native.toString(kstat.ks_module, StandardCharsets.US_ASCII)) || n2 >= 0 && n2 != kstat.ks_instance || string2 != null && !string2.equals(Native.toString(kstat.ks_name, StandardCharsets.US_ASCII))) continue;
                arrayList.add(kstat);
            }
            return arrayList;
        }

        public static int update() {
            return KS.kstat_chain_update(KC);
        }

        @Override
        public void close() {
            CHAIN.unlock();
        }
    }
}

