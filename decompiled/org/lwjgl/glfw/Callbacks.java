/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.Callback;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public final class Callbacks {
    private Callbacks() {
    }

    public static void glfwFreeCallbacks(@NativeType(value="GLFWwindow *") long l2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        for (long l3 : new long[]{GLFW.Functions.SetWindowPosCallback, GLFW.Functions.SetWindowSizeCallback, GLFW.Functions.SetWindowCloseCallback, GLFW.Functions.SetWindowRefreshCallback, GLFW.Functions.SetWindowFocusCallback, GLFW.Functions.SetWindowIconifyCallback, GLFW.Functions.SetWindowMaximizeCallback, GLFW.Functions.SetFramebufferSizeCallback, GLFW.Functions.SetWindowContentScaleCallback, GLFW.Functions.SetKeyCallback, GLFW.Functions.SetCharCallback, GLFW.Functions.SetCharModsCallback, GLFW.Functions.SetMouseButtonCallback, GLFW.Functions.SetCursorPosCallback, GLFW.Functions.SetCursorEnterCallback, GLFW.Functions.SetScrollCallback, GLFW.Functions.SetDropCallback}) {
            long l4 = JNI.invokePPP(l2, 0L, l3);
            if (l4 == 0L) continue;
            Callback.free(l4);
        }
    }
}

