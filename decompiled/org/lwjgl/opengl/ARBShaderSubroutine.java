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
import org.lwjgl.opengl.GL40C;
import org.lwjgl.system.NativeType;

public class ARBShaderSubroutine {
    public static final int GL_ACTIVE_SUBROUTINES = 36325;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423;
    public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425;
    public static final int GL_MAX_SUBROUTINES = 36327;
    public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328;
    public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426;
    public static final int GL_COMPATIBLE_SUBROUTINES = 36427;

    protected ARBShaderSubroutine() {
        throw new UnsupportedOperationException();
    }

    public static int nglGetSubroutineUniformLocation(int n2, int n3, long l2) {
        return GL40C.nglGetSubroutineUniformLocation(n2, n3, l2);
    }

    @NativeType(value="GLint")
    public static int glGetSubroutineUniformLocation(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        return GL40C.glGetSubroutineUniformLocation(n2, n3, byteBuffer);
    }

    @NativeType(value="GLint")
    public static int glGetSubroutineUniformLocation(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLchar const *") CharSequence charSequence) {
        return GL40C.glGetSubroutineUniformLocation(n2, n3, charSequence);
    }

    public static int nglGetSubroutineIndex(int n2, int n3, long l2) {
        return GL40C.nglGetSubroutineIndex(n2, n3, l2);
    }

    @NativeType(value="GLuint")
    public static int glGetSubroutineIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        return GL40C.glGetSubroutineIndex(n2, n3, byteBuffer);
    }

    @NativeType(value="GLuint")
    public static int glGetSubroutineIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLchar const *") CharSequence charSequence) {
        return GL40C.glGetSubroutineIndex(n2, n3, charSequence);
    }

    public static void nglGetActiveSubroutineUniformiv(int n2, int n3, int n4, int n5, long l2) {
        GL40C.nglGetActiveSubroutineUniformiv(n2, n3, n4, n5, l2);
    }

    public static void glGetActiveSubroutineUniformiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL40C.glGetActiveSubroutineUniformiv(n2, n3, n4, n5, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetActiveSubroutineUniformi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum") int n5) {
        return GL40C.glGetActiveSubroutineUniformi(n2, n3, n4, n5);
    }

    public static void nglGetActiveSubroutineUniformName(int n2, int n3, int n4, int n5, long l2, long l3) {
        GL40C.nglGetActiveSubroutineUniformName(n2, n3, n4, n5, l2, l3);
    }

    public static void glGetActiveSubroutineUniformName(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL40C.glGetActiveSubroutineUniformName(n2, n3, n4, intBuffer, byteBuffer);
    }

    @NativeType(value="void")
    public static String glGetActiveSubroutineUniformName(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLsizei") int n5) {
        return GL40C.glGetActiveSubroutineUniformName(n2, n3, n4, n5);
    }

    @NativeType(value="void")
    public static String glGetActiveSubroutineUniformName(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        return ARBShaderSubroutine.glGetActiveSubroutineUniformName(n2, n3, n4, ARBShaderSubroutine.glGetActiveSubroutineUniformi(n2, n3, n4, 35385));
    }

    public static void nglGetActiveSubroutineName(int n2, int n3, int n4, int n5, long l2, long l3) {
        GL40C.nglGetActiveSubroutineName(n2, n3, n4, n5, l2, l3);
    }

    public static void glGetActiveSubroutineName(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL40C.glGetActiveSubroutineName(n2, n3, n4, intBuffer, byteBuffer);
    }

    @NativeType(value="void")
    public static String glGetActiveSubroutineName(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLsizei") int n5) {
        return GL40C.glGetActiveSubroutineName(n2, n3, n4, n5);
    }

    @NativeType(value="void")
    public static String glGetActiveSubroutineName(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        return ARBShaderSubroutine.glGetActiveSubroutineName(n2, n3, n4, ARBShaderSubroutine.glGetProgramStagei(n2, n3, 36424));
    }

    public static void nglUniformSubroutinesuiv(int n2, int n3, long l2) {
        GL40C.nglUniformSubroutinesuiv(n2, n3, l2);
    }

    public static void glUniformSubroutinesuiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL40C.glUniformSubroutinesuiv(n2, intBuffer);
    }

    public static void glUniformSubroutinesui(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int n3) {
        GL40C.glUniformSubroutinesui(n2, n3);
    }

    public static void nglGetUniformSubroutineuiv(int n2, int n3, long l2) {
        GL40C.nglGetUniformSubroutineuiv(n2, n3, l2);
    }

    public static void glGetUniformSubroutineuiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL40C.glGetUniformSubroutineuiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetUniformSubroutineui(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3) {
        return GL40C.glGetUniformSubroutineui(n2, n3);
    }

    public static void nglGetProgramStageiv(int n2, int n3, int n4, long l2) {
        GL40C.nglGetProgramStageiv(n2, n3, n4, l2);
    }

    public static void glGetProgramStageiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL40C.glGetProgramStageiv(n2, n3, n4, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetProgramStagei(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        return GL40C.glGetProgramStagei(n2, n3, n4);
    }

    public static void glGetActiveSubroutineUniformiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLint *") int[] nArray) {
        GL40C.glGetActiveSubroutineUniformiv(n2, n3, n4, n5, nArray);
    }

    public static void glGetActiveSubroutineUniformName(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL40C.glGetActiveSubroutineUniformName(n2, n3, n4, nArray, byteBuffer);
    }

    public static void glGetActiveSubroutineName(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL40C.glGetActiveSubroutineName(n2, n3, n4, nArray, byteBuffer);
    }

    public static void glUniformSubroutinesuiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL40C.glUniformSubroutinesuiv(n2, nArray);
    }

    public static void glGetUniformSubroutineuiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint *") int[] nArray) {
        GL40C.glGetUniformSubroutineuiv(n2, n3, nArray);
    }

    public static void glGetProgramStageiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        GL40C.glGetProgramStageiv(n2, n3, n4, nArray);
    }

    static {
        GL.initialize();
    }
}

