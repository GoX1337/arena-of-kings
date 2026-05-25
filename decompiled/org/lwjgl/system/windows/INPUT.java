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
import org.lwjgl.system.windows.HARDWAREINPUT;
import org.lwjgl.system.windows.KEYBDINPUT;
import org.lwjgl.system.windows.MOUSEINPUT;

public class INPUT
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int DUMMYUNIONNAME;
    public static final int DUMMYUNIONNAME_MI;
    public static final int DUMMYUNIONNAME_KI;
    public static final int DUMMYUNIONNAME_HI;

    public INPUT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), INPUT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int type() {
        return INPUT.ntype(this.address());
    }

    public MOUSEINPUT DUMMYUNIONNAME_mi() {
        return INPUT.nDUMMYUNIONNAME_mi(this.address());
    }

    public KEYBDINPUT DUMMYUNIONNAME_ki() {
        return INPUT.nDUMMYUNIONNAME_ki(this.address());
    }

    public HARDWAREINPUT DUMMYUNIONNAME_hi() {
        return INPUT.nDUMMYUNIONNAME_hi(this.address());
    }

    public INPUT type(@NativeType(value="DWORD") int n2) {
        INPUT.ntype(this.address(), n2);
        return this;
    }

    public INPUT DUMMYUNIONNAME_mi(MOUSEINPUT mOUSEINPUT) {
        INPUT.nDUMMYUNIONNAME_mi(this.address(), mOUSEINPUT);
        return this;
    }

    public INPUT DUMMYUNIONNAME_mi(Consumer<MOUSEINPUT> consumer) {
        consumer.accept(this.DUMMYUNIONNAME_mi());
        return this;
    }

    public INPUT DUMMYUNIONNAME_ki(KEYBDINPUT kEYBDINPUT) {
        INPUT.nDUMMYUNIONNAME_ki(this.address(), kEYBDINPUT);
        return this;
    }

    public INPUT DUMMYUNIONNAME_ki(Consumer<KEYBDINPUT> consumer) {
        consumer.accept(this.DUMMYUNIONNAME_ki());
        return this;
    }

    public INPUT DUMMYUNIONNAME_hi(HARDWAREINPUT hARDWAREINPUT) {
        INPUT.nDUMMYUNIONNAME_hi(this.address(), hARDWAREINPUT);
        return this;
    }

    public INPUT DUMMYUNIONNAME_hi(Consumer<HARDWAREINPUT> consumer) {
        consumer.accept(this.DUMMYUNIONNAME_hi());
        return this;
    }

    public INPUT set(INPUT iNPUT) {
        MemoryUtil.memCopy(iNPUT.address(), this.address(), SIZEOF);
        return this;
    }

    public static INPUT malloc() {
        return INPUT.wrap(INPUT.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static INPUT calloc() {
        return INPUT.wrap(INPUT.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static INPUT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return INPUT.wrap(INPUT.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static INPUT create(long l2) {
        return INPUT.wrap(INPUT.class, l2);
    }

    @Nullable
    public static INPUT createSafe(long l2) {
        return l2 == 0L ? null : INPUT.wrap(INPUT.class, l2);
    }

    public static Buffer malloc(int n2) {
        return INPUT.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(INPUT.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return INPUT.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = INPUT.__create(n2, SIZEOF);
        return INPUT.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return INPUT.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : INPUT.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static INPUT mallocStack() {
        return INPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static INPUT callocStack() {
        return INPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static INPUT mallocStack(MemoryStack memoryStack) {
        return INPUT.malloc(memoryStack);
    }

    @Deprecated
    public static INPUT callocStack(MemoryStack memoryStack) {
        return INPUT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return INPUT.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return INPUT.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return INPUT.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return INPUT.calloc(n2, memoryStack);
    }

    public static INPUT malloc(MemoryStack memoryStack) {
        return INPUT.wrap(INPUT.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static INPUT calloc(MemoryStack memoryStack) {
        return INPUT.wrap(INPUT.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return INPUT.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return INPUT.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int ntype(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TYPE);
    }

    public static MOUSEINPUT nDUMMYUNIONNAME_mi(long l2) {
        return MOUSEINPUT.create(l2 + (long)DUMMYUNIONNAME_MI);
    }

    public static KEYBDINPUT nDUMMYUNIONNAME_ki(long l2) {
        return KEYBDINPUT.create(l2 + (long)DUMMYUNIONNAME_KI);
    }

    public static HARDWAREINPUT nDUMMYUNIONNAME_hi(long l2) {
        return HARDWAREINPUT.create(l2 + (long)DUMMYUNIONNAME_HI);
    }

    public static void ntype(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)TYPE, n2);
    }

    public static void nDUMMYUNIONNAME_mi(long l2, MOUSEINPUT mOUSEINPUT) {
        MemoryUtil.memCopy(mOUSEINPUT.address(), l2 + (long)DUMMYUNIONNAME_MI, MOUSEINPUT.SIZEOF);
    }

    public static void nDUMMYUNIONNAME_ki(long l2, KEYBDINPUT kEYBDINPUT) {
        MemoryUtil.memCopy(kEYBDINPUT.address(), l2 + (long)DUMMYUNIONNAME_KI, KEYBDINPUT.SIZEOF);
    }

    public static void nDUMMYUNIONNAME_hi(long l2, HARDWAREINPUT hARDWAREINPUT) {
        MemoryUtil.memCopy(hARDWAREINPUT.address(), l2 + (long)DUMMYUNIONNAME_HI, HARDWAREINPUT.SIZEOF);
    }

    static {
        Struct.Layout layout = INPUT.__struct(INPUT.__member(4), INPUT.__union(INPUT.__member(MOUSEINPUT.SIZEOF, MOUSEINPUT.ALIGNOF), INPUT.__member(KEYBDINPUT.SIZEOF, KEYBDINPUT.ALIGNOF), INPUT.__member(HARDWAREINPUT.SIZEOF, HARDWAREINPUT.ALIGNOF)));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        DUMMYUNIONNAME = layout.offsetof(1);
        DUMMYUNIONNAME_MI = layout.offsetof(2);
        DUMMYUNIONNAME_KI = layout.offsetof(3);
        DUMMYUNIONNAME_HI = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<INPUT, Buffer>
    implements NativeResource {
        private static final INPUT ELEMENT_FACTORY = INPUT.create(-1L);

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
        protected INPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int type() {
            return INPUT.ntype(this.address());
        }

        public MOUSEINPUT DUMMYUNIONNAME_mi() {
            return INPUT.nDUMMYUNIONNAME_mi(this.address());
        }

        public KEYBDINPUT DUMMYUNIONNAME_ki() {
            return INPUT.nDUMMYUNIONNAME_ki(this.address());
        }

        public HARDWAREINPUT DUMMYUNIONNAME_hi() {
            return INPUT.nDUMMYUNIONNAME_hi(this.address());
        }

        public Buffer type(@NativeType(value="DWORD") int n2) {
            INPUT.ntype(this.address(), n2);
            return this;
        }

        public Buffer DUMMYUNIONNAME_mi(MOUSEINPUT mOUSEINPUT) {
            INPUT.nDUMMYUNIONNAME_mi(this.address(), mOUSEINPUT);
            return this;
        }

        public Buffer DUMMYUNIONNAME_mi(Consumer<MOUSEINPUT> consumer) {
            consumer.accept(this.DUMMYUNIONNAME_mi());
            return this;
        }

        public Buffer DUMMYUNIONNAME_ki(KEYBDINPUT kEYBDINPUT) {
            INPUT.nDUMMYUNIONNAME_ki(this.address(), kEYBDINPUT);
            return this;
        }

        public Buffer DUMMYUNIONNAME_ki(Consumer<KEYBDINPUT> consumer) {
            consumer.accept(this.DUMMYUNIONNAME_ki());
            return this;
        }

        public Buffer DUMMYUNIONNAME_hi(HARDWAREINPUT hARDWAREINPUT) {
            INPUT.nDUMMYUNIONNAME_hi(this.address(), hARDWAREINPUT);
            return this;
        }

        public Buffer DUMMYUNIONNAME_hi(Consumer<HARDWAREINPUT> consumer) {
            consumer.accept(this.DUMMYUNIONNAME_hi());
            return this;
        }
    }
}

