/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL31C
extends GL30C {
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

    protected GL31C() {
        throw new UnsupportedOperationException();
    }

    public static native void glDrawArraysInstanced(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLsizei") int var3);

    public static native void nglDrawElementsInstanced(int var0, int var1, int var2, long var3, int var5);

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") long l2, @NativeType(value="GLsizei") int n5) {
        GL31C.nglDrawElementsInstanced(n2, n3, n4, l2, n5);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n4) {
        GL31C.nglDrawElementsInstanced(n2, byteBuffer.remaining() >> GLChecks.typeToByteShift(n3), n3, MemoryUtil.memAddress(byteBuffer), n4);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n3) {
        GL31C.nglDrawElementsInstanced(n2, byteBuffer.remaining(), 5121, MemoryUtil.memAddress(byteBuffer), n3);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLsizei") int n3) {
        GL31C.nglDrawElementsInstanced(n2, shortBuffer.remaining(), 5123, MemoryUtil.memAddress(shortBuffer), n3);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLsizei") int n3) {
        GL31C.nglDrawElementsInstanced(n2, intBuffer.remaining(), 5125, MemoryUtil.memAddress(intBuffer), n3);
    }

    public static native void glCopyBufferSubData(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLintptr") long var2, @NativeType(value="GLintptr") long var4, @NativeType(value="GLsizeiptr") long var6);

    public static native void glPrimitiveRestartIndex(@NativeType(value="GLuint") int var0);

    public static native void glTexBuffer(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void nglGetUniformIndices(int var0, int var1, long var2, long var4);

    public static void glGetUniformIndices(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const **") PointerBuffer pointerBuffer, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, pointerBuffer.remaining());
        }
        GL31C.nglGetUniformIndices(n2, pointerBuffer.remaining(), MemoryUtil.memAddress(pointerBuffer), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glGetUniformIndices(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const **") CharSequence[] charSequenceArray, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, charSequenceArray.length);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            long l2 = APIUtil.apiArray(memoryStack, MemoryUtil::memASCII, charSequenceArray);
            GL31C.nglGetUniformIndices(n2, charSequenceArray.length, l2, MemoryUtil.memAddress(intBuffer));
            APIUtil.apiArrayFree(l2, charSequenceArray.length);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetUniformIndices(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const **") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            long l2 = APIUtil.apiArray(memoryStack, MemoryUtil::memASCII, charSequence);
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL31C.nglGetUniformIndices(n2, 1, l2, MemoryUtil.memAddress(intBuffer));
            APIUtil.apiArrayFree(l2, 1);
            int n4 = intBuffer.get(0);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nglGetActiveUniformsiv(int var0, int var1, long var2, int var4, long var5);

    public static void glGetActiveUniformsiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer2, intBuffer.remaining());
        }
        GL31C.nglGetActiveUniformsiv(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), n3, MemoryUtil.memAddress(intBuffer2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetActiveUniformsi(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            IntBuffer intBuffer2 = memoryStack.ints(n3);
            GL31C.nglGetActiveUniformsiv(n2, 1, MemoryUtil.memAddress(intBuffer2), n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetActiveUniformName(int var0, int var1, int var2, long var3, long var5);

    public static void glGetActiveUniformName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        GL31C.nglGetActiveUniformName(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetActiveUniformName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(0);
            ByteBuffer byteBuffer = memoryStack.malloc(n4);
            GL31C.nglGetActiveUniformName(n2, n3, n4, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
            String string = MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
            return string;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    @NativeType(value="void")
    public static String glGetActiveUniformName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        return GL31C.glGetActiveUniformName(n2, n3, GL31C.glGetActiveUniformsi(n2, n3, 35385));
    }

    public static native int nglGetUniformBlockIndex(int var0, long var1);

    @NativeType(value="GLuint")
    public static int glGetUniformBlockIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return GL31C.nglGetUniformBlockIndex(n2, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLuint")
    public static int glGetUniformBlockIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n4 = GL31C.nglGetUniformBlockIndex(n2, l2);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nglGetActiveUniformBlockiv(int var0, int var1, int var2, long var3);

    public static void glGetActiveUniformBlockiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL31C.nglGetActiveUniformBlockiv(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetActiveUniformBlocki(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL31C.nglGetActiveUniformBlockiv(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nglGetActiveUniformBlockName(int var0, int var1, int var2, long var3, long var5);

    public static void glGetActiveUniformBlockName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        GL31C.nglGetActiveUniformBlockName(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetActiveUniformBlockName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(0);
            ByteBuffer byteBuffer = memoryStack.malloc(n4);
            GL31C.nglGetActiveUniformBlockName(n2, n3, n4, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
            String string = MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
            return string;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    @NativeType(value="void")
    public static String glGetActiveUniformBlockName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        return GL31C.glGetActiveUniformBlockName(n2, n3, GL31C.glGetActiveUniformBlocki(n2, n3, 35393));
    }

    public static native void glUniformBlockBinding(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static void glGetUniformIndices(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const **") PointerBuffer pointerBuffer, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGetUniformIndices;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, pointerBuffer.remaining());
        }
        JNI.callPPV(n2, pointerBuffer.remaining(), MemoryUtil.memAddress(pointerBuffer), nArray, l2);
    }

    public static void glGetActiveUniformsiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray2) {
        long l2 = GL.getICD().glGetActiveUniformsiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray2, nArray.length);
        }
        JNI.callPPV(n2, nArray.length, nArray, n3, nArray2, l2);
    }

    public static void glGetActiveUniformName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetActiveUniformName;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
        }
        JNI.callPPV(n2, n3, byteBuffer.remaining(), nArray, MemoryUtil.memAddress(byteBuffer), l2);
    }

    public static void glGetActiveUniformBlockiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetActiveUniformBlockiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetActiveUniformBlockName(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetActiveUniformBlockName;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
        }
        JNI.callPPV(n2, n3, byteBuffer.remaining(), nArray, MemoryUtil.memAddress(byteBuffer), l2);
    }

    static {
        GL.initialize();
    }
}

