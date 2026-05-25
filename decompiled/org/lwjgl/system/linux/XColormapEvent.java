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

public class XColormapEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int COLORMAP;
    public static final int NEW;
    public static final int STATE;

    public XColormapEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XColormapEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XColormapEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XColormapEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XColormapEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XColormapEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XColormapEvent.nwindow(this.address());
    }

    @NativeType(value="Colormap")
    public long colormap() {
        return XColormapEvent.ncolormap(this.address());
    }

    public int new$() {
        return XColormapEvent.nnew$(this.address());
    }

    public int state() {
        return XColormapEvent.nstate(this.address());
    }

    public XColormapEvent type(int n2) {
        XColormapEvent.ntype(this.address(), n2);
        return this;
    }

    public XColormapEvent serial(@NativeType(value="unsigned long") long l2) {
        XColormapEvent.nserial(this.address(), l2);
        return this;
    }

    public XColormapEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XColormapEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XColormapEvent display(@NativeType(value="Display *") long l2) {
        XColormapEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XColormapEvent window(@NativeType(value="Window") long l2) {
        XColormapEvent.nwindow(this.address(), l2);
        return this;
    }

    public XColormapEvent colormap(@NativeType(value="Colormap") long l2) {
        XColormapEvent.ncolormap(this.address(), l2);
        return this;
    }

    public XColormapEvent new$(int n2) {
        XColormapEvent.nnew$(this.address(), n2);
        return this;
    }

    public XColormapEvent state(int n2) {
        XColormapEvent.nstate(this.address(), n2);
        return this;
    }

    public XColormapEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, int n3, int n4) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        this.colormap(l5);
        this.new$(n3);
        this.state(n4);
        return this;
    }

    public XColormapEvent set(XColormapEvent xColormapEvent) {
        MemoryUtil.memCopy(xColormapEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XColormapEvent malloc() {
        return XColormapEvent.wrap(XColormapEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XColormapEvent calloc() {
        return XColormapEvent.wrap(XColormapEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XColormapEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XColormapEvent.wrap(XColormapEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XColormapEvent create(long l2) {
        return XColormapEvent.wrap(XColormapEvent.class, l2);
    }

    @Nullable
    public static XColormapEvent createSafe(long l2) {
        return l2 == 0L ? null : XColormapEvent.wrap(XColormapEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XColormapEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XColormapEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XColormapEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XColormapEvent.__create(n2, SIZEOF);
        return XColormapEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XColormapEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XColormapEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XColormapEvent mallocStack() {
        return XColormapEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XColormapEvent callocStack() {
        return XColormapEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XColormapEvent mallocStack(MemoryStack memoryStack) {
        return XColormapEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XColormapEvent callocStack(MemoryStack memoryStack) {
        return XColormapEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XColormapEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XColormapEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XColormapEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XColormapEvent.calloc(n2, memoryStack);
    }

    public static XColormapEvent malloc(MemoryStack memoryStack) {
        return XColormapEvent.wrap(XColormapEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XColormapEvent calloc(MemoryStack memoryStack) {
        return XColormapEvent.wrap(XColormapEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XColormapEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XColormapEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static long ncolormap(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)COLORMAP);
    }

    public static int nnew$(long l2) {
        return UNSAFE.getInt(null, l2 + (long)NEW);
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

    public static void ncolormap(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)COLORMAP, l3);
    }

    public static void nnew$(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)NEW, n2);
    }

    public static void nstate(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)STATE, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XColormapEvent.__struct(XColormapEvent.__member(4), XColormapEvent.__member(CLONG_SIZE), XColormapEvent.__member(4), XColormapEvent.__member(POINTER_SIZE), XColormapEvent.__member(CLONG_SIZE), XColormapEvent.__member(CLONG_SIZE), XColormapEvent.__member(4), XColormapEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        COLORMAP = layout.offsetof(5);
        NEW = layout.offsetof(6);
        STATE = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XColormapEvent, Buffer>
    implements NativeResource {
        private static final XColormapEvent ELEMENT_FACTORY = XColormapEvent.create(-1L);

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
        protected XColormapEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XColormapEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XColormapEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XColormapEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XColormapEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XColormapEvent.nwindow(this.address());
        }

        @NativeType(value="Colormap")
        public long colormap() {
            return XColormapEvent.ncolormap(this.address());
        }

        public int new$() {
            return XColormapEvent.nnew$(this.address());
        }

        public int state() {
            return XColormapEvent.nstate(this.address());
        }

        public Buffer type(int n2) {
            XColormapEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XColormapEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XColormapEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XColormapEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XColormapEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer colormap(@NativeType(value="Colormap") long l2) {
            XColormapEvent.ncolormap(this.address(), l2);
            return this;
        }

        public Buffer new$(int n2) {
            XColormapEvent.nnew$(this.address(), n2);
            return this;
        }

        public Buffer state(int n2) {
            XColormapEvent.nstate(this.address(), n2);
            return this;
        }
    }
}

