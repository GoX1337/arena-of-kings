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
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.system.NativeType;

public class GL20
extends GL15 {
    public static final int GL_SHADING_LANGUAGE_VERSION = 35724;
    public static final int GL_CURRENT_PROGRAM = 35725;
    public static final int GL_SHADER_TYPE = 35663;
    public static final int GL_DELETE_STATUS = 35712;
    public static final int GL_COMPILE_STATUS = 35713;
    public static final int GL_LINK_STATUS = 35714;
    public static final int GL_VALIDATE_STATUS = 35715;
    public static final int GL_INFO_LOG_LENGTH = 35716;
    public static final int GL_ATTACHED_SHADERS = 35717;
    public static final int GL_ACTIVE_UNIFORMS = 35718;
    public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 35719;
    public static final int GL_ACTIVE_ATTRIBUTES = 35721;
    public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 35722;
    public static final int GL_SHADER_SOURCE_LENGTH = 35720;
    public static final int GL_FLOAT_VEC2 = 35664;
    public static final int GL_FLOAT_VEC3 = 35665;
    public static final int GL_FLOAT_VEC4 = 35666;
    public static final int GL_INT_VEC2 = 35667;
    public static final int GL_INT_VEC3 = 35668;
    public static final int GL_INT_VEC4 = 35669;
    public static final int GL_BOOL = 35670;
    public static final int GL_BOOL_VEC2 = 35671;
    public static final int GL_BOOL_VEC3 = 35672;
    public static final int GL_BOOL_VEC4 = 35673;
    public static final int GL_FLOAT_MAT2 = 35674;
    public static final int GL_FLOAT_MAT3 = 35675;
    public static final int GL_FLOAT_MAT4 = 35676;
    public static final int GL_SAMPLER_1D = 35677;
    public static final int GL_SAMPLER_2D = 35678;
    public static final int GL_SAMPLER_3D = 35679;
    public static final int GL_SAMPLER_CUBE = 35680;
    public static final int GL_SAMPLER_1D_SHADOW = 35681;
    public static final int GL_SAMPLER_2D_SHADOW = 35682;
    public static final int GL_VERTEX_SHADER = 35633;
    public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 35658;
    public static final int GL_MAX_VARYING_FLOATS = 35659;
    public static final int GL_MAX_VERTEX_ATTRIBS = 34921;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 34930;
    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 35660;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 35661;
    public static final int GL_MAX_TEXTURE_COORDS = 34929;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 34370;
    public static final int GL_VERTEX_PROGRAM_TWO_SIDE = 34371;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 34338;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 34339;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 34340;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 34341;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 34922;
    public static final int GL_CURRENT_VERTEX_ATTRIB = 34342;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 34373;
    public static final int GL_FRAGMENT_SHADER = 35632;
    public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 35657;
    public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 35723;
    public static final int GL_MAX_DRAW_BUFFERS = 34852;
    public static final int GL_DRAW_BUFFER0 = 34853;
    public static final int GL_DRAW_BUFFER1 = 34854;
    public static final int GL_DRAW_BUFFER2 = 34855;
    public static final int GL_DRAW_BUFFER3 = 34856;
    public static final int GL_DRAW_BUFFER4 = 34857;
    public static final int GL_DRAW_BUFFER5 = 34858;
    public static final int GL_DRAW_BUFFER6 = 34859;
    public static final int GL_DRAW_BUFFER7 = 34860;
    public static final int GL_DRAW_BUFFER8 = 34861;
    public static final int GL_DRAW_BUFFER9 = 34862;
    public static final int GL_DRAW_BUFFER10 = 34863;
    public static final int GL_DRAW_BUFFER11 = 34864;
    public static final int GL_DRAW_BUFFER12 = 34865;
    public static final int GL_DRAW_BUFFER13 = 34866;
    public static final int GL_DRAW_BUFFER14 = 34867;
    public static final int GL_DRAW_BUFFER15 = 34868;
    public static final int GL_POINT_SPRITE = 34913;
    public static final int GL_COORD_REPLACE = 34914;
    public static final int GL_POINT_SPRITE_COORD_ORIGIN = 36000;
    public static final int GL_LOWER_LEFT = 36001;
    public static final int GL_UPPER_LEFT = 36002;
    public static final int GL_BLEND_EQUATION_RGB = 32777;
    public static final int GL_BLEND_EQUATION_ALPHA = 34877;
    public static final int GL_STENCIL_BACK_FUNC = 34816;
    public static final int GL_STENCIL_BACK_FAIL = 34817;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 34818;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 34819;
    public static final int GL_STENCIL_BACK_REF = 36003;
    public static final int GL_STENCIL_BACK_VALUE_MASK = 36004;
    public static final int GL_STENCIL_BACK_WRITEMASK = 36005;

    protected GL20() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="GLuint")
    public static int glCreateProgram() {
        return GL20C.glCreateProgram();
    }

    public static void glDeleteProgram(@NativeType(value="GLuint") int n2) {
        GL20C.glDeleteProgram(n2);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsProgram(@NativeType(value="GLuint") int n2) {
        return GL20C.glIsProgram(n2);
    }

    @NativeType(value="GLuint")
    public static int glCreateShader(@NativeType(value="GLenum") int n2) {
        return GL20C.glCreateShader(n2);
    }

    public static void glDeleteShader(@NativeType(value="GLuint") int n2) {
        GL20C.glDeleteShader(n2);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsShader(@NativeType(value="GLuint") int n2) {
        return GL20C.glIsShader(n2);
    }

    public static void glAttachShader(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        GL20C.glAttachShader(n2, n3);
    }

    public static void glDetachShader(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        GL20C.glDetachShader(n2, n3);
    }

    public static void nglShaderSource(int n2, int n3, long l2, long l3) {
        GL20C.nglShaderSource(n2, n3, l2, l3);
    }

    public static void glShaderSource(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const **") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL20C.glShaderSource(n2, pointerBuffer, intBuffer);
    }

    public static void glShaderSource(@NativeType(value="GLuint") int n2, CharSequence ... charSequenceArray) {
        GL20C.glShaderSource(n2, charSequenceArray);
    }

    public static void glShaderSource(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const **") CharSequence charSequence) {
        GL20C.glShaderSource(n2, charSequence);
    }

    public static void glCompileShader(@NativeType(value="GLuint") int n2) {
        GL20C.glCompileShader(n2);
    }

    public static void glLinkProgram(@NativeType(value="GLuint") int n2) {
        GL20C.glLinkProgram(n2);
    }

    public static void glUseProgram(@NativeType(value="GLuint") int n2) {
        GL20C.glUseProgram(n2);
    }

    public static void glValidateProgram(@NativeType(value="GLuint") int n2) {
        GL20C.glValidateProgram(n2);
    }

    public static void glUniform1f(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat") float f2) {
        GL20C.glUniform1f(n2, f2);
    }

    public static void glUniform2f(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3) {
        GL20C.glUniform2f(n2, f2, f3);
    }

    public static void glUniform3f(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4) {
        GL20C.glUniform3f(n2, f2, f3, f4);
    }

    public static void glUniform4f(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4, @NativeType(value="GLfloat") float f5) {
        GL20C.glUniform4f(n2, f2, f3, f4, f5);
    }

    public static void glUniform1i(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3) {
        GL20C.glUniform1i(n2, n3);
    }

    public static void glUniform2i(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4) {
        GL20C.glUniform2i(n2, n3, n4);
    }

    public static void glUniform3i(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5) {
        GL20C.glUniform3i(n2, n3, n4, n5);
    }

    public static void glUniform4i(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6) {
        GL20C.glUniform4i(n2, n3, n4, n5, n6);
    }

    public static void nglUniform1fv(int n2, int n3, long l2) {
        GL20C.nglUniform1fv(n2, n3, l2);
    }

    public static void glUniform1fv(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL20C.glUniform1fv(n2, floatBuffer);
    }

    public static void nglUniform2fv(int n2, int n3, long l2) {
        GL20C.nglUniform2fv(n2, n3, l2);
    }

    public static void glUniform2fv(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL20C.glUniform2fv(n2, floatBuffer);
    }

    public static void nglUniform3fv(int n2, int n3, long l2) {
        GL20C.nglUniform3fv(n2, n3, l2);
    }

    public static void glUniform3fv(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL20C.glUniform3fv(n2, floatBuffer);
    }

    public static void nglUniform4fv(int n2, int n3, long l2) {
        GL20C.nglUniform4fv(n2, n3, l2);
    }

    public static void glUniform4fv(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL20C.glUniform4fv(n2, floatBuffer);
    }

    public static void nglUniform1iv(int n2, int n3, long l2) {
        GL20C.nglUniform1iv(n2, n3, l2);
    }

    public static void glUniform1iv(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL20C.glUniform1iv(n2, intBuffer);
    }

    public static void nglUniform2iv(int n2, int n3, long l2) {
        GL20C.nglUniform2iv(n2, n3, l2);
    }

    public static void glUniform2iv(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL20C.glUniform2iv(n2, intBuffer);
    }

    public static void nglUniform3iv(int n2, int n3, long l2) {
        GL20C.nglUniform3iv(n2, n3, l2);
    }

    public static void glUniform3iv(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL20C.glUniform3iv(n2, intBuffer);
    }

    public static void nglUniform4iv(int n2, int n3, long l2) {
        GL20C.nglUniform4iv(n2, n3, l2);
    }

    public static void glUniform4iv(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL20C.glUniform4iv(n2, intBuffer);
    }

    public static void nglUniformMatrix2fv(int n2, int n3, boolean bl2, long l2) {
        GL20C.nglUniformMatrix2fv(n2, n3, bl2, l2);
    }

    public static void glUniformMatrix2fv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL20C.glUniformMatrix2fv(n2, bl2, floatBuffer);
    }

    public static void nglUniformMatrix3fv(int n2, int n3, boolean bl2, long l2) {
        GL20C.nglUniformMatrix3fv(n2, n3, bl2, l2);
    }

    public static void glUniformMatrix3fv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL20C.glUniformMatrix3fv(n2, bl2, floatBuffer);
    }

    public static void nglUniformMatrix4fv(int n2, int n3, boolean bl2, long l2) {
        GL20C.nglUniformMatrix4fv(n2, n3, bl2, l2);
    }

    public static void glUniformMatrix4fv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL20C.glUniformMatrix4fv(n2, bl2, floatBuffer);
    }

    public static void nglGetShaderiv(int n2, int n3, long l2) {
        GL20C.nglGetShaderiv(n2, n3, l2);
    }

    public static void glGetShaderiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL20C.glGetShaderiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetShaderi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL20C.glGetShaderi(n2, n3);
    }

    public static void nglGetProgramiv(int n2, int n3, long l2) {
        GL20C.nglGetProgramiv(n2, n3, l2);
    }

    public static void glGetProgramiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL20C.glGetProgramiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetProgrami(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL20C.glGetProgrami(n2, n3);
    }

    public static void nglGetShaderInfoLog(int n2, int n3, long l2, long l3) {
        GL20C.nglGetShaderInfoLog(n2, n3, l2, l3);
    }

    public static void glGetShaderInfoLog(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL20C.glGetShaderInfoLog(n2, intBuffer, byteBuffer);
    }

    @NativeType(value="void")
    public static String glGetShaderInfoLog(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3) {
        return GL20C.glGetShaderInfoLog(n2, n3);
    }

    @NativeType(value="void")
    public static String glGetShaderInfoLog(@NativeType(value="GLuint") int n2) {
        return GL20.glGetShaderInfoLog(n2, GL20.glGetShaderi(n2, 35716));
    }

    public static void nglGetProgramInfoLog(int n2, int n3, long l2, long l3) {
        GL20C.nglGetProgramInfoLog(n2, n3, l2, l3);
    }

    public static void glGetProgramInfoLog(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL20C.glGetProgramInfoLog(n2, intBuffer, byteBuffer);
    }

    @NativeType(value="void")
    public static String glGetProgramInfoLog(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3) {
        return GL20C.glGetProgramInfoLog(n2, n3);
    }

    @NativeType(value="void")
    public static String glGetProgramInfoLog(@NativeType(value="GLuint") int n2) {
        return GL20.glGetProgramInfoLog(n2, GL20.glGetProgrami(n2, 35716));
    }

    public static void nglGetAttachedShaders(int n2, int n3, long l2, long l3) {
        GL20C.nglGetAttachedShaders(n2, n3, l2, l3);
    }

    public static void glGetAttachedShaders(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLuint *") IntBuffer intBuffer2) {
        GL20C.glGetAttachedShaders(n2, intBuffer, intBuffer2);
    }

    public static int nglGetUniformLocation(int n2, long l2) {
        return GL20C.nglGetUniformLocation(n2, l2);
    }

    @NativeType(value="GLint")
    public static int glGetUniformLocation(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        return GL20C.glGetUniformLocation(n2, byteBuffer);
    }

    @NativeType(value="GLint")
    public static int glGetUniformLocation(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        return GL20C.glGetUniformLocation(n2, charSequence);
    }

    public static void nglGetActiveUniform(int n2, int n3, int n4, long l2, long l3, long l4, long l5) {
        GL20C.nglGetActiveUniform(n2, n3, n4, l2, l3, l4, l5);
    }

    public static void glGetActiveUniform(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLint *") IntBuffer intBuffer2, @NativeType(value="GLenum *") IntBuffer intBuffer3, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL20C.glGetActiveUniform(n2, n3, intBuffer, intBuffer2, intBuffer3, byteBuffer);
    }

    @NativeType(value="void")
    public static String glGetActiveUniform(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLenum *") IntBuffer intBuffer2) {
        return GL20C.glGetActiveUniform(n2, n3, n4, intBuffer, intBuffer2);
    }

    @NativeType(value="void")
    public static String glGetActiveUniform(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLenum *") IntBuffer intBuffer2) {
        return GL20.glGetActiveUniform(n2, n3, GL20.glGetProgrami(n2, 35719), intBuffer, intBuffer2);
    }

    public static void nglGetUniformfv(int n2, int n3, long l2) {
        GL20C.nglGetUniformfv(n2, n3, l2);
    }

    public static void glGetUniformfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL20C.glGetUniformfv(n2, n3, floatBuffer);
    }

    @NativeType(value="void")
    public static float glGetUniformf(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        return GL20C.glGetUniformf(n2, n3);
    }

    public static void nglGetUniformiv(int n2, int n3, long l2) {
        GL20C.nglGetUniformiv(n2, n3, l2);
    }

    public static void glGetUniformiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL20C.glGetUniformiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetUniformi(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        return GL20C.glGetUniformi(n2, n3);
    }

    public static void nglGetShaderSource(int n2, int n3, long l2, long l3) {
        GL20C.nglGetShaderSource(n2, n3, l2, l3);
    }

    public static void glGetShaderSource(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL20C.glGetShaderSource(n2, intBuffer, byteBuffer);
    }

    @NativeType(value="void")
    public static String glGetShaderSource(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3) {
        return GL20C.glGetShaderSource(n2, n3);
    }

    @NativeType(value="void")
    public static String glGetShaderSource(@NativeType(value="GLuint") int n2) {
        return GL20.glGetShaderSource(n2, GL20.glGetShaderi(n2, 35720));
    }

    public static void glVertexAttrib1f(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat") float f2) {
        GL20C.glVertexAttrib1f(n2, f2);
    }

    public static void glVertexAttrib1s(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort") short s2) {
        GL20C.glVertexAttrib1s(n2, s2);
    }

    public static void glVertexAttrib1d(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2) {
        GL20C.glVertexAttrib1d(n2, d2);
    }

    public static void glVertexAttrib2f(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3) {
        GL20C.glVertexAttrib2f(n2, f2, f3);
    }

    public static void glVertexAttrib2s(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort") short s2, @NativeType(value="GLshort") short s3) {
        GL20C.glVertexAttrib2s(n2, s2, s3);
    }

    public static void glVertexAttrib2d(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3) {
        GL20C.glVertexAttrib2d(n2, d2, d3);
    }

    public static void glVertexAttrib3f(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4) {
        GL20C.glVertexAttrib3f(n2, f2, f3, f4);
    }

    public static void glVertexAttrib3s(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort") short s2, @NativeType(value="GLshort") short s3, @NativeType(value="GLshort") short s4) {
        GL20C.glVertexAttrib3s(n2, s2, s3, s4);
    }

    public static void glVertexAttrib3d(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3, @NativeType(value="GLdouble") double d4) {
        GL20C.glVertexAttrib3d(n2, d2, d3, d4);
    }

    public static void glVertexAttrib4f(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4, @NativeType(value="GLfloat") float f5) {
        GL20C.glVertexAttrib4f(n2, f2, f3, f4, f5);
    }

    public static void glVertexAttrib4s(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort") short s2, @NativeType(value="GLshort") short s3, @NativeType(value="GLshort") short s4, @NativeType(value="GLshort") short s5) {
        GL20C.glVertexAttrib4s(n2, s2, s3, s4, s5);
    }

    public static void glVertexAttrib4d(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3, @NativeType(value="GLdouble") double d4, @NativeType(value="GLdouble") double d5) {
        GL20C.glVertexAttrib4d(n2, d2, d3, d4, d5);
    }

    public static void glVertexAttrib4Nub(@NativeType(value="GLuint") int n2, @NativeType(value="GLubyte") byte by2, @NativeType(value="GLubyte") byte by3, @NativeType(value="GLubyte") byte by4, @NativeType(value="GLubyte") byte by5) {
        GL20C.glVertexAttrib4Nub(n2, by2, by3, by4, by5);
    }

    public static void nglVertexAttrib1fv(int n2, long l2) {
        GL20C.nglVertexAttrib1fv(n2, l2);
    }

    public static void glVertexAttrib1fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL20C.glVertexAttrib1fv(n2, floatBuffer);
    }

    public static void nglVertexAttrib1sv(int n2, long l2) {
        GL20C.nglVertexAttrib1sv(n2, l2);
    }

    public static void glVertexAttrib1sv(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") ShortBuffer shortBuffer) {
        GL20C.glVertexAttrib1sv(n2, shortBuffer);
    }

    public static void nglVertexAttrib1dv(int n2, long l2) {
        GL20C.nglVertexAttrib1dv(n2, l2);
    }

    public static void glVertexAttrib1dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL20C.glVertexAttrib1dv(n2, doubleBuffer);
    }

    public static void nglVertexAttrib2fv(int n2, long l2) {
        GL20C.nglVertexAttrib2fv(n2, l2);
    }

    public static void glVertexAttrib2fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL20C.glVertexAttrib2fv(n2, floatBuffer);
    }

    public static void nglVertexAttrib2sv(int n2, long l2) {
        GL20C.nglVertexAttrib2sv(n2, l2);
    }

    public static void glVertexAttrib2sv(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") ShortBuffer shortBuffer) {
        GL20C.glVertexAttrib2sv(n2, shortBuffer);
    }

    public static void nglVertexAttrib2dv(int n2, long l2) {
        GL20C.nglVertexAttrib2dv(n2, l2);
    }

    public static void glVertexAttrib2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL20C.glVertexAttrib2dv(n2, doubleBuffer);
    }

    public static void nglVertexAttrib3fv(int n2, long l2) {
        GL20C.nglVertexAttrib3fv(n2, l2);
    }

    public static void glVertexAttrib3fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL20C.glVertexAttrib3fv(n2, floatBuffer);
    }

    public static void nglVertexAttrib3sv(int n2, long l2) {
        GL20C.nglVertexAttrib3sv(n2, l2);
    }

    public static void glVertexAttrib3sv(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") ShortBuffer shortBuffer) {
        GL20C.glVertexAttrib3sv(n2, shortBuffer);
    }

    public static void nglVertexAttrib3dv(int n2, long l2) {
        GL20C.nglVertexAttrib3dv(n2, l2);
    }

    public static void glVertexAttrib3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL20C.glVertexAttrib3dv(n2, doubleBuffer);
    }

    public static void nglVertexAttrib4fv(int n2, long l2) {
        GL20C.nglVertexAttrib4fv(n2, l2);
    }

    public static void glVertexAttrib4fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        GL20C.glVertexAttrib4fv(n2, floatBuffer);
    }

    public static void nglVertexAttrib4sv(int n2, long l2) {
        GL20C.nglVertexAttrib4sv(n2, l2);
    }

    public static void glVertexAttrib4sv(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") ShortBuffer shortBuffer) {
        GL20C.glVertexAttrib4sv(n2, shortBuffer);
    }

    public static void nglVertexAttrib4dv(int n2, long l2) {
        GL20C.nglVertexAttrib4dv(n2, l2);
    }

    public static void glVertexAttrib4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        GL20C.glVertexAttrib4dv(n2, doubleBuffer);
    }

    public static void nglVertexAttrib4iv(int n2, long l2) {
        GL20C.nglVertexAttrib4iv(n2, l2);
    }

    public static void glVertexAttrib4iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL20C.glVertexAttrib4iv(n2, intBuffer);
    }

    public static void nglVertexAttrib4bv(int n2, long l2) {
        GL20C.nglVertexAttrib4bv(n2, l2);
    }

    public static void glVertexAttrib4bv(@NativeType(value="GLuint") int n2, @NativeType(value="GLbyte const *") ByteBuffer byteBuffer) {
        GL20C.glVertexAttrib4bv(n2, byteBuffer);
    }

    public static void nglVertexAttrib4ubv(int n2, long l2) {
        GL20C.nglVertexAttrib4ubv(n2, l2);
    }

    public static void glVertexAttrib4ubv(@NativeType(value="GLuint") int n2, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer) {
        GL20C.glVertexAttrib4ubv(n2, byteBuffer);
    }

    public static void nglVertexAttrib4usv(int n2, long l2) {
        GL20C.nglVertexAttrib4usv(n2, l2);
    }

    public static void glVertexAttrib4usv(@NativeType(value="GLuint") int n2, @NativeType(value="GLushort const *") ShortBuffer shortBuffer) {
        GL20C.glVertexAttrib4usv(n2, shortBuffer);
    }

    public static void nglVertexAttrib4uiv(int n2, long l2) {
        GL20C.nglVertexAttrib4uiv(n2, l2);
    }

    public static void glVertexAttrib4uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL20C.glVertexAttrib4uiv(n2, intBuffer);
    }

    public static void nglVertexAttrib4Nbv(int n2, long l2) {
        GL20C.nglVertexAttrib4Nbv(n2, l2);
    }

    public static void glVertexAttrib4Nbv(@NativeType(value="GLuint") int n2, @NativeType(value="GLbyte const *") ByteBuffer byteBuffer) {
        GL20C.glVertexAttrib4Nbv(n2, byteBuffer);
    }

    public static void nglVertexAttrib4Nsv(int n2, long l2) {
        GL20C.nglVertexAttrib4Nsv(n2, l2);
    }

    public static void glVertexAttrib4Nsv(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") ShortBuffer shortBuffer) {
        GL20C.glVertexAttrib4Nsv(n2, shortBuffer);
    }

    public static void nglVertexAttrib4Niv(int n2, long l2) {
        GL20C.nglVertexAttrib4Niv(n2, l2);
    }

    public static void glVertexAttrib4Niv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        GL20C.glVertexAttrib4Niv(n2, intBuffer);
    }

    public static void nglVertexAttrib4Nubv(int n2, long l2) {
        GL20C.nglVertexAttrib4Nubv(n2, l2);
    }

    public static void glVertexAttrib4Nubv(@NativeType(value="GLuint") int n2, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer) {
        GL20C.glVertexAttrib4Nubv(n2, byteBuffer);
    }

    public static void nglVertexAttrib4Nusv(int n2, long l2) {
        GL20C.nglVertexAttrib4Nusv(n2, l2);
    }

    public static void glVertexAttrib4Nusv(@NativeType(value="GLuint") int n2, @NativeType(value="GLushort const *") ShortBuffer shortBuffer) {
        GL20C.glVertexAttrib4Nusv(n2, shortBuffer);
    }

    public static void nglVertexAttrib4Nuiv(int n2, long l2) {
        GL20C.nglVertexAttrib4Nuiv(n2, l2);
    }

    public static void glVertexAttrib4Nuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL20C.glVertexAttrib4Nuiv(n2, intBuffer);
    }

    public static void nglVertexAttribPointer(int n2, int n3, int n4, boolean bl2, int n5, long l2) {
        GL20C.nglVertexAttribPointer(n2, n3, n4, bl2, n5, l2);
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL20C.glVertexAttribPointer(n2, n3, n4, bl2, n5, byteBuffer);
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") long l2) {
        GL20C.glVertexAttribPointer(n2, n3, n4, bl2, n5, l2);
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL20C.glVertexAttribPointer(n2, n3, n4, bl2, n5, shortBuffer);
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL20C.glVertexAttribPointer(n2, n3, n4, bl2, n5, intBuffer);
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL20C.glVertexAttribPointer(n2, n3, n4, bl2, n5, floatBuffer);
    }

    public static void glEnableVertexAttribArray(@NativeType(value="GLuint") int n2) {
        GL20C.glEnableVertexAttribArray(n2);
    }

    public static void glDisableVertexAttribArray(@NativeType(value="GLuint") int n2) {
        GL20C.glDisableVertexAttribArray(n2);
    }

    public static void nglBindAttribLocation(int n2, int n3, long l2) {
        GL20C.nglBindAttribLocation(n2, n3, l2);
    }

    public static void glBindAttribLocation(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        GL20C.glBindAttribLocation(n2, n3, byteBuffer);
    }

    public static void glBindAttribLocation(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLchar const *") CharSequence charSequence) {
        GL20C.glBindAttribLocation(n2, n3, charSequence);
    }

    public static void nglGetActiveAttrib(int n2, int n3, int n4, long l2, long l3, long l4, long l5) {
        GL20C.nglGetActiveAttrib(n2, n3, n4, l2, l3, l4, l5);
    }

    public static void glGetActiveAttrib(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLint *") IntBuffer intBuffer2, @NativeType(value="GLenum *") IntBuffer intBuffer3, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL20C.glGetActiveAttrib(n2, n3, intBuffer, intBuffer2, intBuffer3, byteBuffer);
    }

    @NativeType(value="void")
    public static String glGetActiveAttrib(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLenum *") IntBuffer intBuffer2) {
        return GL20C.glGetActiveAttrib(n2, n3, n4, intBuffer, intBuffer2);
    }

    @NativeType(value="void")
    public static String glGetActiveAttrib(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLenum *") IntBuffer intBuffer2) {
        return GL20.glGetActiveAttrib(n2, n3, GL20.glGetProgrami(n2, 35722), intBuffer, intBuffer2);
    }

    public static int nglGetAttribLocation(int n2, long l2) {
        return GL20C.nglGetAttribLocation(n2, l2);
    }

    @NativeType(value="GLint")
    public static int glGetAttribLocation(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        return GL20C.glGetAttribLocation(n2, byteBuffer);
    }

    @NativeType(value="GLint")
    public static int glGetAttribLocation(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        return GL20C.glGetAttribLocation(n2, charSequence);
    }

    public static void nglGetVertexAttribiv(int n2, int n3, long l2) {
        GL20C.nglGetVertexAttribiv(n2, n3, l2);
    }

    public static void glGetVertexAttribiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL20C.glGetVertexAttribiv(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetVertexAttribi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL20C.glGetVertexAttribi(n2, n3);
    }

    public static void nglGetVertexAttribfv(int n2, int n3, long l2) {
        GL20C.nglGetVertexAttribfv(n2, n3, l2);
    }

    public static void glGetVertexAttribfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        GL20C.glGetVertexAttribfv(n2, n3, floatBuffer);
    }

    public static void nglGetVertexAttribdv(int n2, int n3, long l2) {
        GL20C.nglGetVertexAttribdv(n2, n3, l2);
    }

    public static void glGetVertexAttribdv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        GL20C.glGetVertexAttribdv(n2, n3, doubleBuffer);
    }

    public static void nglGetVertexAttribPointerv(int n2, int n3, long l2) {
        GL20C.nglGetVertexAttribPointerv(n2, n3, l2);
    }

    public static void glGetVertexAttribPointerv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void **") PointerBuffer pointerBuffer) {
        GL20C.glGetVertexAttribPointerv(n2, n3, pointerBuffer);
    }

    @NativeType(value="void")
    public static long glGetVertexAttribPointer(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL20C.glGetVertexAttribPointer(n2, n3);
    }

    public static void nglDrawBuffers(int n2, long l2) {
        GL20C.nglDrawBuffers(n2, l2);
    }

    public static void glDrawBuffers(@NativeType(value="GLenum const *") IntBuffer intBuffer) {
        GL20C.glDrawBuffers(intBuffer);
    }

    public static void glDrawBuffers(@NativeType(value="GLenum const *") int n2) {
        GL20C.glDrawBuffers(n2);
    }

    public static void glBlendEquationSeparate(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        GL20C.glBlendEquationSeparate(n2, n3);
    }

    public static void glStencilOpSeparate(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5) {
        GL20C.glStencilOpSeparate(n2, n3, n4, n5);
    }

    public static void glStencilFuncSeparate(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLuint") int n5) {
        GL20C.glStencilFuncSeparate(n2, n3, n4, n5);
    }

    public static void glStencilMaskSeparate(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL20C.glStencilMaskSeparate(n2, n3);
    }

    public static void glShaderSource(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const **") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLint const *") int[] nArray) {
        GL20C.glShaderSource(n2, pointerBuffer, nArray);
    }

    public static void glUniform1fv(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL20C.glUniform1fv(n2, fArray);
    }

    public static void glUniform2fv(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL20C.glUniform2fv(n2, fArray);
    }

    public static void glUniform3fv(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL20C.glUniform3fv(n2, fArray);
    }

    public static void glUniform4fv(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL20C.glUniform4fv(n2, fArray);
    }

    public static void glUniform1iv(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        GL20C.glUniform1iv(n2, nArray);
    }

    public static void glUniform2iv(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        GL20C.glUniform2iv(n2, nArray);
    }

    public static void glUniform3iv(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        GL20C.glUniform3iv(n2, nArray);
    }

    public static void glUniform4iv(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        GL20C.glUniform4iv(n2, nArray);
    }

    public static void glUniformMatrix2fv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL20C.glUniformMatrix2fv(n2, bl2, fArray);
    }

    public static void glUniformMatrix3fv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL20C.glUniformMatrix3fv(n2, bl2, fArray);
    }

    public static void glUniformMatrix4fv(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL20C.glUniformMatrix4fv(n2, bl2, fArray);
    }

    public static void glGetShaderiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL20C.glGetShaderiv(n2, n3, nArray);
    }

    public static void glGetProgramiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL20C.glGetProgramiv(n2, n3, nArray);
    }

    public static void glGetShaderInfoLog(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL20C.glGetShaderInfoLog(n2, nArray, byteBuffer);
    }

    public static void glGetProgramInfoLog(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL20C.glGetProgramInfoLog(n2, nArray, byteBuffer);
    }

    public static void glGetAttachedShaders(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLuint *") int[] nArray2) {
        GL20C.glGetAttachedShaders(n2, nArray, nArray2);
    }

    public static void glGetActiveUniform(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLint *") int[] nArray2, @NativeType(value="GLenum *") int[] nArray3, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL20C.glGetActiveUniform(n2, n3, nArray, nArray2, nArray3, byteBuffer);
    }

    public static void glGetUniformfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        GL20C.glGetUniformfv(n2, n3, fArray);
    }

    public static void glGetUniformiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL20C.glGetUniformiv(n2, n3, nArray);
    }

    public static void glGetShaderSource(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL20C.glGetShaderSource(n2, nArray, byteBuffer);
    }

    public static void glVertexAttrib1fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL20C.glVertexAttrib1fv(n2, fArray);
    }

    public static void glVertexAttrib1sv(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") short[] sArray) {
        GL20C.glVertexAttrib1sv(n2, sArray);
    }

    public static void glVertexAttrib1dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL20C.glVertexAttrib1dv(n2, dArray);
    }

    public static void glVertexAttrib2fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL20C.glVertexAttrib2fv(n2, fArray);
    }

    public static void glVertexAttrib2sv(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") short[] sArray) {
        GL20C.glVertexAttrib2sv(n2, sArray);
    }

    public static void glVertexAttrib2dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL20C.glVertexAttrib2dv(n2, dArray);
    }

    public static void glVertexAttrib3fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL20C.glVertexAttrib3fv(n2, fArray);
    }

    public static void glVertexAttrib3sv(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") short[] sArray) {
        GL20C.glVertexAttrib3sv(n2, sArray);
    }

    public static void glVertexAttrib3dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL20C.glVertexAttrib3dv(n2, dArray);
    }

    public static void glVertexAttrib4fv(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        GL20C.glVertexAttrib4fv(n2, fArray);
    }

    public static void glVertexAttrib4sv(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") short[] sArray) {
        GL20C.glVertexAttrib4sv(n2, sArray);
    }

    public static void glVertexAttrib4dv(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        GL20C.glVertexAttrib4dv(n2, dArray);
    }

    public static void glVertexAttrib4iv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        GL20C.glVertexAttrib4iv(n2, nArray);
    }

    public static void glVertexAttrib4usv(@NativeType(value="GLuint") int n2, @NativeType(value="GLushort const *") short[] sArray) {
        GL20C.glVertexAttrib4usv(n2, sArray);
    }

    public static void glVertexAttrib4uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL20C.glVertexAttrib4uiv(n2, nArray);
    }

    public static void glVertexAttrib4Nsv(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") short[] sArray) {
        GL20C.glVertexAttrib4Nsv(n2, sArray);
    }

    public static void glVertexAttrib4Niv(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        GL20C.glVertexAttrib4Niv(n2, nArray);
    }

    public static void glVertexAttrib4Nusv(@NativeType(value="GLuint") int n2, @NativeType(value="GLushort const *") short[] sArray) {
        GL20C.glVertexAttrib4Nusv(n2, sArray);
    }

    public static void glVertexAttrib4Nuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL20C.glVertexAttrib4Nuiv(n2, nArray);
    }

    public static void glGetActiveAttrib(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLint *") int[] nArray2, @NativeType(value="GLenum *") int[] nArray3, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        GL20C.glGetActiveAttrib(n2, n3, nArray, nArray2, nArray3, byteBuffer);
    }

    public static void glGetVertexAttribiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        GL20C.glGetVertexAttribiv(n2, n3, nArray);
    }

    public static void glGetVertexAttribfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        GL20C.glGetVertexAttribfv(n2, n3, fArray);
    }

    public static void glGetVertexAttribdv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        GL20C.glGetVertexAttribdv(n2, n3, dArray);
    }

    public static void glDrawBuffers(@NativeType(value="GLenum const *") int[] nArray) {
        GL20C.glDrawBuffers(nArray);
    }

    static {
        GL.initialize();
    }
}

