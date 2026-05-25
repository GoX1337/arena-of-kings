/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFWReallocateCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWReallocateCallback
extends Callback
implements GLFWReallocateCallbackI {
    public static GLFWReallocateCallback create(long l2) {
        GLFWReallocateCallbackI gLFWReallocateCallbackI = (GLFWReallocateCallbackI)Callback.get(l2);
        return gLFWReallocateCallbackI instanceof GLFWReallocateCallback ? (GLFWReallocateCallback)gLFWReallocateCallbackI : new Container(l2, gLFWReallocateCallbackI);
    }

    @Nullable
    public static GLFWReallocateCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWReallocateCallback.create(l2);
    }

    public static GLFWReallocateCallback create(GLFWReallocateCallbackI gLFWReallocateCallbackI) {
        return gLFWReallocateCallbackI instanceof GLFWReallocateCallback ? (GLFWReallocateCallback)gLFWReallocateCallbackI : new Container(gLFWReallocateCallbackI.address(), gLFWReallocateCallbackI);
    }

    protected GLFWReallocateCallback() {
        super(CIF);
    }

    GLFWReallocateCallback(long l2) {
        super(l2);
    }

    static final class Container
    extends GLFWReallocateCallback {
        private final GLFWReallocateCallbackI delegate;

        Container(long l2, GLFWReallocateCallbackI gLFWReallocateCallbackI) {
            super(l2);
            this.delegate = gLFWReallocateCallbackI;
        }

        @Override
        public long invoke(long l2, long l3, long l4) {
            return this.delegate.invoke(l2, l3, l4);
        }
    }
}

