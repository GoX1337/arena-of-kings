/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL32C;
import org.lwjgl.system.NativeType;

public class ARBTextureMultisample {
    public static final int GL_SAMPLE_POSITION = 36432;
    public static final int GL_SAMPLE_MASK = 36433;
    public static final int GL_SAMPLE_MASK_VALUE = 36434;
    public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 37121;
    public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 37123;
    public static final int GL_MAX_SAMPLE_MASK_WORDS = 36441;
    public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 37134;
    public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 37135;
    public static final int GL_MAX_INTEGER_SAMPLES = 37136;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 37124;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125;
    public static final int GL_TEXTURE_SAMPLES = 37126;
    public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 37127;
    public static final int GL_SAMPLER_2D_MULTISAMPLE = 37128;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 37129;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 37130;
    public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133;

    protected ARBTextureMultisample() {
        throw new UnsupportedOperationException();
    }

    public static void glTexImage2DMultisample(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLboolean") boolean bl2) {
        GL32C.glTexImage2DMultisample(n2, n3, n4, n5, n6, bl2);
    }

    public static void glTexImage3DMultisample(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLboolean") boolean bl2) {
        GL32C.glTexImage3DMultisample(n2, n3, n4, n5, n6, n7, bl2);
    }

    public static void nglGetMultisamplefv(int n2, int n3, long l2) {
        GL32C.nglGetMultisamplefv(n2, n3, l2);
    }

    public static void glGetMultisamplefv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL32C.glGetMultisamplefv(n2, n3, floatBuffer);
    }

    @NativeType(value="void")
    public static float glGetMultisamplef(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        return GL32C.glGetMultisamplef(n2, n3);
    }

    public static void glSampleMaski(@NativeType(value="GLuint") int n2, @NativeType(value="GLbitfield") int n3) {
        GL32C.glSampleMaski(n2, n3);
    }

    public static void glGetMultisamplefv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        GL32C.glGetMultisamplefv(n2, n3, fArray);
    }

    static {
        GL.initialize();
    }
}

