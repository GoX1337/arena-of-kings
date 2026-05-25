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
import org.lwjgl.system.windows.RECT;

public class MONITORINFOEX
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CBSIZE;
    public static final int RCMONITOR;
    public static final int RCWORK;
    public static final int DWFLAGS;
    public static final int SZDEVICE;

    public MONITORINFOEX(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), MONITORINFOEX.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int cbSize() {
        return MONITORINFOEX.ncbSize(this.address());
    }

    public RECT rcMonitor() {
        return MONITORINFOEX.nrcMonitor(this.address());
    }

    public RECT rcWork() {
        return MONITORINFOEX.nrcWork(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return MONITORINFOEX.ndwFlags(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public ByteBuffer szDevice() {
        return MONITORINFOEX.nszDevice(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public String szDeviceString() {
        return MONITORINFOEX.nszDeviceString(this.address());
    }

    public MONITORINFOEX cbSize(@NativeType(value="DWORD") int n2) {
        MONITORINFOEX.ncbSize(this.address(), n2);
        return this;
    }

    public MONITORINFOEX set(MONITORINFOEX mONITORINFOEX) {
        MemoryUtil.memCopy(mONITORINFOEX.address(), this.address(), SIZEOF);
        return this;
    }

    public static MONITORINFOEX malloc() {
        return MONITORINFOEX.wrap(MONITORINFOEX.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static MONITORINFOEX calloc() {
        return MONITORINFOEX.wrap(MONITORINFOEX.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static MONITORINFOEX create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return MONITORINFOEX.wrap(MONITORINFOEX.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static MONITORINFOEX create(long l2) {
        return MONITORINFOEX.wrap(MONITORINFOEX.class, l2);
    }

    @Nullable
    public static MONITORINFOEX createSafe(long l2) {
        return l2 == 0L ? null : MONITORINFOEX.wrap(MONITORINFOEX.class, l2);
    }

    public static Buffer malloc(int n2) {
        return MONITORINFOEX.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(MONITORINFOEX.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return MONITORINFOEX.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = MONITORINFOEX.__create(n2, SIZEOF);
        return MONITORINFOEX.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return MONITORINFOEX.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : MONITORINFOEX.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static MONITORINFOEX mallocStack() {
        return MONITORINFOEX.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MONITORINFOEX callocStack() {
        return MONITORINFOEX.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MONITORINFOEX mallocStack(MemoryStack memoryStack) {
        return MONITORINFOEX.malloc(memoryStack);
    }

    @Deprecated
    public static MONITORINFOEX callocStack(MemoryStack memoryStack) {
        return MONITORINFOEX.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return MONITORINFOEX.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return MONITORINFOEX.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return MONITORINFOEX.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return MONITORINFOEX.calloc(n2, memoryStack);
    }

    public static MONITORINFOEX malloc(MemoryStack memoryStack) {
        return MONITORINFOEX.wrap(MONITORINFOEX.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static MONITORINFOEX calloc(MemoryStack memoryStack) {
        return MONITORINFOEX.wrap(MONITORINFOEX.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return MONITORINFOEX.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return MONITORINFOEX.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int ncbSize(long l2) {
        return UNSAFE.getInt(null, l2 + (long)CBSIZE);
    }

    public static RECT nrcMonitor(long l2) {
        return RECT.create(l2 + (long)RCMONITOR);
    }

    public static RECT nrcWork(long l2) {
        return RECT.create(l2 + (long)RCWORK);
    }

    public static int ndwFlags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DWFLAGS);
    }

    public static ByteBuffer nszDevice(long l2) {
        return MemoryUtil.memByteBuffer(l2 + (long)SZDEVICE, 64);
    }

    public static String nszDeviceString(long l2) {
        return MemoryUtil.memUTF16(l2 + (long)SZDEVICE);
    }

    public static void ncbSize(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)CBSIZE, n2);
    }

    static {
        Struct.Layout layout = MONITORINFOEX.__struct(MONITORINFOEX.__member(4), MONITORINFOEX.__member(RECT.SIZEOF, RECT.ALIGNOF), MONITORINFOEX.__member(RECT.SIZEOF, RECT.ALIGNOF), MONITORINFOEX.__member(4), MONITORINFOEX.__array(2, 32));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        CBSIZE = layout.offsetof(0);
        RCMONITOR = layout.offsetof(1);
        RCWORK = layout.offsetof(2);
        DWFLAGS = layout.offsetof(3);
        SZDEVICE = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<MONITORINFOEX, Buffer>
    implements NativeResource {
        private static final MONITORINFOEX ELEMENT_FACTORY = MONITORINFOEX.create(-1L);

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
        protected MONITORINFOEX getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int cbSize() {
            return MONITORINFOEX.ncbSize(this.address());
        }

        public RECT rcMonitor() {
            return MONITORINFOEX.nrcMonitor(this.address());
        }

        public RECT rcWork() {
            return MONITORINFOEX.nrcWork(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return MONITORINFOEX.ndwFlags(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public ByteBuffer szDevice() {
            return MONITORINFOEX.nszDevice(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public String szDeviceString() {
            return MONITORINFOEX.nszDeviceString(this.address());
        }

        public Buffer cbSize(@NativeType(value="DWORD") int n2) {
            MONITORINFOEX.ncbSize(this.address(), n2);
            return this;
        }
    }
}

