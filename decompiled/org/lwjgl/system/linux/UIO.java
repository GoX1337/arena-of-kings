/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import org.lwjgl.system.Library;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.linux.IOVec;

public class UIO {
    public static final int UIO_FASTIOV = 8;
    public static final int UIO_MAXIOV = 1024;
    public static final int RWF_HIPRI = 1;
    public static final int RWF_DSYNC = 2;
    public static final int RWF_SYNC = 4;
    public static final int RWF_NOWAIT = 8;
    public static final int RWF_APPEND = 16;

    protected UIO() {
        throw new UnsupportedOperationException();
    }

    public static native long nreadv(int var0, long var1, int var3);

    @NativeType(value="ssize_t")
    public static long readv(int n2, @NativeType(value="struct iovec const *") IOVec iOVec, int n3) {
        return UIO.nreadv(n2, iOVec.address(), n3);
    }

    public static native long nwritev(int var0, long var1, int var3);

    @NativeType(value="ssize_t")
    public static long writev(int n2, @NativeType(value="struct iovec const *") IOVec iOVec, int n3) {
        return UIO.nwritev(n2, iOVec.address(), n3);
    }

    public static native long npreadv(int var0, long var1, int var3, long var4);

    @NativeType(value="ssize_t")
    public static long preadv(int n2, @NativeType(value="struct iovec const *") IOVec iOVec, int n3, @NativeType(value="off_t") long l2) {
        return UIO.npreadv(n2, iOVec.address(), n3, l2);
    }

    public static native long npwritev(int var0, long var1, int var3, long var4);

    @NativeType(value="ssize_t")
    public static long pwritev(int n2, @NativeType(value="struct iovec const *") IOVec iOVec, int n3, @NativeType(value="off_t") long l2) {
        return UIO.npwritev(n2, iOVec.address(), n3, l2);
    }

    public static native long npreadv2(int var0, long var1, int var3, long var4, int var6);

    @NativeType(value="ssize_t")
    public static long preadv2(int n2, @NativeType(value="struct iovec const *") IOVec iOVec, int n3, @NativeType(value="off_t") long l2, int n4) {
        return UIO.npreadv2(n2, iOVec.address(), n3, l2, n4);
    }

    public static native long npwritev2(int var0, long var1, int var3, long var4, int var6);

    @NativeType(value="ssize_t")
    public static long pwritev2(int n2, @NativeType(value="struct iovec const *") IOVec iOVec, int n3, @NativeType(value="off_t") long l2, int n4) {
        return UIO.npwritev2(n2, iOVec.address(), n3, l2, n4);
    }

    public static native long nprocess_vm_readv(int var0, long var1, long var3, long var5, long var7, long var9);

    @NativeType(value="ssize_t")
    public static long process_vm_readv(@NativeType(value="pid_t") int n2, @NativeType(value="struct iovec const *") IOVec iOVec, @NativeType(value="unsigned long int") long l2, @NativeType(value="struct iovec const *") IOVec iOVec2, @NativeType(value="unsigned long int") long l3, @NativeType(value="unsigned long int") long l4) {
        return UIO.nprocess_vm_readv(n2, iOVec.address(), l2, iOVec2.address(), l3, l4);
    }

    public static native long nprocess_vm_writev(int var0, long var1, long var3, long var5, long var7, long var9);

    @NativeType(value="ssize_t")
    public static long process_vm_writev(@NativeType(value="pid_t") int n2, @NativeType(value="struct iovec const *") IOVec iOVec, @NativeType(value="unsigned long int") long l2, @NativeType(value="struct iovec const *") IOVec iOVec2, @NativeType(value="unsigned long int") long l3, @NativeType(value="unsigned long int") long l4) {
        return UIO.nprocess_vm_writev(n2, iOVec.address(), l2, iOVec2.address(), l3, l4);
    }

    static {
        Library.initialize();
    }
}

