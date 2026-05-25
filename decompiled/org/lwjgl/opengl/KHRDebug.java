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
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLDebugMessageCallbackI;
import org.lwjgl.system.NativeType;

public class KHRDebug {
    public static final int GL_DEBUG_OUTPUT = 37600;
    public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 33346;
    public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 2;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188;
    public static final int GL_DEBUG_LOGGED_MESSAGES = 37189;
    public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 33347;
    public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388;
    public static final int GL_DEBUG_GROUP_STACK_DEPTH = 33389;
    public static final int GL_MAX_LABEL_LENGTH = 33512;
    public static final int GL_DEBUG_CALLBACK_FUNCTION = 33348;
    public static final int GL_DEBUG_CALLBACK_USER_PARAM = 33349;
    public static final int GL_DEBUG_SOURCE_API = 33350;
    public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351;
    public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352;
    public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353;
    public static final int GL_DEBUG_SOURCE_APPLICATION = 33354;
    public static final int GL_DEBUG_SOURCE_OTHER = 33355;
    public static final int GL_DEBUG_TYPE_ERROR = 33356;
    public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357;
    public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358;
    public static final int GL_DEBUG_TYPE_PORTABILITY = 33359;
    public static final int GL_DEBUG_TYPE_PERFORMANCE = 33360;
    public static final int GL_DEBUG_TYPE_OTHER = 33361;
    public static final int GL_DEBUG_TYPE_MARKER = 33384;
    public static final int GL_DEBUG_TYPE_PUSH_GROUP = 33385;
    public static final int GL_DEBUG_TYPE_POP_GROUP = 33386;
    public static final int GL_DEBUG_SEVERITY_HIGH = 37190;
    public static final int GL_DEBUG_SEVERITY_MEDIUM = 37191;
    public static final int GL_DEBUG_SEVERITY_LOW = 37192;
    public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387;
    public static final int GL_BUFFER = 33504;
    public static final int GL_SHADER = 33505;
    public static final int GL_PROGRAM = 33506;
    public static final int GL_QUERY = 33507;
    public static final int GL_PROGRAM_PIPELINE = 33508;
    public static final int GL_SAMPLER = 33510;
    public static final int GL_DISPLAY_LIST = 33511;

    protected KHRDebug() {
        throw new UnsupportedOperationException();
    }

    public static void nglDebugMessageControl(int n2, int n3, int n4, int n5, long l2, boolean bl2) {
        GL43C.nglDebugMessageControl(n2, n3, n4, n5, l2, bl2);
    }

    public static void glDebugMessageControl(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLboolean") boolean bl2) {
        GL43C.glDebugMessageControl(n2, n3, n4, intBuffer, bl2);
    }

    public static void glDebugMessageControl(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint const *") int n5, @NativeType(value="GLboolean") boolean bl2) {
        GL43C.glDebugMessageControl(n2, n3, n4, n5, bl2);
    }

    public static void nglDebugMessageInsert(int n2, int n3, int n4, int n5, int n6, long l2) {
        GL43C.nglDebugMessageInsert(n2, n3, n4, n5, n6, l2);
    }

    public static void glDebugMessageInsert(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        GL43C.glDebugMessageInsert(n2, n3, n4, n5, byteBuffer);
    }

    public static void glDebugMessageInsert(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLchar const *") CharSequence charSequence) {
        GL43C.glDebugMessageInsert(n2, n3, n4, n5, charSequence);
    }

    public static void nglDebugMessageCallback(long l2, long l3) {
        GL43C.nglDebugMessageCallback(l2, l3);
    }

    public static void glDebugMessageCallback(@Nullable @NativeType(value="GLDEBUGPROC") GLDebugMessageCallbackI gLDebugMessageCallbackI, @NativeType(value="void const *") long l2) {
        GL43C.glDebugMessageCallback(gLDebugMessageCallbackI, l2);
    }

    public static int nglGetDebugMessageLog(int n2, int n3, long l2, long l3, long l4, long l5, long l6, long l7) {
        return GL43C.nglGetDebugMessageLog(n2, n3, l2, l3, l4, l5, l6, l7);
    }

