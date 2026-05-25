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
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.windows.WindowProc;
import org.lwjgl.system.windows.WindowProcI;

public class WNDCLASSEX
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CBSIZE;
    public static final int STYLE;
    public static final int LPFNWNDPROC;
    public static final int CBCLSEXTRA;
    public static final int CBWNDEXTRA;
    public static final int HINSTANCE;
    public static final int HICON;
    public static final int HCURSOR;
    public static final int HBRBACKGROUND;
    public static final int LPSZMENUNAME;
    public static final int LPSZCLASSNAME;
    public static final int HICONSM;

    public WNDCLASSEX(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), WNDCLASSEX.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="UINT")
    public int cbSize() {
        return WNDCLASSEX.ncbSize(this.address());
    }

    @NativeType(value="UINT")
    public int style() {
        return WNDCLASSEX.nstyle(this.address());
    }

    @NativeType(value="WNDPROC")
    public WindowProc lpfnWndProc() {
        return WNDCLASSEX.nlpfnWndProc(this.address());
    }

    public int cbClsExtra() {
        return WNDCLASSEX.ncbClsExtra(this.address());
    }

    public int cbWndExtra() {
        return WNDCLASSEX.ncbWndExtra(this.address());
    }

    @NativeType(value="HINSTANCE")
    public long hInstance() {
        return WNDCLASSEX.nhInstance(this.address());
    }

    @NativeType(value="HICON")
    public long hIcon() {
        return WNDCLASSEX.nhIcon(this.address());
    }

    @NativeType(value="HCURSOR")
    public long hCursor() {
        return WNDCLASSEX.nhCursor(this.address());
    }

    @NativeType(value="HBRUSH")
    public long hbrBackground() {
        return WNDCLASSEX.nhbrBackground(this.address());
    }

    @Nullable
    @NativeType(value="LPCTSTR")
    public ByteBuffer lpszMenuName() {
        return WNDCLASSEX.nlpszMenuName(this.address());
    }

    @Nullable
    @NativeType(value="LPCTSTR")
    public String lpszMenuNameString() {
        return WNDCLASSEX.nlpszMenuNameString(this.address());
    }

    @NativeType(value="LPCTSTR")
    public ByteBuffer lpszClassName() {
        return WNDCLASSEX.nlpszClassName(this.address());
    }

    @NativeType(value="LPCTSTR")
    public String lpszClassNameString() {
        return WNDCLASSEX.nlpszClassNameString(this.address());
    }

    @NativeType(value="HICON")
    public long hIconSm() {
        return WNDCLASSEX.nhIconSm(this.address());
    }

    public WNDCLASSEX cbSize(@NativeType(value="UINT") int n2) {
        WNDCLASSEX.ncbSize(this.address(), n2);
        return this;
    }

    public WNDCLASSEX style(@NativeType(value="UINT") int n2) {
        WNDCLASSEX.nstyle(this.address(), n2);
        return this;
    }

    public WNDCLASSEX lpfnWndProc(@NativeType(value="WNDPROC") WindowProcI windowProcI) {
        WNDCLASSEX.nlpfnWndProc(this.address(), windowProcI);
        return this;
    }

    public WNDCLASSEX cbClsExtra(int n2) {
        WNDCLASSEX.ncbClsExtra(this.address(), n2);
        return this;
    }

    public WNDCLASSEX cbWndExtra(int n2) {
        WNDCLASSEX.ncbWndExtra(this.address(), n2);
        return this;
    }

    public WNDCLASSEX hInstance(@NativeType(value="HINSTANCE") long l2) {
        WNDCLASSEX.nhInstance(this.address(), l2);
        return this;
    }

    public WNDCLASSEX hIcon(@NativeType(value="HICON") long l2) {
        WNDCLASSEX.nhIcon(this.address(), l2);
        return this;
    }

    public WNDCLASSEX hCursor(@NativeType(value="HCURSOR") long l2) {
        WNDCLASSEX.nhCursor(this.address(), l2);
        return this;
    }

    public WNDCLASSEX hbrBackground(@NativeType(value="HBRUSH") long l2) {
        WNDCLASSEX.nhbrBackground(this.address(), l2);
        return this;
    }

    public WNDCLASSEX lpszMenuName(@Nullable @NativeType(value="LPCTSTR") ByteBuffer byteBuffer) {
        WNDCLASSEX.nlpszMenuName(this.address(), byteBuffer);
        return this;
    }

    public WNDCLASSEX lpszClassName(@NativeType(value="LPCTSTR") ByteBuffer byteBuffer) {
        WNDCLASSEX.nlpszClassName(this.address(), byteBuffer);
        return this;
    }

    public WNDCLASSEX hIconSm(@NativeType(value="HICON") long l2) {
        WNDCLASSEX.nhIconSm(this.address(), l2);
        return this;
    }

    public WNDCLASSEX set(int n2, int n3, WindowProcI windowProcI, int n4, int n5, long l2, long l3, long l4, long l5, @Nullable ByteBuffer byteBuffer, ByteBuffer byteBuffer2, long l6) {
        this.cbSize(n2);
        this.style(n3);
        this.lpfnWndProc(windowProcI);
        this.cbClsExtra(n4);
        this.cbWndExtra(n5);
        this.hInstance(l2);
        this.hIcon(l3);
        this.hCursor(l4);
        this.hbrBackground(l5);
        this.lpszMenuName(byteBuffer);
        this.lpszClassName(byteBuffer2);
        this.hIconSm(l6);
        return this;
    }

    public WNDCLASSEX set(WNDCLASSEX wNDCLASSEX) {
        MemoryUtil.memCopy(wNDCLASSEX.address(), this.address(), SIZEOF);
        return this;
    }

    public static WNDCLASSEX malloc() {
        return WNDCLASSEX.wrap(WNDCLASSEX.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static WNDCLASSEX calloc() {
        return WNDCLASSEX.wrap(WNDCLASSEX.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static WNDCLASSEX create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return WNDCLASSEX.wrap(WNDCLASSEX.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static WNDCLASSEX create(long l2) {
        return WNDCLASSEX.wrap(WNDCLASSEX.class, l2);
    }

    @Nullable
    public static WNDCLASSEX createSafe(long l2) {
        return l2 == 0L ? null : WNDCLASSEX.wrap(WNDCLASSEX.class, l2);
    }

    public static Buffer malloc(int n2) {
        return WNDCLASSEX.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(WNDCLASSEX.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return WNDCLASSEX.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = WNDCLASSEX.__create(n2, SIZEOF);
        return WNDCLASSEX.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return WNDCLASSEX.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : WNDCLASSEX.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static WNDCLASSEX mallocStack() {
        return WNDCLASSEX.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static WNDCLASSEX callocStack() {
        return WNDCLASSEX.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static WNDCLASSEX mallocStack(MemoryStack memoryStack) {
        return WNDCLASSEX.malloc(memoryStack);
    }

    @Deprecated
    public static WNDCLASSEX callocStack(MemoryStack memoryStack) {
        return WNDCLASSEX.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return WNDCLASSEX.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return WNDCLASSEX.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return WNDCLASSEX.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return WNDCLASSEX.calloc(n2, memoryStack);
    }

    public static WNDCLASSEX malloc(MemoryStack memoryStack) {
        return WNDCLASSEX.wrap(WNDCLASSEX.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static WNDCLASSEX calloc(MemoryStack memoryStack) {
        return WNDCLASSEX.wrap(WNDCLASSEX.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return WNDCLASSEX.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return WNDCLASSEX.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int ncbSize(long l2) {
        return UNSAFE.getInt(null, l2 + (long)CBSIZE);
    }

    public static int nstyle(long l2) {
        return UNSAFE.getInt(null, l2 + (long)STYLE);
    }

    public static WindowProc nlpfnWndProc(long l2) {
        return WindowProc.create(MemoryUtil.memGetAddress(l2 + (long)LPFNWNDPROC));
    }

    public static int ncbClsExtra(long l2) {
        return UNSAFE.getInt(null, l2 + (long)CBCLSEXTRA);
    }

    public static int ncbWndExtra(long l2) {
        return UNSAFE.getInt(null, l2 + (long)CBWNDEXTRA);
    }

    public static long nhInstance(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)HINSTANCE);
    }

    public static long nhIcon(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)HICON);
    }

    public static long nhCursor(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)HCURSOR);
    }

    public static long nhbrBackground(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)HBRBACKGROUND);
    }

    @Nullable
    public static ByteBuffer nlpszMenuName(long l2) {
        return MemoryUtil.memByteBufferNT2Safe(MemoryUtil.memGetAddress(l2 + (long)LPSZMENUNAME));
    }

    @Nullable
    public static String nlpszMenuNameString(long l2) {
        return MemoryUtil.memUTF16Safe(MemoryUtil.memGetAddress(l2 + (long)LPSZMENUNAME));
    }

    public static ByteBuffer nlpszClassName(long l2) {
        return MemoryUtil.memByteBufferNT2(MemoryUtil.memGetAddress(l2 + (long)LPSZCLASSNAME));
    }

    public static String nlpszClassNameString(long l2) {
        return MemoryUtil.memUTF16(MemoryUtil.memGetAddress(l2 + (long)LPSZCLASSNAME));
    }

    public static long nhIconSm(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)HICONSM);
    }

    public static void ncbSize(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)CBSIZE, n2);
    }

    public static void nstyle(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)STYLE, n2);
    }

    public static void nlpfnWndProc(long l2, WindowProcI windowProcI) {
        MemoryUtil.memPutAddress(l2 + (long)LPFNWNDPROC, windowProcI.address());
    }

    public static void ncbClsExtra(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)CBCLSEXTRA, n2);
    }

    public static void ncbWndExtra(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)CBWNDEXTRA, n2);
    }

    public static void nhInstance(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)HINSTANCE, Checks.check(l3));
    }

    public static void nhIcon(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)HICON, l3);
    }

    public static void nhCursor(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)HCURSOR, l3);
    }

    public static void nhbrBackground(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)HBRBACKGROUND, l3);
    }

    public static void nlpszMenuName(long l2, @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT2Safe(byteBuffer);
        }
        MemoryUtil.memPutAddress(l2 + (long)LPSZMENUNAME, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void nlpszClassName(long l2, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT2(byteBuffer);
        }
        MemoryUtil.memPutAddress(l2 + (long)LPSZCLASSNAME, MemoryUtil.memAddress(byteBuffer));
    }

    public static void nhIconSm(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)HICONSM, l3);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)LPFNWNDPROC));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)HINSTANCE));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)LPSZCLASSNAME));
    }

    static {
        Struct.Layout layout = WNDCLASSEX.__struct(WNDCLASSEX.__member(4), WNDCLASSEX.__member(4), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(4), WNDCLASSEX.__member(4), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        CBSIZE = layout.offsetof(0);
        STYLE = layout.offsetof(1);
        LPFNWNDPROC = layout.offsetof(2);
        CBCLSEXTRA = layout.offsetof(3);
        CBWNDEXTRA = layout.offsetof(4);
        HINSTANCE = layout.offsetof(5);
        HICON = layout.offsetof(6);
        HCURSOR = layout.offsetof(7);
        HBRBACKGROUND = layout.offsetof(8);
        LPSZMENUNAME = layout.offsetof(9);
        LPSZCLASSNAME = layout.offsetof(10);
        HICONSM = layout.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<WNDCLASSEX, Buffer>
    implements NativeResource {
        private static final WNDCLASSEX ELEMENT_FACTORY = WNDCLASSEX.create(-1L);

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
        protected WNDCLASSEX getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="UINT")
        public int cbSize() {
            return WNDCLASSEX.ncbSize(this.address());
        }

        @NativeType(value="UINT")
        public int style() {
            return WNDCLASSEX.nstyle(this.address());
        }

        @NativeType(value="WNDPROC")
        public WindowProc lpfnWndProc() {
            return WNDCLASSEX.nlpfnWndProc(this.address());
        }

        public int cbClsExtra() {
            return WNDCLASSEX.ncbClsExtra(this.address());
        }

        public int cbWndExtra() {
            return WNDCLASSEX.ncbWndExtra(this.address());
        }

        @NativeType(value="HINSTANCE")
        public long hInstance() {
            return WNDCLASSEX.nhInstance(this.address());
        }

        @NativeType(value="HICON")
        public long hIcon() {
            return WNDCLASSEX.nhIcon(this.address());
        }

        @NativeType(value="HCURSOR")
        public long hCursor() {
            return WNDCLASSEX.nhCursor(this.address());
        }

        @NativeType(value="HBRUSH")
        public long hbrBackground() {
            return WNDCLASSEX.nhbrBackground(this.address());
        }

        @Nullable
        @NativeType(value="LPCTSTR")
        public ByteBuffer lpszMenuName() {
            return WNDCLASSEX.nlpszMenuName(this.address());
        }

        @Nullable
        @NativeType(value="LPCTSTR")
        public String lpszMenuNameString() {
            return WNDCLASSEX.nlpszMenuNameString(this.address());
        }

        @NativeType(value="LPCTSTR")
        public ByteBuffer lpszClassName() {
            return WNDCLASSEX.nlpszClassName(this.address());
        }

        @NativeType(value="LPCTSTR")
        public String lpszClassNameString() {
            return WNDCLASSEX.nlpszClassNameString(this.address());
        }

        @NativeType(value="HICON")
        public long hIconSm() {
            return WNDCLASSEX.nhIconSm(this.address());
        }

        public Buffer cbSize(@NativeType(value="UINT") int n2) {
            WNDCLASSEX.ncbSize(this.address(), n2);
            return this;
        }

        public Buffer style(@NativeType(value="UINT") int n2) {
            WNDCLASSEX.nstyle(this.address(), n2);
            return this;
        }

        public Buffer lpfnWndProc(@NativeType(value="WNDPROC") WindowProcI windowProcI) {
            WNDCLASSEX.nlpfnWndProc(this.address(), windowProcI);
            return this;
        }

        public Buffer cbClsExtra(int n2) {
            WNDCLASSEX.ncbClsExtra(this.address(), n2);
            return this;
        }

        public Buffer cbWndExtra(int n2) {
            WNDCLASSEX.ncbWndExtra(this.address(), n2);
            return this;
        }

        public Buffer hInstance(@NativeType(value="HINSTANCE") long l2) {
            WNDCLASSEX.nhInstance(this.address(), l2);
            return this;
        }

        public Buffer hIcon(@NativeType(value="HICON") long l2) {
            WNDCLASSEX.nhIcon(this.address(), l2);
            return this;
        }

        public Buffer hCursor(@NativeType(value="HCURSOR") long l2) {
            WNDCLASSEX.nhCursor(this.address(), l2);
            return this;
        }

        public Buffer hbrBackground(@NativeType(value="HBRUSH") long l2) {
            WNDCLASSEX.nhbrBackground(this.address(), l2);
            return this;
        }

        public Buffer lpszMenuName(@Nullable @NativeType(value="LPCTSTR") ByteBuffer byteBuffer) {
            WNDCLASSEX.nlpszMenuName(this.address(), byteBuffer);
            return this;
        }

        public Buffer lpszClassName(@NativeType(value="LPCTSTR") ByteBuffer byteBuffer) {
            WNDCLASSEX.nlpszClassName(this.address(), byteBuffer);
            return this;
        }

        public Buffer hIconSm(@NativeType(value="HICON") long l2) {
            WNDCLASSEX.nhIconSm(this.address(), l2);
            return this;
        }
    }
}

