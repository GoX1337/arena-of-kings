/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTDebugLabel {
    public static final int GL_BUFFER_OBJECT_EXT = 37201;
    public static final int GL_SHADER_OBJECT_EXT = 35656;
    public static final int GL_PROGRAM_OBJECT_EXT = 35648;
    public static final int GL_VERTEX_ARRAY_OBJECT_EXT = 37204;
    public static final int GL_QUERY_OBJECT_EXT = 37203;
    public static final int GL_PROGRAM_PIPELINE_OBJECT_EXT = 35407;

    protected EXTDebugLabel() {
        throw new UnsupportedOperationException();
    }

    public static native void nglLabelObjectEXT(int var0, int var1, int var2, long var3);

    public static void glLabelObjectEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        EXTDebugLabel.nglLabelObjectEXT(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glLabelObjectEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            int n5 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            EXTDebugLabel.nglLabelObjectEXT(n2, n3, n5, l2);
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetObjectLabelEXT(int var0, int var1, int var2, long var3, long var5);

    public static void glGetObjectLabelEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDebugLabel.nglGetObjectLabelEXT(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetObjectLabelEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(0);
            ByteBuffer byteBuffer = memoryStack.malloc(n4);
            EXTDebugLabel.nglGetObjectLabelEXT(n2, n3, n4, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
            String string = MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
            return string;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static void glGetObjectLabelEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetObjectLabelEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPPV(n2, n3, byteBuffer.remaining(), nArray, MemoryUtil.memAddress(byteBuffer), l2);
    }

    static {
        GL.initialize();
    }
}

