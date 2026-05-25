/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL32C;
import org.lwjgl.system.NativeType;

public class ARBDrawElementsBaseVertex {
    protected ARBDrawElementsBaseVertex() {
        throw new UnsupportedOperationException();
    }

    public static void nglDrawElementsBaseVertex(int n2, int n3, int n4, long l2, int n5) {
        GL32C.nglDrawElementsBaseVertex(n2, n3, n4, l2, n5);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") long l2, @NativeType(value="GLint") int n5) {
        GL32C.glDrawElementsBaseVertex(n2, n3, n4, l2, n5);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLint") int n4) {
        GL32C.glDrawElementsBaseVertex(n2, n3, byteBuffer, n4);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLint") int n3) {
        GL32C.glDrawElementsBaseVertex(n2, byteBuffer, n3);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLint") int n3) {
        GL32C.glDrawElementsBaseVertex(n2, shortBuffer, n3);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLint") int n3) {
        GL32C.glDrawElementsBaseVertex(n2, intBuffer, n3);
    }

    public static void nglDrawRangeElementsBaseVertex(int n2, int n3, int n4, int n5, int n6, long l2, int n7) {
        GL32C.nglDrawRangeElementsBaseVertex(n2, n3, n4, n5, n6, l2, n7);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void const *") long l2, @NativeType(value="GLint") int n7) {
        GL32C.glDrawRangeElementsBaseVertex(n2, n3, n4, n5, n6, l2, n7);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLint") int n6) {
        GL32C.glDrawRangeElementsBaseVertex(n2, n3, n4, n5, byteBuffer, n6);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLint") int n5) {
        GL32C.glDrawRangeElementsBaseVertex(n2, n3, n4, byteBuffer, n5);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLint") int n5) {
        GL32C.glDrawRangeElementsBaseVertex(n2, n3, n4, shortBuffer, n5);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLint") int n5) {
        GL32C.glDrawRangeElementsBaseVertex(n2, n3, n4, intBuffer, n5);
    }

    public static void nglDrawElementsInstancedBaseVertex(int n2, int n3, int n4, long l2, int n5, int n6) {
        GL32C.nglDrawElementsInstancedBaseVertex(n2, n3, n4, l2, n5, n6);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") long l2, @NativeType(value="GLsizei") int n5, @NativeType(value="GLint") int n6) {
        GL32C.glDrawElementsInstancedBaseVertex(n2, n3, n4, l2, n5, n6);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n4, @NativeType(value="GLint") int n5) {
        GL32C.glDrawElementsInstancedBaseVertex(n2, n3, byteBuffer, n4, n5);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLint") int n4) {
        GL32C.glDrawElementsInstancedBaseVertex(n2, byteBuffer, n3, n4);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLint") int n4) {
        GL32C.glDrawElementsInstancedBaseVertex(n2, shortBuffer, n3, n4);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLint") int n4) {
        GL32C.glDrawElementsInstancedBaseVertex(n2, intBuffer, n3, n4);
    }

    public static void nglMultiDrawElementsBaseVertex(int n2, long l2, int n3, long l3, int n4, long l4) {
        GL32C.nglMultiDrawElementsBaseVertex(n2, l2, n3, l3, n4, l4);
    }

    public static void glMultiDrawElementsBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizei const *") IntBuffer intBuffer, @NativeType(value="GLenum") int n3, @NativeType(value="void const **") PointerBuffer pointerBuffer, @NativeType(value="GLint *") IntBuffer intBuffer2) {
        GL32C.glMultiDrawElementsBaseVertex(n2, intBuffer, n3, pointerBuffer, intBuffer2);
    }

    public static void glMultiDrawElementsBaseVertex(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizei const *") int[] nArray, @NativeType(value="GLenum") int n3, @NativeType(value="void const **") PointerBuffer pointerBuffer, @NativeType(value="GLint *") int[] nArray2) {
        GL32C.glMultiDrawElementsBaseVertex(n2, nArray, n3, pointerBuffer, nArray2);
    }

    static {
        GL.initialize();
    }
}

