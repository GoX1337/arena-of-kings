/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.unix.aix;

import com.sun.jna.Native;
import com.sun.jna.platform.unix.aix.Perfstat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class SharedObjectLoader {
    private SharedObjectLoader() {
    }

    static Perfstat getPerfstatInstance() {
        Map<String, Object> map = SharedObjectLoader.getOptions();
        try {
            return Native.load("/usr/lib/libperfstat.a(shr_64.o)", Perfstat.class, map);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            return Native.load("/usr/lib/libperfstat.a(shr.o)", Perfstat.class, map);
        }
    }

    private static Map<String, Object> getOptions() {
        int n2 = 262144;
        int n3 = 65536;
        int n4 = 4;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("open-flags", n2 | n3 | n4);
        return Collections.unmodifiableMap(hashMap);
    }
}

