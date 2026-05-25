/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.system.NativeType;

public class ARBMultiDrawIndirect {
    protected ARBMultiDrawIndirect() {
        throw new UnsupportedOperationException();
    }

    public static void nglMultiDrawArraysIndirect(int n2, long l2, int n3, int n4) {
        GL43C.nglMultiDrawArraysIndirect(n2, l2, n3, n4);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        GL43C.glMultiDrawArraysIndirect(n2, byteBuffer, n3, n4);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") long l2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        GL43C.glMultiDrawArraysIndirect(n2, l2, n3, n4);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        GL43C.glMultiDrawArraysIndirect(n2, intBuffer, n3, n4);
    }

    public static void nglMultiDrawElementsIndirect(int n2, int n3, long l2, int n4, int n5) {
        GL43C.nglMultiDrawElementsIndirect(n2, n3, l2, n4, n5);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        GL43C.glMultiDrawElementsIndirect(n2, n3, byteBuffer, n4, n5);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") long l2, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        GL43C.glMultiDrawElementsIndirect(n2, n3, l2, n4, n5);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        GL43C.glMultiDrawElementsIndirect(n2, n3, intBuffer, n4, n5);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        GL43C.glMultiDrawArraysIndirect(n2, nArray, n3, n4);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        GL43C.glMultiDrawElementsIndirect(n2, n3, nArray, n4, n5);
    }

    static {
        GL.initialize();
    }
}

