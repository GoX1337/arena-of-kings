/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.profiling;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.profiling.GLInterceptor;
import com.badlogic.gdx.utils.GdxRuntimeException;

public interface GLErrorListener {
    public static final GLErrorListener LOGGING_LISTENER = new GLErrorListener(){

        @Override
        public void onError(int n2) {
            String string = null;
            try {
                StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
                for (int i2 = 0; i2 < stackTraceElementArray.length; ++i2) {
                    if (!"check".equals(stackTraceElementArray[i2].getMethodName())) continue;
                    if (i2 + 1 < stackTraceElementArray.length) {
                        StackTraceElement stackTraceElement = stackTraceElementArray[i2 + 1];
                        string = stackTraceElement.getMethodName();
                    }
                    break;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (string != null) {
                Gdx.app.error("GLProfiler", "Error " + GLInterceptor.resolveErrorNumber(n2) + " from " + string);
            } else {
                Gdx.app.error("GLProfiler", "Error " + GLInterceptor.resolveErrorNumber(n2) + " at: ", new Exception());
            }
        }
    };
    public static final GLErrorListener THROWING_LISTENER = new GLErrorListener(){

        @Override
        public void onError(int n2) {
            throw new GdxRuntimeException("GLProfiler: Got GL error " + GLInterceptor.resolveErrorNumber(n2));
        }
    };

    public void onError(int var1);
}

