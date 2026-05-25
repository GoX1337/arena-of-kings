/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.nio.charset.StandardCharsets;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;

final class MultiReleaseTextDecoding {
    private MultiReleaseTextDecoding() {
    }

    static String decodeUTF8(long l2, int n2) {
        if (n2 <= 0) {
            return "";
        }
        if (Checks.DEBUG) {
            byte[] byArray = n2 <= MemoryUtil.ARRAY_TLC_SIZE ? MemoryUtil.ARRAY_TLC_BYTE.get() : new byte[n2];
            MemoryUtil.memByteBuffer(l2, n2).get(byArray, 0, n2);
            return new String(byArray, 0, n2, StandardCharsets.UTF_8);
        }
        char[] cArray = n2 <= MemoryUtil.ARRAY_TLC_SIZE ? MemoryUtil.ARRAY_TLC_CHAR.get() : new char[n2];
        int n3 = 0;
        int n4 = 0;
        while (n4 < n2) {
            char c2;
            int n5;
            if ((n5 = MemoryUtil.UNSAFE.getByte(null, l2 + (long)n4++) & 0xFF) < 128) {
                c2 = (char)n5;
            } else {
                int n6 = MemoryUtil.UNSAFE.getByte(null, l2 + (long)n4++) & 0x3F;
                if ((n5 & 0xE0) == 192) {
                    c2 = (char)((n5 & 0x1F) << 6 | n6);
                } else {
                    int n7 = MemoryUtil.UNSAFE.getByte(null, l2 + (long)n4++) & 0x3F;
                    if ((n5 & 0xF0) == 224) {
                        c2 = (char)((n5 & 0xF) << 12 | n6 << 6 | n7);
                    } else {
                        int n8 = MemoryUtil.UNSAFE.getByte(null, l2 + (long)n4++) & 0x3F;
                        int n9 = (n5 & 7) << 18 | n6 << 12 | n7 << 6 | n8;
                        if (n3 < n2) {
                            cArray[n3++] = (char)((n9 >>> 10) + 55232);
                        }
                        c2 = (char)((n9 & 0x3FF) + 56320);
                    }
                }
            }
            if (n3 >= n2) continue;
            cArray[n3++] = c2;
        }
        return new String(cArray, 0, Math.min(n3, n2));
    }
}

