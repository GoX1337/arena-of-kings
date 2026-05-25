/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.system.NativeType;

public class ARBVertexType2_10_10_10_REV {
    public static final int GL_INT_2_10_10_10_REV = 36255;

    protected ARBVertexType2_10_10_10_REV() {
        throw new UnsupportedOperationException();
    }

    public static void glVertexP2ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL33.glVertexP2ui(n2, n3);
    }

    public static void glVertexP3ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL33.glVertexP3ui(n2, n3);
    }

    public static void glVertexP4ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL33.glVertexP4ui(n2, n3);
    }

    public static void nglVertexP2uiv(int n2, long l2) {
        GL33.nglVertexP2uiv(n2, l2);
    }

    public static void glVertexP2uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glVertexP2uiv(n2, intBuffer);
    }

    public static void nglVertexP3uiv(int n2, long l2) {
        GL33.nglVertexP3uiv(n2, l2);
    }

    public static void glVertexP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glVertexP3uiv(n2, intBuffer);
    }

    public static void nglVertexP4uiv(int n2, long l2) {
        GL33.nglVertexP4uiv(n2, l2);
    }

    public static void glVertexP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glVertexP4uiv(n2, intBuffer);
    }

    public static void glTexCoordP1ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL33.glTexCoordP1ui(n2, n3);
    }

    public static void glTexCoordP2ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL33.glTexCoordP2ui(n2, n3);
    }

    public static void glTexCoordP3ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL33.glTexCoordP3ui(n2, n3);
    }

    public static void glTexCoordP4ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL33.glTexCoordP4ui(n2, n3);
    }

    public static void nglTexCoordP1uiv(int n2, long l2) {
        GL33.nglTexCoordP1uiv(n2, l2);
    }

    public static void glTexCoordP1uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glTexCoordP1uiv(n2, intBuffer);
    }

    public static void nglTexCoordP2uiv(int n2, long l2) {
        GL33.nglTexCoordP2uiv(n2, l2);
    }

    public static void glTexCoordP2uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glTexCoordP2uiv(n2, intBuffer);
    }

    public static void nglTexCoordP3uiv(int n2, long l2) {
        GL33.nglTexCoordP3uiv(n2, l2);
    }

    public static void glTexCoordP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glTexCoordP3uiv(n2, intBuffer);
    }

    public static void nglTexCoordP4uiv(int n2, long l2) {
        GL33.nglTexCoordP4uiv(n2, l2);
    }

    public static void glTexCoordP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glTexCoordP4uiv(n2, intBuffer);
    }

    public static void glMultiTexCoordP1ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        GL33.glMultiTexCoordP1ui(n2, n3, n4);
    }

    public static void glMultiTexCoordP2ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        GL33.glMultiTexCoordP2ui(n2, n3, n4);
    }

    public static void glMultiTexCoordP3ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        GL33.glMultiTexCoordP3ui(n2, n3, n4);
    }

    public static void glMultiTexCoordP4ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        GL33.glMultiTexCoordP4ui(n2, n3, n4);
    }

    public static void nglMultiTexCoordP1uiv(int n2, int n3, long l2) {
        GL33.nglMultiTexCoordP1uiv(n2, n3, l2);
    }

    public static void glMultiTexCoordP1uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glMultiTexCoordP1uiv(n2, n3, intBuffer);
    }

    public static void nglMultiTexCoordP2uiv(int n2, int n3, long l2) {
        GL33.nglMultiTexCoordP2uiv(n2, n3, l2);
    }

    public static void glMultiTexCoordP2uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glMultiTexCoordP2uiv(n2, n3, intBuffer);
    }

    public static void nglMultiTexCoordP3uiv(int n2, int n3, long l2) {
        GL33.nglMultiTexCoordP3uiv(n2, n3, l2);
    }

    public static void glMultiTexCoordP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glMultiTexCoordP3uiv(n2, n3, intBuffer);
    }

    public static void nglMultiTexCoordP4uiv(int n2, int n3, long l2) {
        GL33.nglMultiTexCoordP4uiv(n2, n3, l2);
    }

    public static void glMultiTexCoordP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glMultiTexCoordP4uiv(n2, n3, intBuffer);
    }

    public static void glNormalP3ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL33.glNormalP3ui(n2, n3);
    }

    public static void nglNormalP3uiv(int n2, long l2) {
        GL33.nglNormalP3uiv(n2, l2);
    }

    public static void glNormalP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glNormalP3uiv(n2, intBuffer);
    }

    public static void glColorP3ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL33.glColorP3ui(n2, n3);
    }

    public static void glColorP4ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL33.glColorP4ui(n2, n3);
    }

    public static void nglColorP3uiv(int n2, long l2) {
        GL33.nglColorP3uiv(n2, l2);
    }

    public static void glColorP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glColorP3uiv(n2, intBuffer);
    }

    public static void nglColorP4uiv(int n2, long l2) {
        GL33.nglColorP4uiv(n2, l2);
    }

    public static void glColorP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glColorP4uiv(n2, intBuffer);
    }

    public static void glSecondaryColorP3ui(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL33.glSecondaryColorP3ui(n2, n3);
    }

    public static void nglSecondaryColorP3uiv(int n2, long l2) {
        GL33.nglSecondaryColorP3uiv(n2, l2);
    }

    public static void glSecondaryColorP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33.glSecondaryColorP3uiv(n2, intBuffer);
    }

    public static void glVertexAttribP1ui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint") int n4) {
        GL33C.glVertexAttribP1ui(n2, n3, bl2, n4);
    }

    public static void glVertexAttribP2ui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint") int n4) {
        GL33C.glVertexAttribP2ui(n2, n3, bl2, n4);
    }

    public static void glVertexAttribP3ui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint") int n4) {
        GL33C.glVertexAttribP3ui(n2, n3, bl2, n4);
    }

    public static void glVertexAttribP4ui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint") int n4) {
        GL33C.glVertexAttribP4ui(n2, n3, bl2, n4);
    }

    public static void nglVertexAttribP1uiv(int n2, int n3, boolean bl2, long l2) {
        GL33C.nglVertexAttribP1uiv(n2, n3, bl2, l2);
    }

    public static void glVertexAttribP1uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.glVertexAttribP1uiv(n2, n3, bl2, intBuffer);
    }

    public static void nglVertexAttribP2uiv(int n2, int n3, boolean bl2, long l2) {
        GL33C.nglVertexAttribP2uiv(n2, n3, bl2, l2);
    }

    public static void glVertexAttribP2uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.glVertexAttribP2uiv(n2, n3, bl2, intBuffer);
    }

    public static void nglVertexAttribP3uiv(int n2, int n3, boolean bl2, long l2) {
        GL33C.nglVertexAttribP3uiv(n2, n3, bl2, l2);
    }

    public static void glVertexAttribP3uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.glVertexAttribP3uiv(n2, n3, bl2, intBuffer);
    }

    public static void nglVertexAttribP4uiv(int n2, int n3, boolean bl2, long l2) {
        GL33C.nglVertexAttribP4uiv(n2, n3, bl2, l2);
    }

    public static void glVertexAttribP4uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.glVertexAttribP4uiv(n2, n3, bl2, intBuffer);
    }

    public static void glVertexP2uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glVertexP2uiv(n2, nArray);
    }

    public static void glVertexP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glVertexP3uiv(n2, nArray);
    }

    public static void glVertexP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glVertexP4uiv(n2, nArray);
    }

    public static void glTexCoordP1uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glTexCoordP1uiv(n2, nArray);
    }

    public static void glTexCoordP2uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glTexCoordP2uiv(n2, nArray);
    }

    public static void glTexCoordP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glTexCoordP3uiv(n2, nArray);
    }

    public static void glTexCoordP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glTexCoordP4uiv(n2, nArray);
    }

    public static void glMultiTexCoordP1uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glMultiTexCoordP1uiv(n2, n3, nArray);
    }

    public static void glMultiTexCoordP2uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glMultiTexCoordP2uiv(n2, n3, nArray);
    }

    public static void glMultiTexCoordP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glMultiTexCoordP3uiv(n2, n3, nArray);
    }

    public static void glMultiTexCoordP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glMultiTexCoordP4uiv(n2, n3, nArray);
    }

    public static void glNormalP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glNormalP3uiv(n2, nArray);
    }

    public static void glColorP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glColorP3uiv(n2, nArray);
    }

    public static void glColorP4uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glColorP4uiv(n2, nArray);
    }

    public static void glSecondaryColorP3uiv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33.glSecondaryColorP3uiv(n2, nArray);
    }

    public static void glVertexAttribP1uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33C.glVertexAttribP1uiv(n2, n3, bl2, nArray);
    }

    public static void glVertexAttribP2uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33C.glVertexAttribP2uiv(n2, n3, bl2, nArray);
    }

    public static void glVertexAttribP3uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33C.glVertexAttribP3uiv(n2, n3, bl2, nArray);
    }

    public static void glVertexAttribP4uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") int[] nArray) {
        GL33C.glVertexAttribP4uiv(n2, n3, bl2, nArray);
    }

    static {
        GL.initialize();
    }
}

