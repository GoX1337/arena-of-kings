/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL33
extends GL32 {
    public static final int GL_SRC1_COLOR = 35065;
    public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
    public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
    public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;
    public static final int GL_ANY_SAMPLES_PASSED = 35887;
    public static final int GL_SAMPLER_BINDING = 35097;
    public static final int GL_RGB10_A2UI = 36975;
    public static final int GL_TEXTURE_SWIZZLE_R = 36418;
    public static final int GL_TEXTURE_SWIZZLE_G = 36419;
    public static final int GL_TEXTURE_SWIZZLE_B = 36420;
    public static final int GL_TEXTURE_SWIZZLE_A = 36421;
    public static final int GL_TEXTURE_SWIZZLE_RGBA = 36422;
    public static final int GL_TIME_ELAPSED = 35007;
    public static final int GL_TIMESTAMP = 36392;
    public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR = 35070;
    public static final int GL_INT_2_10_10_10_REV = 36255;

    protected GL33() {
        throw new UnsupportedOperationException();
    }

    public static void nglBindFragDataLocationIndexed(int n2, int n3, int n4, long l2) {
        GL33C.nglBindFragDataLocationIndexed(n2, n3, n4, l2);
    }

    public static void glBindFragDataLocationIndexed(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        GL33C.glBindFragDataLocationIndexed(n2, n3, n4, byteBuffer);
    }

    public static void glBindFragDataLocationIndexed(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLchar const *") CharSequence charSequence) {
        GL33C.glBindFragDataLocationIndexed(n2, n3, n4, charSequence);
    }

    public static int nglGetFragDataIndex(int n2, long l2) {
        return GL33C.nglGetFragDataIndex(n2, l2);
    }

    @NativeType(value="GLint")
    public static int glGetFragDataIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        return GL33C.glGetFragDataIndex(n2, byteBuffer);
    }

    @NativeType(value="GLint")
    public static int glGetFragDataIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        return GL33C.glGetFragDataIndex(n2, charSequence);
    }

    public static void nglGenSamplers(int n2, long l2) {
        GL33C.nglGenSamplers(n2, l2);
    }

    public static void glGenSamplers(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL33C.glGenSamplers(intBuffer);
    }

    @NativeType(value="void")
    public static int glGenSamplers() {
        return GL33C.glGenSamplers();
    }

    public static void nglDeleteSamplers(int n2, long l2) {
        GL33C.nglDeleteSamplers(n2, l2);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.glDeleteSamplers(intBuffer);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") int n2) {
        GL33C.glDeleteSamplers(n2);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsSampler(@NativeType(value="GLuint") int n2) {
        return GL33C.glIsSampler(n2);
    }

    public static void glBindSampler(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        GL33C.glBindSampler(n2, n3);
    }

    public static void glSamplerParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4) {
        GL33C.glSamplerParameteri(n2, n3, n4);
    }

    public static void glSamplerParameterf(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat") float f2) {
        GL33C.glSamplerParameterf(n2, n3, f2);
    }

    public static void nglSamplerParameteriv(int n2, int n3, long l2) {
        GL33C.nglSamplerParameteriv(n2, n3, l2);
    }

    public static void glSamplerParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL33C.glSamplerParameteriv(n2, n3, intBuffer);
    }

    public static void nglSamplerParameterfv(int n2, int n3, long l2) {
        GL33C.nglSamplerParameterfv(n2, n3, l2);
    }

    public static void glSamplerParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL33C.glSamplerParameterfv(n2, n3, floatBuffer);
    }

    public static void nglSamplerParameterIiv(int n2, int n3, long l2) {
        GL33C.nglSamplerParameterIiv(n2, n3, l2);
    }

    public static void glSamplerParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL33C.glSamplerParameterIiv(n2, n3, intBuffer);
    }

    public static void nglSamplerParameterIuiv(int n2, int n3, long l2) {
        GL33C.nglSamplerParameterIuiv(n2, n3, l2);
    }

    public static void glSamplerParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.glSamplerParameterIuiv(n2, n3, intBuffer);
    }

    public static void nglGetSamplerParameteriv(int n2, int n3, long l2) {
        GL33C.nglGetSamplerParameteriv(n2, n3, l2);
    }

    public static void glGetSamplerParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL33C.glGetSamplerParameteriv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetSamplerParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL33C.glGetSamplerParameteri(n2, n3);
    }

    public static void nglGetSamplerParameterfv(int n2, int n3, long l2) {
        GL33C.nglGetSamplerParameterfv(n2, n3, l2);
    }

    public static void glGetSamplerParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL33C.glGetSamplerParameterfv(n2, n3, floatBuffer);
    }

    @NativeType(value="void")
    public static float glGetSamplerParameterf(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL33C.glGetSamplerParameterf(n2, n3);
    }

    public static void nglGetSamplerParameterIiv(int n2, int n3, long l2) {
        GL33C.nglGetSamplerParameterIiv(n2, n3, l2);
    }

    public static void glGetSamplerParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL33C.glGetSamplerParameterIiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetSamplerParameterIi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL33C.glGetSamplerParameterIi(n2, n3);
    }

    public static void nglGetSamplerParameterIuiv(int n2, int n3, long l2) {
        GL33C.nglGetSamplerParameterIuiv(n2, n3, l2);
    }

    public static void glGetSamplerParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL33C.glGetSamplerParameterIuiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetSamplerParameterIui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL33C.glGetSamplerParameterIui(n2, n3);
    }

    public static void glQueryCounter(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        GL33C.glQueryCounter(n2, n3);
    }

    public static void nglGetQueryObjecti64v(int n2, int n3, long l2) {
        GL33C.nglGetQueryObjecti64v(n2, n3, l2);
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        GL33C.glGetQueryObjecti64v(n2, n3, longBuffer);
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") long l2) {
        GL33C.glGetQueryObjecti64v(n2, n3, l2);
    }

    @NativeType(value="void")
    public static long glGetQueryObjecti64(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL33C.glGetQueryObjecti64(n2, n3);
    }

    public static void nglGetQueryObjectui64v(int n2, int n3, long l2) {
        GL33C.nglGetQueryObjectui64v(n2, n3, l2);
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64 *") LongBuffer longBuffer) {
        GL33C.glGetQueryObjectui64v(n2, n3, longBuffer);
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64 *") long l2) {
        GL33C.glGetQueryObjectui64v(n2, n3, l2);
    }

    @NativeType(value="void")
    public static long glGetQueryObjectui64(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL33C.glGetQueryObjectui64(n2, n3);
    }

    public static void glVertexAttribDivisor(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        GL33C.glVertexAttribDivisor(n2, n3);
    }

    public static native void glVertexP2ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexP3ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexP4ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglVertexP2uiv(int var0, long var1);

    public static void glVertexP2uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglVertexP2uiv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglVertexP3uiv(int var0, long var1);

    public static void glVertexP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglVertexP3uiv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglVertexP4uiv(int var0, long var1);

    public static void glVertexP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglVertexP4uiv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glTexCoordP1ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glTexCoordP2ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glTexCoordP3ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glTexCoordP4ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglTexCoordP1uiv(int var0, long var1);

    public static void glTexCoordP1uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglTexCoordP1uiv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglTexCoordP2uiv(int var0, long var1);

    public static void glTexCoordP2uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglTexCoordP2uiv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglTexCoordP3uiv(int var0, long var1);

    public static void glTexCoordP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglTexCoordP3uiv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglTexCoordP4uiv(int var0, long var1);

    public static void glTexCoordP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglTexCoordP4uiv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glMultiTexCoordP1ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glMultiTexCoordP2ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glMultiTexCoordP3ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glMultiTexCoordP4ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void nglMultiTexCoordP1uiv(int var0, int var1, long var2);

    public static void glMultiTexCoordP1uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglMultiTexCoordP1uiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglMultiTexCoordP2uiv(int var0, int var1, long var2);

    public static void glMultiTexCoordP2uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglMultiTexCoordP2uiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglMultiTexCoordP3uiv(int var0, int var1, long var2);

    public static void glMultiTexCoordP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglMultiTexCoordP3uiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglMultiTexCoordP4uiv(int var0, int var1, long var2);

    public static void glMultiTexCoordP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglMultiTexCoordP4uiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glNormalP3ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglNormalP3uiv(int var0, long var1);

    public static void glNormalP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglNormalP3uiv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glColorP3ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glColorP4ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglColorP3uiv(int var0, long var1);

    public static void glColorP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglColorP3uiv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglColorP4uiv(int var0, long var1);

    public static void glColorP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglColorP4uiv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glSecondaryColorP3ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglSecondaryColorP3uiv(int var0, long var1);

    public static void glSecondaryColorP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33.nglSecondaryColorP3uiv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glVertexAttribP1ui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint") int n4) {
        GL33C.glVertexAttribP1ui(n2, n3, bl2, n4);
    }

    public static void glVertexAttribP2ui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint") int n4) {
        GL33C.glVertexAttribP2ui(n2, n3, bl2, n4);
    }

    public static void glVertexAttribP3ui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint") int n4) {
        GL33C.glVertexAttribP3ui(n2, n3, bl2, n4);
    }

    public static void glVertexAttribP4ui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint") int n4) {
        GL33C.glVertexAttribP4ui(n2, n3, bl2, n4);
    }

    public static void nglVertexAttribP1uiv(int n2, int n3, boolean bl2, long l2) {
        GL33C.nglVertexAttribP1uiv(n2, n3, bl2, l2);
    }

    public static void glVertexAttribP1uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.glVertexAttribP1uiv(n2, n3, bl2, intBuffer);
    }

    public static void nglVertexAttribP2uiv(int n2, int n3, boolean bl2, long l2) {
        GL33C.nglVertexAttribP2uiv(n2, n3, bl2, l2);
    }

    public static void glVertexAttribP2uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.glVertexAttribP2uiv(n2, n3, bl2, intBuffer);
    }

    public static void nglVertexAttribP3uiv(int n2, int n3, boolean bl2, long l2) {
        GL33C.nglVertexAttribP3uiv(n2, n3, bl2, l2);
    }

    public static void glVertexAttribP3uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.glVertexAttribP3uiv(n2, n3, bl2, intBuffer);
    }

    public static void nglVertexAttribP4uiv(int n2, int n3, boolean bl2, long l2) {
        GL33C.nglVertexAttribP4uiv(n2, n3, bl2, l2);
    }

    public static void glVertexAttribP4uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.glVertexAttribP4uiv(n2, n3, bl2, intBuffer);
    }

    public static void glGenSamplers(@NativeType(value="GLuint *") int[] nArray) {
        GL33C.glGenSamplers(nArray);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") int[] nArray) {
        GL33C.glDeleteSamplers(nArray);
    }

    public static void glSamplerParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int[] nArray) {
        GL33C.glSamplerParameteriv(n2, n3, nArray);
    }

    public static void glSamplerParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        GL33C.glSamplerParameterfv(n2, n3, fArray);
    }

    public static void glSamplerParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int[] nArray) {
        GL33C.glSamplerParameterIiv(n2, n3, nArray);
    }

    public static void glSamplerParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        GL33C.glSamplerParameterIuiv(n2, n3, nArray);
    }

    public static void glGetSamplerParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL33C.glGetSamplerParameteriv(n2, n3, nArray);
    }

    public static void glGetSamplerParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        GL33C.glGetSamplerParameterfv(n2, n3, fArray);
    }

    public static void glGetSamplerParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL33C.glGetSamplerParameterIiv(n2, n3, nArray);
    }

    public static void glGetSamplerParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") int[] nArray) {
        GL33C.glGetSamplerParameterIuiv(n2, n3, nArray);
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") long[] lArray) {
        GL33C.glGetQueryObjecti64v(n2, n3, lArray);
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64 *") long[] lArray) {
        GL33C.glGetQueryObjectui64v(n2, n3, lArray);
    }

    public static void glVertexP2uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glVertexP2uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, nArray, l2);
    }

    public static void glVertexP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glVertexP3uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, nArray, l2);
    }

    public static void glVertexP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glVertexP4uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, nArray, l2);
    }

    public static void glTexCoordP1uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glTexCoordP1uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, nArray, l2);
    }

    public static void glTexCoordP2uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glTexCoordP2uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, nArray, l2);
    }

    public static void glTexCoordP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glTexCoordP3uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, nArray, l2);
    }

    public static void glTexCoordP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glTexCoordP4uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, nArray, l2);
    }

    public static void glMultiTexCoordP1uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexCoordP1uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glMultiTexCoordP2uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexCoordP2uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glMultiTexCoordP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexCoordP3uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glMultiTexCoordP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glMultiTexCoordP4uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glNormalP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glNormalP3uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, nArray, l2);
    }

    public static void glColorP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glColorP3uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, nArray, l2);
    }

    public static void glColorP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glColorP4uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, nArray, l2);
    }

    public static void glSecondaryColorP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glSecondaryColorP3uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, nArray, l2);
    }

    public static void glVertexAttribP1uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33C.glVertexAttribP1uiv(n2, n3, bl2, nArray);
    }

    public static void glVertexAttribP2uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33C.glVertexAttribP2uiv(n2, n3, bl2, nArray);
    }

    public static void glVertexAttribP3uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33C.glVertexAttribP3uiv(n2, n3, bl2, nArray);
    }

    public static void glVertexAttribP4uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33C.glVertexAttribP4uiv(n2, n3, bl2, nArray);
    }

    static {
        GL.initialize();
    }
}

