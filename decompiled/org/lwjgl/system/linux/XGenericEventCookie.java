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

public class XGenericEventCookie
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EXTENSION;
    public static final int EVTYPE;
    public static final int COOKIE;
    public static final int DATA;

    public XGenericEventCookie(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XGenericEventCookie.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XGenericEventCookie.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XGenericEventCookie.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XGenericEventCookie.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XGenericEventCookie.ndisplay(this.address());
    }

    public int extension() {
        return XGenericEventCookie.nextension(this.address());
    }

    public int evtype() {
        return XGenericEventCookie.nevtype(this.address());
    }

    @NativeType(value="unsigned int")
    public int cookie() {
        return XGenericEventCookie.ncookie(this.address());
    }

    @NativeType(value="void *")
    public ByteBuffer data(int n2) {
        return XGenericEventCookie.ndata(this.address(), n2);
    }

    public XGenericEventCookie type(int n2) {
        XGenericEventCookie.ntype(this.address(), n2);
        return this;
    }

    public XGenericEventCookie serial(@NativeType(value="unsigned long") long l2) {
        XGenericEventCookie.nserial(this.address(), l2);
        return this;
    }

    public XGenericEventCookie send_event(@NativeType(value="Bool") boolean bl2) {
        XGenericEventCookie.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XGenericEventCookie display(@NativeType(value="Display *") long l2) {
        XGenericEventCookie.ndisplay(this.address(), l2);
        return this;
    }

    public XGenericEventCookie extension(int n2) {
        XGenericEventCookie.nextension(this.address(), n2);
        return this;
    }

    public XGenericEventCookie evtype(int n2) {
        XGenericEventCookie.nevtype(this.address(), n2);
        return this;
    }

    public XGenericEventCookie cookie(@NativeType(value="unsigned int") int n2) {
        XGenericEventCookie.ncookie(this.address(), n2);
        return this;
    }

    public XGenericEventCookie data(@NativeType(value="void *") ByteBuffer byteBuffer) {
        XGenericEventCookie.ndata(this.address(), byteBuffer);
        return this;
    }

    public XGenericEventCookie set(int n2, long l2, boolean bl2, long l3, int n3, int n4, int n5, ByteBuffer byteBuffer) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.extension(n3);
        this.evtype(n4);
        this.cookie(n5);
        this.data(byteBuffer);
        return this;
    }

    public XGenericEventCookie set(XGenericEventCookie xGenericEventCookie) {
        MemoryUtil.memCopy(xGenericEventCookie.address(), this.address(), SIZEOF);
        return this;
    }

    public static XGenericEventCookie malloc() {
        return XGenericEventCookie.wrap(XGenericEventCookie.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XGenericEventCookie calloc() {
        return XGenericEventCookie.wrap(XGenericEventCookie.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XGenericEventCookie create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XGenericEventCookie.wrap(XGenericEventCookie.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XGenericEventCookie create(long l2) {
        return XGenericEventCookie.wrap(XGenericEventCookie.class, l2);
    }

    @Nullable
    public static XGenericEventCookie createSafe(long l2) {
        return l2 == 0L ? null : XGenericEventCookie.wrap(XGenericEventCookie.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XGenericEventCookie.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XGenericEventCookie.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XGenericEventCookie.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XGenericEventCookie.__create(n2, SIZEOF);
        return XGenericEventCookie.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XGenericEventCookie.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XGenericEventCookie.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XGenericEventCookie mallocStack() {
        return XGenericEventCookie.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGenericEventCookie callocStack() {
        return XGenericEventCookie.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGenericEventCookie mallocStack(MemoryStack memoryStack) {
        return XGenericEventCookie.malloc(memoryStack);
    }

    @Deprecated
    public static XGenericEventCookie callocStack(MemoryStack memoryStack) {
        return XGenericEventCookie.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XGenericEventCookie.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XGenericEventCookie.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XGenericEventCookie.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XGenericEventCookie.calloc(n2, memoryStack);
    }

    public static XGenericEventCookie malloc(MemoryStack memoryStack) {
        return XGenericEventCookie.wrap(XGenericEventCookie.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XGenericEventCookie calloc(MemoryStack memoryStack) {
        return XGenericEventCookie.wrap(XGenericEventCookie.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XGenericEventCookie.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XGenericEventCookie.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static int nextension(long l2) {
        return UNSAFE.getInt(null, l2 + (long)EXTENSION);
    }

    public static int nevtype(long l2) {
        return UNSAFE.getInt(null, l2 + (long)EVTYPE);
    }

    public static int ncookie(long l2) {
        return UNSAFE.getInt(null, l2 + (long)COOKIE);
    }

    public static ByteBuffer ndata(long l2, int n2) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l2 + (long)DATA), n2);
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

    public static void nextension(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)EXTENSION, n2);
    }

    public static void nevtype(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)EVTYPE, n2);
    }

    public static void ncookie(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)COOKIE, n2);
    }

    public static void ndata(long l2, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)DATA, MemoryUtil.memAddress(byteBuffer));
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DATA));
    }

    static {
        Struct.Layout layout = XGenericEventCookie.__struct(XGenericEventCookie.__member(4), XGenericEventCookie.__member(CLONG_SIZE), XGenericEventCookie.__member(4), XGenericEventCookie.__member(POINTER_SIZE), XGenericEventCookie.__member(4), XGenericEventCookie.__member(4), XGenericEventCookie.__member(4), XGenericEventCookie.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EXTENSION = layout.offsetof(4);
        EVTYPE = layout.offsetof(5);
        COOKIE = layout.offsetof(6);
        DATA = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XGenericEventCookie, Buffer>
    implements NativeResource {
        private static final XGenericEventCookie ELEMENT_FACTORY = XGenericEventCookie.create(-1L);

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
        protected XGenericEventCookie getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XGenericEventCookie.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XGenericEventCookie.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XGenericEventCookie.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XGenericEventCookie.ndisplay(this.address());
        }

        public int extension() {
            return XGenericEventCookie.nextension(this.address());
        }

        public int evtype() {
            return XGenericEventCookie.nevtype(this.address());
        }

        @NativeType(value="unsigned int")
        public int cookie() {
            return XGenericEventCookie.ncookie(this.address());
        }

        @NativeType(value="void *")
        public ByteBuffer data(int n2) {
            return XGenericEventCookie.ndata(this.address(), n2);
        }

        public Buffer type(int n2) {
            XGenericEventCookie.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XGenericEventCookie.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XGenericEventCookie.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XGenericEventCookie.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer extension(int n2) {
            XGenericEventCookie.nextension(this.address(), n2);
            return this;
        }

        public Buffer evtype(int n2) {
            XGenericEventCookie.nevtype(this.address(), n2);
            return this;
        }

        public Buffer cookie(@NativeType(value="unsigned int") int n2) {
            XGenericEventCookie.ncookie(this.address(), n2);
            return this;
        }

        public Buffer data(@NativeType(value="void *") ByteBuffer byteBuffer) {
            XGenericEventCookie.ndata(this.address(), byteBuffer);
            return this;
        }
    }
}

