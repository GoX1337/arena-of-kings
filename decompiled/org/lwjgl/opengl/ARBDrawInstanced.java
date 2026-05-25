/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBDrawInstanced {
    protected ARBDrawInstanced() {
        throw new UnsupportedOperationException();
    }

    public static native void glDrawArraysInstancedARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLsizei") int var3);

    public static native void nglDrawElementsInstancedARB(int var0, int var1, int var2, long var3, int var5);

    public static void glDrawElementsInstancedARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") long l2, @NativeType(value="GLsizei") int n5) {
        ARBDrawInstanced.nglDrawElementsInstancedARB(n2, n3, n4, l2, n5);
    }

    public static void glDrawElementsInstancedARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n4) {
        ARBDrawInstanced.nglDrawElementsInstancedARB(n2, byteBuffer.remaining() >> GLChecks.typeToByteShift(n3), n3, MemoryUtil.memAddress(byteBuffer), n4);
    }

    public static void glDrawElementsInstancedARB(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n3) {
        ARBDrawInstanced.nglDrawElementsInstancedARB(n2, byteBuffer.remaining(), 5121, MemoryUtil.memAddress(byteBuffer), n3);
    }

    public static void glDrawElementsInstancedARB(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLsizei") int n3) {
        ARBDrawInstanced.nglDrawElementsInstancedARB(n2, shortBuffer.remaining(), 5123, MemoryUtil.memAddress(shortBuffer), n3);
    }

    public static void glDrawElementsInstancedARB(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLsizei") int n3) {
        ARBDrawInstanced.nglDrawElementsInstancedARB(n2, intBuffer.remaining(), 5125, MemoryUtil.memAddress(intBuffer), n3);
    }

    static {
        GL.initialize();
    }
}

