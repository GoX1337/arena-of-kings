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

public class XKeyEvent
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
    public static final int STATE;
    public static final int KEYCODE;
    public static final int SAME_SCREEN;

    public XKeyEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XKeyEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XKeyEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XKeyEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XKeyEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XKeyEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XKeyEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long root() {
        return XKeyEvent.nroot(this.address());
    }

    @NativeType(value="Window")
    public long subwindow() {
        return XKeyEvent.nsubwindow(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XKeyEvent.ntime(this.address());
    }

    public int x() {
        return XKeyEvent.nx(this.address());
    }

    public int y() {
        return XKeyEvent.ny(this.address());
    }

    public int x_root() {
        return XKeyEvent.nx_root(this.address());
    }

    public int y_root() {
        return XKeyEvent.ny_root(this.address());
    }

    @NativeType(value="unsigned int")
    public int state() {
        return XKeyEvent.nstate(this.address());
    }

    @NativeType(value="unsigned int")
    public int keycode() {
        return XKeyEvent.nkeycode(this.address());
    }

    @NativeType(value="Bool")
    public boolean same_screen() {
        return XKeyEvent.nsame_screen(this.address()) != 0;
    }

    public XKeyEvent type(int n2) {
        XKeyEvent.ntype(this.address(), n2);
        return this;
    }

    public XKeyEvent serial(@NativeType(value="unsigned long") long l2) {
        XKeyEvent.nserial(this.address(), l2);
        return this;
    }

    public XKeyEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XKeyEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XKeyEvent display(@NativeType(value="Display *") long l2) {
        XKeyEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XKeyEvent window(@NativeType(value="Window") long l2) {
        XKeyEvent.nwindow(this.address(), l2);
        return this;
    }

    public XKeyEvent root(@NativeType(value="Window") long l2) {
        XKeyEvent.nroot(this.address(), l2);
        return this;
    }

    public XKeyEvent subwindow(@NativeType(value="Window") long l2) {
        XKeyEvent.nsubwindow(this.address(), l2);
        return this;
    }

    public XKeyEvent time(@NativeType(value="Time") long l2) {
        XKeyEvent.ntime(this.address(), l2);
        return this;
    }

    public XKeyEvent x(int n2) {
        XKeyEvent.nx(this.address(), n2);
        return this;
    }

    public XKeyEvent y(int n2) {
        XKeyEvent.ny(this.address(), n2);
        return this;
    }

    public XKeyEvent x_root(int n2) {
        XKeyEvent.nx_root(this.address(), n2);
        return this;
    }

    public XKeyEvent y_root(int n2) {
        XKeyEvent.ny_root(this.address(), n2);
        return this;
    }

    public XKeyEvent state(@NativeType(value="unsigned int") int n2) {
        XKeyEvent.nstate(this.address(), n2);
        return this;
    }

    public XKeyEvent keycode(@NativeType(value="unsigned int") int n2) {
        XKeyEvent.nkeycode(this.address(), n2);
        return this;
    }

    public XKeyEvent same_screen(@NativeType(value="Bool") boolean bl2) {
        XKeyEvent.nsame_screen(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XKeyEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, long l6, long l7, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl3) {
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
        this.state(n7);
        this.keycode(n8);
        this.same_screen(bl3);
        return this;
    }

    public XKeyEvent set(XKeyEvent xKeyEvent) {
        MemoryUtil.memCopy(xKeyEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XKeyEvent malloc() {
        return XKeyEvent.wrap(XKeyEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XKeyEvent calloc() {
        return XKeyEvent.wrap(XKeyEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XKeyEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XKeyEvent.wrap(XKeyEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XKeyEvent create(long l2) {
        return XKeyEvent.wrap(XKeyEvent.class, l2);
    }

    @Nullable
    public static XKeyEvent createSafe(long l2) {
        return l2 == 0L ? null : XKeyEvent.wrap(XKeyEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XKeyEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XKeyEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XKeyEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XKeyEvent.__create(n2, SIZEOF);
        return XKeyEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XKeyEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XKeyEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XKeyEvent mallocStack() {
        return XKeyEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XKeyEvent callocStack() {
        return XKeyEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XKeyEvent mallocStack(MemoryStack memoryStack) {
        return XKeyEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XKeyEvent callocStack(MemoryStack memoryStack) {
        return XKeyEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XKeyEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XKeyEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XKeyEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XKeyEvent.calloc(n2, memoryStack);
    }

    public static XKeyEvent malloc(MemoryStack memoryStack) {
        return XKeyEvent.wrap(XKeyEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XKeyEvent calloc(MemoryStack memoryStack) {
        return XKeyEvent.wrap(XKeyEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XKeyEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XKeyEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static int nstate(long l2) {
        return UNSAFE.getInt(null, l2 + (long)STATE);
    }

    public static int nkeycode(long l2) {
        return UNSAFE.getInt(null, l2 + (long)KEYCODE);
    }

    public static int nsame_screen(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SAME_SCREEN);
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

    public static void nstate(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)STATE, n2);
    }

    public static void nkeycode(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)KEYCODE, n2);
    }

    public static void nsame_screen(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SAME_SCREEN, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XKeyEvent.__struct(XKeyEvent.__member(4), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(4), XKeyEvent.__member(POINTER_SIZE), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4));
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
        STATE = layout.offsetof(12);
        KEYCODE = layout.offsetof(13);
        SAME_SCREEN = layout.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<XKeyEvent, Buffer>
    implements NativeResource {
        private static final XKeyEvent ELEMENT_FACTORY = XKeyEvent.create(-1L);

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
        protected XKeyEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XKeyEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XKeyEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XKeyEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XKeyEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XKeyEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long root() {
            return XKeyEvent.nroot(this.address());
        }

        @NativeType(value="Window")
        public long subwindow() {
            return XKeyEvent.nsubwindow(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XKeyEvent.ntime(this.address());
        }

        public int x() {
            return XKeyEvent.nx(this.address());
        }

        public int y() {
            return XKeyEvent.ny(this.address());
        }

        public int x_root() {
            return XKeyEvent.nx_root(this.address());
        }

        public int y_root() {
            return XKeyEvent.ny_root(this.address());
        }

        @NativeType(value="unsigned int")
        public int state() {
            return XKeyEvent.nstate(this.address());
        }

        @NativeType(value="unsigned int")
        public int keycode() {
            return XKeyEvent.nkeycode(this.address());
        }

        @NativeType(value="Bool")
        public boolean same_screen() {
            return XKeyEvent.nsame_screen(this.address()) != 0;
        }

        public Buffer type(int n2) {
            XKeyEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XKeyEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XKeyEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XKeyEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XKeyEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer root(@NativeType(value="Window") long l2) {
            XKeyEvent.nroot(this.address(), l2);
            return this;
        }

        public Buffer subwindow(@NativeType(value="Window") long l2) {
            XKeyEvent.nsubwindow(this.address(), l2);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l2) {
            XKeyEvent.ntime(this.address(), l2);
            return this;
        }

        public Buffer x(int n2) {
            XKeyEvent.nx(this.address(), n2);
            return this;
        }

        public Buffer y(int n2) {
            XKeyEvent.ny(this.address(), n2);
            return this;
        }

        public Buffer x_root(int n2) {
            XKeyEvent.nx_root(this.address(), n2);
            return this;
        }

        public Buffer y_root(int n2) {
            XKeyEvent.ny_root(this.address(), n2);
            return this;
        }

        public Buffer state(@NativeType(value="unsigned int") int n2) {
            XKeyEvent.nstate(this.address(), n2);
            return this;
        }

        public Buffer keycode(@NativeType(value="unsigned int") int n2) {
            XKeyEvent.nkeycode(this.address(), n2);
            return this;
        }

        public Buffer same_screen(@NativeType(value="Bool") boolean bl2) {
            XKeyEvent.nsame_screen(this.address(), bl2 ? 1 : 0);
            return this;
        }
    }
}

