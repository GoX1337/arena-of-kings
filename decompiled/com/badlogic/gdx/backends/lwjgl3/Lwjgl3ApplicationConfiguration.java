/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowConfiguration;
import com.badlogic.gdx.graphics.glutils.HdpiMode;
import java.io.PrintStream;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;

public class Lwjgl3ApplicationConfiguration
extends Lwjgl3WindowConfiguration {
    public static PrintStream errorStream = System.err;
    boolean disableAudio = false;
    int maxNetThreads = Integer.MAX_VALUE;
    int audioDeviceSimultaneousSources = 16;
    int audioDeviceBufferSize = 512;
    int audioDeviceBufferCount = 9;
    GLEmulation glEmulation = GLEmulation.GL20;
    int gles30ContextMajorVersion = 3;
    int gles30ContextMinorVersion = 2;
    int r = 8;
    int g = 8;
    int b = 8;
    int a = 8;
    int depth = 16;
    int stencil = 0;
    int samples = 0;
    boolean transparentFramebuffer;
    int idleFPS = 60;
    int foregroundFPS = 0;
    String preferencesDirectory = ".prefs/";
    Files.FileType preferencesFileType = Files.FileType.External;
    HdpiMode hdpiMode = HdpiMode.Logical;
    boolean debug = false;
    PrintStream debugStream = System.err;

    static Lwjgl3ApplicationConfiguration copy(Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration) {
        Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration2 = new Lwjgl3ApplicationConfiguration();
        lwjgl3ApplicationConfiguration2.set(lwjgl3ApplicationConfiguration);
        return lwjgl3ApplicationConfiguration2;
    }

    void set(Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration) {
        super.setWindowConfiguration(lwjgl3ApplicationConfiguration);
        this.disableAudio = lwjgl3ApplicationConfiguration.disableAudio;
        this.audioDeviceSimultaneousSources = lwjgl3ApplicationConfiguration.audioDeviceSimultaneousSources;
        this.audioDeviceBufferSize = lwjgl3ApplicationConfiguration.audioDeviceBufferSize;
        this.audioDeviceBufferCount = lwjgl3ApplicationConfiguration.audioDeviceBufferCount;
        this.glEmulation = lwjgl3ApplicationConfiguration.glEmulation;
        this.gles30ContextMajorVersion = lwjgl3ApplicationConfiguration.gles30ContextMajorVersion;
        this.gles30ContextMinorVersion = lwjgl3ApplicationConfiguration.gles30ContextMinorVersion;
        this.r = lwjgl3ApplicationConfiguration.r;
        this.g = lwjgl3ApplicationConfiguration.g;
        this.b = lwjgl3ApplicationConfiguration.b;
        this.a = lwjgl3ApplicationConfiguration.a;
        this.depth = lwjgl3ApplicationConfiguration.depth;
        this.stencil = lwjgl3ApplicationConfiguration.stencil;
        this.samples = lwjgl3ApplicationConfiguration.samples;
        this.transparentFramebuffer = lwjgl3ApplicationConfiguration.transparentFramebuffer;
        this.idleFPS = lwjgl3ApplicationConfiguration.idleFPS;
        this.foregroundFPS = lwjgl3ApplicationConfiguration.foregroundFPS;
        this.preferencesDirectory = lwjgl3ApplicationConfiguration.preferencesDirectory;
        this.preferencesFileType = lwjgl3ApplicationConfiguration.preferencesFileType;
        this.hdpiMode = lwjgl3ApplicationConfiguration.hdpiMode;
        this.debug = lwjgl3ApplicationConfiguration.debug;
        this.debugStream = lwjgl3ApplicationConfiguration.debugStream;
    }

    @Override
    public void setInitialVisible(boolean bl2) {
        this.initialVisible = bl2;
    }

    public void disableAudio(boolean bl2) {
        this.disableAudio = bl2;
    }

    public void setMaxNetThreads(int n2) {
        this.maxNetThreads = n2;
    }

    public void setAudioConfig(int n2, int n3, int n4) {
        this.audioDeviceSimultaneousSources = n2;
        this.audioDeviceBufferSize = n3;
        this.audioDeviceBufferCount = n4;
    }

    public void setOpenGLEmulation(GLEmulation gLEmulation, int n2, int n3) {
        this.glEmulation = gLEmulation;
        this.gles30ContextMajorVersion = n2;
        this.gles30ContextMinorVersion = n3;
    }

    public void setBackBufferConfig(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.r = n2;
        this.g = n3;
        this.b = n4;
        this.a = n5;
        this.depth = n6;
        this.stencil = n7;
        this.samples = n8;
    }

    public void setTransparentFramebuffer(boolean bl2) {
        this.transparentFramebuffer = bl2;
    }

    public void setIdleFPS(int n2) {
        this.idleFPS = n2;
    }

    public void setForegroundFPS(int n2) {
        this.foregroundFPS = n2;
    }

    public void setPreferencesConfig(String string, Files.FileType fileType) {
        this.preferencesDirectory = string;
        this.preferencesFileType = fileType;
    }

    public void setHdpiMode(HdpiMode hdpiMode) {
        this.hdpiMode = hdpiMode;
    }

    public void enableGLDebugOutput(boolean bl2, PrintStream printStream) {
        this.debug = bl2;
        this.debugStream = printStream;
    }

    public static Graphics.DisplayMode getDisplayMode() {
        Lwjgl3Application.initializeGlfw();
        GLFWVidMode gLFWVidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        return new Lwjgl3Graphics.Lwjgl3DisplayMode(GLFW.glfwGetPrimaryMonitor(), gLFWVidMode.width(), gLFWVidMode.height(), gLFWVidMode.refreshRate(), gLFWVidMode.redBits() + gLFWVidMode.greenBits() + gLFWVidMode.blueBits());
    }

    public static Graphics.DisplayMode getDisplayMode(Graphics.Monitor monitor) {
        Lwjgl3Application.initializeGlfw();
        GLFWVidMode gLFWVidMode = GLFW.glfwGetVideoMode(((Lwjgl3Graphics.Lwjgl3Monitor)monitor).monitorHandle);
        return new Lwjgl3Graphics.Lwjgl3DisplayMode(((Lwjgl3Graphics.Lwjgl3Monitor)monitor).monitorHandle, gLFWVidMode.width(), gLFWVidMode.height(), gLFWVidMode.refreshRate(), gLFWVidMode.redBits() + gLFWVidMode.greenBits() + gLFWVidMode.blueBits());
    }

    public static Graphics.DisplayMode[] getDisplayModes() {
        Lwjgl3Application.initializeGlfw();
        GLFWVidMode.Buffer buffer = GLFW.glfwGetVideoModes(GLFW.glfwGetPrimaryMonitor());
        Graphics.DisplayMode[] displayModeArray = new Graphics.DisplayMode[buffer.limit()];
        for (int i2 = 0; i2 < displayModeArray.length; ++i2) {
            GLFWVidMode gLFWVidMode = (GLFWVidMode)buffer.get(i2);
            displayModeArray[i2] = new Lwjgl3Graphics.Lwjgl3DisplayMode(GLFW.glfwGetPrimaryMonitor(), gLFWVidMode.width(), gLFWVidMode.height(), gLFWVidMode.refreshRate(), gLFWVidMode.redBits() + gLFWVidMode.greenBits() + gLFWVidMode.blueBits());
        }
        return displayModeArray;
    }

    public static Graphics.DisplayMode[] getDisplayModes(Graphics.Monitor monitor) {
        Lwjgl3Application.initializeGlfw();
        GLFWVidMode.Buffer buffer = GLFW.glfwGetVideoModes(((Lwjgl3Graphics.Lwjgl3Monitor)monitor).monitorHandle);
        Graphics.DisplayMode[] displayModeArray = new Graphics.DisplayMode[buffer.limit()];
        for (int i2 = 0; i2 < displayModeArray.length; ++i2) {
            GLFWVidMode gLFWVidMode = (GLFWVidMode)buffer.get(i2);
            displayModeArray[i2] = new Lwjgl3Graphics.Lwjgl3DisplayMode(((Lwjgl3Graphics.Lwjgl3Monitor)monitor).monitorHandle, gLFWVidMode.width(), gLFWVidMode.height(), gLFWVidMode.refreshRate(), gLFWVidMode.redBits() + gLFWVidMode.greenBits() + gLFWVidMode.blueBits());
        }
        return displayModeArray;
    }

    public static Graphics.Monitor getPrimaryMonitor() {
        Lwjgl3Application.initializeGlfw();
        return Lwjgl3ApplicationConfiguration.toLwjgl3Monitor(GLFW.glfwGetPrimaryMonitor());
    }

    public static Graphics.Monitor[] getMonitors() {
        Lwjgl3Application.initializeGlfw();
        PointerBuffer pointerBuffer = GLFW.glfwGetMonitors();
        Graphics.Monitor[] monitorArray = new Graphics.Monitor[pointerBuffer.limit()];
        for (int i2 = 0; i2 < pointerBuffer.limit(); ++i2) {
            monitorArray[i2] = Lwjgl3ApplicationConfiguration.toLwjgl3Monitor(pointerBuffer.get(i2));
        }
        return monitorArray;
    }

    static Lwjgl3Graphics.Lwjgl3Monitor toLwjgl3Monitor(long l2) {
        IntBuffer intBuffer = BufferUtils.createIntBuffer(1);
        IntBuffer intBuffer2 = BufferUtils.createIntBuffer(1);
        GLFW.glfwGetMonitorPos(l2, intBuffer, intBuffer2);
        int n2 = intBuffer.get(0);
        int n3 = intBuffer2.get(0);
        String string = GLFW.glfwGetMonitorName(l2);
        return new Lwjgl3Graphics.Lwjgl3Monitor(l2, n2, n3, string);
    }

    public static enum GLEmulation {
        ANGLE_GLES20,
        GL20,
        GL30;

    }
}

