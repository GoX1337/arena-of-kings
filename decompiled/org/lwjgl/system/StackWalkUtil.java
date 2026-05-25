/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.util.Arrays;
import java.util.Objects;
import javax.annotation.Nullable;

final class StackWalkUtil {
    private StackWalkUtil() {
    }

    static StackTraceElement[] stackWalkArray(Object[] objectArray) {
        return (StackTraceElement[])objectArray;
    }

    static Object stackWalkGetMethod(Class<?> clazz) {
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i2 = 3; i2 < stackTraceElementArray.length; ++i2) {
            if (stackTraceElementArray[i2].getClassName().startsWith(clazz.getName())) continue;
            return stackTraceElementArray[i2];
        }
        throw new IllegalStateException();
    }

    private static boolean isSameMethod(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return StackWalkUtil.isSameMethod(stackTraceElement, stackTraceElement2, stackTraceElement2.getMethodName());
    }

    private static boolean isSameMethod(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2, String string) {
        return stackTraceElement.getMethodName().equals(string) && stackTraceElement.getClassName().equals(stackTraceElement2.getClassName()) && Objects.equals(stackTraceElement.getFileName(), stackTraceElement2.getFileName());
    }

    private static boolean isAutoCloseable(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        if (StackWalkUtil.isSameMethod(stackTraceElement, stackTraceElement2, "$closeResource")) {
            return true;
        }
        return "closeFinally".equals(stackTraceElement.getMethodName()) && "AutoCloseable.kt".equals(stackTraceElement.getFileName());
    }

    @Nullable
    static Object stackWalkCheckPop(Class<?> clazz, Object object) {
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i2 = 3; i2 < stackTraceElementArray.length; ++i2) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i2];
            if (stackTraceElement.getClassName().startsWith(clazz.getName())) continue;
            StackTraceElement stackTraceElement2 = (StackTraceElement)object;
            if (StackWalkUtil.isSameMethod(stackTraceElement, stackTraceElement2)) {
                return null;
            }
            if (StackWalkUtil.isAutoCloseable(stackTraceElement, stackTraceElement2) && i2 + 1 < stackTraceElementArray.length) {
                stackTraceElement = stackTraceElementArray[i2 + 1];
                if (StackWalkUtil.isSameMethod(stackTraceElement2, stackTraceElementArray[i2 + 1])) {
                    return null;
                }
            }
            return stackTraceElement;
        }
        throw new IllegalStateException();
    }

    static Object[] stackWalkGetTrace() {
        int n2;
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (n2 = 3; n2 < stackTraceElementArray.length && stackTraceElementArray[n2].getClassName().startsWith("org.lwjgl.system.Memory"); ++n2) {
        }
        return Arrays.copyOfRange(stackTraceElementArray, n2, stackTraceElementArray.length);
    }
}

