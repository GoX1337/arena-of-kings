/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.solaris;

import com.sun.jna.Native;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.unix.SolarisLibc;
import oshi.software.os.OSSession;

@ThreadSafe
public final class Who {
    private static final SolarisLibc LIBC = SolarisLibc.INSTANCE;

    private Who() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static synchronized List<OSSession> queryUtxent() {
        ArrayList<OSSession> arrayList = new ArrayList<OSSession>();
        LIBC.setutxent();
        try {
            SolarisLibc.SolarisUtmpx solarisUtmpx;
            while ((solarisUtmpx = LIBC.getutxent()) != null) {
                String string;
                if (solarisUtmpx.ut_type != 7 && solarisUtmpx.ut_type != 6 || "LOGIN".equals(string = Native.toString(solarisUtmpx.ut_user, StandardCharsets.US_ASCII))) continue;
                String string2 = Native.toString(solarisUtmpx.ut_line, StandardCharsets.US_ASCII);
                String string3 = Native.toString(solarisUtmpx.ut_host, StandardCharsets.US_ASCII);
                long l2 = solarisUtmpx.ut_tv.tv_sec.longValue() * 1000L + solarisUtmpx.ut_tv.tv_usec.longValue() / 1000L;
                if (string.isEmpty() || string2.isEmpty() || l2 < 0L || l2 > System.currentTimeMillis()) {
                    List<OSSession> list = oshi.driver.unix.Who.queryWho();
                    return list;
                }
                arrayList.add(new OSSession(string, string2, l2, string3));
            }
            return arrayList;
        }
        finally {
            LIBC.endutxent();
        }
    }
}

