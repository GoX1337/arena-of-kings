/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jni;

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

public class JNINativeMethod
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NAME;
    public static final int SIGNATURE;
    public static final int FNPTR;

    public JNINativeMethod(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), JNINativeMethod.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char *")
    public ByteBuffer name() {
        return JNINativeMethod.nname(this.address());
    }

    @NativeType(value="char *")
    public String nameString() {
        return JNINativeMethod.nnameString(this.address());
    }

    @NativeType(value="char *")
    public ByteBuffer signature() {
        return JNINativeMethod.nsignature(this.address());
    }

    @NativeType(value="char *")
    public String signatureString() {
        return JNINativeMethod.nsignatureString(this.address());
    }

    @NativeType(value="void *")
    public long fnPtr() {
        return JNINativeMethod.nfnPtr(this.address());
    }

    public JNINativeMethod name(@NativeType(value="char *") ByteBuffer byteBuffer) {
        JNINativeMethod.nname(this.address(), byteBuffer);
        return this;
    }

    public JNINativeMethod signature(@NativeType(value="char *") ByteBuffer byteBuffer) {
        JNINativeMethod.nsignature(this.address(), byteBuffer);
        return this;
    }

    public JNINativeMethod fnPtr(@NativeType(value="void *") long l2) {
        JNINativeMethod.nfnPtr(this.address(), l2);
        return this;
    }

    public JNINativeMethod set(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, long l2) {
        this.name(byteBuffer);
        this.signature(byteBuffer2);
        this.fnPtr(l2);
        return this;
    }

    public JNINativeMethod set(JNINativeMethod jNINativeMethod) {
        MemoryUtil.memCopy(jNINativeMethod.address(), this.address(), SIZEOF);
        return this;
    }

    public static JNINativeMethod malloc() {
        return JNINativeMethod.wrap(JNINativeMethod.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static JNINativeMethod calloc() {
        return JNINativeMethod.wrap(JNINativeMethod.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static JNINativeMethod create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return JNINativeMethod.wrap(JNINativeMethod.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static JNINativeMethod create(long l2) {
        return JNINativeMethod.wrap(JNINativeMethod.class, l2);
    }

    @Nullable
    public static JNINativeMethod createSafe(long l2) {
        return l2 == 0L ? null : JNINativeMethod.wrap(JNINativeMethod.class, l2);
    }

    public static Buffer malloc(int n2) {
        return JNINativeMethod.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(JNINativeMethod.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return JNINativeMethod.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = JNINativeMethod.__create(n2, SIZEOF);
        return JNINativeMethod.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return JNINativeMethod.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : JNINativeMethod.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static JNINativeMethod mallocStack() {
        return JNINativeMethod.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static JNINativeMethod callocStack() {
        return JNINativeMethod.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static JNINativeMethod mallocStack(MemoryStack memoryStack) {
        return JNINativeMethod.malloc(memoryStack);
    }

    @Deprecated
    public static JNINativeMethod callocStack(MemoryStack memoryStack) {
        return JNINativeMethod.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return JNINativeMethod.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return JNINativeMethod.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return JNINativeMethod.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return JNINativeMethod.calloc(n2, memoryStack);
    }

    public static JNINativeMethod malloc(MemoryStack memoryStack) {
        return JNINativeMethod.wrap(JNINativeMethod.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static JNINativeMethod calloc(MemoryStack memoryStack) {
        return JNINativeMethod.wrap(JNINativeMethod.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return JNINativeMethod.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return JNINativeMethod.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static ByteBuffer nname(long l2) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(l2 + (long)NAME));
    }

    public static String nnameString(long l2) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(l2 + (long)NAME));
    }

    public static ByteBuffer nsignature(long l2) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(l2 + (long)SIGNATURE));
    }

    public static String nsignatureString(long l2) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(l2 + (long)SIGNATURE));
    }

    public static long nfnPtr(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)FNPTR);
    }

    public static void nname(long l2, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        MemoryUtil.memPutAddress(l2 + (long)NAME, MemoryUtil.memAddress(byteBuffer));
    }

    public static void nsignature(long l2, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        MemoryUtil.memPutAddress(l2 + (long)SIGNATURE, MemoryUtil.memAddress(byteBuffer));
    }

    public static void nfnPtr(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)FNPTR, Checks.check(l3));
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)NAME));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)SIGNATURE));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)FNPTR));
    }

    static {
        Struct.Layout layout = JNINativeMethod.__struct(JNINativeMethod.__member(POINTER_SIZE), JNINativeMethod.__member(POINTER_SIZE), JNINativeMethod.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NAME = layout.offsetof(0);
        SIGNATURE = layout.offsetof(1);
        FNPTR = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<JNINativeMethod, Buffer>
    implements NativeResource {
        private static final JNINativeMethod ELEMENT_FACTORY = JNINativeMethod.create(-1L);

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
        protected JNINativeMethod getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char *")
        public ByteBuffer name() {
            return JNINativeMethod.nname(this.address());
        }

        @NativeType(value="char *")
        public String nameString() {
            return JNINativeMethod.nnameString(this.address());
        }

        @NativeType(value="char *")
        public ByteBuffer signature() {
            return JNINativeMethod.nsignature(this.address());
        }

        @NativeType(value="char *")
        public String signatureString() {
            return JNINativeMethod.nsignatureString(this.address());
        }

        @NativeType(value="void *")
        public long fnPtr() {
            return JNINativeMethod.nfnPtr(this.address());
        }

        public Buffer name(@NativeType(value="char *") ByteBuffer byteBuffer) {
            JNINativeMethod.nname(this.address(), byteBuffer);
            return this;
        }

        public Buffer signature(@NativeType(value="char *") ByteBuffer byteBuffer) {
            JNINativeMethod.nsignature(this.address(), byteBuffer);
            return this;
        }

        public Buffer fnPtr(@NativeType(value="void *") long l2) {
            JNINativeMethod.nfnPtr(this.address(), l2);
            return this;
        }
    }
}

