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
import org.lwjgl.system.windows.RECT;

public class WINDOWPLACEMENT
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int LENGTH;
    public static final int FLAGS;
    public static final int SHOWCMD;
    public static final int PTMINPOSITION;
    public static final int PTMAXPOSITION;
    public static final int RCNORMALPOSITION;

    public WINDOWPLACEMENT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), WINDOWPLACEMENT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="UINT")
    public int length() {
        return WINDOWPLACEMENT.nlength(this.address());
    }

    @NativeType(value="UINT")
    public int flags() {
        return WINDOWPLACEMENT.nflags(this.address());
    }

    @NativeType(value="UINT")
    public int showCmd() {
        return WINDOWPLACEMENT.nshowCmd(this.address());
    }

    public POINT ptMinPosition() {
        return WINDOWPLACEMENT.nptMinPosition(this.address());
    }

    public POINT ptMaxPosition() {
        return WINDOWPLACEMENT.nptMaxPosition(this.address());
    }

    public RECT rcNormalPosition() {
        return WINDOWPLACEMENT.nrcNormalPosition(this.address());
    }

    public WINDOWPLACEMENT length(@NativeType(value="UINT") int n2) {
        WINDOWPLACEMENT.nlength(this.address(), n2);
        return this;
    }

    public WINDOWPLACEMENT flags(@NativeType(value="UINT") int n2) {
        WINDOWPLACEMENT.nflags(this.address(), n2);
        return this;
    }

    public WINDOWPLACEMENT showCmd(@NativeType(value="UINT") int n2) {
        WINDOWPLACEMENT.nshowCmd(this.address(), n2);
        return this;
    }

    public WINDOWPLACEMENT ptMinPosition(POINT pOINT) {
        WINDOWPLACEMENT.nptMinPosition(this.address(), pOINT);
        return this;
    }

    public WINDOWPLACEMENT ptMinPosition(Consumer<POINT> consumer) {
        consumer.accept(this.ptMinPosition());
        return this;
    }

    public WINDOWPLACEMENT ptMaxPosition(POINT pOINT) {
        WINDOWPLACEMENT.nptMaxPosition(this.address(), pOINT);
        return this;
    }

    public WINDOWPLACEMENT ptMaxPosition(Consumer<POINT> consumer) {
        consumer.accept(this.ptMaxPosition());
        return this;
    }

    public WINDOWPLACEMENT rcNormalPosition(RECT rECT) {
        WINDOWPLACEMENT.nrcNormalPosition(this.address(), rECT);
        return this;
    }

    public WINDOWPLACEMENT rcNormalPosition(Consumer<RECT> consumer) {
        consumer.accept(this.rcNormalPosition());
        return this;
    }

    public WINDOWPLACEMENT set(int n2, int n3, int n4, POINT pOINT, POINT pOINT2, RECT rECT) {
        this.length(n2);
        this.flags(n3);
        this.showCmd(n4);
        this.ptMinPosition(pOINT);
        this.ptMaxPosition(pOINT2);
        this.rcNormalPosition(rECT);
        return this;
    }

    public WINDOWPLACEMENT set(WINDOWPLACEMENT wINDOWPLACEMENT) {
        MemoryUtil.memCopy(wINDOWPLACEMENT.address(), this.address(), SIZEOF);
        return this;
    }

    public static WINDOWPLACEMENT malloc() {
        return WINDOWPLACEMENT.wrap(WINDOWPLACEMENT.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static WINDOWPLACEMENT calloc() {
        return WINDOWPLACEMENT.wrap(WINDOWPLACEMENT.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static WINDOWPLACEMENT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return WINDOWPLACEMENT.wrap(WINDOWPLACEMENT.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static WINDOWPLACEMENT create(long l2) {
        return WINDOWPLACEMENT.wrap(WINDOWPLACEMENT.class, l2);
    }

    @Nullable
    public static WINDOWPLACEMENT createSafe(long l2) {
        return l2 == 0L ? null : WINDOWPLACEMENT.wrap(WINDOWPLACEMENT.class, l2);
    }

    public static Buffer malloc(int n2) {
        return WINDOWPLACEMENT.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(WINDOWPLACEMENT.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return WINDOWPLACEMENT.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = WINDOWPLACEMENT.__create(n2, SIZEOF);
        return WINDOWPLACEMENT.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return WINDOWPLACEMENT.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : WINDOWPLACEMENT.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static WINDOWPLACEMENT mallocStack() {
        return WINDOWPLACEMENT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static WINDOWPLACEMENT callocStack() {
        return WINDOWPLACEMENT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static WINDOWPLACEMENT mallocStack(MemoryStack memoryStack) {
        return WINDOWPLACEMENT.malloc(memoryStack);
    }

    @Deprecated
    public static WINDOWPLACEMENT callocStack(MemoryStack memoryStack) {
        return WINDOWPLACEMENT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return WINDOWPLACEMENT.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return WINDOWPLACEMENT.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return WINDOWPLACEMENT.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return WINDOWPLACEMENT.calloc(n2, memoryStack);
    }

    public static WINDOWPLACEMENT malloc(MemoryStack memoryStack) {
        return WINDOWPLACEMENT.wrap(WINDOWPLACEMENT.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static WINDOWPLACEMENT calloc(MemoryStack memoryStack) {
        return WINDOWPLACEMENT.wrap(WINDOWPLACEMENT.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return WINDOWPLACEMENT.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return WINDOWPLACEMENT.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nlength(long l2) {
        return UNSAFE.getInt(null, l2 + (long)LENGTH);
    }

    public static int nflags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FLAGS);
    }

    public static int nshowCmd(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SHOWCMD);
    }

    public static POINT nptMinPosition(long l2) {
        return POINT.create(l2 + (long)PTMINPOSITION);
    }

    public static POINT nptMaxPosition(long l2) {
        return POINT.create(l2 + (long)PTMAXPOSITION);
    }

    public static RECT nrcNormalPosition(long l2) {
        return RECT.create(l2 + (long)RCNORMALPOSITION);
    }

    public static void nlength(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)LENGTH, n2);
    }

    public static void nflags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FLAGS, n2);
    }

    public static void nshowCmd(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SHOWCMD, n2);
    }

    public static void nptMinPosition(long l2, POINT pOINT) {
        MemoryUtil.memCopy(pOINT.address(), l2 + (long)PTMINPOSITION, POINT.SIZEOF);
    }

    public static void nptMaxPosition(long l2, POINT pOINT) {
        MemoryUtil.memCopy(pOINT.address(), l2 + (long)PTMAXPOSITION, POINT.SIZEOF);
    }

    public static void nrcNormalPosition(long l2, RECT rECT) {
        MemoryUtil.memCopy(rECT.address(), l2 + (long)RCNORMALPOSITION, RECT.SIZEOF);
    }

    static {
        Struct.Layout layout = WINDOWPLACEMENT.__struct(WINDOWPLACEMENT.__member(4), WINDOWPLACEMENT.__member(4), WINDOWPLACEMENT.__member(4), WINDOWPLACEMENT.__member(POINT.SIZEOF, POINT.ALIGNOF), WINDOWPLACEMENT.__member(POINT.SIZEOF, POINT.ALIGNOF), WINDOWPLACEMENT.__member(RECT.SIZEOF, RECT.ALIGNOF));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        LENGTH = layout.offsetof(0);
        FLAGS = layout.offsetof(1);
        SHOWCMD = layout.offsetof(2);
        PTMINPOSITION = layout.offsetof(3);
        PTMAXPOSITION = layout.offsetof(4);
        RCNORMALPOSITION = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<WINDOWPLACEMENT, Buffer>
    implements NativeResource {
        private static final WINDOWPLACEMENT ELEMENT_FACTORY = WINDOWPLACEMENT.create(-1L);

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
        protected WINDOWPLACEMENT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="UINT")
        public int length() {
            return WINDOWPLACEMENT.nlength(this.address());
        }

        @NativeType(value="UINT")
        public int flags() {
            return WINDOWPLACEMENT.nflags(this.address());
        }

        @NativeType(value="UINT")
        public int showCmd() {
            return WINDOWPLACEMENT.nshowCmd(this.address());
        }

        public POINT ptMinPosition() {
            return WINDOWPLACEMENT.nptMinPosition(this.address());
        }

        public POINT ptMaxPosition() {
            return WINDOWPLACEMENT.nptMaxPosition(this.address());
        }

        public RECT rcNormalPosition() {
            return WINDOWPLACEMENT.nrcNormalPosition(this.address());
        }

        public Buffer length(@NativeType(value="UINT") int n2) {
            WINDOWPLACEMENT.nlength(this.address(), n2);
            return this;
        }

        public Buffer flags(@NativeType(value="UINT") int n2) {
            WINDOWPLACEMENT.nflags(this.address(), n2);
            return this;
        }

        public Buffer showCmd(@NativeType(value="UINT") int n2) {
            WINDOWPLACEMENT.nshowCmd(this.address(), n2);
            return this;
        }

        public Buffer ptMinPosition(POINT pOINT) {
            WINDOWPLACEMENT.nptMinPosition(this.address(), pOINT);
            return this;
        }

        public Buffer ptMinPosition(Consumer<POINT> consumer) {
            consumer.accept(this.ptMinPosition());
            return this;
        }

        public Buffer ptMaxPosition(POINT pOINT) {
            WINDOWPLACEMENT.nptMaxPosition(this.address(), pOINT);
            return this;
        }

        public Buffer ptMaxPosition(Consumer<POINT> consumer) {
            consumer.accept(this.ptMaxPosition());
            return this;
        }

        public Buffer rcNormalPosition(RECT rECT) {
            WINDOWPLACEMENT.nrcNormalPosition(this.address(), rECT);
            return this;
        }

        public Buffer rcNormalPosition(Consumer<RECT> consumer) {
            consumer.accept(this.rcNormalPosition());
            return this;
        }
    }
}

