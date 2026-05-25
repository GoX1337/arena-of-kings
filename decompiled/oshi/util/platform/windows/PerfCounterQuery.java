/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.platform.windows;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import com.sun.jna.platform.win32.PdhUtil;
import com.sun.jna.platform.win32.VersionHelpers;
import com.sun.jna.platform.win32.Win32Exception;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.PerfCounterQueryHandler;
import oshi.util.platform.windows.PerfDataUtil;
import oshi.util.platform.windows.WmiQueryHandler;
import oshi.util.platform.windows.WmiUtil;

@ThreadSafe
public final class PerfCounterQuery {
    private static final Logger LOG = LoggerFactory.getLogger(PerfCounterQuery.class);
    private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
    private static final Set<String> FAILED_QUERY_CACHE = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap<String, String> LOCALIZE_CACHE = IS_VISTA_OR_GREATER ? null : new ConcurrentHashMap();
    public static final String TOTAL_INSTANCE = "_Total";
    public static final String TOTAL_INSTANCES = "*_Total";
    public static final String NOT_TOTAL_INSTANCE = "^_Total";
    public static final String NOT_TOTAL_INSTANCES = "^*_Total";

    private PerfCounterQuery() {
    }

    public static <T extends Enum<T>> Map<T, Long> queryValues(Class<T> clazz, String string, String string2) {
        if (!FAILED_QUERY_CACHE.contains(string)) {
            Map<T, Long> map = PerfCounterQuery.queryValuesFromPDH(clazz, string);
            if (!map.isEmpty()) {
                return map;
            }
            LOG.warn("Disabling further attempts to query {}.", (Object)string);
            FAILED_QUERY_CACHE.add(string);
        }
        return PerfCounterQuery.queryValuesFromWMI(clazz, string2);
    }

    public static <T extends Enum<T>> Map<T, Long> queryValuesFromPDH(Class<T> clazz, String string) {
        Enum[] enumArray = (Enum[])clazz.getEnumConstants();
        String string2 = PerfCounterQuery.localizeIfNeeded(string);
        EnumMap<T, PerfDataUtil.PerfCounter> enumMap = new EnumMap<T, PerfDataUtil.PerfCounter>(clazz);
        EnumMap<T, Long> enumMap2 = new EnumMap<T, Long>(clazz);
        try (PerfCounterQueryHandler perfCounterQueryHandler = new PerfCounterQueryHandler();){
            for (Enum enum_ : enumArray) {
                PerfDataUtil.PerfCounter perfCounter = PerfDataUtil.createCounter(string2, ((PdhCounterProperty)((Object)enum_)).getInstance(), ((PdhCounterProperty)((Object)enum_)).getCounter());
                enumMap.put(enum_, perfCounter);
                if (perfCounterQueryHandler.addCounterToQuery(perfCounter)) continue;
                EnumMap<T, Long> enumMap3 = enumMap2;
                return enumMap3;
            }
            if (0L < perfCounterQueryHandler.updateQuery()) {
                for (Enum enum_ : enumArray) {
                    enumMap2.put(enum_, perfCounterQueryHandler.queryCounter((PerfDataUtil.PerfCounter)enumMap.get(enum_)));
                }
            }
        }
        return enumMap2;
    }

    public static <T extends Enum<T>> Map<T, Long> queryValuesFromWMI(Class<T> clazz, String string) {
        WbemcliUtil.WmiQuery<T> wmiQuery = new WbemcliUtil.WmiQuery<T>(string, clazz);
        WbemcliUtil.WmiResult<Enum> wmiResult = Objects.requireNonNull(WmiQueryHandler.createInstance()).queryWMI(wmiQuery);
        EnumMap<T, Long> enumMap = new EnumMap<T, Long>(clazz);
        if (wmiResult.getResultCount() > 0) {
            block6: for (Enum enum_ : (Enum[])clazz.getEnumConstants()) {
                switch (wmiResult.getCIMType(enum_)) {
                    case 18: {
                        enumMap.put(enum_, Long.valueOf(WmiUtil.getUint16(wmiResult, enum_, 0)));
                        continue block6;
                    }
                    case 19: {
                        enumMap.put(enum_, WmiUtil.getUint32asLong(wmiResult, enum_, 0));
                        continue block6;
                    }
                    case 21: {
                        enumMap.put(enum_, WmiUtil.getUint64(wmiResult, enum_, 0));
                        continue block6;
                    }
                    case 101: {
                        enumMap.put(enum_, WmiUtil.getDateTime(wmiResult, enum_, 0).toInstant().toEpochMilli());
                        continue block6;
                    }
                    default: {
                        throw new ClassCastException("Unimplemented CIM Type Mapping.");
                    }
                }
            }
        }
        return enumMap;
    }

    public static String localizeIfNeeded(String string) {
        return IS_VISTA_OR_GREATER ? string : LOCALIZE_CACHE.computeIfAbsent(string, PerfCounterQuery::localizeUsingPerfIndex);
    }

    private static String localizeUsingPerfIndex(String string) {
        String string2 = string;
        try {
            string2 = PdhUtil.PdhLookupPerfNameByIndex(null, PdhUtil.PdhLookupPerfIndexByEnglishName(string));
        }
        catch (Win32Exception win32Exception) {
            LOG.warn("Unable to locate English counter names in registry Perflib 009. Assuming English counters. Error {}. {}", (Object)String.format("0x%x", win32Exception.getHR().intValue()), (Object)"See https://support.microsoft.com/en-us/help/300956/how-to-manually-rebuild-performance-counter-library-values");
        }
        catch (PdhUtil.PdhException pdhException) {
            LOG.warn("Unable to localize {} performance counter.  Error {}.", (Object)string, (Object)String.format("0x%x", pdhException.getErrorCode()));
        }
        if (string2.isEmpty()) {
            return string;
        }
        LOG.debug("Localized {} to {}", (Object)string, (Object)string2);
        return string2;
    }

    public static interface PdhCounterProperty {
        public String getInstance();

        public String getCounter();
    }
}

