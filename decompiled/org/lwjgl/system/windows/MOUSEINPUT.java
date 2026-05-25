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

public class MOUSEINPUT
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int DX;
    public static final int DY;
    public static final int MOUSEDATA;
    public static final int DWFLAGS;
    public static final int TIME;
    public static final int DWEXTRAINFO;

    public MOUSEINPUT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), MOUSEINPUT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int dx() {
        return MOUSEINPUT.ndx(this.address());
    }

    @NativeType(value="LONG")
    public int dy() {
        return MOUSEINPUT.ndy(this.address());
    }

    @NativeType(value="DWORD")
    public int mouseData() {
        return MOUSEINPUT.nmouseData(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return MOUSEINPUT.ndwFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int time() {
        return MOUSEINPUT.ntime(this.address());
    }

    @NativeType(value="ULONG_PTR")
    public long dwExtraInfo() {
        return MOUSEINPUT.ndwExtraInfo(this.address());
    }

    public MOUSEINPUT dx(@NativeType(value="LONG") int n2) {
        MOUSEINPUT.ndx(this.address(), n2);
        return this;
    }

    public MOUSEINPUT dy(@NativeType(value="LONG") int n2) {
        MOUSEINPUT.ndy(this.address(), n2);
        return this;
    }

    public MOUSEINPUT mouseData(@NativeType(value="DWORD") int n2) {
        MOUSEINPUT.nmouseData(this.address(), n2);
        return this;
    }

    public MOUSEINPUT dwFlags(@NativeType(value="DWORD") int n2) {
        MOUSEINPUT.ndwFlags(this.address(), n2);
        return this;
    }

    public MOUSEINPUT time(@NativeType(value="DWORD") int n2) {
        MOUSEINPUT.ntime(this.address(), n2);
        return this;
    }

    public MOUSEINPUT dwExtraInfo(@NativeType(value="ULONG_PTR") long l2) {
        MOUSEINPUT.ndwExtraInfo(this.address(), l2);
        return this;
    }

    public MOUSEINPUT set(int n2, int n3, int n4, int n5, int n6, long l2) {
        this.dx(n2);
        this.dy(n3);
        this.mouseData(n4);
        this.dwFlags(n5);
        this.time(n6);
        this.dwExtraInfo(l2);
        return this;
    }

    public MOUSEINPUT set(MOUSEINPUT mOUSEINPUT) {
        MemoryUtil.memCopy(mOUSEINPUT.address(), this.address(), SIZEOF);
        return this;
    }

    public static MOUSEINPUT malloc() {
        return MOUSEINPUT.wrap(MOUSEINPUT.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static MOUSEINPUT calloc() {
        return MOUSEINPUT.wrap(MOUSEINPUT.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static MOUSEINPUT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return MOUSEINPUT.wrap(MOUSEINPUT.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static MOUSEINPUT create(long l2) {
        return MOUSEINPUT.wrap(MOUSEINPUT.class, l2);
    }

    @Nullable
    public static MOUSEINPUT createSafe(long l2) {
        return l2 == 0L ? null : MOUSEINPUT.wrap(MOUSEINPUT.class, l2);
    }

    public static Buffer malloc(int n2) {
        return MOUSEINPUT.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(MOUSEINPUT.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return MOUSEINPUT.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = MOUSEINPUT.__create(n2, SIZEOF);
        return MOUSEINPUT.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return MOUSEINPUT.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : MOUSEINPUT.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static MOUSEINPUT mallocStack() {
        return MOUSEINPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MOUSEINPUT callocStack() {
        return MOUSEINPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MOUSEINPUT mallocStack(MemoryStack memoryStack) {
        return MOUSEINPUT.malloc(memoryStack);
    }

    @Deprecated
    public static MOUSEINPUT callocStack(MemoryStack memoryStack) {
        return MOUSEINPUT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return MOUSEINPUT.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return MOUSEINPUT.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return MOUSEINPUT.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return MOUSEINPUT.calloc(n2, memoryStack);
    }

    public static MOUSEINPUT malloc(MemoryStack memoryStack) {
        return MOUSEINPUT.wrap(MOUSEINPUT.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static MOUSEINPUT calloc(MemoryStack memoryStack) {
        return MOUSEINPUT.wrap(MOUSEINPUT.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return MOUSEINPUT.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return MOUSEINPUT.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int ndx(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DX);
    }

    public static int ndy(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DY);
    }

    public static int nmouseData(long l2) {
        return UNSAFE.getInt(null, l2 + (long)MOUSEDATA);
    }

    public static int ndwFlags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DWFLAGS);
    }

    public static int ntime(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TIME);
    }

    public static long ndwExtraInfo(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)DWEXTRAINFO);
    }

    public static void ndx(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)DX, n2);
    }

    public static void ndy(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)DY, n2);
    }

    public static void nmouseData(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)MOUSEDATA, n2);
    }

    public static void ndwFlags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)DWFLAGS, n2);
    }

    public static void ntime(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)TIME, n2);
    }

    public static void ndwExtraInfo(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)DWEXTRAINFO, l3);
    }

    static {
        Struct.Layout layout = MOUSEINPUT.__struct(MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        DX = layout.offsetof(0);
        DY = layout.offsetof(1);
        MOUSEDATA = layout.offsetof(2);
        DWFLAGS = layout.offsetof(3);
        TIME = layout.offsetof(4);
        DWEXTRAINFO = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<MOUSEINPUT, Buffer>
    implements NativeResource {
        private static final MOUSEINPUT ELEMENT_FACTORY = MOUSEINPUT.create(-1L);

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
        protected MOUSEINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int dx() {
            return MOUSEINPUT.ndx(this.address());
        }

        @NativeType(value="LONG")
        public int dy() {
            return MOUSEINPUT.ndy(this.address());
        }

        @NativeType(value="DWORD")
        public int mouseData() {
            return MOUSEINPUT.nmouseData(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return MOUSEINPUT.ndwFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int time() {
            return MOUSEINPUT.ntime(this.address());
        }

        @NativeType(value="ULONG_PTR")
        public long dwExtraInfo() {
            return MOUSEINPUT.ndwExtraInfo(this.address());
        }

        public Buffer dx(@NativeType(value="LONG") int n2) {
            MOUSEINPUT.ndx(this.address(), n2);
            return this;
        }

        public Buffer dy(@NativeType(value="LONG") int n2) {
            MOUSEINPUT.ndy(this.address(), n2);
            return this;
        }

        public Buffer mouseData(@NativeType(value="DWORD") int n2) {
            MOUSEINPUT.nmouseData(this.address(), n2);
            return this;
        }

        public Buffer dwFlags(@NativeType(value="DWORD") int n2) {
            MOUSEINPUT.ndwFlags(this.address(), n2);
            return this;
        }

        public Buffer time(@NativeType(value="DWORD") int n2) {
            MOUSEINPUT.ntime(this.address(), n2);
            return this;
        }

        public Buffer dwExtraInfo(@NativeType(value="ULONG_PTR") long l2) {
            MOUSEINPUT.ndwExtraInfo(this.address(), l2);
            return this;
        }
    }
}

