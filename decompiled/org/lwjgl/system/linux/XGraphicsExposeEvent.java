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

public class XGraphicsExposeEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int DRAWABLE;
    public static final int X;
    public static final int Y;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int COUNT;
    public static final int MAJOR_CODE;
    public static final int MINOR_CODE;

    public XGraphicsExposeEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XGraphicsExposeEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XGraphicsExposeEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XGraphicsExposeEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XGraphicsExposeEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XGraphicsExposeEvent.ndisplay(this.address());
    }

    @NativeType(value="Drawable")
    public long drawable() {
        return XGraphicsExposeEvent.ndrawable(this.address());
    }

    public int x() {
        return XGraphicsExposeEvent.nx(this.address());
    }

    public int y() {
        return XGraphicsExposeEvent.ny(this.address());
    }

    public int width() {
        return XGraphicsExposeEvent.nwidth(this.address());
    }

    public int height() {
        return XGraphicsExposeEvent.nheight(this.address());
    }

    public int count() {
        return XGraphicsExposeEvent.ncount(this.address());
    }

    public int major_code() {
        return XGraphicsExposeEvent.nmajor_code(this.address());
    }

    public int minor_code() {
        return XGraphicsExposeEvent.nminor_code(this.address());
    }

    public XGraphicsExposeEvent type(int n2) {
        XGraphicsExposeEvent.ntype(this.address(), n2);
        return this;
    }

    public XGraphicsExposeEvent serial(@NativeType(value="unsigned long") long l2) {
        XGraphicsExposeEvent.nserial(this.address(), l2);
        return this;
    }

    public XGraphicsExposeEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XGraphicsExposeEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XGraphicsExposeEvent display(@NativeType(value="Display *") long l2) {
        XGraphicsExposeEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XGraphicsExposeEvent drawable(@NativeType(value="Drawable") long l2) {
        XGraphicsExposeEvent.ndrawable(this.address(), l2);
        return this;
    }

    public XGraphicsExposeEvent x(int n2) {
        XGraphicsExposeEvent.nx(this.address(), n2);
        return this;
    }

    public XGraphicsExposeEvent y(int n2) {
        XGraphicsExposeEvent.ny(this.address(), n2);
        return this;
    }

    public XGraphicsExposeEvent width(int n2) {
        XGraphicsExposeEvent.nwidth(this.address(), n2);
        return this;
    }

    public XGraphicsExposeEvent height(int n2) {
        XGraphicsExposeEvent.nheight(this.address(), n2);
        return this;
    }

    public XGraphicsExposeEvent count(int n2) {
        XGraphicsExposeEvent.ncount(this.address(), n2);
        return this;
    }

    public XGraphicsExposeEvent major_code(int n2) {
        XGraphicsExposeEvent.nmajor_code(this.address(), n2);
        return this;
    }

    public XGraphicsExposeEvent minor_code(int n2) {
        XGraphicsExposeEvent.nminor_code(this.address(), n2);
        return this;
    }

    public XGraphicsExposeEvent set(int n2, long l2, boolean bl2, long l3, long l4, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.drawable(l4);
        this.x(n3);
        this.y(n4);
        this.width(n5);
        this.height(n6);
        this.count(n7);
        this.major_code(n8);
        this.minor_code(n9);
        return this;
    }

    public XGraphicsExposeEvent set(XGraphicsExposeEvent xGraphicsExposeEvent) {
        MemoryUtil.memCopy(xGraphicsExposeEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XGraphicsExposeEvent malloc() {
        return XGraphicsExposeEvent.wrap(XGraphicsExposeEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XGraphicsExposeEvent calloc() {
        return XGraphicsExposeEvent.wrap(XGraphicsExposeEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XGraphicsExposeEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XGraphicsExposeEvent.wrap(XGraphicsExposeEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XGraphicsExposeEvent create(long l2) {
        return XGraphicsExposeEvent.wrap(XGraphicsExposeEvent.class, l2);
    }

    @Nullable
    public static XGraphicsExposeEvent createSafe(long l2) {
        return l2 == 0L ? null : XGraphicsExposeEvent.wrap(XGraphicsExposeEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XGraphicsExposeEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XGraphicsExposeEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XGraphicsExposeEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XGraphicsExposeEvent.__create(n2, SIZEOF);
        return XGraphicsExposeEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XGraphicsExposeEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XGraphicsExposeEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XGraphicsExposeEvent mallocStack() {
        return XGraphicsExposeEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGraphicsExposeEvent callocStack() {
        return XGraphicsExposeEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGraphicsExposeEvent mallocStack(MemoryStack memoryStack) {
        return XGraphicsExposeEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XGraphicsExposeEvent callocStack(MemoryStack memoryStack) {
        return XGraphicsExposeEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XGraphicsExposeEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XGraphicsExposeEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XGraphicsExposeEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XGraphicsExposeEvent.calloc(n2, memoryStack);
    }

    public static XGraphicsExposeEvent malloc(MemoryStack memoryStack) {
        return XGraphicsExposeEvent.wrap(XGraphicsExposeEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XGraphicsExposeEvent calloc(MemoryStack memoryStack) {
        return XGraphicsExposeEvent.wrap(XGraphicsExposeEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XGraphicsExposeEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XGraphicsExposeEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static long ndrawable(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)DRAWABLE);
    }

    public static int nx(long l2) {
        return UNSAFE.getInt(null, l2 + (long)X);
    }

    public static int ny(long l2) {
        return UNSAFE.getInt(null, l2 + (long)Y);
    }

    public static int nwidth(long l2) {
        return UNSAFE.getInt(null, l2 + (long)WIDTH);
    }

    public static int nheight(long l2) {
        return UNSAFE.getInt(null, l2 + (long)HEIGHT);
    }

    public static int ncount(long l2) {
        return UNSAFE.getInt(null, l2 + (long)COUNT);
    }

    public static int nmajor_code(long l2) {
        return UNSAFE.getInt(null, l2 + (long)MAJOR_CODE);
    }

    public static int nminor_code(long l2) {
        return UNSAFE.getInt(null, l2 + (long)MINOR_CODE);
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

    public static void ndrawable(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)DRAWABLE, l3);
    }

    public static void nx(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)X, n2);
    }

    public static void ny(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)Y, n2);
    }

    public static void nwidth(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)WIDTH, n2);
    }

    public static void nheight(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)HEIGHT, n2);
    }

    public static void ncount(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)COUNT, n2);
    }

    public static void nmajor_code(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)MAJOR_CODE, n2);
    }

    public static void nminor_code(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)MINOR_CODE, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XGraphicsExposeEvent.__struct(XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(CLONG_SIZE), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(POINTER_SIZE), XGraphicsExposeEvent.__member(CLONG_SIZE), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        DRAWABLE = layout.offsetof(4);
        X = layout.offsetof(5);
        Y = layout.offsetof(6);
        WIDTH = layout.offsetof(7);
        HEIGHT = layout.offsetof(8);
        COUNT = layout.offsetof(9);
        MAJOR_CODE = layout.offsetof(10);
        MINOR_CODE = layout.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<XGraphicsExposeEvent, Buffer>
    implements NativeResource {
        private static final XGraphicsExposeEvent ELEMENT_FACTORY = XGraphicsExposeEvent.create(-1L);

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
        protected XGraphicsExposeEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XGraphicsExposeEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XGraphicsExposeEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XGraphicsExposeEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XGraphicsExposeEvent.ndisplay(this.address());
        }

        @NativeType(value="Drawable")
        public long drawable() {
            return XGraphicsExposeEvent.ndrawable(this.address());
        }

        public int x() {
            return XGraphicsExposeEvent.nx(this.address());
        }

        public int y() {
            return XGraphicsExposeEvent.ny(this.address());
        }

        public int width() {
            return XGraphicsExposeEvent.nwidth(this.address());
        }

        public int height() {
            return XGraphicsExposeEvent.nheight(this.address());
        }

        public int count() {
            return XGraphicsExposeEvent.ncount(this.address());
        }

        public int major_code() {
            return XGraphicsExposeEvent.nmajor_code(this.address());
        }

        public int minor_code() {
            return XGraphicsExposeEvent.nminor_code(this.address());
        }

        public Buffer type(int n2) {
            XGraphicsExposeEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XGraphicsExposeEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XGraphicsExposeEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XGraphicsExposeEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer drawable(@NativeType(value="Drawable") long l2) {
            XGraphicsExposeEvent.ndrawable(this.address(), l2);
            return this;
        }

        public Buffer x(int n2) {
            XGraphicsExposeEvent.nx(this.address(), n2);
            return this;
        }

        public Buffer y(int n2) {
            XGraphicsExposeEvent.ny(this.address(), n2);
            return this;
        }

        public Buffer width(int n2) {
            XGraphicsExposeEvent.nwidth(this.address(), n2);
            return this;
        }

        public Buffer height(int n2) {
            XGraphicsExposeEvent.nheight(this.address(), n2);
            return this;
        }

        public Buffer count(int n2) {
            XGraphicsExposeEvent.ncount(this.address(), n2);
            return this;
        }

        public Buffer major_code(int n2) {
            XGraphicsExposeEvent.nmajor_code(this.address(), n2);
            return this;
        }

        public Buffer minor_code(int n2) {
            XGraphicsExposeEvent.nminor_code(this.address(), n2);
            return this;
        }
    }
}

