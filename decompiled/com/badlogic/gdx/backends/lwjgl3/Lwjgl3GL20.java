/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;

class Lwjgl3GL20
implements com.badlogic.gdx.graphics.GL20 {
    private ByteBuffer buffer = null;
    private FloatBuffer floatBuffer = null;
    private IntBuffer intBuffer = null;

    Lwjgl3GL20() {
    }

    private void ensureBufferCapacity(int n2) {
        if (this.buffer == null || this.buffer.capacity() < n2) {
            this.buffer = BufferUtils.newByteBuffer(n2);
            this.floatBuffer = this.buffer.asFloatBuffer();
            this.intBuffer = this.buffer.asIntBuffer();
        }
    }

    private FloatBuffer toFloatBuffer(float[] fArray, int n2, int n3) {
        this.ensureBufferCapacity(n3 << 2);
        ((Buffer)this.floatBuffer).clear();
        ((Buffer)this.floatBuffer).limit(n3);
        this.floatBuffer.put(fArray, n2, n3);
        ((Buffer)this.floatBuffer).position(0);
        return this.floatBuffer;
    }

    private IntBuffer toIntBuffer(int[] nArray, int n2, int n3) {
        this.ensureBufferCapacity(n3 << 2);
        ((Buffer)this.intBuffer).clear();
        ((Buffer)this.intBuffer).limit(n3);
        this.intBuffer.put(nArray, n2, n3);
        ((Buffer)this.intBuffer).position(0);
        return this.intBuffer;
    }

    @Override
    public void glActiveTexture(int n2) {
        GL13.glActiveTexture(n2);
    }

    @Override
    public void glAttachShader(int n2, int n3) {
        GL20.glAttachShader(n2, n3);
    }

    @Override
    public void glBindAttribLocation(int n2, int n3, String string) {
        GL20.glBindAttribLocation(n2, n3, string);
    }

    @Override
    public void glBindBuffer(int n2, int n3) {
        GL15.glBindBuffer(n2, n3);
    }

    @Override
    public void glBindFramebuffer(int n2, int n3) {
        EXTFramebufferObject.glBindFramebufferEXT(n2, n3);
    }

    @Override
    public void glBindRenderbuffer(int n2, int n3) {
        EXTFramebufferObject.glBindRenderbufferEXT(n2, n3);
    }

    @Override
    public void glBindTexture(int n2, int n3) {
        GL11.glBindTexture(n2, n3);
    }

    @Override
    public void glBlendColor(float f2, float f3, float f4, float f5) {
        GL14.glBlendColor(f2, f3, f4, f5);
    }

    @Override
    public void glBlendEquation(int n2) {
        GL14.glBlendEquation(n2);
    }

    @Override
    public void glBlendEquationSeparate(int n2, int n3) {
        GL20.glBlendEquationSeparate(n2, n3);
    }

    @Override
    public void glBlendFunc(int n2, int n3) {
        GL11.glBlendFunc(n2, n3);
    }

    @Override
    public void glBlendFuncSeparate(int n2, int n3, int n4, int n5) {
        GL14.glBlendFuncSeparate(n2, n3, n4, n5);
    }

    @Override
    public void glBufferData(int n2, int n3, Buffer buffer, int n4) {
        if (buffer == null) {
            GL15.glBufferData(n2, n3, n4);
        } else if (buffer instanceof ByteBuffer) {
            GL15.glBufferData(n2, (ByteBuffer)buffer, n4);
        } else if (buffer instanceof IntBuffer) {
            GL15.glBufferData(n2, (IntBuffer)buffer, n4);
        } else if (buffer instanceof FloatBuffer) {
            GL15.glBufferData(n2, (FloatBuffer)buffer, n4);
        } else if (buffer instanceof DoubleBuffer) {
            GL15.glBufferData(n2, (DoubleBuffer)buffer, n4);
        } else if (buffer instanceof ShortBuffer) {
            GL15.glBufferData(n2, (ShortBuffer)buffer, n4);
        }
    }

    @Override
    public void glBufferSubData(int n2, int n3, int n4, Buffer buffer) {
        if (buffer == null) {
            throw new GdxRuntimeException("Using null for the data not possible, blame LWJGL");
        }
        if (buffer instanceof ByteBuffer) {
            GL15.glBufferSubData(n2, (long)n3, (ByteBuffer)buffer);
        } else if (buffer instanceof IntBuffer) {
            GL15.glBufferSubData(n2, (long)n3, (IntBuffer)buffer);
        } else if (buffer instanceof FloatBuffer) {
            GL15.glBufferSubData(n2, (long)n3, (FloatBuffer)buffer);
        } else if (buffer instanceof DoubleBuffer) {
            GL15.glBufferSubData(n2, (long)n3, (DoubleBuffer)buffer);
        } else if (buffer instanceof ShortBuffer) {
            GL15.glBufferSubData(n2, (long)n3, (ShortBuffer)buffer);
        }
    }

    @Override
    public int glCheckFramebufferStatus(int n2) {
        return EXTFramebufferObject.glCheckFramebufferStatusEXT(n2);
    }

    @Override
    public void glClear(int n2) {
        GL11.glClear(n2);
    }

    @Override
    public void glClearColor(float f2, float f3, float f4, float f5) {
        GL11.glClearColor(f2, f3, f4, f5);
    }

    @Override
    public void glClearDepthf(float f2) {
        GL11.glClearDepth(f2);
    }

    @Override
    public void glClearStencil(int n2) {
        GL11.glClearStencil(n2);
    }

    @Override
    public void glColorMask(boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        GL11.glColorMask(bl2, bl3, bl4, bl5);
    }

    @Override
    public void glCompileShader(int n2) {
        GL20.glCompileShader(n2);
    }

    @Override
    public void glCompressedTexImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        if (!(buffer instanceof ByteBuffer)) {
            throw new GdxRuntimeException("Can't use " + buffer.getClass().getName() + " with this method. Use ByteBuffer instead.");
        }
        GL13.glCompressedTexImage2D(n2, n3, n4, n5, n6, n7, (ByteBuffer)buffer);
    }

    @Override
    public void glCompressedTexSubImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Buffer buffer) {
        throw new GdxRuntimeException("not implemented");
    }

    @Override
    public void glCopyTexImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        GL11.glCopyTexImage2D(n2, n3, n4, n5, n6, n7, n8, n9);
    }

    @Override
    public void glCopyTexSubImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        GL11.glCopyTexSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9);
    }

    @Override
    public int glCreateProgram() {
        return GL20.glCreateProgram();
    }

    @Override
    public int glCreateShader(int n2) {
        return GL20.glCreateShader(n2);
    }

    @Override
    public void glCullFace(int n2) {
        GL11.glCullFace(n2);
    }

    @Override
    public void glDeleteBuffers(int n2, IntBuffer intBuffer) {
        GL15.glDeleteBuffers(intBuffer);
    }

    @Override
    public void glDeleteBuffer(int n2) {
        GL15.glDeleteBuffers(n2);
    }

    @Override
    public void glDeleteFramebuffers(int n2, IntBuffer intBuffer) {
        EXTFramebufferObject.glDeleteFramebuffersEXT(intBuffer);
    }

    @Override
    public void glDeleteFramebuffer(int n2) {
        EXTFramebufferObject.glDeleteFramebuffersEXT(n2);
    }

    @Override
    public void glDeleteProgram(int n2) {
        GL20.glDeleteProgram(n2);
    }

    @Override
    public void glDeleteRenderbuffers(int n2, IntBuffer intBuffer) {
        EXTFramebufferObject.glDeleteRenderbuffersEXT(intBuffer);
    }

    @Override
    public void glDeleteRenderbuffer(int n2) {
        EXTFramebufferObject.glDeleteRenderbuffersEXT(n2);
    }

    @Override
    public void glDeleteShader(int n2) {
        GL20.glDeleteShader(n2);
    }

    @Override
    public void glDeleteTextures(int n2, IntBuffer intBuffer) {
        GL11.glDeleteTextures(intBuffer);
    }

    @Override
    public void glDeleteTexture(int n2) {
        GL11.glDeleteTextures(n2);
    }

    @Override
    public void glDepthFunc(int n2) {
        GL11.glDepthFunc(n2);
    }

    @Override
    public void glDepthMask(boolean bl2) {
        GL11.glDepthMask(bl2);
    }

    @Override
    public void glDepthRangef(float f2, float f3) {
        GL11.glDepthRange(f2, f3);
    }

    @Override
    public void glDetachShader(int n2, int n3) {
        GL20.glDetachShader(n2, n3);
    }

    @Override
    public void glDisable(int n2) {
        GL11.glDisable(n2);
    }

    @Override
    public void glDisableVertexAttribArray(int n2) {
        GL20.glDisableVertexAttribArray(n2);
    }

    @Override
    public void glDrawArrays(int n2, int n3, int n4) {
        GL11.glDrawArrays(n2, n3, n4);
    }

    @Override
    public void glDrawElements(int n2, int n3, int n4, Buffer buffer) {
        if (buffer instanceof ShortBuffer && n4 == 5123) {
            ShortBuffer shortBuffer = (ShortBuffer)buffer;
            int n5 = shortBuffer.position();
            int n6 = shortBuffer.limit();
            shortBuffer.limit(n5 + n3);
            GL11.glDrawElements(n2, shortBuffer);
            shortBuffer.limit(n6);
        } else if (buffer instanceof ByteBuffer && n4 == 5123) {
            ShortBuffer shortBuffer = ((ByteBuffer)buffer).asShortBuffer();
            int n7 = shortBuffer.position();
            int n8 = shortBuffer.limit();
            shortBuffer.limit(n7 + n3);
            GL11.glDrawElements(n2, shortBuffer);
            shortBuffer.limit(n8);
        } else if (buffer instanceof ByteBuffer && n4 == 5121) {
            ByteBuffer byteBuffer = (ByteBuffer)buffer;
            int n9 = byteBuffer.position();
            int n10 = byteBuffer.limit();
            byteBuffer.limit(n9 + n3);
            GL11.glDrawElements(n2, byteBuffer);
            byteBuffer.limit(n10);
        } else {
            throw new GdxRuntimeException("Can't use " + buffer.getClass().getName() + " with this method. Use ShortBuffer or ByteBuffer instead. Blame LWJGL");
        }
    }

    @Override
    public void glEnable(int n2) {
        GL11.glEnable(n2);
    }

    @Override
    public void glEnableVertexAttribArray(int n2) {
        GL20.glEnableVertexAttribArray(n2);
    }

    @Override
    public void glFinish() {
        GL11.glFinish();
    }

    @Override
    public void glFlush() {
        GL11.glFlush();
    }

    @Override
    public void glFramebufferRenderbuffer(int n2, int n3, int n4, int n5) {
        EXTFramebufferObject.glFramebufferRenderbufferEXT(n2, n3, n4, n5);
    }

    @Override
    public void glFramebufferTexture2D(int n2, int n3, int n4, int n5, int n6) {
        EXTFramebufferObject.glFramebufferTexture2DEXT(n2, n3, n4, n5, n6);
    }

    @Override
    public void glFrontFace(int n2) {
        GL11.glFrontFace(n2);
    }

    @Override
    public void glGenBuffers(int n2, IntBuffer intBuffer) {
        GL15.glGenBuffers(intBuffer);
    }

    @Override
    public int glGenBuffer() {
        return GL15.glGenBuffers();
    }

    @Override
    public void glGenFramebuffers(int n2, IntBuffer intBuffer) {
        EXTFramebufferObject.glGenFramebuffersEXT(intBuffer);
    }

    @Override
    public int glGenFramebuffer() {
        return EXTFramebufferObject.glGenFramebuffersEXT();
    }

    @Override
    public void glGenRenderbuffers(int n2, IntBuffer intBuffer) {
        EXTFramebufferObject.glGenRenderbuffersEXT(intBuffer);
    }

    @Override
    public int glGenRenderbuffer() {
        return EXTFramebufferObject.glGenRenderbuffersEXT();
    }

    @Override
    public void glGenTextures(int n2, IntBuffer intBuffer) {
        GL11.glGenTextures(intBuffer);
    }

    @Override
    public int glGenTexture() {
        return GL11.glGenTextures();
    }

    @Override
    public void glGenerateMipmap(int n2) {
        EXTFramebufferObject.glGenerateMipmapEXT(n2);
    }

    @Override
    public String glGetActiveAttrib(int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        return GL20.glGetActiveAttrib(n2, n3, 256, intBuffer, intBuffer2);
    }

    @Override
    public String glGetActiveUniform(int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        return GL20.glGetActiveUniform(n2, n3, 256, intBuffer, intBuffer2);
    }

    @Override
    public void glGetAttachedShaders(int n2, int n3, Buffer buffer, IntBuffer intBuffer) {
        GL20.glGetAttachedShaders(n2, (IntBuffer)buffer, intBuffer);
    }

    @Override
    public int glGetAttribLocation(int n2, String string) {
        return GL20.glGetAttribLocation(n2, string);
    }

    @Override
    public void glGetBooleanv(int n2, Buffer buffer) {
        GL11.glGetBooleanv(n2, (ByteBuffer)buffer);
    }

    @Override
    public void glGetBufferParameteriv(int n2, int n3, IntBuffer intBuffer) {
        GL15.glGetBufferParameteriv(n2, n3, intBuffer);
    }

    @Override
    public int glGetError() {
        return GL11.glGetError();
    }

    @Override
    public void glGetFloatv(int n2, FloatBuffer floatBuffer) {
        GL11.glGetFloatv(n2, floatBuffer);
    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int n2, int n3, int n4, IntBuffer intBuffer) {
        EXTFramebufferObject.glGetFramebufferAttachmentParameterivEXT(n2, n3, n4, intBuffer);
    }

    @Override
    public void glGetIntegerv(int n2, IntBuffer intBuffer) {
        GL11.glGetIntegerv(n2, intBuffer);
    }

    @Override
    public String glGetProgramInfoLog(int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10240);
        byteBuffer.order(ByteOrder.nativeOrder());
        ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(4);
        byteBuffer2.order(ByteOrder.nativeOrder());
        IntBuffer intBuffer = byteBuffer2.asIntBuffer();
        GL20.glGetProgramInfoLog(n2, intBuffer, byteBuffer);
        int n3 = intBuffer.get(0);
        byte[] byArray = new byte[n3];
        byteBuffer.get(byArray);
        return new String(byArray);
    }

    @Override
    public void glGetProgramiv(int n2, int n3, IntBuffer intBuffer) {
        GL20.glGetProgramiv(n2, n3, intBuffer);
    }

    @Override
    public void glGetRenderbufferParameteriv(int n2, int n3, IntBuffer intBuffer) {
        EXTFramebufferObject.glGetRenderbufferParameterivEXT(n2, n3, intBuffer);
    }

    @Override
    public String glGetShaderInfoLog(int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10240);
        byteBuffer.order(ByteOrder.nativeOrder());
        ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(4);
        byteBuffer2.order(ByteOrder.nativeOrder());
        IntBuffer intBuffer = byteBuffer2.asIntBuffer();
        GL20.glGetShaderInfoLog(n2, intBuffer, byteBuffer);
        int n3 = intBuffer.get(0);
        byte[] byArray = new byte[n3];
        byteBuffer.get(byArray);
        return new String(byArray);
    }

    @Override
    public void glGetShaderPrecisionFormat(int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        throw new UnsupportedOperationException("unsupported, won't implement");
    }

    @Override
    public void glGetShaderiv(int n2, int n3, IntBuffer intBuffer) {
        GL20.glGetShaderiv(n2, n3, intBuffer);
    }

    @Override
    public String glGetString(int n2) {
        return GL11.glGetString(n2);
    }

    @Override
    public void glGetTexParameterfv(int n2, int n3, FloatBuffer floatBuffer) {
        GL11.glGetTexParameterfv(n2, n3, floatBuffer);
    }

    @Override
    public void glGetTexParameteriv(int n2, int n3, IntBuffer intBuffer) {
        GL11.glGetTexParameteriv(n2, n3, intBuffer);
    }

    @Override
    public int glGetUniformLocation(int n2, String string) {
        return GL20.glGetUniformLocation(n2, string);
    }

    @Override
    public void glGetUniformfv(int n2, int n3, FloatBuffer floatBuffer) {
        GL20.glGetUniformfv(n2, n3, floatBuffer);
    }

    @Override
    public void glGetUniformiv(int n2, int n3, IntBuffer intBuffer) {
        GL20.glGetUniformiv(n2, n3, intBuffer);
    }

    @Override
    public void glGetVertexAttribPointerv(int n2, int n3, Buffer buffer) {
        throw new UnsupportedOperationException("unsupported, won't implement");
    }

    @Override
    public void glGetVertexAttribfv(int n2, int n3, FloatBuffer floatBuffer) {
        GL20.glGetVertexAttribfv(n2, n3, floatBuffer);
    }

    @Override
    public void glGetVertexAttribiv(int n2, int n3, IntBuffer intBuffer) {
        GL20.glGetVertexAttribiv(n2, n3, intBuffer);
    }

    @Override
    public void glHint(int n2, int n3) {
        GL11.glHint(n2, n3);
    }

    @Override
    public boolean glIsBuffer(int n2) {
        return GL15.glIsBuffer(n2);
    }

    @Override
    public boolean glIsEnabled(int n2) {
        return GL11.glIsEnabled(n2);
    }

    @Override
    public boolean glIsFramebuffer(int n2) {
        return EXTFramebufferObject.glIsFramebufferEXT(n2);
    }

    @Override
    public boolean glIsProgram(int n2) {
        return GL20.glIsProgram(n2);
    }

    @Override
    public boolean glIsRenderbuffer(int n2) {
        return EXTFramebufferObject.glIsRenderbufferEXT(n2);
    }

    @Override
    public boolean glIsShader(int n2) {
        return GL20.glIsShader(n2);
    }

    @Override
    public boolean glIsTexture(int n2) {
        return GL11.glIsTexture(n2);
    }

    @Override
    public void glLineWidth(float f2) {
        GL11.glLineWidth(f2);
    }

    @Override
    public void glLinkProgram(int n2) {
        GL20.glLinkProgram(n2);
    }

    @Override
    public void glPixelStorei(int n2, int n3) {
        GL11.glPixelStorei(n2, n3);
    }

    @Override
    public void glPolygonOffset(float f2, float f3) {
        GL11.glPolygonOffset(f2, f3);
    }

    @Override
    public void glReadPixels(int n2, int n3, int n4, int n5, int n6, int n7, Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            GL11.glReadPixels(n2, n3, n4, n5, n6, n7, (ByteBuffer)buffer);
        } else if (buffer instanceof ShortBuffer) {
            GL11.glReadPixels(n2, n3, n4, n5, n6, n7, (ShortBuffer)buffer);
        } else if (buffer instanceof IntBuffer) {
            GL11.glReadPixels(n2, n3, n4, n5, n6, n7, (IntBuffer)buffer);
        } else if (buffer instanceof FloatBuffer) {
            GL11.glReadPixels(n2, n3, n4, n5, n6, n7, (FloatBuffer)buffer);
        } else {
            throw new GdxRuntimeException("Can't use " + buffer.getClass().getName() + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer or FloatBuffer instead. Blame LWJGL");
        }
    }

    @Override
    public void glReleaseShaderCompiler() {
    }

    @Override
    public void glRenderbufferStorage(int n2, int n3, int n4, int n5) {
        EXTFramebufferObject.glRenderbufferStorageEXT(n2, n3, n4, n5);
    }

    @Override
    public void glSampleCoverage(float f2, boolean bl2) {
        GL13.glSampleCoverage(f2, bl2);
    }

    @Override
    public void glScissor(int n2, int n3, int n4, int n5) {
        GL11.glScissor(n2, n3, n4, n5);
    }

    @Override
    public void glShaderBinary(int n2, IntBuffer intBuffer, int n3, Buffer buffer, int n4) {
        throw new UnsupportedOperationException("unsupported, won't implement");
    }

    @Override
    public void glShaderSource(int n2, String string) {
        GL20.glShaderSource(n2, (CharSequence)string);
    }

    @Override
    public void glStencilFunc(int n2, int n3, int n4) {
        GL11.glStencilFunc(n2, n3, n4);
    }

    @Override
    public void glStencilFuncSeparate(int n2, int n3, int n4, int n5) {
        GL20.glStencilFuncSeparate(n2, n3, n4, n5);
    }

    @Override
    public void glStencilMask(int n2) {
        GL11.glStencilMask(n2);
    }

    @Override
    public void glStencilMaskSeparate(int n2, int n3) {
        GL20.glStencilMaskSeparate(n2, n3);
    }

    @Override
    public void glStencilOp(int n2, int n3, int n4) {
        GL11.glStencilOp(n2, n3, n4);
    }

    @Override
    public void glStencilOpSeparate(int n2, int n3, int n4, int n5) {
        GL20.glStencilOpSeparate(n2, n3, n4, n5);
    }

    @Override
    public void glTexImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Buffer buffer) {
        if (buffer == null) {
            GL11.glTexImage2D(n2, n3, n4, n5, n6, n7, n8, n9, (ByteBuffer)null);
        } else if (buffer instanceof ByteBuffer) {
            GL11.glTexImage2D(n2, n3, n4, n5, n6, n7, n8, n9, (ByteBuffer)buffer);
        } else if (buffer instanceof ShortBuffer) {
            GL11.glTexImage2D(n2, n3, n4, n5, n6, n7, n8, n9, (ShortBuffer)buffer);
        } else if (buffer instanceof IntBuffer) {
            GL11.glTexImage2D(n2, n3, n4, n5, n6, n7, n8, n9, (IntBuffer)buffer);
        } else if (buffer instanceof FloatBuffer) {
            GL11.glTexImage2D(n2, n3, n4, n5, n6, n7, n8, n9, (FloatBuffer)buffer);
        } else if (buffer instanceof DoubleBuffer) {
            GL11.glTexImage2D(n2, n3, n4, n5, n6, n7, n8, n9, (DoubleBuffer)buffer);
        } else {
            throw new GdxRuntimeException("Can't use " + buffer.getClass().getName() + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer, FloatBuffer or DoubleBuffer instead. Blame LWJGL");
        }
    }

    @Override
    public void glTexParameterf(int n2, int n3, float f2) {
        GL11.glTexParameterf(n2, n3, f2);
    }

    @Override
    public void glTexParameterfv(int n2, int n3, FloatBuffer floatBuffer) {
        GL11.glTexParameterfv(n2, n3, floatBuffer);
    }

    @Override
    public void glTexParameteri(int n2, int n3, int n4) {
        GL11.glTexParameteri(n2, n3, n4);
    }

    @Override
    public void glTexParameteriv(int n2, int n3, IntBuffer intBuffer) {
        GL11.glTexParameteriv(n2, n3, intBuffer);
    }

    @Override
    public void glTexSubImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            GL11.glTexSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, (ByteBuffer)buffer);
        } else if (buffer instanceof ShortBuffer) {
            GL11.glTexSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, (ShortBuffer)buffer);
        } else if (buffer instanceof IntBuffer) {
            GL11.glTexSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, (IntBuffer)buffer);
        } else if (buffer instanceof FloatBuffer) {
            GL11.glTexSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, (FloatBuffer)buffer);
        } else if (buffer instanceof DoubleBuffer) {
            GL11.glTexSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, (DoubleBuffer)buffer);
        } else {
            throw new GdxRuntimeException("Can't use " + buffer.getClass().getName() + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer, FloatBuffer or DoubleBuffer instead. Blame LWJGL");
        }
    }

    @Override
    public void glUniform1f(int n2, float f2) {
        GL20.glUniform1f(n2, f2);
    }

    @Override
    public void glUniform1fv(int n2, int n3, FloatBuffer floatBuffer) {
        GL20.glUniform1fv(n2, floatBuffer);
    }

    @Override
    public void glUniform1fv(int n2, int n3, float[] fArray, int n4) {
        GL20.glUniform1fv(n2, this.toFloatBuffer(fArray, n4, n3));
    }

    @Override
    public void glUniform1i(int n2, int n3) {
        GL20.glUniform1i(n2, n3);
    }

    @Override
    public void glUniform1iv(int n2, int n3, IntBuffer intBuffer) {
        GL20.glUniform1iv(n2, intBuffer);
    }

    @Override
    public void glUniform1iv(int n2, int n3, int[] nArray, int n4) {
        GL20.glUniform1iv(n2, this.toIntBuffer(nArray, n4, n3));
    }

    @Override
    public void glUniform2f(int n2, float f2, float f3) {
        GL20.glUniform2f(n2, f2, f3);
    }

    @Override
    public void glUniform2fv(int n2, int n3, FloatBuffer floatBuffer) {
        GL20.glUniform2fv(n2, floatBuffer);
    }

    @Override
    public void glUniform2fv(int n2, int n3, float[] fArray, int n4) {
        GL20.glUniform2fv(n2, this.toFloatBuffer(fArray, n4, n3 << 1));
    }

    @Override
    public void glUniform2i(int n2, int n3, int n4) {
        GL20.glUniform2i(n2, n3, n4);
    }

    @Override
    public void glUniform2iv(int n2, int n3, IntBuffer intBuffer) {
        GL20.glUniform2iv(n2, intBuffer);
    }

    @Override
    public void glUniform2iv(int n2, int n3, int[] nArray, int n4) {
        GL20.glUniform2iv(n2, this.toIntBuffer(nArray, n4, n3 << 1));
    }

    @Override
    public void glUniform3f(int n2, float f2, float f3, float f4) {
        GL20.glUniform3f(n2, f2, f3, f4);
    }

    @Override
    public void glUniform3fv(int n2, int n3, FloatBuffer floatBuffer) {
        GL20.glUniform3fv(n2, floatBuffer);
    }

    @Override
    public void glUniform3fv(int n2, int n3, float[] fArray, int n4) {
        GL20.glUniform3fv(n2, this.toFloatBuffer(fArray, n4, n3 * 3));
    }

    @Override
    public void glUniform3i(int n2, int n3, int n4, int n5) {
        GL20.glUniform3i(n2, n3, n4, n5);
    }

    @Override
    public void glUniform3iv(int n2, int n3, IntBuffer intBuffer) {
        GL20.glUniform3iv(n2, intBuffer);
    }

    @Override
    public void glUniform3iv(int n2, int n3, int[] nArray, int n4) {
        GL20.glUniform3iv(n2, this.toIntBuffer(nArray, n4, n3 * 3));
    }

    @Override
    public void glUniform4f(int n2, float f2, float f3, float f4, float f5) {
        GL20.glUniform4f(n2, f2, f3, f4, f5);
    }

    @Override
    public void glUniform4fv(int n2, int n3, FloatBuffer floatBuffer) {
        GL20.glUniform4fv(n2, floatBuffer);
    }

    @Override
    public void glUniform4fv(int n2, int n3, float[] fArray, int n4) {
        GL20.glUniform4fv(n2, this.toFloatBuffer(fArray, n4, n3 << 2));
    }

    @Override
    public void glUniform4i(int n2, int n3, int n4, int n5, int n6) {
        GL20.glUniform4i(n2, n3, n4, n5, n6);
    }

    @Override
    public void glUniform4iv(int n2, int n3, IntBuffer intBuffer) {
        GL20.glUniform4iv(n2, intBuffer);
    }

    @Override
    public void glUniform4iv(int n2, int n3, int[] nArray, int n4) {
        GL20.glUniform4iv(n2, this.toIntBuffer(nArray, n4, n3 << 2));
    }

    @Override
    public void glUniformMatrix2fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        GL20.glUniformMatrix2fv(n2, bl2, floatBuffer);
    }

    @Override
    public void glUniformMatrix2fv(int n2, int n3, boolean bl2, float[] fArray, int n4) {
        GL20.glUniformMatrix2fv(n2, bl2, this.toFloatBuffer(fArray, n4, n3 << 2));
    }

    @Override
    public void glUniformMatrix3fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        GL20.glUniformMatrix3fv(n2, bl2, floatBuffer);
    }

    @Override
    public void glUniformMatrix3fv(int n2, int n3, boolean bl2, float[] fArray, int n4) {
        GL20.glUniformMatrix3fv(n2, bl2, this.toFloatBuffer(fArray, n4, n3 * 9));
    }

    @Override
    public void glUniformMatrix4fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        GL20.glUniformMatrix4fv(n2, bl2, floatBuffer);
    }

    @Override
    public void glUniformMatrix4fv(int n2, int n3, boolean bl2, float[] fArray, int n4) {
        GL20.glUniformMatrix4fv(n2, bl2, this.toFloatBuffer(fArray, n4, n3 << 4));
    }

    @Override
    public void glUseProgram(int n2) {
        GL20.glUseProgram(n2);
    }

    @Override
    public void glValidateProgram(int n2) {
        GL20.glValidateProgram(n2);
    }

    @Override
    public void glVertexAttrib1f(int n2, float f2) {
        GL20.glVertexAttrib1f(n2, f2);
    }

    @Override
    public void glVertexAttrib1fv(int n2, FloatBuffer floatBuffer) {
        GL20.glVertexAttrib1f(n2, floatBuffer.get());
    }

    @Override
    public void glVertexAttrib2f(int n2, float f2, float f3) {
        GL20.glVertexAttrib2f(n2, f2, f3);
    }

    @Override
    public void glVertexAttrib2fv(int n2, FloatBuffer floatBuffer) {
        GL20.glVertexAttrib2f(n2, floatBuffer.get(), floatBuffer.get());
    }

    @Override
    public void glVertexAttrib3f(int n2, float f2, float f3, float f4) {
        GL20.glVertexAttrib3f(n2, f2, f3, f4);
    }

    @Override
    public void glVertexAttrib3fv(int n2, FloatBuffer floatBuffer) {
        GL20.glVertexAttrib3f(n2, floatBuffer.get(), floatBuffer.get(), floatBuffer.get());
    }

    @Override
    public void glVertexAttrib4f(int n2, float f2, float f3, float f4, float f5) {
        GL20.glVertexAttrib4f(n2, f2, f3, f4, f5);
    }

    @Override
    public void glVertexAttrib4fv(int n2, FloatBuffer floatBuffer) {
        GL20.glVertexAttrib4f(n2, floatBuffer.get(), floatBuffer.get(), floatBuffer.get(), floatBuffer.get());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void glVertexAttribPointer(int n2, int n3, int n4, boolean bl2, int n5, Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            if (n4 == 5120) {
                GL20.glVertexAttribPointer(n2, n3, n4, bl2, n5, (ByteBuffer)buffer);
                return;
            } else if (n4 == 5121) {
                GL20.glVertexAttribPointer(n2, n3, n4, bl2, n5, (ByteBuffer)buffer);
                return;
            } else if (n4 == 5122) {
                GL20.glVertexAttribPointer(n2, n3, n4, bl2, n5, ((ByteBuffer)buffer).asShortBuffer());
                return;
            } else if (n4 == 5123) {
                GL20.glVertexAttribPointer(n2, n3, n4, bl2, n5, ((ByteBuffer)buffer).asShortBuffer());
                return;
            } else {
                if (n4 != 5126) throw new GdxRuntimeException("Can't use " + buffer.getClass().getName() + " with type " + n4 + " with this method. Use ByteBuffer and one of GL_BYTE, GL_UNSIGNED_BYTE, GL_SHORT, GL_UNSIGNED_SHORT or GL_FLOAT for type. Blame LWJGL");
                GL20.glVertexAttribPointer(n2, n3, n4, bl2, n5, ((ByteBuffer)buffer).asFloatBuffer());
            }
            return;
        } else {
            if (!(buffer instanceof FloatBuffer)) throw new GdxRuntimeException("Can't use " + buffer.getClass().getName() + " with this method. Use ByteBuffer instead. Blame LWJGL");
            if (n4 != 5126) throw new GdxRuntimeException("Can't use " + buffer.getClass().getName() + " with type " + n4 + " with this method.");
            GL20.glVertexAttribPointer(n2, n3, n4, bl2, n5, (FloatBuffer)buffer);
        }
    }

    @Override
    public void glViewport(int n2, int n3, int n4, int n5) {
        GL11.glViewport(n2, n3, n4, n5);
    }

    @Override
    public void glDrawElements(int n2, int n3, int n4, int n5) {
        GL11.glDrawElements(n2, n3, n4, n5);
    }

    @Override
    public void glVertexAttribPointer(int n2, int n3, int n4, boolean bl2, int n5, int n6) {
        GL20.glVertexAttribPointer(n2, n3, n4, bl2, n5, n6);
    }
}

