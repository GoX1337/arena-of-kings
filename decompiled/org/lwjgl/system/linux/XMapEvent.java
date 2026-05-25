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

public class XMapEvent
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
    public static final int OVERRIDE_REDIRECT;

    public XMapEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XMapEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMapEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMapEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMapEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMapEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long event() {
        return XMapEvent.nevent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMapEvent.nwindow(this.address());
    }

    public int override_redirect() {
        return XMapEvent.noverride_redirect(this.address());
    }

    public XMapEvent type(int n2) {
        XMapEvent.ntype(this.address(), n2);
        return this;
    }

    public XMapEvent serial(@NativeType(value="unsigned long") long l2) {
        XMapEvent.nserial(this.address(), l2);
        return this;
    }

    public XMapEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XMapEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XMapEvent display(@NativeType(value="Display *") long l2) {
        XMapEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XMapEvent event(@NativeType(value="Window") long l2) {
        XMapEvent.nevent(this.address(), l2);
        return this;
    }

    public XMapEvent window(@NativeType(value="Window") long l2) {
        XMapEvent.nwindow(this.address(), l2);
        return this;
    }

    public XMapEvent override_redirect(int n2) {
        XMapEvent.noverride_redirect(this.address(), n2);
        return this;
    }

    public XMapEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, int n3) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.event(l4);
        this.window(l5);
        this.override_redirect(n3);
        return this;
    }

    public XMapEvent set(XMapEvent xMapEvent) {
        MemoryUtil.memCopy(xMapEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMapEvent malloc() {
        return XMapEvent.wrap(XMapEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XMapEvent calloc() {
        return XMapEvent.wrap(XMapEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XMapEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XMapEvent.wrap(XMapEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XMapEvent create(long l2) {
        return XMapEvent.wrap(XMapEvent.class, l2);
    }

    @Nullable
    public static XMapEvent createSafe(long l2) {
        return l2 == 0L ? null : XMapEvent.wrap(XMapEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XMapEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XMapEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XMapEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XMapEvent.__create(n2, SIZEOF);
        return XMapEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XMapEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XMapEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XMapEvent mallocStack() {
        return XMapEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMapEvent callocStack() {
        return XMapEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMapEvent mallocStack(MemoryStack memoryStack) {
        return XMapEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XMapEvent callocStack(MemoryStack memoryStack) {
        return XMapEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XMapEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XMapEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XMapEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XMapEvent.calloc(n2, memoryStack);
    }

    public static XMapEvent malloc(MemoryStack memoryStack) {
        return XMapEvent.wrap(XMapEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XMapEvent calloc(MemoryStack memoryStack) {
        return XMapEvent.wrap(XMapEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XMapEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XMapEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static int noverride_redirect(long l2) {
        return UNSAFE.getInt(null, l2 + (long)OVERRIDE_REDIRECT);
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

    public static void noverride_redirect(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)OVERRIDE_REDIRECT, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XMapEvent.__struct(XMapEvent.__member(4), XMapEvent.__member(CLONG_SIZE), XMapEvent.__member(4), XMapEvent.__member(POINTER_SIZE), XMapEvent.__member(CLONG_SIZE), XMapEvent.__member(CLONG_SIZE), XMapEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EVENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
        OVERRIDE_REDIRECT = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XMapEvent, Buffer>
    implements NativeResource {
        private static final XMapEvent ELEMENT_FACTORY = XMapEvent.create(-1L);

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
        protected XMapEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMapEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMapEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMapEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMapEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long event() {
            return XMapEvent.nevent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMapEvent.nwindow(this.address());
        }

        public int override_redirect() {
            return XMapEvent.noverride_redirect(this.address());
        }

        public Buffer type(int n2) {
            XMapEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XMapEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XMapEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XMapEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer event(@NativeType(value="Window") long l2) {
            XMapEvent.nevent(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XMapEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer override_redirect(int n2) {
            XMapEvent.noverride_redirect(this.address(), n2);
            return this;
        }
    }
}

