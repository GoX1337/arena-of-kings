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

public class XCreateWindowEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int PARENT;
    public static final int WINDOW;
    public static final int X;
    public static final int Y;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int BORDER_WIDTH;
    public static final int OVERRIDE_REDIRECT;

    public XCreateWindowEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XCreateWindowEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XCreateWindowEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XCreateWindowEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XCreateWindowEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XCreateWindowEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long parent() {
        return XCreateWindowEvent.nparent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XCreateWindowEvent.nwindow(this.address());
    }

    public int x() {
        return XCreateWindowEvent.nx(this.address());
    }

    public int y() {
        return XCreateWindowEvent.ny(this.address());
    }

    public int width() {
        return XCreateWindowEvent.nwidth(this.address());
    }

    public int height() {
        return XCreateWindowEvent.nheight(this.address());
    }

    public int border_width() {
        return XCreateWindowEvent.nborder_width(this.address());
    }

    public int override_redirect() {
        return XCreateWindowEvent.noverride_redirect(this.address());
    }

    public XCreateWindowEvent type(int n2) {
        XCreateWindowEvent.ntype(this.address(), n2);
        return this;
    }

    public XCreateWindowEvent serial(@NativeType(value="unsigned long") long l2) {
        XCreateWindowEvent.nserial(this.address(), l2);
        return this;
    }

    public XCreateWindowEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XCreateWindowEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XCreateWindowEvent display(@NativeType(value="Display *") long l2) {
        XCreateWindowEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XCreateWindowEvent parent(@NativeType(value="Window") long l2) {
        XCreateWindowEvent.nparent(this.address(), l2);
        return this;
    }

    public XCreateWindowEvent window(@NativeType(value="Window") long l2) {
        XCreateWindowEvent.nwindow(this.address(), l2);
        return this;
    }

    public XCreateWindowEvent x(int n2) {
        XCreateWindowEvent.nx(this.address(), n2);
        return this;
    }

    public XCreateWindowEvent y(int n2) {
        XCreateWindowEvent.ny(this.address(), n2);
        return this;
    }

    public XCreateWindowEvent width(int n2) {
        XCreateWindowEvent.nwidth(this.address(), n2);
        return this;
    }

    public XCreateWindowEvent height(int n2) {
        XCreateWindowEvent.nheight(this.address(), n2);
        return this;
    }

    public XCreateWindowEvent border_width(int n2) {
        XCreateWindowEvent.nborder_width(this.address(), n2);
        return this;
    }

    public XCreateWindowEvent override_redirect(int n2) {
        XCreateWindowEvent.noverride_redirect(this.address(), n2);
        return this;
    }

    public XCreateWindowEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.parent(l4);
        this.window(l5);
        this.x(n3);
        this.y(n4);
        this.width(n5);
        this.height(n6);
        this.border_width(n7);
        this.override_redirect(n8);
        return this;
    }

    public XCreateWindowEvent set(XCreateWindowEvent xCreateWindowEvent) {
        MemoryUtil.memCopy(xCreateWindowEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XCreateWindowEvent malloc() {
        return XCreateWindowEvent.wrap(XCreateWindowEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XCreateWindowEvent calloc() {
        return XCreateWindowEvent.wrap(XCreateWindowEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XCreateWindowEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XCreateWindowEvent.wrap(XCreateWindowEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XCreateWindowEvent create(long l2) {
        return XCreateWindowEvent.wrap(XCreateWindowEvent.class, l2);
    }

    @Nullable
    public static XCreateWindowEvent createSafe(long l2) {
        return l2 == 0L ? null : XCreateWindowEvent.wrap(XCreateWindowEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XCreateWindowEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XCreateWindowEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XCreateWindowEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XCreateWindowEvent.__create(n2, SIZEOF);
        return XCreateWindowEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XCreateWindowEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XCreateWindowEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XCreateWindowEvent mallocStack() {
        return XCreateWindowEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCreateWindowEvent callocStack() {
        return XCreateWindowEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCreateWindowEvent mallocStack(MemoryStack memoryStack) {
        return XCreateWindowEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XCreateWindowEvent callocStack(MemoryStack memoryStack) {
        return XCreateWindowEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XCreateWindowEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XCreateWindowEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XCreateWindowEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XCreateWindowEvent.calloc(n2, memoryStack);
    }

    public static XCreateWindowEvent malloc(MemoryStack memoryStack) {
        return XCreateWindowEvent.wrap(XCreateWindowEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XCreateWindowEvent calloc(MemoryStack memoryStack) {
        return XCreateWindowEvent.wrap(XCreateWindowEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XCreateWindowEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XCreateWindowEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static long nparent(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)PARENT);
    }

    public static long nwindow(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)WINDOW);
    }

    public static int nx(long l2) {
        return UNSAFE.getInt(null, l2 + (long)X);
    }

    public static int ny(long l2) {
        return UNSAFE.getInt(null, l2 + (long)Y);
    }

    public static int nwidth(long l2) {
        return UNSAFE.getInt(null, l2 + (long)WIDTH);
    }

    public static int nheight(long l2) {
        return UNSAFE.getInt(null, l2 + (long)HEIGHT);
    }

    public static int nborder_width(long l2) {
        return UNSAFE.getInt(null, l2 + (long)BORDER_WIDTH);
    }

    public static int noverride_redirect(long l2) {
        return UNSAFE.getInt(null, l2 + (long)OVERRIDE_REDIRECT);
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

    public static void nparent(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)PARENT, l3);
    }

    public static void nwindow(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)WINDOW, l3);
    }

    public static void nx(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)X, n2);
    }

    public static void ny(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)Y, n2);
    }

    public static void nwidth(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)WIDTH, n2);
    }

    public static void nheight(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)HEIGHT, n2);
    }

    public static void nborder_width(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)BORDER_WIDTH, n2);
    }

    public static void noverride_redirect(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)OVERRIDE_REDIRECT, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XCreateWindowEvent.__struct(XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(CLONG_SIZE), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(POINTER_SIZE), XCreateWindowEvent.__member(CLONG_SIZE), XCreateWindowEvent.__member(CLONG_SIZE), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        PARENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
        X = layout.offsetof(6);
        Y = layout.offsetof(7);
        WIDTH = layout.offsetof(8);
        HEIGHT = layout.offsetof(9);
        BORDER_WIDTH = layout.offsetof(10);
        OVERRIDE_REDIRECT = layout.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<XCreateWindowEvent, Buffer>
    implements NativeResource {
        private static final XCreateWindowEvent ELEMENT_FACTORY = XCreateWindowEvent.create(-1L);

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
        protected XCreateWindowEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XCreateWindowEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XCreateWindowEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XCreateWindowEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XCreateWindowEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long parent() {
            return XCreateWindowEvent.nparent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XCreateWindowEvent.nwindow(this.address());
        }

        public int x() {
            return XCreateWindowEvent.nx(this.address());
        }

        public int y() {
            return XCreateWindowEvent.ny(this.address());
        }

        public int width() {
            return XCreateWindowEvent.nwidth(this.address());
        }

        public int height() {
            return XCreateWindowEvent.nheight(this.address());
        }

        public int border_width() {
            return XCreateWindowEvent.nborder_width(this.address());
        }

        public int override_redirect() {
            return XCreateWindowEvent.noverride_redirect(this.address());
        }

        public Buffer type(int n2) {
            XCreateWindowEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XCreateWindowEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XCreateWindowEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XCreateWindowEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer parent(@NativeType(value="Window") long l2) {
            XCreateWindowEvent.nparent(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XCreateWindowEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer x(int n2) {
            XCreateWindowEvent.nx(this.address(), n2);
            return this;
        }

        public Buffer y(int n2) {
            XCreateWindowEvent.ny(this.address(), n2);
            return this;
        }

        public Buffer width(int n2) {
            XCreateWindowEvent.nwidth(this.address(), n2);
            return this;
        }

        public Buffer height(int n2) {
            XCreateWindowEvent.nheight(this.address(), n2);
            return this;
        }

        public Buffer border_width(int n2) {
            XCreateWindowEvent.nborder_width(this.address(), n2);
            return this;
        }

        public Buffer override_redirect(int n2) {
            XCreateWindowEvent.noverride_redirect(this.address(), n2);
            return this;
        }
    }
}

