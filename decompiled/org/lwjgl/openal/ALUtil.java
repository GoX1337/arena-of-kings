/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.lwjgl.openal.ALC10;
import org.lwjgl.system.MemoryUtil;

public final class ALUtil {
    private ALUtil() {
    }

    @Nullable
    public static List<String> getStringList(long l2, int n2) {
        long l3 = ALC10.nalcGetString(l2, n2);
        if (l3 == 0L) {
            return null;
        }
        ByteBuffer byteBuffer = MemoryUtil.memByteBuffer(l3, Integer.MAX_VALUE);
        ArrayList<String> arrayList = new ArrayList<String>();
        int n3 = 0;
        while (true) {
            if (byteBuffer.get() != 0) {
                continue;
            }
            int n4 = byteBuffer.position() - 1;
            if (n4 == n3) break;
            arrayList.add(MemoryUtil.memUTF8(byteBuffer, n4 - n3, n3));
            n3 = byteBuffer.position();
        }
        return arrayList;
    }
}

