/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.StackWalkUtil;

public class MemoryStack
extends Pointer.Default
implements AutoCloseable {
    private static final int DEFAULT_STACK_SIZE = Configuration.STACK_SIZE.get(64) * 1024;
    private static final int DEFAULT_STACK_FRAMES = 8;
    private static final ThreadLocal<MemoryStack> TLS = ThreadLocal.withInitial(MemoryStack::create);
    @Nullable
    private final ByteBuffer container;
    private final int size;
    private int pointer;
    private int[] frames;
    protected int frameIndex;

    protected MemoryStack(@Nullable ByteBuffer byteBuffer, long l2, int n2) {
        super(l2);
        this.container = byteBuffer;
        this.size = n2;
        this.pointer = n2;
        this.frames = new int[8];
    }

    public static MemoryStack create() {
        return MemoryStack.create(DEFAULT_STACK_SIZE);
    }

    public static MemoryStack create(int n2) {
        return MemoryStack.create(BufferUtils.createByteBuffer(n2));
    }

    public static MemoryStack create(ByteBuffer byteBuffer) {
        long l2 = MemoryUtil.memAddress(byteBuffer);
        int n2 = byteBuffer.remaining();
        return Configuration.DEBUG_STACK.get(false) != false ? new DebugMemoryStack(byteBuffer, l2, n2) : new MemoryStack(byteBuffer, l2, n2);
    }

    public static MemoryStack ncreate(long l2, int n2) {
        return Configuration.DEBUG_STACK.get(false) != false ? new DebugMemoryStack(null, l2, n2) : new MemoryStack(null, l2, n2);
    }

    public MemoryStack push() {
        if (this.frameIndex == this.frames.length) {
            this.frameOverflow();
        }
        this.frames[this.frameIndex++] = this.pointer;
        return this;
    }

    private void frameOverflow() {
        if (Checks.DEBUG) {
            APIUtil.apiLog("[WARNING] Out of frame stack space (" + this.frames.length + ") in thread: " + Thread.currentThread());
        }
        this.frames = Arrays.copyOf(this.frames, this.frames.length * 3 / 2);
    }

    public MemoryStack pop() {
        this.pointer = this.frames[--this.frameIndex];
        return this;
    }

    @Override
    public void close() {
        this.pop();
    }

    public long getAddress() {
        return this.address;
    }

    public int getSize() {
        return this.size;
    }

    public int getFrameIndex() {
        return this.frameIndex;
    }

    public long getPointerAddress() {
        return this.address + ((long)this.pointer & 0xFFFFFFFFL);
    }

    public int getPointer() {
        return this.pointer;
    }

    public void setPointer(int n2) {
        if (Checks.CHECKS) {
            this.checkPointer(n2);
        }
        this.pointer = n2;
    }

    private void checkPointer(int n2) {
        if (n2 < 0 || this.size < n2) {
            throw new IndexOutOfBoundsException("Invalid stack pointer");
        }
    }

    private static void checkAlignment(int n2) {
        if (Integer.bitCount(n2) != 1) {
            throw new IllegalArgumentException("Alignment must be a power-of-two value.");
        }
    }

    public long nmalloc(int n2) {
        return this.nmalloc(POINTER_SIZE, n2);
    }

    public long nmalloc(int n2, int n3) {
        long l2 = this.address + (long)this.pointer - (long)n3 & (Integer.toUnsignedLong(n2 - 1) ^ 0xFFFFFFFFFFFFFFFFL);
        this.pointer = (int)(l2 - this.address);
        if (Checks.CHECKS && this.pointer < 0) {
            throw new OutOfMemoryError("Out of stack space.");
        }
        return l2;
    }

    public long ncalloc(int n2, int n3, int n4) {
        int n5 = n3 * n4;
        long l2 = this.nmalloc(n2, n5);
        MemoryUtil.memSet(l2, 0, n5);
        return l2;
    }

    public ByteBuffer malloc(int n2, int n3) {
        if (Checks.DEBUG) {
            MemoryStack.checkAlignment(n2);
        }
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, this.nmalloc(n2, n3), n3).order(MemoryUtil.NATIVE_ORDER);
    }

    public ByteBuffer calloc(int n2, int n3) {
        if (Checks.DEBUG) {
            MemoryStack.checkAlignment(n2);
        }
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, this.ncalloc(n2, n3, 1), n3).order(MemoryUtil.NATIVE_ORDER);
    }

    public ByteBuffer malloc(int n2) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, this.nmalloc(POINTER_SIZE, n2), n2).order(MemoryUtil.NATIVE_ORDER);
    }

    public ByteBuffer calloc(int n2) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, this.ncalloc(POINTER_SIZE, n2, 1), n2).order(MemoryUtil.NATIVE_ORDER);
    }

    public long nbyte(byte by2) {
        long l2 = this.nmalloc(1, 1);
        MemoryUtil.memPutByte(l2, by2);
        return l2;
    }

    public ByteBuffer bytes(byte by2) {
        return this.malloc(1, 1).put(0, by2);
    }

    public ByteBuffer bytes(byte by2, byte by3) {
        return this.malloc(1, 2).put(0, by2).put(1, by3);
    }

    public ByteBuffer bytes(byte by2, byte by3, byte by4) {
        return this.malloc(1, 3).put(0, by2).put(1, by3).put(2, by4);
    }

    public ByteBuffer bytes(byte by2, byte by3, byte by4, byte by5) {
        return this.malloc(1, 4).put(0, by2).put(1, by3).put(2, by4).put(3, by5);
    }

    public ByteBuffer bytes(byte ... byArray) {
        ByteBuffer byteBuffer = this.malloc(1, byArray.length).put(byArray);
        byteBuffer.flip();
        return byteBuffer;
    }

    public ShortBuffer mallocShort(int n2) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_SHORT, this.nmalloc(2, n2 << 1), n2);
    }

    public ShortBuffer callocShort(int n2) {
        int n3 = n2 * 2;
        long l2 = this.nmalloc(2, n3);
        MemoryUtil.memSet(l2, 0, n3);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_SHORT, l2, n2);
    }

    public long nshort(short s2) {
        long l2 = this.nmalloc(2, 2);
        MemoryUtil.memPutShort(l2, s2);
        return l2;
    }

    public ShortBuffer shorts(short s2) {
        return this.mallocShort(1).put(0, s2);
    }

    public ShortBuffer shorts(short s2, short s3) {
        return this.mallocShort(2).put(0, s2).put(1, s3);
    }

    public ShortBuffer shorts(short s2, short s3, short s4) {
        return this.mallocShort(3).put(0, s2).put(1, s3).put(2, s4);
    }

    public ShortBuffer shorts(short s2, short s3, short s4, short s5) {
        return this.mallocShort(4).put(0, s2).put(1, s3).put(2, s4).put(3, s5);
    }

    public ShortBuffer shorts(short ... sArray) {
        ShortBuffer shortBuffer = this.mallocShort(sArray.length).put(sArray);
        shortBuffer.flip();
        return shortBuffer;
    }

    public IntBuffer mallocInt(int n2) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_INT, this.nmalloc(4, n2 << 2), n2);
    }

    public IntBuffer callocInt(int n2) {
        int n3 = n2 * 4;
        long l2 = this.nmalloc(4, n3);
        MemoryUtil.memSet(l2, 0, n3);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_INT, l2, n2);
    }

    public long nint(int n2) {
        long l2 = this.nmalloc(4, 4);
        MemoryUtil.memPutInt(l2, n2);
        return l2;
    }

    public IntBuffer ints(int n2) {
        return this.mallocInt(1).put(0, n2);
    }

    public IntBuffer ints(int n2, int n3) {
        return this.mallocInt(2).put(0, n2).put(1, n3);
    }

    public IntBuffer ints(int n2, int n3, int n4) {
        return this.mallocInt(3).put(0, n2).put(1, n3).put(2, n4);
    }

    public IntBuffer ints(int n2, int n3, int n4, int n5) {
        return this.mallocInt(4).put(0, n2).put(1, n3).put(2, n4).put(3, n5);
    }

    public IntBuffer ints(int ... nArray) {
        IntBuffer intBuffer = this.mallocInt(nArray.length).put(nArray);
        intBuffer.flip();
        return intBuffer;
    }

    public LongBuffer mallocLong(int n2) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_LONG, this.nmalloc(8, n2 << 3), n2);
    }

    public LongBuffer callocLong(int n2) {
        int n3 = n2 * 8;
        long l2 = this.nmalloc(8, n3);
        MemoryUtil.memSet(l2, 0, n3);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_LONG, l2, n2);
    }

    public long nlong(long l2) {
        long l3 = this.nmalloc(8, 8);
        MemoryUtil.memPutLong(l3, l2);
        return l3;
    }

    public LongBuffer longs(long l2) {
        return this.mallocLong(1).put(0, l2);
    }

    public LongBuffer longs(long l2, long l3) {
        return this.mallocLong(2).put(0, l2).put(1, l3);
    }

    public LongBuffer longs(long l2, long l3, long l4) {
        return this.mallocLong(3).put(0, l2).put(1, l3).put(2, l4);
    }

    public LongBuffer longs(long l2, long l3, long l4, long l5) {
        return this.mallocLong(4).put(0, l2).put(1, l3).put(2, l4).put(3, l5);
    }

    public LongBuffer longs(long ... lArray) {
        LongBuffer longBuffer = this.mallocLong(lArray.length).put(lArray);
        longBuffer.flip();
        return longBuffer;
    }

    public CLongBuffer mallocCLong(int n2) {
        return MemoryStack.wrap(CLongBuffer.class, this.nmalloc(CLONG_SIZE, n2 << CLONG_SHIFT), n2);
    }

    public CLongBuffer callocCLong(int n2) {
        int n3 = n2 * CLONG_SIZE;
        long l2 = this.nmalloc(CLONG_SIZE, n3);
        MemoryUtil.memSet(l2, 0, n3);
        return MemoryStack.wrap(CLongBuffer.class, l2, n2);
    }

    public long nclong(long l2) {
        long l3 = this.nmalloc(CLONG_SIZE, CLONG_SIZE);
        MemoryUtil.memPutCLong(l3, l2);
        return l3;
    }

    public CLongBuffer clongs(long l2) {
        return this.mallocCLong(1).put(0, l2);
    }

    public CLongBuffer clongs(long l2, long l3) {
        return this.mallocCLong(2).put(0, l2).put(1, l3);
    }

    public CLongBuffer clongs(long l2, long l3, long l4) {
        return this.mallocCLong(3).put(0, l2).put(1, l3).put(2, l4);
    }

    public CLongBuffer clongs(long l2, long l3, long l4, long l5) {
        return this.mallocCLong(4).put(0, l2).put(1, l3).put(2, l4).put(3, l5);
    }

    public CLongBuffer clongs(long ... lArray) {
        CLongBuffer cLongBuffer = this.mallocCLong(lArray.length).put(lArray);
        cLongBuffer.flip();
        return cLongBuffer;
    }

    public FloatBuffer mallocFloat(int n2) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_FLOAT, this.nmalloc(4, n2 << 2), n2);
    }

    public FloatBuffer callocFloat(int n2) {
        int n3 = n2 * 4;
        long l2 = this.nmalloc(4, n3);
        MemoryUtil.memSet(l2, 0, n3);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_FLOAT, l2, n2);
    }

    public long nfloat(float f2) {
        long l2 = this.nmalloc(4, 4);
        MemoryUtil.memPutFloat(l2, f2);
        return l2;
    }

    public FloatBuffer floats(float f2) {
        return this.mallocFloat(1).put(0, f2);
    }

    public FloatBuffer floats(float f2, float f3) {
        return this.mallocFloat(2).put(0, f2).put(1, f3);
    }

    public FloatBuffer floats(float f2, float f3, float f4) {
        return this.mallocFloat(3).put(0, f2).put(1, f3).put(2, f4);
    }

    public FloatBuffer floats(float f2, float f3, float f4, float f5) {
        return this.mallocFloat(4).put(0, f2).put(1, f3).put(2, f4).put(3, f5);
    }

    public FloatBuffer floats(float ... fArray) {
        FloatBuffer floatBuffer = this.mallocFloat(fArray.length).put(fArray);
        floatBuffer.flip();
        return floatBuffer;
    }

    public DoubleBuffer mallocDouble(int n2) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_DOUBLE, this.nmalloc(8, n2 << 3), n2);
    }

    public DoubleBuffer callocDouble(int n2) {
        int n3 = n2 * 8;
        long l2 = this.nmalloc(8, n3);
        MemoryUtil.memSet(l2, 0, n3);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_DOUBLE, l2, n2);
    }

    public long ndouble(double d2) {
        long l2 = this.nmalloc(8, 8);
        MemoryUtil.memPutDouble(l2, d2);
        return l2;
    }

    public DoubleBuffer doubles(double d2) {
        return this.mallocDouble(1).put(0, d2);
    }

    public DoubleBuffer doubles(double d2, double d3) {
        return this.mallocDouble(2).put(0, d2).put(1, d3);
    }

    public DoubleBuffer doubles(double d2, double d3, double d4) {
        return this.mallocDouble(3).put(0, d2).put(1, d3).put(2, d4);
    }

    public DoubleBuffer doubles(double d2, double d3, double d4, double d5) {
        return this.mallocDouble(4).put(0, d2).put(1, d3).put(2, d4).put(3, d5);
    }

    public DoubleBuffer doubles(double ... dArray) {
        DoubleBuffer doubleBuffer = this.mallocDouble(dArray.length).put(dArray);
        doubleBuffer.flip();
        return doubleBuffer;
    }

    public PointerBuffer mallocPointer(int n2) {
        return MemoryStack.wrap(PointerBuffer.class, this.nmalloc(POINTER_SIZE, n2 << POINTER_SHIFT), n2);
    }

    public PointerBuffer callocPointer(int n2) {
        int n3 = n2 * POINTER_SIZE;
        long l2 = this.nmalloc(POINTER_SIZE, n3);
        MemoryUtil.memSet(l2, 0, n3);
        return MemoryStack.wrap(PointerBuffer.class, l2, n2);
    }

    public long npointer(long l2) {
        long l3 = this.nmalloc(POINTER_SIZE, POINTER_SIZE);
        MemoryUtil.memPutAddress(l3, l2);
        return l3;
    }

    public PointerBuffer pointers(long l2) {
        return this.mallocPointer(1).put(0, l2);
    }

    public PointerBuffer pointers(long l2, long l3) {
        return this.mallocPointer(2).put(0, l2).put(1, l3);
    }

    public PointerBuffer pointers(long l2, long l3, long l4) {
        return this.mallocPointer(3).put(0, l2).put(1, l3).put(2, l4);
    }

    public PointerBuffer pointers(long l2, long l3, long l4, long l5) {
        return this.mallocPointer(4).put(0, l2).put(1, l3).put(2, l4).put(3, l5);
    }

    public PointerBuffer pointers(long ... lArray) {
        PointerBuffer pointerBuffer = this.mallocPointer(lArray.length).put(lArray);
        pointerBuffer.flip();
        return pointerBuffer;
    }

    public long npointer(Pointer pointer) {
        long l2 = this.nmalloc(POINTER_SIZE, POINTER_SIZE);
        MemoryUtil.memPutAddress(l2, pointer.address());
        return l2;
    }

    public PointerBuffer pointers(Pointer pointer) {
        return this.mallocPointer(1).put(0, pointer);
    }

    public PointerBuffer pointers(Pointer pointer, Pointer pointer2) {
        return this.mallocPointer(2).put(0, pointer).put(1, pointer2);
    }

    public PointerBuffer pointers(Pointer pointer, Pointer pointer2, Pointer pointer3) {
        return this.mallocPointer(3).put(0, pointer).put(1, pointer2).put(2, pointer3);
    }

    public PointerBuffer pointers(Pointer pointer, Pointer pointer2, Pointer pointer3, Pointer pointer4) {
        return this.mallocPointer(4).put(0, pointer).put(1, pointer2).put(2, pointer3).put(3, pointer4);
    }

    public PointerBuffer pointers(Pointer ... pointerArray) {
        PointerBuffer pointerBuffer = this.mallocPointer(pointerArray.length);
        for (int i2 = 0; i2 < pointerArray.length; ++i2) {
            pointerBuffer.put(i2, pointerArray[i2]);
        }
        return pointerBuffer;
    }

    public long npointer(Buffer buffer) {
        long l2 = this.nmalloc(POINTER_SIZE, POINTER_SIZE);
        MemoryUtil.memPutAddress(l2, MemoryUtil.memAddress(buffer));
        return l2;
    }

    public PointerBuffer pointers(Buffer buffer) {
        return this.mallocPointer(1).put(0, MemoryUtil.memAddress(buffer));
    }

    public PointerBuffer pointers(Buffer buffer, Buffer buffer2) {
        return this.mallocPointer(2).put(0, MemoryUtil.memAddress(buffer)).put(1, MemoryUtil.memAddress(buffer2));
    }

    public PointerBuffer pointers(Buffer buffer, Buffer buffer2, Buffer buffer3) {
        return this.mallocPointer(3).put(0, MemoryUtil.memAddress(buffer)).put(1, MemoryUtil.memAddress(buffer2)).put(2, MemoryUtil.memAddress(buffer3));
    }

    public PointerBuffer pointers(Buffer buffer, Buffer buffer2, Buffer buffer3, Buffer buffer4) {
        return this.mallocPointer(4).put(0, MemoryUtil.memAddress(buffer)).put(1, MemoryUtil.memAddress(buffer2)).put(2, MemoryUtil.memAddress(buffer3)).put(3, MemoryUtil.memAddress(buffer4));
    }

    public PointerBuffer pointers(Buffer ... bufferArray) {
        PointerBuffer pointerBuffer = this.mallocPointer(bufferArray.length);
        for (int i2 = 0; i2 < bufferArray.length; ++i2) {
            pointerBuffer.put(i2, MemoryUtil.memAddress(bufferArray[i2]));
        }
        return pointerBuffer;
    }

    public ByteBuffer ASCII(CharSequence charSequence) {
        return this.ASCII(charSequence, true);
    }

    public ByteBuffer ASCII(CharSequence charSequence, boolean bl2) {
        int n2 = MemoryUtil.memLengthASCII(charSequence, bl2);
        long l2 = this.nmalloc(POINTER_SIZE, n2);
        MemoryUtil.encodeASCIIUnsafe(charSequence, bl2, l2);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, l2, n2).order(MemoryUtil.NATIVE_ORDER);
    }

    public int nASCII(CharSequence charSequence, boolean bl2) {
        long l2 = this.nmalloc(POINTER_SIZE, MemoryUtil.memLengthASCII(charSequence, bl2));
        return MemoryUtil.encodeASCIIUnsafe(charSequence, bl2, l2);
    }

    @Nullable
    public ByteBuffer ASCIISafe(@Nullable CharSequence charSequence) {
        return this.ASCIISafe(charSequence, true);
    }

    @Nullable
    public ByteBuffer ASCIISafe(@Nullable CharSequence charSequence, boolean bl2) {
        return charSequence == null ? null : this.ASCII(charSequence, bl2);
    }

    public int nASCIISafe(@Nullable CharSequence charSequence, boolean bl2) {
        return charSequence == null ? 0 : this.nASCII(charSequence, bl2);
    }

    public ByteBuffer UTF8(CharSequence charSequence) {
        return this.UTF8(charSequence, true);
    }

    public ByteBuffer UTF8(CharSequence charSequence, boolean bl2) {
        int n2 = MemoryUtil.memLengthUTF8(charSequence, bl2);
        long l2 = this.nmalloc(POINTER_SIZE, n2);
        MemoryUtil.encodeUTF8Unsafe(charSequence, bl2, l2);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, l2, n2).order(MemoryUtil.NATIVE_ORDER);
    }

    public int nUTF8(CharSequence charSequence, boolean bl2) {
        long l2 = this.nmalloc(POINTER_SIZE, MemoryUtil.memLengthUTF8(charSequence, bl2));
        return MemoryUtil.encodeUTF8Unsafe(charSequence, bl2, l2);
    }

    @Nullable
    public ByteBuffer UTF8Safe(@Nullable CharSequence charSequence) {
        return this.UTF8Safe(charSequence, true);
    }

    @Nullable
    public ByteBuffer UTF8Safe(@Nullable CharSequence charSequence, boolean bl2) {
        return charSequence == null ? null : this.UTF8(charSequence, bl2);
    }

    public int nUTF8Safe(@Nullable CharSequence charSequence, boolean bl2) {
        return charSequence == null ? 0 : this.nUTF8(charSequence, bl2);
    }

    public ByteBuffer UTF16(CharSequence charSequence) {
        return this.UTF16(charSequence, true);
    }

    public ByteBuffer UTF16(CharSequence charSequence, boolean bl2) {
        int n2 = MemoryUtil.memLengthUTF16(charSequence, bl2);
        long l2 = this.nmalloc(POINTER_SIZE, n2);
        MemoryUtil.encodeUTF16Unsafe(charSequence, bl2, l2);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, l2, n2).order(MemoryUtil.NATIVE_ORDER);
    }

    public int nUTF16(CharSequence charSequence, boolean bl2) {
        long l2 = this.nmalloc(POINTER_SIZE, MemoryUtil.memLengthUTF16(charSequence, bl2));
        return MemoryUtil.encodeUTF16Unsafe(charSequence, bl2, l2);
    }

    @Nullable
    public ByteBuffer UTF16Safe(@Nullable CharSequence charSequence) {
        return this.UTF16Safe(charSequence, true);
    }

    @Nullable
    public ByteBuffer UTF16Safe(@Nullable CharSequence charSequence, boolean bl2) {
        return charSequence == null ? null : this.UTF16(charSequence, bl2);
    }

    public int nUTF16Safe(@Nullable CharSequence charSequence, boolean bl2) {
        return charSequence == null ? 0 : this.nUTF16(charSequence, bl2);
    }

    public static MemoryStack stackGet() {
        return TLS.get();
    }

    public static MemoryStack stackPush() {
        return MemoryStack.stackGet().push();
    }

    public static MemoryStack stackPop() {
        return MemoryStack.stackGet().pop();
    }

    public static long nstackMalloc(int n2) {
        return MemoryStack.stackGet().nmalloc(n2);
    }

    public static long nstackMalloc(int n2, int n3) {
        return MemoryStack.stackGet().nmalloc(n2, n3);
    }

    public static long nstackCalloc(int n2, int n3, int n4) {
        return MemoryStack.stackGet().ncalloc(n2, n3, n4);
    }

    public static ByteBuffer stackMalloc(int n2) {
        return MemoryStack.stackGet().malloc(n2);
    }

    public static ByteBuffer stackCalloc(int n2) {
        return MemoryStack.stackGet().calloc(n2);
    }

    public static ByteBuffer stackBytes(byte by2) {
        return MemoryStack.stackGet().bytes(by2);
    }

    public static ByteBuffer stackBytes(byte by2, byte by3) {
        return MemoryStack.stackGet().bytes(by2, by3);
    }

    public static ByteBuffer stackBytes(byte by2, byte by3, byte by4) {
        return MemoryStack.stackGet().bytes(by2, by3, by4);
    }

    public static ByteBuffer stackBytes(byte by2, byte by3, byte by4, byte by5) {
        return MemoryStack.stackGet().bytes(by2, by3, by4, by5);
    }

    public static ByteBuffer stackBytes(byte ... byArray) {
        return MemoryStack.stackGet().bytes(byArray);
    }

    public static ShortBuffer stackMallocShort(int n2) {
        return MemoryStack.stackGet().mallocShort(n2);
    }

    public static ShortBuffer stackCallocShort(int n2) {
        return MemoryStack.stackGet().callocShort(n2);
    }

    public static ShortBuffer stackShorts(short s2) {
        return MemoryStack.stackGet().shorts(s2);
    }

    public static ShortBuffer stackShorts(short s2, short s3) {
        return MemoryStack.stackGet().shorts(s2, s3);
    }

    public static ShortBuffer stackShorts(short s2, short s3, short s4) {
        return MemoryStack.stackGet().shorts(s2, s3, s4);
    }

    public static ShortBuffer stackShorts(short s2, short s3, short s4, short s5) {
        return MemoryStack.stackGet().shorts(s2, s3, s4, s5);
    }

    public static ShortBuffer stackShorts(short ... sArray) {
        return MemoryStack.stackGet().shorts(sArray);
    }

    public static IntBuffer stackMallocInt(int n2) {
        return MemoryStack.stackGet().mallocInt(n2);
    }

    public static IntBuffer stackCallocInt(int n2) {
        return MemoryStack.stackGet().callocInt(n2);
    }

    public static IntBuffer stackInts(int n2) {
        return MemoryStack.stackGet().ints(n2);
    }

    public static IntBuffer stackInts(int n2, int n3) {
        return MemoryStack.stackGet().ints(n2, n3);
    }

    public static IntBuffer stackInts(int n2, int n3, int n4) {
        return MemoryStack.stackGet().ints(n2, n3, n4);
    }

    public static IntBuffer stackInts(int n2, int n3, int n4, int n5) {
        return MemoryStack.stackGet().ints(n2, n3, n4, n5);
    }

    public static IntBuffer stackInts(int ... nArray) {
        return MemoryStack.stackGet().ints(nArray);
    }

    public static LongBuffer stackMallocLong(int n2) {
        return MemoryStack.stackGet().mallocLong(n2);
    }

    public static LongBuffer stackCallocLong(int n2) {
        return MemoryStack.stackGet().callocLong(n2);
    }

    public static LongBuffer stackLongs(long l2) {
        return MemoryStack.stackGet().longs(l2);
    }

    public static LongBuffer stackLongs(long l2, long l3) {
        return MemoryStack.stackGet().longs(l2, l3);
    }

    public static LongBuffer stackLongs(long l2, long l3, long l4) {
        return MemoryStack.stackGet().longs(l2, l3, l4);
    }

    public static LongBuffer stackLongs(long l2, long l3, long l4, long l5) {
        return MemoryStack.stackGet().longs(l2, l3, l4, l5);
    }

    public static LongBuffer stackLongs(long ... lArray) {
        return MemoryStack.stackGet().longs(lArray);
    }

    public static CLongBuffer stackMallocCLong(int n2) {
        return MemoryStack.stackGet().mallocCLong(n2);
    }

    public static CLongBuffer stackCallocCLong(int n2) {
        return MemoryStack.stackGet().callocCLong(n2);
    }

    public static CLongBuffer stackCLongs(long l2) {
        return MemoryStack.stackGet().clongs(l2);
    }

    public static CLongBuffer stackCLongs(long l2, long l3) {
        return MemoryStack.stackGet().clongs(l2, l3);
    }

    public static CLongBuffer stackCLongs(long l2, long l3, long l4) {
        return MemoryStack.stackGet().clongs(l2, l3, l4);
    }

    public static CLongBuffer stackCLongs(long l2, long l3, long l4, long l5) {
        return MemoryStack.stackGet().clongs(l2, l3, l4, l5);
    }

    public static CLongBuffer stackCLongs(long ... lArray) {
        return MemoryStack.stackGet().clongs(lArray);
    }

    public static FloatBuffer stackMallocFloat(int n2) {
        return MemoryStack.stackGet().mallocFloat(n2);
    }

    public static FloatBuffer stackCallocFloat(int n2) {
        return MemoryStack.stackGet().callocFloat(n2);
    }

    public static FloatBuffer stackFloats(float f2) {
        return MemoryStack.stackGet().floats(f2);
    }

    public static FloatBuffer stackFloats(float f2, float f3) {
        return MemoryStack.stackGet().floats(f2, f3);
    }

    public static FloatBuffer stackFloats(float f2, float f3, float f4) {
        return MemoryStack.stackGet().floats(f2, f3, f4);
    }

    public static FloatBuffer stackFloats(float f2, float f3, float f4, float f5) {
        return MemoryStack.stackGet().floats(f2, f3, f4, f5);
    }

    public static FloatBuffer stackFloats(float ... fArray) {
        return MemoryStack.stackGet().floats(fArray);
    }

    public static DoubleBuffer stackMallocDouble(int n2) {
        return MemoryStack.stackGet().mallocDouble(n2);
    }

    public static DoubleBuffer stackCallocDouble(int n2) {
        return MemoryStack.stackGet().callocDouble(n2);
    }

    public static DoubleBuffer stackDoubles(double d2) {
        return MemoryStack.stackGet().doubles(d2);
    }

    public static DoubleBuffer stackDoubles(double d2, double d3) {
        return MemoryStack.stackGet().doubles(d2, d3);
    }

    public static DoubleBuffer stackDoubles(double d2, double d3, double d4) {
        return MemoryStack.stackGet().doubles(d2, d3, d4);
    }

    public static DoubleBuffer stackDoubles(double d2, double d3, double d4, double d5) {
        return MemoryStack.stackGet().doubles(d2, d3, d4, d5);
    }

    public static DoubleBuffer stackDoubles(double ... dArray) {
        return MemoryStack.stackGet().doubles(dArray);
    }

    public static PointerBuffer stackMallocPointer(int n2) {
        return MemoryStack.stackGet().mallocPointer(n2);
    }

    public static PointerBuffer stackCallocPointer(int n2) {
        return MemoryStack.stackGet().callocPointer(n2);
    }

    public static PointerBuffer stackPointers(long l2) {
        return MemoryStack.stackGet().pointers(l2);
    }

    public static PointerBuffer stackPointers(long l2, long l3) {
        return MemoryStack.stackGet().pointers(l2, l3);
    }

    public static PointerBuffer stackPointers(long l2, long l3, long l4) {
        return MemoryStack.stackGet().pointers(l2, l3, l4);
    }

    public static PointerBuffer stackPointers(long l2, long l3, long l4, long l5) {
        return MemoryStack.stackGet().pointers(l2, l3, l4, l5);
    }

    public static PointerBuffer stackPointers(long ... lArray) {
        return MemoryStack.stackGet().pointers(lArray);
    }

    public static PointerBuffer stackPointers(Pointer pointer) {
        return MemoryStack.stackGet().pointers(pointer);
    }

    public static PointerBuffer stackPointers(Pointer pointer, Pointer pointer2) {
        return MemoryStack.stackGet().pointers(pointer, pointer2);
    }

    public static PointerBuffer stackPointers(Pointer pointer, Pointer pointer2, Pointer pointer3) {
        return MemoryStack.stackGet().pointers(pointer, pointer2, pointer3);
    }

    public static PointerBuffer stackPointers(Pointer pointer, Pointer pointer2, Pointer pointer3, Pointer pointer4) {
        return MemoryStack.stackGet().pointers(pointer, pointer2, pointer3, pointer4);
    }

    public static PointerBuffer stackPointers(Pointer ... pointerArray) {
        return MemoryStack.stackGet().pointers(pointerArray);
    }

    public static ByteBuffer stackASCII(CharSequence charSequence) {
        return MemoryStack.stackGet().ASCII(charSequence);
    }

    public static ByteBuffer stackASCII(CharSequence charSequence, boolean bl2) {
        return MemoryStack.stackGet().ASCII(charSequence, bl2);
    }

    public static ByteBuffer stackUTF8(CharSequence charSequence) {
        return MemoryStack.stackGet().UTF8(charSequence);
    }

    public static ByteBuffer stackUTF8(CharSequence charSequence, boolean bl2) {
        return MemoryStack.stackGet().UTF8(charSequence, bl2);
    }

    public static ByteBuffer stackUTF16(CharSequence charSequence) {
        return MemoryStack.stackGet().UTF16(charSequence);
    }

    public static ByteBuffer stackUTF16(CharSequence charSequence, boolean bl2) {
        return MemoryStack.stackGet().UTF16(charSequence, bl2);
    }

    @Nullable
    public static ByteBuffer stackASCIISafe(@Nullable CharSequence charSequence) {
        return MemoryStack.stackGet().ASCIISafe(charSequence);
    }

    @Nullable
    public static ByteBuffer stackASCIISafe(@Nullable CharSequence charSequence, boolean bl2) {
        return MemoryStack.stackGet().ASCIISafe(charSequence, bl2);
    }

    @Nullable
    public static ByteBuffer stackUTF8Safe(@Nullable CharSequence charSequence) {
        return MemoryStack.stackGet().UTF8Safe(charSequence);
    }

    @Nullable
    public static ByteBuffer stackUTF8Safe(@Nullable CharSequence charSequence, boolean bl2) {
        return MemoryStack.stackGet().UTF8Safe(charSequence, bl2);
    }

    @Nullable
    public static ByteBuffer stackUTF16Safe(@Nullable CharSequence charSequence) {
        return MemoryStack.stackGet().UTF16Safe(charSequence);
    }

    @Nullable
    public static ByteBuffer stackUTF16Safe(@Nullable CharSequence charSequence, boolean bl2) {
        return MemoryStack.stackGet().UTF16Safe(charSequence, bl2);
    }

    static {
        if (DEFAULT_STACK_SIZE < 0) {
            throw new IllegalStateException("Invalid stack size.");
        }
    }

    static class DebugMemoryStack
    extends MemoryStack {
        private Object[] debugFrames = new Object[8];

        DebugMemoryStack(@Nullable ByteBuffer byteBuffer, long l2, int n2) {
            super(byteBuffer, l2, n2);
        }

        @Override
        public MemoryStack push() {
            if (this.frameIndex == this.debugFrames.length) {
                this.frameOverflow();
            }
            this.debugFrames[this.frameIndex] = StackWalkUtil.stackWalkGetMethod(MemoryStack.class);
            return super.push();
        }

        @Override
        private void frameOverflow() {
            this.debugFrames = Arrays.copyOf(this.debugFrames, this.debugFrames.length * 3 / 2);
        }

        @Override
        public MemoryStack pop() {
            Object object = this.debugFrames[this.frameIndex - 1];
            Object object2 = StackWalkUtil.stackWalkCheckPop(MemoryStack.class, object);
            if (object2 != null) {
                DebugMemoryStack.reportAsymmetricPop(object, object2);
            }
            this.debugFrames[this.frameIndex - 1] = null;
            return super.pop();
        }

        private static void reportAsymmetricPop(Object object, Object object2) {
            APIUtil.DEBUG_STREAM.format("[LWJGL] Asymmetric pop detected:\n\tPUSHED: %s\n\tPOPPED: %s\n\tTHREAD: %s\n", object, object2, Thread.currentThread());
        }
    }
}

