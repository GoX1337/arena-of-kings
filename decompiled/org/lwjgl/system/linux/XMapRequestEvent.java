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

public class XMapRequestEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int PARENT;
    public static final int WINDOW;

    public XMapRequestEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XMapRequestEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMapRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMapRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMapRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMapRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long parent() {
        return XMapRequestEvent.nparent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMapRequestEvent.nwindow(this.address());
    }

    public XMapRequestEvent type(int n2) {
        XMapRequestEvent.ntype(this.address(), n2);
        return this;
    }

    public XMapRequestEvent serial(@NativeType(value="unsigned long") long l2) {
        XMapRequestEvent.nserial(this.address(), l2);
        return this;
    }

    public XMapRequestEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XMapRequestEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XMapRequestEvent display(@NativeType(value="Display *") long l2) {
        XMapRequestEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XMapRequestEvent parent(@NativeType(value="Window") long l2) {
        XMapRequestEvent.nparent(this.address(), l2);
        return this;
    }

    public XMapRequestEvent window(@NativeType(value="Window") long l2) {
        XMapRequestEvent.nwindow(this.address(), l2);
        return this;
    }

    public XMapRequestEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.parent(l4);
        this.window(l5);
        return this;
    }

    public XMapRequestEvent set(XMapRequestEvent xMapRequestEvent) {
        MemoryUtil.memCopy(xMapRequestEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMapRequestEvent malloc() {
        return XMapRequestEvent.wrap(XMapRequestEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XMapRequestEvent calloc() {
        return XMapRequestEvent.wrap(XMapRequestEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XMapRequestEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XMapRequestEvent.wrap(XMapRequestEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XMapRequestEvent create(long l2) {
        return XMapRequestEvent.wrap(XMapRequestEvent.class, l2);
    }

    @Nullable
    public static XMapRequestEvent createSafe(long l2) {
        return l2 == 0L ? null : XMapRequestEvent.wrap(XMapRequestEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XMapRequestEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XMapRequestEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XMapRequestEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XMapRequestEvent.__create(n2, SIZEOF);
        return XMapRequestEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XMapRequestEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XMapRequestEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XMapRequestEvent mallocStack() {
        return XMapRequestEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMapRequestEvent callocStack() {
        return XMapRequestEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMapRequestEvent mallocStack(MemoryStack memoryStack) {
        return XMapRequestEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XMapRequestEvent callocStack(MemoryStack memoryStack) {
        return XMapRequestEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XMapRequestEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XMapRequestEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XMapRequestEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XMapRequestEvent.calloc(n2, memoryStack);
    }

    public static XMapRequestEvent malloc(MemoryStack memoryStack) {
        return XMapRequestEvent.wrap(XMapRequestEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XMapRequestEvent calloc(MemoryStack memoryStack) {
        return XMapRequestEvent.wrap(XMapRequestEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XMapRequestEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XMapRequestEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static long nparent(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)PARENT);
    }

    public static long nwindow(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)WINDOW);
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

    public static void nparent(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)PARENT, l3);
    }

    public static void nwindow(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)WINDOW, l3);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XMapRequestEvent.__struct(XMapRequestEvent.__member(4), XMapRequestEvent.__member(CLONG_SIZE), XMapRequestEvent.__member(4), XMapRequestEvent.__member(POINTER_SIZE), XMapRequestEvent.__member(CLONG_SIZE), XMapRequestEvent.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        PARENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XMapRequestEvent, Buffer>
    implements NativeResource {
        private static final XMapRequestEvent ELEMENT_FACTORY = XMapRequestEvent.create(-1L);

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
        protected XMapRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMapRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMapRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMapRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMapRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long parent() {
            return XMapRequestEvent.nparent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMapRequestEvent.nwindow(this.address());
        }

        public Buffer type(int n2) {
            XMapRequestEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XMapRequestEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XMapRequestEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XMapRequestEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer parent(@NativeType(value="Window") long l2) {
            XMapRequestEvent.nparent(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XMapRequestEvent.nwindow(this.address(), l2);
            return this;
        }
    }
}

