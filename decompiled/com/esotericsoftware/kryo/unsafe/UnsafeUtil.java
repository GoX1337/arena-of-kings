/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.unsafe;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.minlog.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

public class UnsafeUtil {
    public static final Unsafe unsafe;
    public static final long byteArrayBaseOffset;
    public static final long floatArrayBaseOffset;
    public static final long doubleArrayBaseOffset;
    public static final long intArrayBaseOffset;
    public static final long longArrayBaseOffset;
    public static final long shortArrayBaseOffset;
    public static final long charArrayBaseOffset;
    public static final long booleanArrayBaseOffset;
    private static Constructor<? extends ByteBuffer> directByteBufferConstructor;
    private static Method cleanerMethod;
    private static Method cleanMethod;

    public static ByteBuffer newDirectBuffer(long l2, int n2) {
        if (directByteBufferConstructor == null) {
            throw new UnsupportedOperationException("No direct ByteBuffer constructor is available.");
        }
        try {
            return directByteBufferConstructor.newInstance(l2, n2);
        }
        catch (Exception exception) {
            throw new KryoException("Error creating a ByteBuffer at address: " + l2, exception);
        }
    }

    public static boolean isNewDirectBufferAvailable() {
        return directByteBufferConstructor != null;
    }

    public static void dispose(ByteBuffer byteBuffer) {
        if (!(byteBuffer instanceof DirectBuffer)) {
            return;
        }
        if (cleanerMethod != null) {
            try {
                cleanMethod.invoke(cleanerMethod.invoke((Object)byteBuffer, new Object[0]), new Object[0]);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    static {
        long l2;
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        long l8;
        long l9;
        Object object;
        block11: {
            object = null;
            l9 = 0L;
            l8 = 0L;
            l7 = 0L;
            l6 = 0L;
            l5 = 0L;
            l4 = 0L;
            l3 = 0L;
            l2 = 0L;
            try {
                if (!Util.isAndroid) {
                    Field field = Unsafe.class.getDeclaredField("theUnsafe");
                    field.setAccessible(true);
                    object = (Unsafe)field.get(null);
                    l9 = ((Unsafe)object).arrayBaseOffset(byte[].class);
                    l3 = ((Unsafe)object).arrayBaseOffset(char[].class);
                    l4 = ((Unsafe)object).arrayBaseOffset(short[].class);
                    l6 = ((Unsafe)object).arrayBaseOffset(int[].class);
                    l8 = ((Unsafe)object).arrayBaseOffset(float[].class);
                    l5 = ((Unsafe)object).arrayBaseOffset(long[].class);
                    l7 = ((Unsafe)object).arrayBaseOffset(double[].class);
                    l2 = ((Unsafe)object).arrayBaseOffset(boolean[].class);
                } else if (Log.DEBUG) {
                    Log.debug("kryo", "Unsafe is not available on Android.");
                }
            }
            catch (Exception exception) {
                if (!Log.DEBUG) break block11;
                Log.debug("kryo", "Unsafe is not available.", exception);
            }
        }
        byteArrayBaseOffset = l9;
        charArrayBaseOffset = l3;
        shortArrayBaseOffset = l4;
        intArrayBaseOffset = l6;
        floatArrayBaseOffset = l8;
        longArrayBaseOffset = l5;
        doubleArrayBaseOffset = l7;
        booleanArrayBaseOffset = l2;
        unsafe = object;
        object = ByteBuffer.allocateDirect(1);
        try {
            directByteBufferConstructor = object.getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE);
            directByteBufferConstructor.setAccessible(true);
        }
        catch (Exception exception) {
            if (Log.DEBUG) {
                Log.debug("kryo", "No direct ByteBuffer constructor is available.", exception);
            }
            directByteBufferConstructor = null;
        }
        try {
            cleanerMethod = DirectBuffer.class.getMethod("cleaner", new Class[0]);
            cleanerMethod.setAccessible(true);
            cleanMethod = cleanerMethod.getReturnType().getMethod("clean", new Class[0]);
        }
        catch (Exception exception) {
            if (Log.DEBUG) {
                Log.debug("kryo", "No direct ByteBuffer clean method is available.", exception);
            }
            cleanerMethod = null;
        }
    }
}

