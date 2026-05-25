/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.EXTDrawBuffers2;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTDirectStateAccess {
    public static final int GL_PROGRAM_MATRIX_EXT = 36397;
    public static final int GL_TRANSPOSE_PROGRAM_MATRIX_EXT = 36398;
    public static final int GL_PROGRAM_MATRIX_STACK_DEPTH_EXT = 36399;

    protected EXTDirectStateAccess() {
        throw new UnsupportedOperationException();
    }

    public static native void glClientAttribDefaultEXT(@NativeType(value="GLbitfield") int var0);

    public static native void glPushClientAttribDefaultEXT(@NativeType(value="GLbitfield") int var0);

    public static native void nglMatrixLoadfEXT(int var0, long var1);

    public static void glMatrixLoadfEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 16);
        }
        EXTDirectStateAccess.nglMatrixLoadfEXT(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglMatrixLoaddEXT(int var0, long var1);

    public static void glMatrixLoaddEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 16);
        }
        EXTDirectStateAccess.nglMatrixLoaddEXT(n2, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglMatrixMultfEXT(int var0, long var1);

    public static void glMatrixMultfEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 16);
        }
        EXTDirectStateAccess.nglMatrixMultfEXT(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglMatrixMultdEXT(int var0, long var1);

    public static void glMatrixMultdEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 16);
        }
        EXTDirectStateAccess.nglMatrixMultdEXT(n2, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glMatrixLoadIdentityEXT(@NativeType(value="GLenum") int var0);

    public static native void glMatrixRotatefEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void glMatrixRotatedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7);

    public static native void glMatrixScalefEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glMatrixScaledEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5);

    public static native void glMatrixTranslatefEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glMatrixTranslatedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5);

    public static native void glMatrixOrthoEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7, @NativeType(value="GLdouble") double var9, @NativeType(value="GLdouble") double var11);

    public static native void glMatrixFrustumEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7, @NativeType(value="GLdouble") double var9, @NativeType(value="GLdouble") double var11);

    public static native void glMatrixPushEXT(@NativeType(value="GLenum") int var0);

    public static native void glMatrixPopEXT(@NativeType(value="GLenum") int var0);

    public static native void glTextureParameteriEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLint") int var3);

    public static native void nglTextureParameterivEXT(int var0, int var1, int var2, long var3);

    public static void glTextureParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        EXTDirectStateAccess.nglTextureParameterivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glTextureParameterfEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLfloat") float var3);

    public static native void nglTextureParameterfvEXT(int var0, int var1, int var2, long var3);

    public static void glTextureParameterfvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 4);
        }
        EXTDirectStateAccess.nglTextureParameterfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglTextureImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglTextureImage1DEXT(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglTextureImage1DEXT(n2, n3, n4, n5, n6, n7, n8, n9, l2);
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglTextureImage1DEXT(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglTextureImage1DEXT(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglTextureImage1DEXT(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglTextureImage1DEXT(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddressSafe(doubleBuffer));
    }

    public static native void nglTextureImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglTextureImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglTextureImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, l2);
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglTextureImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglTextureImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglTextureImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglTextureImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddressSafe(doubleBuffer));
    }

    public static native void nglTextureSubImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglTextureSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglTextureSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, l2);
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglTextureSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglTextureSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, MemoryUtil.memAddress(intBuffer));
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglTextureSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglTextureSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglTextureSubImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglTextureSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglTextureSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, l2);
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglTextureSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglTextureSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddress(intBuffer));
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglTextureSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglTextureSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glCopyTextureImage1DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLint") int var7);

    public static native void glCopyTextureImage2DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLsizei") int var7, @NativeType(value="GLint") int var8);

    public static native void glCopyTextureSubImage1DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6);

    public static native void glCopyTextureSubImage2DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLsizei") int var7, @NativeType(value="GLsizei") int var8);

    public static native void nglGetTextureImageEXT(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglGetTextureImageEXT(n2, n3, n4, n5, n6, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") long l2) {
        EXTDirectStateAccess.nglGetTextureImageEXT(n2, n3, n4, n5, n6, l2);
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglGetTextureImageEXT(n2, n3, n4, n5, n6, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglGetTextureImageEXT(n2, n3, n4, n5, n6, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglGetTextureImageEXT(n2, n3, n4, n5, n6, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglGetTextureImageEXT(n2, n3, n4, n5, n6, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglGetTextureParameterfvEXT(int var0, int var1, int var2, long var3);

    public static void glGetTextureParameterfvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        EXTDirectStateAccess.nglGetTextureParameterfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetTextureParameterfEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            EXTDirectStateAccess.nglGetTextureParameterfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetTextureParameterivEXT(int var0, int var1, int var2, long var3);

    public static void glGetTextureParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetTextureParameterivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureParameteriEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetTextureParameterivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetTextureLevelParameterfvEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glGetTextureLevelParameterfvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        EXTDirectStateAccess.nglGetTextureLevelParameterfvEXT(n2, n3, n4, n5, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetTextureLevelParameterfEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n6 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            EXTDirectStateAccess.nglGetTextureLevelParameterfvEXT(n2, n3, n4, n5, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n6);
        }
    }

    public static native void nglGetTextureLevelParameterivEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glGetTextureLevelParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetTextureLevelParameterivEXT(n2, n3, n4, n5, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureLevelParameteriEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n6 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetTextureLevelParameterivEXT(n2, n3, n4, n5, MemoryUtil.memAddress(intBuffer));
            int n7 = intBuffer.get(0);
            return n7;
        }
        finally {
            memoryStack.setPointer(n6);
        }
    }

    public static native void nglTextureImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglTextureImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglTextureImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, l2);
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglTextureImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglTextureImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglTextureImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglTextureImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(doubleBuffer));
    }

    public static native void nglTextureSubImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, long var11);

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglTextureSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglTextureSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, l2);
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglTextureSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglTextureSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, MemoryUtil.memAddress(intBuffer));
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglTextureSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglTextureSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glCopyTextureSubImage3DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLint") int var7, @NativeType(value="GLsizei") int var8, @NativeType(value="GLsizei") int var9);

    public static native void glBindMultiTextureEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void nglMultiTexCoordPointerEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglMultiTexCoordPointerEXT(n2, n3, n4, n5, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglMultiTexCoordPointerEXT(n2, n3, n4, n5, l2);
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglMultiTexCoordPointerEXT(n2, n3, n4, n5, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglMultiTexCoordPointerEXT(n2, n3, n4, n5, MemoryUtil.memAddress(intBuffer));
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglMultiTexCoordPointerEXT(n2, n3, n4, n5, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glMultiTexEnvfEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLfloat") float var3);

    public static native void nglMultiTexEnvfvEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexEnvfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 4);
        }
        EXTDirectStateAccess.nglMultiTexEnvfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glMultiTexEnviEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLint") int var3);

    public static native void nglMultiTexEnvivEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexEnvivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        EXTDirectStateAccess.nglMultiTexEnvivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glMultiTexGendEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLdouble") double var3);

    public static native void nglMultiTexGendvEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexGendvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 4);
        }
        EXTDirectStateAccess.nglMultiTexGendvEXT(n2, n3, n4, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glMultiTexGenfEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLfloat") float var3);

    public static native void nglMultiTexGenfvEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexGenfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 4);
        }
        EXTDirectStateAccess.nglMultiTexGenfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glMultiTexGeniEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLint") int var3);

    public static native void nglMultiTexGenivEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexGenivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        EXTDirectStateAccess.nglMultiTexGenivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglGetMultiTexEnvfvEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexEnvfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexEnvfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetMultiTexEnvfEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            EXTDirectStateAccess.nglGetMultiTexEnvfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetMultiTexEnvivEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexEnvivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexEnvivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMultiTexEnviEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetMultiTexEnvivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetMultiTexGendvEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexGendvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexGendvEXT(n2, n3, n4, MemoryUtil.memAddress(doubleBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetMultiTexGendEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
            EXTDirectStateAccess.nglGetMultiTexGendvEXT(n2, n3, n4, MemoryUtil.memAddress(doubleBuffer));
            double d2 = doubleBuffer.get(0);
            return d2;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetMultiTexGenfvEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexGenfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexGenfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetMultiTexGenfEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            EXTDirectStateAccess.nglGetMultiTexGenfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetMultiTexGenivEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexGenivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexGenivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMultiTexGeniEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetMultiTexGenivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void glMultiTexParameteriEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLint") int var3);

    public static native void nglMultiTexParameterivEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexParameterivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        EXTDirectStateAccess.nglMultiTexParameterivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glMultiTexParameterfEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLfloat") float var3);

    public static native void nglMultiTexParameterfvEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexParameterfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 4);
        }
        EXTDirectStateAccess.nglMultiTexParameterfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglMultiTexImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglMultiTexImage1DEXT(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglMultiTexImage1DEXT(n2, n3, n4, n5, n6, n7, n8, n9, l2);
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglMultiTexImage1DEXT(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglMultiTexImage1DEXT(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglMultiTexImage1DEXT(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglMultiTexImage1DEXT(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddressSafe(doubleBuffer));
    }

    public static native void nglMultiTexImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglMultiTexImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglMultiTexImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, l2);
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglMultiTexImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglMultiTexImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglMultiTexImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglMultiTexImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddressSafe(doubleBuffer));
    }

    public static native void nglMultiTexSubImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglMultiTexSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, l2);
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, MemoryUtil.memAddress(intBuffer));
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglMultiTexSubImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglMultiTexSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, l2);
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddress(intBuffer));
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glCopyMultiTexImage1DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLint") int var7);

    public static native void glCopyMultiTexImage2DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLsizei") int var7, @NativeType(value="GLint") int var8);

    public static native void glCopyMultiTexSubImage1DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6);

    public static native void glCopyMultiTexSubImage2DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLsizei") int var7, @NativeType(value="GLsizei") int var8);

    public static native void nglGetMultiTexImageEXT(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglGetMultiTexImageEXT(n2, n3, n4, n5, n6, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") long l2) {
        EXTDirectStateAccess.nglGetMultiTexImageEXT(n2, n3, n4, n5, n6, l2);
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglGetMultiTexImageEXT(n2, n3, n4, n5, n6, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglGetMultiTexImageEXT(n2, n3, n4, n5, n6, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglGetMultiTexImageEXT(n2, n3, n4, n5, n6, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglGetMultiTexImageEXT(n2, n3, n4, n5, n6, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglGetMultiTexParameterfvEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexParameterfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexParameterfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetMultiTexParameterfEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            EXTDirectStateAccess.nglGetMultiTexParameterfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetMultiTexParameterivEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexParameterivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexParameterivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMultiTexParameteriEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetMultiTexParameterivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetMultiTexLevelParameterfvEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glGetMultiTexLevelParameterfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexLevelParameterfvEXT(n2, n3, n4, n5, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetMultiTexLevelParameterfEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n6 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            EXTDirectStateAccess.nglGetMultiTexLevelParameterfvEXT(n2, n3, n4, n5, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n6);
        }
    }

    public static native void nglGetMultiTexLevelParameterivEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glGetMultiTexLevelParameterivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexLevelParameterivEXT(n2, n3, n4, n5, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMultiTexLevelParameteriEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n6 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetMultiTexLevelParameterivEXT(n2, n3, n4, n5, MemoryUtil.memAddress(intBuffer));
            int n7 = intBuffer.get(0);
            return n7;
        }
        finally {
            memoryStack.setPointer(n6);
        }
    }

    public static native void nglMultiTexImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglMultiTexImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglMultiTexImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, l2);
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglMultiTexImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglMultiTexImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglMultiTexImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglMultiTexImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(doubleBuffer));
    }

    public static native void nglMultiTexSubImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, long var11);

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglMultiTexSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, l2);
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, MemoryUtil.memAddress(intBuffer));
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglMultiTexSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glCopyMultiTexSubImage3DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLint") int var7, @NativeType(value="GLsizei") int var8, @NativeType(value="GLsizei") int var9);

    public static native void glEnableClientStateIndexedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glDisableClientStateIndexedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glEnableClientStateiEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glDisableClientStateiEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglGetFloatIndexedvEXT(int var0, int var1, long var2);

    public static void glGetFloatIndexedvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        EXTDirectStateAccess.nglGetFloatIndexedvEXT(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetFloatIndexedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            EXTDirectStateAccess.nglGetFloatIndexedvEXT(n2, n3, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetDoubleIndexedvEXT(int var0, int var1, long var2);

    public static void glGetDoubleIndexedvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 1);
        }
        EXTDirectStateAccess.nglGetDoubleIndexedvEXT(n2, n3, MemoryUtil.memAddress(doubleBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetDoubleIndexedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
            EXTDirectStateAccess.nglGetDoubleIndexedvEXT(n2, n3, MemoryUtil.memAddress(doubleBuffer));
            double d2 = doubleBuffer.get(0);
            return d2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetPointerIndexedvEXT(int var0, int var1, long var2);

    public static void glGetPointerIndexedvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="void **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        EXTDirectStateAccess.nglGetPointerIndexedvEXT(n2, n3, MemoryUtil.memAddress(pointerBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetPointerIndexedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
            EXTDirectStateAccess.nglGetPointerIndexedvEXT(n2, n3, MemoryUtil.memAddress(pointerBuffer));
            long l2 = pointerBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetFloati_vEXT(int var0, int var1, long var2);

    public static void glGetFloati_vEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        EXTDirectStateAccess.nglGetFloati_vEXT(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetFloatiEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            EXTDirectStateAccess.nglGetFloati_vEXT(n2, n3, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetDoublei_vEXT(int var0, int var1, long var2);

    public static void glGetDoublei_vEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 1);
        }
        EXTDirectStateAccess.nglGetDoublei_vEXT(n2, n3, MemoryUtil.memAddress(doubleBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetDoubleiEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
            EXTDirectStateAccess.nglGetDoublei_vEXT(n2, n3, MemoryUtil.memAddress(doubleBuffer));
            double d2 = doubleBuffer.get(0);
            return d2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetPointeri_vEXT(int var0, int var1, long var2);

    public static void glGetPointeri_vEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="void **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        EXTDirectStateAccess.nglGetPointeri_vEXT(n2, n3, MemoryUtil.memAddress(pointerBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetPointeriEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
            EXTDirectStateAccess.nglGetPointeri_vEXT(n2, n3, MemoryUtil.memAddress(pointerBuffer));
            long l2 = pointerBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void glEnableIndexedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        EXTDrawBuffers2.glEnableIndexedEXT(n2, n3);
    }

    public static void glDisableIndexedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        EXTDrawBuffers2.glDisableIndexedEXT(n2, n3);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsEnabledIndexedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        return EXTDrawBuffers2.glIsEnabledIndexedEXT(n2, n3);
    }

    public static void nglGetIntegerIndexedvEXT(int n2, int n3, long l2) {
        EXTDrawBuffers2.nglGetIntegerIndexedvEXT(n2, n3, l2);
    }

    public static void glGetIntegerIndexedvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        EXTDrawBuffers2.glGetIntegerIndexedvEXT(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetIntegerIndexedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        return EXTDrawBuffers2.glGetIntegerIndexedEXT(n2, n3);
    }

    public static void nglGetBooleanIndexedvEXT(int n2, int n3, long l2) {
        EXTDrawBuffers2.nglGetBooleanIndexedvEXT(n2, n3, l2);
    }

    public static void glGetBooleanIndexedvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLboolean *") ByteBuffer byteBuffer) {
        EXTDrawBuffers2.glGetBooleanIndexedvEXT(n2, n3, byteBuffer);
    }

    @NativeType(value="void")
    public static boolean glGetBooleanIndexedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        return EXTDrawBuffers2.glGetBooleanIndexedEXT(n2, n3);
    }

    public static native void nglNamedProgramStringEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glNamedProgramStringEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglNamedProgramStringEXT(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void glNamedProgramLocalParameter4dEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7, @NativeType(value="GLdouble") double var9);

    public static native void nglNamedProgramLocalParameter4dvEXT(int var0, int var1, int var2, long var3);

    public static void glNamedProgramLocalParameter4dvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 4);
        }
        EXTDirectStateAccess.nglNamedProgramLocalParameter4dvEXT(n2, n3, n4, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glNamedProgramLocalParameter4fEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4, @NativeType(value="GLfloat") float var5, @NativeType(value="GLfloat") float var6);

    public static native void nglNamedProgramLocalParameter4fvEXT(int var0, int var1, int var2, long var3);

    public static void glNamedProgramLocalParameter4fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 4);
        }
        EXTDirectStateAccess.nglNamedProgramLocalParameter4fvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetNamedProgramLocalParameterdvEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedProgramLocalParameterdvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 4);
        }
        EXTDirectStateAccess.nglGetNamedProgramLocalParameterdvEXT(n2, n3, n4, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglGetNamedProgramLocalParameterfvEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedProgramLocalParameterfvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 4);
        }
        EXTDirectStateAccess.nglGetNamedProgramLocalParameterfvEXT(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetNamedProgramivEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedProgramivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetNamedProgramivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedProgramiEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetNamedProgramivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetNamedProgramStringEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedProgramStringEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)byteBuffer, EXTDirectStateAccess.glGetNamedProgramiEXT(n2, n3, 34343));
        }
        EXTDirectStateAccess.nglGetNamedProgramStringEXT(n2, n3, n4, MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglCompressedTextureImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glCompressedTextureImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLsizei") int n10, @Nullable @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglCompressedTextureImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, l2);
    }

    public static void glCompressedTextureImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglCompressedTextureImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, Checks.remainingSafe(byteBuffer), MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static native void nglCompressedTextureImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glCompressedTextureImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLsizei") int n9, @Nullable @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglCompressedTextureImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, l2);
    }

    public static void glCompressedTextureImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglCompressedTextureImage2DEXT(n2, n3, n4, n5, n6, n7, n8, Checks.remainingSafe(byteBuffer), MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static native void nglCompressedTextureImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glCompressedTextureImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @Nullable @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglCompressedTextureImage1DEXT(n2, n3, n4, n5, n6, n7, n8, l2);
    }

    public static void glCompressedTextureImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglCompressedTextureImage1DEXT(n2, n3, n4, n5, n6, n7, Checks.remainingSafe(byteBuffer), MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static native void nglCompressedTextureSubImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, long var11);

    public static void glCompressedTextureSubImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLsizei") int n12, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglCompressedTextureSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, l2);
    }

    public static void glCompressedTextureSubImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglCompressedTextureSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglCompressedTextureSubImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glCompressedTextureSubImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglCompressedTextureSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, l2);
    }

    public static void glCompressedTextureSubImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglCompressedTextureSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglCompressedTextureSubImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glCompressedTextureSubImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglCompressedTextureSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, l2);
    }

    public static void glCompressedTextureSubImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglCompressedTextureSubImage1DEXT(n2, n3, n4, n5, n6, n7, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetCompressedTextureImageEXT(int var0, int var1, int var2, long var3);

    public static void glGetCompressedTextureImageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)byteBuffer, EXTDirectStateAccess.glGetTextureLevelParameteriEXT(n2, n3, n4, 34464));
        }
        EXTDirectStateAccess.nglGetCompressedTextureImageEXT(n2, n3, n4, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetCompressedTextureImageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="void *") long l2) {
        EXTDirectStateAccess.nglGetCompressedTextureImageEXT(n2, n3, n4, l2);
    }

    public static native void nglCompressedMultiTexImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glCompressedMultiTexImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLsizei") int n10, @Nullable @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglCompressedMultiTexImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, l2);
    }

    public static void glCompressedMultiTexImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglCompressedMultiTexImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, Checks.remainingSafe(byteBuffer), MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static native void nglCompressedMultiTexImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glCompressedMultiTexImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLsizei") int n9, @Nullable @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglCompressedMultiTexImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, l2);
    }

    public static void glCompressedMultiTexImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglCompressedMultiTexImage2DEXT(n2, n3, n4, n5, n6, n7, n8, Checks.remainingSafe(byteBuffer), MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static native void nglCompressedMultiTexImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glCompressedMultiTexImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @Nullable @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglCompressedMultiTexImage1DEXT(n2, n3, n4, n5, n6, n7, n8, l2);
    }

    public static void glCompressedMultiTexImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglCompressedMultiTexImage1DEXT(n2, n3, n4, n5, n6, n7, Checks.remainingSafe(byteBuffer), MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static native void nglCompressedMultiTexSubImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, long var11);

    public static void glCompressedMultiTexSubImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLsizei") int n12, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglCompressedMultiTexSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, l2);
    }

    public static void glCompressedMultiTexSubImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglCompressedMultiTexSubImage3DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglCompressedMultiTexSubImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glCompressedMultiTexSubImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglCompressedMultiTexSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, n10, l2);
    }

    public static void glCompressedMultiTexSubImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglCompressedMultiTexSubImage2DEXT(n2, n3, n4, n5, n6, n7, n8, n9, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglCompressedMultiTexSubImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glCompressedMultiTexSubImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="void const *") long l2) {
        EXTDirectStateAccess.nglCompressedMultiTexSubImage1DEXT(n2, n3, n4, n5, n6, n7, n8, l2);
    }

    public static void glCompressedMultiTexSubImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglCompressedMultiTexSubImage1DEXT(n2, n3, n4, n5, n6, n7, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetCompressedMultiTexImageEXT(int var0, int var1, int var2, long var3);

    public static void glGetCompressedMultiTexImageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)byteBuffer, EXTDirectStateAccess.glGetMultiTexLevelParameteriEXT(n2, n3, n4, 34464));
        }
        EXTDirectStateAccess.nglGetCompressedMultiTexImageEXT(n2, n3, n4, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetCompressedMultiTexImageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="void *") long l2) {
        EXTDirectStateAccess.nglGetCompressedMultiTexImageEXT(n2, n3, n4, l2);
    }

    public static native void nglMatrixLoadTransposefEXT(int var0, long var1);

    public static void glMatrixLoadTransposefEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 16);
        }
        EXTDirectStateAccess.nglMatrixLoadTransposefEXT(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglMatrixLoadTransposedEXT(int var0, long var1);

    public static void glMatrixLoadTransposedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 16);
        }
        EXTDirectStateAccess.nglMatrixLoadTransposedEXT(n2, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglMatrixMultTransposefEXT(int var0, long var1);

    public static void glMatrixMultTransposefEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 16);
        }
        EXTDirectStateAccess.nglMatrixMultTransposefEXT(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglMatrixMultTransposedEXT(int var0, long var1);

    public static void glMatrixMultTransposedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 16);
        }
        EXTDirectStateAccess.nglMatrixMultTransposedEXT(n2, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglNamedBufferDataEXT(int var0, long var1, long var3, int var5);

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3) {
        EXTDirectStateAccess.nglNamedBufferDataEXT(n2, l2, 0L, n3);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n3) {
        EXTDirectStateAccess.nglNamedBufferDataEXT(n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), n3);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLenum") int n3) {
        EXTDirectStateAccess.nglNamedBufferDataEXT(n2, Integer.toUnsignedLong(shortBuffer.remaining()) << 1, MemoryUtil.memAddress(shortBuffer), n3);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLenum") int n3) {
        EXTDirectStateAccess.nglNamedBufferDataEXT(n2, Integer.toUnsignedLong(intBuffer.remaining()) << 2, MemoryUtil.memAddress(intBuffer), n3);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") FloatBuffer floatBuffer, @NativeType(value="GLenum") int n3) {
        EXTDirectStateAccess.nglNamedBufferDataEXT(n2, Integer.toUnsignedLong(floatBuffer.remaining()) << 2, MemoryUtil.memAddress(floatBuffer), n3);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") DoubleBuffer doubleBuffer, @NativeType(value="GLenum") int n3) {
        EXTDirectStateAccess.nglNamedBufferDataEXT(n2, Integer.toUnsignedLong(doubleBuffer.remaining()) << 3, MemoryUtil.memAddress(doubleBuffer), n3);
    }

    public static native void nglNamedBufferSubDataEXT(int var0, long var1, long var3, long var5);

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglNamedBufferSubDataEXT(n2, l2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglNamedBufferSubDataEXT(n2, l2, Integer.toUnsignedLong(shortBuffer.remaining()) << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglNamedBufferSubDataEXT(n2, l2, Integer.toUnsignedLong(intBuffer.remaining()) << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglNamedBufferSubDataEXT(n2, l2, Integer.toUnsignedLong(floatBuffer.remaining()) << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglNamedBufferSubDataEXT(n2, l2, Integer.toUnsignedLong(doubleBuffer.remaining()) << 3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native long nglMapNamedBufferEXT(int var0, int var1);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        long l2 = EXTDirectStateAccess.nglMapNamedBufferEXT(n2, n3);
        return MemoryUtil.memByteBufferSafe(l2, EXTDirectStateAccess.glGetNamedBufferParameteriEXT(n2, 34660));
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @Nullable ByteBuffer byteBuffer) {
        long l2 = EXTDirectStateAccess.nglMapNamedBufferEXT(n2, n3);
        int n4 = EXTDirectStateAccess.glGetNamedBufferParameteriEXT(n2, 34660);
        return APIUtil.apiGetMappedBuffer(byteBuffer, l2, n4);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, long l2, @Nullable ByteBuffer byteBuffer) {
        long l3 = EXTDirectStateAccess.nglMapNamedBufferEXT(n2, n3);
        return APIUtil.apiGetMappedBuffer(byteBuffer, l3, (int)l2);
    }

    @NativeType(value="GLboolean")
    public static native boolean glUnmapNamedBufferEXT(@NativeType(value="GLuint") int var0);

    public static native void nglGetNamedBufferParameterivEXT(int var0, int var1, long var2);

    public static void glGetNamedBufferParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetNamedBufferParameterivEXT(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedBufferParameteriEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetNamedBufferParameterivEXT(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetNamedBufferSubDataEXT(int var0, long var1, long var3, long var5);

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") ByteBuffer byteBuffer) {
        EXTDirectStateAccess.nglGetNamedBufferSubDataEXT(n2, l2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") ShortBuffer shortBuffer) {
        EXTDirectStateAccess.nglGetNamedBufferSubDataEXT(n2, l2, Integer.toUnsignedLong(shortBuffer.remaining()) << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglGetNamedBufferSubDataEXT(n2, l2, Integer.toUnsignedLong(intBuffer.remaining()) << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglGetNamedBufferSubDataEXT(n2, l2, Integer.toUnsignedLong(floatBuffer.remaining()) << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        EXTDirectStateAccess.nglGetNamedBufferSubDataEXT(n2, l2, Integer.toUnsignedLong(doubleBuffer.remaining()) << 3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glProgramUniform1fEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2);

    public static native void glProgramUniform2fEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glProgramUniform3fEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void glProgramUniform4fEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4, @NativeType(value="GLfloat") float var5);

    public static native void glProgramUniform1iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glProgramUniform2iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glProgramUniform3iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glProgramUniform4iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5);

    public static native void nglProgramUniform1fvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniform1fvEXT(n2, n3, floatBuffer.remaining(), MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramUniform2fvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniform2fvEXT(n2, n3, floatBuffer.remaining() >> 1, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramUniform3fvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniform3fvEXT(n2, n3, floatBuffer.remaining() / 3, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramUniform4fvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniform4fvEXT(n2, n3, floatBuffer.remaining() >> 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramUniform1ivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1ivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglProgramUniform1ivEXT(n2, n3, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglProgramUniform2ivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2ivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglProgramUniform2ivEXT(n2, n3, intBuffer.remaining() >> 1, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglProgramUniform3ivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3ivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglProgramUniform3ivEXT(n2, n3, intBuffer.remaining() / 3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglProgramUniform4ivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4ivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglProgramUniform4ivEXT(n2, n3, intBuffer.remaining() >> 2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglProgramUniformMatrix2fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniformMatrix2fvEXT(n2, n3, floatBuffer.remaining() >> 2, bl2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramUniformMatrix3fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniformMatrix3fvEXT(n2, n3, floatBuffer.remaining() / 9, bl2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramUniformMatrix4fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniformMatrix4fvEXT(n2, n3, floatBuffer.remaining() >> 4, bl2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramUniformMatrix2x3fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2x3fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniformMatrix2x3fvEXT(n2, n3, floatBuffer.remaining() / 6, bl2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramUniformMatrix3x2fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3x2fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniformMatrix3x2fvEXT(n2, n3, floatBuffer.remaining() / 6, bl2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramUniformMatrix2x4fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2x4fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniformMatrix2x4fvEXT(n2, n3, floatBuffer.remaining() >> 3, bl2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramUniformMatrix4x2fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4x2fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniformMatrix4x2fvEXT(n2, n3, floatBuffer.remaining() >> 3, bl2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramUniformMatrix3x4fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3x4fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniformMatrix3x4fvEXT(n2, n3, floatBuffer.remaining() / 12, bl2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramUniformMatrix4x3fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4x3fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglProgramUniformMatrix4x3fvEXT(n2, n3, floatBuffer.remaining() / 12, bl2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glTextureBufferEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3);

    public static native void glMultiTexBufferEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3);

    public static native void nglTextureParameterIivEXT(int var0, int var1, int var2, long var3);

    public static void glTextureParameterIivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        EXTDirectStateAccess.nglTextureParameterIivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglTextureParameterIuivEXT(int var0, int var1, int var2, long var3);

    public static void glTextureParameterIuivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        EXTDirectStateAccess.nglTextureParameterIuivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglGetTextureParameterIivEXT(int var0, int var1, int var2, long var3);

    public static void glGetTextureParameterIivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetTextureParameterIivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureParameterIiEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetTextureParameterIivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetTextureParameterIuivEXT(int var0, int var1, int var2, long var3);

    public static void glGetTextureParameterIuivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetTextureParameterIuivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureParameterIuiEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetTextureParameterIuivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglMultiTexParameterIivEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexParameterIivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        EXTDirectStateAccess.nglMultiTexParameterIivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglMultiTexParameterIuivEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexParameterIuivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        EXTDirectStateAccess.nglMultiTexParameterIuivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglGetMultiTexParameterIivEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexParameterIivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexParameterIivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMultiTexParameterIiEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetMultiTexParameterIivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetMultiTexParameterIuivEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexParameterIuivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexParameterIuivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMultiTexParameterIuiEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetMultiTexParameterIuivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void glProgramUniform1uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glProgramUniform2uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3);

    public static native void glProgramUniform3uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLuint") int var4);

    public static native void glProgramUniform4uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLuint") int var4, @NativeType(value="GLuint") int var5);

    public static native void nglProgramUniform1uivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1uivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglProgramUniform1uivEXT(n2, n3, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglProgramUniform2uivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2uivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglProgramUniform2uivEXT(n2, n3, intBuffer.remaining() >> 1, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglProgramUniform3uivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3uivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglProgramUniform3uivEXT(n2, n3, intBuffer.remaining() / 3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglProgramUniform4uivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4uivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglProgramUniform4uivEXT(n2, n3, intBuffer.remaining() >> 2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglNamedProgramLocalParameters4fvEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glNamedProgramLocalParameters4fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTDirectStateAccess.nglNamedProgramLocalParameters4fvEXT(n2, n3, n4, floatBuffer.remaining() >> 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glNamedProgramLocalParameterI4iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6);

    public static native void nglNamedProgramLocalParameterI4ivEXT(int var0, int var1, int var2, long var3);

    public static void glNamedProgramLocalParameterI4ivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        EXTDirectStateAccess.nglNamedProgramLocalParameterI4ivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglNamedProgramLocalParametersI4ivEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glNamedProgramLocalParametersI4ivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglNamedProgramLocalParametersI4ivEXT(n2, n3, n4, intBuffer.remaining() >> 2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glNamedProgramLocalParameterI4uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLuint") int var4, @NativeType(value="GLuint") int var5, @NativeType(value="GLuint") int var6);

    public static native void nglNamedProgramLocalParameterI4uivEXT(int var0, int var1, int var2, long var3);

    public static void glNamedProgramLocalParameterI4uivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        EXTDirectStateAccess.nglNamedProgramLocalParameterI4uivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglNamedProgramLocalParametersI4uivEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glNamedProgramLocalParametersI4uivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglNamedProgramLocalParametersI4uivEXT(n2, n3, n4, intBuffer.remaining() >> 2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglGetNamedProgramLocalParameterIivEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedProgramLocalParameterIivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        EXTDirectStateAccess.nglGetNamedProgramLocalParameterIivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglGetNamedProgramLocalParameterIuivEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedProgramLocalParameterIuivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        EXTDirectStateAccess.nglGetNamedProgramLocalParameterIuivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glNamedRenderbufferStorageEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLsizei") int var3);

    public static native void nglGetNamedRenderbufferParameterivEXT(int var0, int var1, long var2);

    public static void glGetNamedRenderbufferParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetNamedRenderbufferParameterivEXT(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedRenderbufferParameteriEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetNamedRenderbufferParameterivEXT(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void glNamedRenderbufferStorageMultisampleEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4);

    public static native void glNamedRenderbufferStorageMultisampleCoverageEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5);

    @NativeType(value="GLenum")
    public static native int glCheckNamedFramebufferStatusEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glNamedFramebufferTexture1DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLint") int var4);

    public static native void glNamedFramebufferTexture2DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLint") int var4);

    public static native void glNamedFramebufferTexture3DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5);

    public static native void glNamedFramebufferRenderbufferEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3);

    public static native void nglGetNamedFramebufferAttachmentParameterivEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedFramebufferAttachmentParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetNamedFramebufferAttachmentParameterivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedFramebufferAttachmentParameteriEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetNamedFramebufferAttachmentParameterivEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void glGenerateTextureMipmapEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glGenerateMultiTexMipmapEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1);

    public static native void glFramebufferDrawBufferEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglFramebufferDrawBuffersEXT(int var0, int var1, long var2);

    public static void glFramebufferDrawBuffersEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") IntBuffer intBuffer) {
        EXTDirectStateAccess.nglFramebufferDrawBuffersEXT(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static native void glFramebufferReadBufferEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglGetFramebufferParameterivEXT(int var0, int var1, long var2);

    public static void glGetFramebufferParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetFramebufferParameterivEXT(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetFramebufferParameteriEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetFramebufferParameterivEXT(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void glNamedCopyBufferSubDataEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLintptr") long var2, @NativeType(value="GLintptr") long var4, @NativeType(value="GLsizeiptr") long var6);

    public static native void glNamedFramebufferTextureEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3);

    public static native void glNamedFramebufferTextureLayerEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glNamedFramebufferTextureFaceEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLenum") int var4);

    public static native void glTextureRenderbufferEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glMultiTexRenderbufferEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glVertexArrayVertexOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLintptr") long var5);

    public static native void glVertexArrayColorOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLintptr") long var5);

    public static native void glVertexArrayEdgeFlagOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glVertexArrayIndexOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLintptr") long var4);

    public static native void glVertexArrayNormalOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLintptr") long var4);

    public static native void glVertexArrayTexCoordOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLintptr") long var5);

    public static native void glVertexArrayMultiTexCoordOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLenum") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLintptr") long var6);

    public static native void glVertexArrayFogCoordOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLintptr") long var4);

    public static native void glVertexArraySecondaryColorOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLintptr") long var5);

    public static native void glVertexArrayVertexAttribOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLenum") int var4, @NativeType(value="GLboolean") boolean var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLintptr") long var7);

    public static native void glVertexArrayVertexAttribIOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLenum") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLintptr") long var6);

    public static native void glEnableVertexArrayEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glDisableVertexArrayEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glEnableVertexArrayAttribEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glDisableVertexArrayAttribEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglGetVertexArrayIntegervEXT(int var0, int var1, long var2);

    public static void glGetVertexArrayIntegervEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetVertexArrayIntegervEXT(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexArrayIntegerEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetVertexArrayIntegervEXT(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetVertexArrayPointervEXT(int var0, int var1, long var2);

    public static void glGetVertexArrayPointervEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        EXTDirectStateAccess.nglGetVertexArrayPointervEXT(n2, n3, MemoryUtil.memAddress(pointerBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetVertexArrayPointerEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
            EXTDirectStateAccess.nglGetVertexArrayPointervEXT(n2, n3, MemoryUtil.memAddress(pointerBuffer));
            long l2 = pointerBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetVertexArrayIntegeri_vEXT(int var0, int var1, int var2, long var3);

    public static void glGetVertexArrayIntegeri_vEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDirectStateAccess.nglGetVertexArrayIntegeri_vEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexArrayIntegeriEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            EXTDirectStateAccess.nglGetVertexArrayIntegeri_vEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetVertexArrayPointeri_vEXT(int var0, int var1, int var2, long var3);

    public static void glGetVertexArrayPointeri_vEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        EXTDirectStateAccess.nglGetVertexArrayPointeri_vEXT(n2, n3, n4, MemoryUtil.memAddress(pointerBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetVertexArrayPointeriEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
            EXTDirectStateAccess.nglGetVertexArrayPointeri_vEXT(n2, n3, n4, MemoryUtil.memAddress(pointerBuffer));
            long l2 = pointerBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native long nglMapNamedBufferRangeEXT(int var0, long var1, long var3, int var5);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferRangeEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLbitfield") int n3) {
        long l4 = EXTDirectStateAccess.nglMapNamedBufferRangeEXT(n2, l2, l3, n3);
        return MemoryUtil.memByteBufferSafe(l4, (int)l3);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferRangeEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLbitfield") int n3, @Nullable ByteBuffer byteBuffer) {
        long l4 = EXTDirectStateAccess.nglMapNamedBufferRangeEXT(n2, l2, l3, n3);
        return APIUtil.apiGetMappedBuffer(byteBuffer, l4, (int)l3);
    }

    public static native void glFlushMappedNamedBufferRangeEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLintptr") long var1, @NativeType(value="GLsizeiptr") long var3);

    public static void glMatrixLoadfEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMatrixLoadfEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 16);
        }
        JNI.callPV(n2, fArray, l2);
    }

    public static void glMatrixLoaddEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        long l2 = GL.getICD().glMatrixLoaddEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 16);
        }
        JNI.callPV(n2, dArray, l2);
    }

    public static void glMatrixMultfEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMatrixMultfEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 16);
        }
        JNI.callPV(n2, fArray, l2);
    }

    public static void glMatrixMultdEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        long l2 = GL.getICD().glMatrixMultdEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 16);
        }
        JNI.callPV(n2, dArray, l2);
    }

    public static void glTextureParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glTextureParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glTextureParameterfvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glTextureParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 4);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glTextureImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, sArray, l2);
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glTextureImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, nArray, l2);
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glTextureImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, fArray, l2);
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glTextureImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, dArray, l2);
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glTextureImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, sArray, l2);
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glTextureImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, nArray, l2);
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glTextureImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, fArray, l2);
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glTextureImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, dArray, l2);
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glTextureSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, sArray, l2);
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glTextureSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, nArray, l2);
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glTextureSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, fArray, l2);
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glTextureSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, dArray, l2);
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glTextureSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, sArray, l2);
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glTextureSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, nArray, l2);
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glTextureSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, fArray, l2);
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glTextureSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, dArray, l2);
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") short[] sArray) {
        long l2 = GL.getICD().glGetTextureImageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, sArray, l2);
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getICD().glGetTextureImageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, nArray, l2);
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getICD().glGetTextureImageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, fArray, l2);
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") double[] dArray) {
        long l2 = GL.getICD().glGetTextureImageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, dArray, l2);
    }

    public static void glGetTextureParameterfvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetTextureParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glGetTextureParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetTextureParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetTextureLevelParameterfvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetTextureLevelParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, n4, n5, fArray, l2);
    }

    public static void glGetTextureLevelParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetTextureLevelParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, n5, nArray, l2);
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glTextureImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, sArray, l2);
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glTextureImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, nArray, l2);
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glTextureImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, fArray, l2);
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glTextureImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, dArray, l2);
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glTextureSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, sArray, l2);
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glTextureSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, nArray, l2);
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glTextureSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, fArray, l2);
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glTextureSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, dArray, l2);
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glMultiTexCoordPointerEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, sArray, l2);
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexCoordPointerEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, nArray, l2);
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glMultiTexCoordPointerEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, fArray, l2);
    }

    public static void glMultiTexEnvfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMultiTexEnvfvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 4);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glMultiTexEnvivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexEnvivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glMultiTexGendvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLdouble const *") double[] dArray) {
        long l2 = GL.getICD().glMultiTexGendvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 4);
        }
        JNI.callPV(n2, n3, n4, dArray, l2);
    }

    public static void glMultiTexGenfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMultiTexGenfvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 4);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glMultiTexGenivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexGenivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetMultiTexEnvfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetMultiTexEnvfvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glGetMultiTexEnvivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetMultiTexEnvivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetMultiTexGendvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLdouble *") double[] dArray) {
        long l2 = GL.getICD().glGetMultiTexGendvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 1);
        }
        JNI.callPV(n2, n3, n4, dArray, l2);
    }

    public static void glGetMultiTexGenfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetMultiTexGenfvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glGetMultiTexGenivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetMultiTexGenivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glMultiTexParameterivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glMultiTexParameterfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMultiTexParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 4);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glMultiTexImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, sArray, l2);
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, nArray, l2);
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glMultiTexImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, fArray, l2);
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @Nullable @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glMultiTexImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, dArray, l2);
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glMultiTexImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, sArray, l2);
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, nArray, l2);
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glMultiTexImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, fArray, l2);
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @Nullable @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glMultiTexImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, dArray, l2);
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glMultiTexSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, sArray, l2);
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, nArray, l2);
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glMultiTexSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, fArray, l2);
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glMultiTexSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, dArray, l2);
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glMultiTexSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, sArray, l2);
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, nArray, l2);
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glMultiTexSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, fArray, l2);
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glMultiTexSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, dArray, l2);
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") short[] sArray) {
        long l2 = GL.getICD().glGetMultiTexImageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, sArray, l2);
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getICD().glGetMultiTexImageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, nArray, l2);
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getICD().glGetMultiTexImageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, fArray, l2);
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void *") double[] dArray) {
        long l2 = GL.getICD().glGetMultiTexImageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, dArray, l2);
    }

    public static void glGetMultiTexParameterfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetMultiTexParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glGetMultiTexParameterivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetMultiTexParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetMultiTexLevelParameterfvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetMultiTexLevelParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, n4, n5, fArray, l2);
    }

    public static void glGetMultiTexLevelParameterivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetMultiTexLevelParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, n5, nArray, l2);
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glMultiTexImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, sArray, l2);
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, nArray, l2);
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glMultiTexImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, fArray, l2);
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glMultiTexImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, dArray, l2);
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glMultiTexSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, sArray, l2);
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, nArray, l2);
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glMultiTexSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, fArray, l2);
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLenum") int n12, @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glMultiTexSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, dArray, l2);
    }

    public static void glGetFloatIndexedvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetFloatIndexedvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glGetDoubleIndexedvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        long l2 = GL.getICD().glGetDoubleIndexedvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 1);
        }
        JNI.callPV(n2, n3, dArray, l2);
    }

    public static void glGetFloati_vEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetFloati_vEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glGetDoublei_vEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        long l2 = GL.getICD().glGetDoublei_vEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 1);
        }
        JNI.callPV(n2, n3, dArray, l2);
    }

    public static void glGetIntegerIndexedvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint *") int[] nArray) {
        EXTDrawBuffers2.glGetIntegerIndexedvEXT(n2, n3, nArray);
    }

    public static void glNamedProgramLocalParameter4dvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLdouble const *") double[] dArray) {
        long l2 = GL.getICD().glNamedProgramLocalParameter4dvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 4);
        }
        JNI.callPV(n2, n3, n4, dArray, l2);
    }

    public static void glNamedProgramLocalParameter4fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glNamedProgramLocalParameter4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 4);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glGetNamedProgramLocalParameterdvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLdouble *") double[] dArray) {
        long l2 = GL.getICD().glGetNamedProgramLocalParameterdvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 4);
        }
        JNI.callPV(n2, n3, n4, dArray, l2);
    }

    public static void glGetNamedProgramLocalParameterfvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetNamedProgramLocalParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 4);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glGetNamedProgramivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedProgramivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glMatrixLoadTransposefEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMatrixLoadTransposefEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 16);
        }
        JNI.callPV(n2, fArray, l2);
    }

    public static void glMatrixLoadTransposedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        long l2 = GL.getICD().glMatrixLoadTransposedEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 16);
        }
        JNI.callPV(n2, dArray, l2);
    }

    public static void glMatrixMultTransposefEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMatrixMultTransposefEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 16);
        }
        JNI.callPV(n2, fArray, l2);
    }

    public static void glMatrixMultTransposedEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        long l2 = GL.getICD().glMatrixMultTransposedEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 16);
        }
        JNI.callPV(n2, dArray, l2);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") short[] sArray, @NativeType(value="GLenum") int n3) {
        long l2 = GL.getICD().glNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(sArray.length) << 1, sArray, n3, l2);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLenum") int n3) {
        long l2 = GL.getICD().glNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(nArray.length) << 2, nArray, n3, l2);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") float[] fArray, @NativeType(value="GLenum") int n3) {
        long l2 = GL.getICD().glNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(fArray.length) << 2, fArray, n3, l2);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") double[] dArray, @NativeType(value="GLenum") int n3) {
        long l2 = GL.getICD().glNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(dArray.length) << 3, dArray, n3, l2);
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") short[] sArray) {
        long l3 = GL.getICD().glNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(sArray.length) << 1, sArray, l3);
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") int[] nArray) {
        long l3 = GL.getICD().glNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(nArray.length) << 2, nArray, l3);
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") float[] fArray) {
        long l3 = GL.getICD().glNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(fArray.length) << 2, fArray, l3);
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") double[] dArray) {
        long l3 = GL.getICD().glNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(dArray.length) << 3, dArray, l3);
    }

    public static void glGetNamedBufferParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedBufferParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") short[] sArray) {
        long l3 = GL.getICD().glGetNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(sArray.length) << 1, sArray, l3);
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") int[] nArray) {
        long l3 = GL.getICD().glGetNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(nArray.length) << 2, nArray, l3);
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") float[] fArray) {
        long l3 = GL.getICD().glGetNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(fArray.length) << 2, fArray, l3);
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") double[] dArray) {
        long l3 = GL.getICD().glGetNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(dArray.length) << 3, dArray, l3);
    }

    public static void glProgramUniform1fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniform1fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length, fArray, l2);
    }

    public static void glProgramUniform2fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniform2fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 1, fArray, l2);
    }

    public static void glProgramUniform3fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniform3fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length / 3, fArray, l2);
    }

    public static void glProgramUniform4fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniform4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 2, fArray, l2);
    }

    public static void glProgramUniform1ivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glProgramUniform1ivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length, nArray, l2);
    }

    public static void glProgramUniform2ivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glProgramUniform2ivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length >> 1, nArray, l2);
    }

    public static void glProgramUniform3ivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glProgramUniform3ivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length / 3, nArray, l2);
    }

    public static void glProgramUniform4ivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glProgramUniform4ivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length >> 2, nArray, l2);
    }

    public static void glProgramUniformMatrix2fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniformMatrix2fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 2, bl2, fArray, l2);
    }

    public static void glProgramUniformMatrix3fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniformMatrix3fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length / 9, bl2, fArray, l2);
    }

    public static void glProgramUniformMatrix4fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniformMatrix4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 4, bl2, fArray, l2);
    }

    public static void glProgramUniformMatrix2x3fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniformMatrix2x3fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length / 6, bl2, fArray, l2);
    }

    public static void glProgramUniformMatrix3x2fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniformMatrix3x2fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length / 6, bl2, fArray, l2);
    }

    public static void glProgramUniformMatrix2x4fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniformMatrix2x4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 3, bl2, fArray, l2);
    }

    public static void glProgramUniformMatrix4x2fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniformMatrix4x2fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 3, bl2, fArray, l2);
    }

    public static void glProgramUniformMatrix3x4fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniformMatrix3x4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length / 12, bl2, fArray, l2);
    }

    public static void glProgramUniformMatrix4x3fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramUniformMatrix4x3fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length / 12, bl2, fArray, l2);
    }

    public static void glTextureParameterIivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glTextureParameterIivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glTextureParameterIuivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glTextureParameterIuivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetTextureParameterIivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetTextureParameterIivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetTextureParameterIuivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGetTextureParameterIuivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glMultiTexParameterIivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexParameterIivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glMultiTexParameterIuivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexParameterIuivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetMultiTexParameterIivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetMultiTexParameterIivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetMultiTexParameterIuivEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGetMultiTexParameterIuivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glProgramUniform1uivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glProgramUniform1uivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length, nArray, l2);
    }

    public static void glProgramUniform2uivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glProgramUniform2uivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length >> 1, nArray, l2);
    }

    public static void glProgramUniform3uivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glProgramUniform3uivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length / 3, nArray, l2);
    }

    public static void glProgramUniform4uivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glProgramUniform4uivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length >> 2, nArray, l2);
    }

    public static void glNamedProgramLocalParameters4fvEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glNamedProgramLocalParameters4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, fArray.length >> 2, fArray, l2);
    }

    public static void glNamedProgramLocalParameterI4ivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glNamedProgramLocalParameterI4ivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glNamedProgramLocalParametersI4ivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glNamedProgramLocalParametersI4ivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, nArray.length >> 2, nArray, l2);
    }

    public static void glNamedProgramLocalParameterI4uivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glNamedProgramLocalParameterI4uivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glNamedProgramLocalParametersI4uivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glNamedProgramLocalParametersI4uivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, nArray.length >> 2, nArray, l2);
    }

    public static void glGetNamedProgramLocalParameterIivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedProgramLocalParameterIivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetNamedProgramLocalParameterIuivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedProgramLocalParameterIuivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetNamedRenderbufferParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedRenderbufferParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetNamedFramebufferAttachmentParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedFramebufferAttachmentParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glFramebufferDrawBuffersEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int[] nArray) {
        long l2 = GL.getICD().glFramebufferDrawBuffersEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length, nArray, l2);
    }

    public static void glGetFramebufferParameterivEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetFramebufferParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetVertexArrayIntegervEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetVertexArrayIntegervEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetVertexArrayIntegeri_vEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetVertexArrayIntegeri_vEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    static {
        GL.initialize();
    }
}

