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
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GL41C;
import org.lwjgl.system.NativeType;

public class GL41
extends GL40 {
    public static final int GL_SHADER_COMPILER = 36346;
    public static final int GL_SHADER_BINARY_FORMATS = 36344;
    public static final int GL_NUM_SHADER_BINARY_FORMATS = 36345;
    public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 36347;
    public static final int GL_MAX_VARYING_VECTORS = 36348;
    public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 36349;
    public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 35738;
    public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 35739;
    public static final int GL_FIXED = 5132;
    public static final int GL_LOW_FLOAT = 36336;
    public static final int GL_MEDIUM_FLOAT = 36337;
    public static final int GL_HIGH_FLOAT = 36338;
    public static final int GL_LOW_INT = 36339;
    public static final int GL_MEDIUM_INT = 36340;
    public static final int GL_HIGH_INT = 36341;
    public static final int GL_RGB565 = 36194;
    public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367;
    public static final int GL_PROGRAM_BINARY_LENGTH = 34625;
    public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814;
    public static final int GL_PROGRAM_BINARY_FORMATS = 34815;
    public static final int GL_VERTEX_SHADER_BIT = 1;
    public static final int GL_FRAGMENT_SHADER_BIT = 2;
    public static final int GL_GEOMETRY_SHADER_BIT = 4;
    public static final int GL_TESS_CONTROL_SHADER_BIT = 8;
    public static final int GL_TESS_EVALUATION_SHADER_BIT = 16;
    public static final int GL_ALL_SHADER_BITS = -1;
    public static final int GL_PROGRAM_SEPARABLE = 33368;
    public static final int GL_ACTIVE_PROGRAM = 33369;
    public static final int GL_PROGRAM_PIPELINE_BINDING = 33370;
    public static final int GL_MAX_VIEWPORTS = 33371;
    public static final int GL_VIEWPORT_SUBPIXEL_BITS = 33372;
    public static final int GL_VIEWPORT_BOUNDS_RANGE = 33373;
    public static final int GL_LAYER_PROVOKING_VERTEX = 33374;
    public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 33375;
    public static final int GL_UNDEFINED_VERTEX = 33376;

    protected GL41() {
        throw new UnsupportedOperationException();
    }

    public static void glReleaseShaderCompiler() {
        GL41C.glReleaseShaderCompiler();
    }

    public static void nglShaderBinary(int n2, long l2, int n3, long l3, int n4) {
        GL41C.nglShaderBinary(n2, l2, n3, l3, n4);
    }

    public static void glShaderBinary(@NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL41C.glShaderBinary(intBuffer, n2, byteBuffer);
    }

    public static void nglGetShaderPrecisionFormat(int n2, int n3, long l2, long l3) {
        GL41C.nglGetShaderPrecisionFormat(n2, n3, l2, l3);
    }

    public static void glGetShaderPrecisionFormat(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLint *") IntBuffer intBuffer2) {
        GL41C.glGetShaderPrecisionFormat(n2, n3, intBuffer, intBuffer2);
    }

    @NativeType(value="void")
    public static int glGetShaderPrecisionFormat(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        return GL41C.glGetShaderPrecisionFormat(n2, n3, intBuffer);
    }

    public static void glDepthRangef(@NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3) {
        GL41C.glDepthRangef(f2, f3);
    }

    public static void glClearDepthf(@NativeType(value="GLfloat") float f2) {
        GL41C.glClearDepthf(f2);
    }

    public static void nglGetProgramBinary(int n2, int n3, long l2, long l3, long l4) {
        GL41C.nglGetProgramBinary(n2, n3, l2, l3, l4);
    }

    public static void glGetProgramBinary(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLenum *") IntBuffer intBuffer2, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL41C.glGetProgramBinary(n2, intBuffer, intBuffer2, byteBuffer);
    }

    public static void nglProgramBinary(int n2, int n3, long l2, int n4) {
        GL41C.nglProgramBinary(n2, n3, l2, n4);
    }

    public static void glProgramBinary(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL41C.glProgramBinary(n2, n3, byteBuffer);
    }

    public static void glProgramParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4) {
        GL41C.glProgramParameteri(n2, n3, n4);
    }

    public static void glUseProgramStages(@NativeType(value="GLuint") int n2, @NativeType(value="GLbitfield") int n3, @NativeType(value="GLuint") int n4) {
        GL41C.glUseProgramStages(n2, n3, n4);
    }

    public static void glActiveShaderProgram(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        GL41C.glActiveShaderProgram(n2, n3);
    }

    public static int nglCreateShaderProgramv(int n2, int n3, long l2) {
        return GL41C.nglCreateShaderProgramv(n2, n3, l2);
    }

    @NativeType(value="GLuint")
    public static int glCreateShaderProgramv(@NativeType(value="GLenum") int n2, @NativeType(value="GLchar const **") PointerBuffer pointerBuffer) {
        return GL41C.glCreateShaderProgramv(n2, pointerBuffer);
    }

    @NativeType(value="GLuint")
    public static int glCreateShaderProgramv(@NativeType(value="GLenum") int n2, CharSequence ... charSequenceArray) {
        return GL41C.glCreateShaderProgramv(n2, charSequenceArray);
    }

    @NativeType(value="GLuint")
    public static int glCreateShaderProgramv(@NativeType(value="GLenum") int n2, @NativeType(value="GLchar const **") CharSequence charSequence) {
        return GL41C.glCreateShaderProgramv(n2, charSequence);
    }

    public static void glBindProgramPipeline(@NativeType(value="GLuint") int n2) {
        GL41C.glBindProgramPipeline(n2);
    }

    public static void nglDeleteProgramPipelines(int n2, long l2) {
        GL41C.nglDeleteProgramPipelines(n2, l2);
    }

    public static void glDeleteProgramPipelines(@NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL41C.glDeleteProgramPipelines(intBuffer);
    }

    public static void glDeleteProgramPipelines(@NativeType(value="GLuint const *") int n2) {
        GL41C.glDeleteProgramPipelines(n2);
    }

    public static void nglGenProgramPipelines(int n2, long l2) {
        GL41C.nglGenProgramPipelines(n2, l2);
    }

    public static void glGenProgramPipelines(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL41C.glGenProgramPipelines(intBuffer);
    }

    @NativeType(value="void")
    public static int glGenProgramPipelines() {
        return GL41C.glGenProgramPipelines();
    }

    @NativeType(value="GLboolean")
    public static boolean glIsProgramPipeline(@NativeType(value="GLuint") int n2) {
        return GL41C.glIsProgramPipeline(n2);
    }

    public static void nglGetProgramPipelineiv(int n2, int n3, long l2) {
        GL41C.nglGetProgramPipelineiv(n2, n3, l2);
    }

    public static void glGetProgramPipelineiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL41C.glGetProgramPipelineiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetProgramPipelinei(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL41C.glGetProgramPipelinei(n2, n3);
    }

    public static void glProgramUniform1i(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4) {
        GL41C.glProgramUniform1i(n2, n3, n4);
    }

    public static void glProgramUniform2i(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5) {
        GL41C.glProgramUniform2i(n2, n3, n4, n5);
    }

    public static void glProgramUniform3i(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6) {
        GL41C.glProgramUniform3i(n2, n3, n4, n5, n6);
    }

    public static void glProgramUniform4i(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLint") int n7) {
        GL41C.glProgramUniform4i(n2, n3, n4, n5, n6, n7);
    }

    public static void glProgramUniform1ui(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint") int n4) {
        GL41C.glProgramUniform1ui(n2, n3, n4);
    }

    public static void glProgramUniform2ui(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLuint") int n5) {
        GL41C.glProgramUniform2ui(n2, n3, n4, n5);
    }

    public static void glProgramUniform3ui(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLuint") int n6) {
        GL41C.glProgramUniform3ui(n2, n3, n4, n5, n6);
    }

    public static void glProgramUniform4ui(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLuint") int n6, @NativeType(value="GLuint") int n7) {
        GL41C.glProgramUniform4ui(n2, n3, n4, n5, n6, n7);
    }

    public static void glProgramUniform1f(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat") float f2) {
        GL41C.glProgramUniform1f(n2, n3, f2);
    }

    public static void glProgramUniform2f(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3) {
        GL41C.glProgramUniform2f(n2, n3, f2, f3);
    }

    public static void glProgramUniform3f(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4) {
        GL41C.glProgramUniform3f(n2, n3, f2, f3, f4);
    }

    public static void glProgramUniform4f(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4, @NativeType(value="GLfloat") float f5) {
        GL41C.glProgramUniform4f(n2, n3, f2, f3, f4, f5);
    }

    public static void glProgramUniform1d(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble") double d2) {
        GL41C.glProgramUniform1d(n2, n3, d2);
    }

    public static void glProgramUniform2d(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3) {
        GL41C.glProgramUniform2d(n2, n3, d2, d3);
    }

    public static void glProgramUniform3d(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3, @NativeType(value="GLdouble") double d4) {
        GL41C.glProgramUniform3d(n2, n3, d2, d3, d4);
    }

    public static void glProgramUniform4d(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3, @NativeType(value="GLdouble") double d4, @NativeType(value="GLdouble") double d5) {
        GL41C.glProgramUniform4d(n2, n3, d2, d3, d4, d5);
    }

    public static void nglProgramUniform1iv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform1iv(n2, n3, n4, l2);
    }

    public static void glProgramUniform1iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL41C.glProgramUniform1iv(n2, n3, intBuffer);
    }

    public static void nglProgramUniform2iv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform2iv(n2, n3, n4, l2);
    }

    public static void glProgramUniform2iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL41C.glProgramUniform2iv(n2, n3, intBuffer);
    }

    public static void nglProgramUniform3iv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform3iv(n2, n3, n4, l2);
    }

    public static void glProgramUniform3iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL41C.glProgramUniform3iv(n2, n3, intBuffer);
    }

    public static void nglProgramUniform4iv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform4iv(n2, n3, n4, l2);
    }

    public static void glProgramUniform4iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL41C.glProgramUniform4iv(n2, n3, intBuffer);
    }

    public static void nglProgramUniform1uiv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform1uiv(n2, n3, n4, l2);
    }

    public static void glProgramUniform1uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL41C.glProgramUniform1uiv(n2, n3, intBuffer);
    }

    public static void nglProgramUniform2uiv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform2uiv(n2, n3, n4, l2);
    }

    public static void glProgramUniform2uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL41C.glProgramUniform2uiv(n2, n3, intBuffer);
    }

    public static void nglProgramUniform3uiv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform3uiv(n2, n3, n4, l2);
    }

    public static void glProgramUniform3uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL41C.glProgramUniform3uiv(n2, n3, intBuffer);
    }

    public static void nglProgramUniform4uiv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform4uiv(n2, n3, n4, l2);
    }

    public static void glProgramUniform4uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL41C.glProgramUniform4uiv(n2, n3, intBuffer);
    }

    public static void nglProgramUniform1fv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform1fv(n2, n3, n4, l2);
    }

    public static void glProgramUniform1fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniform1fv(n2, n3, floatBuffer);
    }

    public static void nglProgramUniform2fv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform2fv(n2, n3, n4, l2);
    }

    public static void glProgramUniform2fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniform2fv(n2, n3, floatBuffer);
    }

    public static void nglProgramUniform3fv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform3fv(n2, n3, n4, l2);
    }

    public static void glProgramUniform3fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniform3fv(n2, n3, floatBuffer);
    }

    public static void nglProgramUniform4fv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform4fv(n2, n3, n4, l2);
    }

    public static void glProgramUniform4fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniform4fv(n2, n3, floatBuffer);
    }

    public static void nglProgramUniform1dv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform1dv(n2, n3, n4, l2);
    }

    public static void glProgramUniform1dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniform1dv(n2, n3, doubleBuffer);
    }

    public static void nglProgramUniform2dv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform2dv(n2, n3, n4, l2);
    }

    public static void glProgramUniform2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniform2dv(n2, n3, doubleBuffer);
    }

    public static void nglProgramUniform3dv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform3dv(n2, n3, n4, l2);
    }

    public static void glProgramUniform3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniform3dv(n2, n3, doubleBuffer);
    }

    public static void nglProgramUniform4dv(int n2, int n3, int n4, long l2) {
        GL41C.nglProgramUniform4dv(n2, n3, n4, l2);
    }

    public static void glProgramUniform4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniform4dv(n2, n3, doubleBuffer);
    }

    public static void nglProgramUniformMatrix2fv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix2fv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix2fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniformMatrix2fv(n2, n3, bl2, floatBuffer);
    }

    public static void nglProgramUniformMatrix3fv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix3fv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix3fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniformMatrix3fv(n2, n3, bl2, floatBuffer);
    }

    public static void nglProgramUniformMatrix4fv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix4fv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix4fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniformMatrix4fv(n2, n3, bl2, floatBuffer);
    }

    public static void nglProgramUniformMatrix2dv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix2dv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniformMatrix2dv(n2, n3, bl2, doubleBuffer);
    }

    public static void nglProgramUniformMatrix3dv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix3dv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniformMatrix3dv(n2, n3, bl2, doubleBuffer);
    }

    public static void nglProgramUniformMatrix4dv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix4dv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniformMatrix4dv(n2, n3, bl2, doubleBuffer);
    }

    public static void nglProgramUniformMatrix2x3fv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix2x3fv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix2x3fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniformMatrix2x3fv(n2, n3, bl2, floatBuffer);
    }

    public static void nglProgramUniformMatrix3x2fv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix3x2fv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix3x2fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniformMatrix3x2fv(n2, n3, bl2, floatBuffer);
    }

    public static void nglProgramUniformMatrix2x4fv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix2x4fv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix2x4fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniformMatrix2x4fv(n2, n3, bl2, floatBuffer);
    }

    public static void nglProgramUniformMatrix4x2fv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix4x2fv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix4x2fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniformMatrix4x2fv(n2, n3, bl2, floatBuffer);
    }

    public static void nglProgramUniformMatrix3x4fv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix3x4fv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix3x4fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniformMatrix3x4fv(n2, n3, bl2, floatBuffer);
    }

    public static void nglProgramUniformMatrix4x3fv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix4x3fv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix4x3fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glProgramUniformMatrix4x3fv(n2, n3, bl2, floatBuffer);
    }

    public static void nglProgramUniformMatrix2x3dv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix2x3dv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix2x3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniformMatrix2x3dv(n2, n3, bl2, doubleBuffer);
    }

    public static void nglProgramUniformMatrix3x2dv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix3x2dv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix3x2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniformMatrix3x2dv(n2, n3, bl2, doubleBuffer);
    }

    public static void nglProgramUniformMatrix2x4dv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix2x4dv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix2x4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniformMatrix2x4dv(n2, n3, bl2, doubleBuffer);
    }

    public static void nglProgramUniformMatrix4x2dv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix4x2dv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix4x2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniformMatrix4x2dv(n2, n3, bl2, doubleBuffer);
    }

    public static void nglProgramUniformMatrix3x4dv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix3x4dv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix3x4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniformMatrix3x4dv(n2, n3, bl2, doubleBuffer);
    }

    public static void nglProgramUniformMatrix4x3dv(int n2, int n3, int n4, boolean bl2, long l2) {
        GL41C.nglProgramUniformMatrix4x3dv(n2, n3, n4, bl2, l2);
    }

    public static void glProgramUniformMatrix4x3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glProgramUniformMatrix4x3dv(n2, n3, bl2, doubleBuffer);
    }

    public static void glValidateProgramPipeline(@NativeType(value="GLuint") int n2) {
        GL41C.glValidateProgramPipeline(n2);
    }

    public static void nglGetProgramPipelineInfoLog(int n2, int n3, long l2, long l3) {
        GL41C.nglGetProgramPipelineInfoLog(n2, n3, l2, l3);
    }

    public static void glGetProgramPipelineInfoLog(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL41C.glGetProgramPipelineInfoLog(n2, intBuffer, byteBuffer);
    }

    @NativeType(value="void")
    public static String glGetProgramPipelineInfoLog(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3) {
        return GL41C.glGetProgramPipelineInfoLog(n2, n3);
    }

    @NativeType(value="void")
    public static String glGetProgramPipelineInfoLog(@NativeType(value="GLuint") int n2) {
        return GL41.glGetProgramPipelineInfoLog(n2, GL41.glGetProgramPipelinei(n2, 35716));
    }

    public static void glVertexAttribL1d(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2) {
        GL41C.glVertexAttribL1d(n2, d2);
    }

    public static void glVertexAttribL2d(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3) {
        GL41C.glVertexAttribL2d(n2, d2, d3);
    }

    public static void glVertexAttribL3d(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3, @NativeType(value="GLdouble") double d4) {
        GL41C.glVertexAttribL3d(n2, d2, d3, d4);
    }

    public static void glVertexAttribL4d(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3, @NativeType(value="GLdouble") double d4, @NativeType(value="GLdouble") double d5) {
        GL41C.glVertexAttribL4d(n2, d2, d3, d4, d5);
    }

    public static void nglVertexAttribL1dv(int n2, long l2) {
        GL41C.nglVertexAttribL1dv(n2, l2);
    }

    public static void glVertexAttribL1dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glVertexAttribL1dv(n2, doubleBuffer);
    }

    public static void nglVertexAttribL2dv(int n2, long l2) {
        GL41C.nglVertexAttribL2dv(n2, l2);
    }

    public static void glVertexAttribL2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glVertexAttribL2dv(n2, doubleBuffer);
    }

    public static void nglVertexAttribL3dv(int n2, long l2) {
        GL41C.nglVertexAttribL3dv(n2, l2);
    }

    public static void glVertexAttribL3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glVertexAttribL3dv(n2, doubleBuffer);
    }

    public static void nglVertexAttribL4dv(int n2, long l2) {
        GL41C.nglVertexAttribL4dv(n2, l2);
    }

    public static void glVertexAttribL4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glVertexAttribL4dv(n2, doubleBuffer);
    }

    public static void nglVertexAttribLPointer(int n2, int n3, int n4, int n5, long l2) {
        GL41C.nglVertexAttribLPointer(n2, n3, n4, n5, l2);
    }

    public static void glVertexAttribLPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL41C.glVertexAttribLPointer(n2, n3, n4, n5, byteBuffer);
    }

    public static void glVertexAttribLPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") long l2) {
        GL41C.glVertexAttribLPointer(n2, n3, n4, n5, l2);
    }

    public static void glVertexAttribLPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL41C.glVertexAttribLPointer(n2, n3, n4, doubleBuffer);
    }

    public static void nglGetVertexAttribLdv(int n2, int n3, long l2) {
        GL41C.nglGetVertexAttribLdv(n2, n3, l2);
    }

    public static void glGetVertexAttribLdv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        GL41C.glGetVertexAttribLdv(n2, n3, doubleBuffer);
    }

    public static void nglViewportArrayv(int n2, int n3, long l2) {
        GL41C.nglViewportArrayv(n2, n3, l2);
    }

    public static void glViewportArrayv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glViewportArrayv(n2, floatBuffer);
    }

    public static void glViewportIndexedf(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4, @NativeType(value="GLfloat") float f5) {
        GL41C.glViewportIndexedf(n2, f2, f3, f4, f5);
    }

    public static void nglViewportIndexedfv(int n2, long l2) {
        GL41C.nglViewportIndexedfv(n2, l2);
    }

    public static void glViewportIndexedfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL41C.glViewportIndexedfv(n2, floatBuffer);
    }

    public static void nglScissorArrayv(int n2, int n3, long l2) {
        GL41C.nglScissorArrayv(n2, n3, l2);
    }

    public static void glScissorArrayv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL41C.glScissorArrayv(n2, intBuffer);
    }

    public static void glScissorIndexed(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6) {
        GL41C.glScissorIndexed(n2, n3, n4, n5, n6);
    }

    public static void nglScissorIndexedv(int n2, long l2) {
        GL41C.nglScissorIndexedv(n2, l2);
    }

    public static void glScissorIndexedv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL41C.glScissorIndexedv(n2, intBuffer);
    }

    public static void nglDepthRangeArrayv(int n2, int n3, long l2) {
        GL41C.nglDepthRangeArrayv(n2, n3, l2);
    }

    public static void glDepthRangeArrayv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL41C.glDepthRangeArrayv(n2, doubleBuffer);
    }

    public static void glDepthRangeIndexed(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3) {
        GL41C.glDepthRangeIndexed(n2, d2, d3);
    }

    public static void nglGetFloati_v(int n2, int n3, long l2) {
        GL41C.nglGetFloati_v(n2, n3, l2);
    }

    public static void glGetFloati_v(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL41C.glGetFloati_v(n2, n3, floatBuffer);
    }

    @NativeType(value="void")
    public static float glGetFloati(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        return GL41C.glGetFloati(n2, n3);
    }

    public static void nglGetDoublei_v(int n2, int n3, long l2) {
        GL41C.nglGetDoublei_v(n2, n3, l2);
    }

    public static void glGetDoublei_v(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        GL41C.glGetDoublei_v(n2, n3, doubleBuffer);
    }

    @NativeType(value="void")
    public static double glGetDoublei(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        return GL41C.glGetDoublei(n2, n3);
    }

    public static void glShaderBinary(@NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL41C.glShaderBinary(nArray, n2, byteBuffer);
    }

    public static void glGetShaderPrecisionFormat(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray, @NativeType(value="GLint *") int[] nArray2) {
        GL41C.glGetShaderPrecisionFormat(n2, n3, nArray, nArray2);
    }

    public static void glGetProgramBinary(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLenum *") int[] nArray2, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL41C.glGetProgramBinary(n2, nArray, nArray2, byteBuffer);
    }

    public static void glDeleteProgramPipelines(@NativeType(value="GLuint const *") int[] nArray) {
        GL41C.glDeleteProgramPipelines(nArray);
    }

    public static void glGenProgramPipelines(@NativeType(value="GLuint *") int[] nArray) {
        GL41C.glGenProgramPipelines(nArray);
    }

    public static void glGetProgramPipelineiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL41C.glGetProgramPipelineiv(n2, n3, nArray);
    }

    public static void glProgramUniform1iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") int[] nArray) {
        GL41C.glProgramUniform1iv(n2, n3, nArray);
    }

    public static void glProgramUniform2iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") int[] nArray) {
        GL41C.glProgramUniform2iv(n2, n3, nArray);
    }

    public static void glProgramUniform3iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") int[] nArray) {
        GL41C.glProgramUniform3iv(n2, n3, nArray);
    }

    public static void glProgramUniform4iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint const *") int[] nArray) {
        GL41C.glProgramUniform4iv(n2, n3, nArray);
    }

    public static void glProgramUniform1uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        GL41C.glProgramUniform1uiv(n2, n3, nArray);
    }

    public static void glProgramUniform2uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        GL41C.glProgramUniform2uiv(n2, n3, nArray);
    }

    public static void glProgramUniform3uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        GL41C.glProgramUniform3uiv(n2, n3, nArray);
    }

    public static void glProgramUniform4uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        GL41C.glProgramUniform4uiv(n2, n3, nArray);
    }

    public static void glProgramUniform1fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniform1fv(n2, n3, fArray);
    }

    public static void glProgramUniform2fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniform2fv(n2, n3, fArray);
    }

    public static void glProgramUniform3fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniform3fv(n2, n3, fArray);
    }

    public static void glProgramUniform4fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniform4fv(n2, n3, fArray);
    }

    public static void glProgramUniform1dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniform1dv(n2, n3, dArray);
    }

    public static void glProgramUniform2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniform2dv(n2, n3, dArray);
    }

    public static void glProgramUniform3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniform3dv(n2, n3, dArray);
    }

    public static void glProgramUniform4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniform4dv(n2, n3, dArray);
    }

    public static void glProgramUniformMatrix2fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniformMatrix2fv(n2, n3, bl2, fArray);
    }

    public static void glProgramUniformMatrix3fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniformMatrix3fv(n2, n3, bl2, fArray);
    }

    public static void glProgramUniformMatrix4fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniformMatrix4fv(n2, n3, bl2, fArray);
    }

    public static void glProgramUniformMatrix2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniformMatrix2dv(n2, n3, bl2, dArray);
    }

    public static void glProgramUniformMatrix3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniformMatrix3dv(n2, n3, bl2, dArray);
    }

    public static void glProgramUniformMatrix4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniformMatrix4dv(n2, n3, bl2, dArray);
    }

    public static void glProgramUniformMatrix2x3fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniformMatrix2x3fv(n2, n3, bl2, fArray);
    }

    public static void glProgramUniformMatrix3x2fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniformMatrix3x2fv(n2, n3, bl2, fArray);
    }

    public static void glProgramUniformMatrix2x4fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniformMatrix2x4fv(n2, n3, bl2, fArray);
    }

    public static void glProgramUniformMatrix4x2fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniformMatrix4x2fv(n2, n3, bl2, fArray);
    }

    public static void glProgramUniformMatrix3x4fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniformMatrix3x4fv(n2, n3, bl2, fArray);
    }

    public static void glProgramUniformMatrix4x3fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glProgramUniformMatrix4x3fv(n2, n3, bl2, fArray);
    }

    public static void glProgramUniformMatrix2x3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniformMatrix2x3dv(n2, n3, bl2, dArray);
    }

    public static void glProgramUniformMatrix3x2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniformMatrix3x2dv(n2, n3, bl2, dArray);
    }

    public static void glProgramUniformMatrix2x4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniformMatrix2x4dv(n2, n3, bl2, dArray);
    }

    public static void glProgramUniformMatrix4x2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniformMatrix4x2dv(n2, n3, bl2, dArray);
    }

    public static void glProgramUniformMatrix3x4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniformMatrix3x4dv(n2, n3, bl2, dArray);
    }

    public static void glProgramUniformMatrix4x3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glProgramUniformMatrix4x3dv(n2, n3, bl2, dArray);
    }

    public static void glGetProgramPipelineInfoLog(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL41C.glGetProgramPipelineInfoLog(n2, nArray, byteBuffer);
    }

    public static void glVertexAttribL1dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glVertexAttribL1dv(n2, dArray);
    }

    public static void glVertexAttribL2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glVertexAttribL2dv(n2, dArray);
    }

    public static void glVertexAttribL3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glVertexAttribL3dv(n2, dArray);
    }

    public static void glVertexAttribL4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glVertexAttribL4dv(n2, dArray);
    }

    public static void glGetVertexAttribLdv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        GL41C.glGetVertexAttribLdv(n2, n3, dArray);
    }

    public static void glViewportArrayv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glViewportArrayv(n2, fArray);
    }

    public static void glViewportIndexedfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL41C.glViewportIndexedfv(n2, fArray);
    }

    public static void glScissorArrayv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        GL41C.glScissorArrayv(n2, nArray);
    }

    public static void glScissorIndexedv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        GL41C.glScissorIndexedv(n2, nArray);
    }

    public static void glDepthRangeArrayv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL41C.glDepthRangeArrayv(n2, dArray);
    }

    public static void glGetFloati_v(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        GL41C.glGetFloati_v(n2, n3, fArray);
    }

    public static void glGetDoublei_v(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        GL41C.glGetDoublei_v(n2, n3, dArray);
    }

    static {
        GL.initialize();
    }
}

