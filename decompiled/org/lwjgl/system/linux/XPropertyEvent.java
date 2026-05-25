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

public class XPropertyEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int ATOM;
    public static final int TIME;
    public static final int STATE;

    public XPropertyEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XPropertyEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XPropertyEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XPropertyEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XPropertyEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XPropertyEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XPropertyEvent.nwindow(this.address());
    }

    @NativeType(value="Atom")
    public long atom() {
        return XPropertyEvent.natom(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XPropertyEvent.ntime(this.address());
    }

    public int state() {
        return XPropertyEvent.nstate(this.address());
    }

    public XPropertyEvent type(int n2) {
        XPropertyEvent.ntype(this.address(), n2);
        return this;
    }

    public XPropertyEvent serial(@NativeType(value="unsigned long") long l2) {
        XPropertyEvent.nserial(this.address(), l2);
        return this;
    }

    public XPropertyEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XPropertyEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XPropertyEvent display(@NativeType(value="Display *") long l2) {
        XPropertyEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XPropertyEvent window(@NativeType(value="Window") long l2) {
        XPropertyEvent.nwindow(this.address(), l2);
        return this;
    }

    public XPropertyEvent atom(@NativeType(value="Atom") long l2) {
        XPropertyEvent.natom(this.address(), l2);
        return this;
    }

    public XPropertyEvent time(@NativeType(value="Time") long l2) {
        XPropertyEvent.ntime(this.address(), l2);
        return this;
    }

    public XPropertyEvent state(int n2) {
        XPropertyEvent.nstate(this.address(), n2);
        return this;
    }

    public XPropertyEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, long l6, int n3) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        this.atom(l5);
        this.time(l6);
        this.state(n3);
        return this;
    }

    public XPropertyEvent set(XPropertyEvent xPropertyEvent) {
        MemoryUtil.memCopy(xPropertyEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XPropertyEvent malloc() {
        return XPropertyEvent.wrap(XPropertyEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XPropertyEvent calloc() {
        return XPropertyEvent.wrap(XPropertyEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XPropertyEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XPropertyEvent.wrap(XPropertyEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XPropertyEvent create(long l2) {
        return XPropertyEvent.wrap(XPropertyEvent.class, l2);
    }

    @Nullable
    public static XPropertyEvent createSafe(long l2) {
        return l2 == 0L ? null : XPropertyEvent.wrap(XPropertyEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XPropertyEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XPropertyEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XPropertyEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XPropertyEvent.__create(n2, SIZEOF);
        return XPropertyEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XPropertyEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XPropertyEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XPropertyEvent mallocStack() {
        return XPropertyEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XPropertyEvent callocStack() {
        return XPropertyEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XPropertyEvent mallocStack(MemoryStack memoryStack) {
        return XPropertyEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XPropertyEvent callocStack(MemoryStack memoryStack) {
        return XPropertyEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XPropertyEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XPropertyEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XPropertyEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XPropertyEvent.calloc(n2, memoryStack);
    }

    public static XPropertyEvent malloc(MemoryStack memoryStack) {
        return XPropertyEvent.wrap(XPropertyEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XPropertyEvent calloc(MemoryStack memoryStack) {
        return XPropertyEvent.wrap(XPropertyEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XPropertyEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XPropertyEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static long natom(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)ATOM);
    }

    public static long ntime(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)TIME);
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

    public static void natom(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)ATOM, l3);
    }

    public static void ntime(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)TIME, l3);
    }

    public static void nstate(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)STATE, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XPropertyEvent.__struct(XPropertyEvent.__member(4), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(4), XPropertyEvent.__member(POINTER_SIZE), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        ATOM = layout.offsetof(5);
        TIME = layout.offsetof(6);
        STATE = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XPropertyEvent, Buffer>
    implements NativeResource {
        private static final XPropertyEvent ELEMENT_FACTORY = XPropertyEvent.create(-1L);

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
        protected XPropertyEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XPropertyEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XPropertyEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XPropertyEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XPropertyEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XPropertyEvent.nwindow(this.address());
        }

        @NativeType(value="Atom")
        public long atom() {
            return XPropertyEvent.natom(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XPropertyEvent.ntime(this.address());
        }

        public int state() {
            return XPropertyEvent.nstate(this.address());
        }

        public Buffer type(int n2) {
            XPropertyEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XPropertyEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XPropertyEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XPropertyEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XPropertyEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer atom(@NativeType(value="Atom") long l2) {
            XPropertyEvent.natom(this.address(), l2);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l2) {
            XPropertyEvent.ntime(this.address(), l2);
            return this;
        }

        public Buffer state(int n2) {
            XPropertyEvent.nstate(this.address(), n2);
            return this;
        }
    }
}

