/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL44C;
import org.lwjgl.system.NativeType;

public class ARBClearTexture {
    public static final int GL_CLEAR_TEXTURE = 37733;

    protected ARBClearTexture() {
        throw new UnsupportedOperationException();
    }

    public static void nglClearTexSubImage(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, long l2) {
        GL44C.nglClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, l2);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL44C.glClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, byteBuffer);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL44C.glClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, shortBuffer);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        GL44C.glClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, intBuffer);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL44C.glClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, floatBuffer);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL44C.glClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, doubleBuffer);
    }

    public static void nglClearTexImage(int n2, int n3, int n4, int n5, long l2) {
        GL44C.nglClearTexImage(n2, n3, n4, n5, l2);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL44C.glClearTexImage(n2, n3, n4, n5, byteBuffer);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL44C.glClearTexImage(n2, n3, n4, n5, shortBuffer);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        GL44C.glClearTexImage(n2, n3, n4, n5, intBuffer);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL44C.glClearTexImage(n2, n3, n4, n5, floatBuffer);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL44C.glClearTexImage(n2, n3, n4, n5, doubleBuffer);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") short[] sArray) {
        GL44C.glClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, sArray);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") int[] nArray) {
        GL44C.glClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, nArray);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") float[] fArray) {
        GL44C.glClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, fArray);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") double[] dArray) {
        GL44C.glClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, dArray);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") short[] sArray) {
        GL44C.glClearTexImage(n2, n3, n4, n5, sArray);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") int[] nArray) {
        GL44C.glClearTexImage(n2, n3, n4, n5, nArray);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") float[] fArray) {
        GL44C.glClearTexImage(n2, n3, n4, n5, fArray);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") double[] dArray) {
        GL44C.glClearTexImage(n2, n3, n4, n5, dArray);
    }

    static {
        GL.initialize();
    }
}

