/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.platform.windows;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import com.sun.jna.platform.win32.PdhUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.Util;
import oshi.util.platform.windows.PerfCounterQuery;
import oshi.util.platform.windows.PerfCounterQueryHandler;
import oshi.util.platform.windows.PerfDataUtil;
import oshi.util.platform.windows.WmiQueryHandler;
import oshi.util.platform.windows.WmiUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class PerfCounterWildcardQuery {
    private static final Logger LOG = LoggerFactory.getLogger(PerfCounterWildcardQuery.class);
    private static final Set<String> FAILED_QUERY_CACHE = ConcurrentHashMap.newKeySet();

    private PerfCounterWildcardQuery() {
    }

    public static <T extends Enum<T>> Pair<List<String>, Map<T, List<Long>>> queryInstancesAndValues(Class<T> clazz, String string, String string2) {
        if (!FAILED_QUERY_CACHE.contains(string)) {
            Pair<List<String>, Map<T, List<Long>>> pair = PerfCounterWildcardQuery.queryInstancesAndValuesFromPDH(clazz, string);
            if (!pair.getA().isEmpty()) {
                return pair;
            }
            LOG.warn("Disabling further attempts to query {}.", (Object)string);
            FAILED_QUERY_CACHE.add(string);
        }
        return PerfCounterWildcardQuery.queryInstancesAndValuesFromWMI(clazz, string2);
    }

    public static <T extends Enum<T>> Pair<List<String>, Map<T, List<Long>>> queryInstancesAndValuesFromPDH(Class<T> clazz, String string) {
        PdhUtil.PdhEnumObjectItems pdhEnumObjectItems;
        Enum[] enumArray = (Enum[])clazz.getEnumConstants();
        if (enumArray.length < 2) {
            throw new IllegalArgumentException("Enum " + clazz.getName() + " must have at least two elements, an instance filter and a counter.");
        }
        String string3 = ((PdhCounterWildcardProperty)((Object)((Enum[])clazz.getEnumConstants())[0])).getCounter().toLowerCase();
        String string4 = PerfCounterQuery.localizeIfNeeded(string);
        try {
            pdhEnumObjectItems = PdhUtil.PdhEnumObjectItems(null, null, string4, 100);
        }
        catch (PdhUtil.PdhException pdhException) {
            return new Pair<List<String>, Map<T, List<Long>>>(Collections.emptyList(), Collections.emptyMap());
        }
        List<String> list = pdhEnumObjectItems.getInstances();
        list.removeIf(string2 -> !Util.wildcardMatch(string2.toLowerCase(), string3));
        EnumMap enumMap = new EnumMap(clazz);
        try (PerfCounterQueryHandler perfCounterQueryHandler = new PerfCounterQueryHandler();){
            ArrayList<Object> arrayList;
            Enum enum_;
            int n2;
            EnumMap enumMap2 = new EnumMap(clazz);
            for (n2 = 1; n2 < enumArray.length; ++n2) {
                enum_ = enumArray[n2];
                arrayList = new ArrayList<Object>(list.size());
                for (String object : list) {
                    PerfDataUtil.PerfCounter perfCounter = PerfDataUtil.createCounter(string, object, ((PdhCounterWildcardProperty)((Object)enum_)).getCounter());
                    if (!perfCounterQueryHandler.addCounterToQuery(perfCounter)) {
                        Pair<List<String>, Map<T, List<Long>>> pair = new Pair<List<String>, Map<T, List<Long>>>(Collections.emptyList(), Collections.emptyMap());
                        return pair;
                    }
                    arrayList.add(perfCounter);
                }
                enumMap2.put(enum_, arrayList);
            }
            if (0L < perfCounterQueryHandler.updateQuery()) {
                for (n2 = 1; n2 < enumArray.length; ++n2) {
                    enum_ = enumArray[n2];
                    arrayList = new ArrayList();
                    for (PerfDataUtil.PerfCounter perfCounter : (List)enumMap2.get(enum_)) {
                        arrayList.add(perfCounterQueryHandler.queryCounter(perfCounter));
                    }
                    enumMap.put(enum_, arrayList);
                }
            }
        }
        return new Pair<List<String>, Map<T, List<Long>>>(list, enumMap);
    }

    public static <T extends Enum<T>> Pair<List<String>, Map<T, List<Long>>> queryInstancesAndValuesFromWMI(Class<T> clazz, String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        EnumMap enumMap = new EnumMap(clazz);
        WbemcliUtil.WmiQuery<T> wmiQuery = new WbemcliUtil.WmiQuery<T>(string, clazz);
        WbemcliUtil.WmiResult<Enum> wmiResult = Objects.requireNonNull(WmiQueryHandler.createInstance()).queryWMI(wmiQuery);
        if (wmiResult.getResultCount() > 0) {
            for (Enum enum_ : (Enum[])clazz.getEnumConstants()) {
                if (enum_.ordinal() == 0) {
                    for (int i2 = 0; i2 < wmiResult.getResultCount(); ++i2) {
                        arrayList.add(WmiUtil.getString(wmiResult, enum_, i2));
                    }
                    continue;
                }
                ArrayList<Long> arrayList2 = new ArrayList<Long>();
                block8: for (int i3 = 0; i3 < wmiResult.getResultCount(); ++i3) {
                    switch (wmiResult.getCIMType(enum_)) {
                        case 18: {
                            arrayList2.add(Long.valueOf(WmiUtil.getUint16(wmiResult, enum_, i3)));
                            continue block8;
                        }
                        case 19: {
                            arrayList2.add(WmiUtil.getUint32asLong(wmiResult, enum_, i3));
                            continue block8;
                        }
                        case 21: {
                            arrayList2.add(WmiUtil.getUint64(wmiResult, enum_, i3));
                            continue block8;
                        }
                        case 101: {
                            arrayList2.add(WmiUtil.getDateTime(wmiResult, enum_, i3).toInstant().toEpochMilli());
                            continue block8;
                        }
                        default: {
                            throw new ClassCastException("Unimplemented CIM Type Mapping.");
                        }
                    }
                }
                enumMap.put(enum_, arrayList2);
            }
        }
        return new Pair<List<String>, Map<T, List<Long>>>(arrayList, enumMap);
    }

    public static interface PdhCounterWildcardProperty {
        public String getCounter();
    }
}

