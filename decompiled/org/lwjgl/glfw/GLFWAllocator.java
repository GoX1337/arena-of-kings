/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWAllocateCallback;
import org.lwjgl.glfw.GLFWAllocateCallbackI;
import org.lwjgl.glfw.GLFWDeallocateCallback;
import org.lwjgl.glfw.GLFWDeallocateCallbackI;
import org.lwjgl.glfw.GLFWReallocateCallback;
import org.lwjgl.glfw.GLFWReallocateCallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct GLFWallocator")
public class GLFWAllocator
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ALLOCATE;
    public static final int REALLOCATE;
    public static final int DEALLOCATE;
    public static final int USER;

    public GLFWAllocator(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), GLFWAllocator.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="GLFWallocatefun")
    public GLFWAllocateCallback allocate() {
        return GLFWAllocator.nallocate(this.address());
    }

    @NativeType(value="GLFWreallocatefun")
    public GLFWReallocateCallback reallocate() {
        return GLFWAllocator.nreallocate(this.address());
    }

    @NativeType(value="GLFWdeallocatefun")
    public GLFWDeallocateCallback deallocate() {
        return GLFWAllocator.ndeallocate(this.address());
    }

    @NativeType(value="void *")
    public long user() {
        return GLFWAllocator.nuser(this.address());
    }

    public GLFWAllocator allocate(@NativeType(value="GLFWallocatefun") GLFWAllocateCallbackI gLFWAllocateCallbackI) {
        GLFWAllocator.nallocate(this.address(), gLFWAllocateCallbackI);
        return this;
    }

    public GLFWAllocator reallocate(@NativeType(value="GLFWreallocatefun") GLFWReallocateCallbackI gLFWReallocateCallbackI) {
        GLFWAllocator.nreallocate(this.address(), gLFWReallocateCallbackI);
        return this;
    }

    public GLFWAllocator deallocate(@NativeType(value="GLFWdeallocatefun") GLFWDeallocateCallbackI gLFWDeallocateCallbackI) {
        GLFWAllocator.ndeallocate(this.address(), gLFWDeallocateCallbackI);
        return this;
    }

    public GLFWAllocator user(@NativeType(value="void *") long l2) {
        GLFWAllocator.nuser(this.address(), l2);
        return this;
    }

    public GLFWAllocator set(GLFWAllocateCallbackI gLFWAllocateCallbackI, GLFWReallocateCallbackI gLFWReallocateCallbackI, GLFWDeallocateCallbackI gLFWDeallocateCallbackI, long l2) {
        this.allocate(gLFWAllocateCallbackI);
        this.reallocate(gLFWReallocateCallbackI);
        this.deallocate(gLFWDeallocateCallbackI);
        this.user(l2);
        return this;
    }

    public GLFWAllocator set(GLFWAllocator gLFWAllocator) {
        MemoryUtil.memCopy(gLFWAllocator.address(), this.address(), SIZEOF);
        return this;
    }

    public static GLFWAllocator malloc() {
        return GLFWAllocator.wrap(GLFWAllocator.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static GLFWAllocator calloc() {
        return GLFWAllocator.wrap(GLFWAllocator.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static GLFWAllocator create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return GLFWAllocator.wrap(GLFWAllocator.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static GLFWAllocator create(long l2) {
        return GLFWAllocator.wrap(GLFWAllocator.class, l2);
    }

    @Nullable
    public static GLFWAllocator createSafe(long l2) {
        return l2 == 0L ? null : GLFWAllocator.wrap(GLFWAllocator.class, l2);
    }

    public static Buffer malloc(int n2) {
        return GLFWAllocator.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(GLFWAllocator.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return GLFWAllocator.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = GLFWAllocator.__create(n2, SIZEOF);
        return GLFWAllocator.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return GLFWAllocator.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : GLFWAllocator.wrap(Buffer.class, l2, n2);
    }

    public static GLFWAllocator malloc(MemoryStack memoryStack) {
        return GLFWAllocator.wrap(GLFWAllocator.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static GLFWAllocator calloc(MemoryStack memoryStack) {
        return GLFWAllocator.wrap(GLFWAllocator.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return GLFWAllocator.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return GLFWAllocator.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static GLFWAllocateCallback nallocate(long l2) {
        return GLFWAllocateCallback.create(MemoryUtil.memGetAddress(l2 + (long)ALLOCATE));
    }

    public static GLFWReallocateCallback nreallocate(long l2) {
        return GLFWReallocateCallback.create(MemoryUtil.memGetAddress(l2 + (long)REALLOCATE));
    }

    public static GLFWDeallocateCallback ndeallocate(long l2) {
        return GLFWDeallocateCallback.create(MemoryUtil.memGetAddress(l2 + (long)DEALLOCATE));
    }

    public static long nuser(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)USER);
    }

    public static void nallocate(long l2, GLFWAllocateCallbackI gLFWAllocateCallbackI) {
        MemoryUtil.memPutAddress(l2 + (long)ALLOCATE, gLFWAllocateCallbackI.address());
    }

    public static void nreallocate(long l2, GLFWReallocateCallbackI gLFWReallocateCallbackI) {
        MemoryUtil.memPutAddress(l2 + (long)REALLOCATE, gLFWReallocateCallbackI.address());
    }

    public static void ndeallocate(long l2, GLFWDeallocateCallbackI gLFWDeallocateCallbackI) {
        MemoryUtil.memPutAddress(l2 + (long)DEALLOCATE, gLFWDeallocateCallbackI.address());
    }

    public static void nuser(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)USER, l3);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)ALLOCATE));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)REALLOCATE));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)DEALLOCATE));
    }

    static {
        Struct.Layout layout = GLFWAllocator.__struct(GLFWAllocator.__member(POINTER_SIZE), GLFWAllocator.__member(POINTER_SIZE), GLFWAllocator.__member(POINTER_SIZE), GLFWAllocator.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        ALLOCATE = layout.offsetof(0);
        REALLOCATE = layout.offsetof(1);
        DEALLOCATE = layout.offsetof(2);
        USER = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<GLFWAllocator, Buffer>
    implements NativeResource {
        private static final GLFWAllocator ELEMENT_FACTORY = GLFWAllocator.create(-1L);

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
        protected GLFWAllocator getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="GLFWallocatefun")
        public GLFWAllocateCallback allocate() {
            return GLFWAllocator.nallocate(this.address());
        }

        @NativeType(value="GLFWreallocatefun")
        public GLFWReallocateCallback reallocate() {
            return GLFWAllocator.nreallocate(this.address());
        }

        @NativeType(value="GLFWdeallocatefun")
        public GLFWDeallocateCallback deallocate() {
            return GLFWAllocator.ndeallocate(this.address());
        }

        @NativeType(value="void *")
        public long user() {
            return GLFWAllocator.nuser(this.address());
        }

        public Buffer allocate(@NativeType(value="GLFWallocatefun") GLFWAllocateCallbackI gLFWAllocateCallbackI) {
            GLFWAllocator.nallocate(this.address(), gLFWAllocateCallbackI);
            return this;
        }

        public Buffer reallocate(@NativeType(value="GLFWreallocatefun") GLFWReallocateCallbackI gLFWReallocateCallbackI) {
            GLFWAllocator.nreallocate(this.address(), gLFWReallocateCallbackI);
            return this;
        }

        public Buffer deallocate(@NativeType(value="GLFWdeallocatefun") GLFWDeallocateCallbackI gLFWDeallocateCallbackI) {
            GLFWAllocator.ndeallocate(this.address(), gLFWDeallocateCallbackI);
            return this;
        }

        public Buffer user(@NativeType(value="void *") long l2) {
            GLFWAllocator.nuser(this.address(), l2);
            return this;
        }
    }
}

