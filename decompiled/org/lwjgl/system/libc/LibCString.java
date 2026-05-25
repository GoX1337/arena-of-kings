/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.libc;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class LibCString {
    protected LibCString() {
        throw new UnsupportedOperationException();
    }

    public static native long nmemset(long var0, int var2, long var3);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") ByteBuffer byteBuffer, int n2) {
        return LibCString.nmemset(MemoryUtil.memAddress(byteBuffer), n2, (long)byteBuffer.remaining());
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") ShortBuffer shortBuffer, int n2) {
        return LibCString.nmemset(MemoryUtil.memAddress(shortBuffer), n2, Integer.toUnsignedLong(shortBuffer.remaining()) << 1);
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") IntBuffer intBuffer, int n2) {
        return LibCString.nmemset(MemoryUtil.memAddress(intBuffer), n2, Integer.toUnsignedLong(intBuffer.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") LongBuffer longBuffer, int n2) {
        return LibCString.nmemset(MemoryUtil.memAddress(longBuffer), n2, Integer.toUnsignedLong(longBuffer.remaining()) << 3);
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") FloatBuffer floatBuffer, int n2) {
        return LibCString.nmemset(MemoryUtil.memAddress(floatBuffer), n2, Integer.toUnsignedLong(floatBuffer.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") DoubleBuffer doubleBuffer, int n2) {
        return LibCString.nmemset(MemoryUtil.memAddress(doubleBuffer), n2, Integer.toUnsignedLong(doubleBuffer.remaining()) << 3);
    }

    public static native long nmemcpy(long var0, long var2, long var4);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") ByteBuffer byteBuffer, @NativeType(value="void const *") ByteBuffer byteBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, byteBuffer2.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), (long)byteBuffer2.remaining());
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") ShortBuffer shortBuffer, @NativeType(value="void const *") ShortBuffer shortBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)shortBuffer, shortBuffer2.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(shortBuffer), MemoryUtil.memAddress(shortBuffer2), Integer.toUnsignedLong(shortBuffer2.remaining()) << 1);
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") IntBuffer intBuffer, @NativeType(value="void const *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, intBuffer2.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2), Integer.toUnsignedLong(intBuffer2.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") LongBuffer longBuffer, @NativeType(value="void const *") LongBuffer longBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, longBuffer2.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(longBuffer), MemoryUtil.memAddress(longBuffer2), Integer.toUnsignedLong(longBuffer2.remaining()) << 3);
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") FloatBuffer floatBuffer, @NativeType(value="void const *") FloatBuffer floatBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, floatBuffer2.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(floatBuffer), MemoryUtil.memAddress(floatBuffer2), Integer.toUnsignedLong(floatBuffer2.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") DoubleBuffer doubleBuffer, @NativeType(value="void const *") DoubleBuffer doubleBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, doubleBuffer2.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(doubleBuffer), MemoryUtil.memAddress(doubleBuffer2), Integer.toUnsignedLong(doubleBuffer2.remaining()) << 3);
    }

    public static native long nmemmove(long var0, long var2, long var4);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") ByteBuffer byteBuffer, @NativeType(value="void const *") ByteBuffer byteBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, byteBuffer2.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), (long)byteBuffer2.remaining());
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") ShortBuffer shortBuffer, @NativeType(value="void const *") ShortBuffer shortBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)shortBuffer, shortBuffer2.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(shortBuffer), MemoryUtil.memAddress(shortBuffer2), Integer.toUnsignedLong(shortBuffer2.remaining()) << 1);
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") IntBuffer intBuffer, @NativeType(value="void const *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, intBuffer2.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2), Integer.toUnsignedLong(intBuffer2.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") LongBuffer longBuffer, @NativeType(value="void const *") LongBuffer longBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, longBuffer2.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(longBuffer), MemoryUtil.memAddress(longBuffer2), Integer.toUnsignedLong(longBuffer2.remaining()) << 3);
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") FloatBuffer floatBuffer, @NativeType(value="void const *") FloatBuffer floatBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, floatBuffer2.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(floatBuffer), MemoryUtil.memAddress(floatBuffer2), Integer.toUnsignedLong(floatBuffer2.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") DoubleBuffer doubleBuffer, @NativeType(value="void const *") DoubleBuffer doubleBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, doubleBuffer2.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(doubleBuffer), MemoryUtil.memAddress(doubleBuffer2), Integer.toUnsignedLong(doubleBuffer2.remaining()) << 3);
    }

    public static native long nstrerror(int var0);

    @Nullable
    @NativeType(value="char *")
    public static String strerror(int n2) {
        long l2 = LibCString.nstrerror(n2);
        return MemoryUtil.memASCIISafe(l2);
    }

    public static native long nmemset(byte[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") byte[] byArray, int n2) {
        return LibCString.nmemset(byArray, n2, Integer.toUnsignedLong(byArray.length) << 0);
    }

    public static native long nmemset(short[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") short[] sArray, int n2) {
        return LibCString.nmemset(sArray, n2, Integer.toUnsignedLong(sArray.length) << 1);
    }

    public static native long nmemset(int[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") int[] nArray, int n2) {
        return LibCString.nmemset(nArray, n2, Integer.toUnsignedLong(nArray.length) << 2);
    }

    public static native long nmemset(long[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") long[] lArray, int n2) {
        return LibCString.nmemset(lArray, n2, Integer.toUnsignedLong(lArray.length) << 3);
    }

    public static native long nmemset(float[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") float[] fArray, int n2) {
        return LibCString.nmemset(fArray, n2, Integer.toUnsignedLong(fArray.length) << 2);
    }

    public static native long nmemset(double[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") double[] dArray, int n2) {
        return LibCString.nmemset(dArray, n2, Integer.toUnsignedLong(dArray.length) << 3);
    }

    public static native long nmemcpy(byte[] var0, byte[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") byte[] byArray, @NativeType(value="void const *") byte[] byArray2) {
        if (Checks.CHECKS) {
            Checks.check(byArray, byArray2.length);
        }
        return LibCString.nmemcpy(byArray, byArray2, Integer.toUnsignedLong(byArray2.length) << 0);
    }

    public static native long nmemcpy(short[] var0, short[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") short[] sArray, @NativeType(value="void const *") short[] sArray2) {
        if (Checks.CHECKS) {
            Checks.check(sArray, sArray2.length);
        }
        return LibCString.nmemcpy(sArray, sArray2, Integer.toUnsignedLong(sArray2.length) << 1);
    }

    public static native long nmemcpy(int[] var0, int[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") int[] nArray, @NativeType(value="void const *") int[] nArray2) {
        if (Checks.CHECKS) {
            Checks.check(nArray, nArray2.length);
        }
        return LibCString.nmemcpy(nArray, nArray2, Integer.toUnsignedLong(nArray2.length) << 2);
    }

    public static native long nmemcpy(long[] var0, long[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") long[] lArray, @NativeType(value="void const *") long[] lArray2) {
        if (Checks.CHECKS) {
            Checks.check(lArray, lArray2.length);
        }
        return LibCString.nmemcpy(lArray, lArray2, Integer.toUnsignedLong(lArray2.length) << 3);
    }

    public static native long nmemcpy(float[] var0, float[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") float[] fArray, @NativeType(value="void const *") float[] fArray2) {
        if (Checks.CHECKS) {
            Checks.check(fArray, fArray2.length);
        }
        return LibCString.nmemcpy(fArray, fArray2, Integer.toUnsignedLong(fArray2.length) << 2);
    }

    public static native long nmemcpy(double[] var0, double[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") double[] dArray, @NativeType(value="void const *") double[] dArray2) {
        if (Checks.CHECKS) {
            Checks.check(dArray, dArray2.length);
        }
        return LibCString.nmemcpy(dArray, dArray2, Integer.toUnsignedLong(dArray2.length) << 3);
    }

    public static native long nmemmove(byte[] var0, byte[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") byte[] byArray, @NativeType(value="void const *") byte[] byArray2) {
        if (Checks.CHECKS) {
            Checks.check(byArray, byArray2.length);
        }
        return LibCString.nmemmove(byArray, byArray2, Integer.toUnsignedLong(byArray2.length) << 0);
    }

    public static native long nmemmove(short[] var0, short[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") short[] sArray, @NativeType(value="void const *") short[] sArray2) {
        if (Checks.CHECKS) {
            Checks.check(sArray, sArray2.length);
        }
        return LibCString.nmemmove(sArray, sArray2, Integer.toUnsignedLong(sArray2.length) << 1);
    }

    public static native long nmemmove(int[] var0, int[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") int[] nArray, @NativeType(value="void const *") int[] nArray2) {
        if (Checks.CHECKS) {
            Checks.check(nArray, nArray2.length);
        }
        return LibCString.nmemmove(nArray, nArray2, Integer.toUnsignedLong(nArray2.length) << 2);
    }

    public static native long nmemmove(long[] var0, long[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") long[] lArray, @NativeType(value="void const *") long[] lArray2) {
        if (Checks.CHECKS) {
            Checks.check(lArray, lArray2.length);
        }
        return LibCString.nmemmove(lArray, lArray2, Integer.toUnsignedLong(lArray2.length) << 3);
    }

    public static native long nmemmove(float[] var0, float[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") float[] fArray, @NativeType(value="void const *") float[] fArray2) {
        if (Checks.CHECKS) {
            Checks.check(fArray, fArray2.length);
        }
        return LibCString.nmemmove(fArray, fArray2, Integer.toUnsignedLong(fArray2.length) << 2);
    }

    public static native long nmemmove(double[] var0, double[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") double[] dArray, @NativeType(value="void const *") double[] dArray2) {
        if (Checks.CHECKS) {
            Checks.check(dArray, dArray2.length);
        }
        return LibCString.nmemmove(dArray, dArray2, Integer.toUnsignedLong(dArray2.length) << 3);
    }

    @NativeType(value="void *")
    public static <T extends CustomBuffer<T>> long memset(@NativeType(value="void *") T t2, @NativeType(value="int") int n2) {
        return LibCString.nmemset(MemoryUtil.memAddress(t2), n2, Integer.toUnsignedLong(t2.remaining()) * (long)t2.sizeof());
    }

    @NativeType(value="void *")
    public static <T extends CustomBuffer<T>> long memcpy(@NativeType(value="void *") T t2, @NativeType(value="void const *") T t3) {
        if (Checks.CHECKS) {
            Checks.check(t3, t2.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(t2), MemoryUtil.memAddress(t3), (long)t3.remaining() * (long)t3.sizeof());
    }

    @NativeType(value="void *")
    public static <T extends CustomBuffer<T>> long memmove(@NativeType(value="void *") T t2, @NativeType(value="void const *") T t3) {
        if (Checks.CHECKS) {
            Checks.check(t3, t2.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(t2), MemoryUtil.memAddress(t3), (long)t3.remaining() * (long)t3.sizeof());
    }

    static {
        Library.initialize();
    }
}

