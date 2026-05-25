/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WinBase {
    public static final int FALSE = 0;
    public static final int TRUE = 1;

    protected WinBase() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="DWORD")
    public static native int GetLastError();

    @NativeType(value="DWORD")
    public static native int getLastError();

    public static native long nGetModuleHandle(long var0);

    @NativeType(value="HMODULE")
    public static long GetModuleHandle(@Nullable @NativeType(value="LPCTSTR") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT2Safe(byteBuffer);
        }
        return WinBase.nGetModuleHandle(MemoryUtil.memAddressSafe(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="HMODULE")
    public static long GetModuleHandle(@Nullable @NativeType(value="LPCTSTR") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF16Safe(charSequence, true);
            long l2 = charSequence == null ? 0L : memoryStack.getPointerAddress();
            long l3 = WinBase.nGetModuleHandle(l2);
            return l3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native int nGetModuleFileName(long var0, long var2, int var4);

    @NativeType(value="DWORD")
    public static int GetModuleFileName(@NativeType(value="HMODULE") long l2, @NativeType(value="LPTSTR") ByteBuffer byteBuffer) {
        return WinBase.nGetModuleFileName(l2, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining() >> 1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="DWORD")
    public static String GetModuleFileName(@NativeType(value="HMODULE") long l2, @NativeType(value="DWORD") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            ByteBuffer byteBuffer = memoryStack.malloc(n2);
            int n4 = WinBase.nGetModuleFileName(l2, MemoryUtil.memAddress(byteBuffer), n2);
            String string = MemoryUtil.memUTF16(byteBuffer, n4);
            return string;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native long nLoadLibrary(long var0);

    @NativeType(value="HMODULE")
    public static long LoadLibrary(@NativeType(value="LPCTSTR") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT2(byteBuffer);
        }
        return WinBase.nLoadLibrary(MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="HMODULE")
    public static long LoadLibrary(@NativeType(value="LPCTSTR") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF16(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            long l3 = WinBase.nLoadLibrary(l2);
            return l3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native long nGetProcAddress(long var0, long var2);

    @NativeType(value="FARPROC")
    public static long GetProcAddress(@NativeType(value="HMODULE") long l2, @NativeType(value="LPCSTR") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkNT1(byteBuffer);
        }
        return WinBase.nGetProcAddress(l2, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="FARPROC")
    public static long GetProcAddress(@NativeType(value="HMODULE") long l2, @NativeType(value="LPCSTR") CharSequence charSequence) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l3 = memoryStack.getPointerAddress();
            long l4 = WinBase.nGetProcAddress(l2, l3);
            return l4;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native int nFreeLibrary(long var0);

    @NativeType(value="BOOL")
    public static boolean FreeLibrary(@NativeType(value="HMODULE") long l2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return WinBase.nFreeLibrary(l2) != 0;
    }

    static {
        Library.initialize();
    }
}

