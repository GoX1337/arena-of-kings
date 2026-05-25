/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTSeparateShaderObjects {
    public static final int GL_ACTIVE_PROGRAM_EXT = 35725;

    protected EXTSeparateShaderObjects() {
        throw new UnsupportedOperationException();
    }

    public static native void glUseShaderProgramEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glActiveProgramEXT(@NativeType(value="GLuint") int var0);

    public static native int nglCreateShaderProgramEXT(int var0, long var1);

    @NativeType(value="GLuint")
    public static int glCreateShaderProgramEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return EXTSeparateShaderObjects.nglCreateShaderProgramEXT(n2, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLuint")
    public static int glCreateShaderProgramEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n4 = EXTSeparateShaderObjects.nglCreateShaderProgramEXT(n2, l2);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    static {
        GL.initialize();
    }
}

