/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBClearBufferObject {
    protected ARBClearBufferObject() {
        throw new UnsupportedOperationException();
    }

    public static void nglClearBufferData(int n2, int n3, int n4, int n5, long l2) {
        GL43C.nglClearBufferData(n2, n3, n4, n5, l2);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL43C.glClearBufferData(n2, n3, n4, n5, byteBuffer);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL43C.glClearBufferData(n2, n3, n4, n5, shortBuffer);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        GL43C.glClearBufferData(n2, n3, n4, n5, intBuffer);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL43C.glClearBufferData(n2, n3, n4, n5, floatBuffer);
    }

    public static void nglClearBufferSubData(int n2, int n3, long l2, long l3, int n4, int n5, long l4) {
        GL43C.nglClearBufferSubData(n2, n3, l2, l3, n4, n5, l4);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL43C.glClearBufferSubData(n2, n3, l2, l3, n4, n5, byteBuffer);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL43C.glClearBufferSubData(n2, n3, l2, l3, n4, n5, shortBuffer);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        GL43C.glClearBufferSubData(n2, n3, l2, l3, n4, n5, intBuffer);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL43C.glClearBufferSubData(n2, n3, l2, l3, n4, n5, floatBuffer);
    }

    public static native void nglClearNamedBufferDataEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        ARBClearBufferObject.nglClearNamedBufferDataEXT(n2, n3, n4, n5, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        ARBClearBufferObject.nglClearNamedBufferDataEXT(n2, n3, n4, n5, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        ARBClearBufferObject.nglClearNamedBufferDataEXT(n2, n3, n4, n5, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        ARBClearBufferObject.nglClearNamedBufferDataEXT(n2, n3, n4, n5, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static native void nglClearNamedBufferSubDataEXT(int var0, int var1, long var2, long var4, int var6, int var7, long var8);

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(n2, n3, l2, l3, n4, n5, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(n2, n3, l2, l3, n4, n5, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(n2, n3, l2, l3, n4, n5, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(n2, n3, l2, l3, n4, n5, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") short[] sArray) {
        GL43C.glClearBufferData(n2, n3, n4, n5, sArray);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") int[] nArray) {
        GL43C.glClearBufferData(n2, n3, n4, n5, nArray);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") float[] fArray) {
        GL43C.glClearBufferData(n2, n3, n4, n5, fArray);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") short[] sArray) {
        GL43C.glClearBufferSubData(n2, n3, l2, l3, n4, n5, sArray);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") int[] nArray) {
        GL43C.glClearBufferSubData(n2, n3, l2, l3, n4, n5, nArray);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") float[] fArray) {
        GL43C.glClearBufferSubData(n2, n3, l2, l3, n4, n5, fArray);
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glClearNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, sArray, l2);
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glClearNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, nArray, l2);
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glClearNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, fArray, l2);
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l4 = GL.getICD().glClearNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        JNI.callPPPV(n2, n3, l2, l3, n4, n5, sArray, l4);
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l4 = GL.getICD().glClearNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        JNI.callPPPV(n2, n3, l2, l3, n4, n5, nArray, l4);
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l4 = GL.getICD().glClearNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        JNI.callPPPV(n2, n3, l2, l3, n4, n5, fArray, l4);
    }

    static {
        GL.initialize();
    }
}

