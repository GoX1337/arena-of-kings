/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.AbstractGraphics;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Cursor;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3GL20;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3GL30;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.glutils.GLVersion;
import com.badlogic.gdx.graphics.glutils.HdpiMode;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;

public class Lwjgl3Graphics
extends AbstractGraphics
implements Disposable {
    final Lwjgl3Window window;
    GL20 gl20;
    private GL30 gl30;
    private GLVersion glVersion;
    private volatile int backBufferWidth;
    private volatile int backBufferHeight;
    private volatile int logicalWidth;
    private volatile int logicalHeight;
    private volatile boolean isContinuous = true;
    private Graphics.BufferFormat bufferFormat;
    private long lastFrameTime = -1L;
    private float deltaTime;
    private boolean resetDeltaTime = false;
    private long frameId;
    private long frameCounterStart = 0L;
    private int frames;
    private int fps;
    private int windowPosXBeforeFullscreen;
    private int windowPosYBeforeFullscreen;
    private int windowWidthBeforeFullscreen;
    private int windowHeightBeforeFullscreen;
    private Graphics.DisplayMode displayModeBeforeFullscreen = null;
    IntBuffer tmpBuffer = BufferUtils.createIntBuffer(1);
    IntBuffer tmpBuffer2 = BufferUtils.createIntBuffer(1);
    IntBuffer tmpBuffer3 = BufferUtils.createIntBuffer(1);
    IntBuffer tmpBuffer4 = BufferUtils.createIntBuffer(1);
    GLFWFramebufferSizeCallback resizeCallback = new GLFWFramebufferSizeCallback(){
        volatile boolean posted;

        @Override
        public void invoke(final long l2, int n2, int n3) {
            if (this.posted) {
                return;
            }
            this.posted = true;
            Gdx.app.postRunnable(new Runnable(){

                @Override
                public void run() {
                    posted = false;
                    Lwjgl3Graphics.this.updateFramebufferInfo();
                    if (!Lwjgl3Graphics.this.window.isListenerInitialized()) {
                        return;
                    }
                    Lwjgl3Graphics.this.window.makeCurrent();
                    Lwjgl3Graphics.this.gl20.glViewport(0, 0, Lwjgl3Graphics.this.getWidth(), Lwjgl3Graphics.this.getHeight());
                    Lwjgl3Graphics.this.window.getListener().resize(Lwjgl3Graphics.this.getWidth(), Lwjgl3Graphics.this.getHeight());
                    Lwjgl3Graphics.this.window.getListener().render();
                    GLFW.glfwSwapBuffers(l2);
                }
            });
        }
    };

    public Lwjgl3Graphics(Lwjgl3Window lwjgl3Window) {
        this.window = lwjgl3Window;
        if (lwjgl3Window.getConfig().glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.GL30) {
            this.gl30 = new Lwjgl3GL30();
            this.gl20 = this.gl30;
        } else {
            try {
                this.gl20 = lwjgl3Window.getConfig().glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.GL20 ? new Lwjgl3GL20() : (GL20)Class.forName("com.badlogic.gdx.backends.lwjgl3.angle.Lwjgl3GLES20").newInstance();
            }
            catch (Throwable throwable) {
                throw new GdxRuntimeException("Couldn't instantiate GLES20.", throwable);
            }
            this.gl30 = null;
        }
        this.updateFramebufferInfo();
        this.initiateGL();
        GLFW.glfwSetFramebufferSizeCallback(lwjgl3Window.getWindowHandle(), this.resizeCallback);
    }

    private void initiateGL() {
        String string = this.gl20.glGetString(7938);
        String string2 = this.gl20.glGetString(7936);
        String string3 = this.gl20.glGetString(7937);
        this.glVersion = new GLVersion(Application.ApplicationType.Desktop, string, string2, string3);
        if (this.supportsCubeMapSeamless()) {
            this.enableCubeMapSeamless(true);
        }
    }

    public boolean supportsCubeMapSeamless() {
        return this.glVersion.isVersionEqualToOrHigher(3, 2) || this.supportsExtension("GL_ARB_seamless_cube_map");
    }

    public void enableCubeMapSeamless(boolean bl2) {
        if (bl2) {
            this.gl20.glEnable(34895);
        } else {
            this.gl20.glDisable(34895);
        }
    }

    public Lwjgl3Window getWindow() {
        return this.window;
    }

    void updateFramebufferInfo() {
        GLFW.glfwGetFramebufferSize(this.window.getWindowHandle(), this.tmpBuffer, this.tmpBuffer2);
        this.backBufferWidth = this.tmpBuffer.get(0);
        this.backBufferHeight = this.tmpBuffer2.get(0);
        GLFW.glfwGetWindowSize(this.window.getWindowHandle(), this.tmpBuffer, this.tmpBuffer2);
        this.logicalWidth = this.tmpBuffer.get(0);
        this.logicalHeight = this.tmpBuffer2.get(0);
        Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration = this.window.getConfig();
        this.bufferFormat = new Graphics.BufferFormat(lwjgl3ApplicationConfiguration.r, lwjgl3ApplicationConfiguration.g, lwjgl3ApplicationConfiguration.b, lwjgl3ApplicationConfiguration.a, lwjgl3ApplicationConfiguration.depth, lwjgl3ApplicationConfiguration.stencil, lwjgl3ApplicationConfiguration.samples, false);
    }

    void update() {
        long l2 = System.nanoTime();
        if (this.lastFrameTime == -1L) {
            this.lastFrameTime = l2;
        }
        if (this.resetDeltaTime) {
            this.resetDeltaTime = false;
            this.deltaTime = 0.0f;
        } else {
            this.deltaTime = (float)(l2 - this.lastFrameTime) / 1.0E9f;
        }
        this.lastFrameTime = l2;
        if (l2 - this.frameCounterStart >= 1000000000L) {
            this.fps = this.frames;
            this.frames = 0;
            this.frameCounterStart = l2;
        }
        ++this.frames;
        ++this.frameId;
    }

    @Override
    public boolean isGL30Available() {
        return this.gl30 != null;
    }

    @Override
    public GL20 getGL20() {
        return this.gl20;
    }

    @Override
    public GL30 getGL30() {
        return this.gl30;
    }

    @Override
    public void setGL20(GL20 gL20) {
        this.gl20 = gL20;
    }

    @Override
    public void setGL30(GL30 gL30) {
        this.gl30 = gL30;
    }

    @Override
    public int getWidth() {
        if (this.window.getConfig().hdpiMode == HdpiMode.Pixels) {
            return this.backBufferWidth;
        }
        return this.logicalWidth;
    }

    @Override
    public int getHeight() {
        if (this.window.getConfig().hdpiMode == HdpiMode.Pixels) {
            return this.backBufferHeight;
        }
        return this.logicalHeight;
    }

    @Override
    public int getBackBufferWidth() {
        return this.backBufferWidth;
    }

    @Override
    public int getBackBufferHeight() {
        return this.backBufferHeight;
    }

    public int getLogicalWidth() {
        return this.logicalWidth;
    }

    public int getLogicalHeight() {
        return this.logicalHeight;
    }

    @Override
    public long getFrameId() {
        return this.frameId;
    }

    @Override
    public float getDeltaTime() {
        return this.deltaTime;
    }

    public void resetDeltaTime() {
        this.resetDeltaTime = true;
    }

    @Override
    public int getFramesPerSecond() {
        return this.fps;
    }

    @Override
    public Graphics.GraphicsType getType() {
        return Graphics.GraphicsType.LWJGL3;
    }

    @Override
    public GLVersion getGLVersion() {
        return this.glVersion;
    }

    @Override
    public float getPpiX() {
        return this.getPpcX() * 2.54f;
    }

    @Override
    public float getPpiY() {
        return this.getPpcY() * 2.54f;
    }

    @Override
    public float getPpcX() {
        Lwjgl3Monitor lwjgl3Monitor = (Lwjgl3Monitor)this.getMonitor();
        GLFW.glfwGetMonitorPhysicalSize(lwjgl3Monitor.monitorHandle, this.tmpBuffer, this.tmpBuffer2);
        int n2 = this.tmpBuffer.get(0);
        Graphics.DisplayMode displayMode = this.getDisplayMode();
        return (float)displayMode.width / (float)n2 * 10.0f;
    }

    @Override
    public float getPpcY() {
        Lwjgl3Monitor lwjgl3Monitor = (Lwjgl3Monitor)this.getMonitor();
        GLFW.glfwGetMonitorPhysicalSize(lwjgl3Monitor.monitorHandle, this.tmpBuffer, this.tmpBuffer2);
        int n2 = this.tmpBuffer2.get(0);
        Graphics.DisplayMode displayMode = this.getDisplayMode();
        return (float)displayMode.height / (float)n2 * 10.0f;
    }

    @Override
    public boolean supportsDisplayModeChange() {
        return true;
    }

    @Override
    public Graphics.Monitor getPrimaryMonitor() {
        return Lwjgl3ApplicationConfiguration.toLwjgl3Monitor(GLFW.glfwGetPrimaryMonitor());
    }

    @Override
    public Graphics.Monitor getMonitor() {
        Graphics.Monitor[] monitorArray = this.getMonitors();
        Graphics.Monitor monitor = monitorArray[0];
        GLFW.glfwGetWindowPos(this.window.getWindowHandle(), this.tmpBuffer, this.tmpBuffer2);
        int n2 = this.tmpBuffer.get(0);
        int n3 = this.tmpBuffer2.get(0);
        GLFW.glfwGetWindowSize(this.window.getWindowHandle(), this.tmpBuffer, this.tmpBuffer2);
        int n4 = this.tmpBuffer.get(0);
        int n5 = this.tmpBuffer2.get(0);
        int n6 = 0;
        for (Graphics.Monitor monitor2 : monitorArray) {
            Graphics.DisplayMode displayMode = this.getDisplayMode(monitor2);
            int n7 = Math.max(0, Math.min(n2 + n4, monitor2.virtualX + displayMode.width) - Math.max(n2, monitor2.virtualX)) * Math.max(0, Math.min(n3 + n5, monitor2.virtualY + displayMode.height) - Math.max(n3, monitor2.virtualY));
            if (n6 >= n7) continue;
            n6 = n7;
            monitor = monitor2;
        }
        return monitor;
    }

    @Override
    public Graphics.Monitor[] getMonitors() {
        PointerBuffer pointerBuffer = GLFW.glfwGetMonitors();
        Graphics.Monitor[] monitorArray = new Graphics.Monitor[pointerBuffer.limit()];
        for (int i2 = 0; i2 < pointerBuffer.limit(); ++i2) {
            monitorArray[i2] = Lwjgl3ApplicationConfiguration.toLwjgl3Monitor(pointerBuffer.get(i2));
        }
        return monitorArray;
    }

    @Override
    public Graphics.DisplayMode[] getDisplayModes() {
        return Lwjgl3ApplicationConfiguration.getDisplayModes(this.getMonitor());
    }

    @Override
    public Graphics.DisplayMode[] getDisplayModes(Graphics.Monitor monitor) {
        return Lwjgl3ApplicationConfiguration.getDisplayModes(monitor);
    }

    @Override
    public Graphics.DisplayMode getDisplayMode() {
        return Lwjgl3ApplicationConfiguration.getDisplayMode(this.getMonitor());
    }

    @Override
    public Graphics.DisplayMode getDisplayMode(Graphics.Monitor monitor) {
        return Lwjgl3ApplicationConfiguration.getDisplayMode(monitor);
    }

    @Override
    public int getSafeInsetLeft() {
        return 0;
    }

    @Override
    public int getSafeInsetTop() {
        return 0;
    }

    @Override
    public int getSafeInsetBottom() {
        return 0;
    }

    @Override
    public int getSafeInsetRight() {
        return 0;
    }

    @Override
    public boolean setFullscreenMode(Graphics.DisplayMode displayMode) {
        this.window.getInput().resetPollingStates();
        Lwjgl3DisplayMode lwjgl3DisplayMode = (Lwjgl3DisplayMode)displayMode;
        if (this.isFullscreen()) {
            Lwjgl3DisplayMode lwjgl3DisplayMode2 = (Lwjgl3DisplayMode)this.getDisplayMode();
            if (lwjgl3DisplayMode2.getMonitor() == lwjgl3DisplayMode.getMonitor() && lwjgl3DisplayMode2.refreshRate == lwjgl3DisplayMode.refreshRate) {
                GLFW.glfwSetWindowSize(this.window.getWindowHandle(), lwjgl3DisplayMode.width, lwjgl3DisplayMode.height);
            } else {
                GLFW.glfwSetWindowMonitor(this.window.getWindowHandle(), lwjgl3DisplayMode.getMonitor(), 0, 0, lwjgl3DisplayMode.width, lwjgl3DisplayMode.height, lwjgl3DisplayMode.refreshRate);
            }
        } else {
            this.storeCurrentWindowPositionAndDisplayMode();
            GLFW.glfwSetWindowMonitor(this.window.getWindowHandle(), lwjgl3DisplayMode.getMonitor(), 0, 0, lwjgl3DisplayMode.width, lwjgl3DisplayMode.height, lwjgl3DisplayMode.refreshRate);
        }
        this.updateFramebufferInfo();
        this.setVSync(this.window.getConfig().vSyncEnabled);
        return true;
    }

    private void storeCurrentWindowPositionAndDisplayMode() {
        this.windowPosXBeforeFullscreen = this.window.getPositionX();
        this.windowPosYBeforeFullscreen = this.window.getPositionY();
        this.windowWidthBeforeFullscreen = this.logicalWidth;
        this.windowHeightBeforeFullscreen = this.logicalHeight;
        this.displayModeBeforeFullscreen = this.getDisplayMode();
    }

    @Override
    public boolean setWindowedMode(int n2, int n3) {
        this.window.getInput().resetPollingStates();
        if (!this.isFullscreen()) {
            int n4 = 0;
            int n5 = 0;
            boolean bl2 = false;
            if (n2 != this.logicalWidth || n3 != this.logicalHeight) {
                bl2 = true;
                Lwjgl3Monitor lwjgl3Monitor = (Lwjgl3Monitor)this.getMonitor();
                GLFW.glfwGetMonitorWorkarea(lwjgl3Monitor.monitorHandle, this.tmpBuffer, this.tmpBuffer2, this.tmpBuffer3, this.tmpBuffer4);
                n4 = Math.max(0, this.tmpBuffer.get(0) + (this.tmpBuffer3.get(0) - n2) / 2);
                n5 = Math.max(0, this.tmpBuffer2.get(0) + (this.tmpBuffer4.get(0) - n3) / 2);
            }
            GLFW.glfwSetWindowSize(this.window.getWindowHandle(), n2, n3);
            if (bl2) {
                this.window.setPosition(n4, n5);
            }
        } else {
            if (this.displayModeBeforeFullscreen == null) {
                this.storeCurrentWindowPositionAndDisplayMode();
            }
            if (n2 != this.windowWidthBeforeFullscreen || n3 != this.windowHeightBeforeFullscreen) {
                Lwjgl3Monitor lwjgl3Monitor = (Lwjgl3Monitor)this.getMonitor();
                GLFW.glfwGetMonitorWorkarea(lwjgl3Monitor.monitorHandle, this.tmpBuffer, this.tmpBuffer2, this.tmpBuffer3, this.tmpBuffer4);
                GLFW.glfwSetWindowMonitor(this.window.getWindowHandle(), 0L, Math.max(0, this.tmpBuffer.get(0) + (this.tmpBuffer3.get(0) - n2) / 2), Math.max(0, this.tmpBuffer2.get(0) + (this.tmpBuffer4.get(0) - n3) / 2), n2, n3, this.displayModeBeforeFullscreen.refreshRate);
            } else {
                GLFW.glfwSetWindowMonitor(this.window.getWindowHandle(), 0L, this.windowPosXBeforeFullscreen, this.windowPosYBeforeFullscreen, n2, n3, this.displayModeBeforeFullscreen.refreshRate);
            }
        }
        this.updateFramebufferInfo();
        return true;
    }

    @Override
    public void setTitle(String string) {
        if (string == null) {
            string = "";
        }
        GLFW.glfwSetWindowTitle(this.window.getWindowHandle(), string);
    }

    @Override
    public void setUndecorated(boolean bl2) {
        this.getWindow().getConfig().setDecorated(!bl2);
        GLFW.glfwSetWindowAttrib(this.window.getWindowHandle(), 131077, bl2 ? 0 : 1);
    }

    @Override
    public void setResizable(boolean bl2) {
        this.getWindow().getConfig().setResizable(bl2);
        GLFW.glfwSetWindowAttrib(this.window.getWindowHandle(), 131075, bl2 ? 1 : 0);
    }

    @Override
    public void setVSync(boolean bl2) {
        this.getWindow().getConfig().vSyncEnabled = bl2;
        GLFW.glfwSwapInterval(bl2 ? 1 : 0);
    }

    @Override
    public void setForegroundFPS(int n2) {
        this.getWindow().getConfig().foregroundFPS = n2;
    }

    @Override
    public Graphics.BufferFormat getBufferFormat() {
        return this.bufferFormat;
    }

    @Override
    public boolean supportsExtension(String string) {
        return GLFW.glfwExtensionSupported(string);
    }

    @Override
    public void setContinuousRendering(boolean bl2) {
        this.isContinuous = bl2;
    }

    @Override
    public boolean isContinuousRendering() {
        return this.isContinuous;
    }

    @Override
    public void requestRendering() {
        this.window.requestRendering();
    }

    @Override
    public boolean isFullscreen() {
        return GLFW.glfwGetWindowMonitor(this.window.getWindowHandle()) != 0L;
    }

    @Override
    public Cursor newCursor(Pixmap pixmap, int n2, int n3) {
        return new Lwjgl3Cursor(this.getWindow(), pixmap, n2, n3);
    }

    @Override
    public void setCursor(Cursor cursor) {
        GLFW.glfwSetCursor(this.getWindow().getWindowHandle(), ((Lwjgl3Cursor)cursor).glfwCursor);
    }

    @Override
    public void setSystemCursor(Cursor.SystemCursor systemCursor) {
        Lwjgl3Cursor.setSystemCursor(this.getWindow().getWindowHandle(), systemCursor);
    }

    @Override
    public void dispose() {
        this.resizeCallback.free();
    }

    public static class Lwjgl3Monitor
    extends Graphics.Monitor {
        final long monitorHandle;

        Lwjgl3Monitor(long l2, int n2, int n3, String string) {
            super(n2, n3, string);
            this.monitorHandle = l2;
        }

        public long getMonitorHandle() {
            return this.monitorHandle;
        }
    }

    public static class Lwjgl3DisplayMode
    extends Graphics.DisplayMode {
        final long monitorHandle;

        Lwjgl3DisplayMode(long l2, int n2, int n3, int n4, int n5) {
            super(n2, n3, n4, n5);
            this.monitorHandle = l2;
        }

        public long getMonitor() {
            return this.monitorHandle;
        }
    }
}

