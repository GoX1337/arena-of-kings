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

public class XAnyEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;

    public XAnyEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XAnyEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XAnyEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XAnyEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XAnyEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XAnyEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XAnyEvent.nwindow(this.address());
    }

    public XAnyEvent type(int n2) {
        XAnyEvent.ntype(this.address(), n2);
        return this;
    }

    public XAnyEvent serial(@NativeType(value="unsigned long") long l2) {
        XAnyEvent.nserial(this.address(), l2);
        return this;
    }

    public XAnyEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XAnyEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XAnyEvent display(@NativeType(value="Display *") long l2) {
        XAnyEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XAnyEvent window(@NativeType(value="Window") long l2) {
        XAnyEvent.nwindow(this.address(), l2);
        return this;
    }

    public XAnyEvent set(int n2, long l2, boolean bl2, long l3, long l4) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        return this;
    }

    public XAnyEvent set(XAnyEvent xAnyEvent) {
        MemoryUtil.memCopy(xAnyEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XAnyEvent malloc() {
        return XAnyEvent.wrap(XAnyEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XAnyEvent calloc() {
        return XAnyEvent.wrap(XAnyEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XAnyEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XAnyEvent.wrap(XAnyEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XAnyEvent create(long l2) {
        return XAnyEvent.wrap(XAnyEvent.class, l2);
    }

    @Nullable
    public static XAnyEvent createSafe(long l2) {
        return l2 == 0L ? null : XAnyEvent.wrap(XAnyEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XAnyEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XAnyEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XAnyEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XAnyEvent.__create(n2, SIZEOF);
        return XAnyEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XAnyEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XAnyEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XAnyEvent mallocStack() {
        return XAnyEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XAnyEvent callocStack() {
        return XAnyEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XAnyEvent mallocStack(MemoryStack memoryStack) {
        return XAnyEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XAnyEvent callocStack(MemoryStack memoryStack) {
        return XAnyEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XAnyEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XAnyEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XAnyEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XAnyEvent.calloc(n2, memoryStack);
    }

    public static XAnyEvent malloc(MemoryStack memoryStack) {
        return XAnyEvent.wrap(XAnyEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XAnyEvent calloc(MemoryStack memoryStack) {
        return XAnyEvent.wrap(XAnyEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XAnyEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XAnyEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int ntype(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TYPE);
    }

    public static long nserial(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)SERIAL);
    }

    public static int nsend_event(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SEND_EVENT);
    }

    public static long ndisplay(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)DISPLAY);
    }

    public static long nwindow(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)WINDOW);
    }

    public static void ntype(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)TYPE, n2);
    }

    public static void nserial(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)SERIAL, l3);
    }

    public static void nsend_event(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SEND_EVENT, n2);
    }

    public static void ndisplay(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)DISPLAY, Checks.check(l3));
    }

    public static void nwindow(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)WINDOW, l3);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XAnyEvent.__struct(XAnyEvent.__member(4), XAnyEvent.__member(CLONG_SIZE), XAnyEvent.__member(4), XAnyEvent.__member(POINTER_SIZE), XAnyEvent.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<XAnyEvent, Buffer>
    implements NativeResource {
        private static final XAnyEvent ELEMENT_FACTORY = XAnyEvent.create(-1L);

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
        protected XAnyEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XAnyEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XAnyEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XAnyEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XAnyEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XAnyEvent.nwindow(this.address());
        }

        public Buffer type(int n2) {
            XAnyEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XAnyEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XAnyEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XAnyEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XAnyEvent.nwindow(this.address(), l2);
            return this;
        }
    }
}

