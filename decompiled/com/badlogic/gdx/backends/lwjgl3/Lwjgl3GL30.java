/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL21;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GL41;
import org.lwjgl.opengl.GL43;

class Lwjgl3GL30
extends Lwjgl3GL20
implements GL30 {
    Lwjgl3GL30() {
    }

    @Override
    public void glReadBuffer(int n2) {
        GL11.glReadBuffer(n2);
    }

    @Override
    public void glDrawRangeElements(int n2, int n3, int n4, int n5, int n6, Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            GL12.glDrawRangeElements(n2, n3, n4, (ByteBuffer)buffer);
        } else if (buffer instanceof ShortBuffer) {
            GL12.glDrawRangeElements(n2, n3, n4, (ShortBuffer)buffer);
        } else if (buffer instanceof IntBuffer) {
            GL12.glDrawRangeElements(n2, n3, n4, (IntBuffer)buffer);
        } else {
            throw new GdxRuntimeException("indices must be byte, short or int buffer");
        }
    }

    @Override
    public void glDrawRangeElements(int n2, int n3, int n4, int n5, int n6, int n7) {
        GL12.glDrawRangeElements(n2, n3, n4, n5, n6, n7);
    }

    @Override
    public void glTexImage3D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, Buffer buffer) {
        if (buffer == null) {
            GL12.glTexImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, (ByteBuffer)null);
        } else if (buffer instanceof ByteBuffer) {
            GL12.glTexImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, (ByteBuffer)buffer);
        } else if (buffer instanceof ShortBuffer) {
            GL12.glTexImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, (ShortBuffer)buffer);
        } else if (buffer instanceof IntBuffer) {
            GL12.glTexImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, (IntBuffer)buffer);
        } else if (buffer instanceof FloatBuffer) {
            GL12.glTexImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, (FloatBuffer)buffer);
        } else if (buffer instanceof DoubleBuffer) {
            GL12.glTexImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, (DoubleBuffer)buffer);
        } else {
            throw new GdxRuntimeException("Can't use " + buffer.getClass().getName() + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer, FloatBuffer or DoubleBuffer instead. Blame LWJGL");
        }
    }

    @Override
    public void glTexImage3D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        GL12.glTexImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11);
    }

    @Override
    public void glTexSubImage3D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            GL12.glTexSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, (ByteBuffer)buffer);
        } else if (buffer instanceof ShortBuffer) {
            GL12.glTexSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, (ShortBuffer)buffer);
        } else if (buffer instanceof IntBuffer) {
            GL12.glTexSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, (IntBuffer)buffer);
        } else if (buffer instanceof FloatBuffer) {
            GL12.glTexSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, (FloatBuffer)buffer);
        } else if (buffer instanceof DoubleBuffer) {
            GL12.glTexSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, (DoubleBuffer)buffer);
        } else {
            throw new GdxRuntimeException("Can't use " + buffer.getClass().getName() + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer, FloatBuffer or DoubleBuffer instead. Blame LWJGL");
        }
    }

    @Override
    public void glTexSubImage3D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        GL12.glTexSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12);
    }

    @Override
    public void glCopyTexSubImage3D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        GL12.glCopyTexSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10);
    }

    @Override
    public void glGenQueries(int n2, int[] nArray, int n3) {
        for (int i2 = n3; i2 < n3 + n2; ++i2) {
            nArray[i2] = GL15.glGenQueries();
        }
    }

    @Override
    public void glGenQueries(int n2, IntBuffer intBuffer) {
        for (int i2 = 0; i2 < n2; ++i2) {
            intBuffer.put(GL15.glGenQueries());
        }
    }

    @Override
    public void glDeleteQueries(int n2, int[] nArray, int n3) {
        for (int i2 = n3; i2 < n3 + n2; ++i2) {
            GL15.glDeleteQueries(nArray[i2]);
        }
    }

    @Override
    public void glDeleteQueries(int n2, IntBuffer intBuffer) {
        for (int i2 = 0; i2 < n2; ++i2) {
            GL15.glDeleteQueries(intBuffer.get());
        }
    }

    @Override
    public boolean glIsQuery(int n2) {
        return GL15.glIsQuery(n2);
    }

    @Override
    public void glBeginQuery(int n2, int n3) {
        GL15.glBeginQuery(n2, n3);
    }

    @Override
    public void glEndQuery(int n2) {
        GL15.glEndQuery(n2);
    }

    @Override
    public void glGetQueryiv(int n2, int n3, IntBuffer intBuffer) {
        GL15.glGetQueryiv(n2, n3, intBuffer);
    }

    @Override
    public void glGetQueryObjectuiv(int n2, int n3, IntBuffer intBuffer) {
        GL15.glGetQueryObjectuiv(n2, n3, intBuffer);
    }

    @Override
    public boolean glUnmapBuffer(int n2) {
        return GL15.glUnmapBuffer(n2);
    }

    @Override
    public Buffer glGetBufferPointerv(int n2, int n3) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void glDrawBuffers(int n2, IntBuffer intBuffer) {
        int n3 = intBuffer.limit();
        ((Buffer)intBuffer).limit(n2);
        GL20.glDrawBuffers(intBuffer);
        ((Buffer)intBuffer).limit(n3);
    }

    @Override
    public void glUniformMatrix2x3fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        GL21.glUniformMatrix2x3fv(n2, bl2, floatBuffer);
    }

    @Override
    public void glUniformMatrix3x2fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        GL21.glUniformMatrix3x2fv(n2, bl2, floatBuffer);
    }

    @Override
    public void glUniformMatrix2x4fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        GL21.glUniformMatrix2x4fv(n2, bl2, floatBuffer);
    }

    @Override
    public void glUniformMatrix4x2fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        GL21.glUniformMatrix4x2fv(n2, bl2, floatBuffer);
    }

    @Override
    public void glUniformMatrix3x4fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        GL21.glUniformMatrix3x4fv(n2, bl2, floatBuffer);
    }

    @Override
    public void glUniformMatrix4x3fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        GL21.glUniformMatrix4x3fv(n2, bl2, floatBuffer);
    }

    @Override
    public void glBlitFramebuffer(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        org.lwjgl.opengl.GL30.glBlitFramebuffer(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11);
    }

    @Override
    public void glBindFramebuffer(int n2, int n3) {
        org.lwjgl.opengl.GL30.glBindFramebuffer(n2, n3);
    }

    @Override
    public void glBindRenderbuffer(int n2, int n3) {
        org.lwjgl.opengl.GL30.glBindRenderbuffer(n2, n3);
    }

    @Override
    public int glCheckFramebufferStatus(int n2) {
        return org.lwjgl.opengl.GL30.glCheckFramebufferStatus(n2);
    }

    @Override
    public void glDeleteFramebuffers(int n2, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glDeleteFramebuffers(intBuffer);
    }

    @Override
    public void glDeleteFramebuffer(int n2) {
        org.lwjgl.opengl.GL30.glDeleteFramebuffers(n2);
    }

    @Override
    public void glDeleteRenderbuffers(int n2, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glDeleteRenderbuffers(intBuffer);
    }

    @Override
    public void glDeleteRenderbuffer(int n2) {
        org.lwjgl.opengl.GL30.glDeleteRenderbuffers(n2);
    }

    @Override
    public void glGenerateMipmap(int n2) {
        org.lwjgl.opengl.GL30.glGenerateMipmap(n2);
    }

    @Override
    public void glGenFramebuffers(int n2, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glGenFramebuffers(intBuffer);
    }

    @Override
    public int glGenFramebuffer() {
        return org.lwjgl.opengl.GL30.glGenFramebuffers();
    }

    @Override
    public void glGenRenderbuffers(int n2, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glGenRenderbuffers(intBuffer);
    }

    @Override
    public int glGenRenderbuffer() {
        return org.lwjgl.opengl.GL30.glGenRenderbuffers();
    }

    @Override
    public void glGetRenderbufferParameteriv(int n2, int n3, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glGetRenderbufferParameteriv(n2, n3, intBuffer);
    }

    @Override
    public boolean glIsFramebuffer(int n2) {
        return org.lwjgl.opengl.GL30.glIsFramebuffer(n2);
    }

    @Override
    public boolean glIsRenderbuffer(int n2) {
        return org.lwjgl.opengl.GL30.glIsRenderbuffer(n2);
    }

    @Override
    public void glRenderbufferStorage(int n2, int n3, int n4, int n5) {
        org.lwjgl.opengl.GL30.glRenderbufferStorage(n2, n3, n4, n5);
    }

    @Override
    public void glRenderbufferStorageMultisample(int n2, int n3, int n4, int n5, int n6) {
        org.lwjgl.opengl.GL30.glRenderbufferStorageMultisample(n2, n3, n4, n5, n6);
    }

    @Override
    public void glFramebufferTexture2D(int n2, int n3, int n4, int n5, int n6) {
        org.lwjgl.opengl.GL30.glFramebufferTexture2D(n2, n3, n4, n5, n6);
    }

    @Override
    public void glFramebufferRenderbuffer(int n2, int n3, int n4, int n5) {
        org.lwjgl.opengl.GL30.glFramebufferRenderbuffer(n2, n3, n4, n5);
    }

    @Override
    public void glFramebufferTextureLayer(int n2, int n3, int n4, int n5, int n6) {
        org.lwjgl.opengl.GL30.glFramebufferTextureLayer(n2, n3, n4, n5, n6);
    }

    @Override
    public Buffer glMapBufferRange(int n2, int n3, int n4, int n5) {
        return org.lwjgl.opengl.GL30.glMapBufferRange(n2, n3, n4, n5, null);
    }

    @Override
    public void glFlushMappedBufferRange(int n2, int n3, int n4) {
        org.lwjgl.opengl.GL30.glFlushMappedBufferRange(n2, n3, n4);
    }

    @Override
    public void glBindVertexArray(int n2) {
        org.lwjgl.opengl.GL30.glBindVertexArray(n2);
    }

    @Override
    public void glDeleteVertexArrays(int n2, int[] nArray, int n3) {
        for (int i2 = n3; i2 < n3 + n2; ++i2) {
            org.lwjgl.opengl.GL30.glDeleteVertexArrays(nArray[i2]);
        }
    }

    @Override
    public void glDeleteVertexArrays(int n2, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glDeleteVertexArrays(intBuffer);
    }

    @Override
    public void glGenVertexArrays(int n2, int[] nArray, int n3) {
        for (int i2 = n3; i2 < n3 + n2; ++i2) {
            nArray[i2] = org.lwjgl.opengl.GL30.glGenVertexArrays();
        }
    }

    @Override
    public void glGenVertexArrays(int n2, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glGenVertexArrays(intBuffer);
    }

    @Override
    public boolean glIsVertexArray(int n2) {
        return org.lwjgl.opengl.GL30.glIsVertexArray(n2);
    }

    @Override
    public void glBeginTransformFeedback(int n2) {
        org.lwjgl.opengl.GL30.glBeginTransformFeedback(n2);
    }

    @Override
    public void glEndTransformFeedback() {
        org.lwjgl.opengl.GL30.glEndTransformFeedback();
    }

    @Override
    public void glBindBufferRange(int n2, int n3, int n4, int n5, int n6) {
        org.lwjgl.opengl.GL30.glBindBufferRange(n2, n3, n4, n5, n6);
    }

    @Override
    public void glBindBufferBase(int n2, int n3, int n4) {
        org.lwjgl.opengl.GL30.glBindBufferBase(n2, n3, n4);
    }

    @Override
    public void glTransformFeedbackVaryings(int n2, String[] stringArray, int n3) {
        org.lwjgl.opengl.GL30.glTransformFeedbackVaryings(n2, stringArray, n3);
    }

    @Override
    public void glVertexAttribIPointer(int n2, int n3, int n4, int n5, int n6) {
        org.lwjgl.opengl.GL30.glVertexAttribIPointer(n2, n3, n4, n5, n6);
    }

    @Override
    public void glGetVertexAttribIiv(int n2, int n3, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glGetVertexAttribIiv(n2, n3, intBuffer);
    }

    @Override
    public void glGetVertexAttribIuiv(int n2, int n3, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glGetVertexAttribIuiv(n2, n3, intBuffer);
    }

    @Override
    public void glVertexAttribI4i(int n2, int n3, int n4, int n5, int n6) {
        org.lwjgl.opengl.GL30.glVertexAttribI4i(n2, n3, n4, n5, n6);
    }

    @Override
    public void glVertexAttribI4ui(int n2, int n3, int n4, int n5, int n6) {
        org.lwjgl.opengl.GL30.glVertexAttribI4ui(n2, n3, n4, n5, n6);
    }

    @Override
    public void glGetUniformuiv(int n2, int n3, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glGetUniformuiv(n2, n3, intBuffer);
    }

    @Override
    public int glGetFragDataLocation(int n2, String string) {
        return org.lwjgl.opengl.GL30.glGetFragDataLocation(n2, string);
    }

    @Override
    public void glUniform1uiv(int n2, int n3, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glUniform1uiv(n2, intBuffer);
    }

    @Override
    public void glUniform3uiv(int n2, int n3, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glUniform3uiv(n2, intBuffer);
    }

    @Override
    public void glUniform4uiv(int n2, int n3, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glUniform4uiv(n2, intBuffer);
    }

    @Override
    public void glClearBufferiv(int n2, int n3, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glClearBufferiv(n2, n3, intBuffer);
    }

    @Override
    public void glClearBufferuiv(int n2, int n3, IntBuffer intBuffer) {
        org.lwjgl.opengl.GL30.glClearBufferuiv(n2, n3, intBuffer);
    }

    @Override
    public void glClearBufferfv(int n2, int n3, FloatBuffer floatBuffer) {
        org.lwjgl.opengl.GL30.glClearBufferfv(n2, n3, floatBuffer);
    }

    @Override
    public void glClearBufferfi(int n2, int n3, float f2, int n4) {
        org.lwjgl.opengl.GL30.glClearBufferfi(n2, n3, f2, n4);
    }

    @Override
    public String glGetStringi(int n2, int n3) {
        return org.lwjgl.opengl.GL30.glGetStringi(n2, n3);
    }

    @Override
    public void glCopyBufferSubData(int n2, int n3, int n4, int n5, int n6) {
        GL31.glCopyBufferSubData(n2, n3, n4, n5, n6);
    }

    @Override
    public void glGetUniformIndices(int n2, String[] stringArray, IntBuffer intBuffer) {
        GL31.glGetUniformIndices(n2, stringArray, intBuffer);
    }

    @Override
    public void glGetActiveUniformsiv(int n2, int n3, IntBuffer intBuffer, int n4, IntBuffer intBuffer2) {
        GL31.glGetActiveUniformsiv(n2, intBuffer, n4, intBuffer2);
    }

    @Override
    public int glGetUniformBlockIndex(int n2, String string) {
        return GL31.glGetUniformBlockIndex(n2, string);
    }

    @Override
    public void glGetActiveUniformBlockiv(int n2, int n3, int n4, IntBuffer intBuffer) {
        GL31.glGetActiveUniformBlockiv(n2, n3, n4, intBuffer);
    }

    @Override
    public void glGetActiveUniformBlockName(int n2, int n3, Buffer buffer, Buffer buffer2) {
        GL31.glGetActiveUniformBlockName(n2, n3, (IntBuffer)buffer, (ByteBuffer)buffer2);
    }

    @Override
    public String glGetActiveUniformBlockName(int n2, int n3) {
        return GL31.glGetActiveUniformBlockName(n2, n3, 1024);
    }

    @Override
    public void glUniformBlockBinding(int n2, int n3, int n4) {
        GL31.glUniformBlockBinding(n2, n3, n4);
    }

    @Override
    public void glDrawArraysInstanced(int n2, int n3, int n4, int n5) {
        GL31.glDrawArraysInstanced(n2, n3, n4, n5);
    }

    @Override
    public void glDrawElementsInstanced(int n2, int n3, int n4, int n5, int n6) {
        GL31.glDrawElementsInstanced(n2, n3, n4, n5, n6);
    }

    @Override
    public void glGetInteger64v(int n2, LongBuffer longBuffer) {
        GL32.glGetInteger64v(n2, longBuffer);
    }

    @Override
    public void glGetBufferParameteri64v(int n2, int n3, LongBuffer longBuffer) {
        longBuffer.put(GL32.glGetBufferParameteri64(n2, n3));
    }

    @Override
    public void glGenSamplers(int n2, int[] nArray, int n3) {
        for (int i2 = n3; i2 < n3 + n2; ++i2) {
            nArray[i2] = GL33.glGenSamplers();
        }
    }

    @Override
    public void glGenSamplers(int n2, IntBuffer intBuffer) {
        GL33.glGenSamplers(intBuffer);
    }

    @Override
    public void glDeleteSamplers(int n2, int[] nArray, int n3) {
        for (int i2 = n3; i2 < n3 + n2; ++i2) {
            GL33.glDeleteSamplers(nArray[i2]);
        }
    }

    @Override
    public void glDeleteSamplers(int n2, IntBuffer intBuffer) {
        GL33.glDeleteSamplers(intBuffer);
    }

    @Override
    public boolean glIsSampler(int n2) {
        return GL33.glIsSampler(n2);
    }

    @Override
    public void glBindSampler(int n2, int n3) {
        GL33.glBindSampler(n2, n3);
    }

    @Override
    public void glSamplerParameteri(int n2, int n3, int n4) {
        GL33.glSamplerParameteri(n2, n3, n4);
    }

    @Override
    public void glSamplerParameteriv(int n2, int n3, IntBuffer intBuffer) {
        GL33.glSamplerParameteriv(n2, n3, intBuffer);
    }

    @Override
    public void glSamplerParameterf(int n2, int n3, float f2) {
        GL33.glSamplerParameterf(n2, n3, f2);
    }

    @Override
    public void glSamplerParameterfv(int n2, int n3, FloatBuffer floatBuffer) {
        GL33.glSamplerParameterfv(n2, n3, floatBuffer);
    }

    @Override
    public void glGetSamplerParameteriv(int n2, int n3, IntBuffer intBuffer) {
        GL33.glGetSamplerParameterIiv(n2, n3, intBuffer);
    }

    @Override
    public void glGetSamplerParameterfv(int n2, int n3, FloatBuffer floatBuffer) {
        GL33.glGetSamplerParameterfv(n2, n3, floatBuffer);
    }

    @Override
    public void glVertexAttribDivisor(int n2, int n3) {
        GL33.glVertexAttribDivisor(n2, n3);
    }

    @Override
    public void glBindTransformFeedback(int n2, int n3) {
        GL40.glBindTransformFeedback(n2, n3);
    }

    @Override
    public void glDeleteTransformFeedbacks(int n2, int[] nArray, int n3) {
        for (int i2 = n3; i2 < n3 + n2; ++i2) {
            GL40.glDeleteTransformFeedbacks(nArray[i2]);
        }
    }

    @Override
    public void glDeleteTransformFeedbacks(int n2, IntBuffer intBuffer) {
        GL40.glDeleteTransformFeedbacks(intBuffer);
    }

    @Override
    public void glGenTransformFeedbacks(int n2, int[] nArray, int n3) {
        for (int i2 = n3; i2 < n3 + n2; ++i2) {
            nArray[i2] = GL40.glGenTransformFeedbacks();
        }
    }

    @Override
    public void glGenTransformFeedbacks(int n2, IntBuffer intBuffer) {
        GL40.glGenTransformFeedbacks(intBuffer);
    }

    @Override
    public boolean glIsTransformFeedback(int n2) {
        return GL40.glIsTransformFeedback(n2);
    }

    @Override
    public void glPauseTransformFeedback() {
        GL40.glPauseTransformFeedback();
    }

    @Override
    public void glResumeTransformFeedback() {
        GL40.glResumeTransformFeedback();
    }

    @Override
    public void glProgramParameteri(int n2, int n3, int n4) {
        GL41.glProgramParameteri(n2, n3, n4);
    }

    @Override
    public void glInvalidateFramebuffer(int n2, int n3, IntBuffer intBuffer) {
        GL43.glInvalidateFramebuffer(n2, intBuffer);
    }

    @Override
    public void glInvalidateSubFramebuffer(int n2, int n3, IntBuffer intBuffer, int n4, int n5, int n6, int n7) {
        GL43.glInvalidateSubFramebuffer(n2, intBuffer, n4, n5, n6, n7);
    }
}

