/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.registry;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinPerf;
import com.sun.jna.platform.win32.WinReg;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.PerfCounterWildcardQuery;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

@ThreadSafe
public final class HkeyPerformanceDataUtil {
    private static final Logger LOG = LoggerFactory.getLogger(HkeyPerformanceDataUtil.class);
    private static final String HKEY_PERFORMANCE_TEXT = "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Perflib\\009";
    private static final String COUNTER = "Counter";
    private static final Map<String, Integer> COUNTER_INDEX_MAP = HkeyPerformanceDataUtil.mapCounterIndicesFromRegistry();

    private HkeyPerformanceDataUtil() {
    }

    public static <T extends Enum<T>> Triplet<List<Map<T, Object>>, Long, Long> readPerfDataFromRegistry(String string, Class<T> clazz) {
        Pair<Integer, EnumMap<T, Integer>> pair = HkeyPerformanceDataUtil.getCounterIndices(string, clazz);
        if (pair == null) {
            return null;
        }
        Memory memory = HkeyPerformanceDataUtil.readPerfDataBuffer(string);
        if (memory == null) {
            return null;
        }
        WinPerf.PERF_DATA_BLOCK pERF_DATA_BLOCK = new WinPerf.PERF_DATA_BLOCK(memory.share(0L));
        long l2 = pERF_DATA_BLOCK.PerfTime100nSec.getValue();
        long l3 = WinBase.FILETIME.filetimeToDate((int)(l2 >> 32), (int)(l2 & 0xFFFFFFFFL)).getTime();
        long l4 = pERF_DATA_BLOCK.HeaderLength;
        for (int i2 = 0; i2 < pERF_DATA_BLOCK.NumObjectTypes; ++i2) {
            WinPerf.PERF_OBJECT_TYPE pERF_OBJECT_TYPE = new WinPerf.PERF_OBJECT_TYPE(memory.share(l4));
            if (pERF_OBJECT_TYPE.ObjectNameTitleIndex == COUNTER_INDEX_MAP.get(string)) {
                long l5 = l4 + (long)pERF_OBJECT_TYPE.HeaderLength;
                HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
                HashMap<Integer, Integer> hashMap2 = new HashMap<Integer, Integer>();
                for (int i3 = 0; i3 < pERF_OBJECT_TYPE.NumCounters; ++i3) {
                    WinPerf.PERF_COUNTER_DEFINITION pERF_COUNTER_DEFINITION = new WinPerf.PERF_COUNTER_DEFINITION(memory.share(l5));
                    hashMap.put(pERF_COUNTER_DEFINITION.CounterNameTitleIndex, pERF_COUNTER_DEFINITION.CounterOffset);
                    hashMap2.put(pERF_COUNTER_DEFINITION.CounterNameTitleIndex, pERF_COUNTER_DEFINITION.CounterSize);
                    l5 += (long)pERF_COUNTER_DEFINITION.ByteLength;
                }
                long l6 = l4 + (long)pERF_OBJECT_TYPE.DefinitionLength;
                ArrayList arrayList = new ArrayList(pERF_OBJECT_TYPE.NumInstances);
                for (int i4 = 0; i4 < pERF_OBJECT_TYPE.NumInstances; ++i4) {
                    WinPerf.PERF_INSTANCE_DEFINITION pERF_INSTANCE_DEFINITION = new WinPerf.PERF_INSTANCE_DEFINITION(memory.share(l6));
                    long l7 = l6 + (long)pERF_INSTANCE_DEFINITION.ByteLength;
                    EnumMap<T, Object> enumMap = new EnumMap<T, Object>(clazz);
                    Enum[] enumArray = (Enum[])clazz.getEnumConstants();
                    enumMap.put((T)enumArray[0], (Object)memory.getWideString(l6 + (long)pERF_INSTANCE_DEFINITION.NameOffset));
                    for (int i5 = 1; i5 < enumArray.length; ++i5) {
                        Enum enum_ = enumArray[i5];
                        int n2 = COUNTER_INDEX_MAP.get(((PerfCounterWildcardQuery.PdhCounterWildcardProperty)((Object)enum_)).getCounter());
                        int n3 = hashMap2.getOrDefault(n2, 0);
                        if (n3 == 4) {
                            enumMap.put((T)enum_, (Object)memory.getInt(l7 + (long)((Integer)hashMap.get(n2)).intValue()));
                            continue;
                        }
                        if (n3 == 8) {
                            enumMap.put((T)enum_, (Object)memory.getLong(l7 + (long)((Integer)hashMap.get(n2)).intValue()));
                            continue;
                        }
                        return null;
                    }
                    arrayList.add(enumMap);
                    l6 = l7 + (long)new WinPerf.PERF_COUNTER_BLOCK((Pointer)memory.share((long)l7)).ByteLength;
                }
                return new Triplet<List<Map<T, Object>>, Long, Long>(arrayList, l2, l3);
            }
            l4 += (long)pERF_OBJECT_TYPE.TotalByteLength;
        }
        return null;
    }

