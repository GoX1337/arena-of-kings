/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWKeyCallback
extends Callback
implements GLFWKeyCallbackI {
    public static GLFWKeyCallback create(long l2) {
        GLFWKeyCallbackI gLFWKeyCallbackI = (GLFWKeyCallbackI)Callback.get(l2);
        return gLFWKeyCallbackI instanceof GLFWKeyCallback ? (GLFWKeyCallback)gLFWKeyCallbackI : new Container(l2, gLFWKeyCallbackI);
    }

    @Nullable
    public static GLFWKeyCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWKeyCallback.create(l2);
    }

    public static GLFWKeyCallback create(GLFWKeyCallbackI gLFWKeyCallbackI) {
        return gLFWKeyCallbackI instanceof GLFWKeyCallback ? (GLFWKeyCallback)gLFWKeyCallbackI : new Container(gLFWKeyCallbackI.address(), gLFWKeyCallbackI);
    }

    public GLFWKeyCallback() {
        super(CIF);
    }

    GLFWKeyCallback(long l2) {
        super(l2);
    }

    public GLFWKeyCallback set(long l2) {
        GLFW.glfwSetKeyCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWKeyCallback {
        private final GLFWKeyCallbackI delegate;

        Container(long l2, GLFWKeyCallbackI gLFWKeyCallbackI) {
            super(l2);
            this.delegate = gLFWKeyCallbackI;
        }

        @Override
        public void invoke(long l2, int n2, int n3, int n4, int n5) {
            this.delegate.invoke(l2, n2, n3, n4, n5);
        }
    }
}

