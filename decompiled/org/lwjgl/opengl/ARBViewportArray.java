/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL41C;
import org.lwjgl.system.NativeType;

public class ARBViewportArray {
    public static final int GL_MAX_VIEWPORTS = 33371;
    public static final int GL_VIEWPORT_SUBPIXEL_BITS = 33372;
    public static final int GL_VIEWPORT_BOUNDS_RANGE = 33373;
    public static final int GL_LAYER_PROVOKING_VERTEX = 33374;
    public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 33375;
    public static final int GL_UNDEFINED_VERTEX = 33376;

    protected ARBViewportArray() {
        throw new UnsupportedOperationException();
    }

    public static void nglViewportArrayv(int n2, int n3, long l2) {
        GL41C.nglViewportArrayv(n2, n3, l2);
    }

    public static void glViewportArrayv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glViewportArrayv(n2, floatBuffer);
    }

    public static void glViewportIndexedf(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4, @NativeType(value="GLfloat") float f5) {
        GL41C.glViewportIndexedf(n2, f2, f3, f4, f5);
    }

    public static void nglViewportIndexedfv(int n2, long l2) {
        GL41C.nglViewportIndexedfv(n2, l2);
    }

    public static void glViewportIndexedfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glViewportIndexedfv(n2, floatBuffer);
    }

    public static void nglScissorArrayv(int n2, int n3, long l2) {
        GL41C.nglScissorArrayv(n2, n3, l2);
    }

    public static void glScissorArrayv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL41C.glScissorArrayv(n2, intBuffer);
    }

    public static void glScissorIndexed(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6) {
        GL41C.glScissorIndexed(n2, n3, n4, n5, n6);
    }

    public static void nglScissorIndexedv(int n2, long l2) {
        GL41C.nglScissorIndexedv(n2, l2);
    }

    public static void glScissorIndexedv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL41C.glScissorIndexedv(n2, intBuffer);
    }

    public static void nglDepthRangeArrayv(int n2, int n3, long l2) {
        GL41C.nglDepthRangeArrayv(n2, n3, l2);
    }

    public static void glDepthRangeArrayv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glDepthRangeArrayv(n2, doubleBuffer);
    }

    public static void glDepthRangeIndexed(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3) {
        GL41C.glDepthRangeIndexed(n2, d2, d3);
    }

    public static void nglGetFloati_v(int n2, int n3, long l2) {
        GL41C.nglGetFloati_v(n2, n3, l2);
    }

    public static void glGetFloati_v(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL41C.glGetFloati_v(n2, n3, floatBuffer);
    }

    @NativeType(value="void")
    public static float glGetFloati(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        return GL41C.glGetFloati(n2, n3);
    }

    public static void nglGetDoublei_v(int n2, int n3, long l2) {
        GL41C.nglGetDoublei_v(n2, n3, l2);
    }

    public static void glGetDoublei_v(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        GL41C.glGetDoublei_v(n2, n3, doubleBuffer);
    }

    @NativeType(value="void")
    public static double glGetDoublei(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        return GL41C.glGetDoublei(n2, n3);
    }

    public static void glViewportArrayv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glViewportArrayv(n2, fArray);
    }

    public static void glViewportIndexedfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glViewportIndexedfv(n2, fArray);
    }

    public static void glScissorArrayv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        GL41C.glScissorArrayv(n2, nArray);
    }

    public static void glScissorIndexedv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        GL41C.glScissorIndexedv(n2, nArray);
    }

    public static void glDepthRangeArrayv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glDepthRangeArrayv(n2, dArray);
    }

    public static void glGetFloati_v(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        GL41C.glGetFloati_v(n2, n3, fArray);
    }

    public static void glGetDoublei_v(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        GL41C.glGetDoublei_v(n2, n3, dArray);
    }

    static {
        GL.initialize();
    }
}

