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
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class XSetWindowAttributes
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int BACKGROUND_PIXMAP;
    public static final int BACKGROUND_PIXEL;
    public static final int BORDER_PIXMAP;
    public static final int BORDER_PIXEL;
    public static final int BIT_GRAVITY;
    public static final int WIN_GRAVITY;
    public static final int BACKING_STORE;
    public static final int BACKING_PLANES;
    public static final int BACKING_PIXEL;
    public static final int SAVE_UNDER;
    public static final int EVENT_MASK;
    public static final int DO_NOT_PROPAGATE_MASK;
    public static final int OVERRIDE_REDIRECT;
    public static final int COLORMAP;
    public static final int CURSOR;

    public XSetWindowAttributes(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XSetWindowAttributes.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="Pixmap")
    public long background_pixmap() {
        return XSetWindowAttributes.nbackground_pixmap(this.address());
    }

    @NativeType(value="unsigned long")
    public long background_pixel() {
        return XSetWindowAttributes.nbackground_pixel(this.address());
    }

    @NativeType(value="Pixmap")
    public long border_pixmap() {
        return XSetWindowAttributes.nborder_pixmap(this.address());
    }

    @NativeType(value="unsigned long")
    public long border_pixel() {
        return XSetWindowAttributes.nborder_pixel(this.address());
    }

    public int bit_gravity() {
        return XSetWindowAttributes.nbit_gravity(this.address());
    }

    public int win_gravity() {
        return XSetWindowAttributes.nwin_gravity(this.address());
    }

    public int backing_store() {
        return XSetWindowAttributes.nbacking_store(this.address());
    }

    @NativeType(value="unsigned long")
    public long backing_planes() {
        return XSetWindowAttributes.nbacking_planes(this.address());
    }

    @NativeType(value="unsigned long")
    public long backing_pixel() {
        return XSetWindowAttributes.nbacking_pixel(this.address());
    }

    @NativeType(value="Bool")
    public boolean save_under() {
        return XSetWindowAttributes.nsave_under(this.address()) != 0;
    }

    public long event_mask() {
        return XSetWindowAttributes.nevent_mask(this.address());
    }

    public long do_not_propagate_mask() {
        return XSetWindowAttributes.ndo_not_propagate_mask(this.address());
    }

    @NativeType(value="Bool")
    public boolean override_redirect() {
        return XSetWindowAttributes.noverride_redirect(this.address()) != 0;
    }

    @NativeType(value="Colormap")
    public long colormap() {
        return XSetWindowAttributes.ncolormap(this.address());
    }

    @NativeType(value="Cursor")
    public long cursor() {
        return XSetWindowAttributes.ncursor(this.address());
    }

    public XSetWindowAttributes background_pixmap(@NativeType(value="Pixmap") long l2) {
        XSetWindowAttributes.nbackground_pixmap(this.address(), l2);
        return this;
    }

    public XSetWindowAttributes background_pixel(@NativeType(value="unsigned long") long l2) {
        XSetWindowAttributes.nbackground_pixel(this.address(), l2);
        return this;
    }

    public XSetWindowAttributes border_pixmap(@NativeType(value="Pixmap") long l2) {
        XSetWindowAttributes.nborder_pixmap(this.address(), l2);
        return this;
    }

    public XSetWindowAttributes border_pixel(@NativeType(value="unsigned long") long l2) {
        XSetWindowAttributes.nborder_pixel(this.address(), l2);
        return this;
    }

    public XSetWindowAttributes bit_gravity(int n2) {
        XSetWindowAttributes.nbit_gravity(this.address(), n2);
        return this;
    }

    public XSetWindowAttributes win_gravity(int n2) {
        XSetWindowAttributes.nwin_gravity(this.address(), n2);
        return this;
    }

    public XSetWindowAttributes backing_store(int n2) {
        XSetWindowAttributes.nbacking_store(this.address(), n2);
        return this;
    }

    public XSetWindowAttributes backing_planes(@NativeType(value="unsigned long") long l2) {
        XSetWindowAttributes.nbacking_planes(this.address(), l2);
        return this;
    }

    public XSetWindowAttributes backing_pixel(@NativeType(value="unsigned long") long l2) {
        XSetWindowAttributes.nbacking_pixel(this.address(), l2);
        return this;
    }

    public XSetWindowAttributes save_under(@NativeType(value="Bool") boolean bl2) {
        XSetWindowAttributes.nsave_under(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XSetWindowAttributes event_mask(long l2) {
        XSetWindowAttributes.nevent_mask(this.address(), l2);
        return this;
    }

    public XSetWindowAttributes do_not_propagate_mask(long l2) {
        XSetWindowAttributes.ndo_not_propagate_mask(this.address(), l2);
        return this;
    }

    public XSetWindowAttributes override_redirect(@NativeType(value="Bool") boolean bl2) {
        XSetWindowAttributes.noverride_redirect(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public XSetWindowAttributes colormap(@NativeType(value="Colormap") long l2) {
        XSetWindowAttributes.ncolormap(this.address(), l2);
        return this;
    }

    public XSetWindowAttributes cursor(@NativeType(value="Cursor") long l2) {
        XSetWindowAttributes.ncursor(this.address(), l2);
        return this;
    }

    public XSetWindowAttributes set(long l2, long l3, long l4, long l5, int n2, int n3, int n4, long l6, long l7, boolean bl2, long l8, long l9, boolean bl3, long l10, long l11) {
        this.background_pixmap(l2);
        this.background_pixel(l3);
        this.border_pixmap(l4);
        this.border_pixel(l5);
        this.bit_gravity(n2);
        this.win_gravity(n3);
        this.backing_store(n4);
        this.backing_planes(l6);
        this.backing_pixel(l7);
        this.save_under(bl2);
        this.event_mask(l8);
        this.do_not_propagate_mask(l9);
        this.override_redirect(bl3);
        this.colormap(l10);
        this.cursor(l11);
        return this;
    }

    public XSetWindowAttributes set(XSetWindowAttributes xSetWindowAttributes) {
        MemoryUtil.memCopy(xSetWindowAttributes.address(), this.address(), SIZEOF);
        return this;
    }

    public static XSetWindowAttributes malloc() {
        return XSetWindowAttributes.wrap(XSetWindowAttributes.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XSetWindowAttributes calloc() {
        return XSetWindowAttributes.wrap(XSetWindowAttributes.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XSetWindowAttributes create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XSetWindowAttributes.wrap(XSetWindowAttributes.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XSetWindowAttributes create(long l2) {
        return XSetWindowAttributes.wrap(XSetWindowAttributes.class, l2);
    }

    @Nullable
    public static XSetWindowAttributes createSafe(long l2) {
        return l2 == 0L ? null : XSetWindowAttributes.wrap(XSetWindowAttributes.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XSetWindowAttributes.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XSetWindowAttributes.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XSetWindowAttributes.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XSetWindowAttributes.__create(n2, SIZEOF);
        return XSetWindowAttributes.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XSetWindowAttributes.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XSetWindowAttributes.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XSetWindowAttributes mallocStack() {
        return XSetWindowAttributes.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSetWindowAttributes callocStack() {
        return XSetWindowAttributes.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSetWindowAttributes mallocStack(MemoryStack memoryStack) {
        return XSetWindowAttributes.malloc(memoryStack);
    }

    @Deprecated
    public static XSetWindowAttributes callocStack(MemoryStack memoryStack) {
        return XSetWindowAttributes.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XSetWindowAttributes.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XSetWindowAttributes.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XSetWindowAttributes.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XSetWindowAttributes.calloc(n2, memoryStack);
    }

    public static XSetWindowAttributes malloc(MemoryStack memoryStack) {
        return XSetWindowAttributes.wrap(XSetWindowAttributes.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XSetWindowAttributes calloc(MemoryStack memoryStack) {
        return XSetWindowAttributes.wrap(XSetWindowAttributes.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XSetWindowAttributes.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XSetWindowAttributes.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static long nbackground_pixmap(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)BACKGROUND_PIXMAP);
    }

    public static long nbackground_pixel(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)BACKGROUND_PIXEL);
    }

    public static long nborder_pixmap(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)BORDER_PIXMAP);
    }

    public static long nborder_pixel(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)BORDER_PIXEL);
    }

    public static int nbit_gravity(long l2) {
        return UNSAFE.getInt(null, l2 + (long)BIT_GRAVITY);
    }

    public static int nwin_gravity(long l2) {
        return UNSAFE.getInt(null, l2 + (long)WIN_GRAVITY);
    }

    public static int nbacking_store(long l2) {
        return UNSAFE.getInt(null, l2 + (long)BACKING_STORE);
    }

    public static long nbacking_planes(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)BACKING_PLANES);
    }

    public static long nbacking_pixel(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)BACKING_PIXEL);
    }

    public static int nsave_under(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SAVE_UNDER);
    }

    public static long nevent_mask(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)EVENT_MASK);
    }

    public static long ndo_not_propagate_mask(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)DO_NOT_PROPAGATE_MASK);
    }

    public static int noverride_redirect(long l2) {
        return UNSAFE.getInt(null, l2 + (long)OVERRIDE_REDIRECT);
    }

    public static long ncolormap(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)COLORMAP);
    }

    public static long ncursor(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)CURSOR);
    }

    public static void nbackground_pixmap(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)BACKGROUND_PIXMAP, l3);
    }

    public static void nbackground_pixel(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)BACKGROUND_PIXEL, l3);
    }

    public static void nborder_pixmap(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)BORDER_PIXMAP, l3);
    }

    public static void nborder_pixel(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)BORDER_PIXEL, l3);
    }

    public static void nbit_gravity(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)BIT_GRAVITY, n2);
    }

    public static void nwin_gravity(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)WIN_GRAVITY, n2);
    }

    public static void nbacking_store(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)BACKING_STORE, n2);
    }

    public static void nbacking_planes(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)BACKING_PLANES, l3);
    }

    public static void nbacking_pixel(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)BACKING_PIXEL, l3);
    }

    public static void nsave_under(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SAVE_UNDER, n2);
    }

    public static void nevent_mask(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)EVENT_MASK, l3);
    }

    public static void ndo_not_propagate_mask(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)DO_NOT_PROPAGATE_MASK, l3);
    }

    public static void noverride_redirect(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)OVERRIDE_REDIRECT, n2);
    }

    public static void ncolormap(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)COLORMAP, l3);
    }

    public static void ncursor(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)CURSOR, l3);
    }

    static {
        Struct.Layout layout = XSetWindowAttributes.__struct(XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        BACKGROUND_PIXMAP = layout.offsetof(0);
        BACKGROUND_PIXEL = layout.offsetof(1);
        BORDER_PIXMAP = layout.offsetof(2);
        BORDER_PIXEL = layout.offsetof(3);
        BIT_GRAVITY = layout.offsetof(4);
        WIN_GRAVITY = layout.offsetof(5);
        BACKING_STORE = layout.offsetof(6);
        BACKING_PLANES = layout.offsetof(7);
        BACKING_PIXEL = layout.offsetof(8);
        SAVE_UNDER = layout.offsetof(9);
        EVENT_MASK = layout.offsetof(10);
        DO_NOT_PROPAGATE_MASK = layout.offsetof(11);
        OVERRIDE_REDIRECT = layout.offsetof(12);
        COLORMAP = layout.offsetof(13);
        CURSOR = layout.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<XSetWindowAttributes, Buffer>
    implements NativeResource {
        private static final XSetWindowAttributes ELEMENT_FACTORY = XSetWindowAttributes.create(-1L);

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
        protected XSetWindowAttributes getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="Pixmap")
        public long background_pixmap() {
            return XSetWindowAttributes.nbackground_pixmap(this.address());
        }

        @NativeType(value="unsigned long")
        public long background_pixel() {
            return XSetWindowAttributes.nbackground_pixel(this.address());
        }

        @NativeType(value="Pixmap")
        public long border_pixmap() {
            return XSetWindowAttributes.nborder_pixmap(this.address());
        }

        @NativeType(value="unsigned long")
        public long border_pixel() {
            return XSetWindowAttributes.nborder_pixel(this.address());
        }

        public int bit_gravity() {
            return XSetWindowAttributes.nbit_gravity(this.address());
        }

        public int win_gravity() {
            return XSetWindowAttributes.nwin_gravity(this.address());
        }

        public int backing_store() {
            return XSetWindowAttributes.nbacking_store(this.address());
        }

        @NativeType(value="unsigned long")
        public long backing_planes() {
            return XSetWindowAttributes.nbacking_planes(this.address());
        }

        @NativeType(value="unsigned long")
        public long backing_pixel() {
            return XSetWindowAttributes.nbacking_pixel(this.address());
        }

        @NativeType(value="Bool")
        public boolean save_under() {
            return XSetWindowAttributes.nsave_under(this.address()) != 0;
        }

        public long event_mask() {
            return XSetWindowAttributes.nevent_mask(this.address());
        }

        public long do_not_propagate_mask() {
            return XSetWindowAttributes.ndo_not_propagate_mask(this.address());
        }

        @NativeType(value="Bool")
        public boolean override_redirect() {
            return XSetWindowAttributes.noverride_redirect(this.address()) != 0;
        }

        @NativeType(value="Colormap")
        public long colormap() {
            return XSetWindowAttributes.ncolormap(this.address());
        }

        @NativeType(value="Cursor")
        public long cursor() {
            return XSetWindowAttributes.ncursor(this.address());
        }

        public Buffer background_pixmap(@NativeType(value="Pixmap") long l2) {
            XSetWindowAttributes.nbackground_pixmap(this.address(), l2);
            return this;
        }

        public Buffer background_pixel(@NativeType(value="unsigned long") long l2) {
            XSetWindowAttributes.nbackground_pixel(this.address(), l2);
            return this;
        }

        public Buffer border_pixmap(@NativeType(value="Pixmap") long l2) {
            XSetWindowAttributes.nborder_pixmap(this.address(), l2);
            return this;
        }

        public Buffer border_pixel(@NativeType(value="unsigned long") long l2) {
            XSetWindowAttributes.nborder_pixel(this.address(), l2);
            return this;
        }

        public Buffer bit_gravity(int n2) {
            XSetWindowAttributes.nbit_gravity(this.address(), n2);
            return this;
        }

        public Buffer win_gravity(int n2) {
            XSetWindowAttributes.nwin_gravity(this.address(), n2);
            return this;
        }

        public Buffer backing_store(int n2) {
            XSetWindowAttributes.nbacking_store(this.address(), n2);
            return this;
        }

        public Buffer backing_planes(@NativeType(value="unsigned long") long l2) {
            XSetWindowAttributes.nbacking_planes(this.address(), l2);
            return this;
        }

        public Buffer backing_pixel(@NativeType(value="unsigned long") long l2) {
            XSetWindowAttributes.nbacking_pixel(this.address(), l2);
            return this;
        }

        public Buffer save_under(@NativeType(value="Bool") boolean bl2) {
            XSetWindowAttributes.nsave_under(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer event_mask(long l2) {
            XSetWindowAttributes.nevent_mask(this.address(), l2);
            return this;
        }

        public Buffer do_not_propagate_mask(long l2) {
            XSetWindowAttributes.ndo_not_propagate_mask(this.address(), l2);
            return this;
        }

        public Buffer override_redirect(@NativeType(value="Bool") boolean bl2) {
            XSetWindowAttributes.noverride_redirect(this.address(), bl2 ? 1 : 0);
            return this;
        }

        public Buffer colormap(@NativeType(value="Colormap") long l2) {
            XSetWindowAttributes.ncolormap(this.address(), l2);
            return this;
        }

        public Buffer cursor(@NativeType(value="Cursor") long l2) {
            XSetWindowAttributes.ncursor(this.address(), l2);
            return this;
        }
    }
}

