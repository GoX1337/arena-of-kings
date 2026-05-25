/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.windows.POINT;

public class MSG
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int HWND;
    public static final int MESSAGE;
    public static final int WPARAM;
    public static final int LPARAM;
    public static final int TIME;
    public static final int PT;

    public MSG(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), MSG.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="HWND")
    public long hwnd() {
        return MSG.nhwnd(this.address());
    }

    @NativeType(value="UINT")
    public int message() {
        return MSG.nmessage(this.address());
    }

    @NativeType(value="WPARAM")
    public long wParam() {
        return MSG.nwParam(this.address());
    }

    @NativeType(value="LPARAM")
    public long lParam() {
        return MSG.nlParam(this.address());
    }

    @NativeType(value="DWORD")
    public int time() {
        return MSG.ntime(this.address());
    }

    public POINT pt() {
        return MSG.npt(this.address());
    }

    public MSG hwnd(@NativeType(value="HWND") long l2) {
        MSG.nhwnd(this.address(), l2);
        return this;
    }

    public MSG message(@NativeType(value="UINT") int n2) {
        MSG.nmessage(this.address(), n2);
        return this;
    }

    public MSG wParam(@NativeType(value="WPARAM") long l2) {
        MSG.nwParam(this.address(), l2);
        return this;
    }

    public MSG lParam(@NativeType(value="LPARAM") long l2) {
        MSG.nlParam(this.address(), l2);
        return this;
    }

    public MSG time(@NativeType(value="DWORD") int n2) {
        MSG.ntime(this.address(), n2);
        return this;
    }

    public MSG pt(POINT pOINT) {
        MSG.npt(this.address(), pOINT);
        return this;
    }

    public MSG pt(Consumer<POINT> consumer) {
        consumer.accept(this.pt());
        return this;
    }

    public MSG set(long l2, int n2, long l3, long l4, int n3, POINT pOINT) {
        this.hwnd(l2);
        this.message(n2);
        this.wParam(l3);
        this.lParam(l4);
        this.time(n3);
        this.pt(pOINT);
        return this;
    }

    public MSG set(MSG mSG) {
        MemoryUtil.memCopy(mSG.address(), this.address(), SIZEOF);
        return this;
    }

    public static MSG malloc() {
        return MSG.wrap(MSG.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static MSG calloc() {
        return MSG.wrap(MSG.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static MSG create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return MSG.wrap(MSG.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static MSG create(long l2) {
        return MSG.wrap(MSG.class, l2);
    }

    @Nullable
    public static MSG createSafe(long l2) {
        return l2 == 0L ? null : MSG.wrap(MSG.class, l2);
    }

    public static Buffer malloc(int n2) {
        return MSG.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(MSG.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return MSG.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = MSG.__create(n2, SIZEOF);
        return MSG.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return MSG.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : MSG.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static MSG mallocStack() {
        return MSG.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MSG callocStack() {
        return MSG.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MSG mallocStack(MemoryStack memoryStack) {
        return MSG.malloc(memoryStack);
    }

    @Deprecated
    public static MSG callocStack(MemoryStack memoryStack) {
        return MSG.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return MSG.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return MSG.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return MSG.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return MSG.calloc(n2, memoryStack);
    }

    public static MSG malloc(MemoryStack memoryStack) {
        return MSG.wrap(MSG.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static MSG calloc(MemoryStack memoryStack) {
        return MSG.wrap(MSG.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return MSG.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return MSG.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static long nhwnd(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)HWND);
    }

    public static int nmessage(long l2) {
        return UNSAFE.getInt(null, l2 + (long)MESSAGE);
    }

    public static long nwParam(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)WPARAM);
    }

    public static long nlParam(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)LPARAM);
    }

    public static int ntime(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TIME);
    }

    public static POINT npt(long l2) {
        return POINT.create(l2 + (long)PT);
    }

    public static void nhwnd(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)HWND, l3);
    }

    public static void nmessage(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)MESSAGE, n2);
    }

    public static void nwParam(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)WPARAM, l3);
    }

    public static void nlParam(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)LPARAM, l3);
    }

    public static void ntime(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)TIME, n2);
    }

    public static void npt(long l2, POINT pOINT) {
        MemoryUtil.memCopy(pOINT.address(), l2 + (long)PT, POINT.SIZEOF);
    }

    static {
        Struct.Layout layout = MSG.__struct(MSG.__member(POINTER_SIZE), MSG.__member(4), MSG.__member(POINTER_SIZE), MSG.__member(POINTER_SIZE), MSG.__member(4), MSG.__member(POINT.SIZEOF, POINT.ALIGNOF));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        HWND = layout.offsetof(0);
        MESSAGE = layout.offsetof(1);
        WPARAM = layout.offsetof(2);
        LPARAM = layout.offsetof(3);
        TIME = layout.offsetof(4);
        PT = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<MSG, Buffer>
    implements NativeResource {
        private static final MSG ELEMENT_FACTORY = MSG.create(-1L);

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
        protected MSG getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="HWND")
        public long hwnd() {
            return MSG.nhwnd(this.address());
        }

        @NativeType(value="UINT")
        public int message() {
            return MSG.nmessage(this.address());
        }

        @NativeType(value="WPARAM")
        public long wParam() {
            return MSG.nwParam(this.address());
        }

        @NativeType(value="LPARAM")
        public long lParam() {
            return MSG.nlParam(this.address());
        }

        @NativeType(value="DWORD")
        public int time() {
            return MSG.ntime(this.address());
        }

        public POINT pt() {
            return MSG.npt(this.address());
        }

        public Buffer hwnd(@NativeType(value="HWND") long l2) {
            MSG.nhwnd(this.address(), l2);
            return this;
        }

        public Buffer message(@NativeType(value="UINT") int n2) {
            MSG.nmessage(this.address(), n2);
            return this;
        }

        public Buffer wParam(@NativeType(value="WPARAM") long l2) {
            MSG.nwParam(this.address(), l2);
            return this;
        }

        public Buffer lParam(@NativeType(value="LPARAM") long l2) {
            MSG.nlParam(this.address(), l2);
            return this;
        }

        public Buffer time(@NativeType(value="DWORD") int n2) {
            MSG.ntime(this.address(), n2);
            return this;
        }

        public Buffer pt(POINT pOINT) {
            MSG.npt(this.address(), pOINT);
            return this;
        }

        public Buffer pt(Consumer<POINT> consumer) {
            consumer.accept(this.pt());
            return this;
        }
    }
}

