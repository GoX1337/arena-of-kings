/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL45C;
import org.lwjgl.system.NativeType;

public class ARBGetTextureSubImage {
    protected ARBGetTextureSubImage() {
        throw new UnsupportedOperationException();
    }

    public static void nglGetTextureSubImage(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, long l2) {
        GL45C.nglGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, l2);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLsizei") int n12, @NativeType(value="void *") long l2) {
        GL45C.glGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, l2);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.glGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, byteBuffer);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45C.glGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, shortBuffer);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45C.glGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, intBuffer);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45C.glGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, floatBuffer);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        GL45C.glGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, doubleBuffer);
    }

    public static void nglGetCompressedTextureSubImage(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, long l2) {
        GL45C.nglGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, l2);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="void *") long l2) {
        GL45C.glGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, l2);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.glGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, byteBuffer);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45C.glGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, shortBuffer);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45C.glGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, intBuffer);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45C.glGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, floatBuffer);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        GL45C.glGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, doubleBuffer);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") short[] sArray) {
        GL45C.glGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, sArray);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") int[] nArray) {
        GL45C.glGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, nArray);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") float[] fArray) {
        GL45C.glGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, fArray);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") double[] dArray) {
        GL45C.glGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, dArray);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") short[] sArray) {
        GL45C.glGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, sArray);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") int[] nArray) {
        GL45C.glGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, nArray);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") float[] fArray) {
        GL45C.glGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, fArray);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") double[] dArray) {
        GL45C.glGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, dArray);
    }

    static {
        GL.initialize();
    }
}

