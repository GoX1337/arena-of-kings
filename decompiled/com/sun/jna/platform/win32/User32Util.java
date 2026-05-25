/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.Win32VK;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.W32APITypeMapper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class User32Util {
    public static final EnumSet<Win32VK> WIN32VK_MAPPABLE = EnumSet.of(Win32VK.VK_BACK, new Win32VK[]{Win32VK.VK_TAB, Win32VK.VK_CLEAR, Win32VK.VK_RETURN, Win32VK.VK_ESCAPE, Win32VK.VK_SPACE, Win32VK.VK_SELECT, Win32VK.VK_EXECUTE, Win32VK.VK_0, Win32VK.VK_1, Win32VK.VK_2, Win32VK.VK_3, Win32VK.VK_4, Win32VK.VK_5, Win32VK.VK_6, Win32VK.VK_7, Win32VK.VK_8, Win32VK.VK_9, Win32VK.VK_A, Win32VK.VK_B, Win32VK.VK_C, Win32VK.VK_D, Win32VK.VK_E, Win32VK.VK_F, Win32VK.VK_G, Win32VK.VK_H, Win32VK.VK_I, Win32VK.VK_J, Win32VK.VK_K, Win32VK.VK_L, Win32VK.VK_M, Win32VK.VK_N, Win32VK.VK_O, Win32VK.VK_P, Win32VK.VK_Q, Win32VK.VK_R, Win32VK.VK_S, Win32VK.VK_T, Win32VK.VK_U, Win32VK.VK_V, Win32VK.VK_W, Win32VK.VK_X, Win32VK.VK_Y, Win32VK.VK_Z, Win32VK.VK_NUMPAD0, Win32VK.VK_NUMPAD1, Win32VK.VK_NUMPAD2, Win32VK.VK_NUMPAD3, Win32VK.VK_NUMPAD4, Win32VK.VK_NUMPAD5, Win32VK.VK_NUMPAD6, Win32VK.VK_NUMPAD7, Win32VK.VK_NUMPAD8, Win32VK.VK_NUMPAD9, Win32VK.VK_MULTIPLY, Win32VK.VK_ADD, Win32VK.VK_SEPARATOR, Win32VK.VK_SUBTRACT, Win32VK.VK_DECIMAL, Win32VK.VK_DIVIDE, Win32VK.VK_OEM_NEC_EQUAL, Win32VK.VK_OEM_FJ_MASSHOU, Win32VK.VK_OEM_FJ_TOUROKU, Win32VK.VK_OEM_FJ_LOYA, Win32VK.VK_OEM_FJ_ROYA, Win32VK.VK_OEM_1, Win32VK.VK_OEM_PLUS, Win32VK.VK_OEM_COMMA, Win32VK.VK_OEM_MINUS, Win32VK.VK_OEM_PERIOD, Win32VK.VK_OEM_2, Win32VK.VK_OEM_3, Win32VK.VK_RESERVED_C1, Win32VK.VK_RESERVED_C2, Win32VK.VK_OEM_4, Win32VK.VK_OEM_5, Win32VK.VK_OEM_6, Win32VK.VK_OEM_7, Win32VK.VK_OEM_8, Win32VK.VK_OEM_AX, Win32VK.VK_OEM_102, Win32VK.VK_ICO_HELP, Win32VK.VK_PROCESSKEY, Win32VK.VK_ICO_CLEAR, Win32VK.VK_PACKET, Win32VK.VK_OEM_RESET, Win32VK.VK_OEM_JUMP, Win32VK.VK_OEM_PA1, Win32VK.VK_OEM_PA2, Win32VK.VK_OEM_PA3, Win32VK.VK_OEM_WSCTRL, Win32VK.VK_OEM_CUSEL, Win32VK.VK_OEM_ATTN, Win32VK.VK_OEM_FINISH, Win32VK.VK_OEM_COPY, Win32VK.VK_OEM_AUTO, Win32VK.VK_OEM_ENLW, Win32VK.VK_OEM_BACKTAB, Win32VK.VK_ATTN, Win32VK.VK_CRSEL, Win32VK.VK_EXSEL, Win32VK.VK_EREOF, Win32VK.VK_PLAY, Win32VK.VK_ZOOM, Win32VK.VK_NONAME, Win32VK.VK_PA1, Win32VK.VK_OEM_CLEAR});

    public static final int registerWindowMessage(String string) {
        int n2 = User32.INSTANCE.RegisterWindowMessage(string);
        if (n2 == 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return n2;
    }

    public static final WinDef.HWND createWindow(String string, String string2, int n2, int n3, int n4, int n5, int n6, WinDef.HWND hWND, WinDef.HMENU hMENU, WinDef.HINSTANCE hINSTANCE, WinDef.LPVOID lPVOID) {
        return User32Util.createWindowEx(0, string, string2, n2, n3, n4, n5, n6, hWND, hMENU, hINSTANCE, lPVOID);
    }

    public static final WinDef.HWND createWindowEx(int n2, String string, String string2, int n3, int n4, int n5, int n6, int n7, WinDef.HWND hWND, WinDef.HMENU hMENU, WinDef.HINSTANCE hINSTANCE, WinDef.LPVOID lPVOID) {
        WinDef.HWND hWND2 = User32.INSTANCE.CreateWindowEx(n2, string, string2, n3, n4, n5, n6, n7, hWND, hMENU, hINSTANCE, lPVOID);
        if (hWND2 == null) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return hWND2;
    }

    public static final void destroyWindow(WinDef.HWND hWND) {
        if (!User32.INSTANCE.DestroyWindow(hWND)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    public static final List<WinUser.RAWINPUTDEVICELIST> GetRawInputDeviceList() {
        IntByReference intByReference = new IntByReference(0);
        WinUser.RAWINPUTDEVICELIST rAWINPUTDEVICELIST = new WinUser.RAWINPUTDEVICELIST();
        int n2 = rAWINPUTDEVICELIST.sizeof();
        int n3 = User32.INSTANCE.GetRawInputDeviceList(null, intByReference, n2);
        if (n3 != 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        int n4 = intByReference.getValue();
        WinUser.RAWINPUTDEVICELIST[] rAWINPUTDEVICELISTArray = (WinUser.RAWINPUTDEVICELIST[])rAWINPUTDEVICELIST.com_sun_jna_Structure_arr_toArray(n4);
        n3 = User32.INSTANCE.GetRawInputDeviceList(rAWINPUTDEVICELISTArray, intByReference, n2);
        if (n3 == -1) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        if (n3 != rAWINPUTDEVICELISTArray.length) {
            throw new IllegalStateException("Mismatched allocated (" + rAWINPUTDEVICELISTArray.length + ") vs. received devices count (" + n3 + ")");
        }
        return Arrays.asList(rAWINPUTDEVICELISTArray);
    }

    public static String loadString(String string) {
        int n2 = string.lastIndexOf(44);
        String string2 = string.substring(0, n2);
        int n3 = Math.abs(Integer.parseInt(string.substring(n2 + 1)));
        String string3 = Kernel32Util.expandEnvironmentStrings(string2);
        WinDef.HMODULE hMODULE = Kernel32.INSTANCE.LoadLibraryEx(string3, null, 2);
        if (hMODULE == null) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        Memory memory = new Memory(Native.POINTER_SIZE);
        n2 = User32.INSTANCE.LoadString(hMODULE, n3, memory, 0);
        if (0 == n2) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
            return new String(((Pointer)memory).getPointer(0L).getCharArray(0L, n2));
        }
        return new String(((Pointer)memory).getPointer(0L).getByteArray(0L, n2), Native.getDefaultStringEncoding());
    }

    public static class MessageLoopThread
    extends Thread {
        private volatile int nativeThreadId = 0;
        private volatile long javaThreadId = 0L;
        private final List<FutureTask> workQueue = Collections.synchronizedList(new ArrayList());
        private static long messageLoopId = 0L;

        public MessageLoopThread() {
            this.setName("JNA User32 MessageLoop " + ++messageLoopId);
        }

        @Override
        public void run() {
            int n2;
            WinUser.MSG mSG = new WinUser.MSG();
            User32.INSTANCE.PeekMessage(mSG, null, 0, 0, 0);
            this.javaThreadId = Thread.currentThread().getId();
            this.nativeThreadId = Kernel32.INSTANCE.GetCurrentThreadId();
            while ((n2 = User32.INSTANCE.GetMessage(mSG, null, 0, 0)) != 0) {
                if (n2 != -1) {
                    while (!this.workQueue.isEmpty()) {
                        try {
                            FutureTask futureTask = this.workQueue.remove(0);
                            futureTask.run();
                        }
                        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            // empty catch block
                            break;
                        }
                    }
                    User32.INSTANCE.TranslateMessage(mSG);
                    User32.INSTANCE.DispatchMessage(mSG);
                    continue;
                }
                if (!this.getMessageFailed()) continue;
            }
            while (!this.workQueue.isEmpty()) {
                this.workQueue.remove(0).cancel(false);
            }
        }

        public <V> Future<V> runAsync(Callable<V> callable) {
            while (this.nativeThreadId == 0) {
                try {
                    Thread.sleep(20L);
                }
                catch (InterruptedException interruptedException) {
                    Logger.getLogger(MessageLoopThread.class.getName()).log(Level.SEVERE, null, interruptedException);
                }
            }
            FutureTask<V> futureTask = new FutureTask<V>(callable);
            this.workQueue.add(futureTask);
            User32.INSTANCE.PostThreadMessage(this.nativeThreadId, 1024, null, null);
            return futureTask;
        }

        public <V> V runOnThread(Callable<V> callable) {
            while (this.javaThreadId == 0L) {
                try {
                    Thread.sleep(20L);
                }
                catch (InterruptedException interruptedException) {
                    Logger.getLogger(MessageLoopThread.class.getName()).log(Level.SEVERE, null, interruptedException);
                }
            }
            if (this.javaThreadId == Thread.currentThread().getId()) {
                return callable.call();
            }
            Future<V> future = this.runAsync(callable);
            try {
                return future.get();
            }
            catch (InterruptedException interruptedException) {
                throw interruptedException;
            }
            catch (ExecutionException executionException) {
                Throwable throwable = executionException.getCause();
                if (throwable instanceof Exception) {
                    throw (Exception)throwable;
                }
                throw executionException;
            }
        }

        public void exit() {
            User32.INSTANCE.PostThreadMessage(this.nativeThreadId, 18, null, null);
        }

        protected boolean getMessageFailed() {
            int n2 = Kernel32.INSTANCE.GetLastError();
            Logger.getLogger("com.sun.jna.platform.win32.User32Util.MessageLoopThread").log(Level.WARNING, "Message loop was interrupted by an error. [lastError: {0}]", n2);
            return true;
        }

        public class Handler
        implements InvocationHandler {
            private final Object delegate;

            public Handler(Object object) {
                this.delegate = object;
            }

            @Override
            public Object invoke(Object object, final Method method, final Object[] objectArray) {
                try {
                    return MessageLoopThread.this.runOnThread(new Callable<Object>(){

                        @Override
                        public Object call() {
                            return method.invoke(Handler.this.delegate, objectArray);
                        }
                    });
                }
                catch (InvocationTargetException invocationTargetException) {
                    Throwable throwable = invocationTargetException.getCause();
                    if (throwable instanceof Exception) {
                        StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
                        throwable.fillInStackTrace();
                        StackTraceElement[] stackTraceElementArray2 = throwable.getStackTrace();
                        StackTraceElement[] stackTraceElementArray3 = new StackTraceElement[stackTraceElementArray2.length + stackTraceElementArray.length];
                        System.arraycopy(stackTraceElementArray, 0, stackTraceElementArray3, 0, stackTraceElementArray.length);
                        System.arraycopy(stackTraceElementArray2, 0, stackTraceElementArray3, stackTraceElementArray.length, stackTraceElementArray2.length);
                        throwable.setStackTrace(stackTraceElementArray3);
                        throw (Exception)throwable;
                    }
                    throw invocationTargetException;
                }
            }
        }
    }
}

