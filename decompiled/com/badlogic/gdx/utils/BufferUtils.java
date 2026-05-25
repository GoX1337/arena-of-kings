/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public final class BufferUtils {
    static Array<ByteBuffer> unsafeBuffers = new Array();
    static int allocatedUnsafe = 0;

    private BufferUtils() {
    }

    public static void copy(float[] fArray, Buffer buffer, int n2, int n3) {
        if (buffer instanceof ByteBuffer) {
            buffer.limit(n2 << 2);
        } else if (buffer instanceof FloatBuffer) {
            buffer.limit(n2);
        }
        BufferUtils.copyJni(fArray, buffer, n2, n3);
        buffer.position(0);
    }

    public static void copy(byte[] byArray, int n2, Buffer buffer, int n3) {
        buffer.limit(buffer.position() + BufferUtils.bytesToElements(buffer, n3));
        BufferUtils.copyJni(byArray, n2, buffer, BufferUtils.positionInBytes(buffer), n3);
    }

    public static void copy(short[] sArray, int n2, Buffer buffer, int n3) {
        buffer.limit(buffer.position() + BufferUtils.bytesToElements(buffer, n3 << 1));
        BufferUtils.copyJni(sArray, n2, buffer, BufferUtils.positionInBytes(buffer), n3 << 1);
    }

    public static void copy(char[] cArray, int n2, int n3, Buffer buffer) {
        BufferUtils.copyJni(cArray, n2, buffer, BufferUtils.positionInBytes(buffer), n3 << 1);
    }

    public static void copy(int[] nArray, int n2, int n3, Buffer buffer) {
        BufferUtils.copyJni(nArray, n2, buffer, BufferUtils.positionInBytes(buffer), n3 << 2);
    }

    public static void copy(long[] lArray, int n2, int n3, Buffer buffer) {
        BufferUtils.copyJni(lArray, n2, buffer, BufferUtils.positionInBytes(buffer), n3 << 3);
    }

    public static void copy(float[] fArray, int n2, int n3, Buffer buffer) {
        BufferUtils.copyJni(fArray, n2, buffer, BufferUtils.positionInBytes(buffer), n3 << 2);
    }

    public static void copy(double[] dArray, int n2, int n3, Buffer buffer) {
        BufferUtils.copyJni(dArray, n2, buffer, BufferUtils.positionInBytes(buffer), n3 << 3);
    }

    public static void copy(char[] cArray, int n2, Buffer buffer, int n3) {
        buffer.limit(buffer.position() + BufferUtils.bytesToElements(buffer, n3 << 1));
        BufferUtils.copyJni(cArray, n2, buffer, BufferUtils.positionInBytes(buffer), n3 << 1);
    }

    public static void copy(int[] nArray, int n2, Buffer buffer, int n3) {
        buffer.limit(buffer.position() + BufferUtils.bytesToElements(buffer, n3 << 2));
        BufferUtils.copyJni(nArray, n2, buffer, BufferUtils.positionInBytes(buffer), n3 << 2);
    }

    public static void copy(long[] lArray, int n2, Buffer buffer, int n3) {
        buffer.limit(buffer.position() + BufferUtils.bytesToElements(buffer, n3 << 3));
        BufferUtils.copyJni(lArray, n2, buffer, BufferUtils.positionInBytes(buffer), n3 << 3);
    }

    public static void copy(float[] fArray, int n2, Buffer buffer, int n3) {
        buffer.limit(buffer.position() + BufferUtils.bytesToElements(buffer, n3 << 2));
        BufferUtils.copyJni(fArray, n2, buffer, BufferUtils.positionInBytes(buffer), n3 << 2);
    }

    public static void copy(double[] dArray, int n2, Buffer buffer, int n3) {
        buffer.limit(buffer.position() + BufferUtils.bytesToElements(buffer, n3 << 3));
        BufferUtils.copyJni(dArray, n2, buffer, BufferUtils.positionInBytes(buffer), n3 << 3);
    }

    public static void copy(Buffer buffer, Buffer buffer2, int n2) {
        int n3 = BufferUtils.elementsToBytes(buffer, n2);
        buffer2.limit(buffer2.position() + BufferUtils.bytesToElements(buffer2, n3));
        BufferUtils.copyJni(buffer, BufferUtils.positionInBytes(buffer), buffer2, BufferUtils.positionInBytes(buffer2), n3);
    }

    public static void transform(Buffer buffer, int n2, int n3, int n4, Matrix4 matrix4) {
        BufferUtils.transform(buffer, n2, n3, n4, matrix4, 0);
    }

    public static void transform(float[] fArray, int n2, int n3, int n4, Matrix4 matrix4) {
        BufferUtils.transform(fArray, n2, n3, n4, matrix4, 0);
    }

    public static void transform(Buffer buffer, int n2, int n3, int n4, Matrix4 matrix4, int n5) {
        switch (n2) {
            case 4: {
                BufferUtils.transformV4M4Jni(buffer, n3, n4, matrix4.val, BufferUtils.positionInBytes(buffer) + n5);
                break;
            }
            case 3: {
                BufferUtils.transformV3M4Jni(buffer, n3, n4, matrix4.val, BufferUtils.positionInBytes(buffer) + n5);
                break;
            }
            case 2: {
                BufferUtils.transformV2M4Jni(buffer, n3, n4, matrix4.val, BufferUtils.positionInBytes(buffer) + n5);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void transform(float[] fArray, int n2, int n3, int n4, Matrix4 matrix4, int n5) {
        switch (n2) {
            case 4: {
                BufferUtils.transformV4M4Jni(fArray, n3, n4, matrix4.val, n5);
                break;
            }
            case 3: {
                BufferUtils.transformV3M4Jni(fArray, n3, n4, matrix4.val, n5);
                break;
            }
            case 2: {
                BufferUtils.transformV2M4Jni(fArray, n3, n4, matrix4.val, n5);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void transform(Buffer buffer, int n2, int n3, int n4, Matrix3 matrix3) {
        BufferUtils.transform(buffer, n2, n3, n4, matrix3, 0);
    }

    public static void transform(float[] fArray, int n2, int n3, int n4, Matrix3 matrix3) {
        BufferUtils.transform(fArray, n2, n3, n4, matrix3, 0);
    }

    public static void transform(Buffer buffer, int n2, int n3, int n4, Matrix3 matrix3, int n5) {
        switch (n2) {
            case 3: {
                BufferUtils.transformV3M3Jni(buffer, n3, n4, matrix3.val, BufferUtils.positionInBytes(buffer) + n5);
                break;
            }
            case 2: {
                BufferUtils.transformV2M3Jni(buffer, n3, n4, matrix3.val, BufferUtils.positionInBytes(buffer) + n5);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void transform(float[] fArray, int n2, int n3, int n4, Matrix3 matrix3, int n5) {
        switch (n2) {
            case 3: {
                BufferUtils.transformV3M3Jni(fArray, n3, n4, matrix3.val, n5);
                break;
            }
            case 2: {
                BufferUtils.transformV2M3Jni(fArray, n3, n4, matrix3.val, n5);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public static long findFloats(Buffer buffer, int n2, Buffer buffer2, int n3) {
        return BufferUtils.find(buffer, BufferUtils.positionInBytes(buffer), n2, buffer2, BufferUtils.positionInBytes(buffer2), n3);
    }

    public static long findFloats(float[] fArray, int n2, Buffer buffer, int n3) {
        return BufferUtils.find(fArray, 0, n2, buffer, BufferUtils.positionInBytes(buffer), n3);
    }

    public static long findFloats(Buffer buffer, int n2, float[] fArray, int n3) {
        return BufferUtils.find(buffer, BufferUtils.positionInBytes(buffer), n2, fArray, 0, n3);
    }

    public static long findFloats(float[] fArray, int n2, float[] fArray2, int n3) {
        return BufferUtils.find(fArray, 0, n2, fArray2, 0, n3);
    }

    public static long findFloats(Buffer buffer, int n2, Buffer buffer2, int n3, float f2) {
        return BufferUtils.find(buffer, BufferUtils.positionInBytes(buffer), n2, buffer2, BufferUtils.positionInBytes(buffer2), n3, f2);
    }

    public static long findFloats(float[] fArray, int n2, Buffer buffer, int n3, float f2) {
        return BufferUtils.find(fArray, 0, n2, buffer, BufferUtils.positionInBytes(buffer), n3, f2);
    }

    public static long findFloats(Buffer buffer, int n2, float[] fArray, int n3, float f2) {
        return BufferUtils.find(buffer, BufferUtils.positionInBytes(buffer), n2, fArray, 0, n3, f2);
    }

    public static long findFloats(float[] fArray, int n2, float[] fArray2, int n3, float f2) {
        return BufferUtils.find(fArray, 0, n2, fArray2, 0, n3, f2);
    }

    private static int positionInBytes(Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            return buffer.position();
        }
        if (buffer instanceof ShortBuffer) {
            return buffer.position() << 1;
        }
        if (buffer instanceof CharBuffer) {
            return buffer.position() << 1;
        }
        if (buffer instanceof IntBuffer) {
            return buffer.position() << 2;
        }
        if (buffer instanceof LongBuffer) {
            return buffer.position() << 3;
        }
        if (buffer instanceof FloatBuffer) {
            return buffer.position() << 2;
        }
        if (buffer instanceof DoubleBuffer) {
            return buffer.position() << 3;
        }
        throw new GdxRuntimeException("Can't copy to a " + buffer.getClass().getName() + " instance");
    }

    private static int bytesToElements(Buffer buffer, int n2) {
        if (buffer instanceof ByteBuffer) {
            return n2;
        }
        if (buffer instanceof ShortBuffer) {
            return n2 >>> 1;
        }
        if (buffer instanceof CharBuffer) {
            return n2 >>> 1;
        }
        if (buffer instanceof IntBuffer) {
            return n2 >>> 2;
        }
        if (buffer instanceof LongBuffer) {
            return n2 >>> 3;
        }
        if (buffer instanceof FloatBuffer) {
            return n2 >>> 2;
        }
        if (buffer instanceof DoubleBuffer) {
            return n2 >>> 3;
        }
        throw new GdxRuntimeException("Can't copy to a " + buffer.getClass().getName() + " instance");
    }

    private static int elementsToBytes(Buffer buffer, int n2) {
        if (buffer instanceof ByteBuffer) {
            return n2;
        }
        if (buffer instanceof ShortBuffer) {
            return n2 << 1;
        }
        if (buffer instanceof CharBuffer) {
            return n2 << 1;
        }
        if (buffer instanceof IntBuffer) {
            return n2 << 2;
        }
        if (buffer instanceof LongBuffer) {
            return n2 << 3;
        }
        if (buffer instanceof FloatBuffer) {
            return n2 << 2;
        }
        if (buffer instanceof DoubleBuffer) {
            return n2 << 3;
        }
        throw new GdxRuntimeException("Can't copy to a " + buffer.getClass().getName() + " instance");
    }

    public static FloatBuffer newFloatBuffer(int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n2 * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer.asFloatBuffer();
    }

    public static DoubleBuffer newDoubleBuffer(int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n2 * 8);
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer.asDoubleBuffer();
    }

    public static ByteBuffer newByteBuffer(int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n2);
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    public static ShortBuffer newShortBuffer(int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n2 * 2);
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer.asShortBuffer();
    }

    public static CharBuffer newCharBuffer(int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n2 * 2);
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer.asCharBuffer();
    }

    public static IntBuffer newIntBuffer(int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n2 * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer.asIntBuffer();
    }

    public static LongBuffer newLongBuffer(int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n2 * 8);
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer.asLongBuffer();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void disposeUnsafeByteBuffer(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.capacity();
        Array<ByteBuffer> array = unsafeBuffers;
        synchronized (array) {
            if (!unsafeBuffers.removeValue(byteBuffer, true)) {
                throw new IllegalArgumentException("buffer not allocated with newUnsafeByteBuffer or already disposed");
            }
        }
        allocatedUnsafe -= n2;
        BufferUtils.freeMemory(byteBuffer);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean isUnsafeByteBuffer(ByteBuffer byteBuffer) {
        Array<ByteBuffer> array = unsafeBuffers;
        synchronized (array) {
            return unsafeBuffers.contains(byteBuffer, true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ByteBuffer newUnsafeByteBuffer(int n2) {
        ByteBuffer byteBuffer = BufferUtils.newDisposableByteBuffer(n2);
        byteBuffer.order(ByteOrder.nativeOrder());
        allocatedUnsafe += n2;
        Array<ByteBuffer> array = unsafeBuffers;
        synchronized (array) {
            unsafeBuffers.add(byteBuffer);
        }
        return byteBuffer;
    }

    public static long getUnsafeBufferAddress(Buffer buffer) {
        return BufferUtils.getBufferAddress(buffer) + (long)buffer.position();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ByteBuffer newUnsafeByteBuffer(ByteBuffer byteBuffer) {
        allocatedUnsafe += byteBuffer.capacity();
        Array<ByteBuffer> array = unsafeBuffers;
        synchronized (array) {
            unsafeBuffers.add(byteBuffer);
        }
        return byteBuffer;
    }

    public static int getAllocatedBytesUnsafe() {
        return allocatedUnsafe;
    }

    private static native void freeMemory(ByteBuffer var0);

    private static native ByteBuffer newDisposableByteBuffer(int var0);

    private static native long getBufferAddress(Buffer var0);

    public static native void clear(ByteBuffer var0, int var1);

    private static native void copyJni(float[] var0, Buffer var1, int var2, int var3);

    private static native void copyJni(byte[] var0, int var1, Buffer var2, int var3, int var4);

    private static native void copyJni(char[] var0, int var1, Buffer var2, int var3, int var4);

    private static native void copyJni(short[] var0, int var1, Buffer var2, int var3, int var4);

    private static native void copyJni(int[] var0, int var1, Buffer var2, int var3, int var4);

    private static native void copyJni(long[] var0, int var1, Buffer var2, int var3, int var4);

    private static native void copyJni(float[] var0, int var1, Buffer var2, int var3, int var4);

    private static native void copyJni(double[] var0, int var1, Buffer var2, int var3, int var4);

    private static native void copyJni(Buffer var0, int var1, Buffer var2, int var3, int var4);

    private static native void transformV4M4Jni(Buffer var0, int var1, int var2, float[] var3, int var4);

    private static native void transformV4M4Jni(float[] var0, int var1, int var2, float[] var3, int var4);

    private static native void transformV3M4Jni(Buffer var0, int var1, int var2, float[] var3, int var4);

    private static native void transformV3M4Jni(float[] var0, int var1, int var2, float[] var3, int var4);

    private static native void transformV2M4Jni(Buffer var0, int var1, int var2, float[] var3, int var4);

    private static native void transformV2M4Jni(float[] var0, int var1, int var2, float[] var3, int var4);

    private static native void transformV3M3Jni(Buffer var0, int var1, int var2, float[] var3, int var4);

    private static native void transformV3M3Jni(float[] var0, int var1, int var2, float[] var3, int var4);

    private static native void transformV2M3Jni(Buffer var0, int var1, int var2, float[] var3, int var4);

    private static native void transformV2M3Jni(float[] var0, int var1, int var2, float[] var3, int var4);

    private static native long find(Buffer var0, int var1, int var2, Buffer var3, int var4, int var5);

    private static native long find(float[] var0, int var1, int var2, Buffer var3, int var4, int var5);

    private static native long find(Buffer var0, int var1, int var2, float[] var3, int var4, int var5);

    private static native long find(float[] var0, int var1, int var2, float[] var3, int var4, int var5);

    private static native long find(Buffer var0, int var1, int var2, Buffer var3, int var4, int var5, float var6);

    private static native long find(float[] var0, int var1, int var2, Buffer var3, int var4, int var5, float var6);

    private static native long find(Buffer var0, int var1, int var2, float[] var3, int var4, int var5, float var6);

    private static native long find(float[] var0, int var1, int var2, float[] var3, int var4, int var5, float var6);
}

