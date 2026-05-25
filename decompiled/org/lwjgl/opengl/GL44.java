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
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43;
import org.lwjgl.opengl.GL44C;
import org.lwjgl.system.NativeType;

public class GL44
extends GL43 {
    public static final int GL_MAX_VERTEX_ATTRIB_STRIDE = 33509;
    public static final int GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED = 33313;
    public static final int GL_TEXTURE_BUFFER_BINDING = 35882;
    public static final int GL_MAP_PERSISTENT_BIT = 64;
    public static final int GL_MAP_COHERENT_BIT = 128;
    public static final int GL_DYNAMIC_STORAGE_BIT = 256;
    public static final int GL_CLIENT_STORAGE_BIT = 512;
    public static final int GL_BUFFER_IMMUTABLE_STORAGE = 33311;
    public static final int GL_BUFFER_STORAGE_FLAGS = 33312;
    public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 16384;
    public static final int GL_CLEAR_TEXTURE = 37733;
    public static final int GL_LOCATION_COMPONENT = 37706;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_INDEX = 37707;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_STRIDE = 37708;
    public static final int GL_QUERY_RESULT_NO_WAIT = 37268;
    public static final int GL_QUERY_BUFFER = 37266;
    public static final int GL_QUERY_BUFFER_BINDING = 37267;
    public static final int GL_QUERY_BUFFER_BARRIER_BIT = 32768;
    public static final int GL_MIRROR_CLAMP_TO_EDGE = 34627;

    protected GL44() {
        throw new UnsupportedOperationException();
    }

    public static void nglBufferStorage(int n2, long l2, long l3, int n3) {
        GL44C.nglBufferStorage(n2, l2, l3, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, l2, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, byteBuffer, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, shortBuffer, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, intBuffer, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") FloatBuffer floatBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, floatBuffer, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") DoubleBuffer doubleBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, doubleBuffer, n3);
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

    public static void nglBindBuffersBase(int n2, int n3, int n4, long l2) {
        GL44C.nglBindBuffersBase(n2, n3, n4, l2);
    }

    public static void glBindBuffersBase(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL44C.glBindBuffersBase(n2, n3, intBuffer);
    }

    public static void nglBindBuffersRange(int n2, int n3, int n4, long l2, long l3, long l4) {
        GL44C.nglBindBuffersRange(n2, n3, n4, l2, l3, l4);
    }

    public static void glBindBuffersRange(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizeiptr const *") PointerBuffer pointerBuffer2) {
        GL44C.glBindBuffersRange(n2, n3, intBuffer, pointerBuffer, pointerBuffer2);
    }

    public static void nglBindTextures(int n2, int n3, long l2) {
        GL44C.nglBindTextures(n2, n3, l2);
    }

    public static void glBindTextures(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL44C.glBindTextures(n2, intBuffer);
    }

    public static void nglBindSamplers(int n2, int n3, long l2) {
        GL44C.nglBindSamplers(n2, n3, l2);
    }

    public static void glBindSamplers(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL44C.glBindSamplers(n2, intBuffer);
    }

    public static void nglBindImageTextures(int n2, int n3, long l2) {
        GL44C.nglBindImageTextures(n2, n3, l2);
    }

    public static void glBindImageTextures(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL44C.glBindImageTextures(n2, intBuffer);
    }

    public static void nglBindVertexBuffers(int n2, int n3, long l2, long l3, long l4) {
        GL44C.nglBindVertexBuffers(n2, n3, l2, l3, l4);
    }

    public static void glBindVertexBuffers(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizei const *") IntBuffer intBuffer2) {
        GL44C.glBindVertexBuffers(n2, intBuffer, pointerBuffer, intBuffer2);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") short[] sArray, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, sArray, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, nArray, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") float[] fArray, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, fArray, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") double[] dArray, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, dArray, n3);
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

    public static void glBindBuffersBase(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") int[] nArray) {
        GL44C.glBindBuffersBase(n2, n3, nArray);
    }

    public static void glBindBuffersRange(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") int[] nArray, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizeiptr const *") PointerBuffer pointerBuffer2) {
        GL44C.glBindBuffersRange(n2, n3, nArray, pointerBuffer, pointerBuffer2);
    }

    public static void glBindTextures(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") int[] nArray) {
        GL44C.glBindTextures(n2, nArray);
    }

    public static void glBindSamplers(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") int[] nArray) {
        GL44C.glBindSamplers(n2, nArray);
    }

    public static void glBindImageTextures(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") int[] nArray) {
        GL44C.glBindImageTextures(n2, nArray);
    }

    public static void glBindVertexBuffers(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") int[] nArray, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizei const *") int[] nArray2) {
        GL44C.glBindVertexBuffers(n2, nArray, pointerBuffer, nArray2);
    }

    static {
        GL.initialize();
    }
}

