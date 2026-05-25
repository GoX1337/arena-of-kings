/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.function.LongPredicate;
import javax.annotation.Nullable;
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.Library;
import org.lwjgl.system.MathUtil;
import org.lwjgl.system.MemoryManage;
import org.lwjgl.system.MultiReleaseMemCopy;
import org.lwjgl.system.MultiReleaseTextDecoding;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.Struct;
import org.lwjgl.system.jni.JNINativeInterface;
import org.lwjgl.system.libc.LibCString;
import sun.misc.Unsafe;

public final class MemoryUtil {
    public static final long NULL = 0L;
    public static final int PAGE_SIZE;
    public static final int CACHE_LINE_SIZE;
    static final int ARRAY_TLC_SIZE;
    static final ThreadLocal<byte[]> ARRAY_TLC_BYTE;
    static final ThreadLocal<char[]> ARRAY_TLC_CHAR;
    static final Unsafe UNSAFE;
    static final ByteOrder NATIVE_ORDER;
    private static final Charset UTF16;
    static final Class<? extends ByteBuffer> BUFFER_BYTE;
    static final Class<? extends ShortBuffer> BUFFER_SHORT;
    static final Class<? extends CharBuffer> BUFFER_CHAR;
    static final Class<? extends IntBuffer> BUFFER_INT;
    static final Class<? extends LongBuffer> BUFFER_LONG;
    static final Class<? extends FloatBuffer> BUFFER_FLOAT;
    static final Class<? extends DoubleBuffer> BUFFER_DOUBLE;
    private static final long MARK;
    private static final long POSITION;
    private static final long LIMIT;
    private static final long CAPACITY;
    private static final long ADDRESS;
    private static final long PARENT_BYTE;
    private static final long PARENT_SHORT;
    private static final long PARENT_CHAR;
    private static final long PARENT_INT;
    private static final long PARENT_LONG;
    private static final long PARENT_FLOAT;
    private static final long PARENT_DOUBLE;
    private static final NativeShift SHIFT;
    private static final int FILL_PATTERN_32;
    private static final long FILL_PATTERN_64;
    private static final int MAGIC_CAPACITY = 219540062;
    private static final int MAGIC_POSITION = 16435934;

    private MemoryUtil() {
    }

    public static MemoryAllocator getAllocator() {
        return MemoryUtil.getAllocator(false);
    }

    public static MemoryAllocator getAllocator(boolean bl2) {
        return bl2 ? LazyInit.ALLOCATOR : LazyInit.ALLOCATOR_IMPL;
    }

    public static long nmemAlloc(long l2) {
        return LazyInit.ALLOCATOR.malloc(l2);
    }

    public static long nmemAllocChecked(long l2) {
        long l3 = MemoryUtil.nmemAlloc(l2 != 0L ? l2 : 1L);
        if (Checks.CHECKS && l3 == 0L) {
            throw new OutOfMemoryError();
        }
        return l3;
    }

    private static long getAllocationSize(int n2, int n3) {
        return APIUtil.apiCheckAllocation(n2, Integer.toUnsignedLong(n2) << n3, Pointer.BITS64 ? Long.MAX_VALUE : 0xFFFFFFFFL);
    }

