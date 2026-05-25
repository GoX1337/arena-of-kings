/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL45C;
import org.lwjgl.system.NativeType;

public class KHRRobustness {
    public static final int GL_NO_ERROR = 0;
    public static final int GL_GUILTY_CONTEXT_RESET = 33363;
    public static final int GL_INNOCENT_CONTEXT_RESET = 33364;
    public static final int GL_UNKNOWN_CONTEXT_RESET = 33365;
    public static final int GL_CONTEXT_ROBUST_ACCESS = 37107;
    public static final int GL_RESET_NOTIFICATION_STRATEGY = 33366;
    public static final int GL_LOSE_CONTEXT_ON_RESET = 33362;
    public static final int GL_NO_RESET_NOTIFICATION = 33377;
    public static final int GL_CONTEXT_LOST = 1287;

    protected KHRRobustness() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="GLenum")
    public static int glGetGraphicsResetStatus() {
        return GL45C.glGetGraphicsResetStatus();
    }

    public static void nglReadnPixels(int n2, int n3, int n4, int n5, int n6, int n7, int n8, long l2) {
        GL45C.nglReadnPixels(n2, n3, n4, n5, n6, n7, n8, l2);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="void *") long l2) {
        GL45C.glReadnPixels(n2, n3, n4, n5, n6, n7, n8, l2);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.glReadnPixels(n2, n3, n4, n5, n6, n7, byteBuffer);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45C.glReadnPixels(n2, n3, n4, n5, n6, n7, shortBuffer);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45C.glReadnPixels(n2, n3, n4, n5, n6, n7, intBuffer);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45C.glReadnPixels(n2, n3, n4, n5, n6, n7, floatBuffer);
    }

    public static void nglGetnUniformfv(int n2, int n3, int n4, long l2) {
        GL45C.nglGetnUniformfv(n2, n3, n4, l2);
    }

    public static void glGetnUniformfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL45C.glGetnUniformfv(n2, n3, floatBuffer);
    }

    @NativeType(value="void")
    public static float glGetnUniformf(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        return GL45C.glGetnUniformf(n2, n3);
    }

    public static void nglGetnUniformiv(int n2, int n3, int n4, long l2) {
        GL45C.nglGetnUniformiv(n2, n3, n4, l2);
    }

    public static void glGetnUniformiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.glGetnUniformiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetnUniformi(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        return GL45C.glGetnUniformi(n2, n3);
    }

    public static void nglGetnUniformuiv(int n2, int n3, int n4, long l2) {
        GL45C.nglGetnUniformuiv(n2, n3, n4, l2);
    }

    public static void glGetnUniformuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.glGetnUniformuiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetnUniformui(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        return GL45C.glGetnUniformui(n2, n3);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") short[] sArray) {
        GL45C.glReadnPixels(n2, n3, n4, n5, n6, n7, sArray);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") int[] nArray) {
        GL45C.glReadnPixels(n2, n3, n4, n5, n6, n7, nArray);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") float[] fArray) {
        GL45C.glReadnPixels(n2, n3, n4, n5, n6, n7, fArray);
    }

    public static void glGetnUniformfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        GL45C.glGetnUniformfv(n2, n3, fArray);
    }

    public static void glGetnUniformiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL45C.glGetnUniformiv(n2, n3, nArray);
    }

    public static void glGetnUniformuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint *") int[] nArray) {
        GL45C.glGetnUniformuiv(n2, n3, nArray);
    }

    static {
        GL.initialize();
    }
}

