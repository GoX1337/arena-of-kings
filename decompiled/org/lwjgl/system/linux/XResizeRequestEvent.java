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

public class XResizeRequestEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int WIDTH;
    public static final int HEIGHT;

    public XResizeRequestEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XResizeRequestEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XResizeRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XResizeRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XResizeRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XResizeRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XResizeRequestEvent.nwindow(this.address());
    }

    public int width() {
        return XResizeRequestEvent.nwidth(this.address());
    }

    public int height() {
        return XResizeRequestEvent.nheight(this.address());
    }

    public XResizeRequestEvent type(int n2) {
        XResizeRequestEvent.ntype(this.address(), n2);
        return this;
    }

    public XResizeRequestEvent serial(@NativeType(value="unsigned long") long l2) {
        XResizeRequestEvent.nserial(this.address(), l2);
        return this;
    }

    public XResizeRequestEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XResizeRequestEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XResizeRequestEvent display(@NativeType(value="Display *") long l2) {
        XResizeRequestEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XResizeRequestEvent window(@NativeType(value="Window") long l2) {
        XResizeRequestEvent.nwindow(this.address(), l2);
        return this;
    }

    public XResizeRequestEvent width(int n2) {
        XResizeRequestEvent.nwidth(this.address(), n2);
        return this;
    }

    public XResizeRequestEvent height(int n2) {
        XResizeRequestEvent.nheight(this.address(), n2);
        return this;
    }

    public XResizeRequestEvent set(int n2, long l2, boolean bl2, long l3, long l4, int n3, int n4) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        this.width(n3);
        this.height(n4);
        return this;
    }

    public XResizeRequestEvent set(XResizeRequestEvent xResizeRequestEvent) {
        MemoryUtil.memCopy(xResizeRequestEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XResizeRequestEvent malloc() {
        return XResizeRequestEvent.wrap(XResizeRequestEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XResizeRequestEvent calloc() {
        return XResizeRequestEvent.wrap(XResizeRequestEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XResizeRequestEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XResizeRequestEvent.wrap(XResizeRequestEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XResizeRequestEvent create(long l2) {
        return XResizeRequestEvent.wrap(XResizeRequestEvent.class, l2);
    }

    @Nullable
    public static XResizeRequestEvent createSafe(long l2) {
        return l2 == 0L ? null : XResizeRequestEvent.wrap(XResizeRequestEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XResizeRequestEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XResizeRequestEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XResizeRequestEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XResizeRequestEvent.__create(n2, SIZEOF);
        return XResizeRequestEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XResizeRequestEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XResizeRequestEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XResizeRequestEvent mallocStack() {
        return XResizeRequestEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XResizeRequestEvent callocStack() {
        return XResizeRequestEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XResizeRequestEvent mallocStack(MemoryStack memoryStack) {
        return XResizeRequestEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XResizeRequestEvent callocStack(MemoryStack memoryStack) {
        return XResizeRequestEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XResizeRequestEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XResizeRequestEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XResizeRequestEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XResizeRequestEvent.calloc(n2, memoryStack);
    }

    public static XResizeRequestEvent malloc(MemoryStack memoryStack) {
        return XResizeRequestEvent.wrap(XResizeRequestEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XResizeRequestEvent calloc(MemoryStack memoryStack) {
        return XResizeRequestEvent.wrap(XResizeRequestEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XResizeRequestEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XResizeRequestEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static int nwidth(long l2) {
        return UNSAFE.getInt(null, l2 + (long)WIDTH);
    }

    public static int nheight(long l2) {
        return UNSAFE.getInt(null, l2 + (long)HEIGHT);
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

    public static void nwidth(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)WIDTH, n2);
    }

    public static void nheight(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)HEIGHT, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XResizeRequestEvent.__struct(XResizeRequestEvent.__member(4), XResizeRequestEvent.__member(CLONG_SIZE), XResizeRequestEvent.__member(4), XResizeRequestEvent.__member(POINTER_SIZE), XResizeRequestEvent.__member(CLONG_SIZE), XResizeRequestEvent.__member(4), XResizeRequestEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        WIDTH = layout.offsetof(5);
        HEIGHT = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XResizeRequestEvent, Buffer>
    implements NativeResource {
        private static final XResizeRequestEvent ELEMENT_FACTORY = XResizeRequestEvent.create(-1L);

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
        protected XResizeRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XResizeRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XResizeRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XResizeRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XResizeRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XResizeRequestEvent.nwindow(this.address());
        }

        public int width() {
            return XResizeRequestEvent.nwidth(this.address());
        }

        public int height() {
            return XResizeRequestEvent.nheight(this.address());
        }

        public Buffer type(int n2) {
            XResizeRequestEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XResizeRequestEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XResizeRequestEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XResizeRequestEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XResizeRequestEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer width(int n2) {
            XResizeRequestEvent.nwidth(this.address(), n2);
            return this;
        }

        public Buffer height(int n2) {
            XResizeRequestEvent.nheight(this.address(), n2);
            return this;
        }
    }
}

