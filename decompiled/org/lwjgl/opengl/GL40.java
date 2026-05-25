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
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.GL40C;
import org.lwjgl.system.NativeType;

public class GL40
extends GL33 {
    public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
    public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;
    public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 34943;
    public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 36442;
    public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET = 36443;
    public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET = 36444;
    public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS = 36445;
    public static final int GL_DOUBLE_VEC2 = 36860;
    public static final int GL_DOUBLE_VEC3 = 36861;
    public static final int GL_DOUBLE_VEC4 = 36862;
    public static final int GL_DOUBLE_MAT2 = 36678;
    public static final int GL_DOUBLE_MAT3 = 36679;
    public static final int GL_DOUBLE_MAT4 = 36680;
    public static final int GL_DOUBLE_MAT2x3 = 36681;
    public static final int GL_DOUBLE_MAT2x4 = 36682;
    public static final int GL_DOUBLE_MAT3x2 = 36683;
    public static final int GL_DOUBLE_MAT3x4 = 36684;
    public static final int GL_DOUBLE_MAT4x2 = 36685;
    public static final int GL_DOUBLE_MAT4x3 = 36686;
    public static final int GL_SAMPLE_SHADING = 35894;
    public static final int GL_MIN_SAMPLE_SHADING_VALUE = 35895;
    public static final int GL_ACTIVE_SUBROUTINES = 36325;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423;
    public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425;
    public static final int GL_MAX_SUBROUTINES = 36327;
    public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328;
    public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426;
    public static final int GL_COMPATIBLE_SUBROUTINES = 36427;
    public static final int GL_PATCHES = 14;
    public static final int GL_PATCH_VERTICES = 36466;
    public static final int GL_PATCH_DEFAULT_INNER_LEVEL = 36467;
    public static final int GL_PATCH_DEFAULT_OUTER_LEVEL = 36468;
    public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 36469;
    public static final int GL_TESS_GEN_MODE = 36470;
    public static final int GL_TESS_GEN_SPACING = 36471;
    public static final int GL_TESS_GEN_VERTEX_ORDER = 36472;
    public static final int GL_TESS_GEN_POINT_MODE = 36473;
    public static final int GL_ISOLINES = 36474;
    public static final int GL_FRACTIONAL_ODD = 36475;
    public static final int GL_FRACTIONAL_EVEN = 36476;
    public static final int GL_MAX_PATCH_VERTICES = 36477;
    public static final int GL_MAX_TESS_GEN_LEVEL = 36478;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 36479;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 36480;
    public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 36481;
    public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 36482;
    public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 36483;
    public static final int GL_MAX_TESS_PATCH_COMPONENTS = 36484;
    public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 36485;
    public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 36486;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 36489;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 36490;
    public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 34924;
    public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 34925;
    public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 36382;
    public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 36383;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER = 34032;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER = 34033;
    public static final int GL_TESS_EVALUATION_SHADER = 36487;
    public static final int GL_TESS_CONTROL_SHADER = 36488;
    public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 36873;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 36874;
    public static final int GL_PROXY_TEXTURE_CUBE_MAP_ARRAY = 36875;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY = 36876;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW = 36877;
    public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY = 36878;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY = 36879;
    public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET = 36446;
    public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET = 36447;
    public static final int GL_TRANSFORM_FEEDBACK = 36386;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464;
    public static final int GL_MAX_VERTEX_STREAMS = 36465;

    protected GL40() {
        throw new UnsupportedOperationException();
    }

    public static void glBlendEquationi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        GL40C.glBlendEquationi(n2, n3);
    }

    public static void glBlendEquationSeparatei(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        GL40C.glBlendEquationSeparatei(n2, n3, n4);
    }

    public static void glBlendFunci(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        GL40C.glBlendFunci(n2, n3, n4);
    }

    public static void glBlendFuncSeparatei(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLenum") int n6) {
        GL40C.glBlendFuncSeparatei(n2, n3, n4, n5, n6);
    }

    public static void nglDrawArraysIndirect(int n2, long l2) {
        GL40C.nglDrawArraysIndirect(n2, l2);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL40C.glDrawArraysIndirect(n2, byteBuffer);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") long l2) {
        GL40C.glDrawArraysIndirect(n2, l2);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL40C.glDrawArraysIndirect(n2, intBuffer);
    }

    public static void nglDrawElementsIndirect(int n2, int n3, long l2) {
        GL40C.nglDrawElementsIndirect(n2, n3, l2);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL40C.glDrawElementsIndirect(n2, n3, byteBuffer);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") long l2) {
        GL40C.glDrawElementsIndirect(n2, n3, l2);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL40C.glDrawElementsIndirect(n2, n3, intBuffer);
    }

    public static void glUniform1d(@NativeType(value="GLint") int n2, @NativeType(value="GLdouble") double d2) {
        GL40C.glUniform1d(n2, d2);
    }

    public static void glUniform2d(@NativeType(value="GLint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3) {
        GL40C.glUniform2d(n2, d2, d3);
    }

    public static void glUniform3d(@NativeType(value="GLint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3, @NativeType(value="GLdouble") double d4) {
        GL40C.glUniform3d(n2, d2, d3, d4);
    }

    public static void glUniform4d(@NativeType(value="GLint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3, @NativeType(value="GLdouble") double d4, @NativeType(value="GLdouble") double d5) {
        GL40C.glUniform4d(n2, d2, d3, d4, d5);
    }

    public static void nglUniform1dv(int n2, int n3, long l2) {
        GL40C.nglUniform1dv(n2, n3, l2);
    }

    public static void glUniform1dv(@NativeType(value="GLint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniform1dv(n2, doubleBuffer);
    }

    public static void nglUniform2dv(int n2, int n3, long l2) {
        GL40C.nglUniform2dv(n2, n3, l2);
    }

    public static void glUniform2dv(@NativeType(value="GLint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniform2dv(n2, doubleBuffer);
    }

    public static void nglUniform3dv(int n2, int n3, long l2) {
        GL40C.nglUniform3dv(n2, n3, l2);
    }

    public static void glUniform3dv(@NativeType(value="GLint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniform3dv(n2, doubleBuffer);
    }

    public static void nglUniform4dv(int n2, int n3, long l2) {
        GL40C.nglUniform4dv(n2, n3, l2);
    }

    public static void glUniform4dv(@NativeType(value="GLint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniform4dv(n2, doubleBuffer);
    }

    public static void nglUniformMatrix2dv(int n2, int n3, boolean bl2, long l2) {
        GL40C.nglUniformMatrix2dv(n2, n3, bl2, l2);
    }

    public static void glUniformMatrix2dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniformMatrix2dv(n2, bl2, doubleBuffer);
    }

    public static void nglUniformMatrix3dv(int n2, int n3, boolean bl2, long l2) {
        GL40C.nglUniformMatrix3dv(n2, n3, bl2, l2);
    }

    public static void glUniformMatrix3dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniformMatrix3dv(n2, bl2, doubleBuffer);
    }

    public static void nglUniformMatrix4dv(int n2, int n3, boolean bl2, long l2) {
        GL40C.nglUniformMatrix4dv(n2, n3, bl2, l2);
    }

    public static void glUniformMatrix4dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniformMatrix4dv(n2, bl2, doubleBuffer);
    }

    public static void nglUniformMatrix2x3dv(int n2, int n3, boolean bl2, long l2) {
        GL40C.nglUniformMatrix2x3dv(n2, n3, bl2, l2);
    }

    public static void glUniformMatrix2x3dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniformMatrix2x3dv(n2, bl2, doubleBuffer);
    }

    public static void nglUniformMatrix2x4dv(int n2, int n3, boolean bl2, long l2) {
        GL40C.nglUniformMatrix2x4dv(n2, n3, bl2, l2);
    }

    public static void glUniformMatrix2x4dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniformMatrix2x4dv(n2, bl2, doubleBuffer);
    }

    public static void nglUniformMatrix3x2dv(int n2, int n3, boolean bl2, long l2) {
        GL40C.nglUniformMatrix3x2dv(n2, n3, bl2, l2);
    }

    public static void glUniformMatrix3x2dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniformMatrix3x2dv(n2, bl2, doubleBuffer);
    }

    public static void nglUniformMatrix3x4dv(int n2, int n3, boolean bl2, long l2) {
        GL40C.nglUniformMatrix3x4dv(n2, n3, bl2, l2);
    }

    public static void glUniformMatrix3x4dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniformMatrix3x4dv(n2, bl2, doubleBuffer);
    }

    public static void nglUniformMatrix4x2dv(int n2, int n3, boolean bl2, long l2) {
        GL40C.nglUniformMatrix4x2dv(n2, n3, bl2, l2);
    }

    public static void glUniformMatrix4x2dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniformMatrix4x2dv(n2, bl2, doubleBuffer);
    }

    public static void nglUniformMatrix4x3dv(int n2, int n3, boolean bl2, long l2) {
        GL40C.nglUniformMatrix4x3dv(n2, n3, bl2, l2);
    }

    public static void glUniformMatrix4x3dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL40C.glUniformMatrix4x3dv(n2, bl2, doubleBuffer);
    }

    public static void nglGetUniformdv(int n2, int n3, long l2) {
        GL40C.nglGetUniformdv(n2, n3, l2);
    }

    public static void glGetUniformdv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        GL40C.glGetUniformdv(n2, n3, doubleBuffer);
    }

    @NativeType(value="void")
    public static double glGetUniformd(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        return GL40C.glGetUniformd(n2, n3);
    }

    public static void glMinSampleShading(@NativeType(value="GLfloat") float f2) {
        GL40C.glMinSampleShading(f2);
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
        return GL40.glGetActiveSubroutineUniformName(n2, n3, n4, GL40.glGetActiveSubroutineUniformi(n2, n3, n4, 35385));
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
        return GL40.glGetActiveSubroutineName(n2, n3, n4, GL40.glGetProgramStagei(n2, n3, 36424));
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

    public static void glPatchParameteri(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3) {
        GL40C.glPatchParameteri(n2, n3);
    }

    public static void nglPatchParameterfv(int n2, long l2) {
        GL40C.nglPatchParameterfv(n2, l2);
    }

    public static void glPatchParameterfv(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL40C.glPatchParameterfv(n2, floatBuffer);
    }

    public static void glBindTransformFeedback(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL40C.glBindTransformFeedback(n2, n3);
    }

    public static void nglDeleteTransformFeedbacks(int n2, long l2) {
        GL40C.nglDeleteTransformFeedbacks(n2, l2);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL40C.glDeleteTransformFeedbacks(intBuffer);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") int n2) {
        GL40C.glDeleteTransformFeedbacks(n2);
    }

    public static void nglGenTransformFeedbacks(int n2, long l2) {
        GL40C.nglGenTransformFeedbacks(n2, l2);
    }

    public static void glGenTransformFeedbacks(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL40C.glGenTransformFeedbacks(intBuffer);
    }

    @NativeType(value="void")
    public static int glGenTransformFeedbacks() {
        return GL40C.glGenTransformFeedbacks();
    }

    @NativeType(value="GLboolean")
    public static boolean glIsTransformFeedback(@NativeType(value="GLuint") int n2) {
        return GL40C.glIsTransformFeedback(n2);
    }

    public static void glPauseTransformFeedback() {
        GL40C.glPauseTransformFeedback();
    }

    public static void glResumeTransformFeedback() {
        GL40C.glResumeTransformFeedback();
    }

    public static void glDrawTransformFeedback(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL40C.glDrawTransformFeedback(n2, n3);
    }

    public static void glDrawTransformFeedbackStream(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4) {
        GL40C.glDrawTransformFeedbackStream(n2, n3, n4);
    }

    public static void glBeginQueryIndexed(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4) {
        GL40C.glBeginQueryIndexed(n2, n3, n4);
    }

    public static void glEndQueryIndexed(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL40C.glEndQueryIndexed(n2, n3);
    }

    public static void nglGetQueryIndexediv(int n2, int n3, int n4, long l2) {
        GL40C.nglGetQueryIndexediv(n2, n3, n4, l2);
    }

    public static void glGetQueryIndexediv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL40C.glGetQueryIndexediv(n2, n3, n4, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetQueryIndexedi(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        return GL40C.glGetQueryIndexedi(n2, n3, n4);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") int[] nArray) {
        GL40C.glDrawArraysIndirect(n2, nArray);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") int[] nArray) {
        GL40C.glDrawElementsIndirect(n2, n3, nArray);
    }

    public static void glUniform1dv(@NativeType(value="GLint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniform1dv(n2, dArray);
    }

    public static void glUniform2dv(@NativeType(value="GLint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniform2dv(n2, dArray);
    }

    public static void glUniform3dv(@NativeType(value="GLint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniform3dv(n2, dArray);
    }

    public static void glUniform4dv(@NativeType(value="GLint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniform4dv(n2, dArray);
    }

    public static void glUniformMatrix2dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniformMatrix2dv(n2, bl2, dArray);
    }

    public static void glUniformMatrix3dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniformMatrix3dv(n2, bl2, dArray);
    }

    public static void glUniformMatrix4dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniformMatrix4dv(n2, bl2, dArray);
    }

    public static void glUniformMatrix2x3dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniformMatrix2x3dv(n2, bl2, dArray);
    }

    public static void glUniformMatrix2x4dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniformMatrix2x4dv(n2, bl2, dArray);
    }

    public static void glUniformMatrix3x2dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniformMatrix3x2dv(n2, bl2, dArray);
    }

    public static void glUniformMatrix3x4dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniformMatrix3x4dv(n2, bl2, dArray);
    }

    public static void glUniformMatrix4x2dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniformMatrix4x2dv(n2, bl2, dArray);
    }

    public static void glUniformMatrix4x3dv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL40C.glUniformMatrix4x3dv(n2, bl2, dArray);
    }

    public static void glGetUniformdv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        GL40C.glGetUniformdv(n2, n3, dArray);
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

    public static void glPatchParameterfv(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL40C.glPatchParameterfv(n2, fArray);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") int[] nArray) {
        GL40C.glDeleteTransformFeedbacks(nArray);
    }

    public static void glGenTransformFeedbacks(@NativeType(value="GLuint *") int[] nArray) {
        GL40C.glGenTransformFeedbacks(nArray);
    }

    public static void glGetQueryIndexediv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        GL40C.glGetQueryIndexediv(n2, n3, n4, nArray);
    }

    static {
        GL.initialize();
    }
}

