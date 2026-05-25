/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct statx_timestamp")
public class StatxTimestamp
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TV_SEC;
    public static final int TV_NSEC;
    public static final int __RESERVED;

    public StatxTimestamp(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), StatxTimestamp.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__s64")
    public long tv_sec() {
        return StatxTimestamp.ntv_sec(this.address());
    }

    @NativeType(value="__u32")
    public int tv_nsec() {
        return StatxTimestamp.ntv_nsec(this.address());
    }

    public StatxTimestamp tv_sec(@NativeType(value="__s64") long l2) {
        StatxTimestamp.ntv_sec(this.address(), l2);
        return this;
    }

    public StatxTimestamp tv_nsec(@NativeType(value="__u32") int n2) {
        StatxTimestamp.ntv_nsec(this.address(), n2);
        return this;
    }

    public StatxTimestamp set(long l2, int n2) {
        this.tv_sec(l2);
        this.tv_nsec(n2);
        return this;
    }

    public StatxTimestamp set(StatxTimestamp statxTimestamp) {
        MemoryUtil.memCopy(statxTimestamp.address(), this.address(), SIZEOF);
        return this;
    }

    public static StatxTimestamp malloc() {
        return StatxTimestamp.wrap(StatxTimestamp.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static StatxTimestamp calloc() {
        return StatxTimestamp.wrap(StatxTimestamp.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static StatxTimestamp create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return StatxTimestamp.wrap(StatxTimestamp.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static StatxTimestamp create(long l2) {
        return StatxTimestamp.wrap(StatxTimestamp.class, l2);
    }

    @Nullable
    public static StatxTimestamp createSafe(long l2) {
        return l2 == 0L ? null : StatxTimestamp.wrap(StatxTimestamp.class, l2);
    }

    public static Buffer malloc(int n2) {
        return StatxTimestamp.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(StatxTimestamp.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return StatxTimestamp.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = StatxTimestamp.__create(n2, SIZEOF);
        return StatxTimestamp.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return StatxTimestamp.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : StatxTimestamp.wrap(Buffer.class, l2, n2);
    }

    public static StatxTimestamp malloc(MemoryStack memoryStack) {
        return StatxTimestamp.wrap(StatxTimestamp.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static StatxTimestamp calloc(MemoryStack memoryStack) {
        return StatxTimestamp.wrap(StatxTimestamp.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return StatxTimestamp.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return StatxTimestamp.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static long ntv_sec(long l2) {
        return UNSAFE.getLong(null, l2 + (long)TV_SEC);
    }

    public static int ntv_nsec(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TV_NSEC);
    }

    public static int n__reserved(long l2) {
        return UNSAFE.getInt(null, l2 + (long)__RESERVED);
    }

    public static void ntv_sec(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)TV_SEC, l3);
    }

    public static void ntv_nsec(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)TV_NSEC, n2);
    }

    public static void n__reserved(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)__RESERVED, n2);
    }

    static {
        Struct.Layout layout = StatxTimestamp.__struct(StatxTimestamp.__member(8), StatxTimestamp.__member(4), StatxTimestamp.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TV_SEC = layout.offsetof(0);
        TV_NSEC = layout.offsetof(1);
        __RESERVED = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<StatxTimestamp, Buffer>
    implements NativeResource {
        private static final StatxTimestamp ELEMENT_FACTORY = StatxTimestamp.create(-1L);

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
        protected StatxTimestamp getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__s64")
        public long tv_sec() {
            return StatxTimestamp.ntv_sec(this.address());
        }

        @NativeType(value="__u32")
        public int tv_nsec() {
            return StatxTimestamp.ntv_nsec(this.address());
        }

        public Buffer tv_sec(@NativeType(value="__s64") long l2) {
            StatxTimestamp.ntv_sec(this.address(), l2);
            return this;
        }

        public Buffer tv_nsec(@NativeType(value="__u32") int n2) {
            StatxTimestamp.ntv_nsec(this.address(), n2);
            return this;
        }
    }
}

