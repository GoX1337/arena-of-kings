/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBTextureCompression {
    public static final int GL_COMPRESSED_ALPHA_ARB = 34025;
    public static final int GL_COMPRESSED_LUMINANCE_ARB = 34026;
    public static final int GL_COMPRESSED_LUMINANCE_ALPHA_ARB = 34027;
    public static final int GL_COMPRESSED_INTENSITY_ARB = 34028;
    public static final int GL_COMPRESSED_RGB_ARB = 34029;
    public static final int GL_COMPRESSED_RGBA_ARB = 34030;
    public static final int GL_TEXTURE_COMPRESSION_HINT_ARB = 34031;
    public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE_ARB = 34464;
    public static final int GL_TEXTURE_COMPRESSED_ARB = 34465;
    public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS_ARB = 34466;
    public static final int GL_COMPRESSED_TEXTURE_FORMATS_ARB = 34467;

    protected ARBTextureCompression() {
        throw new UnsupportedOperationException();
    }

    public static native void nglCompressedTexImage3DARB(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glCompressedTexImage3DARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLint") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void const *") long l2) {
        ARBTextureCompression.nglCompressedTexImage3DARB(n2, n3, n4, n5, n6, n7, n8, n9, l2);
    }

    public static void glCompressedTexImage3DARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        ARBTextureCompression.nglCompressedTexImage3DARB(n2, n3, n4, n5, n6, n7, 0, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglCompressedTexImage2DARB(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glCompressedTexImage2DARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLint") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="void const *") long l2) {
        ARBTextureCompression.nglCompressedTexImage2DARB(n2, n3, n4, n5, n6, n7, n8, l2);
    }

    public static void glCompressedTexImage2DARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        ARBTextureCompression.nglCompressedTexImage2DARB(n2, n3, n4, n5, n6, 0, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglCompressedTexImage1DARB(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glCompressedTexImage1DARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="void const *") long l2) {
        ARBTextureCompression.nglCompressedTexImage1DARB(n2, n3, n4, n5, n6, n7, l2);
    }

    public static void glCompressedTexImage1DARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        ARBTextureCompression.nglCompressedTexImage1DARB(n2, n3, n4, n5, 0, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglCompressedTexSubImage3DARB(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glCompressedTexSubImage3DARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLsizei") int n11, @NativeType(value="void const *") long l2) {
        ARBTextureCompression.nglCompressedTexSubImage3DARB(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, l2);
    }

    public static void glCompressedTexSubImage3DARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        ARBTextureCompression.nglCompressedTexSubImage3DARB(n2, n3, n4, n5, n6, n7, n8, n9, n10, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglCompressedTexSubImage2DARB(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glCompressedTexSubImage2DARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="void const *") long l2) {
        ARBTextureCompression.nglCompressedTexSubImage2DARB(n2, n3, n4, n5, n6, n7, n8, n9, l2);
    }

    public static void glCompressedTexSubImage2DARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLenum") int n8, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        ARBTextureCompression.nglCompressedTexSubImage2DARB(n2, n3, n4, n5, n6, n7, n8, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglCompressedTexSubImage1DARB(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glCompressedTexSubImage1DARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="void const *") long l2) {
        ARBTextureCompression.nglCompressedTexSubImage1DARB(n2, n3, n4, n5, n6, n7, l2);
    }

    public static void glCompressedTexSubImage1DARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        ARBTextureCompression.nglCompressedTexSubImage1DARB(n2, n3, n4, n5, n6, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetCompressedTexImageARB(int var0, int var1, long var2);

    public static void glGetCompressedTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="void *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)byteBuffer, GL11.glGetTexLevelParameteri(n2, n3, 34464));
        }
        ARBTextureCompression.nglGetCompressedTexImageARB(n2, n3, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetCompressedTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="void *") long l2) {
        ARBTextureCompression.nglGetCompressedTexImageARB(n2, n3, l2);
    }

    static {
        GL.initialize();
    }
}

