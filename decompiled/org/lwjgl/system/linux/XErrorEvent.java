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

public class XErrorEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int DISPLAY;
    public static final int RESOURCEID;
    public static final int SERIAL;
    public static final int ERROR_CODE;
    public static final int REQUEST_CODE;
    public static final int MINOR_CODE;

    public XErrorEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XErrorEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XErrorEvent.ntype(this.address());
    }

    @NativeType(value="Display *")
    public long display() {
        return XErrorEvent.ndisplay(this.address());
    }

    @NativeType(value="XID")
    public long resourceid() {
        return XErrorEvent.nresourceid(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XErrorEvent.nserial(this.address());
    }

    @NativeType(value="unsigned char")
    public byte error_code() {
        return XErrorEvent.nerror_code(this.address());
    }

    @NativeType(value="unsigned char")
    public byte request_code() {
        return XErrorEvent.nrequest_code(this.address());
    }

    @NativeType(value="unsigned char")
    public byte minor_code() {
        return XErrorEvent.nminor_code(this.address());
    }

    public XErrorEvent type(int n2) {
        XErrorEvent.ntype(this.address(), n2);
        return this;
    }

    public XErrorEvent display(@NativeType(value="Display *") long l2) {
        XErrorEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XErrorEvent resourceid(@NativeType(value="XID") long l2) {
        XErrorEvent.nresourceid(this.address(), l2);
        return this;
    }

    public XErrorEvent serial(@NativeType(value="unsigned long") long l2) {
        XErrorEvent.nserial(this.address(), l2);
        return this;
    }

    public XErrorEvent error_code(@NativeType(value="unsigned char") byte by2) {
        XErrorEvent.nerror_code(this.address(), by2);
        return this;
    }

    public XErrorEvent request_code(@NativeType(value="unsigned char") byte by2) {
        XErrorEvent.nrequest_code(this.address(), by2);
        return this;
    }

    public XErrorEvent minor_code(@NativeType(value="unsigned char") byte by2) {
        XErrorEvent.nminor_code(this.address(), by2);
        return this;
    }

    public XErrorEvent set(int n2, long l2, long l3, long l4, byte by2, byte by3, byte by4) {
        this.type(n2);
        this.display(l2);
        this.resourceid(l3);
        this.serial(l4);
        this.error_code(by2);
        this.request_code(by3);
        this.minor_code(by4);
        return this;
    }

    public XErrorEvent set(XErrorEvent xErrorEvent) {
        MemoryUtil.memCopy(xErrorEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XErrorEvent malloc() {
        return XErrorEvent.wrap(XErrorEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XErrorEvent calloc() {
        return XErrorEvent.wrap(XErrorEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XErrorEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XErrorEvent.wrap(XErrorEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XErrorEvent create(long l2) {
        return XErrorEvent.wrap(XErrorEvent.class, l2);
    }

    @Nullable
    public static XErrorEvent createSafe(long l2) {
        return l2 == 0L ? null : XErrorEvent.wrap(XErrorEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XErrorEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XErrorEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XErrorEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XErrorEvent.__create(n2, SIZEOF);
        return XErrorEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XErrorEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XErrorEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XErrorEvent mallocStack() {
        return XErrorEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XErrorEvent callocStack() {
        return XErrorEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XErrorEvent mallocStack(MemoryStack memoryStack) {
        return XErrorEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XErrorEvent callocStack(MemoryStack memoryStack) {
        return XErrorEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XErrorEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XErrorEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XErrorEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XErrorEvent.calloc(n2, memoryStack);
    }

    public static XErrorEvent malloc(MemoryStack memoryStack) {
        return XErrorEvent.wrap(XErrorEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XErrorEvent calloc(MemoryStack memoryStack) {
        return XErrorEvent.wrap(XErrorEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XErrorEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XErrorEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int ntype(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TYPE);
    }

    public static long ndisplay(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)DISPLAY);
    }

    public static long nresourceid(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)RESOURCEID);
    }

    public static long nserial(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)SERIAL);
    }

    public static byte nerror_code(long l2) {
        return UNSAFE.getByte(null, l2 + (long)ERROR_CODE);
    }

    public static byte nrequest_code(long l2) {
        return UNSAFE.getByte(null, l2 + (long)REQUEST_CODE);
    }

    public static byte nminor_code(long l2) {
        return UNSAFE.getByte(null, l2 + (long)MINOR_CODE);
    }

    public static void ntype(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)TYPE, n2);
    }

    public static void ndisplay(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)DISPLAY, Checks.check(l3));
    }

    public static void nresourceid(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)RESOURCEID, l3);
    }

    public static void nserial(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)SERIAL, l3);
    }

    public static void nerror_code(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)ERROR_CODE, by2);
    }

    public static void nrequest_code(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)REQUEST_CODE, by2);
    }

    public static void nminor_code(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)MINOR_CODE, by2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XErrorEvent.__struct(XErrorEvent.__member(4), XErrorEvent.__member(POINTER_SIZE), XErrorEvent.__member(CLONG_SIZE), XErrorEvent.__member(CLONG_SIZE), XErrorEvent.__member(1), XErrorEvent.__member(1), XErrorEvent.__member(1));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        DISPLAY = layout.offsetof(1);
        RESOURCEID = layout.offsetof(2);
        SERIAL = layout.offsetof(3);
        ERROR_CODE = layout.offsetof(4);
        REQUEST_CODE = layout.offsetof(5);
        MINOR_CODE = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XErrorEvent, Buffer>
    implements NativeResource {
        private static final XErrorEvent ELEMENT_FACTORY = XErrorEvent.create(-1L);

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
        protected XErrorEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XErrorEvent.ntype(this.address());
        }

        @NativeType(value="Display *")
        public long display() {
            return XErrorEvent.ndisplay(this.address());
        }

        @NativeType(value="XID")
        public long resourceid() {
            return XErrorEvent.nresourceid(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XErrorEvent.nserial(this.address());
        }

        @NativeType(value="unsigned char")
        public byte error_code() {
            return XErrorEvent.nerror_code(this.address());
        }

        @NativeType(value="unsigned char")
        public byte request_code() {
            return XErrorEvent.nrequest_code(this.address());
        }

        @NativeType(value="unsigned char")
        public byte minor_code() {
            return XErrorEvent.nminor_code(this.address());
        }

        public Buffer type(int n2) {
            XErrorEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XErrorEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer resourceid(@NativeType(value="XID") long l2) {
            XErrorEvent.nresourceid(this.address(), l2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XErrorEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer error_code(@NativeType(value="unsigned char") byte by2) {
            XErrorEvent.nerror_code(this.address(), by2);
            return this;
        }

        public Buffer request_code(@NativeType(value="unsigned char") byte by2) {
            XErrorEvent.nrequest_code(this.address(), by2);
            return this;
        }

        public Buffer minor_code(@NativeType(value="unsigned char") byte by2) {
            XErrorEvent.nminor_code(this.address(), by2);
            return this;
        }
    }
}

