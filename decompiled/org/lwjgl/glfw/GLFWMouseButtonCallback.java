/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWMouseButtonCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWMouseButtonCallback
extends Callback
implements GLFWMouseButtonCallbackI {
    public static GLFWMouseButtonCallback create(long l2) {
        GLFWMouseButtonCallbackI gLFWMouseButtonCallbackI = (GLFWMouseButtonCallbackI)Callback.get(l2);
        return gLFWMouseButtonCallbackI instanceof GLFWMouseButtonCallback ? (GLFWMouseButtonCallback)gLFWMouseButtonCallbackI : new Container(l2, gLFWMouseButtonCallbackI);
    }

    @Nullable
    public static GLFWMouseButtonCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWMouseButtonCallback.create(l2);
    }

    public static GLFWMouseButtonCallback create(GLFWMouseButtonCallbackI gLFWMouseButtonCallbackI) {
        return gLFWMouseButtonCallbackI instanceof GLFWMouseButtonCallback ? (GLFWMouseButtonCallback)gLFWMouseButtonCallbackI : new Container(gLFWMouseButtonCallbackI.address(), gLFWMouseButtonCallbackI);
    }

    public GLFWMouseButtonCallback() {
        super(CIF);
    }

    GLFWMouseButtonCallback(long l2) {
        super(l2);
    }

    public GLFWMouseButtonCallback set(long l2) {
        GLFW.glfwSetMouseButtonCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWMouseButtonCallback {
        private final GLFWMouseButtonCallbackI delegate;

        Container(long l2, GLFWMouseButtonCallbackI gLFWMouseButtonCallbackI) {
            super(l2);
            this.delegate = gLFWMouseButtonCallbackI;
        }

        @Override
        public void invoke(long l2, int n2, int n3, int n4) {
            this.delegate.invoke(l2, n2, n3, n4);
        }
    }
}

