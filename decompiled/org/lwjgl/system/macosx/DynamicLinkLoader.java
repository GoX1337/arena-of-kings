/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class DynamicLinkLoader {
    public static final int RTLD_LAZY = 1;
    public static final int RTLD_NOW = 2;
    public static final int RTLD_LOCAL = 4;
    public static final int RTLD_GLOBAL = 8;
    public static final long RTLD_NEXT = -1L;
    public static final long RTLD_DEFAULT = -2L;
    public static final long RTLD_SELF = -3L;
    public static final long RTLD_MAIN_ONLY = -5L;

    protected DynamicLinkLoader() {
        throw new UnsupportedOperationException();
    }

    public static native long ndlopen(long var0, int var2);

    @NativeType(value="void *")
    public static long dlopen(@Nullable @NativeType(value="char const *") ByteBuffer byteBuffer, int n2) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(byteBuffer);
        }
        return DynamicLinkLoader.ndlopen(MemoryUtil.memAddressSafe(byteBuffer), n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long dlopen(@Nullable @NativeType(value="char const *") CharSequence charSequence, int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8Safe(charSequence, true);
            long l2 = charSequence == null ? 0L : memoryStack.getPointerAddress();
            long l3 = DynamicLinkLoader.ndlopen(l2, n2);
            return l3;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native long ndlerror();

    @Nullable
    @NativeType(value="char const *")
    public static String dlerror() {
        long l2 = DynamicLinkLoader.ndlerror();
        return MemoryUtil.memASCIISafe(l2);
    }

    public static native long ndlsym(long var0, long var2);

    @NativeType(value="void *")
    public static long dlsym(@NativeType(value="void *") long l2, @NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkNT1(byteBuffer);
        }
        return DynamicLinkLoader.ndlsym(l2, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long dlsym(@NativeType(value="void *") long l2, @NativeType(value="char const *") CharSequence charSequence) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l3 = memoryStack.getPointerAddress();
            long l4 = DynamicLinkLoader.ndlsym(l2, l3);
            return l4;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native int ndlclose(long var0);

    public static int dlclose(@NativeType(value="void *") long l2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return DynamicLinkLoader.ndlclose(l2);
    }

    static {
        Library.initialize();
    }
}

