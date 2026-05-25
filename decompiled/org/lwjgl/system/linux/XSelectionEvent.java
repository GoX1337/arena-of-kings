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

public class XSelectionEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int REQUESTOR;
    public static final int SELECTION;
    public static final int TARGET;
    public static final int PROPERTY;
    public static final int TIME;

    public XSelectionEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XSelectionEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XSelectionEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XSelectionEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XSelectionEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XSelectionEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long requestor() {
        return XSelectionEvent.nrequestor(this.address());
    }

    @NativeType(value="Atom")
    public long selection() {
        return XSelectionEvent.nselection(this.address());
    }

    @NativeType(value="Atom")
    public long target() {
        return XSelectionEvent.ntarget(this.address());
    }

    @NativeType(value="Atom")
    public long property() {
        return XSelectionEvent.nproperty(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XSelectionEvent.ntime(this.address());
    }

    public XSelectionEvent type(int n2) {
        XSelectionEvent.ntype(this.address(), n2);
        return this;
    }

    public XSelectionEvent serial(@NativeType(value="unsigned long") long l2) {
        XSelectionEvent.nserial(this.address(), l2);
        return this;
    }

    public XSelectionEvent send_event(@NativeType(value="Bool") boolean bl2) {
        XSelectionEvent.nsend_event(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XSelectionEvent display(@NativeType(value="Display *") long l2) {
        XSelectionEvent.ndisplay(this.address(), l2);
        return this;
    }

    public XSelectionEvent requestor(@NativeType(value="Window") long l2) {
        XSelectionEvent.nrequestor(this.address(), l2);
        return this;
    }

    public XSelectionEvent selection(@NativeType(value="Atom") long l2) {
        XSelectionEvent.nselection(this.address(), l2);
        return this;
    }

    public XSelectionEvent target(@NativeType(value="Atom") long l2) {
        XSelectionEvent.ntarget(this.address(), l2);
        return this;
    }

    public XSelectionEvent property(@NativeType(value="Atom") long l2) {
        XSelectionEvent.nproperty(this.address(), l2);
        return this;
    }

    public XSelectionEvent time(@NativeType(value="Time") long l2) {
        XSelectionEvent.ntime(this.address(), l2);
        return this;
    }

    public XSelectionEvent set(int n2, long l2, boolean bl2, long l3, long l4, long l5, long l6, long l7, long l8) {
        this.type(n2);
        this.serial(l2);
        this.send_event(bl2);
        this.display(l3);
        this.requestor(l4);
        this.selection(l5);
        this.target(l6);
        this.property(l7);
        this.time(l8);
        return this;
    }

    public XSelectionEvent set(XSelectionEvent xSelectionEvent) {
        MemoryUtil.memCopy(xSelectionEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XSelectionEvent malloc() {
        return XSelectionEvent.wrap(XSelectionEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XSelectionEvent calloc() {
        return XSelectionEvent.wrap(XSelectionEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XSelectionEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XSelectionEvent.wrap(XSelectionEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XSelectionEvent create(long l2) {
        return XSelectionEvent.wrap(XSelectionEvent.class, l2);
    }

    @Nullable
    public static XSelectionEvent createSafe(long l2) {
        return l2 == 0L ? null : XSelectionEvent.wrap(XSelectionEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XSelectionEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XSelectionEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XSelectionEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XSelectionEvent.__create(n2, SIZEOF);
        return XSelectionEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XSelectionEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XSelectionEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XSelectionEvent mallocStack() {
        return XSelectionEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSelectionEvent callocStack() {
        return XSelectionEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSelectionEvent mallocStack(MemoryStack memoryStack) {
        return XSelectionEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XSelectionEvent callocStack(MemoryStack memoryStack) {
        return XSelectionEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XSelectionEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XSelectionEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XSelectionEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XSelectionEvent.calloc(n2, memoryStack);
    }

    public static XSelectionEvent malloc(MemoryStack memoryStack) {
        return XSelectionEvent.wrap(XSelectionEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XSelectionEvent calloc(MemoryStack memoryStack) {
        return XSelectionEvent.wrap(XSelectionEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XSelectionEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XSelectionEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
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

    public static long nrequestor(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)REQUESTOR);
    }

    public static long nselection(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)SELECTION);
    }

    public static long ntarget(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)TARGET);
    }

    public static long nproperty(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)PROPERTY);
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

    public static void nrequestor(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)REQUESTOR, l3);
    }

    public static void nselection(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)SELECTION, l3);
    }

    public static void ntarget(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)TARGET, l3);
    }

    public static void nproperty(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)PROPERTY, l3);
    }

    public static void ntime(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)TIME, l3);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XSelectionEvent.__struct(XSelectionEvent.__member(4), XSelectionEvent.__member(CLONG_SIZE), XSelectionEvent.__member(4), XSelectionEvent.__member(POINTER_SIZE), XSelectionEvent.__member(CLONG_SIZE), XSelectionEvent.__member(CLONG_SIZE), XSelectionEvent.__member(CLONG_SIZE), XSelectionEvent.__member(CLONG_SIZE), XSelectionEvent.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        REQUESTOR = layout.offsetof(4);
        SELECTION = layout.offsetof(5);
        TARGET = layout.offsetof(6);
        PROPERTY = layout.offsetof(7);
        TIME = layout.offsetof(8);
    }

    public static class Buffer
    extends StructBuffer<XSelectionEvent, Buffer>
    implements NativeResource {
        private static final XSelectionEvent ELEMENT_FACTORY = XSelectionEvent.create(-1L);

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
        protected XSelectionEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XSelectionEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XSelectionEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XSelectionEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XSelectionEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long requestor() {
            return XSelectionEvent.nrequestor(this.address());
        }

        @NativeType(value="Atom")
        public long selection() {
            return XSelectionEvent.nselection(this.address());
        }

        @NativeType(value="Atom")
        public long target() {
            return XSelectionEvent.ntarget(this.address());
        }

        @NativeType(value="Atom")
        public long property() {
            return XSelectionEvent.nproperty(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XSelectionEvent.ntime(this.address());
        }

        public Buffer type(int n2) {
            XSelectionEvent.ntype(this.address(), n2);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l2) {
            XSelectionEvent.nserial(this.address(), l2);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl2) {
            XSelectionEvent.nsend_event(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l2) {
            XSelectionEvent.ndisplay(this.address(), l2);
            return this;
        }

        public Buffer requestor(@NativeType(value="Window") long l2) {
            XSelectionEvent.nrequestor(this.address(), l2);
            return this;
        }

        public Buffer selection(@NativeType(value="Atom") long l2) {
            XSelectionEvent.nselection(this.address(), l2);
            return this;
        }

        public Buffer target(@NativeType(value="Atom") long l2) {
            XSelectionEvent.ntarget(this.address(), l2);
            return this;
        }

        public Buffer property(@NativeType(value="Atom") long l2) {
            XSelectionEvent.nproperty(this.address(), l2);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l2) {
            XSelectionEvent.ntime(this.address(), l2);
            return this;
        }
    }
}

