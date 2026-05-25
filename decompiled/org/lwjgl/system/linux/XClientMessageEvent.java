/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.CLongBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class XClientMessageEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int MESSAGE_TYPE;
    public static final int FORMAT;
    public static final int DATA;
    public static final int DATA_B;
    public static final int DATA_S;
    public static final int DATA_L;

    public XClientMessageEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XClientMessageEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XClientMessageEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XClientMessageEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XClientMessageEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XClientMessageEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XClientMessageEvent.nwindow(this.address());
    }

    @NativeType(value="Atom")
    public long message_type() {
        return XClientMessageEvent.nmessage_type(this.address());
    }

    public int format() {
        return XClientMessageEvent.nformat(this.address());
    }

    @NativeType(value="char[20]")
    public ByteBuffer data_b() {
        return XClientMessageEvent.ndata_b(this.address());
    }

    @NativeType(value="char")
    public byte data_b(int n2) {
        return XClientMessageEvent.ndata_b(this.address(), n2);
    }

    @NativeType(value="short[10]")
    public ShortBuffer data_s() {
        return XClientMessageEvent.ndata_s(this.address());
    }

    public short data_s(int n2) {
        return XClientMessageEvent.ndata_s(this.address(), n2);
    }

    @NativeType(value="long[5]")
    public CLongBuffer data_l() {
        return XClientMessageEvent.ndata_l(this.address());
    }

    public long data_l(int n2) {
        return XClientMessageEvent.ndata_l(this.address(), n2);
    }

    public XClientMessageEvent type(int n2) {
        XClientMessageEvent.ntype(this.address(), n2);
        return this;
    }

    public XClientMessageEvent serial(@NativeType(value="unsigned long") long l2) {
        XClientMessageEvent.nserial(this.address(), l2);
        return this;
    }

    public XClientMessageEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XClientMessageEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XClientMessageEvent display(@NativeType(value="Display *") long l2) {
        XClientMessageEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XClientMessageEvent window(@NativeType(value="Window") long l2) {
        XClientMessageEvent.nwindow(this.address(), l2);
        return this;
    }

    public XClientMessageEvent message_type(@NativeType(value="Atom") long l2) {
        XClientMessageEvent.nmessage_type(this.address(), l2);
        return this;
    }

    public XClientMessageEvent format(int n2) {
        XClientMessageEvent.nformat(this.address(), n2);
        return this;
    }

    public XClientMessageEvent data_b(@NativeType(value="char[20]") ByteBuffer byteBuffer) {
        XClientMessageEvent.ndata_b(this.address(), byteBuffer);
        return this;
    }

    public XClientMessageEvent data_b(int n2, @NativeType(value="char") byte by2) {
        XClientMessageEvent.ndata_b(this.address(), n2, by2);
        return this;
    }

    public XClientMessageEvent data_s(@NativeType(value="short[10]") ShortBuffer shortBuffer) {
        XClientMessageEvent.ndata_s(this.address(), shortBuffer);
        return this;
    }

    public XClientMessageEvent data_s(int n2, short s2) {
        XClientMessageEvent.ndata_s(this.address(), n2, s2);
        return this;
    }

    public XClientMessageEvent data_l(@NativeType(value="long[5]") CLongBuffer cLongBuffer) {
        XClientMessageEvent.ndata_l(this.address(), cLongBuffer);
        return this;
    }

    public XClientMessageEvent data_l(int n2, long l2) {
        XClientMessageEvent.ndata_l(this.address(), n2, l2);
        return this;
    }

    public XClientMessageEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, int n3, ByteBuffer byteBuffer, ShortBuffer shortBuffer, CLongBuffer cLongBuffer) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.window(l4);
        this.message_type(l5);
        this.format(n3);
        this.data_b(byteBuffer);
        this.data_s(shortBuffer);
        this.data_l(cLongBuffer);
        return this;
    }

    public XClientMessageEvent set(XClientMessageEvent xClientMessageEvent) {
        MemoryUtil.memCopy(xClientMessageEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XClientMessageEvent malloc() {
        return XClientMessageEvent.wrap(XClientMessageEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XClientMessageEvent calloc() {
        return XClientMessageEvent.wrap(XClientMessageEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XClientMessageEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XClientMessageEvent.wrap(XClientMessageEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XClientMessageEvent create(long l2) {
        return XClientMessageEvent.wrap(XClientMessageEvent.class, l2);
    }

    @Nullable
    public static XClientMessageEvent createSafe(long l2) {
        return l2 == 0L ? null : XClientMessageEvent.wrap(XClientMessageEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XClientMessageEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XClientMessageEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XClientMessageEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XClientMessageEvent.__create(n2, SIZEOF);
        return XClientMessageEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XClientMessageEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XClientMessageEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XClientMessageEvent mallocStack() {
        return XClientMessageEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XClientMessageEvent callocStack() {
        return XClientMessageEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XClientMessageEvent mallocStack(MemoryStack memoryStack) {
        return XClientMessageEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XClientMessageEvent callocStack(MemoryStack memoryStack) {
        return XClientMessageEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XClientMessageEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XClientMessageEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XClientMessageEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XClientMessageEvent.calloc(n2, memoryStack);
    }

    public static XClientMessageEvent malloc(MemoryStack memoryStack) {
        return XClientMessageEvent.wrap(XClientMessageEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XClientMessageEvent calloc(MemoryStack memoryStack) {
        return XClientMessageEvent.wrap(XClientMessageEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XClientMessageEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XClientMessageEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static long nmessage_type(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)MESSAGE_TYPE);
    }

    public static int nformat(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FORMAT);
    }

    public static ByteBuffer ndata_b(long l2) {
        return MemoryUtil.memByteBuffer(l2 + (long)DATA_B, 20);
    }

    public static byte ndata_b(long l2, int n2) {
        return UNSAFE.getByte(null, l2 + (long)DATA_B + Checks.check(n2, 20) * 1L);
    }

    public static ShortBuffer ndata_s(long l2) {
        return MemoryUtil.memShortBuffer(l2 + (long)DATA_S, 10);
    }

    public static short ndata_s(long l2, int n2) {
        return UNSAFE.getShort(null, l2 + (long)DATA_S + Checks.check(n2, 10) * 2L);
    }

    public static CLongBuffer ndata_l(long l2) {
        return MemoryUtil.memCLongBuffer(l2 + (long)DATA_L, 5);
    }

    public static long ndata_l(long l2, int n2) {
        return MemoryUtil.memGetCLong(l2 + (long)DATA_L + Checks.check(n2, 5) * (long)CLONG_SIZE);
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

    public static void nmessage_type(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)MESSAGE_TYPE, l3);
    }

    public static void nformat(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FORMAT, n2);
    }

    public static void ndata_b(long l2, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(byteBuffer, 20);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(byteBuffer), l2 + (long)DATA_B, byteBuffer.remaining() * 1);
    }

    public static void ndata_b(long l2, int n2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)DATA_B + Checks.check(n2, 20) * 1L, by2);
    }

    public static void ndata_s(long l2, ShortBuffer shortBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(shortBuffer, 10);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(shortBuffer), l2 + (long)DATA_S, shortBuffer.remaining() * 2);
    }

    public static void ndata_s(long l2, int n2, short s2) {
        UNSAFE.putShort(null, l2 + (long)DATA_S + Checks.check(n2, 10) * 2L, s2);
    }

    public static void ndata_l(long l2, CLongBuffer cLongBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(cLongBuffer, 5);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(cLongBuffer), l2 + (long)DATA_L, cLongBuffer.remaining() * CLONG_SIZE);
    }

    public static void ndata_l(long l2, int n2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)DATA_L + Checks.check(n2, 5) * (long)CLONG_SIZE, l3);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XClientMessageEvent.__struct(XClientMessageEvent.__member(4), XClientMessageEvent.__member(CLONG_SIZE), XClientMessageEvent.__member(4), XClientMessageEvent.__member(POINTER_SIZE), XClientMessageEvent.__member(CLONG_SIZE), XClientMessageEvent.__member(CLONG_SIZE), XClientMessageEvent.__member(4), XClientMessageEvent.__struct(XClientMessageEvent.__array(1, 20), XClientMessageEvent.__array(2, 10), XClientMessageEvent.__array(CLONG_SIZE, 5)));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        MESSAGE_TYPE = layout.offsetof(5);
        FORMAT = layout.offsetof(6);
        DATA = layout.offsetof(7);
        DATA_B = layout.offsetof(8);
        DATA_S = layout.offsetof(9);
        DATA_L = layout.offsetof(10);
    }

    public static class Buffer
    extends StructBuffer<XClientMessageEvent, Buffer>
    implements NativeResource {
        private static final XClientMessageEvent ELEMENT_FACTORY = XClientMessageEvent.create(-1L);

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
        protected XClientMessageEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XClientMessageEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XClientMessageEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XClientMessageEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XClientMessageEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XClientMessageEvent.nwindow(this.address());
        }

        @NativeType(value="Atom")
        public long message_type() {
            return XClientMessageEvent.nmessage_type(this.address());
        }

        public int format() {
            return XClientMessageEvent.nformat(this.address());
        }

        @NativeType(value="char[20]")
        public ByteBuffer data_b() {
            return XClientMessageEvent.ndata_b(this.address());
        }

        @NativeType(value="char")
        public byte data_b(int n2) {
            return XClientMessageEvent.ndata_b(this.address(), n2);
        }

        @NativeType(value="short[10]")
        public ShortBuffer data_s() {
            return XClientMessageEvent.ndata_s(this.address());
        }

        public short data_s(int n2) {
            return XClientMessageEvent.ndata_s(this.address(), n2);
        }

        @NativeType(value="long[5]")
        public CLongBuffer data_l() {
            return XClientMessageEvent.ndata_l(this.address());
        }

        public long data_l(int n2) {
            return XClientMessageEvent.ndata_l(this.address(), n2);
        }

        public Buffer type(int n2) {
            XClientMessageEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XClientMessageEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XClientMessageEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XClientMessageEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l2) {
            XClientMessageEvent.nwindow(this.address(), l2);
            return this;
        }

        public Buffer message_type(@NativeType(value="Atom") long l2) {
            XClientMessageEvent.nmessage_type(this.address(), l2);
            return this;
        }

        public Buffer format(int n2) {
            XClientMessageEvent.nformat(this.address(), n2);
            return this;
        }

        public Buffer data_b(@NativeType(value="char[20]") ByteBuffer byteBuffer) {
            XClientMessageEvent.ndata_b(this.address(), byteBuffer);
            return this;
        }

        public Buffer data_b(int n2, @NativeType(value="char") byte by2) {
            XClientMessageEvent.ndata_b(this.address(), n2, by2);
            return this;
        }

        public Buffer data_s(@NativeType(value="short[10]") ShortBuffer shortBuffer) {
            XClientMessageEvent.ndata_s(this.address(), shortBuffer);
            return this;
        }

        public Buffer data_s(int n2, short s2) {
            XClientMessageEvent.ndata_s(this.address(), n2, s2);
            return this;
        }

        public Buffer data_l(@NativeType(value="long[5]") CLongBuffer cLongBuffer) {
            XClientMessageEvent.ndata_l(this.address(), cLongBuffer);
            return this;
        }

        public Buffer data_l(int n2, long l2) {
            XClientMessageEvent.ndata_l(this.address(), n2, l2);
            return this;
        }
    }
}

