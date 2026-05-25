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

public class XGravityEvent
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
    public static final int X;
    public static final int Y;

    public XGravityEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XGravityEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XGravityEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XGravityEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XGravityEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XGravityEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long event() {
        return XGravityEvent.nevent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XGravityEvent.nwindow(this.address());
    }

    public int x() {
        return XGravityEvent.nx(this.address());
    }

    public int y() {
        return XGravityEvent.ny(this.address());
    }

    public XGravityEvent type(int n2) {
        XGravityEvent.ntype(this.address(), n2);
        return this;
    }

    public XGravityEvent serial(@NativeType(value="unsigned long") long l2) {
        XGravityEvent.nserial(this.address(), l2);
        return this;
    }

    public XGravityEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XGravityEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XGravityEvent display(@NativeType(value="Display *") long l2) {
        XGravityEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XGravityEvent event(@NativeType(value="Window") long l2) {
        XGravityEvent.nevent(this.address(), l2);
        return this;
    }

    public XGravityEvent window(@NativeType(value="Window") long l2) {
        XGravityEvent.nwindow(this.address(), l2);
        return this;
    }

    public XGravityEvent x(int n2) {
        XGravityEvent.nx(this.address(), n2);
        return this;
    }

    public XGravityEvent y(int n2) {
        XGravityEvent.ny(this.address(), n2);
        return this;
    }

    public XGravityEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, int n3, int n4) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.event(l4);
        this.window(l5);
        this.x(n3);
        this.y(n4);
        return this;
    }

    public XGravityEvent set(XGravityEvent xGravityEvent) {
        MemoryUtil.memCopy(xGravityEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XGravityEvent malloc() {
        return XGravityEvent.wrap(XGravityEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XGravityEvent calloc() {
        return XGravityEvent.wrap(XGravityEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XGravityEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XGravityEvent.wrap(XGravityEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XGravityEvent create(long l2) {
        return XGravityEvent.wrap(XGravityEvent.class, l2);
    }

    @Nullable
    public static XGravityEvent createSafe(long l2) {
        return l2 == 0L ? null : XGravityEvent.wrap(XGravityEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XGravityEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XGravityEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XGravityEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XGravityEvent.__create(n2, SIZEOF);
        return XGravityEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XGravityEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XGravityEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XGravityEvent mallocStack() {
        return XGravityEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGravityEvent callocStack() {
        return XGravityEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGravityEvent mallocStack(MemoryStack memoryStack) {
        return XGravityEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XGravityEvent callocStack(MemoryStack memoryStack) {
        return XGravityEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XGravityEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XGravityEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XGravityEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XGravityEvent.calloc(n2, memoryStack);
    }

    public static XGravityEvent malloc(MemoryStack memoryStack) {
        return XGravityEvent.wrap(XGravityEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XGravityEvent calloc(MemoryStack memoryStack) {
        return XGravityEvent.wrap(XGravityEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XGravityEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XGravityEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static int nx(long l2) {
        return UNSAFE.getInt(null, l2 + (long)X);
    }

    public static int ny(long l2) {
        return UNSAFE.getInt(null, l2 + (long)Y);
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

    public static void nx(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)X, n2);
    }

    public static void ny(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)Y, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XGravityEvent.__struct(XGravityEvent.__member(4), XGravityEvent.__member(CLONG_SIZE), XGravityEvent.__member(4), XGravityEvent.__member(POINTER_SIZE), XGravityEvent.__member(CLONG_SIZE), XGravityEvent.__member(CLONG_SIZE), XGravityEvent.__member(4), XGravityEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EVENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
        X = layout.offsetof(6);
        Y = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XGravityEvent, Buffer>
    implements NativeResource {
        private static final XGravityEvent ELEMENT_FACTORY = XGravityEvent.create(-1L);

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
        protected XGravityEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XGravityEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XGravityEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XGravityEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XGravityEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long event() {
            return XGravityEvent.nevent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XGravityEvent.nwindow(this.address());
        }

        public int x() {
            return XGravityEvent.nx(this.address());
        }

        public int y() {
            return XGravityEvent.ny(this.address());
        }

        public Buffer type(int n2) {
            XGravityEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XGravityEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XGravityEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XGravityEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer event(@NativeType(value="Window") long l2) {
            XGravityEvent.nevent(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XGravityEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer x(int n2) {
            XGravityEvent.nx(this.address(), n2);
            return this;
        }

        public Buffer y(int n2) {
            XGravityEvent.ny(this.address(), n2);
            return this;
        }
    }
}

