/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.util.Set;
import java.util.function.IntFunction;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.ThreadLocalUtil;

public final class GLCapabilities {
    static final int ADDRESS_BUFFER_SIZE = 2226;
    public final long glEnable;
    public final long glDisable;
    public final long glAccum;
    public final long glAlphaFunc;
    public final long glAreTexturesResident;
    public final long glArrayElement;
    public final long glBegin;
    public final long glBindTexture;
    public final long glBitmap;
    public final long glBlendFunc;
    public final long glCallList;
    public final long glCallLists;
    public final long glClear;
    public final long glClearAccum;
    public final long glClearColor;
    public final long glClearDepth;
    public final long glClearIndex;
    public final long glClearStencil;
    public final long glClipPlane;
    public final long glColor3b;
    public final long glColor3s;
    public final long glColor3i;
    public final long glColor3f;
    public final long glColor3d;
    public final long glColor3ub;
    public final long glColor3us;
    public final long glColor3ui;
    public final long glColor3bv;
    public final long glColor3sv;
    public final long glColor3iv;
    public final long glColor3fv;
    public final long glColor3dv;
    public final long glColor3ubv;
    public final long glColor3usv;
    public final long glColor3uiv;
    public final long glColor4b;
    public final long glColor4s;
    public final long glColor4i;
    public final long glColor4f;
    public final long glColor4d;
    public final long glColor4ub;
    public final long glColor4us;
    public final long glColor4ui;
    public final long glColor4bv;
    public final long glColor4sv;
    public final long glColor4iv;
    public final long glColor4fv;
    public final long glColor4dv;
    public final long glColor4ubv;
    public final long glColor4usv;
    public final long glColor4uiv;
    public final long glColorMask;
    public final long glColorMaterial;
    public final long glColorPointer;
    public final long glCopyPixels;
    public final long glCullFace;
    public final long glDeleteLists;
    public final long glDepthFunc;
    public final long glDepthMask;
    public final long glDepthRange;
    public final long glDisableClientState;
    public final long glDrawArrays;
    public final long glDrawBuffer;
    public final long glDrawElements;
    public final long glDrawPixels;
    public final long glEdgeFlag;
    public final long glEdgeFlagv;
    public final long glEdgeFlagPointer;
    public final long glEnableClientState;
    public final long glEnd;
    public final long glEvalCoord1f;
    public final long glEvalCoord1fv;
    public final long glEvalCoord1d;
    public final long glEvalCoord1dv;
    public final long glEvalCoord2f;
    public final long glEvalCoord2fv;
    public final long glEvalCoord2d;
    public final long glEvalCoord2dv;
    public final long glEvalMesh1;
    public final long glEvalMesh2;
    public final long glEvalPoint1;
    public final long glEvalPoint2;
    public final long glFeedbackBuffer;
    public final long glFinish;
    public final long glFlush;
    public final long glFogi;
    public final long glFogiv;
    public final long glFogf;
    public final long glFogfv;
    public final long glFrontFace;
    public final long glGenLists;
    public final long glGenTextures;
    public final long glDeleteTextures;
    public final long glGetClipPlane;
    public final long glGetBooleanv;
    public final long glGetFloatv;
    public final long glGetIntegerv;
    public final long glGetDoublev;
    public final long glGetError;
    public final long glGetLightiv;
    public final long glGetLightfv;
    public final long glGetMapiv;
    public final long glGetMapfv;
    public final long glGetMapdv;
    public final long glGetMaterialiv;
    public final long glGetMaterialfv;
    public final long glGetPixelMapfv;
    public final long glGetPixelMapusv;
    public final long glGetPixelMapuiv;
    public final long glGetPointerv;
    public final long glGetPolygonStipple;
    public final long glGetString;
    public final long glGetTexEnviv;
    public final long glGetTexEnvfv;
    public final long glGetTexGeniv;
    public final long glGetTexGenfv;
    public final long glGetTexGendv;
    public final long glGetTexImage;
    public final long glGetTexLevelParameteriv;
    public final long glGetTexLevelParameterfv;
    public final long glGetTexParameteriv;
    public final long glGetTexParameterfv;
    public final long glHint;
    public final long glIndexi;
    public final long glIndexub;
    public final long glIndexs;
    public final long glIndexf;
    public final long glIndexd;
    public final long glIndexiv;
    public final long glIndexubv;
    public final long glIndexsv;
    public final long glIndexfv;
    public final long glIndexdv;
    public final long glIndexMask;
    public final long glIndexPointer;
    public final long glInitNames;
    public final long glInterleavedArrays;
    public final long glIsEnabled;
    public final long glIsList;
    public final long glIsTexture;
    public final long glLightModeli;
    public final long glLightModelf;
    public final long glLightModeliv;
    public final long glLightModelfv;
    public final long glLighti;
    public final long glLightf;
    public final long glLightiv;
    public final long glLightfv;
    public final long glLineStipple;
    public final long glLineWidth;
    public final long glListBase;
    public final long glLoadMatrixf;
    public final long glLoadMatrixd;
    public final long glLoadIdentity;
    public final long glLoadName;
    public final long glLogicOp;
    public final long glMap1f;
    public final long glMap1d;
    public final long glMap2f;
    public final long glMap2d;
    public final long glMapGrid1f;
    public final long glMapGrid1d;
    public final long glMapGrid2f;
    public final long glMapGrid2d;
    public final long glMateriali;
    public final long glMaterialf;
    public final long glMaterialiv;
    public final long glMaterialfv;
    public final long glMatrixMode;
    public final long glMultMatrixf;
    public final long glMultMatrixd;
    public final long glFrustum;
    public final long glNewList;
    public final long glEndList;
    public final long glNormal3f;
    public final long glNormal3b;
    public final long glNormal3s;
    public final long glNormal3i;
    public final long glNormal3d;
    public final long glNormal3fv;
    public final long glNormal3bv;
    public final long glNormal3sv;
    public final long glNormal3iv;
    public final long glNormal3dv;
    public final long glNormalPointer;
    public final long glOrtho;
    public final long glPassThrough;
    public final long glPixelMapfv;
    public final long glPixelMapusv;
    public final long glPixelMapuiv;
    public final long glPixelStorei;
    public final long glPixelStoref;
    public final long glPixelTransferi;
    public final long glPixelTransferf;
    public final long glPixelZoom;
    public final long glPointSize;
    public final long glPolygonMode;
    public final long glPolygonOffset;
    public final long glPolygonStipple;
    public final long glPushAttrib;
    public final long glPushClientAttrib;
    public final long glPopAttrib;
    public final long glPopClientAttrib;
    public final long glPopMatrix;
    public final long glPopName;
    public final long glPrioritizeTextures;
    public final long glPushMatrix;
    public final long glPushName;
    public final long glRasterPos2i;
    public final long glRasterPos2s;
    public final long glRasterPos2f;
    public final long glRasterPos2d;
    public final long glRasterPos2iv;
    public final long glRasterPos2sv;
    public final long glRasterPos2fv;
    public final long glRasterPos2dv;
    public final long glRasterPos3i;
    public final long glRasterPos3s;
    public final long glRasterPos3f;
    public final long glRasterPos3d;
    public final long glRasterPos3iv;
    public final long glRasterPos3sv;
    public final long glRasterPos3fv;
    public final long glRasterPos3dv;
    public final long glRasterPos4i;
    public final long glRasterPos4s;
    public final long glRasterPos4f;
    public final long glRasterPos4d;
    public final long glRasterPos4iv;
    public final long glRasterPos4sv;
    public final long glRasterPos4fv;
    public final long glRasterPos4dv;
    public final long glReadBuffer;
    public final long glReadPixels;
    public final long glRecti;
    public final long glRects;
    public final long glRectf;
    public final long glRectd;
    public final long glRectiv;
    public final long glRectsv;
    public final long glRectfv;
    public final long glRectdv;
    public final long glRenderMode;
    public final long glRotatef;
    public final long glRotated;
    public final long glScalef;
    public final long glScaled;
    public final long glScissor;
    public final long glSelectBuffer;
    public final long glShadeModel;
    public final long glStencilFunc;
    public final long glStencilMask;
    public final long glStencilOp;
    public final long glTexCoord1f;
    public final long glTexCoord1s;
    public final long glTexCoord1i;
    public final long glTexCoord1d;
    public final long glTexCoord1fv;
    public final long glTexCoord1sv;
    public final long glTexCoord1iv;
    public final long glTexCoord1dv;
    public final long glTexCoord2f;
    public final long glTexCoord2s;
    public final long glTexCoord2i;
    public final long glTexCoord2d;
    public final long glTexCoord2fv;
    public final long glTexCoord2sv;
    public final long glTexCoord2iv;
    public final long glTexCoord2dv;
    public final long glTexCoord3f;
    public final long glTexCoord3s;
    public final long glTexCoord3i;
    public final long glTexCoord3d;
    public final long glTexCoord3fv;
    public final long glTexCoord3sv;
    public final long glTexCoord3iv;
    public final long glTexCoord3dv;
    public final long glTexCoord4f;
    public final long glTexCoord4s;
    public final long glTexCoord4i;
    public final long glTexCoord4d;
    public final long glTexCoord4fv;
    public final long glTexCoord4sv;
    public final long glTexCoord4iv;
    public final long glTexCoord4dv;
    public final long glTexCoordPointer;
    public final long glTexEnvi;
    public final long glTexEnviv;
    public final long glTexEnvf;
    public final long glTexEnvfv;
    public final long glTexGeni;
    public final long glTexGeniv;
    public final long glTexGenf;
    public final long glTexGenfv;
    public final long glTexGend;
    public final long glTexGendv;
    public final long glTexImage1D;
    public final long glTexImage2D;
    public final long glCopyTexImage1D;
    public final long glCopyTexImage2D;
    public final long glCopyTexSubImage1D;
    public final long glCopyTexSubImage2D;
    public final long glTexParameteri;
    public final long glTexParameteriv;
    public final long glTexParameterf;
    public final long glTexParameterfv;
    public final long glTexSubImage1D;
    public final long glTexSubImage2D;
    public final long glTranslatef;
    public final long glTranslated;
    public final long glVertex2f;
    public final long glVertex2s;
    public final long glVertex2i;
    public final long glVertex2d;
    public final long glVertex2fv;
    public final long glVertex2sv;
    public final long glVertex2iv;
    public final long glVertex2dv;
    public final long glVertex3f;
    public final long glVertex3s;
    public final long glVertex3i;
    public final long glVertex3d;
    public final long glVertex3fv;
    public final long glVertex3sv;
    public final long glVertex3iv;
    public final long glVertex3dv;
    public final long glVertex4f;
    public final long glVertex4s;
    public final long glVertex4i;
    public final long glVertex4d;
    public final long glVertex4fv;
    public final long glVertex4sv;
    public final long glVertex4iv;
    public final long glVertex4dv;
    public final long glVertexPointer;
    public final long glViewport;
    public final long glTexImage3D;
    public final long glTexSubImage3D;
    public final long glCopyTexSubImage3D;
    public final long glDrawRangeElements;
    public final long glCompressedTexImage3D;
    public final long glCompressedTexImage2D;
    public final long glCompressedTexImage1D;
    public final long glCompressedTexSubImage3D;
    public final long glCompressedTexSubImage2D;
    public final long glCompressedTexSubImage1D;
    public final long glGetCompressedTexImage;
    public final long glSampleCoverage;
    public final long glActiveTexture;
    public final long glClientActiveTexture;
    public final long glMultiTexCoord1f;
    public final long glMultiTexCoord1s;
    public final long glMultiTexCoord1i;
    public final long glMultiTexCoord1d;
    public final long glMultiTexCoord1fv;
    public final long glMultiTexCoord1sv;
    public final long glMultiTexCoord1iv;
    public final long glMultiTexCoord1dv;
    public final long glMultiTexCoord2f;
    public final long glMultiTexCoord2s;
    public final long glMultiTexCoord2i;
    public final long glMultiTexCoord2d;
    public final long glMultiTexCoord2fv;
    public final long glMultiTexCoord2sv;
    public final long glMultiTexCoord2iv;
    public final long glMultiTexCoord2dv;
    public final long glMultiTexCoord3f;
    public final long glMultiTexCoord3s;
    public final long glMultiTexCoord3i;
    public final long glMultiTexCoord3d;
    public final long glMultiTexCoord3fv;
    public final long glMultiTexCoord3sv;
    public final long glMultiTexCoord3iv;
    public final long glMultiTexCoord3dv;
    public final long glMultiTexCoord4f;
    public final long glMultiTexCoord4s;
    public final long glMultiTexCoord4i;
    public final long glMultiTexCoord4d;
    public final long glMultiTexCoord4fv;
    public final long glMultiTexCoord4sv;
    public final long glMultiTexCoord4iv;
    public final long glMultiTexCoord4dv;
    public final long glLoadTransposeMatrixf;
    public final long glLoadTransposeMatrixd;
    public final long glMultTransposeMatrixf;
    public final long glMultTransposeMatrixd;
    public final long glBlendColor;
    public final long glBlendEquation;
    public final long glFogCoordf;
    public final long glFogCoordd;
    public final long glFogCoordfv;
    public final long glFogCoorddv;
    public final long glFogCoordPointer;
    public final long glMultiDrawArrays;
    public final long glMultiDrawElements;
    public final long glPointParameterf;
    public final long glPointParameteri;
    public final long glPointParameterfv;
    public final long glPointParameteriv;
    public final long glSecondaryColor3b;
    public final long glSecondaryColor3s;
    public final long glSecondaryColor3i;
    public final long glSecondaryColor3f;
    public final long glSecondaryColor3d;
    public final long glSecondaryColor3ub;
    public final long glSecondaryColor3us;
    public final long glSecondaryColor3ui;
    public final long glSecondaryColor3bv;
    public final long glSecondaryColor3sv;
    public final long glSecondaryColor3iv;
    public final long glSecondaryColor3fv;
    public final long glSecondaryColor3dv;
    public final long glSecondaryColor3ubv;
    public final long glSecondaryColor3usv;
    public final long glSecondaryColor3uiv;
    public final long glSecondaryColorPointer;
    public final long glBlendFuncSeparate;
    public final long glWindowPos2i;
    public final long glWindowPos2s;
    public final long glWindowPos2f;
    public final long glWindowPos2d;
    public final long glWindowPos2iv;
    public final long glWindowPos2sv;
    public final long glWindowPos2fv;
    public final long glWindowPos2dv;
    public final long glWindowPos3i;
    public final long glWindowPos3s;
    public final long glWindowPos3f;
    public final long glWindowPos3d;
    public final long glWindowPos3iv;
    public final long glWindowPos3sv;
    public final long glWindowPos3fv;
    public final long glWindowPos3dv;
    public final long glBindBuffer;
    public final long glDeleteBuffers;
    public final long glGenBuffers;
    public final long glIsBuffer;
    public final long glBufferData;
    public final long glBufferSubData;
    public final long glGetBufferSubData;
    public final long glMapBuffer;
    public final long glUnmapBuffer;
    public final long glGetBufferParameteriv;
    public final long glGetBufferPointerv;
    public final long glGenQueries;
    public final long glDeleteQueries;
    public final long glIsQuery;
    public final long glBeginQuery;
    public final long glEndQuery;
    public final long glGetQueryiv;
    public final long glGetQueryObjectiv;
    public final long glGetQueryObjectuiv;
    public final long glCreateProgram;
    public final long glDeleteProgram;
    public final long glIsProgram;
    public final long glCreateShader;
    public final long glDeleteShader;
    public final long glIsShader;
    public final long glAttachShader;
    public final long glDetachShader;
    public final long glShaderSource;
    public final long glCompileShader;
    public final long glLinkProgram;
    public final long glUseProgram;
    public final long glValidateProgram;
    public final long glUniform1f;
    public final long glUniform2f;
    public final long glUniform3f;
    public final long glUniform4f;
    public final long glUniform1i;
    public final long glUniform2i;
    public final long glUniform3i;
    public final long glUniform4i;
    public final long glUniform1fv;
    public final long glUniform2fv;
    public final long glUniform3fv;
    public final long glUniform4fv;
    public final long glUniform1iv;
    public final long glUniform2iv;
    public final long glUniform3iv;
    public final long glUniform4iv;
    public final long glUniformMatrix2fv;
    public final long glUniformMatrix3fv;
    public final long glUniformMatrix4fv;
    public final long glGetShaderiv;
    public final long glGetProgramiv;
    public final long glGetShaderInfoLog;
    public final long glGetProgramInfoLog;
    public final long glGetAttachedShaders;
    public final long glGetUniformLocation;
    public final long glGetActiveUniform;
    public final long glGetUniformfv;
    public final long glGetUniformiv;
    public final long glGetShaderSource;
    public final long glVertexAttrib1f;
    public final long glVertexAttrib1s;
    public final long glVertexAttrib1d;
    public final long glVertexAttrib2f;
    public final long glVertexAttrib2s;
    public final long glVertexAttrib2d;
    public final long glVertexAttrib3f;
    public final long glVertexAttrib3s;
    public final long glVertexAttrib3d;
    public final long glVertexAttrib4f;
    public final long glVertexAttrib4s;
    public final long glVertexAttrib4d;
    public final long glVertexAttrib4Nub;
    public final long glVertexAttrib1fv;
    public final long glVertexAttrib1sv;
    public final long glVertexAttrib1dv;
    public final long glVertexAttrib2fv;
    public final long glVertexAttrib2sv;
    public final long glVertexAttrib2dv;
    public final long glVertexAttrib3fv;
    public final long glVertexAttrib3sv;
    public final long glVertexAttrib3dv;
    public final long glVertexAttrib4fv;
    public final long glVertexAttrib4sv;
    public final long glVertexAttrib4dv;
    public final long glVertexAttrib4iv;
    public final long glVertexAttrib4bv;
    public final long glVertexAttrib4ubv;
    public final long glVertexAttrib4usv;
    public final long glVertexAttrib4uiv;
    public final long glVertexAttrib4Nbv;
    public final long glVertexAttrib4Nsv;
    public final long glVertexAttrib4Niv;
    public final long glVertexAttrib4Nubv;
    public final long glVertexAttrib4Nusv;
    public final long glVertexAttrib4Nuiv;
    public final long glVertexAttribPointer;
    public final long glEnableVertexAttribArray;
    public final long glDisableVertexAttribArray;
    public final long glBindAttribLocation;
    public final long glGetActiveAttrib;
    public final long glGetAttribLocation;
    public final long glGetVertexAttribiv;
    public final long glGetVertexAttribfv;
    public final long glGetVertexAttribdv;
    public final long glGetVertexAttribPointerv;
    public final long glDrawBuffers;
    public final long glBlendEquationSeparate;
    public final long glStencilOpSeparate;
    public final long glStencilFuncSeparate;
    public final long glStencilMaskSeparate;
    public final long glUniformMatrix2x3fv;
    public final long glUniformMatrix3x2fv;
    public final long glUniformMatrix2x4fv;
    public final long glUniformMatrix4x2fv;
    public final long glUniformMatrix3x4fv;
    public final long glUniformMatrix4x3fv;
    public final long glGetStringi;
    public final long glClearBufferiv;
    public final long glClearBufferuiv;
    public final long glClearBufferfv;
    public final long glClearBufferfi;
    public final long glVertexAttribI1i;
    public final long glVertexAttribI2i;
    public final long glVertexAttribI3i;
    public final long glVertexAttribI4i;
    public final long glVertexAttribI1ui;
    public final long glVertexAttribI2ui;
    public final long glVertexAttribI3ui;
    public final long glVertexAttribI4ui;
    public final long glVertexAttribI1iv;
    public final long glVertexAttribI2iv;
    public final long glVertexAttribI3iv;
    public final long glVertexAttribI4iv;
    public final long glVertexAttribI1uiv;
    public final long glVertexAttribI2uiv;
    public final long glVertexAttribI3uiv;
    public final long glVertexAttribI4uiv;
    public final long glVertexAttribI4bv;
    public final long glVertexAttribI4sv;
    public final long glVertexAttribI4ubv;
    public final long glVertexAttribI4usv;
    public final long glVertexAttribIPointer;
    public final long glGetVertexAttribIiv;
    public final long glGetVertexAttribIuiv;
    public final long glUniform1ui;
    public final long glUniform2ui;
    public final long glUniform3ui;
    public final long glUniform4ui;
    public final long glUniform1uiv;
    public final long glUniform2uiv;
    public final long glUniform3uiv;
    public final long glUniform4uiv;
    public final long glGetUniformuiv;
    public final long glBindFragDataLocation;
    public final long glGetFragDataLocation;
    public final long glBeginConditionalRender;
    public final long glEndConditionalRender;
    public final long glMapBufferRange;
    public final long glFlushMappedBufferRange;
    public final long glClampColor;
    public final long glIsRenderbuffer;
    public final long glBindRenderbuffer;
    public final long glDeleteRenderbuffers;
    public final long glGenRenderbuffers;
    public final long glRenderbufferStorage;
    public final long glRenderbufferStorageMultisample;
    public final long glGetRenderbufferParameteriv;
    public final long glIsFramebuffer;
    public final long glBindFramebuffer;
    public final long glDeleteFramebuffers;
    public final long glGenFramebuffers;
    public final long glCheckFramebufferStatus;
    public final long glFramebufferTexture1D;
    public final long glFramebufferTexture2D;
    public final long glFramebufferTexture3D;
    public final long glFramebufferTextureLayer;
    public final long glFramebufferRenderbuffer;
    public final long glGetFramebufferAttachmentParameteriv;
    public final long glBlitFramebuffer;
    public final long glGenerateMipmap;
    public final long glTexParameterIiv;
    public final long glTexParameterIuiv;
    public final long glGetTexParameterIiv;
    public final long glGetTexParameterIuiv;
    public final long glColorMaski;
    public final long glGetBooleani_v;
    public final long glGetIntegeri_v;
    public final long glEnablei;
    public final long glDisablei;
    public final long glIsEnabledi;
    public final long glBindBufferRange;
    public final long glBindBufferBase;
    public final long glBeginTransformFeedback;
    public final long glEndTransformFeedback;
    public final long glTransformFeedbackVaryings;
    public final long glGetTransformFeedbackVarying;
    public final long glBindVertexArray;
    public final long glDeleteVertexArrays;
    public final long glGenVertexArrays;
    public final long glIsVertexArray;
    public final long glDrawArraysInstanced;
    public final long glDrawElementsInstanced;
    public final long glCopyBufferSubData;
    public final long glPrimitiveRestartIndex;
    public final long glTexBuffer;
    public final long glGetUniformIndices;
    public final long glGetActiveUniformsiv;
    public final long glGetActiveUniformName;
    public final long glGetUniformBlockIndex;
    public final long glGetActiveUniformBlockiv;
    public final long glGetActiveUniformBlockName;
    public final long glUniformBlockBinding;
    public final long glGetBufferParameteri64v;
    public final long glDrawElementsBaseVertex;
    public final long glDrawRangeElementsBaseVertex;
    public final long glDrawElementsInstancedBaseVertex;
    public final long glMultiDrawElementsBaseVertex;
    public final long glProvokingVertex;
    public final long glTexImage2DMultisample;
    public final long glTexImage3DMultisample;
    public final long glGetMultisamplefv;
    public final long glSampleMaski;
    public final long glFramebufferTexture;
    public final long glFenceSync;
    public final long glIsSync;
    public final long glDeleteSync;
    public final long glClientWaitSync;
    public final long glWaitSync;
    public final long glGetInteger64v;
    public final long glGetInteger64i_v;
    public final long glGetSynciv;
    public final long glBindFragDataLocationIndexed;
    public final long glGetFragDataIndex;
    public final long glGenSamplers;
    public final long glDeleteSamplers;
    public final long glIsSampler;
    public final long glBindSampler;
    public final long glSamplerParameteri;
    public final long glSamplerParameterf;
    public final long glSamplerParameteriv;
    public final long glSamplerParameterfv;
    public final long glSamplerParameterIiv;
    public final long glSamplerParameterIuiv;
    public final long glGetSamplerParameteriv;
    public final long glGetSamplerParameterfv;
    public final long glGetSamplerParameterIiv;
    public final long glGetSamplerParameterIuiv;
    public final long glQueryCounter;
    public final long glGetQueryObjecti64v;
    public final long glGetQueryObjectui64v;
    public final long glVertexAttribDivisor;
    public final long glVertexP2ui;
    public final long glVertexP3ui;
    public final long glVertexP4ui;
    public final long glVertexP2uiv;
    public final long glVertexP3uiv;
    public final long glVertexP4uiv;
    public final long glTexCoordP1ui;
    public final long glTexCoordP2ui;
    public final long glTexCoordP3ui;
    public final long glTexCoordP4ui;
    public final long glTexCoordP1uiv;
    public final long glTexCoordP2uiv;
    public final long glTexCoordP3uiv;
    public final long glTexCoordP4uiv;
    public final long glMultiTexCoordP1ui;
    public final long glMultiTexCoordP2ui;
    public final long glMultiTexCoordP3ui;
    public final long glMultiTexCoordP4ui;
    public final long glMultiTexCoordP1uiv;
    public final long glMultiTexCoordP2uiv;
    public final long glMultiTexCoordP3uiv;
    public final long glMultiTexCoordP4uiv;
    public final long glNormalP3ui;
    public final long glNormalP3uiv;
    public final long glColorP3ui;
    public final long glColorP4ui;
    public final long glColorP3uiv;
    public final long glColorP4uiv;
    public final long glSecondaryColorP3ui;
    public final long glSecondaryColorP3uiv;
    public final long glVertexAttribP1ui;
    public final long glVertexAttribP2ui;
    public final long glVertexAttribP3ui;
    public final long glVertexAttribP4ui;
    public final long glVertexAttribP1uiv;
    public final long glVertexAttribP2uiv;
    public final long glVertexAttribP3uiv;
    public final long glVertexAttribP4uiv;
    public final long glBlendEquationi;
    public final long glBlendEquationSeparatei;
    public final long glBlendFunci;
    public final long glBlendFuncSeparatei;
    public final long glDrawArraysIndirect;
    public final long glDrawElementsIndirect;
    public final long glUniform1d;
    public final long glUniform2d;
    public final long glUniform3d;
    public final long glUniform4d;
    public final long glUniform1dv;
    public final long glUniform2dv;
    public final long glUniform3dv;
    public final long glUniform4dv;
    public final long glUniformMatrix2dv;
    public final long glUniformMatrix3dv;
    public final long glUniformMatrix4dv;
    public final long glUniformMatrix2x3dv;
    public final long glUniformMatrix2x4dv;
    public final long glUniformMatrix3x2dv;
    public final long glUniformMatrix3x4dv;
    public final long glUniformMatrix4x2dv;
    public final long glUniformMatrix4x3dv;
    public final long glGetUniformdv;
    public final long glMinSampleShading;
    public final long glGetSubroutineUniformLocation;
    public final long glGetSubroutineIndex;
    public final long glGetActiveSubroutineUniformiv;
    public final long glGetActiveSubroutineUniformName;
    public final long glGetActiveSubroutineName;
    public final long glUniformSubroutinesuiv;
    public final long glGetUniformSubroutineuiv;
    public final long glGetProgramStageiv;
    public final long glPatchParameteri;
    public final long glPatchParameterfv;
    public final long glBindTransformFeedback;
    public final long glDeleteTransformFeedbacks;
    public final long glGenTransformFeedbacks;
    public final long glIsTransformFeedback;
    public final long glPauseTransformFeedback;
    public final long glResumeTransformFeedback;
    public final long glDrawTransformFeedback;
    public final long glDrawTransformFeedbackStream;
    public final long glBeginQueryIndexed;
    public final long glEndQueryIndexed;
    public final long glGetQueryIndexediv;
    public final long glReleaseShaderCompiler;
    public final long glShaderBinary;
    public final long glGetShaderPrecisionFormat;
    public final long glDepthRangef;
    public final long glClearDepthf;
    public final long glGetProgramBinary;
    public final long glProgramBinary;
    public final long glProgramParameteri;
    public final long glUseProgramStages;
    public final long glActiveShaderProgram;
    public final long glCreateShaderProgramv;
    public final long glBindProgramPipeline;
    public final long glDeleteProgramPipelines;
    public final long glGenProgramPipelines;
    public final long glIsProgramPipeline;
    public final long glGetProgramPipelineiv;
    public final long glProgramUniform1i;
    public final long glProgramUniform2i;
    public final long glProgramUniform3i;
    public final long glProgramUniform4i;
    public final long glProgramUniform1ui;
    public final long glProgramUniform2ui;
    public final long glProgramUniform3ui;
    public final long glProgramUniform4ui;
    public final long glProgramUniform1f;
    public final long glProgramUniform2f;
    public final long glProgramUniform3f;
    public final long glProgramUniform4f;
    public final long glProgramUniform1d;
    public final long glProgramUniform2d;
    public final long glProgramUniform3d;
    public final long glProgramUniform4d;
    public final long glProgramUniform1iv;
    public final long glProgramUniform2iv;
    public final long glProgramUniform3iv;
    public final long glProgramUniform4iv;
    public final long glProgramUniform1uiv;
    public final long glProgramUniform2uiv;
    public final long glProgramUniform3uiv;
    public final long glProgramUniform4uiv;
    public final long glProgramUniform1fv;
    public final long glProgramUniform2fv;
    public final long glProgramUniform3fv;
    public final long glProgramUniform4fv;
    public final long glProgramUniform1dv;
    public final long glProgramUniform2dv;
    public final long glProgramUniform3dv;
    public final long glProgramUniform4dv;
    public final long glProgramUniformMatrix2fv;
    public final long glProgramUniformMatrix3fv;
    public final long glProgramUniformMatrix4fv;
    public final long glProgramUniformMatrix2dv;
    public final long glProgramUniformMatrix3dv;
    public final long glProgramUniformMatrix4dv;
    public final long glProgramUniformMatrix2x3fv;
    public final long glProgramUniformMatrix3x2fv;
    public final long glProgramUniformMatrix2x4fv;
    public final long glProgramUniformMatrix4x2fv;
    public final long glProgramUniformMatrix3x4fv;
    public final long glProgramUniformMatrix4x3fv;
    public final long glProgramUniformMatrix2x3dv;
    public final long glProgramUniformMatrix3x2dv;
    public final long glProgramUniformMatrix2x4dv;
    public final long glProgramUniformMatrix4x2dv;
    public final long glProgramUniformMatrix3x4dv;
    public final long glProgramUniformMatrix4x3dv;
    public final long glValidateProgramPipeline;
    public final long glGetProgramPipelineInfoLog;
    public final long glVertexAttribL1d;
    public final long glVertexAttribL2d;
    public final long glVertexAttribL3d;
    public final long glVertexAttribL4d;
    public final long glVertexAttribL1dv;
    public final long glVertexAttribL2dv;
    public final long glVertexAttribL3dv;
    public final long glVertexAttribL4dv;
    public final long glVertexAttribLPointer;
    public final long glGetVertexAttribLdv;
    public final long glViewportArrayv;
    public final long glViewportIndexedf;
    public final long glViewportIndexedfv;
    public final long glScissorArrayv;
    public final long glScissorIndexed;
    public final long glScissorIndexedv;
    public final long glDepthRangeArrayv;
    public final long glDepthRangeIndexed;
    public final long glGetFloati_v;
    public final long glGetDoublei_v;
    public final long glGetActiveAtomicCounterBufferiv;
    public final long glTexStorage1D;
    public final long glTexStorage2D;
    public final long glTexStorage3D;
    public final long glDrawTransformFeedbackInstanced;
    public final long glDrawTransformFeedbackStreamInstanced;
    public final long glDrawArraysInstancedBaseInstance;
    public final long glDrawElementsInstancedBaseInstance;
    public final long glDrawElementsInstancedBaseVertexBaseInstance;
    public final long glBindImageTexture;
    public final long glMemoryBarrier;
    public final long glGetInternalformativ;
    public final long glClearBufferData;
    public final long glClearBufferSubData;
    public final long glDispatchCompute;
    public final long glDispatchComputeIndirect;
    public final long glCopyImageSubData;
    public final long glDebugMessageControl;
    public final long glDebugMessageInsert;
    public final long glDebugMessageCallback;
    public final long glGetDebugMessageLog;
    public final long glPushDebugGroup;
    public final long glPopDebugGroup;
    public final long glObjectLabel;
    public final long glGetObjectLabel;
    public final long glObjectPtrLabel;
    public final long glGetObjectPtrLabel;
    public final long glFramebufferParameteri;
    public final long glGetFramebufferParameteriv;
    public final long glGetInternalformati64v;
    public final long glInvalidateTexSubImage;
    public final long glInvalidateTexImage;
    public final long glInvalidateBufferSubData;
    public final long glInvalidateBufferData;
    public final long glInvalidateFramebuffer;
    public final long glInvalidateSubFramebuffer;
    public final long glMultiDrawArraysIndirect;
    public final long glMultiDrawElementsIndirect;
    public final long glGetProgramInterfaceiv;
    public final long glGetProgramResourceIndex;
    public final long glGetProgramResourceName;
    public final long glGetProgramResourceiv;
    public final long glGetProgramResourceLocation;
    public final long glGetProgramResourceLocationIndex;
    public final long glShaderStorageBlockBinding;
    public final long glTexBufferRange;
    public final long glTexStorage2DMultisample;
    public final long glTexStorage3DMultisample;
    public final long glTextureView;
    public final long glBindVertexBuffer;
    public final long glVertexAttribFormat;
    public final long glVertexAttribIFormat;
    public final long glVertexAttribLFormat;
    public final long glVertexAttribBinding;
    public final long glVertexBindingDivisor;
    public final long glBufferStorage;
    public final long glClearTexSubImage;
    public final long glClearTexImage;
    public final long glBindBuffersBase;
    public final long glBindBuffersRange;
    public final long glBindTextures;
    public final long glBindSamplers;
    public final long glBindImageTextures;
    public final long glBindVertexBuffers;
    public final long glClipControl;
    public final long glCreateTransformFeedbacks;
    public final long glTransformFeedbackBufferBase;
    public final long glTransformFeedbackBufferRange;
    public final long glGetTransformFeedbackiv;
    public final long glGetTransformFeedbacki_v;
    public final long glGetTransformFeedbacki64_v;
    public final long glCreateBuffers;
    public final long glNamedBufferStorage;
    public final long glNamedBufferData;
    public final long glNamedBufferSubData;
    public final long glCopyNamedBufferSubData;
    public final long glClearNamedBufferData;
    public final long glClearNamedBufferSubData;
    public final long glMapNamedBuffer;
    public final long glMapNamedBufferRange;
    public final long glUnmapNamedBuffer;
    public final long glFlushMappedNamedBufferRange;
    public final long glGetNamedBufferParameteriv;
    public final long glGetNamedBufferParameteri64v;
    public final long glGetNamedBufferPointerv;
    public final long glGetNamedBufferSubData;
    public final long glCreateFramebuffers;
    public final long glNamedFramebufferRenderbuffer;
    public final long glNamedFramebufferParameteri;
    public final long glNamedFramebufferTexture;
    public final long glNamedFramebufferTextureLayer;
    public final long glNamedFramebufferDrawBuffer;
    public final long glNamedFramebufferDrawBuffers;
    public final long glNamedFramebufferReadBuffer;
    public final long glInvalidateNamedFramebufferData;
    public final long glInvalidateNamedFramebufferSubData;
    public final long glClearNamedFramebufferiv;
    public final long glClearNamedFramebufferuiv;
    public final long glClearNamedFramebufferfv;
    public final long glClearNamedFramebufferfi;
    public final long glBlitNamedFramebuffer;
    public final long glCheckNamedFramebufferStatus;
    public final long glGetNamedFramebufferParameteriv;
    public final long glGetNamedFramebufferAttachmentParameteriv;
    public final long glCreateRenderbuffers;
    public final long glNamedRenderbufferStorage;
    public final long glNamedRenderbufferStorageMultisample;
    public final long glGetNamedRenderbufferParameteriv;
    public final long glCreateTextures;
    public final long glTextureBuffer;
    public final long glTextureBufferRange;
    public final long glTextureStorage1D;
    public final long glTextureStorage2D;
    public final long glTextureStorage3D;
    public final long glTextureStorage2DMultisample;
    public final long glTextureStorage3DMultisample;
    public final long glTextureSubImage1D;
    public final long glTextureSubImage2D;
    public final long glTextureSubImage3D;
    public final long glCompressedTextureSubImage1D;
    public final long glCompressedTextureSubImage2D;
    public final long glCompressedTextureSubImage3D;
    public final long glCopyTextureSubImage1D;
    public final long glCopyTextureSubImage2D;
    public final long glCopyTextureSubImage3D;
    public final long glTextureParameterf;
    public final long glTextureParameterfv;
    public final long glTextureParameteri;
    public final long glTextureParameterIiv;
    public final long glTextureParameterIuiv;
    public final long glTextureParameteriv;
    public final long glGenerateTextureMipmap;
    public final long glBindTextureUnit;
    public final long glGetTextureImage;
    public final long glGetCompressedTextureImage;
    public final long glGetTextureLevelParameterfv;
    public final long glGetTextureLevelParameteriv;
    public final long glGetTextureParameterfv;
    public final long glGetTextureParameterIiv;
    public final long glGetTextureParameterIuiv;
    public final long glGetTextureParameteriv;
    public final long glCreateVertexArrays;
    public final long glDisableVertexArrayAttrib;
    public final long glEnableVertexArrayAttrib;
    public final long glVertexArrayElementBuffer;
    public final long glVertexArrayVertexBuffer;
    public final long glVertexArrayVertexBuffers;
    public final long glVertexArrayAttribFormat;
    public final long glVertexArrayAttribIFormat;
    public final long glVertexArrayAttribLFormat;
    public final long glVertexArrayAttribBinding;
    public final long glVertexArrayBindingDivisor;
    public final long glGetVertexArrayiv;
    public final long glGetVertexArrayIndexediv;
    public final long glGetVertexArrayIndexed64iv;
    public final long glCreateSamplers;
    public final long glCreateProgramPipelines;
    public final long glCreateQueries;
    public final long glGetQueryBufferObjectiv;
    public final long glGetQueryBufferObjectuiv;
    public final long glGetQueryBufferObjecti64v;
    public final long glGetQueryBufferObjectui64v;
    public final long glMemoryBarrierByRegion;
    public final long glGetTextureSubImage;
    public final long glGetCompressedTextureSubImage;
    public final long glTextureBarrier;
    public final long glGetGraphicsResetStatus;
    public final long glGetnMapdv;
    public final long glGetnMapfv;
    public final long glGetnMapiv;
    public final long glGetnPixelMapfv;
    public final long glGetnPixelMapuiv;
    public final long glGetnPixelMapusv;
    public final long glGetnPolygonStipple;
    public final long glGetnTexImage;
    public final long glReadnPixels;
    public final long glGetnColorTable;
    public final long glGetnConvolutionFilter;
    public final long glGetnSeparableFilter;
    public final long glGetnHistogram;
    public final long glGetnMinmax;
    public final long glGetnCompressedTexImage;
    public final long glGetnUniformfv;
    public final long glGetnUniformdv;
    public final long glGetnUniformiv;
    public final long glGetnUniformuiv;
    public final long glMultiDrawArraysIndirectCount;
    public final long glMultiDrawElementsIndirectCount;
    public final long glPolygonOffsetClamp;
    public final long glSpecializeShader;
    public final long glDebugMessageEnableAMD;
    public final long glDebugMessageInsertAMD;
    public final long glDebugMessageCallbackAMD;
    public final long glGetDebugMessageLogAMD;
    public final long glBlendFuncIndexedAMD;
    public final long glBlendFuncSeparateIndexedAMD;
    public final long glBlendEquationIndexedAMD;
    public final long glBlendEquationSeparateIndexedAMD;
    public final long glRenderbufferStorageMultisampleAdvancedAMD;
    public final long glNamedRenderbufferStorageMultisampleAdvancedAMD;
    public final long glUniform1i64NV;
    public final long glUniform2i64NV;
    public final long glUniform3i64NV;
    public final long glUniform4i64NV;
    public final long glUniform1i64vNV;
    public final long glUniform2i64vNV;
    public final long glUniform3i64vNV;
    public final long glUniform4i64vNV;
    public final long glUniform1ui64NV;
    public final long glUniform2ui64NV;
    public final long glUniform3ui64NV;
    public final long glUniform4ui64NV;
    public final long glUniform1ui64vNV;
    public final long glUniform2ui64vNV;
    public final long glUniform3ui64vNV;
    public final long glUniform4ui64vNV;
    public final long glGetUniformi64vNV;
    public final long glGetUniformui64vNV;
    public final long glProgramUniform1i64NV;
    public final long glProgramUniform2i64NV;
    public final long glProgramUniform3i64NV;
    public final long glProgramUniform4i64NV;
    public final long glProgramUniform1i64vNV;
    public final long glProgramUniform2i64vNV;
    public final long glProgramUniform3i64vNV;
    public final long glProgramUniform4i64vNV;
    public final long glProgramUniform1ui64NV;
    public final long glProgramUniform2ui64NV;
    public final long glProgramUniform3ui64NV;
    public final long glProgramUniform4ui64NV;
    public final long glProgramUniform1ui64vNV;
    public final long glProgramUniform2ui64vNV;
    public final long glProgramUniform3ui64vNV;
    public final long glProgramUniform4ui64vNV;
    public final long glVertexAttribParameteriAMD;
    public final long glQueryObjectParameteruiAMD;
    public final long glGetPerfMonitorGroupsAMD;
    public final long glGetPerfMonitorCountersAMD;
    public final long glGetPerfMonitorGroupStringAMD;
    public final long glGetPerfMonitorCounterStringAMD;
    public final long glGetPerfMonitorCounterInfoAMD;
    public final long glGenPerfMonitorsAMD;
    public final long glDeletePerfMonitorsAMD;
    public final long glSelectPerfMonitorCountersAMD;
    public final long glBeginPerfMonitorAMD;
    public final long glEndPerfMonitorAMD;
    public final long glGetPerfMonitorCounterDataAMD;
    public final long glSetMultisamplefvAMD;
    public final long glTexStorageSparseAMD;
    public final long glTextureStorageSparseAMD;
    public final long glStencilOpValueAMD;
    public final long glTessellationFactorAMD;
    public final long glTessellationModeAMD;
    public final long glGetTextureHandleARB;
    public final long glGetTextureSamplerHandleARB;
    public final long glMakeTextureHandleResidentARB;
    public final long glMakeTextureHandleNonResidentARB;
    public final long glGetImageHandleARB;
    public final long glMakeImageHandleResidentARB;
    public final long glMakeImageHandleNonResidentARB;
    public final long glUniformHandleui64ARB;
    public final long glUniformHandleui64vARB;
    public final long glProgramUniformHandleui64ARB;
    public final long glProgramUniformHandleui64vARB;
    public final long glIsTextureHandleResidentARB;
    public final long glIsImageHandleResidentARB;
    public final long glVertexAttribL1ui64ARB;
    public final long glVertexAttribL1ui64vARB;
    public final long glGetVertexAttribLui64vARB;
    public final long glNamedBufferStorageEXT;
    public final long glCreateSyncFromCLeventARB;
    public final long glClearNamedBufferDataEXT;
    public final long glClearNamedBufferSubDataEXT;
    public final long glClampColorARB;
    public final long glDispatchComputeGroupSizeARB;
    public final long glDebugMessageControlARB;
    public final long glDebugMessageInsertARB;
    public final long glDebugMessageCallbackARB;
    public final long glGetDebugMessageLogARB;
    public final long glDrawBuffersARB;
    public final long glBlendEquationiARB;
    public final long glBlendEquationSeparateiARB;
    public final long glBlendFunciARB;
    public final long glBlendFuncSeparateiARB;
    public final long glDrawArraysInstancedARB;
    public final long glDrawElementsInstancedARB;
    public final long glPrimitiveBoundingBoxARB;
    public final long glNamedFramebufferParameteriEXT;
    public final long glGetNamedFramebufferParameterivEXT;
    public final long glProgramParameteriARB;
    public final long glFramebufferTextureARB;
    public final long glFramebufferTextureLayerARB;
    public final long glFramebufferTextureFaceARB;
    public final long glSpecializeShaderARB;
    public final long glProgramUniform1dEXT;
    public final long glProgramUniform2dEXT;
    public final long glProgramUniform3dEXT;
    public final long glProgramUniform4dEXT;
    public final long glProgramUniform1dvEXT;
    public final long glProgramUniform2dvEXT;
    public final long glProgramUniform3dvEXT;
    public final long glProgramUniform4dvEXT;
    public final long glProgramUniformMatrix2dvEXT;
    public final long glProgramUniformMatrix3dvEXT;
    public final long glProgramUniformMatrix4dvEXT;
    public final long glProgramUniformMatrix2x3dvEXT;
    public final long glProgramUniformMatrix2x4dvEXT;
    public final long glProgramUniformMatrix3x2dvEXT;
    public final long glProgramUniformMatrix3x4dvEXT;
    public final long glProgramUniformMatrix4x2dvEXT;
    public final long glProgramUniformMatrix4x3dvEXT;
    public final long glUniform1i64ARB;
    public final long glUniform1i64vARB;
    public final long glProgramUniform1i64ARB;
    public final long glProgramUniform1i64vARB;
    public final long glUniform2i64ARB;
    public final long glUniform2i64vARB;
    public final long glProgramUniform2i64ARB;
    public final long glProgramUniform2i64vARB;
    public final long glUniform3i64ARB;
    public final long glUniform3i64vARB;
    public final long glProgramUniform3i64ARB;
    public final long glProgramUniform3i64vARB;
    public final long glUniform4i64ARB;
    public final long glUniform4i64vARB;
    public final long glProgramUniform4i64ARB;
    public final long glProgramUniform4i64vARB;
    public final long glUniform1ui64ARB;
    public final long glUniform1ui64vARB;
    public final long glProgramUniform1ui64ARB;
    public final long glProgramUniform1ui64vARB;
    public final long glUniform2ui64ARB;
    public final long glUniform2ui64vARB;
    public final long glProgramUniform2ui64ARB;
    public final long glProgramUniform2ui64vARB;
    public final long glUniform3ui64ARB;
    public final long glUniform3ui64vARB;
    public final long glProgramUniform3ui64ARB;
    public final long glProgramUniform3ui64vARB;
    public final long glUniform4ui64ARB;
    public final long glUniform4ui64vARB;
    public final long glProgramUniform4ui64ARB;
    public final long glProgramUniform4ui64vARB;
    public final long glGetUniformi64vARB;
    public final long glGetUniformui64vARB;
    public final long glGetnUniformi64vARB;
    public final long glGetnUniformui64vARB;
    public final long glColorTable;
    public final long glCopyColorTable;
    public final long glColorTableParameteriv;
    public final long glColorTableParameterfv;
    public final long glGetColorTable;
    public final long glGetColorTableParameteriv;
    public final long glGetColorTableParameterfv;
    public final long glColorSubTable;
    public final long glCopyColorSubTable;
    public final long glConvolutionFilter1D;
    public final long glConvolutionFilter2D;
    public final long glCopyConvolutionFilter1D;
    public final long glCopyConvolutionFilter2D;
    public final long glGetConvolutionFilter;
    public final long glSeparableFilter2D;
    public final long glGetSeparableFilter;
    public final long glConvolutionParameteri;
    public final long glConvolutionParameteriv;
    public final long glConvolutionParameterf;
    public final long glConvolutionParameterfv;
    public final long glGetConvolutionParameteriv;
    public final long glGetConvolutionParameterfv;
    public final long glHistogram;
    public final long glResetHistogram;
    public final long glGetHistogram;
    public final long glGetHistogramParameteriv;
    public final long glGetHistogramParameterfv;
    public final long glMinmax;
    public final long glResetMinmax;
    public final long glGetMinmax;
    public final long glGetMinmaxParameteriv;
    public final long glGetMinmaxParameterfv;
    public final long glMultiDrawArraysIndirectCountARB;
    public final long glMultiDrawElementsIndirectCountARB;
    public final long glVertexAttribDivisorARB;
    public final long glVertexArrayVertexAttribDivisorEXT;
    public final long glCurrentPaletteMatrixARB;
    public final long glMatrixIndexuivARB;
    public final long glMatrixIndexubvARB;
    public final long glMatrixIndexusvARB;
    public final long glMatrixIndexPointerARB;
    public final long glSampleCoverageARB;
    public final long glActiveTextureARB;
    public final long glClientActiveTextureARB;
    public final long glMultiTexCoord1fARB;
    public final long glMultiTexCoord1sARB;
    public final long glMultiTexCoord1iARB;
    public final long glMultiTexCoord1dARB;
    public final long glMultiTexCoord1fvARB;
    public final long glMultiTexCoord1svARB;
    public final long glMultiTexCoord1ivARB;
    public final long glMultiTexCoord1dvARB;
    public final long glMultiTexCoord2fARB;
    public final long glMultiTexCoord2sARB;
    public final long glMultiTexCoord2iARB;
    public final long glMultiTexCoord2dARB;
    public final long glMultiTexCoord2fvARB;
    public final long glMultiTexCoord2svARB;
    public final long glMultiTexCoord2ivARB;
    public final long glMultiTexCoord2dvARB;
    public final long glMultiTexCoord3fARB;
    public final long glMultiTexCoord3sARB;
    public final long glMultiTexCoord3iARB;
    public final long glMultiTexCoord3dARB;
    public final long glMultiTexCoord3fvARB;
    public final long glMultiTexCoord3svARB;
    public final long glMultiTexCoord3ivARB;
    public final long glMultiTexCoord3dvARB;
    public final long glMultiTexCoord4fARB;
    public final long glMultiTexCoord4sARB;
    public final long glMultiTexCoord4iARB;
    public final long glMultiTexCoord4dARB;
    public final long glMultiTexCoord4fvARB;
    public final long glMultiTexCoord4svARB;
    public final long glMultiTexCoord4ivARB;
    public final long glMultiTexCoord4dvARB;
    public final long glGenQueriesARB;
    public final long glDeleteQueriesARB;
    public final long glIsQueryARB;
    public final long glBeginQueryARB;
    public final long glEndQueryARB;
    public final long glGetQueryivARB;
    public final long glGetQueryObjectivARB;
    public final long glGetQueryObjectuivARB;
    public final long glMaxShaderCompilerThreadsARB;
    public final long glPointParameterfARB;
    public final long glPointParameterfvARB;
    public final long glGetGraphicsResetStatusARB;
    public final long glGetnMapdvARB;
    public final long glGetnMapfvARB;
    public final long glGetnMapivARB;
    public final long glGetnPixelMapfvARB;
    public final long glGetnPixelMapuivARB;
    public final long glGetnPixelMapusvARB;
    public final long glGetnPolygonStippleARB;
    public final long glGetnTexImageARB;
    public final long glReadnPixelsARB;
    public final long glGetnColorTableARB;
    public final long glGetnConvolutionFilterARB;
    public final long glGetnSeparableFilterARB;
    public final long glGetnHistogramARB;
    public final long glGetnMinmaxARB;
    public final long glGetnCompressedTexImageARB;
    public final long glGetnUniformfvARB;
    public final long glGetnUniformivARB;
    public final long glGetnUniformuivARB;
    public final long glGetnUniformdvARB;
    public final long glFramebufferSampleLocationsfvARB;
    public final long glNamedFramebufferSampleLocationsfvARB;
    public final long glEvaluateDepthValuesARB;
    public final long glMinSampleShadingARB;
    public final long glDeleteObjectARB;
    public final long glGetHandleARB;
    public final long glDetachObjectARB;
    public final long glCreateShaderObjectARB;
    public final long glShaderSourceARB;
    public final long glCompileShaderARB;
    public final long glCreateProgramObjectARB;
    public final long glAttachObjectARB;
    public final long glLinkProgramARB;
    public final long glUseProgramObjectARB;
    public final long glValidateProgramARB;
    public final long glUniform1fARB;
    public final long glUniform2fARB;
    public final long glUniform3fARB;
    public final long glUniform4fARB;
    public final long glUniform1iARB;
    public final long glUniform2iARB;
    public final long glUniform3iARB;
    public final long glUniform4iARB;
    public final long glUniform1fvARB;
    public final long glUniform2fvARB;
    public final long glUniform3fvARB;
    public final long glUniform4fvARB;
    public final long glUniform1ivARB;
    public final long glUniform2ivARB;
    public final long glUniform3ivARB;
    public final long glUniform4ivARB;
    public final long glUniformMatrix2fvARB;
    public final long glUniformMatrix3fvARB;
    public final long glUniformMatrix4fvARB;
    public final long glGetObjectParameterfvARB;
    public final long glGetObjectParameterivARB;
    public final long glGetInfoLogARB;
    public final long glGetAttachedObjectsARB;
    public final long glGetUniformLocationARB;
    public final long glGetActiveUniformARB;
    public final long glGetUniformfvARB;
    public final long glGetUniformivARB;
    public final long glGetShaderSourceARB;
    public final long glNamedStringARB;
    public final long glDeleteNamedStringARB;
    public final long glCompileShaderIncludeARB;
    public final long glIsNamedStringARB;
    public final long glGetNamedStringARB;
    public final long glGetNamedStringivARB;
    public final long glBufferPageCommitmentARB;
    public final long glNamedBufferPageCommitmentEXT;
    public final long glNamedBufferPageCommitmentARB;
    public final long glTexPageCommitmentARB;
    public final long glTexturePageCommitmentEXT;
    public final long glTexBufferARB;
    public final long glTextureBufferRangeEXT;
    public final long glCompressedTexImage3DARB;
    public final long glCompressedTexImage2DARB;
    public final long glCompressedTexImage1DARB;
    public final long glCompressedTexSubImage3DARB;
    public final long glCompressedTexSubImage2DARB;
    public final long glCompressedTexSubImage1DARB;
    public final long glGetCompressedTexImageARB;
    public final long glTextureStorage1DEXT;
    public final long glTextureStorage2DEXT;
    public final long glTextureStorage3DEXT;
    public final long glTextureStorage2DMultisampleEXT;
    public final long glTextureStorage3DMultisampleEXT;
    public final long glLoadTransposeMatrixfARB;
    public final long glLoadTransposeMatrixdARB;
    public final long glMultTransposeMatrixfARB;
    public final long glMultTransposeMatrixdARB;
    public final long glVertexArrayVertexAttribLOffsetEXT;
    public final long glVertexArrayBindVertexBufferEXT;
    public final long glVertexArrayVertexAttribFormatEXT;
    public final long glVertexArrayVertexAttribIFormatEXT;
    public final long glVertexArrayVertexAttribLFormatEXT;
    public final long glVertexArrayVertexAttribBindingEXT;
    public final long glVertexArrayVertexBindingDivisorEXT;
    public final long glWeightfvARB;
    public final long glWeightbvARB;
    public final long glWeightubvARB;
    public final long glWeightsvARB;
    public final long glWeightusvARB;
    public final long glWeightivARB;
    public final long glWeightuivARB;
    public final long glWeightdvARB;
    public final long glWeightPointerARB;
    public final long glVertexBlendARB;
    public final long glBindBufferARB;
    public final long glDeleteBuffersARB;
    public final long glGenBuffersARB;
    public final long glIsBufferARB;
    public final long glBufferDataARB;
    public final long glBufferSubDataARB;
    public final long glGetBufferSubDataARB;
    public final long glMapBufferARB;
    public final long glUnmapBufferARB;
    public final long glGetBufferParameterivARB;
    public final long glGetBufferPointervARB;
    public final long glVertexAttrib1sARB;
    public final long glVertexAttrib1fARB;
    public final long glVertexAttrib1dARB;
    public final long glVertexAttrib2sARB;
    public final long glVertexAttrib2fARB;
    public final long glVertexAttrib2dARB;
    public final long glVertexAttrib3sARB;
    public final long glVertexAttrib3fARB;
    public final long glVertexAttrib3dARB;
    public final long glVertexAttrib4sARB;
    public final long glVertexAttrib4fARB;
    public final long glVertexAttrib4dARB;
    public final long glVertexAttrib4NubARB;
    public final long glVertexAttrib1svARB;
    public final long glVertexAttrib1fvARB;
    public final long glVertexAttrib1dvARB;
    public final long glVertexAttrib2svARB;
    public final long glVertexAttrib2fvARB;
    public final long glVertexAttrib2dvARB;
    public final long glVertexAttrib3svARB;
    public final long glVertexAttrib3fvARB;
    public final long glVertexAttrib3dvARB;
    public final long glVertexAttrib4fvARB;
    public final long glVertexAttrib4bvARB;
    public final long glVertexAttrib4svARB;
    public final long glVertexAttrib4ivARB;
    public final long glVertexAttrib4ubvARB;
    public final long glVertexAttrib4usvARB;
    public final long glVertexAttrib4uivARB;
    public final long glVertexAttrib4dvARB;
    public final long glVertexAttrib4NbvARB;
    public final long glVertexAttrib4NsvARB;
    public final long glVertexAttrib4NivARB;
    public final long glVertexAttrib4NubvARB;
    public final long glVertexAttrib4NusvARB;
    public final long glVertexAttrib4NuivARB;
    public final long glVertexAttribPointerARB;
    public final long glEnableVertexAttribArrayARB;
    public final long glDisableVertexAttribArrayARB;
    public final long glProgramStringARB;
    public final long glBindProgramARB;
    public final long glDeleteProgramsARB;
    public final long glGenProgramsARB;
    public final long glProgramEnvParameter4dARB;
    public final long glProgramEnvParameter4dvARB;
    public final long glProgramEnvParameter4fARB;
    public final long glProgramEnvParameter4fvARB;
    public final long glProgramLocalParameter4dARB;
    public final long glProgramLocalParameter4dvARB;
    public final long glProgramLocalParameter4fARB;
    public final long glProgramLocalParameter4fvARB;
    public final long glGetProgramEnvParameterfvARB;
    public final long glGetProgramEnvParameterdvARB;
    public final long glGetProgramLocalParameterfvARB;
    public final long glGetProgramLocalParameterdvARB;
    public final long glGetProgramivARB;
    public final long glGetProgramStringARB;
    public final long glGetVertexAttribfvARB;
    public final long glGetVertexAttribdvARB;
    public final long glGetVertexAttribivARB;
    public final long glGetVertexAttribPointervARB;
    public final long glIsProgramARB;
    public final long glBindAttribLocationARB;
    public final long glGetActiveAttribARB;
    public final long glGetAttribLocationARB;
    public final long glWindowPos2iARB;
    public final long glWindowPos2sARB;
    public final long glWindowPos2fARB;
    public final long glWindowPos2dARB;
    public final long glWindowPos2ivARB;
    public final long glWindowPos2svARB;
    public final long glWindowPos2fvARB;
    public final long glWindowPos2dvARB;
    public final long glWindowPos3iARB;
    public final long glWindowPos3sARB;
    public final long glWindowPos3fARB;
    public final long glWindowPos3dARB;
    public final long glWindowPos3ivARB;
    public final long glWindowPos3svARB;
    public final long glWindowPos3fvARB;
    public final long glWindowPos3dvARB;
    public final long glUniformBufferEXT;
    public final long glGetUniformBufferSizeEXT;
    public final long glGetUniformOffsetEXT;
    public final long glBlendColorEXT;
    public final long glBlendEquationSeparateEXT;
    public final long glBlendFuncSeparateEXT;
    public final long glBlendEquationEXT;
    public final long glLockArraysEXT;
    public final long glUnlockArraysEXT;
    public final long glLabelObjectEXT;
    public final long glGetObjectLabelEXT;
    public final long glInsertEventMarkerEXT;
    public final long glPushGroupMarkerEXT;
    public final long glPopGroupMarkerEXT;
    public final long glDepthBoundsEXT;
    public final long glClientAttribDefaultEXT;
    public final long glPushClientAttribDefaultEXT;
    public final long glMatrixLoadfEXT;
    public final long glMatrixLoaddEXT;
    public final long glMatrixMultfEXT;
    public final long glMatrixMultdEXT;
    public final long glMatrixLoadIdentityEXT;
    public final long glMatrixRotatefEXT;
    public final long glMatrixRotatedEXT;
    public final long glMatrixScalefEXT;
    public final long glMatrixScaledEXT;
    public final long glMatrixTranslatefEXT;
    public final long glMatrixTranslatedEXT;
    public final long glMatrixOrthoEXT;
    public final long glMatrixFrustumEXT;
    public final long glMatrixPushEXT;
    public final long glMatrixPopEXT;
    public final long glTextureParameteriEXT;
    public final long glTextureParameterivEXT;
    public final long glTextureParameterfEXT;
    public final long glTextureParameterfvEXT;
    public final long glTextureImage1DEXT;
    public final long glTextureImage2DEXT;
    public final long glTextureSubImage1DEXT;
    public final long glTextureSubImage2DEXT;
    public final long glCopyTextureImage1DEXT;
    public final long glCopyTextureImage2DEXT;
    public final long glCopyTextureSubImage1DEXT;
    public final long glCopyTextureSubImage2DEXT;
    public final long glGetTextureImageEXT;
    public final long glGetTextureParameterfvEXT;
    public final long glGetTextureParameterivEXT;
    public final long glGetTextureLevelParameterfvEXT;
    public final long glGetTextureLevelParameterivEXT;
    public final long glTextureImage3DEXT;
    public final long glTextureSubImage3DEXT;
    public final long glCopyTextureSubImage3DEXT;
    public final long glBindMultiTextureEXT;
    public final long glMultiTexCoordPointerEXT;
    public final long glMultiTexEnvfEXT;
    public final long glMultiTexEnvfvEXT;
    public final long glMultiTexEnviEXT;
    public final long glMultiTexEnvivEXT;
    public final long glMultiTexGendEXT;
    public final long glMultiTexGendvEXT;
    public final long glMultiTexGenfEXT;
    public final long glMultiTexGenfvEXT;
    public final long glMultiTexGeniEXT;
    public final long glMultiTexGenivEXT;
    public final long glGetMultiTexEnvfvEXT;
    public final long glGetMultiTexEnvivEXT;
    public final long glGetMultiTexGendvEXT;
    public final long glGetMultiTexGenfvEXT;
    public final long glGetMultiTexGenivEXT;
    public final long glMultiTexParameteriEXT;
    public final long glMultiTexParameterivEXT;
    public final long glMultiTexParameterfEXT;
    public final long glMultiTexParameterfvEXT;
    public final long glMultiTexImage1DEXT;
    public final long glMultiTexImage2DEXT;
    public final long glMultiTexSubImage1DEXT;
    public final long glMultiTexSubImage2DEXT;
    public final long glCopyMultiTexImage1DEXT;
    public final long glCopyMultiTexImage2DEXT;
    public final long glCopyMultiTexSubImage1DEXT;
    public final long glCopyMultiTexSubImage2DEXT;
    public final long glGetMultiTexImageEXT;
    public final long glGetMultiTexParameterfvEXT;
    public final long glGetMultiTexParameterivEXT;
    public final long glGetMultiTexLevelParameterfvEXT;
    public final long glGetMultiTexLevelParameterivEXT;
    public final long glMultiTexImage3DEXT;
    public final long glMultiTexSubImage3DEXT;
    public final long glCopyMultiTexSubImage3DEXT;
    public final long glEnableClientStateIndexedEXT;
    public final long glDisableClientStateIndexedEXT;
    public final long glEnableClientStateiEXT;
    public final long glDisableClientStateiEXT;
    public final long glGetFloatIndexedvEXT;
    public final long glGetDoubleIndexedvEXT;
    public final long glGetPointerIndexedvEXT;
    public final long glGetFloati_vEXT;
    public final long glGetDoublei_vEXT;
    public final long glGetPointeri_vEXT;
    public final long glEnableIndexedEXT;
    public final long glDisableIndexedEXT;
    public final long glIsEnabledIndexedEXT;
    public final long glGetIntegerIndexedvEXT;
    public final long glGetBooleanIndexedvEXT;
    public final long glNamedProgramStringEXT;
    public final long glNamedProgramLocalParameter4dEXT;
    public final long glNamedProgramLocalParameter4dvEXT;
    public final long glNamedProgramLocalParameter4fEXT;
    public final long glNamedProgramLocalParameter4fvEXT;
    public final long glGetNamedProgramLocalParameterdvEXT;
    public final long glGetNamedProgramLocalParameterfvEXT;
    public final long glGetNamedProgramivEXT;
    public final long glGetNamedProgramStringEXT;
    public final long glCompressedTextureImage3DEXT;
    public final long glCompressedTextureImage2DEXT;
    public final long glCompressedTextureImage1DEXT;
    public final long glCompressedTextureSubImage3DEXT;
    public final long glCompressedTextureSubImage2DEXT;
    public final long glCompressedTextureSubImage1DEXT;
    public final long glGetCompressedTextureImageEXT;
    public final long glCompressedMultiTexImage3DEXT;
    public final long glCompressedMultiTexImage2DEXT;
    public final long glCompressedMultiTexImage1DEXT;
    public final long glCompressedMultiTexSubImage3DEXT;
    public final long glCompressedMultiTexSubImage2DEXT;
    public final long glCompressedMultiTexSubImage1DEXT;
    public final long glGetCompressedMultiTexImageEXT;
    public final long glMatrixLoadTransposefEXT;
    public final long glMatrixLoadTransposedEXT;
    public final long glMatrixMultTransposefEXT;
    public final long glMatrixMultTransposedEXT;
    public final long glNamedBufferDataEXT;
    public final long glNamedBufferSubDataEXT;
    public final long glMapNamedBufferEXT;
    public final long glUnmapNamedBufferEXT;
    public final long glGetNamedBufferParameterivEXT;
    public final long glGetNamedBufferSubDataEXT;
    public final long glProgramUniform1fEXT;
    public final long glProgramUniform2fEXT;
    public final long glProgramUniform3fEXT;
    public final long glProgramUniform4fEXT;
    public final long glProgramUniform1iEXT;
    public final long glProgramUniform2iEXT;
    public final long glProgramUniform3iEXT;
    public final long glProgramUniform4iEXT;
    public final long glProgramUniform1fvEXT;
    public final long glProgramUniform2fvEXT;
    public final long glProgramUniform3fvEXT;
    public final long glProgramUniform4fvEXT;
    public final long glProgramUniform1ivEXT;
    public final long glProgramUniform2ivEXT;
    public final long glProgramUniform3ivEXT;
    public final long glProgramUniform4ivEXT;
    public final long glProgramUniformMatrix2fvEXT;
    public final long glProgramUniformMatrix3fvEXT;
    public final long glProgramUniformMatrix4fvEXT;
    public final long glProgramUniformMatrix2x3fvEXT;
    public final long glProgramUniformMatrix3x2fvEXT;
    public final long glProgramUniformMatrix2x4fvEXT;
    public final long glProgramUniformMatrix4x2fvEXT;
    public final long glProgramUniformMatrix3x4fvEXT;
    public final long glProgramUniformMatrix4x3fvEXT;
    public final long glTextureBufferEXT;
    public final long glMultiTexBufferEXT;
    public final long glTextureParameterIivEXT;
    public final long glTextureParameterIuivEXT;
    public final long glGetTextureParameterIivEXT;
    public final long glGetTextureParameterIuivEXT;
    public final long glMultiTexParameterIivEXT;
    public final long glMultiTexParameterIuivEXT;
    public final long glGetMultiTexParameterIivEXT;
    public final long glGetMultiTexParameterIuivEXT;
    public final long glProgramUniform1uiEXT;
    public final long glProgramUniform2uiEXT;
    public final long glProgramUniform3uiEXT;
    public final long glProgramUniform4uiEXT;
    public final long glProgramUniform1uivEXT;
    public final long glProgramUniform2uivEXT;
    public final long glProgramUniform3uivEXT;
    public final long glProgramUniform4uivEXT;
    public final long glNamedProgramLocalParameters4fvEXT;
    public final long glNamedProgramLocalParameterI4iEXT;
    public final long glNamedProgramLocalParameterI4ivEXT;
    public final long glNamedProgramLocalParametersI4ivEXT;
    public final long glNamedProgramLocalParameterI4uiEXT;
    public final long glNamedProgramLocalParameterI4uivEXT;
    public final long glNamedProgramLocalParametersI4uivEXT;
    public final long glGetNamedProgramLocalParameterIivEXT;
    public final long glGetNamedProgramLocalParameterIuivEXT;
    public final long glNamedRenderbufferStorageEXT;
    public final long glGetNamedRenderbufferParameterivEXT;
    public final long glNamedRenderbufferStorageMultisampleEXT;
    public final long glNamedRenderbufferStorageMultisampleCoverageEXT;
    public final long glCheckNamedFramebufferStatusEXT;
    public final long glNamedFramebufferTexture1DEXT;
    public final long glNamedFramebufferTexture2DEXT;
    public final long glNamedFramebufferTexture3DEXT;
    public final long glNamedFramebufferRenderbufferEXT;
    public final long glGetNamedFramebufferAttachmentParameterivEXT;
    public final long glGenerateTextureMipmapEXT;
    public final long glGenerateMultiTexMipmapEXT;
    public final long glFramebufferDrawBufferEXT;
    public final long glFramebufferDrawBuffersEXT;
    public final long glFramebufferReadBufferEXT;
    public final long glGetFramebufferParameterivEXT;
    public final long glNamedCopyBufferSubDataEXT;
    public final long glNamedFramebufferTextureEXT;
    public final long glNamedFramebufferTextureLayerEXT;
    public final long glNamedFramebufferTextureFaceEXT;
    public final long glTextureRenderbufferEXT;
    public final long glMultiTexRenderbufferEXT;
    public final long glVertexArrayVertexOffsetEXT;
    public final long glVertexArrayColorOffsetEXT;
    public final long glVertexArrayEdgeFlagOffsetEXT;
    public final long glVertexArrayIndexOffsetEXT;
    public final long glVertexArrayNormalOffsetEXT;
    public final long glVertexArrayTexCoordOffsetEXT;
    public final long glVertexArrayMultiTexCoordOffsetEXT;
    public final long glVertexArrayFogCoordOffsetEXT;
    public final long glVertexArraySecondaryColorOffsetEXT;
    public final long glVertexArrayVertexAttribOffsetEXT;
    public final long glVertexArrayVertexAttribIOffsetEXT;
    public final long glEnableVertexArrayEXT;
    public final long glDisableVertexArrayEXT;
    public final long glEnableVertexArrayAttribEXT;
    public final long glDisableVertexArrayAttribEXT;
    public final long glGetVertexArrayIntegervEXT;
    public final long glGetVertexArrayPointervEXT;
    public final long glGetVertexArrayIntegeri_vEXT;
    public final long glGetVertexArrayPointeri_vEXT;
    public final long glMapNamedBufferRangeEXT;
    public final long glFlushMappedNamedBufferRangeEXT;
    public final long glColorMaskIndexedEXT;
    public final long glDrawArraysInstancedEXT;
    public final long glDrawElementsInstancedEXT;
    public final long glEGLImageTargetTexStorageEXT;
    public final long glEGLImageTargetTextureStorageEXT;
    public final long glBufferStorageExternalEXT;
    public final long glNamedBufferStorageExternalEXT;
    public final long glBlitFramebufferEXT;
    public final long glRenderbufferStorageMultisampleEXT;
    public final long glIsRenderbufferEXT;
    public final long glBindRenderbufferEXT;
    public final long glDeleteRenderbuffersEXT;
    public final long glGenRenderbuffersEXT;
    public final long glRenderbufferStorageEXT;
    public final long glGetRenderbufferParameterivEXT;
    public final long glIsFramebufferEXT;
    public final long glBindFramebufferEXT;
    public final long glDeleteFramebuffersEXT;
    public final long glGenFramebuffersEXT;
    public final long glCheckFramebufferStatusEXT;
    public final long glFramebufferTexture1DEXT;
    public final long glFramebufferTexture2DEXT;
    public final long glFramebufferTexture3DEXT;
    public final long glFramebufferRenderbufferEXT;
    public final long glGetFramebufferAttachmentParameterivEXT;
    public final long glGenerateMipmapEXT;
    public final long glProgramParameteriEXT;
    public final long glFramebufferTextureEXT;
    public final long glFramebufferTextureLayerEXT;
    public final long glFramebufferTextureFaceEXT;
    public final long glProgramEnvParameters4fvEXT;
    public final long glProgramLocalParameters4fvEXT;
    public final long glVertexAttribI1iEXT;
    public final long glVertexAttribI2iEXT;
    public final long glVertexAttribI3iEXT;
    public final long glVertexAttribI4iEXT;
    public final long glVertexAttribI1uiEXT;
    public final long glVertexAttribI2uiEXT;
    public final long glVertexAttribI3uiEXT;
    public final long glVertexAttribI4uiEXT;
    public final long glVertexAttribI1ivEXT;
    public final long glVertexAttribI2ivEXT;
    public final long glVertexAttribI3ivEXT;
    public final long glVertexAttribI4ivEXT;
    public final long glVertexAttribI1uivEXT;
    public final long glVertexAttribI2uivEXT;
    public final long glVertexAttribI3uivEXT;
    public final long glVertexAttribI4uivEXT;
    public final long glVertexAttribI4bvEXT;
    public final long glVertexAttribI4svEXT;
    public final long glVertexAttribI4ubvEXT;
    public final long glVertexAttribI4usvEXT;
    public final long glVertexAttribIPointerEXT;
    public final long glGetVertexAttribIivEXT;
    public final long glGetVertexAttribIuivEXT;
    public final long glGetUniformuivEXT;
    public final long glBindFragDataLocationEXT;
    public final long glGetFragDataLocationEXT;
    public final long glUniform1uiEXT;
    public final long glUniform2uiEXT;
    public final long glUniform3uiEXT;
    public final long glUniform4uiEXT;
    public final long glUniform1uivEXT;
    public final long glUniform2uivEXT;
    public final long glUniform3uivEXT;
    public final long glUniform4uivEXT;
    public final long glGetUnsignedBytevEXT;
    public final long glGetUnsignedBytei_vEXT;
    public final long glDeleteMemoryObjectsEXT;
    public final long glIsMemoryObjectEXT;
    public final long glCreateMemoryObjectsEXT;
    public final long glMemoryObjectParameterivEXT;
    public final long glGetMemoryObjectParameterivEXT;
    public final long glTexStorageMem2DEXT;
    public final long glTexStorageMem2DMultisampleEXT;
    public final long glTexStorageMem3DEXT;
    public final long glTexStorageMem3DMultisampleEXT;
    public final long glBufferStorageMemEXT;
    public final long glTextureStorageMem2DEXT;
    public final long glTextureStorageMem2DMultisampleEXT;
    public final long glTextureStorageMem3DEXT;
    public final long glTextureStorageMem3DMultisampleEXT;
    public final long glNamedBufferStorageMemEXT;
    public final long glTexStorageMem1DEXT;
    public final long glTextureStorageMem1DEXT;
    public final long glImportMemoryFdEXT;
    public final long glImportMemoryWin32HandleEXT;
    public final long glImportMemoryWin32NameEXT;
    public final long glPointParameterfEXT;
    public final long glPointParameterfvEXT;
    public final long glPolygonOffsetClampEXT;
    public final long glProvokingVertexEXT;
    public final long glRasterSamplesEXT;
    public final long glSecondaryColor3bEXT;
    public final long glSecondaryColor3sEXT;
    public final long glSecondaryColor3iEXT;
    public final long glSecondaryColor3fEXT;
    public final long glSecondaryColor3dEXT;
    public final long glSecondaryColor3ubEXT;
    public final long glSecondaryColor3usEXT;
    public final long glSecondaryColor3uiEXT;
    public final long glSecondaryColor3bvEXT;
    public final long glSecondaryColor3svEXT;
    public final long glSecondaryColor3ivEXT;
    public final long glSecondaryColor3fvEXT;
    public final long glSecondaryColor3dvEXT;
    public final long glSecondaryColor3ubvEXT;
    public final long glSecondaryColor3usvEXT;
    public final long glSecondaryColor3uivEXT;
    public final long glSecondaryColorPointerEXT;
    public final long glGenSemaphoresEXT;
    public final long glDeleteSemaphoresEXT;
    public final long glIsSemaphoreEXT;
    public final long glSemaphoreParameterui64vEXT;
    public final long glGetSemaphoreParameterui64vEXT;
    public final long glWaitSemaphoreEXT;
    public final long glSignalSemaphoreEXT;
    public final long glImportSemaphoreFdEXT;
    public final long glImportSemaphoreWin32HandleEXT;
    public final long glImportSemaphoreWin32NameEXT;
    public final long glUseShaderProgramEXT;
    public final long glActiveProgramEXT;
    public final long glCreateShaderProgramEXT;
    public final long glFramebufferFetchBarrierEXT;
    public final long glBindImageTextureEXT;
    public final long glMemoryBarrierEXT;
    public final long glStencilClearTagEXT;
    public final long glActiveStencilFaceEXT;
    public final long glTexBufferEXT;
    public final long glClearColorIiEXT;
    public final long glClearColorIuiEXT;
    public final long glTexParameterIivEXT;
    public final long glTexParameterIuivEXT;
    public final long glGetTexParameterIivEXT;
    public final long glGetTexParameterIuivEXT;
    public final long glTexStorage1DEXT;
    public final long glTexStorage2DEXT;
    public final long glTexStorage3DEXT;
    public final long glGetQueryObjecti64vEXT;
    public final long glGetQueryObjectui64vEXT;
    public final long glBindBufferRangeEXT;
    public final long glBindBufferOffsetEXT;
    public final long glBindBufferBaseEXT;
    public final long glBeginTransformFeedbackEXT;
    public final long glEndTransformFeedbackEXT;
    public final long glTransformFeedbackVaryingsEXT;
    public final long glGetTransformFeedbackVaryingEXT;
    public final long glVertexAttribL1dEXT;
    public final long glVertexAttribL2dEXT;
    public final long glVertexAttribL3dEXT;
    public final long glVertexAttribL4dEXT;
    public final long glVertexAttribL1dvEXT;
    public final long glVertexAttribL2dvEXT;
    public final long glVertexAttribL3dvEXT;
    public final long glVertexAttribL4dvEXT;
    public final long glVertexAttribLPointerEXT;
    public final long glGetVertexAttribLdvEXT;
    public final long glAcquireKeyedMutexWin32EXT;
    public final long glReleaseKeyedMutexWin32EXT;
    public final long glWindowRectanglesEXT;
    public final long glImportSyncEXT;
    public final long glFrameTerminatorGREMEDY;
    public final long glStringMarkerGREMEDY;
    public final long glApplyFramebufferAttachmentCMAAINTEL;
    public final long glSyncTextureINTEL;
    public final long glUnmapTexture2DINTEL;
    public final long glMapTexture2DINTEL;
    public final long glBeginPerfQueryINTEL;
    public final long glCreatePerfQueryINTEL;
    public final long glDeletePerfQueryINTEL;
    public final long glEndPerfQueryINTEL;
    public final long glGetFirstPerfQueryIdINTEL;
    public final long glGetNextPerfQueryIdINTEL;
    public final long glGetPerfCounterInfoINTEL;
    public final long glGetPerfQueryDataINTEL;
    public final long glGetPerfQueryIdByNameINTEL;
    public final long glGetPerfQueryInfoINTEL;
    public final long glBlendBarrierKHR;
    public final long glMaxShaderCompilerThreadsKHR;
    public final long glFramebufferParameteriMESA;
    public final long glGetFramebufferParameterivMESA;
    public final long glAlphaToCoverageDitherControlNV;
    public final long glMultiDrawArraysIndirectBindlessNV;
    public final long glMultiDrawElementsIndirectBindlessNV;
    public final long glMultiDrawArraysIndirectBindlessCountNV;
    public final long glMultiDrawElementsIndirectBindlessCountNV;
    public final long glGetTextureHandleNV;
    public final long glGetTextureSamplerHandleNV;
    public final long glMakeTextureHandleResidentNV;
    public final long glMakeTextureHandleNonResidentNV;
    public final long glGetImageHandleNV;
    public final long glMakeImageHandleResidentNV;
    public final long glMakeImageHandleNonResidentNV;
    public final long glUniformHandleui64NV;
    public final long glUniformHandleui64vNV;
    public final long glProgramUniformHandleui64NV;
    public final long glProgramUniformHandleui64vNV;
    public final long glIsTextureHandleResidentNV;
    public final long glIsImageHandleResidentNV;
    public final long glBlendParameteriNV;
    public final long glBlendBarrierNV;
    public final long glViewportPositionWScaleNV;
    public final long glCreateStatesNV;
    public final long glDeleteStatesNV;
    public final long glIsStateNV;
    public final long glStateCaptureNV;
    public final long glGetCommandHeaderNV;
    public final long glGetStageIndexNV;
    public final long glDrawCommandsNV;
    public final long glDrawCommandsAddressNV;
    public final long glDrawCommandsStatesNV;
    public final long glDrawCommandsStatesAddressNV;
    public final long glCreateCommandListsNV;
    public final long glDeleteCommandListsNV;
    public final long glIsCommandListNV;
    public final long glListDrawCommandsStatesClientNV;
    public final long glCommandListSegmentsNV;
    public final long glCompileCommandListNV;
    public final long glCallCommandListNV;
    public final long glBeginConditionalRenderNV;
    public final long glEndConditionalRenderNV;
    public final long glSubpixelPrecisionBiasNV;
    public final long glConservativeRasterParameterfNV;
    public final long glConservativeRasterParameteriNV;
    public final long glCopyImageSubDataNV;
    public final long glDepthRangedNV;
    public final long glClearDepthdNV;
    public final long glDepthBoundsdNV;
    public final long glDrawTextureNV;
    public final long glDrawVkImageNV;
    public final long glGetVkProcAddrNV;
    public final long glWaitVkSemaphoreNV;
    public final long glSignalVkSemaphoreNV;
    public final long glSignalVkFenceNV;
    public final long glGetMultisamplefvNV;
    public final long glSampleMaskIndexedNV;
    public final long glTexRenderbufferNV;
    public final long glDeleteFencesNV;
    public final long glGenFencesNV;
    public final long glIsFenceNV;
    public final long glTestFenceNV;
    public final long glGetFenceivNV;
    public final long glFinishFenceNV;
    public final long glSetFenceNV;
    public final long glFragmentCoverageColorNV;
    public final long glCoverageModulationTableNV;
    public final long glGetCoverageModulationTableNV;
    public final long glCoverageModulationNV;
    public final long glRenderbufferStorageMultisampleCoverageNV;
    public final long glRenderGpuMaskNV;
    public final long glMulticastBufferSubDataNV;
    public final long glMulticastCopyBufferSubDataNV;
    public final long glMulticastCopyImageSubDataNV;
    public final long glMulticastBlitFramebufferNV;
    public final long glMulticastFramebufferSampleLocationsfvNV;
    public final long glMulticastBarrierNV;
    public final long glMulticastWaitSyncNV;
    public final long glMulticastGetQueryObjectivNV;
    public final long glMulticastGetQueryObjectuivNV;
    public final long glMulticastGetQueryObjecti64vNV;
    public final long glMulticastGetQueryObjectui64vNV;
    public final long glVertex2hNV;
    public final long glVertex2hvNV;
    public final long glVertex3hNV;
    public final long glVertex3hvNV;
    public final long glVertex4hNV;
    public final long glVertex4hvNV;
    public final long glNormal3hNV;
    public final long glNormal3hvNV;
    public final long glColor3hNV;
    public final long glColor3hvNV;
    public final long glColor4hNV;
    public final long glColor4hvNV;
    public final long glTexCoord1hNV;
    public final long glTexCoord1hvNV;
    public final long glTexCoord2hNV;
    public final long glTexCoord2hvNV;
    public final long glTexCoord3hNV;
    public final long glTexCoord3hvNV;
    public final long glTexCoord4hNV;
    public final long glTexCoord4hvNV;
    public final long glMultiTexCoord1hNV;
    public final long glMultiTexCoord1hvNV;
    public final long glMultiTexCoord2hNV;
    public final long glMultiTexCoord2hvNV;
    public final long glMultiTexCoord3hNV;
    public final long glMultiTexCoord3hvNV;
    public final long glMultiTexCoord4hNV;
    public final long glMultiTexCoord4hvNV;
    public final long glFogCoordhNV;
    public final long glFogCoordhvNV;
    public final long glSecondaryColor3hNV;
    public final long glSecondaryColor3hvNV;
    public final long glVertexWeighthNV;
    public final long glVertexWeighthvNV;
    public final long glVertexAttrib1hNV;
    public final long glVertexAttrib1hvNV;
    public final long glVertexAttrib2hNV;
    public final long glVertexAttrib2hvNV;
    public final long glVertexAttrib3hNV;
    public final long glVertexAttrib3hvNV;
    public final long glVertexAttrib4hNV;
    public final long glVertexAttrib4hvNV;
    public final long glVertexAttribs1hvNV;
    public final long glVertexAttribs2hvNV;
    public final long glVertexAttribs3hvNV;
    public final long glVertexAttribs4hvNV;
    public final long glGetInternalformatSampleivNV;
    public final long glGetMemoryObjectDetachedResourcesuivNV;
    public final long glResetMemoryObjectParameterNV;
    public final long glTexAttachMemoryNV;
    public final long glBufferAttachMemoryNV;
    public final long glTextureAttachMemoryNV;
    public final long glNamedBufferAttachMemoryNV;
    public final long glBufferPageCommitmentMemNV;
    public final long glNamedBufferPageCommitmentMemNV;
    public final long glTexPageCommitmentMemNV;
    public final long glTexturePageCommitmentMemNV;
    public final long glDrawMeshTasksNV;
    public final long glDrawMeshTasksIndirectNV;
    public final long glMultiDrawMeshTasksIndirectNV;
    public final long glMultiDrawMeshTasksIndirectCountNV;
    public final long glPathCommandsNV;
    public final long glPathCoordsNV;
    public final long glPathSubCommandsNV;
    public final long glPathSubCoordsNV;
    public final long glPathStringNV;
    public final long glPathGlyphsNV;
    public final long glPathGlyphRangeNV;
    public final long glPathGlyphIndexArrayNV;
    public final long glPathMemoryGlyphIndexArrayNV;
    public final long glCopyPathNV;
    public final long glWeightPathsNV;
    public final long glInterpolatePathsNV;
    public final long glTransformPathNV;
    public final long glPathParameterivNV;
    public final long glPathParameteriNV;
    public final long glPathParameterfvNV;
    public final long glPathParameterfNV;
    public final long glPathDashArrayNV;
    public final long glGenPathsNV;
    public final long glDeletePathsNV;
    public final long glIsPathNV;
    public final long glPathStencilFuncNV;
    public final long glPathStencilDepthOffsetNV;
    public final long glStencilFillPathNV;
    public final long glStencilStrokePathNV;
    public final long glStencilFillPathInstancedNV;
    public final long glStencilStrokePathInstancedNV;
    public final long glPathCoverDepthFuncNV;
    public final long glPathColorGenNV;
    public final long glPathTexGenNV;
    public final long glPathFogGenNV;
    public final long glCoverFillPathNV;
    public final long glCoverStrokePathNV;
    public final long glCoverFillPathInstancedNV;
    public final long glCoverStrokePathInstancedNV;
    public final long glStencilThenCoverFillPathNV;
    public final long glStencilThenCoverStrokePathNV;
    public final long glStencilThenCoverFillPathInstancedNV;
    public final long glStencilThenCoverStrokePathInstancedNV;
    public final long glPathGlyphIndexRangeNV;
    public final long glProgramPathFragmentInputGenNV;
    public final long glGetPathParameterivNV;
    public final long glGetPathParameterfvNV;
    public final long glGetPathCommandsNV;
    public final long glGetPathCoordsNV;
    public final long glGetPathDashArrayNV;
    public final long glGetPathMetricsNV;
    public final long glGetPathMetricRangeNV;
    public final long glGetPathSpacingNV;
    public final long glGetPathColorGenivNV;
    public final long glGetPathColorGenfvNV;
    public final long glGetPathTexGenivNV;
    public final long glGetPathTexGenfvNV;
    public final long glIsPointInFillPathNV;
    public final long glIsPointInStrokePathNV;
    public final long glGetPathLengthNV;
    public final long glPointAlongPathNV;
    public final long glMatrixLoad3x2fNV;
    public final long glMatrixLoad3x3fNV;
    public final long glMatrixLoadTranspose3x3fNV;
    public final long glMatrixMult3x2fNV;
    public final long glMatrixMult3x3fNV;
    public final long glMatrixMultTranspose3x3fNV;
    public final long glGetProgramResourcefvNV;
    public final long glPixelDataRangeNV;
    public final long glFlushPixelDataRangeNV;
    public final long glPointParameteriNV;
    public final long glPointParameterivNV;
    public final long glPrimitiveRestartNV;
    public final long glPrimitiveRestartIndexNV;
    public final long glQueryResourceNV;
    public final long glGenQueryResourceTagNV;
    public final long glDeleteQueryResourceTagNV;
    public final long glQueryResourceTagNV;
    public final long glFramebufferSampleLocationsfvNV;
    public final long glNamedFramebufferSampleLocationsfvNV;
    public final long glResolveDepthValuesNV;
    public final long glScissorExclusiveArrayvNV;
    public final long glScissorExclusiveNV;
    public final long glMakeBufferResidentNV;
    public final long glMakeBufferNonResidentNV;
    public final long glIsBufferResidentNV;
    public final long glMakeNamedBufferResidentNV;
    public final long glMakeNamedBufferNonResidentNV;
    public final long glIsNamedBufferResidentNV;
    public final long glGetBufferParameterui64vNV;
    public final long glGetNamedBufferParameterui64vNV;
    public final long glGetIntegerui64vNV;
    public final long glUniformui64NV;
    public final long glUniformui64vNV;
    public final long glProgramUniformui64NV;
    public final long glProgramUniformui64vNV;
    public final long glBindShadingRateImageNV;
    public final long glShadingRateImagePaletteNV;
    public final long glGetShadingRateImagePaletteNV;
    public final long glShadingRateImageBarrierNV;
    public final long glShadingRateSampleOrderNV;
    public final long glShadingRateSampleOrderCustomNV;
    public final long glGetShadingRateSampleLocationivNV;
    public final long glTextureBarrierNV;
    public final long glTexImage2DMultisampleCoverageNV;
    public final long glTexImage3DMultisampleCoverageNV;
    public final long glTextureImage2DMultisampleNV;
    public final long glTextureImage3DMultisampleNV;
    public final long glTextureImage2DMultisampleCoverageNV;
    public final long glTextureImage3DMultisampleCoverageNV;
    public final long glCreateSemaphoresNV;
    public final long glSemaphoreParameterivNV;
    public final long glGetSemaphoreParameterivNV;
    public final long glBeginTransformFeedbackNV;
    public final long glEndTransformFeedbackNV;
    public final long glTransformFeedbackAttribsNV;
    public final long glBindBufferRangeNV;
    public final long glBindBufferOffsetNV;
    public final long glBindBufferBaseNV;
    public final long glTransformFeedbackVaryingsNV;
    public final long glActiveVaryingNV;
    public final long glGetVaryingLocationNV;
    public final long glGetActiveVaryingNV;
    public final long glGetTransformFeedbackVaryingNV;
    public final long glTransformFeedbackStreamAttribsNV;
    public final long glBindTransformFeedbackNV;
    public final long glDeleteTransformFeedbacksNV;
    public final long glGenTransformFeedbacksNV;
    public final long glIsTransformFeedbackNV;
    public final long glPauseTransformFeedbackNV;
    public final long glResumeTransformFeedbackNV;
    public final long glDrawTransformFeedbackNV;
    public final long glVertexArrayRangeNV;
    public final long glFlushVertexArrayRangeNV;
    public final long glVertexAttribL1i64NV;
    public final long glVertexAttribL2i64NV;
    public final long glVertexAttribL3i64NV;
    public final long glVertexAttribL4i64NV;
    public final long glVertexAttribL1i64vNV;
    public final long glVertexAttribL2i64vNV;
    public final long glVertexAttribL3i64vNV;
    public final long glVertexAttribL4i64vNV;
    public final long glVertexAttribL1ui64NV;
    public final long glVertexAttribL2ui64NV;
    public final long glVertexAttribL3ui64NV;
    public final long glVertexAttribL4ui64NV;
    public final long glVertexAttribL1ui64vNV;
    public final long glVertexAttribL2ui64vNV;
    public final long glVertexAttribL3ui64vNV;
    public final long glVertexAttribL4ui64vNV;
    public final long glGetVertexAttribLi64vNV;
    public final long glGetVertexAttribLui64vNV;
    public final long glVertexAttribLFormatNV;
    public final long glBufferAddressRangeNV;
    public final long glVertexFormatNV;
    public final long glNormalFormatNV;
    public final long glColorFormatNV;
    public final long glIndexFormatNV;
    public final long glTexCoordFormatNV;
    public final long glEdgeFlagFormatNV;
    public final long glSecondaryColorFormatNV;
    public final long glFogCoordFormatNV;
    public final long glVertexAttribFormatNV;
    public final long glVertexAttribIFormatNV;
    public final long glGetIntegerui64i_vNV;
    public final long glViewportSwizzleNV;
    public final long glBeginConditionalRenderNVX;
    public final long glEndConditionalRenderNVX;
    public final long glAsyncCopyImageSubDataNVX;
    public final long glAsyncCopyBufferSubDataNVX;
    public final long glUploadGpuMaskNVX;
    public final long glMulticastViewportArrayvNVX;
    public final long glMulticastScissorArrayvNVX;
    public final long glMulticastViewportPositionWScaleNVX;
    public final long glCreateProgressFenceNVX;
    public final long glSignalSemaphoreui64NVX;
    public final long glWaitSemaphoreui64NVX;
    public final long glClientWaitSemaphoreui64NVX;
    public final long glFramebufferTextureMultiviewOVR;
    public final long glNamedFramebufferTextureMultiviewOVR;
    public final boolean OpenGL11;
    public final boolean OpenGL12;
    public final boolean OpenGL13;
    public final boolean OpenGL14;
    public final boolean OpenGL15;
    public final boolean OpenGL20;
    public final boolean OpenGL21;
    public final boolean OpenGL30;
    public final boolean OpenGL31;
    public final boolean OpenGL32;
    public final boolean OpenGL33;
    public final boolean OpenGL40;
    public final boolean OpenGL41;
    public final boolean OpenGL42;
    public final boolean OpenGL43;
    public final boolean OpenGL44;
    public final boolean OpenGL45;
    public final boolean OpenGL46;
    public final boolean GL_3DFX_texture_compression_FXT1;
    public final boolean GL_AMD_blend_minmax_factor;
    public final boolean GL_AMD_conservative_depth;
    public final boolean GL_AMD_debug_output;
    public final boolean GL_AMD_depth_clamp_separate;
    public final boolean GL_AMD_draw_buffers_blend;
    public final boolean GL_AMD_framebuffer_multisample_advanced;
    public final boolean GL_AMD_gcn_shader;
    public final boolean GL_AMD_gpu_shader_half_float;
    public final boolean GL_AMD_gpu_shader_half_float_fetch;
    public final boolean GL_AMD_gpu_shader_int16;
    public final boolean GL_AMD_gpu_shader_int64;
    public final boolean GL_AMD_interleaved_elements;
    public final boolean GL_AMD_occlusion_query_event;
    public final boolean GL_AMD_performance_monitor;
    public final boolean GL_AMD_pinned_memory;
    public final boolean GL_AMD_query_buffer_object;
    public final boolean GL_AMD_sample_positions;
    public final boolean GL_AMD_seamless_cubemap_per_texture;
    public final boolean GL_AMD_shader_atomic_counter_ops;
    public final boolean GL_AMD_shader_ballot;
    public final boolean GL_AMD_shader_explicit_vertex_parameter;
    public final boolean GL_AMD_shader_image_load_store_lod;
    public final boolean GL_AMD_shader_stencil_export;
    public final boolean GL_AMD_shader_trinary_minmax;
    public final boolean GL_AMD_sparse_texture;
    public final boolean GL_AMD_stencil_operation_extended;
    public final boolean GL_AMD_texture_gather_bias_lod;
    public final boolean GL_AMD_texture_texture4;
    public final boolean GL_AMD_transform_feedback3_lines_triangles;
    public final boolean GL_AMD_transform_feedback4;
    public final boolean GL_AMD_vertex_shader_layer;
    public final boolean GL_AMD_vertex_shader_tessellator;
    public final boolean GL_AMD_vertex_shader_viewport_index;
    public final boolean GL_ARB_arrays_of_arrays;
    public final boolean GL_ARB_base_instance;
    public final boolean GL_ARB_bindless_texture;
    public final boolean GL_ARB_blend_func_extended;
    public final boolean GL_ARB_buffer_storage;
    public final boolean GL_ARB_cl_event;
    public final boolean GL_ARB_clear_buffer_object;
    public final boolean GL_ARB_clear_texture;
    public final boolean GL_ARB_clip_control;
    public final boolean GL_ARB_color_buffer_float;
    public final boolean GL_ARB_compatibility;
    public final boolean GL_ARB_compressed_texture_pixel_storage;
    public final boolean GL_ARB_compute_shader;
    public final boolean GL_ARB_compute_variable_group_size;
    public final boolean GL_ARB_conditional_render_inverted;
    public final boolean GL_ARB_conservative_depth;
    public final boolean GL_ARB_copy_buffer;
    public final boolean GL_ARB_copy_image;
    public final boolean GL_ARB_cull_distance;
    public final boolean GL_ARB_debug_output;
    public final boolean GL_ARB_depth_buffer_float;
    public final boolean GL_ARB_depth_clamp;
    public final boolean GL_ARB_depth_texture;
    public final boolean GL_ARB_derivative_control;
    public final boolean GL_ARB_direct_state_access;
    public final boolean GL_ARB_draw_buffers;
    public final boolean GL_ARB_draw_buffers_blend;
    public final boolean GL_ARB_draw_elements_base_vertex;
    public final boolean GL_ARB_draw_indirect;
    public final boolean GL_ARB_draw_instanced;
    public final boolean GL_ARB_enhanced_layouts;
    public final boolean GL_ARB_ES2_compatibility;
    public final boolean GL_ARB_ES3_1_compatibility;
    public final boolean GL_ARB_ES3_2_compatibility;
    public final boolean GL_ARB_ES3_compatibility;
    public final boolean GL_ARB_explicit_attrib_location;
    public final boolean GL_ARB_explicit_uniform_location;
    public final boolean GL_ARB_fragment_coord_conventions;
    public final boolean GL_ARB_fragment_layer_viewport;
    public final boolean GL_ARB_fragment_program;
    public final boolean GL_ARB_fragment_program_shadow;
    public final boolean GL_ARB_fragment_shader;
    public final boolean GL_ARB_fragment_shader_interlock;
    public final boolean GL_ARB_framebuffer_no_attachments;
    public final boolean GL_ARB_framebuffer_object;
    public final boolean GL_ARB_framebuffer_sRGB;
    public final boolean GL_ARB_geometry_shader4;
    public final boolean GL_ARB_get_program_binary;
    public final boolean GL_ARB_get_texture_sub_image;
    public final boolean GL_ARB_gl_spirv;
    public final boolean GL_ARB_gpu_shader5;
    public final boolean GL_ARB_gpu_shader_fp64;
    public final boolean GL_ARB_gpu_shader_int64;
    public final boolean GL_ARB_half_float_pixel;
    public final boolean GL_ARB_half_float_vertex;
    public final boolean GL_ARB_imaging;
    public final boolean GL_ARB_indirect_parameters;
    public final boolean GL_ARB_instanced_arrays;
    public final boolean GL_ARB_internalformat_query;
    public final boolean GL_ARB_internalformat_query2;
    public final boolean GL_ARB_invalidate_subdata;
    public final boolean GL_ARB_map_buffer_alignment;
    public final boolean GL_ARB_map_buffer_range;
    public final boolean GL_ARB_matrix_palette;
    public final boolean GL_ARB_multi_bind;
    public final boolean GL_ARB_multi_draw_indirect;
    public final boolean GL_ARB_multisample;
    public final boolean GL_ARB_multitexture;
    public final boolean GL_ARB_occlusion_query;
    public final boolean GL_ARB_occlusion_query2;
    public final boolean GL_ARB_parallel_shader_compile;
    public final boolean GL_ARB_pipeline_statistics_query;
    public final boolean GL_ARB_pixel_buffer_object;
    public final boolean GL_ARB_point_parameters;
    public final boolean GL_ARB_point_sprite;
    public final boolean GL_ARB_polygon_offset_clamp;
    public final boolean GL_ARB_post_depth_coverage;
    public final boolean GL_ARB_program_interface_query;
    public final boolean GL_ARB_provoking_vertex;
    public final boolean GL_ARB_query_buffer_object;
    public final boolean GL_ARB_robust_buffer_access_behavior;
    public final boolean GL_ARB_robustness;
    public final boolean GL_ARB_robustness_application_isolation;
    public final boolean GL_ARB_robustness_share_group_isolation;
    public final boolean GL_ARB_sample_locations;
    public final boolean GL_ARB_sample_shading;
    public final boolean GL_ARB_sampler_objects;
    public final boolean GL_ARB_seamless_cube_map;
    public final boolean GL_ARB_seamless_cubemap_per_texture;
    public final boolean GL_ARB_separate_shader_objects;
    public final boolean GL_ARB_shader_atomic_counter_ops;
    public final boolean GL_ARB_shader_atomic_counters;
    public final boolean GL_ARB_shader_ballot;
    public final boolean GL_ARB_shader_bit_encoding;
    public final boolean GL_ARB_shader_clock;
    public final boolean GL_ARB_shader_draw_parameters;
    public final boolean GL_ARB_shader_group_vote;
    public final boolean GL_ARB_shader_image_load_store;
    public final boolean GL_ARB_shader_image_size;
    public final boolean GL_ARB_shader_objects;
    public final boolean GL_ARB_shader_precision;
    public final boolean GL_ARB_shader_stencil_export;
    public final boolean GL_ARB_shader_storage_buffer_object;
    public final boolean GL_ARB_shader_subroutine;
    public final boolean GL_ARB_shader_texture_image_samples;
    public final boolean GL_ARB_shader_texture_lod;
    public final boolean GL_ARB_shader_viewport_layer_array;
    public final boolean GL_ARB_shading_language_100;
    public final boolean GL_ARB_shading_language_420pack;
    public final boolean GL_ARB_shading_language_include;
    public final boolean GL_ARB_shading_language_packing;
    public final boolean GL_ARB_shadow;
    public final boolean GL_ARB_shadow_ambient;
    public final boolean GL_ARB_sparse_buffer;
    public final boolean GL_ARB_sparse_texture;
    public final boolean GL_ARB_sparse_texture2;
    public final boolean GL_ARB_sparse_texture_clamp;
    public final boolean GL_ARB_spirv_extensions;
    public final boolean GL_ARB_stencil_texturing;
    public final boolean GL_ARB_sync;
    public final boolean GL_ARB_tessellation_shader;
    public final boolean GL_ARB_texture_barrier;
    public final boolean GL_ARB_texture_border_clamp;
    public final boolean GL_ARB_texture_buffer_object;
    public final boolean GL_ARB_texture_buffer_object_rgb32;
    public final boolean GL_ARB_texture_buffer_range;
    public final boolean GL_ARB_texture_compression;
    public final boolean GL_ARB_texture_compression_bptc;
    public final boolean GL_ARB_texture_compression_rgtc;
    public final boolean GL_ARB_texture_cube_map;
    public final boolean GL_ARB_texture_cube_map_array;
    public final boolean GL_ARB_texture_env_add;
    public final boolean GL_ARB_texture_env_combine;
    public final boolean GL_ARB_texture_env_crossbar;
    public final boolean GL_ARB_texture_env_dot3;
    public final boolean GL_ARB_texture_filter_anisotropic;
    public final boolean GL_ARB_texture_filter_minmax;
    public final boolean GL_ARB_texture_float;
    public final boolean GL_ARB_texture_gather;
    public final boolean GL_ARB_texture_mirror_clamp_to_edge;
    public final boolean GL_ARB_texture_mirrored_repeat;
    public final boolean GL_ARB_texture_multisample;
    public final boolean GL_ARB_texture_non_power_of_two;
    public final boolean GL_ARB_texture_query_levels;
    public final boolean GL_ARB_texture_query_lod;
    public final boolean GL_ARB_texture_rectangle;
    public final boolean GL_ARB_texture_rg;
    public final boolean GL_ARB_texture_rgb10_a2ui;
    public final boolean GL_ARB_texture_stencil8;
    public final boolean GL_ARB_texture_storage;
    public final boolean GL_ARB_texture_storage_multisample;
    public final boolean GL_ARB_texture_swizzle;
    public final boolean GL_ARB_texture_view;
    public final boolean GL_ARB_timer_query;
    public final boolean GL_ARB_transform_feedback2;
    public final boolean GL_ARB_transform_feedback3;
    public final boolean GL_ARB_transform_feedback_instanced;
    public final boolean GL_ARB_transform_feedback_overflow_query;
    public final boolean GL_ARB_transpose_matrix;
    public final boolean GL_ARB_uniform_buffer_object;
    public final boolean GL_ARB_vertex_array_bgra;
    public final boolean GL_ARB_vertex_array_object;
    public final boolean GL_ARB_vertex_attrib_64bit;
    public final boolean GL_ARB_vertex_attrib_binding;
    public final boolean GL_ARB_vertex_blend;
    public final boolean GL_ARB_vertex_buffer_object;
    public final boolean GL_ARB_vertex_program;
    public final boolean GL_ARB_vertex_shader;
    public final boolean GL_ARB_vertex_type_10f_11f_11f_rev;
    public final boolean GL_ARB_vertex_type_2_10_10_10_rev;
    public final boolean GL_ARB_viewport_array;
    public final boolean GL_ARB_window_pos;
    public final boolean GL_ATI_meminfo;
    public final boolean GL_ATI_shader_texture_lod;
    public final boolean GL_ATI_texture_compression_3dc;
    public final boolean GL_EXT_422_pixels;
    public final boolean GL_EXT_abgr;
    public final boolean GL_EXT_bgra;
    public final boolean GL_EXT_bindable_uniform;
    public final boolean GL_EXT_blend_color;
    public final boolean GL_EXT_blend_equation_separate;
    public final boolean GL_EXT_blend_func_separate;
    public final boolean GL_EXT_blend_minmax;
    public final boolean GL_EXT_blend_subtract;
    public final boolean GL_EXT_clip_volume_hint;
    public final boolean GL_EXT_compiled_vertex_array;
    public final boolean GL_EXT_debug_label;
    public final boolean GL_EXT_debug_marker;
    public final boolean GL_EXT_depth_bounds_test;
    public final boolean GL_EXT_direct_state_access;
    public final boolean GL_EXT_draw_buffers2;
    public final boolean GL_EXT_draw_instanced;
    public final boolean GL_EXT_EGL_image_storage;
    public final boolean GL_EXT_EGL_sync;
    public final boolean GL_EXT_external_buffer;
    public final boolean GL_EXT_framebuffer_blit;
    public final boolean GL_EXT_framebuffer_multisample;
    public final boolean GL_EXT_framebuffer_multisample_blit_scaled;
    public final boolean GL_EXT_framebuffer_object;
    public final boolean GL_EXT_framebuffer_sRGB;
    public final boolean GL_EXT_geometry_shader4;
    public final boolean GL_EXT_gpu_program_parameters;
    public final boolean GL_EXT_gpu_shader4;
    public final boolean GL_EXT_memory_object;
    public final boolean GL_EXT_memory_object_fd;
    public final boolean GL_EXT_memory_object_win32;
    public final boolean GL_EXT_multiview_tessellation_geometry_shader;
    public final boolean GL_EXT_multiview_texture_multisample;
    public final boolean GL_EXT_multiview_timer_query;
    public final boolean GL_EXT_packed_depth_stencil;
    public final boolean GL_EXT_packed_float;
    public final boolean GL_EXT_pixel_buffer_object;
    public final boolean GL_EXT_point_parameters;
    public final boolean GL_EXT_polygon_offset_clamp;
    public final boolean GL_EXT_post_depth_coverage;
    public final boolean GL_EXT_provoking_vertex;
    public final boolean GL_EXT_raster_multisample;
    public final boolean GL_EXT_secondary_color;
    public final boolean GL_EXT_semaphore;
    public final boolean GL_EXT_semaphore_fd;
    public final boolean GL_EXT_semaphore_win32;
    public final boolean GL_EXT_separate_shader_objects;
    public final boolean GL_EXT_shader_framebuffer_fetch;
    public final boolean GL_EXT_shader_framebuffer_fetch_non_coherent;
    public final boolean GL_EXT_shader_image_load_formatted;
    public final boolean GL_EXT_shader_image_load_store;
    public final boolean GL_EXT_shader_integer_mix;
    public final boolean GL_EXT_shadow_funcs;
    public final boolean GL_EXT_shared_texture_palette;
    public final boolean GL_EXT_sparse_texture2;
    public final boolean GL_EXT_stencil_clear_tag;
    public final boolean GL_EXT_stencil_two_side;
    public final boolean GL_EXT_stencil_wrap;
    public final boolean GL_EXT_texture_array;
    public final boolean GL_EXT_texture_buffer_object;
    public final boolean GL_EXT_texture_compression_latc;
    public final boolean GL_EXT_texture_compression_rgtc;
    public final boolean GL_EXT_texture_compression_s3tc;
    public final boolean GL_EXT_texture_filter_anisotropic;
    public final boolean GL_EXT_texture_filter_minmax;
    public final boolean GL_EXT_texture_integer;
    public final boolean GL_EXT_texture_mirror_clamp;
    public final boolean GL_EXT_texture_shadow_lod;
    public final boolean GL_EXT_texture_shared_exponent;
    public final boolean GL_EXT_texture_snorm;
    public final boolean GL_EXT_texture_sRGB;
    public final boolean GL_EXT_texture_sRGB_decode;
    public final boolean GL_EXT_texture_sRGB_R8;
    public final boolean GL_EXT_texture_sRGB_RG8;
    public final boolean GL_EXT_texture_storage;
    public final boolean GL_EXT_texture_swizzle;
    public final boolean GL_EXT_timer_query;
    public final boolean GL_EXT_transform_feedback;
    public final boolean GL_EXT_vertex_array_bgra;
    public final boolean GL_EXT_vertex_attrib_64bit;
    public final boolean GL_EXT_win32_keyed_mutex;
    public final boolean GL_EXT_window_rectangles;
    public final boolean GL_EXT_x11_sync_object;
    public final boolean GL_GREMEDY_frame_terminator;
    public final boolean GL_GREMEDY_string_marker;
    public final boolean GL_INTEL_blackhole_render;
    public final boolean GL_INTEL_conservative_rasterization;
    public final boolean GL_INTEL_fragment_shader_ordering;
    public final boolean GL_INTEL_framebuffer_CMAA;
    public final boolean GL_INTEL_map_texture;
    public final boolean GL_INTEL_performance_query;
    public final boolean GL_INTEL_shader_integer_functions2;
    public final boolean GL_KHR_blend_equation_advanced;
    public final boolean GL_KHR_blend_equation_advanced_coherent;
    public final boolean GL_KHR_context_flush_control;
    public final boolean GL_KHR_debug;
    public final boolean GL_KHR_no_error;
    public final boolean GL_KHR_parallel_shader_compile;
    public final boolean GL_KHR_robust_buffer_access_behavior;
    public final boolean GL_KHR_robustness;
    public final boolean GL_KHR_shader_subgroup;
    public final boolean GL_KHR_texture_compression_astc_hdr;
    public final boolean GL_KHR_texture_compression_astc_ldr;
    public final boolean GL_KHR_texture_compression_astc_sliced_3d;
    public final boolean GL_MESA_framebuffer_flip_x;
    public final boolean GL_MESA_framebuffer_flip_y;
    public final boolean GL_MESA_framebuffer_swap_xy;
    public final boolean GL_MESA_tile_raster_order;
    public final boolean GL_NV_alpha_to_coverage_dither_control;
    public final boolean GL_NV_bindless_multi_draw_indirect;
    public final boolean GL_NV_bindless_multi_draw_indirect_count;
    public final boolean GL_NV_bindless_texture;
    public final boolean GL_NV_blend_equation_advanced;
    public final boolean GL_NV_blend_equation_advanced_coherent;
    public final boolean GL_NV_blend_minmax_factor;
    public final boolean GL_NV_blend_square;
    public final boolean GL_NV_clip_space_w_scaling;
    public final boolean GL_NV_command_list;
    public final boolean GL_NV_compute_shader_derivatives;
    public final boolean GL_NV_conditional_render;
    public final boolean GL_NV_conservative_raster;
    public final boolean GL_NV_conservative_raster_dilate;
    public final boolean GL_NV_conservative_raster_pre_snap;
    public final boolean GL_NV_conservative_raster_pre_snap_triangles;
    public final boolean GL_NV_conservative_raster_underestimation;
    public final boolean GL_NV_copy_depth_to_color;
    public final boolean GL_NV_copy_image;
    public final boolean GL_NV_deep_texture3D;
    public final boolean GL_NV_depth_buffer_float;
    public final boolean GL_NV_depth_clamp;
    public final boolean GL_NV_draw_texture;
    public final boolean GL_NV_draw_vulkan_image;
    public final boolean GL_NV_ES3_1_compatibility;
    public final boolean GL_NV_explicit_multisample;
    public final boolean GL_NV_fence;
    public final boolean GL_NV_fill_rectangle;
    public final boolean GL_NV_float_buffer;
    public final boolean GL_NV_fog_distance;
    public final boolean GL_NV_fragment_coverage_to_color;
    public final boolean GL_NV_fragment_program4;
    public final boolean GL_NV_fragment_program_option;
    public final boolean GL_NV_fragment_shader_barycentric;
    public final boolean GL_NV_fragment_shader_interlock;
    public final boolean GL_NV_framebuffer_mixed_samples;
    public final boolean GL_NV_framebuffer_multisample_coverage;
    public final boolean GL_NV_geometry_shader4;
    public final boolean GL_NV_geometry_shader_passthrough;
    public final boolean GL_NV_gpu_multicast;
    public final boolean GL_NV_gpu_shader5;
    public final boolean GL_NV_half_float;
    public final boolean GL_NV_internalformat_sample_query;
    public final boolean GL_NV_light_max_exponent;
    public final boolean GL_NV_memory_attachment;
    public final boolean GL_NV_memory_object_sparse;
    public final boolean GL_NV_mesh_shader;
    public final boolean GL_NV_multisample_coverage;
    public final boolean GL_NV_multisample_filter_hint;
    public final boolean GL_NV_packed_depth_stencil;
    public final boolean GL_NV_path_rendering;
    public final boolean GL_NV_path_rendering_shared_edge;
    public final boolean GL_NV_pixel_data_range;
    public final boolean GL_NV_point_sprite;
    public final boolean GL_NV_primitive_restart;
    public final boolean GL_NV_primitive_shading_rate;
    public final boolean GL_NV_query_resource;
    public final boolean GL_NV_query_resource_tag;
    public final boolean GL_NV_representative_fragment_test;
    public final boolean GL_NV_robustness_video_memory_purge;
    public final boolean GL_NV_sample_locations;
    public final boolean GL_NV_sample_mask_override_coverage;
    public final boolean GL_NV_scissor_exclusive;
    public final boolean GL_NV_shader_atomic_float;
    public final boolean GL_NV_shader_atomic_float64;
    public final boolean GL_NV_shader_atomic_fp16_vector;
    public final boolean GL_NV_shader_atomic_int64;
    public final boolean GL_NV_shader_buffer_load;
    public final boolean GL_NV_shader_buffer_store;
    public final boolean GL_NV_shader_subgroup_partitioned;
    public final boolean GL_NV_shader_texture_footprint;
    public final boolean GL_NV_shader_thread_group;
    public final boolean GL_NV_shader_thread_shuffle;
    public final boolean GL_NV_shading_rate_image;
    public final boolean GL_NV_stereo_view_rendering;
    public final boolean GL_NV_texgen_reflection;
    public final boolean GL_NV_texture_barrier;
    public final boolean GL_NV_texture_compression_vtc;
    public final boolean GL_NV_texture_multisample;
    public final boolean GL_NV_texture_rectangle_compressed;
    public final boolean GL_NV_texture_shader;
    public final boolean GL_NV_texture_shader2;
    public final boolean GL_NV_texture_shader3;
    public final boolean GL_NV_timeline_semaphore;
    public final boolean GL_NV_transform_feedback;
    public final boolean GL_NV_transform_feedback2;
    public final boolean GL_NV_uniform_buffer_unified_memory;
    public final boolean GL_NV_vertex_array_range;
    public final boolean GL_NV_vertex_array_range2;
    public final boolean GL_NV_vertex_attrib_integer_64bit;
    public final boolean GL_NV_vertex_buffer_unified_memory;
    public final boolean GL_NV_viewport_array2;
    public final boolean GL_NV_viewport_swizzle;
    public final boolean GL_NVX_blend_equation_advanced_multi_draw_buffers;
    public final boolean GL_NVX_conditional_render;
    public final boolean GL_NVX_gpu_memory_info;
    public final boolean GL_NVX_gpu_multicast2;
    public final boolean GL_NVX_progress_fence;
    public final boolean GL_OVR_multiview;
    public final boolean GL_OVR_multiview2;
    public final boolean GL_S3_s3tc;
    public final boolean forwardCompatible;
    final PointerBuffer addresses;

    /*
     * Opcode count of 13540 triggered aggressive code reduction.  Override with --aggressivesizethreshold.
     */
    GLCapabilities(FunctionProvider functionProvider, Set<String> set, boolean bl2, IntFunction<PointerBuffer> intFunction) {
        this.forwardCompatible = bl2;
        PointerBuffer pointerBuffer = intFunction.apply(2226);
        this.OpenGL11 = GLCapabilities.check_GL11(functionProvider, pointerBuffer, set, bl2);
        this.OpenGL12 = GLCapabilities.check_GL12(functionProvider, pointerBuffer, set);
        this.OpenGL13 = GLCapabilities.check_GL13(functionProvider, pointerBuffer, set, bl2);
        this.OpenGL14 = GLCapabilities.check_GL14(functionProvider, pointerBuffer, set, bl2);
        this.OpenGL15 = GLCapabilities.check_GL15(functionProvider, pointerBuffer, set);
        this.OpenGL20 = GLCapabilities.check_GL20(functionProvider, pointerBuffer, set);
        this.OpenGL21 = GLCapabilities.check_GL21(functionProvider, pointerBuffer, set);
        this.OpenGL30 = GLCapabilities.check_GL30(functionProvider, pointerBuffer, set);
        this.OpenGL31 = GLCapabilities.check_GL31(functionProvider, pointerBuffer, set);
        this.OpenGL32 = GLCapabilities.check_GL32(functionProvider, pointerBuffer, set);
        this.OpenGL33 = GLCapabilities.check_GL33(functionProvider, pointerBuffer, set, bl2);
        this.OpenGL40 = GLCapabilities.check_GL40(functionProvider, pointerBuffer, set);
        this.OpenGL41 = GLCapabilities.check_GL41(functionProvider, pointerBuffer, set);
        this.OpenGL42 = GLCapabilities.check_GL42(functionProvider, pointerBuffer, set);
        this.OpenGL43 = GLCapabilities.check_GL43(functionProvider, pointerBuffer, set);
        this.OpenGL44 = GLCapabilities.check_GL44(functionProvider, pointerBuffer, set);
        this.OpenGL45 = GLCapabilities.check_GL45(functionProvider, pointerBuffer, set);
        this.OpenGL46 = GLCapabilities.check_GL46(functionProvider, pointerBuffer, set);
        this.GL_3DFX_texture_compression_FXT1 = set.contains("GL_3DFX_texture_compression_FXT1");
        this.GL_AMD_blend_minmax_factor = set.contains("GL_AMD_blend_minmax_factor");
        this.GL_AMD_conservative_depth = set.contains("GL_AMD_conservative_depth");
        this.GL_AMD_debug_output = GLCapabilities.check_AMD_debug_output(functionProvider, pointerBuffer, set);
        this.GL_AMD_depth_clamp_separate = set.contains("GL_AMD_depth_clamp_separate");
        this.GL_AMD_draw_buffers_blend = GLCapabilities.check_AMD_draw_buffers_blend(functionProvider, pointerBuffer, set);
        this.GL_AMD_framebuffer_multisample_advanced = GLCapabilities.check_AMD_framebuffer_multisample_advanced(functionProvider, pointerBuffer, set);
        this.GL_AMD_gcn_shader = set.contains("GL_AMD_gcn_shader");
        this.GL_AMD_gpu_shader_half_float = set.contains("GL_AMD_gpu_shader_half_float");
        this.GL_AMD_gpu_shader_half_float_fetch = set.contains("GL_AMD_gpu_shader_half_float_fetch");
        this.GL_AMD_gpu_shader_int16 = set.contains("GL_AMD_gpu_shader_int16");
        this.GL_AMD_gpu_shader_int64 = GLCapabilities.check_AMD_gpu_shader_int64(functionProvider, pointerBuffer, set);
        this.GL_AMD_interleaved_elements = GLCapabilities.check_AMD_interleaved_elements(functionProvider, pointerBuffer, set);
        this.GL_AMD_occlusion_query_event = GLCapabilities.check_AMD_occlusion_query_event(functionProvider, pointerBuffer, set);
        this.GL_AMD_performance_monitor = GLCapabilities.check_AMD_performance_monitor(functionProvider, pointerBuffer, set);
        this.GL_AMD_pinned_memory = set.contains("GL_AMD_pinned_memory");
        this.GL_AMD_query_buffer_object = set.contains("GL_AMD_query_buffer_object");
        this.GL_AMD_sample_positions = GLCapabilities.check_AMD_sample_positions(functionProvider, pointerBuffer, set);
        this.GL_AMD_seamless_cubemap_per_texture = set.contains("GL_AMD_seamless_cubemap_per_texture");
        this.GL_AMD_shader_atomic_counter_ops = set.contains("GL_AMD_shader_atomic_counter_ops");
        this.GL_AMD_shader_ballot = set.contains("GL_AMD_shader_ballot");
        this.GL_AMD_shader_explicit_vertex_parameter = set.contains("GL_AMD_shader_explicit_vertex_parameter");
        this.GL_AMD_shader_image_load_store_lod = set.contains("GL_AMD_shader_image_load_store_lod");
        this.GL_AMD_shader_stencil_export = set.contains("GL_AMD_shader_stencil_export");
        this.GL_AMD_shader_trinary_minmax = set.contains("GL_AMD_shader_trinary_minmax");
        this.GL_AMD_sparse_texture = GLCapabilities.check_AMD_sparse_texture(functionProvider, pointerBuffer, set);
        this.GL_AMD_stencil_operation_extended = GLCapabilities.check_AMD_stencil_operation_extended(functionProvider, pointerBuffer, set);
        this.GL_AMD_texture_gather_bias_lod = set.contains("GL_AMD_texture_gather_bias_lod");
        this.GL_AMD_texture_texture4 = set.contains("GL_AMD_texture_texture4");
        this.GL_AMD_transform_feedback3_lines_triangles = set.contains("GL_AMD_transform_feedback3_lines_triangles");
        this.GL_AMD_transform_feedback4 = set.contains("GL_AMD_transform_feedback4");
        this.GL_AMD_vertex_shader_layer = set.contains("GL_AMD_vertex_shader_layer");
        this.GL_AMD_vertex_shader_tessellator = GLCapabilities.check_AMD_vertex_shader_tessellator(functionProvider, pointerBuffer, set);
        this.GL_AMD_vertex_shader_viewport_index = set.contains("GL_AMD_vertex_shader_viewport_index");
        this.GL_ARB_arrays_of_arrays = set.contains("GL_ARB_arrays_of_arrays");
        this.GL_ARB_base_instance = GLCapabilities.check_ARB_base_instance(functionProvider, pointerBuffer, set);
        this.GL_ARB_bindless_texture = GLCapabilities.check_ARB_bindless_texture(functionProvider, pointerBuffer, set);
        this.GL_ARB_blend_func_extended = GLCapabilities.check_ARB_blend_func_extended(functionProvider, pointerBuffer, set);
        this.GL_ARB_buffer_storage = GLCapabilities.check_ARB_buffer_storage(functionProvider, pointerBuffer, set);
        this.GL_ARB_cl_event = GLCapabilities.check_ARB_cl_event(functionProvider, pointerBuffer, set);
        this.GL_ARB_clear_buffer_object = GLCapabilities.check_ARB_clear_buffer_object(functionProvider, pointerBuffer, set);
        this.GL_ARB_clear_texture = GLCapabilities.check_ARB_clear_texture(functionProvider, pointerBuffer, set);
        this.GL_ARB_clip_control = GLCapabilities.check_ARB_clip_control(functionProvider, pointerBuffer, set);
        this.GL_ARB_color_buffer_float = GLCapabilities.check_ARB_color_buffer_float(functionProvider, pointerBuffer, set);
        this.GL_ARB_compatibility = set.contains("GL_ARB_compatibility");
        this.GL_ARB_compressed_texture_pixel_storage = set.contains("GL_ARB_compressed_texture_pixel_storage");
        this.GL_ARB_compute_shader = GLCapabilities.check_ARB_compute_shader(functionProvider, pointerBuffer, set);
        this.GL_ARB_compute_variable_group_size = GLCapabilities.check_ARB_compute_variable_group_size(functionProvider, pointerBuffer, set);
        this.GL_ARB_conditional_render_inverted = set.contains("GL_ARB_conditional_render_inverted");
        this.GL_ARB_conservative_depth = set.contains("GL_ARB_conservative_depth");
        this.GL_ARB_copy_buffer = GLCapabilities.check_ARB_copy_buffer(functionProvider, pointerBuffer, set);
        this.GL_ARB_copy_image = GLCapabilities.check_ARB_copy_image(functionProvider, pointerBuffer, set);
        this.GL_ARB_cull_distance = set.contains("GL_ARB_cull_distance");
        this.GL_ARB_debug_output = GLCapabilities.check_ARB_debug_output(functionProvider, pointerBuffer, set);
        this.GL_ARB_depth_buffer_float = set.contains("GL_ARB_depth_buffer_float");
        this.GL_ARB_depth_clamp = set.contains("GL_ARB_depth_clamp");
        this.GL_ARB_depth_texture = set.contains("GL_ARB_depth_texture");
        this.GL_ARB_derivative_control = set.contains("GL_ARB_derivative_control");
        this.GL_ARB_direct_state_access = GLCapabilities.check_ARB_direct_state_access(functionProvider, pointerBuffer, set);
        this.GL_ARB_draw_buffers = GLCapabilities.check_ARB_draw_buffers(functionProvider, pointerBuffer, set);
        this.GL_ARB_draw_buffers_blend = GLCapabilities.check_ARB_draw_buffers_blend(functionProvider, pointerBuffer, set);
        this.GL_ARB_draw_elements_base_vertex = GLCapabilities.check_ARB_draw_elements_base_vertex(functionProvider, pointerBuffer, set);
        this.GL_ARB_draw_indirect = GLCapabilities.check_ARB_draw_indirect(functionProvider, pointerBuffer, set);
        this.GL_ARB_draw_instanced = GLCapabilities.check_ARB_draw_instanced(functionProvider, pointerBuffer, set);
        this.GL_ARB_enhanced_layouts = set.contains("GL_ARB_enhanced_layouts");
        this.GL_ARB_ES2_compatibility = GLCapabilities.check_ARB_ES2_compatibility(functionProvider, pointerBuffer, set);
        this.GL_ARB_ES3_1_compatibility = GLCapabilities.check_ARB_ES3_1_compatibility(functionProvider, pointerBuffer, set);
        this.GL_ARB_ES3_2_compatibility = GLCapabilities.check_ARB_ES3_2_compatibility(functionProvider, pointerBuffer, set);
        this.GL_ARB_ES3_compatibility = set.contains("GL_ARB_ES3_compatibility");
        this.GL_ARB_explicit_attrib_location = set.contains("GL_ARB_explicit_attrib_location");
        this.GL_ARB_explicit_uniform_location = set.contains("GL_ARB_explicit_uniform_location");
        this.GL_ARB_fragment_coord_conventions = set.contains("GL_ARB_fragment_coord_conventions");
        this.GL_ARB_fragment_layer_viewport = set.contains("GL_ARB_fragment_layer_viewport");
        this.GL_ARB_fragment_program = set.contains("GL_ARB_fragment_program");
        this.GL_ARB_fragment_program_shadow = set.contains("GL_ARB_fragment_program_shadow");
        this.GL_ARB_fragment_shader = set.contains("GL_ARB_fragment_shader");
        this.GL_ARB_fragment_shader_interlock = set.contains("GL_ARB_fragment_shader_interlock");
        this.GL_ARB_framebuffer_no_attachments = GLCapabilities.check_ARB_framebuffer_no_attachments(functionProvider, pointerBuffer, set);
        this.GL_ARB_framebuffer_object = GLCapabilities.check_ARB_framebuffer_object(functionProvider, pointerBuffer, set);
        this.GL_ARB_framebuffer_sRGB = set.contains("GL_ARB_framebuffer_sRGB");
        this.GL_ARB_geometry_shader4 = GLCapabilities.check_ARB_geometry_shader4(functionProvider, pointerBuffer, set);
        this.GL_ARB_get_program_binary = GLCapabilities.check_ARB_get_program_binary(functionProvider, pointerBuffer, set);
        this.GL_ARB_get_texture_sub_image = GLCapabilities.check_ARB_get_texture_sub_image(functionProvider, pointerBuffer, set);
        this.GL_ARB_gl_spirv = GLCapabilities.check_ARB_gl_spirv(functionProvider, pointerBuffer, set);
        this.GL_ARB_gpu_shader5 = set.contains("GL_ARB_gpu_shader5");
        this.GL_ARB_gpu_shader_fp64 = GLCapabilities.check_ARB_gpu_shader_fp64(functionProvider, pointerBuffer, set);
        this.GL_ARB_gpu_shader_int64 = GLCapabilities.check_ARB_gpu_shader_int64(functionProvider, pointerBuffer, set);
        this.GL_ARB_half_float_pixel = set.contains("GL_ARB_half_float_pixel");
        this.GL_ARB_half_float_vertex = set.contains("GL_ARB_half_float_vertex");
        this.GL_ARB_imaging = GLCapabilities.check_ARB_imaging(functionProvider, pointerBuffer, set, bl2);
        this.GL_ARB_indirect_parameters = GLCapabilities.check_ARB_indirect_parameters(functionProvider, pointerBuffer, set);
        this.GL_ARB_instanced_arrays = GLCapabilities.check_ARB_instanced_arrays(functionProvider, pointerBuffer, set);
        this.GL_ARB_internalformat_query = GLCapabilities.check_ARB_internalformat_query(functionProvider, pointerBuffer, set);
        this.GL_ARB_internalformat_query2 = GLCapabilities.check_ARB_internalformat_query2(functionProvider, pointerBuffer, set);
        this.GL_ARB_invalidate_subdata = GLCapabilities.check_ARB_invalidate_subdata(functionProvider, pointerBuffer, set);
        this.GL_ARB_map_buffer_alignment = set.contains("GL_ARB_map_buffer_alignment");
        this.GL_ARB_map_buffer_range = GLCapabilities.check_ARB_map_buffer_range(functionProvider, pointerBuffer, set);
        this.GL_ARB_matrix_palette = GLCapabilities.check_ARB_matrix_palette(functionProvider, pointerBuffer, set);
        this.GL_ARB_multi_bind = GLCapabilities.check_ARB_multi_bind(functionProvider, pointerBuffer, set);
        this.GL_ARB_multi_draw_indirect = GLCapabilities.check_ARB_multi_draw_indirect(functionProvider, pointerBuffer, set);
        this.GL_ARB_multisample = GLCapabilities.check_ARB_multisample(functionProvider, pointerBuffer, set);
        this.GL_ARB_multitexture = GLCapabilities.check_ARB_multitexture(functionProvider, pointerBuffer, set);
        this.GL_ARB_occlusion_query = GLCapabilities.check_ARB_occlusion_query(functionProvider, pointerBuffer, set);
        this.GL_ARB_occlusion_query2 = set.contains("GL_ARB_occlusion_query2");
        this.GL_ARB_parallel_shader_compile = GLCapabilities.check_ARB_parallel_shader_compile(functionProvider, pointerBuffer, set);
        this.GL_ARB_pipeline_statistics_query = set.contains("GL_ARB_pipeline_statistics_query");
        this.GL_ARB_pixel_buffer_object = set.contains("GL_ARB_pixel_buffer_object");
        this.GL_ARB_point_parameters = GLCapabilities.check_ARB_point_parameters(functionProvider, pointerBuffer, set);
        this.GL_ARB_point_sprite = set.contains("GL_ARB_point_sprite");
        this.GL_ARB_polygon_offset_clamp = GLCapabilities.check_ARB_polygon_offset_clamp(functionProvider, pointerBuffer, set);
        this.GL_ARB_post_depth_coverage = set.contains("GL_ARB_post_depth_coverage");
        this.GL_ARB_program_interface_query = GLCapabilities.check_ARB_program_interface_query(functionProvider, pointerBuffer, set);
        this.GL_ARB_provoking_vertex = GLCapabilities.check_ARB_provoking_vertex(functionProvider, pointerBuffer, set);
        this.GL_ARB_query_buffer_object = set.contains("GL_ARB_query_buffer_object");
        this.GL_ARB_robust_buffer_access_behavior = set.contains("GL_ARB_robust_buffer_access_behavior");
        this.GL_ARB_robustness = GLCapabilities.check_ARB_robustness(functionProvider, pointerBuffer, set);
        this.GL_ARB_robustness_application_isolation = set.contains("GL_ARB_robustness_application_isolation");
        this.GL_ARB_robustness_share_group_isolation = set.contains("GL_ARB_robustness_share_group_isolation");
        this.GL_ARB_sample_locations = GLCapabilities.check_ARB_sample_locations(functionProvider, pointerBuffer, set);
        this.GL_ARB_sample_shading = GLCapabilities.check_ARB_sample_shading(functionProvider, pointerBuffer, set);
        this.GL_ARB_sampler_objects = GLCapabilities.check_ARB_sampler_objects(functionProvider, pointerBuffer, set);
        this.GL_ARB_seamless_cube_map = set.contains("GL_ARB_seamless_cube_map");
        this.GL_ARB_seamless_cubemap_per_texture = set.contains("GL_ARB_seamless_cubemap_per_texture");
        this.GL_ARB_separate_shader_objects = GLCapabilities.check_ARB_separate_shader_objects(functionProvider, pointerBuffer, set);
        this.GL_ARB_shader_atomic_counter_ops = set.contains("GL_ARB_shader_atomic_counter_ops");
        this.GL_ARB_shader_atomic_counters = GLCapabilities.check_ARB_shader_atomic_counters(functionProvider, pointerBuffer, set);
        this.GL_ARB_shader_ballot = set.contains("GL_ARB_shader_ballot");
        this.GL_ARB_shader_bit_encoding = set.contains("GL_ARB_shader_bit_encoding");
        this.GL_ARB_shader_clock = set.contains("GL_ARB_shader_clock");
        this.GL_ARB_shader_draw_parameters = set.contains("GL_ARB_shader_draw_parameters");
        this.GL_ARB_shader_group_vote = set.contains("GL_ARB_shader_group_vote");
        this.GL_ARB_shader_image_load_store = GLCapabilities.check_ARB_shader_image_load_store(functionProvider, pointerBuffer, set);
        this.GL_ARB_shader_image_size = set.contains("GL_ARB_shader_image_size");
        this.GL_ARB_shader_objects = GLCapabilities.check_ARB_shader_objects(functionProvider, pointerBuffer, set);
        this.GL_ARB_shader_precision = set.contains("GL_ARB_shader_precision");
        this.GL_ARB_shader_stencil_export = set.contains("GL_ARB_shader_stencil_export");
        this.GL_ARB_shader_storage_buffer_object = GLCapabilities.check_ARB_shader_storage_buffer_object(functionProvider, pointerBuffer, set);
        this.GL_ARB_shader_subroutine = GLCapabilities.check_ARB_shader_subroutine(functionProvider, pointerBuffer, set);
        this.GL_ARB_shader_texture_image_samples = set.contains("GL_ARB_shader_texture_image_samples");
        this.GL_ARB_shader_texture_lod = set.contains("GL_ARB_shader_texture_lod");
        this.GL_ARB_shader_viewport_layer_array = set.contains("GL_ARB_shader_viewport_layer_array");
        this.GL_ARB_shading_language_100 = set.contains("GL_ARB_shading_language_100");
        this.GL_ARB_shading_language_420pack = set.contains("GL_ARB_shading_language_420pack");
        this.GL_ARB_shading_language_include = GLCapabilities.check_ARB_shading_language_include(functionProvider, pointerBuffer, set);
        this.GL_ARB_shading_language_packing = set.contains("GL_ARB_shading_language_packing");
        this.GL_ARB_shadow = set.contains("GL_ARB_shadow");
        this.GL_ARB_shadow_ambient = set.contains("GL_ARB_shadow_ambient");
        this.GL_ARB_sparse_buffer = GLCapabilities.check_ARB_sparse_buffer(functionProvider, pointerBuffer, set);
        this.GL_ARB_sparse_texture = GLCapabilities.check_ARB_sparse_texture(functionProvider, pointerBuffer, set);
        this.GL_ARB_sparse_texture2 = set.contains("GL_ARB_sparse_texture2");
        this.GL_ARB_sparse_texture_clamp = set.contains("GL_ARB_sparse_texture_clamp");
        this.GL_ARB_spirv_extensions = set.contains("GL_ARB_spirv_extensions");
        this.GL_ARB_stencil_texturing = set.contains("GL_ARB_stencil_texturing");
        this.GL_ARB_sync = GLCapabilities.check_ARB_sync(functionProvider, pointerBuffer, set);
        this.GL_ARB_tessellation_shader = GLCapabilities.check_ARB_tessellation_shader(functionProvider, pointerBuffer, set);
        this.GL_ARB_texture_barrier = GLCapabilities.check_ARB_texture_barrier(functionProvider, pointerBuffer, set);
        this.GL_ARB_texture_border_clamp = set.contains("GL_ARB_texture_border_clamp");
        this.GL_ARB_texture_buffer_object = GLCapabilities.check_ARB_texture_buffer_object(functionProvider, pointerBuffer, set);
        this.GL_ARB_texture_buffer_object_rgb32 = set.contains("GL_ARB_texture_buffer_object_rgb32");
        this.GL_ARB_texture_buffer_range = GLCapabilities.check_ARB_texture_buffer_range(functionProvider, pointerBuffer, set);
        this.GL_ARB_texture_compression = GLCapabilities.check_ARB_texture_compression(functionProvider, pointerBuffer, set);
        this.GL_ARB_texture_compression_bptc = set.contains("GL_ARB_texture_compression_bptc");
        this.GL_ARB_texture_compression_rgtc = set.contains("GL_ARB_texture_compression_rgtc");
        this.GL_ARB_texture_cube_map = set.contains("GL_ARB_texture_cube_map");
        this.GL_ARB_texture_cube_map_array = set.contains("GL_ARB_texture_cube_map_array");
        this.GL_ARB_texture_env_add = set.contains("GL_ARB_texture_env_add");
        this.GL_ARB_texture_env_combine = set.contains("GL_ARB_texture_env_combine");
        this.GL_ARB_texture_env_crossbar = set.contains("GL_ARB_texture_env_crossbar");
        this.GL_ARB_texture_env_dot3 = set.contains("GL_ARB_texture_env_dot3");
        this.GL_ARB_texture_filter_anisotropic = set.contains("GL_ARB_texture_filter_anisotropic");
        this.GL_ARB_texture_filter_minmax = set.contains("GL_ARB_texture_filter_minmax");
        this.GL_ARB_texture_float = set.contains("GL_ARB_texture_float");
        this.GL_ARB_texture_gather = set.contains("GL_ARB_texture_gather");
        this.GL_ARB_texture_mirror_clamp_to_edge = set.contains("GL_ARB_texture_mirror_clamp_to_edge");
        this.GL_ARB_texture_mirrored_repeat = set.contains("GL_ARB_texture_mirrored_repeat");
        this.GL_ARB_texture_multisample = GLCapabilities.check_ARB_texture_multisample(functionProvider, pointerBuffer, set);
        this.GL_ARB_texture_non_power_of_two = set.contains("GL_ARB_texture_non_power_of_two");
        this.GL_ARB_texture_query_levels = set.contains("GL_ARB_texture_query_levels");
        this.GL_ARB_texture_query_lod = set.contains("GL_ARB_texture_query_lod");
        this.GL_ARB_texture_rectangle = set.contains("GL_ARB_texture_rectangle");
        this.GL_ARB_texture_rg = set.contains("GL_ARB_texture_rg");
        this.GL_ARB_texture_rgb10_a2ui = set.contains("GL_ARB_texture_rgb10_a2ui");
        this.GL_ARB_texture_stencil8 = set.contains("GL_ARB_texture_stencil8");
        this.GL_ARB_texture_storage = GLCapabilities.check_ARB_texture_storage(functionProvider, pointerBuffer, set);
        this.GL_ARB_texture_storage_multisample = GLCapabilities.check_ARB_texture_storage_multisample(functionProvider, pointerBuffer, set);
        this.GL_ARB_texture_swizzle = set.contains("GL_ARB_texture_swizzle");
        this.GL_ARB_texture_view = GLCapabilities.check_ARB_texture_view(functionProvider, pointerBuffer, set);
        this.GL_ARB_timer_query = GLCapabilities.check_ARB_timer_query(functionProvider, pointerBuffer, set);
        this.GL_ARB_transform_feedback2 = GLCapabilities.check_ARB_transform_feedback2(functionProvider, pointerBuffer, set);
        this.GL_ARB_transform_feedback3 = GLCapabilities.check_ARB_transform_feedback3(functionProvider, pointerBuffer, set);
        this.GL_ARB_transform_feedback_instanced = GLCapabilities.check_ARB_transform_feedback_instanced(functionProvider, pointerBuffer, set);
        this.GL_ARB_transform_feedback_overflow_query = set.contains("GL_ARB_transform_feedback_overflow_query");
        this.GL_ARB_transpose_matrix = GLCapabilities.check_ARB_transpose_matrix(functionProvider, pointerBuffer, set);
        this.GL_ARB_uniform_buffer_object = GLCapabilities.check_ARB_uniform_buffer_object(functionProvider, pointerBuffer, set);
        this.GL_ARB_vertex_array_bgra = set.contains("GL_ARB_vertex_array_bgra");
        this.GL_ARB_vertex_array_object = GLCapabilities.check_ARB_vertex_array_object(functionProvider, pointerBuffer, set);
        this.GL_ARB_vertex_attrib_64bit = GLCapabilities.check_ARB_vertex_attrib_64bit(functionProvider, pointerBuffer, set);
        this.GL_ARB_vertex_attrib_binding = GLCapabilities.check_ARB_vertex_attrib_binding(functionProvider, pointerBuffer, set);
        this.GL_ARB_vertex_blend = GLCapabilities.check_ARB_vertex_blend(functionProvider, pointerBuffer, set);
        this.GL_ARB_vertex_buffer_object = GLCapabilities.check_ARB_vertex_buffer_object(functionProvider, pointerBuffer, set);
        this.GL_ARB_vertex_program = GLCapabilities.check_ARB_vertex_program(functionProvider, pointerBuffer, set);
        this.GL_ARB_vertex_shader = GLCapabilities.check_ARB_vertex_shader(functionProvider, pointerBuffer, set);
        this.GL_ARB_vertex_type_10f_11f_11f_rev = set.contains("GL_ARB_vertex_type_10f_11f_11f_rev");
        this.GL_ARB_vertex_type_2_10_10_10_rev = GLCapabilities.check_ARB_vertex_type_2_10_10_10_rev(functionProvider, pointerBuffer, set, bl2);
        this.GL_ARB_viewport_array = GLCapabilities.check_ARB_viewport_array(functionProvider, pointerBuffer, set);
        this.GL_ARB_window_pos = GLCapabilities.check_ARB_window_pos(functionProvider, pointerBuffer, set);
        this.GL_ATI_meminfo = set.contains("GL_ATI_meminfo");
        this.GL_ATI_shader_texture_lod = set.contains("GL_ATI_shader_texture_lod");
        this.GL_ATI_texture_compression_3dc = set.contains("GL_ATI_texture_compression_3dc");
        this.GL_EXT_422_pixels = set.contains("GL_EXT_422_pixels");
        this.GL_EXT_abgr = set.contains("GL_EXT_abgr");
        this.GL_EXT_bgra = set.contains("GL_EXT_bgra");
        this.GL_EXT_bindable_uniform = GLCapabilities.check_EXT_bindable_uniform(functionProvider, pointerBuffer, set);
        this.GL_EXT_blend_color = GLCapabilities.check_EXT_blend_color(functionProvider, pointerBuffer, set);
        this.GL_EXT_blend_equation_separate = GLCapabilities.check_EXT_blend_equation_separate(functionProvider, pointerBuffer, set);
        this.GL_EXT_blend_func_separate = GLCapabilities.check_EXT_blend_func_separate(functionProvider, pointerBuffer, set);
        this.GL_EXT_blend_minmax = GLCapabilities.check_EXT_blend_minmax(functionProvider, pointerBuffer, set);
        this.GL_EXT_blend_subtract = set.contains("GL_EXT_blend_subtract");
        this.GL_EXT_clip_volume_hint = set.contains("GL_EXT_clip_volume_hint");
        this.GL_EXT_compiled_vertex_array = GLCapabilities.check_EXT_compiled_vertex_array(functionProvider, pointerBuffer, set);
        this.GL_EXT_debug_label = GLCapabilities.check_EXT_debug_label(functionProvider, pointerBuffer, set);
        this.GL_EXT_debug_marker = GLCapabilities.check_EXT_debug_marker(functionProvider, pointerBuffer, set);
        this.GL_EXT_depth_bounds_test = GLCapabilities.check_EXT_depth_bounds_test(functionProvider, pointerBuffer, set);
        this.GL_EXT_direct_state_access = GLCapabilities.check_EXT_direct_state_access(functionProvider, pointerBuffer, set);
        this.GL_EXT_draw_buffers2 = GLCapabilities.check_EXT_draw_buffers2(functionProvider, pointerBuffer, set);
        this.GL_EXT_draw_instanced = GLCapabilities.check_EXT_draw_instanced(functionProvider, pointerBuffer, set);
        this.GL_EXT_EGL_image_storage = GLCapabilities.check_EXT_EGL_image_storage(functionProvider, pointerBuffer, set);
        this.GL_EXT_EGL_sync = set.contains("GL_EXT_EGL_sync");
        this.GL_EXT_external_buffer = GLCapabilities.check_EXT_external_buffer(functionProvider, pointerBuffer, set);
        this.GL_EXT_framebuffer_blit = GLCapabilities.check_EXT_framebuffer_blit(functionProvider, pointerBuffer, set);
        this.GL_EXT_framebuffer_multisample = GLCapabilities.check_EXT_framebuffer_multisample(functionProvider, pointerBuffer, set);
        this.GL_EXT_framebuffer_multisample_blit_scaled = set.contains("GL_EXT_framebuffer_multisample_blit_scaled");
        this.GL_EXT_framebuffer_object = GLCapabilities.check_EXT_framebuffer_object(functionProvider, pointerBuffer, set);
        this.GL_EXT_framebuffer_sRGB = set.contains("GL_EXT_framebuffer_sRGB");
        this.GL_EXT_geometry_shader4 = GLCapabilities.check_EXT_geometry_shader4(functionProvider, pointerBuffer, set);
        this.GL_EXT_gpu_program_parameters = GLCapabilities.check_EXT_gpu_program_parameters(functionProvider, pointerBuffer, set);
        this.GL_EXT_gpu_shader4 = GLCapabilities.check_EXT_gpu_shader4(functionProvider, pointerBuffer, set);
        this.GL_EXT_memory_object = GLCapabilities.check_EXT_memory_object(functionProvider, pointerBuffer, set);
        this.GL_EXT_memory_object_fd = GLCapabilities.check_EXT_memory_object_fd(functionProvider, pointerBuffer, set);
        this.GL_EXT_memory_object_win32 = GLCapabilities.check_EXT_memory_object_win32(functionProvider, pointerBuffer, set);
        this.GL_EXT_multiview_tessellation_geometry_shader = set.contains("GL_EXT_multiview_tessellation_geometry_shader");
        this.GL_EXT_multiview_texture_multisample = set.contains("GL_EXT_multiview_texture_multisample");
        this.GL_EXT_multiview_timer_query = set.contains("GL_EXT_multiview_timer_query");
        this.GL_EXT_packed_depth_stencil = set.contains("GL_EXT_packed_depth_stencil");
        this.GL_EXT_packed_float = set.contains("GL_EXT_packed_float");
        this.GL_EXT_pixel_buffer_object = set.contains("GL_EXT_pixel_buffer_object");
        this.GL_EXT_point_parameters = GLCapabilities.check_EXT_point_parameters(functionProvider, pointerBuffer, set);
        this.GL_EXT_polygon_offset_clamp = GLCapabilities.check_EXT_polygon_offset_clamp(functionProvider, pointerBuffer, set);
        this.GL_EXT_post_depth_coverage = set.contains("GL_EXT_post_depth_coverage");
        this.GL_EXT_provoking_vertex = GLCapabilities.check_EXT_provoking_vertex(functionProvider, pointerBuffer, set);
        this.GL_EXT_raster_multisample = GLCapabilities.check_EXT_raster_multisample(functionProvider, pointerBuffer, set);
        this.GL_EXT_secondary_color = GLCapabilities.check_EXT_secondary_color(functionProvider, pointerBuffer, set);
        this.GL_EXT_semaphore = GLCapabilities.check_EXT_semaphore(functionProvider, pointerBuffer, set);
        this.GL_EXT_semaphore_fd = GLCapabilities.check_EXT_semaphore_fd(functionProvider, pointerBuffer, set);
        this.GL_EXT_semaphore_win32 = GLCapabilities.check_EXT_semaphore_win32(functionProvider, pointerBuffer, set);
        this.GL_EXT_separate_shader_objects = GLCapabilities.check_EXT_separate_shader_objects(functionProvider, pointerBuffer, set);
        this.GL_EXT_shader_framebuffer_fetch = set.contains("GL_EXT_shader_framebuffer_fetch");
        this.GL_EXT_shader_framebuffer_fetch_non_coherent = GLCapabilities.check_EXT_shader_framebuffer_fetch_non_coherent(functionProvider, pointerBuffer, set);
        this.GL_EXT_shader_image_load_formatted = set.contains("GL_EXT_shader_image_load_formatted");
        this.GL_EXT_shader_image_load_store = GLCapabilities.check_EXT_shader_image_load_store(functionProvider, pointerBuffer, set);
        this.GL_EXT_shader_integer_mix = set.contains("GL_EXT_shader_integer_mix");
        this.GL_EXT_shadow_funcs = set.contains("GL_EXT_shadow_funcs");
        this.GL_EXT_shared_texture_palette = set.contains("GL_EXT_shared_texture_palette");
        this.GL_EXT_sparse_texture2 = set.contains("GL_EXT_sparse_texture2");
        this.GL_EXT_stencil_clear_tag = GLCapabilities.check_EXT_stencil_clear_tag(functionProvider, pointerBuffer, set);
        this.GL_EXT_stencil_two_side = GLCapabilities.check_EXT_stencil_two_side(functionProvider, pointerBuffer, set);
        this.GL_EXT_stencil_wrap = set.contains("GL_EXT_stencil_wrap");
        this.GL_EXT_texture_array = GLCapabilities.check_EXT_texture_array(functionProvider, pointerBuffer, set);
        this.GL_EXT_texture_buffer_object = GLCapabilities.check_EXT_texture_buffer_object(functionProvider, pointerBuffer, set);
        this.GL_EXT_texture_compression_latc = set.contains("GL_EXT_texture_compression_latc");
        this.GL_EXT_texture_compression_rgtc = set.contains("GL_EXT_texture_compression_rgtc");
        this.GL_EXT_texture_compression_s3tc = set.contains("GL_EXT_texture_compression_s3tc");
        this.GL_EXT_texture_filter_anisotropic = set.contains("GL_EXT_texture_filter_anisotropic");
        this.GL_EXT_texture_filter_minmax = set.contains("GL_EXT_texture_filter_minmax");
        this.GL_EXT_texture_integer = GLCapabilities.check_EXT_texture_integer(functionProvider, pointerBuffer, set);
        this.GL_EXT_texture_mirror_clamp = set.contains("GL_EXT_texture_mirror_clamp");
        this.GL_EXT_texture_shadow_lod = set.contains("GL_EXT_texture_shadow_lod");
        this.GL_EXT_texture_shared_exponent = set.contains("GL_EXT_texture_shared_exponent");
        this.GL_EXT_texture_snorm = set.contains("GL_EXT_texture_snorm");
        this.GL_EXT_texture_sRGB = set.contains("GL_EXT_texture_sRGB");
        this.GL_EXT_texture_sRGB_decode = set.contains("GL_EXT_texture_sRGB_decode");
        this.GL_EXT_texture_sRGB_R8 = set.contains("GL_EXT_texture_sRGB_R8");
        this.GL_EXT_texture_sRGB_RG8 = set.contains("GL_EXT_texture_sRGB_RG8");
        this.GL_EXT_texture_storage = GLCapabilities.check_EXT_texture_storage(functionProvider, pointerBuffer, set);
        this.GL_EXT_texture_swizzle = set.contains("GL_EXT_texture_swizzle");
        this.GL_EXT_timer_query = GLCapabilities.check_EXT_timer_query(functionProvider, pointerBuffer, set);
        this.GL_EXT_transform_feedback = GLCapabilities.check_EXT_transform_feedback(functionProvider, pointerBuffer, set);
        this.GL_EXT_vertex_array_bgra = set.contains("GL_EXT_vertex_array_bgra");
        this.GL_EXT_vertex_attrib_64bit = GLCapabilities.check_EXT_vertex_attrib_64bit(functionProvider, pointerBuffer, set);
        this.GL_EXT_win32_keyed_mutex = GLCapabilities.check_EXT_win32_keyed_mutex(functionProvider, pointerBuffer, set);
        this.GL_EXT_window_rectangles = GLCapabilities.check_EXT_window_rectangles(functionProvider, pointerBuffer, set);
        this.GL_EXT_x11_sync_object = GLCapabilities.check_EXT_x11_sync_object(functionProvider, pointerBuffer, set);
        this.GL_GREMEDY_frame_terminator = GLCapabilities.check_GREMEDY_frame_terminator(functionProvider, pointerBuffer, set);
        this.GL_GREMEDY_string_marker = GLCapabilities.check_GREMEDY_string_marker(functionProvider, pointerBuffer, set);
        this.GL_INTEL_blackhole_render = set.contains("GL_INTEL_blackhole_render");
        this.GL_INTEL_conservative_rasterization = set.contains("GL_INTEL_conservative_rasterization");
        this.GL_INTEL_fragment_shader_ordering = set.contains("GL_INTEL_fragment_shader_ordering");
        this.GL_INTEL_framebuffer_CMAA = GLCapabilities.check_INTEL_framebuffer_CMAA(functionProvider, pointerBuffer, set);
        this.GL_INTEL_map_texture = GLCapabilities.check_INTEL_map_texture(functionProvider, pointerBuffer, set);
        this.GL_INTEL_performance_query = GLCapabilities.check_INTEL_performance_query(functionProvider, pointerBuffer, set);
        this.GL_INTEL_shader_integer_functions2 = set.contains("GL_INTEL_shader_integer_functions2");
        this.GL_KHR_blend_equation_advanced = GLCapabilities.check_KHR_blend_equation_advanced(functionProvider, pointerBuffer, set);
        this.GL_KHR_blend_equation_advanced_coherent = set.contains("GL_KHR_blend_equation_advanced_coherent");
        this.GL_KHR_context_flush_control = set.contains("GL_KHR_context_flush_control");
        this.GL_KHR_debug = GLCapabilities.check_KHR_debug(functionProvider, pointerBuffer, set);
        this.GL_KHR_no_error = set.contains("GL_KHR_no_error");
        this.GL_KHR_parallel_shader_compile = GLCapabilities.check_KHR_parallel_shader_compile(functionProvider, pointerBuffer, set);
        this.GL_KHR_robust_buffer_access_behavior = set.contains("GL_KHR_robust_buffer_access_behavior");
        this.GL_KHR_robustness = GLCapabilities.check_KHR_robustness(functionProvider, pointerBuffer, set);
        this.GL_KHR_shader_subgroup = set.contains("GL_KHR_shader_subgroup");
        this.GL_KHR_texture_compression_astc_hdr = set.contains("GL_KHR_texture_compression_astc_hdr");
        this.GL_KHR_texture_compression_astc_ldr = set.contains("GL_KHR_texture_compression_astc_ldr");
        this.GL_KHR_texture_compression_astc_sliced_3d = set.contains("GL_KHR_texture_compression_astc_sliced_3d");
        this.GL_MESA_framebuffer_flip_x = set.contains("GL_MESA_framebuffer_flip_x");
        this.GL_MESA_framebuffer_flip_y = GLCapabilities.check_MESA_framebuffer_flip_y(functionProvider, pointerBuffer, set);
        this.GL_MESA_framebuffer_swap_xy = set.contains("GL_MESA_framebuffer_swap_xy");
        this.GL_MESA_tile_raster_order = set.contains("GL_MESA_tile_raster_order");
        this.GL_NV_alpha_to_coverage_dither_control = GLCapabilities.check_NV_alpha_to_coverage_dither_control(functionProvider, pointerBuffer, set);
        this.GL_NV_bindless_multi_draw_indirect = GLCapabilities.check_NV_bindless_multi_draw_indirect(functionProvider, pointerBuffer, set);
        this.GL_NV_bindless_multi_draw_indirect_count = GLCapabilities.check_NV_bindless_multi_draw_indirect_count(functionProvider, pointerBuffer, set);
        this.GL_NV_bindless_texture = GLCapabilities.check_NV_bindless_texture(functionProvider, pointerBuffer, set);
        this.GL_NV_blend_equation_advanced = GLCapabilities.check_NV_blend_equation_advanced(functionProvider, pointerBuffer, set);
        this.GL_NV_blend_equation_advanced_coherent = set.contains("GL_NV_blend_equation_advanced_coherent");
        this.GL_NV_blend_minmax_factor = set.contains("GL_NV_blend_minmax_factor");
        this.GL_NV_blend_square = set.contains("GL_NV_blend_square");
        this.GL_NV_clip_space_w_scaling = GLCapabilities.check_NV_clip_space_w_scaling(functionProvider, pointerBuffer, set);
        this.GL_NV_command_list = GLCapabilities.check_NV_command_list(functionProvider, pointerBuffer, set);
        this.GL_NV_compute_shader_derivatives = set.contains("GL_NV_compute_shader_derivatives");
        this.GL_NV_conditional_render = GLCapabilities.check_NV_conditional_render(functionProvider, pointerBuffer, set);
        this.GL_NV_conservative_raster = GLCapabilities.check_NV_conservative_raster(functionProvider, pointerBuffer, set);
        this.GL_NV_conservative_raster_dilate = GLCapabilities.check_NV_conservative_raster_dilate(functionProvider, pointerBuffer, set);
        this.GL_NV_conservative_raster_pre_snap = set.contains("GL_NV_conservative_raster_pre_snap");
        this.GL_NV_conservative_raster_pre_snap_triangles = GLCapabilities.check_NV_conservative_raster_pre_snap_triangles(functionProvider, pointerBuffer, set);
        this.GL_NV_conservative_raster_underestimation = set.contains("GL_NV_conservative_raster_underestimation");
        this.GL_NV_copy_depth_to_color = set.contains("GL_NV_copy_depth_to_color");
        this.GL_NV_copy_image = GLCapabilities.check_NV_copy_image(functionProvider, pointerBuffer, set);
        this.GL_NV_deep_texture3D = set.contains("GL_NV_deep_texture3D");
        this.GL_NV_depth_buffer_float = GLCapabilities.check_NV_depth_buffer_float(functionProvider, pointerBuffer, set);
        this.GL_NV_depth_clamp = set.contains("GL_NV_depth_clamp");
        this.GL_NV_draw_texture = GLCapabilities.check_NV_draw_texture(functionProvider, pointerBuffer, set);
        this.GL_NV_draw_vulkan_image = GLCapabilities.check_NV_draw_vulkan_image(functionProvider, pointerBuffer, set);
        this.GL_NV_ES3_1_compatibility = set.contains("GL_NV_ES3_1_compatibility");
        this.GL_NV_explicit_multisample = GLCapabilities.check_NV_explicit_multisample(functionProvider, pointerBuffer, set);
        this.GL_NV_fence = GLCapabilities.check_NV_fence(functionProvider, pointerBuffer, set);
        this.GL_NV_fill_rectangle = set.contains("GL_NV_fill_rectangle");
        this.GL_NV_float_buffer = set.contains("GL_NV_float_buffer");
        this.GL_NV_fog_distance = set.contains("GL_NV_fog_distance");
        this.GL_NV_fragment_coverage_to_color = GLCapabilities.check_NV_fragment_coverage_to_color(functionProvider, pointerBuffer, set);
        this.GL_NV_fragment_program4 = set.contains("GL_NV_fragment_program4");
        this.GL_NV_fragment_program_option = set.contains("GL_NV_fragment_program_option");
        this.GL_NV_fragment_shader_barycentric = set.contains("GL_NV_fragment_shader_barycentric");
        this.GL_NV_fragment_shader_interlock = set.contains("GL_NV_fragment_shader_interlock");
        this.GL_NV_framebuffer_mixed_samples = GLCapabilities.check_NV_framebuffer_mixed_samples(functionProvider, pointerBuffer, set);
        this.GL_NV_framebuffer_multisample_coverage = GLCapabilities.check_NV_framebuffer_multisample_coverage(functionProvider, pointerBuffer, set);
        this.GL_NV_geometry_shader4 = set.contains("GL_NV_geometry_shader4");
        this.GL_NV_geometry_shader_passthrough = set.contains("GL_NV_geometry_shader_passthrough");
        this.GL_NV_gpu_multicast = GLCapabilities.check_NV_gpu_multicast(functionProvider, pointerBuffer, set);
        this.GL_NV_gpu_shader5 = GLCapabilities.check_NV_gpu_shader5(functionProvider, pointerBuffer, set);
        this.GL_NV_half_float = GLCapabilities.check_NV_half_float(functionProvider, pointerBuffer, set);
        this.GL_NV_internalformat_sample_query = GLCapabilities.check_NV_internalformat_sample_query(functionProvider, pointerBuffer, set);
        this.GL_NV_light_max_exponent = set.contains("GL_NV_light_max_exponent");
        this.GL_NV_memory_attachment = GLCapabilities.check_NV_memory_attachment(functionProvider, pointerBuffer, set);
        this.GL_NV_memory_object_sparse = GLCapabilities.check_NV_memory_object_sparse(functionProvider, pointerBuffer, set);
        this.GL_NV_mesh_shader = GLCapabilities.check_NV_mesh_shader(functionProvider, pointerBuffer, set);
        this.GL_NV_multisample_coverage = set.contains("GL_NV_multisample_coverage");
        this.GL_NV_multisample_filter_hint = set.contains("GL_NV_multisample_filter_hint");
        this.GL_NV_packed_depth_stencil = set.contains("GL_NV_packed_depth_stencil");
        this.GL_NV_path_rendering = GLCapabilities.check_NV_path_rendering(functionProvider, pointerBuffer, set);
        this.GL_NV_path_rendering_shared_edge = set.contains("GL_NV_path_rendering_shared_edge");
        this.GL_NV_pixel_data_range = GLCapabilities.check_NV_pixel_data_range(functionProvider, pointerBuffer, set);
        this.GL_NV_point_sprite = GLCapabilities.check_NV_point_sprite(functionProvider, pointerBuffer, set);
        this.GL_NV_primitive_restart = GLCapabilities.check_NV_primitive_restart(functionProvider, pointerBuffer, set);
        this.GL_NV_primitive_shading_rate = set.contains("GL_NV_primitive_shading_rate");
        this.GL_NV_query_resource = GLCapabilities.check_NV_query_resource(functionProvider, pointerBuffer, set);
        this.GL_NV_query_resource_tag = GLCapabilities.check_NV_query_resource_tag(functionProvider, pointerBuffer, set);
        this.GL_NV_representative_fragment_test = set.contains("GL_NV_representative_fragment_test");
        this.GL_NV_robustness_video_memory_purge = set.contains("GL_NV_robustness_video_memory_purge");
        this.GL_NV_sample_locations = GLCapabilities.check_NV_sample_locations(functionProvider, pointerBuffer, set);
        this.GL_NV_sample_mask_override_coverage = set.contains("GL_NV_sample_mask_override_coverage");
        this.GL_NV_scissor_exclusive = GLCapabilities.check_NV_scissor_exclusive(functionProvider, pointerBuffer, set);
        this.GL_NV_shader_atomic_float = set.contains("GL_NV_shader_atomic_float");
        this.GL_NV_shader_atomic_float64 = set.contains("GL_NV_shader_atomic_float64");
        this.GL_NV_shader_atomic_fp16_vector = set.contains("GL_NV_shader_atomic_fp16_vector");
        this.GL_NV_shader_atomic_int64 = set.contains("GL_NV_shader_atomic_int64");
        this.GL_NV_shader_buffer_load = GLCapabilities.check_NV_shader_buffer_load(functionProvider, pointerBuffer, set);
        this.GL_NV_shader_buffer_store = set.contains("GL_NV_shader_buffer_store");
        this.GL_NV_shader_subgroup_partitioned = set.contains("GL_NV_shader_subgroup_partitioned");
        this.GL_NV_shader_texture_footprint = set.contains("GL_NV_shader_texture_footprint");
        this.GL_NV_shader_thread_group = set.contains("GL_NV_shader_thread_group");
        this.GL_NV_shader_thread_shuffle = set.contains("GL_NV_shader_thread_shuffle");
        this.GL_NV_shading_rate_image = GLCapabilities.check_NV_shading_rate_image(functionProvider, pointerBuffer, set);
        this.GL_NV_stereo_view_rendering = set.contains("GL_NV_stereo_view_rendering");
        this.GL_NV_texgen_reflection = set.contains("GL_NV_texgen_reflection");
        this.GL_NV_texture_barrier = GLCapabilities.check_NV_texture_barrier(functionProvider, pointerBuffer, set);
        this.GL_NV_texture_compression_vtc = set.contains("GL_NV_texture_compression_vtc");
        this.GL_NV_texture_multisample = GLCapabilities.check_NV_texture_multisample(functionProvider, pointerBuffer, set);
        this.GL_NV_texture_rectangle_compressed = set.contains("GL_NV_texture_rectangle_compressed");
        this.GL_NV_texture_shader = set.contains("GL_NV_texture_shader");
        this.GL_NV_texture_shader2 = set.contains("GL_NV_texture_shader2");
        this.GL_NV_texture_shader3 = set.contains("GL_NV_texture_shader3");
        this.GL_NV_timeline_semaphore = GLCapabilities.check_NV_timeline_semaphore(functionProvider, pointerBuffer, set);
        this.GL_NV_transform_feedback = GLCapabilities.check_NV_transform_feedback(functionProvider, pointerBuffer, set);
        this.GL_NV_transform_feedback2 = GLCapabilities.check_NV_transform_feedback2(functionProvider, pointerBuffer, set);
        this.GL_NV_uniform_buffer_unified_memory = set.contains("GL_NV_uniform_buffer_unified_memory");
        this.GL_NV_vertex_array_range = GLCapabilities.check_NV_vertex_array_range(functionProvider, pointerBuffer, set);
        this.GL_NV_vertex_array_range2 = set.contains("GL_NV_vertex_array_range2");
        this.GL_NV_vertex_attrib_integer_64bit = GLCapabilities.check_NV_vertex_attrib_integer_64bit(functionProvider, pointerBuffer, set);
        this.GL_NV_vertex_buffer_unified_memory = GLCapabilities.check_NV_vertex_buffer_unified_memory(functionProvider, pointerBuffer, set);
        this.GL_NV_viewport_array2 = set.contains("GL_NV_viewport_array2");
        this.GL_NV_viewport_swizzle = GLCapabilities.check_NV_viewport_swizzle(functionProvider, pointerBuffer, set);
        this.GL_NVX_blend_equation_advanced_multi_draw_buffers = set.contains("GL_NVX_blend_equation_advanced_multi_draw_buffers");
        this.GL_NVX_conditional_render = GLCapabilities.check_NVX_conditional_render(functionProvider, pointerBuffer, set);
        this.GL_NVX_gpu_memory_info = set.contains("GL_NVX_gpu_memory_info");
        this.GL_NVX_gpu_multicast2 = GLCapabilities.check_NVX_gpu_multicast2(functionProvider, pointerBuffer, set);
        this.GL_NVX_progress_fence = GLCapabilities.check_NVX_progress_fence(functionProvider, pointerBuffer, set);
        this.GL_OVR_multiview = GLCapabilities.check_OVR_multiview(functionProvider, pointerBuffer, set);
        this.GL_OVR_multiview2 = set.contains("GL_OVR_multiview2");
        this.GL_S3_s3tc = set.contains("GL_S3_s3tc");
        this.glEnable = pointerBuffer.get(0);
        this.glDisable = pointerBuffer.get(1);
        this.glAccum = pointerBuffer.get(2);
        this.glAlphaFunc = pointerBuffer.get(3);
        this.glAreTexturesResident = pointerBuffer.get(4);
        this.glArrayElement = pointerBuffer.get(5);
        this.glBegin = pointerBuffer.get(6);
        this.glBindTexture = pointerBuffer.get(7);
        this.glBitmap = pointerBuffer.get(8);
        this.glBlendFunc = pointerBuffer.get(9);
        this.glCallList = pointerBuffer.get(10);
        this.glCallLists = pointerBuffer.get(11);
        this.glClear = pointerBuffer.get(12);
        this.glClearAccum = pointerBuffer.get(13);
        this.glClearColor = pointerBuffer.get(14);
        this.glClearDepth = pointerBuffer.get(15);
        this.glClearIndex = pointerBuffer.get(16);
        this.glClearStencil = pointerBuffer.get(17);
        this.glClipPlane = pointerBuffer.get(18);
        this.glColor3b = pointerBuffer.get(19);
        this.glColor3s = pointerBuffer.get(20);
        this.glColor3i = pointerBuffer.get(21);
        this.glColor3f = pointerBuffer.get(22);
        this.glColor3d = pointerBuffer.get(23);
        this.glColor3ub = pointerBuffer.get(24);
        this.glColor3us = pointerBuffer.get(25);
        this.glColor3ui = pointerBuffer.get(26);
        this.glColor3bv = pointerBuffer.get(27);
        this.glColor3sv = pointerBuffer.get(28);
        this.glColor3iv = pointerBuffer.get(29);
        this.glColor3fv = pointerBuffer.get(30);
        this.glColor3dv = pointerBuffer.get(31);
        this.glColor3ubv = pointerBuffer.get(32);
        this.glColor3usv = pointerBuffer.get(33);
        this.glColor3uiv = pointerBuffer.get(34);
        this.glColor4b = pointerBuffer.get(35);
        this.glColor4s = pointerBuffer.get(36);
        this.glColor4i = pointerBuffer.get(37);
        this.glColor4f = pointerBuffer.get(38);
        this.glColor4d = pointerBuffer.get(39);
        this.glColor4ub = pointerBuffer.get(40);
        this.glColor4us = pointerBuffer.get(41);
        this.glColor4ui = pointerBuffer.get(42);
        this.glColor4bv = pointerBuffer.get(43);
        this.glColor4sv = pointerBuffer.get(44);
        this.glColor4iv = pointerBuffer.get(45);
        this.glColor4fv = pointerBuffer.get(46);
        this.glColor4dv = pointerBuffer.get(47);
        this.glColor4ubv = pointerBuffer.get(48);
        this.glColor4usv = pointerBuffer.get(49);
        this.glColor4uiv = pointerBuffer.get(50);
        this.glColorMask = pointerBuffer.get(51);
        this.glColorMaterial = pointerBuffer.get(52);
        this.glColorPointer = pointerBuffer.get(53);
        this.glCopyPixels = pointerBuffer.get(54);
        this.glCullFace = pointerBuffer.get(55);
        this.glDeleteLists = pointerBuffer.get(56);
        this.glDepthFunc = pointerBuffer.get(57);
        this.glDepthMask = pointerBuffer.get(58);
        this.glDepthRange = pointerBuffer.get(59);
        this.glDisableClientState = pointerBuffer.get(60);
        this.glDrawArrays = pointerBuffer.get(61);
        this.glDrawBuffer = pointerBuffer.get(62);
        this.glDrawElements = pointerBuffer.get(63);
        this.glDrawPixels = pointerBuffer.get(64);
        this.glEdgeFlag = pointerBuffer.get(65);
        this.glEdgeFlagv = pointerBuffer.get(66);
        this.glEdgeFlagPointer = pointerBuffer.get(67);
        this.glEnableClientState = pointerBuffer.get(68);
        this.glEnd = pointerBuffer.get(69);
        this.glEvalCoord1f = pointerBuffer.get(70);
        this.glEvalCoord1fv = pointerBuffer.get(71);
        this.glEvalCoord1d = pointerBuffer.get(72);
        this.glEvalCoord1dv = pointerBuffer.get(73);
        this.glEvalCoord2f = pointerBuffer.get(74);
        this.glEvalCoord2fv = pointerBuffer.get(75);
        this.glEvalCoord2d = pointerBuffer.get(76);
        this.glEvalCoord2dv = pointerBuffer.get(77);
        this.glEvalMesh1 = pointerBuffer.get(78);
        this.glEvalMesh2 = pointerBuffer.get(79);
        this.glEvalPoint1 = pointerBuffer.get(80);
        this.glEvalPoint2 = pointerBuffer.get(81);
        this.glFeedbackBuffer = pointerBuffer.get(82);
        this.glFinish = pointerBuffer.get(83);
        this.glFlush = pointerBuffer.get(84);
        this.glFogi = pointerBuffer.get(85);
        this.glFogiv = pointerBuffer.get(86);
        this.glFogf = pointerBuffer.get(87);
        this.glFogfv = pointerBuffer.get(88);
        this.glFrontFace = pointerBuffer.get(89);
        this.glGenLists = pointerBuffer.get(90);
        this.glGenTextures = pointerBuffer.get(91);
        this.glDeleteTextures = pointerBuffer.get(92);
        this.glGetClipPlane = pointerBuffer.get(93);
        this.glGetBooleanv = pointerBuffer.get(94);
        this.glGetFloatv = pointerBuffer.get(95);
        this.glGetIntegerv = pointerBuffer.get(96);
        this.glGetDoublev = pointerBuffer.get(97);
        this.glGetError = pointerBuffer.get(98);
        this.glGetLightiv = pointerBuffer.get(99);
        this.glGetLightfv = pointerBuffer.get(100);
        this.glGetMapiv = pointerBuffer.get(101);
        this.glGetMapfv = pointerBuffer.get(102);
        this.glGetMapdv = pointerBuffer.get(103);
        this.glGetMaterialiv = pointerBuffer.get(104);
        this.glGetMaterialfv = pointerBuffer.get(105);
        this.glGetPixelMapfv = pointerBuffer.get(106);
        this.glGetPixelMapusv = pointerBuffer.get(107);
        this.glGetPixelMapuiv = pointerBuffer.get(108);
        this.glGetPointerv = pointerBuffer.get(109);
        this.glGetPolygonStipple = pointerBuffer.get(110);
        this.glGetString = pointerBuffer.get(111);
        this.glGetTexEnviv = pointerBuffer.get(112);
        this.glGetTexEnvfv = pointerBuffer.get(113);
        this.glGetTexGeniv = pointerBuffer.get(114);
        this.glGetTexGenfv = pointerBuffer.get(115);
        this.glGetTexGendv = pointerBuffer.get(116);
        this.glGetTexImage = pointerBuffer.get(117);
        this.glGetTexLevelParameteriv = pointerBuffer.get(118);
        this.glGetTexLevelParameterfv = pointerBuffer.get(119);
        this.glGetTexParameteriv = pointerBuffer.get(120);
        this.glGetTexParameterfv = pointerBuffer.get(121);
        this.glHint = pointerBuffer.get(122);
        this.glIndexi = pointerBuffer.get(123);
        this.glIndexub = pointerBuffer.get(124);
        this.glIndexs = pointerBuffer.get(125);
        this.glIndexf = pointerBuffer.get(126);
        this.glIndexd = pointerBuffer.get(127);
        this.glIndexiv = pointerBuffer.get(128);
        this.glIndexubv = pointerBuffer.get(129);
        this.glIndexsv = pointerBuffer.get(130);
        this.glIndexfv = pointerBuffer.get(131);
        this.glIndexdv = pointerBuffer.get(132);
        this.glIndexMask = pointerBuffer.get(133);
        this.glIndexPointer = pointerBuffer.get(134);
        this.glInitNames = pointerBuffer.get(135);
        this.glInterleavedArrays = pointerBuffer.get(136);
        this.glIsEnabled = pointerBuffer.get(137);
        this.glIsList = pointerBuffer.get(138);
        this.glIsTexture = pointerBuffer.get(139);
        this.glLightModeli = pointerBuffer.get(140);
        this.glLightModelf = pointerBuffer.get(141);
        this.glLightModeliv = pointerBuffer.get(142);
        this.glLightModelfv = pointerBuffer.get(143);
        this.glLighti = pointerBuffer.get(144);
        this.glLightf = pointerBuffer.get(145);
        this.glLightiv = pointerBuffer.get(146);
        this.glLightfv = pointerBuffer.get(147);
        this.glLineStipple = pointerBuffer.get(148);
        this.glLineWidth = pointerBuffer.get(149);
        this.glListBase = pointerBuffer.get(150);
        this.glLoadMatrixf = pointerBuffer.get(151);
        this.glLoadMatrixd = pointerBuffer.get(152);
        this.glLoadIdentity = pointerBuffer.get(153);
        this.glLoadName = pointerBuffer.get(154);
        this.glLogicOp = pointerBuffer.get(155);
        this.glMap1f = pointerBuffer.get(156);
        this.glMap1d = pointerBuffer.get(157);
        this.glMap2f = pointerBuffer.get(158);
        this.glMap2d = pointerBuffer.get(159);
        this.glMapGrid1f = pointerBuffer.get(160);
        this.glMapGrid1d = pointerBuffer.get(161);
        this.glMapGrid2f = pointerBuffer.get(162);
        this.glMapGrid2d = pointerBuffer.get(163);
        this.glMateriali = pointerBuffer.get(164);
        this.glMaterialf = pointerBuffer.get(165);
        this.glMaterialiv = pointerBuffer.get(166);
        this.glMaterialfv = pointerBuffer.get(167);
        this.glMatrixMode = pointerBuffer.get(168);
        this.glMultMatrixf = pointerBuffer.get(169);
        this.glMultMatrixd = pointerBuffer.get(170);
        this.glFrustum = pointerBuffer.get(171);
        this.glNewList = pointerBuffer.get(172);
        this.glEndList = pointerBuffer.get(173);
        this.glNormal3f = pointerBuffer.get(174);
        this.glNormal3b = pointerBuffer.get(175);
        this.glNormal3s = pointerBuffer.get(176);
        this.glNormal3i = pointerBuffer.get(177);
        this.glNormal3d = pointerBuffer.get(178);
        this.glNormal3fv = pointerBuffer.get(179);
        this.glNormal3bv = pointerBuffer.get(180);
        this.glNormal3sv = pointerBuffer.get(181);
        this.glNormal3iv = pointerBuffer.get(182);
        this.glNormal3dv = pointerBuffer.get(183);
        this.glNormalPointer = pointerBuffer.get(184);
        this.glOrtho = pointerBuffer.get(185);
        this.glPassThrough = pointerBuffer.get(186);
        this.glPixelMapfv = pointerBuffer.get(187);
        this.glPixelMapusv = pointerBuffer.get(188);
        this.glPixelMapuiv = pointerBuffer.get(189);
        this.glPixelStorei = pointerBuffer.get(190);
        this.glPixelStoref = pointerBuffer.get(191);
        this.glPixelTransferi = pointerBuffer.get(192);
        this.glPixelTransferf = pointerBuffer.get(193);
        this.glPixelZoom = pointerBuffer.get(194);
        this.glPointSize = pointerBuffer.get(195);
        this.glPolygonMode = pointerBuffer.get(196);
        this.glPolygonOffset = pointerBuffer.get(197);
        this.glPolygonStipple = pointerBuffer.get(198);
        this.glPushAttrib = pointerBuffer.get(199);
        this.glPushClientAttrib = pointerBuffer.get(200);
        this.glPopAttrib = pointerBuffer.get(201);
        this.glPopClientAttrib = pointerBuffer.get(202);
        this.glPopMatrix = pointerBuffer.get(203);
        this.glPopName = pointerBuffer.get(204);
        this.glPrioritizeTextures = pointerBuffer.get(205);
        this.glPushMatrix = pointerBuffer.get(206);
        this.glPushName = pointerBuffer.get(207);
        this.glRasterPos2i = pointerBuffer.get(208);
        this.glRasterPos2s = pointerBuffer.get(209);
        this.glRasterPos2f = pointerBuffer.get(210);
        this.glRasterPos2d = pointerBuffer.get(211);
        this.glRasterPos2iv = pointerBuffer.get(212);
        this.glRasterPos2sv = pointerBuffer.get(213);
        this.glRasterPos2fv = pointerBuffer.get(214);
        this.glRasterPos2dv = pointerBuffer.get(215);
        this.glRasterPos3i = pointerBuffer.get(216);
        this.glRasterPos3s = pointerBuffer.get(217);
        this.glRasterPos3f = pointerBuffer.get(218);
        this.glRasterPos3d = pointerBuffer.get(219);
        this.glRasterPos3iv = pointerBuffer.get(220);
        this.glRasterPos3sv = pointerBuffer.get(221);
        this.glRasterPos3fv = pointerBuffer.get(222);
        this.glRasterPos3dv = pointerBuffer.get(223);
        this.glRasterPos4i = pointerBuffer.get(224);
        this.glRasterPos4s = pointerBuffer.get(225);
        this.glRasterPos4f = pointerBuffer.get(226);
        this.glRasterPos4d = pointerBuffer.get(227);
        this.glRasterPos4iv = pointerBuffer.get(228);
        this.glRasterPos4sv = pointerBuffer.get(229);
        this.glRasterPos4fv = pointerBuffer.get(230);
        this.glRasterPos4dv = pointerBuffer.get(231);
        this.glReadBuffer = pointerBuffer.get(232);
        this.glReadPixels = pointerBuffer.get(233);
        this.glRecti = pointerBuffer.get(234);
        this.glRects = pointerBuffer.get(235);
        this.glRectf = pointerBuffer.get(236);
        this.glRectd = pointerBuffer.get(237);
        this.glRectiv = pointerBuffer.get(238);
        this.glRectsv = pointerBuffer.get(239);
        this.glRectfv = pointerBuffer.get(240);
        this.glRectdv = pointerBuffer.get(241);
        this.glRenderMode = pointerBuffer.get(242);
        this.glRotatef = pointerBuffer.get(243);
        this.glRotated = pointerBuffer.get(244);
        this.glScalef = pointerBuffer.get(245);
        this.glScaled = pointerBuffer.get(246);
        this.glScissor = pointerBuffer.get(247);
        this.glSelectBuffer = pointerBuffer.get(248);
        this.glShadeModel = pointerBuffer.get(249);
        this.glStencilFunc = pointerBuffer.get(250);
        this.glStencilMask = pointerBuffer.get(251);
        this.glStencilOp = pointerBuffer.get(252);
        this.glTexCoord1f = pointerBuffer.get(253);
        this.glTexCoord1s = pointerBuffer.get(254);
        this.glTexCoord1i = pointerBuffer.get(255);
        this.glTexCoord1d = pointerBuffer.get(256);
        this.glTexCoord1fv = pointerBuffer.get(257);
        this.glTexCoord1sv = pointerBuffer.get(258);
        this.glTexCoord1iv = pointerBuffer.get(259);
        this.glTexCoord1dv = pointerBuffer.get(260);
        this.glTexCoord2f = pointerBuffer.get(261);
        this.glTexCoord2s = pointerBuffer.get(262);
        this.glTexCoord2i = pointerBuffer.get(263);
        this.glTexCoord2d = pointerBuffer.get(264);
        this.glTexCoord2fv = pointerBuffer.get(265);
        this.glTexCoord2sv = pointerBuffer.get(266);
        this.glTexCoord2iv = pointerBuffer.get(267);
        this.glTexCoord2dv = pointerBuffer.get(268);
        this.glTexCoord3f = pointerBuffer.get(269);
        this.glTexCoord3s = pointerBuffer.get(270);
        this.glTexCoord3i = pointerBuffer.get(271);
        this.glTexCoord3d = pointerBuffer.get(272);
        this.glTexCoord3fv = pointerBuffer.get(273);
        this.glTexCoord3sv = pointerBuffer.get(274);
        this.glTexCoord3iv = pointerBuffer.get(275);
        this.glTexCoord3dv = pointerBuffer.get(276);
        this.glTexCoord4f = pointerBuffer.get(277);
        this.glTexCoord4s = pointerBuffer.get(278);
        this.glTexCoord4i = pointerBuffer.get(279);
        this.glTexCoord4d = pointerBuffer.get(280);
        this.glTexCoord4fv = pointerBuffer.get(281);
        this.glTexCoord4sv = pointerBuffer.get(282);
        this.glTexCoord4iv = pointerBuffer.get(283);
        this.glTexCoord4dv = pointerBuffer.get(284);
        this.glTexCoordPointer = pointerBuffer.get(285);
        this.glTexEnvi = pointerBuffer.get(286);
        this.glTexEnviv = pointerBuffer.get(287);
        this.glTexEnvf = pointerBuffer.get(288);
        this.glTexEnvfv = pointerBuffer.get(289);
        this.glTexGeni = pointerBuffer.get(290);
        this.glTexGeniv = pointerBuffer.get(291);
        this.glTexGenf = pointerBuffer.get(292);
        this.glTexGenfv = pointerBuffer.get(293);
        this.glTexGend = pointerBuffer.get(294);
        this.glTexGendv = pointerBuffer.get(295);
        this.glTexImage1D = pointerBuffer.get(296);
        this.glTexImage2D = pointerBuffer.get(297);
        this.glCopyTexImage1D = pointerBuffer.get(298);
        this.glCopyTexImage2D = pointerBuffer.get(299);
        this.glCopyTexSubImage1D = pointerBuffer.get(300);
        this.glCopyTexSubImage2D = pointerBuffer.get(301);
        this.glTexParameteri = pointerBuffer.get(302);
        this.glTexParameteriv = pointerBuffer.get(303);
        this.glTexParameterf = pointerBuffer.get(304);
        this.glTexParameterfv = pointerBuffer.get(305);
        this.glTexSubImage1D = pointerBuffer.get(306);
        this.glTexSubImage2D = pointerBuffer.get(307);
        this.glTranslatef = pointerBuffer.get(308);
        this.glTranslated = pointerBuffer.get(309);
        this.glVertex2f = pointerBuffer.get(310);
        this.glVertex2s = pointerBuffer.get(311);
        this.glVertex2i = pointerBuffer.get(312);
        this.glVertex2d = pointerBuffer.get(313);
        this.glVertex2fv = pointerBuffer.get(314);
        this.glVertex2sv = pointerBuffer.get(315);
        this.glVertex2iv = pointerBuffer.get(316);
        this.glVertex2dv = pointerBuffer.get(317);
        this.glVertex3f = pointerBuffer.get(318);
        this.glVertex3s = pointerBuffer.get(319);
        this.glVertex3i = pointerBuffer.get(320);
        this.glVertex3d = pointerBuffer.get(321);
        this.glVertex3fv = pointerBuffer.get(322);
        this.glVertex3sv = pointerBuffer.get(323);
        this.glVertex3iv = pointerBuffer.get(324);
        this.glVertex3dv = pointerBuffer.get(325);
        this.glVertex4f = pointerBuffer.get(326);
        this.glVertex4s = pointerBuffer.get(327);
        this.glVertex4i = pointerBuffer.get(328);
        this.glVertex4d = pointerBuffer.get(329);
        this.glVertex4fv = pointerBuffer.get(330);
        this.glVertex4sv = pointerBuffer.get(331);
        this.glVertex4iv = pointerBuffer.get(332);
        this.glVertex4dv = pointerBuffer.get(333);
        this.glVertexPointer = pointerBuffer.get(334);
        this.glViewport = pointerBuffer.get(335);
        this.glTexImage3D = pointerBuffer.get(336);
        this.glTexSubImage3D = pointerBuffer.get(337);
        this.glCopyTexSubImage3D = pointerBuffer.get(338);
        this.glDrawRangeElements = pointerBuffer.get(339);
        this.glCompressedTexImage3D = pointerBuffer.get(340);
        this.glCompressedTexImage2D = pointerBuffer.get(341);
        this.glCompressedTexImage1D = pointerBuffer.get(342);
        this.glCompressedTexSubImage3D = pointerBuffer.get(343);
        this.glCompressedTexSubImage2D = pointerBuffer.get(344);
        this.glCompressedTexSubImage1D = pointerBuffer.get(345);
        this.glGetCompressedTexImage = pointerBuffer.get(346);
        this.glSampleCoverage = pointerBuffer.get(347);
        this.glActiveTexture = pointerBuffer.get(348);
        this.glClientActiveTexture = pointerBuffer.get(349);
        this.glMultiTexCoord1f = pointerBuffer.get(350);
        this.glMultiTexCoord1s = pointerBuffer.get(351);
        this.glMultiTexCoord1i = pointerBuffer.get(352);
        this.glMultiTexCoord1d = pointerBuffer.get(353);
        this.glMultiTexCoord1fv = pointerBuffer.get(354);
        this.glMultiTexCoord1sv = pointerBuffer.get(355);
        this.glMultiTexCoord1iv = pointerBuffer.get(356);
        this.glMultiTexCoord1dv = pointerBuffer.get(357);
        this.glMultiTexCoord2f = pointerBuffer.get(358);
        this.glMultiTexCoord2s = pointerBuffer.get(359);
        this.glMultiTexCoord2i = pointerBuffer.get(360);
        this.glMultiTexCoord2d = pointerBuffer.get(361);
        this.glMultiTexCoord2fv = pointerBuffer.get(362);
        this.glMultiTexCoord2sv = pointerBuffer.get(363);
        this.glMultiTexCoord2iv = pointerBuffer.get(364);
        this.glMultiTexCoord2dv = pointerBuffer.get(365);
        this.glMultiTexCoord3f = pointerBuffer.get(366);
        this.glMultiTexCoord3s = pointerBuffer.get(367);
        this.glMultiTexCoord3i = pointerBuffer.get(368);
        this.glMultiTexCoord3d = pointerBuffer.get(369);
        this.glMultiTexCoord3fv = pointerBuffer.get(370);
        this.glMultiTexCoord3sv = pointerBuffer.get(371);
        this.glMultiTexCoord3iv = pointerBuffer.get(372);
        this.glMultiTexCoord3dv = pointerBuffer.get(373);
        this.glMultiTexCoord4f = pointerBuffer.get(374);
        this.glMultiTexCoord4s = pointerBuffer.get(375);
        this.glMultiTexCoord4i = pointerBuffer.get(376);
        this.glMultiTexCoord4d = pointerBuffer.get(377);
        this.glMultiTexCoord4fv = pointerBuffer.get(378);
        this.glMultiTexCoord4sv = pointerBuffer.get(379);
        this.glMultiTexCoord4iv = pointerBuffer.get(380);
        this.glMultiTexCoord4dv = pointerBuffer.get(381);
        this.glLoadTransposeMatrixf = pointerBuffer.get(382);
        this.glLoadTransposeMatrixd = pointerBuffer.get(383);
        this.glMultTransposeMatrixf = pointerBuffer.get(384);
        this.glMultTransposeMatrixd = pointerBuffer.get(385);
        this.glBlendColor = pointerBuffer.get(386);
        this.glBlendEquation = pointerBuffer.get(387);
        this.glFogCoordf = pointerBuffer.get(388);
        this.glFogCoordd = pointerBuffer.get(389);
        this.glFogCoordfv = pointerBuffer.get(390);
        this.glFogCoorddv = pointerBuffer.get(391);
        this.glFogCoordPointer = pointerBuffer.get(392);
        this.glMultiDrawArrays = pointerBuffer.get(393);
        this.glMultiDrawElements = pointerBuffer.get(394);
        this.glPointParameterf = pointerBuffer.get(395);
        this.glPointParameteri = pointerBuffer.get(396);
        this.glPointParameterfv = pointerBuffer.get(397);
        this.glPointParameteriv = pointerBuffer.get(398);
        this.glSecondaryColor3b = pointerBuffer.get(399);
        this.glSecondaryColor3s = pointerBuffer.get(400);
        this.glSecondaryColor3i = pointerBuffer.get(401);
        this.glSecondaryColor3f = pointerBuffer.get(402);
        this.glSecondaryColor3d = pointerBuffer.get(403);
        this.glSecondaryColor3ub = pointerBuffer.get(404);
        this.glSecondaryColor3us = pointerBuffer.get(405);
        this.glSecondaryColor3ui = pointerBuffer.get(406);
        this.glSecondaryColor3bv = pointerBuffer.get(407);
        this.glSecondaryColor3sv = pointerBuffer.get(408);
        this.glSecondaryColor3iv = pointerBuffer.get(409);
        this.glSecondaryColor3fv = pointerBuffer.get(410);
        this.glSecondaryColor3dv = pointerBuffer.get(411);
        this.glSecondaryColor3ubv = pointerBuffer.get(412);
        this.glSecondaryColor3usv = pointerBuffer.get(413);
        this.glSecondaryColor3uiv = pointerBuffer.get(414);
        this.glSecondaryColorPointer = pointerBuffer.get(415);
        this.glBlendFuncSeparate = pointerBuffer.get(416);
        this.glWindowPos2i = pointerBuffer.get(417);
        this.glWindowPos2s = pointerBuffer.get(418);
        this.glWindowPos2f = pointerBuffer.get(419);
        this.glWindowPos2d = pointerBuffer.get(420);
        this.glWindowPos2iv = pointerBuffer.get(421);
        this.glWindowPos2sv = pointerBuffer.get(422);
        this.glWindowPos2fv = pointerBuffer.get(423);
        this.glWindowPos2dv = pointerBuffer.get(424);
        this.glWindowPos3i = pointerBuffer.get(425);
        this.glWindowPos3s = pointerBuffer.get(426);
        this.glWindowPos3f = pointerBuffer.get(427);
        this.glWindowPos3d = pointerBuffer.get(428);
        this.glWindowPos3iv = pointerBuffer.get(429);
        this.glWindowPos3sv = pointerBuffer.get(430);
        this.glWindowPos3fv = pointerBuffer.get(431);
        this.glWindowPos3dv = pointerBuffer.get(432);
        this.glBindBuffer = pointerBuffer.get(433);
        this.glDeleteBuffers = pointerBuffer.get(434);
        this.glGenBuffers = pointerBuffer.get(435);
        this.glIsBuffer = pointerBuffer.get(436);
        this.glBufferData = pointerBuffer.get(437);
        this.glBufferSubData = pointerBuffer.get(438);
        this.glGetBufferSubData = pointerBuffer.get(439);
        this.glMapBuffer = pointerBuffer.get(440);
        this.glUnmapBuffer = pointerBuffer.get(441);
        this.glGetBufferParameteriv = pointerBuffer.get(442);
        this.glGetBufferPointerv = pointerBuffer.get(443);
        this.glGenQueries = pointerBuffer.get(444);
        this.glDeleteQueries = pointerBuffer.get(445);
        this.glIsQuery = pointerBuffer.get(446);
        this.glBeginQuery = pointerBuffer.get(447);
        this.glEndQuery = pointerBuffer.get(448);
        this.glGetQueryiv = pointerBuffer.get(449);
        this.glGetQueryObjectiv = pointerBuffer.get(450);
        this.glGetQueryObjectuiv = pointerBuffer.get(451);
        this.glCreateProgram = pointerBuffer.get(452);
        this.glDeleteProgram = pointerBuffer.get(453);
        this.glIsProgram = pointerBuffer.get(454);
        this.glCreateShader = pointerBuffer.get(455);
        this.glDeleteShader = pointerBuffer.get(456);
        this.glIsShader = pointerBuffer.get(457);
        this.glAttachShader = pointerBuffer.get(458);
        this.glDetachShader = pointerBuffer.get(459);
        this.glShaderSource = pointerBuffer.get(460);
        this.glCompileShader = pointerBuffer.get(461);
        this.glLinkProgram = pointerBuffer.get(462);
        this.glUseProgram = pointerBuffer.get(463);
        this.glValidateProgram = pointerBuffer.get(464);
        this.glUniform1f = pointerBuffer.get(465);
        this.glUniform2f = pointerBuffer.get(466);
        this.glUniform3f = pointerBuffer.get(467);
        this.glUniform4f = pointerBuffer.get(468);
        this.glUniform1i = pointerBuffer.get(469);
        this.glUniform2i = pointerBuffer.get(470);
        this.glUniform3i = pointerBuffer.get(471);
        this.glUniform4i = pointerBuffer.get(472);
        this.glUniform1fv = pointerBuffer.get(473);
        this.glUniform2fv = pointerBuffer.get(474);
        this.glUniform3fv = pointerBuffer.get(475);
        this.glUniform4fv = pointerBuffer.get(476);
        this.glUniform1iv = pointerBuffer.get(477);
        this.glUniform2iv = pointerBuffer.get(478);
        this.glUniform3iv = pointerBuffer.get(479);
        this.glUniform4iv = pointerBuffer.get(480);
        this.glUniformMatrix2fv = pointerBuffer.get(481);
        this.glUniformMatrix3fv = pointerBuffer.get(482);
        this.glUniformMatrix4fv = pointerBuffer.get(483);
        this.glGetShaderiv = pointerBuffer.get(484);
        this.glGetProgramiv = pointerBuffer.get(485);
        this.glGetShaderInfoLog = pointerBuffer.get(486);
        this.glGetProgramInfoLog = pointerBuffer.get(487);
        this.glGetAttachedShaders = pointerBuffer.get(488);
        this.glGetUniformLocation = pointerBuffer.get(489);
        this.glGetActiveUniform = pointerBuffer.get(490);
        this.glGetUniformfv = pointerBuffer.get(491);
        this.glGetUniformiv = pointerBuffer.get(492);
        this.glGetShaderSource = pointerBuffer.get(493);
        this.glVertexAttrib1f = pointerBuffer.get(494);
        this.glVertexAttrib1s = pointerBuffer.get(495);
        this.glVertexAttrib1d = pointerBuffer.get(496);
        this.glVertexAttrib2f = pointerBuffer.get(497);
        this.glVertexAttrib2s = pointerBuffer.get(498);
        this.glVertexAttrib2d = pointerBuffer.get(499);
        this.glVertexAttrib3f = pointerBuffer.get(500);
        this.glVertexAttrib3s = pointerBuffer.get(501);
        this.glVertexAttrib3d = pointerBuffer.get(502);
        this.glVertexAttrib4f = pointerBuffer.get(503);
        this.glVertexAttrib4s = pointerBuffer.get(504);
        this.glVertexAttrib4d = pointerBuffer.get(505);
        this.glVertexAttrib4Nub = pointerBuffer.get(506);
        this.glVertexAttrib1fv = pointerBuffer.get(507);
        this.glVertexAttrib1sv = pointerBuffer.get(508);
        this.glVertexAttrib1dv = pointerBuffer.get(509);
        this.glVertexAttrib2fv = pointerBuffer.get(510);
        this.glVertexAttrib2sv = pointerBuffer.get(511);
        this.glVertexAttrib2dv = pointerBuffer.get(512);
        this.glVertexAttrib3fv = pointerBuffer.get(513);
        this.glVertexAttrib3sv = pointerBuffer.get(514);
        this.glVertexAttrib3dv = pointerBuffer.get(515);
        this.glVertexAttrib4fv = pointerBuffer.get(516);
        this.glVertexAttrib4sv = pointerBuffer.get(517);
        this.glVertexAttrib4dv = pointerBuffer.get(518);
        this.glVertexAttrib4iv = pointerBuffer.get(519);
        this.glVertexAttrib4bv = pointerBuffer.get(520);
        this.glVertexAttrib4ubv = pointerBuffer.get(521);
        this.glVertexAttrib4usv = pointerBuffer.get(522);
        this.glVertexAttrib4uiv = pointerBuffer.get(523);
        this.glVertexAttrib4Nbv = pointerBuffer.get(524);
        this.glVertexAttrib4Nsv = pointerBuffer.get(525);
        this.glVertexAttrib4Niv = pointerBuffer.get(526);
        this.glVertexAttrib4Nubv = pointerBuffer.get(527);
        this.glVertexAttrib4Nusv = pointerBuffer.get(528);
        this.glVertexAttrib4Nuiv = pointerBuffer.get(529);
        this.glVertexAttribPointer = pointerBuffer.get(530);
        this.glEnableVertexAttribArray = pointerBuffer.get(531);
        this.glDisableVertexAttribArray = pointerBuffer.get(532);
        this.glBindAttribLocation = pointerBuffer.get(533);
        this.glGetActiveAttrib = pointerBuffer.get(534);
        this.glGetAttribLocation = pointerBuffer.get(535);
        this.glGetVertexAttribiv = pointerBuffer.get(536);
        this.glGetVertexAttribfv = pointerBuffer.get(537);
        this.glGetVertexAttribdv = pointerBuffer.get(538);
        this.glGetVertexAttribPointerv = pointerBuffer.get(539);
        this.glDrawBuffers = pointerBuffer.get(540);
        this.glBlendEquationSeparate = pointerBuffer.get(541);
        this.glStencilOpSeparate = pointerBuffer.get(542);
        this.glStencilFuncSeparate = pointerBuffer.get(543);
        this.glStencilMaskSeparate = pointerBuffer.get(544);
        this.glUniformMatrix2x3fv = pointerBuffer.get(545);
        this.glUniformMatrix3x2fv = pointerBuffer.get(546);
        this.glUniformMatrix2x4fv = pointerBuffer.get(547);
        this.glUniformMatrix4x2fv = pointerBuffer.get(548);
        this.glUniformMatrix3x4fv = pointerBuffer.get(549);
        this.glUniformMatrix4x3fv = pointerBuffer.get(550);
        this.glGetStringi = pointerBuffer.get(551);
        this.glClearBufferiv = pointerBuffer.get(552);
        this.glClearBufferuiv = pointerBuffer.get(553);
        this.glClearBufferfv = pointerBuffer.get(554);
        this.glClearBufferfi = pointerBuffer.get(555);
        this.glVertexAttribI1i = pointerBuffer.get(556);
        this.glVertexAttribI2i = pointerBuffer.get(557);
        this.glVertexAttribI3i = pointerBuffer.get(558);
        this.glVertexAttribI4i = pointerBuffer.get(559);
        this.glVertexAttribI1ui = pointerBuffer.get(560);
        this.glVertexAttribI2ui = pointerBuffer.get(561);
        this.glVertexAttribI3ui = pointerBuffer.get(562);
        this.glVertexAttribI4ui = pointerBuffer.get(563);
        this.glVertexAttribI1iv = pointerBuffer.get(564);
        this.glVertexAttribI2iv = pointerBuffer.get(565);
        this.glVertexAttribI3iv = pointerBuffer.get(566);
        this.glVertexAttribI4iv = pointerBuffer.get(567);
        this.glVertexAttribI1uiv = pointerBuffer.get(568);
        this.glVertexAttribI2uiv = pointerBuffer.get(569);
        this.glVertexAttribI3uiv = pointerBuffer.get(570);
        this.glVertexAttribI4uiv = pointerBuffer.get(571);
        this.glVertexAttribI4bv = pointerBuffer.get(572);
        this.glVertexAttribI4sv = pointerBuffer.get(573);
        this.glVertexAttribI4ubv = pointerBuffer.get(574);
        this.glVertexAttribI4usv = pointerBuffer.get(575);
        this.glVertexAttribIPointer = pointerBuffer.get(576);
        this.glGetVertexAttribIiv = pointerBuffer.get(577);
        this.glGetVertexAttribIuiv = pointerBuffer.get(578);
        this.glUniform1ui = pointerBuffer.get(579);
        this.glUniform2ui = pointerBuffer.get(580);
        this.glUniform3ui = pointerBuffer.get(581);
        this.glUniform4ui = pointerBuffer.get(582);
        this.glUniform1uiv = pointerBuffer.get(583);
        this.glUniform2uiv = pointerBuffer.get(584);
        this.glUniform3uiv = pointerBuffer.get(585);
        this.glUniform4uiv = pointerBuffer.get(586);
        this.glGetUniformuiv = pointerBuffer.get(587);
        this.glBindFragDataLocation = pointerBuffer.get(588);
        this.glGetFragDataLocation = pointerBuffer.get(589);
        this.glBeginConditionalRender = pointerBuffer.get(590);
        this.glEndConditionalRender = pointerBuffer.get(591);
        this.glMapBufferRange = pointerBuffer.get(592);
        this.glFlushMappedBufferRange = pointerBuffer.get(593);
        this.glClampColor = pointerBuffer.get(594);
        this.glIsRenderbuffer = pointerBuffer.get(595);
        this.glBindRenderbuffer = pointerBuffer.get(596);
        this.glDeleteRenderbuffers = pointerBuffer.get(597);
        this.glGenRenderbuffers = pointerBuffer.get(598);
        this.glRenderbufferStorage = pointerBuffer.get(599);
        this.glRenderbufferStorageMultisample = pointerBuffer.get(600);
        this.glGetRenderbufferParameteriv = pointerBuffer.get(601);
        this.glIsFramebuffer = pointerBuffer.get(602);
        this.glBindFramebuffer = pointerBuffer.get(603);
        this.glDeleteFramebuffers = pointerBuffer.get(604);
        this.glGenFramebuffers = pointerBuffer.get(605);
        this.glCheckFramebufferStatus = pointerBuffer.get(606);
        this.glFramebufferTexture1D = pointerBuffer.get(607);
        this.glFramebufferTexture2D = pointerBuffer.get(608);
        this.glFramebufferTexture3D = pointerBuffer.get(609);
        this.glFramebufferTextureLayer = pointerBuffer.get(610);
        this.glFramebufferRenderbuffer = pointerBuffer.get(611);
        this.glGetFramebufferAttachmentParameteriv = pointerBuffer.get(612);
        this.glBlitFramebuffer = pointerBuffer.get(613);
        this.glGenerateMipmap = pointerBuffer.get(614);
        this.glTexParameterIiv = pointerBuffer.get(615);
        this.glTexParameterIuiv = pointerBuffer.get(616);
        this.glGetTexParameterIiv = pointerBuffer.get(617);
        this.glGetTexParameterIuiv = pointerBuffer.get(618);
        this.glColorMaski = pointerBuffer.get(619);
        this.glGetBooleani_v = pointerBuffer.get(620);
        this.glGetIntegeri_v = pointerBuffer.get(621);
        this.glEnablei = pointerBuffer.get(622);
        this.glDisablei = pointerBuffer.get(623);
        this.glIsEnabledi = pointerBuffer.get(624);
        this.glBindBufferRange = pointerBuffer.get(625);
        this.glBindBufferBase = pointerBuffer.get(626);
        this.glBeginTransformFeedback = pointerBuffer.get(627);
        this.glEndTransformFeedback = pointerBuffer.get(628);
        this.glTransformFeedbackVaryings = pointerBuffer.get(629);
        this.glGetTransformFeedbackVarying = pointerBuffer.get(630);
        this.glBindVertexArray = pointerBuffer.get(631);
        this.glDeleteVertexArrays = pointerBuffer.get(632);
        this.glGenVertexArrays = pointerBuffer.get(633);
        this.glIsVertexArray = pointerBuffer.get(634);
        this.glDrawArraysInstanced = pointerBuffer.get(635);
        this.glDrawElementsInstanced = pointerBuffer.get(636);
        this.glCopyBufferSubData = pointerBuffer.get(637);
        this.glPrimitiveRestartIndex = pointerBuffer.get(638);
        this.glTexBuffer = pointerBuffer.get(639);
        this.glGetUniformIndices = pointerBuffer.get(640);
        this.glGetActiveUniformsiv = pointerBuffer.get(641);
        this.glGetActiveUniformName = pointerBuffer.get(642);
        this.glGetUniformBlockIndex = pointerBuffer.get(643);
        this.glGetActiveUniformBlockiv = pointerBuffer.get(644);
        this.glGetActiveUniformBlockName = pointerBuffer.get(645);
        this.glUniformBlockBinding = pointerBuffer.get(646);
        this.glGetBufferParameteri64v = pointerBuffer.get(647);
        this.glDrawElementsBaseVertex = pointerBuffer.get(648);
        this.glDrawRangeElementsBaseVertex = pointerBuffer.get(649);
        this.glDrawElementsInstancedBaseVertex = pointerBuffer.get(650);
        this.glMultiDrawElementsBaseVertex = pointerBuffer.get(651);
        this.glProvokingVertex = pointerBuffer.get(652);
        this.glTexImage2DMultisample = pointerBuffer.get(653);
        this.glTexImage3DMultisample = pointerBuffer.get(654);
        this.glGetMultisamplefv = pointerBuffer.get(655);
        this.glSampleMaski = pointerBuffer.get(656);
        this.glFramebufferTexture = pointerBuffer.get(657);
        this.glFenceSync = pointerBuffer.get(658);
        this.glIsSync = pointerBuffer.get(659);
        this.glDeleteSync = pointerBuffer.get(660);
        this.glClientWaitSync = pointerBuffer.get(661);
        this.glWaitSync = pointerBuffer.get(662);
        this.glGetInteger64v = pointerBuffer.get(663);
        this.glGetInteger64i_v = pointerBuffer.get(664);
        this.glGetSynciv = pointerBuffer.get(665);
        this.glBindFragDataLocationIndexed = pointerBuffer.get(666);
        this.glGetFragDataIndex = pointerBuffer.get(667);
        this.glGenSamplers = pointerBuffer.get(668);
        this.glDeleteSamplers = pointerBuffer.get(669);
        this.glIsSampler = pointerBuffer.get(670);
        this.glBindSampler = pointerBuffer.get(671);
        this.glSamplerParameteri = pointerBuffer.get(672);
        this.glSamplerParameterf = pointerBuffer.get(673);
        this.glSamplerParameteriv = pointerBuffer.get(674);
        this.glSamplerParameterfv = pointerBuffer.get(675);
        this.glSamplerParameterIiv = pointerBuffer.get(676);
        this.glSamplerParameterIuiv = pointerBuffer.get(677);
        this.glGetSamplerParameteriv = pointerBuffer.get(678);
        this.glGetSamplerParameterfv = pointerBuffer.get(679);
        this.glGetSamplerParameterIiv = pointerBuffer.get(680);
        this.glGetSamplerParameterIuiv = pointerBuffer.get(681);
        this.glQueryCounter = pointerBuffer.get(682);
        this.glGetQueryObjecti64v = pointerBuffer.get(683);
        this.glGetQueryObjectui64v = pointerBuffer.get(684);
        this.glVertexAttribDivisor = pointerBuffer.get(685);
        this.glVertexP2ui = pointerBuffer.get(686);
        this.glVertexP3ui = pointerBuffer.get(687);
        this.glVertexP4ui = pointerBuffer.get(688);
        this.glVertexP2uiv = pointerBuffer.get(689);
        this.glVertexP3uiv = pointerBuffer.get(690);
        this.glVertexP4uiv = pointerBuffer.get(691);
        this.glTexCoordP1ui = pointerBuffer.get(692);
        this.glTexCoordP2ui = pointerBuffer.get(693);
        this.glTexCoordP3ui = pointerBuffer.get(694);
        this.glTexCoordP4ui = pointerBuffer.get(695);
        this.glTexCoordP1uiv = pointerBuffer.get(696);
        this.glTexCoordP2uiv = pointerBuffer.get(697);
        this.glTexCoordP3uiv = pointerBuffer.get(698);
        this.glTexCoordP4uiv = pointerBuffer.get(699);
        this.glMultiTexCoordP1ui = pointerBuffer.get(700);
        this.glMultiTexCoordP2ui = pointerBuffer.get(701);
        this.glMultiTexCoordP3ui = pointerBuffer.get(702);
        this.glMultiTexCoordP4ui = pointerBuffer.get(703);
        this.glMultiTexCoordP1uiv = pointerBuffer.get(704);
        this.glMultiTexCoordP2uiv = pointerBuffer.get(705);
        this.glMultiTexCoordP3uiv = pointerBuffer.get(706);
        this.glMultiTexCoordP4uiv = pointerBuffer.get(707);
        this.glNormalP3ui = pointerBuffer.get(708);
        this.glNormalP3uiv = pointerBuffer.get(709);
        this.glColorP3ui = pointerBuffer.get(710);
        this.glColorP4ui = pointerBuffer.get(711);
        this.glColorP3uiv = pointerBuffer.get(712);
        this.glColorP4uiv = pointerBuffer.get(713);
        this.glSecondaryColorP3ui = pointerBuffer.get(714);
        this.glSecondaryColorP3uiv = pointerBuffer.get(715);
        this.glVertexAttribP1ui = pointerBuffer.get(716);
        this.glVertexAttribP2ui = pointerBuffer.get(717);
        this.glVertexAttribP3ui = pointerBuffer.get(718);
        this.glVertexAttribP4ui = pointerBuffer.get(719);
        this.glVertexAttribP1uiv = pointerBuffer.get(720);
        this.glVertexAttribP2uiv = pointerBuffer.get(721);
        this.glVertexAttribP3uiv = pointerBuffer.get(722);
        this.glVertexAttribP4uiv = pointerBuffer.get(723);
        this.glBlendEquationi = pointerBuffer.get(724);
        this.glBlendEquationSeparatei = pointerBuffer.get(725);
        this.glBlendFunci = pointerBuffer.get(726);
        this.glBlendFuncSeparatei = pointerBuffer.get(727);
        this.glDrawArraysIndirect = pointerBuffer.get(728);
        this.glDrawElementsIndirect = pointerBuffer.get(729);
        this.glUniform1d = pointerBuffer.get(730);
        this.glUniform2d = pointerBuffer.get(731);
        this.glUniform3d = pointerBuffer.get(732);
        this.glUniform4d = pointerBuffer.get(733);
        this.glUniform1dv = pointerBuffer.get(734);
        this.glUniform2dv = pointerBuffer.get(735);
        this.glUniform3dv = pointerBuffer.get(736);
        this.glUniform4dv = pointerBuffer.get(737);
        this.glUniformMatrix2dv = pointerBuffer.get(738);
        this.glUniformMatrix3dv = pointerBuffer.get(739);
        this.glUniformMatrix4dv = pointerBuffer.get(740);
        this.glUniformMatrix2x3dv = pointerBuffer.get(741);
        this.glUniformMatrix2x4dv = pointerBuffer.get(742);
        this.glUniformMatrix3x2dv = pointerBuffer.get(743);
        this.glUniformMatrix3x4dv = pointerBuffer.get(744);
        this.glUniformMatrix4x2dv = pointerBuffer.get(745);
        this.glUniformMatrix4x3dv = pointerBuffer.get(746);
        this.glGetUniformdv = pointerBuffer.get(747);
        this.glMinSampleShading = pointerBuffer.get(748);
        this.glGetSubroutineUniformLocation = pointerBuffer.get(749);
        this.glGetSubroutineIndex = pointerBuffer.get(750);
        this.glGetActiveSubroutineUniformiv = pointerBuffer.get(751);
        this.glGetActiveSubroutineUniformName = pointerBuffer.get(752);
        this.glGetActiveSubroutineName = pointerBuffer.get(753);
        this.glUniformSubroutinesuiv = pointerBuffer.get(754);
        this.glGetUniformSubroutineuiv = pointerBuffer.get(755);
        this.glGetProgramStageiv = pointerBuffer.get(756);
        this.glPatchParameteri = pointerBuffer.get(757);
        this.glPatchParameterfv = pointerBuffer.get(758);
        this.glBindTransformFeedback = pointerBuffer.get(759);
        this.glDeleteTransformFeedbacks = pointerBuffer.get(760);
        this.glGenTransformFeedbacks = pointerBuffer.get(761);
        this.glIsTransformFeedback = pointerBuffer.get(762);
        this.glPauseTransformFeedback = pointerBuffer.get(763);
        this.glResumeTransformFeedback = pointerBuffer.get(764);
        this.glDrawTransformFeedback = pointerBuffer.get(765);
        this.glDrawTransformFeedbackStream = pointerBuffer.get(766);
        this.glBeginQueryIndexed = pointerBuffer.get(767);
        this.glEndQueryIndexed = pointerBuffer.get(768);
        this.glGetQueryIndexediv = pointerBuffer.get(769);
        this.glReleaseShaderCompiler = pointerBuffer.get(770);
        this.glShaderBinary = pointerBuffer.get(771);
        this.glGetShaderPrecisionFormat = pointerBuffer.get(772);
        this.glDepthRangef = pointerBuffer.get(773);
        this.glClearDepthf = pointerBuffer.get(774);
        this.glGetProgramBinary = pointerBuffer.get(775);
        this.glProgramBinary = pointerBuffer.get(776);
        this.glProgramParameteri = pointerBuffer.get(777);
        this.glUseProgramStages = pointerBuffer.get(778);
        this.glActiveShaderProgram = pointerBuffer.get(779);
        this.glCreateShaderProgramv = pointerBuffer.get(780);
        this.glBindProgramPipeline = pointerBuffer.get(781);
        this.glDeleteProgramPipelines = pointerBuffer.get(782);
        this.glGenProgramPipelines = pointerBuffer.get(783);
        this.glIsProgramPipeline = pointerBuffer.get(784);
        this.glGetProgramPipelineiv = pointerBuffer.get(785);
        this.glProgramUniform1i = pointerBuffer.get(786);
        this.glProgramUniform2i = pointerBuffer.get(787);
        this.glProgramUniform3i = pointerBuffer.get(788);
        this.glProgramUniform4i = pointerBuffer.get(789);
        this.glProgramUniform1ui = pointerBuffer.get(790);
        this.glProgramUniform2ui = pointerBuffer.get(791);
        this.glProgramUniform3ui = pointerBuffer.get(792);
        this.glProgramUniform4ui = pointerBuffer.get(793);
        this.glProgramUniform1f = pointerBuffer.get(794);
        this.glProgramUniform2f = pointerBuffer.get(795);
        this.glProgramUniform3f = pointerBuffer.get(796);
        this.glProgramUniform4f = pointerBuffer.get(797);
        this.glProgramUniform1d = pointerBuffer.get(798);
        this.glProgramUniform2d = pointerBuffer.get(799);
        this.glProgramUniform3d = pointerBuffer.get(800);
        this.glProgramUniform4d = pointerBuffer.get(801);
        this.glProgramUniform1iv = pointerBuffer.get(802);
        this.glProgramUniform2iv = pointerBuffer.get(803);
        this.glProgramUniform3iv = pointerBuffer.get(804);
        this.glProgramUniform4iv = pointerBuffer.get(805);
        this.glProgramUniform1uiv = pointerBuffer.get(806);
        this.glProgramUniform2uiv = pointerBuffer.get(807);
        this.glProgramUniform3uiv = pointerBuffer.get(808);
        this.glProgramUniform4uiv = pointerBuffer.get(809);
        this.glProgramUniform1fv = pointerBuffer.get(810);
        this.glProgramUniform2fv = pointerBuffer.get(811);
        this.glProgramUniform3fv = pointerBuffer.get(812);
        this.glProgramUniform4fv = pointerBuffer.get(813);
        this.glProgramUniform1dv = pointerBuffer.get(814);
        this.glProgramUniform2dv = pointerBuffer.get(815);
        this.glProgramUniform3dv = pointerBuffer.get(816);
        this.glProgramUniform4dv = pointerBuffer.get(817);
        this.glProgramUniformMatrix2fv = pointerBuffer.get(818);
        this.glProgramUniformMatrix3fv = pointerBuffer.get(819);
        this.glProgramUniformMatrix4fv = pointerBuffer.get(820);
        this.glProgramUniformMatrix2dv = pointerBuffer.get(821);
        this.glProgramUniformMatrix3dv = pointerBuffer.get(822);
        this.glProgramUniformMatrix4dv = pointerBuffer.get(823);
        this.glProgramUniformMatrix2x3fv = pointerBuffer.get(824);
        this.glProgramUniformMatrix3x2fv = pointerBuffer.get(825);
        this.glProgramUniformMatrix2x4fv = pointerBuffer.get(826);
        this.glProgramUniformMatrix4x2fv = pointerBuffer.get(827);
        this.glProgramUniformMatrix3x4fv = pointerBuffer.get(828);
        this.glProgramUniformMatrix4x3fv = pointerBuffer.get(829);
        this.glProgramUniformMatrix2x3dv = pointerBuffer.get(830);
        this.glProgramUniformMatrix3x2dv = pointerBuffer.get(831);
        this.glProgramUniformMatrix2x4dv = pointerBuffer.get(832);
        this.glProgramUniformMatrix4x2dv = pointerBuffer.get(833);
        this.glProgramUniformMatrix3x4dv = pointerBuffer.get(834);
        this.glProgramUniformMatrix4x3dv = pointerBuffer.get(835);
        this.glValidateProgramPipeline = pointerBuffer.get(836);
        this.glGetProgramPipelineInfoLog = pointerBuffer.get(837);
        this.glVertexAttribL1d = pointerBuffer.get(838);
        this.glVertexAttribL2d = pointerBuffer.get(839);
        this.glVertexAttribL3d = pointerBuffer.get(840);
        this.glVertexAttribL4d = pointerBuffer.get(841);
        this.glVertexAttribL1dv = pointerBuffer.get(842);
        this.glVertexAttribL2dv = pointerBuffer.get(843);
        this.glVertexAttribL3dv = pointerBuffer.get(844);
        this.glVertexAttribL4dv = pointerBuffer.get(845);
        this.glVertexAttribLPointer = pointerBuffer.get(846);
        this.glGetVertexAttribLdv = pointerBuffer.get(847);
        this.glViewportArrayv = pointerBuffer.get(848);
        this.glViewportIndexedf = pointerBuffer.get(849);
        this.glViewportIndexedfv = pointerBuffer.get(850);
        this.glScissorArrayv = pointerBuffer.get(851);
        this.glScissorIndexed = pointerBuffer.get(852);
        this.glScissorIndexedv = pointerBuffer.get(853);
        this.glDepthRangeArrayv = pointerBuffer.get(854);
        this.glDepthRangeIndexed = pointerBuffer.get(855);
        this.glGetFloati_v = pointerBuffer.get(856);
        this.glGetDoublei_v = pointerBuffer.get(857);
        this.glGetActiveAtomicCounterBufferiv = pointerBuffer.get(858);
        this.glTexStorage1D = pointerBuffer.get(859);
        this.glTexStorage2D = pointerBuffer.get(860);
        this.glTexStorage3D = pointerBuffer.get(861);
        this.glDrawTransformFeedbackInstanced = pointerBuffer.get(862);
        this.glDrawTransformFeedbackStreamInstanced = pointerBuffer.get(863);
        this.glDrawArraysInstancedBaseInstance = pointerBuffer.get(864);
        this.glDrawElementsInstancedBaseInstance = pointerBuffer.get(865);
        this.glDrawElementsInstancedBaseVertexBaseInstance = pointerBuffer.get(866);
        this.glBindImageTexture = pointerBuffer.get(867);
        this.glMemoryBarrier = pointerBuffer.get(868);
        this.glGetInternalformativ = pointerBuffer.get(869);
        this.glClearBufferData = pointerBuffer.get(870);
        this.glClearBufferSubData = pointerBuffer.get(871);
        this.glDispatchCompute = pointerBuffer.get(872);
        this.glDispatchComputeIndirect = pointerBuffer.get(873);
        this.glCopyImageSubData = pointerBuffer.get(874);
        this.glDebugMessageControl = pointerBuffer.get(875);
        this.glDebugMessageInsert = pointerBuffer.get(876);
        this.glDebugMessageCallback = pointerBuffer.get(877);
        this.glGetDebugMessageLog = pointerBuffer.get(878);
        this.glPushDebugGroup = pointerBuffer.get(879);
        this.glPopDebugGroup = pointerBuffer.get(880);
        this.glObjectLabel = pointerBuffer.get(881);
        this.glGetObjectLabel = pointerBuffer.get(882);
        this.glObjectPtrLabel = pointerBuffer.get(883);
        this.glGetObjectPtrLabel = pointerBuffer.get(884);
        this.glFramebufferParameteri = pointerBuffer.get(885);
        this.glGetFramebufferParameteriv = pointerBuffer.get(886);
        this.glGetInternalformati64v = pointerBuffer.get(887);
        this.glInvalidateTexSubImage = pointerBuffer.get(888);
        this.glInvalidateTexImage = pointerBuffer.get(889);
        this.glInvalidateBufferSubData = pointerBuffer.get(890);
        this.glInvalidateBufferData = pointerBuffer.get(891);
        this.glInvalidateFramebuffer = pointerBuffer.get(892);
        this.glInvalidateSubFramebuffer = pointerBuffer.get(893);
        this.glMultiDrawArraysIndirect = pointerBuffer.get(894);
        this.glMultiDrawElementsIndirect = pointerBuffer.get(895);
        this.glGetProgramInterfaceiv = pointerBuffer.get(896);
        this.glGetProgramResourceIndex = pointerBuffer.get(897);
        this.glGetProgramResourceName = pointerBuffer.get(898);
        this.glGetProgramResourceiv = pointerBuffer.get(899);
        this.glGetProgramResourceLocation = pointerBuffer.get(900);
        this.glGetProgramResourceLocationIndex = pointerBuffer.get(901);
        this.glShaderStorageBlockBinding = pointerBuffer.get(902);
        this.glTexBufferRange = pointerBuffer.get(903);
        this.glTexStorage2DMultisample = pointerBuffer.get(904);
        this.glTexStorage3DMultisample = pointerBuffer.get(905);
        this.glTextureView = pointerBuffer.get(906);
        this.glBindVertexBuffer = pointerBuffer.get(907);
        this.glVertexAttribFormat = pointerBuffer.get(908);
        this.glVertexAttribIFormat = pointerBuffer.get(909);
        this.glVertexAttribLFormat = pointerBuffer.get(910);
        this.glVertexAttribBinding = pointerBuffer.get(911);
        this.glVertexBindingDivisor = pointerBuffer.get(912);
        this.glBufferStorage = pointerBuffer.get(913);
        this.glClearTexSubImage = pointerBuffer.get(914);
        this.glClearTexImage = pointerBuffer.get(915);
        this.glBindBuffersBase = pointerBuffer.get(916);
        this.glBindBuffersRange = pointerBuffer.get(917);
        this.glBindTextures = pointerBuffer.get(918);
        this.glBindSamplers = pointerBuffer.get(919);
        this.glBindImageTextures = pointerBuffer.get(920);
        this.glBindVertexBuffers = pointerBuffer.get(921);
        this.glClipControl = pointerBuffer.get(922);
        this.glCreateTransformFeedbacks = pointerBuffer.get(923);
        this.glTransformFeedbackBufferBase = pointerBuffer.get(924);
        this.glTransformFeedbackBufferRange = pointerBuffer.get(925);
        this.glGetTransformFeedbackiv = pointerBuffer.get(926);
        this.glGetTransformFeedbacki_v = pointerBuffer.get(927);
        this.glGetTransformFeedbacki64_v = pointerBuffer.get(928);
        this.glCreateBuffers = pointerBuffer.get(929);
        this.glNamedBufferStorage = pointerBuffer.get(930);
        this.glNamedBufferData = pointerBuffer.get(931);
        this.glNamedBufferSubData = pointerBuffer.get(932);
        this.glCopyNamedBufferSubData = pointerBuffer.get(933);
        this.glClearNamedBufferData = pointerBuffer.get(934);
        this.glClearNamedBufferSubData = pointerBuffer.get(935);
        this.glMapNamedBuffer = pointerBuffer.get(936);
        this.glMapNamedBufferRange = pointerBuffer.get(937);
        this.glUnmapNamedBuffer = pointerBuffer.get(938);
        this.glFlushMappedNamedBufferRange = pointerBuffer.get(939);
        this.glGetNamedBufferParameteriv = pointerBuffer.get(940);
        this.glGetNamedBufferParameteri64v = pointerBuffer.get(941);
        this.glGetNamedBufferPointerv = pointerBuffer.get(942);
        this.glGetNamedBufferSubData = pointerBuffer.get(943);
        this.glCreateFramebuffers = pointerBuffer.get(944);
        this.glNamedFramebufferRenderbuffer = pointerBuffer.get(945);
        this.glNamedFramebufferParameteri = pointerBuffer.get(946);
        this.glNamedFramebufferTexture = pointerBuffer.get(947);
        this.glNamedFramebufferTextureLayer = pointerBuffer.get(948);
        this.glNamedFramebufferDrawBuffer = pointerBuffer.get(949);
        this.glNamedFramebufferDrawBuffers = pointerBuffer.get(950);
        this.glNamedFramebufferReadBuffer = pointerBuffer.get(951);
        this.glInvalidateNamedFramebufferData = pointerBuffer.get(952);
        this.glInvalidateNamedFramebufferSubData = pointerBuffer.get(953);
        this.glClearNamedFramebufferiv = pointerBuffer.get(954);
        this.glClearNamedFramebufferuiv = pointerBuffer.get(955);
        this.glClearNamedFramebufferfv = pointerBuffer.get(956);
        this.glClearNamedFramebufferfi = pointerBuffer.get(957);
        this.glBlitNamedFramebuffer = pointerBuffer.get(958);
        this.glCheckNamedFramebufferStatus = pointerBuffer.get(959);
        this.glGetNamedFramebufferParameteriv = pointerBuffer.get(960);
        this.glGetNamedFramebufferAttachmentParameteriv = pointerBuffer.get(961);
        this.glCreateRenderbuffers = pointerBuffer.get(962);
        this.glNamedRenderbufferStorage = pointerBuffer.get(963);
        this.glNamedRenderbufferStorageMultisample = pointerBuffer.get(964);
        this.glGetNamedRenderbufferParameteriv = pointerBuffer.get(965);
        this.glCreateTextures = pointerBuffer.get(966);
        this.glTextureBuffer = pointerBuffer.get(967);
        this.glTextureBufferRange = pointerBuffer.get(968);
        this.glTextureStorage1D = pointerBuffer.get(969);
        this.glTextureStorage2D = pointerBuffer.get(970);
        this.glTextureStorage3D = pointerBuffer.get(971);
        this.glTextureStorage2DMultisample = pointerBuffer.get(972);
        this.glTextureStorage3DMultisample = pointerBuffer.get(973);
        this.glTextureSubImage1D = pointerBuffer.get(974);
        this.glTextureSubImage2D = pointerBuffer.get(975);
        this.glTextureSubImage3D = pointerBuffer.get(976);
        this.glCompressedTextureSubImage1D = pointerBuffer.get(977);
        this.glCompressedTextureSubImage2D = pointerBuffer.get(978);
        this.glCompressedTextureSubImage3D = pointerBuffer.get(979);
        this.glCopyTextureSubImage1D = pointerBuffer.get(980);
        this.glCopyTextureSubImage2D = pointerBuffer.get(981);
        this.glCopyTextureSubImage3D = pointerBuffer.get(982);
        this.glTextureParameterf = pointerBuffer.get(983);
        this.glTextureParameterfv = pointerBuffer.get(984);
        this.glTextureParameteri = pointerBuffer.get(985);
        this.glTextureParameterIiv = pointerBuffer.get(986);
        this.glTextureParameterIuiv = pointerBuffer.get(987);
        this.glTextureParameteriv = pointerBuffer.get(988);
        this.glGenerateTextureMipmap = pointerBuffer.get(989);
        this.glBindTextureUnit = pointerBuffer.get(990);
        this.glGetTextureImage = pointerBuffer.get(991);
        this.glGetCompressedTextureImage = pointerBuffer.get(992);
        this.glGetTextureLevelParameterfv = pointerBuffer.get(993);
        this.glGetTextureLevelParameteriv = pointerBuffer.get(994);
        this.glGetTextureParameterfv = pointerBuffer.get(995);
        this.glGetTextureParameterIiv = pointerBuffer.get(996);
        this.glGetTextureParameterIuiv = pointerBuffer.get(997);
        this.glGetTextureParameteriv = pointerBuffer.get(998);
        this.glCreateVertexArrays = pointerBuffer.get(999);
        this.glDisableVertexArrayAttrib = pointerBuffer.get(1000);
        this.glEnableVertexArrayAttrib = pointerBuffer.get(1001);
        this.glVertexArrayElementBuffer = pointerBuffer.get(1002);
        this.glVertexArrayVertexBuffer = pointerBuffer.get(1003);
        this.glVertexArrayVertexBuffers = pointerBuffer.get(1004);
        this.glVertexArrayAttribFormat = pointerBuffer.get(1005);
        this.glVertexArrayAttribIFormat = pointerBuffer.get(1006);
        this.glVertexArrayAttribLFormat = pointerBuffer.get(1007);
        this.glVertexArrayAttribBinding = pointerBuffer.get(1008);
        this.glVertexArrayBindingDivisor = pointerBuffer.get(1009);
        this.glGetVertexArrayiv = pointerBuffer.get(1010);
        this.glGetVertexArrayIndexediv = pointerBuffer.get(1011);
        this.glGetVertexArrayIndexed64iv = pointerBuffer.get(1012);
        this.glCreateSamplers = pointerBuffer.get(1013);
        this.glCreateProgramPipelines = pointerBuffer.get(1014);
        this.glCreateQueries = pointerBuffer.get(1015);
        this.glGetQueryBufferObjectiv = pointerBuffer.get(1016);
        this.glGetQueryBufferObjectuiv = pointerBuffer.get(1017);
        this.glGetQueryBufferObjecti64v = pointerBuffer.get(1018);
        this.glGetQueryBufferObjectui64v = pointerBuffer.get(1019);
        this.glMemoryBarrierByRegion = pointerBuffer.get(1020);
        this.glGetTextureSubImage = pointerBuffer.get(1021);
        this.glGetCompressedTextureSubImage = pointerBuffer.get(1022);
        this.glTextureBarrier = pointerBuffer.get(1023);
        this.glGetGraphicsResetStatus = pointerBuffer.get(1024);
        this.glGetnMapdv = pointerBuffer.get(1025);
        this.glGetnMapfv = pointerBuffer.get(1026);
        this.glGetnMapiv = pointerBuffer.get(1027);
        this.glGetnPixelMapfv = pointerBuffer.get(1028);
        this.glGetnPixelMapuiv = pointerBuffer.get(1029);
        this.glGetnPixelMapusv = pointerBuffer.get(1030);
        this.glGetnPolygonStipple = pointerBuffer.get(1031);
        this.glGetnTexImage = pointerBuffer.get(1032);
        this.glReadnPixels = pointerBuffer.get(1033);
        this.glGetnColorTable = pointerBuffer.get(1034);
        this.glGetnConvolutionFilter = pointerBuffer.get(1035);
        this.glGetnSeparableFilter = pointerBuffer.get(1036);
        this.glGetnHistogram = pointerBuffer.get(1037);
        this.glGetnMinmax = pointerBuffer.get(1038);
        this.glGetnCompressedTexImage = pointerBuffer.get(1039);
        this.glGetnUniformfv = pointerBuffer.get(1040);
        this.glGetnUniformdv = pointerBuffer.get(1041);
        this.glGetnUniformiv = pointerBuffer.get(1042);
        this.glGetnUniformuiv = pointerBuffer.get(1043);
        this.glMultiDrawArraysIndirectCount = pointerBuffer.get(1044);
        this.glMultiDrawElementsIndirectCount = pointerBuffer.get(1045);
        this.glPolygonOffsetClamp = pointerBuffer.get(1046);
        this.glSpecializeShader = pointerBuffer.get(1047);
        this.glDebugMessageEnableAMD = pointerBuffer.get(1048);
        this.glDebugMessageInsertAMD = pointerBuffer.get(1049);
        this.glDebugMessageCallbackAMD = pointerBuffer.get(1050);
        this.glGetDebugMessageLogAMD = pointerBuffer.get(1051);
        this.glBlendFuncIndexedAMD = pointerBuffer.get(1052);
        this.glBlendFuncSeparateIndexedAMD = pointerBuffer.get(1053);
        this.glBlendEquationIndexedAMD = pointerBuffer.get(1054);
        this.glBlendEquationSeparateIndexedAMD = pointerBuffer.get(1055);
        this.glRenderbufferStorageMultisampleAdvancedAMD = pointerBuffer.get(1056);
        this.glNamedRenderbufferStorageMultisampleAdvancedAMD = pointerBuffer.get(1057);
        this.glUniform1i64NV = pointerBuffer.get(1058);
        this.glUniform2i64NV = pointerBuffer.get(1059);
        this.glUniform3i64NV = pointerBuffer.get(1060);
        this.glUniform4i64NV = pointerBuffer.get(1061);
        this.glUniform1i64vNV = pointerBuffer.get(1062);
        this.glUniform2i64vNV = pointerBuffer.get(1063);
        this.glUniform3i64vNV = pointerBuffer.get(1064);
        this.glUniform4i64vNV = pointerBuffer.get(1065);
        this.glUniform1ui64NV = pointerBuffer.get(1066);
        this.glUniform2ui64NV = pointerBuffer.get(1067);
        this.glUniform3ui64NV = pointerBuffer.get(1068);
        this.glUniform4ui64NV = pointerBuffer.get(1069);
        this.glUniform1ui64vNV = pointerBuffer.get(1070);
        this.glUniform2ui64vNV = pointerBuffer.get(1071);
        this.glUniform3ui64vNV = pointerBuffer.get(1072);
        this.glUniform4ui64vNV = pointerBuffer.get(1073);
        this.glGetUniformi64vNV = pointerBuffer.get(1074);
        this.glGetUniformui64vNV = pointerBuffer.get(1075);
        this.glProgramUniform1i64NV = pointerBuffer.get(1076);
        this.glProgramUniform2i64NV = pointerBuffer.get(1077);
        this.glProgramUniform3i64NV = pointerBuffer.get(1078);
        this.glProgramUniform4i64NV = pointerBuffer.get(1079);
        this.glProgramUniform1i64vNV = pointerBuffer.get(1080);
        this.glProgramUniform2i64vNV = pointerBuffer.get(1081);
        this.glProgramUniform3i64vNV = pointerBuffer.get(1082);
        this.glProgramUniform4i64vNV = pointerBuffer.get(1083);
        this.glProgramUniform1ui64NV = pointerBuffer.get(1084);
        this.glProgramUniform2ui64NV = pointerBuffer.get(1085);
        this.glProgramUniform3ui64NV = pointerBuffer.get(1086);
        this.glProgramUniform4ui64NV = pointerBuffer.get(1087);
        this.glProgramUniform1ui64vNV = pointerBuffer.get(1088);
        this.glProgramUniform2ui64vNV = pointerBuffer.get(1089);
        this.glProgramUniform3ui64vNV = pointerBuffer.get(1090);
        this.glProgramUniform4ui64vNV = pointerBuffer.get(1091);
        this.glVertexAttribParameteriAMD = pointerBuffer.get(1092);
        this.glQueryObjectParameteruiAMD = pointerBuffer.get(1093);
        this.glGetPerfMonitorGroupsAMD = pointerBuffer.get(1094);
        this.glGetPerfMonitorCountersAMD = pointerBuffer.get(1095);
        this.glGetPerfMonitorGroupStringAMD = pointerBuffer.get(1096);
        this.glGetPerfMonitorCounterStringAMD = pointerBuffer.get(1097);
        this.glGetPerfMonitorCounterInfoAMD = pointerBuffer.get(1098);
        this.glGenPerfMonitorsAMD = pointerBuffer.get(1099);
        this.glDeletePerfMonitorsAMD = pointerBuffer.get(1100);
        this.glSelectPerfMonitorCountersAMD = pointerBuffer.get(1101);
        this.glBeginPerfMonitorAMD = pointerBuffer.get(1102);
        this.glEndPerfMonitorAMD = pointerBuffer.get(1103);
        this.glGetPerfMonitorCounterDataAMD = pointerBuffer.get(1104);
        this.glSetMultisamplefvAMD = pointerBuffer.get(1105);
        this.glTexStorageSparseAMD = pointerBuffer.get(1106);
        this.glTextureStorageSparseAMD = pointerBuffer.get(1107);
        this.glStencilOpValueAMD = pointerBuffer.get(1108);
        this.glTessellationFactorAMD = pointerBuffer.get(1109);
        this.glTessellationModeAMD = pointerBuffer.get(1110);
        this.glGetTextureHandleARB = pointerBuffer.get(1111);
        this.glGetTextureSamplerHandleARB = pointerBuffer.get(1112);
        this.glMakeTextureHandleResidentARB = pointerBuffer.get(1113);
        this.glMakeTextureHandleNonResidentARB = pointerBuffer.get(1114);
        this.glGetImageHandleARB = pointerBuffer.get(1115);
        this.glMakeImageHandleResidentARB = pointerBuffer.get(1116);
        this.glMakeImageHandleNonResidentARB = pointerBuffer.get(1117);
        this.glUniformHandleui64ARB = pointerBuffer.get(1118);
        this.glUniformHandleui64vARB = pointerBuffer.get(1119);
        this.glProgramUniformHandleui64ARB = pointerBuffer.get(1120);
        this.glProgramUniformHandleui64vARB = pointerBuffer.get(1121);
        this.glIsTextureHandleResidentARB = pointerBuffer.get(1122);
        this.glIsImageHandleResidentARB = pointerBuffer.get(1123);
        this.glVertexAttribL1ui64ARB = pointerBuffer.get(1124);
        this.glVertexAttribL1ui64vARB = pointerBuffer.get(1125);
        this.glGetVertexAttribLui64vARB = pointerBuffer.get(1126);
        this.glNamedBufferStorageEXT = pointerBuffer.get(1127);
        this.glCreateSyncFromCLeventARB = pointerBuffer.get(1128);
        this.glClearNamedBufferDataEXT = pointerBuffer.get(1129);
        this.glClearNamedBufferSubDataEXT = pointerBuffer.get(1130);
        this.glClampColorARB = pointerBuffer.get(1131);
        this.glDispatchComputeGroupSizeARB = pointerBuffer.get(1132);
        this.glDebugMessageControlARB = pointerBuffer.get(1133);
        this.glDebugMessageInsertARB = pointerBuffer.get(1134);
        this.glDebugMessageCallbackARB = pointerBuffer.get(1135);
        this.glGetDebugMessageLogARB = pointerBuffer.get(1136);
        this.glDrawBuffersARB = pointerBuffer.get(1137);
        this.glBlendEquationiARB = pointerBuffer.get(1138);
        this.glBlendEquationSeparateiARB = pointerBuffer.get(1139);
        this.glBlendFunciARB = pointerBuffer.get(1140);
        this.glBlendFuncSeparateiARB = pointerBuffer.get(1141);
        this.glDrawArraysInstancedARB = pointerBuffer.get(1142);
        this.glDrawElementsInstancedARB = pointerBuffer.get(1143);
        this.glPrimitiveBoundingBoxARB = pointerBuffer.get(1144);
        this.glNamedFramebufferParameteriEXT = pointerBuffer.get(1145);
        this.glGetNamedFramebufferParameterivEXT = pointerBuffer.get(1146);
        this.glProgramParameteriARB = pointerBuffer.get(1147);
        this.glFramebufferTextureARB = pointerBuffer.get(1148);
        this.glFramebufferTextureLayerARB = pointerBuffer.get(1149);
        this.glFramebufferTextureFaceARB = pointerBuffer.get(1150);
        this.glSpecializeShaderARB = pointerBuffer.get(1151);
        this.glProgramUniform1dEXT = pointerBuffer.get(1152);
        this.glProgramUniform2dEXT = pointerBuffer.get(1153);
        this.glProgramUniform3dEXT = pointerBuffer.get(1154);
        this.glProgramUniform4dEXT = pointerBuffer.get(1155);
        this.glProgramUniform1dvEXT = pointerBuffer.get(1156);
        this.glProgramUniform2dvEXT = pointerBuffer.get(1157);
        this.glProgramUniform3dvEXT = pointerBuffer.get(1158);
        this.glProgramUniform4dvEXT = pointerBuffer.get(1159);
        this.glProgramUniformMatrix2dvEXT = pointerBuffer.get(1160);
        this.glProgramUniformMatrix3dvEXT = pointerBuffer.get(1161);
        this.glProgramUniformMatrix4dvEXT = pointerBuffer.get(1162);
        this.glProgramUniformMatrix2x3dvEXT = pointerBuffer.get(1163);
        this.glProgramUniformMatrix2x4dvEXT = pointerBuffer.get(1164);
        this.glProgramUniformMatrix3x2dvEXT = pointerBuffer.get(1165);
        this.glProgramUniformMatrix3x4dvEXT = pointerBuffer.get(1166);
        this.glProgramUniformMatrix4x2dvEXT = pointerBuffer.get(1167);
        this.glProgramUniformMatrix4x3dvEXT = pointerBuffer.get(1168);
        this.glUniform1i64ARB = pointerBuffer.get(1169);
        this.glUniform1i64vARB = pointerBuffer.get(1170);
        this.glProgramUniform1i64ARB = pointerBuffer.get(1171);
        this.glProgramUniform1i64vARB = pointerBuffer.get(1172);
        this.glUniform2i64ARB = pointerBuffer.get(1173);
        this.glUniform2i64vARB = pointerBuffer.get(1174);
        this.glProgramUniform2i64ARB = pointerBuffer.get(1175);
        this.glProgramUniform2i64vARB = pointerBuffer.get(1176);
        this.glUniform3i64ARB = pointerBuffer.get(1177);
        this.glUniform3i64vARB = pointerBuffer.get(1178);
        this.glProgramUniform3i64ARB = pointerBuffer.get(1179);
        this.glProgramUniform3i64vARB = pointerBuffer.get(1180);
        this.glUniform4i64ARB = pointerBuffer.get(1181);
        this.glUniform4i64vARB = pointerBuffer.get(1182);
        this.glProgramUniform4i64ARB = pointerBuffer.get(1183);
        this.glProgramUniform4i64vARB = pointerBuffer.get(1184);
        this.glUniform1ui64ARB = pointerBuffer.get(1185);
        this.glUniform1ui64vARB = pointerBuffer.get(1186);
        this.glProgramUniform1ui64ARB = pointerBuffer.get(1187);
        this.glProgramUniform1ui64vARB = pointerBuffer.get(1188);
        this.glUniform2ui64ARB = pointerBuffer.get(1189);
        this.glUniform2ui64vARB = pointerBuffer.get(1190);
        this.glProgramUniform2ui64ARB = pointerBuffer.get(1191);
        this.glProgramUniform2ui64vARB = pointerBuffer.get(1192);
        this.glUniform3ui64ARB = pointerBuffer.get(1193);
        this.glUniform3ui64vARB = pointerBuffer.get(1194);
        this.glProgramUniform3ui64ARB = pointerBuffer.get(1195);
        this.glProgramUniform3ui64vARB = pointerBuffer.get(1196);
        this.glUniform4ui64ARB = pointerBuffer.get(1197);
        this.glUniform4ui64vARB = pointerBuffer.get(1198);
        this.glProgramUniform4ui64ARB = pointerBuffer.get(1199);
        this.glProgramUniform4ui64vARB = pointerBuffer.get(1200);
        this.glGetUniformi64vARB = pointerBuffer.get(1201);
        this.glGetUniformui64vARB = pointerBuffer.get(1202);
        this.glGetnUniformi64vARB = pointerBuffer.get(1203);
        this.glGetnUniformui64vARB = pointerBuffer.get(1204);
        this.glColorTable = pointerBuffer.get(1205);
        this.glCopyColorTable = pointerBuffer.get(1206);
        this.glColorTableParameteriv = pointerBuffer.get(1207);
        this.glColorTableParameterfv = pointerBuffer.get(1208);
        this.glGetColorTable = pointerBuffer.get(1209);
        this.glGetColorTableParameteriv = pointerBuffer.get(1210);
        this.glGetColorTableParameterfv = pointerBuffer.get(1211);
        this.glColorSubTable = pointerBuffer.get(1212);
        this.glCopyColorSubTable = pointerBuffer.get(1213);
        this.glConvolutionFilter1D = pointerBuffer.get(1214);
        this.glConvolutionFilter2D = pointerBuffer.get(1215);
        this.glCopyConvolutionFilter1D = pointerBuffer.get(1216);
        this.glCopyConvolutionFilter2D = pointerBuffer.get(1217);
        this.glGetConvolutionFilter = pointerBuffer.get(1218);
        this.glSeparableFilter2D = pointerBuffer.get(1219);
        this.glGetSeparableFilter = pointerBuffer.get(1220);
        this.glConvolutionParameteri = pointerBuffer.get(1221);
        this.glConvolutionParameteriv = pointerBuffer.get(1222);
        this.glConvolutionParameterf = pointerBuffer.get(1223);
        this.glConvolutionParameterfv = pointerBuffer.get(1224);
        this.glGetConvolutionParameteriv = pointerBuffer.get(1225);
        this.glGetConvolutionParameterfv = pointerBuffer.get(1226);
        this.glHistogram = pointerBuffer.get(1227);
        this.glResetHistogram = pointerBuffer.get(1228);
        this.glGetHistogram = pointerBuffer.get(1229);
        this.glGetHistogramParameteriv = pointerBuffer.get(1230);
        this.glGetHistogramParameterfv = pointerBuffer.get(1231);
        this.glMinmax = pointerBuffer.get(1232);
        this.glResetMinmax = pointerBuffer.get(1233);
        this.glGetMinmax = pointerBuffer.get(1234);
        this.glGetMinmaxParameteriv = pointerBuffer.get(1235);
        this.glGetMinmaxParameterfv = pointerBuffer.get(1236);
        this.glMultiDrawArraysIndirectCountARB = pointerBuffer.get(1237);
        this.glMultiDrawElementsIndirectCountARB = pointerBuffer.get(1238);
        this.glVertexAttribDivisorARB = pointerBuffer.get(1239);
        this.glVertexArrayVertexAttribDivisorEXT = pointerBuffer.get(1240);
        this.glCurrentPaletteMatrixARB = pointerBuffer.get(1241);
        this.glMatrixIndexuivARB = pointerBuffer.get(1242);
        this.glMatrixIndexubvARB = pointerBuffer.get(1243);
        this.glMatrixIndexusvARB = pointerBuffer.get(1244);
        this.glMatrixIndexPointerARB = pointerBuffer.get(1245);
        this.glSampleCoverageARB = pointerBuffer.get(1246);
        this.glActiveTextureARB = pointerBuffer.get(1247);
        this.glClientActiveTextureARB = pointerBuffer.get(1248);
        this.glMultiTexCoord1fARB = pointerBuffer.get(1249);
        this.glMultiTexCoord1sARB = pointerBuffer.get(1250);
        this.glMultiTexCoord1iARB = pointerBuffer.get(1251);
        this.glMultiTexCoord1dARB = pointerBuffer.get(1252);
        this.glMultiTexCoord1fvARB = pointerBuffer.get(1253);
        this.glMultiTexCoord1svARB = pointerBuffer.get(1254);
        this.glMultiTexCoord1ivARB = pointerBuffer.get(1255);
        this.glMultiTexCoord1dvARB = pointerBuffer.get(1256);
        this.glMultiTexCoord2fARB = pointerBuffer.get(1257);
        this.glMultiTexCoord2sARB = pointerBuffer.get(1258);
        this.glMultiTexCoord2iARB = pointerBuffer.get(1259);
        this.glMultiTexCoord2dARB = pointerBuffer.get(1260);
        this.glMultiTexCoord2fvARB = pointerBuffer.get(1261);
        this.glMultiTexCoord2svARB = pointerBuffer.get(1262);
        this.glMultiTexCoord2ivARB = pointerBuffer.get(1263);
        this.glMultiTexCoord2dvARB = pointerBuffer.get(1264);
        this.glMultiTexCoord3fARB = pointerBuffer.get(1265);
        this.glMultiTexCoord3sARB = pointerBuffer.get(1266);
        this.glMultiTexCoord3iARB = pointerBuffer.get(1267);
        this.glMultiTexCoord3dARB = pointerBuffer.get(1268);
        this.glMultiTexCoord3fvARB = pointerBuffer.get(1269);
        this.glMultiTexCoord3svARB = pointerBuffer.get(1270);
        this.glMultiTexCoord3ivARB = pointerBuffer.get(1271);
        this.glMultiTexCoord3dvARB = pointerBuffer.get(1272);
        this.glMultiTexCoord4fARB = pointerBuffer.get(1273);
        this.glMultiTexCoord4sARB = pointerBuffer.get(1274);
        this.glMultiTexCoord4iARB = pointerBuffer.get(1275);
        this.glMultiTexCoord4dARB = pointerBuffer.get(1276);
        this.glMultiTexCoord4fvARB = pointerBuffer.get(1277);
        this.glMultiTexCoord4svARB = pointerBuffer.get(1278);
        this.glMultiTexCoord4ivARB = pointerBuffer.get(1279);
        this.glMultiTexCoord4dvARB = pointerBuffer.get(1280);
        this.glGenQueriesARB = pointerBuffer.get(1281);
        this.glDeleteQueriesARB = pointerBuffer.get(1282);
        this.glIsQueryARB = pointerBuffer.get(1283);
        this.glBeginQueryARB = pointerBuffer.get(1284);
        this.glEndQueryARB = pointerBuffer.get(1285);
        this.glGetQueryivARB = pointerBuffer.get(1286);
        this.glGetQueryObjectivARB = pointerBuffer.get(1287);
        this.glGetQueryObjectuivARB = pointerBuffer.get(1288);
        this.glMaxShaderCompilerThreadsARB = pointerBuffer.get(1289);
        this.glPointParameterfARB = pointerBuffer.get(1290);
        this.glPointParameterfvARB = pointerBuffer.get(1291);
        this.glGetGraphicsResetStatusARB = pointerBuffer.get(1292);
        this.glGetnMapdvARB = pointerBuffer.get(1293);
        this.glGetnMapfvARB = pointerBuffer.get(1294);
        this.glGetnMapivARB = pointerBuffer.get(1295);
        this.glGetnPixelMapfvARB = pointerBuffer.get(1296);
        this.glGetnPixelMapuivARB = pointerBuffer.get(1297);
        this.glGetnPixelMapusvARB = pointerBuffer.get(1298);
        this.glGetnPolygonStippleARB = pointerBuffer.get(1299);
        this.glGetnTexImageARB = pointerBuffer.get(1300);
        this.glReadnPixelsARB = pointerBuffer.get(1301);
        this.glGetnColorTableARB = pointerBuffer.get(1302);
        this.glGetnConvolutionFilterARB = pointerBuffer.get(1303);
        this.glGetnSeparableFilterARB = pointerBuffer.get(1304);
        this.glGetnHistogramARB = pointerBuffer.get(1305);
        this.glGetnMinmaxARB = pointerBuffer.get(1306);
        this.glGetnCompressedTexImageARB = pointerBuffer.get(1307);
        this.glGetnUniformfvARB = pointerBuffer.get(1308);
        this.glGetnUniformivARB = pointerBuffer.get(1309);
        this.glGetnUniformuivARB = pointerBuffer.get(1310);
        this.glGetnUniformdvARB = pointerBuffer.get(1311);
        this.glFramebufferSampleLocationsfvARB = pointerBuffer.get(1312);
        this.glNamedFramebufferSampleLocationsfvARB = pointerBuffer.get(1313);
        this.glEvaluateDepthValuesARB = pointerBuffer.get(1314);
        this.glMinSampleShadingARB = pointerBuffer.get(1315);
        this.glDeleteObjectARB = pointerBuffer.get(1316);
        this.glGetHandleARB = pointerBuffer.get(1317);
        this.glDetachObjectARB = pointerBuffer.get(1318);
        this.glCreateShaderObjectARB = pointerBuffer.get(1319);
        this.glShaderSourceARB = pointerBuffer.get(1320);
        this.glCompileShaderARB = pointerBuffer.get(1321);
        this.glCreateProgramObjectARB = pointerBuffer.get(1322);
        this.glAttachObjectARB = pointerBuffer.get(1323);
        this.glLinkProgramARB = pointerBuffer.get(1324);
        this.glUseProgramObjectARB = pointerBuffer.get(1325);
        this.glValidateProgramARB = pointerBuffer.get(1326);
        this.glUniform1fARB = pointerBuffer.get(1327);
        this.glUniform2fARB = pointerBuffer.get(1328);
        this.glUniform3fARB = pointerBuffer.get(1329);
        this.glUniform4fARB = pointerBuffer.get(1330);
        this.glUniform1iARB = pointerBuffer.get(1331);
        this.glUniform2iARB = pointerBuffer.get(1332);
        this.glUniform3iARB = pointerBuffer.get(1333);
        this.glUniform4iARB = pointerBuffer.get(1334);
        this.glUniform1fvARB = pointerBuffer.get(1335);
        this.glUniform2fvARB = pointerBuffer.get(1336);
        this.glUniform3fvARB = pointerBuffer.get(1337);
        this.glUniform4fvARB = pointerBuffer.get(1338);
        this.glUniform1ivARB = pointerBuffer.get(1339);
        this.glUniform2ivARB = pointerBuffer.get(1340);
        this.glUniform3ivARB = pointerBuffer.get(1341);
        this.glUniform4ivARB = pointerBuffer.get(1342);
        this.glUniformMatrix2fvARB = pointerBuffer.get(1343);
        this.glUniformMatrix3fvARB = pointerBuffer.get(1344);
        this.glUniformMatrix4fvARB = pointerBuffer.get(1345);
        this.glGetObjectParameterfvARB = pointerBuffer.get(1346);
        this.glGetObjectParameterivARB = pointerBuffer.get(1347);
        this.glGetInfoLogARB = pointerBuffer.get(1348);
        this.glGetAttachedObjectsARB = pointerBuffer.get(1349);
        this.glGetUniformLocationARB = pointerBuffer.get(1350);
        this.glGetActiveUniformARB = pointerBuffer.get(1351);
        this.glGetUniformfvARB = pointerBuffer.get(1352);
        this.glGetUniformivARB = pointerBuffer.get(1353);
        this.glGetShaderSourceARB = pointerBuffer.get(1354);
        this.glNamedStringARB = pointerBuffer.get(1355);
        this.glDeleteNamedStringARB = pointerBuffer.get(1356);
        this.glCompileShaderIncludeARB = pointerBuffer.get(1357);
        this.glIsNamedStringARB = pointerBuffer.get(1358);
        this.glGetNamedStringARB = pointerBuffer.get(1359);
        this.glGetNamedStringivARB = pointerBuffer.get(1360);
        this.glBufferPageCommitmentARB = pointerBuffer.get(1361);
        this.glNamedBufferPageCommitmentEXT = pointerBuffer.get(1362);
        this.glNamedBufferPageCommitmentARB = pointerBuffer.get(1363);
        this.glTexPageCommitmentARB = pointerBuffer.get(1364);
        this.glTexturePageCommitmentEXT = pointerBuffer.get(1365);
        this.glTexBufferARB = pointerBuffer.get(1366);
        this.glTextureBufferRangeEXT = pointerBuffer.get(1367);
        this.glCompressedTexImage3DARB = pointerBuffer.get(1368);
        this.glCompressedTexImage2DARB = pointerBuffer.get(1369);
        this.glCompressedTexImage1DARB = pointerBuffer.get(1370);
        this.glCompressedTexSubImage3DARB = pointerBuffer.get(1371);
        this.glCompressedTexSubImage2DARB = pointerBuffer.get(1372);
        this.glCompressedTexSubImage1DARB = pointerBuffer.get(1373);
        this.glGetCompressedTexImageARB = pointerBuffer.get(1374);
        this.glTextureStorage1DEXT = pointerBuffer.get(1375);
        this.glTextureStorage2DEXT = pointerBuffer.get(1376);
        this.glTextureStorage3DEXT = pointerBuffer.get(1377);
        this.glTextureStorage2DMultisampleEXT = pointerBuffer.get(1378);
        this.glTextureStorage3DMultisampleEXT = pointerBuffer.get(1379);
        this.glLoadTransposeMatrixfARB = pointerBuffer.get(1380);
        this.glLoadTransposeMatrixdARB = pointerBuffer.get(1381);
        this.glMultTransposeMatrixfARB = pointerBuffer.get(1382);
        this.glMultTransposeMatrixdARB = pointerBuffer.get(1383);
        this.glVertexArrayVertexAttribLOffsetEXT = pointerBuffer.get(1384);
        this.glVertexArrayBindVertexBufferEXT = pointerBuffer.get(1385);
        this.glVertexArrayVertexAttribFormatEXT = pointerBuffer.get(1386);
        this.glVertexArrayVertexAttribIFormatEXT = pointerBuffer.get(1387);
        this.glVertexArrayVertexAttribLFormatEXT = pointerBuffer.get(1388);
        this.glVertexArrayVertexAttribBindingEXT = pointerBuffer.get(1389);
        this.glVertexArrayVertexBindingDivisorEXT = pointerBuffer.get(1390);
        this.glWeightfvARB = pointerBuffer.get(1391);
        this.glWeightbvARB = pointerBuffer.get(1392);
        this.glWeightubvARB = pointerBuffer.get(1393);
        this.glWeightsvARB = pointerBuffer.get(1394);
        this.glWeightusvARB = pointerBuffer.get(1395);
        this.glWeightivARB = pointerBuffer.get(1396);
        this.glWeightuivARB = pointerBuffer.get(1397);
        this.glWeightdvARB = pointerBuffer.get(1398);
        this.glWeightPointerARB = pointerBuffer.get(1399);
        this.glVertexBlendARB = pointerBuffer.get(1400);
        this.glBindBufferARB = pointerBuffer.get(1401);
        this.glDeleteBuffersARB = pointerBuffer.get(1402);
        this.glGenBuffersARB = pointerBuffer.get(1403);
        this.glIsBufferARB = pointerBuffer.get(1404);
        this.glBufferDataARB = pointerBuffer.get(1405);
        this.glBufferSubDataARB = pointerBuffer.get(1406);
        this.glGetBufferSubDataARB = pointerBuffer.get(1407);
        this.glMapBufferARB = pointerBuffer.get(1408);
        this.glUnmapBufferARB = pointerBuffer.get(1409);
        this.glGetBufferParameterivARB = pointerBuffer.get(1410);
        this.glGetBufferPointervARB = pointerBuffer.get(1411);
        this.glVertexAttrib1sARB = pointerBuffer.get(1412);
        this.glVertexAttrib1fARB = pointerBuffer.get(1413);
        this.glVertexAttrib1dARB = pointerBuffer.get(1414);
        this.glVertexAttrib2sARB = pointerBuffer.get(1415);
        this.glVertexAttrib2fARB = pointerBuffer.get(1416);
        this.glVertexAttrib2dARB = pointerBuffer.get(1417);
        this.glVertexAttrib3sARB = pointerBuffer.get(1418);
        this.glVertexAttrib3fARB = pointerBuffer.get(1419);
        this.glVertexAttrib3dARB = pointerBuffer.get(1420);
        this.glVertexAttrib4sARB = pointerBuffer.get(1421);
        this.glVertexAttrib4fARB = pointerBuffer.get(1422);
        this.glVertexAttrib4dARB = pointerBuffer.get(1423);
        this.glVertexAttrib4NubARB = pointerBuffer.get(1424);
        this.glVertexAttrib1svARB = pointerBuffer.get(1425);
        this.glVertexAttrib1fvARB = pointerBuffer.get(1426);
        this.glVertexAttrib1dvARB = pointerBuffer.get(1427);
        this.glVertexAttrib2svARB = pointerBuffer.get(1428);
        this.glVertexAttrib2fvARB = pointerBuffer.get(1429);
        this.glVertexAttrib2dvARB = pointerBuffer.get(1430);
        this.glVertexAttrib3svARB = pointerBuffer.get(1431);
        this.glVertexAttrib3fvARB = pointerBuffer.get(1432);
        this.glVertexAttrib3dvARB = pointerBuffer.get(1433);
        this.glVertexAttrib4fvARB = pointerBuffer.get(1434);
        this.glVertexAttrib4bvARB = pointerBuffer.get(1435);
        this.glVertexAttrib4svARB = pointerBuffer.get(1436);
        this.glVertexAttrib4ivARB = pointerBuffer.get(1437);
        this.glVertexAttrib4ubvARB = pointerBuffer.get(1438);
        this.glVertexAttrib4usvARB = pointerBuffer.get(1439);
        this.glVertexAttrib4uivARB = pointerBuffer.get(1440);
        this.glVertexAttrib4dvARB = pointerBuffer.get(1441);
        this.glVertexAttrib4NbvARB = pointerBuffer.get(1442);
        this.glVertexAttrib4NsvARB = pointerBuffer.get(1443);
        this.glVertexAttrib4NivARB = pointerBuffer.get(1444);
        this.glVertexAttrib4NubvARB = pointerBuffer.get(1445);
        this.glVertexAttrib4NusvARB = pointerBuffer.get(1446);
        this.glVertexAttrib4NuivARB = pointerBuffer.get(1447);
        this.glVertexAttribPointerARB = pointerBuffer.get(1448);
        this.glEnableVertexAttribArrayARB = pointerBuffer.get(1449);
        this.glDisableVertexAttribArrayARB = pointerBuffer.get(1450);
        this.glProgramStringARB = pointerBuffer.get(1451);
        this.glBindProgramARB = pointerBuffer.get(1452);
        this.glDeleteProgramsARB = pointerBuffer.get(1453);
        this.glGenProgramsARB = pointerBuffer.get(1454);
        this.glProgramEnvParameter4dARB = pointerBuffer.get(1455);
        this.glProgramEnvParameter4dvARB = pointerBuffer.get(1456);
        this.glProgramEnvParameter4fARB = pointerBuffer.get(1457);
        this.glProgramEnvParameter4fvARB = pointerBuffer.get(1458);
        this.glProgramLocalParameter4dARB = pointerBuffer.get(1459);
        this.glProgramLocalParameter4dvARB = pointerBuffer.get(1460);
        this.glProgramLocalParameter4fARB = pointerBuffer.get(1461);
        this.glProgramLocalParameter4fvARB = pointerBuffer.get(1462);
        this.glGetProgramEnvParameterfvARB = pointerBuffer.get(1463);
        this.glGetProgramEnvParameterdvARB = pointerBuffer.get(1464);
        this.glGetProgramLocalParameterfvARB = pointerBuffer.get(1465);
        this.glGetProgramLocalParameterdvARB = pointerBuffer.get(1466);
        this.glGetProgramivARB = pointerBuffer.get(1467);
        this.glGetProgramStringARB = pointerBuffer.get(1468);
        this.glGetVertexAttribfvARB = pointerBuffer.get(1469);
        this.glGetVertexAttribdvARB = pointerBuffer.get(1470);
        this.glGetVertexAttribivARB = pointerBuffer.get(1471);
        this.glGetVertexAttribPointervARB = pointerBuffer.get(1472);
        this.glIsProgramARB = pointerBuffer.get(1473);
        this.glBindAttribLocationARB = pointerBuffer.get(1474);
        this.glGetActiveAttribARB = pointerBuffer.get(1475);
        this.glGetAttribLocationARB = pointerBuffer.get(1476);
        this.glWindowPos2iARB = pointerBuffer.get(1477);
        this.glWindowPos2sARB = pointerBuffer.get(1478);
        this.glWindowPos2fARB = pointerBuffer.get(1479);
        this.glWindowPos2dARB = pointerBuffer.get(1480);
        this.glWindowPos2ivARB = pointerBuffer.get(1481);
        this.glWindowPos2svARB = pointerBuffer.get(1482);
        this.glWindowPos2fvARB = pointerBuffer.get(1483);
        this.glWindowPos2dvARB = pointerBuffer.get(1484);
        this.glWindowPos3iARB = pointerBuffer.get(1485);
        this.glWindowPos3sARB = pointerBuffer.get(1486);
        this.glWindowPos3fARB = pointerBuffer.get(1487);
        this.glWindowPos3dARB = pointerBuffer.get(1488);
        this.glWindowPos3ivARB = pointerBuffer.get(1489);
        this.glWindowPos3svARB = pointerBuffer.get(1490);
        this.glWindowPos3fvARB = pointerBuffer.get(1491);
        this.glWindowPos3dvARB = pointerBuffer.get(1492);
        this.glUniformBufferEXT = pointerBuffer.get(1493);
        this.glGetUniformBufferSizeEXT = pointerBuffer.get(1494);
        this.glGetUniformOffsetEXT = pointerBuffer.get(1495);
        this.glBlendColorEXT = pointerBuffer.get(1496);
        this.glBlendEquationSeparateEXT = pointerBuffer.get(1497);
        this.glBlendFuncSeparateEXT = pointerBuffer.get(1498);
        this.glBlendEquationEXT = pointerBuffer.get(1499);
        this.glLockArraysEXT = pointerBuffer.get(1500);
        this.glUnlockArraysEXT = pointerBuffer.get(1501);
        this.glLabelObjectEXT = pointerBuffer.get(1502);
        this.glGetObjectLabelEXT = pointerBuffer.get(1503);
        this.glInsertEventMarkerEXT = pointerBuffer.get(1504);
        this.glPushGroupMarkerEXT = pointerBuffer.get(1505);
        this.glPopGroupMarkerEXT = pointerBuffer.get(1506);
        this.glDepthBoundsEXT = pointerBuffer.get(1507);
        this.glClientAttribDefaultEXT = pointerBuffer.get(1508);
        this.glPushClientAttribDefaultEXT = pointerBuffer.get(1509);
        this.glMatrixLoadfEXT = pointerBuffer.get(1510);
        this.glMatrixLoaddEXT = pointerBuffer.get(1511);
        this.glMatrixMultfEXT = pointerBuffer.get(1512);
        this.glMatrixMultdEXT = pointerBuffer.get(1513);
        this.glMatrixLoadIdentityEXT = pointerBuffer.get(1514);
        this.glMatrixRotatefEXT = pointerBuffer.get(1515);
        this.glMatrixRotatedEXT = pointerBuffer.get(1516);
        this.glMatrixScalefEXT = pointerBuffer.get(1517);
        this.glMatrixScaledEXT = pointerBuffer.get(1518);
        this.glMatrixTranslatefEXT = pointerBuffer.get(1519);
        this.glMatrixTranslatedEXT = pointerBuffer.get(1520);
        this.glMatrixOrthoEXT = pointerBuffer.get(1521);
        this.glMatrixFrustumEXT = pointerBuffer.get(1522);
        this.glMatrixPushEXT = pointerBuffer.get(1523);
        this.glMatrixPopEXT = pointerBuffer.get(1524);
        this.glTextureParameteriEXT = pointerBuffer.get(1525);
        this.glTextureParameterivEXT = pointerBuffer.get(1526);
        this.glTextureParameterfEXT = pointerBuffer.get(1527);
        this.glTextureParameterfvEXT = pointerBuffer.get(1528);
        this.glTextureImage1DEXT = pointerBuffer.get(1529);
        this.glTextureImage2DEXT = pointerBuffer.get(1530);
        this.glTextureSubImage1DEXT = pointerBuffer.get(1531);
        this.glTextureSubImage2DEXT = pointerBuffer.get(1532);
        this.glCopyTextureImage1DEXT = pointerBuffer.get(1533);
        this.glCopyTextureImage2DEXT = pointerBuffer.get(1534);
        this.glCopyTextureSubImage1DEXT = pointerBuffer.get(1535);
        this.glCopyTextureSubImage2DEXT = pointerBuffer.get(1536);
        this.glGetTextureImageEXT = pointerBuffer.get(1537);
        this.glGetTextureParameterfvEXT = pointerBuffer.get(1538);
        this.glGetTextureParameterivEXT = pointerBuffer.get(1539);
        this.glGetTextureLevelParameterfvEXT = pointerBuffer.get(1540);
        this.glGetTextureLevelParameterivEXT = pointerBuffer.get(1541);
        this.glTextureImage3DEXT = pointerBuffer.get(1542);
        this.glTextureSubImage3DEXT = pointerBuffer.get(1543);
        this.glCopyTextureSubImage3DEXT = pointerBuffer.get(1544);
        this.glBindMultiTextureEXT = pointerBuffer.get(1545);
        this.glMultiTexCoordPointerEXT = pointerBuffer.get(1546);
        this.glMultiTexEnvfEXT = pointerBuffer.get(1547);
        this.glMultiTexEnvfvEXT = pointerBuffer.get(1548);
        this.glMultiTexEnviEXT = pointerBuffer.get(1549);
        this.glMultiTexEnvivEXT = pointerBuffer.get(1550);
        this.glMultiTexGendEXT = pointerBuffer.get(1551);
        this.glMultiTexGendvEXT = pointerBuffer.get(1552);
        this.glMultiTexGenfEXT = pointerBuffer.get(1553);
        this.glMultiTexGenfvEXT = pointerBuffer.get(1554);
        this.glMultiTexGeniEXT = pointerBuffer.get(1555);
        this.glMultiTexGenivEXT = pointerBuffer.get(1556);
        this.glGetMultiTexEnvfvEXT = pointerBuffer.get(1557);
        this.glGetMultiTexEnvivEXT = pointerBuffer.get(1558);
        this.glGetMultiTexGendvEXT = pointerBuffer.get(1559);
        this.glGetMultiTexGenfvEXT = pointerBuffer.get(1560);
        this.glGetMultiTexGenivEXT = pointerBuffer.get(1561);
        this.glMultiTexParameteriEXT = pointerBuffer.get(1562);
        this.glMultiTexParameterivEXT = pointerBuffer.get(1563);
        this.glMultiTexParameterfEXT = pointerBuffer.get(1564);
        this.glMultiTexParameterfvEXT = pointerBuffer.get(1565);
        this.glMultiTexImage1DEXT = pointerBuffer.get(1566);
        this.glMultiTexImage2DEXT = pointerBuffer.get(1567);
        this.glMultiTexSubImage1DEXT = pointerBuffer.get(1568);
        this.glMultiTexSubImage2DEXT = pointerBuffer.get(1569);
        this.glCopyMultiTexImage1DEXT = pointerBuffer.get(1570);
        this.glCopyMultiTexImage2DEXT = pointerBuffer.get(1571);
        this.glCopyMultiTexSubImage1DEXT = pointerBuffer.get(1572);
        this.glCopyMultiTexSubImage2DEXT = pointerBuffer.get(1573);
        this.glGetMultiTexImageEXT = pointerBuffer.get(1574);
        this.glGetMultiTexParameterfvEXT = pointerBuffer.get(1575);
        this.glGetMultiTexParameterivEXT = pointerBuffer.get(1576);
        this.glGetMultiTexLevelParameterfvEXT = pointerBuffer.get(1577);
        this.glGetMultiTexLevelParameterivEXT = pointerBuffer.get(1578);
        this.glMultiTexImage3DEXT = pointerBuffer.get(1579);
        this.glMultiTexSubImage3DEXT = pointerBuffer.get(1580);
        this.glCopyMultiTexSubImage3DEXT = pointerBuffer.get(1581);
        this.glEnableClientStateIndexedEXT = pointerBuffer.get(1582);
        this.glDisableClientStateIndexedEXT = pointerBuffer.get(1583);
        this.glEnableClientStateiEXT = pointerBuffer.get(1584);
        this.glDisableClientStateiEXT = pointerBuffer.get(1585);
        this.glGetFloatIndexedvEXT = pointerBuffer.get(1586);
        this.glGetDoubleIndexedvEXT = pointerBuffer.get(1587);
        this.glGetPointerIndexedvEXT = pointerBuffer.get(1588);
        this.glGetFloati_vEXT = pointerBuffer.get(1589);
        this.glGetDoublei_vEXT = pointerBuffer.get(1590);
        this.glGetPointeri_vEXT = pointerBuffer.get(1591);
        this.glEnableIndexedEXT = pointerBuffer.get(1592);
        this.glDisableIndexedEXT = pointerBuffer.get(1593);
        this.glIsEnabledIndexedEXT = pointerBuffer.get(1594);
        this.glGetIntegerIndexedvEXT = pointerBuffer.get(1595);
        this.glGetBooleanIndexedvEXT = pointerBuffer.get(1596);
        this.glNamedProgramStringEXT = pointerBuffer.get(1597);
        this.glNamedProgramLocalParameter4dEXT = pointerBuffer.get(1598);
        this.glNamedProgramLocalParameter4dvEXT = pointerBuffer.get(1599);
        this.glNamedProgramLocalParameter4fEXT = pointerBuffer.get(1600);
        this.glNamedProgramLocalParameter4fvEXT = pointerBuffer.get(1601);
        this.glGetNamedProgramLocalParameterdvEXT = pointerBuffer.get(1602);
        this.glGetNamedProgramLocalParameterfvEXT = pointerBuffer.get(1603);
        this.glGetNamedProgramivEXT = pointerBuffer.get(1604);
        this.glGetNamedProgramStringEXT = pointerBuffer.get(1605);
        this.glCompressedTextureImage3DEXT = pointerBuffer.get(1606);
        this.glCompressedTextureImage2DEXT = pointerBuffer.get(1607);
        this.glCompressedTextureImage1DEXT = pointerBuffer.get(1608);
        this.glCompressedTextureSubImage3DEXT = pointerBuffer.get(1609);
        this.glCompressedTextureSubImage2DEXT = pointerBuffer.get(1610);
        this.glCompressedTextureSubImage1DEXT = pointerBuffer.get(1611);
        this.glGetCompressedTextureImageEXT = pointerBuffer.get(1612);
        this.glCompressedMultiTexImage3DEXT = pointerBuffer.get(1613);
        this.glCompressedMultiTexImage2DEXT = pointerBuffer.get(1614);
        this.glCompressedMultiTexImage1DEXT = pointerBuffer.get(1615);
        this.glCompressedMultiTexSubImage3DEXT = pointerBuffer.get(1616);
        this.glCompressedMultiTexSubImage2DEXT = pointerBuffer.get(1617);
        this.glCompressedMultiTexSubImage1DEXT = pointerBuffer.get(1618);
        this.glGetCompressedMultiTexImageEXT = pointerBuffer.get(1619);
        this.glMatrixLoadTransposefEXT = pointerBuffer.get(1620);
        this.glMatrixLoadTransposedEXT = pointerBuffer.get(1621);
        this.glMatrixMultTransposefEXT = pointerBuffer.get(1622);
        this.glMatrixMultTransposedEXT = pointerBuffer.get(1623);
        this.glNamedBufferDataEXT = pointerBuffer.get(1624);
        this.glNamedBufferSubDataEXT = pointerBuffer.get(1625);
        this.glMapNamedBufferEXT = pointerBuffer.get(1626);
        this.glUnmapNamedBufferEXT = pointerBuffer.get(1627);
        this.glGetNamedBufferParameterivEXT = pointerBuffer.get(1628);
        this.glGetNamedBufferSubDataEXT = pointerBuffer.get(1629);
        this.glProgramUniform1fEXT = pointerBuffer.get(1630);
        this.glProgramUniform2fEXT = pointerBuffer.get(1631);
        this.glProgramUniform3fEXT = pointerBuffer.get(1632);
        this.glProgramUniform4fEXT = pointerBuffer.get(1633);
        this.glProgramUniform1iEXT = pointerBuffer.get(1634);
        this.glProgramUniform2iEXT = pointerBuffer.get(1635);
        this.glProgramUniform3iEXT = pointerBuffer.get(1636);
        this.glProgramUniform4iEXT = pointerBuffer.get(1637);
        this.glProgramUniform1fvEXT = pointerBuffer.get(1638);
        this.glProgramUniform2fvEXT = pointerBuffer.get(1639);
        this.glProgramUniform3fvEXT = pointerBuffer.get(1640);
        this.glProgramUniform4fvEXT = pointerBuffer.get(1641);
        this.glProgramUniform1ivEXT = pointerBuffer.get(1642);
        this.glProgramUniform2ivEXT = pointerBuffer.get(1643);
        this.glProgramUniform3ivEXT = pointerBuffer.get(1644);
        this.glProgramUniform4ivEXT = pointerBuffer.get(1645);
        this.glProgramUniformMatrix2fvEXT = pointerBuffer.get(1646);
        this.glProgramUniformMatrix3fvEXT = pointerBuffer.get(1647);
        this.glProgramUniformMatrix4fvEXT = pointerBuffer.get(1648);
        this.glProgramUniformMatrix2x3fvEXT = pointerBuffer.get(1649);
        this.glProgramUniformMatrix3x2fvEXT = pointerBuffer.get(1650);
        this.glProgramUniformMatrix2x4fvEXT = pointerBuffer.get(1651);
        this.glProgramUniformMatrix4x2fvEXT = pointerBuffer.get(1652);
        this.glProgramUniformMatrix3x4fvEXT = pointerBuffer.get(1653);
        this.glProgramUniformMatrix4x3fvEXT = pointerBuffer.get(1654);
        this.glTextureBufferEXT = pointerBuffer.get(1655);
        this.glMultiTexBufferEXT = pointerBuffer.get(1656);
        this.glTextureParameterIivEXT = pointerBuffer.get(1657);
        this.glTextureParameterIuivEXT = pointerBuffer.get(1658);
        this.glGetTextureParameterIivEXT = pointerBuffer.get(1659);
        this.glGetTextureParameterIuivEXT = pointerBuffer.get(1660);
        this.glMultiTexParameterIivEXT = pointerBuffer.get(1661);
        this.glMultiTexParameterIuivEXT = pointerBuffer.get(1662);
        this.glGetMultiTexParameterIivEXT = pointerBuffer.get(1663);
        this.glGetMultiTexParameterIuivEXT = pointerBuffer.get(1664);
        this.glProgramUniform1uiEXT = pointerBuffer.get(1665);
        this.glProgramUniform2uiEXT = pointerBuffer.get(1666);
        this.glProgramUniform3uiEXT = pointerBuffer.get(1667);
        this.glProgramUniform4uiEXT = pointerBuffer.get(1668);
        this.glProgramUniform1uivEXT = pointerBuffer.get(1669);
        this.glProgramUniform2uivEXT = pointerBuffer.get(1670);
        this.glProgramUniform3uivEXT = pointerBuffer.get(1671);
        this.glProgramUniform4uivEXT = pointerBuffer.get(1672);
        this.glNamedProgramLocalParameters4fvEXT = pointerBuffer.get(1673);
        this.glNamedProgramLocalParameterI4iEXT = pointerBuffer.get(1674);
        this.glNamedProgramLocalParameterI4ivEXT = pointerBuffer.get(1675);
        this.glNamedProgramLocalParametersI4ivEXT = pointerBuffer.get(1676);
        this.glNamedProgramLocalParameterI4uiEXT = pointerBuffer.get(1677);
        this.glNamedProgramLocalParameterI4uivEXT = pointerBuffer.get(1678);
        this.glNamedProgramLocalParametersI4uivEXT = pointerBuffer.get(1679);
        this.glGetNamedProgramLocalParameterIivEXT = pointerBuffer.get(1680);
        this.glGetNamedProgramLocalParameterIuivEXT = pointerBuffer.get(1681);
        this.glNamedRenderbufferStorageEXT = pointerBuffer.get(1682);
        this.glGetNamedRenderbufferParameterivEXT = pointerBuffer.get(1683);
        this.glNamedRenderbufferStorageMultisampleEXT = pointerBuffer.get(1684);
        this.glNamedRenderbufferStorageMultisampleCoverageEXT = pointerBuffer.get(1685);
        this.glCheckNamedFramebufferStatusEXT = pointerBuffer.get(1686);
        this.glNamedFramebufferTexture1DEXT = pointerBuffer.get(1687);
        this.glNamedFramebufferTexture2DEXT = pointerBuffer.get(1688);
        this.glNamedFramebufferTexture3DEXT = pointerBuffer.get(1689);
        this.glNamedFramebufferRenderbufferEXT = pointerBuffer.get(1690);
        this.glGetNamedFramebufferAttachmentParameterivEXT = pointerBuffer.get(1691);
        this.glGenerateTextureMipmapEXT = pointerBuffer.get(1692);
        this.glGenerateMultiTexMipmapEXT = pointerBuffer.get(1693);
        this.glFramebufferDrawBufferEXT = pointerBuffer.get(1694);
        this.glFramebufferDrawBuffersEXT = pointerBuffer.get(1695);
        this.glFramebufferReadBufferEXT = pointerBuffer.get(1696);
        this.glGetFramebufferParameterivEXT = pointerBuffer.get(1697);
        this.glNamedCopyBufferSubDataEXT = pointerBuffer.get(1698);
        this.glNamedFramebufferTextureEXT = pointerBuffer.get(1699);
        this.glNamedFramebufferTextureLayerEXT = pointerBuffer.get(1700);
        this.glNamedFramebufferTextureFaceEXT = pointerBuffer.get(1701);
        this.glTextureRenderbufferEXT = pointerBuffer.get(1702);
        this.glMultiTexRenderbufferEXT = pointerBuffer.get(1703);
        this.glVertexArrayVertexOffsetEXT = pointerBuffer.get(1704);
        this.glVertexArrayColorOffsetEXT = pointerBuffer.get(1705);
        this.glVertexArrayEdgeFlagOffsetEXT = pointerBuffer.get(1706);
        this.glVertexArrayIndexOffsetEXT = pointerBuffer.get(1707);
        this.glVertexArrayNormalOffsetEXT = pointerBuffer.get(1708);
        this.glVertexArrayTexCoordOffsetEXT = pointerBuffer.get(1709);
        this.glVertexArrayMultiTexCoordOffsetEXT = pointerBuffer.get(1710);
        this.glVertexArrayFogCoordOffsetEXT = pointerBuffer.get(1711);
        this.glVertexArraySecondaryColorOffsetEXT = pointerBuffer.get(1712);
        this.glVertexArrayVertexAttribOffsetEXT = pointerBuffer.get(1713);
        this.glVertexArrayVertexAttribIOffsetEXT = pointerBuffer.get(1714);
        this.glEnableVertexArrayEXT = pointerBuffer.get(1715);
        this.glDisableVertexArrayEXT = pointerBuffer.get(1716);
        this.glEnableVertexArrayAttribEXT = pointerBuffer.get(1717);
        this.glDisableVertexArrayAttribEXT = pointerBuffer.get(1718);
        this.glGetVertexArrayIntegervEXT = pointerBuffer.get(1719);
        this.glGetVertexArrayPointervEXT = pointerBuffer.get(1720);
        this.glGetVertexArrayIntegeri_vEXT = pointerBuffer.get(1721);
        this.glGetVertexArrayPointeri_vEXT = pointerBuffer.get(1722);
        this.glMapNamedBufferRangeEXT = pointerBuffer.get(1723);
        this.glFlushMappedNamedBufferRangeEXT = pointerBuffer.get(1724);
        this.glColorMaskIndexedEXT = pointerBuffer.get(1725);
        this.glDrawArraysInstancedEXT = pointerBuffer.get(1726);
        this.glDrawElementsInstancedEXT = pointerBuffer.get(1727);
        this.glEGLImageTargetTexStorageEXT = pointerBuffer.get(1728);
        this.glEGLImageTargetTextureStorageEXT = pointerBuffer.get(1729);
        this.glBufferStorageExternalEXT = pointerBuffer.get(1730);
        this.glNamedBufferStorageExternalEXT = pointerBuffer.get(1731);
        this.glBlitFramebufferEXT = pointerBuffer.get(1732);
        this.glRenderbufferStorageMultisampleEXT = pointerBuffer.get(1733);
        this.glIsRenderbufferEXT = pointerBuffer.get(1734);
        this.glBindRenderbufferEXT = pointerBuffer.get(1735);
        this.glDeleteRenderbuffersEXT = pointerBuffer.get(1736);
        this.glGenRenderbuffersEXT = pointerBuffer.get(1737);
        this.glRenderbufferStorageEXT = pointerBuffer.get(1738);
        this.glGetRenderbufferParameterivEXT = pointerBuffer.get(1739);
        this.glIsFramebufferEXT = pointerBuffer.get(1740);
        this.glBindFramebufferEXT = pointerBuffer.get(1741);
        this.glDeleteFramebuffersEXT = pointerBuffer.get(1742);
        this.glGenFramebuffersEXT = pointerBuffer.get(1743);
        this.glCheckFramebufferStatusEXT = pointerBuffer.get(1744);
        this.glFramebufferTexture1DEXT = pointerBuffer.get(1745);
        this.glFramebufferTexture2DEXT = pointerBuffer.get(1746);
        this.glFramebufferTexture3DEXT = pointerBuffer.get(1747);
        this.glFramebufferRenderbufferEXT = pointerBuffer.get(1748);
        this.glGetFramebufferAttachmentParameterivEXT = pointerBuffer.get(1749);
        this.glGenerateMipmapEXT = pointerBuffer.get(1750);
        this.glProgramParameteriEXT = pointerBuffer.get(1751);
        this.glFramebufferTextureEXT = pointerBuffer.get(1752);
        this.glFramebufferTextureLayerEXT = pointerBuffer.get(1753);
        this.glFramebufferTextureFaceEXT = pointerBuffer.get(1754);
        this.glProgramEnvParameters4fvEXT = pointerBuffer.get(1755);
        this.glProgramLocalParameters4fvEXT = pointerBuffer.get(1756);
        this.glVertexAttribI1iEXT = pointerBuffer.get(1757);
        this.glVertexAttribI2iEXT = pointerBuffer.get(1758);
        this.glVertexAttribI3iEXT = pointerBuffer.get(1759);
        this.glVertexAttribI4iEXT = pointerBuffer.get(1760);
        this.glVertexAttribI1uiEXT = pointerBuffer.get(1761);
        this.glVertexAttribI2uiEXT = pointerBuffer.get(1762);
        this.glVertexAttribI3uiEXT = pointerBuffer.get(1763);
        this.glVertexAttribI4uiEXT = pointerBuffer.get(1764);
        this.glVertexAttribI1ivEXT = pointerBuffer.get(1765);
        this.glVertexAttribI2ivEXT = pointerBuffer.get(1766);
        this.glVertexAttribI3ivEXT = pointerBuffer.get(1767);
        this.glVertexAttribI4ivEXT = pointerBuffer.get(1768);
        this.glVertexAttribI1uivEXT = pointerBuffer.get(1769);
        this.glVertexAttribI2uivEXT = pointerBuffer.get(1770);
        this.glVertexAttribI3uivEXT = pointerBuffer.get(1771);
        this.glVertexAttribI4uivEXT = pointerBuffer.get(1772);
        this.glVertexAttribI4bvEXT = pointerBuffer.get(1773);
        this.glVertexAttribI4svEXT = pointerBuffer.get(1774);
        this.glVertexAttribI4ubvEXT = pointerBuffer.get(1775);
        this.glVertexAttribI4usvEXT = pointerBuffer.get(1776);
        this.glVertexAttribIPointerEXT = pointerBuffer.get(1777);
        this.glGetVertexAttribIivEXT = pointerBuffer.get(1778);
        this.glGetVertexAttribIuivEXT = pointerBuffer.get(1779);
        this.glGetUniformuivEXT = pointerBuffer.get(1780);
        this.glBindFragDataLocationEXT = pointerBuffer.get(1781);
        this.glGetFragDataLocationEXT = pointerBuffer.get(1782);
        this.glUniform1uiEXT = pointerBuffer.get(1783);
        this.glUniform2uiEXT = pointerBuffer.get(1784);
        this.glUniform3uiEXT = pointerBuffer.get(1785);
        this.glUniform4uiEXT = pointerBuffer.get(1786);
        this.glUniform1uivEXT = pointerBuffer.get(1787);
        this.glUniform2uivEXT = pointerBuffer.get(1788);
        this.glUniform3uivEXT = pointerBuffer.get(1789);
        this.glUniform4uivEXT = pointerBuffer.get(1790);
        this.glGetUnsignedBytevEXT = pointerBuffer.get(1791);
        this.glGetUnsignedBytei_vEXT = pointerBuffer.get(1792);
        this.glDeleteMemoryObjectsEXT = pointerBuffer.get(1793);
        this.glIsMemoryObjectEXT = pointerBuffer.get(1794);
        this.glCreateMemoryObjectsEXT = pointerBuffer.get(1795);
        this.glMemoryObjectParameterivEXT = pointerBuffer.get(1796);
        this.glGetMemoryObjectParameterivEXT = pointerBuffer.get(1797);
        this.glTexStorageMem2DEXT = pointerBuffer.get(1798);
        this.glTexStorageMem2DMultisampleEXT = pointerBuffer.get(1799);
        this.glTexStorageMem3DEXT = pointerBuffer.get(1800);
        this.glTexStorageMem3DMultisampleEXT = pointerBuffer.get(1801);
        this.glBufferStorageMemEXT = pointerBuffer.get(1802);
        this.glTextureStorageMem2DEXT = pointerBuffer.get(1803);
        this.glTextureStorageMem2DMultisampleEXT = pointerBuffer.get(1804);
        this.glTextureStorageMem3DEXT = pointerBuffer.get(1805);
        this.glTextureStorageMem3DMultisampleEXT = pointerBuffer.get(1806);
        this.glNamedBufferStorageMemEXT = pointerBuffer.get(1807);
        this.glTexStorageMem1DEXT = pointerBuffer.get(1808);
        this.glTextureStorageMem1DEXT = pointerBuffer.get(1809);
        this.glImportMemoryFdEXT = pointerBuffer.get(1810);
        this.glImportMemoryWin32HandleEXT = pointerBuffer.get(1811);
        this.glImportMemoryWin32NameEXT = pointerBuffer.get(1812);
        this.glPointParameterfEXT = pointerBuffer.get(1813);
        this.glPointParameterfvEXT = pointerBuffer.get(1814);
        this.glPolygonOffsetClampEXT = pointerBuffer.get(1815);
        this.glProvokingVertexEXT = pointerBuffer.get(1816);
        this.glRasterSamplesEXT = pointerBuffer.get(1817);
        this.glSecondaryColor3bEXT = pointerBuffer.get(1818);
        this.glSecondaryColor3sEXT = pointerBuffer.get(1819);
        this.glSecondaryColor3iEXT = pointerBuffer.get(1820);
        this.glSecondaryColor3fEXT = pointerBuffer.get(1821);
        this.glSecondaryColor3dEXT = pointerBuffer.get(1822);
        this.glSecondaryColor3ubEXT = pointerBuffer.get(1823);
        this.glSecondaryColor3usEXT = pointerBuffer.get(1824);
        this.glSecondaryColor3uiEXT = pointerBuffer.get(1825);
        this.glSecondaryColor3bvEXT = pointerBuffer.get(1826);
        this.glSecondaryColor3svEXT = pointerBuffer.get(1827);
        this.glSecondaryColor3ivEXT = pointerBuffer.get(1828);
        this.glSecondaryColor3fvEXT = pointerBuffer.get(1829);
        this.glSecondaryColor3dvEXT = pointerBuffer.get(1830);
        this.glSecondaryColor3ubvEXT = pointerBuffer.get(1831);
        this.glSecondaryColor3usvEXT = pointerBuffer.get(1832);
        this.glSecondaryColor3uivEXT = pointerBuffer.get(1833);
        this.glSecondaryColorPointerEXT = pointerBuffer.get(1834);
        this.glGenSemaphoresEXT = pointerBuffer.get(1835);
        this.glDeleteSemaphoresEXT = pointerBuffer.get(1836);
        this.glIsSemaphoreEXT = pointerBuffer.get(1837);
        this.glSemaphoreParameterui64vEXT = pointerBuffer.get(1838);
        this.glGetSemaphoreParameterui64vEXT = pointerBuffer.get(1839);
        this.glWaitSemaphoreEXT = pointerBuffer.get(1840);
        this.glSignalSemaphoreEXT = pointerBuffer.get(1841);
        this.glImportSemaphoreFdEXT = pointerBuffer.get(1842);
        this.glImportSemaphoreWin32HandleEXT = pointerBuffer.get(1843);
        this.glImportSemaphoreWin32NameEXT = pointerBuffer.get(1844);
        this.glUseShaderProgramEXT = pointerBuffer.get(1845);
        this.glActiveProgramEXT = pointerBuffer.get(1846);
        this.glCreateShaderProgramEXT = pointerBuffer.get(1847);
        this.glFramebufferFetchBarrierEXT = pointerBuffer.get(1848);
        this.glBindImageTextureEXT = pointerBuffer.get(1849);
        this.glMemoryBarrierEXT = pointerBuffer.get(1850);
        this.glStencilClearTagEXT = pointerBuffer.get(1851);
        this.glActiveStencilFaceEXT = pointerBuffer.get(1852);
        this.glTexBufferEXT = pointerBuffer.get(1853);
        this.glClearColorIiEXT = pointerBuffer.get(1854);
        this.glClearColorIuiEXT = pointerBuffer.get(1855);
        this.glTexParameterIivEXT = pointerBuffer.get(1856);
        this.glTexParameterIuivEXT = pointerBuffer.get(1857);
        this.glGetTexParameterIivEXT = pointerBuffer.get(1858);
        this.glGetTexParameterIuivEXT = pointerBuffer.get(1859);
        this.glTexStorage1DEXT = pointerBuffer.get(1860);
        this.glTexStorage2DEXT = pointerBuffer.get(1861);
        this.glTexStorage3DEXT = pointerBuffer.get(1862);
        this.glGetQueryObjecti64vEXT = pointerBuffer.get(1863);
        this.glGetQueryObjectui64vEXT = pointerBuffer.get(1864);
        this.glBindBufferRangeEXT = pointerBuffer.get(1865);
        this.glBindBufferOffsetEXT = pointerBuffer.get(1866);
        this.glBindBufferBaseEXT = pointerBuffer.get(1867);
        this.glBeginTransformFeedbackEXT = pointerBuffer.get(1868);
        this.glEndTransformFeedbackEXT = pointerBuffer.get(1869);
        this.glTransformFeedbackVaryingsEXT = pointerBuffer.get(1870);
        this.glGetTransformFeedbackVaryingEXT = pointerBuffer.get(1871);
        this.glVertexAttribL1dEXT = pointerBuffer.get(1872);
        this.glVertexAttribL2dEXT = pointerBuffer.get(1873);
        this.glVertexAttribL3dEXT = pointerBuffer.get(1874);
        this.glVertexAttribL4dEXT = pointerBuffer.get(1875);
        this.glVertexAttribL1dvEXT = pointerBuffer.get(1876);
        this.glVertexAttribL2dvEXT = pointerBuffer.get(1877);
        this.glVertexAttribL3dvEXT = pointerBuffer.get(1878);
        this.glVertexAttribL4dvEXT = pointerBuffer.get(1879);
        this.glVertexAttribLPointerEXT = pointerBuffer.get(1880);
        this.glGetVertexAttribLdvEXT = pointerBuffer.get(1881);
        this.glAcquireKeyedMutexWin32EXT = pointerBuffer.get(1882);
        this.glReleaseKeyedMutexWin32EXT = pointerBuffer.get(1883);
        this.glWindowRectanglesEXT = pointerBuffer.get(1884);
        this.glImportSyncEXT = pointerBuffer.get(1885);
        this.glFrameTerminatorGREMEDY = pointerBuffer.get(1886);
        this.glStringMarkerGREMEDY = pointerBuffer.get(1887);
        this.glApplyFramebufferAttachmentCMAAINTEL = pointerBuffer.get(1888);
        this.glSyncTextureINTEL = pointerBuffer.get(1889);
        this.glUnmapTexture2DINTEL = pointerBuffer.get(1890);
        this.glMapTexture2DINTEL = pointerBuffer.get(1891);
        this.glBeginPerfQueryINTEL = pointerBuffer.get(1892);
        this.glCreatePerfQueryINTEL = pointerBuffer.get(1893);
        this.glDeletePerfQueryINTEL = pointerBuffer.get(1894);
        this.glEndPerfQueryINTEL = pointerBuffer.get(1895);
        this.glGetFirstPerfQueryIdINTEL = pointerBuffer.get(1896);
        this.glGetNextPerfQueryIdINTEL = pointerBuffer.get(1897);
        this.glGetPerfCounterInfoINTEL = pointerBuffer.get(1898);
        this.glGetPerfQueryDataINTEL = pointerBuffer.get(1899);
        this.glGetPerfQueryIdByNameINTEL = pointerBuffer.get(1900);
        this.glGetPerfQueryInfoINTEL = pointerBuffer.get(1901);
        this.glBlendBarrierKHR = pointerBuffer.get(1902);
        this.glMaxShaderCompilerThreadsKHR = pointerBuffer.get(1903);
        this.glFramebufferParameteriMESA = pointerBuffer.get(1904);
        this.glGetFramebufferParameterivMESA = pointerBuffer.get(1905);
        this.glAlphaToCoverageDitherControlNV = pointerBuffer.get(1906);
        this.glMultiDrawArraysIndirectBindlessNV = pointerBuffer.get(1907);
        this.glMultiDrawElementsIndirectBindlessNV = pointerBuffer.get(1908);
        this.glMultiDrawArraysIndirectBindlessCountNV = pointerBuffer.get(1909);
        this.glMultiDrawElementsIndirectBindlessCountNV = pointerBuffer.get(1910);
        this.glGetTextureHandleNV = pointerBuffer.get(1911);
        this.glGetTextureSamplerHandleNV = pointerBuffer.get(1912);
        this.glMakeTextureHandleResidentNV = pointerBuffer.get(1913);
        this.glMakeTextureHandleNonResidentNV = pointerBuffer.get(1914);
        this.glGetImageHandleNV = pointerBuffer.get(1915);
        this.glMakeImageHandleResidentNV = pointerBuffer.get(1916);
        this.glMakeImageHandleNonResidentNV = pointerBuffer.get(1917);
        this.glUniformHandleui64NV = pointerBuffer.get(1918);
        this.glUniformHandleui64vNV = pointerBuffer.get(1919);
        this.glProgramUniformHandleui64NV = pointerBuffer.get(1920);
        this.glProgramUniformHandleui64vNV = pointerBuffer.get(1921);
        this.glIsTextureHandleResidentNV = pointerBuffer.get(1922);
        this.glIsImageHandleResidentNV = pointerBuffer.get(1923);
        this.glBlendParameteriNV = pointerBuffer.get(1924);
        this.glBlendBarrierNV = pointerBuffer.get(1925);
        this.glViewportPositionWScaleNV = pointerBuffer.get(1926);
        this.glCreateStatesNV = pointerBuffer.get(1927);
        this.glDeleteStatesNV = pointerBuffer.get(1928);
        this.glIsStateNV = pointerBuffer.get(1929);
        this.glStateCaptureNV = pointerBuffer.get(1930);
        this.glGetCommandHeaderNV = pointerBuffer.get(1931);
        this.glGetStageIndexNV = pointerBuffer.get(1932);
        this.glDrawCommandsNV = pointerBuffer.get(1933);
        this.glDrawCommandsAddressNV = pointerBuffer.get(1934);
        this.glDrawCommandsStatesNV = pointerBuffer.get(1935);
        this.glDrawCommandsStatesAddressNV = pointerBuffer.get(1936);
        this.glCreateCommandListsNV = pointerBuffer.get(1937);
        this.glDeleteCommandListsNV = pointerBuffer.get(1938);
        this.glIsCommandListNV = pointerBuffer.get(1939);
        this.glListDrawCommandsStatesClientNV = pointerBuffer.get(1940);
        this.glCommandListSegmentsNV = pointerBuffer.get(1941);
        this.glCompileCommandListNV = pointerBuffer.get(1942);
        this.glCallCommandListNV = pointerBuffer.get(1943);
        this.glBeginConditionalRenderNV = pointerBuffer.get(1944);
        this.glEndConditionalRenderNV = pointerBuffer.get(1945);
        this.glSubpixelPrecisionBiasNV = pointerBuffer.get(1946);
        this.glConservativeRasterParameterfNV = pointerBuffer.get(1947);
        this.glConservativeRasterParameteriNV = pointerBuffer.get(1948);
        this.glCopyImageSubDataNV = pointerBuffer.get(1949);
        this.glDepthRangedNV = pointerBuffer.get(1950);
        this.glClearDepthdNV = pointerBuffer.get(1951);
        this.glDepthBoundsdNV = pointerBuffer.get(1952);
        this.glDrawTextureNV = pointerBuffer.get(1953);
        this.glDrawVkImageNV = pointerBuffer.get(1954);
        this.glGetVkProcAddrNV = pointerBuffer.get(1955);
        this.glWaitVkSemaphoreNV = pointerBuffer.get(1956);
        this.glSignalVkSemaphoreNV = pointerBuffer.get(1957);
        this.glSignalVkFenceNV = pointerBuffer.get(1958);
        this.glGetMultisamplefvNV = pointerBuffer.get(1959);
        this.glSampleMaskIndexedNV = pointerBuffer.get(1960);
        this.glTexRenderbufferNV = pointerBuffer.get(1961);
        this.glDeleteFencesNV = pointerBuffer.get(1962);
        this.glGenFencesNV = pointerBuffer.get(1963);
        this.glIsFenceNV = pointerBuffer.get(1964);
        this.glTestFenceNV = pointerBuffer.get(1965);
        this.glGetFenceivNV = pointerBuffer.get(1966);
        this.glFinishFenceNV = pointerBuffer.get(1967);
        this.glSetFenceNV = pointerBuffer.get(1968);
        this.glFragmentCoverageColorNV = pointerBuffer.get(1969);
        this.glCoverageModulationTableNV = pointerBuffer.get(1970);
        this.glGetCoverageModulationTableNV = pointerBuffer.get(1971);
        this.glCoverageModulationNV = pointerBuffer.get(1972);
        this.glRenderbufferStorageMultisampleCoverageNV = pointerBuffer.get(1973);
        this.glRenderGpuMaskNV = pointerBuffer.get(1974);
        this.glMulticastBufferSubDataNV = pointerBuffer.get(1975);
        this.glMulticastCopyBufferSubDataNV = pointerBuffer.get(1976);
        this.glMulticastCopyImageSubDataNV = pointerBuffer.get(1977);
        this.glMulticastBlitFramebufferNV = pointerBuffer.get(1978);
        this.glMulticastFramebufferSampleLocationsfvNV = pointerBuffer.get(1979);
        this.glMulticastBarrierNV = pointerBuffer.get(1980);
        this.glMulticastWaitSyncNV = pointerBuffer.get(1981);
        this.glMulticastGetQueryObjectivNV = pointerBuffer.get(1982);
        this.glMulticastGetQueryObjectuivNV = pointerBuffer.get(1983);
        this.glMulticastGetQueryObjecti64vNV = pointerBuffer.get(1984);
        this.glMulticastGetQueryObjectui64vNV = pointerBuffer.get(1985);
        this.glVertex2hNV = pointerBuffer.get(1986);
        this.glVertex2hvNV = pointerBuffer.get(1987);
        this.glVertex3hNV = pointerBuffer.get(1988);
        this.glVertex3hvNV = pointerBuffer.get(1989);
        this.glVertex4hNV = pointerBuffer.get(1990);
        this.glVertex4hvNV = pointerBuffer.get(1991);
        this.glNormal3hNV = pointerBuffer.get(1992);
        this.glNormal3hvNV = pointerBuffer.get(1993);
        this.glColor3hNV = pointerBuffer.get(1994);
        this.glColor3hvNV = pointerBuffer.get(1995);
        this.glColor4hNV = pointerBuffer.get(1996);
        this.glColor4hvNV = pointerBuffer.get(1997);
        this.glTexCoord1hNV = pointerBuffer.get(1998);
        this.glTexCoord1hvNV = pointerBuffer.get(1999);
        this.glTexCoord2hNV = pointerBuffer.get(2000);
        this.glTexCoord2hvNV = pointerBuffer.get(2001);
        this.glTexCoord3hNV = pointerBuffer.get(2002);
        this.glTexCoord3hvNV = pointerBuffer.get(2003);
        this.glTexCoord4hNV = pointerBuffer.get(2004);
        this.glTexCoord4hvNV = pointerBuffer.get(2005);
        this.glMultiTexCoord1hNV = pointerBuffer.get(2006);
        this.glMultiTexCoord1hvNV = pointerBuffer.get(2007);
        this.glMultiTexCoord2hNV = pointerBuffer.get(2008);
        this.glMultiTexCoord2hvNV = pointerBuffer.get(2009);
        this.glMultiTexCoord3hNV = pointerBuffer.get(2010);
        this.glMultiTexCoord3hvNV = pointerBuffer.get(2011);
        this.glMultiTexCoord4hNV = pointerBuffer.get(2012);
        this.glMultiTexCoord4hvNV = pointerBuffer.get(2013);
        this.glFogCoordhNV = pointerBuffer.get(2014);
        this.glFogCoordhvNV = pointerBuffer.get(2015);
        this.glSecondaryColor3hNV = pointerBuffer.get(2016);
        this.glSecondaryColor3hvNV = pointerBuffer.get(2017);
        this.glVertexWeighthNV = pointerBuffer.get(2018);
        this.glVertexWeighthvNV = pointerBuffer.get(2019);
        this.glVertexAttrib1hNV = pointerBuffer.get(2020);
        this.glVertexAttrib1hvNV = pointerBuffer.get(2021);
        this.glVertexAttrib2hNV = pointerBuffer.get(2022);
        this.glVertexAttrib2hvNV = pointerBuffer.get(2023);
        this.glVertexAttrib3hNV = pointerBuffer.get(2024);
        this.glVertexAttrib3hvNV = pointerBuffer.get(2025);
        this.glVertexAttrib4hNV = pointerBuffer.get(2026);
        this.glVertexAttrib4hvNV = pointerBuffer.get(2027);
        this.glVertexAttribs1hvNV = pointerBuffer.get(2028);
        this.glVertexAttribs2hvNV = pointerBuffer.get(2029);
        this.glVertexAttribs3hvNV = pointerBuffer.get(2030);
        this.glVertexAttribs4hvNV = pointerBuffer.get(2031);
        this.glGetInternalformatSampleivNV = pointerBuffer.get(2032);
        this.glGetMemoryObjectDetachedResourcesuivNV = pointerBuffer.get(2033);
        this.glResetMemoryObjectParameterNV = pointerBuffer.get(2034);
        this.glTexAttachMemoryNV = pointerBuffer.get(2035);
        this.glBufferAttachMemoryNV = pointerBuffer.get(2036);
        this.glTextureAttachMemoryNV = pointerBuffer.get(2037);
        this.glNamedBufferAttachMemoryNV = pointerBuffer.get(2038);
        this.glBufferPageCommitmentMemNV = pointerBuffer.get(2039);
        this.glNamedBufferPageCommitmentMemNV = pointerBuffer.get(2040);
        this.glTexPageCommitmentMemNV = pointerBuffer.get(2041);
        this.glTexturePageCommitmentMemNV = pointerBuffer.get(2042);
        this.glDrawMeshTasksNV = pointerBuffer.get(2043);
        this.glDrawMeshTasksIndirectNV = pointerBuffer.get(2044);
        this.glMultiDrawMeshTasksIndirectNV = pointerBuffer.get(2045);
        this.glMultiDrawMeshTasksIndirectCountNV = pointerBuffer.get(2046);
        this.glPathCommandsNV = pointerBuffer.get(2047);
        this.glPathCoordsNV = pointerBuffer.get(2048);
        this.glPathSubCommandsNV = pointerBuffer.get(2049);
        this.glPathSubCoordsNV = pointerBuffer.get(2050);
        this.glPathStringNV = pointerBuffer.get(2051);
        this.glPathGlyphsNV = pointerBuffer.get(2052);
        this.glPathGlyphRangeNV = pointerBuffer.get(2053);
        this.glPathGlyphIndexArrayNV = pointerBuffer.get(2054);
        this.glPathMemoryGlyphIndexArrayNV = pointerBuffer.get(2055);
        this.glCopyPathNV = pointerBuffer.get(2056);
        this.glWeightPathsNV = pointerBuffer.get(2057);
        this.glInterpolatePathsNV = pointerBuffer.get(2058);
        this.glTransformPathNV = pointerBuffer.get(2059);
        this.glPathParameterivNV = pointerBuffer.get(2060);
        this.glPathParameteriNV = pointerBuffer.get(2061);
        this.glPathParameterfvNV = pointerBuffer.get(2062);
        this.glPathParameterfNV = pointerBuffer.get(2063);
        this.glPathDashArrayNV = pointerBuffer.get(2064);
        this.glGenPathsNV = pointerBuffer.get(2065);
        this.glDeletePathsNV = pointerBuffer.get(2066);
        this.glIsPathNV = pointerBuffer.get(2067);
        this.glPathStencilFuncNV = pointerBuffer.get(2068);
        this.glPathStencilDepthOffsetNV = pointerBuffer.get(2069);
        this.glStencilFillPathNV = pointerBuffer.get(2070);
        this.glStencilStrokePathNV = pointerBuffer.get(2071);
        this.glStencilFillPathInstancedNV = pointerBuffer.get(2072);
        this.glStencilStrokePathInstancedNV = pointerBuffer.get(2073);
        this.glPathCoverDepthFuncNV = pointerBuffer.get(2074);
        this.glPathColorGenNV = pointerBuffer.get(2075);
        this.glPathTexGenNV = pointerBuffer.get(2076);
        this.glPathFogGenNV = pointerBuffer.get(2077);
        this.glCoverFillPathNV = pointerBuffer.get(2078);
        this.glCoverStrokePathNV = pointerBuffer.get(2079);
        this.glCoverFillPathInstancedNV = pointerBuffer.get(2080);
        this.glCoverStrokePathInstancedNV = pointerBuffer.get(2081);
        this.glStencilThenCoverFillPathNV = pointerBuffer.get(2082);
        this.glStencilThenCoverStrokePathNV = pointerBuffer.get(2083);
        this.glStencilThenCoverFillPathInstancedNV = pointerBuffer.get(2084);
        this.glStencilThenCoverStrokePathInstancedNV = pointerBuffer.get(2085);
        this.glPathGlyphIndexRangeNV = pointerBuffer.get(2086);
        this.glProgramPathFragmentInputGenNV = pointerBuffer.get(2087);
        this.glGetPathParameterivNV = pointerBuffer.get(2088);
        this.glGetPathParameterfvNV = pointerBuffer.get(2089);
        this.glGetPathCommandsNV = pointerBuffer.get(2090);
        this.glGetPathCoordsNV = pointerBuffer.get(2091);
        this.glGetPathDashArrayNV = pointerBuffer.get(2092);
        this.glGetPathMetricsNV = pointerBuffer.get(2093);
        this.glGetPathMetricRangeNV = pointerBuffer.get(2094);
        this.glGetPathSpacingNV = pointerBuffer.get(2095);
        this.glGetPathColorGenivNV = pointerBuffer.get(2096);
        this.glGetPathColorGenfvNV = pointerBuffer.get(2097);
        this.glGetPathTexGenivNV = pointerBuffer.get(2098);
        this.glGetPathTexGenfvNV = pointerBuffer.get(2099);
        this.glIsPointInFillPathNV = pointerBuffer.get(2100);
        this.glIsPointInStrokePathNV = pointerBuffer.get(2101);
        this.glGetPathLengthNV = pointerBuffer.get(2102);
        this.glPointAlongPathNV = pointerBuffer.get(2103);
        this.glMatrixLoad3x2fNV = pointerBuffer.get(2104);
        this.glMatrixLoad3x3fNV = pointerBuffer.get(2105);
        this.glMatrixLoadTranspose3x3fNV = pointerBuffer.get(2106);
        this.glMatrixMult3x2fNV = pointerBuffer.get(2107);
        this.glMatrixMult3x3fNV = pointerBuffer.get(2108);
        this.glMatrixMultTranspose3x3fNV = pointerBuffer.get(2109);
        this.glGetProgramResourcefvNV = pointerBuffer.get(2110);
        this.glPixelDataRangeNV = pointerBuffer.get(2111);
        this.glFlushPixelDataRangeNV = pointerBuffer.get(2112);
        this.glPointParameteriNV = pointerBuffer.get(2113);
        this.glPointParameterivNV = pointerBuffer.get(2114);
        this.glPrimitiveRestartNV = pointerBuffer.get(2115);
        this.glPrimitiveRestartIndexNV = pointerBuffer.get(2116);
        this.glQueryResourceNV = pointerBuffer.get(2117);
        this.glGenQueryResourceTagNV = pointerBuffer.get(2118);
        this.glDeleteQueryResourceTagNV = pointerBuffer.get(2119);
        this.glQueryResourceTagNV = pointerBuffer.get(2120);
        this.glFramebufferSampleLocationsfvNV = pointerBuffer.get(2121);
        this.glNamedFramebufferSampleLocationsfvNV = pointerBuffer.get(2122);
        this.glResolveDepthValuesNV = pointerBuffer.get(2123);
        this.glScissorExclusiveArrayvNV = pointerBuffer.get(2124);
        this.glScissorExclusiveNV = pointerBuffer.get(2125);
        this.glMakeBufferResidentNV = pointerBuffer.get(2126);
        this.glMakeBufferNonResidentNV = pointerBuffer.get(2127);
        this.glIsBufferResidentNV = pointerBuffer.get(2128);
        this.glMakeNamedBufferResidentNV = pointerBuffer.get(2129);
        this.glMakeNamedBufferNonResidentNV = pointerBuffer.get(2130);
        this.glIsNamedBufferResidentNV = pointerBuffer.get(2131);
        this.glGetBufferParameterui64vNV = pointerBuffer.get(2132);
        this.glGetNamedBufferParameterui64vNV = pointerBuffer.get(2133);
        this.glGetIntegerui64vNV = pointerBuffer.get(2134);
        this.glUniformui64NV = pointerBuffer.get(2135);
        this.glUniformui64vNV = pointerBuffer.get(2136);
        this.glProgramUniformui64NV = pointerBuffer.get(2137);
        this.glProgramUniformui64vNV = pointerBuffer.get(2138);
        this.glBindShadingRateImageNV = pointerBuffer.get(2139);
        this.glShadingRateImagePaletteNV = pointerBuffer.get(2140);
        this.glGetShadingRateImagePaletteNV = pointerBuffer.get(2141);
        this.glShadingRateImageBarrierNV = pointerBuffer.get(2142);
        this.glShadingRateSampleOrderNV = pointerBuffer.get(2143);
        this.glShadingRateSampleOrderCustomNV = pointerBuffer.get(2144);
        this.glGetShadingRateSampleLocationivNV = pointerBuffer.get(2145);
        this.glTextureBarrierNV = pointerBuffer.get(2146);
        this.glTexImage2DMultisampleCoverageNV = pointerBuffer.get(2147);
        this.glTexImage3DMultisampleCoverageNV = pointerBuffer.get(2148);
        this.glTextureImage2DMultisampleNV = pointerBuffer.get(2149);
        this.glTextureImage3DMultisampleNV = pointerBuffer.get(2150);
        this.glTextureImage2DMultisampleCoverageNV = pointerBuffer.get(2151);
        this.glTextureImage3DMultisampleCoverageNV = pointerBuffer.get(2152);
        this.glCreateSemaphoresNV = pointerBuffer.get(2153);
        this.glSemaphoreParameterivNV = pointerBuffer.get(2154);
        this.glGetSemaphoreParameterivNV = pointerBuffer.get(2155);
        this.glBeginTransformFeedbackNV = pointerBuffer.get(2156);
        this.glEndTransformFeedbackNV = pointerBuffer.get(2157);
        this.glTransformFeedbackAttribsNV = pointerBuffer.get(2158);
        this.glBindBufferRangeNV = pointerBuffer.get(2159);
        this.glBindBufferOffsetNV = pointerBuffer.get(2160);
        this.glBindBufferBaseNV = pointerBuffer.get(2161);
        this.glTransformFeedbackVaryingsNV = pointerBuffer.get(2162);
        this.glActiveVaryingNV = pointerBuffer.get(2163);
        this.glGetVaryingLocationNV = pointerBuffer.get(2164);
        this.glGetActiveVaryingNV = pointerBuffer.get(2165);
        this.glGetTransformFeedbackVaryingNV = pointerBuffer.get(2166);
        this.glTransformFeedbackStreamAttribsNV = pointerBuffer.get(2167);
        this.glBindTransformFeedbackNV = pointerBuffer.get(2168);
        this.glDeleteTransformFeedbacksNV = pointerBuffer.get(2169);
        this.glGenTransformFeedbacksNV = pointerBuffer.get(2170);
        this.glIsTransformFeedbackNV = pointerBuffer.get(2171);
        this.glPauseTransformFeedbackNV = pointerBuffer.get(2172);
        this.glResumeTransformFeedbackNV = pointerBuffer.get(2173);
        this.glDrawTransformFeedbackNV = pointerBuffer.get(2174);
        this.glVertexArrayRangeNV = pointerBuffer.get(2175);
        this.glFlushVertexArrayRangeNV = pointerBuffer.get(2176);
        this.glVertexAttribL1i64NV = pointerBuffer.get(2177);
        this.glVertexAttribL2i64NV = pointerBuffer.get(2178);
        this.glVertexAttribL3i64NV = pointerBuffer.get(2179);
        this.glVertexAttribL4i64NV = pointerBuffer.get(2180);
        this.glVertexAttribL1i64vNV = pointerBuffer.get(2181);
        this.glVertexAttribL2i64vNV = pointerBuffer.get(2182);
        this.glVertexAttribL3i64vNV = pointerBuffer.get(2183);
        this.glVertexAttribL4i64vNV = pointerBuffer.get(2184);
        this.glVertexAttribL1ui64NV = pointerBuffer.get(2185);
        this.glVertexAttribL2ui64NV = pointerBuffer.get(2186);
        this.glVertexAttribL3ui64NV = pointerBuffer.get(2187);
        this.glVertexAttribL4ui64NV = pointerBuffer.get(2188);
        this.glVertexAttribL1ui64vNV = pointerBuffer.get(2189);
        this.glVertexAttribL2ui64vNV = pointerBuffer.get(2190);
        this.glVertexAttribL3ui64vNV = pointerBuffer.get(2191);
        this.glVertexAttribL4ui64vNV = pointerBuffer.get(2192);
        this.glGetVertexAttribLi64vNV = pointerBuffer.get(2193);
        this.glGetVertexAttribLui64vNV = pointerBuffer.get(2194);
        this.glVertexAttribLFormatNV = pointerBuffer.get(2195);
        this.glBufferAddressRangeNV = pointerBuffer.get(2196);
        this.glVertexFormatNV = pointerBuffer.get(2197);
        this.glNormalFormatNV = pointerBuffer.get(2198);
        this.glColorFormatNV = pointerBuffer.get(2199);
        this.glIndexFormatNV = pointerBuffer.get(2200);
        this.glTexCoordFormatNV = pointerBuffer.get(2201);
        this.glEdgeFlagFormatNV = pointerBuffer.get(2202);
        this.glSecondaryColorFormatNV = pointerBuffer.get(2203);
        this.glFogCoordFormatNV = pointerBuffer.get(2204);
        this.glVertexAttribFormatNV = pointerBuffer.get(2205);
        this.glVertexAttribIFormatNV = pointerBuffer.get(2206);
        this.glGetIntegerui64i_vNV = pointerBuffer.get(2207);
        this.glViewportSwizzleNV = pointerBuffer.get(2208);
        this.glBeginConditionalRenderNVX = pointerBuffer.get(2209);
        this.glEndConditionalRenderNVX = pointerBuffer.get(2210);
        this.glAsyncCopyImageSubDataNVX = pointerBuffer.get(2211);
        this.glAsyncCopyBufferSubDataNVX = pointerBuffer.get(2212);
        this.glUploadGpuMaskNVX = pointerBuffer.get(2213);
        this.glMulticastViewportArrayvNVX = pointerBuffer.get(2214);
        this.glMulticastScissorArrayvNVX = pointerBuffer.get(2215);
        this.glMulticastViewportPositionWScaleNVX = pointerBuffer.get(2216);
        this.glCreateProgressFenceNVX = pointerBuffer.get(2217);
        this.glSignalSemaphoreui64NVX = pointerBuffer.get(2218);
        this.glWaitSemaphoreui64NVX = pointerBuffer.get(2219);
        this.glClientWaitSemaphoreui64NVX = pointerBuffer.get(2220);
        this.glFramebufferTextureMultiviewOVR = pointerBuffer.get(2221);
        this.glNamedFramebufferTextureMultiviewOVR = pointerBuffer.get(2222);
        this.addresses = ThreadLocalUtil.setupAddressBuffer(pointerBuffer);
    }

    public PointerBuffer getAddressBuffer() {
        return this.addresses;
    }

    public static void initialize() {
    }

    private static boolean check_GL11(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set, boolean bl2) {
        if (!set.contains("OpenGL11")) {
            return false;
        }
        int n2 = !bl2 || set.contains("GL_NV_vertex_buffer_unified_memory") ? 0 : Integer.MIN_VALUE;
        return (bl2 || Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2, 3, 4, 5, 6, 8, 10, 11, 13, 16, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 52, 53, 54, 56, 64, 65, 66, 67, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 85, 86, 87, 88, 90, 93, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 110, 112, 113, 114, 115, 116, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 138, 140, 141, 142, 143, 144, 145, 146, 147, 148, 150, 151, 152, 153, 154, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 192, 193, 194, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 248, 249, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334}, "glAccum", "glAlphaFunc", "glAreTexturesResident", "glArrayElement", "glBegin", "glBitmap", "glCallList", "glCallLists", "glClearAccum", "glClearIndex", "glClipPlane", "glColor3b", "glColor3s", "glColor3i", "glColor3f", "glColor3d", "glColor3ub", "glColor3us", "glColor3ui", "glColor3bv", "glColor3sv", "glColor3iv", "glColor3fv", "glColor3dv", "glColor3ubv", "glColor3usv", "glColor3uiv", "glColor4b", "glColor4s", "glColor4i", "glColor4f", "glColor4d", "glColor4ub", "glColor4us", "glColor4ui", "glColor4bv", "glColor4sv", "glColor4iv", "glColor4fv", "glColor4dv", "glColor4ubv", "glColor4usv", "glColor4uiv", "glColorMaterial", "glColorPointer", "glCopyPixels", "glDeleteLists", "glDrawPixels", "glEdgeFlag", "glEdgeFlagv", "glEdgeFlagPointer", "glEnd", "glEvalCoord1f", "glEvalCoord1fv", "glEvalCoord1d", "glEvalCoord1dv", "glEvalCoord2f", "glEvalCoord2fv", "glEvalCoord2d", "glEvalCoord2dv", "glEvalMesh1", "glEvalMesh2", "glEvalPoint1", "glEvalPoint2", "glFeedbackBuffer", "glFogi", "glFogiv", "glFogf", "glFogfv", "glGenLists", "glGetClipPlane", "glGetLightiv", "glGetLightfv", "glGetMapiv", "glGetMapfv", "glGetMapdv", "glGetMaterialiv", "glGetMaterialfv", "glGetPixelMapfv", "glGetPixelMapusv", "glGetPixelMapuiv", "glGetPolygonStipple", "glGetTexEnviv", "glGetTexEnvfv", "glGetTexGeniv", "glGetTexGenfv", "glGetTexGendv", "glIndexi", "glIndexub", "glIndexs", "glIndexf", "glIndexd", "glIndexiv", "glIndexubv", "glIndexsv", "glIndexfv", "glIndexdv", "glIndexMask", "glIndexPointer", "glInitNames", "glInterleavedArrays", "glIsList", "glLightModeli", "glLightModelf", "glLightModeliv", "glLightModelfv", "glLighti", "glLightf", "glLightiv", "glLightfv", "glLineStipple", "glListBase", "glLoadMatrixf", "glLoadMatrixd", "glLoadIdentity", "glLoadName", "glMap1f", "glMap1d", "glMap2f", "glMap2d", "glMapGrid1f", "glMapGrid1d", "glMapGrid2f", "glMapGrid2d", "glMateriali", "glMaterialf", "glMaterialiv", "glMaterialfv", "glMatrixMode", "glMultMatrixf", "glMultMatrixd", "glFrustum", "glNewList", "glEndList", "glNormal3f", "glNormal3b", "glNormal3s", "glNormal3i", "glNormal3d", "glNormal3fv", "glNormal3bv", "glNormal3sv", "glNormal3iv", "glNormal3dv", "glNormalPointer", "glOrtho", "glPassThrough", "glPixelMapfv", "glPixelMapusv", "glPixelMapuiv", "glPixelTransferi", "glPixelTransferf", "glPixelZoom", "glPolygonStipple", "glPushAttrib", "glPushClientAttrib", "glPopAttrib", "glPopClientAttrib", "glPopMatrix", "glPopName", "glPrioritizeTextures", "glPushMatrix", "glPushName", "glRasterPos2i", "glRasterPos2s", "glRasterPos2f", "glRasterPos2d", "glRasterPos2iv", "glRasterPos2sv", "glRasterPos2fv", "glRasterPos2dv", "glRasterPos3i", "glRasterPos3s", "glRasterPos3f", "glRasterPos3d", "glRasterPos3iv", "glRasterPos3sv", "glRasterPos3fv", "glRasterPos3dv", "glRasterPos4i", "glRasterPos4s", "glRasterPos4f", "glRasterPos4d", "glRasterPos4iv", "glRasterPos4sv", "glRasterPos4fv", "glRasterPos4dv", "glRecti", "glRects", "glRectf", "glRectd", "glRectiv", "glRectsv", "glRectfv", "glRectdv", "glRenderMode", "glRotatef", "glRotated", "glScalef", "glScaled", "glSelectBuffer", "glShadeModel", "glTexCoord1f", "glTexCoord1s", "glTexCoord1i", "glTexCoord1d", "glTexCoord1fv", "glTexCoord1sv", "glTexCoord1iv", "glTexCoord1dv", "glTexCoord2f", "glTexCoord2s", "glTexCoord2i", "glTexCoord2d", "glTexCoord2fv", "glTexCoord2sv", "glTexCoord2iv", "glTexCoord2dv", "glTexCoord3f", "glTexCoord3s", "glTexCoord3i", "glTexCoord3d", "glTexCoord3fv", "glTexCoord3sv", "glTexCoord3iv", "glTexCoord3dv", "glTexCoord4f", "glTexCoord4s", "glTexCoord4i", "glTexCoord4d", "glTexCoord4fv", "glTexCoord4sv", "glTexCoord4iv", "glTexCoord4dv", "glTexCoordPointer", "glTexEnvi", "glTexEnviv", "glTexEnvf", "glTexEnvfv", "glTexGeni", "glTexGeniv", "glTexGenf", "glTexGenfv", "glTexGend", "glTexGendv", "glTranslatef", "glTranslated", "glVertex2f", "glVertex2s", "glVertex2i", "glVertex2d", "glVertex2fv", "glVertex2sv", "glVertex2iv", "glVertex2dv", "glVertex3f", "glVertex3s", "glVertex3i", "glVertex3d", "glVertex3fv", "glVertex3sv", "glVertex3iv", "glVertex3dv", "glVertex4f", "glVertex4s", "glVertex4i", "glVertex4d", "glVertex4fv", "glVertex4sv", "glVertex4iv", "glVertex4dv", "glVertexPointer")) && Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{0, 1, 7, 9, 12, 14, 15, 17, 51, 55, 57, 58, 59, n2 + 60, 61, 62, 63, n2 + 68, 83, 84, 89, 91, 92, 94, 95, 96, 97, 98, 109, 111, 117, 118, 119, 120, 121, 122, 137, 139, 149, 155, 190, 191, 195, 196, 197, 232, 233, 247, 250, 251, 252, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 335}, "glEnable", "glDisable", "glBindTexture", "glBlendFunc", "glClear", "glClearColor", "glClearDepth", "glClearStencil", "glColorMask", "glCullFace", "glDepthFunc", "glDepthMask", "glDepthRange", "glDisableClientState", "glDrawArrays", "glDrawBuffer", "glDrawElements", "glEnableClientState", "glFinish", "glFlush", "glFrontFace", "glGenTextures", "glDeleteTextures", "glGetBooleanv", "glGetFloatv", "glGetIntegerv", "glGetDoublev", "glGetError", "glGetPointerv", "glGetString", "glGetTexImage", "glGetTexLevelParameteriv", "glGetTexLevelParameterfv", "glGetTexParameteriv", "glGetTexParameterfv", "glHint", "glIsEnabled", "glIsTexture", "glLineWidth", "glLogicOp", "glPixelStorei", "glPixelStoref", "glPointSize", "glPolygonMode", "glPolygonOffset", "glReadBuffer", "glReadPixels", "glScissor", "glStencilFunc", "glStencilMask", "glStencilOp", "glTexImage1D", "glTexImage2D", "glCopyTexImage1D", "glCopyTexImage2D", "glCopyTexSubImage1D", "glCopyTexSubImage2D", "glTexParameteri", "glTexParameteriv", "glTexParameterf", "glTexParameterfv", "glTexSubImage1D", "glTexSubImage2D", "glViewport") || Checks.reportMissing("GL", "OpenGL11");
    }

    private static boolean check_GL12(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL12")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{336, 337, 338, 339}, "glTexImage3D", "glTexSubImage3D", "glCopyTexSubImage3D", "glDrawRangeElements") || Checks.reportMissing("GL", "OpenGL12");
    }

    private static boolean check_GL13(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set, boolean bl2) {
        if (!set.contains("OpenGL13")) {
            return false;
        }
        return (bl2 || Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385}, "glClientActiveTexture", "glMultiTexCoord1f", "glMultiTexCoord1s", "glMultiTexCoord1i", "glMultiTexCoord1d", "glMultiTexCoord1fv", "glMultiTexCoord1sv", "glMultiTexCoord1iv", "glMultiTexCoord1dv", "glMultiTexCoord2f", "glMultiTexCoord2s", "glMultiTexCoord2i", "glMultiTexCoord2d", "glMultiTexCoord2fv", "glMultiTexCoord2sv", "glMultiTexCoord2iv", "glMultiTexCoord2dv", "glMultiTexCoord3f", "glMultiTexCoord3s", "glMultiTexCoord3i", "glMultiTexCoord3d", "glMultiTexCoord3fv", "glMultiTexCoord3sv", "glMultiTexCoord3iv", "glMultiTexCoord3dv", "glMultiTexCoord4f", "glMultiTexCoord4s", "glMultiTexCoord4i", "glMultiTexCoord4d", "glMultiTexCoord4fv", "glMultiTexCoord4sv", "glMultiTexCoord4iv", "glMultiTexCoord4dv", "glLoadTransposeMatrixf", "glLoadTransposeMatrixd", "glMultTransposeMatrixf", "glMultTransposeMatrixd")) && Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{340, 341, 342, 343, 344, 345, 346, 347, 348}, "glCompressedTexImage3D", "glCompressedTexImage2D", "glCompressedTexImage1D", "glCompressedTexSubImage3D", "glCompressedTexSubImage2D", "glCompressedTexSubImage1D", "glGetCompressedTexImage", "glSampleCoverage", "glActiveTexture") || Checks.reportMissing("GL", "OpenGL13");
    }

    private static boolean check_GL14(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set, boolean bl2) {
        if (!set.contains("OpenGL14")) {
            return false;
        }
        return (bl2 || Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{388, 389, 390, 391, 392, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432}, "glFogCoordf", "glFogCoordd", "glFogCoordfv", "glFogCoorddv", "glFogCoordPointer", "glSecondaryColor3b", "glSecondaryColor3s", "glSecondaryColor3i", "glSecondaryColor3f", "glSecondaryColor3d", "glSecondaryColor3ub", "glSecondaryColor3us", "glSecondaryColor3ui", "glSecondaryColor3bv", "glSecondaryColor3sv", "glSecondaryColor3iv", "glSecondaryColor3fv", "glSecondaryColor3dv", "glSecondaryColor3ubv", "glSecondaryColor3usv", "glSecondaryColor3uiv", "glSecondaryColorPointer", "glWindowPos2i", "glWindowPos2s", "glWindowPos2f", "glWindowPos2d", "glWindowPos2iv", "glWindowPos2sv", "glWindowPos2fv", "glWindowPos2dv", "glWindowPos3i", "glWindowPos3s", "glWindowPos3f", "glWindowPos3d", "glWindowPos3iv", "glWindowPos3sv", "glWindowPos3fv", "glWindowPos3dv")) && Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{386, 387, 393, 394, 395, 396, 397, 398, 416}, "glBlendColor", "glBlendEquation", "glMultiDrawArrays", "glMultiDrawElements", "glPointParameterf", "glPointParameteri", "glPointParameterfv", "glPointParameteriv", "glBlendFuncSeparate") || Checks.reportMissing("GL", "OpenGL14");
    }

    private static boolean check_GL15(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL15")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{433, 434, 435, 436, 437, 438, 439, 440, 441, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451}, "glBindBuffer", "glDeleteBuffers", "glGenBuffers", "glIsBuffer", "glBufferData", "glBufferSubData", "glGetBufferSubData", "glMapBuffer", "glUnmapBuffer", "glGetBufferParameteriv", "glGetBufferPointerv", "glGenQueries", "glDeleteQueries", "glIsQuery", "glBeginQuery", "glEndQuery", "glGetQueryiv", "glGetQueryObjectiv", "glGetQueryObjectuiv") || Checks.reportMissing("GL", "OpenGL15");
    }

    private static boolean check_GL20(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL20")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 484, 485, 486, 487, 488, 489, 490, 491, 492, 493, 494, 495, 496, 497, 498, 499, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511, 512, 513, 514, 515, 516, 517, 518, 519, 520, 521, 522, 523, 524, 525, 526, 527, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544}, "glCreateProgram", "glDeleteProgram", "glIsProgram", "glCreateShader", "glDeleteShader", "glIsShader", "glAttachShader", "glDetachShader", "glShaderSource", "glCompileShader", "glLinkProgram", "glUseProgram", "glValidateProgram", "glUniform1f", "glUniform2f", "glUniform3f", "glUniform4f", "glUniform1i", "glUniform2i", "glUniform3i", "glUniform4i", "glUniform1fv", "glUniform2fv", "glUniform3fv", "glUniform4fv", "glUniform1iv", "glUniform2iv", "glUniform3iv", "glUniform4iv", "glUniformMatrix2fv", "glUniformMatrix3fv", "glUniformMatrix4fv", "glGetShaderiv", "glGetProgramiv", "glGetShaderInfoLog", "glGetProgramInfoLog", "glGetAttachedShaders", "glGetUniformLocation", "glGetActiveUniform", "glGetUniformfv", "glGetUniformiv", "glGetShaderSource", "glVertexAttrib1f", "glVertexAttrib1s", "glVertexAttrib1d", "glVertexAttrib2f", "glVertexAttrib2s", "glVertexAttrib2d", "glVertexAttrib3f", "glVertexAttrib3s", "glVertexAttrib3d", "glVertexAttrib4f", "glVertexAttrib4s", "glVertexAttrib4d", "glVertexAttrib4Nub", "glVertexAttrib1fv", "glVertexAttrib1sv", "glVertexAttrib1dv", "glVertexAttrib2fv", "glVertexAttrib2sv", "glVertexAttrib2dv", "glVertexAttrib3fv", "glVertexAttrib3sv", "glVertexAttrib3dv", "glVertexAttrib4fv", "glVertexAttrib4sv", "glVertexAttrib4dv", "glVertexAttrib4iv", "glVertexAttrib4bv", "glVertexAttrib4ubv", "glVertexAttrib4usv", "glVertexAttrib4uiv", "glVertexAttrib4Nbv", "glVertexAttrib4Nsv", "glVertexAttrib4Niv", "glVertexAttrib4Nubv", "glVertexAttrib4Nusv", "glVertexAttrib4Nuiv", "glVertexAttribPointer", "glEnableVertexAttribArray", "glDisableVertexAttribArray", "glBindAttribLocation", "glGetActiveAttrib", "glGetAttribLocation", "glGetVertexAttribiv", "glGetVertexAttribfv", "glGetVertexAttribdv", "glGetVertexAttribPointerv", "glDrawBuffers", "glBlendEquationSeparate", "glStencilOpSeparate", "glStencilFuncSeparate", "glStencilMaskSeparate") || Checks.reportMissing("GL", "OpenGL20");
    }

    private static boolean check_GL21(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL21")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{545, 546, 547, 548, 549, 550}, "glUniformMatrix2x3fv", "glUniformMatrix3x2fv", "glUniformMatrix2x4fv", "glUniformMatrix4x2fv", "glUniformMatrix3x4fv", "glUniformMatrix4x3fv") || Checks.reportMissing("GL", "OpenGL21");
    }

    private static boolean check_GL30(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL30")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634}, "glGetStringi", "glClearBufferiv", "glClearBufferuiv", "glClearBufferfv", "glClearBufferfi", "glVertexAttribI1i", "glVertexAttribI2i", "glVertexAttribI3i", "glVertexAttribI4i", "glVertexAttribI1ui", "glVertexAttribI2ui", "glVertexAttribI3ui", "glVertexAttribI4ui", "glVertexAttribI1iv", "glVertexAttribI2iv", "glVertexAttribI3iv", "glVertexAttribI4iv", "glVertexAttribI1uiv", "glVertexAttribI2uiv", "glVertexAttribI3uiv", "glVertexAttribI4uiv", "glVertexAttribI4bv", "glVertexAttribI4sv", "glVertexAttribI4ubv", "glVertexAttribI4usv", "glVertexAttribIPointer", "glGetVertexAttribIiv", "glGetVertexAttribIuiv", "glUniform1ui", "glUniform2ui", "glUniform3ui", "glUniform4ui", "glUniform1uiv", "glUniform2uiv", "glUniform3uiv", "glUniform4uiv", "glGetUniformuiv", "glBindFragDataLocation", "glGetFragDataLocation", "glBeginConditionalRender", "glEndConditionalRender", "glMapBufferRange", "glFlushMappedBufferRange", "glClampColor", "glIsRenderbuffer", "glBindRenderbuffer", "glDeleteRenderbuffers", "glGenRenderbuffers", "glRenderbufferStorage", "glRenderbufferStorageMultisample", "glGetRenderbufferParameteriv", "glIsFramebuffer", "glBindFramebuffer", "glDeleteFramebuffers", "glGenFramebuffers", "glCheckFramebufferStatus", "glFramebufferTexture1D", "glFramebufferTexture2D", "glFramebufferTexture3D", "glFramebufferTextureLayer", "glFramebufferRenderbuffer", "glGetFramebufferAttachmentParameteriv", "glBlitFramebuffer", "glGenerateMipmap", "glTexParameterIiv", "glTexParameterIuiv", "glGetTexParameterIiv", "glGetTexParameterIuiv", "glColorMaski", "glGetBooleani_v", "glGetIntegeri_v", "glEnablei", "glDisablei", "glIsEnabledi", "glBindBufferRange", "glBindBufferBase", "glBeginTransformFeedback", "glEndTransformFeedback", "glTransformFeedbackVaryings", "glGetTransformFeedbackVarying", "glBindVertexArray", "glDeleteVertexArrays", "glGenVertexArrays", "glIsVertexArray") || Checks.reportMissing("GL", "OpenGL30");
    }

    private static boolean check_GL31(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL31")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{635, 636, 637, 638, 639, 640, 641, 642, 643, 644, 645, 646}, "glDrawArraysInstanced", "glDrawElementsInstanced", "glCopyBufferSubData", "glPrimitiveRestartIndex", "glTexBuffer", "glGetUniformIndices", "glGetActiveUniformsiv", "glGetActiveUniformName", "glGetUniformBlockIndex", "glGetActiveUniformBlockiv", "glGetActiveUniformBlockName", "glUniformBlockBinding") || Checks.reportMissing("GL", "OpenGL31");
    }

    private static boolean check_GL32(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL32")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{647, 648, 649, 650, 651, 652, 653, 654, 655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665}, "glGetBufferParameteri64v", "glDrawElementsBaseVertex", "glDrawRangeElementsBaseVertex", "glDrawElementsInstancedBaseVertex", "glMultiDrawElementsBaseVertex", "glProvokingVertex", "glTexImage2DMultisample", "glTexImage3DMultisample", "glGetMultisamplefv", "glSampleMaski", "glFramebufferTexture", "glFenceSync", "glIsSync", "glDeleteSync", "glClientWaitSync", "glWaitSync", "glGetInteger64v", "glGetInteger64i_v", "glGetSynciv") || Checks.reportMissing("GL", "OpenGL32");
    }

    private static boolean check_GL33(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set, boolean bl2) {
        if (!set.contains("OpenGL33")) {
            return false;
        }
        return (bl2 || Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715}, "glVertexP2ui", "glVertexP3ui", "glVertexP4ui", "glVertexP2uiv", "glVertexP3uiv", "glVertexP4uiv", "glTexCoordP1ui", "glTexCoordP2ui", "glTexCoordP3ui", "glTexCoordP4ui", "glTexCoordP1uiv", "glTexCoordP2uiv", "glTexCoordP3uiv", "glTexCoordP4uiv", "glMultiTexCoordP1ui", "glMultiTexCoordP2ui", "glMultiTexCoordP3ui", "glMultiTexCoordP4ui", "glMultiTexCoordP1uiv", "glMultiTexCoordP2uiv", "glMultiTexCoordP3uiv", "glMultiTexCoordP4uiv", "glNormalP3ui", "glNormalP3uiv", "glColorP3ui", "glColorP4ui", "glColorP3uiv", "glColorP4uiv", "glSecondaryColorP3ui", "glSecondaryColorP3uiv")) && Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{666, 667, 668, 669, 670, 671, 672, 673, 674, 675, 676, 677, 678, 679, 680, 681, 682, 683, 684, 685, 716, 717, 718, 719, 720, 721, 722, 723}, "glBindFragDataLocationIndexed", "glGetFragDataIndex", "glGenSamplers", "glDeleteSamplers", "glIsSampler", "glBindSampler", "glSamplerParameteri", "glSamplerParameterf", "glSamplerParameteriv", "glSamplerParameterfv", "glSamplerParameterIiv", "glSamplerParameterIuiv", "glGetSamplerParameteriv", "glGetSamplerParameterfv", "glGetSamplerParameterIiv", "glGetSamplerParameterIuiv", "glQueryCounter", "glGetQueryObjecti64v", "glGetQueryObjectui64v", "glVertexAttribDivisor", "glVertexAttribP1ui", "glVertexAttribP2ui", "glVertexAttribP3ui", "glVertexAttribP4ui", "glVertexAttribP1uiv", "glVertexAttribP2uiv", "glVertexAttribP3uiv", "glVertexAttribP4uiv") || Checks.reportMissing("GL", "OpenGL33");
    }

    private static boolean check_GL40(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL40")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{724, 725, 726, 727, 728, 729, 730, 731, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747, 748, 749, 750, 751, 752, 753, 754, 755, 756, 757, 758, 759, 760, 761, 762, 763, 764, 765, 766, 767, 768, 769}, "glBlendEquationi", "glBlendEquationSeparatei", "glBlendFunci", "glBlendFuncSeparatei", "glDrawArraysIndirect", "glDrawElementsIndirect", "glUniform1d", "glUniform2d", "glUniform3d", "glUniform4d", "glUniform1dv", "glUniform2dv", "glUniform3dv", "glUniform4dv", "glUniformMatrix2dv", "glUniformMatrix3dv", "glUniformMatrix4dv", "glUniformMatrix2x3dv", "glUniformMatrix2x4dv", "glUniformMatrix3x2dv", "glUniformMatrix3x4dv", "glUniformMatrix4x2dv", "glUniformMatrix4x3dv", "glGetUniformdv", "glMinSampleShading", "glGetSubroutineUniformLocation", "glGetSubroutineIndex", "glGetActiveSubroutineUniformiv", "glGetActiveSubroutineUniformName", "glGetActiveSubroutineName", "glUniformSubroutinesuiv", "glGetUniformSubroutineuiv", "glGetProgramStageiv", "glPatchParameteri", "glPatchParameterfv", "glBindTransformFeedback", "glDeleteTransformFeedbacks", "glGenTransformFeedbacks", "glIsTransformFeedback", "glPauseTransformFeedback", "glResumeTransformFeedback", "glDrawTransformFeedback", "glDrawTransformFeedbackStream", "glBeginQueryIndexed", "glEndQueryIndexed", "glGetQueryIndexediv") || Checks.reportMissing("GL", "OpenGL40");
    }

    private static boolean check_GL41(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL41")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{770, 771, 772, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783, 784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 852, 853, 854, 855, 856, 857}, "glReleaseShaderCompiler", "glShaderBinary", "glGetShaderPrecisionFormat", "glDepthRangef", "glClearDepthf", "glGetProgramBinary", "glProgramBinary", "glProgramParameteri", "glUseProgramStages", "glActiveShaderProgram", "glCreateShaderProgramv", "glBindProgramPipeline", "glDeleteProgramPipelines", "glGenProgramPipelines", "glIsProgramPipeline", "glGetProgramPipelineiv", "glProgramUniform1i", "glProgramUniform2i", "glProgramUniform3i", "glProgramUniform4i", "glProgramUniform1ui", "glProgramUniform2ui", "glProgramUniform3ui", "glProgramUniform4ui", "glProgramUniform1f", "glProgramUniform2f", "glProgramUniform3f", "glProgramUniform4f", "glProgramUniform1d", "glProgramUniform2d", "glProgramUniform3d", "glProgramUniform4d", "glProgramUniform1iv", "glProgramUniform2iv", "glProgramUniform3iv", "glProgramUniform4iv", "glProgramUniform1uiv", "glProgramUniform2uiv", "glProgramUniform3uiv", "glProgramUniform4uiv", "glProgramUniform1fv", "glProgramUniform2fv", "glProgramUniform3fv", "glProgramUniform4fv", "glProgramUniform1dv", "glProgramUniform2dv", "glProgramUniform3dv", "glProgramUniform4dv", "glProgramUniformMatrix2fv", "glProgramUniformMatrix3fv", "glProgramUniformMatrix4fv", "glProgramUniformMatrix2dv", "glProgramUniformMatrix3dv", "glProgramUniformMatrix4dv", "glProgramUniformMatrix2x3fv", "glProgramUniformMatrix3x2fv", "glProgramUniformMatrix2x4fv", "glProgramUniformMatrix4x2fv", "glProgramUniformMatrix3x4fv", "glProgramUniformMatrix4x3fv", "glProgramUniformMatrix2x3dv", "glProgramUniformMatrix3x2dv", "glProgramUniformMatrix2x4dv", "glProgramUniformMatrix4x2dv", "glProgramUniformMatrix3x4dv", "glProgramUniformMatrix4x3dv", "glValidateProgramPipeline", "glGetProgramPipelineInfoLog", "glVertexAttribL1d", "glVertexAttribL2d", "glVertexAttribL3d", "glVertexAttribL4d", "glVertexAttribL1dv", "glVertexAttribL2dv", "glVertexAttribL3dv", "glVertexAttribL4dv", "glVertexAttribLPointer", "glGetVertexAttribLdv", "glViewportArrayv", "glViewportIndexedf", "glViewportIndexedfv", "glScissorArrayv", "glScissorIndexed", "glScissorIndexedv", "glDepthRangeArrayv", "glDepthRangeIndexed", "glGetFloati_v", "glGetDoublei_v") || Checks.reportMissing("GL", "OpenGL41");
    }

    private static boolean check_GL42(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL42")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{858, 859, 860, 861, 862, 863, 864, 865, 866, 867, 868, 869}, "glGetActiveAtomicCounterBufferiv", "glTexStorage1D", "glTexStorage2D", "glTexStorage3D", "glDrawTransformFeedbackInstanced", "glDrawTransformFeedbackStreamInstanced", "glDrawArraysInstancedBaseInstance", "glDrawElementsInstancedBaseInstance", "glDrawElementsInstancedBaseVertexBaseInstance", "glBindImageTexture", "glMemoryBarrier", "glGetInternalformativ") || Checks.reportMissing("GL", "OpenGL42");
    }

    private static boolean check_GL43(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL43")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 911, 912}, "glClearBufferData", "glClearBufferSubData", "glDispatchCompute", "glDispatchComputeIndirect", "glCopyImageSubData", "glDebugMessageControl", "glDebugMessageInsert", "glDebugMessageCallback", "glGetDebugMessageLog", "glPushDebugGroup", "glPopDebugGroup", "glObjectLabel", "glGetObjectLabel", "glObjectPtrLabel", "glGetObjectPtrLabel", "glFramebufferParameteri", "glGetFramebufferParameteriv", "glGetInternalformati64v", "glInvalidateTexSubImage", "glInvalidateTexImage", "glInvalidateBufferSubData", "glInvalidateBufferData", "glInvalidateFramebuffer", "glInvalidateSubFramebuffer", "glMultiDrawArraysIndirect", "glMultiDrawElementsIndirect", "glGetProgramInterfaceiv", "glGetProgramResourceIndex", "glGetProgramResourceName", "glGetProgramResourceiv", "glGetProgramResourceLocation", "glGetProgramResourceLocationIndex", "glShaderStorageBlockBinding", "glTexBufferRange", "glTexStorage2DMultisample", "glTexStorage3DMultisample", "glTextureView", "glBindVertexBuffer", "glVertexAttribFormat", "glVertexAttribIFormat", "glVertexAttribLFormat", "glVertexAttribBinding", "glVertexBindingDivisor") || Checks.reportMissing("GL", "OpenGL43");
    }

    private static boolean check_GL44(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL44")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{913, 914, 915, 916, 917, 918, 919, 920, 921}, "glBufferStorage", "glClearTexSubImage", "glClearTexImage", "glBindBuffersBase", "glBindBuffersRange", "glBindTextures", "glBindSamplers", "glBindImageTextures", "glBindVertexBuffers") || Checks.reportMissing("GL", "OpenGL44");
    }

    private static boolean check_GL45(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL45")) {
            return false;
        }
        int n2 = functionProvider.getFunctionAddress("glGetMapdv") != 0L ? 0 : Integer.MIN_VALUE;
        int n3 = functionProvider.getFunctionAddress("glGetMapfv") != 0L ? 0 : Integer.MIN_VALUE;
        int n4 = functionProvider.getFunctionAddress("glGetMapiv") != 0L ? 0 : Integer.MIN_VALUE;
        int n5 = functionProvider.getFunctionAddress("glGetPixelMapfv") != 0L ? 0 : Integer.MIN_VALUE;
        int n6 = functionProvider.getFunctionAddress("glGetPixelMapuiv") != 0L ? 0 : Integer.MIN_VALUE;
        int n7 = functionProvider.getFunctionAddress("glGetPixelMapusv") != 0L ? 0 : Integer.MIN_VALUE;
        int n8 = functionProvider.getFunctionAddress("glGetPolygonStipple") != 0L ? 0 : Integer.MIN_VALUE;
        int n9 = set.contains("GL_ARB_imaging") && functionProvider.getFunctionAddress("glGetColorTable") != 0L ? 0 : Integer.MIN_VALUE;
        int n10 = set.contains("GL_ARB_imaging") && functionProvider.getFunctionAddress("glGetConvolutionFilter") != 0L ? 0 : Integer.MIN_VALUE;
        int n11 = set.contains("GL_ARB_imaging") && functionProvider.getFunctionAddress("glGetSeparableFilter") != 0L ? 0 : Integer.MIN_VALUE;
        int n12 = set.contains("GL_ARB_imaging") && functionProvider.getFunctionAddress("glGetHistogram") != 0L ? 0 : Integer.MIN_VALUE;
        int n13 = set.contains("GL_ARB_imaging") && functionProvider.getFunctionAddress("glGetMinmax") != 0L ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{922, 923, 924, 925, 926, 927, 928, 929, 930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947, 948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, 999, 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022, 1023, 1024, 1033, 1040, 1042, 1043}, "glClipControl", "glCreateTransformFeedbacks", "glTransformFeedbackBufferBase", "glTransformFeedbackBufferRange", "glGetTransformFeedbackiv", "glGetTransformFeedbacki_v", "glGetTransformFeedbacki64_v", "glCreateBuffers", "glNamedBufferStorage", "glNamedBufferData", "glNamedBufferSubData", "glCopyNamedBufferSubData", "glClearNamedBufferData", "glClearNamedBufferSubData", "glMapNamedBuffer", "glMapNamedBufferRange", "glUnmapNamedBuffer", "glFlushMappedNamedBufferRange", "glGetNamedBufferParameteriv", "glGetNamedBufferParameteri64v", "glGetNamedBufferPointerv", "glGetNamedBufferSubData", "glCreateFramebuffers", "glNamedFramebufferRenderbuffer", "glNamedFramebufferParameteri", "glNamedFramebufferTexture", "glNamedFramebufferTextureLayer", "glNamedFramebufferDrawBuffer", "glNamedFramebufferDrawBuffers", "glNamedFramebufferReadBuffer", "glInvalidateNamedFramebufferData", "glInvalidateNamedFramebufferSubData", "glClearNamedFramebufferiv", "glClearNamedFramebufferuiv", "glClearNamedFramebufferfv", "glClearNamedFramebufferfi", "glBlitNamedFramebuffer", "glCheckNamedFramebufferStatus", "glGetNamedFramebufferParameteriv", "glGetNamedFramebufferAttachmentParameteriv", "glCreateRenderbuffers", "glNamedRenderbufferStorage", "glNamedRenderbufferStorageMultisample", "glGetNamedRenderbufferParameteriv", "glCreateTextures", "glTextureBuffer", "glTextureBufferRange", "glTextureStorage1D", "glTextureStorage2D", "glTextureStorage3D", "glTextureStorage2DMultisample", "glTextureStorage3DMultisample", "glTextureSubImage1D", "glTextureSubImage2D", "glTextureSubImage3D", "glCompressedTextureSubImage1D", "glCompressedTextureSubImage2D", "glCompressedTextureSubImage3D", "glCopyTextureSubImage1D", "glCopyTextureSubImage2D", "glCopyTextureSubImage3D", "glTextureParameterf", "glTextureParameterfv", "glTextureParameteri", "glTextureParameterIiv", "glTextureParameterIuiv", "glTextureParameteriv", "glGenerateTextureMipmap", "glBindTextureUnit", "glGetTextureImage", "glGetCompressedTextureImage", "glGetTextureLevelParameterfv", "glGetTextureLevelParameteriv", "glGetTextureParameterfv", "glGetTextureParameterIiv", "glGetTextureParameterIuiv", "glGetTextureParameteriv", "glCreateVertexArrays", "glDisableVertexArrayAttrib", "glEnableVertexArrayAttrib", "glVertexArrayElementBuffer", "glVertexArrayVertexBuffer", "glVertexArrayVertexBuffers", "glVertexArrayAttribFormat", "glVertexArrayAttribIFormat", "glVertexArrayAttribLFormat", "glVertexArrayAttribBinding", "glVertexArrayBindingDivisor", "glGetVertexArrayiv", "glGetVertexArrayIndexediv", "glGetVertexArrayIndexed64iv", "glCreateSamplers", "glCreateProgramPipelines", "glCreateQueries", "glGetQueryBufferObjectiv", "glGetQueryBufferObjectuiv", "glGetQueryBufferObjecti64v", "glGetQueryBufferObjectui64v", "glMemoryBarrierByRegion", "glGetTextureSubImage", "glGetCompressedTextureSubImage", "glTextureBarrier", "glGetGraphicsResetStatus", "glReadnPixels", "glGetnUniformfv", "glGetnUniformiv", "glGetnUniformuiv") || Checks.reportMissing("GL", "OpenGL45");
    }

    private static boolean check_GL46(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenGL46")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1044, 1045, 1046, 1047}, "glMultiDrawArraysIndirectCount", "glMultiDrawElementsIndirectCount", "glPolygonOffsetClamp", "glSpecializeShader") || Checks.reportMissing("GL", "OpenGL46");
    }

    private static boolean check_AMD_debug_output(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_AMD_debug_output")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1048, 1049, 1050, 1051}, "glDebugMessageEnableAMD", "glDebugMessageInsertAMD", "glDebugMessageCallbackAMD", "glGetDebugMessageLogAMD") || Checks.reportMissing("GL", "GL_AMD_debug_output");
    }

    private static boolean check_AMD_draw_buffers_blend(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_AMD_draw_buffers_blend")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1052, 1053, 1054, 1055}, "glBlendFuncIndexedAMD", "glBlendFuncSeparateIndexedAMD", "glBlendEquationIndexedAMD", "glBlendEquationSeparateIndexedAMD") || Checks.reportMissing("GL", "GL_AMD_draw_buffers_blend");
    }

    private static boolean check_AMD_framebuffer_multisample_advanced(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_AMD_framebuffer_multisample_advanced")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1056, 1057}, "glRenderbufferStorageMultisampleAdvancedAMD", "glNamedRenderbufferStorageMultisampleAdvancedAMD") || Checks.reportMissing("GL", "GL_AMD_framebuffer_multisample_advanced");
    }

    private static boolean check_AMD_gpu_shader_int64(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_AMD_gpu_shader_int64")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068, 1069, 1070, 1071, 1072, 1073, 1074, 1075, n2 + 1076, n2 + 1077, n2 + 1078, n2 + 1079, n2 + 1080, n2 + 1081, n2 + 1082, n2 + 1083, n2 + 1084, n2 + 1085, n2 + 1086, n2 + 1087, n2 + 1088, n2 + 1089, n2 + 1090, n2 + 1091}, "glUniform1i64NV", "glUniform2i64NV", "glUniform3i64NV", "glUniform4i64NV", "glUniform1i64vNV", "glUniform2i64vNV", "glUniform3i64vNV", "glUniform4i64vNV", "glUniform1ui64NV", "glUniform2ui64NV", "glUniform3ui64NV", "glUniform4ui64NV", "glUniform1ui64vNV", "glUniform2ui64vNV", "glUniform3ui64vNV", "glUniform4ui64vNV", "glGetUniformi64vNV", "glGetUniformui64vNV", "glProgramUniform1i64NV", "glProgramUniform2i64NV", "glProgramUniform3i64NV", "glProgramUniform4i64NV", "glProgramUniform1i64vNV", "glProgramUniform2i64vNV", "glProgramUniform3i64vNV", "glProgramUniform4i64vNV", "glProgramUniform1ui64NV", "glProgramUniform2ui64NV", "glProgramUniform3ui64NV", "glProgramUniform4ui64NV", "glProgramUniform1ui64vNV", "glProgramUniform2ui64vNV", "glProgramUniform3ui64vNV", "glProgramUniform4ui64vNV") || Checks.reportMissing("GL", "GL_AMD_gpu_shader_int64");
    }

    private static boolean check_AMD_interleaved_elements(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_AMD_interleaved_elements")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1092}, "glVertexAttribParameteriAMD") || Checks.reportMissing("GL", "GL_AMD_interleaved_elements");
    }

    private static boolean check_AMD_occlusion_query_event(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_AMD_occlusion_query_event")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1093}, "glQueryObjectParameteruiAMD") || Checks.reportMissing("GL", "GL_AMD_occlusion_query_event");
    }

    private static boolean check_AMD_performance_monitor(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_AMD_performance_monitor")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1094, 1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103, 1104}, "glGetPerfMonitorGroupsAMD", "glGetPerfMonitorCountersAMD", "glGetPerfMonitorGroupStringAMD", "glGetPerfMonitorCounterStringAMD", "glGetPerfMonitorCounterInfoAMD", "glGenPerfMonitorsAMD", "glDeletePerfMonitorsAMD", "glSelectPerfMonitorCountersAMD", "glBeginPerfMonitorAMD", "glEndPerfMonitorAMD", "glGetPerfMonitorCounterDataAMD") || Checks.reportMissing("GL", "GL_AMD_performance_monitor");
    }

    private static boolean check_AMD_sample_positions(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_AMD_sample_positions")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1105}, "glSetMultisamplefvAMD") || Checks.reportMissing("GL", "GL_AMD_sample_positions");
    }

    private static boolean check_AMD_sparse_texture(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_AMD_sparse_texture")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1106, 1107}, "glTexStorageSparseAMD", "glTextureStorageSparseAMD") || Checks.reportMissing("GL", "GL_AMD_sparse_texture");
    }

    private static boolean check_AMD_stencil_operation_extended(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_AMD_stencil_operation_extended")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1108}, "glStencilOpValueAMD") || Checks.reportMissing("GL", "GL_AMD_stencil_operation_extended");
    }

    private static boolean check_AMD_vertex_shader_tessellator(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_AMD_vertex_shader_tessellator")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1109, 1110}, "glTessellationFactorAMD", "glTessellationModeAMD") || Checks.reportMissing("GL", "GL_AMD_vertex_shader_tessellator");
    }

    private static boolean check_ARB_base_instance(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_base_instance")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{864, 865, 866}, "glDrawArraysInstancedBaseInstance", "glDrawElementsInstancedBaseInstance", "glDrawElementsInstancedBaseVertexBaseInstance") || Checks.reportMissing("GL", "GL_ARB_base_instance");
    }

    private static boolean check_ARB_bindless_texture(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_bindless_texture")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1111, 1112, 1113, 1114, 1115, 1116, 1117, 1118, 1119, 1120, 1121, 1122, 1123, 1124, 1125, 1126}, "glGetTextureHandleARB", "glGetTextureSamplerHandleARB", "glMakeTextureHandleResidentARB", "glMakeTextureHandleNonResidentARB", "glGetImageHandleARB", "glMakeImageHandleResidentARB", "glMakeImageHandleNonResidentARB", "glUniformHandleui64ARB", "glUniformHandleui64vARB", "glProgramUniformHandleui64ARB", "glProgramUniformHandleui64vARB", "glIsTextureHandleResidentARB", "glIsImageHandleResidentARB", "glVertexAttribL1ui64ARB", "glVertexAttribL1ui64vARB", "glGetVertexAttribLui64vARB") || Checks.reportMissing("GL", "GL_ARB_bindless_texture");
    }

    private static boolean check_ARB_blend_func_extended(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_blend_func_extended")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{666, 667}, "glBindFragDataLocationIndexed", "glGetFragDataIndex") || Checks.reportMissing("GL", "GL_ARB_blend_func_extended");
    }

    private static boolean check_ARB_buffer_storage(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_buffer_storage")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{913, n2 + 1127}, "glBufferStorage", "glNamedBufferStorageEXT") || Checks.reportMissing("GL", "GL_ARB_buffer_storage");
    }

    private static boolean check_ARB_cl_event(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_cl_event")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1128}, "glCreateSyncFromCLeventARB") || Checks.reportMissing("GL", "GL_ARB_cl_event");
    }

    private static boolean check_ARB_clear_buffer_object(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_clear_buffer_object")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{870, 871, n2 + 1129, n2 + 1130}, "glClearBufferData", "glClearBufferSubData", "glClearNamedBufferDataEXT", "glClearNamedBufferSubDataEXT") || Checks.reportMissing("GL", "GL_ARB_clear_buffer_object");
    }

    private static boolean check_ARB_clear_texture(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_clear_texture")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{914, 915}, "glClearTexSubImage", "glClearTexImage") || Checks.reportMissing("GL", "GL_ARB_clear_texture");
    }

    private static boolean check_ARB_clip_control(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_clip_control")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{922}, "glClipControl") || Checks.reportMissing("GL", "GL_ARB_clip_control");
    }

    private static boolean check_ARB_color_buffer_float(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_color_buffer_float")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1131}, "glClampColorARB") || Checks.reportMissing("GL", "GL_ARB_color_buffer_float");
    }

    private static boolean check_ARB_compute_shader(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_compute_shader")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{872, 873}, "glDispatchCompute", "glDispatchComputeIndirect") || Checks.reportMissing("GL", "GL_ARB_compute_shader");
    }

    private static boolean check_ARB_compute_variable_group_size(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_compute_variable_group_size")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1132}, "glDispatchComputeGroupSizeARB") || Checks.reportMissing("GL", "GL_ARB_compute_variable_group_size");
    }

    private static boolean check_ARB_copy_buffer(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_copy_buffer")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{637}, "glCopyBufferSubData") || Checks.reportMissing("GL", "GL_ARB_copy_buffer");
    }

    private static boolean check_ARB_copy_image(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_copy_image")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{874}, "glCopyImageSubData") || Checks.reportMissing("GL", "GL_ARB_copy_image");
    }

    private static boolean check_ARB_debug_output(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_debug_output")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1133, 1134, 1135, 1136}, "glDebugMessageControlARB", "glDebugMessageInsertARB", "glDebugMessageCallbackARB", "glGetDebugMessageLogARB") || Checks.reportMissing("GL", "GL_ARB_debug_output");
    }

    private static boolean check_ARB_direct_state_access(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_direct_state_access")) {
            return false;
        }
        int n2 = GLCapabilities.ARB_transform_feedback2(set) ? 0 : Integer.MIN_VALUE;
        int n3 = GLCapabilities.ARB_uniform_buffer_object(set) ? 0 : Integer.MIN_VALUE;
        int n4 = GLCapabilities.ARB_buffer_storage(set) ? 0 : Integer.MIN_VALUE;
        int n5 = GLCapabilities.ARB_copy_buffer(set) ? 0 : Integer.MIN_VALUE;
        int n6 = GLCapabilities.ARB_clear_texture(set) ? 0 : Integer.MIN_VALUE;
        int n7 = GLCapabilities.ARB_map_buffer_range(set) ? 0 : Integer.MIN_VALUE;
        int n8 = GLCapabilities.ARB_framebuffer_object(set) ? 0 : Integer.MIN_VALUE;
        int n9 = GLCapabilities.ARB_framebuffer_no_attachments(set) ? 0 : Integer.MIN_VALUE;
        int n10 = GLCapabilities.ARB_invalidate_subdata(set) ? 0 : Integer.MIN_VALUE;
        int n11 = GLCapabilities.ARB_texture_buffer_object(set) ? 0 : Integer.MIN_VALUE;
        int n12 = GLCapabilities.ARB_texture_buffer_range(set) ? 0 : Integer.MIN_VALUE;
        int n13 = GLCapabilities.ARB_texture_storage(set) ? 0 : Integer.MIN_VALUE;
        int n14 = GLCapabilities.ARB_texture_storage_multisample(set) ? 0 : Integer.MIN_VALUE;
        int n15 = GLCapabilities.ARB_vertex_array_object(set) ? 0 : Integer.MIN_VALUE;
        int n16 = GLCapabilities.ARB_vertex_attrib_binding(set) ? 0 : Integer.MIN_VALUE;
        int n17 = GLCapabilities.ARB_multi_bind(set) ? 0 : Integer.MIN_VALUE;
        int n18 = GLCapabilities.ARB_sampler_objects(set) ? 0 : Integer.MIN_VALUE;
        int n19 = GLCapabilities.ARB_separate_shader_objects(set) ? 0 : Integer.MIN_VALUE;
        int n20 = GLCapabilities.ARB_query_buffer_object(set) ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{n2 + 923, n3 + 924, n3 + 925, n2 + 926, n2 + 927, n2 + 928, 929, n4 + 930, 931, 932, n5 + 933, n6 + 934, n6 + 935, 936, n7 + 937, 938, n7 + 939, 940, 941, 942, 943, n8 + 944, n8 + 945, n9 + 946, n8 + 947, n8 + 948, n8 + 949, n8 + 950, n8 + 951, n10 + 952, n10 + 953, n8 + 954, n8 + 955, n8 + 956, n8 + 957, n8 + 958, n8 + 959, n9 + 960, n8 + 961, n8 + 962, n8 + 963, n8 + 964, n8 + 965, 966, n11 + 967, n12 + 968, n13 + 969, n13 + 970, n13 + 971, n14 + 972, n14 + 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, n8 + 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, n15 + 999, n15 + 1000, n15 + 1001, n15 + 1002, n16 + 1003, n17 + 1004, n16 + 1005, n16 + 1006, n16 + 1007, n16 + 1008, n16 + 1009, n15 + 1010, n15 + 1011, n15 + 1012, n18 + 1013, n19 + 1014, 1015, n20 + 1018, n20 + 1016, n20 + 1019, n20 + 1017}, "glCreateTransformFeedbacks", "glTransformFeedbackBufferBase", "glTransformFeedbackBufferRange", "glGetTransformFeedbackiv", "glGetTransformFeedbacki_v", "glGetTransformFeedbacki64_v", "glCreateBuffers", "glNamedBufferStorage", "glNamedBufferData", "glNamedBufferSubData", "glCopyNamedBufferSubData", "glClearNamedBufferData", "glClearNamedBufferSubData", "glMapNamedBuffer", "glMapNamedBufferRange", "glUnmapNamedBuffer", "glFlushMappedNamedBufferRange", "glGetNamedBufferParameteriv", "glGetNamedBufferParameteri64v", "glGetNamedBufferPointerv", "glGetNamedBufferSubData", "glCreateFramebuffers", "glNamedFramebufferRenderbuffer", "glNamedFramebufferParameteri", "glNamedFramebufferTexture", "glNamedFramebufferTextureLayer", "glNamedFramebufferDrawBuffer", "glNamedFramebufferDrawBuffers", "glNamedFramebufferReadBuffer", "glInvalidateNamedFramebufferData", "glInvalidateNamedFramebufferSubData", "glClearNamedFramebufferiv", "glClearNamedFramebufferuiv", "glClearNamedFramebufferfv", "glClearNamedFramebufferfi", "glBlitNamedFramebuffer", "glCheckNamedFramebufferStatus", "glGetNamedFramebufferParameteriv", "glGetNamedFramebufferAttachmentParameteriv", "glCreateRenderbuffers", "glNamedRenderbufferStorage", "glNamedRenderbufferStorageMultisample", "glGetNamedRenderbufferParameteriv", "glCreateTextures", "glTextureBuffer", "glTextureBufferRange", "glTextureStorage1D", "glTextureStorage2D", "glTextureStorage3D", "glTextureStorage2DMultisample", "glTextureStorage3DMultisample", "glTextureSubImage1D", "glTextureSubImage2D", "glTextureSubImage3D", "glCompressedTextureSubImage1D", "glCompressedTextureSubImage2D", "glCompressedTextureSubImage3D", "glCopyTextureSubImage1D", "glCopyTextureSubImage2D", "glCopyTextureSubImage3D", "glTextureParameterf", "glTextureParameterfv", "glTextureParameteri", "glTextureParameterIiv", "glTextureParameterIuiv", "glTextureParameteriv", "glGenerateTextureMipmap", "glBindTextureUnit", "glGetTextureImage", "glGetCompressedTextureImage", "glGetTextureLevelParameterfv", "glGetTextureLevelParameteriv", "glGetTextureParameterfv", "glGetTextureParameterIiv", "glGetTextureParameterIuiv", "glGetTextureParameteriv", "glCreateVertexArrays", "glDisableVertexArrayAttrib", "glEnableVertexArrayAttrib", "glVertexArrayElementBuffer", "glVertexArrayVertexBuffer", "glVertexArrayVertexBuffers", "glVertexArrayAttribFormat", "glVertexArrayAttribIFormat", "glVertexArrayAttribLFormat", "glVertexArrayAttribBinding", "glVertexArrayBindingDivisor", "glGetVertexArrayiv", "glGetVertexArrayIndexediv", "glGetVertexArrayIndexed64iv", "glCreateSamplers", "glCreateProgramPipelines", "glCreateQueries", "glGetQueryBufferObjecti64v", "glGetQueryBufferObjectiv", "glGetQueryBufferObjectui64v", "glGetQueryBufferObjectuiv") || Checks.reportMissing("GL", "GL_ARB_direct_state_access");
    }

    private static boolean check_ARB_draw_buffers(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_draw_buffers")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1137}, "glDrawBuffersARB") || Checks.reportMissing("GL", "GL_ARB_draw_buffers");
    }

    private static boolean check_ARB_draw_buffers_blend(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_draw_buffers_blend")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1138, 1139, 1140, 1141}, "glBlendEquationiARB", "glBlendEquationSeparateiARB", "glBlendFunciARB", "glBlendFuncSeparateiARB") || Checks.reportMissing("GL", "GL_ARB_draw_buffers_blend");
    }

    private static boolean check_ARB_draw_elements_base_vertex(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_draw_elements_base_vertex")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{648, 649, 650, 651}, "glDrawElementsBaseVertex", "glDrawRangeElementsBaseVertex", "glDrawElementsInstancedBaseVertex", "glMultiDrawElementsBaseVertex") || Checks.reportMissing("GL", "GL_ARB_draw_elements_base_vertex");
    }

    private static boolean check_ARB_draw_indirect(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_draw_indirect")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{728, 729}, "glDrawArraysIndirect", "glDrawElementsIndirect") || Checks.reportMissing("GL", "GL_ARB_draw_indirect");
    }

    private static boolean check_ARB_draw_instanced(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_draw_instanced")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1142, 1143}, "glDrawArraysInstancedARB", "glDrawElementsInstancedARB") || Checks.reportMissing("GL", "GL_ARB_draw_instanced");
    }

    private static boolean check_ARB_ES2_compatibility(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_ES2_compatibility")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{770, 771, 772, 773, 774}, "glReleaseShaderCompiler", "glShaderBinary", "glGetShaderPrecisionFormat", "glDepthRangef", "glClearDepthf") || Checks.reportMissing("GL", "GL_ARB_ES2_compatibility");
    }

    private static boolean check_ARB_ES3_1_compatibility(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_ES3_1_compatibility")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1020}, "glMemoryBarrierByRegion") || Checks.reportMissing("GL", "GL_ARB_ES3_1_compatibility");
    }

    private static boolean check_ARB_ES3_2_compatibility(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_ES3_2_compatibility")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1144}, "glPrimitiveBoundingBoxARB") || Checks.reportMissing("GL", "GL_ARB_ES3_2_compatibility");
    }

    private static boolean check_ARB_framebuffer_no_attachments(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_framebuffer_no_attachments")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{885, 886, n2 + 1145, n2 + 1146}, "glFramebufferParameteri", "glGetFramebufferParameteriv", "glNamedFramebufferParameteriEXT", "glGetNamedFramebufferParameterivEXT") || Checks.reportMissing("GL", "GL_ARB_framebuffer_no_attachments");
    }

    private static boolean check_ARB_framebuffer_object(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_framebuffer_object")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614}, "glIsRenderbuffer", "glBindRenderbuffer", "glDeleteRenderbuffers", "glGenRenderbuffers", "glRenderbufferStorage", "glRenderbufferStorageMultisample", "glGetRenderbufferParameteriv", "glIsFramebuffer", "glBindFramebuffer", "glDeleteFramebuffers", "glGenFramebuffers", "glCheckFramebufferStatus", "glFramebufferTexture1D", "glFramebufferTexture2D", "glFramebufferTexture3D", "glFramebufferTextureLayer", "glFramebufferRenderbuffer", "glGetFramebufferAttachmentParameteriv", "glBlitFramebuffer", "glGenerateMipmap") || Checks.reportMissing("GL", "GL_ARB_framebuffer_object");
    }

    private static boolean check_ARB_geometry_shader4(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_geometry_shader4")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1147, 1148, 1149, 1150}, "glProgramParameteriARB", "glFramebufferTextureARB", "glFramebufferTextureLayerARB", "glFramebufferTextureFaceARB") || Checks.reportMissing("GL", "GL_ARB_geometry_shader4");
    }

    private static boolean check_ARB_get_program_binary(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_get_program_binary")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{775, 776, 777}, "glGetProgramBinary", "glProgramBinary", "glProgramParameteri") || Checks.reportMissing("GL", "GL_ARB_get_program_binary");
    }

    private static boolean check_ARB_get_texture_sub_image(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_get_texture_sub_image")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1021, 1022}, "glGetTextureSubImage", "glGetCompressedTextureSubImage") || Checks.reportMissing("GL", "GL_ARB_get_texture_sub_image");
    }

    private static boolean check_ARB_gl_spirv(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_gl_spirv")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1151}, "glSpecializeShaderARB") || Checks.reportMissing("GL", "GL_ARB_gl_spirv");
    }

    private static boolean check_ARB_gpu_shader_fp64(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_gpu_shader_fp64")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{730, 731, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747}, "glUniform1d", "glUniform2d", "glUniform3d", "glUniform4d", "glUniform1dv", "glUniform2dv", "glUniform3dv", "glUniform4dv", "glUniformMatrix2dv", "glUniformMatrix3dv", "glUniformMatrix4dv", "glUniformMatrix2x3dv", "glUniformMatrix2x4dv", "glUniformMatrix3x2dv", "glUniformMatrix3x4dv", "glUniformMatrix4x2dv", "glUniformMatrix4x3dv", "glGetUniformdv") || Checks.reportMissing("GL", "GL_ARB_gpu_shader_fp64");
    }

    private static boolean check_ARB_gpu_shader_int64(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_gpu_shader_int64")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1169, 1170, 1171, 1172, 1173, 1174, 1175, 1176, 1177, 1178, 1179, 1180, 1181, 1182, 1183, 1184, 1185, 1186, 1187, 1188, 1189, 1190, 1191, 1192, 1193, 1194, 1195, 1196, 1197, 1198, 1199, 1200, 1201, 1202, 1203, 1204}, "glUniform1i64ARB", "glUniform1i64vARB", "glProgramUniform1i64ARB", "glProgramUniform1i64vARB", "glUniform2i64ARB", "glUniform2i64vARB", "glProgramUniform2i64ARB", "glProgramUniform2i64vARB", "glUniform3i64ARB", "glUniform3i64vARB", "glProgramUniform3i64ARB", "glProgramUniform3i64vARB", "glUniform4i64ARB", "glUniform4i64vARB", "glProgramUniform4i64ARB", "glProgramUniform4i64vARB", "glUniform1ui64ARB", "glUniform1ui64vARB", "glProgramUniform1ui64ARB", "glProgramUniform1ui64vARB", "glUniform2ui64ARB", "glUniform2ui64vARB", "glProgramUniform2ui64ARB", "glProgramUniform2ui64vARB", "glUniform3ui64ARB", "glUniform3ui64vARB", "glProgramUniform3ui64ARB", "glProgramUniform3ui64vARB", "glUniform4ui64ARB", "glUniform4ui64vARB", "glProgramUniform4ui64ARB", "glProgramUniform4ui64vARB", "glGetUniformi64vARB", "glGetUniformui64vARB", "glGetnUniformi64vARB", "glGetnUniformui64vARB") || Checks.reportMissing("GL", "GL_ARB_gpu_shader_int64");
    }

    private static boolean check_ARB_imaging(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set, boolean bl2) {
        if (!set.contains("GL_ARB_imaging")) {
            return false;
        }
        return (bl2 || Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1205, 1206, 1207, 1208, 1209, 1210, 1211, 1212, 1213, 1214, 1215, 1216, 1217, 1218, 1219, 1220, 1221, 1222, 1223, 1224, 1225, 1226, 1227, 1228, 1229, 1230, 1231, 1232, 1233, 1234, 1235, 1236}, "glColorTable", "glCopyColorTable", "glColorTableParameteriv", "glColorTableParameterfv", "glGetColorTable", "glGetColorTableParameteriv", "glGetColorTableParameterfv", "glColorSubTable", "glCopyColorSubTable", "glConvolutionFilter1D", "glConvolutionFilter2D", "glCopyConvolutionFilter1D", "glCopyConvolutionFilter2D", "glGetConvolutionFilter", "glSeparableFilter2D", "glGetSeparableFilter", "glConvolutionParameteri", "glConvolutionParameteriv", "glConvolutionParameterf", "glConvolutionParameterfv", "glGetConvolutionParameteriv", "glGetConvolutionParameterfv", "glHistogram", "glResetHistogram", "glGetHistogram", "glGetHistogramParameteriv", "glGetHistogramParameterfv", "glMinmax", "glResetMinmax", "glGetMinmax", "glGetMinmaxParameteriv", "glGetMinmaxParameterfv")) && Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{386, 387}, "glBlendColor", "glBlendEquation") || Checks.reportMissing("GL", "GL_ARB_imaging");
    }

    private static boolean check_ARB_indirect_parameters(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_indirect_parameters")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1237, 1238}, "glMultiDrawArraysIndirectCountARB", "glMultiDrawElementsIndirectCountARB") || Checks.reportMissing("GL", "GL_ARB_indirect_parameters");
    }

    private static boolean check_ARB_instanced_arrays(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_instanced_arrays")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1239}, "glVertexAttribDivisorARB") || Checks.reportMissing("GL", "GL_ARB_instanced_arrays");
    }

    private static boolean check_ARB_internalformat_query(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_internalformat_query")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{869}, "glGetInternalformativ") || Checks.reportMissing("GL", "GL_ARB_internalformat_query");
    }

    private static boolean check_ARB_internalformat_query2(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_internalformat_query2")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{887}, "glGetInternalformati64v") || Checks.reportMissing("GL", "GL_ARB_internalformat_query2");
    }

    private static boolean check_ARB_invalidate_subdata(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_invalidate_subdata")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{888, 889, 890, 891, 892, 893}, "glInvalidateTexSubImage", "glInvalidateTexImage", "glInvalidateBufferSubData", "glInvalidateBufferData", "glInvalidateFramebuffer", "glInvalidateSubFramebuffer") || Checks.reportMissing("GL", "GL_ARB_invalidate_subdata");
    }

    private static boolean check_ARB_map_buffer_range(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_map_buffer_range")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{592, 593}, "glMapBufferRange", "glFlushMappedBufferRange") || Checks.reportMissing("GL", "GL_ARB_map_buffer_range");
    }

    private static boolean check_ARB_matrix_palette(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_matrix_palette")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1241, 1242, 1243, 1244, 1245}, "glCurrentPaletteMatrixARB", "glMatrixIndexuivARB", "glMatrixIndexubvARB", "glMatrixIndexusvARB", "glMatrixIndexPointerARB") || Checks.reportMissing("GL", "GL_ARB_matrix_palette");
    }

    private static boolean check_ARB_multi_bind(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_multi_bind")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{916, 917, 918, 919, 920, 921}, "glBindBuffersBase", "glBindBuffersRange", "glBindTextures", "glBindSamplers", "glBindImageTextures", "glBindVertexBuffers") || Checks.reportMissing("GL", "GL_ARB_multi_bind");
    }

    private static boolean check_ARB_multi_draw_indirect(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_multi_draw_indirect")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{894, 895}, "glMultiDrawArraysIndirect", "glMultiDrawElementsIndirect") || Checks.reportMissing("GL", "GL_ARB_multi_draw_indirect");
    }

    private static boolean check_ARB_multisample(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_multisample")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1246}, "glSampleCoverageARB") || Checks.reportMissing("GL", "GL_ARB_multisample");
    }

    private static boolean check_ARB_multitexture(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_multitexture")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1247, 1248, 1249, 1250, 1251, 1252, 1253, 1254, 1255, 1256, 1257, 1258, 1259, 1260, 1261, 1262, 1263, 1264, 1265, 1266, 1267, 1268, 1269, 1270, 1271, 1272, 1273, 1274, 1275, 1276, 1277, 1278, 1279, 1280}, "glActiveTextureARB", "glClientActiveTextureARB", "glMultiTexCoord1fARB", "glMultiTexCoord1sARB", "glMultiTexCoord1iARB", "glMultiTexCoord1dARB", "glMultiTexCoord1fvARB", "glMultiTexCoord1svARB", "glMultiTexCoord1ivARB", "glMultiTexCoord1dvARB", "glMultiTexCoord2fARB", "glMultiTexCoord2sARB", "glMultiTexCoord2iARB", "glMultiTexCoord2dARB", "glMultiTexCoord2fvARB", "glMultiTexCoord2svARB", "glMultiTexCoord2ivARB", "glMultiTexCoord2dvARB", "glMultiTexCoord3fARB", "glMultiTexCoord3sARB", "glMultiTexCoord3iARB", "glMultiTexCoord3dARB", "glMultiTexCoord3fvARB", "glMultiTexCoord3svARB", "glMultiTexCoord3ivARB", "glMultiTexCoord3dvARB", "glMultiTexCoord4fARB", "glMultiTexCoord4sARB", "glMultiTexCoord4iARB", "glMultiTexCoord4dARB", "glMultiTexCoord4fvARB", "glMultiTexCoord4svARB", "glMultiTexCoord4ivARB", "glMultiTexCoord4dvARB") || Checks.reportMissing("GL", "GL_ARB_multitexture");
    }

    private static boolean check_ARB_occlusion_query(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_occlusion_query")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1281, 1282, 1283, 1284, 1285, 1286, 1287, 1288}, "glGenQueriesARB", "glDeleteQueriesARB", "glIsQueryARB", "glBeginQueryARB", "glEndQueryARB", "glGetQueryivARB", "glGetQueryObjectivARB", "glGetQueryObjectuivARB") || Checks.reportMissing("GL", "GL_ARB_occlusion_query");
    }

    private static boolean check_ARB_parallel_shader_compile(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_parallel_shader_compile")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1289}, "glMaxShaderCompilerThreadsARB") || Checks.reportMissing("GL", "GL_ARB_parallel_shader_compile");
    }

    private static boolean check_ARB_point_parameters(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_point_parameters")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1290, 1291}, "glPointParameterfARB", "glPointParameterfvARB") || Checks.reportMissing("GL", "GL_ARB_point_parameters");
    }

    private static boolean check_ARB_polygon_offset_clamp(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_polygon_offset_clamp")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1046}, "glPolygonOffsetClamp") || Checks.reportMissing("GL", "GL_ARB_polygon_offset_clamp");
    }

    private static boolean check_ARB_program_interface_query(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_program_interface_query")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{896, 897, 898, 899, 900, 901}, "glGetProgramInterfaceiv", "glGetProgramResourceIndex", "glGetProgramResourceName", "glGetProgramResourceiv", "glGetProgramResourceLocation", "glGetProgramResourceLocationIndex") || Checks.reportMissing("GL", "GL_ARB_program_interface_query");
    }

    private static boolean check_ARB_provoking_vertex(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_provoking_vertex")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{652}, "glProvokingVertex") || Checks.reportMissing("GL", "GL_ARB_provoking_vertex");
    }

    private static boolean check_ARB_robustness(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_robustness")) {
            return false;
        }
        int n2 = functionProvider.getFunctionAddress("glGetMapdv") != 0L ? 0 : Integer.MIN_VALUE;
        int n3 = functionProvider.getFunctionAddress("glGetMapfv") != 0L ? 0 : Integer.MIN_VALUE;
        int n4 = functionProvider.getFunctionAddress("glGetMapiv") != 0L ? 0 : Integer.MIN_VALUE;
        int n5 = functionProvider.getFunctionAddress("glGetPixelMapfv") != 0L ? 0 : Integer.MIN_VALUE;
        int n6 = functionProvider.getFunctionAddress("glGetPixelMapuiv") != 0L ? 0 : Integer.MIN_VALUE;
        int n7 = functionProvider.getFunctionAddress("glGetPixelMapusv") != 0L ? 0 : Integer.MIN_VALUE;
        int n8 = functionProvider.getFunctionAddress("glGetPolygonStipple") != 0L ? 0 : Integer.MIN_VALUE;
        int n9 = set.contains("GL_ARB_imaging") && functionProvider.getFunctionAddress("glGetColorTable") != 0L ? 0 : Integer.MIN_VALUE;
        int n10 = set.contains("GL_ARB_imaging") && functionProvider.getFunctionAddress("glGetConvolutionFilter") != 0L ? 0 : Integer.MIN_VALUE;
        int n11 = set.contains("GL_ARB_imaging") && functionProvider.getFunctionAddress("glGetSeparableFilter") != 0L ? 0 : Integer.MIN_VALUE;
        int n12 = set.contains("GL_ARB_imaging") && functionProvider.getFunctionAddress("glGetHistogram") != 0L ? 0 : Integer.MIN_VALUE;
        int n13 = set.contains("GL_ARB_imaging") && functionProvider.getFunctionAddress("glGetMinmax") != 0L ? 0 : Integer.MIN_VALUE;
        int n14 = set.contains("OpenGL13") ? 0 : Integer.MIN_VALUE;
        int n15 = set.contains("OpenGL20") ? 0 : Integer.MIN_VALUE;
        int n16 = set.contains("OpenGL30") ? 0 : Integer.MIN_VALUE;
        int n17 = set.contains("OpenGL40") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1292, n2 + 1293, n3 + 1294, n4 + 1295, n5 + 1296, n6 + 1297, n7 + 1298, n8 + 1299, 1300, 1301, n9 + 1302, n10 + 1303, n11 + 1304, n12 + 1305, n13 + 1306, n14 + 1307, n15 + 1308, n15 + 1309, n16 + 1310, n17 + 1311}, "glGetGraphicsResetStatusARB", "glGetnMapdvARB", "glGetnMapfvARB", "glGetnMapivARB", "glGetnPixelMapfvARB", "glGetnPixelMapuivARB", "glGetnPixelMapusvARB", "glGetnPolygonStippleARB", "glGetnTexImageARB", "glReadnPixelsARB", "glGetnColorTableARB", "glGetnConvolutionFilterARB", "glGetnSeparableFilterARB", "glGetnHistogramARB", "glGetnMinmaxARB", "glGetnCompressedTexImageARB", "glGetnUniformfvARB", "glGetnUniformivARB", "glGetnUniformuivARB", "glGetnUniformdvARB") || Checks.reportMissing("GL", "GL_ARB_robustness");
    }

    private static boolean check_ARB_sample_locations(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_sample_locations")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1312, 1313, 1314}, "glFramebufferSampleLocationsfvARB", "glNamedFramebufferSampleLocationsfvARB", "glEvaluateDepthValuesARB") || Checks.reportMissing("GL", "GL_ARB_sample_locations");
    }

    private static boolean check_ARB_sample_shading(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_sample_shading")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1315}, "glMinSampleShadingARB") || Checks.reportMissing("GL", "GL_ARB_sample_shading");
    }

    private static boolean check_ARB_sampler_objects(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_sampler_objects")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{668, 669, 670, 671, 672, 673, 674, 675, 676, 677, 678, 679, 680, 681}, "glGenSamplers", "glDeleteSamplers", "glIsSampler", "glBindSampler", "glSamplerParameteri", "glSamplerParameterf", "glSamplerParameteriv", "glSamplerParameterfv", "glSamplerParameterIiv", "glSamplerParameterIuiv", "glGetSamplerParameteriv", "glGetSamplerParameterfv", "glGetSamplerParameterIiv", "glGetSamplerParameterIuiv") || Checks.reportMissing("GL", "GL_ARB_sampler_objects");
    }

    private static boolean check_ARB_separate_shader_objects(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_separate_shader_objects")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{778, 779, 780, 781, 782, 783, 784, 777, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837}, "glUseProgramStages", "glActiveShaderProgram", "glCreateShaderProgramv", "glBindProgramPipeline", "glDeleteProgramPipelines", "glGenProgramPipelines", "glIsProgramPipeline", "glProgramParameteri", "glGetProgramPipelineiv", "glProgramUniform1i", "glProgramUniform2i", "glProgramUniform3i", "glProgramUniform4i", "glProgramUniform1ui", "glProgramUniform2ui", "glProgramUniform3ui", "glProgramUniform4ui", "glProgramUniform1f", "glProgramUniform2f", "glProgramUniform3f", "glProgramUniform4f", "glProgramUniform1d", "glProgramUniform2d", "glProgramUniform3d", "glProgramUniform4d", "glProgramUniform1iv", "glProgramUniform2iv", "glProgramUniform3iv", "glProgramUniform4iv", "glProgramUniform1uiv", "glProgramUniform2uiv", "glProgramUniform3uiv", "glProgramUniform4uiv", "glProgramUniform1fv", "glProgramUniform2fv", "glProgramUniform3fv", "glProgramUniform4fv", "glProgramUniform1dv", "glProgramUniform2dv", "glProgramUniform3dv", "glProgramUniform4dv", "glProgramUniformMatrix2fv", "glProgramUniformMatrix3fv", "glProgramUniformMatrix4fv", "glProgramUniformMatrix2dv", "glProgramUniformMatrix3dv", "glProgramUniformMatrix4dv", "glProgramUniformMatrix2x3fv", "glProgramUniformMatrix3x2fv", "glProgramUniformMatrix2x4fv", "glProgramUniformMatrix4x2fv", "glProgramUniformMatrix3x4fv", "glProgramUniformMatrix4x3fv", "glProgramUniformMatrix2x3dv", "glProgramUniformMatrix3x2dv", "glProgramUniformMatrix2x4dv", "glProgramUniformMatrix4x2dv", "glProgramUniformMatrix3x4dv", "glProgramUniformMatrix4x3dv", "glValidateProgramPipeline", "glGetProgramPipelineInfoLog") || Checks.reportMissing("GL", "GL_ARB_separate_shader_objects");
    }

    private static boolean check_ARB_shader_atomic_counters(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_shader_atomic_counters")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{858}, "glGetActiveAtomicCounterBufferiv") || Checks.reportMissing("GL", "GL_ARB_shader_atomic_counters");
    }

    private static boolean check_ARB_shader_image_load_store(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_shader_image_load_store")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{867, 868}, "glBindImageTexture", "glMemoryBarrier") || Checks.reportMissing("GL", "GL_ARB_shader_image_load_store");
    }

    private static boolean check_ARB_shader_objects(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_shader_objects")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1316, 1317, 1318, 1319, 1320, 1321, 1322, 1323, 1324, 1325, 1326, 1327, 1328, 1329, 1330, 1331, 1332, 1333, 1334, 1335, 1336, 1337, 1338, 1339, 1340, 1341, 1342, 1343, 1344, 1345, 1346, 1347, 1348, 1349, 1350, 1351, 1352, 1353, 1354}, "glDeleteObjectARB", "glGetHandleARB", "glDetachObjectARB", "glCreateShaderObjectARB", "glShaderSourceARB", "glCompileShaderARB", "glCreateProgramObjectARB", "glAttachObjectARB", "glLinkProgramARB", "glUseProgramObjectARB", "glValidateProgramARB", "glUniform1fARB", "glUniform2fARB", "glUniform3fARB", "glUniform4fARB", "glUniform1iARB", "glUniform2iARB", "glUniform3iARB", "glUniform4iARB", "glUniform1fvARB", "glUniform2fvARB", "glUniform3fvARB", "glUniform4fvARB", "glUniform1ivARB", "glUniform2ivARB", "glUniform3ivARB", "glUniform4ivARB", "glUniformMatrix2fvARB", "glUniformMatrix3fvARB", "glUniformMatrix4fvARB", "glGetObjectParameterfvARB", "glGetObjectParameterivARB", "glGetInfoLogARB", "glGetAttachedObjectsARB", "glGetUniformLocationARB", "glGetActiveUniformARB", "glGetUniformfvARB", "glGetUniformivARB", "glGetShaderSourceARB") || Checks.reportMissing("GL", "GL_ARB_shader_objects");
    }

    private static boolean check_ARB_shader_storage_buffer_object(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_shader_storage_buffer_object")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{902}, "glShaderStorageBlockBinding") || Checks.reportMissing("GL", "GL_ARB_shader_storage_buffer_object");
    }

    private static boolean check_ARB_shader_subroutine(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_shader_subroutine")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{749, 750, 751, 752, 753, 754, 755, 756}, "glGetSubroutineUniformLocation", "glGetSubroutineIndex", "glGetActiveSubroutineUniformiv", "glGetActiveSubroutineUniformName", "glGetActiveSubroutineName", "glUniformSubroutinesuiv", "glGetUniformSubroutineuiv", "glGetProgramStageiv") || Checks.reportMissing("GL", "GL_ARB_shader_subroutine");
    }

    private static boolean check_ARB_shading_language_include(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_shading_language_include")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1355, 1356, 1357, 1358, 1359, 1360}, "glNamedStringARB", "glDeleteNamedStringARB", "glCompileShaderIncludeARB", "glIsNamedStringARB", "glGetNamedStringARB", "glGetNamedStringivARB") || Checks.reportMissing("GL", "GL_ARB_shading_language_include");
    }

    private static boolean check_ARB_sparse_buffer(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_sparse_buffer")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        int n3 = set.contains("GL_ARB_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1361}, "glBufferPageCommitmentARB") || Checks.reportMissing("GL", "GL_ARB_sparse_buffer");
    }

    private static boolean check_ARB_sparse_texture(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_sparse_texture")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1364, n2 + 1365}, "glTexPageCommitmentARB", "glTexturePageCommitmentEXT") || Checks.reportMissing("GL", "GL_ARB_sparse_texture");
    }

    private static boolean check_ARB_sync(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_sync")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{658, 659, 660, 661, 662, 663, 665}, "glFenceSync", "glIsSync", "glDeleteSync", "glClientWaitSync", "glWaitSync", "glGetInteger64v", "glGetSynciv") || Checks.reportMissing("GL", "GL_ARB_sync");
    }

    private static boolean check_ARB_tessellation_shader(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_tessellation_shader")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{757, 758}, "glPatchParameteri", "glPatchParameterfv") || Checks.reportMissing("GL", "GL_ARB_tessellation_shader");
    }

    private static boolean check_ARB_texture_barrier(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_texture_barrier")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1023}, "glTextureBarrier") || Checks.reportMissing("GL", "GL_ARB_texture_barrier");
    }

    private static boolean check_ARB_texture_buffer_object(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_texture_buffer_object")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1366}, "glTexBufferARB") || Checks.reportMissing("GL", "GL_ARB_texture_buffer_object");
    }

    private static boolean check_ARB_texture_buffer_range(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_texture_buffer_range")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{903, n2 + 1367}, "glTexBufferRange", "glTextureBufferRangeEXT") || Checks.reportMissing("GL", "GL_ARB_texture_buffer_range");
    }

    private static boolean check_ARB_texture_compression(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_texture_compression")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1368, 1369, 1370, 1371, 1372, 1373, 1374}, "glCompressedTexImage3DARB", "glCompressedTexImage2DARB", "glCompressedTexImage1DARB", "glCompressedTexSubImage3DARB", "glCompressedTexSubImage2DARB", "glCompressedTexSubImage1DARB", "glGetCompressedTexImageARB") || Checks.reportMissing("GL", "GL_ARB_texture_compression");
    }

    private static boolean check_ARB_texture_multisample(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_texture_multisample")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{653, 654, 655, 656}, "glTexImage2DMultisample", "glTexImage3DMultisample", "glGetMultisamplefv", "glSampleMaski") || Checks.reportMissing("GL", "GL_ARB_texture_multisample");
    }

    private static boolean check_ARB_texture_storage(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_texture_storage")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{859, 860, 861, n2 + 1375, n2 + 1376, n2 + 1377}, "glTexStorage1D", "glTexStorage2D", "glTexStorage3D", "glTextureStorage1DEXT", "glTextureStorage2DEXT", "glTextureStorage3DEXT") || Checks.reportMissing("GL", "GL_ARB_texture_storage");
    }

    private static boolean check_ARB_texture_storage_multisample(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_texture_storage_multisample")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{904, 905, n2 + 1378, n2 + 1379}, "glTexStorage2DMultisample", "glTexStorage3DMultisample", "glTextureStorage2DMultisampleEXT", "glTextureStorage3DMultisampleEXT") || Checks.reportMissing("GL", "GL_ARB_texture_storage_multisample");
    }

    private static boolean check_ARB_texture_view(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_texture_view")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{906}, "glTextureView") || Checks.reportMissing("GL", "GL_ARB_texture_view");
    }

    private static boolean check_ARB_timer_query(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_timer_query")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{682, 683, 684}, "glQueryCounter", "glGetQueryObjecti64v", "glGetQueryObjectui64v") || Checks.reportMissing("GL", "GL_ARB_timer_query");
    }

    private static boolean check_ARB_transform_feedback2(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_transform_feedback2")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{759, 760, 761, 762, 763, 764, 765}, "glBindTransformFeedback", "glDeleteTransformFeedbacks", "glGenTransformFeedbacks", "glIsTransformFeedback", "glPauseTransformFeedback", "glResumeTransformFeedback", "glDrawTransformFeedback") || Checks.reportMissing("GL", "GL_ARB_transform_feedback2");
    }

    private static boolean check_ARB_transform_feedback3(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_transform_feedback3")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{766, 767, 768, 769}, "glDrawTransformFeedbackStream", "glBeginQueryIndexed", "glEndQueryIndexed", "glGetQueryIndexediv") || Checks.reportMissing("GL", "GL_ARB_transform_feedback3");
    }

    private static boolean check_ARB_transform_feedback_instanced(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_transform_feedback_instanced")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{862, 863}, "glDrawTransformFeedbackInstanced", "glDrawTransformFeedbackStreamInstanced") || Checks.reportMissing("GL", "GL_ARB_transform_feedback_instanced");
    }

    private static boolean check_ARB_transpose_matrix(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_transpose_matrix")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1380, 1381, 1382, 1383}, "glLoadTransposeMatrixfARB", "glLoadTransposeMatrixdARB", "glMultTransposeMatrixfARB", "glMultTransposeMatrixdARB") || Checks.reportMissing("GL", "GL_ARB_transpose_matrix");
    }

    private static boolean check_ARB_uniform_buffer_object(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_uniform_buffer_object")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{640, 641, 642, 643, 644, 645, 625, 626, 621, 646}, "glGetUniformIndices", "glGetActiveUniformsiv", "glGetActiveUniformName", "glGetUniformBlockIndex", "glGetActiveUniformBlockiv", "glGetActiveUniformBlockName", "glBindBufferRange", "glBindBufferBase", "glGetIntegeri_v", "glUniformBlockBinding") || Checks.reportMissing("GL", "GL_ARB_uniform_buffer_object");
    }

    private static boolean check_ARB_vertex_array_object(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_vertex_array_object")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{631, 632, 633, 634}, "glBindVertexArray", "glDeleteVertexArrays", "glGenVertexArrays", "glIsVertexArray") || Checks.reportMissing("GL", "GL_ARB_vertex_array_object");
    }

    private static boolean check_ARB_vertex_attrib_64bit(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_vertex_attrib_64bit")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{838, 839, 840, 841, 842, 843, 844, 845, 846, 847, n2 + 1384}, "glVertexAttribL1d", "glVertexAttribL2d", "glVertexAttribL3d", "glVertexAttribL4d", "glVertexAttribL1dv", "glVertexAttribL2dv", "glVertexAttribL3dv", "glVertexAttribL4dv", "glVertexAttribLPointer", "glGetVertexAttribLdv", "glVertexArrayVertexAttribLOffsetEXT") || Checks.reportMissing("GL", "GL_ARB_vertex_attrib_64bit");
    }

    private static boolean check_ARB_vertex_attrib_binding(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_vertex_attrib_binding")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{907, 908, 909, 910, 911, 912, n2 + 1385, n2 + 1386, n2 + 1387, n2 + 1388, n2 + 1389, n2 + 1390}, "glBindVertexBuffer", "glVertexAttribFormat", "glVertexAttribIFormat", "glVertexAttribLFormat", "glVertexAttribBinding", "glVertexBindingDivisor", "glVertexArrayBindVertexBufferEXT", "glVertexArrayVertexAttribFormatEXT", "glVertexArrayVertexAttribIFormatEXT", "glVertexArrayVertexAttribLFormatEXT", "glVertexArrayVertexAttribBindingEXT", "glVertexArrayVertexBindingDivisorEXT") || Checks.reportMissing("GL", "GL_ARB_vertex_attrib_binding");
    }

    private static boolean check_ARB_vertex_blend(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_vertex_blend")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1391, 1392, 1393, 1394, 1395, 1396, 1397, 1398, 1399, 1400}, "glWeightfvARB", "glWeightbvARB", "glWeightubvARB", "glWeightsvARB", "glWeightusvARB", "glWeightivARB", "glWeightuivARB", "glWeightdvARB", "glWeightPointerARB", "glVertexBlendARB") || Checks.reportMissing("GL", "GL_ARB_vertex_blend");
    }

    private static boolean check_ARB_vertex_buffer_object(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_vertex_buffer_object")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1401, 1402, 1403, 1404, 1405, 1406, 1407, 1408, 1409, 1410, 1411}, "glBindBufferARB", "glDeleteBuffersARB", "glGenBuffersARB", "glIsBufferARB", "glBufferDataARB", "glBufferSubDataARB", "glGetBufferSubDataARB", "glMapBufferARB", "glUnmapBufferARB", "glGetBufferParameterivARB", "glGetBufferPointervARB") || Checks.reportMissing("GL", "GL_ARB_vertex_buffer_object");
    }

    private static boolean check_ARB_vertex_program(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_vertex_program")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1412, 1413, 1414, 1415, 1416, 1417, 1418, 1419, 1420, 1421, 1422, 1423, 1424, 1425, 1426, 1427, 1428, 1429, 1430, 1431, 1432, 1433, 1434, 1435, 1436, 1437, 1438, 1439, 1440, 1441, 1442, 1443, 1444, 1445, 1446, 1447, 1448, 1449, 1450, 1451, 1452, 1453, 1454, 1455, 1456, 1457, 1458, 1459, 1460, 1461, 1462, 1463, 1464, 1465, 1466, 1467, 1468, 1469, 1470, 1471, 1472, 1473}, "glVertexAttrib1sARB", "glVertexAttrib1fARB", "glVertexAttrib1dARB", "glVertexAttrib2sARB", "glVertexAttrib2fARB", "glVertexAttrib2dARB", "glVertexAttrib3sARB", "glVertexAttrib3fARB", "glVertexAttrib3dARB", "glVertexAttrib4sARB", "glVertexAttrib4fARB", "glVertexAttrib4dARB", "glVertexAttrib4NubARB", "glVertexAttrib1svARB", "glVertexAttrib1fvARB", "glVertexAttrib1dvARB", "glVertexAttrib2svARB", "glVertexAttrib2fvARB", "glVertexAttrib2dvARB", "glVertexAttrib3svARB", "glVertexAttrib3fvARB", "glVertexAttrib3dvARB", "glVertexAttrib4fvARB", "glVertexAttrib4bvARB", "glVertexAttrib4svARB", "glVertexAttrib4ivARB", "glVertexAttrib4ubvARB", "glVertexAttrib4usvARB", "glVertexAttrib4uivARB", "glVertexAttrib4dvARB", "glVertexAttrib4NbvARB", "glVertexAttrib4NsvARB", "glVertexAttrib4NivARB", "glVertexAttrib4NubvARB", "glVertexAttrib4NusvARB", "glVertexAttrib4NuivARB", "glVertexAttribPointerARB", "glEnableVertexAttribArrayARB", "glDisableVertexAttribArrayARB", "glProgramStringARB", "glBindProgramARB", "glDeleteProgramsARB", "glGenProgramsARB", "glProgramEnvParameter4dARB", "glProgramEnvParameter4dvARB", "glProgramEnvParameter4fARB", "glProgramEnvParameter4fvARB", "glProgramLocalParameter4dARB", "glProgramLocalParameter4dvARB", "glProgramLocalParameter4fARB", "glProgramLocalParameter4fvARB", "glGetProgramEnvParameterfvARB", "glGetProgramEnvParameterdvARB", "glGetProgramLocalParameterfvARB", "glGetProgramLocalParameterdvARB", "glGetProgramivARB", "glGetProgramStringARB", "glGetVertexAttribfvARB", "glGetVertexAttribdvARB", "glGetVertexAttribivARB", "glGetVertexAttribPointervARB", "glIsProgramARB") || Checks.reportMissing("GL", "GL_ARB_vertex_program");
    }

    private static boolean check_ARB_vertex_shader(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_vertex_shader")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1413, 1412, 1414, 1416, 1415, 1417, 1419, 1418, 1420, 1422, 1421, 1423, 1424, 1426, 1425, 1427, 1429, 1428, 1430, 1432, 1431, 1433, 1434, 1436, 1441, 1437, 1435, 1438, 1439, 1440, 1442, 1443, 1444, 1445, 1446, 1447, 1448, 1449, 1450, 1474, 1475, 1476, 1471, 1469, 1470, 1472}, "glVertexAttrib1fARB", "glVertexAttrib1sARB", "glVertexAttrib1dARB", "glVertexAttrib2fARB", "glVertexAttrib2sARB", "glVertexAttrib2dARB", "glVertexAttrib3fARB", "glVertexAttrib3sARB", "glVertexAttrib3dARB", "glVertexAttrib4fARB", "glVertexAttrib4sARB", "glVertexAttrib4dARB", "glVertexAttrib4NubARB", "glVertexAttrib1fvARB", "glVertexAttrib1svARB", "glVertexAttrib1dvARB", "glVertexAttrib2fvARB", "glVertexAttrib2svARB", "glVertexAttrib2dvARB", "glVertexAttrib3fvARB", "glVertexAttrib3svARB", "glVertexAttrib3dvARB", "glVertexAttrib4fvARB", "glVertexAttrib4svARB", "glVertexAttrib4dvARB", "glVertexAttrib4ivARB", "glVertexAttrib4bvARB", "glVertexAttrib4ubvARB", "glVertexAttrib4usvARB", "glVertexAttrib4uivARB", "glVertexAttrib4NbvARB", "glVertexAttrib4NsvARB", "glVertexAttrib4NivARB", "glVertexAttrib4NubvARB", "glVertexAttrib4NusvARB", "glVertexAttrib4NuivARB", "glVertexAttribPointerARB", "glEnableVertexAttribArrayARB", "glDisableVertexAttribArrayARB", "glBindAttribLocationARB", "glGetActiveAttribARB", "glGetAttribLocationARB", "glGetVertexAttribivARB", "glGetVertexAttribfvARB", "glGetVertexAttribdvARB", "glGetVertexAttribPointervARB") || Checks.reportMissing("GL", "GL_ARB_vertex_shader");
    }

    private static boolean check_ARB_vertex_type_2_10_10_10_rev(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set, boolean bl2) {
        if (!set.contains("GL_ARB_vertex_type_2_10_10_10_rev")) {
            return false;
        }
        return (bl2 || Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715}, "glVertexP2ui", "glVertexP3ui", "glVertexP4ui", "glVertexP2uiv", "glVertexP3uiv", "glVertexP4uiv", "glTexCoordP1ui", "glTexCoordP2ui", "glTexCoordP3ui", "glTexCoordP4ui", "glTexCoordP1uiv", "glTexCoordP2uiv", "glTexCoordP3uiv", "glTexCoordP4uiv", "glMultiTexCoordP1ui", "glMultiTexCoordP2ui", "glMultiTexCoordP3ui", "glMultiTexCoordP4ui", "glMultiTexCoordP1uiv", "glMultiTexCoordP2uiv", "glMultiTexCoordP3uiv", "glMultiTexCoordP4uiv", "glNormalP3ui", "glNormalP3uiv", "glColorP3ui", "glColorP4ui", "glColorP3uiv", "glColorP4uiv", "glSecondaryColorP3ui", "glSecondaryColorP3uiv")) && Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{716, 717, 718, 719, 720, 721, 722, 723}, "glVertexAttribP1ui", "glVertexAttribP2ui", "glVertexAttribP3ui", "glVertexAttribP4ui", "glVertexAttribP1uiv", "glVertexAttribP2uiv", "glVertexAttribP3uiv", "glVertexAttribP4uiv") || Checks.reportMissing("GL", "GL_ARB_vertex_type_2_10_10_10_rev");
    }

    private static boolean check_ARB_viewport_array(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_viewport_array")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{848, 849, 850, 851, 852, 853, 854, 855, 856, 857}, "glViewportArrayv", "glViewportIndexedf", "glViewportIndexedfv", "glScissorArrayv", "glScissorIndexed", "glScissorIndexedv", "glDepthRangeArrayv", "glDepthRangeIndexed", "glGetFloati_v", "glGetDoublei_v") || Checks.reportMissing("GL", "GL_ARB_viewport_array");
    }

    private static boolean check_ARB_window_pos(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_ARB_window_pos")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1477, 1478, 1479, 1480, 1481, 1482, 1483, 1484, 1485, 1486, 1487, 1488, 1489, 1490, 1491, 1492}, "glWindowPos2iARB", "glWindowPos2sARB", "glWindowPos2fARB", "glWindowPos2dARB", "glWindowPos2ivARB", "glWindowPos2svARB", "glWindowPos2fvARB", "glWindowPos2dvARB", "glWindowPos3iARB", "glWindowPos3sARB", "glWindowPos3fARB", "glWindowPos3dARB", "glWindowPos3ivARB", "glWindowPos3svARB", "glWindowPos3fvARB", "glWindowPos3dvARB") || Checks.reportMissing("GL", "GL_ARB_window_pos");
    }

    private static boolean check_EXT_bindable_uniform(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_bindable_uniform")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1493, 1494, 1495}, "glUniformBufferEXT", "glGetUniformBufferSizeEXT", "glGetUniformOffsetEXT") || Checks.reportMissing("GL", "GL_EXT_bindable_uniform");
    }

    private static boolean check_EXT_blend_color(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_blend_color")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1496}, "glBlendColorEXT") || Checks.reportMissing("GL", "GL_EXT_blend_color");
    }

    private static boolean check_EXT_blend_equation_separate(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_blend_equation_separate")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1497}, "glBlendEquationSeparateEXT") || Checks.reportMissing("GL", "GL_EXT_blend_equation_separate");
    }

    private static boolean check_EXT_blend_func_separate(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_blend_func_separate")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1498}, "glBlendFuncSeparateEXT") || Checks.reportMissing("GL", "GL_EXT_blend_func_separate");
    }

    private static boolean check_EXT_blend_minmax(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_blend_minmax")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1499}, "glBlendEquationEXT") || Checks.reportMissing("GL", "GL_EXT_blend_minmax");
    }

    private static boolean check_EXT_compiled_vertex_array(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_compiled_vertex_array")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1500, 1501}, "glLockArraysEXT", "glUnlockArraysEXT") || Checks.reportMissing("GL", "GL_EXT_compiled_vertex_array");
    }

    private static boolean check_EXT_debug_label(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_debug_label")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1502, 1503}, "glLabelObjectEXT", "glGetObjectLabelEXT") || Checks.reportMissing("GL", "GL_EXT_debug_label");
    }

    private static boolean check_EXT_debug_marker(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_debug_marker")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1504, 1505, 1506}, "glInsertEventMarkerEXT", "glPushGroupMarkerEXT", "glPopGroupMarkerEXT") || Checks.reportMissing("GL", "GL_EXT_debug_marker");
    }

    private static boolean check_EXT_depth_bounds_test(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_depth_bounds_test")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1507}, "glDepthBoundsEXT") || Checks.reportMissing("GL", "GL_EXT_depth_bounds_test");
    }

    private static boolean check_EXT_direct_state_access(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_direct_state_access")) {
            return false;
        }
        int n2 = set.contains("OpenGL12") ? 0 : Integer.MIN_VALUE;
        int n3 = set.contains("OpenGL13") ? 0 : Integer.MIN_VALUE;
        int n4 = set.contains("OpenGL30") ? 0 : Integer.MIN_VALUE;
        int n5 = set.contains("GL_ARB_vertex_program") ? 0 : Integer.MIN_VALUE;
        int n6 = set.contains("OpenGL15") ? 0 : Integer.MIN_VALUE;
        int n7 = set.contains("OpenGL20") ? 0 : Integer.MIN_VALUE;
        int n8 = set.contains("OpenGL21") ? 0 : Integer.MIN_VALUE;
        int n9 = set.contains("GL_EXT_texture_buffer_object") ? 0 : Integer.MIN_VALUE;
        int n10 = set.contains("GL_EXT_texture_integer") ? 0 : Integer.MIN_VALUE;
        int n11 = set.contains("GL_EXT_gpu_shader4") ? 0 : Integer.MIN_VALUE;
        int n12 = set.contains("GL_EXT_gpu_program_parameters") ? 0 : Integer.MIN_VALUE;
        int n13 = set.contains("GL_NV_gpu_program4") ? 0 : Integer.MIN_VALUE;
        int n14 = set.contains("GL_NV_framebuffer_multisample_coverage") ? 0 : Integer.MIN_VALUE;
        int n15 = set.contains("GL_EXT_geometry_shader4") || set.contains("GL_NV_gpu_program4") ? 0 : Integer.MIN_VALUE;
        int n16 = set.contains("GL_NV_explicit_multisample") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1508, 1509, 1510, 1511, 1512, 1513, 1514, 1515, 1516, 1517, 1518, 1519, 1520, 1521, 1522, 1523, 1524, 1525, 1526, 1527, 1528, 1529, 1530, 1531, 1532, 1533, 1534, 1535, 1536, 1537, 1538, 1539, 1540, 1541, n2 + 1542, n2 + 1543, n2 + 1544, n3 + 1545, n3 + 1546, n3 + 1547, n3 + 1548, n3 + 1549, n3 + 1550, n3 + 1551, n3 + 1552, n3 + 1553, n3 + 1554, n3 + 1555, n3 + 1556, n3 + 1557, n3 + 1558, n3 + 1559, n3 + 1560, n3 + 1561, n3 + 1562, n3 + 1563, n3 + 1564, n3 + 1565, n3 + 1566, n3 + 1567, n3 + 1568, n3 + 1569, n3 + 1570, n3 + 1571, n3 + 1572, n3 + 1573, n3 + 1574, n3 + 1575, n3 + 1576, n3 + 1577, n3 + 1578, n3 + 1579, n3 + 1580, n3 + 1581, n3 + 1582, n3 + 1583, n3 + 1586, n3 + 1587, n3 + 1588, n3 + 1592, n3 + 1593, n3 + 1594, n3 + 1595, n3 + 1596, n5 + 1597, n5 + 1598, n5 + 1599, n5 + 1600, n5 + 1601, n5 + 1602, n5 + 1603, n5 + 1604, n5 + 1605, n3 + 1606, n3 + 1607, n3 + 1608, n3 + 1609, n3 + 1610, n3 + 1611, n3 + 1612, n3 + 1613, n3 + 1614, n3 + 1615, n3 + 1616, n3 + 1617, n3 + 1618, n3 + 1619, n3 + 1620, n3 + 1621, n3 + 1622, n3 + 1623, n6 + 1624, n6 + 1625, n6 + 1626, n6 + 1627, n6 + 1628, n6 + 1629, n7 + 1630, n7 + 1631, n7 + 1632, n7 + 1633, n7 + 1634, n7 + 1635, n7 + 1636, n7 + 1637, n7 + 1638, n7 + 1639, n7 + 1640, n7 + 1641, n7 + 1642, n7 + 1643, n7 + 1644, n7 + 1645, n7 + 1646, n7 + 1647, n7 + 1648, n8 + 1649, n8 + 1650, n8 + 1651, n8 + 1652, n8 + 1653, n8 + 1654, n9 + 1655, n9 + 1656, n10 + 1657, n10 + 1658, n10 + 1659, n10 + 1660, n10 + 1661, n10 + 1662, n10 + 1663, n10 + 1664, n11 + 1665, n11 + 1666, n11 + 1667, n11 + 1668, n11 + 1669, n11 + 1670, n11 + 1671, n11 + 1672, n12 + 1673, n13 + 1674, n13 + 1675, n13 + 1676, n13 + 1677, n13 + 1678, n13 + 1679, n13 + 1680, n13 + 1681, n4 + 1682, n4 + 1683, n4 + 1684, n14 + 1685, n4 + 1686, n4 + 1687, n4 + 1688, n4 + 1689, n4 + 1690, n4 + 1691, n4 + 1692, n4 + 1693, n4 + 1694, n4 + 1695, n4 + 1696, n4 + 1697, n4 + 1698, n15 + 1699, n15 + 1700, n15 + 1701, n16 + 1702, n16 + 1703, n4 + 1704, n4 + 1705, n4 + 1706, n4 + 1707, n4 + 1708, n4 + 1709, n4 + 1710, n4 + 1711, n4 + 1712, n4 + 1713, n4 + 1714, n4 + 1715, n4 + 1716, n4 + 1717, n4 + 1718, n4 + 1719, n4 + 1720, n4 + 1721, n4 + 1722, n4 + 1723, n4 + 1724}, "glClientAttribDefaultEXT", "glPushClientAttribDefaultEXT", "glMatrixLoadfEXT", "glMatrixLoaddEXT", "glMatrixMultfEXT", "glMatrixMultdEXT", "glMatrixLoadIdentityEXT", "glMatrixRotatefEXT", "glMatrixRotatedEXT", "glMatrixScalefEXT", "glMatrixScaledEXT", "glMatrixTranslatefEXT", "glMatrixTranslatedEXT", "glMatrixOrthoEXT", "glMatrixFrustumEXT", "glMatrixPushEXT", "glMatrixPopEXT", "glTextureParameteriEXT", "glTextureParameterivEXT", "glTextureParameterfEXT", "glTextureParameterfvEXT", "glTextureImage1DEXT", "glTextureImage2DEXT", "glTextureSubImage1DEXT", "glTextureSubImage2DEXT", "glCopyTextureImage1DEXT", "glCopyTextureImage2DEXT", "glCopyTextureSubImage1DEXT", "glCopyTextureSubImage2DEXT", "glGetTextureImageEXT", "glGetTextureParameterfvEXT", "glGetTextureParameterivEXT", "glGetTextureLevelParameterfvEXT", "glGetTextureLevelParameterivEXT", "glTextureImage3DEXT", "glTextureSubImage3DEXT", "glCopyTextureSubImage3DEXT", "glBindMultiTextureEXT", "glMultiTexCoordPointerEXT", "glMultiTexEnvfEXT", "glMultiTexEnvfvEXT", "glMultiTexEnviEXT", "glMultiTexEnvivEXT", "glMultiTexGendEXT", "glMultiTexGendvEXT", "glMultiTexGenfEXT", "glMultiTexGenfvEXT", "glMultiTexGeniEXT", "glMultiTexGenivEXT", "glGetMultiTexEnvfvEXT", "glGetMultiTexEnvivEXT", "glGetMultiTexGendvEXT", "glGetMultiTexGenfvEXT", "glGetMultiTexGenivEXT", "glMultiTexParameteriEXT", "glMultiTexParameterivEXT", "glMultiTexParameterfEXT", "glMultiTexParameterfvEXT", "glMultiTexImage1DEXT", "glMultiTexImage2DEXT", "glMultiTexSubImage1DEXT", "glMultiTexSubImage2DEXT", "glCopyMultiTexImage1DEXT", "glCopyMultiTexImage2DEXT", "glCopyMultiTexSubImage1DEXT", "glCopyMultiTexSubImage2DEXT", "glGetMultiTexImageEXT", "glGetMultiTexParameterfvEXT", "glGetMultiTexParameterivEXT", "glGetMultiTexLevelParameterfvEXT", "glGetMultiTexLevelParameterivEXT", "glMultiTexImage3DEXT", "glMultiTexSubImage3DEXT", "glCopyMultiTexSubImage3DEXT", "glEnableClientStateIndexedEXT", "glDisableClientStateIndexedEXT", "glGetFloatIndexedvEXT", "glGetDoubleIndexedvEXT", "glGetPointerIndexedvEXT", "glEnableIndexedEXT", "glDisableIndexedEXT", "glIsEnabledIndexedEXT", "glGetIntegerIndexedvEXT", "glGetBooleanIndexedvEXT", "glNamedProgramStringEXT", "glNamedProgramLocalParameter4dEXT", "glNamedProgramLocalParameter4dvEXT", "glNamedProgramLocalParameter4fEXT", "glNamedProgramLocalParameter4fvEXT", "glGetNamedProgramLocalParameterdvEXT", "glGetNamedProgramLocalParameterfvEXT", "glGetNamedProgramivEXT", "glGetNamedProgramStringEXT", "glCompressedTextureImage3DEXT", "glCompressedTextureImage2DEXT", "glCompressedTextureImage1DEXT", "glCompressedTextureSubImage3DEXT", "glCompressedTextureSubImage2DEXT", "glCompressedTextureSubImage1DEXT", "glGetCompressedTextureImageEXT", "glCompressedMultiTexImage3DEXT", "glCompressedMultiTexImage2DEXT", "glCompressedMultiTexImage1DEXT", "glCompressedMultiTexSubImage3DEXT", "glCompressedMultiTexSubImage2DEXT", "glCompressedMultiTexSubImage1DEXT", "glGetCompressedMultiTexImageEXT", "glMatrixLoadTransposefEXT", "glMatrixLoadTransposedEXT", "glMatrixMultTransposefEXT", "glMatrixMultTransposedEXT", "glNamedBufferDataEXT", "glNamedBufferSubDataEXT", "glMapNamedBufferEXT", "glUnmapNamedBufferEXT", "glGetNamedBufferParameterivEXT", "glGetNamedBufferSubDataEXT", "glProgramUniform1fEXT", "glProgramUniform2fEXT", "glProgramUniform3fEXT", "glProgramUniform4fEXT", "glProgramUniform1iEXT", "glProgramUniform2iEXT", "glProgramUniform3iEXT", "glProgramUniform4iEXT", "glProgramUniform1fvEXT", "glProgramUniform2fvEXT", "glProgramUniform3fvEXT", "glProgramUniform4fvEXT", "glProgramUniform1ivEXT", "glProgramUniform2ivEXT", "glProgramUniform3ivEXT", "glProgramUniform4ivEXT", "glProgramUniformMatrix2fvEXT", "glProgramUniformMatrix3fvEXT", "glProgramUniformMatrix4fvEXT", "glProgramUniformMatrix2x3fvEXT", "glProgramUniformMatrix3x2fvEXT", "glProgramUniformMatrix2x4fvEXT", "glProgramUniformMatrix4x2fvEXT", "glProgramUniformMatrix3x4fvEXT", "glProgramUniformMatrix4x3fvEXT", "glTextureBufferEXT", "glMultiTexBufferEXT", "glTextureParameterIivEXT", "glTextureParameterIuivEXT", "glGetTextureParameterIivEXT", "glGetTextureParameterIuivEXT", "glMultiTexParameterIivEXT", "glMultiTexParameterIuivEXT", "glGetMultiTexParameterIivEXT", "glGetMultiTexParameterIuivEXT", "glProgramUniform1uiEXT", "glProgramUniform2uiEXT", "glProgramUniform3uiEXT", "glProgramUniform4uiEXT", "glProgramUniform1uivEXT", "glProgramUniform2uivEXT", "glProgramUniform3uivEXT", "glProgramUniform4uivEXT", "glNamedProgramLocalParameters4fvEXT", "glNamedProgramLocalParameterI4iEXT", "glNamedProgramLocalParameterI4ivEXT", "glNamedProgramLocalParametersI4ivEXT", "glNamedProgramLocalParameterI4uiEXT", "glNamedProgramLocalParameterI4uivEXT", "glNamedProgramLocalParametersI4uivEXT", "glGetNamedProgramLocalParameterIivEXT", "glGetNamedProgramLocalParameterIuivEXT", "glNamedRenderbufferStorageEXT", "glGetNamedRenderbufferParameterivEXT", "glNamedRenderbufferStorageMultisampleEXT", "glNamedRenderbufferStorageMultisampleCoverageEXT", "glCheckNamedFramebufferStatusEXT", "glNamedFramebufferTexture1DEXT", "glNamedFramebufferTexture2DEXT", "glNamedFramebufferTexture3DEXT", "glNamedFramebufferRenderbufferEXT", "glGetNamedFramebufferAttachmentParameterivEXT", "glGenerateTextureMipmapEXT", "glGenerateMultiTexMipmapEXT", "glFramebufferDrawBufferEXT", "glFramebufferDrawBuffersEXT", "glFramebufferReadBufferEXT", "glGetFramebufferParameterivEXT", "glNamedCopyBufferSubDataEXT", "glNamedFramebufferTextureEXT", "glNamedFramebufferTextureLayerEXT", "glNamedFramebufferTextureFaceEXT", "glTextureRenderbufferEXT", "glMultiTexRenderbufferEXT", "glVertexArrayVertexOffsetEXT", "glVertexArrayColorOffsetEXT", "glVertexArrayEdgeFlagOffsetEXT", "glVertexArrayIndexOffsetEXT", "glVertexArrayNormalOffsetEXT", "glVertexArrayTexCoordOffsetEXT", "glVertexArrayMultiTexCoordOffsetEXT", "glVertexArrayFogCoordOffsetEXT", "glVertexArraySecondaryColorOffsetEXT", "glVertexArrayVertexAttribOffsetEXT", "glVertexArrayVertexAttribIOffsetEXT", "glEnableVertexArrayEXT", "glDisableVertexArrayEXT", "glEnableVertexArrayAttribEXT", "glDisableVertexArrayAttribEXT", "glGetVertexArrayIntegervEXT", "glGetVertexArrayPointervEXT", "glGetVertexArrayIntegeri_vEXT", "glGetVertexArrayPointeri_vEXT", "glMapNamedBufferRangeEXT", "glFlushMappedNamedBufferRangeEXT") || Checks.reportMissing("GL", "GL_EXT_direct_state_access");
    }

    private static boolean check_EXT_draw_buffers2(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_draw_buffers2")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1725, 1596, 1595, 1592, 1593, 1594}, "glColorMaskIndexedEXT", "glGetBooleanIndexedvEXT", "glGetIntegerIndexedvEXT", "glEnableIndexedEXT", "glDisableIndexedEXT", "glIsEnabledIndexedEXT") || Checks.reportMissing("GL", "GL_EXT_draw_buffers2");
    }

    private static boolean check_EXT_draw_instanced(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_draw_instanced")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1726, 1727}, "glDrawArraysInstancedEXT", "glDrawElementsInstancedEXT") || Checks.reportMissing("GL", "GL_EXT_draw_instanced");
    }

    private static boolean check_EXT_EGL_image_storage(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_EGL_image_storage")) {
            return false;
        }
        int n2 = GLCapabilities.hasDSA(set) ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1728, n2 + 1729}, "glEGLImageTargetTexStorageEXT", "glEGLImageTargetTextureStorageEXT") || Checks.reportMissing("GL", "GL_EXT_EGL_image_storage");
    }

    private static boolean check_EXT_external_buffer(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_external_buffer")) {
            return false;
        }
        int n2 = GLCapabilities.hasDSA(set) ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1730, n2 + 1731}, "glBufferStorageExternalEXT", "glNamedBufferStorageExternalEXT") || Checks.reportMissing("GL", "GL_EXT_external_buffer");
    }

    private static boolean check_EXT_framebuffer_blit(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_framebuffer_blit")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1732}, "glBlitFramebufferEXT") || Checks.reportMissing("GL", "GL_EXT_framebuffer_blit");
    }

    private static boolean check_EXT_framebuffer_multisample(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_framebuffer_multisample")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1733}, "glRenderbufferStorageMultisampleEXT") || Checks.reportMissing("GL", "GL_EXT_framebuffer_multisample");
    }

    private static boolean check_EXT_framebuffer_object(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_framebuffer_object")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1734, 1735, 1736, 1737, 1738, 1739, 1740, 1741, 1742, 1743, 1744, 1745, 1746, 1747, 1748, 1749, 1750}, "glIsRenderbufferEXT", "glBindRenderbufferEXT", "glDeleteRenderbuffersEXT", "glGenRenderbuffersEXT", "glRenderbufferStorageEXT", "glGetRenderbufferParameterivEXT", "glIsFramebufferEXT", "glBindFramebufferEXT", "glDeleteFramebuffersEXT", "glGenFramebuffersEXT", "glCheckFramebufferStatusEXT", "glFramebufferTexture1DEXT", "glFramebufferTexture2DEXT", "glFramebufferTexture3DEXT", "glFramebufferRenderbufferEXT", "glGetFramebufferAttachmentParameterivEXT", "glGenerateMipmapEXT") || Checks.reportMissing("GL", "GL_EXT_framebuffer_object");
    }

    private static boolean check_EXT_geometry_shader4(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_geometry_shader4")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1751, 1752, 1753, 1754}, "glProgramParameteriEXT", "glFramebufferTextureEXT", "glFramebufferTextureLayerEXT", "glFramebufferTextureFaceEXT") || Checks.reportMissing("GL", "GL_EXT_geometry_shader4");
    }

    private static boolean check_EXT_gpu_program_parameters(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_gpu_program_parameters")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1755, 1756}, "glProgramEnvParameters4fvEXT", "glProgramLocalParameters4fvEXT") || Checks.reportMissing("GL", "GL_EXT_gpu_program_parameters");
    }

    private static boolean check_EXT_gpu_shader4(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_gpu_shader4")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1757, 1758, 1759, 1760, 1761, 1762, 1763, 1764, 1765, 1766, 1767, 1768, 1769, 1770, 1771, 1772, 1773, 1774, 1775, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785, 1786, 1787, 1788, 1789, 1790}, "glVertexAttribI1iEXT", "glVertexAttribI2iEXT", "glVertexAttribI3iEXT", "glVertexAttribI4iEXT", "glVertexAttribI1uiEXT", "glVertexAttribI2uiEXT", "glVertexAttribI3uiEXT", "glVertexAttribI4uiEXT", "glVertexAttribI1ivEXT", "glVertexAttribI2ivEXT", "glVertexAttribI3ivEXT", "glVertexAttribI4ivEXT", "glVertexAttribI1uivEXT", "glVertexAttribI2uivEXT", "glVertexAttribI3uivEXT", "glVertexAttribI4uivEXT", "glVertexAttribI4bvEXT", "glVertexAttribI4svEXT", "glVertexAttribI4ubvEXT", "glVertexAttribI4usvEXT", "glVertexAttribIPointerEXT", "glGetVertexAttribIivEXT", "glGetVertexAttribIuivEXT", "glGetUniformuivEXT", "glBindFragDataLocationEXT", "glGetFragDataLocationEXT", "glUniform1uiEXT", "glUniform2uiEXT", "glUniform3uiEXT", "glUniform4uiEXT", "glUniform1uivEXT", "glUniform2uivEXT", "glUniform3uivEXT", "glUniform4uivEXT") || Checks.reportMissing("GL", "GL_EXT_gpu_shader4");
    }

    private static boolean check_EXT_memory_object(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_memory_object")) {
            return false;
        }
        int n2 = GLCapabilities.hasDSA(set) ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1791, 1792, 1793, 1794, 1795, 1796, 1797, 1798, 1799, 1800, 1801, 1802, n2 + 1803, n2 + 1804, n2 + 1805, n2 + 1806, n2 + 1807, 1808, n2 + 1809}, "glGetUnsignedBytevEXT", "glGetUnsignedBytei_vEXT", "glDeleteMemoryObjectsEXT", "glIsMemoryObjectEXT", "glCreateMemoryObjectsEXT", "glMemoryObjectParameterivEXT", "glGetMemoryObjectParameterivEXT", "glTexStorageMem2DEXT", "glTexStorageMem2DMultisampleEXT", "glTexStorageMem3DEXT", "glTexStorageMem3DMultisampleEXT", "glBufferStorageMemEXT", "glTextureStorageMem2DEXT", "glTextureStorageMem2DMultisampleEXT", "glTextureStorageMem3DEXT", "glTextureStorageMem3DMultisampleEXT", "glNamedBufferStorageMemEXT", "glTexStorageMem1DEXT", "glTextureStorageMem1DEXT") || Checks.reportMissing("GL", "GL_EXT_memory_object");
    }

    private static boolean check_EXT_memory_object_fd(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_memory_object_fd")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1810}, "glImportMemoryFdEXT") || Checks.reportMissing("GL", "GL_EXT_memory_object_fd");
    }

    private static boolean check_EXT_memory_object_win32(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_memory_object_win32")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1811, 1812}, "glImportMemoryWin32HandleEXT", "glImportMemoryWin32NameEXT") || Checks.reportMissing("GL", "GL_EXT_memory_object_win32");
    }

    private static boolean check_EXT_point_parameters(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_point_parameters")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1813, 1814}, "glPointParameterfEXT", "glPointParameterfvEXT") || Checks.reportMissing("GL", "GL_EXT_point_parameters");
    }

    private static boolean check_EXT_polygon_offset_clamp(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_polygon_offset_clamp")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1815}, "glPolygonOffsetClampEXT") || Checks.reportMissing("GL", "GL_EXT_polygon_offset_clamp");
    }

    private static boolean check_EXT_provoking_vertex(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_provoking_vertex")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1816}, "glProvokingVertexEXT") || Checks.reportMissing("GL", "GL_EXT_provoking_vertex");
    }

    private static boolean check_EXT_raster_multisample(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_raster_multisample")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1817}, "glRasterSamplesEXT") || Checks.reportMissing("GL", "GL_EXT_raster_multisample");
    }

    private static boolean check_EXT_secondary_color(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_secondary_color")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1818, 1819, 1820, 1821, 1822, 1823, 1824, 1825, 1826, 1827, 1828, 1829, 1830, 1831, 1832, 1833, 1834}, "glSecondaryColor3bEXT", "glSecondaryColor3sEXT", "glSecondaryColor3iEXT", "glSecondaryColor3fEXT", "glSecondaryColor3dEXT", "glSecondaryColor3ubEXT", "glSecondaryColor3usEXT", "glSecondaryColor3uiEXT", "glSecondaryColor3bvEXT", "glSecondaryColor3svEXT", "glSecondaryColor3ivEXT", "glSecondaryColor3fvEXT", "glSecondaryColor3dvEXT", "glSecondaryColor3ubvEXT", "glSecondaryColor3usvEXT", "glSecondaryColor3uivEXT", "glSecondaryColorPointerEXT") || Checks.reportMissing("GL", "GL_EXT_secondary_color");
    }

    private static boolean check_EXT_semaphore(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_semaphore")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1791, 1792, 1835, 1836, 1837, 1838, 1839, 1840, 1841}, "glGetUnsignedBytevEXT", "glGetUnsignedBytei_vEXT", "glGenSemaphoresEXT", "glDeleteSemaphoresEXT", "glIsSemaphoreEXT", "glSemaphoreParameterui64vEXT", "glGetSemaphoreParameterui64vEXT", "glWaitSemaphoreEXT", "glSignalSemaphoreEXT") || Checks.reportMissing("GL", "GL_EXT_semaphore");
    }

    private static boolean check_EXT_semaphore_fd(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_semaphore_fd")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1842}, "glImportSemaphoreFdEXT") || Checks.reportMissing("GL", "GL_EXT_semaphore_fd");
    }

    private static boolean check_EXT_semaphore_win32(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_semaphore_win32")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1843, 1844}, "glImportSemaphoreWin32HandleEXT", "glImportSemaphoreWin32NameEXT") || Checks.reportMissing("GL", "GL_EXT_semaphore_win32");
    }

    private static boolean check_EXT_separate_shader_objects(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_separate_shader_objects")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1845, 1846, 1847}, "glUseShaderProgramEXT", "glActiveProgramEXT", "glCreateShaderProgramEXT") || Checks.reportMissing("GL", "GL_EXT_separate_shader_objects");
    }

    private static boolean check_EXT_shader_framebuffer_fetch_non_coherent(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_shader_framebuffer_fetch_non_coherent")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1848}, "glFramebufferFetchBarrierEXT") || Checks.reportMissing("GL", "GL_EXT_shader_framebuffer_fetch_non_coherent");
    }

    private static boolean check_EXT_shader_image_load_store(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_shader_image_load_store")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1849, 1850}, "glBindImageTextureEXT", "glMemoryBarrierEXT") || Checks.reportMissing("GL", "GL_EXT_shader_image_load_store");
    }

    private static boolean check_EXT_stencil_clear_tag(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_stencil_clear_tag")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1851}, "glStencilClearTagEXT") || Checks.reportMissing("GL", "GL_EXT_stencil_clear_tag");
    }

    private static boolean check_EXT_stencil_two_side(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_stencil_two_side")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1852}, "glActiveStencilFaceEXT") || Checks.reportMissing("GL", "GL_EXT_stencil_two_side");
    }

    private static boolean check_EXT_texture_array(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_texture_array")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1753}, "glFramebufferTextureLayerEXT") || Checks.reportMissing("GL", "GL_EXT_texture_array");
    }

    private static boolean check_EXT_texture_buffer_object(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_texture_buffer_object")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1853}, "glTexBufferEXT") || Checks.reportMissing("GL", "GL_EXT_texture_buffer_object");
    }

    private static boolean check_EXT_texture_integer(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_texture_integer")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1854, 1855, 1856, 1857, 1858, 1859}, "glClearColorIiEXT", "glClearColorIuiEXT", "glTexParameterIivEXT", "glTexParameterIuivEXT", "glGetTexParameterIivEXT", "glGetTexParameterIuivEXT") || Checks.reportMissing("GL", "GL_EXT_texture_integer");
    }

    private static boolean check_EXT_texture_storage(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_texture_storage")) {
            return false;
        }
        int n2 = GLCapabilities.hasDSA(set) ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1860, 1861, 1862, n2 + 1375, n2 + 1376, n2 + 1377}, "glTexStorage1DEXT", "glTexStorage2DEXT", "glTexStorage3DEXT", "glTextureStorage1DEXT", "glTextureStorage2DEXT", "glTextureStorage3DEXT") || Checks.reportMissing("GL", "GL_EXT_texture_storage");
    }

    private static boolean check_EXT_timer_query(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_timer_query")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1863, 1864}, "glGetQueryObjecti64vEXT", "glGetQueryObjectui64vEXT") || Checks.reportMissing("GL", "GL_EXT_timer_query");
    }

    private static boolean check_EXT_transform_feedback(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_transform_feedback")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1865, 1866, 1867, 1868, 1869, 1870, 1871, 1595, 1596}, "glBindBufferRangeEXT", "glBindBufferOffsetEXT", "glBindBufferBaseEXT", "glBeginTransformFeedbackEXT", "glEndTransformFeedbackEXT", "glTransformFeedbackVaryingsEXT", "glGetTransformFeedbackVaryingEXT", "glGetIntegerIndexedvEXT", "glGetBooleanIndexedvEXT") || Checks.reportMissing("GL", "GL_EXT_transform_feedback");
    }

    private static boolean check_EXT_vertex_attrib_64bit(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_vertex_attrib_64bit")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1872, 1873, 1874, 1875, 1876, 1877, 1878, 1879, 1880, 1881, n2 + 1384}, "glVertexAttribL1dEXT", "glVertexAttribL2dEXT", "glVertexAttribL3dEXT", "glVertexAttribL4dEXT", "glVertexAttribL1dvEXT", "glVertexAttribL2dvEXT", "glVertexAttribL3dvEXT", "glVertexAttribL4dvEXT", "glVertexAttribLPointerEXT", "glGetVertexAttribLdvEXT", "glVertexArrayVertexAttribLOffsetEXT") || Checks.reportMissing("GL", "GL_EXT_vertex_attrib_64bit");
    }

    private static boolean check_EXT_win32_keyed_mutex(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_win32_keyed_mutex")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1882, 1883}, "glAcquireKeyedMutexWin32EXT", "glReleaseKeyedMutexWin32EXT") || Checks.reportMissing("GL", "GL_EXT_win32_keyed_mutex");
    }

    private static boolean check_EXT_window_rectangles(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_window_rectangles")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1884}, "glWindowRectanglesEXT") || Checks.reportMissing("GL", "GL_EXT_window_rectangles");
    }

    private static boolean check_EXT_x11_sync_object(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_EXT_x11_sync_object")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1885}, "glImportSyncEXT") || Checks.reportMissing("GL", "GL_EXT_x11_sync_object");
    }

    private static boolean check_GREMEDY_frame_terminator(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_GREMEDY_frame_terminator")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1886}, "glFrameTerminatorGREMEDY") || Checks.reportMissing("GL", "GL_GREMEDY_frame_terminator");
    }

    private static boolean check_GREMEDY_string_marker(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_GREMEDY_string_marker")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1887}, "glStringMarkerGREMEDY") || Checks.reportMissing("GL", "GL_GREMEDY_string_marker");
    }

    private static boolean check_INTEL_framebuffer_CMAA(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_INTEL_framebuffer_CMAA")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1888}, "glApplyFramebufferAttachmentCMAAINTEL") || Checks.reportMissing("GL", "GL_INTEL_framebuffer_CMAA");
    }

    private static boolean check_INTEL_map_texture(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_INTEL_map_texture")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1889, 1890, 1891}, "glSyncTextureINTEL", "glUnmapTexture2DINTEL", "glMapTexture2DINTEL") || Checks.reportMissing("GL", "GL_INTEL_map_texture");
    }

    private static boolean check_INTEL_performance_query(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_INTEL_performance_query")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1892, 1893, 1894, 1895, 1896, 1897, 1898, 1899, 1900, 1901}, "glBeginPerfQueryINTEL", "glCreatePerfQueryINTEL", "glDeletePerfQueryINTEL", "glEndPerfQueryINTEL", "glGetFirstPerfQueryIdINTEL", "glGetNextPerfQueryIdINTEL", "glGetPerfCounterInfoINTEL", "glGetPerfQueryDataINTEL", "glGetPerfQueryIdByNameINTEL", "glGetPerfQueryInfoINTEL") || Checks.reportMissing("GL", "GL_INTEL_performance_query");
    }

    private static boolean check_KHR_blend_equation_advanced(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_KHR_blend_equation_advanced")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1902}, "glBlendBarrierKHR") || Checks.reportMissing("GL", "GL_KHR_blend_equation_advanced");
    }

    private static boolean check_KHR_debug(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_KHR_debug")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{875, 876, 877, 878, 879, 880, 881, 882, 883, 884}, "glDebugMessageControl", "glDebugMessageInsert", "glDebugMessageCallback", "glGetDebugMessageLog", "glPushDebugGroup", "glPopDebugGroup", "glObjectLabel", "glGetObjectLabel", "glObjectPtrLabel", "glGetObjectPtrLabel") || Checks.reportMissing("GL", "GL_KHR_debug");
    }

    private static boolean check_KHR_parallel_shader_compile(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_KHR_parallel_shader_compile")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1903}, "glMaxShaderCompilerThreadsKHR") || Checks.reportMissing("GL", "GL_KHR_parallel_shader_compile");
    }

    private static boolean check_KHR_robustness(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_KHR_robustness")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1024, 1033, 1040, 1042, 1043}, "glGetGraphicsResetStatus", "glReadnPixels", "glGetnUniformfv", "glGetnUniformiv", "glGetnUniformuiv") || Checks.reportMissing("GL", "GL_KHR_robustness");
    }

    private static boolean check_MESA_framebuffer_flip_y(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_MESA_framebuffer_flip_y")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1904, 1905}, "glFramebufferParameteriMESA", "glGetFramebufferParameterivMESA") || Checks.reportMissing("GL", "GL_MESA_framebuffer_flip_y");
    }

    private static boolean check_NV_alpha_to_coverage_dither_control(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_alpha_to_coverage_dither_control")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1906}, "glAlphaToCoverageDitherControlNV") || Checks.reportMissing("GL", "GL_NV_alpha_to_coverage_dither_control");
    }

    private static boolean check_NV_bindless_multi_draw_indirect(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_bindless_multi_draw_indirect")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1907, 1908}, "glMultiDrawArraysIndirectBindlessNV", "glMultiDrawElementsIndirectBindlessNV") || Checks.reportMissing("GL", "GL_NV_bindless_multi_draw_indirect");
    }

    private static boolean check_NV_bindless_multi_draw_indirect_count(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_bindless_multi_draw_indirect_count")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1909, 1910}, "glMultiDrawArraysIndirectBindlessCountNV", "glMultiDrawElementsIndirectBindlessCountNV") || Checks.reportMissing("GL", "GL_NV_bindless_multi_draw_indirect_count");
    }

    private static boolean check_NV_bindless_texture(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_bindless_texture")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1911, 1912, 1913, 1914, 1915, 1916, 1917, 1918, 1919, 1920, 1921, 1922, 1923}, "glGetTextureHandleNV", "glGetTextureSamplerHandleNV", "glMakeTextureHandleResidentNV", "glMakeTextureHandleNonResidentNV", "glGetImageHandleNV", "glMakeImageHandleResidentNV", "glMakeImageHandleNonResidentNV", "glUniformHandleui64NV", "glUniformHandleui64vNV", "glProgramUniformHandleui64NV", "glProgramUniformHandleui64vNV", "glIsTextureHandleResidentNV", "glIsImageHandleResidentNV") || Checks.reportMissing("GL", "GL_NV_bindless_texture");
    }

    private static boolean check_NV_blend_equation_advanced(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_blend_equation_advanced")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1924, 1925}, "glBlendParameteriNV", "glBlendBarrierNV") || Checks.reportMissing("GL", "GL_NV_blend_equation_advanced");
    }

    private static boolean check_NV_clip_space_w_scaling(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_clip_space_w_scaling")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1926}, "glViewportPositionWScaleNV") || Checks.reportMissing("GL", "GL_NV_clip_space_w_scaling");
    }

    private static boolean check_NV_command_list(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_command_list")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1927, 1928, 1929, 1930, 1931, 1932, 1933, 1934, 1935, 1936, 1937, 1938, 1939, 1940, 1941, 1942, 1943}, "glCreateStatesNV", "glDeleteStatesNV", "glIsStateNV", "glStateCaptureNV", "glGetCommandHeaderNV", "glGetStageIndexNV", "glDrawCommandsNV", "glDrawCommandsAddressNV", "glDrawCommandsStatesNV", "glDrawCommandsStatesAddressNV", "glCreateCommandListsNV", "glDeleteCommandListsNV", "glIsCommandListNV", "glListDrawCommandsStatesClientNV", "glCommandListSegmentsNV", "glCompileCommandListNV", "glCallCommandListNV") || Checks.reportMissing("GL", "GL_NV_command_list");
    }

    private static boolean check_NV_conditional_render(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_conditional_render")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1944, 1945}, "glBeginConditionalRenderNV", "glEndConditionalRenderNV") || Checks.reportMissing("GL", "GL_NV_conditional_render");
    }

    private static boolean check_NV_conservative_raster(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_conservative_raster")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1946}, "glSubpixelPrecisionBiasNV") || Checks.reportMissing("GL", "GL_NV_conservative_raster");
    }

    private static boolean check_NV_conservative_raster_dilate(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_conservative_raster_dilate")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1947}, "glConservativeRasterParameterfNV") || Checks.reportMissing("GL", "GL_NV_conservative_raster_dilate");
    }

    private static boolean check_NV_conservative_raster_pre_snap_triangles(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_conservative_raster_pre_snap_triangles")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1948}, "glConservativeRasterParameteriNV") || Checks.reportMissing("GL", "GL_NV_conservative_raster_pre_snap_triangles");
    }

    private static boolean check_NV_copy_image(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_copy_image")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1949}, "glCopyImageSubDataNV") || Checks.reportMissing("GL", "GL_NV_copy_image");
    }

    private static boolean check_NV_depth_buffer_float(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_depth_buffer_float")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1950, 1951, 1952}, "glDepthRangedNV", "glClearDepthdNV", "glDepthBoundsdNV") || Checks.reportMissing("GL", "GL_NV_depth_buffer_float");
    }

    private static boolean check_NV_draw_texture(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_draw_texture")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1953}, "glDrawTextureNV") || Checks.reportMissing("GL", "GL_NV_draw_texture");
    }

    private static boolean check_NV_draw_vulkan_image(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_draw_vulkan_image")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1954, 1955, 1956, 1957, 1958}, "glDrawVkImageNV", "glGetVkProcAddrNV", "glWaitVkSemaphoreNV", "glSignalVkSemaphoreNV", "glSignalVkFenceNV") || Checks.reportMissing("GL", "GL_NV_draw_vulkan_image");
    }

    private static boolean check_NV_explicit_multisample(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_explicit_multisample")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1959, 1960, 1961}, "glGetMultisamplefvNV", "glSampleMaskIndexedNV", "glTexRenderbufferNV") || Checks.reportMissing("GL", "GL_NV_explicit_multisample");
    }

    private static boolean check_NV_fence(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_fence")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1962, 1963, 1964, 1965, 1966, 1967, 1968}, "glDeleteFencesNV", "glGenFencesNV", "glIsFenceNV", "glTestFenceNV", "glGetFenceivNV", "glFinishFenceNV", "glSetFenceNV") || Checks.reportMissing("GL", "GL_NV_fence");
    }

    private static boolean check_NV_fragment_coverage_to_color(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_fragment_coverage_to_color")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1969}, "glFragmentCoverageColorNV") || Checks.reportMissing("GL", "GL_NV_fragment_coverage_to_color");
    }

    private static boolean check_NV_framebuffer_mixed_samples(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_framebuffer_mixed_samples")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1817, 1970, 1971, 1972}, "glRasterSamplesEXT", "glCoverageModulationTableNV", "glGetCoverageModulationTableNV", "glCoverageModulationNV") || Checks.reportMissing("GL", "GL_NV_framebuffer_mixed_samples");
    }

    private static boolean check_NV_framebuffer_multisample_coverage(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_framebuffer_multisample_coverage")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1973}, "glRenderbufferStorageMultisampleCoverageNV") || Checks.reportMissing("GL", "GL_NV_framebuffer_multisample_coverage");
    }

    private static boolean check_NV_gpu_multicast(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_gpu_multicast")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983, 1984, 1985}, "glRenderGpuMaskNV", "glMulticastBufferSubDataNV", "glMulticastCopyBufferSubDataNV", "glMulticastCopyImageSubDataNV", "glMulticastBlitFramebufferNV", "glMulticastFramebufferSampleLocationsfvNV", "glMulticastBarrierNV", "glMulticastWaitSyncNV", "glMulticastGetQueryObjectivNV", "glMulticastGetQueryObjectuivNV", "glMulticastGetQueryObjecti64vNV", "glMulticastGetQueryObjectui64vNV") || Checks.reportMissing("GL", "GL_NV_gpu_multicast");
    }

    private static boolean check_NV_gpu_shader5(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_gpu_shader5")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068, 1069, 1070, 1071, 1072, 1073, 1074, 1075, n2 + 1076, n2 + 1077, n2 + 1078, n2 + 1079, n2 + 1080, n2 + 1081, n2 + 1082, n2 + 1083, n2 + 1084, n2 + 1085, n2 + 1086, n2 + 1087, n2 + 1088, n2 + 1089, n2 + 1090, n2 + 1091}, "glUniform1i64NV", "glUniform2i64NV", "glUniform3i64NV", "glUniform4i64NV", "glUniform1i64vNV", "glUniform2i64vNV", "glUniform3i64vNV", "glUniform4i64vNV", "glUniform1ui64NV", "glUniform2ui64NV", "glUniform3ui64NV", "glUniform4ui64NV", "glUniform1ui64vNV", "glUniform2ui64vNV", "glUniform3ui64vNV", "glUniform4ui64vNV", "glGetUniformi64vNV", "glGetUniformui64vNV", "glProgramUniform1i64NV", "glProgramUniform2i64NV", "glProgramUniform3i64NV", "glProgramUniform4i64NV", "glProgramUniform1i64vNV", "glProgramUniform2i64vNV", "glProgramUniform3i64vNV", "glProgramUniform4i64vNV", "glProgramUniform1ui64NV", "glProgramUniform2ui64NV", "glProgramUniform3ui64NV", "glProgramUniform4ui64NV", "glProgramUniform1ui64vNV", "glProgramUniform2ui64vNV", "glProgramUniform3ui64vNV", "glProgramUniform4ui64vNV") || Checks.reportMissing("GL", "GL_NV_gpu_shader5");
    }

    private static boolean check_NV_half_float(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_half_float")) {
            return false;
        }
        int n2 = set.contains("GL_EXT_fog_coord") ? 0 : Integer.MIN_VALUE;
        int n3 = set.contains("GL_EXT_secondary_color") ? 0 : Integer.MIN_VALUE;
        int n4 = set.contains("GL_EXT_vertex_weighting") ? 0 : Integer.MIN_VALUE;
        int n5 = set.contains("GL_NV_vertex_program") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, n2 + 2014, n2 + 2015, n3 + 2016, n3 + 2017, n4 + 2018, n4 + 2019, n5 + 2020, n5 + 2021, n5 + 2022, n5 + 2023, n5 + 2024, n5 + 2025, n5 + 2026, n5 + 2027, n5 + 2028, n5 + 2029, n5 + 2030, n5 + 2031}, "glVertex2hNV", "glVertex2hvNV", "glVertex3hNV", "glVertex3hvNV", "glVertex4hNV", "glVertex4hvNV", "glNormal3hNV", "glNormal3hvNV", "glColor3hNV", "glColor3hvNV", "glColor4hNV", "glColor4hvNV", "glTexCoord1hNV", "glTexCoord1hvNV", "glTexCoord2hNV", "glTexCoord2hvNV", "glTexCoord3hNV", "glTexCoord3hvNV", "glTexCoord4hNV", "glTexCoord4hvNV", "glMultiTexCoord1hNV", "glMultiTexCoord1hvNV", "glMultiTexCoord2hNV", "glMultiTexCoord2hvNV", "glMultiTexCoord3hNV", "glMultiTexCoord3hvNV", "glMultiTexCoord4hNV", "glMultiTexCoord4hvNV", "glFogCoordhNV", "glFogCoordhvNV", "glSecondaryColor3hNV", "glSecondaryColor3hvNV", "glVertexWeighthNV", "glVertexWeighthvNV", "glVertexAttrib1hNV", "glVertexAttrib1hvNV", "glVertexAttrib2hNV", "glVertexAttrib2hvNV", "glVertexAttrib3hNV", "glVertexAttrib3hvNV", "glVertexAttrib4hNV", "glVertexAttrib4hvNV", "glVertexAttribs1hvNV", "glVertexAttribs2hvNV", "glVertexAttribs3hvNV", "glVertexAttribs4hvNV") || Checks.reportMissing("GL", "GL_NV_half_float");
    }

    private static boolean check_NV_internalformat_sample_query(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_internalformat_sample_query")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2032}, "glGetInternalformatSampleivNV") || Checks.reportMissing("GL", "GL_NV_internalformat_sample_query");
    }

    private static boolean check_NV_memory_attachment(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_memory_attachment")) {
            return false;
        }
        int n2 = GLCapabilities.hasDSA(set) ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2033, 2034, 2035, 2036, n2 + 2037, n2 + 2038}, "glGetMemoryObjectDetachedResourcesuivNV", "glResetMemoryObjectParameterNV", "glTexAttachMemoryNV", "glBufferAttachMemoryNV", "glTextureAttachMemoryNV", "glNamedBufferAttachMemoryNV") || Checks.reportMissing("GL", "GL_NV_memory_attachment");
    }

    private static boolean check_NV_memory_object_sparse(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_memory_object_sparse")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2039, 2040, 2041, 2042}, "glBufferPageCommitmentMemNV", "glNamedBufferPageCommitmentMemNV", "glTexPageCommitmentMemNV", "glTexturePageCommitmentMemNV") || Checks.reportMissing("GL", "GL_NV_memory_object_sparse");
    }

    private static boolean check_NV_mesh_shader(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_mesh_shader")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2043, 2044, 2045, 2046}, "glDrawMeshTasksNV", "glDrawMeshTasksIndirectNV", "glMultiDrawMeshTasksIndirectNV", "glMultiDrawMeshTasksIndirectCountNV") || Checks.reportMissing("GL", "GL_NV_mesh_shader");
    }

    private static boolean check_NV_path_rendering(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_path_rendering")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2047, 2048, 2049, 2050, 2051, 2052, 2053, 2056, 2058, 2059, 2060, 2061, 2062, 2063, 2064, 2065, 2066, 2067, 2068, 2069, 2070, 2071, 2072, 2073, 2074, 2078, 2079, 2080, 2081, 2088, 2089, 2090, 2091, 2092, 2093, 2094, 2095, 2100, 2101, 2102, 2103}, "glPathCommandsNV", "glPathCoordsNV", "glPathSubCommandsNV", "glPathSubCoordsNV", "glPathStringNV", "glPathGlyphsNV", "glPathGlyphRangeNV", "glCopyPathNV", "glInterpolatePathsNV", "glTransformPathNV", "glPathParameterivNV", "glPathParameteriNV", "glPathParameterfvNV", "glPathParameterfNV", "glPathDashArrayNV", "glGenPathsNV", "glDeletePathsNV", "glIsPathNV", "glPathStencilFuncNV", "glPathStencilDepthOffsetNV", "glStencilFillPathNV", "glStencilStrokePathNV", "glStencilFillPathInstancedNV", "glStencilStrokePathInstancedNV", "glPathCoverDepthFuncNV", "glCoverFillPathNV", "glCoverStrokePathNV", "glCoverFillPathInstancedNV", "glCoverStrokePathInstancedNV", "glGetPathParameterivNV", "glGetPathParameterfvNV", "glGetPathCommandsNV", "glGetPathCoordsNV", "glGetPathDashArrayNV", "glGetPathMetricsNV", "glGetPathMetricRangeNV", "glGetPathSpacingNV", "glIsPointInFillPathNV", "glIsPointInStrokePathNV", "glGetPathLengthNV", "glPointAlongPathNV") || Checks.reportMissing("GL", "GL_NV_path_rendering");
    }

    private static boolean check_NV_pixel_data_range(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_pixel_data_range")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2111, 2112}, "glPixelDataRangeNV", "glFlushPixelDataRangeNV") || Checks.reportMissing("GL", "GL_NV_pixel_data_range");
    }

    private static boolean check_NV_point_sprite(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_point_sprite")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2113, 2114}, "glPointParameteriNV", "glPointParameterivNV") || Checks.reportMissing("GL", "GL_NV_point_sprite");
    }

    private static boolean check_NV_primitive_restart(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_primitive_restart")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2115, 2116}, "glPrimitiveRestartNV", "glPrimitiveRestartIndexNV") || Checks.reportMissing("GL", "GL_NV_primitive_restart");
    }

    private static boolean check_NV_query_resource(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_query_resource")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2117}, "glQueryResourceNV") || Checks.reportMissing("GL", "GL_NV_query_resource");
    }

    private static boolean check_NV_query_resource_tag(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_query_resource_tag")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2118, 2119, 2120}, "glGenQueryResourceTagNV", "glDeleteQueryResourceTagNV", "glQueryResourceTagNV") || Checks.reportMissing("GL", "GL_NV_query_resource_tag");
    }

    private static boolean check_NV_sample_locations(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_sample_locations")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2121, 2122, 2123}, "glFramebufferSampleLocationsfvNV", "glNamedFramebufferSampleLocationsfvNV", "glResolveDepthValuesNV") || Checks.reportMissing("GL", "GL_NV_sample_locations");
    }

    private static boolean check_NV_scissor_exclusive(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_scissor_exclusive")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2124, 2125}, "glScissorExclusiveArrayvNV", "glScissorExclusiveNV") || Checks.reportMissing("GL", "GL_NV_scissor_exclusive");
    }

    private static boolean check_NV_shader_buffer_load(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_shader_buffer_load")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2126, 2127, 2128, 2129, 2130, 2131, 2132, 2133, 2134, 2135, 2136, 1075, 2137, 2138}, "glMakeBufferResidentNV", "glMakeBufferNonResidentNV", "glIsBufferResidentNV", "glMakeNamedBufferResidentNV", "glMakeNamedBufferNonResidentNV", "glIsNamedBufferResidentNV", "glGetBufferParameterui64vNV", "glGetNamedBufferParameterui64vNV", "glGetIntegerui64vNV", "glUniformui64NV", "glUniformui64vNV", "glGetUniformui64vNV", "glProgramUniformui64NV", "glProgramUniformui64vNV") || Checks.reportMissing("GL", "GL_NV_shader_buffer_load");
    }

    private static boolean check_NV_shading_rate_image(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_shading_rate_image")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2139, 2140, 2141, 2142, 2143, 2144, 2145}, "glBindShadingRateImageNV", "glShadingRateImagePaletteNV", "glGetShadingRateImagePaletteNV", "glShadingRateImageBarrierNV", "glShadingRateSampleOrderNV", "glShadingRateSampleOrderCustomNV", "glGetShadingRateSampleLocationivNV") || Checks.reportMissing("GL", "GL_NV_shading_rate_image");
    }

    private static boolean check_NV_texture_barrier(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_texture_barrier")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2146}, "glTextureBarrierNV") || Checks.reportMissing("GL", "GL_NV_texture_barrier");
    }

    private static boolean check_NV_texture_multisample(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_texture_multisample")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2147, 2148, 2149, 2150, 2151, 2152}, "glTexImage2DMultisampleCoverageNV", "glTexImage3DMultisampleCoverageNV", "glTextureImage2DMultisampleNV", "glTextureImage3DMultisampleNV", "glTextureImage2DMultisampleCoverageNV", "glTextureImage3DMultisampleCoverageNV") || Checks.reportMissing("GL", "GL_NV_texture_multisample");
    }

    private static boolean check_NV_timeline_semaphore(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_timeline_semaphore")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2153, 2154, 2155}, "glCreateSemaphoresNV", "glSemaphoreParameterivNV", "glGetSemaphoreParameterivNV") || Checks.reportMissing("GL", "GL_NV_timeline_semaphore");
    }

    private static boolean check_NV_transform_feedback(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_transform_feedback")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2156, 2157, 2158, 2159, 2160, 2161, 2162, 2163, 2164, 2165, 2166, 2167}, "glBeginTransformFeedbackNV", "glEndTransformFeedbackNV", "glTransformFeedbackAttribsNV", "glBindBufferRangeNV", "glBindBufferOffsetNV", "glBindBufferBaseNV", "glTransformFeedbackVaryingsNV", "glActiveVaryingNV", "glGetVaryingLocationNV", "glGetActiveVaryingNV", "glGetTransformFeedbackVaryingNV", "glTransformFeedbackStreamAttribsNV") || Checks.reportMissing("GL", "GL_NV_transform_feedback");
    }

    private static boolean check_NV_transform_feedback2(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_transform_feedback2")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2168, 2169, 2170, 2171, 2172, 2173, 2174}, "glBindTransformFeedbackNV", "glDeleteTransformFeedbacksNV", "glGenTransformFeedbacksNV", "glIsTransformFeedbackNV", "glPauseTransformFeedbackNV", "glResumeTransformFeedbackNV", "glDrawTransformFeedbackNV") || Checks.reportMissing("GL", "GL_NV_transform_feedback2");
    }

    private static boolean check_NV_vertex_array_range(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_vertex_array_range")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2175, 2176}, "glVertexArrayRangeNV", "glFlushVertexArrayRangeNV") || Checks.reportMissing("GL", "GL_NV_vertex_array_range");
    }

    private static boolean check_NV_vertex_attrib_integer_64bit(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_vertex_attrib_integer_64bit")) {
            return false;
        }
        int n2 = set.contains("GL_NV_vertex_buffer_unified_memory") ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2177, 2178, 2179, 2180, 2181, 2182, 2183, 2184, 2185, 2186, 2187, 2188, 2189, 2190, 2191, 2192, 2193, 2194, n2 + 2195}, "glVertexAttribL1i64NV", "glVertexAttribL2i64NV", "glVertexAttribL3i64NV", "glVertexAttribL4i64NV", "glVertexAttribL1i64vNV", "glVertexAttribL2i64vNV", "glVertexAttribL3i64vNV", "glVertexAttribL4i64vNV", "glVertexAttribL1ui64NV", "glVertexAttribL2ui64NV", "glVertexAttribL3ui64NV", "glVertexAttribL4ui64NV", "glVertexAttribL1ui64vNV", "glVertexAttribL2ui64vNV", "glVertexAttribL3ui64vNV", "glVertexAttribL4ui64vNV", "glGetVertexAttribLi64vNV", "glGetVertexAttribLui64vNV", "glVertexAttribLFormatNV") || Checks.reportMissing("GL", "GL_NV_vertex_attrib_integer_64bit");
    }

    private static boolean check_NV_vertex_buffer_unified_memory(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_vertex_buffer_unified_memory")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2196, 2197, 2198, 2199, 2200, 2201, 2202, 2203, 2204, 2205, 2206, 2207}, "glBufferAddressRangeNV", "glVertexFormatNV", "glNormalFormatNV", "glColorFormatNV", "glIndexFormatNV", "glTexCoordFormatNV", "glEdgeFlagFormatNV", "glSecondaryColorFormatNV", "glFogCoordFormatNV", "glVertexAttribFormatNV", "glVertexAttribIFormatNV", "glGetIntegerui64i_vNV") || Checks.reportMissing("GL", "GL_NV_vertex_buffer_unified_memory");
    }

    private static boolean check_NV_viewport_swizzle(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NV_viewport_swizzle")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2208}, "glViewportSwizzleNV") || Checks.reportMissing("GL", "GL_NV_viewport_swizzle");
    }

    private static boolean check_NVX_conditional_render(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NVX_conditional_render")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2209, 2210}, "glBeginConditionalRenderNVX", "glEndConditionalRenderNVX") || Checks.reportMissing("GL", "GL_NVX_conditional_render");
    }

    private static boolean check_NVX_gpu_multicast2(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NVX_gpu_multicast2")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2211, 2212, 2213, 2214, 2215, 2216}, "glAsyncCopyImageSubDataNVX", "glAsyncCopyBufferSubDataNVX", "glUploadGpuMaskNVX", "glMulticastViewportArrayvNVX", "glMulticastScissorArrayvNVX", "glMulticastViewportPositionWScaleNVX") || Checks.reportMissing("GL", "GL_NVX_gpu_multicast2");
    }

    private static boolean check_NVX_progress_fence(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_NVX_progress_fence")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2217, 2218, 2219, 2220}, "glCreateProgressFenceNVX", "glSignalSemaphoreui64NVX", "glWaitSemaphoreui64NVX", "glClientWaitSemaphoreui64NVX") || Checks.reportMissing("GL", "GL_NVX_progress_fence");
    }

    private static boolean check_OVR_multiview(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("GL_OVR_multiview")) {
            return false;
        }
        int n2 = GLCapabilities.hasDSA(set) ? 0 : Integer.MIN_VALUE;
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{2221, n2 + 2222}, "glFramebufferTextureMultiviewOVR", "glNamedFramebufferTextureMultiviewOVR") || Checks.reportMissing("GL", "GL_OVR_multiview");
    }

    private static boolean hasDSA(Set<String> set) {
        return set.contains("GL45") || set.contains("GL_ARB_direct_state_access") || set.contains("GL_EXT_direct_state_access");
    }

    private static boolean ARB_framebuffer_object(Set<String> set) {
        return set.contains("OpenGL30") || set.contains("GL_ARB_framebuffer_object");
    }

    private static boolean ARB_map_buffer_range(Set<String> set) {
        return set.contains("OpenGL30") || set.contains("GL_ARB_map_buffer_range");
    }

    private static boolean ARB_vertex_array_object(Set<String> set) {
        return set.contains("OpenGL30") || set.contains("GL_ARB_vertex_array_object");
    }

    private static boolean ARB_copy_buffer(Set<String> set) {
        return set.contains("OpenGL31") || set.contains("GL_ARB_copy_buffer");
    }

    private static boolean ARB_texture_buffer_object(Set<String> set) {
        return set.contains("OpenGL31") || set.contains("GL_ARB_texture_buffer_object");
    }

    private static boolean ARB_uniform_buffer_object(Set<String> set) {
        return set.contains("OpenGL31") || set.contains("GL_ARB_uniform_buffer_object");
    }

    private static boolean ARB_instanced_arrays(Set<String> set) {
        return set.contains("OpenGL33") || set.contains("GL_ARB_instanced_arrays");
    }

    private static boolean ARB_sampler_objects(Set<String> set) {
        return set.contains("OpenGL33") || set.contains("GL_ARB_sampler_objects");
    }

    private static boolean ARB_transform_feedback2(Set<String> set) {
        return set.contains("OpenGL40") || set.contains("GL_ARB_transform_feedback2");
    }

    private static boolean ARB_vertex_attrib_64bit(Set<String> set) {
        return set.contains("OpenGL41") || set.contains("GL_ARB_vertex_attrib_64bit");
    }

    private static boolean ARB_separate_shader_objects(Set<String> set) {
        return set.contains("OpenGL41") || set.contains("GL_ARB_separate_shader_objects");
    }

    private static boolean ARB_texture_storage(Set<String> set) {
        return set.contains("OpenGL42") || set.contains("GL_ARB_texture_storage");
    }

    private static boolean ARB_texture_storage_multisample(Set<String> set) {
        return set.contains("OpenGL43") || set.contains("GL_ARB_texture_storage_multisample");
    }

    private static boolean ARB_vertex_attrib_binding(Set<String> set) {
        return set.contains("OpenGL43") || set.contains("GL_ARB_vertex_attrib_binding");
    }

    private static boolean ARB_invalidate_subdata(Set<String> set) {
        return set.contains("OpenGL43") || set.contains("GL_ARB_invalidate_subdata");
    }

    private static boolean ARB_texture_buffer_range(Set<String> set) {
        return set.contains("OpenGL43") || set.contains("GL_ARB_texture_buffer_range");
    }

    private static boolean ARB_clear_buffer_object(Set<String> set) {
        return set.contains("OpenGL43") || set.contains("GL_ARB_clear_buffer_object");
    }

    private static boolean ARB_framebuffer_no_attachments(Set<String> set) {
        return set.contains("OpenGL43") || set.contains("GL_ARB_framebuffer_no_attachments");
    }

    private static boolean ARB_buffer_storage(Set<String> set) {
        return set.contains("OpenGL44") || set.contains("GL_ARB_buffer_storage");
    }

    private static boolean ARB_clear_texture(Set<String> set) {
        return set.contains("OpenGL44") || set.contains("GL_ARB_clear_texture");
    }

    private static boolean ARB_multi_bind(Set<String> set) {
        return set.contains("OpenGL44") || set.contains("GL_ARB_multi_bind");
    }

    private static boolean ARB_query_buffer_object(Set<String> set) {
        return set.contains("OpenGL44") || set.contains("GL_ARB_query_buffer_object");
    }
}