    @NativeType(value="GLuint")
    public static int glGetDebugMessageLog(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLenum *") IntBuffer intBuffer, @Nullable @NativeType(value="GLenum *") IntBuffer intBuffer2, @Nullable @NativeType(value="GLuint *") IntBuffer intBuffer3, @Nullable @NativeType(value="GLenum *") IntBuffer intBuffer4, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer5, @Nullable @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        return GL43C.glGetDebugMessageLog(n2, intBuffer, intBuffer2, intBuffer3, intBuffer4, intBuffer5, byteBuffer);
    }

    public static void nglPushDebugGroup(int n2, int n3, int n4, long l2) {
        GL43C.nglPushDebugGroup(n2, n3, n4, l2);
    }

    public static void glPushDebugGroup(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        GL43C.glPushDebugGroup(n2, n3, byteBuffer);
    }

    public static void glPushDebugGroup(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLchar const *") CharSequence charSequence) {
        GL43C.glPushDebugGroup(n2, n3, charSequence);
    }

    public static void glPopDebugGroup() {
        GL43C.glPopDebugGroup();
    }

    public static void nglObjectLabel(int n2, int n3, int n4, long l2) {
        GL43C.nglObjectLabel(n2, n3, n4, l2);
    }

    public static void glObjectLabel(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        GL43C.glObjectLabel(n2, n3, byteBuffer);
    }

    public static void glObjectLabel(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLchar const *") CharSequence charSequence) {
        GL43C.glObjectLabel(n2, n3, charSequence);
    }

    public static void nglGetObjectLabel(int n2, int n3, int n4, long l2, long l3) {
        GL43C.nglGetObjectLabel(n2, n3, n4, l2, l3);
    }

    public static void glGetObjectLabel(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL43C.glGetObjectLabel(n2, n3, intBuffer, byteBuffer);
    }

    @NativeType(value="void")
    public static String glGetObjectLabel(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei") int n4) {
        return GL43C.glGetObjectLabel(n2, n3, n4);
    }

    @NativeType(value="void")
    public static String glGetObjectLabel(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        return KHRDebug.glGetObjectLabel(n2, n3, GL11.glGetInteger(33512));
    }

    public static void nglObjectPtrLabel(long l2, int n2, long l3) {
        GL43C.nglObjectPtrLabel(l2, n2, l3);
    }

    public static void glObjectPtrLabel(@NativeType(value="void *") long l2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        GL43C.glObjectPtrLabel(l2, byteBuffer);
    }

    public static void glObjectPtrLabel(@NativeType(value="void *") long l2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        GL43C.glObjectPtrLabel(l2, charSequence);
    }

    public static void nglGetObjectPtrLabel(long l2, int n2, long l3, long l4) {
        GL43C.nglGetObjectPtrLabel(l2, n2, l3, l4);
    }

    public static void glGetObjectPtrLabel(@NativeType(value="void *") long l2, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL43C.glGetObjectPtrLabel(l2, intBuffer, byteBuffer);
    }

    @NativeType(value="void")
    public static String glGetObjectPtrLabel(@NativeType(value="void *") long l2, @NativeType(value="GLsizei") int n2) {
        return GL43C.glGetObjectPtrLabel(l2, n2);
    }

    @NativeType(value="void")
    public static String glGetObjectPtrLabel(@NativeType(value="void *") long l2) {
        return KHRDebug.glGetObjectPtrLabel(l2, GL11.glGetInteger(33512));
    }

    public static void glDebugMessageControl(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @Nullable @NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLboolean") boolean bl2) {
        GL43C.glDebugMessageControl(n2, n3, n4, nArray, bl2);
    }

    @NativeType(value="GLuint")
    public static int glGetDebugMessageLog(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLenum *") int[] nArray, @Nullable @NativeType(value="GLenum *") int[] nArray2, @Nullable @NativeType(value="GLuint *") int[] nArray3, @Nullable @NativeType(value="GLenum *") int[] nArray4, @Nullable @NativeType(value="GLsizei *") int[] nArray5, @Nullable @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        return GL43C.glGetDebugMessageLog(n2, nArray, nArray2, nArray3, nArray4, nArray5, byteBuffer);
    }

    public static void glGetObjectLabel(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL43C.glGetObjectLabel(n2, n3, nArray, byteBuffer);
    }

    public static void glGetObjectPtrLabel(@NativeType(value="void *") long l2, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL43C.glGetObjectPtrLabel(l2, nArray, byteBuffer);
    }

    static {
        GL.initialize();
    }
}

