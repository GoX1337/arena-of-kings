/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL45;
import org.lwjgl.opengl.GL46C;
import org.lwjgl.system.NativeType;

public class GL46
extends GL45 {
    public static final int GL_PARAMETER_BUFFER = 33006;
    public static final int GL_PARAMETER_BUFFER_BINDING = 33007;
    public static final int GL_VERTICES_SUBMITTED = 33518;
    public static final int GL_PRIMITIVES_SUBMITTED = 33519;
    public static final int GL_VERTEX_SHADER_INVOCATIONS = 33520;
    public static final int GL_TESS_CONTROL_SHADER_PATCHES = 33521;
    public static final int GL_TESS_EVALUATION_SHADER_INVOCATIONS = 33522;
    public static final int GL_GEOMETRY_SHADER_PRIMITIVES_EMITTED = 33523;
    public static final int GL_FRAGMENT_SHADER_INVOCATIONS = 33524;
    public static final int GL_COMPUTE_SHADER_INVOCATIONS = 33525;
    public static final int GL_CLIPPING_INPUT_PRIMITIVES = 33526;
    public static final int GL_CLIPPING_OUTPUT_PRIMITIVES = 33527;
    public static final int GL_POLYGON_OFFSET_CLAMP = 36379;
    public static final int GL_CONTEXT_FLAG_NO_ERROR_BIT = 8;
    public static final int GL_SHADER_BINARY_FORMAT_SPIR_V = 38225;
    public static final int GL_SPIR_V_BINARY = 38226;
    public static final int GL_SPIR_V_EXTENSIONS = 38227;
    public static final int GL_NUM_SPIR_V_EXTENSIONS = 38228;
    public static final int GL_TEXTURE_MAX_ANISOTROPY = 34046;
    public static final int GL_MAX_TEXTURE_MAX_ANISOTROPY = 34047;
    public static final int GL_TRANSFORM_FEEDBACK_OVERFLOW = 33516;
    public static final int GL_TRANSFORM_FEEDBACK_STREAM_OVERFLOW = 33517;

    protected GL46() {
        throw new UnsupportedOperationException();
    }

    public static void nglMultiDrawArraysIndirectCount(int n2, long l2, long l3, int n3, int n4) {
        GL46C.nglMultiDrawArraysIndirectCount(n2, l2, l3, n3, n4);
    }

    public static void glMultiDrawArraysIndirectCount(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        GL46C.glMultiDrawArraysIndirectCount(n2, byteBuffer, l2, n3, n4);
    }

    public static void glMultiDrawArraysIndirectCount(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") long l2, @NativeType(value="GLintptr") long l3, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        GL46C.glMultiDrawArraysIndirectCount(n2, l2, l3, n3, n4);
    }

    public static void glMultiDrawArraysIndirectCount(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        GL46C.glMultiDrawArraysIndirectCount(n2, intBuffer, l2, n3, n4);
    }

    public static void nglMultiDrawElementsIndirectCount(int n2, int n3, long l2, long l3, int n4, int n5) {
        GL46C.nglMultiDrawElementsIndirectCount(n2, n3, l2, l3, n4, n5);
    }

    public static void glMultiDrawElementsIndirectCount(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        GL46C.glMultiDrawElementsIndirectCount(n2, n3, byteBuffer, l2, n4, n5);
    }

    public static void glMultiDrawElementsIndirectCount(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") long l2, @NativeType(value="GLintptr") long l3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        GL46C.glMultiDrawElementsIndirectCount(n2, n3, l2, l3, n4, n5);
    }

    public static void glMultiDrawElementsIndirectCount(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        GL46C.glMultiDrawElementsIndirectCount(n2, n3, intBuffer, l2, n4, n5);
    }

    public static void glPolygonOffsetClamp(@NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4) {
        GL46C.glPolygonOffsetClamp(f2, f3, f4);
    }

    public static void nglSpecializeShader(int n2, long l2, int n3, long l3, long l4) {
        GL46C.nglSpecializeShader(n2, l2, n3, l3, l4);
    }

    public static void glSpecializeShader(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer2) {
        GL46C.glSpecializeShader(n2, byteBuffer, intBuffer, intBuffer2);
    }

    public static void glSpecializeShader(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer2) {
        GL46C.glSpecializeShader(n2, charSequence, intBuffer, intBuffer2);
    }

    public static void glMultiDrawArraysIndirectCount(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        GL46C.glMultiDrawArraysIndirectCount(n2, nArray, l2, n3, n4);
    }

    public static void glMultiDrawElementsIndirectCount(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        GL46C.glMultiDrawElementsIndirectCount(n2, n3, nArray, l2, n4, n5);
    }

    public static void glSpecializeShader(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer, @Nullable @NativeType(value="GLuint const *") int[] nArray, @Nullable @NativeType(value="GLuint const *") int[] nArray2) {
        GL46C.glSpecializeShader(n2, byteBuffer, nArray, nArray2);
    }

    public static void glSpecializeShader(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence, @Nullable @NativeType(value="GLuint const *") int[] nArray, @Nullable @NativeType(value="GLuint const *") int[] nArray2) {
        GL46C.glSpecializeShader(n2, charSequence, nArray, nArray2);
    }

    static {
        GL.initialize();
    }
}

