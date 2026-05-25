/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import java.io.PrintStream;
import java.util.Map;
import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallbackI;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;

public abstract class GLFWErrorCallback
extends Callback
implements GLFWErrorCallbackI {
    public static GLFWErrorCallback create(long l2) {
        GLFWErrorCallbackI gLFWErrorCallbackI = (GLFWErrorCallbackI)Callback.get(l2);
        return gLFWErrorCallbackI instanceof GLFWErrorCallback ? (GLFWErrorCallback)gLFWErrorCallbackI : new Container(l2, gLFWErrorCallbackI);
    }

    @Nullable
    public static GLFWErrorCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWErrorCallback.create(l2);
    }

    public static GLFWErrorCallback create(GLFWErrorCallbackI gLFWErrorCallbackI) {
        return gLFWErrorCallbackI instanceof GLFWErrorCallback ? (GLFWErrorCallback)gLFWErrorCallbackI : new Container(gLFWErrorCallbackI.address(), gLFWErrorCallbackI);
    }

    protected GLFWErrorCallback() {
        super(CIF);
    }

    GLFWErrorCallback(long l2) {
        super(l2);
    }

    public static String getDescription(long l2) {
        return MemoryUtil.memUTF8(l2);
    }

    public static GLFWErrorCallback createPrint() {
        return GLFWErrorCallback.createPrint(APIUtil.DEBUG_STREAM);
    }

    public static GLFWErrorCallback createPrint(final PrintStream printStream) {
        return new GLFWErrorCallback(){
            private Map<Integer, String> ERROR_CODES = APIUtil.apiClassTokens((field, n2) -> 65536 < n2 && n2 < 131072, null, GLFW.class);

            @Override
            public void invoke(int n2, long l2) {
                String string = _1.getDescription(l2);
                printStream.printf("[LWJGL] %s error\n", this.ERROR_CODES.get(n2));
                printStream.println("\tDescription : " + string);
                printStream.println("\tStacktrace  :");
                StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
                for (int i2 = 4; i2 < stackTraceElementArray.length; ++i2) {
                    printStream.print("\t\t");
                    printStream.println(stackTraceElementArray[i2].toString());
                }
            }
        };
    }

    public static GLFWErrorCallback createThrow() {
        return new GLFWErrorCallback(){

            @Override
            public void invoke(int n2, long l2) {
                throw new IllegalStateException(String.format("GLFW error [0x%X]: %s", n2, _2.getDescription(l2)));
            }
        };
    }

    public GLFWErrorCallback set() {
        GLFW.glfwSetErrorCallback(this);
        return this;
    }

    static final class Container
    extends GLFWErrorCallback {
        private final GLFWErrorCallbackI delegate;

        Container(long l2, GLFWErrorCallbackI gLFWErrorCallbackI) {
            super(l2);
            this.delegate = gLFWErrorCallbackI;
        }

        @Override
        public void invoke(int n2, long l2) {
            this.delegate.invoke(n2, l2);
        }
    }
}

