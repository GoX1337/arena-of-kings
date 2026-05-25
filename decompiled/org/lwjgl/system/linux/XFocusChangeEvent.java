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

public class XFocusChangeEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int MODE;
    public static final int DETAIL;

    public XFocusChangeEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XFocusChangeEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XFocusChangeEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XFocusChangeEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XFocusChangeEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XFocusChangeEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XFocusChangeEvent.nwindow(this.address());
    }

    public int mode() {
        return XFocusChangeEvent.nmode(this.address());
    }

    public int detail() {
        return XFocusChangeEvent.ndetail(this.address());
    }

    public XFocusChangeEvent type(int n2) {
        XFocusChangeEvent.ntype(this.address(), n2);
        return this;
    }

    public XFocusChangeEvent serial(@NativeType(value="unsigned long") long l2) {
        XFocusChangeEvent.nserial(this.address(), l2);
        return this;
    }

    public XFocusChangeEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XFocusChangeEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XFocusChangeEvent display(@NativeType(value="Display *") long l2) {
        XFocusChangeEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XFocusChangeEvent window(@NativeType(value="Window") long l2) {
        XFocusChangeEvent.nwindow(this.address(), l2);
        return this;
    }

    public XFocusChangeEvent mode(int n2) {
        XFocusChangeEvent.nmode(this.address(), n2);
        return this;
    }

    public XFocusChangeEvent detail(int n2) {
        XFocusChangeEvent.ndetail(this.address(), n2);
        return this;
    }

    public XFocusChangeEvent set(int n2, long l2, boolean bl2, long l3, long l4, int n3, int n4) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        this.mode(n3);
        this.detail(n4);
        return this;
    }

    public XFocusChangeEvent set(XFocusChangeEvent xFocusChangeEvent) {
        MemoryUtil.memCopy(xFocusChangeEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XFocusChangeEvent malloc() {
        return XFocusChangeEvent.wrap(XFocusChangeEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XFocusChangeEvent calloc() {
        return XFocusChangeEvent.wrap(XFocusChangeEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XFocusChangeEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XFocusChangeEvent.wrap(XFocusChangeEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XFocusChangeEvent create(long l2) {
        return XFocusChangeEvent.wrap(XFocusChangeEvent.class, l2);
    }

    @Nullable
    public static XFocusChangeEvent createSafe(long l2) {
        return l2 == 0L ? null : XFocusChangeEvent.wrap(XFocusChangeEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XFocusChangeEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XFocusChangeEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XFocusChangeEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XFocusChangeEvent.__create(n2, SIZEOF);
        return XFocusChangeEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XFocusChangeEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XFocusChangeEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XFocusChangeEvent mallocStack() {
        return XFocusChangeEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XFocusChangeEvent callocStack() {
        return XFocusChangeEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XFocusChangeEvent mallocStack(MemoryStack memoryStack) {
        return XFocusChangeEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XFocusChangeEvent callocStack(MemoryStack memoryStack) {
        return XFocusChangeEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XFocusChangeEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XFocusChangeEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XFocusChangeEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XFocusChangeEvent.calloc(n2, memoryStack);
    }

    public static XFocusChangeEvent malloc(MemoryStack memoryStack) {
        return XFocusChangeEvent.wrap(XFocusChangeEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XFocusChangeEvent calloc(MemoryStack memoryStack) {
        return XFocusChangeEvent.wrap(XFocusChangeEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XFocusChangeEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XFocusChangeEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static int nmode(long l2) {
        return UNSAFE.getInt(null, l2 + (long)MODE);
    }

    public static int ndetail(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DETAIL);
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

    public static void nmode(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)MODE, n2);
    }

    public static void ndetail(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)DETAIL, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XFocusChangeEvent.__struct(XFocusChangeEvent.__member(4), XFocusChangeEvent.__member(CLONG_SIZE), XFocusChangeEvent.__member(4), XFocusChangeEvent.__member(POINTER_SIZE), XFocusChangeEvent.__member(CLONG_SIZE), XFocusChangeEvent.__member(4), XFocusChangeEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        MODE = layout.offsetof(5);
        DETAIL = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XFocusChangeEvent, Buffer>
    implements NativeResource {
        private static final XFocusChangeEvent ELEMENT_FACTORY = XFocusChangeEvent.create(-1L);

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
        protected XFocusChangeEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XFocusChangeEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XFocusChangeEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XFocusChangeEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XFocusChangeEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XFocusChangeEvent.nwindow(this.address());
        }

        public int mode() {
            return XFocusChangeEvent.nmode(this.address());
        }

        public int detail() {
            return XFocusChangeEvent.ndetail(this.address());
        }

        public Buffer type(int n2) {
            XFocusChangeEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XFocusChangeEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XFocusChangeEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XFocusChangeEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XFocusChangeEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer mode(int n2) {
            XFocusChangeEvent.nmode(this.address(), n2);
            return this;
        }

        public Buffer detail(int n2) {
            XFocusChangeEvent.ndetail(this.address(), n2);
            return this;
        }
    }
}

