/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.stb;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.stb.STBIEOFCallback;
import org.lwjgl.stb.STBIEOFCallbackI;
import org.lwjgl.stb.STBIReadCallback;
import org.lwjgl.stb.STBIReadCallbackI;
import org.lwjgl.stb.STBISkipCallback;
import org.lwjgl.stb.STBISkipCallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct stbi_io_callbacks")
public class STBIIOCallbacks
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int READ;
    public static final int SKIP;
    public static final int EOF;

    public STBIIOCallbacks(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBIIOCallbacks.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="int (*) (void *, char *, int)")
    public STBIReadCallback read() {
        return STBIIOCallbacks.nread(this.address());
    }

    @NativeType(value="void (*) (void *, int)")
    public STBISkipCallback skip() {
        return STBIIOCallbacks.nskip(this.address());
    }

    @NativeType(value="int (*) (void *)")
    public STBIEOFCallback eof() {
        return STBIIOCallbacks.neof(this.address());
    }

    public STBIIOCallbacks read(@NativeType(value="int (*) (void *, char *, int)") STBIReadCallbackI sTBIReadCallbackI) {
        STBIIOCallbacks.nread(this.address(), sTBIReadCallbackI);
        return this;
    }

    public STBIIOCallbacks skip(@NativeType(value="void (*) (void *, int)") STBISkipCallbackI sTBISkipCallbackI) {
        STBIIOCallbacks.nskip(this.address(), sTBISkipCallbackI);
        return this;
    }

    public STBIIOCallbacks eof(@NativeType(value="int (*) (void *)") STBIEOFCallbackI sTBIEOFCallbackI) {
        STBIIOCallbacks.neof(this.address(), sTBIEOFCallbackI);
        return this;
    }

    public STBIIOCallbacks set(STBIReadCallbackI sTBIReadCallbackI, STBISkipCallbackI sTBISkipCallbackI, STBIEOFCallbackI sTBIEOFCallbackI) {
        this.read(sTBIReadCallbackI);
        this.skip(sTBISkipCallbackI);
        this.eof(sTBIEOFCallbackI);
        return this;
    }

    public STBIIOCallbacks set(STBIIOCallbacks sTBIIOCallbacks) {
        MemoryUtil.memCopy(sTBIIOCallbacks.address(), this.address(), SIZEOF);
        return this;
    }

    public static STBIIOCallbacks malloc() {
        return STBIIOCallbacks.wrap(STBIIOCallbacks.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBIIOCallbacks calloc() {
        return STBIIOCallbacks.wrap(STBIIOCallbacks.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBIIOCallbacks create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBIIOCallbacks.wrap(STBIIOCallbacks.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBIIOCallbacks create(long l2) {
        return STBIIOCallbacks.wrap(STBIIOCallbacks.class, l2);
    }

    @Nullable
    public static STBIIOCallbacks createSafe(long l2) {
        return l2 == 0L ? null : STBIIOCallbacks.wrap(STBIIOCallbacks.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBIIOCallbacks.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBIIOCallbacks.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBIIOCallbacks.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBIIOCallbacks.__create(n2, SIZEOF);
        return STBIIOCallbacks.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBIIOCallbacks.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBIIOCallbacks.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static STBIIOCallbacks mallocStack() {
        return STBIIOCallbacks.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBIIOCallbacks callocStack() {
        return STBIIOCallbacks.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBIIOCallbacks mallocStack(MemoryStack memoryStack) {
        return STBIIOCallbacks.malloc(memoryStack);
    }

    @Deprecated
    public static STBIIOCallbacks callocStack(MemoryStack memoryStack) {
        return STBIIOCallbacks.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return STBIIOCallbacks.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return STBIIOCallbacks.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return STBIIOCallbacks.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return STBIIOCallbacks.calloc(n2, memoryStack);
    }

    public static STBIIOCallbacks malloc(MemoryStack memoryStack) {
        return STBIIOCallbacks.wrap(STBIIOCallbacks.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBIIOCallbacks calloc(MemoryStack memoryStack) {
        return STBIIOCallbacks.wrap(STBIIOCallbacks.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBIIOCallbacks.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBIIOCallbacks.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static STBIReadCallback nread(long l2) {
        return STBIReadCallback.create(MemoryUtil.memGetAddress(l2 + (long)READ));
    }

    public static STBISkipCallback nskip(long l2) {
        return STBISkipCallback.create(MemoryUtil.memGetAddress(l2 + (long)SKIP));
    }

    public static STBIEOFCallback neof(long l2) {
        return STBIEOFCallback.create(MemoryUtil.memGetAddress(l2 + (long)EOF));
    }

    public static void nread(long l2, STBIReadCallbackI sTBIReadCallbackI) {
        MemoryUtil.memPutAddress(l2 + (long)READ, sTBIReadCallbackI.address());
    }

    public static void nskip(long l2, STBISkipCallbackI sTBISkipCallbackI) {
        MemoryUtil.memPutAddress(l2 + (long)SKIP, sTBISkipCallbackI.address());
    }

    public static void neof(long l2, STBIEOFCallbackI sTBIEOFCallbackI) {
        MemoryUtil.memPutAddress(l2 + (long)EOF, sTBIEOFCallbackI.address());
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)READ));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)SKIP));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)EOF));
    }

    static {
        Struct.Layout layout = STBIIOCallbacks.__struct(STBIIOCallbacks.__member(POINTER_SIZE), STBIIOCallbacks.__member(POINTER_SIZE), STBIIOCallbacks.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        READ = layout.offsetof(0);
        SKIP = layout.offsetof(1);
        EOF = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<STBIIOCallbacks, Buffer>
    implements NativeResource {
        private static final STBIIOCallbacks ELEMENT_FACTORY = STBIIOCallbacks.create(-1L);

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
        protected STBIIOCallbacks getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="int (*) (void *, char *, int)")
        public STBIReadCallback read() {
            return STBIIOCallbacks.nread(this.address());
        }

        @NativeType(value="void (*) (void *, int)")
        public STBISkipCallback skip() {
            return STBIIOCallbacks.nskip(this.address());
        }

        @NativeType(value="int (*) (void *)")
        public STBIEOFCallback eof() {
            return STBIIOCallbacks.neof(this.address());
        }

        public Buffer read(@NativeType(value="int (*) (void *, char *, int)") STBIReadCallbackI sTBIReadCallbackI) {
            STBIIOCallbacks.nread(this.address(), sTBIReadCallbackI);
            return this;
        }

        public Buffer skip(@NativeType(value="void (*) (void *, int)") STBISkipCallbackI sTBISkipCallbackI) {
            STBIIOCallbacks.nskip(this.address(), sTBISkipCallbackI);
            return this;
        }

        public Buffer eof(@NativeType(value="int (*) (void *)") STBIEOFCallbackI sTBIEOFCallbackI) {
            STBIIOCallbacks.neof(this.address(), sTBIEOFCallbackI);
            return this;
        }
    }
}

