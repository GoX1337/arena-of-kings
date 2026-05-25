/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.ApplicationLogger;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.backends.lwjgl3.DefaultLwjgl3Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationBase;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationLogger;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Clipboard;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Cursor;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3FileHandle;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3NativesLoader;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Net;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Preferences;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Sync;
import com.badlogic.gdx.backends.lwjgl3.audio.Lwjgl3Audio;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALLwjgl3Audio;
import com.badlogic.gdx.backends.lwjgl3.audio.mock.MockAudio;
import com.badlogic.gdx.graphics.glutils.GLVersion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Clipboard;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.SharedLibraryLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.AMDDebugOutput;
import org.lwjgl.opengl.ARBDebugOutput;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL43;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLUtil;
import org.lwjgl.opengl.KHRDebug;
import org.lwjgl.system.Callback;
import org.lwjgl.system.Configuration;

public class Lwjgl3Application
implements Lwjgl3ApplicationBase {
    private final Lwjgl3ApplicationConfiguration config;
    final Array<Lwjgl3Window> windows = new Array();
    private volatile Lwjgl3Window currentWindow;
    private Lwjgl3Audio audio;
    private final Files files;
    private final Net net;
    private final ObjectMap<String, Preferences> preferences = new ObjectMap();
    private final Lwjgl3Clipboard clipboard;
    private int logLevel = 2;
    private ApplicationLogger applicationLogger;
    private volatile boolean running = true;
    private final Array<Runnable> runnables = new Array();
    private final Array<Runnable> executedRunnables = new Array();
    private final Array<LifecycleListener> lifecycleListeners = new Array();
    private static GLFWErrorCallback errorCallback;
    private static GLVersion glVersion;
    private static Callback glDebugCallback;
    private final Sync sync;

    static void initializeGlfw() {
        if (errorCallback == null) {
            if (SharedLibraryLoader.isMac) {
                Lwjgl3Application.loadGlfwAwtMacos();
            }
            Lwjgl3NativesLoader.load();
            errorCallback = GLFWErrorCallback.createPrint(Lwjgl3ApplicationConfiguration.errorStream);
            GLFW.glfwSetErrorCallback(errorCallback);
            if (SharedLibraryLoader.isMac) {
                GLFW.glfwInitHint(327682, 225288);
            }
            GLFW.glfwInitHint(327681, 0);
            if (!GLFW.glfwInit()) {
                throw new GdxRuntimeException("Unable to initialize GLFW");
            }
        }
    }

    static void loadANGLE() {
        try {
            Class<?> clazz = Class.forName("com.badlogic.gdx.backends.lwjgl3.angle.ANGLELoader");
            Method method = clazz.getMethod("load", new Class[0]);
            method.invoke(clazz, new Object[0]);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return;
        }
        catch (Throwable throwable) {
            throw new GdxRuntimeException("Couldn't load ANGLE.", throwable);
        }
    }

    static void postLoadANGLE() {
        try {
            Class<?> clazz = Class.forName("com.badlogic.gdx.backends.lwjgl3.angle.ANGLELoader");
            Method method = clazz.getMethod("postGlfwInit", new Class[0]);
            method.invoke(clazz, new Object[0]);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return;
        }
        catch (Throwable throwable) {
            throw new GdxRuntimeException("Couldn't load ANGLE.", throwable);
        }
    }

    static void loadGlfwAwtMacos() {
        try {
            Class<?> clazz = Class.forName("com.badlogic.gdx.backends.lwjgl3.awt.GlfwAWTLoader");
            Method method = clazz.getMethod("load", new Class[0]);
            File file = (File)method.invoke(clazz, new Object[0]);
            Configuration.GLFW_LIBRARY_NAME.set(file.getAbsolutePath());
            Configuration.GLFW_CHECK_THREAD0.set(false);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return;
        }
        catch (Throwable throwable) {
            throw new GdxRuntimeException("Couldn't load GLFW AWT for macOS.", throwable);
        }
    }

    public Lwjgl3Application(ApplicationListener applicationListener) {
        this(applicationListener, new Lwjgl3ApplicationConfiguration());
    }

    public Lwjgl3Application(ApplicationListener applicationListener, Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration) {
        if (lwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20) {
            Lwjgl3Application.loadANGLE();
        }
        Lwjgl3Application.initializeGlfw();
        this.setApplicationLogger(new Lwjgl3ApplicationLogger());
        this.config = lwjgl3ApplicationConfiguration = Lwjgl3ApplicationConfiguration.copy(lwjgl3ApplicationConfiguration);
        if (lwjgl3ApplicationConfiguration.title == null) {
            lwjgl3ApplicationConfiguration.title = applicationListener.getClass().getSimpleName();
        }
        Gdx.app = this;
        if (!lwjgl3ApplicationConfiguration.disableAudio) {
            try {
                this.audio = this.createAudio(lwjgl3ApplicationConfiguration);
            }
            catch (Throwable throwable) {
                this.log("Lwjgl3Application", "Couldn't initialize audio, disabling audio", throwable);
                this.audio = new MockAudio();
            }
        } else {
            this.audio = new MockAudio();
        }
        Gdx.audio = this.audio;
        this.files = Gdx.files = this.createFiles();
        this.net = Gdx.net = new Lwjgl3Net(lwjgl3ApplicationConfiguration);
        this.clipboard = new Lwjgl3Clipboard();
        this.sync = new Sync();
        Lwjgl3Window lwjgl3Window = this.createWindow(lwjgl3ApplicationConfiguration, applicationListener, 0L);
        if (lwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20) {
            Lwjgl3Application.postLoadANGLE();
        }
        this.windows.add(lwjgl3Window);
        try {
            this.loop();
            this.cleanupWindows();
        }
        catch (Throwable throwable) {
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            throw new GdxRuntimeException(throwable);
        }
        finally {
            this.cleanup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void loop() {
        Array<Lwjgl3Window> array = new Array<Lwjgl3Window>();
        while (this.running && this.windows.size > 0) {
            boolean bl2;
            this.audio.update();
            boolean bl3 = false;
            array.clear();
            int n2 = -2;
            for (Lwjgl3Window lwjgl3Window : this.windows) {
                lwjgl3Window.makeCurrent();
                this.currentWindow = lwjgl3Window;
                if (n2 == -2) {
                    n2 = lwjgl3Window.getConfig().foregroundFPS;
                }
                Array<LifecycleListener> array2 = this.lifecycleListeners;
                synchronized (array2) {
                    bl3 |= lwjgl3Window.update();
                }
                if (!lwjgl3Window.shouldClose()) continue;
                array.add(lwjgl3Window);
            }
            GLFW.glfwPollEvents();
            Array<Runnable> array3 = this.runnables;
            synchronized (array3) {
                bl2 = this.runnables.size > 0;
                this.executedRunnables.clear();
                this.executedRunnables.addAll(this.runnables);
                this.runnables.clear();
            }
            for (Runnable runnable : this.executedRunnables) {
                runnable.run();
            }
            if (bl2) {
                for (Lwjgl3Window lwjgl3Window : this.windows) {
                    if (lwjgl3Window.getGraphics().isContinuousRendering()) continue;
                    lwjgl3Window.requestRendering();
                }
            }
            for (Lwjgl3Window lwjgl3Window : array) {
                if (this.windows.size == 1) {
                    for (int i2 = this.lifecycleListeners.size - 1; i2 >= 0; --i2) {
                        LifecycleListener lifecycleListener = this.lifecycleListeners.get(i2);
                        lifecycleListener.pause();
                        lifecycleListener.dispose();
                    }
                    this.lifecycleListeners.clear();
                }
                lwjgl3Window.dispose();
                this.windows.removeValue(lwjgl3Window, false);
            }
            if (!bl3) {
                try {
                    Thread.sleep(1000 / this.config.idleFPS);
                }
                catch (InterruptedException interruptedException) {}
                continue;
            }
            if (n2 <= 0) continue;
            this.sync.sync(n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void cleanupWindows() {
        Array<LifecycleListener> array = this.lifecycleListeners;
        synchronized (array) {
            for (LifecycleListener lifecycleListener : this.lifecycleListeners) {
                lifecycleListener.pause();
                lifecycleListener.dispose();
            }
        }
        for (Lwjgl3Window lwjgl3Window : this.windows) {
            lwjgl3Window.dispose();
        }
        this.windows.clear();
    }

    protected void cleanup() {
        Lwjgl3Cursor.disposeSystemCursors();
        this.audio.dispose();
        errorCallback.free();
        errorCallback = null;
        if (glDebugCallback != null) {
            glDebugCallback.free();
            glDebugCallback = null;
        }
        GLFW.glfwTerminate();
    }

    @Override
    public ApplicationListener getApplicationListener() {
        return this.currentWindow.getListener();
    }

    @Override
    public Graphics getGraphics() {
        return this.currentWindow.getGraphics();
    }

    @Override
    public Audio getAudio() {
        return this.audio;
    }

    @Override
    public Input getInput() {
        return this.currentWindow.getInput();
    }

    @Override
    public Files getFiles() {
        return this.files;
    }

    @Override
    public Net getNet() {
        return this.net;
    }

    @Override
    public void debug(String string, String string2) {
        if (this.logLevel >= 3) {
            this.getApplicationLogger().debug(string, string2);
        }
    }

    @Override
    public void debug(String string, String string2, Throwable throwable) {
        if (this.logLevel >= 3) {
            this.getApplicationLogger().debug(string, string2, throwable);
        }
    }

    @Override
    public void log(String string, String string2) {
        if (this.logLevel >= 2) {
            this.getApplicationLogger().log(string, string2);
        }
    }

    @Override
    public void log(String string, String string2, Throwable throwable) {
        if (this.logLevel >= 2) {
            this.getApplicationLogger().log(string, string2, throwable);
        }
    }

    @Override
    public void error(String string, String string2) {
        if (this.logLevel >= 1) {
            this.getApplicationLogger().error(string, string2);
        }
    }

    @Override
    public void error(String string, String string2, Throwable throwable) {
        if (this.logLevel >= 1) {
            this.getApplicationLogger().error(string, string2, throwable);
        }
    }

    @Override
    public void setLogLevel(int n2) {
        this.logLevel = n2;
    }

    @Override
    public int getLogLevel() {
        return this.logLevel;
    }

    @Override
    public void setApplicationLogger(ApplicationLogger applicationLogger) {
        this.applicationLogger = applicationLogger;
    }

    @Override
    public ApplicationLogger getApplicationLogger() {
        return this.applicationLogger;
    }

    @Override
    public Application.ApplicationType getType() {
        return Application.ApplicationType.Desktop;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public long getJavaHeap() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    @Override
    public long getNativeHeap() {
        return this.getJavaHeap();
    }

    @Override
    public Preferences getPreferences(String string) {
        if (this.preferences.containsKey(string)) {
            return this.preferences.get(string);
        }
        Lwjgl3Preferences lwjgl3Preferences = new Lwjgl3Preferences(new Lwjgl3FileHandle(new File(this.config.preferencesDirectory, string), this.config.preferencesFileType));
        this.preferences.put(string, lwjgl3Preferences);
        return lwjgl3Preferences;
    }

    @Override
    public Clipboard getClipboard() {
        return this.clipboard;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void postRunnable(Runnable runnable) {
        Array<Runnable> array = this.runnables;
        synchronized (array) {
            this.runnables.add(runnable);
        }
    }

    @Override
    public void exit() {
        this.running = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addLifecycleListener(LifecycleListener lifecycleListener) {
        Array<LifecycleListener> array = this.lifecycleListeners;
        synchronized (array) {
            this.lifecycleListeners.add(lifecycleListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeLifecycleListener(LifecycleListener lifecycleListener) {
        Array<LifecycleListener> array = this.lifecycleListeners;
        synchronized (array) {
            this.lifecycleListeners.removeValue(lifecycleListener, true);
        }
    }

    @Override
    public Lwjgl3Audio createAudio(Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration) {
        return new OpenALLwjgl3Audio(lwjgl3ApplicationConfiguration.audioDeviceSimultaneousSources, lwjgl3ApplicationConfiguration.audioDeviceBufferCount, lwjgl3ApplicationConfiguration.audioDeviceBufferSize);
    }

    @Override
    public Lwjgl3Input createInput(Lwjgl3Window lwjgl3Window) {
        return new DefaultLwjgl3Input(lwjgl3Window);
    }

    protected Files createFiles() {
        return new Lwjgl3Files();
    }

    public Lwjgl3Window newWindow(ApplicationListener applicationListener, Lwjgl3WindowConfiguration lwjgl3WindowConfiguration) {
        Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration = Lwjgl3ApplicationConfiguration.copy(this.config);
        lwjgl3ApplicationConfiguration.setWindowConfiguration(lwjgl3WindowConfiguration);
        if (lwjgl3ApplicationConfiguration.title == null) {
            lwjgl3ApplicationConfiguration.title = applicationListener.getClass().getSimpleName();
        }
        return this.createWindow(lwjgl3ApplicationConfiguration, applicationListener, this.windows.get(0).getWindowHandle());
    }

    private Lwjgl3Window createWindow(final Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration, ApplicationListener applicationListener, final long l2) {
        final Lwjgl3Window lwjgl3Window = new Lwjgl3Window(applicationListener, lwjgl3ApplicationConfiguration, this);
        if (l2 == 0L) {
            this.createWindow(lwjgl3Window, lwjgl3ApplicationConfiguration, l2);
        } else {
            this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    Lwjgl3Application.this.createWindow(lwjgl3Window, lwjgl3ApplicationConfiguration, l2);
                    Lwjgl3Application.this.windows.add(lwjgl3Window);
                }
            });
        }
        return lwjgl3Window;
    }

    void createWindow(Lwjgl3Window lwjgl3Window, Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration, long l2) {
        long l3 = Lwjgl3Application.createGlfwWindow(lwjgl3ApplicationConfiguration, l2);
        lwjgl3Window.create(l3);
        lwjgl3Window.setVisible(lwjgl3ApplicationConfiguration.initialVisible);
        for (int i2 = 0; i2 < 2; ++i2) {
            GL11.glClearColor(lwjgl3ApplicationConfiguration.initialBackgroundColor.r, lwjgl3ApplicationConfiguration.initialBackgroundColor.g, lwjgl3ApplicationConfiguration.initialBackgroundColor.b, lwjgl3ApplicationConfiguration.initialBackgroundColor.a);
            GL11.glClear(16384);
            GLFW.glfwSwapBuffers(l3);
        }
    }

    static long createGlfwWindow(Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration, long l2) {
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(131076, 0);
        GLFW.glfwWindowHint(131075, lwjgl3ApplicationConfiguration.windowResizable ? 1 : 0);
        GLFW.glfwWindowHint(131080, lwjgl3ApplicationConfiguration.windowMaximized ? 1 : 0);
        GLFW.glfwWindowHint(131078, lwjgl3ApplicationConfiguration.autoIconify ? 1 : 0);
        GLFW.glfwWindowHint(135169, lwjgl3ApplicationConfiguration.r);
        GLFW.glfwWindowHint(135170, lwjgl3ApplicationConfiguration.g);
        GLFW.glfwWindowHint(135171, lwjgl3ApplicationConfiguration.b);
        GLFW.glfwWindowHint(135172, lwjgl3ApplicationConfiguration.a);
        GLFW.glfwWindowHint(135174, lwjgl3ApplicationConfiguration.stencil);
        GLFW.glfwWindowHint(135173, lwjgl3ApplicationConfiguration.depth);
        GLFW.glfwWindowHint(135181, lwjgl3ApplicationConfiguration.samples);
        if (lwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.GL30) {
            GLFW.glfwWindowHint(139266, lwjgl3ApplicationConfiguration.gles30ContextMajorVersion);
            GLFW.glfwWindowHint(139267, lwjgl3ApplicationConfiguration.gles30ContextMinorVersion);
            if (SharedLibraryLoader.isMac) {
                GLFW.glfwWindowHint(139270, 1);
                GLFW.glfwWindowHint(139272, 204801);
            }
        } else if (lwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20) {
            GLFW.glfwWindowHint(139275, 221186);
            GLFW.glfwWindowHint(139265, 196610);
            GLFW.glfwWindowHint(139266, 2);
            GLFW.glfwWindowHint(139267, 0);
        }
        if (lwjgl3ApplicationConfiguration.transparentFramebuffer) {
            GLFW.glfwWindowHint(131082, 1);
        }
        if (lwjgl3ApplicationConfiguration.debug) {
            GLFW.glfwWindowHint(139271, 1);
        }
        long l3 = 0L;
        if (lwjgl3ApplicationConfiguration.fullscreenMode != null) {
            GLFW.glfwWindowHint(135183, lwjgl3ApplicationConfiguration.fullscreenMode.refreshRate);
            l3 = GLFW.glfwCreateWindow(lwjgl3ApplicationConfiguration.fullscreenMode.width, lwjgl3ApplicationConfiguration.fullscreenMode.height, lwjgl3ApplicationConfiguration.title, lwjgl3ApplicationConfiguration.fullscreenMode.getMonitor(), l2);
        } else {
            GLFW.glfwWindowHint(131077, lwjgl3ApplicationConfiguration.windowDecorated ? 1 : 0);
            l3 = GLFW.glfwCreateWindow(lwjgl3ApplicationConfiguration.windowWidth, lwjgl3ApplicationConfiguration.windowHeight, lwjgl3ApplicationConfiguration.title, 0L, l2);
        }
        if (l3 == 0L) {
            throw new GdxRuntimeException("Couldn't create window");
        }
        Lwjgl3Window.setSizeLimits(l3, lwjgl3ApplicationConfiguration.windowMinWidth, lwjgl3ApplicationConfiguration.windowMinHeight, lwjgl3ApplicationConfiguration.windowMaxWidth, lwjgl3ApplicationConfiguration.windowMaxHeight);
        if (lwjgl3ApplicationConfiguration.fullscreenMode == null) {
            if (lwjgl3ApplicationConfiguration.windowX == -1 && lwjgl3ApplicationConfiguration.windowY == -1) {
                int n2 = Math.max(lwjgl3ApplicationConfiguration.windowWidth, lwjgl3ApplicationConfiguration.windowMinWidth);
                int n3 = Math.max(lwjgl3ApplicationConfiguration.windowHeight, lwjgl3ApplicationConfiguration.windowMinHeight);
                if (lwjgl3ApplicationConfiguration.windowMaxWidth > -1) {
                    n2 = Math.min(n2, lwjgl3ApplicationConfiguration.windowMaxWidth);
                }
                if (lwjgl3ApplicationConfiguration.windowMaxHeight > -1) {
                    n3 = Math.min(n3, lwjgl3ApplicationConfiguration.windowMaxHeight);
                }
                long l4 = GLFW.glfwGetPrimaryMonitor();
                if (lwjgl3ApplicationConfiguration.windowMaximized && lwjgl3ApplicationConfiguration.maximizedMonitor != null) {
                    l4 = lwjgl3ApplicationConfiguration.maximizedMonitor.monitorHandle;
                }
                IntBuffer intBuffer = BufferUtils.createIntBuffer(1);
                IntBuffer intBuffer2 = BufferUtils.createIntBuffer(1);
                IntBuffer intBuffer3 = BufferUtils.createIntBuffer(1);
                IntBuffer intBuffer4 = BufferUtils.createIntBuffer(1);
                GLFW.glfwGetMonitorWorkarea(l4, intBuffer, intBuffer2, intBuffer3, intBuffer4);
                GLFW.glfwSetWindowPos(l3, Math.max(0, intBuffer.get(0) + intBuffer3.get(0) / 2 - n2 / 2), Math.max(0, intBuffer2.get(0) + intBuffer4.get(0) / 2 - n3 / 2));
            } else {
                GLFW.glfwSetWindowPos(l3, lwjgl3ApplicationConfiguration.windowX, lwjgl3ApplicationConfiguration.windowY);
            }
            if (lwjgl3ApplicationConfiguration.windowMaximized) {
                GLFW.glfwMaximizeWindow(l3);
            }
        }
        if (lwjgl3ApplicationConfiguration.windowIconPaths != null) {
            Lwjgl3Window.setIcon(l3, lwjgl3ApplicationConfiguration.windowIconPaths, lwjgl3ApplicationConfiguration.windowIconFileType);
        }
        GLFW.glfwMakeContextCurrent(l3);
        GLFW.glfwSwapInterval(lwjgl3ApplicationConfiguration.vSyncEnabled ? 1 : 0);
        if (lwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20) {
            try {
                Class<?> clazz = Class.forName("org.lwjgl.opengles.GLES");
                clazz.getMethod("createCapabilities", new Class[0]).invoke(clazz, new Object[0]);
            }
            catch (Throwable throwable) {
                throw new GdxRuntimeException("Couldn't initialize GLES", throwable);
            }
        } else {
            GL.createCapabilities();
        }
        Lwjgl3Application.initiateGL(lwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20);
        if (!glVersion.isVersionEqualToOrHigher(2, 0)) {
            throw new GdxRuntimeException("OpenGL 2.0 or higher with the FBO extension is required. OpenGL version: " + GL11.glGetString(7938) + "\n" + glVersion.getDebugVersionString());
        }
        if (lwjgl3ApplicationConfiguration.glEmulation != Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20 && !Lwjgl3Application.supportsFBO()) {
            throw new GdxRuntimeException("OpenGL 2.0 or higher with the FBO extension is required. OpenGL version: " + GL11.glGetString(7938) + ", FBO extension: false\n" + glVersion.getDebugVersionString());
        }
        if (lwjgl3ApplicationConfiguration.debug) {
            glDebugCallback = GLUtil.setupDebugMessageCallback(lwjgl3ApplicationConfiguration.debugStream);
            Lwjgl3Application.setGLDebugMessageControl(GLDebugMessageSeverity.NOTIFICATION, false);
        }
        return l3;
    }

    private static void initiateGL(boolean bl2) {
        if (!bl2) {
            String string = GL11.glGetString(7938);
            String string2 = GL11.glGetString(7936);
            String string3 = GL11.glGetString(7937);
            glVersion = new GLVersion(Application.ApplicationType.Desktop, string, string2, string3);
        } else {
            try {
                Class<?> clazz = Class.forName("org.lwjgl.opengles.GLES20");
                Method method = clazz.getMethod("glGetString", Integer.TYPE);
                String string = (String)method.invoke(clazz, 7938);
                String string4 = (String)method.invoke(clazz, 7936);
                String string5 = (String)method.invoke(clazz, 7937);
                glVersion = new GLVersion(Application.ApplicationType.Desktop, string, string4, string5);
            }
            catch (Throwable throwable) {
                throw new GdxRuntimeException("Couldn't get GLES version string.", throwable);
            }
        }
    }

    private static boolean supportsFBO() {
        return glVersion.isVersionEqualToOrHigher(3, 0) || GLFW.glfwExtensionSupported("GL_EXT_framebuffer_object") || GLFW.glfwExtensionSupported("GL_ARB_framebuffer_object");
    }

    public static boolean setGLDebugMessageControl(GLDebugMessageSeverity gLDebugMessageSeverity, boolean bl2) {
        GLCapabilities gLCapabilities = GL.getCapabilities();
        int n2 = 4352;
        if (gLCapabilities.OpenGL43) {
            GL43.glDebugMessageControl(4352, 4352, gLDebugMessageSeverity.gl43, (IntBuffer)null, bl2);
            return true;
        }
        if (gLCapabilities.GL_KHR_debug) {
            KHRDebug.glDebugMessageControl(4352, 4352, gLDebugMessageSeverity.khr, (IntBuffer)null, bl2);
            return true;
        }
        if (gLCapabilities.GL_ARB_debug_output && gLDebugMessageSeverity.arb != -1) {
            ARBDebugOutput.glDebugMessageControlARB(4352, 4352, gLDebugMessageSeverity.arb, (IntBuffer)null, bl2);
            return true;
        }
        if (gLCapabilities.GL_AMD_debug_output && gLDebugMessageSeverity.amd != -1) {
            AMDDebugOutput.glDebugMessageEnableAMD(4352, gLDebugMessageSeverity.amd, (IntBuffer)null, bl2);
            return true;
        }
        return false;
    }

    public static enum GLDebugMessageSeverity {
        HIGH(37190, 37190, 37190, 37190),
        MEDIUM(37191, 37191, 37191, 37191),
        LOW(37192, 37192, 37192, 37192),
        NOTIFICATION(33387, 33387, -1, -1);

        final int gl43;
        final int khr;
        final int arb;
        final int amd;

        private GLDebugMessageSeverity(int n3, int n4, int n5, int n6) {
            this.gl43 = n3;
            this.khr = n4;
            this.arb = n5;
            this.amd = n6;
        }
    }
}

