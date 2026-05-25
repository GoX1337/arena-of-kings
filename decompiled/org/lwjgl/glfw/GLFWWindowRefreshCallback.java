/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowRefreshCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowRefreshCallback
extends Callback
implements GLFWWindowRefreshCallbackI {
    public static GLFWWindowRefreshCallback create(long l2) {
        GLFWWindowRefreshCallbackI gLFWWindowRefreshCallbackI = (GLFWWindowRefreshCallbackI)Callback.get(l2);
        return gLFWWindowRefreshCallbackI instanceof GLFWWindowRefreshCallback ? (GLFWWindowRefreshCallback)gLFWWindowRefreshCallbackI : new Container(l2, gLFWWindowRefreshCallbackI);
    }

    @Nullable
    public static GLFWWindowRefreshCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWWindowRefreshCallback.create(l2);
    }

    public static GLFWWindowRefreshCallback create(GLFWWindowRefreshCallbackI gLFWWindowRefreshCallbackI) {
        return gLFWWindowRefreshCallbackI instanceof GLFWWindowRefreshCallback ? (GLFWWindowRefreshCallback)gLFWWindowRefreshCallbackI : new Container(gLFWWindowRefreshCallbackI.address(), gLFWWindowRefreshCallbackI);
    }

    public GLFWWindowRefreshCallback() {
        super(CIF);
    }

    GLFWWindowRefreshCallback(long l2) {
        super(l2);
    }

    public GLFWWindowRefreshCallback set(long l2) {
        GLFW.glfwSetWindowRefreshCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWWindowRefreshCallback {
        private final GLFWWindowRefreshCallbackI delegate;

        Container(long l2, GLFWWindowRefreshCallbackI gLFWWindowRefreshCallbackI) {
            super(l2);
            this.delegate = gLFWWindowRefreshCallbackI;
        }

        @Override
        public void invoke(long l2) {
            this.delegate.invoke(l2);
        }
    }
}

