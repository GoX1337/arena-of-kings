/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.registry;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.VersionHelpers;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.Wtsapi32;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.OSSession;
import oshi.util.ParseUtil;

@ThreadSafe
public final class SessionWtsData {
    private static final int WTS_ACTIVE = 0;
    private static final int WTS_CLIENTADDRESS = 14;
    private static final int WTS_SESSIONINFO = 24;
    private static final int WTS_CLIENTPROTOCOLTYPE = 16;
    private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
    private static final Wtsapi32 WTS = Wtsapi32.INSTANCE;

    private SessionWtsData() {
    }

    public static List<OSSession> queryUserSessions() {
        IntByReference intByReference;
        PointerByReference pointerByReference;
        ArrayList<OSSession> arrayList = new ArrayList<OSSession>();
        if (IS_VISTA_OR_GREATER && WTS.WTSEnumerateSessions(Wtsapi32.WTS_CURRENT_SERVER_HANDLE, 0, 1, pointerByReference = new PointerByReference(), intByReference = new IntByReference())) {
            Pointer pointer = pointerByReference.getValue();
            if (intByReference.getValue() > 0) {
                Wtsapi32.WTS_SESSION_INFO[] wTS_SESSION_INFOArray;
                Wtsapi32.WTS_SESSION_INFO wTS_SESSION_INFO = new Wtsapi32.WTS_SESSION_INFO(pointer);
                for (Wtsapi32.WTS_SESSION_INFO wTS_SESSION_INFO2 : wTS_SESSION_INFOArray = (Wtsapi32.WTS_SESSION_INFO[])wTS_SESSION_INFO.com_sun_jna_Structure_arr_toArray(intByReference.getValue())) {
                    if (wTS_SESSION_INFO2.State != 0) continue;
                    PointerByReference pointerByReference2 = new PointerByReference();
                    IntByReference intByReference2 = new IntByReference();
                    WTS.WTSQuerySessionInformation(Wtsapi32.WTS_CURRENT_SERVER_HANDLE, wTS_SESSION_INFO2.SessionId, 16, pointerByReference2, intByReference2);
                    Pointer pointer2 = pointerByReference2.getValue();
                    short s2 = pointer2.getShort(0L);
                    WTS.WTSFreeMemory(pointer2);
                    if (s2 <= 0) continue;
                    String string = wTS_SESSION_INFO2.pWinStationName;
                    WTS.WTSQuerySessionInformation(Wtsapi32.WTS_CURRENT_SERVER_HANDLE, wTS_SESSION_INFO2.SessionId, 24, pointerByReference2, intByReference2);
                    pointer2 = pointerByReference2.getValue();
                    Wtsapi32.WTSINFO wTSINFO = new Wtsapi32.WTSINFO(pointer2);
                    long l2 = new WinBase.FILETIME(new WinNT.LARGE_INTEGER(wTSINFO.LogonTime.getValue())).toTime();
                    String string2 = wTSINFO.getUserName();
                    WTS.WTSFreeMemory(pointer2);
                    WTS.WTSQuerySessionInformation(Wtsapi32.WTS_CURRENT_SERVER_HANDLE, wTS_SESSION_INFO2.SessionId, 14, pointerByReference2, intByReference2);
                    pointer2 = pointerByReference2.getValue();
                    Wtsapi32.WTS_CLIENT_ADDRESS wTS_CLIENT_ADDRESS = new Wtsapi32.WTS_CLIENT_ADDRESS(pointer2);
                    WTS.WTSFreeMemory(pointer2);
                    String string3 = "::";
                    if (wTS_CLIENT_ADDRESS.AddressFamily == 2) {
                        try {
                            string3 = InetAddress.getByAddress(Arrays.copyOfRange(wTS_CLIENT_ADDRESS.Address, 2, 6)).getHostAddress();
                        }
                        catch (UnknownHostException unknownHostException) {
                            string3 = "Illegal length IP Array";
                        }
                    } else if (wTS_CLIENT_ADDRESS.AddressFamily == 23) {
                        int[] nArray = SessionWtsData.convertBytesToInts(wTS_CLIENT_ADDRESS.Address);
                        string3 = ParseUtil.parseUtAddrV6toIP(nArray);
                    }
                    arrayList.add(new OSSession(string2, string, l2, string3));
                }
            }
            WTS.WTSFreeMemory(pointer);
        }
        return arrayList;
    }

    private static int[] convertBytesToInts(byte[] byArray) {
        IntBuffer intBuffer = ByteBuffer.wrap(Arrays.copyOfRange(byArray, 2, 18)).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
        int[] nArray = new int[intBuffer.remaining()];
        intBuffer.get(nArray);
        return nArray;
    }
}

