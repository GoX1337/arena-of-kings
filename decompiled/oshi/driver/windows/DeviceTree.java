/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows;

import com.sun.jna.Memory;
import com.sun.jna.platform.win32.Cfgmgr32;
import com.sun.jna.platform.win32.Cfgmgr32Util;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.SetupApi;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.tuples.Quintet;

@ThreadSafe
public final class DeviceTree {
    private static final int MAX_PATH = 260;
    private static final SetupApi SA = SetupApi.INSTANCE;
    private static final Cfgmgr32 C32 = Cfgmgr32.INSTANCE;

    private DeviceTree() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Quintet<Set<Integer>, Map<Integer, Integer>, Map<Integer, String>, Map<Integer, String>, Map<Integer, String>> queryDeviceTree(Guid.GUID gUID) {
        Object object;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        HashMap<Integer, String> hashMap2 = new HashMap<Integer, String>();
        HashMap<Integer, String> hashMap3 = new HashMap<Integer, String>();
        HashMap<Integer, String> hashMap4 = new HashMap<Integer, String>();
        WinNT.HANDLE hANDLE = SA.SetupDiGetClassDevs(gUID, null, null, 18);
        if (!WinBase.INVALID_HANDLE_VALUE.equals(hANDLE)) {
            try {
                object = new Memory(260L);
                IntByReference intByReference = new IntByReference(260);
                ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
                SetupApi.SP_DEVINFO_DATA sP_DEVINFO_DATA = new SetupApi.SP_DEVINFO_DATA();
                sP_DEVINFO_DATA.cbSize = sP_DEVINFO_DATA.size();
                int n3 = 0;
                while (SA.SetupDiEnumDeviceInfo(hANDLE, n3, sP_DEVINFO_DATA)) {
                    arrayDeque.add(sP_DEVINFO_DATA.DevInst);
                    int n4 = 0;
                    IntByReference intByReference2 = new IntByReference();
                    IntByReference intByReference3 = new IntByReference();
                    while (!arrayDeque.isEmpty()) {
                        n4 = (Integer)arrayDeque.poll();
                        String string = Cfgmgr32Util.CM_Get_Device_ID(n4);
                        hashMap3.put(n4, string);
                        String string2 = DeviceTree.getDevNodeProperty(n4, 13, (Memory)object, intByReference);
                        if (string2.isEmpty()) {
                            string2 = DeviceTree.getDevNodeProperty(n4, 1, (Memory)object, intByReference);
                        }
                        if (string2.isEmpty()) {
                            string2 = DeviceTree.getDevNodeProperty(n4, 8, (Memory)object, intByReference);
                            String string3 = DeviceTree.getDevNodeProperty(n4, 5, (Memory)object, intByReference);
                            if (!string3.isEmpty()) {
                                string2 = string2 + " (" + string3 + ")";
                            }
                        }
                        hashMap2.put(n4, string2);
                        hashMap4.put(n4, DeviceTree.getDevNodeProperty(n4, 12, (Memory)object, intByReference));
                        if (0 != C32.CM_Get_Child(intByReference2, n4, 0)) continue;
                        hashMap.put(intByReference2.getValue(), n4);
                        arrayDeque.add(intByReference2.getValue());
                        while (0 == C32.CM_Get_Sibling(intByReference3, intByReference2.getValue(), 0)) {
                            hashMap.put(intByReference3.getValue(), n4);
                            arrayDeque.add(intByReference3.getValue());
                            intByReference2.setValue(intByReference3.getValue());
                        }
                    }
                    ++n3;
                }
            }
            finally {
                SA.SetupDiDestroyDeviceInfoList(hANDLE);
            }
        }
        object = hashMap3.keySet().stream().filter(n2 -> !hashMap.containsKey(n2)).collect(Collectors.toSet());
        return new Quintet(object, hashMap, hashMap2, hashMap3, hashMap4);
    }

    private static String getDevNodeProperty(int n2, int n3, Memory memory, IntByReference intByReference) {
        memory.clear();
        intByReference.setValue((int)memory.size());
        C32.CM_Get_DevNode_Registry_Property(n2, n3, null, memory, intByReference, 0);
        return memory.getWideString(0L);
    }
}

