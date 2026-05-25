/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVBindlessMultiDrawIndirectCount {
    protected NVBindlessMultiDrawIndirectCount() {
        throw new UnsupportedOperationException();
    }

    public static native void nglMultiDrawArraysIndirectBindlessCountNV(int var0, long var1, long var3, int var5, int var6, int var7);

    public static void glMultiDrawArraysIndirectBindlessCountNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLint") int n5) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n3 * (n4 == 0 ? 16 + n5 * 24 : n4));
        }
        NVBindlessMultiDrawIndirectCount.nglMultiDrawArraysIndirectBindlessCountNV(n2, MemoryUtil.memAddress(byteBuffer), l2, n3, n4, n5);
    }

    public static void glMultiDrawArraysIndirectBindlessCountNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") long l2, @NativeType(value="GLintptr") long l3, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLint") int n5) {
        NVBindlessMultiDrawIndirectCount.nglMultiDrawArraysIndirectBindlessCountNV(n2, l2, l3, n3, n4, n5);
    }

    public static native void nglMultiDrawElementsIndirectBindlessCountNV(int var0, int var1, long var2, long var4, int var6, int var7, int var8);

    public static void glMultiDrawElementsIndirectBindlessCountNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLint") int n6) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n4 * (n5 == 0 ? (n6 + 2) * 24 : n5));
        }
        NVBindlessMultiDrawIndirectCount.nglMultiDrawElementsIndirectBindlessCountNV(n2, n3, MemoryUtil.memAddress(byteBuffer), l2, n4, n5, n6);
    }

    public static void glMultiDrawElementsIndirectBindlessCountNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") long l2, @NativeType(value="GLintptr") long l3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLint") int n6) {
        NVBindlessMultiDrawIndirectCount.nglMultiDrawElementsIndirectBindlessCountNV(n2, n3, l2, l3, n4, n5, n6);
    }

    static {
        GL.initialize();
    }
}

