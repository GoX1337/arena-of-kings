/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.libc.LibCString;

final class MultiReleaseMemCopy {
    private MultiReleaseMemCopy() {
    }

    static void copy(long l2, long l3, long l4) {
        if (l4 < 384L) {
            int n2 = (int)l2;
            int n3 = (int)l3;
            if (Pointer.BITS64) {
                if ((n2 & 7) == 0 && (n3 & 7) == 0) {
                    MemoryUtil.memCopyAligned64(l2, l3, (int)l4 & 0x1FF);
                    return;
                }
            } else if ((n2 & 3) == 0 && (n3 & 3) == 0) {
                MemoryUtil.memCopyAligned32(n2, n3, (int)l4 & 0x1FF);
                return;
            }
            MemoryUtil.UNSAFE.copyMemory(null, l2, null, l3, l4);
            return;
        }
        LibCString.nmemcpy(l3, l2, l4);
    }
}

