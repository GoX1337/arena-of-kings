/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_getevents_arg")
public class IOURingGeteventsArg
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SIGMASK;
    public static final int SIGMASK_SZ;
    public static final int PAD;
    public static final int TS;

    public IOURingGeteventsArg(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingGeteventsArg.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long sigmask() {
        return IOURingGeteventsArg.nsigmask(this.address());
    }

    @NativeType(value="__u32")
    public int sigmask_sz() {
        return IOURingGeteventsArg.nsigmask_sz(this.address());
    }

    @NativeType(value="__u32")
    public int pad() {
        return IOURingGeteventsArg.npad(this.address());
    }

    @NativeType(value="__u64")
    public long ts() {
        return IOURingGeteventsArg.nts(this.address());
    }

    public IOURingGeteventsArg sigmask(@NativeType(value="__u64") long l2) {
        IOURingGeteventsArg.nsigmask(this.address(), l2);
        return this;
    }

    public IOURingGeteventsArg sigmask_sz(@NativeType(value="__u32") int n2) {
        IOURingGeteventsArg.nsigmask_sz(this.address(), n2);
        return this;
    }

    public IOURingGeteventsArg pad(@NativeType(value="__u32") int n2) {
        IOURingGeteventsArg.npad(this.address(), n2);
        return this;
    }

    public IOURingGeteventsArg ts(@NativeType(value="__u64") long l2) {
        IOURingGeteventsArg.nts(this.address(), l2);
        return this;
    }

    public IOURingGeteventsArg set(long l2, int n2, int n3, long l3) {
        this.sigmask(l2);
        this.sigmask_sz(n2);
        this.pad(n3);
        this.ts(l3);
        return this;
    }

    public IOURingGeteventsArg set(IOURingGeteventsArg iOURingGeteventsArg) {
        MemoryUtil.memCopy(iOURingGeteventsArg.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingGeteventsArg malloc() {
        return IOURingGeteventsArg.wrap(IOURingGeteventsArg.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURingGeteventsArg calloc() {
        return IOURingGeteventsArg.wrap(IOURingGeteventsArg.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURingGeteventsArg create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURingGeteventsArg.wrap(IOURingGeteventsArg.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingGeteventsArg create(long l2) {
        return IOURingGeteventsArg.wrap(IOURingGeteventsArg.class, l2);
    }

    @Nullable
    public static IOURingGeteventsArg createSafe(long l2) {
        return l2 == 0L ? null : IOURingGeteventsArg.wrap(IOURingGeteventsArg.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURingGeteventsArg.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURingGeteventsArg.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURingGeteventsArg.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURingGeteventsArg.__create(n2, SIZEOF);
        return IOURingGeteventsArg.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURingGeteventsArg.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURingGeteventsArg.wrap(Buffer.class, l2, n2);
    }

    public static IOURingGeteventsArg malloc(MemoryStack memoryStack) {
        return IOURingGeteventsArg.wrap(IOURingGeteventsArg.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURingGeteventsArg calloc(MemoryStack memoryStack) {
        return IOURingGeteventsArg.wrap(IOURingGeteventsArg.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURingGeteventsArg.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURingGeteventsArg.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static long nsigmask(long l2) {
        return UNSAFE.getLong(null, l2 + (long)SIGMASK);
    }

    public static int nsigmask_sz(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SIGMASK_SZ);
    }

    public static int npad(long l2) {
        return UNSAFE.getInt(null, l2 + (long)PAD);
    }

    public static long nts(long l2) {
        return UNSAFE.getLong(null, l2 + (long)TS);
    }

    public static void nsigmask(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)SIGMASK, l3);
    }

    public static void nsigmask_sz(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SIGMASK_SZ, n2);
    }

    public static void npad(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)PAD, n2);
    }

    public static void nts(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)TS, l3);
    }

    static {
        Struct.Layout layout = IOURingGeteventsArg.__struct(IOURingGeteventsArg.__member(8), IOURingGeteventsArg.__member(4), IOURingGeteventsArg.__member(4), IOURingGeteventsArg.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        SIGMASK = layout.offsetof(0);
        SIGMASK_SZ = layout.offsetof(1);
        PAD = layout.offsetof(2);
        TS = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingGeteventsArg, Buffer>
    implements NativeResource {
        private static final IOURingGeteventsArg ELEMENT_FACTORY = IOURingGeteventsArg.create(-1L);

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
        protected IOURingGeteventsArg getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long sigmask() {
            return IOURingGeteventsArg.nsigmask(this.address());
        }

        @NativeType(value="__u32")
        public int sigmask_sz() {
            return IOURingGeteventsArg.nsigmask_sz(this.address());
        }

        @NativeType(value="__u32")
        public int pad() {
            return IOURingGeteventsArg.npad(this.address());
        }

        @NativeType(value="__u64")
        public long ts() {
            return IOURingGeteventsArg.nts(this.address());
        }

        public Buffer sigmask(@NativeType(value="__u64") long l2) {
            IOURingGeteventsArg.nsigmask(this.address(), l2);
            return this;
        }

        public Buffer sigmask_sz(@NativeType(value="__u32") int n2) {
            IOURingGeteventsArg.nsigmask_sz(this.address(), n2);
            return this;
        }

        public Buffer pad(@NativeType(value="__u32") int n2) {
            IOURingGeteventsArg.npad(this.address(), n2);
            return this;
        }

        public Buffer ts(@NativeType(value="__u64") long l2) {
            IOURingGeteventsArg.nts(this.address(), l2);
            return this;
        }
    }
}

