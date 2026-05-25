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

public class KEYBDINPUT
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int WVK;
    public static final int WSCAN;
    public static final int DWFLAGS;
    public static final int TIME;
    public static final int DWEXTRAINFO;

    public KEYBDINPUT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), KEYBDINPUT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="WORD")
    public short wVk() {
        return KEYBDINPUT.nwVk(this.address());
    }

    @NativeType(value="WORD")
    public short wScan() {
        return KEYBDINPUT.nwScan(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return KEYBDINPUT.ndwFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int time() {
        return KEYBDINPUT.ntime(this.address());
    }

    @NativeType(value="ULONG_PTR")
    public long dwExtraInfo() {
        return KEYBDINPUT.ndwExtraInfo(this.address());
    }

    public KEYBDINPUT wVk(@NativeType(value="WORD") short s2) {
        KEYBDINPUT.nwVk(this.address(), s2);
        return this;
    }

    public KEYBDINPUT wScan(@NativeType(value="WORD") short s2) {
        KEYBDINPUT.nwScan(this.address(), s2);
        return this;
    }

    public KEYBDINPUT dwFlags(@NativeType(value="DWORD") int n2) {
        KEYBDINPUT.ndwFlags(this.address(), n2);
        return this;
    }

    public KEYBDINPUT time(@NativeType(value="DWORD") int n2) {
        KEYBDINPUT.ntime(this.address(), n2);
        return this;
    }

    public KEYBDINPUT dwExtraInfo(@NativeType(value="ULONG_PTR") long l2) {
        KEYBDINPUT.ndwExtraInfo(this.address(), l2);
        return this;
    }

    public KEYBDINPUT set(short s2, short s3, int n2, int n3, long l2) {
        this.wVk(s2);
        this.wScan(s3);
        this.dwFlags(n2);
        this.time(n3);
        this.dwExtraInfo(l2);
        return this;
    }

    public KEYBDINPUT set(KEYBDINPUT kEYBDINPUT) {
        MemoryUtil.memCopy(kEYBDINPUT.address(), this.address(), SIZEOF);
        return this;
    }

    public static KEYBDINPUT malloc() {
        return KEYBDINPUT.wrap(KEYBDINPUT.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static KEYBDINPUT calloc() {
        return KEYBDINPUT.wrap(KEYBDINPUT.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static KEYBDINPUT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return KEYBDINPUT.wrap(KEYBDINPUT.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static KEYBDINPUT create(long l2) {
        return KEYBDINPUT.wrap(KEYBDINPUT.class, l2);
    }

    @Nullable
    public static KEYBDINPUT createSafe(long l2) {
        return l2 == 0L ? null : KEYBDINPUT.wrap(KEYBDINPUT.class, l2);
    }

    public static Buffer malloc(int n2) {
        return KEYBDINPUT.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(KEYBDINPUT.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return KEYBDINPUT.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = KEYBDINPUT.__create(n2, SIZEOF);
        return KEYBDINPUT.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return KEYBDINPUT.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : KEYBDINPUT.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static KEYBDINPUT mallocStack() {
        return KEYBDINPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static KEYBDINPUT callocStack() {
        return KEYBDINPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static KEYBDINPUT mallocStack(MemoryStack memoryStack) {
        return KEYBDINPUT.malloc(memoryStack);
    }

    @Deprecated
    public static KEYBDINPUT callocStack(MemoryStack memoryStack) {
        return KEYBDINPUT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return KEYBDINPUT.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return KEYBDINPUT.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return KEYBDINPUT.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return KEYBDINPUT.calloc(n2, memoryStack);
    }

    public static KEYBDINPUT malloc(MemoryStack memoryStack) {
        return KEYBDINPUT.wrap(KEYBDINPUT.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static KEYBDINPUT calloc(MemoryStack memoryStack) {
        return KEYBDINPUT.wrap(KEYBDINPUT.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return KEYBDINPUT.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return KEYBDINPUT.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static short nwVk(long l2) {
        return UNSAFE.getShort(null, l2 + (long)WVK);
    }

    public static short nwScan(long l2) {
        return UNSAFE.getShort(null, l2 + (long)WSCAN);
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

    public static void nwVk(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)WVK, s2);
    }

    public static void nwScan(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)WSCAN, s2);
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
        Struct.Layout layout = KEYBDINPUT.__struct(KEYBDINPUT.__member(2), KEYBDINPUT.__member(2), KEYBDINPUT.__member(4), KEYBDINPUT.__member(4), KEYBDINPUT.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        WVK = layout.offsetof(0);
        WSCAN = layout.offsetof(1);
        DWFLAGS = layout.offsetof(2);
        TIME = layout.offsetof(3);
        DWEXTRAINFO = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<KEYBDINPUT, Buffer>
    implements NativeResource {
        private static final KEYBDINPUT ELEMENT_FACTORY = KEYBDINPUT.create(-1L);

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
        protected KEYBDINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="WORD")
        public short wVk() {
            return KEYBDINPUT.nwVk(this.address());
        }

        @NativeType(value="WORD")
        public short wScan() {
            return KEYBDINPUT.nwScan(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return KEYBDINPUT.ndwFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int time() {
            return KEYBDINPUT.ntime(this.address());
        }

        @NativeType(value="ULONG_PTR")
        public long dwExtraInfo() {
            return KEYBDINPUT.ndwExtraInfo(this.address());
        }

        public Buffer wVk(@NativeType(value="WORD") short s2) {
            KEYBDINPUT.nwVk(this.address(), s2);
            return this;
        }

        public Buffer wScan(@NativeType(value="WORD") short s2) {
            KEYBDINPUT.nwScan(this.address(), s2);
            return this;
        }

        public Buffer dwFlags(@NativeType(value="DWORD") int n2) {
            KEYBDINPUT.ndwFlags(this.address(), n2);
            return this;
        }

        public Buffer time(@NativeType(value="DWORD") int n2) {
            KEYBDINPUT.ntime(this.address(), n2);
            return this;
        }

        public Buffer dwExtraInfo(@NativeType(value="ULONG_PTR") long l2) {
            KEYBDINPUT.ndwExtraInfo(this.address(), l2);
            return this;
        }
    }
}

