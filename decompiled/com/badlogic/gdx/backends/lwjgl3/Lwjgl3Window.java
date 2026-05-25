/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationBase;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Cursor;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowListener;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.SharedLibraryLoader;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWDropCallback;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWWindowCloseCallback;
import org.lwjgl.glfw.GLFWWindowFocusCallback;
import org.lwjgl.glfw.GLFWWindowIconifyCallback;
import org.lwjgl.glfw.GLFWWindowMaximizeCallback;
import org.lwjgl.glfw.GLFWWindowRefreshCallback;
import org.lwjgl.system.Struct;

public class Lwjgl3Window
implements Disposable {
    private long windowHandle;
    final ApplicationListener listener;
    final Lwjgl3ApplicationBase application;
    private boolean listenerInitialized = false;
    Lwjgl3WindowListener windowListener;
    private Lwjgl3Graphics graphics;
    private Lwjgl3Input input;
    private final Lwjgl3ApplicationConfiguration config;
    private final Array<Runnable> runnables = new Array();
    private final Array<Runnable> executedRunnables = new Array();
    private final IntBuffer tmpBuffer;
    private final IntBuffer tmpBuffer2;
    boolean iconified = false;
    boolean focused = false;
    private boolean requestRendering = false;
    private final GLFWWindowFocusCallback focusCallback = new GLFWWindowFocusCallback(){

        @Override
        public void invoke(long l2, final boolean bl2) {
            Lwjgl3Window.this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    if (Lwjgl3Window.this.windowListener != null) {
                        if (bl2) {
                            Lwjgl3Window.this.windowListener.focusGained();
                        } else {
                            Lwjgl3Window.this.windowListener.focusLost();
                        }
                        Lwjgl3Window.this.focused = bl2;
                    }
                }
            });
        }
    };
    private final GLFWWindowIconifyCallback iconifyCallback = new GLFWWindowIconifyCallback(){

        @Override
        public void invoke(long l2, final boolean bl2) {
            Lwjgl3Window.this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    if (Lwjgl3Window.this.windowListener != null) {
                        Lwjgl3Window.this.windowListener.iconified(bl2);
                    }
                    Lwjgl3Window.this.iconified = bl2;
                    if (bl2) {
                        Lwjgl3Window.this.listener.pause();
                    } else {
                        Lwjgl3Window.this.listener.resume();
                    }
                }
            });
        }
    };
    private final GLFWWindowMaximizeCallback maximizeCallback = new GLFWWindowMaximizeCallback(){

        @Override
        public void invoke(long l2, final boolean bl2) {
            Lwjgl3Window.this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    if (Lwjgl3Window.this.windowListener != null) {
                        Lwjgl3Window.this.windowListener.maximized(bl2);
                    }
                }
            });
        }
    };
    private final GLFWWindowCloseCallback closeCallback = new GLFWWindowCloseCallback(){

        @Override
        public void invoke(final long l2) {
            Lwjgl3Window.this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    if (Lwjgl3Window.this.windowListener != null && !Lwjgl3Window.this.windowListener.closeRequested()) {
                        GLFW.glfwSetWindowShouldClose(l2, false);
                    }
                }
            });
        }
    };
    private final GLFWDropCallback dropCallback = new GLFWDropCallback(){

        @Override
        public void invoke(long l2, int n2, long l3) {
            final String[] stringArray = new String[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                stringArray[i2] = _5.getName(l3, i2);
            }
            Lwjgl3Window.this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    if (Lwjgl3Window.this.windowListener != null) {
                        Lwjgl3Window.this.windowListener.filesDropped(stringArray);
                    }
                }
            });
        }
    };
    private final GLFWWindowRefreshCallback refreshCallback = new GLFWWindowRefreshCallback(){

        @Override
        public void invoke(long l2) {
            Lwjgl3Window.this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    if (Lwjgl3Window.this.windowListener != null) {
                        Lwjgl3Window.this.windowListener.refreshRequested();
                    }
                }
            });
        }
    };

    Lwjgl3Window(ApplicationListener applicationListener, Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration, Lwjgl3ApplicationBase lwjgl3ApplicationBase) {
        this.listener = applicationListener;
        this.windowListener = lwjgl3ApplicationConfiguration.windowListener;
        this.config = lwjgl3ApplicationConfiguration;
        this.application = lwjgl3ApplicationBase;
        this.tmpBuffer = BufferUtils.createIntBuffer(1);
        this.tmpBuffer2 = BufferUtils.createIntBuffer(1);
    }

    void create(long l2) {
        this.windowHandle = l2;
        this.input = this.application.createInput(this);
        this.graphics = new Lwjgl3Graphics(this);
        GLFW.glfwSetWindowFocusCallback(l2, this.focusCallback);
        GLFW.glfwSetWindowIconifyCallback(l2, this.iconifyCallback);
        GLFW.glfwSetWindowMaximizeCallback(l2, this.maximizeCallback);
        GLFW.glfwSetWindowCloseCallback(l2, this.closeCallback);
        GLFW.glfwSetDropCallback(l2, this.dropCallback);
        GLFW.glfwSetWindowRefreshCallback(l2, this.refreshCallback);
        if (this.windowListener != null) {
            this.windowListener.created(this);
        }
    }

    public ApplicationListener getListener() {
        return this.listener;
    }

    public Lwjgl3WindowListener getWindowListener() {
        return this.windowListener;
    }

    public void setWindowListener(Lwjgl3WindowListener lwjgl3WindowListener) {
        this.windowListener = lwjgl3WindowListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void postRunnable(Runnable runnable) {
        Array<Runnable> array = this.runnables;
        synchronized (array) {
            this.runnables.add(runnable);
        }
    }

    public void setPosition(int n2, int n3) {
        GLFW.glfwSetWindowPos(this.windowHandle, n2, n3);
    }

    public int getPositionX() {
        GLFW.glfwGetWindowPos(this.windowHandle, this.tmpBuffer, this.tmpBuffer2);
        return this.tmpBuffer.get(0);
    }

    public int getPositionY() {
        GLFW.glfwGetWindowPos(this.windowHandle, this.tmpBuffer, this.tmpBuffer2);
        return this.tmpBuffer2.get(0);
    }

    public void setVisible(boolean bl2) {
        if (bl2) {
            GLFW.glfwShowWindow(this.windowHandle);
        } else {
            GLFW.glfwHideWindow(this.windowHandle);
        }
    }

    public void closeWindow() {
        GLFW.glfwSetWindowShouldClose(this.windowHandle, true);
    }

    public void iconifyWindow() {
        GLFW.glfwIconifyWindow(this.windowHandle);
    }

    public boolean isIconified() {
        return this.iconified;
    }

    public void restoreWindow() {
        GLFW.glfwRestoreWindow(this.windowHandle);
    }

    public void maximizeWindow() {
        GLFW.glfwMaximizeWindow(this.windowHandle);
    }

    public void focusWindow() {
        GLFW.glfwFocusWindow(this.windowHandle);
    }

    public boolean isFocused() {
        return this.focused;
    }

    public void setIcon(Pixmap ... pixmapArray) {
        Lwjgl3Window.setIcon(this.windowHandle, pixmapArray);
    }

    static void setIcon(long l2, String[] stringArray, Files.FileType fileType) {
        if (SharedLibraryLoader.isMac) {
            return;
        }
        Pixmap[] pixmapArray = new Pixmap[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            pixmapArray[i2] = new Pixmap(Gdx.files.getFileHandle(stringArray[i2], fileType));
        }
        Lwjgl3Window.setIcon(l2, pixmapArray);
        for (Pixmap pixmap : pixmapArray) {
            pixmap.dispose();
        }
    }

    static void setIcon(long l2, Pixmap[] pixmapArray) {
        if (SharedLibraryLoader.isMac) {
            return;
        }
        GLFWImage.Buffer buffer = GLFWImage.malloc(pixmapArray.length);
        Pixmap[] pixmapArray2 = new Pixmap[pixmapArray.length];
        for (int i2 = 0; i2 < pixmapArray.length; ++i2) {
            Object object;
            Object object2 = pixmapArray[i2];
            if (((Pixmap)object2).getFormat() != Pixmap.Format.RGBA8888) {
                object = new Pixmap(((Pixmap)object2).getWidth(), ((Pixmap)object2).getHeight(), Pixmap.Format.RGBA8888);
                ((Pixmap)object).setBlending(Pixmap.Blending.None);
                ((Pixmap)object).drawPixmap((Pixmap)object2, 0, 0);
                pixmapArray2[i2] = object;
                object2 = object;
            }
            object = GLFWImage.malloc();
            ((GLFWImage)object).set(((Pixmap)object2).getWidth(), ((Pixmap)object2).getHeight(), ((Pixmap)object2).getPixels());
            buffer.put(object);
            ((Struct)object).free();
        }
        buffer.position(0);
        GLFW.glfwSetWindowIcon(l2, buffer);
        buffer.free();
        for (Pixmap pixmap : pixmapArray2) {
            if (pixmap == null) continue;
            pixmap.dispose();
        }
    }

    public void setTitle(CharSequence charSequence) {
        GLFW.glfwSetWindowTitle(this.windowHandle, charSequence);
    }

    public void setSizeLimits(int n2, int n3, int n4, int n5) {
        Lwjgl3Window.setSizeLimits(this.windowHandle, n2, n3, n4, n5);
    }

    static void setSizeLimits(long l2, int n2, int n3, int n4, int n5) {
        GLFW.glfwSetWindowSizeLimits(l2, n2 > -1 ? n2 : -1, n3 > -1 ? n3 : -1, n4 > -1 ? n4 : -1, n5 > -1 ? n5 : -1);
    }

    Lwjgl3Graphics getGraphics() {
        return this.graphics;
    }

    Lwjgl3Input getInput() {
        return this.input;
    }

    public long getWindowHandle() {
        return this.windowHandle;
    }

    void windowHandleChanged(long l2) {
        this.windowHandle = l2;
        this.input.windowHandleChanged(l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean update() {
        boolean bl2;
        if (!this.listenerInitialized) {
            this.initializeListener();
        }
        Array<Runnable> array = this.runnables;
        synchronized (array) {
            this.executedRunnables.addAll(this.runnables);
            this.runnables.clear();
        }
        for (Runnable object2 : this.executedRunnables) {
            object2.run();
        }
        boolean bl3 = this.executedRunnables.size > 0 || this.graphics.isContinuousRendering();
        this.executedRunnables.clear();
        if (!this.iconified) {
            this.input.update();
        }
        Lwjgl3Window lwjgl3Window = this;
        synchronized (lwjgl3Window) {
            bl2 = this.requestRendering && !this.iconified;
            this.requestRendering = false;
        }
        if (bl3 |= bl2) {
            this.graphics.update();
            this.listener.render();
            GLFW.glfwSwapBuffers(this.windowHandle);
        }
        if (!this.iconified) {
            this.input.prepareNext();
        }
        return bl3;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void requestRendering() {
        Lwjgl3Window lwjgl3Window = this;
        synchronized (lwjgl3Window) {
            this.requestRendering = true;
        }
    }

    boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(this.windowHandle);
    }

    Lwjgl3ApplicationConfiguration getConfig() {
        return this.config;
    }

    boolean isListenerInitialized() {
        return this.listenerInitialized;
    }

    void initializeListener() {
        if (!this.listenerInitialized) {
            this.listener.create();
            this.listener.resize(this.graphics.getWidth(), this.graphics.getHeight());
            this.listenerInitialized = true;
        }
    }

    void makeCurrent() {
        Gdx.graphics = this.graphics;
        Gdx.gl30 = this.graphics.getGL30();
        Gdx.gl20 = Gdx.gl30 != null ? Gdx.gl30 : this.graphics.getGL20();
        Gdx.gl = Gdx.gl30 != null ? Gdx.gl30 : Gdx.gl20;
        Gdx.input = this.input;
        GLFW.glfwMakeContextCurrent(this.windowHandle);
    }

    @Override
    public void dispose() {
        this.listener.pause();
        this.listener.dispose();
        Lwjgl3Cursor.dispose(this);
        this.graphics.dispose();
        this.input.dispose();
        GLFW.glfwSetWindowFocusCallback(this.windowHandle, null);
        GLFW.glfwSetWindowIconifyCallback(this.windowHandle, null);
        GLFW.glfwSetWindowCloseCallback(this.windowHandle, null);
        GLFW.glfwSetDropCallback(this.windowHandle, null);
        GLFW.glfwDestroyWindow(this.windowHandle);
        this.focusCallback.free();
        this.iconifyCallback.free();
        this.maximizeCallback.free();
        this.closeCallback.free();
        this.dropCallback.free();
        this.refreshCallback.free();
    }

    public int hashCode() {
        int n2 = 31;
        int n3 = 1;
        n3 = 31 * n3 + (int)(this.windowHandle ^ this.windowHandle >>> 32);
        return n3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Lwjgl3Window lwjgl3Window = (Lwjgl3Window)object;
        return this.windowHandle == lwjgl3Window.windowHandle;
    }

    public void flash() {
        GLFW.glfwRequestWindowAttention(this.windowHandle);
    }
}

