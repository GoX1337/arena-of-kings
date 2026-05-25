/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.mac;

import com.sun.jna.Native;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.mac.SystemB;
import oshi.software.os.OSSession;

@ThreadSafe
public final class Who {
    private static final SystemB SYS = SystemB.INSTANCE;

    private Who() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static synchronized List<OSSession> queryUtxent() {
        ArrayList<OSSession> arrayList = new ArrayList<OSSession>();
        SYS.setutxent();
        try {
            SystemB.MacUtmpx macUtmpx;
            while ((macUtmpx = SYS.getutxent()) != null) {
                if (macUtmpx.ut_type != 7 && macUtmpx.ut_type != 6) continue;
                String string = Native.toString(macUtmpx.ut_user, StandardCharsets.US_ASCII);
                String string2 = Native.toString(macUtmpx.ut_line, StandardCharsets.US_ASCII);
                String string3 = Native.toString(macUtmpx.ut_host, StandardCharsets.US_ASCII);
                long l2 = macUtmpx.ut_tv.tv_sec.longValue() * 1000L + (long)macUtmpx.ut_tv.tv_usec / 1000L;
                if (string.isEmpty() || string2.isEmpty() || l2 < 0L || l2 > System.currentTimeMillis()) {
                    List<OSSession> list = oshi.driver.unix.Who.queryWho();
                    return list;
                }
                arrayList.add(new OSSession(string, string2, l2, string3));
            }
        }
        finally {
            SYS.endutxent();
        }
        return arrayList;
    }
}

