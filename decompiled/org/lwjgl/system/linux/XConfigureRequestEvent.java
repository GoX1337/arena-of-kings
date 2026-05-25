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

public class XConfigureRequestEvent
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
    public static final int ABOVE;
    public static final int DETAIL;
    public static final int VALUE_MASK;

    public XConfigureRequestEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XConfigureRequestEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XConfigureRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XConfigureRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XConfigureRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XConfigureRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long parent() {
        return XConfigureRequestEvent.nparent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XConfigureRequestEvent.nwindow(this.address());
    }

    public int x() {
        return XConfigureRequestEvent.nx(this.address());
    }

    public int y() {
        return XConfigureRequestEvent.ny(this.address());
    }

    public int width() {
        return XConfigureRequestEvent.nwidth(this.address());
    }

    public int height() {
        return XConfigureRequestEvent.nheight(this.address());
    }

    public int border_width() {
        return XConfigureRequestEvent.nborder_width(this.address());
    }

    @NativeType(value="Window")
    public long above() {
        return XConfigureRequestEvent.nabove(this.address());
    }

    public int detail() {
        return XConfigureRequestEvent.ndetail(this.address());
    }

    @NativeType(value="unsigned long")
    public long value_mask() {
        return XConfigureRequestEvent.nvalue_mask(this.address());
    }

    public XConfigureRequestEvent type(int n2) {
        XConfigureRequestEvent.ntype(this.address(), n2);
        return this;
    }

    public XConfigureRequestEvent serial(@NativeType(value="unsigned long") long l2) {
        XConfigureRequestEvent.nserial(this.address(), l2);
        return this;
    }

    public XConfigureRequestEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XConfigureRequestEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XConfigureRequestEvent display(@NativeType(value="Display *") long l2) {
        XConfigureRequestEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XConfigureRequestEvent parent(@NativeType(value="Window") long l2) {
        XConfigureRequestEvent.nparent(this.address(), l2);
        return this;
    }

    public XConfigureRequestEvent window(@NativeType(value="Window") long l2) {
        XConfigureRequestEvent.nwindow(this.address(), l2);
        return this;
    }

    public XConfigureRequestEvent x(int n2) {
        XConfigureRequestEvent.nx(this.address(), n2);
        return this;
    }

    public XConfigureRequestEvent y(int n2) {
        XConfigureRequestEvent.ny(this.address(), n2);
        return this;
    }

    public XConfigureRequestEvent width(int n2) {
        XConfigureRequestEvent.nwidth(this.address(), n2);
        return this;
    }

    public XConfigureRequestEvent height(int n2) {
        XConfigureRequestEvent.nheight(this.address(), n2);
        return this;
    }

    public XConfigureRequestEvent border_width(int n2) {
        XConfigureRequestEvent.nborder_width(this.address(), n2);
        return this;
    }

    public XConfigureRequestEvent above(@NativeType(value="Window") long l2) {
        XConfigureRequestEvent.nabove(this.address(), l2);
        return this;
    }

    public XConfigureRequestEvent detail(int n2) {
        XConfigureRequestEvent.ndetail(this.address(), n2);
        return this;
    }

    public XConfigureRequestEvent value_mask(@NativeType(value="unsigned long") long l2) {
        XConfigureRequestEvent.nvalue_mask(this.address(), l2);
        return this;
    }

    public XConfigureRequestEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, int n3, int n4, int n5, int n6, int n7, long l6, int n8, long l7) {
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
        this.above(l6);
        this.detail(n8);
        this.value_mask(l7);
        return this;
    }

    public XConfigureRequestEvent set(XConfigureRequestEvent xConfigureRequestEvent) {
        MemoryUtil.memCopy(xConfigureRequestEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XConfigureRequestEvent malloc() {
        return XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XConfigureRequestEvent calloc() {
        return XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XConfigureRequestEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XConfigureRequestEvent create(long l2) {
        return XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, l2);
    }

    @Nullable
    public static XConfigureRequestEvent createSafe(long l2) {
        return l2 == 0L ? null : XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XConfigureRequestEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XConfigureRequestEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XConfigureRequestEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XConfigureRequestEvent.__create(n2, SIZEOF);
        return XConfigureRequestEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XConfigureRequestEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XConfigureRequestEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XConfigureRequestEvent mallocStack() {
        return XConfigureRequestEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XConfigureRequestEvent callocStack() {
        return XConfigureRequestEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XConfigureRequestEvent mallocStack(MemoryStack memoryStack) {
        return XConfigureRequestEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XConfigureRequestEvent callocStack(MemoryStack memoryStack) {
        return XConfigureRequestEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XConfigureRequestEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XConfigureRequestEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XConfigureRequestEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XConfigureRequestEvent.calloc(n2, memoryStack);
    }

    public static XConfigureRequestEvent malloc(MemoryStack memoryStack) {
        return XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XConfigureRequestEvent calloc(MemoryStack memoryStack) {
        return XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XConfigureRequestEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XConfigureRequestEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static long nabove(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)ABOVE);
    }

    public static int ndetail(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DETAIL);
    }

    public static long nvalue_mask(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)VALUE_MASK);
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

    public static void nabove(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)ABOVE, l3);
    }

    public static void ndetail(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)DETAIL, n2);
    }

    public static void nvalue_mask(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)VALUE_MASK, l3);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XConfigureRequestEvent.__struct(XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(POINTER_SIZE), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(CLONG_SIZE));
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
        ABOVE = layout.offsetof(11);
        DETAIL = layout.offsetof(12);
        VALUE_MASK = layout.offsetof(13);
    }

    public static class Buffer
    extends StructBuffer<XConfigureRequestEvent, Buffer>
    implements NativeResource {
        private static final XConfigureRequestEvent ELEMENT_FACTORY = XConfigureRequestEvent.create(-1L);

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
        protected XConfigureRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XConfigureRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XConfigureRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XConfigureRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XConfigureRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long parent() {
            return XConfigureRequestEvent.nparent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XConfigureRequestEvent.nwindow(this.address());
        }

        public int x() {
            return XConfigureRequestEvent.nx(this.address());
        }

        public int y() {
            return XConfigureRequestEvent.ny(this.address());
        }

        public int width() {
            return XConfigureRequestEvent.nwidth(this.address());
        }

        public int height() {
            return XConfigureRequestEvent.nheight(this.address());
        }

        public int border_width() {
            return XConfigureRequestEvent.nborder_width(this.address());
        }

        @NativeType(value="Window")
        public long above() {
            return XConfigureRequestEvent.nabove(this.address());
        }

        public int detail() {
            return XConfigureRequestEvent.ndetail(this.address());
        }

        @NativeType(value="unsigned long")
        public long value_mask() {
            return XConfigureRequestEvent.nvalue_mask(this.address());
        }

        public Buffer type(int n2) {
            XConfigureRequestEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XConfigureRequestEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XConfigureRequestEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XConfigureRequestEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer parent(@NativeType(value="Window") long l2) {
            XConfigureRequestEvent.nparent(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XConfigureRequestEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer x(int n2) {
            XConfigureRequestEvent.nx(this.address(), n2);
            return this;
        }

        public Buffer y(int n2) {
            XConfigureRequestEvent.ny(this.address(), n2);
            return this;
        }

        public Buffer width(int n2) {
            XConfigureRequestEvent.nwidth(this.address(), n2);
            return this;
        }

        public Buffer height(int n2) {
            XConfigureRequestEvent.nheight(this.address(), n2);
            return this;
        }

        public Buffer border_width(int n2) {
            XConfigureRequestEvent.nborder_width(this.address(), n2);
            return this;
        }

        public Buffer above(@NativeType(value="Window") long l2) {
            XConfigureRequestEvent.nabove(this.address(), l2);
            return this;
        }

        public Buffer detail(int n2) {
            XConfigureRequestEvent.ndetail(this.address(), n2);
            return this;
        }

        public Buffer value_mask(@NativeType(value="unsigned long") long l2) {
            XConfigureRequestEvent.nvalue_mask(this.address(), l2);
            return this;
        }
    }
}

