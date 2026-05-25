/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.EpollData;

@NativeType(value="struct epoll_event")
public class EpollEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int EVENTS;
    public static final int DATA;

    public EpollEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), EpollEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="uint32_t")
    public int events() {
        return EpollEvent.nevents(this.address());
    }

    @NativeType(value="epoll_data_t")
    public EpollData data() {
        return EpollEvent.ndata(this.address());
    }

    public EpollEvent events(@NativeType(value="uint32_t") int n2) {
        EpollEvent.nevents(this.address(), n2);
        return this;
    }

    public EpollEvent data(@NativeType(value="epoll_data_t") EpollData epollData) {
        EpollEvent.ndata(this.address(), epollData);
        return this;
    }

    public EpollEvent data(Consumer<EpollData> consumer) {
        consumer.accept(this.data());
        return this;
    }

    public EpollEvent set(int n2, EpollData epollData) {
        this.events(n2);
        this.data(epollData);
        return this;
    }

    public EpollEvent set(EpollEvent epollEvent) {
        MemoryUtil.memCopy(epollEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static EpollEvent malloc() {
        return EpollEvent.wrap(EpollEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static EpollEvent calloc() {
        return EpollEvent.wrap(EpollEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static EpollEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return EpollEvent.wrap(EpollEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static EpollEvent create(long l2) {
        return EpollEvent.wrap(EpollEvent.class, l2);
    }

    @Nullable
    public static EpollEvent createSafe(long l2) {
        return l2 == 0L ? null : EpollEvent.wrap(EpollEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return EpollEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(EpollEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return EpollEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = EpollEvent.__create(n2, SIZEOF);
        return EpollEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return EpollEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : EpollEvent.wrap(Buffer.class, l2, n2);
    }

    public static EpollEvent malloc(MemoryStack memoryStack) {
        return EpollEvent.wrap(EpollEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static EpollEvent calloc(MemoryStack memoryStack) {
        return EpollEvent.wrap(EpollEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return EpollEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return EpollEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nevents(long l2) {
        return UNSAFE.getInt(null, l2 + (long)EVENTS);
    }

    public static EpollData ndata(long l2) {
        return EpollData.create(l2 + (long)DATA);
    }

    public static void nevents(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)EVENTS, n2);
    }

    public static void ndata(long l2, EpollData epollData) {
        MemoryUtil.memCopy(epollData.address(), l2 + (long)DATA, EpollData.SIZEOF);
    }

    static {
        Struct.Layout layout = EpollEvent.__struct(EpollEvent.__member(4), EpollEvent.__member(EpollData.SIZEOF, EpollData.ALIGNOF));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        EVENTS = layout.offsetof(0);
        DATA = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<EpollEvent, Buffer>
    implements NativeResource {
        private static final EpollEvent ELEMENT_FACTORY = EpollEvent.create(-1L);

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
        protected EpollEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="uint32_t")
        public int events() {
            return EpollEvent.nevents(this.address());
        }

        @NativeType(value="epoll_data_t")
        public EpollData data() {
            return EpollEvent.ndata(this.address());
        }

        public Buffer events(@NativeType(value="uint32_t") int n2) {
            EpollEvent.nevents(this.address(), n2);
            return this;
        }

        public Buffer data(@NativeType(value="epoll_data_t") EpollData epollData) {
            EpollEvent.ndata(this.address(), epollData);
            return this;
        }

        public Buffer data(Consumer<EpollData> consumer) {
            consumer.accept(this.data());
            return this;
        }
    }
}

