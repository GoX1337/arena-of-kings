/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.stb;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct stb_vorbis_info")
public class STBVorbisInfo
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SAMPLE_RATE;
    public static final int CHANNELS;
    public static final int SETUP_MEMORY_REQUIRED;
    public static final int SETUP_TEMP_MEMORY_REQUIRED;
    public static final int TEMP_MEMORY_REQUIRED;
    public static final int MAX_FRAME_SIZE;

    public STBVorbisInfo(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBVorbisInfo.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned int")
    public int sample_rate() {
        return STBVorbisInfo.nsample_rate(this.address());
    }

    public int channels() {
        return STBVorbisInfo.nchannels(this.address());
    }

    @NativeType(value="unsigned int")
    public int setup_memory_required() {
        return STBVorbisInfo.nsetup_memory_required(this.address());
    }

    @NativeType(value="unsigned int")
    public int setup_temp_memory_required() {
        return STBVorbisInfo.nsetup_temp_memory_required(this.address());
    }

    @NativeType(value="unsigned int")
    public int temp_memory_required() {
        return STBVorbisInfo.ntemp_memory_required(this.address());
    }

    public int max_frame_size() {
        return STBVorbisInfo.nmax_frame_size(this.address());
    }

    public static STBVorbisInfo malloc() {
        return STBVorbisInfo.wrap(STBVorbisInfo.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBVorbisInfo calloc() {
        return STBVorbisInfo.wrap(STBVorbisInfo.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBVorbisInfo create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBVorbisInfo.wrap(STBVorbisInfo.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBVorbisInfo create(long l2) {
        return STBVorbisInfo.wrap(STBVorbisInfo.class, l2);
    }

    @Nullable
    public static STBVorbisInfo createSafe(long l2) {
        return l2 == 0L ? null : STBVorbisInfo.wrap(STBVorbisInfo.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBVorbisInfo.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBVorbisInfo.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBVorbisInfo.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBVorbisInfo.__create(n2, SIZEOF);
        return STBVorbisInfo.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBVorbisInfo.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBVorbisInfo.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static STBVorbisInfo mallocStack() {
        return STBVorbisInfo.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBVorbisInfo callocStack() {
        return STBVorbisInfo.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBVorbisInfo mallocStack(MemoryStack memoryStack) {
        return STBVorbisInfo.malloc(memoryStack);
    }

    @Deprecated
    public static STBVorbisInfo callocStack(MemoryStack memoryStack) {
        return STBVorbisInfo.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return STBVorbisInfo.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return STBVorbisInfo.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return STBVorbisInfo.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return STBVorbisInfo.calloc(n2, memoryStack);
    }

    public static STBVorbisInfo malloc(MemoryStack memoryStack) {
        return STBVorbisInfo.wrap(STBVorbisInfo.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBVorbisInfo calloc(MemoryStack memoryStack) {
        return STBVorbisInfo.wrap(STBVorbisInfo.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBVorbisInfo.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBVorbisInfo.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nsample_rate(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SAMPLE_RATE);
    }

    public static int nchannels(long l2) {
        return UNSAFE.getInt(null, l2 + (long)CHANNELS);
    }

    public static int nsetup_memory_required(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SETUP_MEMORY_REQUIRED);
    }

    public static int nsetup_temp_memory_required(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SETUP_TEMP_MEMORY_REQUIRED);
    }

    public static int ntemp_memory_required(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TEMP_MEMORY_REQUIRED);
    }

    public static int nmax_frame_size(long l2) {
        return UNSAFE.getInt(null, l2 + (long)MAX_FRAME_SIZE);
    }

    static {
        Struct.Layout layout = STBVorbisInfo.__struct(STBVorbisInfo.__member(4), STBVorbisInfo.__member(4), STBVorbisInfo.__member(4), STBVorbisInfo.__member(4), STBVorbisInfo.__member(4), STBVorbisInfo.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        SAMPLE_RATE = layout.offsetof(0);
        CHANNELS = layout.offsetof(1);
        SETUP_MEMORY_REQUIRED = layout.offsetof(2);
        SETUP_TEMP_MEMORY_REQUIRED = layout.offsetof(3);
        TEMP_MEMORY_REQUIRED = layout.offsetof(4);
        MAX_FRAME_SIZE = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<STBVorbisInfo, Buffer>
    implements NativeResource {
        private static final STBVorbisInfo ELEMENT_FACTORY = STBVorbisInfo.create(-1L);

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
        protected STBVorbisInfo getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned int")
        public int sample_rate() {
            return STBVorbisInfo.nsample_rate(this.address());
        }

        public int channels() {
            return STBVorbisInfo.nchannels(this.address());
        }

        @NativeType(value="unsigned int")
        public int setup_memory_required() {
            return STBVorbisInfo.nsetup_memory_required(this.address());
        }

        @NativeType(value="unsigned int")
        public int setup_temp_memory_required() {
            return STBVorbisInfo.nsetup_temp_memory_required(this.address());
        }

        @NativeType(value="unsigned int")
        public int temp_memory_required() {
            return STBVorbisInfo.ntemp_memory_required(this.address());
        }

        public int max_frame_size() {
            return STBVorbisInfo.nmax_frame_size(this.address());
        }
    }
}

