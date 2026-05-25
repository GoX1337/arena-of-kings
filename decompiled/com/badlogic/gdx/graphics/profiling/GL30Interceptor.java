/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.profiling;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.profiling.GLInterceptor;
import com.badlogic.gdx.graphics.profiling.GLProfiler;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

public class GL30Interceptor
extends GLInterceptor
implements GL30 {
    protected final GL30 gl30;

    protected GL30Interceptor(GLProfiler gLProfiler, GL30 gL30) {
        super(gLProfiler);
        this.gl30 = gL30;
    }

    private void check() {
        int n2 = this.gl30.glGetError();
        while (n2 != 0) {
            this.glProfiler.getListener().onError(n2);
            n2 = this.gl30.glGetError();
        }
    }

    @Override
    public void glActiveTexture(int n2) {
        ++this.calls;
        this.gl30.glActiveTexture(n2);
        this.check();
    }

    @Override
    public void glBindTexture(int n2, int n3) {
        ++this.textureBindings;
        ++this.calls;
        this.gl30.glBindTexture(n2, n3);
        this.check();
    }

    @Override
    public void glBlendFunc(int n2, int n3) {
        ++this.calls;
        this.gl30.glBlendFunc(n2, n3);
        this.check();
    }

    @Override
    public void glClear(int n2) {
        ++this.calls;
        this.gl30.glClear(n2);
        this.check();
    }

    @Override
    public void glClearColor(float f2, float f3, float f4, float f5) {
        ++this.calls;
        this.gl30.glClearColor(f2, f3, f4, f5);
        this.check();
    }

    @Override
    public void glClearDepthf(float f2) {
        ++this.calls;
        this.gl30.glClearDepthf(f2);
        this.check();
    }

    @Override
    public void glClearStencil(int n2) {
        ++this.calls;
        this.gl30.glClearStencil(n2);
        this.check();
    }

    @Override
    public void glColorMask(boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        ++this.calls;
        this.gl30.glColorMask(bl2, bl3, bl4, bl5);
        this.check();
    }

    @Override
    public void glCompressedTexImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        ++this.calls;
        this.gl30.glCompressedTexImage2D(n2, n3, n4, n5, n6, n7, n8, buffer);
        this.check();
    }

    @Override
    public void glCompressedTexSubImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Buffer buffer) {
        ++this.calls;
        this.gl30.glCompressedTexSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, buffer);
        this.check();
    }

    @Override
    public void glCopyTexImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        ++this.calls;
        this.gl30.glCopyTexImage2D(n2, n3, n4, n5, n6, n7, n8, n9);
        this.check();
    }

    @Override
    public void glCopyTexSubImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        ++this.calls;
        this.gl30.glCopyTexSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9);
        this.check();
    }

    @Override
    public void glCullFace(int n2) {
        ++this.calls;
        this.gl30.glCullFace(n2);
        this.check();
    }

    @Override
    public void glDeleteTextures(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glDeleteTextures(n2, intBuffer);
        this.check();
    }

    @Override
    public void glDeleteTexture(int n2) {
        ++this.calls;
        this.gl30.glDeleteTexture(n2);
        this.check();
    }

    @Override
    public void glDepthFunc(int n2) {
        ++this.calls;
        this.gl30.glDepthFunc(n2);
        this.check();
    }

    @Override
    public void glDepthMask(boolean bl2) {
        ++this.calls;
        this.gl30.glDepthMask(bl2);
        this.check();
    }

    @Override
    public void glDepthRangef(float f2, float f3) {
        ++this.calls;
        this.gl30.glDepthRangef(f2, f3);
        this.check();
    }

    @Override
    public void glDisable(int n2) {
        ++this.calls;
        this.gl30.glDisable(n2);
        this.check();
    }

    @Override
    public void glDrawArrays(int n2, int n3, int n4) {
        this.vertexCount.put(n4);
        ++this.drawCalls;
        ++this.calls;
        this.gl30.glDrawArrays(n2, n3, n4);
        this.check();
    }

    @Override
    public void glDrawElements(int n2, int n3, int n4, Buffer buffer) {
        this.vertexCount.put(n3);
        ++this.drawCalls;
        ++this.calls;
        this.gl30.glDrawElements(n2, n3, n4, buffer);
        this.check();
    }

    @Override
    public void glEnable(int n2) {
        ++this.calls;
        this.gl30.glEnable(n2);
        this.check();
    }

    @Override
    public void glFinish() {
        ++this.calls;
        this.gl30.glFinish();
        this.check();
    }

    @Override
    public void glFlush() {
        ++this.calls;
        this.gl30.glFlush();
        this.check();
    }

    @Override
    public void glFrontFace(int n2) {
        ++this.calls;
        this.gl30.glFrontFace(n2);
        this.check();
    }

    @Override
    public void glGenTextures(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGenTextures(n2, intBuffer);
        this.check();
    }

    @Override
    public int glGenTexture() {
        ++this.calls;
        int n2 = this.gl30.glGenTexture();
        this.check();
        return n2;
    }

    @Override
    public int glGetError() {
        ++this.calls;
        return this.gl30.glGetError();
    }

    @Override
    public void glGetIntegerv(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetIntegerv(n2, intBuffer);
        this.check();
    }

    @Override
    public String glGetString(int n2) {
        ++this.calls;
        String string = this.gl30.glGetString(n2);
        this.check();
        return string;
    }

    @Override
    public void glHint(int n2, int n3) {
        ++this.calls;
        this.gl30.glHint(n2, n3);
        this.check();
    }

    @Override
    public void glLineWidth(float f2) {
        ++this.calls;
        this.gl30.glLineWidth(f2);
        this.check();
    }

    @Override
    public void glPixelStorei(int n2, int n3) {
        ++this.calls;
        this.gl30.glPixelStorei(n2, n3);
        this.check();
    }

    @Override
    public void glPolygonOffset(float f2, float f3) {
        ++this.calls;
        this.gl30.glPolygonOffset(f2, f3);
        this.check();
    }

    @Override
    public void glReadPixels(int n2, int n3, int n4, int n5, int n6, int n7, Buffer buffer) {
        ++this.calls;
        this.gl30.glReadPixels(n2, n3, n4, n5, n6, n7, buffer);
        this.check();
    }

    @Override
    public void glScissor(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl30.glScissor(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glStencilFunc(int n2, int n3, int n4) {
        ++this.calls;
        this.gl30.glStencilFunc(n2, n3, n4);
        this.check();
    }

    @Override
    public void glStencilMask(int n2) {
        ++this.calls;
        this.gl30.glStencilMask(n2);
        this.check();
    }

    @Override
    public void glStencilOp(int n2, int n3, int n4) {
        ++this.calls;
        this.gl30.glStencilOp(n2, n3, n4);
        this.check();
    }

    @Override
    public void glTexImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Buffer buffer) {
        ++this.calls;
        this.gl30.glTexImage2D(n2, n3, n4, n5, n6, n7, n8, n9, buffer);
        this.check();
    }

    @Override
    public void glTexParameterf(int n2, int n3, float f2) {
        ++this.calls;
        this.gl30.glTexParameterf(n2, n3, f2);
        this.check();
    }

    @Override
    public void glTexSubImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Buffer buffer) {
        ++this.calls;
        this.gl30.glTexSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, buffer);
        this.check();
    }

    @Override
    public void glViewport(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl30.glViewport(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glAttachShader(int n2, int n3) {
        ++this.calls;
        this.gl30.glAttachShader(n2, n3);
        this.check();
    }

    @Override
    public void glBindAttribLocation(int n2, int n3, String string) {
        ++this.calls;
        this.gl30.glBindAttribLocation(n2, n3, string);
        this.check();
    }

    @Override
    public void glBindBuffer(int n2, int n3) {
        ++this.calls;
        this.gl30.glBindBuffer(n2, n3);
        this.check();
    }

    @Override
    public void glBindFramebuffer(int n2, int n3) {
        ++this.calls;
        this.gl30.glBindFramebuffer(n2, n3);
        this.check();
    }

    @Override
    public void glBindRenderbuffer(int n2, int n3) {
        ++this.calls;
        this.gl30.glBindRenderbuffer(n2, n3);
        this.check();
    }

    @Override
    public void glBlendColor(float f2, float f3, float f4, float f5) {
        ++this.calls;
        this.gl30.glBlendColor(f2, f3, f4, f5);
        this.check();
    }

    @Override
    public void glBlendEquation(int n2) {
        ++this.calls;
        this.gl30.glBlendEquation(n2);
        this.check();
    }

    @Override
    public void glBlendEquationSeparate(int n2, int n3) {
        ++this.calls;
        this.gl30.glBlendEquationSeparate(n2, n3);
        this.check();
    }

    @Override
    public void glBlendFuncSeparate(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl30.glBlendFuncSeparate(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glBufferData(int n2, int n3, Buffer buffer, int n4) {
        ++this.calls;
        this.gl30.glBufferData(n2, n3, buffer, n4);
        this.check();
    }

    @Override
    public void glBufferSubData(int n2, int n3, int n4, Buffer buffer) {
        ++this.calls;
        this.gl30.glBufferSubData(n2, n3, n4, buffer);
        this.check();
    }

    @Override
    public int glCheckFramebufferStatus(int n2) {
        ++this.calls;
        int n3 = this.gl30.glCheckFramebufferStatus(n2);
        this.check();
        return n3;
    }

    @Override
    public void glCompileShader(int n2) {
        ++this.calls;
        this.gl30.glCompileShader(n2);
        this.check();
    }

    @Override
    public int glCreateProgram() {
        ++this.calls;
        int n2 = this.gl30.glCreateProgram();
        this.check();
        return n2;
    }

    @Override
    public int glCreateShader(int n2) {
        ++this.calls;
        int n3 = this.gl30.glCreateShader(n2);
        this.check();
        return n3;
    }

    @Override
    public void glDeleteBuffer(int n2) {
        ++this.calls;
        this.gl30.glDeleteBuffer(n2);
        this.check();
    }

    @Override
    public void glDeleteBuffers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glDeleteBuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public void glDeleteFramebuffer(int n2) {
        ++this.calls;
        this.gl30.glDeleteFramebuffer(n2);
        this.check();
    }

    @Override
    public void glDeleteFramebuffers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glDeleteFramebuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public void glDeleteProgram(int n2) {
        ++this.calls;
        this.gl30.glDeleteProgram(n2);
        this.check();
    }

    @Override
    public void glDeleteRenderbuffer(int n2) {
        ++this.calls;
        this.gl30.glDeleteRenderbuffer(n2);
        this.check();
    }

    @Override
    public void glDeleteRenderbuffers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glDeleteRenderbuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public void glDeleteShader(int n2) {
        ++this.calls;
        this.gl30.glDeleteShader(n2);
        this.check();
    }

    @Override
    public void glDetachShader(int n2, int n3) {
        ++this.calls;
        this.gl30.glDetachShader(n2, n3);
        this.check();
    }

    @Override
    public void glDisableVertexAttribArray(int n2) {
        ++this.calls;
        this.gl30.glDisableVertexAttribArray(n2);
        this.check();
    }

    @Override
    public void glDrawElements(int n2, int n3, int n4, int n5) {
        this.vertexCount.put(n3);
        ++this.drawCalls;
        ++this.calls;
        this.gl30.glDrawElements(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glEnableVertexAttribArray(int n2) {
        ++this.calls;
        this.gl30.glEnableVertexAttribArray(n2);
        this.check();
    }

    @Override
    public void glFramebufferRenderbuffer(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl30.glFramebufferRenderbuffer(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glFramebufferTexture2D(int n2, int n3, int n4, int n5, int n6) {
        ++this.calls;
        this.gl30.glFramebufferTexture2D(n2, n3, n4, n5, n6);
        this.check();
    }

    @Override
    public int glGenBuffer() {
        ++this.calls;
        int n2 = this.gl30.glGenBuffer();
        this.check();
        return n2;
    }

    @Override
    public void glGenBuffers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGenBuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public void glGenerateMipmap(int n2) {
        ++this.calls;
        this.gl30.glGenerateMipmap(n2);
        this.check();
    }

    @Override
    public int glGenFramebuffer() {
        ++this.calls;
        int n2 = this.gl30.glGenFramebuffer();
        this.check();
        return n2;
    }

    @Override
    public void glGenFramebuffers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGenFramebuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public int glGenRenderbuffer() {
        ++this.calls;
        int n2 = this.gl30.glGenRenderbuffer();
        this.check();
        return n2;
    }

    @Override
    public void glGenRenderbuffers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGenRenderbuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public String glGetActiveAttrib(int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        ++this.calls;
        String string = this.gl30.glGetActiveAttrib(n2, n3, intBuffer, intBuffer2);
        this.check();
        return string;
    }

    @Override
    public String glGetActiveUniform(int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        ++this.calls;
        String string = this.gl30.glGetActiveUniform(n2, n3, intBuffer, intBuffer2);
        this.check();
        return string;
    }

    @Override
    public void glGetAttachedShaders(int n2, int n3, Buffer buffer, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetAttachedShaders(n2, n3, buffer, intBuffer);
        this.check();
    }

    @Override
    public int glGetAttribLocation(int n2, String string) {
        ++this.calls;
        int n3 = this.gl30.glGetAttribLocation(n2, string);
        this.check();
        return n3;
    }

    @Override
    public void glGetBooleanv(int n2, Buffer buffer) {
        ++this.calls;
        this.gl30.glGetBooleanv(n2, buffer);
        this.check();
    }

    @Override
    public void glGetBufferParameteriv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetBufferParameteriv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glGetFloatv(int n2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glGetFloatv(n2, floatBuffer);
        this.check();
    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int n2, int n3, int n4, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetFramebufferAttachmentParameteriv(n2, n3, n4, intBuffer);
        this.check();
    }

    @Override
    public void glGetProgramiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetProgramiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public String glGetProgramInfoLog(int n2) {
        ++this.calls;
        String string = this.gl30.glGetProgramInfoLog(n2);
        this.check();
        return string;
    }

    @Override
    public void glGetRenderbufferParameteriv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetRenderbufferParameteriv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glGetShaderiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetShaderiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public String glGetShaderInfoLog(int n2) {
        ++this.calls;
        String string = this.gl30.glGetShaderInfoLog(n2);
        this.check();
        return string;
    }

    @Override
    public void glGetShaderPrecisionFormat(int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        ++this.calls;
        this.gl30.glGetShaderPrecisionFormat(n2, n3, intBuffer, intBuffer2);
        this.check();
    }

    @Override
    public void glGetTexParameterfv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glGetTexParameterfv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glGetTexParameteriv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetTexParameteriv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glGetUniformfv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glGetUniformfv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glGetUniformiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetUniformiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public int glGetUniformLocation(int n2, String string) {
        ++this.calls;
        int n3 = this.gl30.glGetUniformLocation(n2, string);
        this.check();
        return n3;
    }

    @Override
    public void glGetVertexAttribfv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glGetVertexAttribfv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glGetVertexAttribiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetVertexAttribiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glGetVertexAttribPointerv(int n2, int n3, Buffer buffer) {
        ++this.calls;
        this.gl30.glGetVertexAttribPointerv(n2, n3, buffer);
        this.check();
    }

    @Override
    public boolean glIsBuffer(int n2) {
        ++this.calls;
        boolean bl2 = this.gl30.glIsBuffer(n2);
        this.check();
        return bl2;
    }

    @Override
    public boolean glIsEnabled(int n2) {
        ++this.calls;
        boolean bl2 = this.gl30.glIsEnabled(n2);
        this.check();
        return bl2;
    }

    @Override
    public boolean glIsFramebuffer(int n2) {
        ++this.calls;
        boolean bl2 = this.gl30.glIsFramebuffer(n2);
        this.check();
        return bl2;
    }

    @Override
    public boolean glIsProgram(int n2) {
        ++this.calls;
        boolean bl2 = this.gl30.glIsProgram(n2);
        this.check();
        return bl2;
    }

    @Override
    public boolean glIsRenderbuffer(int n2) {
        ++this.calls;
        boolean bl2 = this.gl30.glIsRenderbuffer(n2);
        this.check();
        return bl2;
    }

    @Override
    public boolean glIsShader(int n2) {
        ++this.calls;
        boolean bl2 = this.gl30.glIsShader(n2);
        this.check();
        return bl2;
    }

    @Override
    public boolean glIsTexture(int n2) {
        ++this.calls;
        boolean bl2 = this.gl30.glIsTexture(n2);
        this.check();
        return bl2;
    }

    @Override
    public void glLinkProgram(int n2) {
        ++this.calls;
        this.gl30.glLinkProgram(n2);
        this.check();
    }

    @Override
    public void glReleaseShaderCompiler() {
        ++this.calls;
        this.gl30.glReleaseShaderCompiler();
        this.check();
    }

    @Override
    public void glRenderbufferStorage(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl30.glRenderbufferStorage(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glSampleCoverage(float f2, boolean bl2) {
        ++this.calls;
        this.gl30.glSampleCoverage(f2, bl2);
        this.check();
    }

    @Override
    public void glShaderBinary(int n2, IntBuffer intBuffer, int n3, Buffer buffer, int n4) {
        ++this.calls;
        this.gl30.glShaderBinary(n2, intBuffer, n3, buffer, n4);
        this.check();
    }

    @Override
    public void glShaderSource(int n2, String string) {
        ++this.calls;
        this.gl30.glShaderSource(n2, string);
        this.check();
    }

    @Override
    public void glStencilFuncSeparate(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl30.glStencilFuncSeparate(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glStencilMaskSeparate(int n2, int n3) {
        ++this.calls;
        this.gl30.glStencilMaskSeparate(n2, n3);
        this.check();
    }

    @Override
    public void glStencilOpSeparate(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl30.glStencilOpSeparate(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glTexParameterfv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glTexParameterfv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glTexParameteri(int n2, int n3, int n4) {
        ++this.calls;
        this.gl30.glTexParameteri(n2, n3, n4);
        this.check();
    }

    @Override
    public void glTexParameteriv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glTexParameteriv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glUniform1f(int n2, float f2) {
        ++this.calls;
        this.gl30.glUniform1f(n2, f2);
        this.check();
    }

    @Override
    public void glUniform1fv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniform1fv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glUniform1fv(int n2, int n3, float[] fArray, int n4) {
        ++this.calls;
        this.gl30.glUniform1fv(n2, n3, fArray, n4);
        this.check();
    }

    @Override
    public void glUniform1i(int n2, int n3) {
        ++this.calls;
        this.gl30.glUniform1i(n2, n3);
        this.check();
    }

    @Override
    public void glUniform1iv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glUniform1iv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glUniform1iv(int n2, int n3, int[] nArray, int n4) {
        ++this.calls;
        this.gl30.glUniform1iv(n2, n3, nArray, n4);
        this.check();
    }

    @Override
    public void glUniform2f(int n2, float f2, float f3) {
        ++this.calls;
        this.gl30.glUniform2f(n2, f2, f3);
        this.check();
    }

    @Override
    public void glUniform2fv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniform2fv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glUniform2fv(int n2, int n3, float[] fArray, int n4) {
        ++this.calls;
        this.gl30.glUniform2fv(n2, n3, fArray, n4);
        this.check();
    }

    @Override
    public void glUniform2i(int n2, int n3, int n4) {
        ++this.calls;
        this.gl30.glUniform2i(n2, n3, n4);
        this.check();
    }

    @Override
    public void glUniform2iv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glUniform2iv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glUniform2iv(int n2, int n3, int[] nArray, int n4) {
        ++this.calls;
        this.gl30.glUniform2iv(n2, n3, nArray, n4);
        this.check();
    }

    @Override
    public void glUniform3f(int n2, float f2, float f3, float f4) {
        ++this.calls;
        this.gl30.glUniform3f(n2, f2, f3, f4);
        this.check();
    }

    @Override
    public void glUniform3fv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniform3fv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glUniform3fv(int n2, int n3, float[] fArray, int n4) {
        ++this.calls;
        this.gl30.glUniform3fv(n2, n3, fArray, n4);
        this.check();
    }

    @Override
    public void glUniform3i(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl30.glUniform3i(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glUniform3iv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glUniform3iv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glUniform3iv(int n2, int n3, int[] nArray, int n4) {
        ++this.calls;
        this.gl30.glUniform3iv(n2, n3, nArray, n4);
        this.check();
    }

    @Override
    public void glUniform4f(int n2, float f2, float f3, float f4, float f5) {
        ++this.calls;
        this.gl30.glUniform4f(n2, f2, f3, f4, f5);
        this.check();
    }

    @Override
    public void glUniform4fv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniform4fv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glUniform4fv(int n2, int n3, float[] fArray, int n4) {
        ++this.calls;
        this.gl30.glUniform4fv(n2, n3, fArray, n4);
        this.check();
    }

    @Override
    public void glUniform4i(int n2, int n3, int n4, int n5, int n6) {
        ++this.calls;
        this.gl30.glUniform4i(n2, n3, n4, n5, n6);
        this.check();
    }

    @Override
    public void glUniform4iv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glUniform4iv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glUniform4iv(int n2, int n3, int[] nArray, int n4) {
        ++this.calls;
        this.gl30.glUniform4iv(n2, n3, nArray, n4);
        this.check();
    }

    @Override
    public void glUniformMatrix2fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniformMatrix2fv(n2, n3, bl2, floatBuffer);
        this.check();
    }

    @Override
    public void glUniformMatrix2fv(int n2, int n3, boolean bl2, float[] fArray, int n4) {
        ++this.calls;
        this.gl30.glUniformMatrix2fv(n2, n3, bl2, fArray, n4);
        this.check();
    }

    @Override
    public void glUniformMatrix3fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniformMatrix3fv(n2, n3, bl2, floatBuffer);
        this.check();
    }

    @Override
    public void glUniformMatrix3fv(int n2, int n3, boolean bl2, float[] fArray, int n4) {
        ++this.calls;
        this.gl30.glUniformMatrix3fv(n2, n3, bl2, fArray, n4);
        this.check();
    }

    @Override
    public void glUniformMatrix4fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniformMatrix4fv(n2, n3, bl2, floatBuffer);
        this.check();
    }

    @Override
    public void glUniformMatrix4fv(int n2, int n3, boolean bl2, float[] fArray, int n4) {
        ++this.calls;
        this.gl30.glUniformMatrix4fv(n2, n3, bl2, fArray, n4);
        this.check();
    }

    @Override
    public void glUseProgram(int n2) {
        ++this.shaderSwitches;
        ++this.calls;
        this.gl30.glUseProgram(n2);
        this.check();
    }

    @Override
    public void glValidateProgram(int n2) {
        ++this.calls;
        this.gl30.glValidateProgram(n2);
        this.check();
    }

    @Override
    public void glVertexAttrib1f(int n2, float f2) {
        ++this.calls;
        this.gl30.glVertexAttrib1f(n2, f2);
        this.check();
    }

    @Override
    public void glVertexAttrib1fv(int n2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glVertexAttrib1fv(n2, floatBuffer);
        this.check();
    }

    @Override
    public void glVertexAttrib2f(int n2, float f2, float f3) {
        ++this.calls;
        this.gl30.glVertexAttrib2f(n2, f2, f3);
        this.check();
    }

    @Override
    public void glVertexAttrib2fv(int n2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glVertexAttrib2fv(n2, floatBuffer);
        this.check();
    }

    @Override
    public void glVertexAttrib3f(int n2, float f2, float f3, float f4) {
        ++this.calls;
        this.gl30.glVertexAttrib3f(n2, f2, f3, f4);
        this.check();
    }

    @Override
    public void glVertexAttrib3fv(int n2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glVertexAttrib3fv(n2, floatBuffer);
        this.check();
    }

    @Override
    public void glVertexAttrib4f(int n2, float f2, float f3, float f4, float f5) {
        ++this.calls;
        this.gl30.glVertexAttrib4f(n2, f2, f3, f4, f5);
        this.check();
    }

    @Override
    public void glVertexAttrib4fv(int n2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glVertexAttrib4fv(n2, floatBuffer);
        this.check();
    }

    @Override
    public void glVertexAttribPointer(int n2, int n3, int n4, boolean bl2, int n5, Buffer buffer) {
        ++this.calls;
        this.gl30.glVertexAttribPointer(n2, n3, n4, bl2, n5, buffer);
        this.check();
    }

    @Override
    public void glVertexAttribPointer(int n2, int n3, int n4, boolean bl2, int n5, int n6) {
        ++this.calls;
        this.gl30.glVertexAttribPointer(n2, n3, n4, bl2, n5, n6);
        this.check();
    }

    @Override
    public void glReadBuffer(int n2) {
        ++this.calls;
        this.gl30.glReadBuffer(n2);
        this.check();
    }

    @Override
    public void glDrawRangeElements(int n2, int n3, int n4, int n5, int n6, Buffer buffer) {
        this.vertexCount.put(n5);
        ++this.drawCalls;
        ++this.calls;
        this.gl30.glDrawRangeElements(n2, n3, n4, n5, n6, buffer);
        this.check();
    }

    @Override
    public void glDrawRangeElements(int n2, int n3, int n4, int n5, int n6, int n7) {
        this.vertexCount.put(n5);
        ++this.drawCalls;
        ++this.calls;
        this.gl30.glDrawRangeElements(n2, n3, n4, n5, n6, n7);
        this.check();
    }

    @Override
    public void glTexImage3D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, Buffer buffer) {
        ++this.calls;
        this.gl30.glTexImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, buffer);
        this.check();
    }

    @Override
    public void glTexImage3D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        ++this.calls;
        this.gl30.glTexImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11);
        this.check();
    }

    @Override
    public void glTexSubImage3D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, Buffer buffer) {
        ++this.calls;
        this.gl30.glTexSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, buffer);
        this.check();
    }

    @Override
    public void glTexSubImage3D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        ++this.calls;
        this.gl30.glTexSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12);
        this.check();
    }

    @Override
    public void glCopyTexSubImage3D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        ++this.calls;
        this.gl30.glCopyTexSubImage3D(n2, n3, n4, n5, n6, n7, n8, n9, n10);
        this.check();
    }

    @Override
    public void glGenQueries(int n2, int[] nArray, int n3) {
        ++this.calls;
        this.gl30.glGenQueries(n2, nArray, n3);
        this.check();
    }

    @Override
    public void glGenQueries(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGenQueries(n2, intBuffer);
        this.check();
    }

    @Override
    public void glDeleteQueries(int n2, int[] nArray, int n3) {
        ++this.calls;
        this.gl30.glDeleteQueries(n2, nArray, n3);
        this.check();
    }

    @Override
    public void glDeleteQueries(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glDeleteQueries(n2, intBuffer);
        this.check();
    }

    @Override
    public boolean glIsQuery(int n2) {
        ++this.calls;
        boolean bl2 = this.gl30.glIsQuery(n2);
        this.check();
        return bl2;
    }

    @Override
    public void glBeginQuery(int n2, int n3) {
        ++this.calls;
        this.gl30.glBeginQuery(n2, n3);
        this.check();
    }

    @Override
    public void glEndQuery(int n2) {
        ++this.calls;
        this.gl30.glEndQuery(n2);
        this.check();
    }

    @Override
    public void glGetQueryiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetQueryiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glGetQueryObjectuiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetQueryObjectuiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public boolean glUnmapBuffer(int n2) {
        ++this.calls;
        boolean bl2 = this.gl30.glUnmapBuffer(n2);
        this.check();
        return bl2;
    }

    @Override
    public Buffer glGetBufferPointerv(int n2, int n3) {
        ++this.calls;
        Buffer buffer = this.gl30.glGetBufferPointerv(n2, n3);
        this.check();
        return buffer;
    }

    @Override
    public void glDrawBuffers(int n2, IntBuffer intBuffer) {
        ++this.drawCalls;
        ++this.calls;
        this.gl30.glDrawBuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public void glUniformMatrix2x3fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniformMatrix2x3fv(n2, n3, bl2, floatBuffer);
        this.check();
    }

    @Override
    public void glUniformMatrix3x2fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniformMatrix3x2fv(n2, n3, bl2, floatBuffer);
        this.check();
    }

    @Override
    public void glUniformMatrix2x4fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniformMatrix2x4fv(n2, n3, bl2, floatBuffer);
        this.check();
    }

    @Override
    public void glUniformMatrix4x2fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniformMatrix4x2fv(n2, n3, bl2, floatBuffer);
        this.check();
    }

    @Override
    public void glUniformMatrix3x4fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniformMatrix3x4fv(n2, n3, bl2, floatBuffer);
        this.check();
    }

    @Override
    public void glUniformMatrix4x3fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glUniformMatrix4x3fv(n2, n3, bl2, floatBuffer);
        this.check();
    }

    @Override
    public void glBlitFramebuffer(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        ++this.calls;
        this.gl30.glBlitFramebuffer(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11);
        this.check();
    }

    @Override
    public void glRenderbufferStorageMultisample(int n2, int n3, int n4, int n5, int n6) {
        ++this.calls;
        this.gl30.glRenderbufferStorageMultisample(n2, n3, n4, n5, n6);
        this.check();
    }

    @Override
    public void glFramebufferTextureLayer(int n2, int n3, int n4, int n5, int n6) {
        ++this.calls;
        this.gl30.glFramebufferTextureLayer(n2, n3, n4, n5, n6);
        this.check();
    }

    @Override
    public Buffer glMapBufferRange(int n2, int n3, int n4, int n5) {
        ++this.calls;
        Buffer buffer = this.gl30.glMapBufferRange(n2, n3, n4, n5);
        this.check();
        return buffer;
    }

    @Override
    public void glFlushMappedBufferRange(int n2, int n3, int n4) {
        ++this.calls;
        this.gl30.glFlushMappedBufferRange(n2, n3, n4);
        this.check();
    }

    @Override
    public void glBindVertexArray(int n2) {
        ++this.calls;
        this.gl30.glBindVertexArray(n2);
        this.check();
    }

    @Override
    public void glDeleteVertexArrays(int n2, int[] nArray, int n3) {
        ++this.calls;
        this.gl30.glDeleteVertexArrays(n2, nArray, n3);
        this.check();
    }

    @Override
    public void glDeleteVertexArrays(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glDeleteVertexArrays(n2, intBuffer);
        this.check();
    }

    @Override
    public void glGenVertexArrays(int n2, int[] nArray, int n3) {
        ++this.calls;
        this.gl30.glGenVertexArrays(n2, nArray, n3);
        this.check();
    }

    @Override
    public void glGenVertexArrays(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGenVertexArrays(n2, intBuffer);
        this.check();
    }

    @Override
    public boolean glIsVertexArray(int n2) {
        ++this.calls;
        boolean bl2 = this.gl30.glIsVertexArray(n2);
        this.check();
        return bl2;
    }

    @Override
    public void glBeginTransformFeedback(int n2) {
        ++this.calls;
        this.gl30.glBeginTransformFeedback(n2);
        this.check();
    }

    @Override
    public void glEndTransformFeedback() {
        ++this.calls;
        this.gl30.glEndTransformFeedback();
        this.check();
    }

    @Override
    public void glBindBufferRange(int n2, int n3, int n4, int n5, int n6) {
        ++this.calls;
        this.gl30.glBindBufferRange(n2, n3, n4, n5, n6);
        this.check();
    }

    @Override
    public void glBindBufferBase(int n2, int n3, int n4) {
        ++this.calls;
        this.gl30.glBindBufferBase(n2, n3, n4);
        this.check();
    }

    @Override
    public void glTransformFeedbackVaryings(int n2, String[] stringArray, int n3) {
        ++this.calls;
        this.gl30.glTransformFeedbackVaryings(n2, stringArray, n3);
        this.check();
    }

    @Override
    public void glVertexAttribIPointer(int n2, int n3, int n4, int n5, int n6) {
        ++this.calls;
        this.gl30.glVertexAttribIPointer(n2, n3, n4, n5, n6);
        this.check();
    }

    @Override
    public void glGetVertexAttribIiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetVertexAttribIiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glGetVertexAttribIuiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetVertexAttribIuiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glVertexAttribI4i(int n2, int n3, int n4, int n5, int n6) {
        ++this.calls;
        this.gl30.glVertexAttribI4i(n2, n3, n4, n5, n6);
        this.check();
    }

    @Override
    public void glVertexAttribI4ui(int n2, int n3, int n4, int n5, int n6) {
        ++this.calls;
        this.gl30.glVertexAttribI4ui(n2, n3, n4, n5, n6);
        this.check();
    }

    @Override
    public void glGetUniformuiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetUniformuiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public int glGetFragDataLocation(int n2, String string) {
        ++this.calls;
        int n3 = this.gl30.glGetFragDataLocation(n2, string);
        this.check();
        return n3;
    }

    @Override
    public void glUniform1uiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glUniform1uiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glUniform3uiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glUniform3uiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glUniform4uiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glUniform4uiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glClearBufferiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glClearBufferiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glClearBufferuiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glClearBufferuiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glClearBufferfv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glClearBufferfv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glClearBufferfi(int n2, int n3, float f2, int n4) {
        ++this.calls;
        this.gl30.glClearBufferfi(n2, n3, f2, n4);
        this.check();
    }

    @Override
    public String glGetStringi(int n2, int n3) {
        ++this.calls;
        String string = this.gl30.glGetStringi(n2, n3);
        this.check();
        return string;
    }

    @Override
    public void glCopyBufferSubData(int n2, int n3, int n4, int n5, int n6) {
        ++this.calls;
        this.gl30.glCopyBufferSubData(n2, n3, n4, n5, n6);
        this.check();
    }

    @Override
    public void glGetUniformIndices(int n2, String[] stringArray, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetUniformIndices(n2, stringArray, intBuffer);
        this.check();
    }

    @Override
    public void glGetActiveUniformsiv(int n2, int n3, IntBuffer intBuffer, int n4, IntBuffer intBuffer2) {
        ++this.calls;
        this.gl30.glGetActiveUniformsiv(n2, n3, intBuffer, n4, intBuffer2);
        this.check();
    }

    @Override
    public int glGetUniformBlockIndex(int n2, String string) {
        ++this.calls;
        int n3 = this.gl30.glGetUniformBlockIndex(n2, string);
        this.check();
        return n3;
    }

    @Override
    public void glGetActiveUniformBlockiv(int n2, int n3, int n4, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetActiveUniformBlockiv(n2, n3, n4, intBuffer);
        this.check();
    }

    @Override
    public void glGetActiveUniformBlockName(int n2, int n3, Buffer buffer, Buffer buffer2) {
        ++this.calls;
        this.gl30.glGetActiveUniformBlockName(n2, n3, buffer, buffer2);
        this.check();
    }

    @Override
    public String glGetActiveUniformBlockName(int n2, int n3) {
        ++this.calls;
        String string = this.gl30.glGetActiveUniformBlockName(n2, n3);
        this.check();
        return string;
    }

    @Override
    public void glUniformBlockBinding(int n2, int n3, int n4) {
        ++this.calls;
        this.gl30.glUniformBlockBinding(n2, n3, n4);
        this.check();
    }

    @Override
    public void glDrawArraysInstanced(int n2, int n3, int n4, int n5) {
        this.vertexCount.put(n4);
        ++this.drawCalls;
        ++this.calls;
        this.gl30.glDrawArraysInstanced(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glDrawElementsInstanced(int n2, int n3, int n4, int n5, int n6) {
        this.vertexCount.put(n3);
        ++this.drawCalls;
        ++this.calls;
        this.gl30.glDrawElementsInstanced(n2, n3, n4, n5, n6);
        this.check();
    }

    @Override
    public void glGetInteger64v(int n2, LongBuffer longBuffer) {
        ++this.calls;
        this.gl30.glGetInteger64v(n2, longBuffer);
        this.check();
    }

    @Override
    public void glGetBufferParameteri64v(int n2, int n3, LongBuffer longBuffer) {
        ++this.calls;
        this.gl30.glGetBufferParameteri64v(n2, n3, longBuffer);
        this.check();
    }

    @Override
    public void glGenSamplers(int n2, int[] nArray, int n3) {
        ++this.calls;
        this.gl30.glGenSamplers(n2, nArray, n3);
        this.check();
    }

    @Override
    public void glGenSamplers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGenSamplers(n2, intBuffer);
        this.check();
    }

    @Override
    public void glDeleteSamplers(int n2, int[] nArray, int n3) {
        ++this.calls;
        this.gl30.glDeleteSamplers(n2, nArray, n3);
        this.check();
    }

    @Override
    public void glDeleteSamplers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glDeleteSamplers(n2, intBuffer);
        this.check();
    }

    @Override
    public boolean glIsSampler(int n2) {
        ++this.calls;
        boolean bl2 = this.gl30.glIsSampler(n2);
        this.check();
        return bl2;
    }

    @Override
    public void glBindSampler(int n2, int n3) {
        ++this.calls;
        this.gl30.glBindSampler(n2, n3);
        this.check();
    }

    @Override
    public void glSamplerParameteri(int n2, int n3, int n4) {
        ++this.calls;
        this.gl30.glSamplerParameteri(n2, n3, n4);
        this.check();
    }

    @Override
    public void glSamplerParameteriv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glSamplerParameteriv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glSamplerParameterf(int n2, int n3, float f2) {
        ++this.calls;
        this.gl30.glSamplerParameterf(n2, n3, f2);
        this.check();
    }

    @Override
    public void glSamplerParameterfv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glSamplerParameterfv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glGetSamplerParameteriv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGetSamplerParameteriv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glGetSamplerParameterfv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl30.glGetSamplerParameterfv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glVertexAttribDivisor(int n2, int n3) {
        ++this.calls;
        this.gl30.glVertexAttribDivisor(n2, n3);
        this.check();
    }

    @Override
    public void glBindTransformFeedback(int n2, int n3) {
        ++this.calls;
        this.gl30.glBindTransformFeedback(n2, n3);
        this.check();
    }

    @Override
    public void glDeleteTransformFeedbacks(int n2, int[] nArray, int n3) {
        ++this.calls;
        this.gl30.glDeleteTransformFeedbacks(n2, nArray, n3);
        this.check();
    }

    @Override
    public void glDeleteTransformFeedbacks(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glDeleteTransformFeedbacks(n2, intBuffer);
        this.check();
    }

    @Override
    public void glGenTransformFeedbacks(int n2, int[] nArray, int n3) {
        ++this.calls;
        this.gl30.glGenTransformFeedbacks(n2, nArray, n3);
        this.check();
    }

    @Override
    public void glGenTransformFeedbacks(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glGenTransformFeedbacks(n2, intBuffer);
        this.check();
    }

    @Override
    public boolean glIsTransformFeedback(int n2) {
        ++this.calls;
        boolean bl2 = this.gl30.glIsTransformFeedback(n2);
        this.check();
        return bl2;
    }

    @Override
    public void glPauseTransformFeedback() {
        ++this.calls;
        this.gl30.glPauseTransformFeedback();
        this.check();
    }

    @Override
    public void glResumeTransformFeedback() {
        ++this.calls;
        this.gl30.glResumeTransformFeedback();
        this.check();
    }

    @Override
    public void glProgramParameteri(int n2, int n3, int n4) {
        ++this.calls;
        this.gl30.glProgramParameteri(n2, n3, n4);
        this.check();
    }

    @Override
    public void glInvalidateFramebuffer(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl30.glInvalidateFramebuffer(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glInvalidateSubFramebuffer(int n2, int n3, IntBuffer intBuffer, int n4, int n5, int n6, int n7) {
        ++this.calls;
        this.gl30.glInvalidateSubFramebuffer(n2, n3, intBuffer, n4, n5, n6, n7);
        this.check();
    }
}

