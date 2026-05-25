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

public class XButtonEvent
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
    public static final int BUTTON;
    public static final int SAME_SCREEN;

    public XButtonEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XButtonEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XButtonEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XButtonEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XButtonEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XButtonEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XButtonEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long root() {
        return XButtonEvent.nroot(this.address());
    }

    @NativeType(value="Window")
    public long subwindow() {
        return XButtonEvent.nsubwindow(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XButtonEvent.ntime(this.address());
    }

    public int x() {
        return XButtonEvent.nx(this.address());
    }

    public int y() {
        return XButtonEvent.ny(this.address());
    }

    public int x_root() {
        return XButtonEvent.nx_root(this.address());
    }

    public int y_root() {
        return XButtonEvent.ny_root(this.address());
    }

    @NativeType(value="unsigned int")
    public int state() {
        return XButtonEvent.nstate(this.address());
    }

    @NativeType(value="unsigned int")
    public int button() {
        return XButtonEvent.nbutton(this.address());
    }

    @NativeType(value="Bool")
    public boolean same_screen() {
        return XButtonEvent.nsame_screen(this.address()) != 0;
    }

    public XButtonEvent type(int n2) {
        XButtonEvent.ntype(this.address(), n2);
        return this;
    }

    public XButtonEvent serial(@NativeType(value="unsigned long") long l2) {
        XButtonEvent.nserial(this.address(), l2);
        return this;
    }

    public XButtonEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XButtonEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XButtonEvent display(@NativeType(value="Display *") long l2) {
        XButtonEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XButtonEvent window(@NativeType(value="Window") long l2) {
        XButtonEvent.nwindow(this.address(), l2);
        return this;
    }

    public XButtonEvent root(@NativeType(value="Window") long l2) {
        XButtonEvent.nroot(this.address(), l2);
        return this;
    }

    public XButtonEvent subwindow(@NativeType(value="Window") long l2) {
        XButtonEvent.nsubwindow(this.address(), l2);
        return this;
    }

    public XButtonEvent time(@NativeType(value="Time") long l2) {
        XButtonEvent.ntime(this.address(), l2);
        return this;
    }

    public XButtonEvent x(int n2) {
        XButtonEvent.nx(this.address(), n2);
        return this;
    }

    public XButtonEvent y(int n2) {
        XButtonEvent.ny(this.address(), n2);
        return this;
    }

    public XButtonEvent x_root(int n2) {
        XButtonEvent.nx_root(this.address(), n2);
        return this;
    }

    public XButtonEvent y_root(int n2) {
        XButtonEvent.ny_root(this.address(), n2);
        return this;
    }

    public XButtonEvent state(@NativeType(value="unsigned int") int n2) {
        XButtonEvent.nstate(this.address(), n2);
        return this;
    }

    public XButtonEvent button(@NativeType(value="unsigned int") int n2) {
        XButtonEvent.nbutton(this.address(), n2);
        return this;
    }

    public XButtonEvent same_screen(@NativeType(value="Bool") boolean bl2) {
        XButtonEvent.nsame_screen(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XButtonEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, long l6, long l7, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl3) {
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
        this.button(n8);
        this.same_screen(bl3);
        return this;
    }

    public XButtonEvent set(XButtonEvent xButtonEvent) {
        MemoryUtil.memCopy(xButtonEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XButtonEvent malloc() {
        return XButtonEvent.wrap(XButtonEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XButtonEvent calloc() {
        return XButtonEvent.wrap(XButtonEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XButtonEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XButtonEvent.wrap(XButtonEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XButtonEvent create(long l2) {
        return XButtonEvent.wrap(XButtonEvent.class, l2);
    }

    @Nullable
    public static XButtonEvent createSafe(long l2) {
        return l2 == 0L ? null : XButtonEvent.wrap(XButtonEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XButtonEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XButtonEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XButtonEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XButtonEvent.__create(n2, SIZEOF);
        return XButtonEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XButtonEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XButtonEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XButtonEvent mallocStack() {
        return XButtonEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XButtonEvent callocStack() {
        return XButtonEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XButtonEvent mallocStack(MemoryStack memoryStack) {
        return XButtonEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XButtonEvent callocStack(MemoryStack memoryStack) {
        return XButtonEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XButtonEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XButtonEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XButtonEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XButtonEvent.calloc(n2, memoryStack);
    }

    public static XButtonEvent malloc(MemoryStack memoryStack) {
        return XButtonEvent.wrap(XButtonEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XButtonEvent calloc(MemoryStack memoryStack) {
        return XButtonEvent.wrap(XButtonEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XButtonEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XButtonEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static int nbutton(long l2) {
        return UNSAFE.getInt(null, l2 + (long)BUTTON);
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

    public static void nbutton(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)BUTTON, n2);
    }

    public static void nsame_screen(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SAME_SCREEN, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XButtonEvent.__struct(XButtonEvent.__member(4), XButtonEvent.__member(CLONG_SIZE), XButtonEvent.__member(4), XButtonEvent.__member(POINTER_SIZE), XButtonEvent.__member(CLONG_SIZE), XButtonEvent.__member(CLONG_SIZE), XButtonEvent.__member(CLONG_SIZE), XButtonEvent.__member(CLONG_SIZE), XButtonEvent.__member(4), XButtonEvent.__member(4), XButtonEvent.__member(4), XButtonEvent.__member(4), XButtonEvent.__member(4), XButtonEvent.__member(4), XButtonEvent.__member(4));
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
        BUTTON = layout.offsetof(13);
        SAME_SCREEN = layout.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<XButtonEvent, Buffer>
    implements NativeResource {
        private static final XButtonEvent ELEMENT_FACTORY = XButtonEvent.create(-1L);

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
        protected XButtonEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XButtonEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XButtonEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XButtonEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XButtonEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XButtonEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long root() {
            return XButtonEvent.nroot(this.address());
        }

        @NativeType(value="Window")
        public long subwindow() {
            return XButtonEvent.nsubwindow(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XButtonEvent.ntime(this.address());
        }

        public int x() {
            return XButtonEvent.nx(this.address());
        }

        public int y() {
            return XButtonEvent.ny(this.address());
        }

        public int x_root() {
            return XButtonEvent.nx_root(this.address());
        }

        public int y_root() {
            return XButtonEvent.ny_root(this.address());
        }

        @NativeType(value="unsigned int")
        public int state() {
            return XButtonEvent.nstate(this.address());
        }

        @NativeType(value="unsigned int")
        public int button() {
            return XButtonEvent.nbutton(this.address());
        }

        @NativeType(value="Bool")
        public boolean same_screen() {
            return XButtonEvent.nsame_screen(this.address()) != 0;
        }

        public Buffer type(int n2) {
            XButtonEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XButtonEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XButtonEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XButtonEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XButtonEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer root(@NativeType(value="Window") long l2) {
            XButtonEvent.nroot(this.address(), l2);
            return this;
        }

        public Buffer subwindow(@NativeType(value="Window") long l2) {
            XButtonEvent.nsubwindow(this.address(), l2);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l2) {
            XButtonEvent.ntime(this.address(), l2);
            return this;
        }

        public Buffer x(int n2) {
            XButtonEvent.nx(this.address(), n2);
            return this;
        }

        public Buffer y(int n2) {
            XButtonEvent.ny(this.address(), n2);
            return this;
        }

        public Buffer x_root(int n2) {
            XButtonEvent.nx_root(this.address(), n2);
            return this;
        }

        public Buffer y_root(int n2) {
            XButtonEvent.ny_root(this.address(), n2);
            return this;
        }

        public Buffer state(@NativeType(value="unsigned int") int n2) {
            XButtonEvent.nstate(this.address(), n2);
            return this;
        }

        public Buffer button(@NativeType(value="unsigned int") int n2) {
            XButtonEvent.nbutton(this.address(), n2);
            return this;
        }

        public Buffer same_screen(@NativeType(value="Bool") boolean bl2) {
            XButtonEvent.nsame_screen(this.address(), bl2 ? 1 : 0);
            return this;
        }
    }
}

