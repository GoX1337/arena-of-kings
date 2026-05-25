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
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL44C;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL45C
extends GL44C {
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

    protected GL45C() {
        throw new UnsupportedOperationException();
    }

    public static native void glClipControl(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglCreateTransformFeedbacks(int var0, long var1);

    public static void glCreateTransformFeedbacks(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.nglCreateTransformFeedbacks(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateTransformFeedbacks() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglCreateTransformFeedbacks(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void glTransformFeedbackBufferBase(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glTransformFeedbackBufferRange(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3, @NativeType(value="GLsizeiptr") long var5);

    public static native void nglGetTransformFeedbackiv(int var0, int var1, long var2);

    public static void glGetTransformFeedbackiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglGetTransformFeedbackiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTransformFeedbacki(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetTransformFeedbackiv(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetTransformFeedbacki_v(int var0, int var1, int var2, long var3);

    public static void glGetTransformFeedbacki_v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglGetTransformFeedbacki_v(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTransformFeedbacki(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetTransformFeedbacki_v(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetTransformFeedbacki64_v(int var0, int var1, int var2, long var3);

    public static void glGetTransformFeedbacki64_v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        GL45C.nglGetTransformFeedbacki64_v(n2, n3, n4, MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetTransformFeedbacki64(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            GL45C.nglGetTransformFeedbacki64_v(n2, n3, n4, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglCreateBuffers(int var0, long var1);

    public static void glCreateBuffers(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.nglCreateBuffers(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateBuffers() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglCreateBuffers(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nglNamedBufferStorage(int var0, long var1, long var3, int var5);

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLbitfield") int n3) {
        GL45C.nglNamedBufferStorage(n2, l2, 0L, n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLbitfield") int n3) {
        GL45C.nglNamedBufferStorage(n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLbitfield") int n3) {
        GL45C.nglNamedBufferStorage(n2, Integer.toUnsignedLong(shortBuffer.remaining()) << 1, MemoryUtil.memAddress(shortBuffer), n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLbitfield") int n3) {
        GL45C.nglNamedBufferStorage(n2, Integer.toUnsignedLong(intBuffer.remaining()) << 2, MemoryUtil.memAddress(intBuffer), n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") FloatBuffer floatBuffer, @NativeType(value="GLbitfield") int n3) {
        GL45C.nglNamedBufferStorage(n2, Integer.toUnsignedLong(floatBuffer.remaining()) << 2, MemoryUtil.memAddress(floatBuffer), n3);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") DoubleBuffer doubleBuffer, @NativeType(value="GLbitfield") int n3) {
        GL45C.nglNamedBufferStorage(n2, Integer.toUnsignedLong(doubleBuffer.remaining()) << 3, MemoryUtil.memAddress(doubleBuffer), n3);
    }

    public static native void nglNamedBufferData(int var0, long var1, long var3, int var5);

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3) {
        GL45C.nglNamedBufferData(n2, l2, 0L, n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n3) {
        GL45C.nglNamedBufferData(n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLenum") int n3) {
        GL45C.nglNamedBufferData(n2, Integer.toUnsignedLong(shortBuffer.remaining()) << 1, MemoryUtil.memAddress(shortBuffer), n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLenum") int n3) {
        GL45C.nglNamedBufferData(n2, Integer.toUnsignedLong(intBuffer.remaining()) << 2, MemoryUtil.memAddress(intBuffer), n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") LongBuffer longBuffer, @NativeType(value="GLenum") int n3) {
        GL45C.nglNamedBufferData(n2, Integer.toUnsignedLong(longBuffer.remaining()) << 3, MemoryUtil.memAddress(longBuffer), n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") FloatBuffer floatBuffer, @NativeType(value="GLenum") int n3) {
        GL45C.nglNamedBufferData(n2, Integer.toUnsignedLong(floatBuffer.remaining()) << 2, MemoryUtil.memAddress(floatBuffer), n3);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") DoubleBuffer doubleBuffer, @NativeType(value="GLenum") int n3) {
        GL45C.nglNamedBufferData(n2, Integer.toUnsignedLong(doubleBuffer.remaining()) << 3, MemoryUtil.memAddress(doubleBuffer), n3);
    }

    public static native void nglNamedBufferSubData(int var0, long var1, long var3, long var5);

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.nglNamedBufferSubData(n2, l2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL45C.nglNamedBufferSubData(n2, l2, Integer.toUnsignedLong(shortBuffer.remaining()) << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL45C.nglNamedBufferSubData(n2, l2, Integer.toUnsignedLong(intBuffer.remaining()) << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") LongBuffer longBuffer) {
        GL45C.nglNamedBufferSubData(n2, l2, Integer.toUnsignedLong(longBuffer.remaining()) << 3, MemoryUtil.memAddress(longBuffer));
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL45C.nglNamedBufferSubData(n2, l2, Integer.toUnsignedLong(floatBuffer.remaining()) << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL45C.nglNamedBufferSubData(n2, l2, Integer.toUnsignedLong(doubleBuffer.remaining()) << 3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glCopyNamedBufferSubData(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLintptr") long var2, @NativeType(value="GLintptr") long var4, @NativeType(value="GLsizeiptr") long var6);

    public static native void nglClearNamedBufferData(int var0, int var1, int var2, int var3, long var4);

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.nglClearNamedBufferData(n2, n3, n4, n5, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL45C.nglClearNamedBufferData(n2, n3, n4, n5, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        GL45C.nglClearNamedBufferData(n2, n3, n4, n5, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL45C.nglClearNamedBufferData(n2, n3, n4, n5, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static native void nglClearNamedBufferSubData(int var0, int var1, long var2, long var4, int var6, int var7, long var8);

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.nglClearNamedBufferSubData(n2, n3, l2, l3, n4, n5, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL45C.nglClearNamedBufferSubData(n2, n3, l2, l3, n4, n5, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        GL45C.nglClearNamedBufferSubData(n2, n3, l2, l3, n4, n5, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL45C.nglClearNamedBufferSubData(n2, n3, l2, l3, n4, n5, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static native long nglMapNamedBuffer(int var0, int var1);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        long l2 = GL45C.nglMapNamedBuffer(n2, n3);
        return MemoryUtil.memByteBufferSafe(l2, GL45C.glGetNamedBufferParameteri(n2, 34660));
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @Nullable ByteBuffer byteBuffer) {
        long l2 = GL45C.nglMapNamedBuffer(n2, n3);
        int n4 = GL45C.glGetNamedBufferParameteri(n2, 34660);
        return APIUtil.apiGetMappedBuffer(byteBuffer, l2, n4);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBuffer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, long l2, @Nullable ByteBuffer byteBuffer) {
        long l3 = GL45C.nglMapNamedBuffer(n2, n3);
        return APIUtil.apiGetMappedBuffer(byteBuffer, l3, (int)l2);
    }

    public static native long nglMapNamedBufferRange(int var0, long var1, long var3, int var5);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferRange(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLbitfield") int n3) {
        long l4 = GL45C.nglMapNamedBufferRange(n2, l2, l3, n3);
        return MemoryUtil.memByteBufferSafe(l4, (int)l3);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferRange(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLbitfield") int n3, @Nullable ByteBuffer byteBuffer) {
        long l4 = GL45C.nglMapNamedBufferRange(n2, l2, l3, n3);
        return APIUtil.apiGetMappedBuffer(byteBuffer, l4, (int)l3);
    }

    @NativeType(value="GLboolean")
    public static native boolean glUnmapNamedBuffer(@NativeType(value="GLuint") int var0);

    public static native void glFlushMappedNamedBufferRange(@NativeType(value="GLuint") int var0, @NativeType(value="GLintptr") long var1, @NativeType(value="GLsizeiptr") long var3);

    public static native void nglGetNamedBufferParameteriv(int var0, int var1, long var2);

    public static void glGetNamedBufferParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglGetNamedBufferParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedBufferParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetNamedBufferParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetNamedBufferParameteri64v(int var0, int var1, long var2);

    public static void glGetNamedBufferParameteri64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        GL45C.nglGetNamedBufferParameteri64v(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetNamedBufferParameteri64(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            GL45C.nglGetNamedBufferParameteri64v(n2, n3, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetNamedBufferPointerv(int var0, int var1, long var2);

    public static void glGetNamedBufferPointerv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        GL45C.nglGetNamedBufferPointerv(n2, n3, MemoryUtil.memAddress(pointerBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetNamedBufferPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
            GL45C.nglGetNamedBufferPointerv(n2, n3, MemoryUtil.memAddress(pointerBuffer));
            long l2 = pointerBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetNamedBufferSubData(int var0, long var1, long var3, long var5);

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.nglGetNamedBufferSubData(n2, l2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45C.nglGetNamedBufferSubData(n2, l2, Integer.toUnsignedLong(shortBuffer.remaining()) << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45C.nglGetNamedBufferSubData(n2, l2, Integer.toUnsignedLong(intBuffer.remaining()) << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") LongBuffer longBuffer) {
        GL45C.nglGetNamedBufferSubData(n2, l2, Integer.toUnsignedLong(longBuffer.remaining()) << 3, MemoryUtil.memAddress(longBuffer));
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45C.nglGetNamedBufferSubData(n2, l2, Integer.toUnsignedLong(floatBuffer.remaining()) << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        GL45C.nglGetNamedBufferSubData(n2, l2, Integer.toUnsignedLong(doubleBuffer.remaining()) << 3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglCreateFramebuffers(int var0, long var1);

    public static void glCreateFramebuffers(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.nglCreateFramebuffers(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateFramebuffers() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglCreateFramebuffers(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void glNamedFramebufferRenderbuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3);

    public static native void glNamedFramebufferParameteri(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void glNamedFramebufferTexture(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3);

    public static native void glNamedFramebufferTextureLayer(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glNamedFramebufferDrawBuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglNamedFramebufferDrawBuffers(int var0, int var1, long var2);

    public static void glNamedFramebufferDrawBuffers(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") IntBuffer intBuffer) {
        GL45C.nglNamedFramebufferDrawBuffers(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glNamedFramebufferDrawBuffers(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n3);
            GL45C.nglNamedFramebufferDrawBuffers(n2, 1, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void glNamedFramebufferReadBuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglInvalidateNamedFramebufferData(int var0, int var1, long var2);

    public static void glInvalidateNamedFramebufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") IntBuffer intBuffer) {
        GL45C.nglInvalidateNamedFramebufferData(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glInvalidateNamedFramebufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n3);
            GL45C.nglInvalidateNamedFramebufferData(n2, 1, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglInvalidateNamedFramebufferSubData(int var0, int var1, long var2, int var4, int var5, int var6, int var7);

    public static void glInvalidateNamedFramebufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") IntBuffer intBuffer, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6) {
        GL45C.nglInvalidateNamedFramebufferSubData(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), n3, n4, n5, n6);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glInvalidateNamedFramebufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n8 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n3);
            GL45C.nglInvalidateNamedFramebufferSubData(n2, 1, MemoryUtil.memAddress(intBuffer), n4, n5, n6, n7);
        }
        finally {
            memoryStack.setPointer(n8);
        }
    }

    public static native void nglClearNamedFramebufferiv(int var0, int var1, int var2, long var3);

    public static void glClearNamedFramebufferiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglClearNamedFramebufferiv(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglClearNamedFramebufferuiv(int var0, int var1, int var2, long var3);

    public static void glClearNamedFramebufferuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        GL45C.nglClearNamedFramebufferuiv(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglClearNamedFramebufferfv(int var0, int var1, int var2, long var3);

    public static void glClearNamedFramebufferfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        GL45C.nglClearNamedFramebufferfv(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glClearNamedFramebufferfi(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLint") int var4);

    public static native void glBlitNamedFramebuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLint") int var7, @NativeType(value="GLint") int var8, @NativeType(value="GLint") int var9, @NativeType(value="GLbitfield") int var10, @NativeType(value="GLenum") int var11);

    @NativeType(value="GLenum")
    public static native int glCheckNamedFramebufferStatus(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglGetNamedFramebufferParameteriv(int var0, int var1, long var2);

    public static void glGetNamedFramebufferParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglGetNamedFramebufferParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedFramebufferParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetNamedFramebufferParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetNamedFramebufferAttachmentParameteriv(int var0, int var1, int var2, long var3);

    public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglGetNamedFramebufferAttachmentParameteriv(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedFramebufferAttachmentParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetNamedFramebufferAttachmentParameteriv(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglCreateRenderbuffers(int var0, long var1);

    public static void glCreateRenderbuffers(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.nglCreateRenderbuffers(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateRenderbuffers() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglCreateRenderbuffers(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void glNamedRenderbufferStorage(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLsizei") int var3);

    public static native void glNamedRenderbufferStorageMultisample(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4);

    public static native void nglGetNamedRenderbufferParameteriv(int var0, int var1, long var2);

    public static void glGetNamedRenderbufferParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglGetNamedRenderbufferParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedRenderbufferParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetNamedRenderbufferParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglCreateTextures(int var0, int var1, long var2);

    public static void glCreateTextures(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.nglCreateTextures(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateTextures(@NativeType(value="GLenum") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglCreateTextures(n2, 1, MemoryUtil.memAddress(intBuffer));
            int n4 = intBuffer.get(0);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void glTextureBuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glTextureBufferRange(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3, @NativeType(value="GLsizeiptr") long var5);

    public static native void glTextureStorage1D(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3);

    public static native void glTextureStorage2D(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4);

    public static native void glTextureStorage3D(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5);

    public static native void glTextureStorage2DMultisample(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLboolean") boolean var5);

    public static native void glTextureStorage3DMultisample(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLboolean") boolean var6);

    public static native void nglTextureSubImage1D(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.nglTextureSubImage1D(n2, n3, n4, n5, n6, n7, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") long l2) {
        GL45C.nglTextureSubImage1D(n2, n3, n4, n5, n6, n7, l2);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL45C.nglTextureSubImage1D(n2, n3, n4, n5, n6, n7, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL45C.nglTextureSubImage1D(n2, n3, n4, n5, n6, n7, MemoryUtil.memAddress(intBuffer));
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL45C.nglTextureSubImage1D(n2, n3, n4, n5, n6, n7, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL45C.nglTextureSubImage1D(n2, n3, n4, n5, n6, n7, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglTextureSubImage2D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.nglTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") long l2) {
        GL45C.nglTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, l2);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL45C.nglTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL45C.nglTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddress(intBuffer));
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL45C.nglTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL45C.nglTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglTextureSubImage3D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.nglTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") long l2) {
        GL45C.nglTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, l2);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL45C.nglTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL45C.nglTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddress(intBuffer));
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL45C.nglTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL45C.nglTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglCompressedTextureSubImage1D(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glCompressedTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="void const *") long l2) {
        GL45C.nglCompressedTextureSubImage1D(n2, n3, n4, n5, n6, n7, l2);
    }

    public static void glCompressedTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.nglCompressedTextureSubImage1D(n2, n3, n4, n5, n6, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglCompressedTextureSubImage2D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glCompressedTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void const *") long l2) {
        GL45C.nglCompressedTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, l2);
    }

    public static void glCompressedTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.nglCompressedTextureSubImage2D(n2, n3, n4, n5, n6, n7, n8, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglCompressedTextureSubImage3D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glCompressedTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLsizei") int n11, @NativeType(value="void const *") long l2) {
        GL45C.nglCompressedTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, l2);
    }

    public static void glCompressedTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL45C.nglCompressedTextureSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void glCopyTextureSubImage1D(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLsizei") int var5);

    public static native void glCopyTextureSubImage2D(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLsizei") int var7);

    public static native void glCopyTextureSubImage3D(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLsizei") int var7, @NativeType(value="GLsizei") int var8);

    public static native void glTextureParameterf(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLfloat") float var2);

    public static native void nglTextureParameterfv(int var0, int var1, long var2);

    public static void glTextureParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 4);
        }
        GL45C.nglTextureParameterfv(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glTextureParameteri(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void nglTextureParameterIiv(int var0, int var1, long var2);

    public static void glTextureParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglTextureParameterIiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glTextureParameterIi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n4);
            GL45C.nglTextureParameterIiv(n2, n3, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglTextureParameterIuiv(int var0, int var1, long var2);

    public static void glTextureParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglTextureParameterIuiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glTextureParameterIui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n4);
            GL45C.nglTextureParameterIuiv(n2, n3, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglTextureParameteriv(int var0, int var1, long var2);

    public static void glTextureParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 4);
        }
        GL45C.nglTextureParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glGenerateTextureMipmap(@NativeType(value="GLuint") int var0);

    public static native void glBindTextureUnit(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglGetTextureImage(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="void *") long l2) {
        GL45C.nglGetTextureImage(n2, n3, n4, n5, n6, l2);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.nglGetTextureImage(n2, n3, n4, n5, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45C.nglGetTextureImage(n2, n3, n4, n5, shortBuffer.remaining() << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45C.nglGetTextureImage(n2, n3, n4, n5, intBuffer.remaining() << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45C.nglGetTextureImage(n2, n3, n4, n5, floatBuffer.remaining() << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        GL45C.nglGetTextureImage(n2, n3, n4, n5, doubleBuffer.remaining() << 3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglGetCompressedTextureImage(int var0, int var1, int var2, long var3);

    public static void glGetCompressedTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="void *") long l2) {
        GL45C.nglGetCompressedTextureImage(n2, n3, n4, l2);
    }

    public static void glGetCompressedTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="void *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)byteBuffer, GL45C.glGetTextureLevelParameteri(n2, n3, 34464));
        }
        GL45C.nglGetCompressedTextureImage(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetTextureLevelParameterfv(int var0, int var1, int var2, long var3);

    public static void glGetTextureLevelParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        GL45C.nglGetTextureLevelParameterfv(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetTextureLevelParameterf(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            GL45C.nglGetTextureLevelParameterfv(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetTextureLevelParameteriv(int var0, int var1, int var2, long var3);

    public static void glGetTextureLevelParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglGetTextureLevelParameteriv(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureLevelParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetTextureLevelParameteriv(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetTextureParameterfv(int var0, int var1, long var2);

    public static void glGetTextureParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        GL45C.nglGetTextureParameterfv(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetTextureParameterf(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            GL45C.nglGetTextureParameterfv(n2, n3, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetTextureParameterIiv(int var0, int var1, long var2);

    public static void glGetTextureParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglGetTextureParameterIiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureParameterIi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetTextureParameterIiv(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetTextureParameterIuiv(int var0, int var1, long var2);

    public static void glGetTextureParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglGetTextureParameterIuiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureParameterIui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetTextureParameterIuiv(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetTextureParameteriv(int var0, int var1, long var2);

    public static void glGetTextureParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglGetTextureParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetTextureParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglCreateVertexArrays(int var0, long var1);

    public static void glCreateVertexArrays(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.nglCreateVertexArrays(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateVertexArrays() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglCreateVertexArrays(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void glDisableVertexArrayAttrib(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glEnableVertexArrayAttrib(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexArrayElementBuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexArrayVertexBuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3, @NativeType(value="GLsizei") int var5);

    public static native void nglVertexArrayVertexBuffers(int var0, int var1, int var2, long var3, long var5, long var7);

    public static void glVertexArrayVertexBuffers(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizei const *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe(pointerBuffer, Checks.remainingSafe(intBuffer));
            Checks.checkSafe((Buffer)intBuffer2, Checks.remainingSafe(intBuffer));
        }
        GL45C.nglVertexArrayVertexBuffers(n2, n3, Checks.remainingSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(pointerBuffer), MemoryUtil.memAddressSafe(intBuffer2));
    }

    public static native void glVertexArrayAttribFormat(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLboolean") boolean var4, @NativeType(value="GLuint") int var5);

    public static native void glVertexArrayAttribIFormat(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLuint") int var4);

    public static native void glVertexArrayAttribLFormat(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLuint") int var4);

    public static native void glVertexArrayAttribBinding(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glVertexArrayBindingDivisor(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void nglGetVertexArrayiv(int var0, int var1, long var2);

    public static void glGetVertexArrayiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglGetVertexArrayiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexArrayi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetVertexArrayiv(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetVertexArrayIndexediv(int var0, int var1, int var2, long var3);

    public static void glGetVertexArrayIndexediv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL45C.nglGetVertexArrayIndexediv(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexArrayIndexedi(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetVertexArrayIndexediv(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetVertexArrayIndexed64iv(int var0, int var1, int var2, long var3);

    public static void glGetVertexArrayIndexed64iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        GL45C.nglGetVertexArrayIndexed64iv(n2, n3, n4, MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetVertexArrayIndexed64i(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            GL45C.nglGetVertexArrayIndexed64iv(n2, n3, n4, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglCreateSamplers(int var0, long var1);

    public static void glCreateSamplers(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.nglCreateSamplers(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateSamplers() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglCreateSamplers(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nglCreateProgramPipelines(int var0, long var1);

    public static void glCreateProgramPipelines(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.nglCreateProgramPipelines(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateProgramPipelines() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglCreateProgramPipelines(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nglCreateQueries(int var0, int var1, long var2);

    public static void glCreateQueries(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.nglCreateQueries(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateQueries(@NativeType(value="GLenum") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglCreateQueries(n2, 1, MemoryUtil.memAddress(intBuffer));
            int n4 = intBuffer.get(0);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void glGetQueryBufferObjectiv(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glGetQueryBufferObjectuiv(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glGetQueryBufferObjecti64v(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glGetQueryBufferObjectui64v(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glMemoryBarrierByRegion(@NativeType(value="GLbitfield") int var0);

    public static native void nglGetTextureSubImage(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, long var11);

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="GLsizei") int n12, @NativeType(value="void *") long l2) {
        GL45C.nglGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, l2);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.nglGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45C.nglGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, shortBuffer.remaining() << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45C.nglGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, intBuffer.remaining() << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45C.nglGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, floatBuffer.remaining() << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        GL45C.nglGetTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, doubleBuffer.remaining() << 3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglGetCompressedTextureSubImage(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLsizei") int n10, @NativeType(value="void *") long l2) {
        GL45C.nglGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, l2);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.nglGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45C.nglGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, shortBuffer.remaining() << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45C.nglGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, intBuffer.remaining() << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45C.nglGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, floatBuffer.remaining() << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        GL45C.nglGetCompressedTextureSubImage(n2, n3, n4, n5, n6, n7, n8, n9, doubleBuffer.remaining() << 3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glTextureBarrier();

    @NativeType(value="GLenum")
    public static native int glGetGraphicsResetStatus();

    public static native void nglGetnTexImage(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="void *") long l2) {
        GL45C.nglGetnTexImage(n2, n3, n4, n5, n6, l2);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.nglGetnTexImage(n2, n3, n4, n5, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45C.nglGetnTexImage(n2, n3, n4, n5, shortBuffer.remaining() << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45C.nglGetnTexImage(n2, n3, n4, n5, intBuffer.remaining() << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45C.nglGetnTexImage(n2, n3, n4, n5, floatBuffer.remaining() << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        GL45C.nglGetnTexImage(n2, n3, n4, n5, doubleBuffer.remaining() << 3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglReadnPixels(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="void *") long l2) {
        GL45C.nglReadnPixels(n2, n3, n4, n5, n6, n7, n8, l2);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL45C.nglReadnPixels(n2, n3, n4, n5, n6, n7, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") ShortBuffer shortBuffer) {
        GL45C.nglReadnPixels(n2, n3, n4, n5, n6, n7, shortBuffer.remaining() << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") IntBuffer intBuffer) {
        GL45C.nglReadnPixels(n2, n3, n4, n5, n6, n7, intBuffer.remaining() << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") FloatBuffer floatBuffer) {
        GL45C.nglReadnPixels(n2, n3, n4, n5, n6, n7, floatBuffer.remaining() << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetnCompressedTexImage(int var0, int var1, int var2, long var3);

    public static void glGetnCompressedTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="void *") long l2) {
        GL45C.nglGetnCompressedTexImage(n2, n3, n4, l2);
    }

    public static void glGetnCompressedTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="void *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)byteBuffer, GL11.glGetTexLevelParameteri(n2, n3, 34464));
        }
        GL45C.nglGetnCompressedTexImage(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetnUniformfv(int var0, int var1, int var2, long var3);

    public static void glGetnUniformfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL45C.nglGetnUniformfv(n2, n3, floatBuffer.remaining(), MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetnUniformf(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            GL45C.nglGetnUniformfv(n2, n3, 1, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnUniformdv(int var0, int var1, int var2, long var3);

    public static void glGetnUniformdv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        GL45C.nglGetnUniformdv(n2, n3, doubleBuffer.remaining(), MemoryUtil.memAddress(doubleBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetnUniformd(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
            GL45C.nglGetnUniformdv(n2, n3, 1, MemoryUtil.memAddress(doubleBuffer));
            double d2 = doubleBuffer.get(0);
            return d2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnUniformiv(int var0, int var1, int var2, long var3);

    public static void glGetnUniformiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL45C.nglGetnUniformiv(n2, n3, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetnUniformi(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetnUniformiv(n2, n3, 1, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnUniformuiv(int var0, int var1, int var2, long var3);

    public static void glGetnUniformuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL45C.nglGetnUniformuiv(n2, n3, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetnUniformui(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL45C.nglGetnUniformuiv(n2, n3, 1, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void glCreateTransformFeedbacks(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glCreateTransformFeedbacks;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glGetTransformFeedbackiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetTransformFeedbackiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetTransformFeedbacki_v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetTransformFeedbacki_v;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetTransformFeedbacki64_v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glGetTransformFeedbacki64_v;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, n4, lArray, l2);
    }

    public static void glCreateBuffers(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glCreateBuffers;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") short[] sArray, @NativeType(value="GLbitfield") int n3) {
        long l2 = GL.getICD().glNamedBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(sArray.length) << 1, sArray, n3, l2);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLbitfield") int n3) {
        long l2 = GL.getICD().glNamedBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(nArray.length) << 2, nArray, n3, l2);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") float[] fArray, @NativeType(value="GLbitfield") int n3) {
        long l2 = GL.getICD().glNamedBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(fArray.length) << 2, fArray, n3, l2);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") double[] dArray, @NativeType(value="GLbitfield") int n3) {
        long l2 = GL.getICD().glNamedBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(dArray.length) << 3, dArray, n3, l2);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") short[] sArray, @NativeType(value="GLenum") int n3) {
        long l2 = GL.getICD().glNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(sArray.length) << 1, sArray, n3, l2);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLenum") int n3) {
        long l2 = GL.getICD().glNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(nArray.length) << 2, nArray, n3, l2);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") long[] lArray, @NativeType(value="GLenum") int n3) {
        long l2 = GL.getICD().glNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(lArray.length) << 3, lArray, n3, l2);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") float[] fArray, @NativeType(value="GLenum") int n3) {
        long l2 = GL.getICD().glNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(fArray.length) << 2, fArray, n3, l2);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") double[] dArray, @NativeType(value="GLenum") int n3) {
        long l2 = GL.getICD().glNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(dArray.length) << 3, dArray, n3, l2);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") short[] sArray) {
        long l3 = GL.getICD().glNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(sArray.length) << 1, sArray, l3);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") int[] nArray) {
        long l3 = GL.getICD().glNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(nArray.length) << 2, nArray, l3);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") long[] lArray) {
        long l3 = GL.getICD().glNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(lArray.length) << 3, lArray, l3);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") float[] fArray) {
        long l3 = GL.getICD().glNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(fArray.length) << 2, fArray, l3);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void const *") double[] dArray) {
        long l3 = GL.getICD().glNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(dArray.length) << 3, dArray, l3);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glClearNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, sArray, l2);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glClearNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, nArray, l2);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glClearNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, fArray, l2);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l4 = GL.getICD().glClearNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        JNI.callPPPV(n2, n3, l2, l3, n4, n5, sArray, l4);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l4 = GL.getICD().glClearNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        JNI.callPPPV(n2, n3, l2, l3, n4, n5, nArray, l4);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l4 = GL.getICD().glClearNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        JNI.callPPPV(n2, n3, l2, l3, n4, n5, fArray, l4);
    }

    public static void glGetNamedBufferParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedBufferParameteriv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetNamedBufferParameteri64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glGetNamedBufferParameteri64v;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, lArray, l2);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") short[] sArray) {
        long l3 = GL.getICD().glGetNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(sArray.length) << 1, sArray, l3);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") int[] nArray) {
        long l3 = GL.getICD().glGetNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(nArray.length) << 2, nArray, l3);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") long[] lArray) {
        long l3 = GL.getICD().glGetNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(lArray.length) << 3, lArray, l3);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") float[] fArray) {
        long l3 = GL.getICD().glGetNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(fArray.length) << 2, fArray, l3);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="void *") double[] dArray) {
        long l3 = GL.getICD().glGetNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n2, l2, Integer.toUnsignedLong(dArray.length) << 3, dArray, l3);
    }

    public static void glCreateFramebuffers(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glCreateFramebuffers;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glNamedFramebufferDrawBuffers(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int[] nArray) {
        long l2 = GL.getICD().glNamedFramebufferDrawBuffers;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length, nArray, l2);
    }

    public static void glInvalidateNamedFramebufferData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int[] nArray) {
        long l2 = GL.getICD().glInvalidateNamedFramebufferData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length, nArray, l2);
    }

    public static void glInvalidateNamedFramebufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum const *") int[] nArray, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6) {
        long l2 = GL.getICD().glInvalidateNamedFramebufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length, nArray, n3, n4, n5, n6, l2);
    }

    public static void glClearNamedFramebufferiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glClearNamedFramebufferiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glClearNamedFramebufferuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glClearNamedFramebufferuiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glClearNamedFramebufferfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glClearNamedFramebufferfv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glGetNamedFramebufferParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedFramebufferParameteriv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedFramebufferAttachmentParameteriv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glCreateRenderbuffers(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glCreateRenderbuffers;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glGetNamedRenderbufferParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedRenderbufferParameteriv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glCreateTextures(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glCreateTextures;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length, nArray, l2);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glTextureSubImage1D;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, sArray, l2);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glTextureSubImage1D;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, nArray, l2);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glTextureSubImage1D;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, fArray, l2);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glTextureSubImage1D;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, dArray, l2);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glTextureSubImage2D;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, sArray, l2);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glTextureSubImage2D;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, nArray, l2);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glTextureSubImage2D;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, fArray, l2);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLenum") int n9, @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glTextureSubImage2D;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, dArray, l2);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glTextureSubImage3D;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, sArray, l2);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glTextureSubImage3D;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, nArray, l2);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glTextureSubImage3D;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, fArray, l2);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glTextureSubImage3D;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, dArray, l2);
    }

    public static void glTextureParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glTextureParameterfv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 4);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glTextureParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glTextureParameterIiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glTextureParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glTextureParameterIuiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glTextureParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glTextureParameteriv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 4);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") short[] sArray) {
        long l2 = GL.getICD().glGetTextureImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, sArray.length << 1, sArray, l2);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getICD().glGetTextureImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, nArray.length << 2, nArray, l2);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getICD().glGetTextureImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, fArray.length << 2, fArray, l2);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") double[] dArray) {
        long l2 = GL.getICD().glGetTextureImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, dArray.length << 3, dArray, l2);
    }

    public static void glGetTextureLevelParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetTextureLevelParameterfv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glGetTextureLevelParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetTextureLevelParameteriv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetTextureParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetTextureParameterfv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glGetTextureParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetTextureParameterIiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetTextureParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGetTextureParameterIuiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetTextureParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetTextureParameteriv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glCreateVertexArrays(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glCreateVertexArrays;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glVertexArrayVertexBuffers(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") int[] nArray, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizei const *") int[] nArray2) {
        long l2 = GL.getICD().glVertexArrayVertexBuffers;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(pointerBuffer, Checks.lengthSafe(nArray));
            Checks.checkSafe(nArray2, Checks.lengthSafe(nArray));
        }
        JNI.callPPPV(n2, n3, Checks.lengthSafe(nArray), nArray, MemoryUtil.memAddressSafe(pointerBuffer), nArray2, l2);
    }

    public static void glGetVertexArrayiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetVertexArrayiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetVertexArrayIndexediv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetVertexArrayIndexediv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetVertexArrayIndexed64iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glGetVertexArrayIndexed64iv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, n4, lArray, l2);
    }

    public static void glCreateSamplers(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glCreateSamplers;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glCreateProgramPipelines(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glCreateProgramPipelines;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glCreateQueries(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glCreateQueries;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length, nArray, l2);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") short[] sArray) {
        long l2 = GL.getICD().glGetTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, sArray.length << 1, sArray, l2);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getICD().glGetTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, nArray.length << 2, nArray, l2);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getICD().glGetTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, fArray.length << 2, fArray, l2);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @NativeType(value="void *") double[] dArray) {
        long l2 = GL.getICD().glGetTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, dArray.length << 3, dArray, l2);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") short[] sArray) {
        long l2 = GL.getICD().glGetCompressedTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, sArray.length << 1, sArray, l2);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getICD().glGetCompressedTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, nArray.length << 2, nArray, l2);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getICD().glGetCompressedTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, fArray.length << 2, fArray, l2);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void *") double[] dArray) {
        long l2 = GL.getICD().glGetCompressedTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, dArray.length << 3, dArray, l2);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") short[] sArray) {
        long l2 = GL.getICD().glGetnTexImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, sArray.length << 1, sArray, l2);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getICD().glGetnTexImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, nArray.length << 2, nArray, l2);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getICD().glGetnTexImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, fArray.length << 2, fArray, l2);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") double[] dArray) {
        long l2 = GL.getICD().glGetnTexImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, dArray.length << 3, dArray, l2);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") short[] sArray) {
        long l2 = GL.getICD().glReadnPixels;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, sArray.length << 1, sArray, l2);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getICD().glReadnPixels;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, nArray.length << 2, nArray, l2);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getICD().glReadnPixels;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, fArray.length << 2, fArray, l2);
    }

    public static void glGetnUniformfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetnUniformfv;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length, fArray, l2);
    }

    public static void glGetnUniformdv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        long l2 = GL.getICD().glGetnUniformdv;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, dArray.length, dArray, l2);
    }

    public static void glGetnUniformiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetnUniformiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length, nArray, l2);
    }

    public static void glGetnUniformuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGetnUniformuiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length, nArray, l2);
    }

    static {
        GL.initialize();
    }
}

