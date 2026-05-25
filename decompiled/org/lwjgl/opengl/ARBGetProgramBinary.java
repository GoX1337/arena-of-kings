/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL41C;
import org.lwjgl.system.NativeType;

public class ARBGetProgramBinary {
    public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367;
    public static final int GL_PROGRAM_BINARY_LENGTH = 34625;
    public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814;
    public static final int GL_PROGRAM_BINARY_FORMATS = 34815;

    protected ARBGetProgramBinary() {
        throw new UnsupportedOperationException();
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

    public static void glGetProgramBinary(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLenum *") int[] nArray2, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL41C.glGetProgramBinary(n2, nArray, nArray2, byteBuffer);
    }

    static {
        GL.initialize();
    }
}

