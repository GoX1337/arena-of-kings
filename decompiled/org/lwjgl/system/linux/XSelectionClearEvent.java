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

public class XSelectionClearEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int SELECTION;
    public static final int TIME;

    public XSelectionClearEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XSelectionClearEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XSelectionClearEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XSelectionClearEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XSelectionClearEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XSelectionClearEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XSelectionClearEvent.nwindow(this.address());
    }

    @NativeType(value="Atom")
    public long selection() {
        return XSelectionClearEvent.nselection(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XSelectionClearEvent.ntime(this.address());
    }

    public XSelectionClearEvent type(int n2) {
        XSelectionClearEvent.ntype(this.address(), n2);
        return this;
    }

    public XSelectionClearEvent serial(@NativeType(value="unsigned long") long l2) {
        XSelectionClearEvent.nserial(this.address(), l2);
        return this;
    }

    public XSelectionClearEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XSelectionClearEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XSelectionClearEvent display(@NativeType(value="Display *") long l2) {
        XSelectionClearEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XSelectionClearEvent window(@NativeType(value="Window") long l2) {
        XSelectionClearEvent.nwindow(this.address(), l2);
        return this;
    }

    public XSelectionClearEvent selection(@NativeType(value="Atom") long l2) {
        XSelectionClearEvent.nselection(this.address(), l2);
        return this;
    }

    public XSelectionClearEvent time(@NativeType(value="Time") long l2) {
        XSelectionClearEvent.ntime(this.address(), l2);
        return this;
    }

    public XSelectionClearEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, long l6) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        this.selection(l5);
        this.time(l6);
        return this;
    }

    public XSelectionClearEvent set(XSelectionClearEvent xSelectionClearEvent) {
        MemoryUtil.memCopy(xSelectionClearEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XSelectionClearEvent malloc() {
        return XSelectionClearEvent.wrap(XSelectionClearEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XSelectionClearEvent calloc() {
        return XSelectionClearEvent.wrap(XSelectionClearEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XSelectionClearEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XSelectionClearEvent.wrap(XSelectionClearEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XSelectionClearEvent create(long l2) {
        return XSelectionClearEvent.wrap(XSelectionClearEvent.class, l2);
    }

    @Nullable
    public static XSelectionClearEvent createSafe(long l2) {
        return l2 == 0L ? null : XSelectionClearEvent.wrap(XSelectionClearEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XSelectionClearEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XSelectionClearEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XSelectionClearEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XSelectionClearEvent.__create(n2, SIZEOF);
        return XSelectionClearEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XSelectionClearEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XSelectionClearEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XSelectionClearEvent mallocStack() {
        return XSelectionClearEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSelectionClearEvent callocStack() {
        return XSelectionClearEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSelectionClearEvent mallocStack(MemoryStack memoryStack) {
        return XSelectionClearEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XSelectionClearEvent callocStack(MemoryStack memoryStack) {
        return XSelectionClearEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XSelectionClearEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XSelectionClearEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XSelectionClearEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XSelectionClearEvent.calloc(n2, memoryStack);
    }

    public static XSelectionClearEvent malloc(MemoryStack memoryStack) {
        return XSelectionClearEvent.wrap(XSelectionClearEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XSelectionClearEvent calloc(MemoryStack memoryStack) {
        return XSelectionClearEvent.wrap(XSelectionClearEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XSelectionClearEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XSelectionClearEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static long nselection(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)SELECTION);
    }

    public static long ntime(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)TIME);
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

    public static void nselection(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)SELECTION, l3);
    }

    public static void ntime(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)TIME, l3);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XSelectionClearEvent.__struct(XSelectionClearEvent.__member(4), XSelectionClearEvent.__member(CLONG_SIZE), XSelectionClearEvent.__member(4), XSelectionClearEvent.__member(POINTER_SIZE), XSelectionClearEvent.__member(CLONG_SIZE), XSelectionClearEvent.__member(CLONG_SIZE), XSelectionClearEvent.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        SELECTION = layout.offsetof(5);
        TIME = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XSelectionClearEvent, Buffer>
    implements NativeResource {
        private static final XSelectionClearEvent ELEMENT_FACTORY = XSelectionClearEvent.create(-1L);

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
        protected XSelectionClearEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XSelectionClearEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XSelectionClearEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XSelectionClearEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XSelectionClearEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XSelectionClearEvent.nwindow(this.address());
        }

        @NativeType(value="Atom")
        public long selection() {
            return XSelectionClearEvent.nselection(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XSelectionClearEvent.ntime(this.address());
        }

        public Buffer type(int n2) {
            XSelectionClearEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XSelectionClearEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XSelectionClearEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XSelectionClearEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XSelectionClearEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer selection(@NativeType(value="Atom") long l2) {
            XSelectionClearEvent.nselection(this.address(), l2);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l2) {
            XSelectionClearEvent.ntime(this.address(), l2);
            return this;
        }
    }
}

