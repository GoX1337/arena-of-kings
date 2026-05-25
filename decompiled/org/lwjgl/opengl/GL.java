/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.lang.invoke.LambdaMetafactory;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.IntFunction;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLX11;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.opengl.WGL;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.Platform;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.ThreadLocalUtil;
import org.lwjgl.system.linux.X11;
import org.lwjgl.system.macosx.MacOSXLibrary;
import org.lwjgl.system.windows.GDI32;
import org.lwjgl.system.windows.PIXELFORMATDESCRIPTOR;
import org.lwjgl.system.windows.User32;
import org.lwjgl.system.windows.WNDCLASSEX;
import org.lwjgl.system.windows.WindowsLibrary;
import org.lwjgl.system.windows.WindowsUtil;

public final class GL {
    @Nullable
    private static final APIUtil.APIVersion MAX_VERSION;
    @Nullable
    private static FunctionProvider functionProvider;
    private static final ThreadLocal<GLCapabilities> capabilitiesTLS;
    private static ICD icd;
    @Nullable
    private static WGLCapabilities capabilitiesWGL;
    @Nullable
    private static GLXCapabilities capabilitiesGLXClient;
    @Nullable
    private static GLXCapabilities capabilitiesGLX;

    private GL() {
    }

    static void initialize() {
    }

