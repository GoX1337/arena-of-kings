/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.mac.disk;

import com.sun.jna.Native;
import com.sun.jna.platform.mac.SystemB;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class Fsstat {
    private Fsstat() {
    }

    public static int queryFsstat(SystemB.Statfs[] statfsArray, int n2, int n3) {
        return SystemB.INSTANCE.getfsstat64(statfsArray, n2, n3);
    }

    public static SystemB.Statfs[] getFileSystems(int n2) {
        SystemB.Statfs[] statfsArray = new SystemB.Statfs[n2];
        Fsstat.queryFsstat(statfsArray, n2 * new SystemB.Statfs().size(), 16);
        return statfsArray;
    }

    public static Map<String, String> queryPartitionToMountMap() {
        SystemB.Statfs[] statfsArray;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        int n2 = Fsstat.queryFsstat(null, 0, 0);
        for (SystemB.Statfs statfs : statfsArray = Fsstat.getFileSystems(n2)) {
            String string = Native.toString(statfs.f_mntfromname, StandardCharsets.UTF_8);
            hashMap.put(string.replace("/dev/", ""), Native.toString(statfs.f_mntonname, StandardCharsets.UTF_8));
        }
        return hashMap;
    }
}

