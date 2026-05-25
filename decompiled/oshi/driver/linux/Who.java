/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.linux;

import com.sun.jna.Native;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.linux.LinuxLibc;
import oshi.software.os.OSSession;
import oshi.util.ParseUtil;

@ThreadSafe
public final class Who {
    private static final LinuxLibc LIBC = LinuxLibc.INSTANCE;

    private Who() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static synchronized List<OSSession> queryUtxent() {
        ArrayList<OSSession> arrayList = new ArrayList<OSSession>();
        LIBC.setutxent();
        try {
            LinuxLibc.LinuxUtmpx linuxUtmpx;
            while ((linuxUtmpx = LIBC.getutxent()) != null) {
                if (linuxUtmpx.ut_type != 7 && linuxUtmpx.ut_type != 6) continue;
                String string = Native.toString(linuxUtmpx.ut_user, Charset.defaultCharset());
                String string2 = Native.toString(linuxUtmpx.ut_line, Charset.defaultCharset());
                String string3 = ParseUtil.parseUtAddrV6toIP(linuxUtmpx.ut_addr_v6);
                long l2 = (long)linuxUtmpx.ut_tv.tv_sec * 1000L + (long)linuxUtmpx.ut_tv.tv_usec / 1000L;
                if (string.isEmpty() || string2.isEmpty() || l2 < 0L || l2 > System.currentTimeMillis()) {
                    List<OSSession> list = oshi.driver.unix.Who.queryWho();
                    return list;
                }
                arrayList.add(new OSSession(string, string2, l2, string3));
            }
        }
        finally {
            LIBC.endutxent();
        }
        return arrayList;
    }
}

