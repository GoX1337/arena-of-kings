/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.freebsd;

import com.sun.jna.Native;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.unix.FreeBsdLibc;
import oshi.software.os.OSSession;

@ThreadSafe
public final class Who {
    private static final FreeBsdLibc LIBC = FreeBsdLibc.INSTANCE;

    private Who() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static synchronized List<OSSession> queryUtxent() {
        ArrayList<OSSession> arrayList = new ArrayList<OSSession>();
        LIBC.setutxent();
        try {
            FreeBsdLibc.FreeBsdUtmpx freeBsdUtmpx;
            while ((freeBsdUtmpx = LIBC.getutxent()) != null) {
                if (freeBsdUtmpx.ut_type != 7 && freeBsdUtmpx.ut_type != 6) continue;
                String string = Native.toString(freeBsdUtmpx.ut_user, StandardCharsets.US_ASCII);
                String string2 = Native.toString(freeBsdUtmpx.ut_line, StandardCharsets.US_ASCII);
                String string3 = Native.toString(freeBsdUtmpx.ut_host, StandardCharsets.US_ASCII);
                long l2 = freeBsdUtmpx.ut_tv.tv_sec * 1000L + freeBsdUtmpx.ut_tv.tv_usec / 1000L;
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

