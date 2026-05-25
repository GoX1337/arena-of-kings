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
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class INTELMapTexture {
    public static final int GL_TEXTURE_MEMORY_LAYOUT_INTEL = 33791;
    public static final int GL_LAYOUT_DEFAULT_INTEL = 0;
    public static final int GL_LAYOUT_LINEAR_INTEL = 1;
    public static final int GL_LAYOUT_LINEAR_CPU_CACHED_INTEL = 2;

    protected INTELMapTexture() {
        throw new UnsupportedOperationException();
    }

    public static native void glSyncTextureINTEL(@NativeType(value="GLuint") int var0);

    public static native void glUnmapTexture2DINTEL(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1);

    public static native long nglMapTexture2DINTEL(int var0, int var1, int var2, long var3, long var5);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapTexture2DINTEL(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLbitfield") int n4, @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLenum *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        long l2 = INTELMapTexture.nglMapTexture2DINTEL(n2, n3, n4, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2));
        return MemoryUtil.memByteBufferSafe(l2, INTELMapTexture.getStride(intBuffer) * GLChecks.getTexLevelParameteri(n2, 3553, n3, 4097));
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapTexture2DINTEL(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLbitfield") int n4, @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLenum *") IntBuffer intBuffer2, @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        long l2 = INTELMapTexture.nglMapTexture2DINTEL(n2, n3, n4, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2));
        int n5 = INTELMapTexture.getStride(intBuffer) * GLChecks.getTexLevelParameteri(n2, 3553, n3, 4097);
        return APIUtil.apiGetMappedBuffer(byteBuffer, l2, n5);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapTexture2DINTEL(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLbitfield") int n4, @NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLenum *") IntBuffer intBuffer2, long l2, @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        long l3 = INTELMapTexture.nglMapTexture2DINTEL(n2, n3, n4, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2));
        return APIUtil.apiGetMappedBuffer(byteBuffer, l3, (int)l2);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapTexture2DINTEL(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLbitfield") int n4, @NativeType(value="GLint *") int[] nArray, @NativeType(value="GLenum *") int[] nArray2) {
        long l2 = GL.getICD().glMapTexture2DINTEL;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
        }
        long l3 = JNI.callPPP(n2, n3, n4, nArray, nArray2, l2);
        return MemoryUtil.memByteBufferSafe(l3, INTELMapTexture.getStride(nArray) * GLChecks.getTexLevelParameteri(n2, 3553, n3, 4097));
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapTexture2DINTEL(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLbitfield") int n4, @NativeType(value="GLint *") int[] nArray, @NativeType(value="GLenum *") int[] nArray2, @Nullable ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glMapTexture2DINTEL;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
        }
        long l3 = JNI.callPPP(n2, n3, n4, nArray, nArray2, l2);
        int n5 = INTELMapTexture.getStride(nArray) * GLChecks.getTexLevelParameteri(n2, 3553, n3, 4097);
        return APIUtil.apiGetMappedBuffer(byteBuffer, l3, n5);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapTexture2DINTEL(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLbitfield") int n4, @NativeType(value="GLint *") int[] nArray, @NativeType(value="GLenum *") int[] nArray2, long l2, @Nullable ByteBuffer byteBuffer) {
        long l3 = GL.getICD().glMapTexture2DINTEL;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
        }
        long l4 = JNI.callPPP(n2, n3, n4, nArray, nArray2, l3);
        return APIUtil.apiGetMappedBuffer(byteBuffer, l4, (int)l2);
    }

    private static int getStride(IntBuffer intBuffer) {
        return intBuffer.get(intBuffer.position());
    }

    private static int getStride(int[] nArray) {
        return nArray[0];
    }

    static {
        GL.initialize();
    }
}

