/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.ARBVertexShader;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBVertexProgram {
    public static final int GL_VERTEX_PROGRAM_ARB = 34336;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE_ARB = 34370;
    public static final int GL_VERTEX_PROGRAM_TWO_SIDE_ARB = 34371;
    public static final int GL_COLOR_SUM_ARB = 33880;
    public static final int GL_PROGRAM_FORMAT_ASCII_ARB = 34933;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB = 34338;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB = 34339;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB = 34340;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB = 34341;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB = 34922;
    public static final int GL_CURRENT_VERTEX_ATTRIB_ARB = 34342;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB = 34373;
    public static final int GL_PROGRAM_LENGTH_ARB = 34343;
    public static final int GL_PROGRAM_FORMAT_ARB = 34934;
    public static final int GL_PROGRAM_BINDING_ARB = 34423;
    public static final int GL_PROGRAM_INSTRUCTIONS_ARB = 34976;
    public static final int GL_MAX_PROGRAM_INSTRUCTIONS_ARB = 34977;
    public static final int GL_PROGRAM_NATIVE_INSTRUCTIONS_ARB = 34978;
    public static final int GL_MAX_PROGRAM_NATIVE_INSTRUCTIONS_ARB = 34979;
    public static final int GL_PROGRAM_TEMPORARIES_ARB = 34980;
    public static final int GL_MAX_PROGRAM_TEMPORARIES_ARB = 34981;
    public static final int GL_PROGRAM_NATIVE_TEMPORARIES_ARB = 34982;
    public static final int GL_MAX_PROGRAM_NATIVE_TEMPORARIES_ARB = 34983;
    public static final int GL_PROGRAM_PARAMETERS_ARB = 34984;
    public static final int GL_MAX_PROGRAM_PARAMETERS_ARB = 34985;
    public static final int GL_PROGRAM_NATIVE_PARAMETERS_ARB = 34986;
    public static final int GL_MAX_PROGRAM_NATIVE_PARAMETERS_ARB = 34987;
    public static final int GL_PROGRAM_ATTRIBS_ARB = 34988;
    public static final int GL_MAX_PROGRAM_ATTRIBS_ARB = 34989;
    public static final int GL_PROGRAM_NATIVE_ATTRIBS_ARB = 34990;
    public static final int GL_MAX_PROGRAM_NATIVE_ATTRIBS_ARB = 34991;
    public static final int GL_PROGRAM_ADDRESS_REGISTERS_ARB = 34992;
    public static final int GL_MAX_PROGRAM_ADDRESS_REGISTERS_ARB = 34993;
    public static final int GL_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB = 34994;
    public static final int GL_MAX_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB = 34995;
    public static final int GL_MAX_PROGRAM_LOCAL_PARAMETERS_ARB = 34996;
    public static final int GL_MAX_PROGRAM_ENV_PARAMETERS_ARB = 34997;
    public static final int GL_PROGRAM_UNDER_NATIVE_LIMITS_ARB = 34998;
    public static final int GL_PROGRAM_STRING_ARB = 34344;
    public static final int GL_PROGRAM_ERROR_POSITION_ARB = 34379;
    public static final int GL_CURRENT_MATRIX_ARB = 34369;
    public static final int GL_TRANSPOSE_CURRENT_MATRIX_ARB = 34999;
    public static final int GL_CURRENT_MATRIX_STACK_DEPTH_ARB = 34368;
    public static final int GL_MAX_VERTEX_ATTRIBS_ARB = 34921;
    public static final int GL_MAX_PROGRAM_MATRICES_ARB = 34351;
    public static final int GL_MAX_PROGRAM_MATRIX_STACK_DEPTH_ARB = 34350;
    public static final int GL_PROGRAM_ERROR_STRING_ARB = 34932;
    public static final int GL_MATRIX0_ARB = 35008;
    public static final int GL_MATRIX1_ARB = 35009;
    public static final int GL_MATRIX2_ARB = 35010;
    public static final int GL_MATRIX3_ARB = 35011;
    public static final int GL_MATRIX4_ARB = 35012;
    public static final int GL_MATRIX5_ARB = 35013;
    public static final int GL_MATRIX6_ARB = 35014;
    public static final int GL_MATRIX7_ARB = 35015;
    public static final int GL_MATRIX8_ARB = 35016;
    public static final int GL_MATRIX9_ARB = 35017;
    public static final int GL_MATRIX10_ARB = 35018;
    public static final int GL_MATRIX11_ARB = 35019;
    public static final int GL_MATRIX12_ARB = 35020;
    public static final int GL_MATRIX13_ARB = 35021;
    public static final int GL_MATRIX14_ARB = 35022;
    public static final int GL_MATRIX15_ARB = 35023;
    public static final int GL_MATRIX16_ARB = 35024;
    public static final int GL_MATRIX17_ARB = 35025;
    public static final int GL_MATRIX18_ARB = 35026;
    public static final int GL_MATRIX19_ARB = 35027;
    public static final int GL_MATRIX20_ARB = 35028;
    public static final int GL_MATRIX21_ARB = 35029;
    public static final int GL_MATRIX22_ARB = 35030;
    public static final int GL_MATRIX23_ARB = 35031;
    public static final int GL_MATRIX24_ARB = 35032;
    public static final int GL_MATRIX25_ARB = 35033;
    public static final int GL_MATRIX26_ARB = 35034;
    public static final int GL_MATRIX27_ARB = 35035;
    public static final int GL_MATRIX28_ARB = 35036;
    public static final int GL_MATRIX29_ARB = 35037;
    public static final int GL_MATRIX30_ARB = 35038;
    public static final int GL_MATRIX31_ARB = 35039;

    protected ARBVertexProgram() {
        throw new UnsupportedOperationException();
    }

    public static void glVertexAttrib1sARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort") short s2) {
        ARBVertexShader.glVertexAttrib1sARB(n2, s2);
    }

    public static void glVertexAttrib1fARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat") float f2) {
        ARBVertexShader.glVertexAttrib1fARB(n2, f2);
    }

    public static void glVertexAttrib1dARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2) {
        ARBVertexShader.glVertexAttrib1dARB(n2, d2);
    }

    public static void glVertexAttrib2sARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort") short s2, @NativeType(value="GLshort") short s3) {
        ARBVertexShader.glVertexAttrib2sARB(n2, s2, s3);
    }

    public static void glVertexAttrib2fARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3) {
        ARBVertexShader.glVertexAttrib2fARB(n2, f2, f3);
    }

    public static void glVertexAttrib2dARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3) {
        ARBVertexShader.glVertexAttrib2dARB(n2, d2, d3);
    }

    public static void glVertexAttrib3sARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort") short s2, @NativeType(value="GLshort") short s3, @NativeType(value="GLshort") short s4) {
        ARBVertexShader.glVertexAttrib3sARB(n2, s2, s3, s4);
    }

    public static void glVertexAttrib3fARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4) {
        ARBVertexShader.glVertexAttrib3fARB(n2, f2, f3, f4);
    }

    public static void glVertexAttrib3dARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3, @NativeType(value="GLdouble") double d4) {
        ARBVertexShader.glVertexAttrib3dARB(n2, d2, d3, d4);
    }

    public static void glVertexAttrib4sARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort") short s2, @NativeType(value="GLshort") short s3, @NativeType(value="GLshort") short s4, @NativeType(value="GLshort") short s5) {
        ARBVertexShader.glVertexAttrib4sARB(n2, s2, s3, s4, s5);
    }

    public static void glVertexAttrib4fARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4, @NativeType(value="GLfloat") float f5) {
        ARBVertexShader.glVertexAttrib4fARB(n2, f2, f3, f4, f5);
    }

    public static void glVertexAttrib4dARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble") double d2, @NativeType(value="GLdouble") double d3, @NativeType(value="GLdouble") double d4, @NativeType(value="GLdouble") double d5) {
        ARBVertexShader.glVertexAttrib4dARB(n2, d2, d3, d4, d5);
    }

    public static void glVertexAttrib4NubARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLubyte") byte by2, @NativeType(value="GLubyte") byte by3, @NativeType(value="GLubyte") byte by4, @NativeType(value="GLubyte") byte by5) {
        ARBVertexShader.glVertexAttrib4NubARB(n2, by2, by3, by4, by5);
    }

    public static void nglVertexAttrib1svARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib1svARB(n2, l2);
    }

    public static void glVertexAttrib1svARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") ShortBuffer shortBuffer) {
        ARBVertexShader.glVertexAttrib1svARB(n2, shortBuffer);
    }

    public static void nglVertexAttrib1fvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib1fvARB(n2, l2);
    }

    public static void glVertexAttrib1fvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBVertexShader.glVertexAttrib1fvARB(n2, floatBuffer);
    }

    public static void nglVertexAttrib1dvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib1dvARB(n2, l2);
    }

    public static void glVertexAttrib1dvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        ARBVertexShader.glVertexAttrib1dvARB(n2, doubleBuffer);
    }

    public static void nglVertexAttrib2svARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib2svARB(n2, l2);
    }

    public static void glVertexAttrib2svARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") ShortBuffer shortBuffer) {
        ARBVertexShader.glVertexAttrib2svARB(n2, shortBuffer);
    }

    public static void nglVertexAttrib2fvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib2fvARB(n2, l2);
    }

    public static void glVertexAttrib2fvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBVertexShader.glVertexAttrib2fvARB(n2, floatBuffer);
    }

    public static void nglVertexAttrib2dvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib2dvARB(n2, l2);
    }

    public static void glVertexAttrib2dvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        ARBVertexShader.glVertexAttrib2dvARB(n2, doubleBuffer);
    }

    public static void nglVertexAttrib3svARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib3svARB(n2, l2);
    }

    public static void glVertexAttrib3svARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") ShortBuffer shortBuffer) {
        ARBVertexShader.glVertexAttrib3svARB(n2, shortBuffer);
    }

    public static void nglVertexAttrib3fvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib3fvARB(n2, l2);
    }

    public static void glVertexAttrib3fvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBVertexShader.glVertexAttrib3fvARB(n2, floatBuffer);
    }

    public static void nglVertexAttrib3dvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib3dvARB(n2, l2);
    }

    public static void glVertexAttrib3dvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        ARBVertexShader.glVertexAttrib3dvARB(n2, doubleBuffer);
    }

    public static void nglVertexAttrib4fvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4fvARB(n2, l2);
    }

    public static void glVertexAttrib4fvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBVertexShader.glVertexAttrib4fvARB(n2, floatBuffer);
    }

    public static void nglVertexAttrib4bvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4bvARB(n2, l2);
    }

    public static void glVertexAttrib4bvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLbyte const *") ByteBuffer byteBuffer) {
        ARBVertexShader.glVertexAttrib4bvARB(n2, byteBuffer);
    }

    public static void nglVertexAttrib4svARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4svARB(n2, l2);
    }

    public static void glVertexAttrib4svARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") ShortBuffer shortBuffer) {
        ARBVertexShader.glVertexAttrib4svARB(n2, shortBuffer);
    }

    public static void nglVertexAttrib4ivARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4ivARB(n2, l2);
    }

    public static void glVertexAttrib4ivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        ARBVertexShader.glVertexAttrib4ivARB(n2, intBuffer);
    }

    public static void nglVertexAttrib4ubvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4ubvARB(n2, l2);
    }

    public static void glVertexAttrib4ubvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer) {
        ARBVertexShader.glVertexAttrib4ubvARB(n2, byteBuffer);
    }

    public static void nglVertexAttrib4usvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4usvARB(n2, l2);
    }

    public static void glVertexAttrib4usvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLushort const *") ShortBuffer shortBuffer) {
        ARBVertexShader.glVertexAttrib4usvARB(n2, shortBuffer);
    }

    public static void nglVertexAttrib4uivARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4uivARB(n2, l2);
    }

    public static void glVertexAttrib4uivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        ARBVertexShader.glVertexAttrib4uivARB(n2, intBuffer);
    }

    public static void nglVertexAttrib4dvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4dvARB(n2, l2);
    }

    public static void glVertexAttrib4dvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        ARBVertexShader.glVertexAttrib4dvARB(n2, doubleBuffer);
    }

    public static void nglVertexAttrib4NbvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4NbvARB(n2, l2);
    }

    public static void glVertexAttrib4NbvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLbyte const *") ByteBuffer byteBuffer) {
        ARBVertexShader.glVertexAttrib4NbvARB(n2, byteBuffer);
    }

    public static void nglVertexAttrib4NsvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4NsvARB(n2, l2);
    }

    public static void glVertexAttrib4NsvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") ShortBuffer shortBuffer) {
        ARBVertexShader.glVertexAttrib4NsvARB(n2, shortBuffer);
    }

    public static void nglVertexAttrib4NivARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4NivARB(n2, l2);
    }

    public static void glVertexAttrib4NivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        ARBVertexShader.glVertexAttrib4NivARB(n2, intBuffer);
    }

    public static void nglVertexAttrib4NubvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4NubvARB(n2, l2);
    }

    public static void glVertexAttrib4NubvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer) {
        ARBVertexShader.glVertexAttrib4NubvARB(n2, byteBuffer);
    }

    public static void nglVertexAttrib4NusvARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4NusvARB(n2, l2);
    }

    public static void glVertexAttrib4NusvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLushort const *") ShortBuffer shortBuffer) {
        ARBVertexShader.glVertexAttrib4NusvARB(n2, shortBuffer);
    }

    public static void nglVertexAttrib4NuivARB(int n2, long l2) {
        ARBVertexShader.nglVertexAttrib4NuivARB(n2, l2);
    }

    public static void glVertexAttrib4NuivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        ARBVertexShader.glVertexAttrib4NuivARB(n2, intBuffer);
    }

    public static void nglVertexAttribPointerARB(int n2, int n3, int n4, boolean bl2, int n5, long l2) {
        ARBVertexShader.nglVertexAttribPointerARB(n2, n3, n4, bl2, n5, l2);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        ARBVertexShader.glVertexAttribPointerARB(n2, n3, n4, bl2, n5, byteBuffer);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") long l2) {
        ARBVertexShader.glVertexAttribPointerARB(n2, n3, n4, bl2, n5, l2);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        ARBVertexShader.glVertexAttribPointerARB(n2, n3, n4, bl2, n5, shortBuffer);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") IntBuffer intBuffer) {
        ARBVertexShader.glVertexAttribPointerARB(n2, n3, n4, bl2, n5, intBuffer);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        ARBVertexShader.glVertexAttribPointerARB(n2, n3, n4, bl2, n5, floatBuffer);
    }

    public static void glEnableVertexAttribArrayARB(@NativeType(value="GLuint") int n2) {
        ARBVertexShader.glEnableVertexAttribArrayARB(n2);
    }

    public static void glDisableVertexAttribArrayARB(@NativeType(value="GLuint") int n2) {
        ARBVertexShader.glDisableVertexAttribArrayARB(n2);
    }

    public static native void nglProgramStringARB(int var0, int var1, int var2, long var3);

    public static void glProgramStringARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        ARBVertexProgram.nglProgramStringARB(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void glBindProgramARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglDeleteProgramsARB(int var0, long var1);

    public static void glDeleteProgramsARB(@NativeType(value="GLuint const *") IntBuffer intBuffer) {
        ARBVertexProgram.nglDeleteProgramsARB(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglGenProgramsARB(int var0, long var1);

    public static void glGenProgramsARB(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        ARBVertexProgram.nglGenProgramsARB(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenProgramsARB() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBVertexProgram.nglGenProgramsARB(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void glProgramEnvParameter4dARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6, @NativeType(value="GLdouble") double var8);

    public static native void nglProgramEnvParameter4dvARB(int var0, int var1, long var2);

    public static void glProgramEnvParameter4dvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 4);
        }
        ARBVertexProgram.nglProgramEnvParameter4dvARB(n2, n3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glProgramEnvParameter4fARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4, @NativeType(value="GLfloat") float var5);

    public static native void nglProgramEnvParameter4fvARB(int var0, int var1, long var2);

    public static void glProgramEnvParameter4fvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 4);
        }
        ARBVertexProgram.nglProgramEnvParameter4fvARB(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glProgramLocalParameter4dARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6, @NativeType(value="GLdouble") double var8);

    public static native void nglProgramLocalParameter4dvARB(int var0, int var1, long var2);

    public static void glProgramLocalParameter4dvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble const *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 4);
        }
        ARBVertexProgram.nglProgramLocalParameter4dvARB(n2, n3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void glProgramLocalParameter4fARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4, @NativeType(value="GLfloat") float var5);

    public static native void nglProgramLocalParameter4fvARB(int var0, int var1, long var2);

    public static void glProgramLocalParameter4fvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 4);
        }
        ARBVertexProgram.nglProgramLocalParameter4fvARB(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetProgramEnvParameterfvARB(int var0, int var1, long var2);

    public static void glGetProgramEnvParameterfvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 4);
        }
        ARBVertexProgram.nglGetProgramEnvParameterfvARB(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetProgramEnvParameterdvARB(int var0, int var1, long var2);

    public static void glGetProgramEnvParameterdvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 4);
        }
        ARBVertexProgram.nglGetProgramEnvParameterdvARB(n2, n3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglGetProgramLocalParameterfvARB(int var0, int var1, long var2);

    public static void glGetProgramLocalParameterfvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 4);
        }
        ARBVertexProgram.nglGetProgramLocalParameterfvARB(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetProgramLocalParameterdvARB(int var0, int var1, long var2);

    public static void glGetProgramLocalParameterdvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 4);
        }
        ARBVertexProgram.nglGetProgramLocalParameterdvARB(n2, n3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglGetProgramivARB(int var0, int var1, long var2);

    public static void glGetProgramivARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        ARBVertexProgram.nglGetProgramivARB(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetProgramiARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBVertexProgram.nglGetProgramivARB(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetProgramStringARB(int var0, int var1, long var2);

    public static void glGetProgramStringARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)byteBuffer, ARBVertexProgram.glGetProgramiARB(n2, 34343));
        }
        ARBVertexProgram.nglGetProgramStringARB(n2, n3, MemoryUtil.memAddress(byteBuffer));
    }

    public static void nglGetVertexAttribfvARB(int n2, int n3, long l2) {
        ARBVertexShader.nglGetVertexAttribfvARB(n2, n3, l2);
    }

    public static void glGetVertexAttribfvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        ARBVertexShader.glGetVertexAttribfvARB(n2, n3, floatBuffer);
    }

    public static void nglGetVertexAttribdvARB(int n2, int n3, long l2) {
        ARBVertexShader.nglGetVertexAttribdvARB(n2, n3, l2);
    }

    public static void glGetVertexAttribdvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        ARBVertexShader.glGetVertexAttribdvARB(n2, n3, doubleBuffer);
    }

    public static void nglGetVertexAttribivARB(int n2, int n3, long l2) {
        ARBVertexShader.nglGetVertexAttribivARB(n2, n3, l2);
    }

    public static void glGetVertexAttribivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        ARBVertexShader.glGetVertexAttribivARB(n2, n3, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetVertexAttribiARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return ARBVertexShader.glGetVertexAttribiARB(n2, n3);
    }

    public static void nglGetVertexAttribPointervARB(int n2, int n3, long l2) {
        ARBVertexShader.nglGetVertexAttribPointervARB(n2, n3, l2);
    }

    public static void glGetVertexAttribPointervARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void **") PointerBuffer pointerBuffer) {
        ARBVertexShader.glGetVertexAttribPointervARB(n2, n3, pointerBuffer);
    }

    @NativeType(value="void")
    public static long glGetVertexAttribPointerARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return ARBVertexShader.glGetVertexAttribPointerARB(n2, n3);
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsProgramARB(@NativeType(value="GLuint") int var0);

    public static void glVertexAttrib1svARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") short[] sArray) {
        ARBVertexShader.glVertexAttrib1svARB(n2, sArray);
    }

    public static void glVertexAttrib1fvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        ARBVertexShader.glVertexAttrib1fvARB(n2, fArray);
    }

    public static void glVertexAttrib1dvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        ARBVertexShader.glVertexAttrib1dvARB(n2, dArray);
    }

    public static void glVertexAttrib2svARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") short[] sArray) {
        ARBVertexShader.glVertexAttrib2svARB(n2, sArray);
    }

    public static void glVertexAttrib2fvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        ARBVertexShader.glVertexAttrib2fvARB(n2, fArray);
    }

    public static void glVertexAttrib2dvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        ARBVertexShader.glVertexAttrib2dvARB(n2, dArray);
    }

    public static void glVertexAttrib3svARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") short[] sArray) {
        ARBVertexShader.glVertexAttrib3svARB(n2, sArray);
    }

    public static void glVertexAttrib3fvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        ARBVertexShader.glVertexAttrib3fvARB(n2, fArray);
    }

    public static void glVertexAttrib3dvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        ARBVertexShader.glVertexAttrib3dvARB(n2, dArray);
    }

    public static void glVertexAttrib4fvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        ARBVertexShader.glVertexAttrib4fvARB(n2, fArray);
    }

    public static void glVertexAttrib4svARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") short[] sArray) {
        ARBVertexShader.glVertexAttrib4svARB(n2, sArray);
    }

    public static void glVertexAttrib4ivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        ARBVertexShader.glVertexAttrib4ivARB(n2, nArray);
    }

    public static void glVertexAttrib4usvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLushort const *") short[] sArray) {
        ARBVertexShader.glVertexAttrib4usvARB(n2, sArray);
    }

    public static void glVertexAttrib4uivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        ARBVertexShader.glVertexAttrib4uivARB(n2, nArray);
    }

    public static void glVertexAttrib4dvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLdouble const *") double[] dArray) {
        ARBVertexShader.glVertexAttrib4dvARB(n2, dArray);
    }

    public static void glVertexAttrib4NsvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLshort const *") short[] sArray) {
        ARBVertexShader.glVertexAttrib4NsvARB(n2, sArray);
    }

    public static void glVertexAttrib4NivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        ARBVertexShader.glVertexAttrib4NivARB(n2, nArray);
    }

    public static void glVertexAttrib4NusvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLushort const *") short[] sArray) {
        ARBVertexShader.glVertexAttrib4NusvARB(n2, sArray);
    }

    public static void glVertexAttrib4NuivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        ARBVertexShader.glVertexAttrib4NuivARB(n2, nArray);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") short[] sArray) {
        ARBVertexShader.glVertexAttribPointerARB(n2, n3, n4, bl2, n5, sArray);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") int[] nArray) {
        ARBVertexShader.glVertexAttribPointerARB(n2, n3, n4, bl2, n5, nArray);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLsizei") int n5, @NativeType(value="void const *") float[] fArray) {
        ARBVertexShader.glVertexAttribPointerARB(n2, n3, n4, bl2, n5, fArray);
    }

    public static void glDeleteProgramsARB(@NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glDeleteProgramsARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glGenProgramsARB(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGenProgramsARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glProgramEnvParameter4dvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble const *") double[] dArray) {
        long l2 = GL.getICD().glProgramEnvParameter4dvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 4);
        }
        JNI.callPV(n2, n3, dArray, l2);
    }

    public static void glProgramEnvParameter4fvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramEnvParameter4fvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 4);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glProgramLocalParameter4dvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble const *") double[] dArray) {
        long l2 = GL.getICD().glProgramLocalParameter4dvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 4);
        }
        JNI.callPV(n2, n3, dArray, l2);
    }

    public static void glProgramLocalParameter4fvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramLocalParameter4fvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 4);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glGetProgramEnvParameterfvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetProgramEnvParameterfvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 4);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glGetProgramEnvParameterdvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        long l2 = GL.getICD().glGetProgramEnvParameterdvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 4);
        }
        JNI.callPV(n2, n3, dArray, l2);
    }

    public static void glGetProgramLocalParameterfvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetProgramLocalParameterfvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 4);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glGetProgramLocalParameterdvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        long l2 = GL.getICD().glGetProgramLocalParameterdvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(dArray, 4);
        }
        JNI.callPV(n2, n3, dArray, l2);
    }

    public static void glGetProgramivARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetProgramivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetVertexAttribfvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        ARBVertexShader.glGetVertexAttribfvARB(n2, n3, fArray);
    }

    public static void glGetVertexAttribdvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        ARBVertexShader.glGetVertexAttribdvARB(n2, n3, dArray);
    }

    public static void glGetVertexAttribivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        ARBVertexShader.glGetVertexAttribivARB(n2, n3, nArray);
    }

    static {
        GL.initialize();
    }
}

