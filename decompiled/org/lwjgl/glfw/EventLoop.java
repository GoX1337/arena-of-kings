/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.lwjgl.system.Configuration;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Platform;
import org.lwjgl.system.macosx.LibC;
import org.lwjgl.system.macosx.ObjCRuntime;

final class EventLoop {
    private EventLoop() {
    }

    static void check() {
    }

    private static boolean isMainThread() {
        if (!Configuration.GLFW_CHECK_THREAD0.get(true).booleanValue() || Configuration.GLFW_LIBRARY_NAME.get("").contains("glfw_async")) {
            return true;
        }
        long l2 = ObjCRuntime.getLibrary().getFunctionAddress("objc_msgSend");
        long l3 = ObjCRuntime.objc_getClass("NSThread");
        long l4 = JNI.invokePPP(l3, ObjCRuntime.sel_getUid("currentThread"), l2);
        return JNI.invokePPZ(l4, ObjCRuntime.sel_getUid("isMainThread"), l2);
    }

    private static boolean isJavaStartedOnFirstThread() {
        return "1".equals(System.getenv().get("JAVA_STARTED_ON_FIRST_THREAD_" + LibC.getpid()));
    }

    static {
        if (Platform.get() == Platform.MACOSX && !EventLoop.isMainThread()) {
            throw new IllegalStateException(EventLoop.isJavaStartedOnFirstThread() ? "GLFW may only be used on the main thread. This check may be disabled with Configuration.GLFW_CHECK_THREAD0." : "GLFW may only be used on the main thread and that thread must be the first thread in the process. Please run the JVM with -XstartOnFirstThread. This check may be disabled with Configuration.GLFW_CHECK_THREAD0.");
        }
    }
}

