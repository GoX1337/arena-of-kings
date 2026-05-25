/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowFocusCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowFocusCallback
extends Callback
implements GLFWWindowFocusCallbackI {
    public static GLFWWindowFocusCallback create(long l2) {
        GLFWWindowFocusCallbackI gLFWWindowFocusCallbackI = (GLFWWindowFocusCallbackI)Callback.get(l2);
        return gLFWWindowFocusCallbackI instanceof GLFWWindowFocusCallback ? (GLFWWindowFocusCallback)gLFWWindowFocusCallbackI : new Container(l2, gLFWWindowFocusCallbackI);
    }

    @Nullable
    public static GLFWWindowFocusCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWWindowFocusCallback.create(l2);
    }

    public static GLFWWindowFocusCallback create(GLFWWindowFocusCallbackI gLFWWindowFocusCallbackI) {
        return gLFWWindowFocusCallbackI instanceof GLFWWindowFocusCallback ? (GLFWWindowFocusCallback)gLFWWindowFocusCallbackI : new Container(gLFWWindowFocusCallbackI.address(), gLFWWindowFocusCallbackI);
    }

    public GLFWWindowFocusCallback() {
        super(CIF);
    }

    GLFWWindowFocusCallback(long l2) {
        super(l2);
    }

    public GLFWWindowFocusCallback set(long l2) {
        GLFW.glfwSetWindowFocusCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWWindowFocusCallback {
        private final GLFWWindowFocusCallbackI delegate;

        Container(long l2, GLFWWindowFocusCallbackI gLFWWindowFocusCallbackI) {
            super(l2);
            this.delegate = gLFWWindowFocusCallbackI;
        }

        @Override
        public void invoke(long l2, boolean bl2) {
            this.delegate.invoke(l2, bl2);
        }
    }
}

