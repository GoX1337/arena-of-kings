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

public class XVisibilityEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int STATE;

    public XVisibilityEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XVisibilityEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XVisibilityEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XVisibilityEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XVisibilityEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XVisibilityEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XVisibilityEvent.nwindow(this.address());
    }

    public int state() {
        return XVisibilityEvent.nstate(this.address());
    }

    public XVisibilityEvent type(int n2) {
        XVisibilityEvent.ntype(this.address(), n2);
        return this;
    }

    public XVisibilityEvent serial(@NativeType(value="unsigned long") long l2) {
        XVisibilityEvent.nserial(this.address(), l2);
        return this;
    }

    public XVisibilityEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XVisibilityEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XVisibilityEvent display(@NativeType(value="Display *") long l2) {
        XVisibilityEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XVisibilityEvent window(@NativeType(value="Window") long l2) {
        XVisibilityEvent.nwindow(this.address(), l2);
        return this;
    }

    public XVisibilityEvent state(int n2) {
        XVisibilityEvent.nstate(this.address(), n2);
        return this;
    }

    public XVisibilityEvent set(int n2, long l2, boolean bl2, long l3, long l4, int n3) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        this.state(n3);
        return this;
    }

    public XVisibilityEvent set(XVisibilityEvent xVisibilityEvent) {
        MemoryUtil.memCopy(xVisibilityEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XVisibilityEvent malloc() {
        return XVisibilityEvent.wrap(XVisibilityEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XVisibilityEvent calloc() {
        return XVisibilityEvent.wrap(XVisibilityEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XVisibilityEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XVisibilityEvent.wrap(XVisibilityEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XVisibilityEvent create(long l2) {
        return XVisibilityEvent.wrap(XVisibilityEvent.class, l2);
    }

    @Nullable
    public static XVisibilityEvent createSafe(long l2) {
        return l2 == 0L ? null : XVisibilityEvent.wrap(XVisibilityEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XVisibilityEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XVisibilityEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XVisibilityEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XVisibilityEvent.__create(n2, SIZEOF);
        return XVisibilityEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XVisibilityEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XVisibilityEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XVisibilityEvent mallocStack() {
        return XVisibilityEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XVisibilityEvent callocStack() {
        return XVisibilityEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XVisibilityEvent mallocStack(MemoryStack memoryStack) {
        return XVisibilityEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XVisibilityEvent callocStack(MemoryStack memoryStack) {
        return XVisibilityEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XVisibilityEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XVisibilityEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XVisibilityEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XVisibilityEvent.calloc(n2, memoryStack);
    }

    public static XVisibilityEvent malloc(MemoryStack memoryStack) {
        return XVisibilityEvent.wrap(XVisibilityEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XVisibilityEvent calloc(MemoryStack memoryStack) {
        return XVisibilityEvent.wrap(XVisibilityEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XVisibilityEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XVisibilityEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static void nstate(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)STATE, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XVisibilityEvent.__struct(XVisibilityEvent.__member(4), XVisibilityEvent.__member(CLONG_SIZE), XVisibilityEvent.__member(4), XVisibilityEvent.__member(POINTER_SIZE), XVisibilityEvent.__member(CLONG_SIZE), XVisibilityEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        STATE = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XVisibilityEvent, Buffer>
    implements NativeResource {
        private static final XVisibilityEvent ELEMENT_FACTORY = XVisibilityEvent.create(-1L);

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
        protected XVisibilityEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XVisibilityEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XVisibilityEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XVisibilityEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XVisibilityEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XVisibilityEvent.nwindow(this.address());
        }

        public int state() {
            return XVisibilityEvent.nstate(this.address());
        }

        public Buffer type(int n2) {
            XVisibilityEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XVisibilityEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XVisibilityEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XVisibilityEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XVisibilityEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer state(int n2) {
            XVisibilityEvent.nstate(this.address(), n2);
            return this;
        }
    }
}

