/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class TOUCHINPUT
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;
    public static final int HSOURCE;
    public static final int DWID;
    public static final int DWFLAGS;
    public static final int DWMASK;
    public static final int DWTIME;
    public static final int DWEXTRAINFO;
    public static final int CXCONTACT;
    public static final int CYCONTACT;

    public TOUCHINPUT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), TOUCHINPUT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int x() {
        return TOUCHINPUT.nx(this.address());
    }

    @NativeType(value="LONG")
    public int y() {
        return TOUCHINPUT.ny(this.address());
    }

    @NativeType(value="HANDLE")
    public long hSource() {
        return TOUCHINPUT.nhSource(this.address());
    }

    @NativeType(value="DWORD")
    public int dwID() {
        return TOUCHINPUT.ndwID(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return TOUCHINPUT.ndwFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int dwMask() {
        return TOUCHINPUT.ndwMask(this.address());
    }

    @NativeType(value="DWORD")
    public int dwTime() {
        return TOUCHINPUT.ndwTime(this.address());
    }

    @NativeType(value="ULONG_PTR")
    public long dwExtraInfo() {
        return TOUCHINPUT.ndwExtraInfo(this.address());
    }

    @NativeType(value="DWORD")
    public int cxContact() {
        return TOUCHINPUT.ncxContact(this.address());
    }

    @NativeType(value="DWORD")
    public int cyContact() {
        return TOUCHINPUT.ncyContact(this.address());
    }

    public static TOUCHINPUT malloc() {
        return TOUCHINPUT.wrap(TOUCHINPUT.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static TOUCHINPUT calloc() {
        return TOUCHINPUT.wrap(TOUCHINPUT.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static TOUCHINPUT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return TOUCHINPUT.wrap(TOUCHINPUT.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static TOUCHINPUT create(long l2) {
        return TOUCHINPUT.wrap(TOUCHINPUT.class, l2);
    }

    @Nullable
    public static TOUCHINPUT createSafe(long l2) {
        return l2 == 0L ? null : TOUCHINPUT.wrap(TOUCHINPUT.class, l2);
    }

    public static Buffer malloc(int n2) {
        return TOUCHINPUT.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(TOUCHINPUT.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return TOUCHINPUT.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = TOUCHINPUT.__create(n2, SIZEOF);
        return TOUCHINPUT.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return TOUCHINPUT.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : TOUCHINPUT.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static TOUCHINPUT mallocStack() {
        return TOUCHINPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static TOUCHINPUT callocStack() {
        return TOUCHINPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static TOUCHINPUT mallocStack(MemoryStack memoryStack) {
        return TOUCHINPUT.malloc(memoryStack);
    }

    @Deprecated
    public static TOUCHINPUT callocStack(MemoryStack memoryStack) {
        return TOUCHINPUT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return TOUCHINPUT.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return TOUCHINPUT.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return TOUCHINPUT.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return TOUCHINPUT.calloc(n2, memoryStack);
    }

    public static TOUCHINPUT malloc(MemoryStack memoryStack) {
        return TOUCHINPUT.wrap(TOUCHINPUT.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static TOUCHINPUT calloc(MemoryStack memoryStack) {
        return TOUCHINPUT.wrap(TOUCHINPUT.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return TOUCHINPUT.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return TOUCHINPUT.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nx(long l2) {
        return UNSAFE.getInt(null, l2 + (long)X);
    }

    public static int ny(long l2) {
        return UNSAFE.getInt(null, l2 + (long)Y);
    }

    public static long nhSource(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)HSOURCE);
    }

    public static int ndwID(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DWID);
    }

    public static int ndwFlags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DWFLAGS);
    }

    public static int ndwMask(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DWMASK);
    }

    public static int ndwTime(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DWTIME);
    }

    public static long ndwExtraInfo(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)DWEXTRAINFO);
    }

    public static int ncxContact(long l2) {
        return UNSAFE.getInt(null, l2 + (long)CXCONTACT);
    }

    public static int ncyContact(long l2) {
        return UNSAFE.getInt(null, l2 + (long)CYCONTACT);
    }

    static {
        Struct.Layout layout = TOUCHINPUT.__struct(TOUCHINPUT.__member(4), TOUCHINPUT.__member(4), TOUCHINPUT.__member(POINTER_SIZE), TOUCHINPUT.__member(4), TOUCHINPUT.__member(4), TOUCHINPUT.__member(4), TOUCHINPUT.__member(4), TOUCHINPUT.__member(POINTER_SIZE), TOUCHINPUT.__member(4), TOUCHINPUT.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        X = layout.offsetof(0);
        Y = layout.offsetof(1);
        HSOURCE = layout.offsetof(2);
        DWID = layout.offsetof(3);
        DWFLAGS = layout.offsetof(4);
        DWMASK = layout.offsetof(5);
        DWTIME = layout.offsetof(6);
        DWEXTRAINFO = layout.offsetof(7);
        CXCONTACT = layout.offsetof(8);
        CYCONTACT = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<TOUCHINPUT, Buffer>
    implements NativeResource {
        private static final TOUCHINPUT ELEMENT_FACTORY = TOUCHINPUT.create(-1L);

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
        protected TOUCHINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int x() {
            return TOUCHINPUT.nx(this.address());
        }

        @NativeType(value="LONG")
        public int y() {
            return TOUCHINPUT.ny(this.address());
        }

        @NativeType(value="HANDLE")
        public long hSource() {
            return TOUCHINPUT.nhSource(this.address());
        }

        @NativeType(value="DWORD")
        public int dwID() {
            return TOUCHINPUT.ndwID(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return TOUCHINPUT.ndwFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int dwMask() {
            return TOUCHINPUT.ndwMask(this.address());
        }

        @NativeType(value="DWORD")
        public int dwTime() {
            return TOUCHINPUT.ndwTime(this.address());
        }

        @NativeType(value="ULONG_PTR")
        public long dwExtraInfo() {
            return TOUCHINPUT.ndwExtraInfo(this.address());
        }

        @NativeType(value="DWORD")
        public int cxContact() {
            return TOUCHINPUT.ncxContact(this.address());
        }

        @NativeType(value="DWORD")
        public int cyContact() {
            return TOUCHINPUT.ncyContact(this.address());
        }
    }
}