    public static void create() {
        SharedLibrary sharedLibrary;
        switch (Platform.get()) {
            case LINUX: {
                sharedLibrary = Library.loadNative(GL.class, "org.lwjgl.opengl", Configuration.OPENGL_LIBRARY_NAME, "libGL.so.1", "libGL.so");
                break;
            }
            case MACOSX: {
                String string = Configuration.OPENGL_LIBRARY_NAME.get();
                sharedLibrary = string != null ? Library.loadNative(GL.class, "org.lwjgl.opengl", string) : MacOSXLibrary.getWithIdentifier("com.apple.opengl");
                break;
            }
            case WINDOWS: {
                sharedLibrary = Library.loadNative(GL.class, "org.lwjgl.opengl", Configuration.OPENGL_LIBRARY_NAME, "opengl32");
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        GL.create(sharedLibrary);
    }

    public static void create(String string) {
        GL.create(Library.loadNative(GL.class, "org.lwjgl.opengl", string));
    }

    private static void create(SharedLibrary sharedLibrary) {
        try {
            GL.create((FunctionProvider)new SharedLibrary.Delegate(sharedLibrary){
                private final long GetProcAddress;
                {
                    long l2 = 0L;
                    switch (Platform.get()) {
                        case LINUX: {
                            l2 = this.library.getFunctionAddress("glXGetProcAddress");
                            if (l2 != 0L) break;
                            l2 = this.library.getFunctionAddress("glXGetProcAddressARB");
                            break;
                        }
                        case WINDOWS: {
                            l2 = this.library.getFunctionAddress("wglGetProcAddress");
                        }
                    }
                    if (l2 == 0L) {
                        l2 = this.library.getFunctionAddress("OSMesaGetProcAddress");
                    }
                    this.GetProcAddress = l2;
                }

                @Override
                public long getFunctionAddress(ByteBuffer byteBuffer) {
                    long l2;
                    long l3 = this.GetProcAddress == 0L ? 0L : (l2 = Platform.get() == Platform.WINDOWS ? WGL.nwglGetProcAddress(MemoryUtil.memAddress(byteBuffer), this.GetProcAddress) : JNI.callPP(MemoryUtil.memAddress(byteBuffer), this.GetProcAddress));
                    if (l2 == 0L && (l2 = this.library.getFunctionAddress(byteBuffer)) == 0L && Checks.DEBUG_FUNCTIONS) {
                        APIUtil.apiLog("Failed to locate address for GL function " + MemoryUtil.memASCII(byteBuffer));
                    }
                    return l2;
                }
            });
        }
        catch (RuntimeException runtimeException) {
            sharedLibrary.free();
            throw runtimeException;
        }
    }

    public static void create(FunctionProvider functionProvider) {
        if (GL.functionProvider != null) {
            throw new IllegalStateException("OpenGL library has already been loaded.");
        }
        GL.functionProvider = functionProvider;
        ThreadLocalUtil.setFunctionMissingAddresses(2226);
    }

    public static void destroy() {
        if (functionProvider == null) {
            return;
        }
        ThreadLocalUtil.setFunctionMissingAddresses(0);
        capabilitiesWGL = null;
        capabilitiesGLX = null;
        if (functionProvider instanceof NativeResource) {
            ((NativeResource)((Object)functionProvider)).free();
        }
        functionProvider = null;
    }

    @Nullable
    public static FunctionProvider getFunctionProvider() {
        return functionProvider;
    }

    public static void setCapabilities(@Nullable GLCapabilities gLCapabilities) {
        capabilitiesTLS.set(gLCapabilities);
        ThreadLocalUtil.setCapabilities(gLCapabilities == null ? 0L : MemoryUtil.memAddress(gLCapabilities.addresses));
        icd.set(gLCapabilities);
    }

    public static GLCapabilities getCapabilities() {
        return GL.checkCapabilities(capabilitiesTLS.get());
    }

    private static GLCapabilities checkCapabilities(@Nullable GLCapabilities gLCapabilities) {
        if (Checks.CHECKS && gLCapabilities == null) {
            throw new IllegalStateException("No GLCapabilities instance set for the current thread. Possible solutions:\n\ta) Call GL.createCapabilities() after making a context current in the current thread.\n\tb) Call GL.setCapabilities() if a GLCapabilities instance already exists for the current context.");
        }
        return gLCapabilities;
    }

    public static WGLCapabilities getCapabilitiesWGL() {
        if (capabilitiesWGL == null) {
            capabilitiesWGL = GL.createCapabilitiesWGLDummy();
        }
        return capabilitiesWGL;
    }

    static GLXCapabilities getCapabilitiesGLXClient() {
        if (capabilitiesGLXClient == null) {
            capabilitiesGLXClient = GL.initCapabilitiesGLX(true);
        }
        return capabilitiesGLXClient;
    }

    public static GLXCapabilities getCapabilitiesGLX() {
        if (capabilitiesGLX == null) {
            capabilitiesGLX = GL.initCapabilitiesGLX(false);
        }
        return capabilitiesGLX;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static GLXCapabilities initCapabilitiesGLX(boolean bl2) {
        long l2 = X11.nXOpenDisplay(0L);
        try {
            GLXCapabilities gLXCapabilities = GL.createCapabilitiesGLX(l2, bl2 ? -1 : X11.XDefaultScreen(l2));
            return gLXCapabilities;
        }
        finally {
            X11.XCloseDisplay(l2);
        }
    }

    public static GLCapabilities createCapabilities() {
        return GL.createCapabilities(null);
    }

    public static GLCapabilities createCapabilities(@Nullable IntFunction<PointerBuffer> intFunction) {
        return GL.createCapabilities(false, intFunction);
    }

    public static GLCapabilities createCapabilities(boolean bl2) {
        return GL.createCapabilities(bl2, null);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static GLCapabilities createCapabilities(boolean var0, @Nullable IntFunction<PointerBuffer> var1_1) {
        var2_2 = GL.functionProvider;
        if (var2_2 == null) {
            throw new IllegalStateException("OpenGL library has not been loaded.");
        }
        var3_3 = var2_2.getFunctionAddress("glGetError");
        var5_4 = var2_2.getFunctionAddress("glGetString");
        var7_5 = var2_2.getFunctionAddress("glGetIntegerv");
        if (var3_3 == 0L || var5_4 == 0L || var7_5 == 0L) {
            throw new IllegalStateException("Core OpenGL functions could not be found. Make sure that the OpenGL library has been loaded correctly.");
        }
        var9_6 = JNI.callI(var3_3);
        if (var9_6 != 0) {
            APIUtil.apiLog(String.format("An OpenGL context was in an error state before the creation of its capabilities instance. Error: 0x%X", new Object[]{var9_6}));
        }
        var12_7 = MemoryStack.stackPush();
        var13_8 = null;
        try {
            var14_9 = var12_7.ints(0);
            JNI.callPV(33307, MemoryUtil.memAddress(var14_9), var7_5);
            if (JNI.callI(var3_3) == 0 && 3 <= (var10_13 = var14_9.get(0))) {
                JNI.callPV(33308, MemoryUtil.memAddress(var14_9), var7_5);
                var11_14 = var14_9.get(0);
            } else {
                var15_15 = MemoryUtil.memUTF8Safe(JNI.callP(7938, var5_4));
                if (var15_15 == null || JNI.callI(var3_3) != 0) {
                    throw new IllegalStateException("There is no OpenGL context current in the current thread.");
                }
                var16_18 = APIUtil.apiParseVersion(var15_15);
                var10_13 = var16_18.major;
                var11_14 = var16_18.minor;
            }
        }
        catch (Throwable var14_11) {
            var13_8 = var14_11;
            throw var14_11;
        }
        finally {
            if (var12_7 != null) {
                if (var13_8 != null) {
                    try {
                        var12_7.close();
                    }
                    catch (Throwable var14_10) {
                        var13_8.addSuppressed(var14_10);
                    }
                } else {
                    var12_7.close();
                }
            }
        }
        if (var10_13 < 1 || var10_13 == 1 && var11_14 < 1) {
            throw new IllegalStateException("OpenGL 1.1 is required.");
        }
        var12_7 = new int[]{5, 1, 3, 6};
        var13_8 = new HashSet<E>(512);
        var14_12 = Math.min(var10_13, ((Object)var12_7).length);
        if (GL.MAX_VERSION != null) {
            var14_12 = Math.min(GL.MAX_VERSION.major, var14_12);
        }
        for (var15_16 = 1; var15_16 <= var14_12; ++var15_16) {
            var16_19 /* !! */  = var12_7[var15_16 - 1];
            if (var15_16 == var10_13) {
                var16_19 /* !! */  = Math.min(var11_14, (int)var16_19 /* !! */ );
            }
            if (GL.MAX_VERSION != null && var15_16 == GL.MAX_VERSION.major) {
                var16_19 /* !! */  = Math.min(GL.MAX_VERSION.minor, (int)var16_19 /* !! */ );
            }
            v0 = var17_21 = var15_16 == 1 ? 1 : 0;
            while (var17_21 <= var16_19 /* !! */ ) {
                var13_8.add(String.format("OpenGL%d%d", new Object[]{var15_16, var17_21}));
                ++var17_21;
            }
        }
        if (var10_13 < 3) {
            var15_17 = MemoryUtil.memASCIISafe(JNI.callP(7939, var5_4));
            if (var15_17 != null) {
                var16_18 = new StringTokenizer((String)var15_17);
                while (var16_18.hasMoreTokens()) {
                    var13_8.add(var16_18.nextToken());
                }
            }
        } else {
            var15_17 = MemoryStack.stackPush();
            var16_18 = null;
            try {
                var17_22 = var15_17.ints(0);
                JNI.callPV(33309, MemoryUtil.memAddress(var17_22), var7_5);
                var18_26 = var17_22.get(0);
                var19_27 = APIUtil.apiGetFunctionAddress(var2_2, "glGetStringi");
                for (var21_28 = 0; var21_28 < var18_26; ++var21_28) {
                    var13_8.add(MemoryUtil.memASCII(JNI.callP(7939, var21_28, var19_27)));
                }
                JNI.callPV(33310, MemoryUtil.memAddress(var17_22), var7_5);
                if ((var17_22.get(0) & 1) != 0) {
                    var0 = true;
                }
                if (3 >= var10_13 && 1 > var11_14) ** GOTO lbl110
                if (3 < var10_13 || 2 <= var11_14) {
                    JNI.callPV(37158, MemoryUtil.memAddress(var17_22), var7_5);
                    if ((var17_22.get(0) & 1) == 0) ** GOTO lbl110
                    var0 = true;
                }
                var0 = var13_8.contains("GL_ARB_compatibility") == false;
            }
            catch (Throwable var17_24) {
                var16_18 = var17_24;
                throw var17_24;
            }
            finally {
                if (var15_17 != null) {
                    if (var16_18 != null) {
                        try {
                            var15_17.close();
                        }
                        catch (Throwable var17_23) {
                            var16_18.addSuppressed(var17_23);
                        }
                    } else {
                        var15_17.close();
                    }
                }
            }
        }
lbl110:
        // 6 sources

        APIUtil.apiFilterExtensions((Set<String>)var13_8, Configuration.OPENGL_EXTENSION_FILTER);
        var15_17 = new GLCapabilities(var2_2, (Set<String>)var13_8, var0, var1_1 == null ? (IntFunction<PointerBuffer>)LambdaMetafactory.metafactory(null, null, null, (I)Ljava/lang/Object;, createPointerBuffer(int ), (I)Lorg/lwjgl/PointerBuffer;)() : var1_1);
        GL.setCapabilities((GLCapabilities)var15_17);
        return var15_17;
    }

    /*
     * Loose catch block
     */
    private static WGLCapabilities createCapabilitiesWGLDummy() {
        long l2 = WGL.wglGetCurrentDC();
        if (l2 != 0L) {
            return GL.createCapabilitiesWGL(l2);
        }
        int n2 = 0;
        long l3 = 0L;
        long l4 = 0L;
        try {
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                PIXELFORMATDESCRIPTOR pIXELFORMATDESCRIPTOR;
                WNDCLASSEX wNDCLASSEX = WNDCLASSEX.calloc(memoryStack).cbSize(WNDCLASSEX.SIZEOF).style(3).hInstance(WindowsLibrary.HINSTANCE).lpszClassName(memoryStack.UTF16("WGL"));
                MemoryUtil.memPutAddress(wNDCLASSEX.address() + (long)WNDCLASSEX.LPFNWNDPROC, User32.Functions.DefWindowProc);
                n2 = User32.RegisterClassEx(wNDCLASSEX);
                if (n2 == 0) {
                    throw new IllegalStateException("Failed to register WGL window class");
                }
                l3 = Checks.check(User32.nCreateWindowEx(0, n2 & 0xFFFF, 0L, 114229248, 0, 0, 1, 1, 0L, 0L, 0L, 0L));
                l2 = Checks.check(User32.GetDC(l3));
                int n3 = GDI32.ChoosePixelFormat(l2, pIXELFORMATDESCRIPTOR = PIXELFORMATDESCRIPTOR.calloc(memoryStack).nSize((short)PIXELFORMATDESCRIPTOR.SIZEOF).nVersion((short)1).dwFlags(32));
                if (n3 == 0) {
                    WindowsUtil.windowsThrowException("Failed to choose an OpenGL-compatible pixel format");
                }
                if (GDI32.DescribePixelFormat(l2, n3, pIXELFORMATDESCRIPTOR) == 0) {
                    WindowsUtil.windowsThrowException("Failed to obtain pixel format information");
                }
                if (!GDI32.SetPixelFormat(l2, n3, pIXELFORMATDESCRIPTOR)) {
                    WindowsUtil.windowsThrowException("Failed to set the pixel format");
                }
                l4 = Checks.check(WGL.wglCreateContext(l2));
                WGL.wglMakeCurrent(l2, l4);
                WGLCapabilities wGLCapabilities = GL.createCapabilitiesWGL(l2);
                return wGLCapabilities;
            }
            {
                catch (Throwable throwable) {
                    throw throwable;
                }
            }
        }
        finally {
            if (l4 != 0L) {
                WGL.wglMakeCurrent(0L, 0L);
                WGL.wglDeleteContext(l4);
            }
            if (l3 != 0L) {
                User32.DestroyWindow(l3);
            }
            if (n2 != 0) {
                User32.nUnregisterClass(n2 & 0xFFFF, WindowsLibrary.HINSTANCE);
            }
        }
    }

    public static WGLCapabilities createCapabilitiesWGL() {
        long l2 = WGL.wglGetCurrentDC();
        if (l2 == 0L) {
            throw new IllegalStateException("Failed to retrieve the device context of the current OpenGL context");
        }
        return GL.createCapabilitiesWGL(l2);
    }

    private static WGLCapabilities createCapabilitiesWGL(long l2) {
        FunctionProvider functionProvider = GL.functionProvider;
        if (functionProvider == null) {
            throw new IllegalStateException("OpenGL library has not been loaded.");
        }
        String string = null;
        long l3 = functionProvider.getFunctionAddress("wglGetExtensionsStringARB");
        if (l3 != 0L) {
            string = MemoryUtil.memASCII(JNI.callPP(l2, l3));
        } else {
            l3 = functionProvider.getFunctionAddress("wglGetExtensionsStringEXT");
            if (l3 != 0L) {
                string = MemoryUtil.memASCII(JNI.callP(l3));
            }
        }
        HashSet<String> hashSet = new HashSet<String>(32);
        if (string != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(string);
            while (stringTokenizer.hasMoreTokens()) {
                hashSet.add(stringTokenizer.nextToken());
            }
        }
        APIUtil.apiFilterExtensions(hashSet, Configuration.OPENGL_EXTENSION_FILTER);
        return new WGLCapabilities(functionProvider, hashSet);
    }

    public static GLXCapabilities createCapabilitiesGLX(long l2) {
        return GL.createCapabilitiesGLX(l2, X11.XDefaultScreen(l2));
    }

    public static GLXCapabilities createCapabilitiesGLX(long l2, int n2) {
        int n3;
        int n4;
        Object object;
        FunctionProvider functionProvider = GL.functionProvider;
        if (functionProvider == null) {
            throw new IllegalStateException("OpenGL library has not been loaded.");
        }
        Object object2 = MemoryStack.stackPush();
        Object object3 = null;
        try {
            IntBuffer intBuffer = ((MemoryStack)object2).ints(0);
            object = ((MemoryStack)object2).ints(0);
            if (!GLX11.glXQueryVersion(l2, intBuffer, (IntBuffer)object)) {
                throw new IllegalStateException("Failed to query GLX version");
            }
            n4 = intBuffer.get(0);
            n3 = ((IntBuffer)object).get(0);
            if (n4 != 1) {
                throw new IllegalStateException("Invalid GLX major version: " + n4);
            }
        }
        catch (Throwable throwable) {
            object3 = throwable;
            throw throwable;
        }
        finally {
            if (object2 != null) {
                if (object3 != null) {
                    try {
                        ((MemoryStack)object2).close();
                    }
                    catch (Throwable throwable) {
                        ((Throwable)object3).addSuppressed(throwable);
                    }
                } else {
                    ((MemoryStack)object2).close();
                }
            }
        }
        object2 = new HashSet(32);
        object3 = new int[][]{{1, 2, 3, 4}};
        for (int i2 = 1; i2 <= ((Object)object3).length; ++i2) {
            for (Object object4 : object = object3[i2 - 1]) {
                if (i2 >= n4 && (i2 != n4 || object4 > n3)) continue;
                object2.add("GLX" + i2 + (int)object4);
            }
        }
        if (1 <= n3) {
            String string;
            long l3;
            if (n2 == -1) {
                l3 = functionProvider.getFunctionAddress("glXGetClientString");
                string = MemoryUtil.memASCIISafe(JNI.callPP(l2, 3, l3));
            } else {
                l3 = functionProvider.getFunctionAddress("glXQueryExtensionsString");
                string = MemoryUtil.memASCIISafe(JNI.callPP(l2, n2, l3));
            }
            if (string != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(string);
                while (stringTokenizer.hasMoreTokens()) {
                    object2.add(stringTokenizer.nextToken());
                }
            }
        }
        APIUtil.apiFilterExtensions((Set<String>)object2, Configuration.OPENGL_EXTENSION_FILTER);
        return new GLXCapabilities(functionProvider, (Set<String>)object2);
    }

    static GLCapabilities getICD() {
        return GL.checkCapabilities(icd.get());
    }

    static {
        capabilitiesTLS = new ThreadLocal();
        icd = new ICDStatic();
        Library.loadSystem(System::load, System::loadLibrary, GL.class, "org.lwjgl.opengl", Platform.mapLibraryNameBundled("lwjgl_opengl"));
        MAX_VERSION = APIUtil.apiParseVersion(Configuration.OPENGL_MAXVERSION);
        if (!Configuration.OPENGL_EXPLICIT_INIT.get(false).booleanValue()) {
            GL.create();
        }
    }

    static class ICDStatic
    implements ICD {
        @Nullable
        private static GLCapabilities tempCaps;

        private ICDStatic() {
        }

        @Override
        public void set(@Nullable GLCapabilities gLCapabilities) {
            if (tempCaps == null) {
                tempCaps = gLCapabilities;
            } else if (gLCapabilities != null && gLCapabilities != tempCaps && ThreadLocalUtil.areCapabilitiesDifferent(ICDStatic.tempCaps.addresses, gLCapabilities.addresses)) {
                APIUtil.apiLog("[WARNING] Incompatible context detected. Falling back to thread-local lookup for GL contexts.");
                icd = GL::getCapabilities;
            }
        }

        @Override
        public GLCapabilities get() {
            return WriteOnce.caps;
        }

        static final class WriteOnce {
            static final GLCapabilities caps;

            private WriteOnce() {
            }

            static {
                GLCapabilities gLCapabilities = tempCaps;
                if (gLCapabilities == null) {
                    throw new IllegalStateException("No GLCapabilities instance has been set");
                }
                caps = gLCapabilities;
            }
        }
    }

    static interface ICD {
        default public void set(@Nullable GLCapabilities gLCapabilities) {
        }

        @Nullable
        public GLCapabilities get();
    }
}

