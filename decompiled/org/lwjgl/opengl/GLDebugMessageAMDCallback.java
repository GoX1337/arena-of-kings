/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import javax.annotation.Nullable;
import org.lwjgl.opengl.GLDebugMessageAMDCallbackI;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;

public abstract class GLDebugMessageAMDCallback
extends Callback
implements GLDebugMessageAMDCallbackI {
    public static GLDebugMessageAMDCallback create(long l2) {
        GLDebugMessageAMDCallbackI gLDebugMessageAMDCallbackI = (GLDebugMessageAMDCallbackI)Callback.get(l2);
        return gLDebugMessageAMDCallbackI instanceof GLDebugMessageAMDCallback ? (GLDebugMessageAMDCallback)gLDebugMessageAMDCallbackI : new Container(l2, gLDebugMessageAMDCallbackI);
    }

    @Nullable
    public static GLDebugMessageAMDCallback createSafe(long l2) {
        return l2 == 0L ? null : GLDebugMessageAMDCallback.create(l2);
    }

    public static GLDebugMessageAMDCallback create(GLDebugMessageAMDCallbackI gLDebugMessageAMDCallbackI) {
        return gLDebugMessageAMDCallbackI instanceof GLDebugMessageAMDCallback ? (GLDebugMessageAMDCallback)gLDebugMessageAMDCallbackI : new Container(gLDebugMessageAMDCallbackI.address(), gLDebugMessageAMDCallbackI);
    }

    protected GLDebugMessageAMDCallback() {
        super(CIF);
    }

    GLDebugMessageAMDCallback(long l2) {
        super(l2);
    }

    public static String getMessage(int n2, long l2) {
        return MemoryUtil.memUTF8(MemoryUtil.memByteBuffer(l2, n2));
    }

    static final class Container
    extends GLDebugMessageAMDCallback {
        private final GLDebugMessageAMDCallbackI delegate;

        Container(long l2, GLDebugMessageAMDCallbackI gLDebugMessageAMDCallbackI) {
            super(l2);
            this.delegate = gLDebugMessageAMDCallbackI;
        }

        @Override
        public void invoke(int n2, int n3, int n4, int n5, long l2, long l3) {
            this.delegate.invoke(n2, n3, n4, n5, l2, l3);
        }
    }
}

