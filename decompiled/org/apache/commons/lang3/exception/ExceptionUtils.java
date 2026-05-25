/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

public class ExceptionUtils {
    private static final int NOT_FOUND = -1;
    private static final String[] CAUSE_METHOD_NAMES = new String[]{"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};
    static final String WRAPPED_MARKER = " [wrapped] ";

    @Deprecated
    public static Throwable getCause(Throwable throwable) {
        return ExceptionUtils.getCause(throwable, null);
    }

    @Deprecated
    public static Throwable getCause(Throwable throwable, String[] stringArray) {
        if (throwable == null) {
            return null;
        }
        if (stringArray == null) {
            Throwable object = throwable.getCause();
            if (object != null) {
                return object;
            }
            stringArray = CAUSE_METHOD_NAMES;
        }
        for (String string : stringArray) {
            Throwable throwable2;
            if (string == null || (throwable2 = ExceptionUtils.getCauseUsingMethodName(throwable, string)) == null) continue;
            return throwable2;
        }
        return null;
    }

    private static Throwable getCauseUsingMethodName(Throwable throwable, String string) {
        Method method = null;
        try {
            method = throwable.getClass().getMethod(string, new Class[0]);
        }
        catch (NoSuchMethodException | SecurityException exception) {
            // empty catch block
        }
        if (method != null && Throwable.class.isAssignableFrom(method.getReturnType())) {
            try {
                return (Throwable)method.invoke((Object)throwable, new Object[0]);
            }
            catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
                // empty catch block
            }
        }
        return null;
    }

    @Deprecated
    public static String[] getDefaultCauseMethodNames() {
        return ArrayUtils.clone(CAUSE_METHOD_NAMES);
    }

    public static String getMessage(Throwable throwable) {
        if (throwable == null) {
            return "";
        }
        String string = ClassUtils.getShortClassName(throwable, null);
        String string2 = throwable.getMessage();
        return string + ": " + StringUtils.defaultString(string2);
    }

    public static Throwable getRootCause(Throwable throwable) {
        List<Throwable> list = ExceptionUtils.getThrowableList(throwable);
        return list.isEmpty() ? null : list.get(list.size() - 1);
    }

    public static String getRootCauseMessage(Throwable throwable) {
        Throwable throwable2 = ExceptionUtils.getRootCause(throwable);
        throwable2 = throwable2 == null ? throwable : throwable2;
        return ExceptionUtils.getMessage(throwable2);
    }

