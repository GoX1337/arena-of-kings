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

public class XCirculateEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EVENT;
    public static final int WINDOW;
    public static final int PLACE;

    public XCirculateEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XCirculateEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XCirculateEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XCirculateEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XCirculateEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XCirculateEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long event() {
        return XCirculateEvent.nevent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XCirculateEvent.nwindow(this.address());
    }

    public int place() {
        return XCirculateEvent.nplace(this.address());
    }

    public XCirculateEvent type(int n2) {
        XCirculateEvent.ntype(this.address(), n2);
        return this;
    }

    public XCirculateEvent serial(@NativeType(value="unsigned long") long l2) {
        XCirculateEvent.nserial(this.address(), l2);
        return this;
    }

    public XCirculateEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XCirculateEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XCirculateEvent display(@NativeType(value="Display *") long l2) {
        XCirculateEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XCirculateEvent event(@NativeType(value="Window") long l2) {
        XCirculateEvent.nevent(this.address(), l2);
        return this;
    }

    public XCirculateEvent window(@NativeType(value="Window") long l2) {
        XCirculateEvent.nwindow(this.address(), l2);
        return this;
    }

    public XCirculateEvent place(int n2) {
        XCirculateEvent.nplace(this.address(), n2);
        return this;
    }

    public XCirculateEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, int n3) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.event(l4);
        this.window(l5);
        this.place(n3);
        return this;
    }

    public XCirculateEvent set(XCirculateEvent xCirculateEvent) {
        MemoryUtil.memCopy(xCirculateEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XCirculateEvent malloc() {
        return XCirculateEvent.wrap(XCirculateEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XCirculateEvent calloc() {
        return XCirculateEvent.wrap(XCirculateEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XCirculateEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XCirculateEvent.wrap(XCirculateEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XCirculateEvent create(long l2) {
        return XCirculateEvent.wrap(XCirculateEvent.class, l2);
    }

    @Nullable
    public static XCirculateEvent createSafe(long l2) {
        return l2 == 0L ? null : XCirculateEvent.wrap(XCirculateEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XCirculateEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XCirculateEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XCirculateEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XCirculateEvent.__create(n2, SIZEOF);
        return XCirculateEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XCirculateEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XCirculateEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XCirculateEvent mallocStack() {
        return XCirculateEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCirculateEvent callocStack() {
        return XCirculateEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCirculateEvent mallocStack(MemoryStack memoryStack) {
        return XCirculateEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XCirculateEvent callocStack(MemoryStack memoryStack) {
        return XCirculateEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XCirculateEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XCirculateEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XCirculateEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XCirculateEvent.calloc(n2, memoryStack);
    }

    public static XCirculateEvent malloc(MemoryStack memoryStack) {
        return XCirculateEvent.wrap(XCirculateEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XCirculateEvent calloc(MemoryStack memoryStack) {
        return XCirculateEvent.wrap(XCirculateEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XCirculateEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XCirculateEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static long nevent(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)EVENT);
    }

    public static long nwindow(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)WINDOW);
    }

    public static int nplace(long l2) {
        return UNSAFE.getInt(null, l2 + (long)PLACE);
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

    public static void nevent(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)EVENT, l3);
    }

    public static void nwindow(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)WINDOW, l3);
    }

    public static void nplace(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)PLACE, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XCirculateEvent.__struct(XCirculateEvent.__member(4), XCirculateEvent.__member(CLONG_SIZE), XCirculateEvent.__member(4), XCirculateEvent.__member(POINTER_SIZE), XCirculateEvent.__member(CLONG_SIZE), XCirculateEvent.__member(CLONG_SIZE), XCirculateEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EVENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
        PLACE = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XCirculateEvent, Buffer>
    implements NativeResource {
        private static final XCirculateEvent ELEMENT_FACTORY = XCirculateEvent.create(-1L);

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
        protected XCirculateEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XCirculateEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XCirculateEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XCirculateEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XCirculateEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long event() {
            return XCirculateEvent.nevent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XCirculateEvent.nwindow(this.address());
        }

        public int place() {
            return XCirculateEvent.nplace(this.address());
        }

        public Buffer type(int n2) {
            XCirculateEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XCirculateEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XCirculateEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XCirculateEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer event(@NativeType(value="Window") long l2) {
            XCirculateEvent.nevent(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XCirculateEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer place(int n2) {
            XCirculateEvent.nplace(this.address(), n2);
            return this;
        }
    }
}

