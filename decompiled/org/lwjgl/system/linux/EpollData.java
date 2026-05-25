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
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="union epoll_data_t")
public class EpollData
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int PTR;
    public static final int FD;
    public static final int U32;
    public static final int U64;

    public EpollData(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), EpollData.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="void *")
    public long ptr() {
        return EpollData.nptr(this.address());
    }

    public int fd() {
        return EpollData.nfd(this.address());
    }

    @NativeType(value="uint32_t")
    public int u32() {
        return EpollData.nu32(this.address());
    }

    @NativeType(value="uint64_t")
    public long u64() {
        return EpollData.nu64(this.address());
    }

    public EpollData ptr(@NativeType(value="void *") long l2) {
        EpollData.nptr(this.address(), l2);
        return this;
    }

    public EpollData fd(int n2) {
        EpollData.nfd(this.address(), n2);
        return this;
    }

    public EpollData u32(@NativeType(value="uint32_t") int n2) {
        EpollData.nu32(this.address(), n2);
        return this;
    }

    public EpollData u64(@NativeType(value="uint64_t") long l2) {
        EpollData.nu64(this.address(), l2);
        return this;
    }

    public EpollData set(EpollData epollData) {
        MemoryUtil.memCopy(epollData.address(), this.address(), SIZEOF);
        return this;
    }

    public static EpollData malloc() {
        return EpollData.wrap(EpollData.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static EpollData calloc() {
        return EpollData.wrap(EpollData.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static EpollData create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return EpollData.wrap(EpollData.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static EpollData create(long l2) {
        return EpollData.wrap(EpollData.class, l2);
    }

    @Nullable
    public static EpollData createSafe(long l2) {
        return l2 == 0L ? null : EpollData.wrap(EpollData.class, l2);
    }

    public static Buffer malloc(int n2) {
        return EpollData.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(EpollData.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return EpollData.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = EpollData.__create(n2, SIZEOF);
        return EpollData.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return EpollData.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : EpollData.wrap(Buffer.class, l2, n2);
    }

    public static EpollData malloc(MemoryStack memoryStack) {
        return EpollData.wrap(EpollData.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static EpollData calloc(MemoryStack memoryStack) {
        return EpollData.wrap(EpollData.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return EpollData.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return EpollData.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static long nptr(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)PTR);
    }

    public static int nfd(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FD);
    }

    public static int nu32(long l2) {
        return UNSAFE.getInt(null, l2 + (long)U32);
    }

    public static long nu64(long l2) {
        return UNSAFE.getLong(null, l2 + (long)U64);
    }

    public static void nptr(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)PTR, Checks.check(l3));
    }

    public static void nfd(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FD, n2);
    }

    public static void nu32(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)U32, n2);
    }

    public static void nu64(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)U64, l3);
    }

    static {
        Struct.Layout layout = EpollData.__union(EpollData.__member(POINTER_SIZE), EpollData.__member(4), EpollData.__member(4), EpollData.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        PTR = layout.offsetof(0);
        FD = layout.offsetof(1);
        U32 = layout.offsetof(2);
        U64 = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<EpollData, Buffer>
    implements NativeResource {
        private static final EpollData ELEMENT_FACTORY = EpollData.create(-1L);

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
        protected EpollData getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="void *")
        public long ptr() {
            return EpollData.nptr(this.address());
        }

        public int fd() {
            return EpollData.nfd(this.address());
        }

        @NativeType(value="uint32_t")
        public int u32() {
            return EpollData.nu32(this.address());
        }

        @NativeType(value="uint64_t")
        public long u64() {
            return EpollData.nu64(this.address());
        }

        public Buffer ptr(@NativeType(value="void *") long l2) {
            EpollData.nptr(this.address(), l2);
            return this;
        }

        public Buffer fd(int n2) {
            EpollData.nfd(this.address(), n2);
            return this;
        }

        public Buffer u32(@NativeType(value="uint32_t") int n2) {
            EpollData.nu32(this.address(), n2);
            return this;
        }

        public Buffer u64(@NativeType(value="uint64_t") long l2) {
            EpollData.nu64(this.address(), l2);
            return this;
        }
    }
}

