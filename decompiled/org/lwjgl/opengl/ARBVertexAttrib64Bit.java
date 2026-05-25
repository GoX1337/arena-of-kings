/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL41C;
import org.lwjgl.system.NativeType;

public class ARBVertexAttrib64Bit {
    public static final int GL_DOUBLE_VEC2 = 36860;
    public static final int GL_DOUBLE_VEC3 = 36861;
    public static final int GL_DOUBLE_VEC4 = 36862;
    public static final int GL_DOUBLE_MAT2 = 36678;
    public static final int GL_DOUBLE_MAT3 = 36679;
    public static final int GL_DOUBLE_MAT4 = 36680;
    public static final int GL_DOUBLE_MAT2x3 = 36681;
    public static final int GL_DOUBLE_MAT2x4 = 36682;
    public static final int GL_DOUBLE_MAT3x2 = 36683;
    public static final int GL_DOUBLE_MAT3x4 = 36684;
    public static final int GL_DOUBLE_MAT4x2 = 36685;
    public static final int GL_DOUBLE_MAT4x3 = 36686;

    protected ARBVertexAttrib64Bit() {
        throw new UnsupportedOperationException();
    }

    public static void glVertexAttribL1d(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2) {
        GL41C.glVertexAttribL1d(n2, d2);
    }

    public static void glVertexAttribL2d(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3) {
        GL41C.glVertexAttribL2d(n2, d2, d3);
    }

    public static void glVertexAttribL3d(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3, @NativeType(value="GLdouble") double d4) {
        GL41C.glVertexAttribL3d(n2, d2, d3, d4);
    }

    public static void glVertexAttribL4d(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3, @NativeType(value="GLdouble") double d4, @NativeType(value="GLdouble") double d5) {
        GL41C.glVertexAttribL4d(n2, d2, d3, d4, d5);
    }

    public static void nglVertexAttribL1dv(int n2, long l2) {
        GL41C.nglVertexAttribL1dv(n2, l2);
    }

    public static void glVertexAttribL1dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glVertexAttribL1dv(n2, doubleBuffer);
    }

    public static void nglVertexAttribL2dv(int n2, long l2) {
        GL41C.nglVertexAttribL2dv(n2, l2);
    }

    public static void glVertexAttribL2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glVertexAttribL2dv(n2, doubleBuffer);
    }

    public static void nglVertexAttribL3dv(int n2, long l2) {
        GL41C.nglVertexAttribL3dv(n2, l2);
    }

    public static void glVertexAttribL3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glVertexAttribL3dv(n2, doubleBuffer);
    }

    public static void nglVertexAttribL4dv(int n2, long l2) {
        GL41C.nglVertexAttribL4dv(n2, l2);
    }

    public static void glVertexAttribL4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glVertexAttribL4dv(n2, doubleBuffer);
    }

    public static void nglVertexAttribLPointer(int n2, int n3, int n4, int n5, long l2) {
        GL41C.nglVertexAttribLPointer(n2, n3, n4, n5, l2);
    }

    public static void glVertexAttribLPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL41C.glVertexAttribLPointer(n2, n3, n4, n5, byteBuffer);
    }

    public static void glVertexAttribLPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") long l2) {
        GL41C.glVertexAttribLPointer(n2, n3, n4, n5, l2);
    }

    public static void glVertexAttribLPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL41C.glVertexAttribLPointer(n2, n3, n4, doubleBuffer);
    }

    public static void nglGetVertexAttribLdv(int n2, int n3, long l2) {
        GL41C.nglGetVertexAttribLdv(n2, n3, l2);
    }

    public static void glGetVertexAttribLdv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        GL41C.glGetVertexAttribLdv(n2, n3, doubleBuffer);
    }

    public static native void glVertexArrayVertexAttribLOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLenum") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLintptr") long var6);

    public static void glVertexAttribL1dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glVertexAttribL1dv(n2, dArray);
    }

    public static void glVertexAttribL2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glVertexAttribL2dv(n2, dArray);
    }

    public static void glVertexAttribL3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glVertexAttribL3dv(n2, dArray);
    }

    public static void glVertexAttribL4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glVertexAttribL4dv(n2, dArray);
    }

    public static void glGetVertexAttribLdv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        GL41C.glGetVertexAttribLdv(n2, n3, dArray);
    }

    static {
        GL.initialize();
    }
}