    public static String[] getRootCauseStackTrace(Throwable throwable) {
        if (throwable == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        Throwable[] throwableArray = ExceptionUtils.getThrowables(throwable);
        int n2 = throwableArray.length;
        ArrayList<String> arrayList = new ArrayList<String>();
        List<String> list = ExceptionUtils.getStackFrameList(throwableArray[n2 - 1]);
        int n3 = n2;
        while (--n3 >= 0) {
            List<String> list2 = list;
            if (n3 != 0) {
                list = ExceptionUtils.getStackFrameList(throwableArray[n3 - 1]);
                ExceptionUtils.removeCommonFrames(list2, list);
            }
            if (n3 == n2 - 1) {
                arrayList.add(throwableArray[n3].toString());
            } else {
                arrayList.add(WRAPPED_MARKER + throwableArray[n3].toString());
            }
            arrayList.addAll(list2);
        }
        return arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    static List<String> getStackFrameList(Throwable throwable) {
        String string = ExceptionUtils.getStackTrace(throwable);
        String string2 = System.lineSeparator();
        StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
        ArrayList<String> arrayList = new ArrayList<String>();
        boolean bl2 = false;
        while (stringTokenizer.hasMoreTokens()) {
            String string3 = stringTokenizer.nextToken();
            int n2 = string3.indexOf("at");
            if (n2 != -1 && string3.substring(0, n2).trim().isEmpty()) {
                bl2 = true;
                arrayList.add(string3);
                continue;
            }
            if (!bl2) continue;
            break;
        }
        return arrayList;
    }

    static String[] getStackFrames(String string) {
        String string2 = System.lineSeparator();
        StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
        ArrayList<String> arrayList = new ArrayList<String>();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static String[] getStackFrames(Throwable throwable) {
        if (throwable == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return ExceptionUtils.getStackFrames(ExceptionUtils.getStackTrace(throwable));
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer)stringWriter, true);
        throwable.printStackTrace(printWriter);
        return stringWriter.getBuffer().toString();
    }

    public static int getThrowableCount(Throwable throwable) {
        return ExceptionUtils.getThrowableList(throwable).size();
    }

    public static List<Throwable> getThrowableList(Throwable throwable) {
        ArrayList<Throwable> arrayList = new ArrayList<Throwable>();
        while (throwable != null && !arrayList.contains(throwable)) {
            arrayList.add(throwable);
            throwable = throwable.getCause();
        }
        return arrayList;
    }

    public static Throwable[] getThrowables(Throwable throwable) {
        List<Throwable> list = ExceptionUtils.getThrowableList(throwable);
        return list.toArray(ArrayUtils.EMPTY_THROWABLE_ARRAY);
    }

    public static boolean hasCause(Throwable throwable, Class<? extends Throwable> clazz) {
        if (throwable instanceof UndeclaredThrowableException) {
            throwable = throwable.getCause();
        }
        return clazz.isInstance(throwable);
    }

    private static int indexOf(Throwable throwable, Class<? extends Throwable> clazz, int n2, boolean bl2) {
        Throwable[] throwableArray;
        if (throwable == null || clazz == null) {
            return -1;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= (throwableArray = ExceptionUtils.getThrowables(throwable)).length) {
            return -1;
        }
        if (bl2) {
            for (int i2 = n2; i2 < throwableArray.length; ++i2) {
                if (!clazz.isAssignableFrom(throwableArray[i2].getClass())) continue;
                return i2;
            }
        } else {
            for (int i3 = n2; i3 < throwableArray.length; ++i3) {
                if (!clazz.equals(throwableArray[i3].getClass())) continue;
                return i3;
            }
        }
        return -1;
    }

    public static int indexOfThrowable(Throwable throwable, Class<? extends Throwable> clazz) {
        return ExceptionUtils.indexOf(throwable, clazz, 0, false);
    }

    public static int indexOfThrowable(Throwable throwable, Class<? extends Throwable> clazz, int n2) {
        return ExceptionUtils.indexOf(throwable, clazz, n2, false);
    }

    public static int indexOfType(Throwable throwable, Class<? extends Throwable> clazz) {
        return ExceptionUtils.indexOf(throwable, clazz, 0, true);
    }

    public static int indexOfType(Throwable throwable, Class<? extends Throwable> clazz, int n2) {
        return ExceptionUtils.indexOf(throwable, clazz, n2, true);
    }

    public static void printRootCauseStackTrace(Throwable throwable) {
        ExceptionUtils.printRootCauseStackTrace(throwable, System.err);
    }

    public static void printRootCauseStackTrace(Throwable throwable, PrintStream printStream) {
        String[] stringArray;
        if (throwable == null) {
            return;
        }
        Objects.requireNonNull(printStream, "printStream");
        for (String string : stringArray = ExceptionUtils.getRootCauseStackTrace(throwable)) {
            printStream.println(string);
        }
        printStream.flush();
    }

    public static void printRootCauseStackTrace(Throwable throwable, PrintWriter printWriter) {
        String[] stringArray;
        if (throwable == null) {
            return;
        }
        Objects.requireNonNull(printWriter, "printWriter");
        for (String string : stringArray = ExceptionUtils.getRootCauseStackTrace(throwable)) {
            printWriter.println(string);
        }
        printWriter.flush();
    }

    public static void removeCommonFrames(List<String> list, List<String> list2) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("The List must not be null");
        }
        int n2 = list.size() - 1;
        for (int i2 = list2.size() - 1; n2 >= 0 && i2 >= 0; --n2, --i2) {
            String string;
            String string2 = list.get(n2);
            if (!string2.equals(string = list2.get(i2))) continue;
            list.remove(n2);
        }
    }

    public static <R> R rethrow(Throwable throwable) {
        return ExceptionUtils.typeErasure(throwable);
    }

    private static <T extends Throwable> T throwableOf(Throwable throwable, Class<T> clazz, int n2, boolean bl2) {
        Throwable[] throwableArray;
        if (throwable == null || clazz == null) {
            return null;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= (throwableArray = ExceptionUtils.getThrowables(throwable)).length) {
            return null;
        }
        if (bl2) {
            for (int i2 = n2; i2 < throwableArray.length; ++i2) {
                if (!clazz.isAssignableFrom(throwableArray[i2].getClass())) continue;
                return (T)((Throwable)clazz.cast(throwableArray[i2]));
            }
        } else {
            for (int i3 = n2; i3 < throwableArray.length; ++i3) {
                if (!clazz.equals(throwableArray[i3].getClass())) continue;
                return (T)((Throwable)clazz.cast(throwableArray[i3]));
            }
        }
        return null;
    }

    public static <T extends Throwable> T throwableOfThrowable(Throwable throwable, Class<T> clazz) {
        return ExceptionUtils.throwableOf(throwable, clazz, 0, false);
    }

    public static <T extends Throwable> T throwableOfThrowable(Throwable throwable, Class<T> clazz, int n2) {
        return ExceptionUtils.throwableOf(throwable, clazz, n2, false);
    }

    public static <T extends Throwable> T throwableOfType(Throwable throwable, Class<T> clazz) {
        return ExceptionUtils.throwableOf(throwable, clazz, 0, true);
    }

    public static <T extends Throwable> T throwableOfType(Throwable throwable, Class<T> clazz, int n2) {
        return ExceptionUtils.throwableOf(throwable, clazz, n2, true);
    }

    private static <R, T extends Throwable> R typeErasure(Throwable throwable) {
        throw throwable;
    }

    public static <R> R wrapAndThrow(Throwable throwable) {
        if (throwable instanceof RuntimeException) {
            throw (RuntimeException)throwable;
        }
        if (throwable instanceof Error) {
            throw (Error)throwable;
        }
        throw new UndeclaredThrowableException(throwable);
    }
}

