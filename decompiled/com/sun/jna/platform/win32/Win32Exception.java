/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.LastErrorException;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.W32Errors;
import com.sun.jna.platform.win32.WinNT;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Win32Exception
extends LastErrorException {
    private static final long serialVersionUID = 1L;
    private WinNT.HRESULT _hr;
    private static Method addSuppressedMethod = null;

    public WinNT.HRESULT getHR() {
        return this._hr;
    }

    public Win32Exception(int n2) {
        this(n2, W32Errors.HRESULT_FROM_WIN32(n2));
    }

    public Win32Exception(WinNT.HRESULT hRESULT) {
        this(W32Errors.HRESULT_CODE(hRESULT.intValue()), hRESULT);
    }

    protected Win32Exception(int n2, WinNT.HRESULT hRESULT) {
        this(n2, hRESULT, Kernel32Util.formatMessage(hRESULT));
    }

    protected Win32Exception(int n2, WinNT.HRESULT hRESULT, String string) {
        super(n2, string);
        this._hr = hRESULT;
    }

    void addSuppressedReflected(Throwable throwable) {
        if (addSuppressedMethod == null) {
            return;
        }
        try {
            addSuppressedMethod.invoke((Object)this, throwable);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("Failed to call addSuppressedMethod", illegalAccessException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new RuntimeException("Failed to call addSuppressedMethod", illegalArgumentException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException("Failed to call addSuppressedMethod", invocationTargetException);
        }
    }

    static {
        try {
            addSuppressedMethod = Throwable.class.getMethod("addSuppressed", Throwable.class);
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (SecurityException securityException) {
            Logger.getLogger(Win32Exception.class.getName()).log(Level.SEVERE, "Failed to initialize 'addSuppressed' method", securityException);
        }
    }
}

