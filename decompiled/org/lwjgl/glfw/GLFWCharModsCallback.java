/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharModsCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWCharModsCallback
extends Callback
implements GLFWCharModsCallbackI {
    public static GLFWCharModsCallback create(long l2) {
        GLFWCharModsCallbackI gLFWCharModsCallbackI = (GLFWCharModsCallbackI)Callback.get(l2);
        return gLFWCharModsCallbackI instanceof GLFWCharModsCallback ? (GLFWCharModsCallback)gLFWCharModsCallbackI : new Container(l2, gLFWCharModsCallbackI);
    }

    @Nullable
    public static GLFWCharModsCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWCharModsCallback.create(l2);
    }

    public static GLFWCharModsCallback create(GLFWCharModsCallbackI gLFWCharModsCallbackI) {
        return gLFWCharModsCallbackI instanceof GLFWCharModsCallback ? (GLFWCharModsCallback)gLFWCharModsCallbackI : new Container(gLFWCharModsCallbackI.address(), gLFWCharModsCallbackI);
    }

    protected GLFWCharModsCallback() {
        super(CIF);
    }

    GLFWCharModsCallback(long l2) {
        super(l2);
    }

    public GLFWCharModsCallback set(long l2) {
        GLFW.glfwSetCharModsCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWCharModsCallback {
        private final GLFWCharModsCallbackI delegate;

        Container(long l2, GLFWCharModsCallbackI gLFWCharModsCallbackI) {
            super(l2);
            this.delegate = gLFWCharModsCallbackI;
        }

        @Override
        public void invoke(long l2, int n2, int n3) {
            this.delegate.invoke(l2, n2, n3);
        }
    }
}

