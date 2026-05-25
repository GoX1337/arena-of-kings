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

public class XCrossingEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int ROOT;
    public static final int SUBWINDOW;
    public static final int TIME;
    public static final int X;
    public static final int Y;
    public static final int X_ROOT;
    public static final int Y_ROOT;
    public static final int MODE;
    public static final int DETAIL;
    public static final int SAME_SCREEN;
    public static final int FOCUS;
    public static final int STATE;

    public XCrossingEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XCrossingEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XCrossingEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XCrossingEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XCrossingEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XCrossingEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XCrossingEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long root() {
        return XCrossingEvent.nroot(this.address());
    }

    @NativeType(value="Window")
    public long subwindow() {
        return XCrossingEvent.nsubwindow(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XCrossingEvent.ntime(this.address());
    }

    public int x() {
        return XCrossingEvent.nx(this.address());
    }

    public int y() {
        return XCrossingEvent.ny(this.address());
    }

    public int x_root() {
        return XCrossingEvent.nx_root(this.address());
    }

    public int y_root() {
        return XCrossingEvent.ny_root(this.address());
    }

    public int mode() {
        return XCrossingEvent.nmode(this.address());
    }

    public int detail() {
        return XCrossingEvent.ndetail(this.address());
    }

    public int same_screen() {
        return XCrossingEvent.nsame_screen(this.address());
    }

    public int focus() {
        return XCrossingEvent.nfocus(this.address());
    }

    @NativeType(value="unsigned int")
    public int state() {
        return XCrossingEvent.nstate(this.address());
    }

    public XCrossingEvent type(int n2) {
        XCrossingEvent.ntype(this.address(), n2);
        return this;
    }

    public XCrossingEvent serial(@NativeType(value="unsigned long") long l2) {
        XCrossingEvent.nserial(this.address(), l2);
        return this;
    }

    public XCrossingEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XCrossingEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XCrossingEvent display(@NativeType(value="Display *") long l2) {
        XCrossingEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XCrossingEvent window(@NativeType(value="Window") long l2) {
        XCrossingEvent.nwindow(this.address(), l2);
        return this;
    }

    public XCrossingEvent root(@NativeType(value="Window") long l2) {
        XCrossingEvent.nroot(this.address(), l2);
        return this;
    }

    public XCrossingEvent subwindow(@NativeType(value="Window") long l2) {
        XCrossingEvent.nsubwindow(this.address(), l2);
        return this;
    }

    public XCrossingEvent time(@NativeType(value="Time") long l2) {
        XCrossingEvent.ntime(this.address(), l2);
        return this;
    }

    public XCrossingEvent x(int n2) {
        XCrossingEvent.nx(this.address(), n2);
        return this;
    }

    public XCrossingEvent y(int n2) {
        XCrossingEvent.ny(this.address(), n2);
        return this;
    }

    public XCrossingEvent x_root(int n2) {
        XCrossingEvent.nx_root(this.address(), n2);
        return this;
    }

    public XCrossingEvent y_root(int n2) {
        XCrossingEvent.ny_root(this.address(), n2);
        return this;
    }

    public XCrossingEvent mode(int n2) {
        XCrossingEvent.nmode(this.address(), n2);
        return this;
    }

    public XCrossingEvent detail(int n2) {
        XCrossingEvent.ndetail(this.address(), n2);
        return this;
    }

    public XCrossingEvent same_screen(int n2) {
        XCrossingEvent.nsame_screen(this.address(), n2);
        return this;
    }

    public XCrossingEvent focus(int n2) {
        XCrossingEvent.nfocus(this.address(), n2);
        return this;
    }

    public XCrossingEvent state(@NativeType(value="unsigned int") int n2) {
        XCrossingEvent.nstate(this.address(), n2);
        return this;
    }

    public XCrossingEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, long l6, long l7, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        this.root(l5);
        this.subwindow(l6);
        this.time(l7);
        this.x(n3);
        this.y(n4);
        this.x_root(n5);
        this.y_root(n6);
        this.mode(n7);
        this.detail(n8);
        this.same_screen(n9);
        this.focus(n10);
        this.state(n11);
        return this;
    }

    public XCrossingEvent set(XCrossingEvent xCrossingEvent) {
        MemoryUtil.memCopy(xCrossingEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XCrossingEvent malloc() {
        return XCrossingEvent.wrap(XCrossingEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XCrossingEvent calloc() {
        return XCrossingEvent.wrap(XCrossingEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XCrossingEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XCrossingEvent.wrap(XCrossingEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XCrossingEvent create(long l2) {
        return XCrossingEvent.wrap(XCrossingEvent.class, l2);
    }

    @Nullable
    public static XCrossingEvent createSafe(long l2) {
        return l2 == 0L ? null : XCrossingEvent.wrap(XCrossingEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XCrossingEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XCrossingEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XCrossingEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XCrossingEvent.__create(n2, SIZEOF);
        return XCrossingEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XCrossingEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XCrossingEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XCrossingEvent mallocStack() {
        return XCrossingEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCrossingEvent callocStack() {
        return XCrossingEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCrossingEvent mallocStack(MemoryStack memoryStack) {
        return XCrossingEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XCrossingEvent callocStack(MemoryStack memoryStack) {
        return XCrossingEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XCrossingEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XCrossingEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XCrossingEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XCrossingEvent.calloc(n2, memoryStack);
    }

    public static XCrossingEvent malloc(MemoryStack memoryStack) {
        return XCrossingEvent.wrap(XCrossingEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XCrossingEvent calloc(MemoryStack memoryStack) {
        return XCrossingEvent.wrap(XCrossingEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XCrossingEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XCrossingEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static long nroot(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)ROOT);
    }

    public static long nsubwindow(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)SUBWINDOW);
    }

    public static long ntime(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)TIME);
    }

    public static int nx(long l2) {
        return UNSAFE.getInt(null, l2 + (long)X);
    }

    public static int ny(long l2) {
        return UNSAFE.getInt(null, l2 + (long)Y);
    }

    public static int nx_root(long l2) {
        return UNSAFE.getInt(null, l2 + (long)X_ROOT);
    }

    public static int ny_root(long l2) {
        return UNSAFE.getInt(null, l2 + (long)Y_ROOT);
    }

    public static int nmode(long l2) {
        return UNSAFE.getInt(null, l2 + (long)MODE);
    }

    public static int ndetail(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DETAIL);
    }

    public static int nsame_screen(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SAME_SCREEN);
    }

    public static int nfocus(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FOCUS);
    }

    public static int nstate(long l2) {
        return UNSAFE.getInt(null, l2 + (long)STATE);
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

    public static void nroot(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)ROOT, l3);
    }

    public static void nsubwindow(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)SUBWINDOW, l3);
    }

    public static void ntime(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)TIME, l3);
    }

    public static void nx(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)X, n2);
    }

    public static void ny(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)Y, n2);
    }

    public static void nx_root(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)X_ROOT, n2);
    }

    public static void ny_root(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)Y_ROOT, n2);
    }

    public static void nmode(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)MODE, n2);
    }

    public static void ndetail(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)DETAIL, n2);
    }

    public static void nsame_screen(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SAME_SCREEN, n2);
    }

    public static void nfocus(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FOCUS, n2);
    }

    public static void nstate(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)STATE, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XCrossingEvent.__struct(XCrossingEvent.__member(4), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(4), XCrossingEvent.__member(POINTER_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        ROOT = layout.offsetof(5);
        SUBWINDOW = layout.offsetof(6);
        TIME = layout.offsetof(7);
        X = layout.offsetof(8);
        Y = layout.offsetof(9);
        X_ROOT = layout.offsetof(10);
        Y_ROOT = layout.offsetof(11);
        MODE = layout.offsetof(12);
        DETAIL = layout.offsetof(13);
        SAME_SCREEN = layout.offsetof(14);
        FOCUS = layout.offsetof(15);
        STATE = layout.offsetof(16);
    }

    public static class Buffer
    extends StructBuffer<XCrossingEvent, Buffer>
    implements NativeResource {
        private static final XCrossingEvent ELEMENT_FACTORY = XCrossingEvent.create(-1L);

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
        protected XCrossingEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XCrossingEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XCrossingEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XCrossingEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XCrossingEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XCrossingEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long root() {
            return XCrossingEvent.nroot(this.address());
        }

        @NativeType(value="Window")
        public long subwindow() {
            return XCrossingEvent.nsubwindow(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XCrossingEvent.ntime(this.address());
        }

        public int x() {
            return XCrossingEvent.nx(this.address());
        }

        public int y() {
            return XCrossingEvent.ny(this.address());
        }

        public int x_root() {
            return XCrossingEvent.nx_root(this.address());
        }

        public int y_root() {
            return XCrossingEvent.ny_root(this.address());
        }

        public int mode() {
            return XCrossingEvent.nmode(this.address());
        }

        public int detail() {
            return XCrossingEvent.ndetail(this.address());
        }

        public int same_screen() {
            return XCrossingEvent.nsame_screen(this.address());
        }

        public int focus() {
            return XCrossingEvent.nfocus(this.address());
        }

        @NativeType(value="unsigned int")
        public int state() {
            return XCrossingEvent.nstate(this.address());
        }

        public Buffer type(int n2) {
            XCrossingEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XCrossingEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XCrossingEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XCrossingEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XCrossingEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer root(@NativeType(value="Window") long l2) {
            XCrossingEvent.nroot(this.address(), l2);
            return this;
        }

        public Buffer subwindow(@NativeType(value="Window") long l2) {
            XCrossingEvent.nsubwindow(this.address(), l2);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l2) {
            XCrossingEvent.ntime(this.address(), l2);
            return this;
        }

        public Buffer x(int n2) {
            XCrossingEvent.nx(this.address(), n2);
            return this;
        }

        public Buffer y(int n2) {
            XCrossingEvent.ny(this.address(), n2);
            return this;
        }

        public Buffer x_root(int n2) {
            XCrossingEvent.nx_root(this.address(), n2);
            return this;
        }

        public Buffer y_root(int n2) {
            XCrossingEvent.ny_root(this.address(), n2);
            return this;
        }

        public Buffer mode(int n2) {
            XCrossingEvent.nmode(this.address(), n2);
            return this;
        }

        public Buffer detail(int n2) {
            XCrossingEvent.ndetail(this.address(), n2);
            return this;
        }

        public Buffer same_screen(int n2) {
            XCrossingEvent.nsame_screen(this.address(), n2);
            return this;
        }

        public Buffer focus(int n2) {
            XCrossingEvent.nfocus(this.address(), n2);
            return this;
        }

        public Buffer state(@NativeType(value="unsigned int") int n2) {
            XCrossingEvent.nstate(this.address(), n2);
            return this;
        }
    }
}

