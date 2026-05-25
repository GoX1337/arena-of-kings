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

public class XNoExposeEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int DRAWABLE;
    public static final int MAJOR_CODE;
    public static final int MINOR_CODE;

    public XNoExposeEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XNoExposeEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XNoExposeEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XNoExposeEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XNoExposeEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XNoExposeEvent.ndisplay(this.address());
    }

    @NativeType(value="Drawable")
    public long drawable() {
        return XNoExposeEvent.ndrawable(this.address());
    }

    public int major_code() {
        return XNoExposeEvent.nmajor_code(this.address());
    }

    public int minor_code() {
        return XNoExposeEvent.nminor_code(this.address());
    }

    public XNoExposeEvent type(int n2) {
        XNoExposeEvent.ntype(this.address(), n2);
        return this;
    }

    public XNoExposeEvent serial(@NativeType(value="unsigned long") long l2) {
        XNoExposeEvent.nserial(this.address(), l2);
        return this;
    }

    public XNoExposeEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XNoExposeEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XNoExposeEvent display(@NativeType(value="Display *") long l2) {
        XNoExposeEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XNoExposeEvent drawable(@NativeType(value="Drawable") long l2) {
        XNoExposeEvent.ndrawable(this.address(), l2);
        return this;
    }

    public XNoExposeEvent major_code(int n2) {
        XNoExposeEvent.nmajor_code(this.address(), n2);
        return this;
    }

    public XNoExposeEvent minor_code(int n2) {
        XNoExposeEvent.nminor_code(this.address(), n2);
        return this;
    }

    public XNoExposeEvent set(int n2, long l2, boolean bl2, long l3, long l4, int n3, int n4) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.drawable(l4);
        this.major_code(n3);
        this.minor_code(n4);
        return this;
    }

    public XNoExposeEvent set(XNoExposeEvent xNoExposeEvent) {
        MemoryUtil.memCopy(xNoExposeEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XNoExposeEvent malloc() {
        return XNoExposeEvent.wrap(XNoExposeEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XNoExposeEvent calloc() {
        return XNoExposeEvent.wrap(XNoExposeEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XNoExposeEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XNoExposeEvent.wrap(XNoExposeEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XNoExposeEvent create(long l2) {
        return XNoExposeEvent.wrap(XNoExposeEvent.class, l2);
    }

    @Nullable
    public static XNoExposeEvent createSafe(long l2) {
        return l2 == 0L ? null : XNoExposeEvent.wrap(XNoExposeEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XNoExposeEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XNoExposeEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XNoExposeEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XNoExposeEvent.__create(n2, SIZEOF);
        return XNoExposeEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XNoExposeEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XNoExposeEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XNoExposeEvent mallocStack() {
        return XNoExposeEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XNoExposeEvent callocStack() {
        return XNoExposeEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XNoExposeEvent mallocStack(MemoryStack memoryStack) {
        return XNoExposeEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XNoExposeEvent callocStack(MemoryStack memoryStack) {
        return XNoExposeEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XNoExposeEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XNoExposeEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XNoExposeEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XNoExposeEvent.calloc(n2, memoryStack);
    }

    public static XNoExposeEvent malloc(MemoryStack memoryStack) {
        return XNoExposeEvent.wrap(XNoExposeEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XNoExposeEvent calloc(MemoryStack memoryStack) {
        return XNoExposeEvent.wrap(XNoExposeEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XNoExposeEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XNoExposeEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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
        Struct.Layout layout = XNoExposeEvent.__struct(XNoExposeEvent.__member(4), XNoExposeEvent.__member(CLONG_SIZE), XNoExposeEvent.__member(4), XNoExposeEvent.__member(POINTER_SIZE), XNoExposeEvent.__member(CLONG_SIZE), XNoExposeEvent.__member(4), XNoExposeEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        DRAWABLE = layout.offsetof(4);
        MAJOR_CODE = layout.offsetof(5);
        MINOR_CODE = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XNoExposeEvent, Buffer>
    implements NativeResource {
        private static final XNoExposeEvent ELEMENT_FACTORY = XNoExposeEvent.create(-1L);

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
        protected XNoExposeEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XNoExposeEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XNoExposeEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XNoExposeEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XNoExposeEvent.ndisplay(this.address());
        }

        @NativeType(value="Drawable")
        public long drawable() {
            return XNoExposeEvent.ndrawable(this.address());
        }

        public int major_code() {
            return XNoExposeEvent.nmajor_code(this.address());
        }

        public int minor_code() {
            return XNoExposeEvent.nminor_code(this.address());
        }

        public Buffer type(int n2) {
            XNoExposeEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XNoExposeEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XNoExposeEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XNoExposeEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer drawable(@NativeType(value="Drawable") long l2) {
            XNoExposeEvent.ndrawable(this.address(), l2);
            return this;
        }

        public Buffer major_code(int n2) {
            XNoExposeEvent.nmajor_code(this.address(), n2);
            return this;
        }

        public Buffer minor_code(int n2) {
            XNoExposeEvent.nminor_code(this.address(), n2);
            return this;
        }
    }
}

