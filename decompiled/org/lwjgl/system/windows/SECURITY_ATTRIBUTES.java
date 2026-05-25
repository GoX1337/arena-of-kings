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

public class SECURITY_ATTRIBUTES
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NLENGTH;
    public static final int LPSECURITYDESCRIPTOR;
    public static final int BINHERITHANDLE;

    public SECURITY_ATTRIBUTES(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), SECURITY_ATTRIBUTES.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int nLength() {
        return SECURITY_ATTRIBUTES.nnLength(this.address());
    }

    @NativeType(value="LPVOID")
    public long lpSecurityDescriptor() {
        return SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address());
    }

    @NativeType(value="BOOL")
    public boolean bInheritHandle() {
        return SECURITY_ATTRIBUTES.nbInheritHandle(this.address()) != 0;
    }

    public SECURITY_ATTRIBUTES nLength(@NativeType(value="DWORD") int n2) {
        SECURITY_ATTRIBUTES.nnLength(this.address(), n2);
        return this;
    }

    public SECURITY_ATTRIBUTES lpSecurityDescriptor(@NativeType(value="LPVOID") long l2) {
        SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address(), l2);
        return this;
    }

    public SECURITY_ATTRIBUTES bInheritHandle(@NativeType(value="BOOL") boolean bl2) {
        SECURITY_ATTRIBUTES.nbInheritHandle(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public SECURITY_ATTRIBUTES set(int n2, long l2, boolean bl2) {
        this.nLength(n2);
        this.lpSecurityDescriptor(l2);
        this.bInheritHandle(bl2);
        return this;
    }

    public SECURITY_ATTRIBUTES set(SECURITY_ATTRIBUTES sECURITY_ATTRIBUTES) {
        MemoryUtil.memCopy(sECURITY_ATTRIBUTES.address(), this.address(), SIZEOF);
        return this;
    }

    public static SECURITY_ATTRIBUTES malloc() {
        return SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static SECURITY_ATTRIBUTES calloc() {
        return SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static SECURITY_ATTRIBUTES create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static SECURITY_ATTRIBUTES create(long l2) {
        return SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, l2);
    }

    @Nullable
    public static SECURITY_ATTRIBUTES createSafe(long l2) {
        return l2 == 0L ? null : SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, l2);
    }

    public static Buffer malloc(int n2) {
        return SECURITY_ATTRIBUTES.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(SECURITY_ATTRIBUTES.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return SECURITY_ATTRIBUTES.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = SECURITY_ATTRIBUTES.__create(n2, SIZEOF);
        return SECURITY_ATTRIBUTES.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return SECURITY_ATTRIBUTES.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : SECURITY_ATTRIBUTES.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static SECURITY_ATTRIBUTES mallocStack() {
        return SECURITY_ATTRIBUTES.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static SECURITY_ATTRIBUTES callocStack() {
        return SECURITY_ATTRIBUTES.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static SECURITY_ATTRIBUTES mallocStack(MemoryStack memoryStack) {
        return SECURITY_ATTRIBUTES.malloc(memoryStack);
    }

    @Deprecated
    public static SECURITY_ATTRIBUTES callocStack(MemoryStack memoryStack) {
        return SECURITY_ATTRIBUTES.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return SECURITY_ATTRIBUTES.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return SECURITY_ATTRIBUTES.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return SECURITY_ATTRIBUTES.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return SECURITY_ATTRIBUTES.calloc(n2, memoryStack);
    }

    public static SECURITY_ATTRIBUTES malloc(MemoryStack memoryStack) {
        return SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static SECURITY_ATTRIBUTES calloc(MemoryStack memoryStack) {
        return SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return SECURITY_ATTRIBUTES.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return SECURITY_ATTRIBUTES.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nnLength(long l2) {
        return UNSAFE.getInt(null, l2 + (long)NLENGTH);
    }

    public static long nlpSecurityDescriptor(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)LPSECURITYDESCRIPTOR);
    }

    public static int nbInheritHandle(long l2) {
        return UNSAFE.getInt(null, l2 + (long)BINHERITHANDLE);
    }

    public static void nnLength(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)NLENGTH, n2);
    }

    public static void nlpSecurityDescriptor(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)LPSECURITYDESCRIPTOR, Checks.check(l3));
    }

    public static void nbInheritHandle(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)BINHERITHANDLE, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)LPSECURITYDESCRIPTOR));
    }

    static {
        Struct.Layout layout = SECURITY_ATTRIBUTES.__struct(SECURITY_ATTRIBUTES.__member(4), SECURITY_ATTRIBUTES.__member(POINTER_SIZE), SECURITY_ATTRIBUTES.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NLENGTH = layout.offsetof(0);
        LPSECURITYDESCRIPTOR = layout.offsetof(1);
        BINHERITHANDLE = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<SECURITY_ATTRIBUTES, Buffer>
    implements NativeResource {
        private static final SECURITY_ATTRIBUTES ELEMENT_FACTORY = SECURITY_ATTRIBUTES.create(-1L);

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
        protected SECURITY_ATTRIBUTES getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int nLength() {
            return SECURITY_ATTRIBUTES.nnLength(this.address());
        }

        @NativeType(value="LPVOID")
        public long lpSecurityDescriptor() {
            return SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address());
        }

        @NativeType(value="BOOL")
        public boolean bInheritHandle() {
            return SECURITY_ATTRIBUTES.nbInheritHandle(this.address()) != 0;
        }

        public Buffer nLength(@NativeType(value="DWORD") int n2) {
            SECURITY_ATTRIBUTES.nnLength(this.address(), n2);
            return this;
        }

        public Buffer lpSecurityDescriptor(@NativeType(value="LPVOID") long l2) {
            SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address(), l2);
            return this;
        }

        public Buffer bInheritHandle(@NativeType(value="BOOL") boolean bl2) {
            SECURITY_ATTRIBUTES.nbInheritHandle(this.address(), bl2 ? 1 : 0);
            return this;
        }
    }
}

