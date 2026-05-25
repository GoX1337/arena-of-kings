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
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL44;
import org.lwjgl.opengl.GL45C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL45
extends GL44 {
    public static final int GL_NEGATIVE_ONE_TO_ONE = 37726;
    public static final int GL_ZERO_TO_ONE = 37727;
    public static final int GL_CLIP_ORIGIN = 37724;
    public static final int GL_CLIP_DEPTH_MODE = 37725;
    public static final int GL_QUERY_WAIT_INVERTED = 36375;
    public static final int GL_QUERY_NO_WAIT_INVERTED = 36376;
    public static final int GL_QUERY_BY_REGION_WAIT_INVERTED = 36377;
    public static final int GL_QUERY_BY_REGION_NO_WAIT_INVERTED = 36378;
    public static final int GL_MAX_CULL_DISTANCES = 33529;
    public static final int GL_MAX_COMBINED_CLIP_AND_CULL_DISTANCES = 33530;
    public static final int GL_TEXTURE_TARGET = 4102;
    public static final int GL_QUERY_TARGET = 33514;
    public static final int GL_CONTEXT_RELEASE_BEHAVIOR = 33531;
    public static final int GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH = 33532;
    public static final int GL_GUILTY_CONTEXT_RESET = 33363;
    public static final int GL_INNOCENT_CONTEXT_RESET = 33364;
    public static final int GL_UNKNOWN_CONTEXT_RESET = 33365;
    public static final int GL_RESET_NOTIFICATION_STRATEGY = 33366;
    public static final int GL_LOSE_CONTEXT_ON_RESET = 33362;
    public static final int GL_NO_RESET_NOTIFICATION = 33377;
    public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT = 4;
    public static final int GL_CONTEXT_LOST = 1287;

    protected GL45() {
        throw new UnsupportedOperationException();
    }

    public static void glClipControl(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        GL45C.glClipControl(n2, n3);
    }

    public static void nglCreateTransformFeedbacks(int n2, long l2) {
        GL45C.nglCreateTransformFeedbacks(n2, l2);
    }

    public static void glCreateTransformFeedbacks(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.glCreateTransformFeedbacks(intBuffer);
    }

    @NativeType(value="void")
    public static int glCreateTransformFeedbacks() {
        return GL45C.glCreateTransformFeedbacks();
    }

    public static void glTransformFeedbackBufferBase(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4) {
        GL45C.glTransformFeedbackBufferBase(n2, n3, n4);
    }

    public static void glTransformFeedbackBufferRange(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3) {
        GL45C.glTransformFeedbackBufferRange(n2, n3, n4, l2, l3);
    }

    public static void nglGetTransformFeedbackiv(int n2, int n3, long l2) {
        GL45C.nglGetTransformFeedbackiv(n2, n3, l2);
    }

    public static void glGetTransformFeedbackiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.glGetTransformFeedbackiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetTransformFeedbacki(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glGetTransformFeedbacki(n2, n3);
    }

    public static void nglGetTransformFeedbacki_v(int n2, int n3, int n4, long l2) {
        GL45C.nglGetTransformFeedbacki_v(n2, n3, n4, l2);
    }

    public static void glGetTransformFeedbacki_v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.glGetTransformFeedbacki_v(n2, n3, n4, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetTransformFeedbacki(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        return GL45C.glGetTransformFeedbacki(n2, n3, n4);
    }

    public static void nglGetTransformFeedbacki64_v(int n2, int n3, int n4, long l2) {
        GL45C.nglGetTransformFeedbacki64_v(n2, n3, n4, l2);
    }

    public static void glGetTransformFeedbacki64_v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        GL45C.glGetTransformFeedbacki64_v(n2, n3, n4, longBuffer);
    }

    @NativeType(value="void")
    public static long glGetTransformFeedbacki64(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        return GL45C.glGetTransformFeedbacki64(n2, n3, n4);
    }

    public static void nglCreateBuffers(int n2, long l2) {
        GL45C.nglCreateBuffers(n2, l2);
    }

    public static void glCreateBuffers(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.glCreateBuffers(intBuffer);
    }

    @NativeType(value="void")
    public static int glCreateBuffers() {
        return GL45C.glCreateBuffers();
    }

    public static void nglNamedBufferStorage(int n2, long l2, long l3, int n3) {
        GL45C.nglNamedBufferStorage(n2, l2, l3, n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLbitfield") int n3) {
        GL45C.glNamedBufferStorage(n2, l2, n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLbitfield") int n3) {
        GL45C.glNamedBufferStorage(n2, byteBuffer, n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLbitfield") int n3) {
        GL45C.glNamedBufferStorage(n2, shortBuffer, n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLbitfield") int n3) {
        GL45C.glNamedBufferStorage(n2, intBuffer, n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") FloatBuffer floatBuffer, @NativeType(value="GLbitfield") int n3) {
        GL45C.glNamedBufferStorage(n2, floatBuffer, n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") DoubleBuffer doubleBuffer, @NativeType(value="GLbitfield") int n3) {
        GL45C.glNamedBufferStorage(n2, doubleBuffer, n3);
    }

    public static void nglNamedBufferData(int n2, long l2, long l3, int n3) {
        GL45C.nglNamedBufferData(n2, l2, l3, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedBufferData(n2, l2, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedBufferData(n2, byteBuffer, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedBufferData(n2, shortBuffer, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedBufferData(n2, intBuffer, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") LongBuffer longBuffer, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedBufferData(n2, longBuffer, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") FloatBuffer floatBuffer, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedBufferData(n2, floatBuffer, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") DoubleBuffer doubleBuffer, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedBufferData(n2, doubleBuffer, n3);
    }

    public static void nglNamedBufferSubData(int n2, long l2, long l3, long l4) {
        GL45C.nglNamedBufferSubData(n2, l2, l3, l4);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.glNamedBufferSubData(n2, l2, byteBuffer);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL45C.glNamedBufferSubData(n2, l2, shortBuffer);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL45C.glNamedBufferSubData(n2, l2, intBuffer);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") LongBuffer longBuffer) {
        GL45C.glNamedBufferSubData(n2, l2, longBuffer);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL45C.glNamedBufferSubData(n2, l2, floatBuffer);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL45C.glNamedBufferSubData(n2, l2, doubleBuffer);
    }

    public static void glCopyNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLintptr") long l3, @NativeType(value="GLsizeiptr") long l4) {
        GL45C.glCopyNamedBufferSubData(n2, n3, l2, l3, l4);
    }

    public static void nglClearNamedBufferData(int n2, int n3, int n4, int n5, long l2) {
        GL45C.nglClearNamedBufferData(n2, n3, n4, n5, l2);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.glClearNamedBufferData(n2, n3, n4, n5, byteBuffer);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL45C.glClearNamedBufferData(n2, n3, n4, n5, shortBuffer);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        GL45C.glClearNamedBufferData(n2, n3, n4, n5, intBuffer);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL45C.glClearNamedBufferData(n2, n3, n4, n5, floatBuffer);
    }

    public static void nglClearNamedBufferSubData(int n2, int n3, long l2, long l3, int n4, int n5, long l4) {
        GL45C.nglClearNamedBufferSubData(n2, n3, l2, l3, n4, n5, l4);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.glClearNamedBufferSubData(n2, n3, l2, l3, n4, n5, byteBuffer);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL45C.glClearNamedBufferSubData(n2, n3, l2, l3, n4, n5, shortBuffer);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        GL45C.glClearNamedBufferSubData(n2, n3, l2, l3, n4, n5, intBuffer);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL45C.glClearNamedBufferSubData(n2, n3, l2, l3, n4, n5, floatBuffer);
    }

    public static long nglMapNamedBuffer(int n2, int n3) {
        return GL45C.nglMapNamedBuffer(n2, n3);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glMapNamedBuffer(n2, n3);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @Nullable ByteBuffer byteBuffer) {
        return GL45C.glMapNamedBuffer(n2, n3, byteBuffer);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, long l2, @Nullable ByteBuffer byteBuffer) {
        return GL45C.glMapNamedBuffer(n2, n3, l2, byteBuffer);
    }

    public static long nglMapNamedBufferRange(int n2, long l2, long l3, int n3) {
        return GL45C.nglMapNamedBufferRange(n2, l2, l3, n3);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferRange(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLbitfield") int n3) {
        return GL45C.glMapNamedBufferRange(n2, l2, l3, n3);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferRange(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLbitfield") int n3, @Nullable ByteBuffer byteBuffer) {
        return GL45C.glMapNamedBufferRange(n2, l2, l3, n3, byteBuffer);
    }

    @NativeType(value="GLboolean")
    public static boolean glUnmapNamedBuffer(@NativeType(value="GLuint") int n2) {
        return GL45C.glUnmapNamedBuffer(n2);
    }

    public static void glFlushMappedNamedBufferRange(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3) {
        GL45C.glFlushMappedNamedBufferRange(n2, l2, l3);
    }

    public static void nglGetNamedBufferParameteriv(int n2, int n3, long l2) {
        GL45C.nglGetNamedBufferParameteriv(n2, n3, l2);
    }

    public static void glGetNamedBufferParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.glGetNamedBufferParameteriv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetNamedBufferParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glGetNamedBufferParameteri(n2, n3);
    }

    public static void nglGetNamedBufferParameteri64v(int n2, int n3, long l2) {
        GL45C.nglGetNamedBufferParameteri64v(n2, n3, l2);
    }

    public static void glGetNamedBufferParameteri64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        GL45C.glGetNamedBufferParameteri64v(n2, n3, longBuffer);
    }

    @NativeType(value="void")
    public static long glGetNamedBufferParameteri64(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glGetNamedBufferParameteri64(n2, n3);
    }

    public static void nglGetNamedBufferPointerv(int n2, int n3, long l2) {
        GL45C.nglGetNamedBufferPointerv(n2, n3, l2);
    }

    public static void glGetNamedBufferPointerv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void **") PointerBuffer pointerBuffer) {
        GL45C.glGetNamedBufferPointerv(n2, n3, pointerBuffer);
    }

    @NativeType(value="void")
    public static long glGetNamedBufferPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glGetNamedBufferPointer(n2, n3);
    }

    public static void nglGetNamedBufferSubData(int n2, long l2, long l3, long l4) {
        GL45C.nglGetNamedBufferSubData(n2, l2, l3, l4);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.glGetNamedBufferSubData(n2, l2, byteBuffer);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45C.glGetNamedBufferSubData(n2, l2, shortBuffer);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45C.glGetNamedBufferSubData(n2, l2, intBuffer);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") LongBuffer longBuffer) {
        GL45C.glGetNamedBufferSubData(n2, l2, longBuffer);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45C.glGetNamedBufferSubData(n2, l2, floatBuffer);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        GL45C.glGetNamedBufferSubData(n2, l2, doubleBuffer);
    }

    public static void nglCreateFramebuffers(int n2, long l2) {
        GL45C.nglCreateFramebuffers(n2, l2);
    }

    public static void glCreateFramebuffers(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.glCreateFramebuffers(intBuffer);
    }

    @NativeType(value="void")
    public static int glCreateFramebuffers() {
        return GL45C.glCreateFramebuffers();
    }

    public static void glNamedFramebufferRenderbuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint") int n5) {
        GL45C.glNamedFramebufferRenderbuffer(n2, n3, n4, n5);
    }

    public static void glNamedFramebufferParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4) {
        GL45C.glNamedFramebufferParameteri(n2, n3, n4);
    }

    public static void glNamedFramebufferTexture(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint") int n5) {
        GL45C.glNamedFramebufferTexture(n2, n3, n4, n5);
    }

    public static void glNamedFramebufferTextureLayer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6) {
        GL45C.glNamedFramebufferTextureLayer(n2, n3, n4, n5, n6);
    }

    public static void glNamedFramebufferDrawBuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedFramebufferDrawBuffer(n2, n3);
    }

    public static void nglNamedFramebufferDrawBuffers(int n2, int n3, long l2) {
        GL45C.nglNamedFramebufferDrawBuffers(n2, n3, l2);
    }

    public static void glNamedFramebufferDrawBuffers(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") IntBuffer intBuffer) {
        GL45C.glNamedFramebufferDrawBuffers(n2, intBuffer);
    }

    public static void glNamedFramebufferDrawBuffers(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int n3) {
        GL45C.glNamedFramebufferDrawBuffers(n2, n3);
    }

    public static void glNamedFramebufferReadBuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedFramebufferReadBuffer(n2, n3);
    }

    public static void nglInvalidateNamedFramebufferData(int n2, int n3, long l2) {
        GL45C.nglInvalidateNamedFramebufferData(n2, n3, l2);
    }

    public static void glInvalidateNamedFramebufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") IntBuffer intBuffer) {
        GL45C.glInvalidateNamedFramebufferData(n2, intBuffer);
    }

    public static void glInvalidateNamedFramebufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int n3) {
        GL45C.glInvalidateNamedFramebufferData(n2, n3);
    }

    public static void nglInvalidateNamedFramebufferSubData(int n2, int n3, long l2, int n4, int n5, int n6, int n7) {
        GL45C.nglInvalidateNamedFramebufferSubData(n2, n3, l2, n4, n5, n6, n7);
    }

    public static void glInvalidateNamedFramebufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") IntBuffer intBuffer, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6) {
        GL45C.glInvalidateNamedFramebufferSubData(n2, intBuffer, n3, n4, n5, n6);
    }

    public static void glInvalidateNamedFramebufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7) {
        GL45C.glInvalidateNamedFramebufferSubData(n2, n3, n4, n5, n6, n7);
    }

    public static void nglClearNamedFramebufferiv(int n2, int n3, int n4, long l2) {
        GL45C.nglClearNamedFramebufferiv(n2, n3, n4, l2);
    }

    public static void glClearNamedFramebufferiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL45C.glClearNamedFramebufferiv(n2, n3, n4, intBuffer);
    }

    public static void nglClearNamedFramebufferuiv(int n2, int n3, int n4, long l2) {
        GL45C.nglClearNamedFramebufferuiv(n2, n3, n4, l2);
    }

    public static void glClearNamedFramebufferuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL45C.glClearNamedFramebufferuiv(n2, n3, n4, intBuffer);
    }

    public static void nglClearNamedFramebufferfv(int n2, int n3, int n4, long l2) {
        GL45C.nglClearNamedFramebufferfv(n2, n3, n4, l2);
    }

    public static void glClearNamedFramebufferfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL45C.glClearNamedFramebufferfv(n2, n3, n4, floatBuffer);
    }

    public static void glClearNamedFramebufferfi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLfloat") float f2, @NativeType(value="GLint") int n5) {
        GL45C.glClearNamedFramebufferfi(n2, n3, n4, f2, n5);
    }

    public static void glBlitNamedFramebuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLint") int n9, @NativeType(value="GLint") int n10, @NativeType(value="GLint") int n11, @NativeType(value="GLbitfield") int n12, @NativeType(value="GLenum") int n13) {
        GL45C.glBlitNamedFramebuffer(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13);
    }

    @NativeType(value="GLenum")
    public static int glCheckNamedFramebufferStatus(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glCheckNamedFramebufferStatus(n2, n3);
    }

    public static void nglGetNamedFramebufferParameteriv(int n2, int n3, long l2) {
        GL45C.nglGetNamedFramebufferParameteriv(n2, n3, l2);
    }

    public static void glGetNamedFramebufferParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.glGetNamedFramebufferParameteriv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetNamedFramebufferParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glGetNamedFramebufferParameteri(n2, n3);
    }

    public static void nglGetNamedFramebufferAttachmentParameteriv(int n2, int n3, int n4, long l2) {
        GL45C.nglGetNamedFramebufferAttachmentParameteriv(n2, n3, n4, l2);
    }

    public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.glGetNamedFramebufferAttachmentParameteriv(n2, n3, n4, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetNamedFramebufferAttachmentParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        return GL45C.glGetNamedFramebufferAttachmentParameteri(n2, n3, n4);
    }

    public static void nglCreateRenderbuffers(int n2, long l2) {
        GL45C.nglCreateRenderbuffers(n2, l2);
    }

    public static void glCreateRenderbuffers(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.glCreateRenderbuffers(intBuffer);
    }

    @NativeType(value="void")
    public static int glCreateRenderbuffers() {
        return GL45C.glCreateRenderbuffers();
    }

    public static void glNamedRenderbufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        GL45C.glNamedRenderbufferStorage(n2, n3, n4, n5);
    }

    public static void glNamedRenderbufferStorageMultisample(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6) {
        GL45C.glNamedRenderbufferStorageMultisample(n2, n3, n4, n5, n6);
    }

    public static void nglGetNamedRenderbufferParameteriv(int n2, int n3, long l2) {
        GL45C.nglGetNamedRenderbufferParameteriv(n2, n3, l2);
    }

    public static void glGetNamedRenderbufferParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.glGetNamedRenderbufferParameteriv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetNamedRenderbufferParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glGetNamedRenderbufferParameteri(n2, n3);
    }

    public static void nglCreateTextures(int n2, int n3, long l2) {
        GL45C.nglCreateTextures(n2, n3, l2);
    }

    public static void glCreateTextures(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.glCreateTextures(n2, intBuffer);
    }

    @NativeType(value="void")
    public static int glCreateTextures(@NativeType(value="GLenum") int n2) {
        return GL45C.glCreateTextures(n2);
    }

    public static void glTextureBuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        GL45C.glTextureBuffer(n2, n3, n4);
    }

    public static void glTextureBufferRange(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3) {
        GL45C.glTextureBufferRange(n2, n3, n4, l2, l3);
    }

    public static void glTextureStorage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5) {
        GL45C.glTextureStorage1D(n2, n3, n4, n5);
    }

    public static void glTextureStorage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6) {
        GL45C.glTextureStorage2D(n2, n3, n4, n5, n6);
    }

    public static void glTextureStorage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7) {
        GL45C.glTextureStorage3D(n2, n3, n4, n5, n6, n7);
    }

    public static void glTextureStorage2DMultisample(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLboolean") boolean bl2) {
        GL45C.glTextureStorage2DMultisample(n2, n3, n4, n5, n6, bl2);
    }

    public static void glTextureStorage3DMultisample(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLboolean") boolean bl2) {
        GL45C.glTextureStorage3DMultisample(n2, n3, n4, n5, n6, n7, bl2);
    }

    public static void nglTextureSubImage1D(int n2, int n3, int n4, int n5, int n6, int n7, long l2) {
        GL45C.nglTextureSubImage1D(n2, n3, n4, n5, n6, n7, l2);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.glTextureSubImage1D(n2, n3, n4, n5, n6, n7, byteBuffer);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") long l2) {
        GL45C.glTextureSubImage1D(n2, n3, n4, n5, n6, n7, l2);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL45C.glTextureSubImage1D(n2, n3, n4, n5, n6, n7, shortBuffer);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL45C.glTextureSubImage1D(n2, n3, n4, n5, n6, n7, intBuffer);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL45C.glTextureSubImage1D(n2, n3, n4, n5, n6, n7, floatBuffer);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL45C.glTextureSubImage1D(n2, n3, n4, n5, n6, n7, doubleBuffer);
    }

    public static void nglTextureSubImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, long l2) {
        GL45C.nglTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, l2);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.glTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, byteBuffer);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") long l2) {
        GL45C.glTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, l2);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL45C.glTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, shortBuffer);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL45C.glTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, intBuffer);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL45C.glTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, floatBuffer);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL45C.glTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, doubleBuffer);
    }

    public static void nglTextureSubImage3D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, long l2) {
        GL45C.nglTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, l2);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.glTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, byteBuffer);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") long l2) {
        GL45C.glTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, l2);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL45C.glTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, shortBuffer);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL45C.glTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, intBuffer);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL45C.glTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, floatBuffer);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL45C.glTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, doubleBuffer);
    }

    public static void nglCompressedTextureSubImage1D(int n2, int n3, int n4, int n5, int n6, int n7, long l2) {
        GL45C.nglCompressedTextureSubImage1D(n2, n3, n4, n5, n6, n7, l2);
    }

    public static void glCompressedTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="void const *") long l2) {
        GL45C.glCompressedTextureSubImage1D(n2, n3, n4, n5, n6, n7, l2);
    }

    public static void glCompressedTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.glCompressedTextureSubImage1D(n2, n3, n4, n5, n6, byteBuffer);
    }

    public static void nglCompressedTextureSubImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, long l2) {
        GL45C.nglCompressedTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, l2);
    }

    public static void glCompressedTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void const *") long l2) {
        GL45C.glCompressedTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, l2);
    }

    public static void glCompressedTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.glCompressedTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, byteBuffer);
    }

    public static void nglCompressedTextureSubImage3D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, long l2) {
        GL45C.nglCompressedTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, l2);
    }

    public static void glCompressedTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLsizei") int n11, @NativeType(value="void const *") long l2) {
        GL45C.glCompressedTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, l2);
    }

    public static void glCompressedTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.glCompressedTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, byteBuffer);
    }

    public static void glCopyTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7) {
        GL45C.glCopyTextureSubImage1D(n2, n3, n4, n5, n6, n7);
    }

    public static void glCopyTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9) {
        GL45C.glCopyTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9);
    }

    public static void glCopyTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10) {
        GL45C.glCopyTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10);
    }

    public static void glTextureParameterf(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat") float f2) {
        GL45C.glTextureParameterf(n2, n3, f2);
    }

    public static void nglTextureParameterfv(int n2, int n3, long l2) {
        GL45C.nglTextureParameterfv(n2, n3, l2);
    }

    public static void glTextureParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL45C.glTextureParameterfv(n2, n3, floatBuffer);
    }

    public static void glTextureParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4) {
        GL45C.glTextureParameteri(n2, n3, n4);
    }

    public static void nglTextureParameterIiv(int n2, int n3, long l2) {
        GL45C.nglTextureParameterIiv(n2, n3, l2);
    }

    public static void glTextureParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL45C.glTextureParameterIiv(n2, n3, intBuffer);
    }

    public static void glTextureParameterIi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int n4) {
        GL45C.glTextureParameterIi(n2, n3, n4);
    }

    public static void nglTextureParameterIuiv(int n2, int n3, long l2) {
        GL45C.nglTextureParameterIuiv(n2, n3, l2);
    }

    public static void glTextureParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL45C.glTextureParameterIuiv(n2, n3, intBuffer);
    }

    public static void glTextureParameterIui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int n4) {
        GL45C.glTextureParameterIui(n2, n3, n4);
    }

    public static void nglTextureParameteriv(int n2, int n3, long l2) {
        GL45C.nglTextureParameteriv(n2, n3, l2);
    }

    public static void glTextureParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL45C.glTextureParameteriv(n2, n3, intBuffer);
    }

    public static void glGenerateTextureMipmap(@NativeType(value="GLuint") int n2) {
        GL45C.glGenerateTextureMipmap(n2);
    }

    public static void glBindTextureUnit(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        GL45C.glBindTextureUnit(n2, n3);
    }

    public static void nglGetTextureImage(int n2, int n3, int n4, int n5, int n6, long l2) {
        GL45C.nglGetTextureImage(n2, n3, n4, n5, n6, l2);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="void *") long l2) {
        GL45C.glGetTextureImage(n2, n3, n4, n5, n6, l2);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.glGetTextureImage(n2, n3, n4, n5, byteBuffer);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45C.glGetTextureImage(n2, n3, n4, n5, shortBuffer);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45C.glGetTextureImage(n2, n3, n4, n5, intBuffer);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45C.glGetTextureImage(n2, n3, n4, n5, floatBuffer);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        GL45C.glGetTextureImage(n2, n3, n4, n5, doubleBuffer);
    }

    public static void nglGetCompressedTextureImage(int n2, int n3, int n4, long l2) {
        GL45C.nglGetCompressedTextureImage(n2, n3, n4, l2);
    }

    public static void glGetCompressedTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="void *") long l2) {
        GL45C.glGetCompressedTextureImage(n2, n3, n4, l2);
    }

    public static void glGetCompressedTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.glGetCompressedTextureImage(n2, n3, byteBuffer);
    }

    public static void nglGetTextureLevelParameterfv(int n2, int n3, int n4, long l2) {
        GL45C.nglGetTextureLevelParameterfv(n2, n3, n4, l2);
    }

    public static void glGetTextureLevelParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL45C.glGetTextureLevelParameterfv(n2, n3, n4, floatBuffer);
    }

    @NativeType(value="void")
    public static float glGetTextureLevelParameterf(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4) {
        return GL45C.glGetTextureLevelParameterf(n2, n3, n4);
    }

    public static void nglGetTextureLevelParameteriv(int n2, int n3, int n4, long l2) {
        GL45C.nglGetTextureLevelParameteriv(n2, n3, n4, l2);
    }

    public static void glGetTextureLevelParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.glGetTextureLevelParameteriv(n2, n3, n4, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetTextureLevelParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4) {
        return GL45C.glGetTextureLevelParameteri(n2, n3, n4);
    }

    public static void nglGetTextureParameterfv(int n2, int n3, long l2) {
        GL45C.nglGetTextureParameterfv(n2, n3, l2);
    }

    public static void glGetTextureParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL45C.glGetTextureParameterfv(n2, n3, floatBuffer);
    }

    @NativeType(value="void")
    public static float glGetTextureParameterf(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glGetTextureParameterf(n2, n3);
    }

    public static void nglGetTextureParameterIiv(int n2, int n3, long l2) {
        GL45C.nglGetTextureParameterIiv(n2, n3, l2);
    }

    public static void glGetTextureParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.glGetTextureParameterIiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetTextureParameterIi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glGetTextureParameterIi(n2, n3);
    }

    public static void nglGetTextureParameterIuiv(int n2, int n3, long l2) {
        GL45C.nglGetTextureParameterIuiv(n2, n3, l2);
    }

    public static void glGetTextureParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.glGetTextureParameterIuiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetTextureParameterIui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glGetTextureParameterIui(n2, n3);
    }

    public static void nglGetTextureParameteriv(int n2, int n3, long l2) {
        GL45C.nglGetTextureParameteriv(n2, n3, l2);
    }

    public static void glGetTextureParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.glGetTextureParameteriv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetTextureParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glGetTextureParameteri(n2, n3);
    }

    public static void nglCreateVertexArrays(int n2, long l2) {
        GL45C.nglCreateVertexArrays(n2, l2);
    }

    public static void glCreateVertexArrays(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.glCreateVertexArrays(intBuffer);
    }

    @NativeType(value="void")
    public static int glCreateVertexArrays() {
        return GL45C.glCreateVertexArrays();
    }

    public static void glDisableVertexArrayAttrib(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        GL45C.glDisableVertexArrayAttrib(n2, n3);
    }

    public static void glEnableVertexArrayAttrib(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        GL45C.glEnableVertexArrayAttrib(n2, n3);
    }

    public static void glVertexArrayElementBuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        GL45C.glVertexArrayElementBuffer(n2, n3);
    }

    public static void glVertexArrayVertexBuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n5) {
        GL45C.glVertexArrayVertexBuffer(n2, n3, n4, l2, n5);
    }

    public static void nglVertexArrayVertexBuffers(int n2, int n3, int n4, long l2, long l3, long l4) {
        GL45C.nglVertexArrayVertexBuffers(n2, n3, n4, l2, l3, l4);
    }

    public static void glVertexArrayVertexBuffers(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizei const *") IntBuffer intBuffer2) {
        GL45C.glVertexArrayVertexBuffers(n2, n3, intBuffer, pointerBuffer, intBuffer2);
    }

    public static void glVertexArrayAttribFormat(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint") int n6) {
        GL45C.glVertexArrayAttribFormat(n2, n3, n4, n5, bl2, n6);
    }

    public static void glVertexArrayAttribIFormat(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLuint") int n6) {
        GL45C.glVertexArrayAttribIFormat(n2, n3, n4, n5, n6);
    }

    public static void glVertexArrayAttribLFormat(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLuint") int n6) {
        GL45C.glVertexArrayAttribLFormat(n2, n3, n4, n5, n6);
    }

    public static void glVertexArrayAttribBinding(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4) {
        GL45C.glVertexArrayAttribBinding(n2, n3, n4);
    }

    public static void glVertexArrayBindingDivisor(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4) {
        GL45C.glVertexArrayBindingDivisor(n2, n3, n4);
    }

    public static void nglGetVertexArrayiv(int n2, int n3, long l2) {
        GL45C.nglGetVertexArrayiv(n2, n3, l2);
    }

    public static void glGetVertexArrayiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.glGetVertexArrayiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetVertexArrayi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL45C.glGetVertexArrayi(n2, n3);
    }

    public static void nglGetVertexArrayIndexediv(int n2, int n3, int n4, long l2) {
        GL45C.nglGetVertexArrayIndexediv(n2, n3, n4, l2);
    }

    public static void glGetVertexArrayIndexediv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.glGetVertexArrayIndexediv(n2, n3, n4, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetVertexArrayIndexedi(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        return GL45C.glGetVertexArrayIndexedi(n2, n3, n4);
    }

    public static void nglGetVertexArrayIndexed64iv(int n2, int n3, int n4, long l2) {
        GL45C.nglGetVertexArrayIndexed64iv(n2, n3, n4, l2);
    }

    public static void glGetVertexArrayIndexed64iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        GL45C.glGetVertexArrayIndexed64iv(n2, n3, n4, longBuffer);
    }

    @NativeType(value="void")
    public static long glGetVertexArrayIndexed64i(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        return GL45C.glGetVertexArrayIndexed64i(n2, n3, n4);
    }

    public static void nglCreateSamplers(int n2, long l2) {
        GL45C.nglCreateSamplers(n2, l2);
    }

    public static void glCreateSamplers(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.glCreateSamplers(intBuffer);
    }

    @NativeType(value="void")
    public static int glCreateSamplers() {
        return GL45C.glCreateSamplers();
    }

    public static void nglCreateProgramPipelines(int n2, long l2) {
        GL45C.nglCreateProgramPipelines(n2, l2);
    }

    public static void glCreateProgramPipelines(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.glCreateProgramPipelines(intBuffer);
    }

    @NativeType(value="void")
    public static int glCreateProgramPipelines() {
        return GL45C.glCreateProgramPipelines();
    }

    public static void nglCreateQueries(int n2, int n3, long l2) {
        GL45C.nglCreateQueries(n2, n3, l2);
    }

    public static void glCreateQueries(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.glCreateQueries(n2, intBuffer);
    }

    @NativeType(value="void")
    public static int glCreateQueries(@NativeType(value="GLenum") int n2) {
        return GL45C.glCreateQueries(n2);
    }

    public static void glGetQueryBufferObjectiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLintptr") long l2) {
        GL45C.glGetQueryBufferObjectiv(n2, n3, n4, l2);
    }

    public static void glGetQueryBufferObjectuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLintptr") long l2) {
        GL45C.glGetQueryBufferObjectuiv(n2, n3, n4, l2);
    }

    public static void glGetQueryBufferObjecti64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLintptr") long l2) {
        GL45C.glGetQueryBufferObjecti64v(n2, n3, n4, l2);
    }

    public static void glGetQueryBufferObjectui64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLintptr") long l2) {
        GL45C.glGetQueryBufferObjectui64v(n2, n3, n4, l2);
    }

    public static void glMemoryBarrierByRegion(@NativeType(value="GLbitfield") int n2) {
        GL45C.glMemoryBarrierByRegion(n2);
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

    public static void glTextureBarrier() {
        GL45C.glTextureBarrier();
    }

    @NativeType(value="GLenum")
    public static int glGetGraphicsResetStatus() {
        return GL45C.glGetGraphicsResetStatus();
    }

    public static native void nglGetnMapdv(int var0, int var1, int var2, long var3);

    public static void glGetnMapdv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        GL45.nglGetnMapdv(n2, n3, doubleBuffer.remaining(), MemoryUtil.memAddress(doubleBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetnMapd(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
            GL45.nglGetnMapdv(n2, n3, 1, MemoryUtil.memAddress(doubleBuffer));
            double d2 = doubleBuffer.get(0);
            return d2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnMapfv(int var0, int var1, int var2, long var3);

    public static void glGetnMapfv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL45.nglGetnMapfv(n2, n3, floatBuffer.remaining(), MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetnMapf(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            GL45.nglGetnMapfv(n2, n3, 1, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnMapiv(int var0, int var1, int var2, long var3);

    public static void glGetnMapiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45.nglGetnMapiv(n2, n3, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetnMapi(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45.nglGetnMapiv(n2, n3, 1, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnPixelMapfv(int var0, int var1, long var2);

    public static void glGetnPixelMapfv(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL45.nglGetnPixelMapfv(n2, floatBuffer.remaining(), MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetnPixelMapuiv(int var0, int var1, long var2);

    public static void glGetnPixelMapuiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45.nglGetnPixelMapuiv(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglGetnPixelMapusv(int var0, int var1, long var2);

    public static void glGetnPixelMapusv(@NativeType(value="GLenum") int n2, @NativeType(value="GLushort *") ShortBuffer shortBuffer) {
        GL45.nglGetnPixelMapusv(n2, shortBuffer.remaining(), MemoryUtil.memAddress(shortBuffer));
    }

    public static native void nglGetnPolygonStipple(int var0, long var1);

    public static void glGetnPolygonStipple(@NativeType(value="GLsizei") int n2, @NativeType(value="GLubyte *") long l2) {
        GL45.nglGetnPolygonStipple(n2, l2);
    }

    public static void glGetnPolygonStipple(@NativeType(value="GLubyte *") ByteBuffer byteBuffer) {
        GL45.nglGetnPolygonStipple(byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void nglGetnTexImage(int n2, int n3, int n4, int n5, int n6, long l2) {
        GL45C.nglGetnTexImage(n2, n3, n4, n5, n6, l2);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="void *") long l2) {
        GL45C.glGetnTexImage(n2, n3, n4, n5, n6, l2);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.glGetnTexImage(n2, n3, n4, n5, byteBuffer);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45C.glGetnTexImage(n2, n3, n4, n5, shortBuffer);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45C.glGetnTexImage(n2, n3, n4, n5, intBuffer);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45C.glGetnTexImage(n2, n3, n4, n5, floatBuffer);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        GL45C.glGetnTexImage(n2, n3, n4, n5, doubleBuffer);
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

    public static native void nglGetnColorTable(int var0, int var1, int var2, int var3, long var4);

    public static void glGetnColorTable(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void *") long l2) {
        GL45.nglGetnColorTable(n2, n3, n4, n5, l2);
    }

    public static void glGetnColorTable(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45.nglGetnColorTable(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetnColorTable(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45.nglGetnColorTable(n2, n3, n4, shortBuffer.remaining() << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glGetnColorTable(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45.nglGetnColorTable(n2, n3, n4, intBuffer.remaining() << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetnColorTable(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45.nglGetnColorTable(n2, n3, n4, floatBuffer.remaining() << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetnConvolutionFilter(int var0, int var1, int var2, int var3, long var4);

    public static void glGetnConvolutionFilter(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void *") long l2) {
        GL45.nglGetnConvolutionFilter(n2, n3, n4, n5, l2);
    }

    public static void glGetnConvolutionFilter(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45.nglGetnConvolutionFilter(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetnSeparableFilter(int var0, int var1, int var2, int var3, long var4, int var6, long var7, long var9);

    public static void glGetnSeparableFilter(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void *") long l2, @NativeType(value="GLsizei") int n6, @NativeType(value="void *") long l3, @Nullable @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45.nglGetnSeparableFilter(n2, n3, n4, n5, l2, n6, l3, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glGetnSeparableFilter(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer, @NativeType(value="void *") ByteBuffer byteBuffer2, @Nullable @NativeType(value="void *") ByteBuffer byteBuffer3) {
        GL45.nglGetnSeparableFilter(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), byteBuffer2.remaining(), MemoryUtil.memAddress(byteBuffer2), MemoryUtil.memAddressSafe(byteBuffer3));
    }

    public static native void nglGetnHistogram(int var0, boolean var1, int var2, int var3, int var4, long var5);

    public static void glGetnHistogram(@NativeType(value="GLenum") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void *") long l2) {
        GL45.nglGetnHistogram(n2, bl2, n3, n4, n5, l2);
    }

    public static void glGetnHistogram(@NativeType(value="GLenum") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45.nglGetnHistogram(n2, bl2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetnMinmax(int var0, boolean var1, int var2, int var3, int var4, long var5);

    public static void glGetnMinmax(@NativeType(value="GLenum") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void *") long l2) {
        GL45.nglGetnMinmax(n2, bl2, n3, n4, n5, l2);
    }

    public static void glGetnMinmax(@NativeType(value="GLenum") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45.nglGetnMinmax(n2, bl2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void nglGetnCompressedTexImage(int n2, int n3, int n4, long l2) {
        GL45C.nglGetnCompressedTexImage(n2, n3, n4, l2);
    }

    public static void glGetnCompressedTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="void *") long l2) {
        GL45C.glGetnCompressedTexImage(n2, n3, n4, l2);
    }

    public static void glGetnCompressedTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.glGetnCompressedTexImage(n2, n3, byteBuffer);
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

    public static void nglGetnUniformdv(int n2, int n3, int n4, long l2) {
        GL45C.nglGetnUniformdv(n2, n3, n4, l2);
    }

    public static void glGetnUniformdv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        GL45C.glGetnUniformdv(n2, n3, doubleBuffer);
    }

    @NativeType(value="void")
    public static double glGetnUniformd(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        return GL45C.glGetnUniformd(n2, n3);
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

    public static void glCreateTransformFeedbacks(@NativeType(value="GLuint *") int[] nArray) {
        GL45C.glCreateTransformFeedbacks(nArray);
    }

    public static void glGetTransformFeedbackiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL45C.glGetTransformFeedbackiv(n2, n3, nArray);
    }

    public static void glGetTransformFeedbacki_v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint *") int[] nArray) {
        GL45C.glGetTransformFeedbacki_v(n2, n3, n4, nArray);
    }

    public static void glGetTransformFeedbacki64_v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint64 *") long[] lArray) {
        GL45C.glGetTransformFeedbacki64_v(n2, n3, n4, lArray);
    }

    public static void glCreateBuffers(@NativeType(value="GLuint *") int[] nArray) {
        GL45C.glCreateBuffers(nArray);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") short[] sArray, @NativeType(value="GLbitfield") int n3) {
        GL45C.glNamedBufferStorage(n2, sArray, n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLbitfield") int n3) {
        GL45C.glNamedBufferStorage(n2, nArray, n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") float[] fArray, @NativeType(value="GLbitfield") int n3) {
        GL45C.glNamedBufferStorage(n2, fArray, n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") double[] dArray, @NativeType(value="GLbitfield") int n3) {
        GL45C.glNamedBufferStorage(n2, dArray, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") short[] sArray, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedBufferData(n2, sArray, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedBufferData(n2, nArray, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") long[] lArray, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedBufferData(n2, lArray, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") float[] fArray, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedBufferData(n2, fArray, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") double[] dArray, @NativeType(value="GLenum") int n3) {
        GL45C.glNamedBufferData(n2, dArray, n3);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") short[] sArray) {
        GL45C.glNamedBufferSubData(n2, l2, sArray);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") int[] nArray) {
        GL45C.glNamedBufferSubData(n2, l2, nArray);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") long[] lArray) {
        GL45C.glNamedBufferSubData(n2, l2, lArray);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") float[] fArray) {
        GL45C.glNamedBufferSubData(n2, l2, fArray);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") double[] dArray) {
        GL45C.glNamedBufferSubData(n2, l2, dArray);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") short[] sArray) {
        GL45C.glClearNamedBufferData(n2, n3, n4, n5, sArray);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") int[] nArray) {
        GL45C.glClearNamedBufferData(n2, n3, n4, n5, nArray);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") float[] fArray) {
        GL45C.glClearNamedBufferData(n2, n3, n4, n5, fArray);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") short[] sArray) {
        GL45C.glClearNamedBufferSubData(n2, n3, l2, l3, n4, n5, sArray);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") int[] nArray) {
        GL45C.glClearNamedBufferSubData(n2, n3, l2, l3, n4, n5, nArray);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") float[] fArray) {
        GL45C.glClearNamedBufferSubData(n2, n3, l2, l3, n4, n5, fArray);
    }

    public static void glGetNamedBufferParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL45C.glGetNamedBufferParameteriv(n2, n3, nArray);
    }

    public static void glGetNamedBufferParameteri64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") long[] lArray) {
        GL45C.glGetNamedBufferParameteri64v(n2, n3, lArray);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") short[] sArray) {
        GL45C.glGetNamedBufferSubData(n2, l2, sArray);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") int[] nArray) {
        GL45C.glGetNamedBufferSubData(n2, l2, nArray);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") long[] lArray) {
        GL45C.glGetNamedBufferSubData(n2, l2, lArray);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") float[] fArray) {
        GL45C.glGetNamedBufferSubData(n2, l2, fArray);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") double[] dArray) {
        GL45C.glGetNamedBufferSubData(n2, l2, dArray);
    }

    public static void glCreateFramebuffers(@NativeType(value="GLuint *") int[] nArray) {
        GL45C.glCreateFramebuffers(nArray);
    }

    public static void glNamedFramebufferDrawBuffers(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int[] nArray) {
        GL45C.glNamedFramebufferDrawBuffers(n2, nArray);
    }

    public static void glInvalidateNamedFramebufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int[] nArray) {
        GL45C.glInvalidateNamedFramebufferData(n2, nArray);
    }

    public static void glInvalidateNamedFramebufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int[] nArray, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6) {
        GL45C.glInvalidateNamedFramebufferSubData(n2, nArray, n3, n4, n5, n6);
    }

    public static void glClearNamedFramebufferiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint const *") int[] nArray) {
        GL45C.glClearNamedFramebufferiv(n2, n3, n4, nArray);
    }

    public static void glClearNamedFramebufferuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint const *") int[] nArray) {
        GL45C.glClearNamedFramebufferuiv(n2, n3, n4, nArray);
    }

    public static void glClearNamedFramebufferfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLfloat const *") float[] fArray) {
        GL45C.glClearNamedFramebufferfv(n2, n3, n4, fArray);
    }

    public static void glGetNamedFramebufferParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL45C.glGetNamedFramebufferParameteriv(n2, n3, nArray);
    }

    public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        GL45C.glGetNamedFramebufferAttachmentParameteriv(n2, n3, n4, nArray);
    }

    public static void glCreateRenderbuffers(@NativeType(value="GLuint *") int[] nArray) {
        GL45C.glCreateRenderbuffers(nArray);
    }

    public static void glGetNamedRenderbufferParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL45C.glGetNamedRenderbufferParameteriv(n2, n3, nArray);
    }

    public static void glCreateTextures(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint *") int[] nArray) {
        GL45C.glCreateTextures(n2, nArray);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") short[] sArray) {
        GL45C.glTextureSubImage1D(n2, n3, n4, n5, n6, n7, sArray);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") int[] nArray) {
        GL45C.glTextureSubImage1D(n2, n3, n4, n5, n6, n7, nArray);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") float[] fArray) {
        GL45C.glTextureSubImage1D(n2, n3, n4, n5, n6, n7, fArray);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") double[] dArray) {
        GL45C.glTextureSubImage1D(n2, n3, n4, n5, n6, n7, dArray);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") short[] sArray) {
        GL45C.glTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, sArray);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") int[] nArray) {
        GL45C.glTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, nArray);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") float[] fArray) {
        GL45C.glTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, fArray);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") double[] dArray) {
        GL45C.glTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, dArray);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") short[] sArray) {
        GL45C.glTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, sArray);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") int[] nArray) {
        GL45C.glTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, nArray);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") float[] fArray) {
        GL45C.glTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, fArray);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") double[] dArray) {
        GL45C.glTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, dArray);
    }

    public static void glTextureParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        GL45C.glTextureParameterfv(n2, n3, fArray);
    }

    public static void glTextureParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int[] nArray) {
        GL45C.glTextureParameterIiv(n2, n3, nArray);
    }

    public static void glTextureParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        GL45C.glTextureParameterIuiv(n2, n3, nArray);
    }

    public static void glTextureParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int[] nArray) {
        GL45C.glTextureParameteriv(n2, n3, nArray);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") short[] sArray) {
        GL45C.glGetTextureImage(n2, n3, n4, n5, sArray);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") int[] nArray) {
        GL45C.glGetTextureImage(n2, n3, n4, n5, nArray);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") float[] fArray) {
        GL45C.glGetTextureImage(n2, n3, n4, n5, fArray);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") double[] dArray) {
        GL45C.glGetTextureImage(n2, n3, n4, n5, dArray);
    }

    public static void glGetTextureLevelParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat *") float[] fArray) {
        GL45C.glGetTextureLevelParameterfv(n2, n3, n4, fArray);
    }

    public static void glGetTextureLevelParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        GL45C.glGetTextureLevelParameteriv(n2, n3, n4, nArray);
    }

    public static void glGetTextureParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        GL45C.glGetTextureParameterfv(n2, n3, fArray);
    }

    public static void glGetTextureParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL45C.glGetTextureParameterIiv(n2, n3, nArray);
    }

    public static void glGetTextureParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") int[] nArray) {
        GL45C.glGetTextureParameterIuiv(n2, n3, nArray);
    }

    public static void glGetTextureParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL45C.glGetTextureParameteriv(n2, n3, nArray);
    }

    public static void glCreateVertexArrays(@NativeType(value="GLuint *") int[] nArray) {
        GL45C.glCreateVertexArrays(nArray);
    }

    public static void glVertexArrayVertexBuffers(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") int[] nArray, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizei const *") int[] nArray2) {
        GL45C.glVertexArrayVertexBuffers(n2, n3, nArray, pointerBuffer, nArray2);
    }

    public static void glGetVertexArrayiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL45C.glGetVertexArrayiv(n2, n3, nArray);
    }

    public static void glGetVertexArrayIndexediv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        GL45C.glGetVertexArrayIndexediv(n2, n3, n4, nArray);
    }

    public static void glGetVertexArrayIndexed64iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint64 *") long[] lArray) {
        GL45C.glGetVertexArrayIndexed64iv(n2, n3, n4, lArray);
    }

    public static void glCreateSamplers(@NativeType(value="GLuint *") int[] nArray) {
        GL45C.glCreateSamplers(nArray);
    }

    public static void glCreateProgramPipelines(@NativeType(value="GLuint *") int[] nArray) {
        GL45C.glCreateProgramPipelines(nArray);
    }

    public static void glCreateQueries(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint *") int[] nArray) {
        GL45C.glCreateQueries(n2, nArray);
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

    public static void glGetnMapdv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        long l2 = GL.getICD().glGetnMapdv;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, dArray.length, dArray, l2);
    }

    public static void glGetnMapfv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetnMapfv;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length, fArray, l2);
    }

    public static void glGetnMapiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetnMapiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length, nArray, l2);
    }

    public static void glGetnPixelMapfv(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetnPixelMapfv;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, fArray.length, fArray, l2);
    }

    public static void glGetnPixelMapuiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGetnPixelMapuiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length, nArray, l2);
    }

    public static void glGetnPixelMapusv(@NativeType(value="GLenum") int n2, @NativeType(value="GLushort *") short[] sArray) {
        long l2 = GL.getICD().glGetnPixelMapusv;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, sArray.length, sArray, l2);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") short[] sArray) {
        GL45C.glGetnTexImage(n2, n3, n4, n5, sArray);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") int[] nArray) {
        GL45C.glGetnTexImage(n2, n3, n4, n5, nArray);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") float[] fArray) {
        GL45C.glGetnTexImage(n2, n3, n4, n5, fArray);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") double[] dArray) {
        GL45C.glGetnTexImage(n2, n3, n4, n5, dArray);
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

    public static void glGetnColorTable(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") short[] sArray) {
        long l2 = GL.getICD().glGetnColorTable;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, sArray.length << 1, sArray, l2);
    }

    public static void glGetnColorTable(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getICD().glGetnColorTable;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, nArray.length << 2, nArray, l2);
    }

    public static void glGetnColorTable(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getICD().glGetnColorTable;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, fArray.length << 2, fArray, l2);
    }

    public static void glGetnUniformfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        GL45C.glGetnUniformfv(n2, n3, fArray);
    }

    public static void glGetnUniformdv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        GL45C.glGetnUniformdv(n2, n3, dArray);
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