    public static ByteBuffer memAlloc(int n2) {
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.nmemAllocChecked(n2), n2).order(NATIVE_ORDER);
    }

    public static ShortBuffer memAllocShort(int n2) {
        return MemoryUtil.wrap(BUFFER_SHORT, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n2, 1)), n2);
    }

    public static IntBuffer memAllocInt(int n2) {
        return MemoryUtil.wrap(BUFFER_INT, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n2, 2)), n2);
    }

    public static FloatBuffer memAllocFloat(int n2) {
        return MemoryUtil.wrap(BUFFER_FLOAT, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n2, 2)), n2);
    }

    public static LongBuffer memAllocLong(int n2) {
        return MemoryUtil.wrap(BUFFER_LONG, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n2, 3)), n2);
    }

    public static CLongBuffer memAllocCLong(int n2) {
        return Pointer.Default.wrap(CLongBuffer.class, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n2, Pointer.CLONG_SHIFT)), n2);
    }

    public static DoubleBuffer memAllocDouble(int n2) {
        return MemoryUtil.wrap(BUFFER_DOUBLE, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n2, 3)), n2);
    }

    public static PointerBuffer memAllocPointer(int n2) {
        return Pointer.Default.wrap(PointerBuffer.class, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n2, Pointer.POINTER_SHIFT)), n2);
    }

    public static void nmemFree(long l2) {
        LazyInit.ALLOCATOR.free(l2);
    }

    public static void memFree(@Nullable Buffer buffer) {
        if (buffer != null) {
            MemoryUtil.nmemFree(UNSAFE.getLong(buffer, ADDRESS));
        }
    }

    public static void memFree(@Nullable CustomBuffer<?> customBuffer) {
        if (customBuffer != null) {
            MemoryUtil.nmemFree(customBuffer.address);
        }
    }

    public static long nmemCalloc(long l2, long l3) {
        return LazyInit.ALLOCATOR.calloc(l2, l3);
    }

    public static long nmemCallocChecked(long l2, long l3) {
        if (l2 == 0L || l3 == 0L) {
            l2 = 1L;
            l3 = 1L;
        }
        long l4 = MemoryUtil.nmemCalloc(l2, l3);
        if (Checks.CHECKS && l4 == 0L) {
            throw new OutOfMemoryError();
        }
        return l4;
    }

    public static ByteBuffer memCalloc(int n2, int n3) {
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.nmemCallocChecked(n2, n3), n2 * n3).order(NATIVE_ORDER);
    }

    public static ByteBuffer memCalloc(int n2) {
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.nmemCallocChecked(n2, 1L), n2).order(NATIVE_ORDER);
    }

    public static ShortBuffer memCallocShort(int n2) {
        return MemoryUtil.wrap(BUFFER_SHORT, MemoryUtil.nmemCallocChecked(n2, 2L), n2);
    }

    public static IntBuffer memCallocInt(int n2) {
        return MemoryUtil.wrap(BUFFER_INT, MemoryUtil.nmemCallocChecked(n2, 4L), n2);
    }

    public static FloatBuffer memCallocFloat(int n2) {
        return MemoryUtil.wrap(BUFFER_FLOAT, MemoryUtil.nmemCallocChecked(n2, 4L), n2);
    }

    public static LongBuffer memCallocLong(int n2) {
        return MemoryUtil.wrap(BUFFER_LONG, MemoryUtil.nmemCallocChecked(n2, 8L), n2);
    }

    public static CLongBuffer memCallocCLong(int n2) {
        return Pointer.Default.wrap(CLongBuffer.class, MemoryUtil.nmemCallocChecked(n2, Pointer.CLONG_SIZE), n2);
    }

    public static DoubleBuffer memCallocDouble(int n2) {
        return MemoryUtil.wrap(BUFFER_DOUBLE, MemoryUtil.nmemCallocChecked(n2, 8L), n2);
    }

    public static PointerBuffer memCallocPointer(int n2) {
        return Pointer.Default.wrap(PointerBuffer.class, MemoryUtil.nmemCallocChecked(n2, Pointer.POINTER_SIZE), n2);
    }

    public static long nmemRealloc(long l2, long l3) {
        return LazyInit.ALLOCATOR.realloc(l2, l3);
    }

    public static long nmemReallocChecked(long l2, long l3) {
        long l4 = MemoryUtil.nmemRealloc(l2, l3 != 0L ? l3 : 1L);
        if (Checks.CHECKS && l4 == 0L) {
            throw new OutOfMemoryError();
        }
        return l4;
    }

    private static <T extends Buffer> T realloc(@Nullable T t2, T t3, int n2) {
        if (t2 != null) {
            t3.position(Math.min(t2.position(), n2));
        }
        return t3;
    }

    public static ByteBuffer memRealloc(@Nullable ByteBuffer byteBuffer, int n2) {
        return MemoryUtil.realloc(byteBuffer, MemoryUtil.memByteBuffer(MemoryUtil.nmemReallocChecked(byteBuffer == null ? 0L : UNSAFE.getLong(byteBuffer, ADDRESS), n2), n2), n2);
    }

    public static ShortBuffer memRealloc(@Nullable ShortBuffer shortBuffer, int n2) {
        return MemoryUtil.realloc(shortBuffer, MemoryUtil.memShortBuffer(MemoryUtil.nmemReallocChecked(shortBuffer == null ? 0L : UNSAFE.getLong(shortBuffer, ADDRESS), MemoryUtil.getAllocationSize(n2, 1)), n2), n2);
    }

    public static IntBuffer memRealloc(@Nullable IntBuffer intBuffer, int n2) {
        return MemoryUtil.realloc(intBuffer, MemoryUtil.memIntBuffer(MemoryUtil.nmemReallocChecked(intBuffer == null ? 0L : UNSAFE.getLong(intBuffer, ADDRESS), MemoryUtil.getAllocationSize(n2, 2)), n2), n2);
    }

    public static LongBuffer memRealloc(@Nullable LongBuffer longBuffer, int n2) {
        return MemoryUtil.realloc(longBuffer, MemoryUtil.memLongBuffer(MemoryUtil.nmemReallocChecked(longBuffer == null ? 0L : UNSAFE.getLong(longBuffer, ADDRESS), MemoryUtil.getAllocationSize(n2, 3)), n2), n2);
    }

    public static CLongBuffer memRealloc(@Nullable CLongBuffer cLongBuffer, int n2) {
        CLongBuffer cLongBuffer2 = MemoryUtil.memCLongBuffer(MemoryUtil.nmemReallocChecked(cLongBuffer == null ? 0L : cLongBuffer.address, MemoryUtil.getAllocationSize(n2, Pointer.CLONG_SIZE)), n2);
        if (cLongBuffer != null) {
            cLongBuffer2.position(Math.min(cLongBuffer.position(), n2));
        }
        return cLongBuffer2;
    }

    public static FloatBuffer memRealloc(@Nullable FloatBuffer floatBuffer, int n2) {
        return MemoryUtil.realloc(floatBuffer, MemoryUtil.memFloatBuffer(MemoryUtil.nmemReallocChecked(floatBuffer == null ? 0L : UNSAFE.getLong(floatBuffer, ADDRESS), MemoryUtil.getAllocationSize(n2, 2)), n2), n2);
    }

    public static DoubleBuffer memRealloc(@Nullable DoubleBuffer doubleBuffer, int n2) {
        return MemoryUtil.realloc(doubleBuffer, MemoryUtil.memDoubleBuffer(MemoryUtil.nmemReallocChecked(doubleBuffer == null ? 0L : UNSAFE.getLong(doubleBuffer, ADDRESS), MemoryUtil.getAllocationSize(n2, 3)), n2), n2);
    }

    public static PointerBuffer memRealloc(@Nullable PointerBuffer pointerBuffer, int n2) {
        PointerBuffer pointerBuffer2 = MemoryUtil.memPointerBuffer(MemoryUtil.nmemReallocChecked(pointerBuffer == null ? 0L : pointerBuffer.address, MemoryUtil.getAllocationSize(n2, Pointer.POINTER_SHIFT)), n2);
        if (pointerBuffer != null) {
            pointerBuffer2.position(Math.min(pointerBuffer.position(), n2));
        }
        return pointerBuffer2;
    }

    public static long nmemAlignedAlloc(long l2, long l3) {
        return LazyInit.ALLOCATOR.aligned_alloc(l2, l3);
    }

    public static long nmemAlignedAllocChecked(long l2, long l3) {
        long l4 = MemoryUtil.nmemAlignedAlloc(l2, l3 != 0L ? l3 : 1L);
        if (Checks.CHECKS && l4 == 0L) {
            throw new OutOfMemoryError();
        }
        return l4;
    }

    public static ByteBuffer memAlignedAlloc(int n2, int n3) {
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.nmemAlignedAllocChecked(n2, n3), n3).order(NATIVE_ORDER);
    }

    public static void nmemAlignedFree(long l2) {
        LazyInit.ALLOCATOR.aligned_free(l2);
    }

    public static void memAlignedFree(@Nullable ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            MemoryUtil.nmemAlignedFree(UNSAFE.getLong(byteBuffer, ADDRESS));
        }
    }

    public static void memReport(MemoryAllocationReport memoryAllocationReport) {
        MemoryManage.DebugAllocator.report(memoryAllocationReport);
    }

    public static void memReport(MemoryAllocationReport memoryAllocationReport, MemoryAllocationReport.Aggregate aggregate, boolean bl2) {
        MemoryManage.DebugAllocator.report(memoryAllocationReport, aggregate, bl2);
    }

    public static long memAddress0(Buffer buffer) {
        return UNSAFE.getLong(buffer, ADDRESS);
    }

    public static long memAddress(ByteBuffer byteBuffer) {
        return (long)byteBuffer.position() + MemoryUtil.memAddress0(byteBuffer);
    }

    public static long memAddress(ByteBuffer byteBuffer, int n2) {
        Objects.requireNonNull(byteBuffer);
        return MemoryUtil.memAddress0(byteBuffer) + Integer.toUnsignedLong(n2);
    }

    private static long address(int n2, int n3, long l2) {
        return l2 + (((long)n2 & 0xFFFFFFFFL) << n3);
    }

    public static long memAddress(ShortBuffer shortBuffer) {
        return MemoryUtil.address(shortBuffer.position(), 1, MemoryUtil.memAddress0(shortBuffer));
    }

    public static long memAddress(ShortBuffer shortBuffer, int n2) {
        Objects.requireNonNull(shortBuffer);
        return MemoryUtil.address(n2, 1, MemoryUtil.memAddress0(shortBuffer));
    }

    public static long memAddress(CharBuffer charBuffer) {
        return MemoryUtil.address(charBuffer.position(), 1, MemoryUtil.memAddress0(charBuffer));
    }

    public static long memAddress(CharBuffer charBuffer, int n2) {
        Objects.requireNonNull(charBuffer);
        return MemoryUtil.address(n2, 1, MemoryUtil.memAddress0(charBuffer));
    }

    public static long memAddress(IntBuffer intBuffer) {
        return MemoryUtil.address(intBuffer.position(), 2, MemoryUtil.memAddress0(intBuffer));
    }

    public static long memAddress(IntBuffer intBuffer, int n2) {
        Objects.requireNonNull(intBuffer);
        return MemoryUtil.address(n2, 2, MemoryUtil.memAddress0(intBuffer));
    }

    public static long memAddress(FloatBuffer floatBuffer) {
        return MemoryUtil.address(floatBuffer.position(), 2, MemoryUtil.memAddress0(floatBuffer));
    }

    public static long memAddress(FloatBuffer floatBuffer, int n2) {
        Objects.requireNonNull(floatBuffer);
        return MemoryUtil.address(n2, 2, MemoryUtil.memAddress0(floatBuffer));
    }

    public static long memAddress(LongBuffer longBuffer) {
        return MemoryUtil.address(longBuffer.position(), 3, MemoryUtil.memAddress0(longBuffer));
    }

    public static long memAddress(LongBuffer longBuffer, int n2) {
        Objects.requireNonNull(longBuffer);
        return MemoryUtil.address(n2, 3, MemoryUtil.memAddress0(longBuffer));
    }

    public static long memAddress(DoubleBuffer doubleBuffer) {
        return MemoryUtil.address(doubleBuffer.position(), 3, MemoryUtil.memAddress0(doubleBuffer));
    }

    public static long memAddress(DoubleBuffer doubleBuffer, int n2) {
        Objects.requireNonNull(doubleBuffer);
        return MemoryUtil.address(n2, 3, MemoryUtil.memAddress0(doubleBuffer));
    }

    public static long memAddress(Buffer buffer) {
        int n2 = buffer instanceof ByteBuffer ? 0 : (buffer instanceof ShortBuffer || buffer instanceof CharBuffer ? 1 : (buffer instanceof IntBuffer || buffer instanceof FloatBuffer ? 2 : 3));
        return MemoryUtil.address(buffer.position(), n2, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(CustomBuffer<?> customBuffer) {
        return customBuffer.address();
    }

    public static long memAddress(CustomBuffer<?> customBuffer, int n2) {
        return customBuffer.address(n2);
    }

    public static long memAddressSafe(@Nullable ByteBuffer byteBuffer) {
        return byteBuffer == null ? 0L : MemoryUtil.memAddress0(byteBuffer) + (long)byteBuffer.position();
    }

    public static long memAddressSafe(@Nullable ShortBuffer shortBuffer) {
        return shortBuffer == null ? 0L : MemoryUtil.address(shortBuffer.position(), 1, MemoryUtil.memAddress0(shortBuffer));
    }

    public static long memAddressSafe(@Nullable CharBuffer charBuffer) {
        return charBuffer == null ? 0L : MemoryUtil.address(charBuffer.position(), 1, MemoryUtil.memAddress0(charBuffer));
    }

    public static long memAddressSafe(@Nullable IntBuffer intBuffer) {
        return intBuffer == null ? 0L : MemoryUtil.address(intBuffer.position(), 2, MemoryUtil.memAddress0(intBuffer));
    }

    public static long memAddressSafe(@Nullable FloatBuffer floatBuffer) {
        return floatBuffer == null ? 0L : MemoryUtil.address(floatBuffer.position(), 2, MemoryUtil.memAddress0(floatBuffer));
    }

    public static long memAddressSafe(@Nullable LongBuffer longBuffer) {
        return longBuffer == null ? 0L : MemoryUtil.address(longBuffer.position(), 3, MemoryUtil.memAddress0(longBuffer));
    }

    public static long memAddressSafe(@Nullable DoubleBuffer doubleBuffer) {
        return doubleBuffer == null ? 0L : MemoryUtil.address(doubleBuffer.position(), 3, MemoryUtil.memAddress0(doubleBuffer));
    }

    public static long memAddressSafe(@Nullable Pointer pointer) {
        return pointer == null ? 0L : pointer.address();
    }

    public static ByteBuffer memByteBuffer(long l2, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return MemoryUtil.wrap(BUFFER_BYTE, l2, n2).order(NATIVE_ORDER);
    }

    @Nullable
    public static ByteBuffer memByteBufferSafe(long l2, int n2) {
        return l2 == 0L ? null : MemoryUtil.wrap(BUFFER_BYTE, l2, n2).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(ShortBuffer shortBuffer) {
        if (Checks.CHECKS && 0x3FFFFFFF < shortBuffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(shortBuffer), shortBuffer.remaining() << 1).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(CharBuffer charBuffer) {
        if (Checks.CHECKS && 0x3FFFFFFF < charBuffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(charBuffer), charBuffer.remaining() << 1).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(IntBuffer intBuffer) {
        if (Checks.CHECKS && 0x1FFFFFFF < intBuffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(intBuffer), intBuffer.remaining() << 2).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(LongBuffer longBuffer) {
        if (Checks.CHECKS && 0xFFFFFFF < longBuffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(longBuffer), longBuffer.remaining() << 3).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(FloatBuffer floatBuffer) {
        if (Checks.CHECKS && 0x1FFFFFFF < floatBuffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(floatBuffer), floatBuffer.remaining() << 2).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS && 0xFFFFFFF < doubleBuffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(doubleBuffer), doubleBuffer.remaining() << 3).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(CustomBuffer<?> customBuffer) {
        if (Checks.CHECKS && Integer.MAX_VALUE / customBuffer.sizeof() < customBuffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(customBuffer), customBuffer.remaining() * customBuffer.sizeof()).order(NATIVE_ORDER);
    }

    public static ShortBuffer memShortBuffer(long l2, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return MemoryUtil.wrap(BUFFER_SHORT, l2, n2);
    }

    @Nullable
    public static ShortBuffer memShortBufferSafe(long l2, int n2) {
        return l2 == 0L ? null : MemoryUtil.wrap(BUFFER_SHORT, l2, n2);
    }

    public static CharBuffer memCharBuffer(long l2, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return MemoryUtil.wrap(BUFFER_CHAR, l2, n2);
    }

    @Nullable
    public static CharBuffer memCharBufferSafe(long l2, int n2) {
        return l2 == 0L ? null : MemoryUtil.wrap(BUFFER_CHAR, l2, n2);
    }

    public static IntBuffer memIntBuffer(long l2, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return MemoryUtil.wrap(BUFFER_INT, l2, n2);
    }

    @Nullable
    public static IntBuffer memIntBufferSafe(long l2, int n2) {
        return l2 == 0L ? null : MemoryUtil.wrap(BUFFER_INT, l2, n2);
    }

    public static LongBuffer memLongBuffer(long l2, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return MemoryUtil.wrap(BUFFER_LONG, l2, n2);
    }

    @Nullable
    public static LongBuffer memLongBufferSafe(long l2, int n2) {
        return l2 == 0L ? null : MemoryUtil.wrap(BUFFER_LONG, l2, n2);
    }

    public static CLongBuffer memCLongBuffer(long l2, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return Pointer.Default.wrap(CLongBuffer.class, l2, n2);
    }

    @Nullable
    public static CLongBuffer memCLongBufferSafe(long l2, int n2) {
        return l2 == 0L ? null : Pointer.Default.wrap(CLongBuffer.class, l2, n2);
    }

    public static FloatBuffer memFloatBuffer(long l2, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return MemoryUtil.wrap(BUFFER_FLOAT, l2, n2);
    }

    @Nullable
    public static FloatBuffer memFloatBufferSafe(long l2, int n2) {
        return l2 == 0L ? null : MemoryUtil.wrap(BUFFER_FLOAT, l2, n2);
    }

    public static DoubleBuffer memDoubleBuffer(long l2, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return MemoryUtil.wrap(BUFFER_DOUBLE, l2, n2);
    }

    @Nullable
    public static DoubleBuffer memDoubleBufferSafe(long l2, int n2) {
        return l2 == 0L ? null : MemoryUtil.wrap(BUFFER_DOUBLE, l2, n2);
    }

    public static PointerBuffer memPointerBuffer(long l2, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return Pointer.Default.wrap(PointerBuffer.class, l2, n2);
    }

    @Nullable
    public static PointerBuffer memPointerBufferSafe(long l2, int n2) {
        return l2 == 0L ? null : Pointer.Default.wrap(PointerBuffer.class, l2, n2);
    }

    public static ByteBuffer memDuplicate(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        try {
            byteBuffer2 = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(byteBuffer2, ADDRESS, UNSAFE.getLong(byteBuffer, ADDRESS));
        UNSAFE.putInt(byteBuffer2, MARK, UNSAFE.getInt(byteBuffer, MARK));
        UNSAFE.putInt(byteBuffer2, POSITION, UNSAFE.getInt(byteBuffer, POSITION));
        UNSAFE.putInt(byteBuffer2, LIMIT, UNSAFE.getInt(byteBuffer, LIMIT));
        UNSAFE.putInt(byteBuffer2, CAPACITY, UNSAFE.getInt(byteBuffer, CAPACITY));
        Object object = UNSAFE.getObject(byteBuffer, PARENT_BYTE);
        UNSAFE.putObject(byteBuffer2, PARENT_BYTE, object == null ? byteBuffer : object);
        return byteBuffer2.order(byteBuffer.order());
    }

    public static ShortBuffer memDuplicate(ShortBuffer shortBuffer) {
        return MemoryUtil.duplicate(BUFFER_SHORT, shortBuffer, PARENT_SHORT);
    }

    public static CharBuffer memDuplicate(CharBuffer charBuffer) {
        return MemoryUtil.duplicate(BUFFER_CHAR, charBuffer, PARENT_CHAR);
    }

    public static IntBuffer memDuplicate(IntBuffer intBuffer) {
        return MemoryUtil.duplicate(BUFFER_INT, intBuffer, PARENT_INT);
    }

    public static LongBuffer memDuplicate(LongBuffer longBuffer) {
        return MemoryUtil.duplicate(BUFFER_LONG, longBuffer, PARENT_LONG);
    }

    public static FloatBuffer memDuplicate(FloatBuffer floatBuffer) {
        return MemoryUtil.duplicate(BUFFER_FLOAT, floatBuffer, PARENT_FLOAT);
    }

    public static DoubleBuffer memDuplicate(DoubleBuffer doubleBuffer) {
        return MemoryUtil.duplicate(BUFFER_DOUBLE, doubleBuffer, PARENT_DOUBLE);
    }

    public static ByteBuffer memSlice(ByteBuffer byteBuffer) {
        return MemoryUtil.slice(byteBuffer, MemoryUtil.memAddress0(byteBuffer) + (long)byteBuffer.position(), byteBuffer.remaining());
    }

    public static ShortBuffer memSlice(ShortBuffer shortBuffer) {
        return MemoryUtil.slice(BUFFER_SHORT, shortBuffer, MemoryUtil.address(shortBuffer.position(), 1, MemoryUtil.memAddress0(shortBuffer)), shortBuffer.remaining(), PARENT_SHORT);
    }

    public static CharBuffer memSlice(CharBuffer charBuffer) {
        return MemoryUtil.slice(BUFFER_CHAR, charBuffer, MemoryUtil.address(charBuffer.position(), 1, MemoryUtil.memAddress0(charBuffer)), charBuffer.remaining(), PARENT_CHAR);
    }

    public static IntBuffer memSlice(IntBuffer intBuffer) {
        return MemoryUtil.slice(BUFFER_INT, intBuffer, MemoryUtil.address(intBuffer.position(), 2, MemoryUtil.memAddress0(intBuffer)), intBuffer.remaining(), PARENT_INT);
    }

    public static LongBuffer memSlice(LongBuffer longBuffer) {
        return MemoryUtil.slice(BUFFER_LONG, longBuffer, MemoryUtil.address(longBuffer.position(), 3, MemoryUtil.memAddress0(longBuffer)), longBuffer.remaining(), PARENT_LONG);
    }

    public static FloatBuffer memSlice(FloatBuffer floatBuffer) {
        return MemoryUtil.slice(BUFFER_FLOAT, floatBuffer, MemoryUtil.address(floatBuffer.position(), 2, MemoryUtil.memAddress0(floatBuffer)), floatBuffer.remaining(), PARENT_FLOAT);
    }

    public static DoubleBuffer memSlice(DoubleBuffer doubleBuffer) {
        return MemoryUtil.slice(BUFFER_DOUBLE, doubleBuffer, MemoryUtil.address(doubleBuffer.position(), 3, MemoryUtil.memAddress0(doubleBuffer)), doubleBuffer.remaining(), PARENT_DOUBLE);
    }

    public static ByteBuffer memSlice(ByteBuffer byteBuffer, int n2, int n3) {
        int n4 = byteBuffer.position() + n2;
        if (n2 < 0 || byteBuffer.limit() < n4) {
            throw new IllegalArgumentException();
        }
        if (n3 < 0 || byteBuffer.capacity() - n4 < n3) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(byteBuffer, MemoryUtil.memAddress0(byteBuffer) + (long)n4, n3);
    }

    public static ShortBuffer memSlice(ShortBuffer shortBuffer, int n2, int n3) {
        int n4 = shortBuffer.position() + n2;
        if (n2 < 0 || shortBuffer.limit() < n4) {
            throw new IllegalArgumentException();
        }
        if (n3 < 0 || shortBuffer.capacity() - n4 < n3) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_SHORT, shortBuffer, MemoryUtil.address(n4, 1, MemoryUtil.memAddress0(shortBuffer)), n3, PARENT_SHORT);
    }

    public static CharBuffer memSlice(CharBuffer charBuffer, int n2, int n3) {
        int n4 = charBuffer.position() + n2;
        if (n2 < 0 || charBuffer.limit() < n4) {
            throw new IllegalArgumentException();
        }
        if (n3 < 0 || charBuffer.capacity() - n4 < n3) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_CHAR, charBuffer, MemoryUtil.address(n4, 1, MemoryUtil.memAddress0(charBuffer)), n3, PARENT_CHAR);
    }

    public static IntBuffer memSlice(IntBuffer intBuffer, int n2, int n3) {
        int n4 = intBuffer.position() + n2;
        if (n2 < 0 || intBuffer.limit() < n4) {
            throw new IllegalArgumentException();
        }
        if (n3 < 0 || intBuffer.capacity() - n4 < n3) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_INT, intBuffer, MemoryUtil.address(n4, 2, MemoryUtil.memAddress0(intBuffer)), n3, PARENT_INT);
    }

    public static LongBuffer memSlice(LongBuffer longBuffer, int n2, int n3) {
        int n4 = longBuffer.position() + n2;
        if (n2 < 0 || longBuffer.limit() < n4) {
            throw new IllegalArgumentException();
        }
        if (n3 < 0 || longBuffer.capacity() - n4 < n3) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_LONG, longBuffer, MemoryUtil.address(n4, 3, MemoryUtil.memAddress0(longBuffer)), n3, PARENT_LONG);
    }

    public static FloatBuffer memSlice(FloatBuffer floatBuffer, int n2, int n3) {
        int n4 = floatBuffer.position() + n2;
        if (n2 < 0 || floatBuffer.limit() < n4) {
            throw new IllegalArgumentException();
        }
        if (n3 < 0 || floatBuffer.capacity() - n4 < n3) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_FLOAT, floatBuffer, MemoryUtil.address(n4, 2, MemoryUtil.memAddress0(floatBuffer)), n3, PARENT_FLOAT);
    }

    public static DoubleBuffer memSlice(DoubleBuffer doubleBuffer, int n2, int n3) {
        int n4 = doubleBuffer.position() + n2;
        if (n2 < 0 || doubleBuffer.limit() < n4) {
            throw new IllegalArgumentException();
        }
        if (n3 < 0 || doubleBuffer.capacity() - n4 < n3) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_DOUBLE, doubleBuffer, MemoryUtil.address(n4, 3, MemoryUtil.memAddress0(doubleBuffer)), n3, PARENT_DOUBLE);
    }

    public static <T extends CustomBuffer<T>> T memSlice(T t2, int n2, int n3) {
        return t2.slice(n2, n3);
    }

    public static void memSet(ByteBuffer byteBuffer, int n2) {
        MemoryUtil.memSet(MemoryUtil.memAddress(byteBuffer), n2, byteBuffer.remaining());
    }

    public static void memSet(ShortBuffer shortBuffer, int n2) {
        MemoryUtil.memSet(MemoryUtil.memAddress(shortBuffer), n2, APIUtil.apiGetBytes(shortBuffer.remaining(), 1));
    }

    public static void memSet(CharBuffer charBuffer, int n2) {
        MemoryUtil.memSet(MemoryUtil.memAddress(charBuffer), n2, APIUtil.apiGetBytes(charBuffer.remaining(), 1));
    }

    public static void memSet(IntBuffer intBuffer, int n2) {
        MemoryUtil.memSet(MemoryUtil.memAddress(intBuffer), n2, APIUtil.apiGetBytes(intBuffer.remaining(), 2));
    }

    public static void memSet(LongBuffer longBuffer, int n2) {
        MemoryUtil.memSet(MemoryUtil.memAddress(longBuffer), n2, APIUtil.apiGetBytes(longBuffer.remaining(), 3));
    }

    public static void memSet(FloatBuffer floatBuffer, int n2) {
        MemoryUtil.memSet(MemoryUtil.memAddress(floatBuffer), n2, APIUtil.apiGetBytes(floatBuffer.remaining(), 2));
    }

    public static void memSet(DoubleBuffer doubleBuffer, int n2) {
        MemoryUtil.memSet(MemoryUtil.memAddress(doubleBuffer), n2, APIUtil.apiGetBytes(doubleBuffer.remaining(), 3));
    }

    public static <T extends CustomBuffer<T>> void memSet(T t2, int n2) {
        MemoryUtil.memSet(MemoryUtil.memAddress(t2), n2, Integer.toUnsignedLong(t2.remaining()) * (long)t2.sizeof());
    }

    public static <T extends Struct> void memSet(T t2, int n2) {
        MemoryUtil.memSet(t2.address, n2, t2.sizeof());
    }

    public static void memCopy(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer2, byteBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), byteBuffer.remaining());
    }

    public static void memCopy(ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)shortBuffer2, shortBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(shortBuffer), MemoryUtil.memAddress(shortBuffer2), APIUtil.apiGetBytes(shortBuffer.remaining(), 1));
    }

    public static void memCopy(CharBuffer charBuffer, CharBuffer charBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)charBuffer2, charBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(charBuffer), MemoryUtil.memAddress(charBuffer2), APIUtil.apiGetBytes(charBuffer.remaining(), 1));
    }

    public static void memCopy(IntBuffer intBuffer, IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer2, intBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2), APIUtil.apiGetBytes(intBuffer.remaining(), 2));
    }

    public static void memCopy(LongBuffer longBuffer, LongBuffer longBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer2, longBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(longBuffer), MemoryUtil.memAddress(longBuffer2), APIUtil.apiGetBytes(longBuffer.remaining(), 3));
    }

    public static void memCopy(FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer2, floatBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(floatBuffer), MemoryUtil.memAddress(floatBuffer2), APIUtil.apiGetBytes(floatBuffer.remaining(), 2));
    }

    public static void memCopy(DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer2, doubleBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(doubleBuffer), MemoryUtil.memAddress(doubleBuffer2), APIUtil.apiGetBytes(doubleBuffer.remaining(), 3));
    }

    public static <T extends CustomBuffer<T>> void memCopy(T t2, T t3) {
        if (Checks.CHECKS) {
            Checks.check(t3, t2.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(t2), MemoryUtil.memAddress(t3), Integer.toUnsignedLong(t2.remaining()) * (long)t2.sizeof());
    }

    public static <T extends Struct> void memCopy(T t2, T t3) {
        MultiReleaseMemCopy.copy(t2.address, t3.address, t2.sizeof());
    }

    public static void memSet(long l2, int n2, long l3) {
        if (Checks.DEBUG && (l2 == 0L || l3 < 0L)) {
            throw new IllegalArgumentException();
        }
        if (l3 < 256L) {
            int n3 = (int)l2;
            if (Pointer.BITS64) {
                if ((n3 & 7) == 0) {
                    MemoryUtil.memSet64(l2, n2, (int)l3 & 0xFF);
                    return;
                }
            } else if ((n3 & 3) == 0) {
                MemoryUtil.memSet32(n3, n2, (int)l3 & 0xFF);
                return;
            }
        }
        LibCString.nmemset(l2, n2, l3);
    }

    private static void memSet64(long l2, int n2, int n3) {
        long l3 = (long)(n2 & 0xFF) * FILL_PATTERN_64;
        int n4 = n3;
        while (8 <= n4) {
            UNSAFE.putLong(null, l2, l3);
            n4 -= 8;
            l2 += 8L;
        }
        if (n4 != 0) {
            long l4 = SHIFT.right(-1L, n4);
            UNSAFE.putLong(null, l2, l3 ^ (l3 ^ UNSAFE.getLong(null, l2)) & l4);
        }
    }

    private static void memSet32(int n2, int n3, int n4) {
        int n5;
        int n6 = (n3 & 0xFF) * FILL_PATTERN_32;
        for (n5 = 0; n5 <= n4 - 4; n5 += 4) {
            UNSAFE.putInt(null, n2 + n5, n6);
        }
        while (n5 < n4) {
            UNSAFE.putByte(null, n2 + n5, (byte)n6);
            ++n5;
        }
    }

    private static long merge(long l2, long l3, long l4) {
        return l2 ^ (l2 ^ l3) & l4;
    }

    public static void memCopy(long l2, long l3, long l4) {
        if (Checks.DEBUG && (l2 == 0L || l3 == 0L || l4 < 0L)) {
            throw new IllegalArgumentException();
        }
        MultiReleaseMemCopy.copy(l2, l3, l4);
    }

    static void memCopyAligned64(long l2, long l3, int n2) {
        int n3;
        for (n3 = 0; n3 <= n2 - 8; n3 += 8) {
            UNSAFE.putLong(null, l3 + (long)n3, UNSAFE.getLong(null, l2 + (long)n3));
        }
        if (n3 < n2) {
            UNSAFE.putLong(null, l3 + (long)n3, MemoryUtil.merge(UNSAFE.getLong(null, l2 + (long)n3), UNSAFE.getLong(null, l3 + (long)n3), SHIFT.right(-1L, n2 - n3)));
        }
    }

    static void memCopyAligned32(int n2, int n3, int n4) {
        int n5 = 0;
        while (n5 <= n4 - 4) {
            UNSAFE.putInt(null, n3, UNSAFE.getInt(null, n2));
            n5 += 4;
            n3 += 4;
            n2 += 4;
        }
        while (n5 < n4) {
            UNSAFE.putByte(null, n3, UNSAFE.getByte(null, n2));
            ++n5;
            ++n3;
            ++n2;
        }
    }

    public static boolean memGetBoolean(long l2) {
        return UNSAFE.getByte(null, l2) != 0;
    }

    public static byte memGetByte(long l2) {
        return UNSAFE.getByte(null, l2);
    }

    public static short memGetShort(long l2) {
        return UNSAFE.getShort(null, l2);
    }

    public static int memGetInt(long l2) {
        return UNSAFE.getInt(null, l2);
    }

    public static long memGetLong(long l2) {
        return UNSAFE.getLong(null, l2);
    }

    public static float memGetFloat(long l2) {
        return UNSAFE.getFloat(null, l2);
    }

    public static double memGetDouble(long l2) {
        return UNSAFE.getDouble(null, l2);
    }

    public static long memGetCLong(long l2) {
        return Pointer.CLONG_SIZE == 8 ? UNSAFE.getLong(null, l2) : (long)UNSAFE.getInt(null, l2);
    }

    public static long memGetAddress(long l2) {
        return Pointer.BITS64 ? UNSAFE.getLong(null, l2) : (long)UNSAFE.getInt(null, l2) & 0xFFFFFFFFL;
    }

    public static void memPutByte(long l2, byte by2) {
        UNSAFE.putByte(null, l2, by2);
    }

    public static void memPutShort(long l2, short s2) {
        UNSAFE.putShort(null, l2, s2);
    }

    public static void memPutInt(long l2, int n2) {
        UNSAFE.putInt(null, l2, n2);
    }

    public static void memPutLong(long l2, long l3) {
        UNSAFE.putLong(null, l2, l3);
    }

    public static void memPutFloat(long l2, float f2) {
        UNSAFE.putFloat(null, l2, f2);
    }

    public static void memPutDouble(long l2, double d2) {
        UNSAFE.putDouble(null, l2, d2);
    }

    public static void memPutCLong(long l2, long l3) {
        if (Pointer.CLONG_SIZE == 8) {
            UNSAFE.putLong(null, l2, l3);
        } else {
            UNSAFE.putInt(null, l2, (int)l3);
        }
    }

    public static void memPutAddress(long l2, long l3) {
        if (Pointer.BITS64) {
            UNSAFE.putLong(null, l2, l3);
        } else {
            UNSAFE.putInt(null, l2, (int)l3);
        }
    }

    public static native <T> T memGlobalRefToObject(long var0);

    private static int write8(long l2, int n2, int n3) {
        UNSAFE.putByte(null, l2 + Integer.toUnsignedLong(n2), (byte)n3);
        return n2 + 1;
    }

    private static int write8Safe(long l2, int n2, int n3, int n4) {
        if (n2 == n3) {
            throw new BufferOverflowException();
        }
        UNSAFE.putByte(null, l2 + Integer.toUnsignedLong(n2), (byte)n4);
        return n2 + 1;
    }

    private static int write16(long l2, int n2, char c2) {
        UNSAFE.putShort(null, l2 + Integer.toUnsignedLong(n2), (short)c2);
        return n2 + 2;
    }

    public static ByteBuffer memASCII(CharSequence charSequence) {
        return MemoryUtil.memASCII(charSequence, true);
    }

    @Nullable
    public static ByteBuffer memASCIISafe(@Nullable CharSequence charSequence) {
        return charSequence == null ? null : MemoryUtil.memASCII(charSequence, true);
    }

    public static ByteBuffer memASCII(CharSequence charSequence, boolean bl2) {
        int n2 = MemoryUtil.memLengthASCII(charSequence, bl2);
        long l2 = MemoryUtil.nmemAlloc(n2);
        if (Checks.CHECKS && l2 == 0L) {
            throw new OutOfMemoryError();
        }
        MemoryUtil.encodeASCIIUnsafe(charSequence, bl2, l2);
        return MemoryUtil.wrap(BUFFER_BYTE, l2, n2).order(NATIVE_ORDER);
    }

    @Nullable
    public static ByteBuffer memASCIISafe(@Nullable CharSequence charSequence, boolean bl2) {
        return charSequence == null ? null : MemoryUtil.memASCII(charSequence, bl2);
    }

    public static int memASCII(CharSequence charSequence, boolean bl2, ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < MemoryUtil.memLengthASCII(charSequence, bl2)) {
            throw new BufferOverflowException();
        }
        long l2 = MemoryUtil.memAddress(byteBuffer);
        return MemoryUtil.encodeASCIIUnsafe(charSequence, bl2, l2);
    }

    public static int memASCII(CharSequence charSequence, boolean bl2, ByteBuffer byteBuffer, int n2) {
        if (byteBuffer.capacity() - n2 < MemoryUtil.memLengthASCII(charSequence, bl2)) {
            throw new BufferOverflowException();
        }
        return MemoryUtil.encodeASCIIUnsafe(charSequence, bl2, MemoryUtil.memAddress(byteBuffer, n2));
    }

    static int encodeASCIIUnsafe(CharSequence charSequence, boolean bl2, long l2) {
        int n2 = 0;
        int n3 = charSequence.length();
        while (n2 < n3) {
            n2 = MemoryUtil.write8(l2, n2, charSequence.charAt(n2));
        }
        if (bl2) {
            n2 = MemoryUtil.write8(l2, n2, 0);
        }
        return n2;
    }

    public static int memLengthASCII(CharSequence charSequence, boolean bl2) {
        int n2 = charSequence.length() + (bl2 ? 1 : 0);
        if (n2 < 0) {
            throw new BufferOverflowException();
        }
        return n2;
    }

    public static ByteBuffer memUTF8(CharSequence charSequence) {
        return MemoryUtil.memUTF8(charSequence, true);
    }

    @Nullable
    public static ByteBuffer memUTF8Safe(@Nullable CharSequence charSequence) {
        return charSequence == null ? null : MemoryUtil.memUTF8(charSequence, true);
    }

    public static ByteBuffer memUTF8(CharSequence charSequence, boolean bl2) {
        int n2 = MemoryUtil.memLengthUTF8(charSequence, bl2);
        long l2 = MemoryUtil.nmemAlloc(n2);
        if (Checks.CHECKS && l2 == 0L) {
            throw new OutOfMemoryError();
        }
        MemoryUtil.encodeUTF8Unsafe(charSequence, bl2, l2);
        return MemoryUtil.wrap(BUFFER_BYTE, l2, n2).order(NATIVE_ORDER);
    }

    @Nullable
    public static ByteBuffer memUTF8Safe(@Nullable CharSequence charSequence, boolean bl2) {
        return charSequence == null ? null : MemoryUtil.memUTF8(charSequence, bl2);
    }

    public static int memUTF8(CharSequence charSequence, boolean bl2, ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < MemoryUtil.memLengthASCII(charSequence, bl2)) {
            throw new BufferOverflowException();
        }
        return MemoryUtil.encodeUTF8Safe(charSequence, bl2, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static int memUTF8(CharSequence charSequence, boolean bl2, ByteBuffer byteBuffer, int n2) {
        if (byteBuffer.capacity() - n2 < MemoryUtil.memLengthASCII(charSequence, bl2)) {
            throw new BufferOverflowException();
        }
        return MemoryUtil.encodeUTF8Safe(charSequence, bl2, MemoryUtil.memAddress(byteBuffer, n2), byteBuffer.capacity() - n2);
    }

    static int encodeUTF8Unsafe(CharSequence charSequence, boolean bl2, long l2) {
        int n2 = 0;
        int n3 = 0;
        int n4 = charSequence.length();
        while (n3 < n4) {
            int n5;
            if ((n5 = charSequence.charAt(n3++)) < 128) {
                n2 = MemoryUtil.write8(l2, n2, n5);
                continue;
            }
            int n6 = n5;
            if (n5 < 2048) {
                n2 = MemoryUtil.write8(l2, n2, 0xC0 | n6 >> 6);
            } else {
                if (!Character.isHighSurrogate((char)n5)) {
                    n2 = MemoryUtil.write8(l2, n2, 0xE0 | n6 >> 12);
                } else {
                    n6 = Character.toCodePoint((char)n5, charSequence.charAt(n3++));
                    n2 = MemoryUtil.write8(l2, n2, 0xF0 | n6 >> 18);
                    n2 = MemoryUtil.write8(l2, n2, 0x80 | n6 >> 12 & 0x3F);
                }
                n2 = MemoryUtil.write8(l2, n2, 0x80 | n6 >> 6 & 0x3F);
            }
            n2 = MemoryUtil.write8(l2, n2, 0x80 | n6 & 0x3F);
        }
        if (bl2) {
            n2 = MemoryUtil.write8(l2, n2, 0);
        }
        return n2;
    }

    static int encodeUTF8Safe(CharSequence charSequence, boolean bl2, long l2, int n2) {
        int n3;
        int n4;
        int n5 = 0;
        int n6 = charSequence.length();
        for (n4 = 0; n4 < n6 && 128 > (n3 = charSequence.charAt(n4)); ++n4) {
            n5 = MemoryUtil.write8(l2, n5, n3);
        }
        while (n4 < n6) {
            if ((n3 = charSequence.charAt(n4++)) < 128) {
                n5 = MemoryUtil.write8Safe(l2, n5, n2, n3);
                continue;
            }
            int n7 = n3;
            if (n3 < 2048) {
                n5 = MemoryUtil.write8Safe(l2, n5, n2, 0xC0 | n7 >> 6);
            } else {
                if (!Character.isHighSurrogate((char)n3)) {
                    n5 = MemoryUtil.write8Safe(l2, n5, n2, 0xE0 | n7 >> 12);
                } else {
                    n7 = Character.toCodePoint((char)n3, charSequence.charAt(n4++));
                    n5 = MemoryUtil.write8Safe(l2, n5, n2, 0xF0 | n7 >> 18);
                    n5 = MemoryUtil.write8Safe(l2, n5, n2, 0x80 | n7 >> 12 & 0x3F);
                }
                n5 = MemoryUtil.write8Safe(l2, n5, n2, 0x80 | n7 >> 6 & 0x3F);
            }
            n5 = MemoryUtil.write8Safe(l2, n5, n2, 0x80 | n7 & 0x3F);
        }
        if (bl2) {
            n5 = MemoryUtil.write8Safe(l2, n5, n2, 0);
        }
        return n5;
    }

    public static int memLengthUTF8(CharSequence charSequence, boolean bl2) {
        int n2 = charSequence.length();
        int n3 = n2 + (bl2 ? 1 : 0);
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = charSequence.charAt(i2);
            if (c2 < '\u0080') continue;
            if (c2 < '\u0800') {
                n3 += 127 - c2 >>> 31;
            } else {
                n3 += 2;
                if (Character.isHighSurrogate(c2)) {
                    ++i2;
                }
            }
            if (n3 >= 0) continue;
            throw new BufferOverflowException();
        }
        if (n3 < 0) {
            throw new BufferOverflowException();
        }
        return n3;
    }

    public static ByteBuffer memUTF16(CharSequence charSequence) {
        return MemoryUtil.memUTF16(charSequence, true);
    }

    @Nullable
    public static ByteBuffer memUTF16Safe(@Nullable CharSequence charSequence) {
        return charSequence == null ? null : MemoryUtil.memUTF16(charSequence, true);
    }

    public static ByteBuffer memUTF16(CharSequence charSequence, boolean bl2) {
        int n2 = MemoryUtil.memLengthUTF16(charSequence, bl2);
        long l2 = MemoryUtil.nmemAlloc(n2);
        if (Checks.CHECKS && l2 == 0L) {
            throw new OutOfMemoryError();
        }
        MemoryUtil.encodeUTF16Unsafe(charSequence, bl2, l2);
        return MemoryUtil.wrap(BUFFER_BYTE, l2, n2).order(NATIVE_ORDER);
    }

    @Nullable
    public static ByteBuffer memUTF16Safe(@Nullable CharSequence charSequence, boolean bl2) {
        return charSequence == null ? null : MemoryUtil.memUTF16(charSequence, bl2);
    }

    public static int memUTF16(CharSequence charSequence, boolean bl2, ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < MemoryUtil.memLengthUTF16(charSequence, bl2)) {
            throw new BufferOverflowException();
        }
        long l2 = MemoryUtil.memAddress(byteBuffer);
        return MemoryUtil.encodeUTF16Unsafe(charSequence, bl2, l2);
    }

    public static int memUTF16(CharSequence charSequence, boolean bl2, ByteBuffer byteBuffer, int n2) {
        if (byteBuffer.capacity() - n2 < MemoryUtil.memLengthUTF16(charSequence, bl2)) {
            throw new BufferOverflowException();
        }
        long l2 = MemoryUtil.memAddress(byteBuffer, n2);
        return MemoryUtil.encodeUTF16Unsafe(charSequence, bl2, l2);
    }

    static int encodeUTF16Unsafe(CharSequence charSequence, boolean bl2, long l2) {
        int n2 = 0;
        int n3 = 0;
        int n4 = charSequence.length();
        while (n3 < n4) {
            n2 = MemoryUtil.write16(l2, n2, charSequence.charAt(n3++));
        }
        if (bl2) {
            n2 = MemoryUtil.write16(l2, n2, '\u0000');
        }
        return n2;
    }

    public static int memLengthUTF16(CharSequence charSequence, boolean bl2) {
        int n2 = charSequence.length() + (bl2 ? 1 : 0);
        if (n2 < 0 || 0x3FFFFFFF < n2) {
            throw new BufferOverflowException();
        }
        return n2 << 1;
    }

    private static int memLengthNT1(long l2, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return Pointer.BITS64 ? MemoryUtil.strlen64NT1(l2, n2) : MemoryUtil.strlen32NT1(l2, n2);
    }

    private static int strlen64NT1(long l2, int n2) {
        int n3;
        if (8 <= n2) {
            int n4 = (int)l2 & 7;
            if (n4 != 0) {
                int n5 = 8 - n4;
                for (n3 = 0; n3 < n5; ++n3) {
                    if (UNSAFE.getByte(null, l2 + (long)n3) != 0) continue;
                    return n3;
                }
            }
            while (n3 <= n2 - 8 && !MathUtil.mathHasZeroByte(UNSAFE.getLong(null, l2 + (long)n3))) {
                n3 += 8;
            }
        }
        while (n3 < n2 && UNSAFE.getByte(null, l2 + (long)n3) != 0) {
            ++n3;
        }
        return n3;
    }

    private static int strlen32NT1(long l2, int n2) {
        int n3;
        if (4 <= n2) {
            int n4 = (int)l2 & 3;
            if (n4 != 0) {
                int n5 = 4 - n4;
                for (n3 = 0; n3 < n5; ++n3) {
                    if (UNSAFE.getByte(null, l2 + (long)n3) != 0) continue;
                    return n3;
                }
            }
            while (n3 <= n2 - 4 && !MathUtil.mathHasZeroByte(UNSAFE.getInt(null, l2 + (long)n3))) {
                n3 += 4;
            }
        }
        while (n3 < n2 && UNSAFE.getByte(null, l2 + (long)n3) != 0) {
            ++n3;
        }
        return n3;
    }

    public static int memLengthNT1(ByteBuffer byteBuffer) {
        return MemoryUtil.memLengthNT1(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    private static int memLengthNT2(long l2, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return Pointer.BITS64 ? MemoryUtil.strlen64NT2(l2, n2) : MemoryUtil.strlen32NT2((int)l2, n2);
    }

    private static int strlen64NT2(long l2, int n2) {
        int n3;
        if (8 <= n2) {
            int n4 = (int)l2 & 7;
            if (n4 != 0) {
                int n5 = 8 - n4;
                for (n3 = 0; n3 < n5; n3 += 2) {
                    if (UNSAFE.getShort(null, l2 + (long)n3) != 0) continue;
                    return n3;
                }
            }
            while (n3 <= n2 - 8 && !MathUtil.mathHasZeroShort(UNSAFE.getLong(null, l2 + (long)n3))) {
                n3 += 8;
            }
        }
        while (n3 < n2 && UNSAFE.getShort(null, l2 + (long)n3) != 0) {
            n3 += 2;
        }
        return n3;
    }

    private static int strlen32NT2(long l2, int n2) {
        int n3;
        if (4 <= n2) {
            int n4 = (int)l2 & 3;
            if (n4 != 0) {
                int n5 = 4 - n4;
                for (n3 = 0; n3 < n5; n3 += 2) {
                    if (UNSAFE.getShort(null, l2 + (long)n3) != 0) continue;
                    return n3;
                }
            }
            while (n3 <= n2 - 4 && !MathUtil.mathHasZeroShort(UNSAFE.getInt(null, l2 + (long)n3))) {
                n3 += 4;
            }
        }
        while (n3 < n2 && UNSAFE.getShort(null, l2 + (long)n3) != 0) {
            n3 += 2;
        }
        return n3;
    }

    public static int memLengthNT2(ByteBuffer byteBuffer) {
        return MemoryUtil.memLengthNT2(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static ByteBuffer memByteBufferNT1(long l2) {
        return MemoryUtil.memByteBuffer(l2, MemoryUtil.memLengthNT1(l2, Integer.MAX_VALUE));
    }

    public static ByteBuffer memByteBufferNT1(long l2, int n2) {
        return MemoryUtil.memByteBuffer(l2, MemoryUtil.memLengthNT1(l2, n2));
    }

    @Nullable
    public static ByteBuffer memByteBufferNT1Safe(long l2) {
        return l2 == 0L ? null : MemoryUtil.memByteBuffer(l2, MemoryUtil.memLengthNT1(l2, Integer.MAX_VALUE));
    }

    @Nullable
    public static ByteBuffer memByteBufferNT1Safe(long l2, int n2) {
        return l2 == 0L ? null : MemoryUtil.memByteBuffer(l2, MemoryUtil.memLengthNT1(l2, n2));
    }

    public static ByteBuffer memByteBufferNT2(long l2) {
        return MemoryUtil.memByteBufferNT2(l2, 0x7FFFFFFE);
    }

    public static ByteBuffer memByteBufferNT2(long l2, int n2) {
        if (Checks.DEBUG && (n2 & 1) != 0) {
            throw new IllegalArgumentException("The maximum length must be an even number.");
        }
        return MemoryUtil.memByteBuffer(l2, MemoryUtil.memLengthNT2(l2, n2));
    }

    @Nullable
    public static ByteBuffer memByteBufferNT2Safe(long l2) {
        return l2 == 0L ? null : MemoryUtil.memByteBufferNT2(l2, 0x7FFFFFFE);
    }

    @Nullable
    public static ByteBuffer memByteBufferNT2Safe(long l2, int n2) {
        return l2 == 0L ? null : MemoryUtil.memByteBufferNT2(l2, n2);
    }

    public static String memASCII(long l2) {
        return MemoryUtil.memASCII(l2, MemoryUtil.memLengthNT1(l2, Integer.MAX_VALUE));
    }

    public static String memASCII(long l2, int n2) {
        if (n2 <= 0) {
            return "";
        }
        byte[] byArray = n2 <= ARRAY_TLC_SIZE ? ARRAY_TLC_BYTE.get() : new byte[n2];
        MemoryUtil.memByteBuffer(l2, n2).get(byArray, 0, n2);
        return new String(byArray, 0, 0, n2);
    }

    public static String memASCII(ByteBuffer byteBuffer) {
        return MemoryUtil.memASCII(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    @Nullable
    public static String memASCIISafe(long l2) {
        return l2 == 0L ? null : MemoryUtil.memASCII(l2, MemoryUtil.memLengthNT1(l2, Integer.MAX_VALUE));
    }

    @Nullable
    public static String memASCIISafe(long l2, int n2) {
        return l2 == 0L ? null : MemoryUtil.memASCII(l2, n2);
    }

    @Nullable
    public static String memASCIISafe(@Nullable ByteBuffer byteBuffer) {
        return byteBuffer == null ? null : MemoryUtil.memASCII(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static String memASCII(ByteBuffer byteBuffer, int n2) {
        return MemoryUtil.memASCII(MemoryUtil.memAddress(byteBuffer), n2);
    }

    public static String memASCII(ByteBuffer byteBuffer, int n2, int n3) {
        return MemoryUtil.memASCII(MemoryUtil.memAddress(byteBuffer, n3), n2);
    }

    public static String memUTF8(long l2) {
        return MultiReleaseTextDecoding.decodeUTF8(l2, MemoryUtil.memLengthNT1(l2, Integer.MAX_VALUE));
    }

    public static String memUTF8(long l2, int n2) {
        return MultiReleaseTextDecoding.decodeUTF8(l2, n2);
    }

    public static String memUTF8(ByteBuffer byteBuffer) {
        return MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    @Nullable
    public static String memUTF8Safe(long l2) {
        return l2 == 0L ? null : MultiReleaseTextDecoding.decodeUTF8(l2, MemoryUtil.memLengthNT1(l2, Integer.MAX_VALUE));
    }

    @Nullable
    public static String memUTF8Safe(long l2, int n2) {
        return l2 == 0L ? null : MultiReleaseTextDecoding.decodeUTF8(l2, n2);
    }

    @Nullable
    public static String memUTF8Safe(@Nullable ByteBuffer byteBuffer) {
        return byteBuffer == null ? null : MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static String memUTF8(ByteBuffer byteBuffer, int n2) {
        return MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(byteBuffer), n2);
    }

    public static String memUTF8(ByteBuffer byteBuffer, int n2, int n3) {
        return MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(byteBuffer, n3), n2);
    }

    public static String memUTF16(long l2) {
        return MemoryUtil.memUTF16(l2, MemoryUtil.memLengthNT2(l2, 0x7FFFFFFE) >> 1);
    }

    public static String memUTF16(long l2, int n2) {
        if (n2 <= 0) {
            return "";
        }
        if (Checks.DEBUG) {
            int n3 = n2 << 1;
            byte[] byArray = n3 <= ARRAY_TLC_SIZE ? ARRAY_TLC_BYTE.get() : new byte[n3];
            MemoryUtil.memByteBuffer(l2, n3).get(byArray, 0, n3);
            return new String(byArray, 0, n3, UTF16);
        }
        char[] cArray = n2 <= ARRAY_TLC_SIZE ? ARRAY_TLC_CHAR.get() : new char[n2];
        MemoryUtil.memCharBuffer(l2, n2).get(cArray, 0, n2);
        return new String(cArray, 0, n2);
    }

    public static String memUTF16(ByteBuffer byteBuffer) {
        return MemoryUtil.memUTF16(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining() >> 1);
    }

    @Nullable
    public static String memUTF16Safe(long l2) {
        return l2 == 0L ? null : MemoryUtil.memUTF16(l2, MemoryUtil.memLengthNT2(l2, 0x7FFFFFFE) >> 1);
    }

    @Nullable
    public static String memUTF16Safe(long l2, int n2) {
        return l2 == 0L ? null : MemoryUtil.memUTF16(l2, n2);
    }

    @Nullable
    public static String memUTF16Safe(@Nullable ByteBuffer byteBuffer) {
        return byteBuffer == null ? null : MemoryUtil.memUTF16(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining() >> 1);
    }

    public static String memUTF16(ByteBuffer byteBuffer, int n2) {
        return MemoryUtil.memUTF16(MemoryUtil.memAddress(byteBuffer), n2);
    }

    public static String memUTF16(ByteBuffer byteBuffer, int n2, int n3) {
        return MemoryUtil.memUTF16(MemoryUtil.memAddress(byteBuffer, n3), n2);
    }

    private static Unsafe getUnsafeInstance() {
        Field[] fieldArray;
        for (Field field : fieldArray = Unsafe.class.getDeclaredFields()) {
            int n2;
            if (!field.getType().equals(Unsafe.class) || !Modifier.isStatic(n2 = field.getModifiers()) || !Modifier.isFinal(n2)) continue;
            try {
                field.setAccessible(true);
                return (Unsafe)field.get(null);
            }
            catch (Exception exception) {
                break;
            }
        }
        throw new UnsupportedOperationException("LWJGL requires sun.misc.Unsafe to be available.");
    }

    private static long getFieldOffset(Class<?> clazz, Class<?> clazz2, LongPredicate longPredicate) {
        for (Class<?> clazz3 = clazz; clazz3 != Object.class; clazz3 = clazz3.getSuperclass()) {
            Field[] fieldArray;
            for (Field field : fieldArray = clazz3.getDeclaredFields()) {
                long l2;
                if (!field.getType().isAssignableFrom(clazz2) || Modifier.isStatic(field.getModifiers()) || field.isSynthetic() || !longPredicate.test(l2 = UNSAFE.objectFieldOffset(field))) continue;
                return l2;
            }
        }
        throw new UnsupportedOperationException("Failed to find field offset in class.");
    }

    private static long getFieldOffsetInt(Object object, int n2) {
        return MemoryUtil.getFieldOffset(object.getClass(), Integer.TYPE, l2 -> UNSAFE.getInt(object, l2) == n2);
    }

    private static long getFieldOffsetObject(Object object, Object object2) {
        return MemoryUtil.getFieldOffset(object.getClass(), object2.getClass(), l2 -> UNSAFE.getObject(object, l2) == object2);
    }

    private static long getAddressOffset() {
        long l2 = 0xDEADBEEF8BADF00DL & (Pointer.BITS32 ? 0xFFFFFFFFL : -1L);
        ByteBuffer byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(l2, 0L));
        return MemoryUtil.getFieldOffset(byteBuffer.getClass(), Long.TYPE, l3 -> UNSAFE.getLong(byteBuffer, l3) == l2);
    }

    private static long getMarkOffset() {
        ByteBuffer byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(1L, 0L));
        return MemoryUtil.getFieldOffsetInt(byteBuffer, -1);
    }

    private static long getPositionOffset() {
        ByteBuffer byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
        byteBuffer.position(16435934);
        return MemoryUtil.getFieldOffsetInt(byteBuffer, 16435934);
    }

    private static long getLimitOffset() {
        ByteBuffer byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
        byteBuffer.limit(16435934);
        return MemoryUtil.getFieldOffsetInt(byteBuffer, 16435934);
    }

    private static long getCapacityOffset() {
        ByteBuffer byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
        byteBuffer.limit(0);
        return MemoryUtil.getFieldOffsetInt(byteBuffer, 219540062);
    }

    static <T extends Buffer> T wrap(Class<? extends T> clazz, long l2, int n2) {
        Buffer buffer;
        try {
            buffer = (Buffer)UNSAFE.allocateInstance(clazz);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(buffer, ADDRESS, l2);
        UNSAFE.putInt(buffer, MARK, -1);
        UNSAFE.putInt(buffer, LIMIT, n2);
        UNSAFE.putInt(buffer, CAPACITY, n2);
        return (T)buffer;
    }

    static ByteBuffer slice(ByteBuffer byteBuffer, long l2, int n2) {
        ByteBuffer byteBuffer2;
        try {
            byteBuffer2 = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(byteBuffer2, ADDRESS, l2);
        UNSAFE.putInt(byteBuffer2, MARK, -1);
        UNSAFE.putInt(byteBuffer2, LIMIT, n2);
        UNSAFE.putInt(byteBuffer2, CAPACITY, n2);
        Object object = UNSAFE.getObject(byteBuffer, PARENT_BYTE);
        UNSAFE.putObject(byteBuffer2, PARENT_BYTE, object == null ? byteBuffer : object);
        return byteBuffer2.order(byteBuffer.order());
    }

    static <T extends Buffer> T slice(Class<? extends T> clazz, T t2, long l2, int n2, long l3) {
        Buffer buffer;
        try {
            buffer = (Buffer)UNSAFE.allocateInstance(clazz);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(buffer, ADDRESS, l2);
        UNSAFE.putInt(buffer, MARK, -1);
        UNSAFE.putInt(buffer, LIMIT, n2);
        UNSAFE.putInt(buffer, CAPACITY, n2);
        UNSAFE.putObject(buffer, l3, UNSAFE.getObject(t2, l3));
        return (T)buffer;
    }

    static <T extends Buffer> T duplicate(Class<? extends T> clazz, T t2, long l2) {
        Buffer buffer;
        try {
            buffer = (Buffer)UNSAFE.allocateInstance(clazz);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(buffer, ADDRESS, UNSAFE.getLong(t2, ADDRESS));
        UNSAFE.putInt(buffer, MARK, UNSAFE.getInt(t2, MARK));
        UNSAFE.putInt(buffer, POSITION, UNSAFE.getInt(t2, POSITION));
        UNSAFE.putInt(buffer, LIMIT, UNSAFE.getInt(t2, LIMIT));
        UNSAFE.putInt(buffer, CAPACITY, UNSAFE.getInt(t2, CAPACITY));
        UNSAFE.putObject(buffer, l2, UNSAFE.getObject(t2, l2));
        return (T)buffer;
    }

    static {
        ARRAY_TLC_SIZE = Configuration.ARRAY_TLC_SIZE.get(8192);
        ARRAY_TLC_BYTE = ThreadLocal.withInitial(() -> new byte[ARRAY_TLC_SIZE]);
        ARRAY_TLC_CHAR = ThreadLocal.withInitial(() -> new char[ARRAY_TLC_SIZE]);
        NATIVE_ORDER = ByteOrder.nativeOrder();
        UTF16 = NATIVE_ORDER == ByteOrder.LITTLE_ENDIAN ? StandardCharsets.UTF_16LE : StandardCharsets.UTF_16BE;
        Library.initialize();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(0).order(NATIVE_ORDER);
        BUFFER_BYTE = byteBuffer.getClass();
        BUFFER_SHORT = byteBuffer.asShortBuffer().getClass();
        BUFFER_CHAR = byteBuffer.asCharBuffer().getClass();
        BUFFER_INT = byteBuffer.asIntBuffer().getClass();
        BUFFER_LONG = byteBuffer.asLongBuffer().getClass();
        BUFFER_FLOAT = byteBuffer.asFloatBuffer().getClass();
        BUFFER_DOUBLE = byteBuffer.asDoubleBuffer().getClass();
        UNSAFE = MemoryUtil.getUnsafeInstance();
        try {
            MARK = MemoryUtil.getMarkOffset();
            POSITION = MemoryUtil.getPositionOffset();
            LIMIT = MemoryUtil.getLimitOffset();
            CAPACITY = MemoryUtil.getCapacityOffset();
            ADDRESS = MemoryUtil.getAddressOffset();
            PARENT_BYTE = MemoryUtil.getFieldOffsetObject(byteBuffer.duplicate().order(byteBuffer.order()), byteBuffer);
            PARENT_SHORT = MemoryUtil.getFieldOffsetObject(byteBuffer.asShortBuffer(), byteBuffer);
            PARENT_CHAR = MemoryUtil.getFieldOffsetObject(byteBuffer.asCharBuffer(), byteBuffer);
            PARENT_INT = MemoryUtil.getFieldOffsetObject(byteBuffer.asIntBuffer(), byteBuffer);
            PARENT_LONG = MemoryUtil.getFieldOffsetObject(byteBuffer.asLongBuffer(), byteBuffer);
            PARENT_FLOAT = MemoryUtil.getFieldOffsetObject(byteBuffer.asFloatBuffer(), byteBuffer);
            PARENT_DOUBLE = MemoryUtil.getFieldOffsetObject(byteBuffer.asDoubleBuffer(), byteBuffer);
        }
        catch (Throwable throwable) {
            throw new UnsupportedOperationException(throwable);
        }
        PAGE_SIZE = UNSAFE.pageSize();
        CACHE_LINE_SIZE = 64;
        SHIFT = NATIVE_ORDER == ByteOrder.BIG_ENDIAN ? new NativeShift(){

            @Override
            public long left(long l2, int n2) {
                return l2 << (n2 << 3);
            }

            @Override
            public long right(long l2, int n2) {
                return l2 >>> (n2 << 3);
            }
        } : new NativeShift(){

            @Override
            public long left(long l2, int n2) {
                return l2 >>> (n2 << 3);
            }

            @Override
            public long right(long l2, int n2) {
                return l2 << (n2 << 3);
            }
        };
        FILL_PATTERN_32 = Integer.divideUnsigned(-1, 255);
        FILL_PATTERN_64 = Long.divideUnsigned(-1L, 255L);
    }

    public static interface MemoryAllocator {
        public long getMalloc();

        public long getCalloc();

        public long getRealloc();

        public long getFree();

        public long getAlignedAlloc();

        public long getAlignedFree();

        public long malloc(long var1);

        public long calloc(long var1, long var3);

        public long realloc(long var1, long var3);

        public void free(long var1);

        public long aligned_alloc(long var1, long var3);

        public void aligned_free(long var1);
    }

    static final class LazyInit {
        static final MemoryAllocator ALLOCATOR_IMPL = MemoryManage.getInstance();
        static final MemoryAllocator ALLOCATOR = Configuration.DEBUG_MEMORY_ALLOCATOR.get(false) != false ? new MemoryManage.DebugAllocator(ALLOCATOR_IMPL) : ALLOCATOR_IMPL;

        private LazyInit() {
        }

        static {
            APIUtil.apiLog("MemoryUtil allocator: " + ALLOCATOR.getClass().getSimpleName());
        }
    }

    public static interface MemoryAllocationReport {
        public void invoke(long var1, long var3, long var5, @Nullable String var7, StackTraceElement ... var8);

        public static enum Aggregate {
            ALL,
            GROUP_BY_METHOD,
            GROUP_BY_STACKTRACE;

        }
    }

    static interface NativeShift {
        public long left(long var1, int var3);

        public long right(long var1, int var3);
    }
}

