/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorEnterCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWCursorEnterCallback
extends Callback
implements GLFWCursorEnterCallbackI {
    public static GLFWCursorEnterCallback create(long l2) {
        GLFWCursorEnterCallbackI gLFWCursorEnterCallbackI = (GLFWCursorEnterCallbackI)Callback.get(l2);
        return gLFWCursorEnterCallbackI instanceof GLFWCursorEnterCallback ? (GLFWCursorEnterCallback)gLFWCursorEnterCallbackI : new Container(l2, gLFWCursorEnterCallbackI);
    }

    @Nullable
    public static GLFWCursorEnterCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWCursorEnterCallback.create(l2);
    }

    public static GLFWCursorEnterCallback create(GLFWCursorEnterCallbackI gLFWCursorEnterCallbackI) {
        return gLFWCursorEnterCallbackI instanceof GLFWCursorEnterCallback ? (GLFWCursorEnterCallback)gLFWCursorEnterCallbackI : new Container(gLFWCursorEnterCallbackI.address(), gLFWCursorEnterCallbackI);
    }

    protected GLFWCursorEnterCallback() {
        super(CIF);
    }

    GLFWCursorEnterCallback(long l2) {
        super(l2);
    }

    public GLFWCursorEnterCallback set(long l2) {
        GLFW.glfwSetCursorEnterCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWCursorEnterCallback {
        private final GLFWCursorEnterCallbackI delegate;

        Container(long l2, GLFWCursorEnterCallbackI gLFWCursorEnterCallbackI) {
            super(l2);
            this.delegate = gLFWCursorEnterCallbackI;
        }

        @Override
        public void invoke(long l2, boolean bl2) {
            this.delegate.invoke(l2, bl2);
        }
    }
}

