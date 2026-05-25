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

public class NVBindlessMultiDrawIndirect {
    protected NVBindlessMultiDrawIndirect() {
        throw new UnsupportedOperationException();
    }

    public static native void nglMultiDrawArraysIndirectBindlessNV(int var0, long var1, int var3, int var4, int var5);

    public static void glMultiDrawArraysIndirectBindlessNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLint") int n5) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n3 * (n4 == 0 ? 16 + n5 * 24 : n4));
        }
        NVBindlessMultiDrawIndirect.nglMultiDrawArraysIndirectBindlessNV(n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5);
    }

    public static void glMultiDrawArraysIndirectBindlessNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") long l2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLint") int n5) {
        NVBindlessMultiDrawIndirect.nglMultiDrawArraysIndirectBindlessNV(n2, l2, n3, n4, n5);
    }

    public static native void nglMultiDrawElementsIndirectBindlessNV(int var0, int var1, long var2, int var4, int var5, int var6);

    public static void glMultiDrawElementsIndirectBindlessNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLint") int n6) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n4 * (n5 == 0 ? (n6 + 2) * 24 : n5));
        }
        NVBindlessMultiDrawIndirect.nglMultiDrawElementsIndirectBindlessNV(n2, n3, MemoryUtil.memAddress(byteBuffer), n4, n5, n6);
    }

    public static void glMultiDrawElementsIndirectBindlessNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") long l2, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLint") int n6) {
        NVBindlessMultiDrawIndirect.nglMultiDrawElementsIndirectBindlessNV(n2, n3, l2, n4, n5, n6);
    }

    static {
        GL.initialize();
    }
}

