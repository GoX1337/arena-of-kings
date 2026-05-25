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

public class XMotionEvent
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
    public static final int IS_HINT;
    public static final int SAME_SCREEN;

    public XMotionEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XMotionEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMotionEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMotionEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMotionEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMotionEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMotionEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long root() {
        return XMotionEvent.nroot(this.address());
    }

    @NativeType(value="Window")
    public long subwindow() {
        return XMotionEvent.nsubwindow(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XMotionEvent.ntime(this.address());
    }

    public int x() {
        return XMotionEvent.nx(this.address());
    }

    public int y() {
        return XMotionEvent.ny(this.address());
    }

    public int x_root() {
        return XMotionEvent.nx_root(this.address());
    }

    public int y_root() {
        return XMotionEvent.ny_root(this.address());
    }

    @NativeType(value="unsigned int")
    public int state() {
        return XMotionEvent.nstate(this.address());
    }

    @NativeType(value="char")
    public byte is_hint() {
        return XMotionEvent.nis_hint(this.address());
    }

    @NativeType(value="Bool")
    public boolean same_screen() {
        return XMotionEvent.nsame_screen(this.address()) != 0;
    }

    public XMotionEvent type(int n2) {
        XMotionEvent.ntype(this.address(), n2);
        return this;
    }

    public XMotionEvent serial(@NativeType(value="unsigned long") long l2) {
        XMotionEvent.nserial(this.address(), l2);
        return this;
    }

    public XMotionEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XMotionEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XMotionEvent display(@NativeType(value="Display *") long l2) {
        XMotionEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XMotionEvent window(@NativeType(value="Window") long l2) {
        XMotionEvent.nwindow(this.address(), l2);
        return this;
    }

    public XMotionEvent root(@NativeType(value="Window") long l2) {
        XMotionEvent.nroot(this.address(), l2);
        return this;
    }

    public XMotionEvent subwindow(@NativeType(value="Window") long l2) {
        XMotionEvent.nsubwindow(this.address(), l2);
        return this;
    }

    public XMotionEvent time(@NativeType(value="Time") long l2) {
        XMotionEvent.ntime(this.address(), l2);
        return this;
    }

    public XMotionEvent x(int n2) {
        XMotionEvent.nx(this.address(), n2);
        return this;
    }

    public XMotionEvent y(int n2) {
        XMotionEvent.ny(this.address(), n2);
        return this;
    }

    public XMotionEvent x_root(int n2) {
        XMotionEvent.nx_root(this.address(), n2);
        return this;
    }

    public XMotionEvent y_root(int n2) {
        XMotionEvent.ny_root(this.address(), n2);
        return this;
    }

    public XMotionEvent state(@NativeType(value="unsigned int") int n2) {
        XMotionEvent.nstate(this.address(), n2);
        return this;
    }

    public XMotionEvent is_hint(@NativeType(value="char") byte by2) {
        XMotionEvent.nis_hint(this.address(), by2);
        return this;
    }

    public XMotionEvent same_screen(@NativeType(value="Bool") boolean bl2) {
        XMotionEvent.nsame_screen(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XMotionEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, long l6, long l7, int n3, int n4, int n5, int n6, int n7, byte by2, boolean bl3) {
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
        this.is_hint(by2);
        this.same_screen(bl3);
        return this;
    }

    public XMotionEvent set(XMotionEvent xMotionEvent) {
        MemoryUtil.memCopy(xMotionEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMotionEvent malloc() {
        return XMotionEvent.wrap(XMotionEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XMotionEvent calloc() {
        return XMotionEvent.wrap(XMotionEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XMotionEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XMotionEvent.wrap(XMotionEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XMotionEvent create(long l2) {
        return XMotionEvent.wrap(XMotionEvent.class, l2);
    }

    @Nullable
    public static XMotionEvent createSafe(long l2) {
        return l2 == 0L ? null : XMotionEvent.wrap(XMotionEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XMotionEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XMotionEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XMotionEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XMotionEvent.__create(n2, SIZEOF);
        return XMotionEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XMotionEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XMotionEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XMotionEvent mallocStack() {
        return XMotionEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMotionEvent callocStack() {
        return XMotionEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMotionEvent mallocStack(MemoryStack memoryStack) {
        return XMotionEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XMotionEvent callocStack(MemoryStack memoryStack) {
        return XMotionEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XMotionEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XMotionEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XMotionEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XMotionEvent.calloc(n2, memoryStack);
    }

    public static XMotionEvent malloc(MemoryStack memoryStack) {
        return XMotionEvent.wrap(XMotionEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XMotionEvent calloc(MemoryStack memoryStack) {
        return XMotionEvent.wrap(XMotionEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XMotionEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XMotionEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static byte nis_hint(long l2) {
        return UNSAFE.getByte(null, l2 + (long)IS_HINT);
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

    public static void nis_hint(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)IS_HINT, by2);
    }

    public static void nsame_screen(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SAME_SCREEN, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XMotionEvent.__struct(XMotionEvent.__member(4), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(4), XMotionEvent.__member(POINTER_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(1), XMotionEvent.__member(4));
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
        IS_HINT = layout.offsetof(13);
        SAME_SCREEN = layout.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<XMotionEvent, Buffer>
    implements NativeResource {
        private static final XMotionEvent ELEMENT_FACTORY = XMotionEvent.create(-1L);

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
        protected XMotionEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMotionEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMotionEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMotionEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMotionEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMotionEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long root() {
            return XMotionEvent.nroot(this.address());
        }

        @NativeType(value="Window")
        public long subwindow() {
            return XMotionEvent.nsubwindow(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XMotionEvent.ntime(this.address());
        }

        public int x() {
            return XMotionEvent.nx(this.address());
        }

        public int y() {
            return XMotionEvent.ny(this.address());
        }

        public int x_root() {
            return XMotionEvent.nx_root(this.address());
        }

        public int y_root() {
            return XMotionEvent.ny_root(this.address());
        }

        @NativeType(value="unsigned int")
        public int state() {
            return XMotionEvent.nstate(this.address());
        }

        @NativeType(value="char")
        public byte is_hint() {
            return XMotionEvent.nis_hint(this.address());
        }

        @NativeType(value="Bool")
        public boolean same_screen() {
            return XMotionEvent.nsame_screen(this.address()) != 0;
        }

        public Buffer type(int n2) {
            XMotionEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XMotionEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XMotionEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XMotionEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XMotionEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer root(@NativeType(value="Window") long l2) {
            XMotionEvent.nroot(this.address(), l2);
            return this;
        }

        public Buffer subwindow(@NativeType(value="Window") long l2) {
            XMotionEvent.nsubwindow(this.address(), l2);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l2) {
            XMotionEvent.ntime(this.address(), l2);
            return this;
        }

        public Buffer x(int n2) {
            XMotionEvent.nx(this.address(), n2);
            return this;
        }

        public Buffer y(int n2) {
            XMotionEvent.ny(this.address(), n2);
            return this;
        }

        public Buffer x_root(int n2) {
            XMotionEvent.nx_root(this.address(), n2);
            return this;
        }

        public Buffer y_root(int n2) {
            XMotionEvent.ny_root(this.address(), n2);
            return this;
        }

        public Buffer state(@NativeType(value="unsigned int") int n2) {
            XMotionEvent.nstate(this.address(), n2);
            return this;
        }

        public Buffer is_hint(@NativeType(value="char") byte by2) {
            XMotionEvent.nis_hint(this.address(), by2);
            return this;
        }

        public Buffer same_screen(@NativeType(value="Bool") boolean bl2) {
            XMotionEvent.nsame_screen(this.address(), bl2 ? 1 : 0);
            return this;
        }
    }
}

