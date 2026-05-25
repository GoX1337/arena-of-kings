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

public class XExposeEvent
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
    public static final int COUNT;

    public XExposeEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XExposeEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XExposeEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XExposeEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XExposeEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XExposeEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XExposeEvent.nwindow(this.address());
    }

    public int x() {
        return XExposeEvent.nx(this.address());
    }

    public int y() {
        return XExposeEvent.ny(this.address());
    }

    public int width() {
        return XExposeEvent.nwidth(this.address());
    }

    public int height() {
        return XExposeEvent.nheight(this.address());
    }

    public int count() {
        return XExposeEvent.ncount(this.address());
    }

    public XExposeEvent type(int n2) {
        XExposeEvent.ntype(this.address(), n2);
        return this;
    }

    public XExposeEvent serial(@NativeType(value="unsigned long") long l2) {
        XExposeEvent.nserial(this.address(), l2);
        return this;
    }

    public XExposeEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XExposeEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XExposeEvent display(@NativeType(value="Display *") long l2) {
        XExposeEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XExposeEvent window(@NativeType(value="Window") long l2) {
        XExposeEvent.nwindow(this.address(), l2);
        return this;
    }

    public XExposeEvent x(int n2) {
        XExposeEvent.nx(this.address(), n2);
        return this;
    }

    public XExposeEvent y(int n2) {
        XExposeEvent.ny(this.address(), n2);
        return this;
    }

    public XExposeEvent width(int n2) {
        XExposeEvent.nwidth(this.address(), n2);
        return this;
    }

    public XExposeEvent height(int n2) {
        XExposeEvent.nheight(this.address(), n2);
        return this;
    }

    public XExposeEvent count(int n2) {
        XExposeEvent.ncount(this.address(), n2);
        return this;
    }

    public XExposeEvent set(int n2, long l2, boolean bl2, long l3, long l4, int n3, int n4, int n5, int n6, int n7) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        this.x(n3);
        this.y(n4);
        this.width(n5);
        this.height(n6);
        this.count(n7);
        return this;
    }

    public XExposeEvent set(XExposeEvent xExposeEvent) {
        MemoryUtil.memCopy(xExposeEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XExposeEvent malloc() {
        return XExposeEvent.wrap(XExposeEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XExposeEvent calloc() {
        return XExposeEvent.wrap(XExposeEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XExposeEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XExposeEvent.wrap(XExposeEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XExposeEvent create(long l2) {
        return XExposeEvent.wrap(XExposeEvent.class, l2);
    }

    @Nullable
    public static XExposeEvent createSafe(long l2) {
        return l2 == 0L ? null : XExposeEvent.wrap(XExposeEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XExposeEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XExposeEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XExposeEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XExposeEvent.__create(n2, SIZEOF);
        return XExposeEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XExposeEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XExposeEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XExposeEvent mallocStack() {
        return XExposeEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XExposeEvent callocStack() {
        return XExposeEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XExposeEvent mallocStack(MemoryStack memoryStack) {
        return XExposeEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XExposeEvent callocStack(MemoryStack memoryStack) {
        return XExposeEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XExposeEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XExposeEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XExposeEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XExposeEvent.calloc(n2, memoryStack);
    }

    public static XExposeEvent malloc(MemoryStack memoryStack) {
        return XExposeEvent.wrap(XExposeEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XExposeEvent calloc(MemoryStack memoryStack) {
        return XExposeEvent.wrap(XExposeEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XExposeEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XExposeEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static int ncount(long l2) {
        return UNSAFE.getInt(null, l2 + (long)COUNT);
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

    public static void ncount(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)COUNT, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XExposeEvent.__struct(XExposeEvent.__member(4), XExposeEvent.__member(CLONG_SIZE), XExposeEvent.__member(4), XExposeEvent.__member(POINTER_SIZE), XExposeEvent.__member(CLONG_SIZE), XExposeEvent.__member(4), XExposeEvent.__member(4), XExposeEvent.__member(4), XExposeEvent.__member(4), XExposeEvent.__member(4));
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
        COUNT = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<XExposeEvent, Buffer>
    implements NativeResource {
        private static final XExposeEvent ELEMENT_FACTORY = XExposeEvent.create(-1L);

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
        protected XExposeEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XExposeEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XExposeEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XExposeEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XExposeEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XExposeEvent.nwindow(this.address());
        }

        public int x() {
            return XExposeEvent.nx(this.address());
        }

        public int y() {
            return XExposeEvent.ny(this.address());
        }

        public int width() {
            return XExposeEvent.nwidth(this.address());
        }

        public int height() {
            return XExposeEvent.nheight(this.address());
        }

        public int count() {
            return XExposeEvent.ncount(this.address());
        }

        public Buffer type(int n2) {
            XExposeEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XExposeEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XExposeEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XExposeEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XExposeEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer x(int n2) {
            XExposeEvent.nx(this.address(), n2);
            return this;
        }

        public Buffer y(int n2) {
            XExposeEvent.ny(this.address(), n2);
            return this;
        }

        public Buffer width(int n2) {
            XExposeEvent.nwidth(this.address(), n2);
            return this;
        }

        public Buffer height(int n2) {
            XExposeEvent.nheight(this.address(), n2);
            return this;
        }

        public Buffer count(int n2) {
            XExposeEvent.ncount(this.address(), n2);
            return this;
        }
    }
}

