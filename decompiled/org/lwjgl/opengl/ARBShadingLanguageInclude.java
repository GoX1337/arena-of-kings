/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBShadingLanguageInclude {
    public static final int GL_SHADER_INCLUDE_ARB = 36270;
    public static final int GL_NAMED_STRING_LENGTH_ARB = 36329;
    public static final int GL_NAMED_STRING_TYPE_ARB = 36330;

    protected ARBShadingLanguageInclude() {
        throw new UnsupportedOperationException();
    }

    public static native void nglNamedStringARB(int var0, int var1, long var2, int var4, long var5);

    public static void glNamedStringARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer, @NativeType(value="GLchar const *") ByteBuffer byteBuffer2) {
        ARBShadingLanguageInclude.nglNamedStringARB(n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), byteBuffer2.remaining(), MemoryUtil.memAddress(byteBuffer2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glNamedStringARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLchar const *") CharSequence charSequence, @NativeType(value="GLchar const *") CharSequence charSequence2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            int n4 = memoryStack.nASCII(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            int n5 = memoryStack.nUTF8(charSequence2, false);
            long l3 = memoryStack.getPointerAddress();
            ARBShadingLanguageInclude.nglNamedStringARB(n2, n4, l2, n5, l3);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nglDeleteNamedStringARB(int var0, long var1);

    public static void glDeleteNamedStringARB(@NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        ARBShadingLanguageInclude.nglDeleteNamedStringARB(byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteNamedStringARB(@NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            int n3 = memoryStack.nASCII(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            ARBShadingLanguageInclude.nglDeleteNamedStringARB(n3, l2);
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nglCompileShaderIncludeARB(int var0, int var1, long var2, long var4);

    public static void glCompileShaderIncludeARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const * const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, pointerBuffer.remaining());
        }
        ARBShadingLanguageInclude.nglCompileShaderIncludeARB(n2, pointerBuffer.remaining(), MemoryUtil.memAddress(pointerBuffer), MemoryUtil.memAddressSafe(intBuffer));
    }

    public static native boolean nglIsNamedStringARB(int var0, long var1);

    @NativeType(value="GLboolean")
    public static boolean glIsNamedStringARB(@NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        return ARBShadingLanguageInclude.nglIsNamedStringARB(byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLboolean")
    public static boolean glIsNamedStringARB(@NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            int n3 = memoryStack.nASCII(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            boolean bl2 = ARBShadingLanguageInclude.nglIsNamedStringARB(n3, l2);
            return bl2;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nglGetNamedStringARB(int var0, long var1, int var3, long var4, long var6);

    public static void glGetNamedStringARB(@NativeType(value="GLchar const *") ByteBuffer byteBuffer, @Nullable @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        ARBShadingLanguageInclude.nglGetNamedStringARB(byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), byteBuffer2.remaining(), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glGetNamedStringARB(@NativeType(value="GLchar const *") CharSequence charSequence, @Nullable @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            int n3 = memoryStack.nASCII(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            ARBShadingLanguageInclude.nglGetNamedStringARB(n3, l2, byteBuffer.remaining(), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer));
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetNamedStringARB(@NativeType(value="GLchar const *") CharSequence charSequence, @NativeType(value="GLsizei") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            int n4 = memoryStack.nASCII(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            IntBuffer intBuffer = memoryStack.ints(0);
            ByteBuffer byteBuffer = memoryStack.malloc(n2);
            ARBShadingLanguageInclude.nglGetNamedStringARB(n4, l2, n2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
            String string = MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
            return string;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    @NativeType(value="void")
    public static String glGetNamedStringARB(@NativeType(value="GLchar const *") CharSequence charSequence) {
        return ARBShadingLanguageInclude.glGetNamedStringARB(charSequence, ARBShadingLanguageInclude.glGetNamedStringiARB(charSequence, 36329));
    }

    public static native void nglGetNamedStringivARB(int var0, long var1, int var3, long var4);

    public static void glGetNamedStringivARB(@NativeType(value="GLchar const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n2, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        ARBShadingLanguageInclude.nglGetNamedStringivARB(byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), n2, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glGetNamedStringivARB(@NativeType(value="GLchar const *") CharSequence charSequence, @NativeType(value="GLenum") int n2, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            int n4 = memoryStack.nASCII(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            ARBShadingLanguageInclude.nglGetNamedStringivARB(n4, l2, n2, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedStringiARB(@NativeType(value="GLchar const *") CharSequence charSequence, @NativeType(value="GLenum") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            int n4 = memoryStack.nASCII(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBShadingLanguageInclude.nglGetNamedStringivARB(n4, l2, n2, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static void glCompileShaderIncludeARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const * const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glCompileShaderIncludeARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, pointerBuffer.remaining());
        }
        JNI.callPPV(n2, pointerBuffer.remaining(), MemoryUtil.memAddress(pointerBuffer), nArray, l2);
    }

    public static void glGetNamedStringARB(@NativeType(value="GLchar const *") ByteBuffer byteBuffer, @Nullable @NativeType(value="GLint *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer2) {
        long l2 = GL.getICD().glGetNamedStringARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
        }
        JNI.callPPPV(byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), byteBuffer2.remaining(), nArray, MemoryUtil.memAddress(byteBuffer2), l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glGetNamedStringARB(@NativeType(value="GLchar const *") CharSequence charSequence, @Nullable @NativeType(value="GLint *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetNamedStringARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            int n3 = memoryStack.nASCII(charSequence, false);
            long l3 = memoryStack.getPointerAddress();
            JNI.callPPPV(n3, l3, byteBuffer.remaining(), nArray, MemoryUtil.memAddress(byteBuffer), l2);
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static void glGetNamedStringivARB(@NativeType(value="GLchar const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n2, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedStringivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPPV(byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), n2, nArray, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glGetNamedStringivARB(@NativeType(value="GLchar const *") CharSequence charSequence, @NativeType(value="GLenum") int n2, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetNamedStringivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            int n4 = memoryStack.nASCII(charSequence, false);
            long l3 = memoryStack.getPointerAddress();
            JNI.callPPV(n4, l3, n2, nArray, l2);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    static {
        GL.initialize();
    }
}

