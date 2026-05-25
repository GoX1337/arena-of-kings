/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31C;
import org.lwjgl.system.NativeType;

public class GL31
extends GL30 {
    public static final int GL_R8_SNORM = 36756;
    public static final int GL_RG8_SNORM = 36757;
    public static final int GL_RGB8_SNORM = 36758;
    public static final int GL_RGBA8_SNORM = 36759;
    public static final int GL_R16_SNORM = 36760;
    public static final int GL_RG16_SNORM = 36761;
    public static final int GL_RGB16_SNORM = 36762;
    public static final int GL_RGBA16_SNORM = 36763;
    public static final int GL_SIGNED_NORMALIZED = 36764;
    public static final int GL_SAMPLER_BUFFER = 36290;
    public static final int GL_INT_SAMPLER_2D_RECT = 36301;
    public static final int GL_INT_SAMPLER_BUFFER = 36304;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT = 36309;
    public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 36312;
    public static final int GL_COPY_READ_BUFFER = 36662;
    public static final int GL_COPY_WRITE_BUFFER = 36663;
    public static final int GL_PRIMITIVE_RESTART = 36765;
    public static final int GL_PRIMITIVE_RESTART_INDEX = 36766;
    public static final int GL_TEXTURE_BUFFER = 35882;
    public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 35883;
    public static final int GL_TEXTURE_BINDING_BUFFER = 35884;
    public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 35885;
    public static final int GL_TEXTURE_RECTANGLE = 34037;
    public static final int GL_TEXTURE_BINDING_RECTANGLE = 34038;
    public static final int GL_PROXY_TEXTURE_RECTANGLE = 34039;
    public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 34040;
    public static final int GL_SAMPLER_2D_RECT = 35683;
    public static final int GL_SAMPLER_2D_RECT_SHADOW = 35684;
    public static final int GL_UNIFORM_BUFFER = 35345;
    public static final int GL_UNIFORM_BUFFER_BINDING = 35368;
    public static final int GL_UNIFORM_BUFFER_START = 35369;
    public static final int GL_UNIFORM_BUFFER_SIZE = 35370;
    public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 35371;
    public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 35372;
    public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 35373;
    public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 35374;
    public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 35375;
    public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 35376;
    public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 35377;
    public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 35378;
    public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 35379;
    public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 35380;
    public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 35381;
    public static final int GL_ACTIVE_UNIFORM_BLOCKS = 35382;
    public static final int GL_UNIFORM_TYPE = 35383;
    public static final int GL_UNIFORM_SIZE = 35384;
    public static final int GL_UNIFORM_NAME_LENGTH = 35385;
    public static final int GL_UNIFORM_BLOCK_INDEX = 35386;
    public static final int GL_UNIFORM_OFFSET = 35387;
    public static final int GL_UNIFORM_ARRAY_STRIDE = 35388;
    public static final int GL_UNIFORM_MATRIX_STRIDE = 35389;
    public static final int GL_UNIFORM_IS_ROW_MAJOR = 35390;
    public static final int GL_UNIFORM_BLOCK_BINDING = 35391;
    public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 35392;
    public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 35393;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 35394;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 35395;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 35396;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 35397;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 35398;
    public static final int GL_INVALID_INDEX = -1;

    protected GL31() {
        throw new UnsupportedOperationException();
    }

    public static void glDrawArraysInstanced(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        GL31C.glDrawArraysInstanced(n2, n3, n4, n5);
    }

    public static void nglDrawElementsInstanced(int n2, int n3, int n4, long l2, int n5) {
        GL31C.nglDrawElementsInstanced(n2, n3, n4, l2, n5);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") long l2, @NativeType(value="GLsizei") int n5) {
        GL31C.glDrawElementsInstanced(n2, n3, n4, l2, n5);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n4) {
        GL31C.glDrawElementsInstanced(n2, n3, byteBuffer, n4);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n3) {
        GL31C.glDrawElementsInstanced(n2, byteBuffer, n3);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLsizei") int n3) {
        GL31C.glDrawElementsInstanced(n2, shortBuffer, n3);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLsizei") int n3) {
        GL31C.glDrawElementsInstanced(n2, intBuffer, n3);
    }

    public static void glCopyBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLintptr") long l3, @NativeType(value="GLsizeiptr") long l4) {
        GL31C.glCopyBufferSubData(n2, n3, l2, l3, l4);
    }

    public static void glPrimitiveRestartIndex(@NativeType(value="GLuint") int n2) {
        GL31C.glPrimitiveRestartIndex(n2);
    }

    public static void glTexBuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        GL31C.glTexBuffer(n2, n3, n4);
    }

    public static void nglGetUniformIndices(int n2, int n3, long l2, long l3) {
        GL31C.nglGetUniformIndices(n2, n3, l2, l3);
    }

    public static void glGetUniformIndices(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const **") PointerBuffer pointerBuffer, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL31C.glGetUniformIndices(n2, pointerBuffer, intBuffer);
    }

    public static void glGetUniformIndices(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const **") CharSequence[] charSequenceArray, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL31C.glGetUniformIndices(n2, charSequenceArray, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetUniformIndices(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const **") CharSequence charSequence) {
        return GL31C.glGetUniformIndices(n2, charSequence);
    }

    public static void nglGetActiveUniformsiv(int n2, int n3, long l2, int n4, long l3) {
        GL31C.nglGetActiveUniformsiv(n2, n3, l2, n4, l3);
    }

    public static void glGetActiveUniformsiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer2) {
        GL31C.glGetActiveUniformsiv(n2, intBuffer, n3, intBuffer2);
    }

    @NativeType(value="void")
    public static int glGetActiveUniformsi(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int n3, @NativeType(value="GLenum") int n4) {
        return GL31C.glGetActiveUniformsi(n2, n3, n4);
    }

    public static void nglGetActiveUniformName(int n2, int n3, int n4, long l2, long l3) {
        GL31C.nglGetActiveUniformName(n2, n3, n4, l2, l3);
    }

    public static void glGetActiveUniformName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL31C.glGetActiveUniformName(n2, n3, intBuffer, byteBuffer);
    }

    @NativeType(value="void")
    public static String glGetActiveUniformName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei") int n4) {
        return GL31C.glGetActiveUniformName(n2, n3, n4);
    }

    @NativeType(value="void")
    public static String glGetActiveUniformName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        return GL31.glGetActiveUniformName(n2, n3, GL31.glGetActiveUniformsi(n2, n3, 35385));
    }

    public static int nglGetUniformBlockIndex(int n2, long l2) {
        return GL31C.nglGetUniformBlockIndex(n2, l2);
    }

    @NativeType(value="GLuint")
    public static int glGetUniformBlockIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        return GL31C.glGetUniformBlockIndex(n2, byteBuffer);
    }

    @NativeType(value="GLuint")
    public static int glGetUniformBlockIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        return GL31C.glGetUniformBlockIndex(n2, charSequence);
    }

    public static void nglGetActiveUniformBlockiv(int n2, int n3, int n4, long l2) {
        GL31C.nglGetActiveUniformBlockiv(n2, n3, n4, l2);
    }

    public static void glGetActiveUniformBlockiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL31C.glGetActiveUniformBlockiv(n2, n3, n4, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetActiveUniformBlocki(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        return GL31C.glGetActiveUniformBlocki(n2, n3, n4);
    }

    public static void nglGetActiveUniformBlockName(int n2, int n3, int n4, long l2, long l3) {
        GL31C.nglGetActiveUniformBlockName(n2, n3, n4, l2, l3);
    }

    public static void glGetActiveUniformBlockName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL31C.glGetActiveUniformBlockName(n2, n3, intBuffer, byteBuffer);
    }

    @NativeType(value="void")
    public static String glGetActiveUniformBlockName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei") int n4) {
        return GL31C.glGetActiveUniformBlockName(n2, n3, n4);
    }

    @NativeType(value="void")
    public static String glGetActiveUniformBlockName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        return GL31.glGetActiveUniformBlockName(n2, n3, GL31.glGetActiveUniformBlocki(n2, n3, 35393));
    }

    public static void glUniformBlockBinding(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4) {
        GL31C.glUniformBlockBinding(n2, n3, n4);
    }

    public static void glGetUniformIndices(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const **") PointerBuffer pointerBuffer, @NativeType(value="GLuint *") int[] nArray) {
        GL31C.glGetUniformIndices(n2, pointerBuffer, nArray);
    }

    public static void glGetActiveUniformsiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray2) {
        GL31C.glGetActiveUniformsiv(n2, nArray, n3, nArray2);
    }

    public static void glGetActiveUniformName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL31C.glGetActiveUniformName(n2, n3, nArray, byteBuffer);
    }

    public static void glGetActiveUniformBlockiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        GL31C.glGetActiveUniformBlockiv(n2, n3, n4, nArray);
    }

    public static void glGetActiveUniformBlockName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL31C.glGetActiveUniformBlockName(n2, n3, nArray, byteBuffer);
    }

    static {
        GL.initialize();
    }
}

