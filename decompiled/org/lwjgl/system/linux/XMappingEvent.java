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

public class XMappingEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int REQUEST;
    public static final int FIRST_KEYCODE;
    public static final int COUNT;

    public XMappingEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XMappingEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMappingEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMappingEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMappingEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMappingEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMappingEvent.nwindow(this.address());
    }

    public int request() {
        return XMappingEvent.nrequest(this.address());
    }

    public int first_keycode() {
        return XMappingEvent.nfirst_keycode(this.address());
    }

    public int count() {
        return XMappingEvent.ncount(this.address());
    }

    public XMappingEvent type(int n2) {
        XMappingEvent.ntype(this.address(), n2);
        return this;
    }

    public XMappingEvent serial(@NativeType(value="unsigned long") long l2) {
        XMappingEvent.nserial(this.address(), l2);
        return this;
    }

    public XMappingEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XMappingEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XMappingEvent display(@NativeType(value="Display *") long l2) {
        XMappingEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XMappingEvent window(@NativeType(value="Window") long l2) {
        XMappingEvent.nwindow(this.address(), l2);
        return this;
    }

    public XMappingEvent request(int n2) {
        XMappingEvent.nrequest(this.address(), n2);
        return this;
    }

    public XMappingEvent first_keycode(int n2) {
        XMappingEvent.nfirst_keycode(this.address(), n2);
        return this;
    }

    public XMappingEvent count(int n2) {
        XMappingEvent.ncount(this.address(), n2);
        return this;
    }

    public XMappingEvent set(int n2, long l2, boolean bl2, long l3, long l4, int n3, int n4, int n5) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        this.request(n3);
        this.first_keycode(n4);
        this.count(n5);
        return this;
    }

    public XMappingEvent set(XMappingEvent xMappingEvent) {
        MemoryUtil.memCopy(xMappingEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMappingEvent malloc() {
        return XMappingEvent.wrap(XMappingEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XMappingEvent calloc() {
        return XMappingEvent.wrap(XMappingEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XMappingEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XMappingEvent.wrap(XMappingEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XMappingEvent create(long l2) {
        return XMappingEvent.wrap(XMappingEvent.class, l2);
    }

    @Nullable
    public static XMappingEvent createSafe(long l2) {
        return l2 == 0L ? null : XMappingEvent.wrap(XMappingEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XMappingEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XMappingEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XMappingEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XMappingEvent.__create(n2, SIZEOF);
        return XMappingEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XMappingEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XMappingEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XMappingEvent mallocStack() {
        return XMappingEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMappingEvent callocStack() {
        return XMappingEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMappingEvent mallocStack(MemoryStack memoryStack) {
        return XMappingEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XMappingEvent callocStack(MemoryStack memoryStack) {
        return XMappingEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XMappingEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XMappingEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XMappingEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XMappingEvent.calloc(n2, memoryStack);
    }

    public static XMappingEvent malloc(MemoryStack memoryStack) {
        return XMappingEvent.wrap(XMappingEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XMappingEvent calloc(MemoryStack memoryStack) {
        return XMappingEvent.wrap(XMappingEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XMappingEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XMappingEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static int nrequest(long l2) {
        return UNSAFE.getInt(null, l2 + (long)REQUEST);
    }

    public static int nfirst_keycode(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FIRST_KEYCODE);
    }

    public static int ncount(long l2) {
        return UNSAFE.getInt(null, l2 + (long)COUNT);
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

    public static void nrequest(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)REQUEST, n2);
    }

    public static void nfirst_keycode(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FIRST_KEYCODE, n2);
    }

    public static void ncount(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)COUNT, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XMappingEvent.__struct(XMappingEvent.__member(4), XMappingEvent.__member(CLONG_SIZE), XMappingEvent.__member(4), XMappingEvent.__member(POINTER_SIZE), XMappingEvent.__member(CLONG_SIZE), XMappingEvent.__member(4), XMappingEvent.__member(4), XMappingEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        REQUEST = layout.offsetof(5);
        FIRST_KEYCODE = layout.offsetof(6);
        COUNT = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XMappingEvent, Buffer>
    implements NativeResource {
        private static final XMappingEvent ELEMENT_FACTORY = XMappingEvent.create(-1L);

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
        protected XMappingEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMappingEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMappingEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMappingEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMappingEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMappingEvent.nwindow(this.address());
        }

        public int request() {
            return XMappingEvent.nrequest(this.address());
        }

        public int first_keycode() {
            return XMappingEvent.nfirst_keycode(this.address());
        }

        public int count() {
            return XMappingEvent.ncount(this.address());
        }

        public Buffer type(int n2) {
            XMappingEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XMappingEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XMappingEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XMappingEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XMappingEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer request(int n2) {
            XMappingEvent.nrequest(this.address(), n2);
            return this;
        }

        public Buffer first_keycode(int n2) {
            XMappingEvent.nfirst_keycode(this.address(), n2);
            return this;
        }

        public Buffer count(int n2) {
            XMappingEvent.ncount(this.address(), n2);
            return this;
        }
    }
}

