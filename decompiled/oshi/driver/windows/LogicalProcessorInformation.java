/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows;

import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.WinNT;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.CentralProcessor;

@ThreadSafe
public final class LogicalProcessorInformation {
    private LogicalProcessorInformation() {
    }

    public static List<CentralProcessor.LogicalProcessor> getLogicalProcessorInformationEx() {
        WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX[] sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EXArray = Kernel32Util.getLogicalProcessorInformationEx(65535);
        ArrayList<WinNT.GROUP_AFFINITY[]> arrayList = new ArrayList<WinNT.GROUP_AFFINITY[]>();
        ArrayList<WinNT.GROUP_AFFINITY> arrayList2 = new ArrayList<WinNT.GROUP_AFFINITY>();
        ArrayList<WinNT.NUMA_NODE_RELATIONSHIP> arrayList3 = new ArrayList<WinNT.NUMA_NODE_RELATIONSHIP>();
        block5: for (int i2 = 0; i2 < sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EXArray.length; ++i2) {
            switch (sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EXArray[i2].relationship) {
                case 3: {
                    arrayList.add(((WinNT.PROCESSOR_RELATIONSHIP)sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EXArray[i2]).groupMask);
                    continue block5;
                }
                case 0: {
                    arrayList2.add(((WinNT.PROCESSOR_RELATIONSHIP)sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EXArray[i2]).groupMask[0]);
                    continue block5;
                }
                case 1: {
                    arrayList3.add((WinNT.NUMA_NODE_RELATIONSHIP)sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EXArray[i2]);
                    continue block5;
                }
            }
        }
        arrayList2.sort(Comparator.comparing(gROUP_AFFINITY -> (long)gROUP_AFFINITY.group * 64L + gROUP_AFFINITY.mask.longValue()));
        arrayList.sort(Comparator.comparing(gROUP_AFFINITYArray -> (long)gROUP_AFFINITYArray[0].group * 64L + gROUP_AFFINITYArray[0].mask.longValue()));
        arrayList3.sort(Comparator.comparing(nUMA_NODE_RELATIONSHIP -> nUMA_NODE_RELATIONSHIP.nodeNumber));
        ArrayList<CentralProcessor.LogicalProcessor> arrayList4 = new ArrayList<CentralProcessor.LogicalProcessor>();
        for (WinNT.NUMA_NODE_RELATIONSHIP nUMA_NODE_RELATIONSHIP2 : arrayList3) {
            int n2 = nUMA_NODE_RELATIONSHIP2.nodeNumber;
            short s2 = nUMA_NODE_RELATIONSHIP2.groupMask.group;
            long l2 = nUMA_NODE_RELATIONSHIP2.groupMask.mask.longValue();
            int n3 = Long.numberOfTrailingZeros(l2);
            int n4 = 63 - Long.numberOfLeadingZeros(l2);
            for (int i3 = n3; i3 <= n4; ++i3) {
                if ((l2 & 1L << i3) == 0L) continue;
                CentralProcessor.LogicalProcessor logicalProcessor = new CentralProcessor.LogicalProcessor(i3, LogicalProcessorInformation.getMatchingCore(arrayList2, s2, i3), LogicalProcessorInformation.getMatchingPackage(arrayList, s2, i3), n2, s2);
                arrayList4.add(logicalProcessor);
            }
        }
        return arrayList4;
    }

    private static int getMatchingPackage(List<WinNT.GROUP_AFFINITY[]> list, int n2, int n3) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            for (int i3 = 0; i3 < list.get(i2).length; ++i3) {
                if ((list.get((int)i2)[i3].mask.longValue() & 1L << n3) == 0L || list.get((int)i2)[i3].group != n2) continue;
                return i2;
            }
        }
        return 0;
    }

    private static int getMatchingCore(List<WinNT.GROUP_AFFINITY> list, int n2, int n3) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if ((list.get((int)i2).mask.longValue() & 1L << n3) == 0L || list.get((int)i2).group != n2) continue;
            return i2;
        }
        return 0;
    }

    public static List<CentralProcessor.LogicalProcessor> getLogicalProcessorInformation() {
        ArrayList<Long> arrayList = new ArrayList<Long>();
        ArrayList<Long> arrayList2 = new ArrayList<Long>();
        WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION[] sYSTEM_LOGICAL_PROCESSOR_INFORMATIONArray = Kernel32Util.getLogicalProcessorInformation();
        for (WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION sYSTEM_LOGICAL_PROCESSOR_INFORMATION : sYSTEM_LOGICAL_PROCESSOR_INFORMATIONArray) {
            if (sYSTEM_LOGICAL_PROCESSOR_INFORMATION.relationship == 3) {
                arrayList.add(sYSTEM_LOGICAL_PROCESSOR_INFORMATION.processorMask.longValue());
                continue;
            }
            if (sYSTEM_LOGICAL_PROCESSOR_INFORMATION.relationship != 0) continue;
            arrayList2.add(sYSTEM_LOGICAL_PROCESSOR_INFORMATION.processorMask.longValue());
        }
        arrayList2.sort(null);
        arrayList.sort(null);
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < arrayList2.size(); ++i2) {
            long l2 = (Long)arrayList2.get(i2);
            int n2 = Long.numberOfTrailingZeros(l2);
            int n3 = 63 - Long.numberOfLeadingZeros(l2);
            for (int i3 = n2; i3 <= n3; ++i3) {
                if ((l2 & 1L << i3) == 0L) continue;
                CentralProcessor.LogicalProcessor logicalProcessor = new CentralProcessor.LogicalProcessor(i3, i2, LogicalProcessorInformation.getBitMatchingPackageNumber(arrayList, i3));
                arrayList3.add(logicalProcessor);
            }
        }
        return arrayList3;
    }

    private static int getBitMatchingPackageNumber(List<Long> list, int n2) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if ((list.get(i2) & 1L << n2) == 0L) continue;
            return i2;
        }
        return 0;
    }
}

