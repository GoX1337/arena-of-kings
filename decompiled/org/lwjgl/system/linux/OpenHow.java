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

@NativeType(value="struct open_how")
public class OpenHow
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int FLAGS;
    public static final int MODE;
    public static final int RESOLVE;

    public OpenHow(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), OpenHow.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long flags() {
        return OpenHow.nflags(this.address());
    }

    @NativeType(value="__u64")
    public long mode() {
        return OpenHow.nmode(this.address());
    }

    @NativeType(value="__u64")
    public long resolve() {
        return OpenHow.nresolve(this.address());
    }

    public OpenHow flags(@NativeType(value="__u64") long l2) {
        OpenHow.nflags(this.address(), l2);
        return this;
    }

    public OpenHow mode(@NativeType(value="__u64") long l2) {
        OpenHow.nmode(this.address(), l2);
        return this;
    }

    public OpenHow resolve(@NativeType(value="__u64") long l2) {
        OpenHow.nresolve(this.address(), l2);
        return this;
    }

    public OpenHow set(long l2, long l3, long l4) {
        this.flags(l2);
        this.mode(l3);
        this.resolve(l4);
        return this;
    }

    public OpenHow set(OpenHow openHow) {
        MemoryUtil.memCopy(openHow.address(), this.address(), SIZEOF);
        return this;
    }

    public static OpenHow malloc() {
        return OpenHow.wrap(OpenHow.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static OpenHow calloc() {
        return OpenHow.wrap(OpenHow.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static OpenHow create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return OpenHow.wrap(OpenHow.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static OpenHow create(long l2) {
        return OpenHow.wrap(OpenHow.class, l2);
    }

    @Nullable
    public static OpenHow createSafe(long l2) {
        return l2 == 0L ? null : OpenHow.wrap(OpenHow.class, l2);
    }

    public static Buffer malloc(int n2) {
        return OpenHow.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(OpenHow.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return OpenHow.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = OpenHow.__create(n2, SIZEOF);
        return OpenHow.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return OpenHow.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : OpenHow.wrap(Buffer.class, l2, n2);
    }

    public static OpenHow malloc(MemoryStack memoryStack) {
        return OpenHow.wrap(OpenHow.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static OpenHow calloc(MemoryStack memoryStack) {
        return OpenHow.wrap(OpenHow.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return OpenHow.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return OpenHow.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static long nflags(long l2) {
        return UNSAFE.getLong(null, l2 + (long)FLAGS);
    }

    public static long nmode(long l2) {
        return UNSAFE.getLong(null, l2 + (long)MODE);
    }

    public static long nresolve(long l2) {
        return UNSAFE.getLong(null, l2 + (long)RESOLVE);
    }

    public static void nflags(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)FLAGS, l3);
    }

    public static void nmode(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)MODE, l3);
    }

    public static void nresolve(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)RESOLVE, l3);
    }

    static {
        Struct.Layout layout = OpenHow.__struct(OpenHow.__member(8), OpenHow.__member(8), OpenHow.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        FLAGS = layout.offsetof(0);
        MODE = layout.offsetof(1);
        RESOLVE = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<OpenHow, Buffer>
    implements NativeResource {
        private static final OpenHow ELEMENT_FACTORY = OpenHow.create(-1L);

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
        protected OpenHow getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long flags() {
            return OpenHow.nflags(this.address());
        }

        @NativeType(value="__u64")
        public long mode() {
            return OpenHow.nmode(this.address());
        }

        @NativeType(value="__u64")
        public long resolve() {
            return OpenHow.nresolve(this.address());
        }

        public Buffer flags(@NativeType(value="__u64") long l2) {
            OpenHow.nflags(this.address(), l2);
            return this;
        }

        public Buffer mode(@NativeType(value="__u64") long l2) {
            OpenHow.nmode(this.address(), l2);
            return this;
        }

        public Buffer resolve(@NativeType(value="__u64") long l2) {
            OpenHow.nresolve(this.address(), l2);
            return this;
        }
    }
}

