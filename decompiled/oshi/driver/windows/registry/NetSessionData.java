/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.registry;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Netapi32;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.OSSession;

@ThreadSafe
public final class NetSessionData {
    private static final Netapi32 NET = Netapi32.INSTANCE;

    private NetSessionData() {
    }

    public static List<OSSession> queryUserSessions() {
        ArrayList<OSSession> arrayList = new ArrayList<OSSession>();
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        if (0 == NET.NetSessionEnum(null, null, null, 10, pointerByReference, -1, intByReference, intByReference2, null)) {
            Pointer pointer = pointerByReference.getValue();
            Netapi32.SESSION_INFO_10 sESSION_INFO_10 = new Netapi32.SESSION_INFO_10(pointer);
            if (intByReference.getValue() > 0) {
                Netapi32.SESSION_INFO_10[] sESSION_INFO_10Array;
                for (Netapi32.SESSION_INFO_10 sESSION_INFO_102 : sESSION_INFO_10Array = (Netapi32.SESSION_INFO_10[])sESSION_INFO_10.com_sun_jna_Structure_arr_toArray(intByReference.getValue())) {
                    long l2 = System.currentTimeMillis() - 1000L * (long)sESSION_INFO_102.sesi10_time;
                    arrayList.add(new OSSession(sESSION_INFO_102.sesi10_username, "Network session", l2, sESSION_INFO_102.sesi10_cname));
                }
            }
            NET.NetApiBufferFree(pointer);
        }
        return arrayList;
    }
}

