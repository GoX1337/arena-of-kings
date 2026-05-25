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
import org.lwjgl.system.linux.Visual;

public class XVisualInfo
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int VISUAL;
    public static final int VISUALID;
    public static final int SCREEN;
    public static final int DEPTH;
    public static final int CLASS;
    public static final int RED_MASK;
    public static final int GREEN_MASK;
    public static final int BLUE_MASK;
    public static final int COLORMAP_SIZE;
    public static final int BITS_PER_RGB;

    public XVisualInfo(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XVisualInfo.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="Visual *")
    public Visual visual() {
        return XVisualInfo.nvisual(this.address());
    }

    @NativeType(value="VisualID")
    public long visualid() {
        return XVisualInfo.nvisualid(this.address());
    }

    public int screen() {
        return XVisualInfo.nscreen(this.address());
    }

    public int depth() {
        return XVisualInfo.ndepth(this.address());
    }

    public int class$() {
        return XVisualInfo.nclass$(this.address());
    }

    @NativeType(value="unsigned long")
    public long red_mask() {
        return XVisualInfo.nred_mask(this.address());
    }

    @NativeType(value="unsigned long")
    public long green_mask() {
        return XVisualInfo.ngreen_mask(this.address());
    }

    @NativeType(value="unsigned long")
    public long blue_mask() {
        return XVisualInfo.nblue_mask(this.address());
    }

    public int colormap_size() {
        return XVisualInfo.ncolormap_size(this.address());
    }

    public int bits_per_rgb() {
        return XVisualInfo.nbits_per_rgb(this.address());
    }

    public XVisualInfo visual(@NativeType(value="Visual *") Visual visual) {
        XVisualInfo.nvisual(this.address(), visual);
        return this;
    }

    public XVisualInfo visualid(@NativeType(value="VisualID") long l2) {
        XVisualInfo.nvisualid(this.address(), l2);
        return this;
    }

    public XVisualInfo screen(int n2) {
        XVisualInfo.nscreen(this.address(), n2);
        return this;
    }

    public XVisualInfo depth(int n2) {
        XVisualInfo.ndepth(this.address(), n2);
        return this;
    }

    public XVisualInfo class$(int n2) {
        XVisualInfo.nclass$(this.address(), n2);
        return this;
    }

    public XVisualInfo red_mask(@NativeType(value="unsigned long") long l2) {
        XVisualInfo.nred_mask(this.address(), l2);
        return this;
    }

    public XVisualInfo green_mask(@NativeType(value="unsigned long") long l2) {
        XVisualInfo.ngreen_mask(this.address(), l2);
        return this;
    }

    public XVisualInfo blue_mask(@NativeType(value="unsigned long") long l2) {
        XVisualInfo.nblue_mask(this.address(), l2);
        return this;
    }

    public XVisualInfo colormap_size(int n2) {
        XVisualInfo.ncolormap_size(this.address(), n2);
        return this;
    }

    public XVisualInfo bits_per_rgb(int n2) {
        XVisualInfo.nbits_per_rgb(this.address(), n2);
        return this;
    }

    public XVisualInfo set(Visual visual, long l2, int n2, int n3, int n4, long l3, long l4, long l5, int n5, int n6) {
        this.visual(visual);
        this.visualid(l2);
        this.screen(n2);
        this.depth(n3);
        this.class$(n4);
        this.red_mask(l3);
        this.green_mask(l4);
        this.blue_mask(l5);
        this.colormap_size(n5);
        this.bits_per_rgb(n6);
        return this;
    }

    public XVisualInfo set(XVisualInfo xVisualInfo) {
        MemoryUtil.memCopy(xVisualInfo.address(), this.address(), SIZEOF);
        return this;
    }

    public static XVisualInfo malloc() {
        return XVisualInfo.wrap(XVisualInfo.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XVisualInfo calloc() {
        return XVisualInfo.wrap(XVisualInfo.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XVisualInfo create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XVisualInfo.wrap(XVisualInfo.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XVisualInfo create(long l2) {
        return XVisualInfo.wrap(XVisualInfo.class, l2);
    }

    @Nullable
    public static XVisualInfo createSafe(long l2) {
        return l2 == 0L ? null : XVisualInfo.wrap(XVisualInfo.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XVisualInfo.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XVisualInfo.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XVisualInfo.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XVisualInfo.__create(n2, SIZEOF);
        return XVisualInfo.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XVisualInfo.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XVisualInfo.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XVisualInfo mallocStack() {
        return XVisualInfo.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XVisualInfo callocStack() {
        return XVisualInfo.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XVisualInfo mallocStack(MemoryStack memoryStack) {
        return XVisualInfo.malloc(memoryStack);
    }

    @Deprecated
    public static XVisualInfo callocStack(MemoryStack memoryStack) {
        return XVisualInfo.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XVisualInfo.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XVisualInfo.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XVisualInfo.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XVisualInfo.calloc(n2, memoryStack);
    }

    public static XVisualInfo malloc(MemoryStack memoryStack) {
        return XVisualInfo.wrap(XVisualInfo.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XVisualInfo calloc(MemoryStack memoryStack) {
        return XVisualInfo.wrap(XVisualInfo.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XVisualInfo.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XVisualInfo.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static Visual nvisual(long l2) {
        return Visual.create(MemoryUtil.memGetAddress(l2 + (long)VISUAL));
    }

    public static long nvisualid(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)VISUALID);
    }

    public static int nscreen(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SCREEN);
    }

    public static int ndepth(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DEPTH);
    }

    public static int nclass$(long l2) {
        return UNSAFE.getInt(null, l2 + (long)CLASS);
    }

    public static long nred_mask(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)RED_MASK);
    }

    public static long ngreen_mask(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)GREEN_MASK);
    }

    public static long nblue_mask(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)BLUE_MASK);
    }

    public static int ncolormap_size(long l2) {
        return UNSAFE.getInt(null, l2 + (long)COLORMAP_SIZE);
    }

    public static int nbits_per_rgb(long l2) {
        return UNSAFE.getInt(null, l2 + (long)BITS_PER_RGB);
    }

    public static void nvisual(long l2, Visual visual) {
        MemoryUtil.memPutAddress(l2 + (long)VISUAL, visual.address());
    }

    public static void nvisualid(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)VISUALID, l3);
    }

    public static void nscreen(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SCREEN, n2);
    }

    public static void ndepth(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)DEPTH, n2);
    }

    public static void nclass$(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)CLASS, n2);
    }

    public static void nred_mask(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)RED_MASK, l3);
    }

    public static void ngreen_mask(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)GREEN_MASK, l3);
    }

    public static void nblue_mask(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)BLUE_MASK, l3);
    }

    public static void ncolormap_size(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)COLORMAP_SIZE, n2);
    }

    public static void nbits_per_rgb(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)BITS_PER_RGB, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)VISUAL));
    }

    static {
        Struct.Layout layout = XVisualInfo.__struct(XVisualInfo.__member(POINTER_SIZE), XVisualInfo.__member(CLONG_SIZE), XVisualInfo.__member(4), XVisualInfo.__member(4), XVisualInfo.__member(4), XVisualInfo.__member(CLONG_SIZE), XVisualInfo.__member(CLONG_SIZE), XVisualInfo.__member(CLONG_SIZE), XVisualInfo.__member(4), XVisualInfo.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        VISUAL = layout.offsetof(0);
        VISUALID = layout.offsetof(1);
        SCREEN = layout.offsetof(2);
        DEPTH = layout.offsetof(3);
        CLASS = layout.offsetof(4);
        RED_MASK = layout.offsetof(5);
        GREEN_MASK = layout.offsetof(6);
        BLUE_MASK = layout.offsetof(7);
        COLORMAP_SIZE = layout.offsetof(8);
        BITS_PER_RGB = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<XVisualInfo, Buffer>
    implements NativeResource {
        private static final XVisualInfo ELEMENT_FACTORY = XVisualInfo.create(-1L);

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
        protected XVisualInfo getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="Visual *")
        public Visual visual() {
            return XVisualInfo.nvisual(this.address());
        }

        @NativeType(value="VisualID")
        public long visualid() {
            return XVisualInfo.nvisualid(this.address());
        }

        public int screen() {
            return XVisualInfo.nscreen(this.address());
        }

        public int depth() {
            return XVisualInfo.ndepth(this.address());
        }

        public int class$() {
            return XVisualInfo.nclass$(this.address());
        }

        @NativeType(value="unsigned long")
        public long red_mask() {
            return XVisualInfo.nred_mask(this.address());
        }

        @NativeType(value="unsigned long")
        public long green_mask() {
            return XVisualInfo.ngreen_mask(this.address());
        }

        @NativeType(value="unsigned long")
        public long blue_mask() {
            return XVisualInfo.nblue_mask(this.address());
        }

        public int colormap_size() {
            return XVisualInfo.ncolormap_size(this.address());
        }

        public int bits_per_rgb() {
            return XVisualInfo.nbits_per_rgb(this.address());
        }

        public Buffer visual(@NativeType(value="Visual *") Visual visual) {
            XVisualInfo.nvisual(this.address(), visual);
            return this;
        }

        public Buffer visualid(@NativeType(value="VisualID") long l2) {
            XVisualInfo.nvisualid(this.address(), l2);
            return this;
        }

        public Buffer screen(int n2) {
            XVisualInfo.nscreen(this.address(), n2);
            return this;
        }

        public Buffer depth(int n2) {
            XVisualInfo.ndepth(this.address(), n2);
            return this;
        }

        public Buffer class$(int n2) {
            XVisualInfo.nclass$(this.address(), n2);
            return this;
        }

        public Buffer red_mask(@NativeType(value="unsigned long") long l2) {
            XVisualInfo.nred_mask(this.address(), l2);
            return this;
        }

        public Buffer green_mask(@NativeType(value="unsigned long") long l2) {
            XVisualInfo.ngreen_mask(this.address(), l2);
            return this;
        }

        public Buffer blue_mask(@NativeType(value="unsigned long") long l2) {
            XVisualInfo.nblue_mask(this.address(), l2);
            return this;
        }

        public Buffer colormap_size(int n2) {
            XVisualInfo.ncolormap_size(this.address(), n2);
            return this;
        }

        public Buffer bits_per_rgb(int n2) {
            XVisualInfo.nbits_per_rgb(this.address(), n2);
            return this;
        }
    }
}

