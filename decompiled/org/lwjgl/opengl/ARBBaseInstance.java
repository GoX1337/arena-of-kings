/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL42C;
import org.lwjgl.system.NativeType;

public class ARBBaseInstance {
    protected ARBBaseInstance() {
        throw new UnsupportedOperationException();
    }

    public static void glDrawArraysInstancedBaseInstance(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLuint") int n6) {
        GL42C.glDrawArraysInstancedBaseInstance(n2, n3, n4, n5, n6);
    }

    public static void nglDrawElementsInstancedBaseInstance(int n2, int n3, int n4, long l2, int n5, int n6) {
        GL42C.nglDrawElementsInstancedBaseInstance(n2, n3, n4, l2, n5, n6);
    }

    public static void glDrawElementsInstancedBaseInstance(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") long l2, @NativeType(value="GLsizei") int n5, @NativeType(value="GLuint") int n6) {
        GL42C.glDrawElementsInstancedBaseInstance(n2, n3, n4, l2, n5, n6);
    }

    public static void glDrawElementsInstancedBaseInstance(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n4, @NativeType(value="GLuint") int n5) {
        GL42C.glDrawElementsInstancedBaseInstance(n2, n3, byteBuffer, n4, n5);
    }

    public static void glDrawElementsInstancedBaseInstance(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLuint") int n4) {
        GL42C.glDrawElementsInstancedBaseInstance(n2, byteBuffer, n3, n4);
    }

    public static void glDrawElementsInstancedBaseInstance(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLuint") int n4) {
        GL42C.glDrawElementsInstancedBaseInstance(n2, shortBuffer, n3, n4);
    }

    public static void glDrawElementsInstancedBaseInstance(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLuint") int n4) {
        GL42C.glDrawElementsInstancedBaseInstance(n2, intBuffer, n3, n4);
    }

    public static void nglDrawElementsInstancedBaseVertexBaseInstance(int n2, int n3, int n4, long l2, int n5, int n6, int n7) {
        GL42C.nglDrawElementsInstancedBaseVertexBaseInstance(n2, n3, n4, l2, n5, n6, n7);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") long l2, @NativeType(value="GLsizei") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLuint") int n7) {
        GL42C.glDrawElementsInstancedBaseVertexBaseInstance(n2, n3, n4, l2, n5, n6, n7);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLuint") int n6) {
        GL42C.glDrawElementsInstancedBaseVertexBaseInstance(n2, n3, byteBuffer, n4, n5, n6);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLuint") int n5) {
        GL42C.glDrawElementsInstancedBaseVertexBaseInstance(n2, byteBuffer, n3, n4, n5);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLuint") int n5) {
        GL42C.glDrawElementsInstancedBaseVertexBaseInstance(n2, shortBuffer, n3, n4, n5);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLuint") int n5) {
        GL42C.glDrawElementsInstancedBaseVertexBaseInstance(n2, intBuffer, n3, n4, n5);
    }

    static {
        GL.initialize();
    }
}

