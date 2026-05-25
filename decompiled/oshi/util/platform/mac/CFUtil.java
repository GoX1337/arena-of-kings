/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.platform.mac;

import com.sun.jna.Pointer;
import com.sun.jna.platform.mac.CoreFoundation;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class CFUtil {
    private CFUtil() {
    }

    public static String cfPointerToString(Pointer pointer) {
        return CFUtil.cfPointerToString(pointer, true);
    }

    public static String cfPointerToString(Pointer pointer, boolean bl2) {
        String string = "";
        if (pointer != null) {
            CoreFoundation.CFStringRef cFStringRef = new CoreFoundation.CFStringRef(pointer);
            string = cFStringRef.stringValue();
        }
        if (bl2 && string.isEmpty()) {
            return "unknown";
        }
        return string;
    }
}

