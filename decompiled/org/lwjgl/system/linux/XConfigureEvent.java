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

public class XConfigureEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int X;
    public static final int Y;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int BORDER_WIDTH;
    public static final int ABOVE;
    public static final int OVERRIDE_REDIRECT;

    public XConfigureEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XConfigureEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XConfigureEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XConfigureEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XConfigureEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XConfigureEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XConfigureEvent.nwindow(this.address());
    }

    public int x() {
        return XConfigureEvent.nx(this.address());
    }

    public int y() {
        return XConfigureEvent.ny(this.address());
    }

    public int width() {
        return XConfigureEvent.nwidth(this.address());
    }

    public int height() {
        return XConfigureEvent.nheight(this.address());
    }

    public int border_width() {
        return XConfigureEvent.nborder_width(this.address());
    }

    @NativeType(value="Window")
    public long above() {
        return XConfigureEvent.nabove(this.address());
    }

    @NativeType(value="Bool")
    public boolean override_redirect() {
        return XConfigureEvent.noverride_redirect(this.address()) != 0;
    }

    public XConfigureEvent type(int n2) {
        XConfigureEvent.ntype(this.address(), n2);
        return this;
    }

    public XConfigureEvent serial(@NativeType(value="unsigned long") long l2) {
        XConfigureEvent.nserial(this.address(), l2);
        return this;
    }

    public XConfigureEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XConfigureEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XConfigureEvent display(@NativeType(value="Display *") long l2) {
        XConfigureEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XConfigureEvent window(@NativeType(value="Window") long l2) {
        XConfigureEvent.nwindow(this.address(), l2);
        return this;
    }

    public XConfigureEvent x(int n2) {
        XConfigureEvent.nx(this.address(), n2);
        return this;
    }

    public XConfigureEvent y(int n2) {
        XConfigureEvent.ny(this.address(), n2);
        return this;
    }

    public XConfigureEvent width(int n2) {
        XConfigureEvent.nwidth(this.address(), n2);
        return this;
    }

    public XConfigureEvent height(int n2) {
        XConfigureEvent.nheight(this.address(), n2);
        return this;
    }

    public XConfigureEvent border_width(int n2) {
        XConfigureEvent.nborder_width(this.address(), n2);
        return this;
    }

    public XConfigureEvent above(@NativeType(value="Window") long l2) {
        XConfigureEvent.nabove(this.address(), l2);
        return this;
    }

    public XConfigureEvent override_redirect(@NativeType(value="Bool") boolean bl2) {
        XConfigureEvent.noverride_redirect(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XConfigureEvent set(int n2, long l2, boolean bl2, long l3, long l4, int n3, int n4, int n5, int n6, int n7, long l5, boolean bl3) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        this.x(n3);
        this.y(n4);
        this.width(n5);
        this.height(n6);
        this.border_width(n7);
        this.above(l5);
        this.override_redirect(bl3);
        return this;
    }

    public XConfigureEvent set(XConfigureEvent xConfigureEvent) {
        MemoryUtil.memCopy(xConfigureEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XConfigureEvent malloc() {
        return XConfigureEvent.wrap(XConfigureEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XConfigureEvent calloc() {
        return XConfigureEvent.wrap(XConfigureEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XConfigureEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XConfigureEvent.wrap(XConfigureEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XConfigureEvent create(long l2) {
        return XConfigureEvent.wrap(XConfigureEvent.class, l2);
    }

    @Nullable
    public static XConfigureEvent createSafe(long l2) {
        return l2 == 0L ? null : XConfigureEvent.wrap(XConfigureEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XConfigureEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XConfigureEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XConfigureEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XConfigureEvent.__create(n2, SIZEOF);
        return XConfigureEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XConfigureEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XConfigureEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XConfigureEvent mallocStack() {
        return XConfigureEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XConfigureEvent callocStack() {
        return XConfigureEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XConfigureEvent mallocStack(MemoryStack memoryStack) {
        return XConfigureEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XConfigureEvent callocStack(MemoryStack memoryStack) {
        return XConfigureEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XConfigureEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XConfigureEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XConfigureEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XConfigureEvent.calloc(n2, memoryStack);
    }

    public static XConfigureEvent malloc(MemoryStack memoryStack) {
        return XConfigureEvent.wrap(XConfigureEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XConfigureEvent calloc(MemoryStack memoryStack) {
        return XConfigureEvent.wrap(XConfigureEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XConfigureEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XConfigureEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static void noverride_redirect(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)OVERRIDE_REDIRECT, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XConfigureEvent.__struct(XConfigureEvent.__member(4), XConfigureEvent.__member(CLONG_SIZE), XConfigureEvent.__member(4), XConfigureEvent.__member(POINTER_SIZE), XConfigureEvent.__member(CLONG_SIZE), XConfigureEvent.__member(4), XConfigureEvent.__member(4), XConfigureEvent.__member(4), XConfigureEvent.__member(4), XConfigureEvent.__member(4), XConfigureEvent.__member(CLONG_SIZE), XConfigureEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        X = layout.offsetof(5);
        Y = layout.offsetof(6);
        WIDTH = layout.offsetof(7);
        HEIGHT = layout.offsetof(8);
        BORDER_WIDTH = layout.offsetof(9);
        ABOVE = layout.offsetof(10);
        OVERRIDE_REDIRECT = layout.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<XConfigureEvent, Buffer>
    implements NativeResource {
        private static final XConfigureEvent ELEMENT_FACTORY = XConfigureEvent.create(-1L);

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
        protected XConfigureEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XConfigureEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XConfigureEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XConfigureEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XConfigureEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XConfigureEvent.nwindow(this.address());
        }

        public int x() {
            return XConfigureEvent.nx(this.address());
        }

        public int y() {
            return XConfigureEvent.ny(this.address());
        }

        public int width() {
            return XConfigureEvent.nwidth(this.address());
        }

        public int height() {
            return XConfigureEvent.nheight(this.address());
        }

        public int border_width() {
            return XConfigureEvent.nborder_width(this.address());
        }

        @NativeType(value="Window")
        public long above() {
            return XConfigureEvent.nabove(this.address());
        }

        @NativeType(value="Bool")
        public boolean override_redirect() {
            return XConfigureEvent.noverride_redirect(this.address()) != 0;
        }

        public Buffer type(int n2) {
            XConfigureEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XConfigureEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XConfigureEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XConfigureEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XConfigureEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer x(int n2) {
            XConfigureEvent.nx(this.address(), n2);
            return this;
        }

        public Buffer y(int n2) {
            XConfigureEvent.ny(this.address(), n2);
            return this;
        }

        public Buffer width(int n2) {
            XConfigureEvent.nwidth(this.address(), n2);
            return this;
        }

        public Buffer height(int n2) {
            XConfigureEvent.nheight(this.address(), n2);
            return this;
        }

        public Buffer border_width(int n2) {
            XConfigureEvent.nborder_width(this.address(), n2);
            return this;
        }

        public Buffer above(@NativeType(value="Window") long l2) {
            XConfigureEvent.nabove(this.address(), l2);
            return this;
        }

        public Buffer override_redirect(@NativeType(value="Bool") boolean bl2) {
            XConfigureEvent.noverride_redirect(this.address(), bl2 ? 1 : 0);
            return this;
        }
    }
}

