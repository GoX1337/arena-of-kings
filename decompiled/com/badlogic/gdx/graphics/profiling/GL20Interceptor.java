/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.profiling;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.profiling.GLInterceptor;
import com.badlogic.gdx.graphics.profiling.GLProfiler;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class GL20Interceptor
extends GLInterceptor
implements GL20 {
    protected final GL20 gl20;

    protected GL20Interceptor(GLProfiler gLProfiler, GL20 gL20) {
        super(gLProfiler);
        this.gl20 = gL20;
    }

    private void check() {
        int n2 = this.gl20.glGetError();
        while (n2 != 0) {
            this.glProfiler.getListener().onError(n2);
            n2 = this.gl20.glGetError();
        }
    }

    @Override
    public void glActiveTexture(int n2) {
        ++this.calls;
        this.gl20.glActiveTexture(n2);
        this.check();
    }

    @Override
    public void glBindTexture(int n2, int n3) {
        ++this.textureBindings;
        ++this.calls;
        this.gl20.glBindTexture(n2, n3);
        this.check();
    }

    @Override
    public void glBlendFunc(int n2, int n3) {
        ++this.calls;
        this.gl20.glBlendFunc(n2, n3);
        this.check();
    }

    @Override
    public void glClear(int n2) {
        ++this.calls;
        this.gl20.glClear(n2);
        this.check();
    }

    @Override
    public void glClearColor(float f2, float f3, float f4, float f5) {
        ++this.calls;
        this.gl20.glClearColor(f2, f3, f4, f5);
        this.check();
    }

    @Override
    public void glClearDepthf(float f2) {
        ++this.calls;
        this.gl20.glClearDepthf(f2);
        this.check();
    }

    @Override
    public void glClearStencil(int n2) {
        ++this.calls;
        this.gl20.glClearStencil(n2);
        this.check();
    }

    @Override
    public void glColorMask(boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        ++this.calls;
        this.gl20.glColorMask(bl2, bl3, bl4, bl5);
        this.check();
    }

    @Override
    public void glCompressedTexImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        ++this.calls;
        this.gl20.glCompressedTexImage2D(n2, n3, n4, n5, n6, n7, n8, buffer);
        this.check();
    }

    @Override
    public void glCompressedTexSubImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Buffer buffer) {
        ++this.calls;
        this.gl20.glCompressedTexSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, buffer);
        this.check();
    }

    @Override
    public void glCopyTexImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        ++this.calls;
        this.gl20.glCopyTexImage2D(n2, n3, n4, n5, n6, n7, n8, n9);
        this.check();
    }

    @Override
    public void glCopyTexSubImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        ++this.calls;
        this.gl20.glCopyTexSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9);
        this.check();
    }

    @Override
    public void glCullFace(int n2) {
        ++this.calls;
        this.gl20.glCullFace(n2);
        this.check();
    }

    @Override
    public void glDeleteTextures(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glDeleteTextures(n2, intBuffer);
        this.check();
    }

    @Override
    public void glDeleteTexture(int n2) {
        ++this.calls;
        this.gl20.glDeleteTexture(n2);
        this.check();
    }

    @Override
    public void glDepthFunc(int n2) {
        ++this.calls;
        this.gl20.glDepthFunc(n2);
        this.check();
    }

    @Override
    public void glDepthMask(boolean bl2) {
        ++this.calls;
        this.gl20.glDepthMask(bl2);
        this.check();
    }

    @Override
    public void glDepthRangef(float f2, float f3) {
        ++this.calls;
        this.gl20.glDepthRangef(f2, f3);
        this.check();
    }

    @Override
    public void glDisable(int n2) {
        ++this.calls;
        this.gl20.glDisable(n2);
        this.check();
    }

    @Override
    public void glDrawArrays(int n2, int n3, int n4) {
        this.vertexCount.put(n4);
        ++this.drawCalls;
        ++this.calls;
        this.gl20.glDrawArrays(n2, n3, n4);
        this.check();
    }

    @Override
    public void glDrawElements(int n2, int n3, int n4, Buffer buffer) {
        this.vertexCount.put(n3);
        ++this.drawCalls;
        ++this.calls;
        this.gl20.glDrawElements(n2, n3, n4, buffer);
        this.check();
    }

    @Override
    public void glEnable(int n2) {
        ++this.calls;
        this.gl20.glEnable(n2);
        this.check();
    }

    @Override
    public void glFinish() {
        ++this.calls;
        this.gl20.glFinish();
        this.check();
    }

    @Override
    public void glFlush() {
        ++this.calls;
        this.gl20.glFlush();
        this.check();
    }

    @Override
    public void glFrontFace(int n2) {
        ++this.calls;
        this.gl20.glFrontFace(n2);
        this.check();
    }

    @Override
    public void glGenTextures(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGenTextures(n2, intBuffer);
        this.check();
    }

    @Override
    public int glGenTexture() {
        ++this.calls;
        int n2 = this.gl20.glGenTexture();
        this.check();
        return n2;
    }

    @Override
    public int glGetError() {
        ++this.calls;
        return this.gl20.glGetError();
    }

    @Override
    public void glGetIntegerv(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGetIntegerv(n2, intBuffer);
        this.check();
    }

    @Override
    public String glGetString(int n2) {
        ++this.calls;
        String string = this.gl20.glGetString(n2);
        this.check();
        return string;
    }

    @Override
    public void glHint(int n2, int n3) {
        ++this.calls;
        this.gl20.glHint(n2, n3);
        this.check();
    }

    @Override
    public void glLineWidth(float f2) {
        ++this.calls;
        this.gl20.glLineWidth(f2);
        this.check();
    }

    @Override
    public void glPixelStorei(int n2, int n3) {
        ++this.calls;
        this.gl20.glPixelStorei(n2, n3);
        this.check();
    }

    @Override
    public void glPolygonOffset(float f2, float f3) {
        ++this.calls;
        this.gl20.glPolygonOffset(f2, f3);
        this.check();
    }

    @Override
    public void glReadPixels(int n2, int n3, int n4, int n5, int n6, int n7, Buffer buffer) {
        ++this.calls;
        this.gl20.glReadPixels(n2, n3, n4, n5, n6, n7, buffer);
        this.check();
    }

    @Override
    public void glScissor(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl20.glScissor(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glStencilFunc(int n2, int n3, int n4) {
        ++this.calls;
        this.gl20.glStencilFunc(n2, n3, n4);
        this.check();
    }

    @Override
    public void glStencilMask(int n2) {
        ++this.calls;
        this.gl20.glStencilMask(n2);
        this.check();
    }

    @Override
    public void glStencilOp(int n2, int n3, int n4) {
        ++this.calls;
        this.gl20.glStencilOp(n2, n3, n4);
        this.check();
    }

    @Override
    public void glTexImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Buffer buffer) {
        ++this.calls;
        this.gl20.glTexImage2D(n2, n3, n4, n5, n6, n7, n8, n9, buffer);
        this.check();
    }

    @Override
    public void glTexParameterf(int n2, int n3, float f2) {
        ++this.calls;
        this.gl20.glTexParameterf(n2, n3, f2);
        this.check();
    }

    @Override
    public void glTexSubImage2D(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Buffer buffer) {
        ++this.calls;
        this.gl20.glTexSubImage2D(n2, n3, n4, n5, n6, n7, n8, n9, buffer);
        this.check();
    }

    @Override
    public void glViewport(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl20.glViewport(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glAttachShader(int n2, int n3) {
        ++this.calls;
        this.gl20.glAttachShader(n2, n3);
        this.check();
    }

    @Override
    public void glBindAttribLocation(int n2, int n3, String string) {
        ++this.calls;
        this.gl20.glBindAttribLocation(n2, n3, string);
        this.check();
    }

    @Override
    public void glBindBuffer(int n2, int n3) {
        ++this.calls;
        this.gl20.glBindBuffer(n2, n3);
        this.check();
    }

    @Override
    public void glBindFramebuffer(int n2, int n3) {
        ++this.calls;
        this.gl20.glBindFramebuffer(n2, n3);
        this.check();
    }

    @Override
    public void glBindRenderbuffer(int n2, int n3) {
        ++this.calls;
        this.gl20.glBindRenderbuffer(n2, n3);
        this.check();
    }

    @Override
    public void glBlendColor(float f2, float f3, float f4, float f5) {
        ++this.calls;
        this.gl20.glBlendColor(f2, f3, f4, f5);
        this.check();
    }

    @Override
    public void glBlendEquation(int n2) {
        ++this.calls;
        this.gl20.glBlendEquation(n2);
        this.check();
    }

    @Override
    public void glBlendEquationSeparate(int n2, int n3) {
        ++this.calls;
        this.gl20.glBlendEquationSeparate(n2, n3);
        this.check();
    }

    @Override
    public void glBlendFuncSeparate(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl20.glBlendFuncSeparate(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glBufferData(int n2, int n3, Buffer buffer, int n4) {
        ++this.calls;
        this.gl20.glBufferData(n2, n3, buffer, n4);
        this.check();
    }

    @Override
    public void glBufferSubData(int n2, int n3, int n4, Buffer buffer) {
        ++this.calls;
        this.gl20.glBufferSubData(n2, n3, n4, buffer);
        this.check();
    }

    @Override
    public int glCheckFramebufferStatus(int n2) {
        ++this.calls;
        int n3 = this.gl20.glCheckFramebufferStatus(n2);
        this.check();
        return n3;
    }

    @Override
    public void glCompileShader(int n2) {
        ++this.calls;
        this.gl20.glCompileShader(n2);
        this.check();
    }

    @Override
    public int glCreateProgram() {
        ++this.calls;
        int n2 = this.gl20.glCreateProgram();
        this.check();
        return n2;
    }

    @Override
    public int glCreateShader(int n2) {
        ++this.calls;
        int n3 = this.gl20.glCreateShader(n2);
        this.check();
        return n3;
    }

    @Override
    public void glDeleteBuffer(int n2) {
        ++this.calls;
        this.gl20.glDeleteBuffer(n2);
        this.check();
    }

    @Override
    public void glDeleteBuffers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glDeleteBuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public void glDeleteFramebuffer(int n2) {
        ++this.calls;
        this.gl20.glDeleteFramebuffer(n2);
        this.check();
    }

    @Override
    public void glDeleteFramebuffers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glDeleteFramebuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public void glDeleteProgram(int n2) {
        ++this.calls;
        this.gl20.glDeleteProgram(n2);
        this.check();
    }

    @Override
    public void glDeleteRenderbuffer(int n2) {
        ++this.calls;
        this.gl20.glDeleteRenderbuffer(n2);
        this.check();
    }

    @Override
    public void glDeleteRenderbuffers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glDeleteRenderbuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public void glDeleteShader(int n2) {
        ++this.calls;
        this.gl20.glDeleteShader(n2);
        this.check();
    }

    @Override
    public void glDetachShader(int n2, int n3) {
        ++this.calls;
        this.gl20.glDetachShader(n2, n3);
        this.check();
    }

    @Override
    public void glDisableVertexAttribArray(int n2) {
        ++this.calls;
        this.gl20.glDisableVertexAttribArray(n2);
        this.check();
    }

    @Override
    public void glDrawElements(int n2, int n3, int n4, int n5) {
        this.vertexCount.put(n3);
        ++this.drawCalls;
        ++this.calls;
        this.gl20.glDrawElements(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glEnableVertexAttribArray(int n2) {
        ++this.calls;
        this.gl20.glEnableVertexAttribArray(n2);
        this.check();
    }

    @Override
    public void glFramebufferRenderbuffer(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl20.glFramebufferRenderbuffer(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glFramebufferTexture2D(int n2, int n3, int n4, int n5, int n6) {
        ++this.calls;
        this.gl20.glFramebufferTexture2D(n2, n3, n4, n5, n6);
        this.check();
    }

    @Override
    public int glGenBuffer() {
        ++this.calls;
        int n2 = this.gl20.glGenBuffer();
        this.check();
        return n2;
    }

    @Override
    public void glGenBuffers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGenBuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public void glGenerateMipmap(int n2) {
        ++this.calls;
        this.gl20.glGenerateMipmap(n2);
        this.check();
    }

    @Override
    public int glGenFramebuffer() {
        ++this.calls;
        int n2 = this.gl20.glGenFramebuffer();
        this.check();
        return n2;
    }

    @Override
    public void glGenFramebuffers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGenFramebuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public int glGenRenderbuffer() {
        ++this.calls;
        int n2 = this.gl20.glGenRenderbuffer();
        this.check();
        return n2;
    }

    @Override
    public void glGenRenderbuffers(int n2, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGenRenderbuffers(n2, intBuffer);
        this.check();
    }

    @Override
    public String glGetActiveAttrib(int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        ++this.calls;
        String string = this.gl20.glGetActiveAttrib(n2, n3, intBuffer, intBuffer2);
        this.check();
        return string;
    }

    @Override
    public String glGetActiveUniform(int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        ++this.calls;
        String string = this.gl20.glGetActiveUniform(n2, n3, intBuffer, intBuffer2);
        this.check();
        return string;
    }

    @Override
    public void glGetAttachedShaders(int n2, int n3, Buffer buffer, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGetAttachedShaders(n2, n3, buffer, intBuffer);
        this.check();
    }

    @Override
    public int glGetAttribLocation(int n2, String string) {
        ++this.calls;
        int n3 = this.gl20.glGetAttribLocation(n2, string);
        this.check();
        return n3;
    }

    @Override
    public void glGetBooleanv(int n2, Buffer buffer) {
        ++this.calls;
        this.gl20.glGetBooleanv(n2, buffer);
        this.check();
    }

    @Override
    public void glGetBufferParameteriv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGetBufferParameteriv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glGetFloatv(int n2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glGetFloatv(n2, floatBuffer);
        this.check();
    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int n2, int n3, int n4, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGetFramebufferAttachmentParameteriv(n2, n3, n4, intBuffer);
        this.check();
    }

    @Override
    public void glGetProgramiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGetProgramiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public String glGetProgramInfoLog(int n2) {
        ++this.calls;
        String string = this.gl20.glGetProgramInfoLog(n2);
        this.check();
        return string;
    }

    @Override
    public void glGetRenderbufferParameteriv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGetRenderbufferParameteriv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glGetShaderiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGetShaderiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public String glGetShaderInfoLog(int n2) {
        ++this.calls;
        String string = this.gl20.glGetShaderInfoLog(n2);
        this.check();
        return string;
    }

    @Override
    public void glGetShaderPrecisionFormat(int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        ++this.calls;
        this.gl20.glGetShaderPrecisionFormat(n2, n3, intBuffer, intBuffer2);
        this.check();
    }

    @Override
    public void glGetTexParameterfv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glGetTexParameterfv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glGetTexParameteriv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGetTexParameteriv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glGetUniformfv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glGetUniformfv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glGetUniformiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGetUniformiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public int glGetUniformLocation(int n2, String string) {
        ++this.calls;
        int n3 = this.gl20.glGetUniformLocation(n2, string);
        this.check();
        return n3;
    }

    @Override
    public void glGetVertexAttribfv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glGetVertexAttribfv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glGetVertexAttribiv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glGetVertexAttribiv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glGetVertexAttribPointerv(int n2, int n3, Buffer buffer) {
        ++this.calls;
        this.gl20.glGetVertexAttribPointerv(n2, n3, buffer);
        this.check();
    }

    @Override
    public boolean glIsBuffer(int n2) {
        ++this.calls;
        boolean bl2 = this.gl20.glIsBuffer(n2);
        this.check();
        return bl2;
    }

    @Override
    public boolean glIsEnabled(int n2) {
        ++this.calls;
        boolean bl2 = this.gl20.glIsEnabled(n2);
        this.check();
        return bl2;
    }

    @Override
    public boolean glIsFramebuffer(int n2) {
        ++this.calls;
        boolean bl2 = this.gl20.glIsFramebuffer(n2);
        this.check();
        return bl2;
    }

    @Override
    public boolean glIsProgram(int n2) {
        ++this.calls;
        boolean bl2 = this.gl20.glIsProgram(n2);
        this.check();
        return bl2;
    }

    @Override
    public boolean glIsRenderbuffer(int n2) {
        ++this.calls;
        boolean bl2 = this.gl20.glIsRenderbuffer(n2);
        this.check();
        return bl2;
    }

    @Override
    public boolean glIsShader(int n2) {
        ++this.calls;
        boolean bl2 = this.gl20.glIsShader(n2);
        this.check();
        return bl2;
    }

    @Override
    public boolean glIsTexture(int n2) {
        ++this.calls;
        boolean bl2 = this.gl20.glIsTexture(n2);
        this.check();
        return bl2;
    }

    @Override
    public void glLinkProgram(int n2) {
        ++this.calls;
        this.gl20.glLinkProgram(n2);
        this.check();
    }

    @Override
    public void glReleaseShaderCompiler() {
        ++this.calls;
        this.gl20.glReleaseShaderCompiler();
        this.check();
    }

    @Override
    public void glRenderbufferStorage(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl20.glRenderbufferStorage(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glSampleCoverage(float f2, boolean bl2) {
        ++this.calls;
        this.gl20.glSampleCoverage(f2, bl2);
        this.check();
    }

    @Override
    public void glShaderBinary(int n2, IntBuffer intBuffer, int n3, Buffer buffer, int n4) {
        ++this.calls;
        this.gl20.glShaderBinary(n2, intBuffer, n3, buffer, n4);
        this.check();
    }

    @Override
    public void glShaderSource(int n2, String string) {
        ++this.calls;
        this.gl20.glShaderSource(n2, string);
        this.check();
    }

    @Override
    public void glStencilFuncSeparate(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl20.glStencilFuncSeparate(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glStencilMaskSeparate(int n2, int n3) {
        ++this.calls;
        this.gl20.glStencilMaskSeparate(n2, n3);
        this.check();
    }

    @Override
    public void glStencilOpSeparate(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl20.glStencilOpSeparate(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glTexParameterfv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glTexParameterfv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glTexParameteri(int n2, int n3, int n4) {
        ++this.calls;
        this.gl20.glTexParameteri(n2, n3, n4);
        this.check();
    }

    @Override
    public void glTexParameteriv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glTexParameteriv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glUniform1f(int n2, float f2) {
        ++this.calls;
        this.gl20.glUniform1f(n2, f2);
        this.check();
    }

    @Override
    public void glUniform1fv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glUniform1fv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glUniform1fv(int n2, int n3, float[] fArray, int n4) {
        ++this.calls;
        this.gl20.glUniform1fv(n2, n3, fArray, n4);
        this.check();
    }

    @Override
    public void glUniform1i(int n2, int n3) {
        ++this.calls;
        this.gl20.glUniform1i(n2, n3);
        this.check();
    }

    @Override
    public void glUniform1iv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glUniform1iv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glUniform1iv(int n2, int n3, int[] nArray, int n4) {
        ++this.calls;
        this.gl20.glUniform1iv(n2, n3, nArray, n4);
        this.check();
    }

    @Override
    public void glUniform2f(int n2, float f2, float f3) {
        ++this.calls;
        this.gl20.glUniform2f(n2, f2, f3);
        this.check();
    }

    @Override
    public void glUniform2fv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glUniform2fv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glUniform2fv(int n2, int n3, float[] fArray, int n4) {
        ++this.calls;
        this.gl20.glUniform2fv(n2, n3, fArray, n4);
        this.check();
    }

    @Override
    public void glUniform2i(int n2, int n3, int n4) {
        ++this.calls;
        this.gl20.glUniform2i(n2, n3, n4);
        this.check();
    }

    @Override
    public void glUniform2iv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glUniform2iv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glUniform2iv(int n2, int n3, int[] nArray, int n4) {
        ++this.calls;
        this.gl20.glUniform2iv(n2, n3, nArray, n4);
        this.check();
    }

    @Override
    public void glUniform3f(int n2, float f2, float f3, float f4) {
        ++this.calls;
        this.gl20.glUniform3f(n2, f2, f3, f4);
        this.check();
    }

    @Override
    public void glUniform3fv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glUniform3fv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glUniform3fv(int n2, int n3, float[] fArray, int n4) {
        ++this.calls;
        this.gl20.glUniform3fv(n2, n3, fArray, n4);
        this.check();
    }

    @Override
    public void glUniform3i(int n2, int n3, int n4, int n5) {
        ++this.calls;
        this.gl20.glUniform3i(n2, n3, n4, n5);
        this.check();
    }

    @Override
    public void glUniform3iv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glUniform3iv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glUniform3iv(int n2, int n3, int[] nArray, int n4) {
        ++this.calls;
        this.gl20.glUniform3iv(n2, n3, nArray, n4);
        this.check();
    }

    @Override
    public void glUniform4f(int n2, float f2, float f3, float f4, float f5) {
        ++this.calls;
        this.gl20.glUniform4f(n2, f2, f3, f4, f5);
        this.check();
    }

    @Override
    public void glUniform4fv(int n2, int n3, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glUniform4fv(n2, n3, floatBuffer);
        this.check();
    }

    @Override
    public void glUniform4fv(int n2, int n3, float[] fArray, int n4) {
        ++this.calls;
        this.gl20.glUniform4fv(n2, n3, fArray, n4);
        this.check();
    }

    @Override
    public void glUniform4i(int n2, int n3, int n4, int n5, int n6) {
        ++this.calls;
        this.gl20.glUniform4i(n2, n3, n4, n5, n6);
        this.check();
    }

    @Override
    public void glUniform4iv(int n2, int n3, IntBuffer intBuffer) {
        ++this.calls;
        this.gl20.glUniform4iv(n2, n3, intBuffer);
        this.check();
    }

    @Override
    public void glUniform4iv(int n2, int n3, int[] nArray, int n4) {
        ++this.calls;
        this.gl20.glUniform4iv(n2, n3, nArray, n4);
        this.check();
    }

    @Override
    public void glUniformMatrix2fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glUniformMatrix2fv(n2, n3, bl2, floatBuffer);
        this.check();
    }

    @Override
    public void glUniformMatrix2fv(int n2, int n3, boolean bl2, float[] fArray, int n4) {
        ++this.calls;
        this.gl20.glUniformMatrix2fv(n2, n3, bl2, fArray, n4);
        this.check();
    }

    @Override
    public void glUniformMatrix3fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glUniformMatrix3fv(n2, n3, bl2, floatBuffer);
        this.check();
    }

    @Override
    public void glUniformMatrix3fv(int n2, int n3, boolean bl2, float[] fArray, int n4) {
        ++this.calls;
        this.gl20.glUniformMatrix3fv(n2, n3, bl2, fArray, n4);
        this.check();
    }

    @Override
    public void glUniformMatrix4fv(int n2, int n3, boolean bl2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glUniformMatrix4fv(n2, n3, bl2, floatBuffer);
        this.check();
    }

    @Override
    public void glUniformMatrix4fv(int n2, int n3, boolean bl2, float[] fArray, int n4) {
        ++this.calls;
        this.gl20.glUniformMatrix4fv(n2, n3, bl2, fArray, n4);
        this.check();
    }

    @Override
    public void glUseProgram(int n2) {
        ++this.shaderSwitches;
        ++this.calls;
        this.gl20.glUseProgram(n2);
        this.check();
    }

    @Override
    public void glValidateProgram(int n2) {
        ++this.calls;
        this.gl20.glValidateProgram(n2);
        this.check();
    }

    @Override
    public void glVertexAttrib1f(int n2, float f2) {
        ++this.calls;
        this.gl20.glVertexAttrib1f(n2, f2);
        this.check();
    }

    @Override
    public void glVertexAttrib1fv(int n2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glVertexAttrib1fv(n2, floatBuffer);
        this.check();
    }

    @Override
    public void glVertexAttrib2f(int n2, float f2, float f3) {
        ++this.calls;
        this.gl20.glVertexAttrib2f(n2, f2, f3);
        this.check();
    }

    @Override
    public void glVertexAttrib2fv(int n2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glVertexAttrib2fv(n2, floatBuffer);
        this.check();
    }

    @Override
    public void glVertexAttrib3f(int n2, float f2, float f3, float f4) {
        ++this.calls;
        this.gl20.glVertexAttrib3f(n2, f2, f3, f4);
        this.check();
    }

    @Override
    public void glVertexAttrib3fv(int n2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glVertexAttrib3fv(n2, floatBuffer);
        this.check();
    }

    @Override
    public void glVertexAttrib4f(int n2, float f2, float f3, float f4, float f5) {
        ++this.calls;
        this.gl20.glVertexAttrib4f(n2, f2, f3, f4, f5);
        this.check();
    }

    @Override
    public void glVertexAttrib4fv(int n2, FloatBuffer floatBuffer) {
        ++this.calls;
        this.gl20.glVertexAttrib4fv(n2, floatBuffer);
        this.check();
    }

    @Override
    public void glVertexAttribPointer(int n2, int n3, int n4, boolean bl2, int n5, Buffer buffer) {
        ++this.calls;
        this.gl20.glVertexAttribPointer(n2, n3, n4, bl2, n5, buffer);
        this.check();
    }

    @Override
    public void glVertexAttribPointer(int n2, int n3, int n4, boolean bl2, int n5, int n6) {
        ++this.calls;
        this.gl20.glVertexAttribPointer(n2, n3, n4, bl2, n5, n6);
        this.check();
    }
}

