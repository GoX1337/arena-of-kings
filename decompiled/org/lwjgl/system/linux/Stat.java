/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class Stat {
    protected Stat() {
        throw new UnsupportedOperationException();
    }

    public static native int nstat(long var0, long var2);

    public static int stat(@NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="struct stat *") long l2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.check(l2);
        }
        return Stat.nstat(MemoryUtil.memAddress(byteBuffer), l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int stat(@NativeType(value="char const *") CharSequence charSequence, @NativeType(value="struct stat *") long l2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l3 = memoryStack.getPointerAddress();
            int n3 = Stat.nstat(l3, l2);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native int nfstat(int var0, long var1);

    public static int fstat(int n2, @NativeType(value="struct stat *") long l2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return Stat.nfstat(n2, l2);
    }

    static {
        Library.initialize();
    }
}

