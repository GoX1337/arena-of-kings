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

public class XGenericEvent
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

    public XGenericEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XGenericEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XGenericEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XGenericEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XGenericEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XGenericEvent.ndisplay(this.address());
    }

    public int extension() {
        return XGenericEvent.nextension(this.address());
    }

    public int evtype() {
        return XGenericEvent.nevtype(this.address());
    }

    public XGenericEvent type(int n2) {
        XGenericEvent.ntype(this.address(), n2);
        return this;
    }

    public XGenericEvent serial(@NativeType(value="unsigned long") long l2) {
        XGenericEvent.nserial(this.address(), l2);
        return this;
    }

    public XGenericEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XGenericEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XGenericEvent display(@NativeType(value="Display *") long l2) {
        XGenericEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XGenericEvent extension(int n2) {
        XGenericEvent.nextension(this.address(), n2);
        return this;
    }

    public XGenericEvent evtype(int n2) {
        XGenericEvent.nevtype(this.address(), n2);
        return this;
    }

    public XGenericEvent set(int n2, long l2, boolean bl2, long l3, int n3, int n4) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.extension(n3);
        this.evtype(n4);
        return this;
    }

    public XGenericEvent set(XGenericEvent xGenericEvent) {
        MemoryUtil.memCopy(xGenericEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XGenericEvent malloc() {
        return XGenericEvent.wrap(XGenericEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XGenericEvent calloc() {
        return XGenericEvent.wrap(XGenericEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XGenericEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XGenericEvent.wrap(XGenericEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XGenericEvent create(long l2) {
        return XGenericEvent.wrap(XGenericEvent.class, l2);
    }

    @Nullable
    public static XGenericEvent createSafe(long l2) {
        return l2 == 0L ? null : XGenericEvent.wrap(XGenericEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XGenericEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XGenericEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XGenericEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XGenericEvent.__create(n2, SIZEOF);
        return XGenericEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XGenericEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XGenericEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XGenericEvent mallocStack() {
        return XGenericEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGenericEvent callocStack() {
        return XGenericEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGenericEvent mallocStack(MemoryStack memoryStack) {
        return XGenericEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XGenericEvent callocStack(MemoryStack memoryStack) {
        return XGenericEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XGenericEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XGenericEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XGenericEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XGenericEvent.calloc(n2, memoryStack);
    }

    public static XGenericEvent malloc(MemoryStack memoryStack) {
        return XGenericEvent.wrap(XGenericEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XGenericEvent calloc(MemoryStack memoryStack) {
        return XGenericEvent.wrap(XGenericEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XGenericEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XGenericEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XGenericEvent.__struct(XGenericEvent.__member(4), XGenericEvent.__member(CLONG_SIZE), XGenericEvent.__member(4), XGenericEvent.__member(POINTER_SIZE), XGenericEvent.__member(4), XGenericEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EXTENSION = layout.offsetof(4);
        EVTYPE = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XGenericEvent, Buffer>
    implements NativeResource {
        private static final XGenericEvent ELEMENT_FACTORY = XGenericEvent.create(-1L);

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
        protected XGenericEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XGenericEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XGenericEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XGenericEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XGenericEvent.ndisplay(this.address());
        }

        public int extension() {
            return XGenericEvent.nextension(this.address());
        }

        public int evtype() {
            return XGenericEvent.nevtype(this.address());
        }

        public Buffer type(int n2) {
            XGenericEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XGenericEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XGenericEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XGenericEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer extension(int n2) {
            XGenericEvent.nextension(this.address(), n2);
            return this;
        }

        public Buffer evtype(int n2) {
            XGenericEvent.nevtype(this.address(), n2);
            return this;
        }
    }
}

