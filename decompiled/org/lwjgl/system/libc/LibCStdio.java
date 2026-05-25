/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.libc;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class LibCStdio {
    public static final long sscanf;
    public static final long sprintf;
    public static final long snprintf;

    protected LibCStdio() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="void *")
    private static native long sscanf();

    public static native int nvsscanf(long var0, long var2, long var4);

    public static int vsscanf(@NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer2, @NativeType(value="va_list") long l2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
            Checks.check(l2);
        }
        return LibCStdio.nvsscanf(MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int vsscanf(@NativeType(value="char const *") CharSequence charSequence, @NativeType(value="char const *") CharSequence charSequence2, @NativeType(value="va_list") long l2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l3 = memoryStack.getPointerAddress();
            memoryStack.nASCII(charSequence2, true);
            long l4 = memoryStack.getPointerAddress();
            int n3 = LibCStdio.nvsscanf(l3, l4, l2);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    @NativeType(value="void *")
    private static native long sprintf();

    @NativeType(value="void *")
    private static native long snprintf();

    public static native int nvsnprintf(long var0, long var2, long var4, long var6);

    public static int vsnprintf(@Nullable @NativeType(value="char *") ByteBuffer byteBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer2, @NativeType(value="va_list") long l2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer2);
            Checks.check(l2);
        }
        return LibCStdio.nvsnprintf(MemoryUtil.memAddressSafe(byteBuffer), Checks.remainingSafe(byteBuffer), MemoryUtil.memAddress(byteBuffer2), l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int vsnprintf(@Nullable @NativeType(value="char *") ByteBuffer byteBuffer, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="va_list") long l2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l3 = memoryStack.getPointerAddress();
            int n3 = LibCStdio.nvsnprintf(MemoryUtil.memAddressSafe(byteBuffer), Checks.remainingSafe(byteBuffer), l3, l2);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    static {
        Library.initialize();
        sscanf = LibCStdio.sscanf();
        sprintf = LibCStdio.sprintf();
        snprintf = LibCStdio.snprintf();
    }
}

