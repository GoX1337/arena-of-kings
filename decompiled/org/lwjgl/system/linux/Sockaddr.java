/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

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

@NativeType(value="struct sockaddr")
public class Sockaddr
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SA_FAMILY;
    public static final int SA_DATA;

    public Sockaddr(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), Sockaddr.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="sa_family_t")
    public short sa_family() {
        return Sockaddr.nsa_family(this.address());
    }

    @NativeType(value="char[14]")
    public ByteBuffer sa_data() {
        return Sockaddr.nsa_data(this.address());
    }

    @NativeType(value="char")
    public byte sa_data(int n2) {
        return Sockaddr.nsa_data(this.address(), n2);
    }

    public Sockaddr sa_family(@NativeType(value="sa_family_t") short s2) {
        Sockaddr.nsa_family(this.address(), s2);
        return this;
    }

    public Sockaddr sa_data(@NativeType(value="char[14]") ByteBuffer byteBuffer) {
        Sockaddr.nsa_data(this.address(), byteBuffer);
        return this;
    }

    public Sockaddr sa_data(int n2, @NativeType(value="char") byte by2) {
        Sockaddr.nsa_data(this.address(), n2, by2);
        return this;
    }

    public Sockaddr set(short s2, ByteBuffer byteBuffer) {
        this.sa_family(s2);
        this.sa_data(byteBuffer);
        return this;
    }

    public Sockaddr set(Sockaddr sockaddr) {
        MemoryUtil.memCopy(sockaddr.address(), this.address(), SIZEOF);
        return this;
    }

    public static Sockaddr malloc() {
        return Sockaddr.wrap(Sockaddr.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static Sockaddr calloc() {
        return Sockaddr.wrap(Sockaddr.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static Sockaddr create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return Sockaddr.wrap(Sockaddr.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static Sockaddr create(long l2) {
        return Sockaddr.wrap(Sockaddr.class, l2);
    }

    @Nullable
    public static Sockaddr createSafe(long l2) {
        return l2 == 0L ? null : Sockaddr.wrap(Sockaddr.class, l2);
    }

    public static Buffer malloc(int n2) {
        return Sockaddr.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(Sockaddr.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return Sockaddr.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = Sockaddr.__create(n2, SIZEOF);
        return Sockaddr.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return Sockaddr.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : Sockaddr.wrap(Buffer.class, l2, n2);
    }

    public static Sockaddr malloc(MemoryStack memoryStack) {
        return Sockaddr.wrap(Sockaddr.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static Sockaddr calloc(MemoryStack memoryStack) {
        return Sockaddr.wrap(Sockaddr.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return Sockaddr.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return Sockaddr.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static short nsa_family(long l2) {
        return UNSAFE.getShort(null, l2 + (long)SA_FAMILY);
    }

    public static ByteBuffer nsa_data(long l2) {
        return MemoryUtil.memByteBuffer(l2 + (long)SA_DATA, 14);
    }

    public static byte nsa_data(long l2, int n2) {
        return UNSAFE.getByte(null, l2 + (long)SA_DATA + Checks.check(n2, 14) * 1L);
    }

    public static void nsa_family(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)SA_FAMILY, s2);
    }

    public static void nsa_data(long l2, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(byteBuffer, 14);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(byteBuffer), l2 + (long)SA_DATA, byteBuffer.remaining() * 1);
    }

    public static void nsa_data(long l2, int n2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)SA_DATA + Checks.check(n2, 14) * 1L, by2);
    }

    static {
        Struct.Layout layout = Sockaddr.__struct(Sockaddr.__member(2), Sockaddr.__array(1, 14));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        SA_FAMILY = layout.offsetof(0);
        SA_DATA = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<Sockaddr, Buffer>
    implements NativeResource {
        private static final Sockaddr ELEMENT_FACTORY = Sockaddr.create(-1L);

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
        protected Sockaddr getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="sa_family_t")
        public short sa_family() {
            return Sockaddr.nsa_family(this.address());
        }

        @NativeType(value="char[14]")
        public ByteBuffer sa_data() {
            return Sockaddr.nsa_data(this.address());
        }

        @NativeType(value="char")
        public byte sa_data(int n2) {
            return Sockaddr.nsa_data(this.address(), n2);
        }

        public Buffer sa_family(@NativeType(value="sa_family_t") short s2) {
            Sockaddr.nsa_family(this.address(), s2);
            return this;
        }

        public Buffer sa_data(@NativeType(value="char[14]") ByteBuffer byteBuffer) {
            Sockaddr.nsa_data(this.address(), byteBuffer);
            return this;
        }

        public Buffer sa_data(int n2, @NativeType(value="char") byte by2) {
            Sockaddr.nsa_data(this.address(), n2, by2);
            return this;
        }
    }
}

