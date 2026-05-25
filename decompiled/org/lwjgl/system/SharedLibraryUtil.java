/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryUtil;

public final class SharedLibraryUtil {
    private static native int getLibraryPath(long var0, long var2, int var4);

    @Nullable
    public static String getLibraryPath(long l2) {
        int n2 = 256;
        ByteBuffer byteBuffer = MemoryUtil.memAlloc(n2);
        try {
            while (true) {
                int n3;
                if ((n3 = SharedLibraryUtil.getLibraryPath(l2, MemoryUtil.memAddress(byteBuffer), n2)) == 0) {
                    String string = null;
                    return string;
                }
                if (n3 < n2) {
                    String string = MemoryUtil.memUTF8(byteBuffer, n3 - 1);
                    return string;
                }
                n2 = n2 * 3 / 2;
                byteBuffer = MemoryUtil.memRealloc(byteBuffer, n2);
            }
        }
        finally {
            MemoryUtil.memFree(byteBuffer);
        }
    }
}

