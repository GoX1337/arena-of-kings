/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBShaderObjects {
    public static final int GL_PROGRAM_OBJECT_ARB = 35648;
    public static final int GL_OBJECT_TYPE_ARB = 35662;
    public static final int GL_OBJECT_SUBTYPE_ARB = 35663;
    public static final int GL_OBJECT_DELETE_STATUS_ARB = 35712;
    public static final int GL_OBJECT_COMPILE_STATUS_ARB = 35713;
    public static final int GL_OBJECT_LINK_STATUS_ARB = 35714;
    public static final int GL_OBJECT_VALIDATE_STATUS_ARB = 35715;
    public static final int GL_OBJECT_INFO_LOG_LENGTH_ARB = 35716;
    public static final int GL_OBJECT_ATTACHED_OBJECTS_ARB = 35717;
    public static final int GL_OBJECT_ACTIVE_UNIFORMS_ARB = 35718;
    public static final int GL_OBJECT_ACTIVE_UNIFORM_MAX_LENGTH_ARB = 35719;
    public static final int GL_OBJECT_SHADER_SOURCE_LENGTH_ARB = 35720;
    public static final int GL_SHADER_OBJECT_ARB = 35656;
    public static final int GL_FLOAT_VEC2_ARB = 35664;
    public static final int GL_FLOAT_VEC3_ARB = 35665;
    public static final int GL_FLOAT_VEC4_ARB = 35666;
    public static final int GL_INT_VEC2_ARB = 35667;
    public static final int GL_INT_VEC3_ARB = 35668;
    public static final int GL_INT_VEC4_ARB = 35669;
    public static final int GL_BOOL_ARB = 35670;
    public static final int GL_BOOL_VEC2_ARB = 35671;
    public static final int GL_BOOL_VEC3_ARB = 35672;
    public static final int GL_BOOL_VEC4_ARB = 35673;
    public static final int GL_FLOAT_MAT2_ARB = 35674;
    public static final int GL_FLOAT_MAT3_ARB = 35675;
    public static final int GL_FLOAT_MAT4_ARB = 35676;
    public static final int GL_SAMPLER_1D_ARB = 35677;
    public static final int GL_SAMPLER_2D_ARB = 35678;
    public static final int GL_SAMPLER_3D_ARB = 35679;
    public static final int GL_SAMPLER_CUBE_ARB = 35680;
    public static final int GL_SAMPLER_1D_SHADOW_ARB = 35681;
    public static final int GL_SAMPLER_2D_SHADOW_ARB = 35682;
    public static final int GL_SAMPLER_2D_RECT_ARB = 35683;
    public static final int GL_SAMPLER_2D_RECT_SHADOW_ARB = 35684;

    protected ARBShaderObjects() {
        throw new UnsupportedOperationException();
    }

    public static native void glDeleteObjectARB(@NativeType(value="GLhandleARB") int var0);

    @NativeType(value="GLhandleARB")
    public static native int glGetHandleARB(@NativeType(value="GLenum") int var0);

    public static native void glDetachObjectARB(@NativeType(value="GLhandleARB") int var0, @NativeType(value="GLhandleARB") int var1);

    @NativeType(value="GLhandleARB")
    public static native int glCreateShaderObjectARB(@NativeType(value="GLenum") int var0);

    public static native void nglShaderSourceARB(int var0, int var1, long var2, long var4);

    public static void glShaderSourceARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLcharARB const **") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, pointerBuffer.remaining());
        }
        ARBShaderObjects.nglShaderSourceARB(n2, pointerBuffer.remaining(), MemoryUtil.memAddress(pointerBuffer), MemoryUtil.memAddressSafe(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glShaderSourceARB(@NativeType(value="GLhandleARB") int n2, CharSequence ... charSequenceArray) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            long l2 = APIUtil.apiArrayi(memoryStack, MemoryUtil::memUTF8, charSequenceArray);
            ARBShaderObjects.nglShaderSourceARB(n2, charSequenceArray.length, l2, l2 - (long)(charSequenceArray.length << 2));
            APIUtil.apiArrayFree(l2, charSequenceArray.length);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glShaderSourceARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLcharARB const **") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            long l2 = APIUtil.apiArrayi(memoryStack, MemoryUtil::memUTF8, charSequence);
            ARBShaderObjects.nglShaderSourceARB(n2, 1, l2, l2 - 4L);
            APIUtil.apiArrayFree(l2, 1);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void glCompileShaderARB(@NativeType(value="GLhandleARB") int var0);

    @NativeType(value="GLhandleARB")
    public static native int glCreateProgramObjectARB();

    public static native void glAttachObjectARB(@NativeType(value="GLhandleARB") int var0, @NativeType(value="GLhandleARB") int var1);

    public static native void glLinkProgramARB(@NativeType(value="GLhandleARB") int var0);

    public static native void glUseProgramObjectARB(@NativeType(value="GLhandleARB") int var0);

    public static native void glValidateProgramARB(@NativeType(value="GLhandleARB") int var0);

    public static native void glUniform1fARB(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1);

    public static native void glUniform2fARB(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glUniform3fARB(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glUniform4fARB(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void glUniform1iARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1);

    public static native void glUniform2iARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glUniform3iARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glUniform4iARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void nglUniform1fvARB(int var0, int var1, long var2);

    public static void glUniform1fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBShaderObjects.nglUniform1fvARB(n2, floatBuffer.remaining(), MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglUniform2fvARB(int var0, int var1, long var2);

    public static void glUniform2fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBShaderObjects.nglUniform2fvARB(n2, floatBuffer.remaining() >> 1, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglUniform3fvARB(int var0, int var1, long var2);

    public static void glUniform3fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBShaderObjects.nglUniform3fvARB(n2, floatBuffer.remaining() / 3, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglUniform4fvARB(int var0, int var1, long var2);

    public static void glUniform4fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBShaderObjects.nglUniform4fvARB(n2, floatBuffer.remaining() >> 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglUniform1ivARB(int var0, int var1, long var2);

    public static void glUniform1ivARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        ARBShaderObjects.nglUniform1ivARB(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglUniform2ivARB(int var0, int var1, long var2);

    public static void glUniform2ivARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        ARBShaderObjects.nglUniform2ivARB(n2, intBuffer.remaining() >> 1, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglUniform3ivARB(int var0, int var1, long var2);

    public static void glUniform3ivARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        ARBShaderObjects.nglUniform3ivARB(n2, intBuffer.remaining() / 3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglUniform4ivARB(int var0, int var1, long var2);

    public static void glUniform4ivARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        ARBShaderObjects.nglUniform4ivARB(n2, intBuffer.remaining() >> 2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglUniformMatrix2fvARB(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix2fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBShaderObjects.nglUniformMatrix2fvARB(n2, floatBuffer.remaining() >> 2, bl2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglUniformMatrix3fvARB(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix3fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBShaderObjects.nglUniformMatrix3fvARB(n2, floatBuffer.remaining() / 9, bl2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglUniformMatrix4fvARB(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix4fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBShaderObjects.nglUniformMatrix4fvARB(n2, floatBuffer.remaining() >> 4, bl2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetObjectParameterfvARB(int var0, int var1, long var2);

    public static void glGetObjectParameterfvARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        ARBShaderObjects.nglGetObjectParameterfvARB(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetObjectParameterivARB(int var0, int var1, long var2);

    public static void glGetObjectParameterivARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        ARBShaderObjects.nglGetObjectParameterivARB(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetObjectParameteriARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBShaderObjects.nglGetObjectParameterivARB(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetInfoLogARB(int var0, int var1, long var2, long var4);

    public static void glGetInfoLogARB(@NativeType(value="GLhandleARB") int n2, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLcharARB *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        ARBShaderObjects.nglGetInfoLogARB(n2, byteBuffer.remaining(), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetInfoLogARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLsizei") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        ByteBuffer byteBuffer = MemoryUtil.memAlloc(n3);
        try {
            IntBuffer intBuffer = memoryStack.ints(0);
            ARBShaderObjects.nglGetInfoLogARB(n2, n3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
            String string = MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
            return string;
        }
        finally {
            MemoryUtil.memFree(byteBuffer);
            memoryStack.setPointer(n4);
        }
    }

    @NativeType(value="void")
    public static String glGetInfoLogARB(@NativeType(value="GLhandleARB") int n2) {
        return ARBShaderObjects.glGetInfoLogARB(n2, ARBShaderObjects.glGetObjectParameteriARB(n2, 35716));
    }

    public static native void nglGetAttachedObjectsARB(int var0, int var1, long var2, long var4);

    public static void glGetAttachedObjectsARB(@NativeType(value="GLhandleARB") int n2, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLhandleARB *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        ARBShaderObjects.nglGetAttachedObjectsARB(n2, intBuffer2.remaining(), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(intBuffer2));
    }

    public static native int nglGetUniformLocationARB(int var0, long var1);

    @NativeType(value="GLint")
    public static int glGetUniformLocationARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLcharARB const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return ARBShaderObjects.nglGetUniformLocationARB(n2, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetUniformLocationARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLcharARB const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n4 = ARBShaderObjects.nglGetUniformLocationARB(n2, l2);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nglGetActiveUniformARB(int var0, int var1, int var2, long var3, long var5, long var7, long var9);

    public static void glGetActiveUniformARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLint *") IntBuffer intBuffer2, @NativeType(value="GLenum *") IntBuffer intBuffer3, @NativeType(value="GLcharARB *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
            Checks.check((Buffer)intBuffer3, 1);
        }
        ARBShaderObjects.nglGetActiveUniformARB(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(intBuffer2), MemoryUtil.memAddress(intBuffer3), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetActiveUniformARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLenum *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer3 = memoryStack.ints(0);
            ByteBuffer byteBuffer = memoryStack.malloc(n4);
            ARBShaderObjects.nglGetActiveUniformARB(n2, n3, n4, MemoryUtil.memAddress(intBuffer3), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2), MemoryUtil.memAddress(byteBuffer));
            String string = MemoryUtil.memUTF8(byteBuffer, intBuffer3.get(0));
            return string;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    @NativeType(value="void")
    public static String glGetActiveUniformARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLenum *") IntBuffer intBuffer2) {
        return ARBShaderObjects.glGetActiveUniformARB(n2, n3, ARBShaderObjects.glGetObjectParameteriARB(n2, 35719), intBuffer, intBuffer2);
    }

    public static native void nglGetUniformfvARB(int var0, int var1, long var2);

    public static void glGetUniformfvARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        ARBShaderObjects.nglGetUniformfvARB(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetUniformfARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            ARBShaderObjects.nglGetUniformfvARB(n2, n3, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetUniformivARB(int var0, int var1, long var2);

    public static void glGetUniformivARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        ARBShaderObjects.nglGetUniformivARB(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetUniformiARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBShaderObjects.nglGetUniformivARB(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetShaderSourceARB(int var0, int var1, long var2, long var4);

    public static void glGetShaderSourceARB(@NativeType(value="GLhandleARB") int n2, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLcharARB *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        ARBShaderObjects.nglGetShaderSourceARB(n2, byteBuffer.remaining(), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetShaderSourceARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLsizei") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        ByteBuffer byteBuffer = MemoryUtil.memAlloc(n3);
        try {
            IntBuffer intBuffer = memoryStack.ints(0);
            ARBShaderObjects.nglGetShaderSourceARB(n2, n3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
            String string = MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
            return string;
        }
        finally {
            MemoryUtil.memFree(byteBuffer);
            memoryStack.setPointer(n4);
        }
    }

    @NativeType(value="void")
    public static String glGetShaderSourceARB(@NativeType(value="GLhandleARB") int n2) {
        return ARBShaderObjects.glGetShaderSourceARB(n2, ARBShaderObjects.glGetObjectParameteriARB(n2, 35720));
    }

    public static void glShaderSourceARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLcharARB const **") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glShaderSourceARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, pointerBuffer.remaining());
        }
        JNI.callPPV(n2, pointerBuffer.remaining(), MemoryUtil.memAddress(pointerBuffer), nArray, l2);
    }

    public static void glUniform1fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glUniform1fvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, fArray.length, fArray, l2);
    }

    public static void glUniform2fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glUniform2fvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, fArray.length >> 1, fArray, l2);
    }

    public static void glUniform3fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glUniform3fvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, fArray.length / 3, fArray, l2);
    }

    public static void glUniform4fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glUniform4fvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, fArray.length >> 2, fArray, l2);
    }

    public static void glUniform1ivARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glUniform1ivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length, nArray, l2);
    }

    public static void glUniform2ivARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glUniform2ivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length >> 1, nArray, l2);
    }

    public static void glUniform3ivARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glUniform3ivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length / 3, nArray, l2);
    }

    public static void glUniform4ivARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glUniform4ivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length >> 2, nArray, l2);
    }

    public static void glUniformMatrix2fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glUniformMatrix2fvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, fArray.length >> 2, bl2, fArray, l2);
    }

    public static void glUniformMatrix3fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glUniformMatrix3fvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, fArray.length / 9, bl2, fArray, l2);
    }

    public static void glUniformMatrix4fvARB(@NativeType(value="GLint") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glUniformMatrix4fvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, fArray.length >> 4, bl2, fArray, l2);
    }

    public static void glGetObjectParameterfvARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetObjectParameterfvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glGetObjectParameterivARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetObjectParameterivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetInfoLogARB(@NativeType(value="GLhandleARB") int n2, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLcharARB *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetInfoLogARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
        }
        JNI.callPPV(n2, byteBuffer.remaining(), nArray, MemoryUtil.memAddress(byteBuffer), l2);
    }

    public static void glGetAttachedObjectsARB(@NativeType(value="GLhandleARB") int n2, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLhandleARB *") int[] nArray2) {
        long l2 = GL.getICD().glGetAttachedObjectsARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
        }
        JNI.callPPV(n2, nArray2.length, nArray, nArray2, l2);
    }

    public static void glGetActiveUniformARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLint *") int[] nArray2, @NativeType(value="GLenum *") int[] nArray3, @NativeType(value="GLcharARB *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetActiveUniformARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
            Checks.check(nArray2, 1);
            Checks.check(nArray3, 1);
        }
        JNI.callPPPPV(n2, n3, byteBuffer.remaining(), nArray, nArray2, nArray3, MemoryUtil.memAddress(byteBuffer), l2);
    }

    public static void glGetUniformfvARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetUniformfvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glGetUniformivARB(@NativeType(value="GLhandleARB") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetUniformivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetShaderSourceARB(@NativeType(value="GLhandleARB") int n2, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLcharARB *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetShaderSourceARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
        }
        JNI.callPPV(n2, byteBuffer.remaining(), nArray, MemoryUtil.memAddress(byteBuffer), l2);
    }

    static {
        GL.initialize();
    }
}

