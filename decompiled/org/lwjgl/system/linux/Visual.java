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

public class Visual
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int EXT_DATA;
    public static final int VISUALID;
    public static final int CLASS;
    public static final int RED_MASK;
    public static final int GREEN_MASK;
    public static final int BLUE_MASK;
    public static final int BITS_PER_RGB;
    public static final int MAP_ENTRIES;

    public Visual(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), Visual.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="void *")
    public long ext_data() {
        return Visual.next_data(this.address());
    }

    @NativeType(value="VisualID")
    public long visualid() {
        return Visual.nvisualid(this.address());
    }

    public int class$() {
        return Visual.nclass$(this.address());
    }

    @NativeType(value="unsigned long")
    public long red_mask() {
        return Visual.nred_mask(this.address());
    }

    @NativeType(value="unsigned long")
    public long green_mask() {
        return Visual.ngreen_mask(this.address());
    }

    @NativeType(value="unsigned long")
    public long blue_mask() {
        return Visual.nblue_mask(this.address());
    }

    public int bits_per_rgb() {
        return Visual.nbits_per_rgb(this.address());
    }

    public int map_entries() {
        return Visual.nmap_entries(this.address());
    }

    public Visual ext_data(@NativeType(value="void *") long l2) {
        Visual.next_data(this.address(), l2);
        return this;
    }

    public Visual visualid(@NativeType(value="VisualID") long l2) {
        Visual.nvisualid(this.address(), l2);
        return this;
    }

    public Visual class$(int n2) {
        Visual.nclass$(this.address(), n2);
        return this;
    }

    public Visual red_mask(@NativeType(value="unsigned long") long l2) {
        Visual.nred_mask(this.address(), l2);
        return this;
    }

    public Visual green_mask(@NativeType(value="unsigned long") long l2) {
        Visual.ngreen_mask(this.address(), l2);
        return this;
    }

    public Visual blue_mask(@NativeType(value="unsigned long") long l2) {
        Visual.nblue_mask(this.address(), l2);
        return this;
    }

    public Visual bits_per_rgb(int n2) {
        Visual.nbits_per_rgb(this.address(), n2);
        return this;
    }

    public Visual map_entries(int n2) {
        Visual.nmap_entries(this.address(), n2);
        return this;
    }

    public Visual set(long l2, long l3, int n2, long l4, long l5, long l6, int n3, int n4) {
        this.ext_data(l2);
        this.visualid(l3);
        this.class$(n2);
        this.red_mask(l4);
        this.green_mask(l5);
        this.blue_mask(l6);
        this.bits_per_rgb(n3);
        this.map_entries(n4);
        return this;
    }

    public Visual set(Visual visual) {
        MemoryUtil.memCopy(visual.address(), this.address(), SIZEOF);
        return this;
    }

    public static Visual malloc() {
        return Visual.wrap(Visual.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static Visual calloc() {
        return Visual.wrap(Visual.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static Visual create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return Visual.wrap(Visual.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static Visual create(long l2) {
        return Visual.wrap(Visual.class, l2);
    }

    @Nullable
    public static Visual createSafe(long l2) {
        return l2 == 0L ? null : Visual.wrap(Visual.class, l2);
    }

    public static Buffer malloc(int n2) {
        return Visual.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(Visual.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return Visual.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = Visual.__create(n2, SIZEOF);
        return Visual.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return Visual.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : Visual.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static Visual mallocStack() {
        return Visual.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static Visual callocStack() {
        return Visual.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static Visual mallocStack(MemoryStack memoryStack) {
        return Visual.malloc(memoryStack);
    }

    @Deprecated
    public static Visual callocStack(MemoryStack memoryStack) {
        return Visual.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return Visual.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return Visual.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return Visual.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return Visual.calloc(n2, memoryStack);
    }

    public static Visual malloc(MemoryStack memoryStack) {
        return Visual.wrap(Visual.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static Visual calloc(MemoryStack memoryStack) {
        return Visual.wrap(Visual.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return Visual.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return Visual.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static long next_data(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)EXT_DATA);
    }

    public static long nvisualid(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)VISUALID);
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

    public static int nbits_per_rgb(long l2) {
        return UNSAFE.getInt(null, l2 + (long)BITS_PER_RGB);
    }

    public static int nmap_entries(long l2) {
        return UNSAFE.getInt(null, l2 + (long)MAP_ENTRIES);
    }

    public static void next_data(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)EXT_DATA, l3);
    }

    public static void nvisualid(long l2, long l3) {
        MemoryUtil.memPutCLong(l2 + (long)VISUALID, l3);
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

    public static void nbits_per_rgb(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)BITS_PER_RGB, n2);
    }

    public static void nmap_entries(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)MAP_ENTRIES, n2);
    }

    static {
        Struct.Layout layout = Visual.__struct(Visual.__member(POINTER_SIZE), Visual.__member(CLONG_SIZE), Visual.__member(4), Visual.__member(CLONG_SIZE), Visual.__member(CLONG_SIZE), Visual.__member(CLONG_SIZE), Visual.__member(4), Visual.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        EXT_DATA = layout.offsetof(0);
        VISUALID = layout.offsetof(1);
        CLASS = layout.offsetof(2);
        RED_MASK = layout.offsetof(3);
        GREEN_MASK = layout.offsetof(4);
        BLUE_MASK = layout.offsetof(5);
        BITS_PER_RGB = layout.offsetof(6);
        MAP_ENTRIES = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<Visual, Buffer>
    implements NativeResource {
        private static final Visual ELEMENT_FACTORY = Visual.create(-1L);

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
        protected Visual getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="void *")
        public long ext_data() {
            return Visual.next_data(this.address());
        }

        @NativeType(value="VisualID")
        public long visualid() {
            return Visual.nvisualid(this.address());
        }

        public int class$() {
            return Visual.nclass$(this.address());
        }

        @NativeType(value="unsigned long")
        public long red_mask() {
            return Visual.nred_mask(this.address());
        }

        @NativeType(value="unsigned long")
        public long green_mask() {
            return Visual.ngreen_mask(this.address());
        }

        @NativeType(value="unsigned long")
        public long blue_mask() {
            return Visual.nblue_mask(this.address());
        }

        public int bits_per_rgb() {
            return Visual.nbits_per_rgb(this.address());
        }

        public int map_entries() {
            return Visual.nmap_entries(this.address());
        }

        public Buffer ext_data(@NativeType(value="void *") long l2) {
            Visual.next_data(this.address(), l2);
            return this;
        }

        public Buffer visualid(@NativeType(value="VisualID") long l2) {
            Visual.nvisualid(this.address(), l2);
            return this;
        }

        public Buffer class$(int n2) {
            Visual.nclass$(this.address(), n2);
            return this;
        }

        public Buffer red_mask(@NativeType(value="unsigned long") long l2) {
            Visual.nred_mask(this.address(), l2);
            return this;
        }

        public Buffer green_mask(@NativeType(value="unsigned long") long l2) {
            Visual.ngreen_mask(this.address(), l2);
            return this;
        }

        public Buffer blue_mask(@NativeType(value="unsigned long") long l2) {
            Visual.nblue_mask(this.address(), l2);
            return this;
        }

        public Buffer bits_per_rgb(int n2) {
            Visual.nbits_per_rgb(this.address(), n2);
            return this;
        }

        public Buffer map_entries(int n2) {
            Visual.nmap_entries(this.address(), n2);
            return this;
        }
    }
}

