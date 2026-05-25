/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.stb;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.stb.STBTTPackedchar;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct stbtt_pack_range")
public class STBTTPackRange
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int FONT_SIZE;
    public static final int FIRST_UNICODE_CODEPOINT_IN_RANGE;
    public static final int ARRAY_OF_UNICODE_CODEPOINTS;
    public static final int NUM_CHARS;
    public static final int CHARDATA_FOR_RANGE;
    public static final int H_OVERSAMPLE;
    public static final int V_OVERSAMPLE;

    public STBTTPackRange(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBTTPackRange.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public float font_size() {
        return STBTTPackRange.nfont_size(this.address());
    }

    public int first_unicode_codepoint_in_range() {
        return STBTTPackRange.nfirst_unicode_codepoint_in_range(this.address());
    }

    @Nullable
    @NativeType(value="int *")
    public IntBuffer array_of_unicode_codepoints() {
        return STBTTPackRange.narray_of_unicode_codepoints(this.address());
    }

    public int num_chars() {
        return STBTTPackRange.nnum_chars(this.address());
    }

    @NativeType(value="stbtt_packedchar *")
    public STBTTPackedchar.Buffer chardata_for_range() {
        return STBTTPackRange.nchardata_for_range(this.address());
    }

    @NativeType(value="unsigned char")
    public byte h_oversample() {
        return STBTTPackRange.nh_oversample(this.address());
    }

    @NativeType(value="unsigned char")
    public byte v_oversample() {
        return STBTTPackRange.nv_oversample(this.address());
    }

    public STBTTPackRange font_size(float f2) {
        STBTTPackRange.nfont_size(this.address(), f2);
        return this;
    }

    public STBTTPackRange first_unicode_codepoint_in_range(int n2) {
        STBTTPackRange.nfirst_unicode_codepoint_in_range(this.address(), n2);
        return this;
    }

    public STBTTPackRange array_of_unicode_codepoints(@Nullable @NativeType(value="int *") IntBuffer intBuffer) {
        STBTTPackRange.narray_of_unicode_codepoints(this.address(), intBuffer);
        return this;
    }

    public STBTTPackRange num_chars(int n2) {
        STBTTPackRange.nnum_chars(this.address(), n2);
        return this;
    }

    public STBTTPackRange chardata_for_range(@NativeType(value="stbtt_packedchar *") STBTTPackedchar.Buffer buffer) {
        STBTTPackRange.nchardata_for_range(this.address(), buffer);
        return this;
    }

    public STBTTPackRange h_oversample(@NativeType(value="unsigned char") byte by2) {
        STBTTPackRange.nh_oversample(this.address(), by2);
        return this;
    }

    public STBTTPackRange v_oversample(@NativeType(value="unsigned char") byte by2) {
        STBTTPackRange.nv_oversample(this.address(), by2);
        return this;
    }

    public STBTTPackRange set(float f2, int n2, @Nullable IntBuffer intBuffer, int n3, STBTTPackedchar.Buffer buffer, byte by2, byte by3) {
        this.font_size(f2);
        this.first_unicode_codepoint_in_range(n2);
        this.array_of_unicode_codepoints(intBuffer);
        this.num_chars(n3);
        this.chardata_for_range(buffer);
        this.h_oversample(by2);
        this.v_oversample(by3);
        return this;
    }

    public STBTTPackRange set(STBTTPackRange sTBTTPackRange) {
        MemoryUtil.memCopy(sTBTTPackRange.address(), this.address(), SIZEOF);
        return this;
    }

    public static STBTTPackRange malloc() {
        return STBTTPackRange.wrap(STBTTPackRange.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBTTPackRange calloc() {
        return STBTTPackRange.wrap(STBTTPackRange.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBTTPackRange create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBTTPackRange.wrap(STBTTPackRange.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBTTPackRange create(long l2) {
        return STBTTPackRange.wrap(STBTTPackRange.class, l2);
    }

    @Nullable
    public static STBTTPackRange createSafe(long l2) {
        return l2 == 0L ? null : STBTTPackRange.wrap(STBTTPackRange.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBTTPackRange.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBTTPackRange.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBTTPackRange.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBTTPackRange.__create(n2, SIZEOF);
        return STBTTPackRange.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBTTPackRange.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBTTPackRange.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static STBTTPackRange mallocStack() {
        return STBTTPackRange.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBTTPackRange callocStack() {
        return STBTTPackRange.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBTTPackRange mallocStack(MemoryStack memoryStack) {
        return STBTTPackRange.malloc(memoryStack);
    }

    @Deprecated
    public static STBTTPackRange callocStack(MemoryStack memoryStack) {
        return STBTTPackRange.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return STBTTPackRange.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return STBTTPackRange.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return STBTTPackRange.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return STBTTPackRange.calloc(n2, memoryStack);
    }

    public static STBTTPackRange malloc(MemoryStack memoryStack) {
        return STBTTPackRange.wrap(STBTTPackRange.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBTTPackRange calloc(MemoryStack memoryStack) {
        return STBTTPackRange.wrap(STBTTPackRange.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBTTPackRange.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBTTPackRange.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static float nfont_size(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)FONT_SIZE);
    }

    public static int nfirst_unicode_codepoint_in_range(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FIRST_UNICODE_CODEPOINT_IN_RANGE);
    }

    @Nullable
    public static IntBuffer narray_of_unicode_codepoints(long l2) {
        return MemoryUtil.memIntBufferSafe(MemoryUtil.memGetAddress(l2 + (long)ARRAY_OF_UNICODE_CODEPOINTS), STBTTPackRange.nnum_chars(l2));
    }

    public static int nnum_chars(long l2) {
        return UNSAFE.getInt(null, l2 + (long)NUM_CHARS);
    }

    public static STBTTPackedchar.Buffer nchardata_for_range(long l2) {
        return STBTTPackedchar.create(MemoryUtil.memGetAddress(l2 + (long)CHARDATA_FOR_RANGE), STBTTPackRange.nnum_chars(l2));
    }

    public static byte nh_oversample(long l2) {
        return UNSAFE.getByte(null, l2 + (long)H_OVERSAMPLE);
    }

    public static byte nv_oversample(long l2) {
        return UNSAFE.getByte(null, l2 + (long)V_OVERSAMPLE);
    }

    public static void nfont_size(long l2, float f2) {
        UNSAFE.putFloat(null, l2 + (long)FONT_SIZE, f2);
    }

    public static void nfirst_unicode_codepoint_in_range(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FIRST_UNICODE_CODEPOINT_IN_RANGE, n2);
    }

    public static void narray_of_unicode_codepoints(long l2, @Nullable IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)ARRAY_OF_UNICODE_CODEPOINTS, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void nnum_chars(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)NUM_CHARS, n2);
    }

    public static void nchardata_for_range(long l2, STBTTPackedchar.Buffer buffer) {
        MemoryUtil.memPutAddress(l2 + (long)CHARDATA_FOR_RANGE, buffer.address());
    }

    public static void nh_oversample(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)H_OVERSAMPLE, by2);
    }

    public static void nv_oversample(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)V_OVERSAMPLE, by2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)CHARDATA_FOR_RANGE));
    }

    static {
        Struct.Layout layout = STBTTPackRange.__struct(STBTTPackRange.__member(4), STBTTPackRange.__member(4), STBTTPackRange.__member(POINTER_SIZE), STBTTPackRange.__member(4), STBTTPackRange.__member(POINTER_SIZE), STBTTPackRange.__member(1), STBTTPackRange.__member(1));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        FONT_SIZE = layout.offsetof(0);
        FIRST_UNICODE_CODEPOINT_IN_RANGE = layout.offsetof(1);
        ARRAY_OF_UNICODE_CODEPOINTS = layout.offsetof(2);
        NUM_CHARS = layout.offsetof(3);
        CHARDATA_FOR_RANGE = layout.offsetof(4);
        H_OVERSAMPLE = layout.offsetof(5);
        V_OVERSAMPLE = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<STBTTPackRange, Buffer>
    implements NativeResource {
        private static final STBTTPackRange ELEMENT_FACTORY = STBTTPackRange.create(-1L);

        public Buffer(ByteBuffer byteBuffer) {
            super(byteBuffer, byteBuffer.remaining() / SIZEOF);
        }

        public Buffer(long l2, int n2) {
            super(l2, null, -1, 0, n2, n2);
        }

        Buffer(long l2, @Nullable ByteBuffer byteBuffer, int n2, int n3, int n4, int n5) {
            super(l2, byteBuffer, n2, n3, n4, n5);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected STBTTPackRange getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public float font_size() {
            return STBTTPackRange.nfont_size(this.address());
        }

        public int first_unicode_codepoint_in_range() {
            return STBTTPackRange.nfirst_unicode_codepoint_in_range(this.address());
        }

        @Nullable
        @NativeType(value="int *")
        public IntBuffer array_of_unicode_codepoints() {
            return STBTTPackRange.narray_of_unicode_codepoints(this.address());
        }

        public int num_chars() {
            return STBTTPackRange.nnum_chars(this.address());
        }

        @NativeType(value="stbtt_packedchar *")
        public STBTTPackedchar.Buffer chardata_for_range() {
            return STBTTPackRange.nchardata_for_range(this.address());
        }

        @NativeType(value="unsigned char")
        public byte h_oversample() {
            return STBTTPackRange.nh_oversample(this.address());
        }

        @NativeType(value="unsigned char")
        public byte v_oversample() {
            return STBTTPackRange.nv_oversample(this.address());
        }

        public Buffer font_size(float f2) {
            STBTTPackRange.nfont_size(this.address(), f2);
            return this;
        }

        public Buffer first_unicode_codepoint_in_range(int n2) {
            STBTTPackRange.nfirst_unicode_codepoint_in_range(this.address(), n2);
            return this;
        }

        public Buffer array_of_unicode_codepoints(@Nullable @NativeType(value="int *") IntBuffer intBuffer) {
            STBTTPackRange.narray_of_unicode_codepoints(this.address(), intBuffer);
            return this;
        }

        public Buffer num_chars(int n2) {
            STBTTPackRange.nnum_chars(this.address(), n2);
            return this;
        }

        public Buffer chardata_for_range(@NativeType(value="stbtt_packedchar *") STBTTPackedchar.Buffer buffer) {
            STBTTPackRange.nchardata_for_range(this.address(), buffer);
            return this;
        }

        public Buffer h_oversample(@NativeType(value="unsigned char") byte by2) {
            STBTTPackRange.nh_oversample(this.address(), by2);
            return this;
        }

        public Buffer v_oversample(@NativeType(value="unsigned char") byte by2) {
            STBTTPackRange.nv_oversample(this.address(), by2);
            return this;
        }
    }
}