    private static <T extends Enum<T>> Pair<Integer, EnumMap<T, Integer>> getCounterIndices(String string, Class<T> clazz) {
        if (!COUNTER_INDEX_MAP.containsKey(string)) {
            LOG.debug("Couldn't find counter index of {}.", (Object)string);
            return null;
        }
        int n2 = COUNTER_INDEX_MAP.get(string);
        Enum[] enumArray = (Enum[])clazz.getEnumConstants();
        EnumMap<T, Integer> enumMap = new EnumMap<T, Integer>(clazz);
        for (int i2 = 1; i2 < enumArray.length; ++i2) {
            Enum enum_ = enumArray[i2];
            String string2 = ((PerfCounterWildcardQuery.PdhCounterWildcardProperty)((Object)enum_)).getCounter();
            if (!COUNTER_INDEX_MAP.containsKey(string2)) {
                LOG.debug("Couldn't find counter index of {}.", (Object)string2);
                return null;
            }
            enumMap.put(enum_, COUNTER_INDEX_MAP.get(string2));
        }
        return new Pair<Integer, EnumMap<T, Integer>>(n2, enumMap);
    }

    private static Memory readPerfDataBuffer(String string) {
        IntByReference intByReference;
        int n2;
        Memory memory;
        String string2 = Integer.toString(COUNTER_INDEX_MAP.get(string));
        int n3 = Advapi32.INSTANCE.RegQueryValueEx(WinReg.HKEY_PERFORMANCE_DATA, string2, 0, null, memory = new Memory(n2 = 4096), intByReference = new IntByReference(n2));
        if (n3 != 0 && n3 != 234) {
            LOG.error("Error reading performance data from registry for {}.", (Object)string);
            return null;
        }
        while (n3 == 234) {
            intByReference.setValue(n2 += 4096);
            memory = new Memory(n2);
            n3 = Advapi32.INSTANCE.RegQueryValueEx(WinReg.HKEY_PERFORMANCE_DATA, string2, 0, null, memory, intByReference);
        }
        return memory;
    }

    private static Map<String, Integer> mapCounterIndicesFromRegistry() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        try {
            String[] stringArray = Advapi32Util.registryGetStringArray(WinReg.HKEY_LOCAL_MACHINE, HKEY_PERFORMANCE_TEXT, COUNTER);
            for (int i2 = 1; i2 < stringArray.length; i2 += 2) {
                hashMap.putIfAbsent(stringArray[i2], Integer.parseInt(stringArray[i2 - 1]));
            }
        }
        catch (Win32Exception win32Exception) {
            LOG.error("Unable to locate English counter names in registry Perflib 009. Counters may need to be rebuilt: ", win32Exception);
        }
        catch (NumberFormatException numberFormatException) {
            LOG.error("Unable to parse English counter names in registry Perflib 009.");
        }
        return Collections.unmodifiableMap(hashMap);
    }
}

