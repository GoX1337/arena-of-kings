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

public class XKeymapEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int KEY_VECTOR;

    public XKeymapEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XKeymapEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XKeymapEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XKeymapEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XKeymapEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XKeymapEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XKeymapEvent.nwindow(this.address());
    }

    @NativeType(value="char[32]")
    public ByteBuffer key_vector() {
        return XKeymapEvent.nkey_vector(this.address());
    }

    @NativeType(value="char")
    public byte key_vector(int n2) {
        return XKeymapEvent.nkey_vector(this.address(), n2);
    }

    public XKeymapEvent type(int n2) {
        XKeymapEvent.ntype(this.address(), n2);
        return this;
    }

    public XKeymapEvent serial(@NativeType(value="unsigned long") long l2) {
        XKeymapEvent.nserial(this.address(), l2);
        return this;
    }

    public XKeymapEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XKeymapEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XKeymapEvent display(@NativeType(value="Display *") long l2) {
        XKeymapEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XKeymapEvent window(@NativeType(value="Window") long l2) {
        XKeymapEvent.nwindow(this.address(), l2);
        return this;
    }

    public XKeymapEvent key_vector(@NativeType(value="char[32]") ByteBuffer byteBuffer) {
        XKeymapEvent.nkey_vector(this.address(), byteBuffer);
        return this;
    }

    public XKeymapEvent key_vector(int n2, @NativeType(value="char") byte by2) {
        XKeymapEvent.nkey_vector(this.address(), n2, by2);
        return this;
    }

    public XKeymapEvent set(int n2, long l2, boolean bl2, long l3, long l4, ByteBuffer byteBuffer) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        this.key_vector(byteBuffer);
        return this;
    }

    public XKeymapEvent set(XKeymapEvent xKeymapEvent) {
        MemoryUtil.memCopy(xKeymapEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XKeymapEvent malloc() {
        return XKeymapEvent.wrap(XKeymapEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XKeymapEvent calloc() {
        return XKeymapEvent.wrap(XKeymapEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XKeymapEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XKeymapEvent.wrap(XKeymapEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XKeymapEvent create(long l2) {
        return XKeymapEvent.wrap(XKeymapEvent.class, l2);
    }

    @Nullable
    public static XKeymapEvent createSafe(long l2) {
        return l2 == 0L ? null : XKeymapEvent.wrap(XKeymapEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XKeymapEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XKeymapEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XKeymapEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XKeymapEvent.__create(n2, SIZEOF);
        return XKeymapEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XKeymapEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XKeymapEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XKeymapEvent mallocStack() {
        return XKeymapEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XKeymapEvent callocStack() {
        return XKeymapEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XKeymapEvent mallocStack(MemoryStack memoryStack) {
        return XKeymapEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XKeymapEvent callocStack(MemoryStack memoryStack) {
        return XKeymapEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XKeymapEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XKeymapEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XKeymapEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XKeymapEvent.calloc(n2, memoryStack);
    }

    public static XKeymapEvent malloc(MemoryStack memoryStack) {
        return XKeymapEvent.wrap(XKeymapEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XKeymapEvent calloc(MemoryStack memoryStack) {
        return XKeymapEvent.wrap(XKeymapEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XKeymapEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XKeymapEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static ByteBuffer nkey_vector(long l2) {
        return MemoryUtil.memByteBuffer(l2 + (long)KEY_VECTOR, 32);
    }

    public static byte nkey_vector(long l2, int n2) {
        return UNSAFE.getByte(null, l2 + (long)KEY_VECTOR + Checks.check(n2, 32) * 1L);
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

    public static void nkey_vector(long l2, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(byteBuffer, 32);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(byteBuffer), l2 + (long)KEY_VECTOR, byteBuffer.remaining() * 1);
    }

    public static void nkey_vector(long l2, int n2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)KEY_VECTOR + Checks.check(n2, 32) * 1L, by2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XKeymapEvent.__struct(XKeymapEvent.__member(4), XKeymapEvent.__member(CLONG_SIZE), XKeymapEvent.__member(4), XKeymapEvent.__member(POINTER_SIZE), XKeymapEvent.__member(CLONG_SIZE), XKeymapEvent.__array(1, 32));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        KEY_VECTOR = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XKeymapEvent, Buffer>
    implements NativeResource {
        private static final XKeymapEvent ELEMENT_FACTORY = XKeymapEvent.create(-1L);

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
        protected XKeymapEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XKeymapEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XKeymapEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XKeymapEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XKeymapEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XKeymapEvent.nwindow(this.address());
        }

        @NativeType(value="char[32]")
        public ByteBuffer key_vector() {
            return XKeymapEvent.nkey_vector(this.address());
        }

        @NativeType(value="char")
        public byte key_vector(int n2) {
            return XKeymapEvent.nkey_vector(this.address(), n2);
        }

        public Buffer type(int n2) {
            XKeymapEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XKeymapEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XKeymapEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XKeymapEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XKeymapEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer key_vector(@NativeType(value="char[32]") ByteBuffer byteBuffer) {
            XKeymapEvent.nkey_vector(this.address(), byteBuffer);
            return this;
        }

        public Buffer key_vector(int n2, @NativeType(value="char") byte by2) {
            XKeymapEvent.nkey_vector(this.address(), n2, by2);
            return this;
        }
    }
}

