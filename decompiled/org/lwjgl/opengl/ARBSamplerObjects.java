/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.system.NativeType;

public class ARBSamplerObjects {
    public static final int GL_SAMPLER_BINDING = 35097;

    protected ARBSamplerObjects() {
        throw new UnsupportedOperationException();
    }

    public static void nglGenSamplers(int n2, long l2) {
        GL33C.nglGenSamplers(n2, l2);
    }

    public static void glGenSamplers(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL33C.glGenSamplers(intBuffer);
    }

    @NativeType(value="void")
    public static int glGenSamplers() {
        return GL33C.glGenSamplers();
    }

    public static void nglDeleteSamplers(int n2, long l2) {
        GL33C.nglDeleteSamplers(n2, l2);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.glDeleteSamplers(intBuffer);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") int n2) {
        GL33C.glDeleteSamplers(n2);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsSampler(@NativeType(value="GLuint") int n2) {
        return GL33C.glIsSampler(n2);
    }

    public static void glBindSampler(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        GL33C.glBindSampler(n2, n3);
    }

    public static void glSamplerParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4) {
        GL33C.glSamplerParameteri(n2, n3, n4);
    }

    public static void glSamplerParameterf(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat") float f2) {
        GL33C.glSamplerParameterf(n2, n3, f2);
    }

    public static void nglSamplerParameteriv(int n2, int n3, long l2) {
        GL33C.nglSamplerParameteriv(n2, n3, l2);
    }

    public static void glSamplerParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL33C.glSamplerParameteriv(n2, n3, intBuffer);
    }

    public static void nglSamplerParameterfv(int n2, int n3, long l2) {
        GL33C.nglSamplerParameterfv(n2, n3, l2);
    }

    public static void glSamplerParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL33C.glSamplerParameterfv(n2, n3, floatBuffer);
    }

    public static void nglSamplerParameterIiv(int n2, int n3, long l2) {
        GL33C.nglSamplerParameterIiv(n2, n3, l2);
    }

    public static void glSamplerParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL33C.glSamplerParameterIiv(n2, n3, intBuffer);
    }

    public static void nglSamplerParameterIuiv(int n2, int n3, long l2) {
        GL33C.nglSamplerParameterIuiv(n2, n3, l2);
    }

    public static void glSamplerParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.glSamplerParameterIuiv(n2, n3, intBuffer);
    }

    public static void nglGetSamplerParameteriv(int n2, int n3, long l2) {
        GL33C.nglGetSamplerParameteriv(n2, n3, l2);
    }

    public static void glGetSamplerParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL33C.glGetSamplerParameteriv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetSamplerParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL33C.glGetSamplerParameteri(n2, n3);
    }

    public static void nglGetSamplerParameterfv(int n2, int n3, long l2) {
        GL33C.nglGetSamplerParameterfv(n2, n3, l2);
    }

    public static void glGetSamplerParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL33C.glGetSamplerParameterfv(n2, n3, floatBuffer);
    }

    @NativeType(value="void")
    public static float glGetSamplerParameterf(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL33C.glGetSamplerParameterf(n2, n3);
    }

    public static void nglGetSamplerParameterIiv(int n2, int n3, long l2) {
        GL33C.nglGetSamplerParameterIiv(n2, n3, l2);
    }

    public static void glGetSamplerParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL33C.glGetSamplerParameterIiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetSamplerParameterIi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL33C.glGetSamplerParameterIi(n2, n3);
    }

    public static void nglGetSamplerParameterIuiv(int n2, int n3, long l2) {
        GL33C.nglGetSamplerParameterIuiv(n2, n3, l2);
    }

    public static void glGetSamplerParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL33C.glGetSamplerParameterIuiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetSamplerParameterIui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL33C.glGetSamplerParameterIui(n2, n3);
    }

    public static void glGenSamplers(@NativeType(value="GLuint *") int[] nArray) {
        GL33C.glGenSamplers(nArray);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") int[] nArray) {
        GL33C.glDeleteSamplers(nArray);
    }

    public static void glSamplerParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int[] nArray) {
        GL33C.glSamplerParameteriv(n2, n3, nArray);
    }

    public static void glSamplerParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        GL33C.glSamplerParameterfv(n2, n3, fArray);
    }

    public static void glSamplerParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int[] nArray) {
        GL33C.glSamplerParameterIiv(n2, n3, nArray);
    }

    public static void glSamplerParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        GL33C.glSamplerParameterIuiv(n2, n3, nArray);
    }

    public static void glGetSamplerParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL33C.glGetSamplerParameteriv(n2, n3, nArray);
    }

    public static void glGetSamplerParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        GL33C.glGetSamplerParameterfv(n2, n3, fArray);
    }

    public static void glGetSamplerParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL33C.glGetSamplerParameterIiv(n2, n3, nArray);
    }

    public static void glGetSamplerParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") int[] nArray) {
        GL33C.glGetSamplerParameterIuiv(n2, n3, nArray);
    }

    static {
        GL.initialize();
    }
}

